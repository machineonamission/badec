package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda30 implements Function1 {
    public final /* synthetic */ Double f$0;
    public final /* synthetic */ Double f$1;
    public final /* synthetic */ Integer f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Boolean f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda30(Double d, Double d2, Integer num, String str, Boolean bool, String str2) {
        this.f$0 = d;
        this.f$1 = d2;
        this.f$2 = num;
        this.f$3 = str;
        this.f$4 = bool;
        this.f$5 = str2;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateWelcomeHome$43(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (SQLiteConnection) obj);
    }
}
