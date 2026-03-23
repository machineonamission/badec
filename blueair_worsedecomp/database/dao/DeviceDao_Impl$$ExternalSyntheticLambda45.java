package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda45 implements Function1 {
    public final /* synthetic */ Boolean f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda45(Boolean bool, String str) {
        this.f$0 = bool;
        this.f$1 = str;
    }

    public final Object invoke(Object obj) {
        return DeviceDao_Impl.lambda$updateDisinfection$44(this.f$0, this.f$1, (SQLiteConnection) obj);
    }
}
