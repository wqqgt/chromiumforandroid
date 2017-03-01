// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

#include "media/base/mime_util.h"

#include "media/base/mime_util_internal.h"

namespace media {

// This variable is Leaky because it is accessed from WorkerPool threads.
static internal::MimeUtil* GetMimeUtil() {
  static internal::MimeUtil* mime_util = new internal::MimeUtil();
  return mime_util;
}

bool IsSupportedMediaMimeType(const std::string& mime_type) {
  return GetMimeUtil()->IsSupportedMediaMimeType(mime_type);
}

SupportsType IsSupportedMediaFormat(const std::string& mime_type,
                                    const std::vector<std::string>& codecs) {
  return GetMimeUtil()->IsSupportedMediaFormat(mime_type, codecs, false);
}

SupportsType IsSupportedEncryptedMediaFormat(
    const std::string& mime_type,
    const std::vector<std::string>& codecs) {
  return GetMimeUtil()->IsSupportedMediaFormat(mime_type, codecs, true);
}

void ParseCodecString(const std::string& codecs,
                      std::vector<std::string>* codecs_out,
                      bool strip) {
  GetMimeUtil()->ParseCodecString(codecs, codecs_out, strip);
}

void RemoveProprietaryMediaTypesAndCodecsForTests() {
  GetMimeUtil()->RemoveProprietaryMediaTypesAndCodecs();
}

}  // namespace media
