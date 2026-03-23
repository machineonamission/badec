package com.blueair.database.entity;

import com.blueair.core.model.HasSensorData;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$29 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$29 INSTANCE = new DeviceEntity$Companion$fromDevice$29();

    DeviceEntity$Companion$fromDevice$29() {
        super(HasSensorData.class, "hchoRanges", "getHchoRanges()[D", 0);
    }

    public Object get(Object obj) {
        return ((HasSensorData) obj).getHchoRanges();
    }
}
