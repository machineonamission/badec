package com.blueair.core;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/core/FileNames;", "", "<init>", "()V", "TIMEZONE_LIST", "", "SKU_CONFIGURATIONS", "USER_INFO_COLLECTIONS", "DEBUG_LOG", "AQI_DATA_REFRESH_TIME_MAP_FILE", "BLE_DEVICE_MAC_NAME_MAP_FILE", "CHINA_PRIVACY_CONSENT_VERSION", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FileNames.kt */
public final class FileNames {
    public static final String AQI_DATA_REFRESH_TIME_MAP_FILE = "aqi_data_refresh_time_map";
    public static final String BLE_DEVICE_MAC_NAME_MAP_FILE = "ble_device_mac_name_map_file";
    public static final String CHINA_PRIVACY_CONSENT_VERSION = "china_privacy_consent_version";
    public static final String DEBUG_LOG = "debug_log";
    public static final FileNames INSTANCE = new FileNames();
    public static final String SKU_CONFIGURATIONS = "sku_configuration.json";
    public static final String TIMEZONE_LIST = "timezones";
    public static final String USER_INFO_COLLECTIONS = "user_info_collections.json";

    private FileNames() {
    }
}
