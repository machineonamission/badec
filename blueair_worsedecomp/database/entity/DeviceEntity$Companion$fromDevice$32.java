package com.blueair.database.entity;

import com.blueair.core.model.HasEcoMode;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$32 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$32 INSTANCE = new DeviceEntity$Companion$fromDevice$32();

    DeviceEntity$Companion$fromDevice$32() {
        super(HasEcoMode.class, "isEcoModeOn", "isEcoModeOn()Z", 0);
    }

    public Object get(Object obj) {
        return Boolean.valueOf(((HasEcoMode) obj).isEcoModeOn());
    }
}
