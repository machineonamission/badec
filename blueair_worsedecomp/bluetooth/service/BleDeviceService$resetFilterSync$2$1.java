package com.blueair.bluetooth.service;

import custom.CustomCommands;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
final class BleDeviceService$resetFilterSync$2$1 implements Function1<CustomCommands.CommandWrapper, Unit> {
    final /* synthetic */ Continuation<Boolean> $cont;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$resetFilterSync$2$1(Continuation<? super Boolean> continuation, BleDeviceService bleDeviceService) {
        this.$cont = continuation;
        this.this$0 = bleDeviceService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomCommands.CommandWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomCommands.CommandWrapper commandWrapper) {
        Intrinsics.checkNotNullParameter(commandWrapper, "response");
        Timber.Forest forest = Timber.Forest;
        boolean z = false;
        forest.d("resetFilter: onSuccess: status = " + commandWrapper.getFilterSetResp().getStatus(), new Object[0]);
        Continuation<Boolean> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        if (commandWrapper.getFilterSetResp().getStatus() == CustomCommands.Status.Success) {
            z = true;
        }
        continuation.resumeWith(Result.m9366constructorimpl(Boolean.valueOf(z)));
        this.this$0.resetFilterContinuation = null;
    }
}
