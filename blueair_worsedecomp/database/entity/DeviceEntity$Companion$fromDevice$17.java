package com.blueair.database.entity;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$17 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$17 INSTANCE = new DeviceEntity$Companion$fromDevice$17();

    DeviceEntity$Companion$fromDevice$17() {
        super(Device.class, "hardware", "getHardware()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((Device) obj).getHardware();
    }
}
