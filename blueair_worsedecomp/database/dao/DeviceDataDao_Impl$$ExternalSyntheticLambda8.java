package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda8(String str, long j, long j2) {
        this.f$0 = str;
        this.f$1 = j;
        this.f$2 = j2;
    }

    public final Object invoke(Object obj) {
        return DeviceDataDao_Impl.lambda$getFlowDeviceNonRealTimeDataBetween$8(this.f$0, this.f$1, this.f$2, (SQLiteConnection) obj);
    }
}
