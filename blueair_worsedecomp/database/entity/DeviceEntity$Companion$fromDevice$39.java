package com.blueair.database.entity;

import com.blueair.core.model.HasG4NightMode;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$39 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$39 INSTANCE = new DeviceEntity$Companion$fromDevice$39();

    DeviceEntity$Companion$fromDevice$39() {
        super(HasG4NightMode.class, "g4NightModeFilterTrigger", "getG4NightModeFilterTrigger()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((HasG4NightMode) obj).getG4NightModeFilterTrigger();
    }
}
