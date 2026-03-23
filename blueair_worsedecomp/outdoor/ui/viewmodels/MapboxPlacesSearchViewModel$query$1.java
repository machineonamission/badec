package com.blueair.outdoor.ui.viewmodels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel$query$1", f = "MapboxPlacesSearchViewModel.kt", i = {0, 0, 0}, l = {19}, m = "invokeSuspend", n = {"currentLoc", "lngLat", "results"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: MapboxPlacesSearchViewModel.kt */
final class MapboxPlacesSearchViewModel$query$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $query;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MapboxPlacesSearchViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapboxPlacesSearchViewModel$query$1(MapboxPlacesSearchViewModel mapboxPlacesSearchViewModel, String str, Continuation<? super MapboxPlacesSearchViewModel$query$1> continuation) {
        super(2, continuation);
        this.this$0 = mapboxPlacesSearchViewModel;
        this.$query = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapboxPlacesSearchViewModel$query$1(this.this$0, this.$query, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapboxPlacesSearchViewModel$query$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (r3 == null) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            java.lang.Object r0 = r8.L$2
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r8.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r8.L$0
            com.blueair.core.model.TrackedLocation r0 = (com.blueair.core.model.TrackedLocation) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a4
        L_0x001c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel r9 = r8.this$0
            androidx.lifecycle.LiveData r9 = r9.getCurrentLocation()
            java.lang.Object r9 = r9.getValue()
            com.blueair.core.model.TrackedLocation r9 = (com.blueair.core.model.TrackedLocation) r9
            java.lang.String r1 = ""
            if (r9 == 0) goto L_0x0067
            kotlin.Pair r3 = r9.getLatLngInWGS()
            if (r3 == 0) goto L_0x0067
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.Object r5 = r3.getSecond()
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            r4.append(r5)
            r5 = 44
            r4.append(r5)
            java.lang.Object r3 = r3.getFirst()
            java.lang.Number r3 = (java.lang.Number) r3
            double r5 = r3.doubleValue()
            r4.append(r5)
            java.lang.String r3 = r4.toString()
            if (r3 != 0) goto L_0x0068
        L_0x0067:
            r3 = r1
        L_0x0068:
            com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel r4 = r8.this$0
            com.blueair.outdoor.service.GeocodeService r4 = r4.getGeocodeService()
            java.lang.String r5 = r8.$query
            r6 = 10
            java.util.List r1 = r4.mapboxSearch(r5, r3, r1, r6)
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel$query$1$1 r5 = new com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel$query$1$1
            com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel r6 = r8.this$0
            r7 = 0
            r5.<init>(r6, r1, r7)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
            r8.L$1 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r8.L$2 = r9
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r6)
            if (r9 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.viewmodels.MapboxPlacesSearchViewModel$query$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
