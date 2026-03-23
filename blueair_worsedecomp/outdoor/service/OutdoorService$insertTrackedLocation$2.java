package com.blueair.outdoor.service;

import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/blueair/core/model/TrackedLocation;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$2", f = "OutdoorService.kt", i = {0, 1}, l = {118, 119}, m = "invokeSuspend", n = {"it", "it"}, s = {"L$0", "L$0"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$insertTrackedLocation$2 extends SuspendLambda implements Function2<TrackedLocation, Continuation<? super Unit>, Object> {
    final /* synthetic */ AqiData $aqiData;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$insertTrackedLocation$2(OutdoorService outdoorService, AqiData aqiData, Continuation<? super OutdoorService$insertTrackedLocation$2> continuation) {
        super(2, continuation);
        this.this$0 = outdoorService;
        this.$aqiData = aqiData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OutdoorService$insertTrackedLocation$2 outdoorService$insertTrackedLocation$2 = new OutdoorService$insertTrackedLocation$2(this.this$0, this.$aqiData, continuation);
        outdoorService$insertTrackedLocation$2.L$0 = obj;
        return outdoorService$insertTrackedLocation$2;
    }

    public final Object invoke(TrackedLocation trackedLocation, Continuation<? super Unit> continuation) {
        return ((OutdoorService$insertTrackedLocation$2) create(trackedLocation, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005d, code lost:
        if (r11.this$0.trackedLocationRepository.insertAqiData(com.blueair.core.model.AqiData.copy$default(r11.$aqiData, r0.getId(), 0, (com.blueair.core.model.OutdoorPollutants) null, 6, (java.lang.Object) null), (kotlin.coroutines.Continuation<? super kotlin.Unit>) r11) == r1) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        if (r11.this$0.trackedLocationRepository.insertTrackedLocation(r0, r11) == r1) goto L_0x005f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.L$0
            com.blueair.core.model.TrackedLocation r0 = (com.blueair.core.model.TrackedLocation) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r11.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0022
            if (r2 == r4) goto L_0x001e
            if (r2 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0060
        L_0x0016:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0039
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r12)
            com.blueair.outdoor.service.OutdoorService r12 = r11.this$0
            com.blueair.database.repository.TrackedLocationRepository r12 = r12.trackedLocationRepository
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.L$0 = r0
            r11.label = r4
            java.lang.Object r12 = r12.insertTrackedLocation(r0, r2)
            if (r12 != r1) goto L_0x0039
            goto L_0x005f
        L_0x0039:
            com.blueair.outdoor.service.OutdoorService r12 = r11.this$0
            com.blueair.database.repository.TrackedLocationRepository r12 = r12.trackedLocationRepository
            com.blueair.core.model.AqiData r4 = r11.$aqiData
            java.lang.String r5 = r0.getId()
            r9 = 6
            r10 = 0
            r6 = 0
            r8 = 0
            com.blueair.core.model.AqiData r2 = com.blueair.core.model.AqiData.copy$default(r4, r5, r6, r8, r9, r10)
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r11.L$0 = r0
            r11.label = r3
            java.lang.Object r12 = r12.insertAqiData((com.blueair.core.model.AqiData) r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4)
            if (r12 != r1) goto L_0x0060
        L_0x005f:
            return r1
        L_0x0060:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService$insertTrackedLocation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
