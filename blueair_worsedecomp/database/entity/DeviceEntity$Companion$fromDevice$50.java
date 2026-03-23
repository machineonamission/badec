package com.blueair.database.entity;

import com.blueair.core.model.HasWick;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$50 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$50 INSTANCE = new DeviceEntity$Companion$fromDevice$50();

    DeviceEntity$Companion$fromDevice$50() {
        super(HasWick.class, "wickdryLeftTimeUpdateTime", "getWickdryLeftTimeUpdateTime()J", 0);
    }

    public Object get(Object obj) {
        return Long.valueOf(((HasWick) obj).getWickdryLeftTimeUpdateTime());
    }
}
