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
final class BleDeviceService$readFilterSync$2$1 implements Function1<CustomCommands.CommandWrapper, Unit> {
    final /* synthetic */ Continuation<Integer> $cont;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$readFilterSync$2$1(Continuation<? super Integer> continuation, BleDeviceService bleDeviceService) {
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
        forest.d("readFilter: onSuccess: usage = " + commandWrapper.getFilterReadResp().getFilter(), new Object[0]);
        Continuation<Integer> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(Integer.valueOf(commandWrapper.getFilterReadResp().getFilter())));
        this.this$0.readFilterContinuation = null;
    }
}
