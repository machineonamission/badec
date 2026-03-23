package com.blueair.database.entity;

import com.blueair.core.model.HasBody;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$83 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$83 INSTANCE = new DeviceEntity$Companion$fromDevice$83();

    DeviceEntity$Companion$fromDevice$83() {
        super(HasBody.class, "bodyMounted", "getBodyMounted()Z", 0);
    }

    public Object get(Object obj) {
        return Boolean.valueOf(((HasBody) obj).getBodyMounted());
    }
}
