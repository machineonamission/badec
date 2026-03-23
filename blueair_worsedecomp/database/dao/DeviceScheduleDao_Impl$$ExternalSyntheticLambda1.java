package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceScheduleDao_Impl$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ String f$0;

    public /* synthetic */ DeviceScheduleDao_Impl$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    public final Object invoke(Object obj) {
        return DeviceScheduleDao_Impl.lambda$getByDeviceId$4(this.f$0, (SQLiteConnection) obj);
    }
}
