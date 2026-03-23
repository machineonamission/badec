package com.blueair.database.entity;

import com.blueair.core.model.HasGestureRecognition;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$86 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$86 INSTANCE = new DeviceEntity$Companion$fromDevice$86();

    DeviceEntity$Companion$fromDevice$86() {
        super(HasGestureRecognition.class, "hoverEnabled", "getHoverEnabled()Z", 0);
    }

    public Object get(Object obj) {
        return Boolean.valueOf(((HasGestureRecognition) obj).getHoverEnabled());
    }
}
