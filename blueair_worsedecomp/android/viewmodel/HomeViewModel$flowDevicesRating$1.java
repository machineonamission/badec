package com.blueair.android.viewmodel;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "", "", "devices", "Lcom/blueair/core/model/Device;", "indoorDataPoints", "", "", "Lcom/blueair/core/model/IndoorDatapoint;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$flowDevicesRating$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$flowDevicesRating$1 extends SuspendLambda implements Function3<List<? extends Device>, Map<String, ? extends IndoorDatapoint>, Continuation<? super List<? extends Pair<? extends Integer, ? extends Float>>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$flowDevicesRating$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$flowDevicesRating$1> continuation) {
        super(3, continuation);
        this.this$0 = homeViewModel;
    }

    public final Object invoke(List<? extends Device> list, Map<String, IndoorDatapoint> map, Continuation<? super List<Pair<Integer, Float>>> continuation) {
        HomeViewModel$flowDevicesRating$1 homeViewModel$flowDevicesRating$1 = new HomeViewModel$flowDevicesRating$1(this.this$0, continuation);
        homeViewModel$flowDevicesRating$1.L$0 = list;
        homeViewModel$flowDevicesRating$1.L$1 = map;
        return homeViewModel$flowDevicesRating$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        Map map = (Map) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.getAuthService().isUserLoggedIn().getValue().booleanValue()) {
                return CollectionsKt.emptyList();
            }
            Sequence filter = SequencesKt.filter(CollectionsKt.asSequence(list), HomeViewModel$flowDevicesRating$1$invokeSuspend$$inlined$filterIsInstance$1.INSTANCE);
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(filter, new HomeViewModel$flowDevicesRating$1$$ExternalSyntheticLambda0()), new HomeViewModel$flowDevicesRating$1$$ExternalSyntheticLambda1(map, this.this$0)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(HasSensorData hasSensorData) {
        if (hasSensorData instanceof HasBlueProvisionCalls) {
            return ((HasBlueProvisionCalls) hasSensorData).getHasFinishedOnboarding();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$2(Map map, HomeViewModel homeViewModel, HasSensorData hasSensorData) {
        float f = -1.0f;
        int i = -1;
        if (hasSensorData.getConnectivityStatus() != ConnectivityStatus.ONLINE || DeviceKt.isStandByOn(hasSensorData)) {
            return new Pair(-1, Float.valueOf(-1.0f));
        }
        IndoorAirRatingRanges instance = IndoorAirRatingRanges.Companion.instance(hasSensorData);
        IndoorDatapoint indoorDatapoint = (IndoorDatapoint) map.get(hasSensorData.getUid());
        Float f2 = null;
        if (indoorDatapoint == null || System.currentTimeMillis() - indoorDatapoint.getTimeInMillis() >= 20000) {
            indoorDatapoint = null;
        }
        Pair<SensorType, Integer> voteWorstRating = instance.voteWorstRating(IndoorAirRatingRanges.Companion.getAirRatingSensors(hasSensorData), indoorDatapoint);
        int intValue = voteWorstRating.getSecond().intValue();
        float access$computeRatingValue = homeViewModel.computeRatingValue(voteWorstRating.getFirst(), indoorDatapoint != null ? indoorDatapoint.valueFor(voteWorstRating.getFirst()) : null, instance);
        if ((hasSensorData instanceof HasWick) || (hasSensorData instanceof DeviceDehumidifier)) {
            i = homeViewModel.computeHumRatingIndex(indoorDatapoint != null ? indoorDatapoint.getHum() : null, instance);
            SensorType sensorType = SensorType.HUM;
            if (indoorDatapoint != null) {
                f2 = indoorDatapoint.getHum();
            }
            f = homeViewModel.computeRatingValue(sensorType, f2, instance);
        }
        return new Pair(Integer.valueOf(RangesKt.coerceAtLeast(intValue, i)), Float.valueOf(RangesKt.coerceAtLeast(access$computeRatingValue, f)));
    }
}
