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
@DebugMetadata(c = "com.blueair.graph.viewmodel.GraphViewModel$updateHistorical$1", f = "GraphViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraphViewModel.kt */
final class GraphViewModel$updateHistorical$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphState $nuState;
    final /* synthetic */ List<Entry> $reducedDataPoints;
    int label;
    final /* synthetic */ GraphViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphViewModel$updateHistorical$1(GraphViewModel graphViewModel, GraphState graphState, List<? extends Entry> list, Continuation<? super GraphViewModel$updateHistorical$1> continuation) {
        super(2, continuation);
        this.this$0 = graphViewModel;
        this.$nuState = graphState;
        this.$reducedDataPoints = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphViewModel$updateHistorical$1(this.this$0, this.$nuState, this.$reducedDataPoints, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphViewModel$updateHistorical$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.updateState(GraphState.copy$default(this.$nuState, (List) null, (List) null, (List) null, (List) null, this.$reducedDataPoints, (Set) null, (Entry) null, 0, 0, (ChartTimeScale) null, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65519, (Object) null), true);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
