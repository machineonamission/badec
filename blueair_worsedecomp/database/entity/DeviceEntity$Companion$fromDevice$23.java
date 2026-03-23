package com.blueair.database.entity;

import com.blueair.core.model.HasFanSpeed;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$23 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$23 INSTANCE = new DeviceEntity$Companion$fromDevice$23();

    DeviceEntity$Companion$fromDevice$23() {
        super(HasFanSpeed.class, "filterType", "getFilterType()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((HasFanSpeed) obj).getFilterType();
    }
}
