package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.DeviceEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceDao_Impl$$ExternalSyntheticLambda96 implements Function1 {
    public final /* synthetic */ DeviceDao_Impl f$0;
    public final /* synthetic */ DeviceEntity f$1;

    public /* synthetic */ DeviceDao_Impl$$ExternalSyntheticLambda96(DeviceDao_Impl deviceDao_Impl, DeviceEntity deviceEntity) {
        this.f$0 = deviceDao_Impl;
        this.f$1 = deviceEntity;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8292lambda$update$1$comblueairdatabasedaoDeviceDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
