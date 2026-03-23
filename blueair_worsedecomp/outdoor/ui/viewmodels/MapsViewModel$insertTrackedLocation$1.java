package com.blueair.outdoor.ui.viewmodels;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.ui.viewmodels.MapsViewModel$insertTrackedLocation$1", f = "MapsViewModel.kt", i = {1}, l = {115, 116}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* compiled from: MapsViewModel.kt */
final class MapsViewModel$insertTrackedLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ApiResult<TrackedLocation>, Unit> $completion;
    final /* synthetic */ boolean $isUpdate;
    final /* synthetic */ AqiData $pollutant;
    final /* synthetic */ TrackedLocation $trackedLocation;
    Object L$0;
    int label;
    final /* synthetic */ MapsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapsViewModel$insertTrackedLocation$1(MapsViewModel mapsViewModel, TrackedLocation trackedLocation, AqiData aqiData, boolean z, Function1<? super ApiResult<TrackedLocation>, Unit> function1, Continuation<? super MapsViewModel$insertTrackedLocation$1> continuation) {
        super(2, continuation);
        this.this$0 = mapsViewModel;
        this.$trackedLocation = trackedLocation;
        this.$pollutant = aqiData;
        this.$isUpdate = z;
        this.$completion = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapsViewModel$insertTrackedLocation$1(this.this$0, this.$trackedLocation, this.$pollutant, this.$isUpdate, this.$completion, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapsViewModel$insertTrackedLocation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005e, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.outdoor.ui.viewmodels.MapsViewModel$insertTrackedLocation$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.outdoor.ui.viewmodels.MapsViewModel$insertTrackedLocation$1.AnonymousClass1>) null), r7) == r0) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r8 == r0) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r7.L$0
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0061
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003d
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r8 = r7.this$0
            com.blueair.outdoor.service.OutdoorService r8 = r8.getOutdoorService()
            com.blueair.core.model.TrackedLocation r1 = r7.$trackedLocation
            com.blueair.core.model.AqiData r4 = r7.$pollutant
            boolean r5 = r7.$isUpdate
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r3
            java.lang.Object r8 = r8.insertTrackedLocation(r1, r4, r5, r6)
            if (r8 != r0) goto L_0x003d
            goto L_0x0060
        L_0x003d:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.blueair.outdoor.ui.viewmodels.MapsViewModel$insertTrackedLocation$1$1 r3 = new com.blueair.outdoor.ui.viewmodels.MapsViewModel$insertTrackedLocation$1$1
            kotlin.jvm.functions.Function1<io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.TrackedLocation>, kotlin.Unit> r4 = r7.$completion
            r5 = 0
            r3.<init>(r4, r8, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4)
            if (r8 != r0) goto L_0x0061
        L_0x0060:
            return r0
        L_0x0061:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.viewmodels.MapsViewModel$insertTrackedLocation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
