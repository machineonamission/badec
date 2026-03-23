package com.blueair.database.entity;

import com.blueair.core.model.HasOscillation;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$62 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$62 INSTANCE = new DeviceEntity$Companion$fromDevice$62();

    DeviceEntity$Companion$fromDevice$62() {
        super(HasOscillation.class, "oscillationFanSpeed", "getOscillationFanSpeed()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((HasOscillation) obj).getOscillationFanSpeed());
    }
}
