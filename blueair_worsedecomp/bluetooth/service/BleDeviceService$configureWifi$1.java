package com.blueair.bluetooth.service;

import com.blueair.bluetooth.espressif.Provision;
import com.blueair.bluetooth.service.BleDeviceState;
import espressif.Constants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/blueair/bluetooth/service/BleDeviceService$configureWifi$1", "Lcom/blueair/bluetooth/espressif/Provision$ProvisionActionListener;", "onComplete", "", "status", "Lespressif/Constants$Status;", "e", "Ljava/lang/Exception;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceService$configureWifi$1 implements Provision.ProvisionActionListener {
    final /* synthetic */ Continuation<Boolean> $provisionCont;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$configureWifi$1(BleDeviceService bleDeviceService, Continuation<? super Boolean> continuation) {
        this.this$0 = bleDeviceService;
        this.$provisionCont = continuation;
    }

    public void onComplete(Constants.Status status, Exception exc) {
        Timber.Forest forest = Timber.Forest;
        forest.d("configureWifi: onComplete status = " + status, new Object[0]);
        if (status == Constants.Status.Success) {
            Timber.Forest.d("configureWifi: onComplete success", new Object[0]);
            this.this$0.updateState(BleDeviceState.WifiConfigured.INSTANCE);
            Continuation<Boolean> continuation = this.$provisionCont;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m9366constructorimpl(true));
            return;
        }
        Timber.Forest.e(exc, "configureWifi: onComplete failed", new Object[0]);
        Continuation<Boolean> continuation2 = this.$provisionCont;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m9366constructorimpl(false));
    }
}
