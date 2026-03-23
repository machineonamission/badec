package com.blueair.devicemanager;

import com.blueair.core.model.DeviceDetailsOnAblServer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$initNewDevice$1", f = "DeviceManager.kt", i = {}, l = {1791, 1796}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$initNewDevice$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceDetailsOnAblServer $device;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$initNewDevice$1(DeviceManager deviceManager, DeviceDetailsOnAblServer deviceDetailsOnAblServer, Continuation<? super DeviceManager$initNewDevice$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = deviceDetailsOnAblServer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$initNewDevice$1(this.this$0, this.$device, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$initNewDevice$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
        if (r6 == r0) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r5.this$0.getUserAblClient().resetAttributes(r5.$device.getUuid(), r5) == r0) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x006f
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0039
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0
            com.blueair.api.client.UserDevicesAblClient r6 = r6.getUserAblClient()
            com.blueair.core.model.DeviceDetailsOnAblServer r1 = r5.$device
            java.lang.String r1 = r1.getUuid()
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.label = r3
            java.lang.Object r6 = r6.resetAttributes(r1, r4)
            if (r6 != r0) goto L_0x0039
            goto L_0x006e
        L_0x0039:
            com.blueair.core.model.DeviceType$Companion r6 = com.blueair.core.model.DeviceType.Companion
            com.blueair.core.model.DeviceDetailsOnAblServer r1 = r5.$device
            java.lang.String r1 = r1.getCompatibility()
            com.blueair.core.model.DeviceType r6 = r6.fromSkuCompat(r1)
            com.blueair.core.model.DeviceType$ClassicWithoutSensor r1 = com.blueair.core.model.DeviceType.ClassicWithoutSensor.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r1 != 0) goto L_0x0055
            com.blueair.core.model.DeviceType$Sense r1 = com.blueair.core.model.DeviceType.Sense.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x0071
        L_0x0055:
            com.blueair.devicemanager.DeviceManager r6 = r5.this$0
            com.blueair.core.model.DeviceDetailsOnAblServer r1 = r5.$device
            java.lang.String r1 = r1.getUuid()
            com.blueair.api.ConnectionManager r6 = r6.connection(r1)
            if (r6 == 0) goto L_0x0071
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r2
            java.lang.Object r6 = r6.resetAutoModeDependency(r1)
            if (r6 != r0) goto L_0x006f
        L_0x006e:
            return r0
        L_0x006f:
            io.flatcircle.coroutinehelper.ApiResult r6 = (io.flatcircle.coroutinehelper.ApiResult) r6
        L_0x0071:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceManager$initNewDevice$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
