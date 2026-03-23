package com.blueair.database.entity;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$16 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$16 INSTANCE = new DeviceEntity$Companion$fromDevice$16();

    DeviceEntity$Companion$fromDevice$16() {
        super(Device.class, "wifiFirmware", "getWifiFirmware()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((Device) obj).getWifiFirmware();
    }
}
