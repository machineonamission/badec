package com.blueair.bluetooth.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$getDeviceEvents$2$2 implements Function1<Throwable, Unit> {
    final /* synthetic */ Continuation<String> $cont;

    BleDeviceService$getDeviceEvents$2$2(Continuation<? super String> continuation) {
        this.$cont = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Timber.Forest.e(th, "getDeviceEvents:  onFail", new Object[0]);
        Continuation<String> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(ResultKt.createFailure(th)));
    }
}
