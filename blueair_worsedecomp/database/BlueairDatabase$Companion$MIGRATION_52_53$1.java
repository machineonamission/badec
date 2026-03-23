package com.blueair.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/database/BlueairDatabase$Companion$MIGRATION_52_53$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public final class BlueairDatabase$Companion$MIGRATION_52_53$1 extends Migration {
    BlueairDatabase$Companion$MIGRATION_52_53$1() {
        super(52, 53);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN temperatureUnit INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationState INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationAngle INTEGER NOT NULL DEFAULT 90");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationDirection INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN oscillationFanSpeed INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN mainMode INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN apSubMode INTEGER NOT NULL DEFAULT 2");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN apFanSpeed INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN heatSubMode INTEGER NOT NULL DEFAULT 2");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN heatFanSpeed INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN heatAutoTmp REAL NOT NULL DEFAULT 22.0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN heatEcoTmp REAL NOT NULL DEFAULT 22.0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN coolSubMode INTEGER NOT NULL DEFAULT 2");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN coolFanSpeed INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN coolAutoTag INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN coolAutoPresets TEXT NOT NULL DEFAULT ''");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN coolEcoTag INTEGER NOT NULL DEFAULT 0");
        supportSQLiteDatabase.execSQL("ALTER TABLE `device_table` ADD COLUMN coolEcoPresets TEXT NOT NULL DEFAULT ''");
    }
}
