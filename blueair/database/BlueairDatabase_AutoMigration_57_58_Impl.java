package com.blueair.database;

import androidx.room.migration.Migration;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;

final class BlueairDatabase_AutoMigration_57_58_Impl extends Migration {
   public BlueairDatabase_AutoMigration_57_58_Impl() {
      super(57, 58);
   }

   public void migrate(SQLiteConnection var1) {
      SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `notification_table` (`deviceId` TEXT NOT NULL, `filterType` TEXT NOT NULL, `filterLifeLevel` INTEGER NOT NULL, `dismissed` INTEGER NOT NULL, `datetime` INTEGER NOT NULL, PRIMARY KEY(`deviceId`, `filterType`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
   }
}
