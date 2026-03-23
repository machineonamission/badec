package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AqiDataDao_Impl$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ String f$0;

    public /* synthetic */ AqiDataDao_Impl$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    public final Object invoke(Object obj) {
        return AqiDataDao_Impl.lambda$getLiveAqiData$5(this.f$0, (SQLiteConnection) obj);
    }
}
