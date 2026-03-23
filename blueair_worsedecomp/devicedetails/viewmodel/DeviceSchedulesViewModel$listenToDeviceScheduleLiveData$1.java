package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1", f = "DeviceSchedulesViewModel.kt", i = {1}, l = {24, 25}, m = "invokeSuspend", n = {"mergedSchedules"}, s = {"L$0"})
/* compiled from: DeviceSchedulesViewModel.kt */
final class DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DeviceSchedulesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1(DeviceSchedulesViewModel deviceSchedulesViewModel, Continuation<? super DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceSchedulesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0064, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(r1, new com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1.AnonymousClass1>) null), r6) == r0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0066, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        if (r7 == r0) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r6.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0041
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r7 = r6.this$0
            com.blueair.devicemanager.DeviceScheduleService r7 = r7.getDeviceScheduleService()
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r1 = r6.this$0
            com.blueair.core.model.Device r1 = r1.getDevice()
            java.lang.String r1 = r1.getUid()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r7 = r7.getSchedulesFor(r1, r4)
            if (r7 != r0) goto L_0x0041
            goto L_0x0066
        L_0x0041:
            java.util.List r7 = (java.util.List) r7
            kotlinx.coroutines.CoroutineScope r1 = kotlinx.coroutines.CoroutineScopeKt.MainScope()
            kotlin.coroutines.CoroutineContext r1 = r1.getCoroutineContext()
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1$1 r3 = new com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1$1
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r4 = r6.this$0
            r5 = 0
            r3.<init>(r4, r7, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$0 = r7
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4)
            if (r7 != r0) goto L_0x0067
        L_0x0066:
            return r0
        L_0x0067:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$listenToDeviceScheduleLiveData$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
