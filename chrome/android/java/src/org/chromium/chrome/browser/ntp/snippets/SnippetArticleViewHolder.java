// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.ntp.snippets;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.os.StrictMode;
import android.os.SystemClock;
import android.support.v4.text.BidiFormatter;
import android.text.format.DateUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.chromium.base.ApiCompatibilityUtils;
import org.chromium.base.Callback;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.chrome.R;
import org.chromium.chrome.browser.favicon.FaviconHelper.FaviconImageCallback;
import org.chromium.chrome.browser.favicon.FaviconHelper.IconAvailabilityCallback;
import org.chromium.chrome.browser.ntp.ContextMenuManager;
import org.chromium.chrome.browser.ntp.ContextMenuManager.ContextMenuItemId;
import org.chromium.chrome.browser.ntp.cards.CardViewHolder;
import org.chromium.chrome.browser.ntp.cards.CardsVariationParameters;
import org.chromium.chrome.browser.ntp.cards.ImpressionTracker;
import org.chromium.chrome.browser.ntp.cards.NewTabPageRecyclerView;
import org.chromium.chrome.browser.ntp.cards.NewTabPageViewHolder;
import org.chromium.chrome.browser.ntp.cards.SuggestionsCategoryInfo;
import org.chromium.chrome.browser.suggestions.SuggestionsUiDelegate;
import org.chromium.chrome.browser.widget.displaystyle.DisplayStyleObserver;
import org.chromium.chrome.browser.widget.displaystyle.DisplayStyleObserverAdapter;
import org.chromium.chrome.browser.widget.displaystyle.HorizontalDisplayStyle;
import org.chromium.chrome.browser.widget.displaystyle.UiConfig;
import org.chromium.chrome.browser.widget.displaystyle.VerticalDisplayStyle;
import org.chromium.ui.mojom.WindowOpenDisposition;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

/**
 * A class that represents the view for a single card snippet.
 */
public class SnippetArticleViewHolder extends CardViewHolder implements ImpressionTracker.Listener {
    /**
     * A single instance of {@link RefreshOfflineBadgeVisibilityCallback} that can be reused as it
     * has no state.
     */
    public static final RefreshOfflineBadgeVisibilityCallback
            REFRESH_OFFLINE_BADGE_VISIBILITY_CALLBACK = new RefreshOfflineBadgeVisibilityCallback();

    private static final String PUBLISHER_FORMAT_STRING = "%s - %s";
    private static final int FADE_IN_ANIMATION_TIME_MS = 300;
    private static final int[] FAVICON_SERVICE_SUPPORTED_SIZES = {16, 24, 32, 48, 64};
    private static final String FAVICON_SERVICE_FORMAT =
            "https://s2.googleusercontent.com/s2/favicons?domain=%s&src=chrome_newtab_mobile&sz=%d&alt=404";

    private final SuggestionsUiDelegate mUiDelegate;
    private final TextView mHeadlineTextView;
    private final TextView mPublisherTextView;
    private final TextView mArticleSnippetTextView;
    private final ImageView mThumbnailView;
    private final ImageView mOfflineBadge;
    private final View mPublisherBar;

    private FetchImageCallback mImageCallback;
    private SnippetArticle mArticle;
    private SuggestionsCategoryInfo mCategoryInfo;
    private int mPublisherFaviconSizePx;

    private final boolean mUseFaviconService;
    private final UiConfig mUiConfig;

    /**
     * Constructs a {@link SnippetArticleViewHolder} item used to display snippets.
     *  @param parent The NewTabPageRecyclerView that is going to contain the newly created view.
     * @param contextMenuManager The manager responsible for the context menu.
     * @param uiDelegate The delegate object used to open an article, fetch thumbnails, etc.
     * @param uiConfig The NTP UI configuration object used to adjust the article UI.
     */
    public SnippetArticleViewHolder(NewTabPageRecyclerView parent,
            ContextMenuManager contextMenuManager, SuggestionsUiDelegate uiDelegate,
            UiConfig uiConfig) {
        super(R.layout.new_tab_page_snippets_card, parent, uiConfig, contextMenuManager);

        mUiDelegate = uiDelegate;
        mThumbnailView = (ImageView) itemView.findViewById(R.id.article_thumbnail);
        mHeadlineTextView = (TextView) itemView.findViewById(R.id.article_headline);
        mPublisherTextView = (TextView) itemView.findViewById(R.id.article_publisher);
        mArticleSnippetTextView = (TextView) itemView.findViewById(R.id.article_snippet);
        mPublisherBar = itemView.findViewById(R.id.publisher_bar);
        mOfflineBadge = (ImageView) itemView.findViewById(R.id.offline_icon);

        new ImpressionTracker(itemView, this);

        mUiConfig = uiConfig;
        new DisplayStyleObserverAdapter(itemView, uiConfig, new DisplayStyleObserver() {
            @Override
            public void onDisplayStyleChanged(UiConfig.DisplayStyle newDisplayStyle) {
                updateLayout();
            }
        });

        mUseFaviconService = CardsVariationParameters.isFaviconServiceEnabled();
    }

    @Override
    public void onImpression() {
        if (mArticle != null && mArticle.trackImpression()) {
            mUiDelegate.getMetricsReporter().onSuggestionShown(mArticle);
            mRecyclerView.onSnippetImpression();
        }
    }

    @Override
    public void onCardTapped() {
        int windowDisposition = WindowOpenDisposition.CURRENT_TAB;
        mUiDelegate.getMetricsReporter().onSuggestionOpened(mArticle, windowDisposition);
        mUiDelegate.getNavigationDelegate().openSnippet(windowDisposition, mArticle);
    }

    @Override
    public void openItem(int windowDisposition) {
        mUiDelegate.getMetricsReporter().onSuggestionOpened(mArticle, windowDisposition);
        mUiDelegate.getNavigationDelegate().openSnippet(windowDisposition, mArticle);
    }

    @Override
    public String getUrl() {
        return mArticle.mUrl;
    }

    @Override
    public boolean isItemSupported(@ContextMenuItemId int menuItemId) {
        Boolean isSupported = mCategoryInfo.isContextMenuItemSupported(menuItemId);
        if (isSupported != null) return isSupported;

        return super.isItemSupported(menuItemId);
    }

    @Override
    public void onContextMenuCreated() {
        mUiDelegate.getMetricsReporter().onSuggestionMenuOpened(mArticle);
    }

    /**
     * Updates the layout taking into account screen dimensions and the type of snippet displayed.
     */
    private void updateLayout() {
        final int horizontalStyle = mUiConfig.getCurrentDisplayStyle().horizontal;
        final int verticalStyle = mUiConfig.getCurrentDisplayStyle().vertical;
        final int layout = mCategoryInfo.getCardLayout();

        boolean showDescription = shouldShowDescription(horizontalStyle, verticalStyle, layout);
        boolean showThumbnail = shouldShowThumbnail(horizontalStyle, verticalStyle, layout);

        mArticleSnippetTextView.setVisibility(showDescription ? View.VISIBLE : View.GONE);
        mThumbnailView.setVisibility(showThumbnail ? View.VISIBLE : View.GONE);
        mHeadlineTextView.setMaxLines(getHeaderMaxLines(horizontalStyle, verticalStyle, layout));
        mHeadlineTextView.setMinLines(getHeaderMinLines(showDescription, showThumbnail));

        // If we aren't showing the article snippet, reduce the top margin for publisher text.
        ViewGroup.MarginLayoutParams params =
                (ViewGroup.MarginLayoutParams) mPublisherBar.getLayoutParams();

        params.topMargin = mPublisherBar.getResources().getDimensionPixelSize(showThumbnail
                        ? R.dimen.snippets_publisher_margin_top_with_article_snippet
                        : R.dimen.snippets_publisher_margin_top_without_article_snippet);
        mPublisherBar.setLayoutParams(params);
    }

    private boolean shouldShowDescription(int horizontalStyle, int verticalStyle, int layout) {
        // Minimal cards don't have a description.
        if (layout == ContentSuggestionsCardLayout.MINIMAL_CARD) return false;

        // When the screen is too small (narrow or flat) we don't show the description to have more
        // space for the header.
        if (horizontalStyle == HorizontalDisplayStyle.NARROW) return false;
        if (verticalStyle == VerticalDisplayStyle.FLAT) return false;

        return true;
    }

    private boolean shouldShowThumbnail(int horizontalStyle, int verticalStyle, int layout) {
        // Minimal cards don't have a thumbnail
        if (layout == ContentSuggestionsCardLayout.MINIMAL_CARD) return false;

        return true;
    }

    private int getHeaderMaxLines(int horizontalStyle, int verticalStyle, int layout) {
        // When the screen is too small (narrow or flat) we don't show the description so we have
        // more space for the header.
        if (verticalStyle == VerticalDisplayStyle.FLAT) return 3;
        if (horizontalStyle == HorizontalDisplayStyle.NARROW) return 4;
        return 2;
    }

    private int getHeaderMinLines(boolean showDescription, boolean showThumbnail) {
        // When we have a thumbnail, we try to ensure we have enough content to push the
        // attribution line below it. So when the description is hidden, we have to force the
        // header to reserve that space.
        return showThumbnail && !showDescription ? 3 : 1;
    }

    private static String getAttributionString(SnippetArticle article) {
        if (article.mPublishTimestampMilliseconds == 0) return article.mPublisher;

        // DateUtils.getRelativeTimeSpanString(...) calls through to TimeZone.getDefault(). If this
        // has never been called before it loads the current time zone from disk. In most likelihood
        // this will have been called previously and the current time zone will have been cached,
        // but in some cases (eg instrumentation tests) it will cause a strict mode violation.
        StrictMode.ThreadPolicy oldPolicy = StrictMode.allowThreadDiskReads();
        CharSequence relativeTimeSpan;
        try {
            long time = SystemClock.elapsedRealtime();
            relativeTimeSpan =
                    DateUtils.getRelativeTimeSpanString(article.mPublishTimestampMilliseconds,
                            System.currentTimeMillis(), DateUtils.MINUTE_IN_MILLIS);
            RecordHistogram.recordTimesHistogram("Android.StrictMode.SnippetUIBuildTime",
                    SystemClock.elapsedRealtime() - time, TimeUnit.MILLISECONDS);
        } finally {
            StrictMode.setThreadPolicy(oldPolicy);
        }
        // We format the publisher here so that having a publisher name in an RTL language
        // doesn't mess up the formatting on an LTR device and vice versa.
        return String.format(PUBLISHER_FORMAT_STRING,
                BidiFormatter.getInstance().unicodeWrap(article.mPublisher), relativeTimeSpan);
    }

    public void onBindViewHolder(SnippetArticle article, SuggestionsCategoryInfo categoryInfo) {
        super.onBindViewHolder();

        mArticle = article;
        mCategoryInfo = categoryInfo;
        updateLayout();

        mHeadlineTextView.setText(mArticle.mTitle);
        mPublisherTextView.setText(getAttributionString(mArticle));

        // The favicon of the publisher should match the TextView height.
        int widthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int heightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        mPublisherTextView.measure(widthSpec, heightSpec);
        mPublisherFaviconSizePx = mPublisherTextView.getMeasuredHeight();

        mArticleSnippetTextView.setText(mArticle.mPreviewText);

        // If there's still a pending thumbnail fetch, cancel it.
        cancelImageFetch();

        // If the article has a thumbnail already, reuse it. Otherwise start a fetch.
        // mThumbnailView's visibility is modified in updateLayout().
        if (mThumbnailView.getVisibility() == View.VISIBLE) {
            if (mArticle.getThumbnailBitmap() != null) {
                mThumbnailView.setImageBitmap(mArticle.getThumbnailBitmap());
            } else {
                mThumbnailView.setImageResource(R.drawable.ic_snippet_thumbnail_placeholder);
                mImageCallback = new FetchImageCallback(this, mArticle);
                mUiDelegate.getSuggestionsSource().fetchSuggestionImage(mArticle, mImageCallback);
            }
        }

        // Set the favicon of the publisher.
        try {
            fetchFaviconFromLocalCache(new URI(mArticle.mUrl), true);
        } catch (URISyntaxException e) {
            setDefaultFaviconOnView();
        }

        mOfflineBadge.setVisibility(View.GONE);
        refreshOfflineBadgeVisibility();

        mRecyclerView.onSnippetBound(itemView);
    }

    /** Updates the visibility of the card's offline badge by checking the bound article's info. */
    private void refreshOfflineBadgeVisibility() {
        if (!SnippetsConfig.isOfflineBadgeEnabled()) return;
        boolean visible = mArticle.getOfflinePageOfflineId() != null || mArticle.mIsAssetDownload;
        if (visible == (mOfflineBadge.getVisibility() == View.VISIBLE)) return;
        mOfflineBadge.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    private static class FetchImageCallback extends Callback<Bitmap> {
        private SnippetArticleViewHolder mViewHolder;
        private final SnippetArticle mSnippet;

        public FetchImageCallback(
                SnippetArticleViewHolder viewHolder, SnippetArticle snippet) {
            mViewHolder = viewHolder;
            mSnippet = snippet;
        }

        @Override
        public void onResult(Bitmap image) {
            if (mViewHolder == null) return;
            mViewHolder.fadeThumbnailIn(mSnippet, image);
        }

        public void cancel() {
            // TODO(treib): Pass the "cancel" on to the actual image fetcher.
            mViewHolder = null;
        }
    }

    private void cancelImageFetch() {
        if (mImageCallback != null) {
            mImageCallback.cancel();
            mImageCallback = null;
        }
    }

    private void fadeThumbnailIn(SnippetArticle snippet, Bitmap thumbnail) {
        mImageCallback = null;
        if (thumbnail == null) return; // Nothing to do, we keep the placeholder.

        // We need to crop and scale the downloaded bitmap, as the ImageView we set it on won't be
        // able to do so when using a TransitionDrawable (as opposed to the straight bitmap).
        // That's a limitation of TransitionDrawable, which doesn't handle layers of varying sizes.
        Resources res = mThumbnailView.getResources();
        int targetSize = res.getDimensionPixelSize(R.dimen.snippets_thumbnail_size);
        Bitmap scaledThumbnail = ThumbnailUtils.extractThumbnail(
                thumbnail, targetSize, targetSize, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);

        // Store the bitmap to skip the download task next time we display this snippet.
        snippet.setThumbnailBitmap(scaledThumbnail);

        // Cross-fade between the placeholder and the thumbnail. We cross-fade because the incoming
        // image may have transparency and we don't want the previous image showing up behind.
        Drawable[] layers = {mThumbnailView.getDrawable(),
                new BitmapDrawable(mThumbnailView.getResources(), scaledThumbnail)};
        TransitionDrawable transitionDrawable = new TransitionDrawable(layers);
        mThumbnailView.setImageDrawable(transitionDrawable);
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(FADE_IN_ANIMATION_TIME_MS);
    }

    private void fetchFaviconFromLocalCache(final URI snippetUri, final boolean fallbackToService) {
        mUiDelegate.getLocalFaviconImageForURL(
                getSnippetDomain(snippetUri), mPublisherFaviconSizePx, new FaviconImageCallback() {
                    @Override
                    public void onFaviconAvailable(Bitmap image, String iconUrl) {
                        if (image == null && fallbackToService) {
                            fetchFaviconFromService(snippetUri);
                            return;
                        }
                        setFaviconOnView(image);
                    }
                });
    }

    // TODO(crbug.com/635567): Fix this properly.
    @SuppressLint("DefaultLocale")
    private void fetchFaviconFromService(final URI snippetUri) {
        // Show the default favicon immediately.
        setDefaultFaviconOnView();

        if (!mUseFaviconService) return;
        int sizePx = getFaviconServiceSupportedSize();
        if (sizePx == 0) return;

        // Replace the default icon by another one from the service when it is fetched.
        mUiDelegate.ensureIconIsAvailable(
                getSnippetDomain(snippetUri), // Store to the cache for the whole domain.
                String.format(FAVICON_SERVICE_FORMAT, snippetUri.getHost(), sizePx),
                /*useLargeIcon=*/false, /*isTemporary=*/true, new IconAvailabilityCallback() {
                    @Override
                    public void onIconAvailabilityChecked(boolean newlyAvailable) {
                        if (!newlyAvailable) return;
                        // The download succeeded, the favicon is in the cache; fetch it.
                        fetchFaviconFromLocalCache(snippetUri, /*fallbackToService=*/false);
                    }
                });
    }

    private int getFaviconServiceSupportedSize() {
        // Take the smallest size larger than mFaviconSizePx.
        for (int size : FAVICON_SERVICE_SUPPORTED_SIZES) {
            if (size > mPublisherFaviconSizePx) return size;
        }
        // Or at least the largest available size (unless too small).
        int largestSize =
                FAVICON_SERVICE_SUPPORTED_SIZES[FAVICON_SERVICE_SUPPORTED_SIZES.length - 1];
        if (mPublisherFaviconSizePx <= largestSize * 1.5) return largestSize;
        return 0;
    }

    private String getSnippetDomain(URI snippetUri) {
        return String.format("%s://%s", snippetUri.getScheme(), snippetUri.getHost());
    }

    private void setDefaultFaviconOnView() {
        setFaviconOnView(ApiCompatibilityUtils.getDrawable(
                mPublisherTextView.getContext().getResources(), R.drawable.default_favicon));
    }

    private void setFaviconOnView(Bitmap image) {
        setFaviconOnView(new BitmapDrawable(mPublisherTextView.getContext().getResources(), image));
    }

    private void setFaviconOnView(Drawable drawable) {
        drawable.setBounds(0, 0, mPublisherFaviconSizePx, mPublisherFaviconSizePx);
        ApiCompatibilityUtils.setCompoundDrawablesRelative(
                mPublisherTextView, drawable, null, null, null);
        mPublisherTextView.setVisibility(View.VISIBLE);
    }

    /**
     * Callback to refresh the offline badge visibility.
     */
    public static class RefreshOfflineBadgeVisibilityCallback extends PartialBindCallback {
        @Override
        public void onResult(NewTabPageViewHolder holder) {
            assert holder instanceof SnippetArticleViewHolder;
            ((SnippetArticleViewHolder) holder).refreshOfflineBadgeVisibility();
        }
    }
}
