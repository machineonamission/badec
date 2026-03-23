package com.blueair.android.viewmodel;

import com.blueair.core.model.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/blueair/core/model/Device;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$devices$1", f = "IndoorViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IndoorViewModel.kt */
final class IndoorViewModel$shouldShowWhExplore$devices$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Device>>, Object> {
    int label;
    final /* synthetic */ IndoorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IndoorViewModel$shouldShowWhExplore$devices$1(IndoorViewModel indoorViewModel, Continuation<? super IndoorViewModel$shouldShowWhExplore$devices$1> continuation) {
        super(2, continuation);
        this.this$0 = indoorViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IndoorViewModel$shouldShowWhExplore$devices$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Device>> continuation) {
        return ((IndoorViewModel$shouldShowWhExplore$devices$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getDeviceManager().getDevices();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
