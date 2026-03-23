package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceScheduleDao_Impl$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ DeviceScheduleDao_Impl f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ DeviceScheduleDao_Impl$$ExternalSyntheticLambda5(DeviceScheduleDao_Impl deviceScheduleDao_Impl, List list) {
        this.f$0 = deviceScheduleDao_Impl;
        this.f$1 = list;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8297lambda$insert$0$comblueairdatabasedaoDeviceScheduleDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
