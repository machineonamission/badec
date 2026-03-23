package com.blueair.android.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.IndoorDatapoint;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/IndoorDatapoint;", "devices", "indoorDataPoints", "", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.IndoorViewModel$liveDevicesWithLatestDataPoint$1", f = "IndoorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IndoorViewModel.kt */
final class IndoorViewModel$liveDevicesWithLatestDataPoint$1 extends SuspendLambda implements Function3<List<? extends Device>, Map<String, ? extends IndoorDatapoint>, Continuation<? super List<? extends Pair<? extends Device, ? extends IndoorDatapoint>>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ IndoorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IndoorViewModel$liveDevicesWithLatestDataPoint$1(IndoorViewModel indoorViewModel, Continuation<? super IndoorViewModel$liveDevicesWithLatestDataPoint$1> continuation) {
        super(3, continuation);
        this.this$0 = indoorViewModel;
    }

    public final Object invoke(List<? extends Device> list, Map<String, IndoorDatapoint> map, Continuation<? super List<? extends Pair<? extends Device, IndoorDatapoint>>> continuation) {
        IndoorViewModel$liveDevicesWithLatestDataPoint$1 indoorViewModel$liveDevicesWithLatestDataPoint$1 = new IndoorViewModel$liveDevicesWithLatestDataPoint$1(this.this$0, continuation);
        indoorViewModel$liveDevicesWithLatestDataPoint$1.L$0 = list;
        indoorViewModel$liveDevicesWithLatestDataPoint$1.L$1 = map;
        return indoorViewModel$liveDevicesWithLatestDataPoint$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list = (List) this.L$0;
        Map map = (Map) this.L$1;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.getAuthService().isUserLoggedIn().getValue().booleanValue()) {
                return SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(list), new IndoorViewModel$liveDevicesWithLatestDataPoint$1$$ExternalSyntheticLambda0()), new IndoorViewModel$liveDevicesWithLatestDataPoint$1$invokeSuspend$$inlined$sortedBy$1()), new IndoorViewModel$liveDevicesWithLatestDataPoint$1$$ExternalSyntheticLambda1(map)));
            }
            return CollectionsKt.emptyList();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(Device device) {
        if (device instanceof HasBlueProvisionCalls) {
            return ((HasBlueProvisionCalls) device).getHasFinishedOnboarding();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final Pair invokeSuspend$lambda$2(Map map, Device device) {
        IndoorDatapoint indoorDatapoint = (IndoorDatapoint) map.get(device.getUid());
        IndoorDatapoint indoorDatapoint2 = null;
        if (indoorDatapoint != null) {
            if (System.currentTimeMillis() - indoorDatapoint.getTimeInMillis() >= 20000) {
                indoorDatapoint = null;
            }
            indoorDatapoint2 = indoorDatapoint;
        }
        return TuplesKt.to(device, indoorDatapoint2);
    }
}
