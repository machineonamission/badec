package com.blueair.devicemanager;

import com.blueair.devicemanager.DeviceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$Companion", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11}, l = {2670, 2536, 2537, 2541, 2542, 2556, 2557, 2558, 2559, 2560, 2561, 2563}, m = "downloadDeviceList", n = {"deviceManager", "$this$withLock_u24default$iv", "$i$f$withLock", "deviceManager", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2", "deviceManager", "$this$withLock_u24default$iv", "ablDevices", "blueDevices", "sensorsJob", "attributesJob", "isUpdatingJob", "linksJob", "schedules", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$Companion$downloadDeviceList$2"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$Companion$downloadDeviceList$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager.Companion this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$Companion$downloadDeviceList$1(DeviceManager.Companion companion, Continuation<? super DeviceManager$Companion$downloadDeviceList$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadDeviceList((DeviceManager) null, this);
    }
}
