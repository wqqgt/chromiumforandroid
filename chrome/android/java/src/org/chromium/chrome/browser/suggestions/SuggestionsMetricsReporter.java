// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.suggestions;

import org.chromium.chrome.browser.ntp.cards.ActionItem;
import org.chromium.chrome.browser.ntp.snippets.CategoryInt;
import org.chromium.chrome.browser.ntp.snippets.SnippetArticle;

/**
 * Exposes UMA related methods.
 */
public interface SuggestionsMetricsReporter {
    /**
     * Tracks per-page-load metrics for content suggestions.
     * @param categories The categories of content suggestions.
     * @param suggestionsPerCategory The number of content suggestions in each category.
     */
    void onPageShown(int[] categories, int[] suggestionsPerCategory);

    /**
     * Tracks impression metrics for a content suggestion.
     * @param suggestion The content suggestion that was shown to the user.
     */
    void onSuggestionShown(SnippetArticle suggestion);

    /**
     * Tracks interaction metrics for a content suggestion.
     * @param suggestion The content suggestion that the user opened.
     * @param windowOpenDisposition How the suggestion was opened (current tab, new tab,
     *                              new window etc).
     */
    void onSuggestionOpened(SnippetArticle suggestion, int windowOpenDisposition);

    /**
     * Tracks impression metrics for the long-press menu for a content suggestion.
     * @param suggestion The content suggestion for which the long-press menu was opened.
     */
    void onSuggestionMenuOpened(SnippetArticle suggestion);

    /**
     * Tracks impression metrics for a category's action button ("More").
     * @param category The action button that was shown.
     */
    void onMoreButtonShown(@CategoryInt ActionItem category);

    /**
     * Tracks click metrics for a category's action button ("More").
     * @param category The action button that was clicked.
     */
    void onMoreButtonClicked(@CategoryInt ActionItem category);

    /** Sets the ranker to use to compute some of the reported metrics. */
    void setRanker(SuggestionsRanker suggestionsRanker);
}
