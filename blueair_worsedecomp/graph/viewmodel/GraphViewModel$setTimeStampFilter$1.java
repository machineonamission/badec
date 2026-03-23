package com.blueair.graph.viewmodel;

import com.github.mikephil.charting.data.Entry;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.graph.viewmodel.GraphViewModel$setTimeStampFilter$1", f = "GraphViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraphViewModel.kt */
final class GraphViewModel$setTimeStampFilter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Entry> $graphHistoricalDataPoints;
    final /* synthetic */ List<Entry> $graphRealTimeDataPoints;
    final /* synthetic */ GraphState $nuState;
    int label;
    final /* synthetic */ GraphViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphViewModel$setTimeStampFilter$1(List<? extends Entry> list, GraphViewModel graphViewModel, GraphState graphState, List<? extends Entry> list2, Continuation<? super GraphViewModel$setTimeStampFilter$1> continuation) {
        super(2, continuation);
        this.$graphHistoricalDataPoints = list;
        this.this$0 = graphViewModel;
        this.$nuState = graphState;
        this.$graphRealTimeDataPoints = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphViewModel$setTimeStampFilter$1(this.$graphHistoricalDataPoints, this.this$0, this.$nuState, this.$graphRealTimeDataPoints, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphViewModel$setTimeStampFilter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List<Entry> list = this.$graphHistoricalDataPoints;
            if (list != null) {
                this.this$0.updateGraphDataPoints(list, false, this.$nuState);
            } else {
                List<Entry> list2 = this.$graphRealTimeDataPoints;
                if (list2 != null) {
                    this.this$0.updateGraphDataPoints(list2, true, this.$nuState);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
