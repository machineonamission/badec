package com.blueair.devicemanager;

import com.blueair.core.model.HasAblCloudFunctions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1", f = "DeviceManager.kt", i = {1, 1}, l = {2633, 2638}, m = "invokeSuspend", n = {"response", "$i$a$-let-DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1$1"}, s = {"L$0", "I$0"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasAblCloudFunctions $device;
    final /* synthetic */ DeviceManager $deviceManager;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1(DeviceManager deviceManager, HasAblCloudFunctions hasAblCloudFunctions, Continuation<? super DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1> continuation) {
        super(2, continuation);
        this.$deviceManager = deviceManager;
        this.$device = hasAblCloudFunctions;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1(this.$deviceManager, this.$device, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        if (r4.startMigrationOtaPolling(r3, r1, r6) == r0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0087, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0037, code lost:
        if (r7 == r0) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r6.L$0
            com.blueair.core.model.MigrationOtaResponse r0 = (com.blueair.core.model.MigrationOtaResponse) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0088
        L_0x0017:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003a
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r7)
            com.blueair.devicemanager.DeviceManager r7 = r6.$deviceManager
            com.blueair.core.model.HasAblCloudFunctions r1 = r6.$device
            java.lang.String r1 = r1.getUid()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.label = r3
            java.lang.Object r7 = r7.isMigrationOtaRunning(r1, r4)
            if (r7 != r0) goto L_0x003a
            goto L_0x0087
        L_0x003a:
            io.flatcircle.coroutinehelper.ApiResult r7 = (io.flatcircle.coroutinehelper.ApiResult) r7
            java.lang.Object r7 = r7.getOrNull()
            com.blueair.core.model.MigrationOtaResponse r7 = (com.blueair.core.model.MigrationOtaResponse) r7
            if (r7 == 0) goto L_0x008b
            com.blueair.core.model.HasAblCloudFunctions r1 = r6.$device
            com.blueair.devicemanager.DeviceManager r3 = r6.$deviceManager
            java.lang.String r4 = r7.getCompatibility()
            java.lang.String r5 = "foobot"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x005a
            boolean r4 = r7.isUpgrading()
            if (r4 != 0) goto L_0x0070
        L_0x005a:
            java.lang.String r4 = r7.getCompatibility()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x0088
            boolean r4 = r7.isUpgrading()
            if (r4 == 0) goto L_0x0088
            boolean r4 = r1.getHasAtLeastMinimumFirmwareVersion()
            if (r4 != 0) goto L_0x0088
        L_0x0070:
            com.blueair.devicemanager.DeviceManager$Companion r4 = com.blueair.devicemanager.DeviceManager.Companion
            java.lang.String r1 = r1.getUid()
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$0 = r7
            r7 = 0
            r6.I$0 = r7
            r6.label = r2
            java.lang.Object r7 = r4.startMigrationOtaPolling(r3, r1, r6)
            if (r7 != r0) goto L_0x0088
        L_0x0087:
            return r0
        L_0x0088:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x008b:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicemanager.DeviceManager$Companion$updateMigrationOtaState$migrationCheckJobs$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
