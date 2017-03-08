
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     device/generic_sensor/public/interfaces/sensor.mojom
//

package org.chromium.device.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public interface Sensor extends org.chromium.mojo.bindings.Interface {



    interface Proxy extends Sensor, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<Sensor, Sensor.Proxy> MANAGER = Sensor_Internal.MANAGER;


    void getDefaultConfiguration(

GetDefaultConfigurationResponse callback);

    interface GetDefaultConfigurationResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<SensorConfiguration> { }



    void addConfiguration(
SensorConfiguration configuration, 
AddConfigurationResponse callback);

    interface AddConfigurationResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void removeConfiguration(
SensorConfiguration configuration, 
RemoveConfigurationResponse callback);

    interface RemoveConfigurationResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Boolean> { }



    void suspend(
);



    void resume(
);


}