package com.blueair.devicemanager;

import com.blueair.api.ConnectionManager;
import com.blueair.core.model.DataTrend;
import com.blueair.core.model.Device;
import com.blueair.core.model.Filter;
import com.blueair.database.DeviceField;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$setFilter$2", f = "DeviceManager.kt", i = {0, 0}, l = {2103}, m = "invokeSuspend", n = {"connection", "nuValue"}, s = {"L$0", "L$1"})
/* compiled from: DeviceManager.kt */
final class DeviceManager$setFilter$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $device;
    final /* synthetic */ Filter $nuFilter;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$setFilter$2(DeviceManager deviceManager, Device device, Filter filter, Continuation<? super DeviceManager$setFilter$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$device = device;
        this.$nuFilter = filter;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceManager$setFilter$2(this.this$0, this.$device, this.$nuFilter, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceManager$setFilter$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConnectionManager access$connection = this.this$0.connection(this.$device.getUid());
            if (access$connection == null) {
                return Unit.INSTANCE;
            }
            String serverValue = Filter.Companion.toServerValue(this.$nuFilter);
            DeviceManager.updateDeviceFieldAsync$default(this.this$0, this.$device.getUid(), DeviceField.FilterType.INSTANCE, serverValue, (DataTrend) null, 8, (Object) null);
            this.L$0 = SpillingKt.nullOutSpilledVariable(access$connection);
            this.L$1 = SpillingKt.nullOutSpilledVariable(serverValue);
            this.label = 1;
            if (access$connection.setFilterType(serverValue, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            String str = (String) this.L$1;
            ConnectionManager connectionManager = (ConnectionManager) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
