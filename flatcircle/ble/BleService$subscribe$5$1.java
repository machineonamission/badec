package io.flatcircle.ble;

import io.flatcircle.ble.BleIcpController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.ble.BleService$subscribe$5$1", f = "BleService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BleService.kt */
final class BleService$subscribe$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BleIcpController.IcpDevice $it;
    int label;
    final /* synthetic */ BleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleService$subscribe$5$1(BleService bleService, BleIcpController.IcpDevice icpDevice, Continuation<? super BleService$subscribe$5$1> continuation) {
        super(2, continuation);
        this.this$0 = bleService;
        this.$it = icpDevice;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BleService$subscribe$5$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleService$subscribe$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            BleIcpController.IcpDeviceConnectionState connectionState = this.this$0.bleIcpController.getConnectionState(this.$it.getUuid());
            Timber.Forest forest = Timber.Forest;
            forest.d("connectSubject: connectionState after response == " + connectionState, new Object[0]);
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("Connection state post connect call: " + connectionState, new Object[0]);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
