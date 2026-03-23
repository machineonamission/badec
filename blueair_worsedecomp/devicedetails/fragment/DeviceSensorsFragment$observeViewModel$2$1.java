package com.blueair.devicedetails.fragment;

import com.blueair.core.model.SimpleDatapoint;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsBinding;
import com.blueair.graph.view.IndoorGraphView;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.fragment.DeviceSensorsFragment$observeViewModel$2$1", f = "DeviceSensorsFragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSensorsFragment.kt */
final class DeviceSensorsFragment$observeViewModel$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<SimpleDatapoint> $data;
    int label;
    final /* synthetic */ DeviceSensorsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSensorsFragment$observeViewModel$2$1(DeviceSensorsFragment deviceSensorsFragment, List<SimpleDatapoint> list, Continuation<? super DeviceSensorsFragment$observeViewModel$2$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceSensorsFragment;
        this.$data = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSensorsFragment$observeViewModel$2$1(this.this$0, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSensorsFragment$observeViewModel$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FragmentDeviceSensorsBinding access$getViewDataBinding$p = this.this$0.viewDataBinding;
            if (access$getViewDataBinding$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                access$getViewDataBinding$p = null;
            }
            IndoorGraphView indoorGraphView = access$getViewDataBinding$p.deviceGraph;
            List<SimpleDatapoint> list = this.$data;
            Intrinsics.checkNotNull(list);
            this.label = 1;
            if (indoorGraphView.updateHistorical(list, this.this$0.getViewModel().isTempCelsius(), this.this$0.getViewModel().getIndoorAirRatings(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
