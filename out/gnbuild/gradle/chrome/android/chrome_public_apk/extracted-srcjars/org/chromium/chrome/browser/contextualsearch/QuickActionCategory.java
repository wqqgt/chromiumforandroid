
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/android/contextualsearch/resolved_search_term.h

package org.chromium.chrome.browser.contextualsearch;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class QuickActionCategory {
  @IntDef({
      NONE, ADDRESS, EMAIL, EVENT, PHONE, BOUNDARY
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface QuickActionCategoryEnum {}
  public static final int NONE = 0;
  public static final int ADDRESS = 1;
  public static final int EMAIL = 2;
  public static final int EVENT = 3;
  public static final int PHONE = 4;
  public static final int BOUNDARY = 5;
}
