package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$getLatestDevice$1", f = "DeviceSchedulesViewModel.kt", i = {}, l = {42, 43}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSchedulesViewModel.kt */
final class DeviceSchedulesViewModel$getLatestDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Device, Unit> $onResult;
    Object L$0;
    int label;
    final /* synthetic */ DeviceSchedulesViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSchedulesViewModel$getLatestDevice$1(DeviceSchedulesViewModel deviceSchedulesViewModel, Function1<? super Device, Unit> function1, Continuation<? super DeviceSchedulesViewModel$getLatestDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceSchedulesViewModel;
        this.$onResult = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSchedulesViewModel$getLatestDevice$1(this.this$0, this.$onResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSchedulesViewModel$getLatestDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006d, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$getLatestDevice$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$getLatestDevice$1.AnonymousClass1>) null), r6) == r0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r7 == r0) goto L_0x006f;
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
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0070
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r1 = (com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0043
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r1 = r6.this$0
            com.blueair.devicemanager.DeviceManager r7 = r1.getDeviceManager()
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r4 = r6.this$0
            com.blueair.core.model.Device r4 = r4.getDevice()
            java.lang.String r4 = r4.getUid()
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.getDatabaseDevice(r4, r5)
            if (r7 != r0) goto L_0x0043
            goto L_0x006f
        L_0x0043:
            com.blueair.core.model.Device r7 = (com.blueair.core.model.Device) r7
            if (r7 != 0) goto L_0x004d
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r7 = r6.this$0
            com.blueair.core.model.Device r7 = r7.getDevice()
        L_0x004d:
            r1.setDevice(r7)
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$getLatestDevice$1$1 r1 = new com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$getLatestDevice$1$1
            kotlin.jvm.functions.Function1<com.blueair.core.model.Device, kotlin.Unit> r3 = r6.$onResult
            com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel r4 = r6.this$0
            r5 = 0
            r1.<init>(r3, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.L$0 = r5
            r6.label = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r3)
            if (r7 != r0) goto L_0x0070
        L_0x006f:
            return r0
        L_0x0070:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel$getLatestDevice$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
