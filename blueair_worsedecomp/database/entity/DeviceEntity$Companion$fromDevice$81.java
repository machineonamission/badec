package com.blueair.database.entity;

import com.blueair.core.model.HasPetMainMode;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$81 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$81 INSTANCE = new DeviceEntity$Companion$fromDevice$81();

    DeviceEntity$Companion$fromDevice$81() {
        super(HasPetMainMode.class, "smartSubMode", "getSmartSubMode()I", 0);
    }

    public Object get(Object obj) {
        return Integer.valueOf(((HasPetMainMode) obj).getSmartSubMode());
    }
}
