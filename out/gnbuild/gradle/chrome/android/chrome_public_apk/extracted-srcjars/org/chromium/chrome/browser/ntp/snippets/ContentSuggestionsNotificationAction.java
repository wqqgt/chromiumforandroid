
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/ntp_snippets/ntp_snippets_metrics.h

package org.chromium.chrome.browser.ntp.snippets;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ContentSuggestionsNotificationAction {
  @IntDef({
      CONTENT_SUGGESTIONS_TAP, CONTENT_SUGGESTIONS_DISMISSAL, CONTENT_SUGGESTIONS_HIDE_DEADLINE,
      CONTENT_SUGGESTIONS_HIDE_EXPIRY, CONTENT_SUGGESTIONS_HIDE_FRONTMOST,
      CONTENT_SUGGESTIONS_HIDE_DISABLED, CONTENT_SUGGESTIONS_HIDE_SHUTDOWN,
      MAX_CONTENT_SUGGESTIONS_NOTIFICATION_ACTION
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface ContentSuggestionsNotificationActionEnum {}
  public static final int CONTENT_SUGGESTIONS_TAP = 0;
  public static final int CONTENT_SUGGESTIONS_DISMISSAL = 1;
  public static final int CONTENT_SUGGESTIONS_HIDE_DEADLINE = 2;
  public static final int CONTENT_SUGGESTIONS_HIDE_EXPIRY = 3;
  public static final int CONTENT_SUGGESTIONS_HIDE_FRONTMOST = 4;
  public static final int CONTENT_SUGGESTIONS_HIDE_DISABLED = 5;
  public static final int CONTENT_SUGGESTIONS_HIDE_SHUTDOWN = 6;
  public static final int MAX_CONTENT_SUGGESTIONS_NOTIFICATION_ACTION = 7;
}
