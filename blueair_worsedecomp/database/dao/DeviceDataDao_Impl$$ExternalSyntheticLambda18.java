package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda18 implements Function1 {
    public final /* synthetic */ DeviceDataDao_Impl f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda18(DeviceDataDao_Impl deviceDataDao_Impl, String str, List list) {
        this.f$0 = deviceDataDao_Impl;
        this.f$1 = str;
        this.f$2 = list;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8296lambda$insertAllAndReplace$3$comblueairdatabasedaoDeviceDataDao_Impl(this.f$1, this.f$2, (SQLiteConnection) obj);
    }
}
