package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda12 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda12(String str, long j) {
        this.f$0 = str;
        this.f$1 = j;
    }

    public final Object invoke(Object obj) {
        return DeviceDataDao_Impl.lambda$getFlowDeviceDataSince$6(this.f$0, this.f$1, (SQLiteConnection) obj);
    }
}
