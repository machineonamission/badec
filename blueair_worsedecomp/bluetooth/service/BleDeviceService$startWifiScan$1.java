package com.blueair.bluetooth.service;

import com.blueair.bluetooth.espressif.ResponseListener;
import com.blueair.core.model.Ssid;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/blueair/bluetooth/service/BleDeviceService$startWifiScan$1", "Lcom/blueair/bluetooth/espressif/ResponseListener;", "onSuccess", "", "returnData", "", "onFailure", "e", "Ljava/lang/Exception;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceService$startWifiScan$1 implements ResponseListener {
    final /* synthetic */ Function1<List<Ssid>, Unit> $onResponse;
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$startWifiScan$1(BleDeviceService bleDeviceService, Function1<? super List<Ssid>, Unit> function1) {
        this.this$0 = bleDeviceService;
        this.$onResponse = function1;
    }

    public void onSuccess(byte[] bArr) {
        Timber.Forest.d("Successfully sent start scan", new Object[0]);
        this.this$0.processStartScan(bArr);
        this.this$0.getWifiScanStatus(new BleDeviceService$startWifiScan$1$$ExternalSyntheticLambda0(this.$onResponse));
    }

    /* access modifiers changed from: private */
    public static final Unit onSuccess$lambda$0(Function1 function1, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        function1.invoke(list);
        return Unit.INSTANCE;
    }

    public void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "e");
        Timber.Forest.e(exc, "startWifiScan: onFailure", new Object[0]);
        this.$onResponse.invoke(CollectionsKt.emptyList());
    }
}
