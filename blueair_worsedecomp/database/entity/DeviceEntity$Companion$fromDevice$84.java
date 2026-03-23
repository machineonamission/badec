package com.blueair.database.entity;

import com.blueair.core.model.HasCleanAirEta;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$84 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$84 INSTANCE = new DeviceEntity$Companion$fromDevice$84();

    DeviceEntity$Companion$fromDevice$84() {
        super(HasCleanAirEta.class, "cleanAirEta", "getCleanAirEta()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((HasCleanAirEta) obj).getCleanAirEta());
    }
}
