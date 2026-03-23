package com.blueair.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/database/BlueairDatabase$Companion$MIGRATION_59_60$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public final class BlueairDatabase$Companion$MIGRATION_59_60$1 extends Migration {
    BlueairDatabase$Companion$MIGRATION_59_60$1() {
        super(59, 60);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshEnabled INTEGER NOT NULL DEFAULT 1");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshStatus INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshDuration INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshTimeStamp INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshStartTimeStamp INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN airRefreshEndTimeStamp INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN roomType INTEGER NOT NULL DEFAULT 0");
    }
}
