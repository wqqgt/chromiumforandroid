
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../third_party/WebKit/public/platform/WebDisplayMode.h

package org.chromium.blink_public.platform;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class WebDisplayMode {
  @IntDef({
      Undefined, Browser, MinimalUi, Standalone, Fullscreen, Last
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface WebDisplayModeEnum {}
  public static final int Undefined = 0;
  public static final int Browser = 1;
  public static final int MinimalUi = 2;
  public static final int Standalone = 3;
  public static final int Fullscreen = 4;
  public static final int Last = 4;
}
