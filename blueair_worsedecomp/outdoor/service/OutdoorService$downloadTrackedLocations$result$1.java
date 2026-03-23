package com.blueair.outdoor.service;

import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "locList", "", "Lcom/blueair/core/model/TrackedLocation;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$result$1", f = "OutdoorService.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4}, l = {94, 99, 101, 101, 110}, m = "invokeSuspend", n = {"locList", "locList", "nullInfoLocations", "infoAddedLocations", "$this$forEach$iv", "element$iv", "nullInfoLoc", "$i$f$forEach", "$i$a$-forEach-OutdoorService$downloadTrackedLocations$result$1$1", "locList", "nullInfoLocations", "infoAddedLocations", "$this$forEach$iv", "element$iv", "nullInfoLoc", "infoLoc", "$i$f$forEach", "$i$a$-forEach-OutdoorService$downloadTrackedLocations$result$1$1", "$i$a$-let-OutdoorService$downloadTrackedLocations$result$1$1$1", "locList", "nullInfoLocations", "infoAddedLocations", "$this$forEach$iv", "element$iv", "nullInfoLoc", "infoLoc", "$i$f$forEach", "$i$a$-forEach-OutdoorService$downloadTrackedLocations$result$1$1", "$i$a$-let-OutdoorService$downloadTrackedLocations$result$1$1$1", "locList", "nullInfoLocations", "idList"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "L$3", "L$6", "L$7", "L$8", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2"})
/* compiled from: OutdoorService.kt */
final class OutdoorService$downloadTrackedLocations$result$1 extends SuspendLambda implements Function2<List<? extends TrackedLocation>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    final /* synthetic */ OutdoorService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OutdoorService$downloadTrackedLocations$result$1(OutdoorService outdoorService, Continuation<? super OutdoorService$downloadTrackedLocations$result$1> continuation) {
        super(2, continuation);
        this.this$0 = outdoorService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OutdoorService$downloadTrackedLocations$result$1 outdoorService$downloadTrackedLocations$result$1 = new OutdoorService$downloadTrackedLocations$result$1(this.this$0, continuation);
        outdoorService$downloadTrackedLocations$result$1.L$0 = obj;
        return outdoorService$downloadTrackedLocations$result$1;
    }

    public final Object invoke(List<TrackedLocation> list, Continuation<? super Unit> continuation) {
        return ((OutdoorService$downloadTrackedLocations$result$1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00cf, code lost:
        if (r0.this$0.trackedLocationRepository.setTrackedLocations(r1, r0) == r2) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x02ad, code lost:
        if (r0.this$0.fetchAqiData(r1, r0) == r2) goto L_0x02af;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x022e A[LOOP:1: B:47:0x0228->B:49:0x022e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0257  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = r0.L$0
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r0.label
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = 0
            if (r3 == 0) goto L_0x00bb
            if (r3 == r8) goto L_0x00b7
            if (r3 == r7) goto L_0x0090
            if (r3 == r6) goto L_0x0057
            if (r3 == r5) goto L_0x0034
            if (r3 != r4) goto L_0x002c
            java.lang.Object r1 = r0.L$2
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r1 = r0.L$1
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x02b0
        L_0x002c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0034:
            int r3 = r0.I$0
            java.lang.Object r8 = r0.L$8
            com.blueair.core.model.TrackedLocation r8 = (com.blueair.core.model.TrackedLocation) r8
            java.lang.Object r8 = r0.L$7
            com.blueair.core.model.TrackedLocation r8 = (com.blueair.core.model.TrackedLocation) r8
            java.lang.Object r8 = r0.L$5
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r11 = r0.L$4
            com.blueair.outdoor.service.OutdoorService r11 = (com.blueair.outdoor.service.OutdoorService) r11
            java.lang.Object r12 = r0.L$3
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r0.L$2
            java.util.List r13 = (java.util.List) r13
            java.lang.Object r14 = r0.L$1
            java.util.List r14 = (java.util.List) r14
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x01e9
        L_0x0057:
            int r3 = r0.I$2
            int r8 = r0.I$1
            int r11 = r0.I$0
            java.lang.Object r12 = r0.L$8
            com.blueair.core.model.TrackedLocation r12 = (com.blueair.core.model.TrackedLocation) r12
            java.lang.Object r13 = r0.L$7
            com.blueair.core.model.TrackedLocation r13 = (com.blueair.core.model.TrackedLocation) r13
            java.lang.Object r14 = r0.L$6
            java.lang.Object r15 = r0.L$5
            java.util.Iterator r15 = (java.util.Iterator) r15
            java.lang.Object r4 = r0.L$4
            com.blueair.outdoor.service.OutdoorService r4 = (com.blueair.outdoor.service.OutdoorService) r4
            java.lang.Object r5 = r0.L$3
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.lang.Object r6 = r0.L$2
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r0.L$1
            java.util.List r7 = (java.util.List) r7
            kotlin.ResultKt.throwOnFailure(r18)
            r10 = r4
            r4 = r3
            r3 = r11
            r11 = r10
            r10 = r6
            r6 = r5
            r5 = r8
            r8 = r15
            r15 = r7
            r7 = r13
            r13 = r10
            r16 = r14
            r10 = 3
            r14 = r18
            goto L_0x01aa
        L_0x0090:
            int r3 = r0.I$1
            int r4 = r0.I$0
            java.lang.Object r5 = r0.L$7
            com.blueair.core.model.TrackedLocation r5 = (com.blueair.core.model.TrackedLocation) r5
            java.lang.Object r6 = r0.L$6
            java.lang.Object r7 = r0.L$5
            java.util.Iterator r7 = (java.util.Iterator) r7
            java.lang.Object r8 = r0.L$4
            com.blueair.outdoor.service.OutdoorService r8 = (com.blueair.outdoor.service.OutdoorService) r8
            java.lang.Object r11 = r0.L$3
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r0.L$2
            java.util.List r12 = (java.util.List) r12
            java.lang.Object r13 = r0.L$1
            java.util.List r13 = (java.util.List) r13
            kotlin.ResultKt.throwOnFailure(r18)
            r15 = r6
            r14 = 2
            r6 = r18
            goto L_0x0164
        L_0x00b7:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x00d3
        L_0x00bb:
            kotlin.ResultKt.throwOnFailure(r18)
            com.blueair.outdoor.service.OutdoorService r3 = r0.this$0
            com.blueair.database.repository.TrackedLocationRepository r3 = r3.trackedLocationRepository
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r0.L$0 = r1
            r0.label = r8
            java.lang.Object r3 = r3.setTrackedLocations(r1, r4)
            if (r3 != r2) goto L_0x00d3
            goto L_0x02af
        L_0x00d3:
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.Iterator r3 = r3.iterator()
        L_0x00e1:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0104
            java.lang.Object r5 = r3.next()
            r6 = r5
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            java.lang.String r7 = r6.getLocationName()
            if (r7 != 0) goto L_0x00e1
            java.lang.String r7 = r6.getCityName()
            if (r7 != 0) goto L_0x00e1
            java.lang.String r6 = r6.getCountryName()
            if (r6 != 0) goto L_0x00e1
            r4.add(r5)
            goto L_0x00e1
        L_0x0104:
            java.util.List r4 = (java.util.List) r4
            r3 = r4
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0214
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            r5 = r4
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            com.blueair.outdoor.service.OutdoorService r6 = r0.this$0
            java.util.Iterator r7 = r5.iterator()
            r12 = r3
            r13 = r4
            r11 = r5
            r8 = r6
            r4 = r9
        L_0x0124:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L_0x01f5
            java.lang.Object r3 = r7.next()
            r5 = r3
            com.blueair.core.model.TrackedLocation r5 = (com.blueair.core.model.TrackedLocation) r5
            com.blueair.outdoor.service.GeocodeService r6 = r8.geocodeService
            r0.L$0 = r1
            r0.L$1 = r13
            r0.L$2 = r12
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r0.L$3 = r14
            r0.L$4 = r8
            r0.L$5 = r7
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r0.L$6 = r14
            java.lang.Object r14 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$7 = r14
            r0.L$8 = r10
            r0.I$0 = r4
            r0.I$1 = r9
            r14 = 2
            r0.label = r14
            java.lang.Object r6 = r6.getTrackedLocation(r5, r0)
            if (r6 != r2) goto L_0x0162
            goto L_0x02af
        L_0x0162:
            r15 = r3
            r3 = r9
        L_0x0164:
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            if (r6 == 0) goto L_0x01f0
            r12.add(r6)
            com.blueair.api.client.OutdoorClient r14 = r8.outdoorClient
            r0.L$0 = r1
            r0.L$1 = r13
            r0.L$2 = r12
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r0.L$3 = r10
            r0.L$4 = r8
            r0.L$5 = r7
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$6 = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$7 = r10
            r0.L$8 = r6
            r0.I$0 = r4
            r0.I$1 = r3
            r0.I$2 = r9
            r10 = 3
            r0.label = r10
            java.lang.Object r14 = r14.addTrackedLocation(r6, r0)
            if (r14 != r2) goto L_0x019e
            goto L_0x02af
        L_0x019e:
            r16 = r15
            r15 = r13
            r13 = r12
            r12 = r6
            r6 = r11
            r11 = r8
            r8 = r7
            r7 = r5
            r5 = r3
            r3 = r4
            r4 = r9
        L_0x01aa:
            io.flatcircle.coroutinehelper.ApiResult r14 = (io.flatcircle.coroutinehelper.ApiResult) r14
            com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$result$1$1$1$1 r10 = new com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$result$1$1$1$1
            r9 = 0
            r10.<init>(r11, r12, r9)
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r1
            r0.L$1 = r15
            r0.L$2 = r13
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$3 = r9
            r0.L$4 = r11
            r0.L$5 = r8
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r0.L$6 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$7 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r0.L$8 = r7
            r0.I$0 = r3
            r0.I$1 = r5
            r0.I$2 = r4
            r5 = 4
            r0.label = r5
            java.lang.Object r4 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r14, r10, r0)
            if (r4 != r2) goto L_0x01e7
            goto L_0x02af
        L_0x01e7:
            r12 = r6
            r14 = r15
        L_0x01e9:
            r4 = r3
            r7 = r8
            r8 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            goto L_0x01f1
        L_0x01f0:
            r5 = 4
        L_0x01f1:
            r9 = 0
            r10 = 0
            goto L_0x0124
        L_0x01f5:
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Do location info completion: \nbefore: "
            r4.<init>(r5)
            r4.append(r13)
            java.lang.String r5 = "\nafter: "
            r4.append(r5)
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r3.d(r4, r5)
            r4 = r13
        L_0x0214:
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r3 = r3.iterator()
        L_0x0228:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x023c
            java.lang.Object r6 = r3.next()
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            java.lang.String r6 = r6.getId()
            r5.add(r6)
            goto L_0x0228
        L_0x023c:
            java.util.List r5 = (java.util.List) r5
            com.blueair.outdoor.service.OutdoorService r3 = r0.this$0
            java.util.Map r6 = r3.getAqiDataRefreshTime()
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L_0x0251:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x027d
            java.lang.Object r8 = r6.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r9 = r8.getKey()
            java.lang.String r9 = (java.lang.String) r9
            boolean r10 = r5.contains(r9)
            if (r10 != 0) goto L_0x0271
            java.lang.String r10 = "current"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0251
        L_0x0271:
            java.lang.Object r9 = r8.getKey()
            java.lang.Object r8 = r8.getValue()
            r7.put(r9, r8)
            goto L_0x0251
        L_0x027d:
            java.util.Map r7 = (java.util.Map) r7
            r3.setAqiDataRefreshTime(r7)
            com.blueair.outdoor.service.OutdoorService r3 = r0.this$0
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r0.L$0 = r7
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$1 = r4
            java.lang.Object r4 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r0.L$2 = r4
            r9 = 0
            r0.L$3 = r9
            r0.L$4 = r9
            r0.L$5 = r9
            r0.L$6 = r9
            r0.L$7 = r9
            r0.L$8 = r9
            r4 = 5
            r0.label = r4
            java.lang.Object r1 = r3.fetchAqiData(r1, r6)
            if (r1 != r2) goto L_0x02b0
        L_0x02af:
            return r2
        L_0x02b0:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.OutdoorService$downloadTrackedLocations$result$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
