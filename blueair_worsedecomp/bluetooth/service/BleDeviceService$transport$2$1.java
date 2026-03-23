package com.blueair.bluetooth.service;

import android.bluetooth.BluetoothDevice;
import com.blueair.bluetooth.espressif.BLETransport;
import com.blueair.bluetooth.service.BleDeviceState;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0016¨\u0006\f"}, d2 = {"com/blueair/bluetooth/service/BleDeviceService$transport$2$1", "Lcom/blueair/bluetooth/espressif/BLETransport$BLETransportListener;", "onFailure", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onPeripheralNotConfigured", "device", "Landroid/bluetooth/BluetoothDevice;", "onPeripheralConfigured", "onPeripheralDisconnected", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleDeviceService.kt */
public final class BleDeviceService$transport$2$1 implements BLETransport.BLETransportListener {
    final /* synthetic */ BleDeviceService this$0;

    BleDeviceService$transport$2$1(BleDeviceService bleDeviceService) {
        this.this$0 = bleDeviceService;
    }

    public void onFailure(Exception exc) {
        Timber.Forest.e(exc, "onFailure", new Object[0]);
        this.this$0.updateError(new BleDeviceError(this.this$0.getState(), exc != null ? exc.getMessage() : null));
        this.this$0.disconnect();
    }

    public void onPeripheralNotConfigured(BluetoothDevice bluetoothDevice) {
        Timber.Forest.e("onPeripheralNotConfigured", new Object[0]);
        this.this$0.updateError(new BleDeviceError(BleDeviceState.Connecting.INSTANCE, "onPeripheralNotConfigured"));
        this.this$0.disconnect();
    }

    public void onPeripheralConfigured(BluetoothDevice bluetoothDevice) {
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("onPeripheralConfigured: deviceCapabilities = ");
        BLETransport transport = this.this$0.getTransport();
        sb.append(transport != null ? transport.deviceCapabilities : null);
        forest.d(sb.toString(), new Object[0]);
        this.this$0.updateState(BleDeviceState.Connected.INSTANCE);
    }

    public void onPeripheralDisconnected(Exception exc) {
        Timber.Forest.d("BLETransport.BLETransportListener.onPeripheralDisconnected", new Object[0]);
        this.this$0.updateState(BleDeviceState.Disconnected.INSTANCE);
    }
}
