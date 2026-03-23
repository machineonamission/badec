package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$3", f = "DeviceDetailsViewModel.kt", i = {}, l = {326, 326}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceDetailsViewModel.kt */
final class DeviceDetailsViewModel$updateEverything$1$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    int label;
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceDetailsViewModel$updateEverything$1$1$3(Device device, DeviceDetailsViewModel deviceDetailsViewModel, Continuation<? super DeviceDetailsViewModel$updateEverything$1$1$3> continuation) {
        super(2, continuation);
        this.$device = device;
        this.this$0 = deviceDetailsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceDetailsViewModel$updateEverything$1$1$3(this.$device, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceDetailsViewModel$updateEverything$1$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x006c, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onSuccess((io.flatcircle.coroutinehelper.ApiResult) r7, new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$3.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$3.AnonymousClass1>) null), r6) == r0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0052, code lost:
        if (r7 == r0) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006f
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "check device connectivity status: "
            r1.<init>(r4)
            com.blueair.core.model.Device r4 = r6.$device
            java.lang.String r4 = r4.getUid()
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r7.d(r1, r4)
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r7 = r6.this$0
            com.blueair.devicemanager.DeviceManager r7 = r7.getDeviceManager()
            com.blueair.core.model.Device r1 = r6.$device
            java.lang.String r1 = r1.getUid()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r7 = r7.getBlueDeviceStatus(r1, r4)
            if (r7 != r0) goto L_0x0055
            goto L_0x006e
        L_0x0055:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$3$1 r1 = new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$3$1
            com.blueair.core.model.Device r3 = r6.$device
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r4 = r6.this$0
            r5 = 0
            r1.<init>(r3, r4, r5)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r6.label = r2
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r1, r3)
            if (r7 != r0) goto L_0x006f
        L_0x006e:
            return r0
        L_0x006f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$updateEverything$1$1$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
