package com.blueair.bluetooth.service;

import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.bluetooth.service.BleDeviceService$pollDeviceBounded$3", f = "BleDeviceService.kt", i = {}, l = {784}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$pollDeviceBounded$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PublishSubject<String> $eventPublisher;
    final /* synthetic */ Disposable $pollingDisposable;
    int label;
    final /* synthetic */ BleDeviceService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BleDeviceService$pollDeviceBounded$3(BleDeviceService bleDeviceService, PublishSubject<String> publishSubject, Disposable disposable, Continuation<? super BleDeviceService$pollDeviceBounded$3> continuation) {
        super(2, continuation);
        this.this$0 = bleDeviceService;
        this.$eventPublisher = publishSubject;
        this.$pollingDisposable = disposable;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BleDeviceService$pollDeviceBounded$3(this.this$0, this.$eventPublisher, this.$pollingDisposable, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BleDeviceService$pollDeviceBounded$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BleDeviceService bleDeviceService = this.this$0;
            PublishSubject<String> publishSubject = this.$eventPublisher;
            Disposable disposable = this.$pollingDisposable;
            Intrinsics.checkNotNull(disposable);
            this.label = 1;
            if (bleDeviceService.startPollDeviceBounded(publishSubject, disposable, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
