package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda69 implements Function1 {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Float f$1;
    public final /* synthetic */ Float f$2;
    public final /* synthetic */ Float f$3;
    public final /* synthetic */ Float f$4;
    public final /* synthetic */ Float f$5;
    public final /* synthetic */ Float f$6;
    public final /* synthetic */ Float f$7;
    public final /* synthetic */ Float f$8;
    public final /* synthetic */ String f$9;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda69(long j, Float f, Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, Float f8, String str) {
        this.f$0 = j;
        this.f$1 = f;
        this.f$2 = f2;
        this.f$3 = f3;
        this.f$4 = f4;
        this.f$5 = f5;
        this.f$6 = f6;
        this.f$7 = f7;
        this.f$8 = f8;
        this.f$9 = str;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateLatestSensorDataPoint$11(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (SQLiteConnection) obj);
    }
}
