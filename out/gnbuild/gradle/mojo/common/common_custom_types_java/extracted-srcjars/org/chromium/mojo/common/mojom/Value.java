
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     mojo/common/values.mojom
//

package org.chromium.mojo.common.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class Value extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int NullValue = 0;
        public static final int BoolValue = 1;
        public static final int IntValue = 2;
        public static final int DoubleValue = 3;
        public static final int StringValue = 4;
        public static final int BinaryValue = 5;
        public static final int DictionaryValue = 6;
        public static final int ListValue = 7;
    }

    private int mTag_ = -1;
    private NullValue mNullValue;
    private boolean mBoolValue;
    private int mIntValue;
    private double mDoubleValue;
    private String mStringValue;
    private byte[] mBinaryValue;
    private DictionaryValue mDictionaryValue;
    private ListValue mListValue;

    public int which() {
      return mTag_;
    }

    public boolean isUnknown() {
      return mTag_ == -1;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setNullValue(NullValue nullValue) {
        mTag_ = Tag.NullValue;
        mNullValue = nullValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public NullValue getNullValue() {
        assert mTag_ == Tag.NullValue;
        return mNullValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setBoolValue(boolean boolValue) {
        mTag_ = Tag.BoolValue;
        mBoolValue = boolValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public boolean getBoolValue() {
        assert mTag_ == Tag.BoolValue;
        return mBoolValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setIntValue(int intValue) {
        mTag_ = Tag.IntValue;
        mIntValue = intValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public int getIntValue() {
        assert mTag_ == Tag.IntValue;
        return mIntValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setDoubleValue(double doubleValue) {
        mTag_ = Tag.DoubleValue;
        mDoubleValue = doubleValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public double getDoubleValue() {
        assert mTag_ == Tag.DoubleValue;
        return mDoubleValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setStringValue(String stringValue) {
        mTag_ = Tag.StringValue;
        mStringValue = stringValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public String getStringValue() {
        assert mTag_ == Tag.StringValue;
        return mStringValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setBinaryValue(byte[] binaryValue) {
        mTag_ = Tag.BinaryValue;
        mBinaryValue = binaryValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public byte[] getBinaryValue() {
        assert mTag_ == Tag.BinaryValue;
        return mBinaryValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setDictionaryValue(DictionaryValue dictionaryValue) {
        mTag_ = Tag.DictionaryValue;
        mDictionaryValue = dictionaryValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public DictionaryValue getDictionaryValue() {
        assert mTag_ == Tag.DictionaryValue;
        return mDictionaryValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public void setListValue(ListValue listValue) {
        mTag_ = Tag.ListValue;
        mListValue = listValue;
    }

    // TODO(rockot): Fix the findbugs error and remove this suppression.
    // See http://crbug.com/570386.
    @SuppressFBWarnings("EI_EXPOSE_REP")
    public ListValue getListValue() {
        assert mTag_ == Tag.ListValue;
        return mListValue;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(mTag_, offset + 4);
        switch (mTag_) {
            case Tag.NullValue: {
                
                encoder0.encode(mNullValue, offset + 8, true);
                break;
            }
            case Tag.BoolValue: {
                
                encoder0.encode(mBoolValue, offset + 8, 0);
                break;
            }
            case Tag.IntValue: {
                
                encoder0.encode(mIntValue, offset + 8);
                break;
            }
            case Tag.DoubleValue: {
                
                encoder0.encode(mDoubleValue, offset + 8);
                break;
            }
            case Tag.StringValue: {
                
                encoder0.encode(mStringValue, offset + 8, false);
                break;
            }
            case Tag.BinaryValue: {
                
                encoder0.encode(mBinaryValue, offset + 8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                break;
            }
            case Tag.DictionaryValue: {
                
                encoder0.encode(mDictionaryValue, offset + 8, false);
                break;
            }
            case Tag.ListValue: {
                
                encoder0.encode(mListValue, offset + 8, false);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static Value deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final Value decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        Value result = new Value();
        switch (dataHeader.elementsOrVersion) {
            case Tag.NullValue: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, true);
                result.mNullValue = NullValue.decode(decoder1);
                result.mTag_ = Tag.NullValue;
                break;
            }
            case Tag.BoolValue: {
                
                result.mBoolValue = decoder0.readBoolean(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, 0);
                result.mTag_ = Tag.BoolValue;
                break;
            }
            case Tag.IntValue: {
                
                result.mIntValue = decoder0.readInt(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                result.mTag_ = Tag.IntValue;
                break;
            }
            case Tag.DoubleValue: {
                
                result.mDoubleValue = decoder0.readDouble(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                result.mTag_ = Tag.DoubleValue;
                break;
            }
            case Tag.StringValue: {
                
                result.mStringValue = decoder0.readString(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mTag_ = Tag.StringValue;
                break;
            }
            case Tag.BinaryValue: {
                
                result.mBinaryValue = decoder0.readBytes(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                result.mTag_ = Tag.BinaryValue;
                break;
            }
            case Tag.DictionaryValue: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mDictionaryValue = DictionaryValue.decode(decoder1);
                result.mTag_ = Tag.DictionaryValue;
                break;
            }
            case Tag.ListValue: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mListValue = ListValue.decode(decoder1);
                result.mTag_ = Tag.ListValue;
                break;
            }
            default: {
                break;
            }
        }
        return result;
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
        Value other = (Value) object;
        if (mTag_ != other.mTag_)
            return false;
        switch (mTag_) {
            case Tag.NullValue:
                return org.chromium.mojo.bindings.BindingsHelper.equals(mNullValue, other.mNullValue);
            case Tag.BoolValue:
                return mBoolValue== other.mBoolValue;
            case Tag.IntValue:
                return mIntValue== other.mIntValue;
            case Tag.DoubleValue:
                return mDoubleValue== other.mDoubleValue;
            case Tag.StringValue:
                return org.chromium.mojo.bindings.BindingsHelper.equals(mStringValue, other.mStringValue);
            case Tag.BinaryValue:
                return java.util.Arrays.equals(mBinaryValue, other.mBinaryValue);
            case Tag.DictionaryValue:
                return org.chromium.mojo.bindings.BindingsHelper.equals(mDictionaryValue, other.mDictionaryValue);
            case Tag.ListValue:
                return org.chromium.mojo.bindings.BindingsHelper.equals(mListValue, other.mListValue);
            default:
                break;
        }
        return false;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + getClass().hashCode();
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mTag_);
        switch (mTag_) {
            case Tag.NullValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mNullValue);
                break;
            }
            case Tag.BoolValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mBoolValue);
                break;
            }
            case Tag.IntValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mIntValue);
                break;
            }
            case Tag.DoubleValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mDoubleValue);
                break;
            }
            case Tag.StringValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mStringValue);
                break;
            }
            case Tag.BinaryValue: {
                result = prime * result + java.util.Arrays.hashCode(mBinaryValue);
                break;
            }
            case Tag.DictionaryValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mDictionaryValue);
                break;
            }
            case Tag.ListValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mListValue);
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}