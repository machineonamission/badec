package com.blueair.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.blueair.database.dao.AqiDataDao;
import com.blueair.database.dao.AqiDataDao_Impl;
import com.blueair.database.dao.DeviceDao;
import com.blueair.database.dao.DeviceDao_Impl;
import com.blueair.database.dao.DeviceDataDao;
import com.blueair.database.dao.DeviceDataDao_Impl;
import com.blueair.database.dao.DeviceScheduleDao;
import com.blueair.database.dao.DeviceScheduleDao_Impl;
import com.blueair.database.dao.NotificationDao;
import com.blueair.database.dao.NotificationDao_Impl;
import com.blueair.database.dao.TrackedLocationDao;
import com.blueair.database.dao.TrackedLocationDao_Impl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class BlueairDatabase_Impl extends BlueairDatabase {
   private volatile AqiDataDao _aqiDataDao;
   private volatile DeviceDao _deviceDao;
   private volatile DeviceDataDao _deviceDataDao;
   private volatile DeviceScheduleDao _deviceScheduleDao;
   private volatile NotificationDao _notificationDao;
   private volatile TrackedLocationDao _trackedLocationDao;

   public AqiDataDao aqiDataDao() {
      if (this._aqiDataDao != null) {
         return this._aqiDataDao;
      } else {
         synchronized(this){}

         Throwable var10000;
         label136: {
            try {
               if (this._aqiDataDao == null) {
                  AqiDataDao_Impl var1 = new AqiDataDao_Impl(this);
                  this._aqiDataDao = var1;
               }
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label136;
            }

            label133:
            try {
               AqiDataDao var15 = this._aqiDataDao;
               return var15;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var16 = false;
               break label133;
            }
         }

         while(true) {
            Throwable var14 = var10000;

            try {
               throw var14;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               continue;
            }
         }
      }
   }

   public void clearAllTables() {
      super.performClear(true, new String[]{"device_table", "device_data", "tracked_location_table", "aqi_data_table", "device_schedule_table", "notification_table"});
   }

   protected InvalidationTracker createInvalidationTracker() {
      return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"device_table", "device_data", "tracked_location_table", "aqi_data_table", "device_schedule_table", "notification_table"});
   }

   protected RoomOpenDelegate createOpenDelegate() {
      return new RoomOpenDelegate(this, 71, "52cd44c9b7bebf8db8a9280628049fc6", "bfbc6a439546649f2792f37e7d1a439b") {
         final BlueairDatabase_Impl this$0;

         {
            this.this$0 = var1;
         }

         public void createAllTables(SQLiteConnection var1) {
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `device_table` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `modelName` TEXT NOT NULL, `typeIndex` INTEGER NOT NULL, `fanSpeed` INTEGER, `filterLife` INTEGER, `autoModeText` TEXT, `brightness` INTEGER, `info` TEXT, `hasFinishedOnboarding` INTEGER NOT NULL, `lastSelectedSensorType` INTEGER, `isAblDevice` INTEGER NOT NULL, `isNightModeOn` INTEGER NOT NULL, `isChildLockOn` INTEGER NOT NULL, `linkedDeviceUid` TEXT, `connectivityStatusIndex` INTEGER NOT NULL, `lastConnectivityMillis` INTEGER NOT NULL, `mac` TEXT NOT NULL, `mcuFirmware` TEXT NOT NULL, `wifiFirmware` TEXT NOT NULL, `hardware` TEXT NOT NULL, `timeZone` TEXT NOT NULL, `serial` TEXT NOT NULL, `purchaseDate` TEXT NOT NULL, `dealerName` TEXT NOT NULL, `dealerCountry` TEXT NOT NULL, `filterType` TEXT NOT NULL, `filterTrigger` TEXT NOT NULL, `pm1Ranges` TEXT NOT NULL, `pm10Ranges` TEXT NOT NULL, `pm25Ranges` TEXT NOT NULL, `vocRanges` TEXT NOT NULL, `hchoRanges` TEXT NOT NULL, `updateProgress` INTEGER NOT NULL, `isStandByOn` INTEGER NOT NULL, `isEcoModeOn` INTEGER NOT NULL, `isHinsModeOn` INTEGER NOT NULL, `isHinsNightModeOn` INTEGER NOT NULL, `isG4NightModeOn` INTEGER NOT NULL, `isGermShieldOn` INTEGER NOT NULL, `isGermShieldNightModeOn` INTEGER, `isSafetySwitchOn` INTEGER NOT NULL, `g4NightModefilterTrigger` TEXT NOT NULL, `aimInstalled` INTEGER NOT NULL, `sku` TEXT, `compatibility` TEXT, `locationId` TEXT, `disinfection` INTEGER, `disinfectLeftTime` INTEGER, `disinfectLeftTimeUpdateTime` INTEGER, `wickdryEnabled` INTEGER NOT NULL, `wickdryOn` INTEGER NOT NULL, `wickdryLeftTime` INTEGER NOT NULL, `wickdryLeftTimeUpdateTime` INTEGER NOT NULL, `wickUsage` INTEGER NOT NULL, `waterShortage` INTEGER NOT NULL, `autoRh` INTEGER NOT NULL, `timerStatus` INTEGER NOT NULL, `timerDuration` INTEGER NOT NULL, `timerLeftTime` INTEGER NOT NULL, `timerLeftTimeUpdateTime` INTEGER NOT NULL, `temperatureUnit` INTEGER NOT NULL, `oscillationState` INTEGER NOT NULL, `oscillationAngle` INTEGER NOT NULL, `oscillationDirection` INTEGER NOT NULL, `oscillationFanSpeed` INTEGER NOT NULL, `mainMode` INTEGER NOT NULL, `apSubMode` INTEGER NOT NULL, `apFanSpeed` INTEGER NOT NULL, `heatSubMode` INTEGER NOT NULL, `heatFanSpeed` INTEGER NOT NULL, `heatAutoTmp` REAL NOT NULL, `heatEcoTmp` REAL NOT NULL, `coolSubMode` INTEGER NOT NULL, `coolFanSpeed` INTEGER NOT NULL, `coolAutoTag` INTEGER NOT NULL, `coolAutoPresets` TEXT NOT NULL, `coolEcoTag` INTEGER NOT NULL, `coolEcoPresets` TEXT NOT NULL, `humMode` INTEGER NOT NULL, `mode` INTEGER NOT NULL, `waterLevel` INTEGER NOT NULL, `dehSubMode` INTEGER NOT NULL, `waterTankFailure` INTEGER NOT NULL, `smartSubMode` INTEGER NOT NULL, `detectCat` INTEGER NOT NULL, `bodyMounted` INTEGER NOT NULL, `cleanAirEta` INTEGER NOT NULL, `panelDisplayMode` INTEGER NOT NULL, `hoverEnabled` INTEGER NOT NULL, `airRefreshEnabled` INTEGER NOT NULL, `airRefreshStatus` INTEGER NOT NULL, `airRefreshDuration` INTEGER NOT NULL, `airRefreshTimeStamp` INTEGER NOT NULL, `airRefreshStartTimeStamp` INTEGER NOT NULL, `airRefreshEndTimeStamp` INTEGER NOT NULL, `roomType` INTEGER NOT NULL, `nightLampBrightness` INTEGER NOT NULL, `wickdryDuration` INTEGER NOT NULL, `wickdryDone` INTEGER NOT NULL, `ywrmEnabled` INTEGER, `ywrmUsage` INTEGER NOT NULL, `nightLampSteplessBrightness` INTEGER NOT NULL, `alarms` TEXT NOT NULL, `humSubMode` INTEGER NOT NULL, `use24Hour` INTEGER NOT NULL, `waterInfill` INTEGER NOT NULL, `sensorMode` INTEGER NOT NULL, `coolFanSpeedLevel` INTEGER NOT NULL, `coolAutoLevel` INTEGER NOT NULL, `nightModeStartTime` INTEGER NOT NULL, `rpm1` INTEGER NOT NULL, `nightPeriods` TEXT NOT NULL, `uuid` TEXT, `ssid` TEXT, `bssid` TEXT, `ipv4` TEXT, `ipv6` TEXT, `timeInSeconds` INTEGER, `pm1` REAL, `pm10` REAL, `pm25` REAL, `voc` REAL, `hcho` REAL, `tmp` REAL, `hum` REAL, `fan` REAL, `weight` REAL, `rpm` REAL, `lat` REAL, `lng` REAL, `radius` INTEGER, `textValue` TEXT, `isEnabled` INTEGER, `oscillationMode` INTEGER NOT NULL, `horizontalOscillationState` INTEGER NOT NULL, `horizontalOscillationFixAngle` INTEGER NOT NULL, `horizontalOscillationMinAngle` INTEGER NOT NULL, `horizontalOscillationMaxAngle` INTEGER NOT NULL, `verticalOscillationState` INTEGER NOT NULL, `verticalOscillationFixAngle` INTEGER NOT NULL, `verticalOscillationMinAngle` INTEGER NOT NULL, `verticalOscillationMaxAngle` INTEGER NOT NULL, `horizontalCalibrationState` INTEGER NOT NULL, `verticalCalibrationState` INTEGER NOT NULL, PRIMARY KEY(`uid`))");
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `device_data` (`id` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `time` INTEGER NOT NULL, `pm1` REAL, `pm10` REAL, `pm25` REAL, `voc` REAL, `hcho` REAL, `tmp` REAL, `hum` REAL, `fan` REAL, `weight` REAL, `rpm` REAL, `trend` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            SQLite.execSQL(var1, "CREATE INDEX IF NOT EXISTS `index_device_data_deviceId` ON `device_data` (`deviceId`)");
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `tracked_location_table` (`id` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `locationName` TEXT, `cityName` TEXT, `stateName` TEXT, `countryName` TEXT, `countryCode` TEXT, `mapType` TEXT, PRIMARY KEY(`id`))");
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `aqi_data_table` (`trackedLocationId` TEXT NOT NULL, `datetime` INTEGER NOT NULL, `co` REAL, `no2` REAL, `o3` REAL, `pm10` REAL, `pm25` REAL, `so2` REAL, `aqi` REAL, PRIMARY KEY(`trackedLocationId`))");
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `device_schedule_table` (`deviceId` TEXT NOT NULL, `scheduleId` TEXT NOT NULL, `scheduleName` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `instructions` TEXT NOT NULL, `paused` INTEGER NOT NULL, `daysOfWeek` TEXT NOT NULL, `timeZone` TEXT NOT NULL, `endInstructions` TEXT, `scheduleEndType` TEXT, PRIMARY KEY(`scheduleId`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS `notification_table` (`deviceId` TEXT NOT NULL, `type` TEXT NOT NULL, `subType` TEXT NOT NULL, `subLevel` INTEGER NOT NULL, `dismissed` INTEGER NOT NULL, `dismissTime` INTEGER NOT NULL, `datetime` INTEGER NOT NULL, PRIMARY KEY(`deviceId`, `type`, `subType`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
            SQLite.execSQL(var1, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            SQLite.execSQL(var1, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '52cd44c9b7bebf8db8a9280628049fc6')");
         }

         public void dropAllTables(SQLiteConnection var1) {
            SQLite.execSQL(var1, "DROP TABLE IF EXISTS `device_table`");
            SQLite.execSQL(var1, "DROP TABLE IF EXISTS `device_data`");
            SQLite.execSQL(var1, "DROP TABLE IF EXISTS `tracked_location_table`");
            SQLite.execSQL(var1, "DROP TABLE IF EXISTS `aqi_data_table`");
            SQLite.execSQL(var1, "DROP TABLE IF EXISTS `device_schedule_table`");
            SQLite.execSQL(var1, "DROP TABLE IF EXISTS `notification_table`");
         }

         public void onCreate(SQLiteConnection var1) {
         }

         public void onOpen(SQLiteConnection var1) {
            SQLite.execSQL(var1, "PRAGMA foreign_keys = ON");
            this.this$0.internalInitInvalidationTracker(var1);
         }

         public void onPostMigrate(SQLiteConnection var1) {
         }

         public void onPreMigrate(SQLiteConnection var1) {
            DBUtil.dropFtsSyncTriggers(var1);
         }

         public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection var1) {
            HashMap var2 = new HashMap(145);
            var2.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, (String)null, 1));
            var2.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String)null, 1));
            var2.put("modelName", new TableInfo.Column("modelName", "TEXT", true, 0, (String)null, 1));
            var2.put("typeIndex", new TableInfo.Column("typeIndex", "INTEGER", true, 0, (String)null, 1));
            var2.put("fanSpeed", new TableInfo.Column("fanSpeed", "INTEGER", false, 0, (String)null, 1));
            var2.put("filterLife", new TableInfo.Column("filterLife", "INTEGER", false, 0, (String)null, 1));
            var2.put("autoModeText", new TableInfo.Column("autoModeText", "TEXT", false, 0, (String)null, 1));
            var2.put("brightness", new TableInfo.Column("brightness", "INTEGER", false, 0, (String)null, 1));
            var2.put("info", new TableInfo.Column("info", "TEXT", false, 0, (String)null, 1));
            var2.put("hasFinishedOnboarding", new TableInfo.Column("hasFinishedOnboarding", "INTEGER", true, 0, (String)null, 1));
            var2.put("lastSelectedSensorType", new TableInfo.Column("lastSelectedSensorType", "INTEGER", false, 0, (String)null, 1));
            var2.put("isAblDevice", new TableInfo.Column("isAblDevice", "INTEGER", true, 0, (String)null, 1));
            var2.put("isNightModeOn", new TableInfo.Column("isNightModeOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isChildLockOn", new TableInfo.Column("isChildLockOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("linkedDeviceUid", new TableInfo.Column("linkedDeviceUid", "TEXT", false, 0, (String)null, 1));
            var2.put("connectivityStatusIndex", new TableInfo.Column("connectivityStatusIndex", "INTEGER", true, 0, (String)null, 1));
            var2.put("lastConnectivityMillis", new TableInfo.Column("lastConnectivityMillis", "INTEGER", true, 0, (String)null, 1));
            var2.put("mac", new TableInfo.Column("mac", "TEXT", true, 0, (String)null, 1));
            var2.put("mcuFirmware", new TableInfo.Column("mcuFirmware", "TEXT", true, 0, (String)null, 1));
            var2.put("wifiFirmware", new TableInfo.Column("wifiFirmware", "TEXT", true, 0, (String)null, 1));
            var2.put("hardware", new TableInfo.Column("hardware", "TEXT", true, 0, (String)null, 1));
            var2.put("timeZone", new TableInfo.Column("timeZone", "TEXT", true, 0, (String)null, 1));
            var2.put("serial", new TableInfo.Column("serial", "TEXT", true, 0, (String)null, 1));
            var2.put("purchaseDate", new TableInfo.Column("purchaseDate", "TEXT", true, 0, (String)null, 1));
            var2.put("dealerName", new TableInfo.Column("dealerName", "TEXT", true, 0, (String)null, 1));
            var2.put("dealerCountry", new TableInfo.Column("dealerCountry", "TEXT", true, 0, (String)null, 1));
            var2.put("filterType", new TableInfo.Column("filterType", "TEXT", true, 0, (String)null, 1));
            var2.put("filterTrigger", new TableInfo.Column("filterTrigger", "TEXT", true, 0, (String)null, 1));
            var2.put("pm1Ranges", new TableInfo.Column("pm1Ranges", "TEXT", true, 0, (String)null, 1));
            var2.put("pm10Ranges", new TableInfo.Column("pm10Ranges", "TEXT", true, 0, (String)null, 1));
            var2.put("pm25Ranges", new TableInfo.Column("pm25Ranges", "TEXT", true, 0, (String)null, 1));
            var2.put("vocRanges", new TableInfo.Column("vocRanges", "TEXT", true, 0, (String)null, 1));
            var2.put("hchoRanges", new TableInfo.Column("hchoRanges", "TEXT", true, 0, (String)null, 1));
            var2.put("updateProgress", new TableInfo.Column("updateProgress", "INTEGER", true, 0, (String)null, 1));
            var2.put("isStandByOn", new TableInfo.Column("isStandByOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isEcoModeOn", new TableInfo.Column("isEcoModeOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isHinsModeOn", new TableInfo.Column("isHinsModeOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isHinsNightModeOn", new TableInfo.Column("isHinsNightModeOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isG4NightModeOn", new TableInfo.Column("isG4NightModeOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isGermShieldOn", new TableInfo.Column("isGermShieldOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("isGermShieldNightModeOn", new TableInfo.Column("isGermShieldNightModeOn", "INTEGER", false, 0, (String)null, 1));
            var2.put("isSafetySwitchOn", new TableInfo.Column("isSafetySwitchOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("g4NightModefilterTrigger", new TableInfo.Column("g4NightModefilterTrigger", "TEXT", true, 0, (String)null, 1));
            var2.put("aimInstalled", new TableInfo.Column("aimInstalled", "INTEGER", true, 0, (String)null, 1));
            var2.put("sku", new TableInfo.Column("sku", "TEXT", false, 0, (String)null, 1));
            var2.put("compatibility", new TableInfo.Column("compatibility", "TEXT", false, 0, (String)null, 1));
            var2.put("locationId", new TableInfo.Column("locationId", "TEXT", false, 0, (String)null, 1));
            var2.put("disinfection", new TableInfo.Column("disinfection", "INTEGER", false, 0, (String)null, 1));
            var2.put("disinfectLeftTime", new TableInfo.Column("disinfectLeftTime", "INTEGER", false, 0, (String)null, 1));
            var2.put("disinfectLeftTimeUpdateTime", new TableInfo.Column("disinfectLeftTimeUpdateTime", "INTEGER", false, 0, (String)null, 1));
            var2.put("wickdryEnabled", new TableInfo.Column("wickdryEnabled", "INTEGER", true, 0, (String)null, 1));
            var2.put("wickdryOn", new TableInfo.Column("wickdryOn", "INTEGER", true, 0, (String)null, 1));
            var2.put("wickdryLeftTime", new TableInfo.Column("wickdryLeftTime", "INTEGER", true, 0, (String)null, 1));
            var2.put("wickdryLeftTimeUpdateTime", new TableInfo.Column("wickdryLeftTimeUpdateTime", "INTEGER", true, 0, (String)null, 1));
            var2.put("wickUsage", new TableInfo.Column("wickUsage", "INTEGER", true, 0, (String)null, 1));
            var2.put("waterShortage", new TableInfo.Column("waterShortage", "INTEGER", true, 0, (String)null, 1));
            var2.put("autoRh", new TableInfo.Column("autoRh", "INTEGER", true, 0, (String)null, 1));
            var2.put("timerStatus", new TableInfo.Column("timerStatus", "INTEGER", true, 0, (String)null, 1));
            var2.put("timerDuration", new TableInfo.Column("timerDuration", "INTEGER", true, 0, (String)null, 1));
            var2.put("timerLeftTime", new TableInfo.Column("timerLeftTime", "INTEGER", true, 0, (String)null, 1));
            var2.put("timerLeftTimeUpdateTime", new TableInfo.Column("timerLeftTimeUpdateTime", "INTEGER", true, 0, (String)null, 1));
            var2.put("temperatureUnit", new TableInfo.Column("temperatureUnit", "INTEGER", true, 0, (String)null, 1));
            var2.put("oscillationState", new TableInfo.Column("oscillationState", "INTEGER", true, 0, (String)null, 1));
            var2.put("oscillationAngle", new TableInfo.Column("oscillationAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("oscillationDirection", new TableInfo.Column("oscillationDirection", "INTEGER", true, 0, (String)null, 1));
            var2.put("oscillationFanSpeed", new TableInfo.Column("oscillationFanSpeed", "INTEGER", true, 0, (String)null, 1));
            var2.put("mainMode", new TableInfo.Column("mainMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("apSubMode", new TableInfo.Column("apSubMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("apFanSpeed", new TableInfo.Column("apFanSpeed", "INTEGER", true, 0, (String)null, 1));
            var2.put("heatSubMode", new TableInfo.Column("heatSubMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("heatFanSpeed", new TableInfo.Column("heatFanSpeed", "INTEGER", true, 0, (String)null, 1));
            var2.put("heatAutoTmp", new TableInfo.Column("heatAutoTmp", "REAL", true, 0, (String)null, 1));
            var2.put("heatEcoTmp", new TableInfo.Column("heatEcoTmp", "REAL", true, 0, (String)null, 1));
            var2.put("coolSubMode", new TableInfo.Column("coolSubMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("coolFanSpeed", new TableInfo.Column("coolFanSpeed", "INTEGER", true, 0, (String)null, 1));
            var2.put("coolAutoTag", new TableInfo.Column("coolAutoTag", "INTEGER", true, 0, (String)null, 1));
            var2.put("coolAutoPresets", new TableInfo.Column("coolAutoPresets", "TEXT", true, 0, (String)null, 1));
            var2.put("coolEcoTag", new TableInfo.Column("coolEcoTag", "INTEGER", true, 0, (String)null, 1));
            var2.put("coolEcoPresets", new TableInfo.Column("coolEcoPresets", "TEXT", true, 0, (String)null, 1));
            var2.put("humMode", new TableInfo.Column("humMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("mode", new TableInfo.Column("mode", "INTEGER", true, 0, (String)null, 1));
            var2.put("waterLevel", new TableInfo.Column("waterLevel", "INTEGER", true, 0, (String)null, 1));
            var2.put("dehSubMode", new TableInfo.Column("dehSubMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("waterTankFailure", new TableInfo.Column("waterTankFailure", "INTEGER", true, 0, (String)null, 1));
            var2.put("smartSubMode", new TableInfo.Column("smartSubMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("detectCat", new TableInfo.Column("detectCat", "INTEGER", true, 0, (String)null, 1));
            var2.put("bodyMounted", new TableInfo.Column("bodyMounted", "INTEGER", true, 0, (String)null, 1));
            var2.put("cleanAirEta", new TableInfo.Column("cleanAirEta", "INTEGER", true, 0, (String)null, 1));
            var2.put("panelDisplayMode", new TableInfo.Column("panelDisplayMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("hoverEnabled", new TableInfo.Column("hoverEnabled", "INTEGER", true, 0, (String)null, 1));
            var2.put("airRefreshEnabled", new TableInfo.Column("airRefreshEnabled", "INTEGER", true, 0, (String)null, 1));
            var2.put("airRefreshStatus", new TableInfo.Column("airRefreshStatus", "INTEGER", true, 0, (String)null, 1));
            var2.put("airRefreshDuration", new TableInfo.Column("airRefreshDuration", "INTEGER", true, 0, (String)null, 1));
            var2.put("airRefreshTimeStamp", new TableInfo.Column("airRefreshTimeStamp", "INTEGER", true, 0, (String)null, 1));
            var2.put("airRefreshStartTimeStamp", new TableInfo.Column("airRefreshStartTimeStamp", "INTEGER", true, 0, (String)null, 1));
            var2.put("airRefreshEndTimeStamp", new TableInfo.Column("airRefreshEndTimeStamp", "INTEGER", true, 0, (String)null, 1));
            var2.put("roomType", new TableInfo.Column("roomType", "INTEGER", true, 0, (String)null, 1));
            var2.put("nightLampBrightness", new TableInfo.Column("nightLampBrightness", "INTEGER", true, 0, (String)null, 1));
            var2.put("wickdryDuration", new TableInfo.Column("wickdryDuration", "INTEGER", true, 0, (String)null, 1));
            var2.put("wickdryDone", new TableInfo.Column("wickdryDone", "INTEGER", true, 0, (String)null, 1));
            var2.put("ywrmEnabled", new TableInfo.Column("ywrmEnabled", "INTEGER", false, 0, (String)null, 1));
            var2.put("ywrmUsage", new TableInfo.Column("ywrmUsage", "INTEGER", true, 0, (String)null, 1));
            var2.put("nightLampSteplessBrightness", new TableInfo.Column("nightLampSteplessBrightness", "INTEGER", true, 0, (String)null, 1));
            var2.put("alarms", new TableInfo.Column("alarms", "TEXT", true, 0, (String)null, 1));
            var2.put("humSubMode", new TableInfo.Column("humSubMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("use24Hour", new TableInfo.Column("use24Hour", "INTEGER", true, 0, (String)null, 1));
            var2.put("waterInfill", new TableInfo.Column("waterInfill", "INTEGER", true, 0, (String)null, 1));
            var2.put("sensorMode", new TableInfo.Column("sensorMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("coolFanSpeedLevel", new TableInfo.Column("coolFanSpeedLevel", "INTEGER", true, 0, (String)null, 1));
            var2.put("coolAutoLevel", new TableInfo.Column("coolAutoLevel", "INTEGER", true, 0, (String)null, 1));
            var2.put("nightModeStartTime", new TableInfo.Column("nightModeStartTime", "INTEGER", true, 0, (String)null, 1));
            var2.put("rpm1", new TableInfo.Column("rpm1", "INTEGER", true, 0, (String)null, 1));
            var2.put("nightPeriods", new TableInfo.Column("nightPeriods", "TEXT", true, 0, (String)null, 1));
            var2.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, (String)null, 1));
            var2.put("ssid", new TableInfo.Column("ssid", "TEXT", false, 0, (String)null, 1));
            var2.put("bssid", new TableInfo.Column("bssid", "TEXT", false, 0, (String)null, 1));
            var2.put("ipv4", new TableInfo.Column("ipv4", "TEXT", false, 0, (String)null, 1));
            var2.put("ipv6", new TableInfo.Column("ipv6", "TEXT", false, 0, (String)null, 1));
            var2.put("timeInSeconds", new TableInfo.Column("timeInSeconds", "INTEGER", false, 0, (String)null, 1));
            var2.put("pm1", new TableInfo.Column("pm1", "REAL", false, 0, (String)null, 1));
            var2.put("pm10", new TableInfo.Column("pm10", "REAL", false, 0, (String)null, 1));
            var2.put("pm25", new TableInfo.Column("pm25", "REAL", false, 0, (String)null, 1));
            var2.put("voc", new TableInfo.Column("voc", "REAL", false, 0, (String)null, 1));
            var2.put("hcho", new TableInfo.Column("hcho", "REAL", false, 0, (String)null, 1));
            var2.put("tmp", new TableInfo.Column("tmp", "REAL", false, 0, (String)null, 1));
            var2.put("hum", new TableInfo.Column("hum", "REAL", false, 0, (String)null, 1));
            var2.put("fan", new TableInfo.Column("fan", "REAL", false, 0, (String)null, 1));
            var2.put("weight", new TableInfo.Column("weight", "REAL", false, 0, (String)null, 1));
            var2.put("rpm", new TableInfo.Column("rpm", "REAL", false, 0, (String)null, 1));
            var2.put("lat", new TableInfo.Column("lat", "REAL", false, 0, (String)null, 1));
            var2.put("lng", new TableInfo.Column("lng", "REAL", false, 0, (String)null, 1));
            var2.put("radius", new TableInfo.Column("radius", "INTEGER", false, 0, (String)null, 1));
            var2.put("textValue", new TableInfo.Column("textValue", "TEXT", false, 0, (String)null, 1));
            var2.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", false, 0, (String)null, 1));
            var2.put("oscillationMode", new TableInfo.Column("oscillationMode", "INTEGER", true, 0, (String)null, 1));
            var2.put("horizontalOscillationState", new TableInfo.Column("horizontalOscillationState", "INTEGER", true, 0, (String)null, 1));
            var2.put("horizontalOscillationFixAngle", new TableInfo.Column("horizontalOscillationFixAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("horizontalOscillationMinAngle", new TableInfo.Column("horizontalOscillationMinAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("horizontalOscillationMaxAngle", new TableInfo.Column("horizontalOscillationMaxAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("verticalOscillationState", new TableInfo.Column("verticalOscillationState", "INTEGER", true, 0, (String)null, 1));
            var2.put("verticalOscillationFixAngle", new TableInfo.Column("verticalOscillationFixAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("verticalOscillationMinAngle", new TableInfo.Column("verticalOscillationMinAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("verticalOscillationMaxAngle", new TableInfo.Column("verticalOscillationMaxAngle", "INTEGER", true, 0, (String)null, 1));
            var2.put("horizontalCalibrationState", new TableInfo.Column("horizontalCalibrationState", "INTEGER", true, 0, (String)null, 1));
            var2.put("verticalCalibrationState", new TableInfo.Column("verticalCalibrationState", "INTEGER", true, 0, (String)null, 1));
            TableInfo var11 = new TableInfo("device_table", var2, new HashSet(0), new HashSet(0));
            TableInfo var3 = TableInfo.read(var1, "device_table");
            if (!var11.equals(var3)) {
               StringBuilder var10 = new StringBuilder("device_table(com.blueair.database.entity.DeviceEntity).\n Expected:\n");
               var10.append(var11);
               var10.append("\n Found:\n");
               var10.append(var3);
               return new RoomOpenDelegate.ValidationResult(false, var10.toString());
            } else {
               HashMap var22 = new HashMap(14);
               var22.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String)null, 1));
               var22.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String)null, 1));
               var22.put("time", new TableInfo.Column("time", "INTEGER", true, 0, (String)null, 1));
               var22.put("pm1", new TableInfo.Column("pm1", "REAL", false, 0, (String)null, 1));
               var22.put("pm10", new TableInfo.Column("pm10", "REAL", false, 0, (String)null, 1));
               var22.put("pm25", new TableInfo.Column("pm25", "REAL", false, 0, (String)null, 1));
               var22.put("voc", new TableInfo.Column("voc", "REAL", false, 0, (String)null, 1));
               var22.put("hcho", new TableInfo.Column("hcho", "REAL", false, 0, (String)null, 1));
               var22.put("tmp", new TableInfo.Column("tmp", "REAL", false, 0, (String)null, 1));
               var22.put("hum", new TableInfo.Column("hum", "REAL", false, 0, (String)null, 1));
               var22.put("fan", new TableInfo.Column("fan", "REAL", false, 0, (String)null, 1));
               var22.put("weight", new TableInfo.Column("weight", "REAL", false, 0, (String)null, 1));
               var22.put("rpm", new TableInfo.Column("rpm", "REAL", false, 0, (String)null, 1));
               var22.put("trend", new TableInfo.Column("trend", "INTEGER", true, 0, (String)null, 1));
               HashSet var12 = new HashSet(1);
               var12.add(new TableInfo.ForeignKey("device_table", "CASCADE", "NO ACTION", Arrays.asList("deviceId"), Arrays.asList("uid")));
               HashSet var4 = new HashSet(1);
               var4.add(new TableInfo.Index("index_device_data_deviceId", false, Arrays.asList("deviceId"), Arrays.asList("ASC")));
               TableInfo var13 = new TableInfo("device_data", var22, var12, var4);
               TableInfo var23 = TableInfo.read(var1, "device_data");
               if (!var13.equals(var23)) {
                  StringBuilder var9 = new StringBuilder("device_data(com.blueair.database.entity.DeviceDataEntity).\n Expected:\n");
                  var9.append(var13);
                  var9.append("\n Found:\n");
                  var9.append(var23);
                  return new RoomOpenDelegate.ValidationResult(false, var9.toString());
               } else {
                  HashMap var14 = new HashMap(9);
                  var14.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String)null, 1));
                  var14.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, (String)null, 1));
                  var14.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, (String)null, 1));
                  var14.put("locationName", new TableInfo.Column("locationName", "TEXT", false, 0, (String)null, 1));
                  var14.put("cityName", new TableInfo.Column("cityName", "TEXT", false, 0, (String)null, 1));
                  var14.put("stateName", new TableInfo.Column("stateName", "TEXT", false, 0, (String)null, 1));
                  var14.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0, (String)null, 1));
                  var14.put("countryCode", new TableInfo.Column("countryCode", "TEXT", false, 0, (String)null, 1));
                  var14.put("mapType", new TableInfo.Column("mapType", "TEXT", false, 0, (String)null, 1));
                  var23 = new TableInfo("tracked_location_table", var14, new HashSet(0), new HashSet(0));
                  TableInfo var15 = TableInfo.read(var1, "tracked_location_table");
                  if (!var23.equals(var15)) {
                     StringBuilder var8 = new StringBuilder("tracked_location_table(com.blueair.database.entity.TrackedLocationEntity).\n Expected:\n");
                     var8.append(var23);
                     var8.append("\n Found:\n");
                     var8.append(var15);
                     return new RoomOpenDelegate.ValidationResult(false, var8.toString());
                  } else {
                     HashMap var16 = new HashMap(9);
                     var16.put("trackedLocationId", new TableInfo.Column("trackedLocationId", "TEXT", true, 1, (String)null, 1));
                     var16.put("datetime", new TableInfo.Column("datetime", "INTEGER", true, 0, (String)null, 1));
                     var16.put("co", new TableInfo.Column("co", "REAL", false, 0, (String)null, 1));
                     var16.put("no2", new TableInfo.Column("no2", "REAL", false, 0, (String)null, 1));
                     var16.put("o3", new TableInfo.Column("o3", "REAL", false, 0, (String)null, 1));
                     var16.put("pm10", new TableInfo.Column("pm10", "REAL", false, 0, (String)null, 1));
                     var16.put("pm25", new TableInfo.Column("pm25", "REAL", false, 0, (String)null, 1));
                     var16.put("so2", new TableInfo.Column("so2", "REAL", false, 0, (String)null, 1));
                     var16.put("aqi", new TableInfo.Column("aqi", "REAL", false, 0, (String)null, 1));
                     var23 = new TableInfo("aqi_data_table", var16, new HashSet(0), new HashSet(0));
                     TableInfo var17 = TableInfo.read(var1, "aqi_data_table");
                     if (!var23.equals(var17)) {
                        StringBuilder var7 = new StringBuilder("aqi_data_table(com.blueair.database.entity.AqiDataEntity).\n Expected:\n");
                        var7.append(var23);
                        var7.append("\n Found:\n");
                        var7.append(var17);
                        return new RoomOpenDelegate.ValidationResult(false, var7.toString());
                     } else {
                        HashMap var26 = new HashMap(11);
                        var26.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 0, (String)null, 1));
                        var26.put("scheduleId", new TableInfo.Column("scheduleId", "TEXT", true, 1, (String)null, 1));
                        var26.put("scheduleName", new TableInfo.Column("scheduleName", "TEXT", true, 0, (String)null, 1));
                        var26.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, (String)null, 1));
                        var26.put("endTime", new TableInfo.Column("endTime", "TEXT", true, 0, (String)null, 1));
                        var26.put("instructions", new TableInfo.Column("instructions", "TEXT", true, 0, (String)null, 1));
                        var26.put("paused", new TableInfo.Column("paused", "INTEGER", true, 0, (String)null, 1));
                        var26.put("daysOfWeek", new TableInfo.Column("daysOfWeek", "TEXT", true, 0, (String)null, 1));
                        var26.put("timeZone", new TableInfo.Column("timeZone", "TEXT", true, 0, (String)null, 1));
                        var26.put("endInstructions", new TableInfo.Column("endInstructions", "TEXT", false, 0, (String)null, 1));
                        var26.put("scheduleEndType", new TableInfo.Column("scheduleEndType", "TEXT", false, 0, (String)null, 1));
                        HashSet var18 = new HashSet(1);
                        var18.add(new TableInfo.ForeignKey("device_table", "CASCADE", "NO ACTION", Arrays.asList("deviceId"), Arrays.asList("uid")));
                        TableInfo var19 = new TableInfo("device_schedule_table", var26, var18, new HashSet(0));
                        TableInfo var27 = TableInfo.read(var1, "device_schedule_table");
                        if (!var19.equals(var27)) {
                           StringBuilder var6 = new StringBuilder("device_schedule_table(com.blueair.database.entity.DeviceScheduleEntity).\n Expected:\n");
                           var6.append(var19);
                           var6.append("\n Found:\n");
                           var6.append(var27);
                           return new RoomOpenDelegate.ValidationResult(false, var6.toString());
                        } else {
                           HashMap var28 = new HashMap(7);
                           var28.put("deviceId", new TableInfo.Column("deviceId", "TEXT", true, 1, (String)null, 1));
                           var28.put("type", new TableInfo.Column("type", "TEXT", true, 2, (String)null, 1));
                           var28.put("subType", new TableInfo.Column("subType", "TEXT", true, 3, (String)null, 1));
                           var28.put("subLevel", new TableInfo.Column("subLevel", "INTEGER", true, 0, (String)null, 1));
                           var28.put("dismissed", new TableInfo.Column("dismissed", "INTEGER", true, 0, (String)null, 1));
                           var28.put("dismissTime", new TableInfo.Column("dismissTime", "INTEGER", true, 0, (String)null, 1));
                           var28.put("datetime", new TableInfo.Column("datetime", "INTEGER", true, 0, (String)null, 1));
                           HashSet var20 = new HashSet(1);
                           var20.add(new TableInfo.ForeignKey("device_table", "CASCADE", "NO ACTION", Arrays.asList("deviceId"), Arrays.asList("uid")));
                           TableInfo var21 = new TableInfo("notification_table", var28, var20, new HashSet(0));
                           TableInfo var5 = TableInfo.read(var1, "notification_table");
                           if (!var21.equals(var5)) {
                              StringBuilder var29 = new StringBuilder("notification_table(com.blueair.database.entity.NotificationEntity).\n Expected:\n");
                              var29.append(var21);
                              var29.append("\n Found:\n");
                              var29.append(var5);
                              return new RoomOpenDelegate.ValidationResult(false, var29.toString());
                           } else {
                              return new RoomOpenDelegate.ValidationResult(true, (String)null);
                           }
                        }
                     }
                  }
               }
            }
         }
      };
   }

   public DeviceDao deviceDao() {
      if (this._deviceDao != null) {
         return this._deviceDao;
      } else {
         synchronized(this){}

         Throwable var10000;
         label136: {
            try {
               if (this._deviceDao == null) {
                  DeviceDao_Impl var1 = new DeviceDao_Impl(this);
                  this._deviceDao = var1;
               }
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label136;
            }

            label133:
            try {
               DeviceDao var15 = this._deviceDao;
               return var15;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var16 = false;
               break label133;
            }
         }

         while(true) {
            Throwable var14 = var10000;

            try {
               throw var14;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               continue;
            }
         }
      }
   }

   public DeviceDataDao deviceDataDao() {
      if (this._deviceDataDao != null) {
         return this._deviceDataDao;
      } else {
         synchronized(this){}

         Throwable var10000;
         label136: {
            try {
               if (this._deviceDataDao == null) {
                  DeviceDataDao_Impl var1 = new DeviceDataDao_Impl(this);
                  this._deviceDataDao = var1;
               }
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label136;
            }

            label133:
            try {
               DeviceDataDao var15 = this._deviceDataDao;
               return var15;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var16 = false;
               break label133;
            }
         }

         while(true) {
            Throwable var14 = var10000;

            try {
               throw var14;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               continue;
            }
         }
      }
   }

   public DeviceScheduleDao deviceScheduleDao() {
      if (this._deviceScheduleDao != null) {
         return this._deviceScheduleDao;
      } else {
         synchronized(this){}

         Throwable var10000;
         label136: {
            try {
               if (this._deviceScheduleDao == null) {
                  DeviceScheduleDao_Impl var1 = new DeviceScheduleDao_Impl(this);
                  this._deviceScheduleDao = var1;
               }
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label136;
            }

            label133:
            try {
               DeviceScheduleDao var15 = this._deviceScheduleDao;
               return var15;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var16 = false;
               break label133;
            }
         }

         while(true) {
            Throwable var14 = var10000;

            try {
               throw var14;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               continue;
            }
         }
      }
   }

   public List getAutoMigrations(Map var1) {
      ArrayList var2 = new ArrayList();
      var2.add(new BlueairDatabase_AutoMigration_57_58_Impl());
      var2.add(new BlueairDatabase_AutoMigration_63_64_Impl());
      return var2;
   }

   public Set getRequiredAutoMigrationSpecs() {
      return new HashSet();
   }

   protected Map getRequiredTypeConverters() {
      HashMap var1 = new HashMap();
      var1.put(DeviceDao.class, DeviceDao_Impl.getRequiredConverters());
      var1.put(DeviceDataDao.class, DeviceDataDao_Impl.getRequiredConverters());
      var1.put(TrackedLocationDao.class, TrackedLocationDao_Impl.getRequiredConverters());
      var1.put(AqiDataDao.class, AqiDataDao_Impl.getRequiredConverters());
      var1.put(DeviceScheduleDao.class, DeviceScheduleDao_Impl.getRequiredConverters());
      var1.put(NotificationDao.class, NotificationDao_Impl.getRequiredConverters());
      return var1;
   }

   public NotificationDao notificationDao() {
      if (this._notificationDao != null) {
         return this._notificationDao;
      } else {
         synchronized(this){}

         Throwable var10000;
         label136: {
            try {
               if (this._notificationDao == null) {
                  NotificationDao_Impl var1 = new NotificationDao_Impl(this);
                  this._notificationDao = var1;
               }
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label136;
            }

            label133:
            try {
               NotificationDao var15 = this._notificationDao;
               return var15;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var16 = false;
               break label133;
            }
         }

         while(true) {
            Throwable var14 = var10000;

            try {
               throw var14;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               continue;
            }
         }
      }
   }

   public TrackedLocationDao trackedLocationDao() {
      if (this._trackedLocationDao != null) {
         return this._trackedLocationDao;
      } else {
         synchronized(this){}

         Throwable var10000;
         label136: {
            try {
               if (this._trackedLocationDao == null) {
                  TrackedLocationDao_Impl var1 = new TrackedLocationDao_Impl(this);
                  this._trackedLocationDao = var1;
               }
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label136;
            }

            label133:
            try {
               TrackedLocationDao var15 = this._trackedLocationDao;
               return var15;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var16 = false;
               break label133;
            }
         }

         while(true) {
            Throwable var14 = var10000;

            try {
               throw var14;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               continue;
            }
         }
      }
   }
}
