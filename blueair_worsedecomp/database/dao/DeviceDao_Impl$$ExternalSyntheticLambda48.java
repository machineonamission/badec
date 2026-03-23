package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda48 implements Function1 {
    public final /* synthetic */ double f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda48(double d, String str) {
        this.f$0 = d;
        this.f$1 = str;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateHeatAutoTmp$65(this.f$0, this.f$1, (SQLiteConnection) obj);
    }
}
