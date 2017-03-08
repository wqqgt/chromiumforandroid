
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/platform/site_engagement.mojom
//

package org.chromium.blink.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface EngagementClient extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends EngagementClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<EngagementClient, EngagementClient.Proxy> MANAGER = EngagementClient_Internal.MANAGER;


    void setEngagementLevel(
org.chromium.url.mojom.Origin origin, int level);


}
