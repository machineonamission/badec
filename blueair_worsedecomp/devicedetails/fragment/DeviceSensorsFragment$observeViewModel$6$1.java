package com.blueair.devicedetails.fragment;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsBinding;
import com.blueair.graph.view.GraphView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceSensorsFragment$observeViewModel$6$1", f = "DeviceSensorsFragment.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSensorsFragment.kt */
final class DeviceSensorsFragment$observeViewModel$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphView.SelectedPoint $it;
    int label;
    final /* synthetic */ DeviceSensorsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSensorsFragment$observeViewModel$6$1(GraphView.SelectedPoint selectedPoint, DeviceSensorsFragment deviceSensorsFragment, Continuation<? super DeviceSensorsFragment$observeViewModel$6$1> continuation) {
        super(2, continuation);
        this.$it = selectedPoint;
        this.this$0 = deviceSensorsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSensorsFragment$observeViewModel$6$1(this.$it, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSensorsFragment$observeViewModel$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        FragmentDeviceSensorsBinding fragmentDeviceSensorsBinding = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1(this.this$0, this.$it, (Continuation<? super DeviceSensorsFragment$observeViewModel$6$1$indoorDataPoint$1>) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IndoorDatapoint indoorDatapoint = (IndoorDatapoint) obj;
        Timber.Forest forest = Timber.Forest;
        forest.d("deviceGraph.liveSelectedDataPoint: explicit = " + this.$it.getExplicit() + ", graph = " + this.$it.getPoint() + " ; indoorDataPoint = " + indoorDatapoint, new Object[0]);
        DeviceSensorsFragment.updateTabs$default(this.this$0, indoorDatapoint, (AqiData) null, 2, (Object) null);
        if (this.this$0.getViewModel().getShowFanHistory() && this.$it.getExplicit()) {
            FragmentDeviceSensorsBinding access$getViewDataBinding$p = this.this$0.viewDataBinding;
            if (access$getViewDataBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentDeviceSensorsBinding = access$getViewDataBinding$p;
            }
            fragmentDeviceSensorsBinding.fanGraph.gotoTime(this.$it.getPoint().getTimeInMillis());
        }
        return Unit.INSTANCE;
    }
}
