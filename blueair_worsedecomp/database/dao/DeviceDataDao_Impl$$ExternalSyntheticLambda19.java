package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda19 implements Function1 {
    public final /* synthetic */ long f$0;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda19(long j) {
        this.f$0 = j;
    }

    public final Object invoke(Object obj) {
        return DeviceDataDao_Impl.lambda$deleteAllOldDeviceData$20(this.f$0, (SQLiteConnection) obj);
    }
}
