
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/web/window_features.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class WindowFeatures extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 32;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(32, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public float x;
    public boolean hasX;
    public float y;
    public boolean hasY;
    public float width;
    public boolean hasWidth;
    public float height;
    public boolean hasHeight;
    public boolean menuBarVisible;
    public boolean statusBarVisible;
    public boolean toolBarVisible;
    public boolean locationBarVisible;
    public boolean scrollbarsVisible;
    public boolean resizable;
    public boolean fullscreen;
    public boolean dialog;

    private WindowFeatures(int version) {
        super(STRUCT_SIZE, version);
        hasX = false;
        hasY = false;
        hasWidth = false;
        hasHeight = false;
        menuBarVisible = true;
        statusBarVisible = true;
        toolBarVisible = true;
        locationBarVisible = true;
        scrollbarsVisible = true;
        resizable = true;
        fullscreen = false;
        dialog = false;
    }

    public WindowFeatures() {
        this(0);
    }

    public static WindowFeatures deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static WindowFeatures deserialize(java.nio.ByteBuffer data) {
        if (data == null)
            return null;

        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static WindowFeatures decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        WindowFeatures result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            result = new WindowFeatures(mainDataHeader.elementsOrVersion);
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.x = decoder0.readFloat(8);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.hasX = decoder0.readBoolean(12, 0);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.hasY = decoder0.readBoolean(12, 1);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.hasWidth = decoder0.readBoolean(12, 2);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.hasHeight = decoder0.readBoolean(12, 3);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.menuBarVisible = decoder0.readBoolean(12, 4);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.statusBarVisible = decoder0.readBoolean(12, 5);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.toolBarVisible = decoder0.readBoolean(12, 6);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.locationBarVisible = decoder0.readBoolean(12, 7);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.scrollbarsVisible = decoder0.readBoolean(13, 0);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.resizable = decoder0.readBoolean(13, 1);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.fullscreen = decoder0.readBoolean(13, 2);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.dialog = decoder0.readBoolean(13, 3);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.y = decoder0.readFloat(16);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.width = decoder0.readFloat(20);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.height = decoder0.readFloat(24);
            }
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(x, 8);
        
        encoder0.encode(hasX, 12, 0);
        
        encoder0.encode(hasY, 12, 1);
        
        encoder0.encode(hasWidth, 12, 2);
        
        encoder0.encode(hasHeight, 12, 3);
        
        encoder0.encode(menuBarVisible, 12, 4);
        
        encoder0.encode(statusBarVisible, 12, 5);
        
        encoder0.encode(toolBarVisible, 12, 6);
        
        encoder0.encode(locationBarVisible, 12, 7);
        
        encoder0.encode(scrollbarsVisible, 13, 0);
        
        encoder0.encode(resizable, 13, 1);
        
        encoder0.encode(fullscreen, 13, 2);
        
        encoder0.encode(dialog, 13, 3);
        
        encoder0.encode(y, 16);
        
        encoder0.encode(width, 20);
        
        encoder0.encode(height, 24);
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        WindowFeatures other = (WindowFeatures) object;
        if (this.x!= other.x)
            return false;
        if (this.hasX!= other.hasX)
            return false;
        if (this.y!= other.y)
            return false;
        if (this.hasY!= other.hasY)
            return false;
        if (this.width!= other.width)
            return false;
        if (this.hasWidth!= other.hasWidth)
            return false;
        if (this.height!= other.height)
            return false;
        if (this.hasHeight!= other.hasHeight)
            return false;
        if (this.menuBarVisible!= other.menuBarVisible)
            return false;
        if (this.statusBarVisible!= other.statusBarVisible)
            return false;
        if (this.toolBarVisible!= other.toolBarVisible)
            return false;
        if (this.locationBarVisible!= other.locationBarVisible)
            return false;
        if (this.scrollbarsVisible!= other.scrollbarsVisible)
            return false;
        if (this.resizable!= other.resizable)
            return false;
        if (this.fullscreen!= other.fullscreen)
            return false;
        return this.dialog == other.dialog;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + getClass().hashCode();
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(x);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(hasX);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(y);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(hasY);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(width);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(hasWidth);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(height);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(hasHeight);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(menuBarVisible);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(statusBarVisible);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(toolBarVisible);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(locationBarVisible);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(scrollbarsVisible);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(resizable);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(fullscreen);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(dialog);
        return result;
    }
}