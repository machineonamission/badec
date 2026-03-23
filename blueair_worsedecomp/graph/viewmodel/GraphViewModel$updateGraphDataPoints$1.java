package com.blueair.graph.viewmodel;

import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.utils.ChartTimeScale;
import com.github.mikephil.charting.data.Entry;
import java.util.List;
import java.util.Set;
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
@DebugMetadata(c = "com.blueair.graph.viewmodel.GraphViewModel$updateGraphDataPoints$1", f = "GraphViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraphViewModel.kt */
final class GraphViewModel$updateGraphDataPoints$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Entry> $combinedRelativeTimedDataPoints;
    final /* synthetic */ long $latestTimeInMillis;
    final /* synthetic */ List<Entry> $nuGraphRealTimeDataPoints;
    final /* synthetic */ List<Entry> $nuGraphReducedHistoricalDataPoints;
    final /* synthetic */ GraphState $nuState;
    final /* synthetic */ long $startingTimeInMillis;
    int label;
    final /* synthetic */ GraphViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphViewModel$updateGraphDataPoints$1(GraphViewModel graphViewModel, GraphState graphState, List<? extends Entry> list, List<? extends Entry> list2, List<? extends Entry> list3, long j, long j2, Continuation<? super GraphViewModel$updateGraphDataPoints$1> continuation) {
        super(2, continuation);
        this.this$0 = graphViewModel;
        this.$nuState = graphState;
        this.$nuGraphReducedHistoricalDataPoints = list;
        this.$nuGraphRealTimeDataPoints = list2;
        this.$combinedRelativeTimedDataPoints = list3;
        this.$startingTimeInMillis = j;
        this.$latestTimeInMillis = j2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphViewModel$updateGraphDataPoints$1(this.this$0, this.$nuState, this.$nuGraphReducedHistoricalDataPoints, this.$nuGraphRealTimeDataPoints, this.$combinedRelativeTimedDataPoints, this.$startingTimeInMillis, this.$latestTimeInMillis, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphViewModel$updateGraphDataPoints$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateState(GraphState.copy$default(this.$nuState, (List) null, this.$nuGraphReducedHistoricalDataPoints, this.$nuGraphRealTimeDataPoints, this.$combinedRelativeTimedDataPoints, (List) null, (Set) null, (Entry) null, this.$startingTimeInMillis, this.$latestTimeInMillis, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65137, (Object) null), true);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
