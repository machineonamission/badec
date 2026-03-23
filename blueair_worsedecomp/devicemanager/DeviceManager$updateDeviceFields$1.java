package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.database.DeviceField;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$updateDeviceFields$1", f = "DeviceManager.kt", i = {0, 0, 0, 0, 0}, l = {2052}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DeviceManager$updateDeviceFields$1$1"}, s = {"L$0", "L$4", "L$5", "I$0", "I$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateDeviceFields$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ List<Pair<DeviceField<?>, T>> $fieldsAndValues;
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
    DeviceManager$updateDeviceFields$1(List<? extends Pair<? extends DeviceField<?>, ? extends T>> list, DeviceManager deviceManager, String str, Continuation<? super DeviceManager$updateDeviceFields$1> continuation) {
        super(2, continuation);
        this.$fieldsAndValues = list;
        this.this$0 = deviceManager;
        this.$deviceId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$updateDeviceFields$1(this.$fieldsAndValues, this.this$0, this.$deviceId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$updateDeviceFields$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterable iterable;
        String str;
        DeviceManager deviceManager;
        Iterator it;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            iterable = this.$fieldsAndValues;
            deviceManager = this.this$0;
            i = 0;
            str = this.$deviceId;
            it = iterable.iterator();
        } else if (i2 == 1) {
            i = this.I$0;
            Pair pair = (Pair) this.L$5;
            it = (Iterator) this.L$3;
            deviceManager = (DeviceManager) this.L$1;
            ResultKt.throwOnFailure(obj);
            iterable = (Iterable) this.L$0;
            str = (String) this.L$2;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Pair pair2 = (Pair) next;
            Pair pair3 = pair2;
            DeviceField deviceField = (DeviceField) pair2.getFirst();
            Object second = pair3.getSecond();
            this.L$0 = SpillingKt.nullOutSpilledVariable(iterable);
            this.L$1 = deviceManager;
            this.L$2 = str;
            this.L$3 = it;
            this.L$4 = SpillingKt.nullOutSpilledVariable(next);
            this.L$5 = SpillingKt.nullOutSpilledVariable(pair3);
            this.I$0 = i;
            this.I$1 = 0;
            this.label = 1;
            if (deviceManager.updateDeviceField(str, deviceField, second, DataTrend.RealTimeTrend.INSTANCE, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
