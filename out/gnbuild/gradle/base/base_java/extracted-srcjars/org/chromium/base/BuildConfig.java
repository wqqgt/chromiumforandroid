package org.chromium.base;
public class BuildConfig {
    public static boolean isMultidexEnabled() {
        return true;
    }
    public static final boolean DCHECK_IS_ON = false;
    public static final String[] COMPRESSED_LOCALES =
      {};
    public static final String[] UNCOMPRESSED_LOCALES =
      {"en-US", "zh-CN"};
}
