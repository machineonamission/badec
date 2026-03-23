package com.blueair.database;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/database/BlueairDatabase$Companion$MIGRATION_68_69$1", "Landroidx/room/migration/Migration;", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public final class BlueairDatabase$Companion$MIGRATION_68_69$1 extends Migration {
    BlueairDatabase$Companion$MIGRATION_68_69$1() {
        super(68, 69);
    }

    public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        supportSQLiteDatabase.execSQL("CREATE TABLE notification_table_new (\n    deviceId TEXT NOT NULL,\n    type TEXT NOT NULL,\n    subType TEXT NOT NULL,\n    subLevel INTEGER NOT NULL,\n    dismissed INTEGER NOT NULL DEFAULT 0,\n    datetime INTEGER NOT NULL,\n    dismissTime INTEGER NOT NULL DEFAULT 0,\n    PRIMARY KEY(deviceId, type, subType),\n    FOREIGN KEY(deviceId) REFERENCES device_table(uid) ON DELETE CASCADE\n)");
        supportSQLiteDatabase.execSQL("INSERT INTO notification_table_new \n(deviceId, type, subType, subLevel, dismissed, datetime, dismissTime)\nSELECT \n    deviceId, \n    'FILTER_LIFE' AS type, \n    filterType AS subType,  \n    filterLifeLevel AS subLevel, \n    dismissed,\n    datetime,\n    0 AS dismissTime \nFROM notification_table");
        supportSQLiteDatabase.execSQL("DROP TABLE notification_table");
        supportSQLiteDatabase.execSQL("ALTER TABLE notification_table_new RENAME TO notification_table");
    }
}
