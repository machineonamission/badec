package com.blueair.devicemanager;

import com.blueair.core.model.HasLinkingCapability;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lio/flatcircle/coroutinehelper/ApiResult;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$Companion$getDeviceLinkForDevicesWithLinkingCapability$linksJobs$1$1", f = "DeviceManager.kt", i = {}, l = {2621}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$Companion$getDeviceLinkForDevicesWithLinkingCapability$linksJobs$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<List<? extends String>>>, Object> {
    final /* synthetic */ DeviceManager $deviceManager;
    final /* synthetic */ HasLinkingCapability $it;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$Companion$getDeviceLinkForDevicesWithLinkingCapability$linksJobs$1$1(DeviceManager deviceManager, HasLinkingCapability hasLinkingCapability, Continuation<? super DeviceManager$Companion$getDeviceLinkForDevicesWithLinkingCapability$linksJobs$1$1> continuation) {
        super(2, continuation);
        this.$deviceManager = deviceManager;
        this.$it = hasLinkingCapability;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$Companion$getDeviceLinkForDevicesWithLinkingCapability$linksJobs$1$1(this.$deviceManager, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<List<String>>> continuation) {
        return ((DeviceManager$Companion$getDeviceLinkForDevicesWithLinkingCapability$linksJobs$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object linkedUid = this.$deviceManager.getLinkedUid(this.$it, this);
            return linkedUid == coroutine_suspended ? coroutine_suspended : linkedUid;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
