package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager", f = "DeviceManager.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7}, l = {2668, 592, 592, 592, 612, 617, 624, 626}, m = "removeDeviceWithLock", n = {"device", "$this$withLock_u24default$iv", "$i$f$withLock", "device", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2", "device", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2", "device", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2", "device", "$this$withLock_u24default$iv", "it", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2", "$i$a$-let-DeviceManager$removeDeviceWithLock$2$3", "device", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2", "device", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2", "device", "$this$withLock_u24default$iv", "$i$f$withLock", "$i$a$-withLock$default-DeviceManager$removeDeviceWithLock$2"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$removeDeviceWithLock$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$removeDeviceWithLock$1(DeviceManager deviceManager, Continuation<? super DeviceManager$removeDeviceWithLock$1> continuation) {
        super(continuation);
        this.this$0 = deviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeDeviceWithLock((Device) null, this);
    }
}
