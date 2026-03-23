package com.blueair.database.entity;

import com.blueair.core.model.HasCombo3in1MainMode;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$65 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$65 INSTANCE = new DeviceEntity$Companion$fromDevice$65();

    DeviceEntity$Companion$fromDevice$65() {
        super(HasCombo3in1MainMode.class, "apFanSpeed", "getApFanSpeed()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((HasCombo3in1MainMode) obj).getApFanSpeed());
    }
}
