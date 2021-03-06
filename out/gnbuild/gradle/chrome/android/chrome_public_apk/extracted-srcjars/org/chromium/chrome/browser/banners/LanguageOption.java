
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../chrome/browser/banners/app_banner_settings_helper.h

package org.chromium.chrome.browser.banners;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LanguageOption {
  @IntDef({
      DEFAULT, MIN, ADD, INSTALL, MAX
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface LanguageOptionEnum {}
  public static final int DEFAULT = 0;
  public static final int MIN = DEFAULT;
  public static final int ADD = 1;
  public static final int INSTALL = 2;
  public static final int MAX = INSTALL;
}
