package com.blueair.database.entity;

import com.blueair.core.model.HasRemoveYellowWater;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$97 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$97 INSTANCE = new DeviceEntity$Companion$fromDevice$97();

    DeviceEntity$Companion$fromDevice$97() {
        super(HasRemoveYellowWater.class, "ywrmEnabled", "getYwrmEnabled()Ljava/lang/Boolean;", 0);
    }

    public Object get(Object obj) {
        return ((HasRemoveYellowWater) obj).getYwrmEnabled();
    }
}
