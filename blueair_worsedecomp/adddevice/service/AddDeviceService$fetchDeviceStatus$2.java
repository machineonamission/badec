package com.blueair.adddevice.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.service.AddDeviceService$fetchDeviceStatus$2", f = "AddDeviceService.kt", i = {}, l = {900}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceService.kt */
final class AddDeviceService$fetchDeviceStatus$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $deviceUUID;
    int label;
    final /* synthetic */ AddDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceService$fetchDeviceStatus$2(AddDeviceService addDeviceService, String str, Continuation<? super AddDeviceService$fetchDeviceStatus$2> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceService;
        this.$deviceUUID = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceService$fetchDeviceStatus$2(this.this$0, this.$deviceUUID, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AddDeviceService$fetchDeviceStatus$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object ablDeviceStatus = this.this$0.deviceManager.getAblDeviceStatus(this.$deviceUUID, this);
            return ablDeviceStatus == coroutine_suspended ? coroutine_suspended : ablDeviceStatus;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
