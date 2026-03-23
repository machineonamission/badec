package com.blueair.database.entity;

import com.blueair.core.model.HasCompatibility;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.apache.http.client.config.CookieSpecs;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$40 extends PropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$40 INSTANCE = new DeviceEntity$Companion$fromDevice$40();

    DeviceEntity$Companion$fromDevice$40() {
        super(HasCompatibility.class, CookieSpecs.BROWSER_COMPATIBILITY, "getCompatibility()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((HasCompatibility) obj).getCompatibility();
    }
}
