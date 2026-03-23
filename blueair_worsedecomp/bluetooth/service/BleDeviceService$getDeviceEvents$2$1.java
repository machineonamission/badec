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
final class BleDeviceService$getDeviceEvents$2$1 implements Function1<CustomCommands.CommandWrapper, Unit> {
    final /* synthetic */ Continuation<String> $cont;

    BleDeviceService$getDeviceEvents$2$1(Continuation<? super String> continuation) {
        this.$cont = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomCommands.CommandWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomCommands.CommandWrapper commandWrapper) {
        Intrinsics.checkNotNullParameter(commandWrapper, "wrappedResponse");
        Timber.Forest forest = Timber.Forest;
        forest.d("getDeviceEvents:  onSuccess: response numberOfEvents: " + commandWrapper.getEventResp().getNumberOfEvents() + ", json = " + commandWrapper.getEventResp().getJson(), new Object[0]);
        Continuation<String> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(commandWrapper.getEventResp().getJson()));
    }
}
