package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/blueair/devicedetails/viewmodel/DeviceDetailsViewModel$setActuator$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1", f = "DeviceDetailsViewModel.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {616, 616}, m = "invokeSuspend", n = {"$completion", "it", "$i$a$-setActuator-DeviceDetailsViewModel$setAlarm$1", "$completion", "it", "result", "it", "$i$a$-setActuator-DeviceDetailsViewModel$setAlarm$1", "$i$a$-let-DeviceDetailsViewModel$setAlarm$1$1", "$i$a$-let-DeviceDetailsViewModel$setAlarm$1$1$1"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"})
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceAlarm $alarm$inlined;
    final /* synthetic */ Device $device;
    final /* synthetic */ int $index$inlined;
    final /* synthetic */ Function2 $onResult$inlined;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1(Device device, Continuation continuation, DeviceDetailsViewModel deviceDetailsViewModel, int i, DeviceAlarm deviceAlarm, Function2 function2) {
        super(2, continuation);
        this.$device = device;
        this.this$0 = deviceDetailsViewModel;
        this.$index$inlined = i;
        this.$alarm$inlined = deviceAlarm;
        this.$onResult$inlined = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1(this.$device, continuation, this.this$0, this.$index$inlined, this.$alarm$inlined, this.$onResult$inlined);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a4, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$1$1$1$1(r6, r11, (kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$1$1$1$1>) null), r10) == r0) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x003a
            if (r1 == r3) goto L_0x002c
            if (r1 != r2) goto L_0x0024
            java.lang.Object r0 = r10.L$3
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            java.lang.Object r0 = r10.L$2
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Object r0 = r10.L$1
            com.blueair.core.model.HasAlarm r0 = (com.blueair.core.model.HasAlarm) r0
            java.lang.Object r0 = r10.L$0
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a7
        L_0x0024:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002c:
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$1
            com.blueair.core.model.HasAlarm r3 = (com.blueair.core.model.HasAlarm) r3
            java.lang.Object r5 = r10.L$0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006c
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r11)
            com.blueair.core.model.Device r11 = r10.$device
            boolean r1 = r11 instanceof com.blueair.core.model.HasAlarm
            if (r1 == 0) goto L_0x00a7
            r5 = r10
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            com.blueair.core.model.HasAlarm r11 = (com.blueair.core.model.HasAlarm) r11
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r1 = r10.this$0
            com.blueair.devicemanager.DeviceManager r1 = r1.getDeviceManager()
            int r6 = r10.$index$inlined
            com.blueair.core.model.DeviceAlarm r7 = r10.$alarm$inlined
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r10.L$0 = r8
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r10.L$1 = r8
            r10.I$0 = r4
            r10.label = r3
            java.lang.Object r1 = r1.setAlarm(r11, r6, r7, r10)
            if (r1 != r0) goto L_0x0069
            goto L_0x00a6
        L_0x0069:
            r3 = r11
            r11 = r1
            r1 = r4
        L_0x006c:
            io.flatcircle.coroutinehelper.ApiResult r11 = (io.flatcircle.coroutinehelper.ApiResult) r11
            kotlin.jvm.functions.Function2 r6 = r10.$onResult$inlined
            if (r6 == 0) goto L_0x00a7
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$1$1$1$1 r8 = new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$1$1$1$1
            r9 = 0
            r8.<init>(r6, r11, r9)
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r10.L$0 = r5
            java.lang.Object r3 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r10.L$1 = r3
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r10.L$2 = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r10.L$3 = r11
            r10.I$0 = r1
            r10.I$1 = r4
            r10.I$2 = r4
            r10.label = r2
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r10)
            if (r11 != r0) goto L_0x00a7
        L_0x00a6:
            return r0
        L_0x00a7:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
