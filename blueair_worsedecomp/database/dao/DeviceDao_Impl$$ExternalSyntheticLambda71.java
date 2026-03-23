package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda71 implements Function1 {
    public final /* synthetic */ Integer f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda71(Integer num, String str, String str2) {
        this.f$0 = num;
        this.f$1 = str;
        this.f$2 = str2;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateFanSpeedAndAutoMode$14(this.f$0, this.f$1, this.f$2, (SQLiteConnection) obj);
    }
}
