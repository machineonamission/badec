package com.blueair.database.entity;

import com.blueair.core.model.HasDisinfection;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$44 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$44 INSTANCE = new DeviceEntity$Companion$fromDevice$44();

    DeviceEntity$Companion$fromDevice$44() {
        super(HasDisinfection.class, "disinfection", "getDisinfection()Ljava/lang/Boolean;", 0);
    }

    public Object get(Object obj) {
        return ((HasDisinfection) obj).getDisinfection();
    }
}
