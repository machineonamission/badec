package com.blueair.database.repository;

import com.blueair.database.entity.DeviceDataEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceRepository$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ DeviceRepository f$0;

    public /* synthetic */ DeviceRepository$$ExternalSyntheticLambda2(DeviceRepository deviceRepository) {
        this.f$0 = deviceRepository;
    }

    public final Object invoke(Object obj) {
        return DeviceRepository.getLiveLatestDeviceData$lambda$14(this.f$0, (DeviceDataEntity) obj);
    }
}
