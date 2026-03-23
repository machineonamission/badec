package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.AqiDataEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AqiDataDao_Impl$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ AqiDataDao_Impl f$0;
    public final /* synthetic */ AqiDataEntity f$1;

    public /* synthetic */ AqiDataDao_Impl$$ExternalSyntheticLambda5(AqiDataDao_Impl aqiDataDao_Impl, AqiDataEntity aqiDataEntity) {
        this.f$0 = aqiDataDao_Impl;
        this.f$1 = aqiDataEntity;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8289lambda$insert$0$comblueairdatabasedaoAqiDataDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
