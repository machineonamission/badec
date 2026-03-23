package com.blueair.graph.view;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.graph.view.GraphViewV2$setupXAxisLines$1", f = "GraphViewV2.kt", i = {2, 2, 2, 2}, l = {643, 645, 679}, m = "invokeSuspend", n = {"lines", "minimumTime", "xLabelStepInMills", "dividerTime"}, s = {"L$0", "L$1", "J$0", "J$1"})
/* compiled from: GraphViewV2.kt */
final class GraphViewV2$setupXAxisLines$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAppend;
    final /* synthetic */ Job $previousJob;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GraphViewV2 this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewV2.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.graph.utils.ChartTimeScale[] r0 = com.blueair.graph.utils.ChartTimeScale.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.MONTH     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.graph.utils.ChartTimeScale r1 = com.blueair.graph.utils.ChartTimeScale.DAY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphViewV2$setupXAxisLines$1(Job job, boolean z, GraphViewV2 graphViewV2, Continuation<? super GraphViewV2$setupXAxisLines$1> continuation) {
        super(2, continuation);
        this.$previousJob = job;
        this.$isAppend = z;
        this.this$0 = graphViewV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphViewV2$setupXAxisLines$1(this.$previousJob, this.$isAppend, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphViewV2$setupXAxisLines$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r2, r0) == r1) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.AnonymousClass1>) null), r0) == r1) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01b9, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.AnonymousClass4((kotlin.coroutines.Continuation<? super com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.AnonymousClass4>) null), r0) == r1) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01bb, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r6) goto L_0x002d
            if (r2 == r5) goto L_0x0029
            if (r2 != r4) goto L_0x0021
            java.lang.Object r1 = r0.L$1
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r1 = r0.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x01bc
        L_0x0021:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0065
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0045
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r19)
            kotlinx.coroutines.Job r2 = r0.$previousJob
            if (r2 == 0) goto L_0x0045
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.label = r6
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r7)
            if (r2 != r1) goto L_0x0045
            goto L_0x01bb
        L_0x0045:
            boolean r2 = r0.$isAppend
            if (r2 != 0) goto L_0x0065
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.blueair.graph.view.GraphViewV2$setupXAxisLines$1$1 r7 = new com.blueair.graph.view.GraphViewV2$setupXAxisLines$1$1
            com.blueair.graph.view.GraphViewV2 r8 = r0.this$0
            r7.<init>(r8, r3)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r7, r8)
            if (r2 != r1) goto L_0x0065
            goto L_0x01bb
        L_0x0065:
            com.blueair.graph.view.GraphViewV2 r2 = r0.this$0
            long r7 = r2.zeroTime
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x0074
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0074:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            com.blueair.graph.view.GraphViewV2 r7 = r0.this$0
            com.blueair.graph.utils.ChartTimeScale r7 = r7.getTimeScale()
            int[] r8 = com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r6) goto L_0x009d
            if (r7 == r5) goto L_0x0099
            if (r7 != r4) goto L_0x0093
            r7 = 3600000(0x36ee80, double:1.7786363E-317)
            goto L_0x00a0
        L_0x0093:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0099:
            r7 = 259200000(0xf731400, double:1.280618154E-315)
            goto L_0x00a0
        L_0x009d:
            r7 = 864000000(0x337f9800, double:4.26872718E-315)
        L_0x00a0:
            com.blueair.graph.view.GraphViewV2 r5 = r0.this$0
            long r9 = r5.rawEndTime
            com.blueair.graph.view.GraphViewV2 r5 = r0.this$0
            long r11 = r5.rawEndTime
            r5 = 3600000(0x36ee80, float:5.044674E-39)
            long r13 = (long) r5
            long r11 = r11 % r13
            long r9 = r9 - r11
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            com.blueair.graph.view.GraphViewV2 r11 = r0.this$0
            long r11 = r11.zeroTime
            r13 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r11 = r11 - r13
            r5.element = r11
            boolean r11 = r0.$isAppend
            r12 = 5000(0x1388, float:7.006E-42)
            if (r11 == 0) goto L_0x0125
            com.blueair.graph.view.GraphViewV2 r11 = r0.this$0
            com.github.mikephil.charting.charts.LineChart r11 = r11.chart
            com.github.mikephil.charting.components.XAxis r11 = r11.getXAxis()
            java.util.List r11 = r11.getLimitLines()
            java.lang.String r13 = "getLimitLines(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            boolean r13 = r11.hasNext()
            if (r13 != 0) goto L_0x00ec
            r11 = r3
            goto L_0x010f
        L_0x00ec:
            java.lang.Object r13 = r11.next()
            com.github.mikephil.charting.components.LimitLine r13 = (com.github.mikephil.charting.components.LimitLine) r13
            float r13 = r13.getLimit()
        L_0x00f6:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x010b
            java.lang.Object r14 = r11.next()
            com.github.mikephil.charting.components.LimitLine r14 = (com.github.mikephil.charting.components.LimitLine) r14
            float r14 = r14.getLimit()
            float r13 = java.lang.Math.max(r13, r14)
            goto L_0x00f6
        L_0x010b:
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r13)
        L_0x010f:
            if (r11 == 0) goto L_0x0125
            com.blueair.graph.view.GraphViewV2 r13 = r0.this$0
            java.lang.Number r11 = (java.lang.Number) r11
            float r11 = r11.floatValue()
            float r14 = (float) r12
            float r11 = r11 * r14
            long r14 = (long) r11
            long r16 = r13.zeroTime
            long r14 = r14 + r16
            long r14 = r14 + r7
            r5.element = r14
        L_0x0125:
            long r13 = r5.element
            int r11 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r11 <= 0) goto L_0x018e
            com.blueair.graph.utils.GraphUtils r11 = com.blueair.graph.utils.GraphUtils.INSTANCE
            com.blueair.graph.view.GraphViewV2 r13 = r0.this$0
            android.content.Context r13 = r13.getContext()
            java.lang.String r14 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)
            java.lang.String r11 = r11.getStringDate(r9, r13, r6)
            com.blueair.graph.view.GraphViewV2 r13 = r0.this$0
            long r13 = r13.zeroTime
            long r13 = r9 - r13
            r19 = r5
            long r4 = (long) r12
            long r13 = r13 / r4
            com.github.mikephil.charting.components.LimitLine r4 = new com.github.mikephil.charting.components.LimitLine
            float r5 = (float) r13
            r4.<init>(r5, r11)
            com.blueair.graph.view.GraphViewV2 r5 = r0.this$0
            r11 = 1065353216(0x3f800000, float:1.0)
            r4.setLineWidth(r11)
            com.github.mikephil.charting.components.LimitLine$LimitLabelPosition r11 = com.github.mikephil.charting.components.LimitLine.LimitLabelPosition.CENTER_TOP
            r4.setLabelPosition(r11)
            android.content.Context r11 = r5.getContext()
            int r13 = com.blueair.graph.view.GraphViewV2.DIVIDER_TEXT_COLOR
            int r11 = androidx.core.content.ContextCompat.getColor(r11, r13)
            r4.setTextColor(r11)
            android.content.Context r5 = r5.getContext()
            int r11 = com.blueair.graph.view.GraphViewV2.DIVIDER_LINE_COLOR
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r11)
            r4.setLineColor(r5)
            r5 = 1094713344(0x41400000, float:12.0)
            r4.setTextSize(r5)
            r5 = 0
            r4.setXOffset(r5)
            r5 = 1077936128(0x40400000, float:3.0)
            r4.setYOffset(r5)
            r2.add(r4)
            long r9 = r9 - r7
            r5 = r19
            r4 = 3
            goto L_0x0125
        L_0x018e:
            r19 = r5
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.blueair.graph.view.GraphViewV2$setupXAxisLines$1$4 r5 = new com.blueair.graph.view.GraphViewV2$setupXAxisLines$1$4
            com.blueair.graph.view.GraphViewV2 r6 = r0.this$0
            r5.<init>(r2, r6, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
            r0.L$1 = r2
            r0.J$0 = r7
            r0.J$1 = r9
            r15 = 3
            r0.label = r15
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r3)
            if (r2 != r1) goto L_0x01bc
        L_0x01bb:
            return r1
        L_0x01bc:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewV2$setupXAxisLines$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
