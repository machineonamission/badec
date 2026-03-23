package com.blueair.outdoor.ui.viewmodels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.ui.viewmodels.MapsViewModel$fetchAirQuality$1", f = "MapsViewModel.kt", i = {1}, l = {87, 88}, m = "invokeSuspend", n = {"pair"}, s = {"L$0"})
/* compiled from: MapsViewModel.kt */
final class MapsViewModel$fetchAirQuality$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ double $lat;
    final /* synthetic */ double $lng;
    final /* synthetic */ String $mapType;
    Object L$0;
    int label;
    final /* synthetic */ MapsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapsViewModel$fetchAirQuality$1(MapsViewModel mapsViewModel, double d, double d2, String str, Continuation<? super MapsViewModel$fetchAirQuality$1> continuation) {
        super(2, continuation);
        this.this$0 = mapsViewModel;
        this.$lat = d;
        this.$lng = d2;
        this.$mapType = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapsViewModel$fetchAirQuality$1(this.this$0, this.$lat, this.$lng, this.$mapType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapsViewModel$fetchAirQuality$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005e, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.outdoor.ui.viewmodels.MapsViewModel$fetchAirQuality$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.outdoor.ui.viewmodels.MapsViewModel$fetchAirQuality$1.AnonymousClass1>) null), r11) == r0) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0060, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003a, code lost:
        if (r12 == r0) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r11.L$0
            kotlin.Pair r0 = (kotlin.Pair) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0061
        L_0x0016:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x003d
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r12)
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r12 = r11.this$0
            com.blueair.outdoor.service.OutdoorService r4 = r12.getOutdoorService()
            double r5 = r11.$lat
            double r7 = r11.$lng
            java.lang.String r9 = r11.$mapType
            r10 = r11
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11.label = r3
            java.lang.Object r12 = r4.fetchTrackedLocationWithAqiData(r5, r7, r9, r10)
            if (r12 != r0) goto L_0x003d
            goto L_0x0060
        L_0x003d:
            kotlin.Pair r12 = (kotlin.Pair) r12
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.blueair.outdoor.ui.viewmodels.MapsViewModel$fetchAirQuality$1$1 r3 = new com.blueair.outdoor.ui.viewmodels.MapsViewModel$fetchAirQuality$1$1
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r4 = r11.this$0
            r5 = 0
            r3.<init>(r4, r12, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r11.L$0 = r12
            r11.label = r2
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4)
            if (r12 != r0) goto L_0x0061
        L_0x0060:
            return r0
        L_0x0061:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.viewmodels.MapsViewModel$fetchAirQuality$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
