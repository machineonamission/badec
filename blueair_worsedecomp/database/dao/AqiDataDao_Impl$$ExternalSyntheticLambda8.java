package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AqiDataDao_Impl$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ AqiDataDao_Impl$$ExternalSyntheticLambda8(String str, List list) {
        this.f$0 = str;
        this.f$1 = list;
    }

    public final Object invoke(Object obj) {
        return AqiDataDao_Impl.lambda$delete$7(this.f$0, this.f$1, (SQLiteConnection) obj);
    }
}
