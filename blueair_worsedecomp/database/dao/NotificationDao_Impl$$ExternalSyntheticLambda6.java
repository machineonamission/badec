package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationDao_Impl$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ NotificationDao_Impl$$ExternalSyntheticLambda6(long j, String str, String str2, String str3) {
        this.f$0 = j;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = str3;
    }

    public final Object invoke(Object obj) {
        return NotificationDao_Impl.lambda$dismiss$7(this.f$0, this.f$1, this.f$2, this.f$3, (SQLiteConnection) obj);
    }
}
