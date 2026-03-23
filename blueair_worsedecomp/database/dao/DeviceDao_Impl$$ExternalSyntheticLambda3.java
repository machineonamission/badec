package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda3(String str, String str2) {
        this.f$0 = str;
        this.f$1 = str2;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateMacAddress$39(this.f$0, this.f$1, (SQLiteConnection) obj);
    }
}
