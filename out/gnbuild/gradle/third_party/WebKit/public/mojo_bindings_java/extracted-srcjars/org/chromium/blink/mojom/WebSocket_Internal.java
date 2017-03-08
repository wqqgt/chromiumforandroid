
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/platform/modules/websockets/websocket.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


class WebSocket_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<WebSocket, WebSocket.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<WebSocket, WebSocket.Proxy>() {
    
        public String getName() {
            return "blink::mojom::WebSocket";
        }
    
        public int getVersion() {
          return 0;
        }
    
        public Proxy buildProxy(org.chromium.mojo.system.Core core,
                                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }
    
        public Stub buildStub(org.chromium.mojo.system.Core core, WebSocket impl) {
            return new Stub(core, impl);
        }
    
        public WebSocket[] buildArray(int size) {
          return new WebSocket[size];
        }
    };


    private static final int ADD_CHANNEL_REQUEST_ORDINAL = 0;

    private static final int SEND_FRAME_ORDINAL = 1;

    private static final int SEND_FLOW_CONTROL_ORDINAL = 2;

    private static final int START_CLOSING_HANDSHAKE_ORDINAL = 3;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements WebSocket.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void addChannelRequest(
org.chromium.url.mojom.Url url, String[] requestedProtocols, org.chromium.url.mojom.Origin origin, org.chromium.url.mojom.Url firstPartyForCookies, String userAgentOverride, WebSocketClient client) {

            WebSocketAddChannelRequestParams _message = new WebSocketAddChannelRequestParams();

            _message.url = url;

            _message.requestedProtocols = requestedProtocols;

            _message.origin = origin;

            _message.firstPartyForCookies = firstPartyForCookies;

            _message.userAgentOverride = userAgentOverride;

            _message.client = client;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(ADD_CHANNEL_REQUEST_ORDINAL)));

        }


        @Override
        public void sendFrame(
boolean fin, int type, byte[] data) {

            WebSocketSendFrameParams _message = new WebSocketSendFrameParams();

            _message.fin = fin;

            _message.type = type;

            _message.data = data;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SEND_FRAME_ORDINAL)));

        }


        @Override
        public void sendFlowControl(
long quota) {

            WebSocketSendFlowControlParams _message = new WebSocketSendFlowControlParams();

            _message.quota = quota;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(SEND_FLOW_CONTROL_ORDINAL)));

        }


        @Override
        public void startClosingHandshake(
short code, String reason) {

            WebSocketStartClosingHandshakeParams _message = new WebSocketStartClosingHandshakeParams();

            _message.code = code;

            _message.reason = reason;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(START_CLOSING_HANDSHAKE_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<WebSocket> {

        Stub(org.chromium.mojo.system.Core core, WebSocket impl) {
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
                                WebSocket_Internal.MANAGER, messageWithHeader);
            
            
            
            
            
                    case ADD_CHANNEL_REQUEST_ORDINAL: {
            
                        WebSocketAddChannelRequestParams data =
                                WebSocketAddChannelRequestParams.deserialize(messageWithHeader.getPayload());
            
                        getImpl().addChannelRequest(data.url, data.requestedProtocols, data.origin, data.firstPartyForCookies, data.userAgentOverride, data.client);
                        return true;
                    }
            
            
            
            
            
                    case SEND_FRAME_ORDINAL: {
            
                        WebSocketSendFrameParams data =
                                WebSocketSendFrameParams.deserialize(messageWithHeader.getPayload());
            
                        getImpl().sendFrame(data.fin, data.type, data.data);
                        return true;
                    }
            
            
            
            
            
                    case SEND_FLOW_CONTROL_ORDINAL: {
            
                        WebSocketSendFlowControlParams data =
                                WebSocketSendFlowControlParams.deserialize(messageWithHeader.getPayload());
            
                        getImpl().sendFlowControl(data.quota);
                        return true;
                    }
            
            
            
            
            
                    case START_CLOSING_HANDSHAKE_ORDINAL: {
            
                        WebSocketStartClosingHandshakeParams data =
                                WebSocketStartClosingHandshakeParams.deserialize(messageWithHeader.getPayload());
            
                        getImpl().startClosingHandshake(data.code, data.reason);
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
                                getCore(), WebSocket_Internal.MANAGER, messageWithHeader, receiver);
            
            
            
            
            
            
            
            
            
            
                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class WebSocketAddChannelRequestParams extends org.chromium.mojo.bindings.Struct {
    
        private static final int STRUCT_SIZE = 56;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(56, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.url.mojom.Url url;
        public String[] requestedProtocols;
        public org.chromium.url.mojom.Origin origin;
        public org.chromium.url.mojom.Url firstPartyForCookies;
        public String userAgentOverride;
        public WebSocketClient client;
    
        private WebSocketAddChannelRequestParams(int version) {
            super(STRUCT_SIZE, version);
        }
    
        public WebSocketAddChannelRequestParams() {
            this(0);
        }
    
        public static WebSocketAddChannelRequestParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }
    
        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketAddChannelRequestParams deserialize(java.nio.ByteBuffer data) {
            if (data == null)
                return null;
    
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }
    
        @SuppressWarnings("unchecked")
        public static WebSocketAddChannelRequestParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketAddChannelRequestParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                result = new WebSocketAddChannelRequestParams(mainDataHeader.elementsOrVersion);
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.url = org.chromium.url.mojom.Url.decode(decoder1);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, false);
                    {
                        org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                        result.requestedProtocols = new String[si1.elementsOrVersion];
                        for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                            
                            result.requestedProtocols[i1] = decoder1.readString(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        }
                    }
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                    result.origin = org.chromium.url.mojom.Origin.decode(decoder1);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                    result.firstPartyForCookies = org.chromium.url.mojom.Url.decode(decoder1);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.userAgentOverride = decoder0.readString(40, false);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.client = decoder0.readServiceInterface(48, false, WebSocketClient.MANAGER);
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
            
            encoder0.encode(url, 8, false);
            
            if (requestedProtocols == null) {
                encoder0.encodeNullPointer(16, false);
            } else {
                org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(requestedProtocols.length, 16, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                for (int i0 = 0; i0 < requestedProtocols.length; ++i0) {
                    
                    encoder1.encode(requestedProtocols[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
                }
            }
            
            encoder0.encode(origin, 24, false);
            
            encoder0.encode(firstPartyForCookies, 32, false);
            
            encoder0.encode(userAgentOverride, 40, false);
            
            encoder0.encode(client, 48, false, WebSocketClient.MANAGER);
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
            WebSocketAddChannelRequestParams other = (WebSocketAddChannelRequestParams) object;
            if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.url, other.url))
                return false;
            if (!java.util.Arrays.deepEquals(this.requestedProtocols, other.requestedProtocols))
                return false;
            if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.origin, other.origin))
                return false;
            if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.firstPartyForCookies, other.firstPartyForCookies))
                return false;
            if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.userAgentOverride, other.userAgentOverride))
                return false;
            return org.chromium.mojo.bindings.BindingsHelper.equals(this.client, other.client);
        }
    
        /**
         * @see Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime + getClass().hashCode();
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(url);
            result = prime * result + java.util.Arrays.deepHashCode(requestedProtocols);
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(origin);
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(firstPartyForCookies);
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(userAgentOverride);
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(client);
            return result;
        }
    }



    
    static final class WebSocketSendFrameParams extends org.chromium.mojo.bindings.Struct {
    
        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean fin;
        public int type;
        public byte[] data;
    
        private WebSocketSendFrameParams(int version) {
            super(STRUCT_SIZE, version);
        }
    
        public WebSocketSendFrameParams() {
            this(0);
        }
    
        public static WebSocketSendFrameParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }
    
        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketSendFrameParams deserialize(java.nio.ByteBuffer data) {
            if (data == null)
                return null;
    
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }
    
        @SuppressWarnings("unchecked")
        public static WebSocketSendFrameParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketSendFrameParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                result = new WebSocketSendFrameParams(mainDataHeader.elementsOrVersion);
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.fin = decoder0.readBoolean(8, 0);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.type = decoder0.readInt(12);
                        WebSocketMessageType.validate(result.type);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.data = decoder0.readBytes(16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
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
            
            encoder0.encode(fin, 8, 0);
            
            encoder0.encode(type, 12);
            
            encoder0.encode(data, 16, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
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
            WebSocketSendFrameParams other = (WebSocketSendFrameParams) object;
            if (this.fin!= other.fin)
                return false;
            if (this.type!= other.type)
                return false;
            return java.util.Arrays.equals(this.data, other.data);
        }
    
        /**
         * @see Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime + getClass().hashCode();
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(fin);
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(type);
            result = prime * result + java.util.Arrays.hashCode(data);
            return result;
        }
    }



    
    static final class WebSocketSendFlowControlParams extends org.chromium.mojo.bindings.Struct {
    
        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public long quota;
    
        private WebSocketSendFlowControlParams(int version) {
            super(STRUCT_SIZE, version);
        }
    
        public WebSocketSendFlowControlParams() {
            this(0);
        }
    
        public static WebSocketSendFlowControlParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }
    
        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketSendFlowControlParams deserialize(java.nio.ByteBuffer data) {
            if (data == null)
                return null;
    
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }
    
        @SuppressWarnings("unchecked")
        public static WebSocketSendFlowControlParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketSendFlowControlParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                result = new WebSocketSendFlowControlParams(mainDataHeader.elementsOrVersion);
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.quota = decoder0.readLong(8);
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
            
            encoder0.encode(quota, 8);
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
            WebSocketSendFlowControlParams other = (WebSocketSendFlowControlParams) object;
            return this.quota == other.quota;
        }
    
        /**
         * @see Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime + getClass().hashCode();
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(quota);
            return result;
        }
    }



    
    static final class WebSocketStartClosingHandshakeParams extends org.chromium.mojo.bindings.Struct {
    
        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public short code;
        public String reason;
    
        private WebSocketStartClosingHandshakeParams(int version) {
            super(STRUCT_SIZE, version);
        }
    
        public WebSocketStartClosingHandshakeParams() {
            this(0);
        }
    
        public static WebSocketStartClosingHandshakeParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }
    
        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static WebSocketStartClosingHandshakeParams deserialize(java.nio.ByteBuffer data) {
            if (data == null)
                return null;
    
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }
    
        @SuppressWarnings("unchecked")
        public static WebSocketStartClosingHandshakeParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            WebSocketStartClosingHandshakeParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                result = new WebSocketStartClosingHandshakeParams(mainDataHeader.elementsOrVersion);
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.code = decoder0.readShort(8);
                }
                if (mainDataHeader.elementsOrVersion >= 0) {
                    
                    result.reason = decoder0.readString(16, false);
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
            
            encoder0.encode(code, 8);
            
            encoder0.encode(reason, 16, false);
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
            WebSocketStartClosingHandshakeParams other = (WebSocketStartClosingHandshakeParams) object;
            if (this.code!= other.code)
                return false;
            return org.chromium.mojo.bindings.BindingsHelper.equals(this.reason, other.reason);
        }
    
        /**
         * @see Object#hashCode()
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = prime + getClass().hashCode();
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(code);
            result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(reason);
            return result;
        }
    }



}
