package com.blueair.devicemanager;

import com.blueair.core.model.DeviceDetailsOnAblServer;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getAblDevicesAsync$2", f = "DeviceManager.kt", i = {}, l = {494, 494, 494}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getAblDevicesAsync$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<List<? extends DeviceDetailsOnAblServer>>>, Object> {
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getAblDevicesAsync$2(DeviceManager deviceManager, Continuation<? super DeviceManager$getAblDevicesAsync$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$getAblDevicesAsync$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<List<DeviceDetailsOnAblServer>>> continuation) {
        return ((DeviceManager$getAblDevicesAsync$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r7 == r0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        if (r7 == r0) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r5) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r7)
            return r7
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003b
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.devicemanager.DeviceManager r7 = r6.this$0
            com.blueair.api.client.UserDevicesAblClient r7 = r7.getUserAblClient()
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r5
            java.lang.Object r7 = r7.getDevices(r1)
            if (r7 != r0) goto L_0x003b
            goto L_0x0066
        L_0x003b:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.devicemanager.DeviceManager$getAblDevicesAsync$2$1 r1 = new com.blueair.devicemanager.DeviceManager$getAblDevicesAsync$2$1
            com.blueair.devicemanager.DeviceManager r5 = r6.this$0
            r1.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r4
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r7, r1, r5)
            if (r7 != r0) goto L_0x0052
            goto L_0x0066
        L_0x0052:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            com.blueair.devicemanager.DeviceManager$getAblDevicesAsync$2$2 r1 = new com.blueair.devicemanager.DeviceManager$getAblDevicesAsync$2$2
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r6.label = r3
            java.lang.Object r7 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r7, r1, r2)
            if (r7 != r0) goto L_0x0067
        L_0x0066:
            return r0
        L_0x0067:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceManager$getAblDevicesAsync$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
