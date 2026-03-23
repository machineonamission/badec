package com.blueair.database.entity;

import com.blueair.core.model.HasSensorData;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$10 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$10 INSTANCE = new DeviceEntity$Companion$fromDevice$10();

    DeviceEntity$Companion$fromDevice$10() {
        super(HasSensorData.class, "lastSelectedSensorTypeIndex", "getLastSelectedSensorTypeIndex()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((HasSensorData) obj).getLastSelectedSensorTypeIndex());
    }
}
