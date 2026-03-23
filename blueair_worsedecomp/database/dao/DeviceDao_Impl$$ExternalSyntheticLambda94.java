package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda94 implements Function1 {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda94(int i, long j, String str) {
        this.f$0 = i;
        this.f$1 = j;
        this.f$2 = str;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateWickdryLeftTime$48(this.f$0, this.f$1, this.f$2, (SQLiteConnection) obj);
    }
}
