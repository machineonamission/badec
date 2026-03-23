package com.blueair.database;

import androidx.room.InvalidationTracker;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import com.blueair.core.model.AnalyticEvent;
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
import com.blueair.database.entity.AqiDataEntity;
import com.blueair.database.entity.DeviceDataEntity;
import com.blueair.database.entity.DeviceEntity;
import com.blueair.database.entity.DeviceScheduleEntity;
import com.blueair.database.entity.NotificationEntity;
import com.blueair.database.entity.TrackedLocationEntity;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.config.CookieSpecs;

public final class BlueairDatabase_Impl extends BlueairDatabase {
    private volatile AqiDataDao _aqiDataDao;
    private volatile DeviceDao _deviceDao;
    private volatile DeviceDataDao _deviceDataDao;
    private volatile DeviceScheduleDao _deviceScheduleDao;
    private volatile NotificationDao _notificationDao;
    private volatile TrackedLocationDao _trackedLocationDao;

    /* access modifiers changed from: protected */
    public RoomOpenDelegate createOpenDelegate() {
        return new RoomOpenDelegate(69, "2050be38837125afd428ab50e4d650a5", "a340722390fec8f419439c12eab180ea") {
            public void onCreate(SQLiteConnection sQLiteConnection) {
            }

            public void onPostMigrate(SQLiteConnection sQLiteConnection) {
            }

            public void createAllTables(SQLiteConnection sQLiteConnection) {
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `device_table` (`uid` TEXT NOT NULL, `name` TEXT NOT NULL, `modelName` TEXT NOT NULL, `typeIndex` INTEGER NOT NULL, `fanSpeed` INTEGER, `filterLife` INTEGER, `autoModeText` TEXT, `brightness` INTEGER, `info` TEXT, `hasFinishedOnboarding` INTEGER NOT NULL, `lastSelectedSensorType` INTEGER, `isAblDevice` INTEGER NOT NULL, `isNightModeOn` INTEGER NOT NULL, `isChildLockOn` INTEGER NOT NULL, `linkedDeviceUid` TEXT, `connectivityStatusIndex` INTEGER NOT NULL, `lastConnectivityMillis` INTEGER NOT NULL, `mac` TEXT NOT NULL, `mcuFirmware` TEXT NOT NULL, `wifiFirmware` TEXT NOT NULL, `hardware` TEXT NOT NULL, `timeZone` TEXT NOT NULL, `serial` TEXT NOT NULL, `purchaseDate` TEXT NOT NULL, `dealerName` TEXT NOT NULL, `dealerCountry` TEXT NOT NULL, `filterType` TEXT NOT NULL, `filterTrigger` TEXT NOT NULL, `pm1Ranges` TEXT NOT NULL, `pm10Ranges` TEXT NOT NULL, `pm25Ranges` TEXT NOT NULL, `vocRanges` TEXT NOT NULL, `hchoRanges` TEXT NOT NULL, `updateProgress` INTEGER NOT NULL, `isStandByOn` INTEGER NOT NULL, `isEcoModeOn` INTEGER NOT NULL, `isHinsModeOn` INTEGER NOT NULL, `isHinsNightModeOn` INTEGER NOT NULL, `isG4NightModeOn` INTEGER NOT NULL, `isGermShieldOn` INTEGER NOT NULL, `isGermShieldNightModeOn` INTEGER, `isSafetySwitchOn` INTEGER NOT NULL, `g4NightModefilterTrigger` TEXT NOT NULL, `aimInstalled` INTEGER NOT NULL, `sku` TEXT, `compatibility` TEXT, `locationId` TEXT, `disinfection` INTEGER, `disinfectLeftTime` INTEGER, `disinfectLeftTimeUpdateTime` INTEGER, `wickdryEnabled` INTEGER NOT NULL, `wickdryOn` INTEGER NOT NULL, `wickdryLeftTime` INTEGER NOT NULL, `wickdryLeftTimeUpdateTime` INTEGER NOT NULL, `wickUsage` INTEGER NOT NULL, `waterShortage` INTEGER NOT NULL, `autoRh` INTEGER NOT NULL, `timerStatus` INTEGER NOT NULL, `timerDuration` INTEGER NOT NULL, `timerLeftTime` INTEGER NOT NULL, `timerLeftTimeUpdateTime` INTEGER NOT NULL, `temperatureUnit` INTEGER NOT NULL, `oscillationState` INTEGER NOT NULL, `oscillationAngle` INTEGER NOT NULL, `oscillationDirection` INTEGER NOT NULL, `oscillationFanSpeed` INTEGER NOT NULL, `mainMode` INTEGER NOT NULL, `apSubMode` INTEGER NOT NULL, `apFanSpeed` INTEGER NOT NULL, `heatSubMode` INTEGER NOT NULL, `heatFanSpeed` INTEGER NOT NULL, `heatAutoTmp` REAL NOT NULL, `heatEcoTmp` REAL NOT NULL, `coolSubMode` INTEGER NOT NULL, `coolFanSpeed` INTEGER NOT NULL, `coolAutoTag` INTEGER NOT NULL, `coolAutoPresets` TEXT NOT NULL, `coolEcoTag` INTEGER NOT NULL, `coolEcoPresets` TEXT NOT NULL, `humMode` INTEGER NOT NULL, `mode` INTEGER NOT NULL, `waterLevel` INTEGER NOT NULL, `dehSubMode` INTEGER NOT NULL, `waterTankFailure` INTEGER NOT NULL, `smartSubMode` INTEGER NOT NULL, `detectCat` INTEGER NOT NULL, `bodyMounted` INTEGER NOT NULL, `cleanAirEta` INTEGER NOT NULL, `panelDisplayMode` INTEGER NOT NULL, `hoverEnabled` INTEGER NOT NULL, `airRefreshEnabled` INTEGER NOT NULL, `airRefreshStatus` INTEGER NOT NULL, `airRefreshDuration` INTEGER NOT NULL, `airRefreshTimeStamp` INTEGER NOT NULL, `airRefreshStartTimeStamp` INTEGER NOT NULL, `airRefreshEndTimeStamp` INTEGER NOT NULL, `roomType` INTEGER NOT NULL, `nightLampBrightness` INTEGER NOT NULL, `wickdryDuration` INTEGER NOT NULL, `wickdryDone` INTEGER NOT NULL, `ywrmEnabled` INTEGER, `ywrmUsage` INTEGER NOT NULL, `nightLampSteplessBrightness` INTEGER NOT NULL, `alarms` TEXT NOT NULL, `humSubMode` INTEGER NOT NULL, `use24Hour` INTEGER NOT NULL, `waterInfill` INTEGER NOT NULL, `sensorMode` INTEGER NOT NULL, `uuid` TEXT, `ssid` TEXT, `bssid` TEXT, `ipv4` TEXT, `ipv6` TEXT, `timeInSeconds` INTEGER, `pm1` REAL, `pm10` REAL, `pm25` REAL, `voc` REAL, `hcho` REAL, `tmp` REAL, `hum` REAL, `fan` REAL, `weight` REAL, `lat` REAL, `lng` REAL, `radius` INTEGER, `textValue` TEXT, `isEnabled` INTEGER, PRIMARY KEY(`uid`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `device_data` (`id` TEXT NOT NULL, `deviceId` TEXT NOT NULL, `time` INTEGER NOT NULL, `pm1` REAL, `pm10` REAL, `pm25` REAL, `voc` REAL, `hcho` REAL, `tmp` REAL, `hum` REAL, `fan` REAL, `weight` REAL, `trend` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE INDEX IF NOT EXISTS `index_device_data_deviceId` ON `device_data` (`deviceId`)");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `tracked_location_table` (`id` TEXT NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `locationName` TEXT, `cityName` TEXT, `stateName` TEXT, `countryName` TEXT, `countryCode` TEXT, `mapType` TEXT, PRIMARY KEY(`id`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `aqi_data_table` (`trackedLocationId` TEXT NOT NULL, `datetime` INTEGER NOT NULL, `co` REAL, `no2` REAL, `o3` REAL, `pm10` REAL, `pm25` REAL, `so2` REAL, `aqi` REAL, PRIMARY KEY(`trackedLocationId`))");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `device_schedule_table` (`deviceId` TEXT NOT NULL, `scheduleId` TEXT NOT NULL, `scheduleName` TEXT NOT NULL, `startTime` TEXT NOT NULL, `endTime` TEXT NOT NULL, `instructions` TEXT NOT NULL, `paused` INTEGER NOT NULL, `daysOfWeek` TEXT NOT NULL, `timeZone` TEXT NOT NULL, `endInstructions` TEXT, `scheduleEndType` TEXT, PRIMARY KEY(`scheduleId`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, "CREATE TABLE IF NOT EXISTS `notification_table` (`deviceId` TEXT NOT NULL, `type` TEXT NOT NULL, `subType` TEXT NOT NULL, `subLevel` INTEGER NOT NULL, `dismissed` INTEGER NOT NULL, `dismissTime` INTEGER NOT NULL, `datetime` INTEGER NOT NULL, PRIMARY KEY(`deviceId`, `type`, `subType`), FOREIGN KEY(`deviceId`) REFERENCES `device_table`(`uid`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                SQLite.execSQL(sQLiteConnection, RoomMasterTable.CREATE_QUERY);
                SQLite.execSQL(sQLiteConnection, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2050be38837125afd428ab50e4d650a5')");
            }

            public void dropAllTables(SQLiteConnection sQLiteConnection) {
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `device_table`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `device_data`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `tracked_location_table`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `aqi_data_table`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `device_schedule_table`");
                SQLite.execSQL(sQLiteConnection, "DROP TABLE IF EXISTS `notification_table`");
            }

            public void onOpen(SQLiteConnection sQLiteConnection) {
                SQLite.execSQL(sQLiteConnection, "PRAGMA foreign_keys = ON");
                BlueairDatabase_Impl.this.internalInitInvalidationTracker(sQLiteConnection);
            }

            public void onPreMigrate(SQLiteConnection sQLiteConnection) {
                DBUtil.dropFtsSyncTriggers(sQLiteConnection);
            }

            public RoomOpenDelegate.ValidationResult onValidateSchema(SQLiteConnection sQLiteConnection) {
                SQLiteConnection sQLiteConnection2 = sQLiteConnection;
                HashMap hashMap = new HashMap(128);
                hashMap.put("uid", new TableInfo.Column("uid", "TEXT", true, 1, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap.put("modelName", new TableInfo.Column("modelName", "TEXT", true, 0, (String) null, 1));
                hashMap.put("typeIndex", new TableInfo.Column("typeIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("fanSpeed", new TableInfo.Column("fanSpeed", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("filterLife", new TableInfo.Column("filterLife", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("autoModeText", new TableInfo.Column("autoModeText", "TEXT", false, 0, (String) null, 1));
                hashMap.put("brightness", new TableInfo.Column("brightness", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("info", new TableInfo.Column("info", "TEXT", false, 0, (String) null, 1));
                hashMap.put("hasFinishedOnboarding", new TableInfo.Column("hasFinishedOnboarding", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("lastSelectedSensorType", new TableInfo.Column("lastSelectedSensorType", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("isAblDevice", new TableInfo.Column("isAblDevice", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isNightModeOn", new TableInfo.Column("isNightModeOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isChildLockOn", new TableInfo.Column("isChildLockOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("linkedDeviceUid", new TableInfo.Column("linkedDeviceUid", "TEXT", false, 0, (String) null, 1));
                hashMap.put("connectivityStatusIndex", new TableInfo.Column("connectivityStatusIndex", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("lastConnectivityMillis", new TableInfo.Column("lastConnectivityMillis", "INTEGER", true, 0, (String) null, 1));
                hashMap.put(AnalyticEvent.KEY_MAC, new TableInfo.Column(AnalyticEvent.KEY_MAC, "TEXT", true, 0, (String) null, 1));
                hashMap.put("mcuFirmware", new TableInfo.Column("mcuFirmware", "TEXT", true, 0, (String) null, 1));
                hashMap.put("wifiFirmware", new TableInfo.Column("wifiFirmware", "TEXT", true, 0, (String) null, 1));
                hashMap.put("hardware", new TableInfo.Column("hardware", "TEXT", true, 0, (String) null, 1));
                hashMap.put(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, new TableInfo.Column(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "TEXT", true, 0, (String) null, 1));
                hashMap.put("serial", new TableInfo.Column("serial", "TEXT", true, 0, (String) null, 1));
                hashMap.put("purchaseDate", new TableInfo.Column("purchaseDate", "TEXT", true, 0, (String) null, 1));
                hashMap.put("dealerName", new TableInfo.Column("dealerName", "TEXT", true, 0, (String) null, 1));
                hashMap.put("dealerCountry", new TableInfo.Column("dealerCountry", "TEXT", true, 0, (String) null, 1));
                hashMap.put("filterType", new TableInfo.Column("filterType", "TEXT", true, 0, (String) null, 1));
                hashMap.put("filterTrigger", new TableInfo.Column("filterTrigger", "TEXT", true, 0, (String) null, 1));
                hashMap.put("pm1Ranges", new TableInfo.Column("pm1Ranges", "TEXT", true, 0, (String) null, 1));
                hashMap.put("pm10Ranges", new TableInfo.Column("pm10Ranges", "TEXT", true, 0, (String) null, 1));
                hashMap.put("pm25Ranges", new TableInfo.Column("pm25Ranges", "TEXT", true, 0, (String) null, 1));
                hashMap.put("vocRanges", new TableInfo.Column("vocRanges", "TEXT", true, 0, (String) null, 1));
                hashMap.put("hchoRanges", new TableInfo.Column("hchoRanges", "TEXT", true, 0, (String) null, 1));
                hashMap.put("updateProgress", new TableInfo.Column("updateProgress", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isStandByOn", new TableInfo.Column("isStandByOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isEcoModeOn", new TableInfo.Column("isEcoModeOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isHinsModeOn", new TableInfo.Column("isHinsModeOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isHinsNightModeOn", new TableInfo.Column("isHinsNightModeOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isG4NightModeOn", new TableInfo.Column("isG4NightModeOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isGermShieldOn", new TableInfo.Column("isGermShieldOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isGermShieldNightModeOn", new TableInfo.Column("isGermShieldNightModeOn", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("isSafetySwitchOn", new TableInfo.Column("isSafetySwitchOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("g4NightModefilterTrigger", new TableInfo.Column("g4NightModefilterTrigger", "TEXT", true, 0, (String) null, 1));
                hashMap.put("aimInstalled", new TableInfo.Column("aimInstalled", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("sku", new TableInfo.Column("sku", "TEXT", false, 0, (String) null, 1));
                hashMap.put(CookieSpecs.BROWSER_COMPATIBILITY, new TableInfo.Column(CookieSpecs.BROWSER_COMPATIBILITY, "TEXT", false, 0, (String) null, 1));
                hashMap.put("locationId", new TableInfo.Column("locationId", "TEXT", false, 0, (String) null, 1));
                hashMap.put("disinfection", new TableInfo.Column("disinfection", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("disinfectLeftTime", new TableInfo.Column("disinfectLeftTime", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("disinfectLeftTimeUpdateTime", new TableInfo.Column("disinfectLeftTimeUpdateTime", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("wickdryEnabled", new TableInfo.Column("wickdryEnabled", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("wickdryOn", new TableInfo.Column("wickdryOn", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("wickdryLeftTime", new TableInfo.Column("wickdryLeftTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("wickdryLeftTimeUpdateTime", new TableInfo.Column("wickdryLeftTimeUpdateTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("wickUsage", new TableInfo.Column("wickUsage", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("waterShortage", new TableInfo.Column("waterShortage", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("autoRh", new TableInfo.Column("autoRh", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("timerStatus", new TableInfo.Column("timerStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("timerDuration", new TableInfo.Column("timerDuration", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("timerLeftTime", new TableInfo.Column("timerLeftTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("timerLeftTimeUpdateTime", new TableInfo.Column("timerLeftTimeUpdateTime", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("temperatureUnit", new TableInfo.Column("temperatureUnit", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("oscillationState", new TableInfo.Column("oscillationState", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("oscillationAngle", new TableInfo.Column("oscillationAngle", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("oscillationDirection", new TableInfo.Column("oscillationDirection", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("oscillationFanSpeed", new TableInfo.Column("oscillationFanSpeed", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("mainMode", new TableInfo.Column("mainMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("apSubMode", new TableInfo.Column("apSubMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("apFanSpeed", new TableInfo.Column("apFanSpeed", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("heatSubMode", new TableInfo.Column("heatSubMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("heatFanSpeed", new TableInfo.Column("heatFanSpeed", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("heatAutoTmp", new TableInfo.Column("heatAutoTmp", "REAL", true, 0, (String) null, 1));
                hashMap.put("heatEcoTmp", new TableInfo.Column("heatEcoTmp", "REAL", true, 0, (String) null, 1));
                hashMap.put("coolSubMode", new TableInfo.Column("coolSubMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("coolFanSpeed", new TableInfo.Column("coolFanSpeed", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("coolAutoTag", new TableInfo.Column("coolAutoTag", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("coolAutoPresets", new TableInfo.Column("coolAutoPresets", "TEXT", true, 0, (String) null, 1));
                hashMap.put("coolEcoTag", new TableInfo.Column("coolEcoTag", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("coolEcoPresets", new TableInfo.Column("coolEcoPresets", "TEXT", true, 0, (String) null, 1));
                hashMap.put("humMode", new TableInfo.Column("humMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("mode", new TableInfo.Column("mode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("waterLevel", new TableInfo.Column("waterLevel", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("dehSubMode", new TableInfo.Column("dehSubMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("waterTankFailure", new TableInfo.Column("waterTankFailure", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("smartSubMode", new TableInfo.Column("smartSubMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("detectCat", new TableInfo.Column("detectCat", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("bodyMounted", new TableInfo.Column("bodyMounted", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("cleanAirEta", new TableInfo.Column("cleanAirEta", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("panelDisplayMode", new TableInfo.Column("panelDisplayMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("hoverEnabled", new TableInfo.Column("hoverEnabled", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("airRefreshEnabled", new TableInfo.Column("airRefreshEnabled", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("airRefreshStatus", new TableInfo.Column("airRefreshStatus", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("airRefreshDuration", new TableInfo.Column("airRefreshDuration", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("airRefreshTimeStamp", new TableInfo.Column("airRefreshTimeStamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("airRefreshStartTimeStamp", new TableInfo.Column("airRefreshStartTimeStamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("airRefreshEndTimeStamp", new TableInfo.Column("airRefreshEndTimeStamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("roomType", new TableInfo.Column("roomType", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("nightLampBrightness", new TableInfo.Column("nightLampBrightness", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("wickdryDuration", new TableInfo.Column("wickdryDuration", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("wickdryDone", new TableInfo.Column("wickdryDone", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("ywrmEnabled", new TableInfo.Column("ywrmEnabled", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("ywrmUsage", new TableInfo.Column("ywrmUsage", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("nightLampSteplessBrightness", new TableInfo.Column("nightLampSteplessBrightness", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("alarms", new TableInfo.Column("alarms", "TEXT", true, 0, (String) null, 1));
                hashMap.put("humSubMode", new TableInfo.Column("humSubMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("use24Hour", new TableInfo.Column("use24Hour", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("waterInfill", new TableInfo.Column("waterInfill", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("sensorMode", new TableInfo.Column("sensorMode", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, (String) null, 1));
                hashMap.put("ssid", new TableInfo.Column("ssid", "TEXT", false, 0, (String) null, 1));
                hashMap.put("bssid", new TableInfo.Column("bssid", "TEXT", false, 0, (String) null, 1));
                hashMap.put("ipv4", new TableInfo.Column("ipv4", "TEXT", false, 0, (String) null, 1));
                hashMap.put("ipv6", new TableInfo.Column("ipv6", "TEXT", false, 0, (String) null, 1));
                hashMap.put("timeInSeconds", new TableInfo.Column("timeInSeconds", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("pm1", new TableInfo.Column("pm1", "REAL", false, 0, (String) null, 1));
                hashMap.put("pm10", new TableInfo.Column("pm10", "REAL", false, 0, (String) null, 1));
                hashMap.put("pm25", new TableInfo.Column("pm25", "REAL", false, 0, (String) null, 1));
                hashMap.put("voc", new TableInfo.Column("voc", "REAL", false, 0, (String) null, 1));
                hashMap.put("hcho", new TableInfo.Column("hcho", "REAL", false, 0, (String) null, 1));
                hashMap.put("tmp", new TableInfo.Column("tmp", "REAL", false, 0, (String) null, 1));
                hashMap.put("hum", new TableInfo.Column("hum", "REAL", false, 0, (String) null, 1));
                hashMap.put(AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN, new TableInfo.Column(AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN, "REAL", false, 0, (String) null, 1));
                hashMap.put("weight", new TableInfo.Column("weight", "REAL", false, 0, (String) null, 1));
                hashMap.put("lat", new TableInfo.Column("lat", "REAL", false, 0, (String) null, 1));
                hashMap.put("lng", new TableInfo.Column("lng", "REAL", false, 0, (String) null, 1));
                hashMap.put("radius", new TableInfo.Column("radius", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("textValue", new TableInfo.Column("textValue", "TEXT", false, 0, (String) null, 1));
                hashMap.put("isEnabled", new TableInfo.Column("isEnabled", "INTEGER", false, 0, (String) null, 1));
                String str = "uid";
                TableInfo tableInfo = new TableInfo(DeviceEntity.DEVICE_TABLE, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(sQLiteConnection2, DeviceEntity.DEVICE_TABLE);
                if (!tableInfo.equals(read)) {
                    return new RoomOpenDelegate.ValidationResult(false, "device_table(com.blueair.database.entity.DeviceEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(13);
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put(DeviceDataEntity.DEVICE_ID, new TableInfo.Column(DeviceDataEntity.DEVICE_ID, "TEXT", true, 0, (String) null, 1));
                TableInfo.Column column = new TableInfo.Column("time", "INTEGER", true, 0, (String) null, 1);
                Object obj = RemoteConfigConstants.RequestFieldKey.TIME_ZONE;
                hashMap2.put("time", column);
                hashMap2.put("pm1", new TableInfo.Column("pm1", "REAL", false, 0, (String) null, 1));
                hashMap2.put("pm10", new TableInfo.Column("pm10", "REAL", false, 0, (String) null, 1));
                hashMap2.put("pm25", new TableInfo.Column("pm25", "REAL", false, 0, (String) null, 1));
                hashMap2.put("voc", new TableInfo.Column("voc", "REAL", false, 0, (String) null, 1));
                hashMap2.put("hcho", new TableInfo.Column("hcho", "REAL", false, 0, (String) null, 1));
                hashMap2.put("tmp", new TableInfo.Column("tmp", "REAL", false, 0, (String) null, 1));
                hashMap2.put("hum", new TableInfo.Column("hum", "REAL", false, 0, (String) null, 1));
                hashMap2.put(AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN, new TableInfo.Column(AnalyticEvent.OnboardingLogEvent.PAIR_BTN_FAN, "REAL", false, 0, (String) null, 1));
                hashMap2.put("weight", new TableInfo.Column("weight", "REAL", false, 0, (String) null, 1));
                hashMap2.put("trend", new TableInfo.Column("trend", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet = new HashSet(1);
                hashSet.add(new TableInfo.ForeignKey(DeviceEntity.DEVICE_TABLE, "CASCADE", "NO ACTION", Arrays.asList(new String[]{DeviceDataEntity.DEVICE_ID}), Arrays.asList(new String[]{str})));
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new TableInfo.Index("index_device_data_deviceId", false, Arrays.asList(new String[]{DeviceDataEntity.DEVICE_ID}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo2 = new TableInfo(DeviceDataEntity.DEVICE_DATA_TABLE, hashMap2, hashSet, hashSet2);
                TableInfo read2 = TableInfo.read(sQLiteConnection2, DeviceDataEntity.DEVICE_DATA_TABLE);
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenDelegate.ValidationResult(false, "device_data(com.blueair.database.entity.DeviceDataEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(9);
                hashMap3.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, (String) null, 1));
                hashMap3.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, (String) null, 1));
                hashMap3.put("locationName", new TableInfo.Column("locationName", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("cityName", new TableInfo.Column("cityName", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("stateName", new TableInfo.Column("stateName", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("countryName", new TableInfo.Column("countryName", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, new TableInfo.Column(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "TEXT", false, 0, (String) null, 1));
                hashMap3.put("mapType", new TableInfo.Column("mapType", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo(TrackedLocationEntity.TRACKED_LOCATION_TABLE, hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(sQLiteConnection2, TrackedLocationEntity.TRACKED_LOCATION_TABLE);
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenDelegate.ValidationResult(false, "tracked_location_table(com.blueair.database.entity.TrackedLocationEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(9);
                hashMap4.put("trackedLocationId", new TableInfo.Column("trackedLocationId", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("datetime", new TableInfo.Column("datetime", "INTEGER", true, 0, (String) null, 1));
                hashMap4.put("co", new TableInfo.Column("co", "REAL", false, 0, (String) null, 1));
                hashMap4.put("no2", new TableInfo.Column("no2", "REAL", false, 0, (String) null, 1));
                hashMap4.put("o3", new TableInfo.Column("o3", "REAL", false, 0, (String) null, 1));
                hashMap4.put("pm10", new TableInfo.Column("pm10", "REAL", false, 0, (String) null, 1));
                hashMap4.put("pm25", new TableInfo.Column("pm25", "REAL", false, 0, (String) null, 1));
                hashMap4.put("so2", new TableInfo.Column("so2", "REAL", false, 0, (String) null, 1));
                hashMap4.put("aqi", new TableInfo.Column("aqi", "REAL", false, 0, (String) null, 1));
                TableInfo tableInfo4 = new TableInfo(AqiDataEntity.AQI_DATA_TABLE, hashMap4, new HashSet(0), new HashSet(0));
                TableInfo read4 = TableInfo.read(sQLiteConnection2, AqiDataEntity.AQI_DATA_TABLE);
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenDelegate.ValidationResult(false, "aqi_data_table(com.blueair.database.entity.AqiDataEntity).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(11);
                hashMap5.put(DeviceDataEntity.DEVICE_ID, new TableInfo.Column(DeviceDataEntity.DEVICE_ID, "TEXT", true, 0, (String) null, 1));
                hashMap5.put("scheduleId", new TableInfo.Column("scheduleId", "TEXT", true, 1, (String) null, 1));
                hashMap5.put("scheduleName", new TableInfo.Column("scheduleName", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("startTime", new TableInfo.Column("startTime", "TEXT", true, 0, (String) null, 1));
                hashMap5.put(SDKConstants.PARAM_END_TIME, new TableInfo.Column(SDKConstants.PARAM_END_TIME, "TEXT", true, 0, (String) null, 1));
                hashMap5.put("instructions", new TableInfo.Column("instructions", "TEXT", true, 0, (String) null, 1));
                hashMap5.put("paused", new TableInfo.Column("paused", "INTEGER", true, 0, (String) null, 1));
                hashMap5.put("daysOfWeek", new TableInfo.Column("daysOfWeek", "TEXT", true, 0, (String) null, 1));
                hashMap5.put(obj, new TableInfo.Column(RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "TEXT", true, 0, (String) null, 1));
                hashMap5.put("endInstructions", new TableInfo.Column("endInstructions", "TEXT", false, 0, (String) null, 1));
                hashMap5.put("scheduleEndType", new TableInfo.Column("scheduleEndType", "TEXT", false, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(1);
                hashSet3.add(new TableInfo.ForeignKey(DeviceEntity.DEVICE_TABLE, "CASCADE", "NO ACTION", Arrays.asList(new String[]{DeviceDataEntity.DEVICE_ID}), Arrays.asList(new String[]{str})));
                TableInfo tableInfo5 = new TableInfo(DeviceScheduleEntity.DEVICE_SCHEDULE_TABLE, hashMap5, hashSet3, new HashSet(0));
                TableInfo read5 = TableInfo.read(sQLiteConnection2, DeviceScheduleEntity.DEVICE_SCHEDULE_TABLE);
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenDelegate.ValidationResult(false, "device_schedule_table(com.blueair.database.entity.DeviceScheduleEntity).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(7);
                hashMap6.put(DeviceDataEntity.DEVICE_ID, new TableInfo.Column(DeviceDataEntity.DEVICE_ID, "TEXT", true, 1, (String) null, 1));
                hashMap6.put("type", new TableInfo.Column("type", "TEXT", true, 2, (String) null, 1));
                hashMap6.put("subType", new TableInfo.Column("subType", "TEXT", true, 3, (String) null, 1));
                hashMap6.put("subLevel", new TableInfo.Column("subLevel", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("dismissed", new TableInfo.Column("dismissed", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("dismissTime", new TableInfo.Column("dismissTime", "INTEGER", true, 0, (String) null, 1));
                hashMap6.put("datetime", new TableInfo.Column("datetime", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet4 = new HashSet(1);
                hashSet4.add(new TableInfo.ForeignKey(DeviceEntity.DEVICE_TABLE, "CASCADE", "NO ACTION", Arrays.asList(new String[]{DeviceDataEntity.DEVICE_ID}), Arrays.asList(new String[]{str})));
                TableInfo tableInfo6 = new TableInfo(NotificationEntity.NOTIFICATION_TABLE, hashMap6, hashSet4, new HashSet(0));
                TableInfo read6 = TableInfo.read(sQLiteConnection2, NotificationEntity.NOTIFICATION_TABLE);
                if (tableInfo6.equals(read6)) {
                    return new RoomOpenDelegate.ValidationResult(true, (String) null);
                }
                return new RoomOpenDelegate.ValidationResult(false, "notification_table(com.blueair.database.entity.NotificationEntity).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
            }
        };
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), DeviceEntity.DEVICE_TABLE, DeviceDataEntity.DEVICE_DATA_TABLE, TrackedLocationEntity.TRACKED_LOCATION_TABLE, AqiDataEntity.AQI_DATA_TABLE, DeviceScheduleEntity.DEVICE_SCHEDULE_TABLE, NotificationEntity.NOTIFICATION_TABLE);
    }

    public void clearAllTables() {
        super.performClear(true, DeviceEntity.DEVICE_TABLE, DeviceDataEntity.DEVICE_DATA_TABLE, TrackedLocationEntity.TRACKED_LOCATION_TABLE, AqiDataEntity.AQI_DATA_TABLE, DeviceScheduleEntity.DEVICE_SCHEDULE_TABLE, NotificationEntity.NOTIFICATION_TABLE);
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DeviceDao.class, DeviceDao_Impl.getRequiredConverters());
        hashMap.put(DeviceDataDao.class, DeviceDataDao_Impl.getRequiredConverters());
        hashMap.put(TrackedLocationDao.class, TrackedLocationDao_Impl.getRequiredConverters());
        hashMap.put(AqiDataDao.class, AqiDataDao_Impl.getRequiredConverters());
        hashMap.put(DeviceScheduleDao.class, DeviceScheduleDao_Impl.getRequiredConverters());
        hashMap.put(NotificationDao.class, NotificationDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BlueairDatabase_AutoMigration_57_58_Impl());
        arrayList.add(new BlueairDatabase_AutoMigration_63_64_Impl());
        return arrayList;
    }

    public DeviceDao deviceDao() {
        DeviceDao deviceDao;
        if (this._deviceDao != null) {
            return this._deviceDao;
        }
        synchronized (this) {
            if (this._deviceDao == null) {
                this._deviceDao = new DeviceDao_Impl(this);
            }
            deviceDao = this._deviceDao;
        }
        return deviceDao;
    }

    public DeviceDataDao deviceDataDao() {
        DeviceDataDao deviceDataDao;
        if (this._deviceDataDao != null) {
            return this._deviceDataDao;
        }
        synchronized (this) {
            if (this._deviceDataDao == null) {
                this._deviceDataDao = new DeviceDataDao_Impl(this);
            }
            deviceDataDao = this._deviceDataDao;
        }
        return deviceDataDao;
    }

    public TrackedLocationDao trackedLocationDao() {
        TrackedLocationDao trackedLocationDao;
        if (this._trackedLocationDao != null) {
            return this._trackedLocationDao;
        }
        synchronized (this) {
            if (this._trackedLocationDao == null) {
                this._trackedLocationDao = new TrackedLocationDao_Impl(this);
            }
            trackedLocationDao = this._trackedLocationDao;
        }
        return trackedLocationDao;
    }

    public AqiDataDao aqiDataDao() {
        AqiDataDao aqiDataDao;
        if (this._aqiDataDao != null) {
            return this._aqiDataDao;
        }
        synchronized (this) {
            if (this._aqiDataDao == null) {
                this._aqiDataDao = new AqiDataDao_Impl(this);
            }
            aqiDataDao = this._aqiDataDao;
        }
        return aqiDataDao;
    }

    public DeviceScheduleDao deviceScheduleDao() {
        DeviceScheduleDao deviceScheduleDao;
        if (this._deviceScheduleDao != null) {
            return this._deviceScheduleDao;
        }
        synchronized (this) {
            if (this._deviceScheduleDao == null) {
                this._deviceScheduleDao = new DeviceScheduleDao_Impl(this);
            }
            deviceScheduleDao = this._deviceScheduleDao;
        }
        return deviceScheduleDao;
    }

    public NotificationDao notificationDao() {
        NotificationDao notificationDao;
        if (this._notificationDao != null) {
            return this._notificationDao;
        }
        synchronized (this) {
            if (this._notificationDao == null) {
                this._notificationDao = new NotificationDao_Impl(this);
            }
            notificationDao = this._notificationDao;
        }
        return notificationDao;
    }
}
