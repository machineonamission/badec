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
@DebugMetadata(c = "com.blueair.graph.view.GraphViewH$setupXAxisLines$1", f = "GraphViewH.kt", i = {2, 2, 2, 2}, l = {587, 588, 616}, m = "invokeSuspend", n = {"lines", "xLabelStepInMills", "dividerTime", "minimumTime"}, s = {"L$0", "J$0", "J$1", "J$2"})
/* compiled from: GraphViewH.kt */
final class GraphViewH$setupXAxisLines$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Job $previousJob;
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    int label;
    final /* synthetic */ GraphViewH this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GraphViewH.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewH$setupXAxisLines$1.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GraphViewH$setupXAxisLines$1(Job job, GraphViewH graphViewH, Continuation<? super GraphViewH$setupXAxisLines$1> continuation) {
        super(2, continuation);
        this.$previousJob = job;
        this.this$0 = graphViewH;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GraphViewH$setupXAxisLines$1(this.$previousJob, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GraphViewH$setupXAxisLines$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        if (kotlinx.coroutines.JobKt.cancelAndJoin(r2, r0) == r1) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.graph.view.GraphViewH$setupXAxisLines$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.graph.view.GraphViewH$setupXAxisLines$1.AnonymousClass1>) null), r0) == r1) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x014f, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.graph.view.GraphViewH$setupXAxisLines$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.graph.view.GraphViewH$setupXAxisLines$1.AnonymousClass2>) null), r0) == r1) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0151, code lost:
        return r1;
     */
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
            if (r2 == 0) goto L_0x002d
            if (r2 == r6) goto L_0x0029
            if (r2 == r5) goto L_0x0025
            if (r2 != r4) goto L_0x001d
            java.lang.Object r1 = r0.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0152
        L_0x001d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x005d
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r19)
            goto L_0x0041
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r19)
            kotlinx.coroutines.Job r2 = r0.$previousJob
            if (r2 == 0) goto L_0x0041
            r7 = r0
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r0.label = r6
            java.lang.Object r2 = kotlinx.coroutines.JobKt.cancelAndJoin(r2, r7)
            if (r2 != r1) goto L_0x0041
            goto L_0x0151
        L_0x0041:
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.blueair.graph.view.GraphViewH$setupXAxisLines$1$1 r7 = new com.blueair.graph.view.GraphViewH$setupXAxisLines$1$1
            com.blueair.graph.view.GraphViewH r8 = r0.this$0
            r7.<init>(r8, r3)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = r0
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r0.label = r5
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r7, r8)
            if (r2 != r1) goto L_0x005d
            goto L_0x0151
        L_0x005d:
            com.blueair.graph.view.GraphViewH r2 = r0.this$0
            long r7 = r2.zeroTime
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 > 0) goto L_0x006c
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x006c:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            com.blueair.graph.view.GraphViewH r7 = r0.this$0
            com.blueair.graph.utils.ChartTimeScale r7 = r7.getTimeScale()
            int[] r8 = com.blueair.graph.view.GraphViewH$setupXAxisLines$1.WhenMappings.$EnumSwitchMapping$0
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r6) goto L_0x0095
            if (r7 == r5) goto L_0x0091
            if (r7 != r4) goto L_0x008b
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            goto L_0x0098
        L_0x008b:
            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
            r1.<init>()
            throw r1
        L_0x0091:
            r5 = 259200000(0xf731400, double:1.280618154E-315)
            goto L_0x0098
        L_0x0095:
            r5 = 864000000(0x337f9800, double:4.26872718E-315)
        L_0x0098:
            com.blueair.graph.view.GraphViewH r7 = r0.this$0
            long r7 = r7.rawEndTime
            com.blueair.graph.view.GraphViewH r9 = r0.this$0
            long r9 = r9.rawEndTime
            r11 = 3600000(0x36ee80, float:5.044674E-39)
            long r11 = (long) r11
            long r9 = r9 % r11
            long r7 = r7 - r9
            com.blueair.graph.view.GraphViewH r9 = r0.this$0
            long r9 = r9.zeroTime
            r11 = 2592000000(0x9a7ec800, double:1.280618154E-314)
            long r9 = r9 - r11
            r12 = r7
        L_0x00b7:
            int r7 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x0126
            com.blueair.graph.utils.GraphUtils r11 = com.blueair.graph.utils.GraphUtils.INSTANCE
            com.blueair.graph.view.GraphViewH r7 = r0.this$0
            android.content.Context r14 = r7.getContext()
            java.lang.String r7 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r7)
            r16 = 4
            r17 = 0
            r15 = 0
            java.lang.String r7 = com.blueair.graph.utils.GraphUtils.getStringDate$default(r11, r12, r14, r15, r16, r17)
            com.blueair.graph.view.GraphViewH r8 = r0.this$0
            long r14 = r8.zeroTime
            long r14 = r12 - r14
            r8 = 5000(0x1388, float:7.006E-42)
            r16 = r5
            long r4 = (long) r8
            long r14 = r14 / r4
            com.github.mikephil.charting.components.LimitLine r4 = new com.github.mikephil.charting.components.LimitLine
            float r5 = (float) r14
            r4.<init>(r5, r7)
            com.blueair.graph.view.GraphViewH r5 = r0.this$0
            r6 = 1067869798(0x3fa66666, float:1.3)
            r4.setLineWidth(r6)
            com.github.mikephil.charting.components.LimitLine$LimitLabelPosition r6 = com.github.mikephil.charting.components.LimitLine.LimitLabelPosition.RIGHT_BOTTOM
            r4.setLabelPosition(r6)
            android.content.Context r6 = r5.getContext()
            int r7 = com.blueair.graph.view.GraphViewH.DIVIDER_TEXT_COLOR
            int r6 = androidx.core.content.ContextCompat.getColor(r6, r7)
            r4.setTextColor(r6)
            android.content.Context r5 = r5.getContext()
            int r6 = com.blueair.graph.view.GraphViewH.DIVIDER_LINE_COLOR
            int r5 = androidx.core.content.ContextCompat.getColor(r5, r6)
            r4.setLineColor(r5)
            r5 = 1092616192(0x41200000, float:10.0)
            r4.setTextSize(r5)
            r5 = 1084227584(0x40a00000, float:5.0)
            r4.setXOffset(r5)
            r4.setYOffset(r5)
            r2.add(r4)
            long r12 = r12 - r16
            r5 = r16
            r4 = 3
            goto L_0x00b7
        L_0x0126:
            r16 = r5
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.blueair.graph.view.GraphViewH$setupXAxisLines$1$2 r5 = new com.blueair.graph.view.GraphViewH$setupXAxisLines$1$2
            com.blueair.graph.view.GraphViewH r6 = r0.this$0
            r5.<init>(r2, r6, r3)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$0 = r2
            r6 = r16
            r0.J$0 = r6
            r0.J$1 = r12
            r0.J$2 = r9
            r11 = 3
            r0.label = r11
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r3)
            if (r2 != r1) goto L_0x0152
        L_0x0151:
            return r1
        L_0x0152:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.graph.view.GraphViewH$setupXAxisLines$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
