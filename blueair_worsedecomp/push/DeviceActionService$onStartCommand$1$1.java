package com.blueair.push;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.push.DeviceActionService$onStartCommand$1$1", f = "DeviceActionService.kt", i = {1, 2}, l = {40, 42, 42}, m = "invokeSuspend", n = {"device", "device"}, s = {"L$0", "L$0"})
/* compiled from: DeviceActionService.kt */
final class DeviceActionService$onStartCommand$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ int $notificationId;
    Object L$0;
    int label;
    final /* synthetic */ DeviceActionService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceActionService$onStartCommand$1$1(DeviceActionService deviceActionService, String str, int i, Continuation<? super DeviceActionService$onStartCommand$1$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceActionService;
        this.$deviceId = str;
        this.$notificationId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceActionService$onStartCommand$1$1(this.this$0, this.$deviceId, this.$notificationId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceActionService$onStartCommand$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (r8 == r0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (r8 == r0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0083, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r8, new com.blueair.push.DeviceActionService$onStartCommand$1$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.push.DeviceActionService$onStartCommand$1$1.AnonymousClass1>) null), r7) == r0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r4) goto L_0x0029
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            java.lang.Object r0 = r7.L$0
            com.blueair.core.model.Device r0 = (com.blueair.core.model.Device) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0086
        L_0x0019:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0021:
            java.lang.Object r1 = r7.L$0
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0066
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0044
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.push.DeviceActionService r8 = r7.this$0
            com.blueair.devicemanager.DeviceManager r8 = r8.getDeviceManager()
            java.lang.String r1 = r7.$deviceId
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r7.label = r4
            java.lang.Object r8 = r8.getDatabaseDevice(r1, r5)
            if (r8 != r0) goto L_0x0044
            goto L_0x0085
        L_0x0044:
            r1 = r8
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            boolean r8 = r1 instanceof com.blueair.core.model.HasAlarm
            if (r8 == 0) goto L_0x0086
            com.blueair.push.DeviceActionService r8 = r7.this$0
            com.blueair.devicemanager.DeviceManager r8 = r8.getDeviceManager()
            r4 = r1
            com.blueair.core.model.HasAlarm r4 = (com.blueair.core.model.HasAlarm) r4
            r5 = r7
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r7.L$0 = r6
            r7.label = r3
            java.lang.Object r8 = r8.stopAlarm(r4, r5)
            if (r8 != r0) goto L_0x0066
            goto L_0x0085
        L_0x0066:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            com.blueair.push.DeviceActionService$onStartCommand$1$1$1 r3 = new com.blueair.push.DeviceActionService$onStartCommand$1$1$1
            com.blueair.push.DeviceActionService r4 = r7.this$0
            int r5 = r7.$notificationId
            r6 = 0
            r3.<init>(r4, r5, r6)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r8 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r8, r3, r4)
            if (r8 != r0) goto L_0x0086
        L_0x0085:
            return r0
        L_0x0086:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.push.DeviceActionService$onStartCommand$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
