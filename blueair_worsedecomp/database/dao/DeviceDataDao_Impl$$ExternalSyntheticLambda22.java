package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.DeviceDataEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda22 implements Function1 {
    public final /* synthetic */ DeviceDataDao_Impl f$0;
    public final /* synthetic */ DeviceDataEntity f$1;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda22(DeviceDataDao_Impl deviceDataDao_Impl, DeviceDataEntity deviceDataEntity) {
        this.f$0 = deviceDataDao_Impl;
        this.f$1 = deviceDataEntity;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8293lambda$insert$0$comblueairdatabasedaoDeviceDataDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
