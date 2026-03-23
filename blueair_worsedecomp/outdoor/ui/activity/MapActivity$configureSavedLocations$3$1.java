package com.blueair.outdoor.ui.activity;

import com.blueair.core.model.TrackedLocation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1", f = "MapActivity.kt", i = {}, l = {375, 375, 375}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MapActivity.kt */
final class MapActivity$configureSavedLocations$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $currentIndex;
    final /* synthetic */ TrackedLocation $location;
    int label;
    final /* synthetic */ MapActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MapActivity$configureSavedLocations$3$1(MapActivity mapActivity, TrackedLocation trackedLocation, Integer num, Continuation<? super MapActivity$configureSavedLocations$3$1> continuation) {
        super(2, continuation);
        this.this$0 = mapActivity;
        this.$location = trackedLocation;
        this.$currentIndex = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MapActivity$configureSavedLocations$3$1(this.this$0, this.$location, this.$currentIndex, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MapActivity$configureSavedLocations$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004c, code lost:
        if (r10 == r0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0063, code lost:
        if (r10 == r0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007c, code lost:
        if (io.flatcircle.coroutinehelper.ApiResultKt.onFail((io.flatcircle.coroutinehelper.ApiResult) r10, new com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1.AnonymousClass2((kotlin.coroutines.Continuation<? super com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1.AnonymousClass2>) null), r9) == r0) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007e, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r5) goto L_0x0022
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007f
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0066
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x004f
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r10)
            com.blueair.outdoor.ui.activity.MapActivity r10 = r9.this$0
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r10 = r10.getViewModel()
            com.blueair.core.model.TrackedLocation r1 = r9.$location
            java.lang.String r1 = r1.getId()
            com.blueair.outdoor.ui.activity.MapActivity r6 = r9.this$0
            java.lang.String r6 = r6.deviceId
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            java.util.List r7 = kotlin.collections.CollectionsKt.emptyList()
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9.label = r5
            java.lang.Object r10 = r10.setLocationDevices(r1, r6, r7, r8)
            if (r10 != r0) goto L_0x004f
            goto L_0x007e
        L_0x004f:
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1$1 r1 = new com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1$1
            com.blueair.outdoor.ui.activity.MapActivity r5 = r9.this$0
            r1.<init>(r5, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.label = r4
            java.lang.Object r10 = io.flatcircle.coroutinehelper.ApiResultKt.onSuccess(r10, r1, r5)
            if (r10 != r0) goto L_0x0066
            goto L_0x007e
        L_0x0066:
            io.flatcircle.coroutinehelper.ApiResult r10 = (io.flatcircle.coroutinehelper.ApiResult) r10
            com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1$2 r1 = new com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1$2
            java.lang.Integer r4 = r9.$currentIndex
            com.blueair.outdoor.ui.activity.MapActivity r5 = r9.this$0
            r1.<init>(r4, r5, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.label = r3
            java.lang.Object r10 = io.flatcircle.coroutinehelper.ApiResultKt.onFail(r10, r1, r2)
            if (r10 != r0) goto L_0x007f
        L_0x007e:
            return r0
        L_0x007f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.activity.MapActivity$configureSavedLocations$3$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
