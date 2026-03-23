package com.blueair.bluetooth.service;

import com.blueair.bluetooth.espressif.ResponseListener;
import custom.CustomCommands;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0006\u001a\u00020\u00032\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016¨\u0006\n"}, d2 = {"com/blueair/bluetooth/service/BleDeviceService$sendWrapper$1", "Lcom/blueair/bluetooth/espressif/ResponseListener;", "onSuccess", "", "returnData", "", "onFailure", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceService$sendWrapper$1 implements ResponseListener {
    final /* synthetic */ Function1<Throwable, Unit> $onFail;
    final /* synthetic */ Function1<CustomCommands.CommandWrapper, Unit> $onSuccess;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$sendWrapper$1(Function1<? super CustomCommands.CommandWrapper, Unit> function1, BleDeviceService bleDeviceService, Function1<? super Throwable, Unit> function12) {
        this.$onSuccess = function1;
        this.this$0 = bleDeviceService;
        this.$onFail = function12;
    }

    public void onSuccess(byte[] bArr) {
        Timber.Forest.d("sendWrapper: sendConfigData: Successfully sent custom command", new Object[0]);
        try {
            this.$onSuccess.invoke(this.this$0.processCustomCommand(bArr));
        } catch (Throwable th) {
            this.$onFail.invoke(th);
        }
    }

    public void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        Timber.Forest.e(exc, "sendWrapper: sendConfigData failed", new Object[0]);
        this.$onFail.invoke(exc);
    }
}
