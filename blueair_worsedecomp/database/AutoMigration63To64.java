package com.blueair.database;

import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/database/AutoMigration63To64;", "Landroidx/room/migration/AutoMigrationSpec;", "<init>", "()V", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueairDatabase.kt */
public final class AutoMigration63To64 implements AutoMigrationSpec {
    public void onPostMigrate(SQLiteConnection sQLiteConnection) {
        AutoMigrationSpec.CC.$default$onPostMigrate((AutoMigrationSpec) this, sQLiteConnection);
    }

    public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        AutoMigrationSpec.CC.$default$onPostMigrate((AutoMigrationSpec) this, supportSQLiteDatabase);
    }
}
