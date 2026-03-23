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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.DeviceRepository$deleteAllDevicesBackground$1", f = "DeviceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceRepository.kt */
final class DeviceRepository$deleteAllDevicesBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isAblDevice;
    int label;
    final /* synthetic */ DeviceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceRepository$deleteAllDevicesBackground$1(DeviceRepository deviceRepository, boolean z, Continuation<? super DeviceRepository$deleteAllDevicesBackground$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceRepository;
        this.$isAblDevice = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceRepository$deleteAllDevicesBackground$1(this.this$0, this.$isAblDevice, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceRepository$deleteAllDevicesBackground$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.blueairDb.deviceDao().deleteAll(this.$isAblDevice);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
