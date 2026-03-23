package com.blueair.database.entity;

import com.blueair.core.model.HasStandBy;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$31 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$31 INSTANCE = new DeviceEntity$Companion$fromDevice$31();

    DeviceEntity$Companion$fromDevice$31() {
        super(HasStandBy.class, "isStandByOn", "isStandByOn()Z", 0);
    }

    public Object get(Object obj) {
        return Boolean.valueOf(((HasStandBy) obj).isStandByOn());
    }
}
