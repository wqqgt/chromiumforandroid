/* AUTO-GENERATED FILE.  DO NOT MODIFY. */

package org.chromium.components.autofill;

public final class R {
    private static boolean sResourcesDidLoad;
    public static final class color {
        public static int http_bad_warning_message_text = 0x7f040000;
        public static int insecure_context_payment_disabled_message_text = 0x7f040001;
    }
    public static final class dimen {
        public static int dropdown_item_larger_sublabel_font_size = 0x7f050005;
        public static int dropdown_large_icon_margin = 0x7f050007;
        public static int dropdown_large_icon_size = 0x7f050006;
        public static int keyboard_accessory_chip_height = 0x7f050000;
        public static int keyboard_accessory_half_padding = 0x7f050001;
        public static int keyboard_accessory_height = 0x7f050002;
        public static int keyboard_accessory_padding = 0x7f050003;
        public static int keyboard_accessory_text_size = 0x7f050004;
    }
    public static final class drawable {
        public static int autofill_chip_inset = 0x7f020000;
    }
    public static final class id {
        public static int autofill_keyboard_accessory_item_label = 0x7f060000;
        public static int autofill_keyboard_accessory_item_sublabel = 0x7f060001;
    }
    public static final class layout {
        public static int autofill_keyboard_accessory_icon = 0x7f030000;
        public static int autofill_keyboard_accessory_item = 0x7f030001;
    }
    public static void onResourcesLoaded(int packageId) {
        assert !sResourcesDidLoad;
        sResourcesDidLoad = true;
        int packageIdTransform = (packageId ^ 0x7f) << 24;
        onResourcesLoadedColor(packageIdTransform);
        onResourcesLoadedDimen(packageIdTransform);
        onResourcesLoadedDrawable(packageIdTransform);
        onResourcesLoadedId(packageIdTransform);
        onResourcesLoadedLayout(packageIdTransform);
    }
    private static void onResourcesLoadedColor (
            int packageIdTransform) {
        color.http_bad_warning_message_text ^= packageIdTransform;
        color.insecure_context_payment_disabled_message_text ^= packageIdTransform;
    }
    private static void onResourcesLoadedDimen (
            int packageIdTransform) {
        dimen.dropdown_item_larger_sublabel_font_size ^= packageIdTransform;
        dimen.dropdown_large_icon_margin ^= packageIdTransform;
        dimen.dropdown_large_icon_size ^= packageIdTransform;
        dimen.keyboard_accessory_chip_height ^= packageIdTransform;
        dimen.keyboard_accessory_half_padding ^= packageIdTransform;
        dimen.keyboard_accessory_height ^= packageIdTransform;
        dimen.keyboard_accessory_padding ^= packageIdTransform;
        dimen.keyboard_accessory_text_size ^= packageIdTransform;
    }
    private static void onResourcesLoadedDrawable (
            int packageIdTransform) {
        drawable.autofill_chip_inset ^= packageIdTransform;
    }
    private static void onResourcesLoadedId (
            int packageIdTransform) {
        id.autofill_keyboard_accessory_item_label ^= packageIdTransform;
        id.autofill_keyboard_accessory_item_sublabel ^= packageIdTransform;
    }
    private static void onResourcesLoadedLayout (
            int packageIdTransform) {
        layout.autofill_keyboard_accessory_icon ^= packageIdTransform;
        layout.autofill_keyboard_accessory_item ^= packageIdTransform;
    }
}