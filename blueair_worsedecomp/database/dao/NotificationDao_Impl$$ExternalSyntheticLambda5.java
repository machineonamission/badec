package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.NotificationEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationDao_Impl$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ NotificationDao_Impl f$0;
    public final /* synthetic */ NotificationEntity f$1;

    public /* synthetic */ NotificationDao_Impl$$ExternalSyntheticLambda5(NotificationDao_Impl notificationDao_Impl, NotificationEntity notificationEntity) {
        this.f$0 = notificationDao_Impl;
        this.f$1 = notificationEntity;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8300lambda$insert$0$comblueairdatabasedaoNotificationDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
