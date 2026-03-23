package com.blueair.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/database/BlueairDatabase$Companion$MIGRATION_61_62$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public final class BlueairDatabase$Companion$MIGRATION_61_62$1 extends Migration {
    BlueairDatabase$Companion$MIGRATION_61_62$1() {
        super(61, 62);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN nightLampEnabled INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN nightLampBrightness INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryDuration INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN wickdryDone INTEGER NOT NULL DEFAULT 0");
    }
}
