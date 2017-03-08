
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/platform/modules/sensitive_input_visibility/sensitive_input_visibility_service.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


class SensitiveInputVisibilityService_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<SensitiveInputVisibilityService, SensitiveInputVisibilityService.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<SensitiveInputVisibilityService, SensitiveInputVisibilityService.Proxy>() {
    
        public String getName() {
            return "blink::mojom::SensitiveInputVisibilityService";
        }
    
        public int getVersion() {
          return 0;
        }
    
        public Proxy buildProxy(org.chromium.mojo.system.Core core,
                                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }
    
        public Stub buildStub(org.chromium.mojo.system.Core core, SensitiveInputVisibilityService impl) {
            return new Stub(core, impl);
        }
    
        public SensitiveInputVisibilityService[] buildArray(int size) {
          return new SensitiveInputVisibilityService[size];
        }
    };


    private static final int PASSWORD_FIELD_VISIBLE_IN_INSECURE_CONTEXT_ORDINAL = 0;

    private static final int ALL_PASSWORD_FIELDS_IN_INSECURE_CONTEXT_INVISIBLE_ORDINAL = 1;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements SensitiveInputVisibilityService.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void passwordFieldVisibleInInsecureContext(
) {

            SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams _message = new SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(PASSWORD_FIELD_VISIBLE_IN_INSECURE_CONTEXT_ORDINAL)));

        }


        @Override
        public void allPasswordFieldsInInsecureContextInvisible(
) {

            SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams _message = new SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ALL_PASSWORD_FIELDS_IN_INSECURE_CONTEXT_INVISIBLE_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<SensitiveInputVisibilityService> {

        Stub(org.chromium.mojo.system.Core core, SensitiveInputVisibilityService impl) {
            super(core, impl);
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.NO_FLAG)) {
                    return false;
                }
                switch(header.getType()) {
            
                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_OR_CLOSE_PIPE_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(
                                SensitiveInputVisibilityService_Internal.MANAGER, messageWithHeader);
            
            
            
            
            
                    case PASSWORD_FIELD_VISIBLE_IN_INSECURE_CONTEXT_ORDINAL: {
            
                        SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams.deserialize(messageWithHeader.getPayload());
            
                        getImpl().passwordFieldVisibleInInsecureContext();
                        return true;
                    }
            
            
            
            
            
                    case ALL_PASSWORD_FIELDS_IN_INSECURE_CONTEXT_INVISIBLE_ORDINAL: {
            
                        SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams.deserialize(messageWithHeader.getPayload());
            
                        getImpl().allPasswordFieldsInInsecureContextInvisible();
                        return true;
                    }
            
            
                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override
        public boolean acceptWithResponder(org.chromium.mojo.bindings.Message message, org.chromium.mojo.bindings.MessageReceiver receiver) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG)) {
                    return false;
                }
                switch(header.getType()) {
            
                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(
                                getCore(), SensitiveInputVisibilityService_Internal.MANAGER, messageWithHeader, receiver);
            
            
            
            
            
            
                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams extends org.chromium.mojo.bindings.Struct {
    
        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    
        private SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams(int version) {
            super(STRUCT_SIZE, version);
        }
    
        public SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams() {
            this(0);
        }
    
        public static SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }
    
        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams deserialize(java.nio.ByteBuffer data) {
            if (data == null)
                return null;
    
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }
    
        @SuppressWarnings("unchecked")
        public static SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                result = new SensitiveInputVisibilityServicePasswordFieldVisibleInInsecureContextParams(mainDataHeader.elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }
    
        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
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
            return getClass() == object.getClass();
        }
    
        /**
         * @see Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime + getClass().hashCode();
            return result;
        }
    }



    
    static final class SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams extends org.chromium.mojo.bindings.Struct {
    
        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    
        private SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams(int version) {
            super(STRUCT_SIZE, version);
        }
    
        public SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams() {
            this(0);
        }
    
        public static SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }
    
        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams deserialize(java.nio.ByteBuffer data) {
            if (data == null)
                return null;
    
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }
    
        @SuppressWarnings("unchecked")
        public static SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                result = new SensitiveInputVisibilityServiceAllPasswordFieldsInInsecureContextInvisibleParams(mainDataHeader.elementsOrVersion);
            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }
    
        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
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
            return getClass() == object.getClass();
        }
    
        /**
         * @see Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime + getClass().hashCode();
            return result;
        }
    }



}