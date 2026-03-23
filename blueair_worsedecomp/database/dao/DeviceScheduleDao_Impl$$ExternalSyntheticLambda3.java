package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.DeviceScheduleEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceScheduleDao_Impl$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ DeviceScheduleDao_Impl f$0;
    public final /* synthetic */ DeviceScheduleEntity f$1;

    public /* synthetic */ DeviceScheduleDao_Impl$$ExternalSyntheticLambda3(DeviceScheduleDao_Impl deviceScheduleDao_Impl, DeviceScheduleEntity deviceScheduleEntity) {
        this.f$0 = deviceScheduleDao_Impl;
        this.f$1 = deviceScheduleEntity;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8298lambda$update$1$comblueairdatabasedaoDeviceScheduleDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
