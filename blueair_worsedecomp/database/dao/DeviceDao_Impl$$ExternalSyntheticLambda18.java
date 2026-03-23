package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda18 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda18(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
        this.f$3 = str4;
        this.f$4 = str5;
        this.f$5 = str6;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateSensorRange$24(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (SQLiteConnection) obj);
    }
}
