package com.blueair.database.repository;

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
@DebugMetadata(c = "com.blueair.database.repository.DeviceRepository$deleteOldDeviceData$2", f = "DeviceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceRepository.kt */
final class DeviceRepository$deleteOldDeviceData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $deviceId;
    final /* synthetic */ long $monthAgoSeconds;
    int label;
    final /* synthetic */ DeviceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceRepository$deleteOldDeviceData$2(String str, long j, DeviceRepository deviceRepository, Continuation<? super DeviceRepository$deleteOldDeviceData$2> continuation) {
        super(2, continuation);
        this.$deviceId = str;
        this.$monthAgoSeconds = j;
        this.this$0 = deviceRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceRepository$deleteOldDeviceData$2(this.$deviceId, this.$monthAgoSeconds, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceRepository$deleteOldDeviceData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Timber.Forest forest = Timber.Forest;
            forest.v("deleteOldDeviceData: deviceId = " + this.$deviceId + ", monthAgoSeconds = " + this.$monthAgoSeconds, new Object[0]);
            this.this$0.blueairDb.deviceDataDao().deleteOldDeviceData(this.$deviceId, this.$monthAgoSeconds);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
