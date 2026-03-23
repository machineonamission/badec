package io.flatcircle.ble;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "io.flatcircle.ble.BleService$startPingJob$1", f = "BleService.kt", i = {0}, l = {253}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: BleService.kt */
final class BleService$startPingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $macAddress;
    final /* synthetic */ int $oldIndex;
    final /* synthetic */ Pair<String, Job> $oldJob;
    final /* synthetic */ String $uuid;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleService$startPingJob$1(Pair<String, ? extends Job> pair, int i, BleService bleService, String str, String str2, Continuation<? super BleService$startPingJob$1> continuation) {
        super(2, continuation);
        this.$oldJob = pair;
        this.$oldIndex = i;
        this.this$0 = bleService;
        this.$uuid = str;
        this.$macAddress = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BleService$startPingJob$1 bleService$startPingJob$1 = new BleService$startPingJob$1(this.$oldJob, this.$oldIndex, this.this$0, this.$uuid, this.$macAddress, continuation);
        bleService$startPingJob$1.L$0 = obj;
        return bleService$startPingJob$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleService$startPingJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Job second;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Pair<String, Job> pair = this.$oldJob;
            if (!(pair == null || (second = pair.getSecond()) == null)) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (JobKt.cancelAndJoin(second, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Job launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new BleService$startPingJob$1$nuJob$1(this.this$0, this.$uuid, this.$macAddress, (Continuation<? super BleService$startPingJob$1$nuJob$1>) null), 3, (Object) null);
        int i2 = this.$oldIndex;
        if (i2 < 0 || i2 > this.this$0.pingJobs.size() - 1) {
            Serializable boxBoolean = Boxing.boxBoolean(this.this$0.pingJobs.add(TuplesKt.to(this.$uuid, launch$default)));
        } else {
            Serializable serializable = (Serializable) this.this$0.pingJobs.set(this.$oldIndex, TuplesKt.to(this.$uuid, launch$default));
        }
        return Unit.INSTANCE;
    }
}
