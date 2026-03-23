package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.TrackedLocationEntity;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackedLocationDao_Impl$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ TrackedLocationDao_Impl f$0;
    public final /* synthetic */ TrackedLocationEntity f$1;

    public /* synthetic */ TrackedLocationDao_Impl$$ExternalSyntheticLambda13(TrackedLocationDao_Impl trackedLocationDao_Impl, TrackedLocationEntity trackedLocationEntity) {
        this.f$0 = trackedLocationDao_Impl;
        this.f$1 = trackedLocationEntity;
    }

    public final Object invoke(Object obj) {
        return this.f$0.m8306lambda$update$4$comblueairdatabasedaoTrackedLocationDao_Impl(this.f$1, (SQLiteConnection) obj);
    }
}
