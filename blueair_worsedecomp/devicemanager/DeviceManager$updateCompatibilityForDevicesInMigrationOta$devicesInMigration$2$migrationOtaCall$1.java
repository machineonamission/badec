package com.blueair.devicemanager;

import com.blueair.core.model.DeviceDetailsOnAblServer;
import com.blueair.core.model.MigrationOtaResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/core/model/MigrationOtaResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$updateCompatibilityForDevicesInMigrationOta$devicesInMigration$2$migrationOtaCall$1", f = "DeviceManager.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$updateCompatibilityForDevicesInMigrationOta$devicesInMigration$2$migrationOtaCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<MigrationOtaResponse>>, Object> {
    final /* synthetic */ DeviceDetailsOnAblServer $it;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$updateCompatibilityForDevicesInMigrationOta$devicesInMigration$2$migrationOtaCall$1(DeviceManager deviceManager, DeviceDetailsOnAblServer deviceDetailsOnAblServer, Continuation<? super DeviceManager$updateCompatibilityForDevicesInMigrationOta$devicesInMigration$2$migrationOtaCall$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$it = deviceDetailsOnAblServer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$updateCompatibilityForDevicesInMigrationOta$devicesInMigration$2$migrationOtaCall$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<MigrationOtaResponse>> continuation) {
        return ((DeviceManager$updateCompatibilityForDevicesInMigrationOta$devicesInMigration$2$migrationOtaCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object isMigrationOtaRunning = this.this$0.getUserAblClient().isMigrationOtaRunning(this.$it.getUuid(), this);
            return isMigrationOtaRunning == coroutine_suspended ? coroutine_suspended : isMigrationOtaRunning;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
