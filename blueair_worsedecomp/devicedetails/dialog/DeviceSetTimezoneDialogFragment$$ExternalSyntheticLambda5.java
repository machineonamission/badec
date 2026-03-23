package com.blueair.devicedetails.dialog;

import com.blueair.devicedetails.databinding.DialogfragmentDeviceSetTimezoneBinding;
import java.util.TimeZone;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda5 implements Function2 {
    public final /* synthetic */ DeviceSetTimezoneDialogFragment f$0;
    public final /* synthetic */ DialogfragmentDeviceSetTimezoneBinding f$1;

    public /* synthetic */ DeviceSetTimezoneDialogFragment$$ExternalSyntheticLambda5(DeviceSetTimezoneDialogFragment deviceSetTimezoneDialogFragment, DialogfragmentDeviceSetTimezoneBinding dialogfragmentDeviceSetTimezoneBinding) {
        this.f$0 = deviceSetTimezoneDialogFragment;
        this.f$1 = dialogfragmentDeviceSetTimezoneBinding;
    }

    public final Object invoke(Object obj, Object obj2) {
        return DeviceSetTimezoneDialogFragment.onCreateView$lambda$14$lambda$7(this.f$0, this.f$1, ((Integer) obj).intValue(), (TimeZone) obj2);
    }
}
