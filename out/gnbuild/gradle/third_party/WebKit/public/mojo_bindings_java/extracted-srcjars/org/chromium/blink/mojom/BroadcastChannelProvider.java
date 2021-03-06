
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/platform/modules/broadcastchannel/broadcast_channel.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface BroadcastChannelProvider extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends BroadcastChannelProvider, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<BroadcastChannelProvider, BroadcastChannelProvider.Proxy> MANAGER = BroadcastChannelProvider_Internal.MANAGER;


    void connectToChannel(
org.chromium.url.mojom.Origin origin, String name, org.chromium.mojo.bindings.AssociatedInterfaceNotSupported receiver, org.chromium.mojo.bindings.AssociatedInterfaceRequestNotSupported sender);


}
