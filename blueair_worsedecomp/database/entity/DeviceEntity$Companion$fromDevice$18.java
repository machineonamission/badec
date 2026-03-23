package com.blueair.database.entity;

import com.blueair.core.model.Device;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$18 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$18 INSTANCE = new DeviceEntity$Companion$fromDevice$18();

    DeviceEntity$Companion$fromDevice$18() {
        super(Device.class, RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "getTimeZone()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((Device) obj).getTimeZone();
    }
}
