package com.blueair.adddevice.service;

import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.DevicePairManager;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.model.AddDeviceState;
import kotlin.Metadata;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/adddevice/service/AddDeviceService$autoPairDevice$1", "Lcom/blueair/adddevice/DevicePairManager$AutoPairingListener;", "onCompleted", "", "deviceInformation", "Lcom/blueair/adddevice/DeviceInformationLegacy;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceService.kt */
public final class AddDeviceService$autoPairDevice$1 implements DevicePairManager.AutoPairingListener {
    final /* synthetic */ AddDeviceService this$0;

    AddDeviceService$autoPairDevice$1(AddDeviceService addDeviceService) {
        this.this$0 = addDeviceService;
    }

    public void onCompleted(DeviceInformationLegacy deviceInformationLegacy) {
        Timber.Forest forest = Timber.Forest;
        forest.d("autoPairDevice onCompleted:  deviceInformation = " + deviceInformationLegacy + TokenParser.SP, new Object[0]);
        if (deviceInformationLegacy != null) {
            AddDeviceState state = this.this$0.getState();
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("autoPairDevice: Automatic pairing success: " + deviceInformationLegacy, new Object[0]);
            deviceInformationLegacy.setModel((String) null);
            deviceInformationLegacy.setCompatibility(DeviceUtilsLegacy.getDeviceCompatibilityForBackend(state.getDeviceType()));
            this.this$0.deviceConfigSuccess(deviceInformationLegacy, true);
            return;
        }
        Timber.Forest.d("autoPairDevice: Automatic pairing failed", new Object[0]);
        this.this$0.autoConfigFail();
    }
}
