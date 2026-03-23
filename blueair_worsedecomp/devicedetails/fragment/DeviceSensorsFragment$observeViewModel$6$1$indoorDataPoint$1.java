package com.blueair.devicedetails.fragment;

import com.blueair.core.model.IndoorDatapoint;
import com.blueair.graph.view.GraphView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/blueair/core/model/IndoorDatapoint;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1", f = "DeviceSensorsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSensorsFragment.kt */
final class DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IndoorDatapoint>, Object> {
    final /* synthetic */ GraphView.SelectedPoint $it;
    int label;
    final /* synthetic */ DeviceSensorsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1(DeviceSensorsFragment deviceSensorsFragment, GraphView.SelectedPoint selectedPoint, Continuation<? super DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceSensorsFragment;
        this.$it = selectedPoint;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IndoorDatapoint> continuation) {
        return ((DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getIndoorDataForTimestamp(this.$it.getPoint().getTimeInSeconds());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
