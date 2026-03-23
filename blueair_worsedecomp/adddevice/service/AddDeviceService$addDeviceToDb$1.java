package com.blueair.adddevice.service;

import com.blueair.core.model.DeviceDetailsOnAblServer;
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
@DebugMetadata(c = "com.blueair.adddevice.service.AddDeviceService$addDeviceToDb$1", f = "AddDeviceService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceService.kt */
final class AddDeviceService$addDeviceToDb$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceDetailsOnAblServer $deviceInfo;
    int label;
    final /* synthetic */ AddDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceService$addDeviceToDb$1(AddDeviceService addDeviceService, DeviceDetailsOnAblServer deviceDetailsOnAblServer, Continuation<? super AddDeviceService$addDeviceToDb$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceService;
        this.$deviceInfo = deviceDetailsOnAblServer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceService$addDeviceToDb$1(this.this$0, this.$deviceInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceService$addDeviceToDb$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.deviceManager.addAblDeviceToDb(this.$deviceInfo);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
