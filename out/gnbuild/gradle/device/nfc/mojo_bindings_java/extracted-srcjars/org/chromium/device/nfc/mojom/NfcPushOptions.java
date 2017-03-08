
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     device/nfc/nfc.mojom
//

package org.chromium.device.nfc.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class NfcPushOptions extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 24;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public int target;
    public double timeout;
    public boolean ignoreRead;

    private NfcPushOptions(int version) {
        super(STRUCT_SIZE, version);
    }

    public NfcPushOptions() {
        this(0);
    }

    public static NfcPushOptions deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static NfcPushOptions deserialize(java.nio.ByteBuffer data) {
        if (data == null)
            return null;

        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static NfcPushOptions decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        NfcPushOptions result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            result = new NfcPushOptions(mainDataHeader.elementsOrVersion);
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.target = decoder0.readInt(8);
                    NfcPushTarget.validate(result.target);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.ignoreRead = decoder0.readBoolean(12, 0);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.timeout = decoder0.readDouble(16);
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
        
        encoder0.encode(target, 8);
        
        encoder0.encode(ignoreRead, 12, 0);
        
        encoder0.encode(timeout, 16);
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
        NfcPushOptions other = (NfcPushOptions) object;
        if (this.target!= other.target)
            return false;
        if (this.timeout!= other.timeout)
            return false;
        return this.ignoreRead == other.ignoreRead;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + getClass().hashCode();
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(target);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(timeout);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(ignoreRead);
        return result;
    }
}