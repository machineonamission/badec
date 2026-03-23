package com.blueair.database.entity;

import com.blueair.core.model.HasBlueProvisionCalls;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$deviceUuid$1 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$deviceUuid$1 INSTANCE = new DeviceEntity$Companion$fromDevice$deviceUuid$1();

    DeviceEntity$Companion$fromDevice$deviceUuid$1() {
        super(HasBlueProvisionCalls.class, "deviceUuid", "getDeviceUuid()Lcom/blueair/core/model/DeviceUuid;", 0);
    }

    public Object get(Object obj) {
        return ((HasBlueProvisionCalls) obj).getDeviceUuid();
    }
}
