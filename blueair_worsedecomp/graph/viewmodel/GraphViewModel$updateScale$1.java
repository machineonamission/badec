package com.blueair.graph.viewmodel;

import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.graph.utils.ChartTimeScale;
import com.blueair.graph.utils.MpChartUtils;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.graph.viewmodel.GraphViewModel$updateScale$1", f = "GraphViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GraphViewModel.kt */
final class GraphViewModel$updateScale$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChartTimeScale $nuTimeScale;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GraphViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphViewModel$updateScale$1(GraphViewModel graphViewModel, ChartTimeScale chartTimeScale, Continuation<? super GraphViewModel$updateScale$1> continuation) {
        super(2, continuation);
        this.this$0 = graphViewModel;
        this.$nuTimeScale = chartTimeScale;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GraphViewModel$updateScale$1 graphViewModel$updateScale$1 = new GraphViewModel$updateScale$1(this.this$0, this.$nuTimeScale, continuation);
        graphViewModel$updateScale$1.L$0 = obj;
        return graphViewModel$updateScale$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphViewModel$updateScale$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<Entry> list;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final GraphState copy$default = GraphState.copy$default((GraphState) this.this$0.getState(), (List) null, (List) null, (List) null, (List) null, (List) null, (Set) null, (Entry) null, 0, 0, this.$nuTimeScale, 0, 0, (List) null, false, 0, (IndoorAirRatingRanges) null, 65023, (Object) null);
            List<Entry> graphHistoricalDataPoints = copy$default.getGraphHistoricalDataPoints();
            if (graphHistoricalDataPoints != null) {
                list = MpChartUtils.INSTANCE.reduceWithDouglasPeucker((List<? extends Entry>) graphHistoricalDataPoints, this.$nuTimeScale);
            } else {
                list = null;
            }
            if (list == null || Intrinsics.areEqual((Object) list, (Object) copy$default.getGraphReducedHistoricalDataPoints())) {
                final GraphViewModel graphViewModel = this.this$0;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            } else {
                this.this$0.updateGraphDataPoints(list, false, copy$default);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.graph.viewmodel.GraphViewModel$updateScale$1$1", f = "GraphViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.graph.viewmodel.GraphViewModel$updateScale$1$1  reason: invalid class name */
    /* compiled from: GraphViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(graphViewModel, copy$default, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                graphViewModel.updateState(copy$default, true);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
