package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDataDao_Impl$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ String f$0;

    public /* synthetic */ DeviceDataDao_Impl$$ExternalSyntheticLambda10(String str) {
        this.f$0 = str;
    }

    public final Object invoke(Object obj) {
        return DeviceDataDao_Impl.lambda$deleteAllForDevice$18(this.f$0, (SQLiteConnection) obj);
    }
}
