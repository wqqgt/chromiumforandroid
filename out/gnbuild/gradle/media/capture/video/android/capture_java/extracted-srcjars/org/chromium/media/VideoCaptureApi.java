
// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../media/capture/video/video_capture_device_descriptor.h

package org.chromium.media;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class VideoCaptureApi {
  @IntDef({
      LINUX_V4L2_SINGLE_PLANE, WIN_MEDIA_FOUNDATION, WIN_DIRECT_SHOW, MACOSX_AVFOUNDATION,
      MACOSX_DECKLINK, ANDROID_API1, ANDROID_API2_LEGACY, ANDROID_API2_FULL, ANDROID_API2_LIMITED,
      ANDROID_TANGO, UNKNOWN
  })
  @Retention(RetentionPolicy.SOURCE)
  public @interface VideoCaptureApiEnum {}
  public static final int LINUX_V4L2_SINGLE_PLANE = 0;
  public static final int WIN_MEDIA_FOUNDATION = 1;
  public static final int WIN_DIRECT_SHOW = 2;
  public static final int MACOSX_AVFOUNDATION = 3;
  public static final int MACOSX_DECKLINK = 4;
  public static final int ANDROID_API1 = 5;
  public static final int ANDROID_API2_LEGACY = 6;
  public static final int ANDROID_API2_FULL = 7;
  public static final int ANDROID_API2_LIMITED = 8;
  public static final int ANDROID_TANGO = 9;
  public static final int UNKNOWN = 10;
}
