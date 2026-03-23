package com.blueair.database.entity;

import com.blueair.core.model.HasWaterTank;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$80 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$80 INSTANCE = new DeviceEntity$Companion$fromDevice$80();

    DeviceEntity$Companion$fromDevice$80() {
        super(HasWaterTank.class, "waterTankFailure", "getWaterTankFailure()Z", 0);
    }

    public Object get(Object obj) {
        return Boolean.valueOf(((HasWaterTank) obj).getWaterTankFailure());
    }
}
