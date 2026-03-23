package com.blueair.devicemanager;

import com.blueair.core.model.HasAblCloudFunctions;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$Companion$getIsUpdatingForAllDevices$isUpdatingJobs$1$1", f = "DeviceManager.kt", i = {}, l = {2587}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$Companion$getIsUpdatingForAllDevices$isUpdatingJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<Boolean>>, Object> {
    final /* synthetic */ DeviceManager $deviceManager;
    final /* synthetic */ HasAblCloudFunctions $it;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$Companion$getIsUpdatingForAllDevices$isUpdatingJobs$1$1(DeviceManager deviceManager, HasAblCloudFunctions hasAblCloudFunctions, Continuation<? super DeviceManager$Companion$getIsUpdatingForAllDevices$isUpdatingJobs$1$1> continuation) {
        super(2, continuation);
        this.$deviceManager = deviceManager;
        this.$it = hasAblCloudFunctions;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$Companion$getIsUpdatingForAllDevices$isUpdatingJobs$1$1(this.$deviceManager, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<Boolean>> continuation) {
        return ((DeviceManager$Companion$getIsUpdatingForAllDevices$isUpdatingJobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object access$getIsUpdating = this.$deviceManager.getIsUpdating(this.$it, this);
            return access$getIsUpdating == coroutine_suspended ? coroutine_suspended : access$getIsUpdating;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
