package com.blueair.database.entity;

import com.blueair.core.model.HasLinkingCapability;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceEntity.kt */
final /* synthetic */ class DeviceEntity$Companion$fromDevice$13 extends MutablePropertyReference1Impl {
    public static final DeviceEntity$Companion$fromDevice$13 INSTANCE = new DeviceEntity$Companion$fromDevice$13();

    DeviceEntity$Companion$fromDevice$13() {
        super(HasLinkingCapability.class, "linkedToUid", "getLinkedToUid()Ljava/lang/String;", 0);
    }

    public Object get(Object obj) {
        return ((HasLinkingCapability) obj).getLinkedToUid();
    }

    public void set(Object obj, Object obj2) {
        ((HasLinkingCapability) obj).setLinkedToUid((String) obj2);
    }
}
