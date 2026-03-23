package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda16 implements Function1 {
    public final /* synthetic */ DeviceDataDao_Impl f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda16(DeviceDataDao_Impl deviceDataDao_Impl, List list) {
        this.f$0 = deviceDataDao_Impl;
        this.f$1 = list;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8294lambda$insertAll$1$comblueairdatabasedaoDeviceDataDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
