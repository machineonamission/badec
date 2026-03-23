package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$resetFilterSync$2$2 implements Function1<Throwable, Unit> {
    final /* synthetic */ Continuation<Boolean> $cont;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$resetFilterSync$2$2(Continuation<? super Boolean> continuation, BleDeviceService bleDeviceService) {
        this.$cont = continuation;
        this.this$0 = bleDeviceService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest.e(th, "resetFilter: onFail", new Object[0]);
        Continuation<Boolean> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(false));
        this.this$0.resetFilterContinuation = null;
    }
}
