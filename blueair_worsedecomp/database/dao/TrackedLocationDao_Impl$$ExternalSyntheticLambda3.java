package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackedLocationDao_Impl$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ TrackedLocationDao_Impl f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ TrackedLocationDao_Impl$$ExternalSyntheticLambda3(TrackedLocationDao_Impl trackedLocationDao_Impl, List list) {
        this.f$0 = trackedLocationDao_Impl;
        this.f$1 = list;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8303lambda$deleteTrackedLocations$3$comblueairdatabasedaoTrackedLocationDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
