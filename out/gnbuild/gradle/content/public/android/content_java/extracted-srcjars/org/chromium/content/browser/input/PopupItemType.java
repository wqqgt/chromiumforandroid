
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../content/browser/android/content_view_core_impl.cc

package org.chromium.content.browser.input;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PopupItemType {
  @IntDef({
      GROUP, DISABLED, ENABLED
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface PopupItemTypeEnum {}
  /**
   * Popup item is of type group
   */
  public static final int GROUP = 0;
  /**
   * Popup item is disabled
   */
  public static final int DISABLED = 1;
  /**
   * Popup item is enabled
   */
  public static final int ENABLED = 2;
}
