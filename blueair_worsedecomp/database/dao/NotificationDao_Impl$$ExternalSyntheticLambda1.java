package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationDao_Impl$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ NotificationDao_Impl$$ExternalSyntheticLambda1(String str, String str2, String str3) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
    }

    public final Object invoke(Object obj) {
        return NotificationDao_Impl.lambda$getNotification$4(this.f$0, this.f$1, this.f$2, (SQLiteConnection) obj);
    }
}
