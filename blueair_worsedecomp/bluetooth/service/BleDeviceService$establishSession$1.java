package com.blueair.bluetooth.service;

import com.blueair.bluetooth.espressif.Session;
import com.blueair.bluetooth.service.BleDeviceState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/blueair/bluetooth/service/BleDeviceService$establishSession$1", "Lcom/blueair/bluetooth/espressif/Session$SessionListener;", "OnSessionEstablished", "", "OnSessionEstablishFailed", "e", "Ljava/lang/Exception;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceService$establishSession$1 implements Session.SessionListener {
    final /* synthetic */ Function0<Unit> $onSessionEstablished;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$establishSession$1(BleDeviceService bleDeviceService, Function0<Unit> function0) {
        this.this$0 = bleDeviceService;
        this.$onSessionEstablished = function0;
    }

    public void OnSessionEstablished() {
        Timber.Forest.d("OnSessionEstablished", new Object[0]);
        this.this$0.updateState(BleDeviceState.SessionEstablished.INSTANCE);
        Function0<Unit> function0 = this.$onSessionEstablished;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void OnSessionEstablishFailed(Exception exc) {
        Timber.Forest.e("OnSessionEstablishFailed", new Object[0]);
        this.this$0.updateError(new BleDeviceError(BleDeviceState.SessionEstablishing.INSTANCE, exc != null ? exc.getMessage() : null));
    }
}
