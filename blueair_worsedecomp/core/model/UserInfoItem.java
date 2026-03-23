package com.blueair.core.model;

import com.facebook.AuthenticationTokenClaims;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&¨\u0006'"}, d2 = {"Lcom/blueair/core/model/UserInfoItem;", "", "group", "Lcom/blueair/core/model/UserInfoGroup;", "id", "", "<init>", "(Ljava/lang/String;ILcom/blueair/core/model/UserInfoGroup;Ljava/lang/String;)V", "getGroup", "()Lcom/blueair/core/model/UserInfoGroup;", "getId", "()Ljava/lang/String;", "USER_EMAIL", "USER_PASSWORD", "USER_AGE", "USER_ADDRESS", "USER_LOCATION", "USER_SEARCH_RECORDS", "USER_BEHAVIOR", "ANDROID_ID", "PHONE_IMEI", "PHONE_MAC", "PHONE_WIFI_BSSID", "PHONE_MODEL", "PHONE_SYSTEM_VERSION", "BLUEAIR_APP_VERSION", "PHONE_BRAND", "PHONE_RAM_SIZE", "PHONE_VENDOR", "PHONE_COUNTRY_CODE", "BLUEAIR_APP_INFO", "PHONE_SENSOR_DATA", "PHONE_WIFI_STATE", "PHONE_MNO_STATION", "NET_WIFI_SSID", "NET_IP", "DEVICE_MAC", "DEVICE_SERIAL", "DEVICE_SENSOR_DATA", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserInfoCollections.kt */
public enum UserInfoItem {
    USER_EMAIL(UserInfoGroup.USER_PROFILE, "user_email"),
    USER_PASSWORD(UserInfoGroup.USER_PROFILE, "user_password"),
    USER_AGE(UserInfoGroup.USER_PROFILE, "user_age"),
    USER_ADDRESS(UserInfoGroup.USER_PROFILE, "user_address"),
    USER_LOCATION(UserInfoGroup.USER_BEHAVIOR, AuthenticationTokenClaims.JSON_KEY_USER_LOCATION),
    USER_SEARCH_RECORDS(UserInfoGroup.USER_BEHAVIOR, "search_records"),
    USER_BEHAVIOR(UserInfoGroup.USER_BEHAVIOR, "user_behavior"),
    ANDROID_ID(UserInfoGroup.DEVICE_INFO, "android_id"),
    PHONE_IMEI(UserInfoGroup.DEVICE_INFO, "phone_imei"),
    PHONE_MAC(UserInfoGroup.DEVICE_INFO, "phone_mac"),
    PHONE_WIFI_BSSID(UserInfoGroup.DEVICE_INFO, "phone_wifi_bssid"),
    PHONE_MODEL(UserInfoGroup.DEVICE_INFO, "phone_model"),
    PHONE_SYSTEM_VERSION(UserInfoGroup.DEVICE_INFO, "phone_system_version"),
    BLUEAIR_APP_VERSION(UserInfoGroup.DEVICE_INFO, "blueair_app_version"),
    PHONE_BRAND(UserInfoGroup.DEVICE_INFO, "phone_brand"),
    PHONE_RAM_SIZE(UserInfoGroup.DEVICE_INFO, "phone_ram_size"),
    PHONE_VENDOR(UserInfoGroup.DEVICE_INFO, "phone_vendor"),
    PHONE_COUNTRY_CODE(UserInfoGroup.DEVICE_INFO, "phone_country_code"),
    BLUEAIR_APP_INFO(UserInfoGroup.DEVICE_INFO, "blueair_app_info"),
    PHONE_SENSOR_DATA(UserInfoGroup.DEVICE_INFO, "phone_sensor_data"),
    PHONE_WIFI_STATE(UserInfoGroup.DEVICE_INFO, "phone_wifi_state"),
    PHONE_MNO_STATION(UserInfoGroup.DEVICE_INFO, "phone_mno_station"),
    NET_WIFI_SSID(UserInfoGroup.NETWORK_INFO, "net_wifi_ssid"),
    NET_IP(UserInfoGroup.NETWORK_INFO, "net_ip"),
    DEVICE_MAC(UserInfoGroup.PURIFIER_INFO, "device_mac"),
    DEVICE_SERIAL(UserInfoGroup.PURIFIER_INFO, "device_serial"),
    DEVICE_SENSOR_DATA(UserInfoGroup.PURIFIER_INFO, "device_sensor_data");
    
    private final UserInfoGroup group;
    private final String id;

    public static EnumEntries<UserInfoItem> getEntries() {
        return $ENTRIES;
    }

    private UserInfoItem(UserInfoGroup userInfoGroup, String str) {
        this.group = userInfoGroup;
        this.id = str;
    }

    public final UserInfoGroup getGroup() {
        return this.group;
    }

    public final String getId() {
        return this.id;
    }

    static {
        UserInfoItem[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
    }
}
