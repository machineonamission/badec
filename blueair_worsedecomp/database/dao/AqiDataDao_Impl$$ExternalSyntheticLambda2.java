package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AqiDataDao_Impl$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ AqiDataDao_Impl f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ AqiDataDao_Impl$$ExternalSyntheticLambda2(AqiDataDao_Impl aqiDataDao_Impl, List list) {
        this.f$0 = aqiDataDao_Impl;
        this.f$1 = list;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8290lambda$insertAll$1$comblueairdatabasedaoAqiDataDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
