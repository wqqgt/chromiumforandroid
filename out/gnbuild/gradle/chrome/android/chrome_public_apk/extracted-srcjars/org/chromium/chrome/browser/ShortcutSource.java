
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/android/shortcut_info.h

package org.chromium.chrome.browser;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ShortcutSource {
  @IntDef({
      UNKNOWN, ADD_TO_HOMESCREEN, APP_BANNER, BOOKMARK_NAVIGATOR_WIDGET, BOOKMARK_SHORTCUT_WIDGET,
      NOTIFICATION, COUNT
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface ShortcutSourceEnum {}
  public static final int UNKNOWN = 0;
  public static final int ADD_TO_HOMESCREEN = 1;
  public static final int APP_BANNER = 2;
  public static final int BOOKMARK_NAVIGATOR_WIDGET = 3;
  public static final int BOOKMARK_SHORTCUT_WIDGET = 4;
  public static final int NOTIFICATION = 5;
  public static final int COUNT = 6;
}
