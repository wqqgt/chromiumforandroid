
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/browsing_data/core/browsing_data_utils.h

package org.chromium.chrome.browser.browsing_data;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class BrowsingDataType {
  @IntDef({
      HISTORY, CACHE, COOKIES, PASSWORDS, FORM_DATA, BOOKMARKS, NUM_TYPES
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface BrowsingDataTypeEnum {}
  public static final int HISTORY = 0;
  public static final int CACHE = 1;
  public static final int COOKIES = 2;
  public static final int PASSWORDS = 3;
  public static final int FORM_DATA = 4;
  public static final int BOOKMARKS = 5;
  public static final int NUM_TYPES = 6;
}
