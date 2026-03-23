package com.blueair.adddevice.fragment.legacy;

import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.devicemanager.DeviceManager;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1", f = "AddDeviceProgressFragment.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceProgressFragment.kt */
final class AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ DeviceInformationLegacy $it;
    Object L$0;
    int label;
    final /* synthetic */ AddDeviceProgressFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1(AddDeviceProgressFragment addDeviceProgressFragment, DeviceInformationLegacy deviceInformationLegacy, Continuation<? super AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1> continuation) {
        super(1, continuation);
        this.this$0 = addDeviceProgressFragment;
        this.$it = deviceInformationLegacy;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(Continuation<? super Boolean> continuation) {
        return ((AddDeviceProgressFragment$handleOTAUpdateCheck$1$2$1$legacyOta$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DeviceManager deviceManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager deviceManager2 = this.this$0.getDeviceManager();
            this.L$0 = deviceManager2;
            this.label = 1;
            Object isMigrationOtaRunning = this.this$0.getDeviceManager().isMigrationOtaRunning(this.$it.getId(), this);
            if (isMigrationOtaRunning == coroutine_suspended) {
                return coroutine_suspended;
            }
            deviceManager = deviceManager2;
            obj = isMigrationOtaRunning;
        } else if (i == 1) {
            deviceManager = (DeviceManager) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Boxing.boxBoolean(deviceManager.isProbablyInMigrationOta((ApiResult) obj));
    }
}
