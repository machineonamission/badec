package com.blueair.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/database/BlueairDatabase$Companion$MIGRATION_49_50$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public final class BlueairDatabase$Companion$MIGRATION_49_50$1 extends Migration {
    BlueairDatabase$Companion$MIGRATION_49_50$1() {
        super(49, 50);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN isEcoModeOn INTEGER NOT NULL DEFAULT 0");
    }
}
