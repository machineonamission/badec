package com.blueair.bluetooth.service;

import com.blueair.bluetooth.service.BleDeviceState;
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
final class BleDeviceService$startProvisioningSync$2$1 implements Function1<CustomCommands.CommandWrapper, Unit> {
    final /* synthetic */ Continuation<Boolean> $cont;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$startProvisioningSync$2$1(BleDeviceService bleDeviceService, Continuation<? super Boolean> continuation) {
        this.this$0 = bleDeviceService;
        this.$cont = continuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CustomCommands.CommandWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CustomCommands.CommandWrapper commandWrapper) {
        Intrinsics.checkNotNullParameter(commandWrapper, "response");
        Timber.Forest forest = Timber.Forest;
        boolean z = false;
        forest.d("startProvisioning: onSuccess: status: " + commandWrapper.getStartResp().getStatus() + ", status value = " + commandWrapper.getStartResp().getStatusValue(), new Object[0]);
        this.this$0.updateState(BleDeviceState.ProvisioningStarted.INSTANCE);
        Continuation<Boolean> continuation = this.$cont;
        Result.Companion companion = Result.Companion;
        if (commandWrapper.getStartResp().getStatus() == CustomCommands.Status.Success) {
            z = true;
        }
        continuation.resumeWith(Result.m9366constructorimpl(Boolean.valueOf(z)));
    }
}
