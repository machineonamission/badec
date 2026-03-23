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
import kotlinx.coroutines.DelayKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.ble.BleService$startPingJob$1$nuJob$1", f = "BleService.kt", i = {}, l = {258}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BleService.kt */
final class BleService$startPingJob$1$nuJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $macAddress;
    final /* synthetic */ String $uuid;
    int label;
    final /* synthetic */ BleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleService$startPingJob$1$nuJob$1(BleService bleService, String str, String str2, Continuation<? super BleService$startPingJob$1$nuJob$1> continuation) {
        super(2, continuation);
        this.this$0 = bleService;
        this.$uuid = str;
        this.$macAddress = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BleService$startPingJob$1$nuJob$1(this.this$0, this.$uuid, this.$macAddress, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleService$startPingJob$1$nuJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.incrementPingCounter(this.$uuid);
            this.label = 1;
            if (DelayKt.delay(5000, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BleIcpController.IcpDeviceConnectionState connectionState = this.this$0.bleIcpController.getConnectionState(this.$uuid);
        this.this$0.sendConnectionUpdateEvent(this.$uuid, connectionState);
        Timber.Forest forest = Timber.Forest;
        forest.d("BleService - `connection Status = " + connectionState + TokenParser.SP, new Object[0]);
        if (connectionState != BleIcpController.IcpDeviceConnectionState.CONNECTED && System.currentTimeMillis() - this.this$0.lastPingTime > 5000) {
            this.this$0.lastPingTime = System.currentTimeMillis();
            boolean unused = this.this$0.attemptToConnectKnownDevices();
        }
        this.this$0.startPingJob(this.$uuid, this.$macAddress);
        return Unit.INSTANCE;
    }
}
