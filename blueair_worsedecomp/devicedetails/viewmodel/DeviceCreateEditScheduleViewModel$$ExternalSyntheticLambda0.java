package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import kotlin.jvm.functions.Function11;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda0 implements Function11 {
    public final /* synthetic */ DeviceCreateEditScheduleViewModel f$0;

    public /* synthetic */ DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda0(DeviceCreateEditScheduleViewModel deviceCreateEditScheduleViewModel) {
        this.f$0 = deviceCreateEditScheduleViewModel;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11) {
        return DeviceCreateEditScheduleViewModel.configureForModify$lambda$41(this.f$0, (DeviceCreateEditScheduleViewModel.PurifierMode) obj, (MainMode) obj2, (ApSubMode) obj3, (SmartSubMode) obj4, (FanSpeedEnum) obj5, obj6, ((Integer) obj7).intValue(), ((Double) obj8).doubleValue(), ((Double) obj9).doubleValue(), ((Boolean) obj10).booleanValue(), ((Boolean) obj11).booleanValue());
    }
}
