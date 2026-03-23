package com.blueair.devicemanager;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasBlueProvisionCalls;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$assignLocallySavedJwtsToDevices$1", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {693}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "device", "deviceJwt", "$i$f$forEach", "$i$a$-forEach-DeviceManager$assignLocallySavedJwtsToDevices$1$1"}, s = {"L$0", "L$3", "L$4", "L$5", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$assignLocallySavedJwtsToDevices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$assignLocallySavedJwtsToDevices$1(DeviceManager deviceManager, Continuation<? super DeviceManager$assignLocallySavedJwtsToDevices$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$assignLocallySavedJwtsToDevices$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$assignLocallySavedJwtsToDevices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterable iterable;
        DeviceManager deviceManager;
        Iterator it;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Collection arrayList = new ArrayList();
            for (Object next : this.this$0.getDevices()) {
                if (next instanceof HasBlueProvisionCalls) {
                    arrayList.add(next);
                }
            }
            Iterable iterable2 = (List) arrayList;
            DeviceManager deviceManager2 = this.this$0;
            it = iterable2.iterator();
            deviceManager = deviceManager2;
            iterable = iterable2;
            i = 0;
        } else if (i2 == 1) {
            i = this.I$0;
            String str = (String) this.L$5;
            HasBlueProvisionCalls hasBlueProvisionCalls = (HasBlueProvisionCalls) this.L$4;
            it = (Iterator) this.L$2;
            deviceManager = (DeviceManager) this.L$1;
            iterable = (Iterable) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next2 = it.next();
            HasBlueProvisionCalls hasBlueProvisionCalls2 = (HasBlueProvisionCalls) next2;
            Device device = hasBlueProvisionCalls2;
            String locallySavedDeviceJwt = deviceManager.authService.getLocallySavedDeviceJwt(device);
            this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
            this.L$1 = deviceManager;
            this.L$2 = it;
            this.L$3 = SpillingKt.nullOutSpilledVariable(next2);
            this.L$4 = SpillingKt.nullOutSpilledVariable(hasBlueProvisionCalls2);
            this.L$5 = SpillingKt.nullOutSpilledVariable(locallySavedDeviceJwt);
            this.I$0 = i;
            this.I$1 = 0;
            this.label = 1;
            if (deviceManager.assignJwtToDevice(device, locallySavedDeviceJwt, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
