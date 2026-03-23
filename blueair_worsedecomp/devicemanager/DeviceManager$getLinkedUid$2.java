package com.blueair.devicemanager;

import com.blueair.core.model.DataTrend;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.database.DeviceField;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$getLinkedUid$2", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$getLinkedUid$2 extends SuspendLambda implements Function2<List<? extends String>, Continuation<? super Unit>, Object> {
    final /* synthetic */ HasLinkingCapability $device;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$getLinkedUid$2(DeviceManager deviceManager, HasLinkingCapability hasLinkingCapability, Continuation<? super DeviceManager$getLinkedUid$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = hasLinkingCapability;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$getLinkedUid$2 deviceManager$getLinkedUid$2 = new DeviceManager$getLinkedUid$2(this.this$0, this.$device, continuation);
        deviceManager$getLinkedUid$2.L$0 = obj;
        return deviceManager$getLinkedUid$2;
    }

    public final Object invoke(List<String> list, Continuation<? super Unit> continuation) {
        return ((DeviceManager$getLinkedUid$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager.updateDeviceFieldAsync$default(this.this$0, this.$device.getUid(), DeviceField.LinkedDeviceUid.INSTANCE, CollectionsKt.firstOrNull(list), (DataTrend) null, 8, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
