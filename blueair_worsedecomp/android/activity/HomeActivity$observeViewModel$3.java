package com.blueair.android.activity;

import androidx.compose.runtime.MutableFloatState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.activity.HomeActivity$observeViewModel$3", f = "HomeActivity.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeActivity.kt */
final class HomeActivity$observeViewModel$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableFloatState $aqiLiveValue;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$observeViewModel$3(HomeActivity homeActivity, MutableFloatState mutableFloatState, Continuation<? super HomeActivity$observeViewModel$3> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
        this.$aqiLiveValue = mutableFloatState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeActivity$observeViewModel$3(this.this$0, this.$aqiLiveValue, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeActivity$observeViewModel$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<List<Pair<Integer, Float>>> flowDevicesRating = this.this$0.getViewModel().getFlowDevicesRating();
            final MutableFloatState mutableFloatState = this.$aqiLiveValue;
            final HomeActivity homeActivity = this.this$0;
            this.label = 1;
            if (flowDevicesRating.collect(new FlowCollector() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: java.lang.Object} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: kotlin.Pair} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: java.lang.Object} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Float>> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
                    /*
                        r6 = this;
                        boolean r8 = r7.isEmpty()
                        r0 = 1112014848(0x42480000, float:50.0)
                        if (r8 == 0) goto L_0x0017
                        kotlin.Pair r7 = new kotlin.Pair
                        r8 = -1
                        java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
                        java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r0)
                        r7.<init>(r8, r1)
                        goto L_0x0059
                    L_0x0017:
                        java.lang.Iterable r7 = (java.lang.Iterable) r7
                        java.util.Iterator r7 = r7.iterator()
                        boolean r8 = r7.hasNext()
                        if (r8 == 0) goto L_0x00fa
                        java.lang.Object r8 = r7.next()
                        boolean r1 = r7.hasNext()
                        if (r1 != 0) goto L_0x002e
                        goto L_0x0056
                    L_0x002e:
                        r1 = r8
                        kotlin.Pair r1 = (kotlin.Pair) r1
                        java.lang.Object r1 = r1.getFirst()
                        java.lang.Number r1 = (java.lang.Number) r1
                        int r1 = r1.intValue()
                    L_0x003b:
                        java.lang.Object r2 = r7.next()
                        r3 = r2
                        kotlin.Pair r3 = (kotlin.Pair) r3
                        java.lang.Object r3 = r3.getFirst()
                        java.lang.Number r3 = (java.lang.Number) r3
                        int r3 = r3.intValue()
                        if (r1 >= r3) goto L_0x0050
                        r8 = r2
                        r1 = r3
                    L_0x0050:
                        boolean r2 = r7.hasNext()
                        if (r2 != 0) goto L_0x003b
                    L_0x0056:
                        r7 = r8
                        kotlin.Pair r7 = (kotlin.Pair) r7
                    L_0x0059:
                        java.lang.Object r8 = r7.component1()
                        java.lang.Number r8 = (java.lang.Number) r8
                        int r8 = r8.intValue()
                        java.lang.Object r7 = r7.component2()
                        java.lang.Number r7 = (java.lang.Number) r7
                        float r7 = r7.floatValue()
                        r1 = 0
                        int r2 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                        r3 = 1120403456(0x42c80000, float:100.0)
                        if (r2 >= 0) goto L_0x0076
                        r7 = r0
                        goto L_0x0078
                    L_0x0076:
                        float r7 = r3 - r7
                    L_0x0078:
                        androidx.compose.runtime.MutableFloatState r2 = r3
                        r4 = 1103626240(0x41c80000, float:25.0)
                        int r5 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                        if (r5 >= 0) goto L_0x0082
                    L_0x0080:
                        r0 = r1
                        goto L_0x0095
                    L_0x0082:
                        int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                        if (r1 >= 0) goto L_0x0088
                        r0 = r4
                        goto L_0x0095
                    L_0x0088:
                        r1 = 1117126656(0x42960000, float:75.0)
                        int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                        if (r4 >= 0) goto L_0x008f
                        goto L_0x0095
                    L_0x008f:
                        int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                        if (r7 >= 0) goto L_0x0094
                        goto L_0x0080
                    L_0x0094:
                        r0 = r3
                    L_0x0095:
                        r2.setFloatValue(r0)
                        com.blueair.android.activity.HomeActivity r7 = r4
                        com.blueair.android.viewmodel.HomeViewModel r7 = r7.getViewModel()
                        int r7 = r7.getLastRatingIndex()
                        if (r7 == r8) goto L_0x00f7
                        com.blueair.android.activity.HomeActivity r7 = r4
                        com.blueair.android.viewmodel.HomeViewModel r7 = r7.getViewModel()
                        r7.setLastRatingIndex(r8)
                        com.blueair.android.activity.HomeActivity r7 = r4
                        com.blueair.android.viewmodel.HomeViewModel r7 = r7.getViewModel()
                        androidx.lifecycle.MutableLiveData r7 = r7.getLvAirStateStringRes()
                        com.blueair.core.util.IndoorAirRatingRanges$IndoorAirRating$EXCELLENT r0 = com.blueair.core.util.IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE
                        int r0 = r0.getRating()
                        if (r8 != r0) goto L_0x00c2
                        int r8 = com.blueair.viewcore.R.string.label_excellent_air
                        goto L_0x00f0
                    L_0x00c2:
                        com.blueair.core.util.IndoorAirRatingRanges$IndoorAirRating$GOOD r0 = com.blueair.core.util.IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE
                        int r0 = r0.getRating()
                        if (r8 != r0) goto L_0x00cd
                        int r8 = com.blueair.viewcore.R.string.state_good_air
                        goto L_0x00f0
                    L_0x00cd:
                        com.blueair.core.util.IndoorAirRatingRanges$IndoorAirRating$MODERATE r0 = com.blueair.core.util.IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE
                        int r0 = r0.getRating()
                        if (r8 != r0) goto L_0x00d8
                        int r8 = com.blueair.viewcore.R.string.label_moderate_air
                        goto L_0x00f0
                    L_0x00d8:
                        com.blueair.core.util.IndoorAirRatingRanges$IndoorAirRating$POLLUTED r0 = com.blueair.core.util.IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE
                        int r0 = r0.getRating()
                        if (r8 != r0) goto L_0x00e3
                        int r8 = com.blueair.viewcore.R.string.state_poor_air
                        goto L_0x00f0
                    L_0x00e3:
                        com.blueair.core.util.IndoorAirRatingRanges$IndoorAirRating$VERY_POLLUTED r0 = com.blueair.core.util.IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE
                        int r0 = r0.getRating()
                        if (r8 != r0) goto L_0x00ee
                        int r8 = com.blueair.viewcore.R.string.state_verypoor_air
                        goto L_0x00f0
                    L_0x00ee:
                        int r8 = com.blueair.viewcore.R.string.state_no_readings
                    L_0x00f0:
                        java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
                        r7.setValue(r8)
                    L_0x00f7:
                        kotlin.Unit r7 = kotlin.Unit.INSTANCE
                        return r7
                    L_0x00fa:
                        java.util.NoSuchElementException r7 = new java.util.NoSuchElementException
                        r7.<init>()
                        throw r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.HomeActivity$observeViewModel$3.AnonymousClass1.emit(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
