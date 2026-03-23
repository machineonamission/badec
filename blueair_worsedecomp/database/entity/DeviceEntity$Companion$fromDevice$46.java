package com.blueair.database.entity;

import com.blueair.core.model.HasDisinfection;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$46 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$46 INSTANCE = new DeviceEntity$Companion$fromDevice$46();

    DeviceEntity$Companion$fromDevice$46() {
        super(HasDisinfection.class, "disinfectLeftTimeUpdateTime", "getDisinfectLeftTimeUpdateTime()Ljava/lang/Long;", 0);
    }

    public Object get(Object obj) {
        return ((HasDisinfection) obj).getDisinfectLeftTimeUpdateTime();
    }
}
