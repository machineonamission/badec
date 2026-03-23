package com.blueair.core.model;

import androidx.core.app.NotificationCompat;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.gigya.android.sdk.GigyaDefinitions;
import com.gigya.android.sdk.ui.plugin.GigyaPluginEvent;
import com.gigya.android.sdk.ui.plugin.PluginAuthEventDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \f2\u00020\u0001:!\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0001 -./0123456789:;<=>?@ABCDEFGHIJKL¨\u0006M"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent;", "", "eventName", "", "payload", "", "<init>", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "getPayload", "()Ljava/util/Map;", "Companion", "ScreenViewEvent", "LogoutEvent", "ForgotPasswordEvent", "OnboardingLogEvent", "GigyaErrorEvent", "CloudJwtExpiredEvent", "AppUpgradeEvent", "GigyaCloudRegionMismatchEvent", "GigyaGetAccountErrorEvent", "BT_SUCCESS", "BT_PRODUCT_FOUND", "BT_PRODUCT_SELECTED", "BT_PRODUCT_SELECTED_ERROR", "BT_INCORRECT_PW", "BT_EVENT", "BT_EVENT_FAILURE", "BT_REGISTER_ONBOARDING_ERROR", "BT_CHOOSE_DEFAULT_NAME", "BT_FINALIZE", "DeviceSettingEvent", "DeviceBatchSettingEvent", "OPEN_FAN_HISTORY", "SET_SCHEDULE", "SAVE_OUTDOOR_LOCATION", "ENABLE_GPS_LOCATION", "TAP_TROUBLESHOOTING", "TAP_CUSTOMER_SUPPORT", "REFRESH_GIGYA_JWT", "BreezoApiEvent", "BugEvent", "KlaviyoEvent", "FilterClickEvent", "Lcom/blueair/core/model/AnalyticEvent$AppUpgradeEvent;", "Lcom/blueair/core/model/AnalyticEvent$BT_CHOOSE_DEFAULT_NAME;", "Lcom/blueair/core/model/AnalyticEvent$BT_EVENT;", "Lcom/blueair/core/model/AnalyticEvent$BT_EVENT_FAILURE;", "Lcom/blueair/core/model/AnalyticEvent$BT_FINALIZE;", "Lcom/blueair/core/model/AnalyticEvent$BT_INCORRECT_PW;", "Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_FOUND;", "Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED;", "Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED_ERROR;", "Lcom/blueair/core/model/AnalyticEvent$BT_REGISTER_ONBOARDING_ERROR;", "Lcom/blueair/core/model/AnalyticEvent$BT_SUCCESS;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "Lcom/blueair/core/model/AnalyticEvent$CloudJwtExpiredEvent;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent$ENABLE_GPS_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "Lcom/blueair/core/model/AnalyticEvent$ForgotPasswordEvent;", "Lcom/blueair/core/model/AnalyticEvent$GigyaCloudRegionMismatchEvent;", "Lcom/blueair/core/model/AnalyticEvent$GigyaErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent$GigyaGetAccountErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "Lcom/blueair/core/model/AnalyticEvent$LogoutEvent;", "Lcom/blueair/core/model/AnalyticEvent$OPEN_FAN_HISTORY;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "Lcom/blueair/core/model/AnalyticEvent$REFRESH_GIGYA_JWT;", "Lcom/blueair/core/model/AnalyticEvent$SAVE_OUTDOOR_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent$SET_SCHEDULE;", "Lcom/blueair/core/model/AnalyticEvent$ScreenViewEvent;", "Lcom/blueair/core/model/AnalyticEvent$TAP_CUSTOMER_SUPPORT;", "Lcom/blueair/core/model/AnalyticEvent$TAP_TROUBLESHOOTING;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AnalyticEvent.kt */
public abstract class AnalyticEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_CITY = "city";
    public static final String KEY_ERROR_CODE = "error_code";
    public static final String KEY_ERROR_DESCRIPTION = "error_description";
    public static final String KEY_EVENT_NAME = "event_name";
    public static final String KEY_MAC = "mac";
    public static final String KEY_NAME = "name";
    public static final String KEY_ONLINE_TIME = "online_time";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_SETTING = "setting";
    public static final String KEY_TIMESTAMP = "time";
    public static final String KEY_TIME_END = "end_time";
    public static final String KEY_TIME_START = "start_time";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UUID = "uuid";
    public static final String KEY_VALUE = "value";
    public static final String VALUE_PLATFORM = "android";
    private final String eventName;
    private final Map<String, Object> payload;

    public /* synthetic */ AnalyticEvent(String str, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$Companion;", "", "<init>", "()V", "KEY_UUID", "", "KEY_MAC", "KEY_NAME", "KEY_EVENT_NAME", "KEY_ERROR_DESCRIPTION", "KEY_ERROR_CODE", "KEY_SETTING", "KEY_VALUE", "KEY_CITY", "KEY_TIME_START", "KEY_TIME_END", "KEY_ONLINE_TIME", "KEY_TYPE", "KEY_PLATFORM", "VALUE_PLATFORM", "KEY_TIMESTAMP", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private AnalyticEvent(String str, Map<String, ? extends Object> map) {
        this.eventName = str;
        this.payload = map;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getPayload() {
        return this.payload;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$ScreenViewEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "screenName", "", "screenClass", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class ScreenViewEvent extends AnalyticEvent {
        public static final String ADD_DEVICE = "add_device";
        public static final String ADD_DEVICE_CONNECTING = "add_device_connecting";
        public static final String ADD_DEVICE_FINALIZE = "add_device_finalize";
        public static final String ADD_DEVICE_LEGACY = "add_device_legacy";
        public static final String ADD_DEVICE_PAIRING = "add_device_pairing";
        public static final String ADD_DEVICE_SCAN = "add_device_scan";
        public static final String ADD_DEVICE_SET_NAME = "add_device_set_name";
        public static final String ADD_DEVICE_WIFI_LIST = "add_device_wifi_list";
        public static final String ADD_DEVICE_WIFI_PASSWORD = "add_device_wifi_password";
        public static final String ANTIFAKE_INSTRUCTION = "antifake_instruction";
        public static final String ANTIFAKE_RESET = "antifake_reset";
        public static final String ANTIFAKE_RESET_BY_BLUETOOTH = "antifake_reset_reset_by_bluetooth";
        public static final String ANTIFAKE_RESET_BY_WIFI = "antifake_reset_reset_by_wifi";
        public static final String ANTIFAKE_RESET_VERIFYING = "antifake_reset_verifying";
        public static final String ANTIFAKE_RESET_VERIFY_RESULT = "antifake_reset_verify_result";
        public static final String ANTIFAKE_SCAN = "antifake_scan";
        public static final String ANTIFAKE_SCAN_BLUETOOTH = "antifake_reset_scan_bluetooth";
        public static final String ANTIFAKE_SELECT_DEVICE = "antifake_reset_select_device";
        public static final String CONNECT_DEVICE_GUIDE = "connect_device_guide";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String DEVICE_DETAILS = "device_details";
        public static final String DEVICE_DETAILS_ABOUT_AQI = "device_details_about_aqi";
        public static final String DEVICE_DETAILS_ALARM_DELETE = "device_details_alarm_delete";
        public static final String DEVICE_DETAILS_ALARM_DETAILS = "device_details_alarm_details";
        public static final String DEVICE_DETAILS_ALARM_LIST = "device_details_alarm_list";
        public static final String DEVICE_DETAILS_ALARM_SOUND = "device_details_alarm_sound";
        public static final String DEVICE_DETAILS_FILTER = "device_details_filter";
        public static final String DEVICE_DETAILS_SCHEDULE_DETAILS = "device_details_schedule_details";
        public static final String DEVICE_DETAILS_SCHEDULE_LIST = "device_details_schedule_list";
        public static final String DEVICE_DETAILS_SCHEDULE_MODE = "device_details_schedule_mode";
        public static final String DEVICE_FILTER_BUY = "device_filter_buy";
        public static final String DEVICE_FILTER_BUY_WEB = "device_filter_buy_web";
        public static final String DEVICE_FILTER_MANUAL = "device_filter_manual";
        public static final String DEVICE_FILTER_REPLACE = "device_filter_replace";
        public static final String DEVICE_FILTER_VIDEO = "device_filter_video";
        public static final String DEVICE_SETTINGS = "device_settings";
        public static final String DEVICE_SETTINGS_DELETE = "device_settings_delete";
        public static final String DEVICE_SETTINGS_DRY_MODE = "device_settings_dry_mode";
        public static final String DEVICE_SETTINGS_INFO = "device_settings_info";
        public static final String DEVICE_SETTINGS_MANUAL = "device_settings_manual";
        public static final String DEVICE_SETTINGS_SET_NAME = "device_settings_set_name";
        public static final String DEVICE_SETTINGS_TEMPERATURE = "device_settings_temperature";
        public static final String DEVICE_SETTINGS_TIMEZONE = "device_settings_timezone";
        public static final String DEVICE_SETTINGS_WELCOME_HOME = "device_settings_welcome_home";
        public static final String GOOGLE_APP_FLIP = "google_app_flip";
        public static final String HOME = "home";
        public static final String LOGIN = "login";
        public static final String NOTIFICATIONS = "notifications";
        public static final String NOTIFICATIONS_FILTER = "notifications_filter";
        public static final String OUTDOOR_MAP = "outdoor_map";
        public static final String OUTDOOR_MAP_ASSIGN_PRODUCTS = "outdoor_map_assign_products";
        public static final String OUTDOOR_MAP_SEARCH = "outdoor_map_search";
        public static final String REGISTER = "register";
        public static final String SIDE_MENU = "side_menu";
        public static final String SIDE_MENU_CUSTOMER_SUPPORT = "side_menu_customer_support";
        public static final String SIDE_MENU_DEV_SETTINGS = "side_menu_dev_settings";
        public static final String SIDE_MENU_POLICY = "side_menu_policy";
        public static final String SIDE_MENU_POLICY_USER_INFO_DETAILS = "side_menu_policy_user_info_details";
        public static final String SIDE_MENU_POLICY_USER_INFO_GROUPS = "side_menu_policy_user_info_groups";
        public static final String SIDE_MENU_PROFILE = "side_menu_profile";
        public static final String SIDE_MENU_PROFILE_DELETE_ACCOUNT = "side_menu_profile_delete_account";
        public static final String SIDE_MENU_PROFILE_MANAGE_ACCOUNT = "side_menu_profile_manage_account";
        public static final String SIDE_MENU_SETTINGS = "side_menu_settings";
        public static final String SIDE_MENU_SETTINGS_NOTIFICATION = "side_menu_settings_notification";
        public static final String SIDE_MENU_STORE = "side_menu_store";
        public static final String SIDE_MENU_VOICE_ASSISTANT = "side_menu_voice_assistant";
        public static final String SIDE_MENU_VOICE_ASSISTANT_ALEXA = "side_menu_voice_assistant_alexa";
        public static final String SIDE_MENU_VOICE_ASSISTANT_ALEXA_OLD = "side_menu_voice_assistant_alexa_old";
        public static final String SIDE_MENU_VOICE_ASSISTANT_GOOGLE = "side_menu_voice_assistant_google";
        public static final String UPLOAD_LOG = "upload_log";
        public static final String WELCOME = "welcome";

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ScreenViewEvent(String str, String str2) {
            super(FirebaseAnalytics.Event.SCREEN_VIEW, MapsKt.mapOf(TuplesKt.to("screen_name", str), TuplesKt.to(FirebaseAnalytics.Param.SCREEN_CLASS, str2)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "screenName");
            Intrinsics.checkNotNullParameter(str2, "screenClass");
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\bF\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$ScreenViewEvent$Companion;", "", "<init>", "()V", "WELCOME", "", "LOGIN", "REGISTER", "CONNECT_DEVICE_GUIDE", "HOME", "SIDE_MENU", "SIDE_MENU_STORE", "SIDE_MENU_PROFILE", "SIDE_MENU_PROFILE_MANAGE_ACCOUNT", "SIDE_MENU_PROFILE_DELETE_ACCOUNT", "SIDE_MENU_SETTINGS", "SIDE_MENU_SETTINGS_NOTIFICATION", "SIDE_MENU_DEV_SETTINGS", "SIDE_MENU_CUSTOMER_SUPPORT", "SIDE_MENU_VOICE_ASSISTANT", "SIDE_MENU_VOICE_ASSISTANT_ALEXA", "SIDE_MENU_VOICE_ASSISTANT_ALEXA_OLD", "SIDE_MENU_VOICE_ASSISTANT_GOOGLE", "SIDE_MENU_POLICY", "SIDE_MENU_POLICY_USER_INFO_GROUPS", "SIDE_MENU_POLICY_USER_INFO_DETAILS", "ADD_DEVICE", "ADD_DEVICE_LEGACY", "ADD_DEVICE_SCAN", "ADD_DEVICE_PAIRING", "ADD_DEVICE_WIFI_LIST", "ADD_DEVICE_WIFI_PASSWORD", "ADD_DEVICE_CONNECTING", "ADD_DEVICE_SET_NAME", "ADD_DEVICE_FINALIZE", "DEVICE_DETAILS", "DEVICE_DETAILS_ABOUT_AQI", "DEVICE_DETAILS_SCHEDULE_LIST", "DEVICE_DETAILS_SCHEDULE_DETAILS", "DEVICE_DETAILS_SCHEDULE_MODE", "DEVICE_DETAILS_ALARM_LIST", "DEVICE_DETAILS_ALARM_DETAILS", "DEVICE_DETAILS_ALARM_SOUND", "DEVICE_DETAILS_ALARM_DELETE", "DEVICE_DETAILS_FILTER", "DEVICE_FILTER_MANUAL", "DEVICE_FILTER_REPLACE", "DEVICE_FILTER_VIDEO", "DEVICE_FILTER_BUY", "DEVICE_FILTER_BUY_WEB", "DEVICE_SETTINGS", "DEVICE_SETTINGS_SET_NAME", "DEVICE_SETTINGS_TIMEZONE", "DEVICE_SETTINGS_WELCOME_HOME", "DEVICE_SETTINGS_DRY_MODE", "DEVICE_SETTINGS_TEMPERATURE", "DEVICE_SETTINGS_MANUAL", "DEVICE_SETTINGS_INFO", "DEVICE_SETTINGS_DELETE", "ANTIFAKE_INSTRUCTION", "ANTIFAKE_SCAN", "ANTIFAKE_RESET", "ANTIFAKE_RESET_VERIFYING", "ANTIFAKE_RESET_VERIFY_RESULT", "ANTIFAKE_SELECT_DEVICE", "ANTIFAKE_RESET_BY_WIFI", "ANTIFAKE_SCAN_BLUETOOTH", "ANTIFAKE_RESET_BY_BLUETOOTH", "NOTIFICATIONS", "NOTIFICATIONS_FILTER", "OUTDOOR_MAP", "OUTDOOR_MAP_SEARCH", "OUTDOOR_MAP_ASSIGN_PRODUCTS", "GOOGLE_APP_FLIP", "UPLOAD_LOG", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$LogoutEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "reason", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class LogoutEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LogoutEvent(String str) {
            super(PluginAuthEventDef.LOGOUT, MapsKt.mutableMapOf(TuplesKt.to("reason", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "reason");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$ForgotPasswordEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "success", "", "errorMessage", "", "<init>", "(ZLjava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class ForgotPasswordEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ForgotPasswordEvent(boolean z, String str) {
            super("forgot_password", MapsKt.mutableMapOf(TuplesKt.to("success", Boolean.valueOf(z)), TuplesKt.to("error_message", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorMessage");
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \r2\u00020\u0001:\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014B=\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\f\u0001\u0007\u0015\u0016\u0017\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "step", "", "screen", "extra", "payload", "", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Companion", "ScreenStayEvent", "SelectDevice", "ConnectInstructions", "Connecting", "WifiList", "WifiPassword", "Onboarding", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ConnectInstructions;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Connecting;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Onboarding;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ScreenStayEvent;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$SelectDevice;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiList;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiPassword;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class OnboardingLogEvent extends AnalyticEvent {
        public static final String CONNECT_TYPE_DETECT = "detect";
        public static final String CONNECT_TYPE_FORCE = "force";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String PAIR_BTN_AUTO = "auto";
        public static final String PAIR_BTN_FAN = "fan";
        public static final String RESULT_FAILED = "failed";
        public static final String RESULT_SUCCESS = "success";
        public static final String TYPE_NULL = "null";
        public static final String UNKNOWN = "unknown";

        public /* synthetic */ OnboardingLogEvent(String str, int i, String str2, String str3, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, str2, str3, map);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private OnboardingLogEvent(java.lang.String r2, int r3, java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, ? extends java.lang.Object> r6) {
            /*
                r1 = this;
                java.util.Map r6 = kotlin.collections.MapsKt.toMutableMap(r6)
                java.lang.String r0 = "session_uuid"
                r6.put(r0, r2)
                java.lang.String r2 = "step"
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r6.put(r2, r3)
                java.lang.String r2 = "screen"
                r6.put(r2, r4)
                java.lang.String r2 = "extra"
                r6.put(r2, r5)
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
                r2 = 0
                java.lang.String r3 = "onboarding_log"
                r1.<init>(r3, r6, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.<init>(java.lang.String, int, java.lang.String, java.lang.String, java.util.Map):void");
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Companion;", "", "<init>", "()V", "RESULT_SUCCESS", "", "RESULT_FAILED", "UNKNOWN", "TYPE_NULL", "PAIR_BTN_AUTO", "PAIR_BTN_FAN", "CONNECT_TYPE_DETECT", "CONNECT_TYPE_FORCE", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ScreenStayEvent;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "screen", "time", "", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class ScreenStayEvent extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ScreenStayEvent(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, i, (i2 & 8) != 0 ? "" : str3);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public ScreenStayEvent(String str, String str2, int i, String str3) {
                super(str, -1, str2, str3, MapsKt.mapOf(TuplesKt.to("time", Integer.valueOf(i))), (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "uuid");
                Intrinsics.checkNotNullParameter(str2, "screen");
                Intrinsics.checkNotNullParameter(str3, "extra");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$SelectDevice;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "sku", "mac", "family", "model", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SelectDevice extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ SelectDevice(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, str5, (i & 32) != 0 ? "" : str6);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public SelectDevice(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18) {
                /*
                    r12 = this;
                    r2 = r16
                    r3 = r17
                    java.lang.String r4 = "uuid"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r4)
                    java.lang.String r4 = "sku"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r4)
                    java.lang.String r5 = "mac"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r5)
                    java.lang.String r7 = "family"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
                    java.lang.String r8 = "model"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r8)
                    java.lang.String r9 = "extra"
                    r10 = r18
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r9)
                    r9 = 4
                    kotlin.Pair[] r9 = new kotlin.Pair[r9]
                    r11 = 0
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r4, r14)
                    r9[r11] = r0
                    r0 = 1
                    kotlin.Pair r1 = kotlin.TuplesKt.to(r5, r15)
                    r9[r0] = r1
                    r0 = 2
                    kotlin.Pair r1 = kotlin.TuplesKt.to(r7, r2)
                    r9[r0] = r1
                    r0 = 3
                    kotlin.Pair r1 = kotlin.TuplesKt.to(r8, r3)
                    r9[r0] = r1
                    java.util.Map r0 = kotlin.collections.MapsKt.mapOf(r9)
                    r11 = 0
                    r7 = 0
                    java.lang.String r8 = "select_device"
                    r5 = r12
                    r6 = r13
                    r9 = r10
                    r10 = r0
                    r5.<init>(r6, r7, r8, r9, r10, r11)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.SelectDevice.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$ConnectInstructions;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "pairBtn", "connectType", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class ConnectInstructions extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ ConnectInstructions(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, (i & 8) != 0 ? "" : str4);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public ConnectInstructions(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
                /*
                    r8 = this;
                    java.lang.String r0 = "uuid"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r0 = "pairBtn"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    java.lang.String r0 = "connectType"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                    java.lang.String r0 = "extra"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                    r0 = 2
                    kotlin.Pair[] r0 = new kotlin.Pair[r0]
                    java.lang.String r1 = "pair_btn"
                    kotlin.Pair r10 = kotlin.TuplesKt.to(r1, r10)
                    r1 = 0
                    r0[r1] = r10
                    java.lang.String r10 = "connect_type"
                    kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r11)
                    r11 = 1
                    r0[r11] = r10
                    java.util.Map r6 = kotlin.collections.MapsKt.mapOf(r0)
                    r7 = 0
                    r3 = 1
                    java.lang.String r4 = "connect_instructions"
                    r1 = r8
                    r2 = r9
                    r5 = r12
                    r1.<init>(r2, r3, r4, r5, r6, r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.ConnectInstructions.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Connecting;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "bleEstablishSession", "bleStartProvision", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Connecting extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Connecting(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, (i & 8) != 0 ? "" : str4);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Connecting(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
                /*
                    r8 = this;
                    java.lang.String r0 = "uuid"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r0 = "bleEstablishSession"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                    java.lang.String r0 = "bleStartProvision"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                    java.lang.String r0 = "extra"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                    r0 = 2
                    kotlin.Pair[] r0 = new kotlin.Pair[r0]
                    java.lang.String r1 = "ble_establish_session"
                    kotlin.Pair r10 = kotlin.TuplesKt.to(r1, r10)
                    r1 = 0
                    r0[r1] = r10
                    java.lang.String r10 = "ble_start_provision"
                    kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r11)
                    r11 = 1
                    r0[r11] = r10
                    java.util.Map r6 = kotlin.collections.MapsKt.mapOf(r0)
                    r7 = 0
                    r3 = 2
                    java.lang.String r4 = "connecting"
                    r1 = r8
                    r2 = r9
                    r5 = r12
                    r1.<init>(r2, r3, r4, r5, r6, r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.Connecting.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiList;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "refreshCount", "", "ssidCount", "extra", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class WifiList extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ WifiList(String str, int i, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, i, i2, (i3 & 8) != 0 ? "" : str2);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public WifiList(java.lang.String r9, int r10, int r11, java.lang.String r12) {
                /*
                    r8 = this;
                    java.lang.String r0 = "uuid"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r0 = "extra"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
                    r0 = 2
                    kotlin.Pair[] r0 = new kotlin.Pair[r0]
                    java.lang.String r1 = "refresh_count"
                    java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
                    kotlin.Pair r10 = kotlin.TuplesKt.to(r1, r10)
                    r1 = 0
                    r0[r1] = r10
                    java.lang.String r10 = "ssid_count"
                    java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
                    kotlin.Pair r10 = kotlin.TuplesKt.to(r10, r11)
                    r11 = 1
                    r0[r11] = r10
                    java.util.Map r6 = kotlin.collections.MapsKt.mapOf(r0)
                    r7 = 0
                    r3 = 3
                    java.lang.String r4 = "wifi_list"
                    r1 = r8
                    r2 = r9
                    r5 = r12
                    r1.<init>(r2, r3, r4, r5, r6, r7)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.WifiList.<init>(java.lang.String, int, int, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$WifiPassword;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "cloudRegion", "registerForOnboarding", "bleConfigProvision", "bleConfigWifi", "bleApplyWifi", "blePollWifiConnected", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class WifiPassword extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ WifiPassword(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, str3, str4, str5, str6, str7, (i & 128) != 0 ? "" : str8);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public WifiPassword(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) {
                /*
                    r14 = this;
                    r0 = r16
                    r1 = r17
                    r2 = r18
                    r3 = r19
                    r4 = r20
                    r5 = r21
                    java.lang.String r6 = "uuid"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r6)
                    java.lang.String r6 = "cloudRegion"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r6)
                    java.lang.String r6 = "registerForOnboarding"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r6)
                    java.lang.String r6 = "bleConfigProvision"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r6)
                    java.lang.String r6 = "bleConfigWifi"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
                    java.lang.String r6 = "bleApplyWifi"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
                    java.lang.String r6 = "blePollWifiConnected"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
                    java.lang.String r6 = "extra"
                    r11 = r22
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r6)
                    r6 = 6
                    kotlin.Pair[] r6 = new kotlin.Pair[r6]
                    java.lang.String r7 = "cloud_region"
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r7, r0)
                    r7 = 0
                    r6[r7] = r0
                    java.lang.String r0 = "register_for_onboarding"
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
                    r1 = 1
                    r6[r1] = r0
                    java.lang.String r0 = "ble_config_provision"
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r2)
                    r1 = 2
                    r6[r1] = r0
                    java.lang.String r0 = "ble_config_wifi"
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r3)
                    r1 = 3
                    r6[r1] = r0
                    java.lang.String r0 = "ble_apply_wifi"
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r4)
                    r1 = 4
                    r6[r1] = r0
                    java.lang.String r0 = "ble_poll_wifi_connected"
                    kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r5)
                    r1 = 5
                    r6[r1] = r0
                    java.util.Map r12 = kotlin.collections.MapsKt.mapOf(r6)
                    r13 = 0
                    r9 = 4
                    java.lang.String r10 = "wifi_password"
                    r7 = r14
                    r8 = r15
                    r7.<init>(r8, r9, r10, r11, r12, r13)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.OnboardingLogEvent.WifiPassword.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent$Onboarding;", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "uuid", "", "blePollDeviceBound", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Onboarding extends OnboardingLogEvent {
            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Onboarding(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, str2, (i & 4) != 0 ? "" : str3);
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Onboarding(String str, String str2, String str3) {
                super(str, 5, "onboarding", str3, MapsKt.mapOf(TuplesKt.to("ble_poll_device_bound", str2)), (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "uuid");
                Intrinsics.checkNotNullParameter(str2, "blePollDeviceBound");
                Intrinsics.checkNotNullParameter(str3, "extra");
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$GigyaErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "api", "", "errorCode", "errorMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class GigyaErrorEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GigyaErrorEvent(String str, String str2, String str3) {
            super("gigya_error", MapsKt.mutableMapOf(TuplesKt.to("api", str), TuplesKt.to("error_code", str2), TuplesKt.to("error_message", str3)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "api");
            Intrinsics.checkNotNullParameter(str2, "errorCode");
            Intrinsics.checkNotNullParameter(str3, "errorMessage");
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$CloudJwtExpiredEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "expiredCount", "", "messages", "", "iat", "Ljava/util/Date;", "exp", "<init>", "(ILjava/lang/String;Ljava/util/Date;Ljava/util/Date;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class CloudJwtExpiredEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public CloudJwtExpiredEvent(int i, String str, Date date, Date date2) {
            super("cloud_jwt_expired", MapsKt.mutableMapOf(TuplesKt.to("expired_count", Integer.valueOf(i)), TuplesKt.to("messages", str), TuplesKt.to(AuthenticationTokenClaims.JSON_KEY_IAT, String.valueOf(date)), TuplesKt.to(AuthenticationTokenClaims.JSON_KEY_EXP, String.valueOf(date2)), TuplesKt.to(GigyaDefinitions.AccountProfileExtraFields.TIMEZONE, TimeZone.getDefault().getID()), TuplesKt.to("local_time", new Date().toString())), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "messages");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$AppUpgradeEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "gigyaUid", "", "fromCode", "", "fromName", "toCode", "toName", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class AppUpgradeEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AppUpgradeEvent(String str, int i, String str2, int i2, String str3) {
            super("blueair_app_upgrade", MapsKt.mapOf(TuplesKt.to("gigyaUid", str), TuplesKt.to("fromCode", Integer.valueOf(i)), TuplesKt.to("fromName", str2), TuplesKt.to("toCode", Integer.valueOf(i2)), TuplesKt.to("toName", str3), TuplesKt.to("platform", "android"), TuplesKt.to("time", Long.valueOf(System.currentTimeMillis()))), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "gigyaUid");
            Intrinsics.checkNotNullParameter(str2, "fromName");
            Intrinsics.checkNotNullParameter(str3, "toName");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$GigyaCloudRegionMismatchEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "gigyaUid", "", "fromRegion", "toRegion", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class GigyaCloudRegionMismatchEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GigyaCloudRegionMismatchEvent(String str, String str2, String str3, String str4) {
            super("cloud_region_mismatch", MapsKt.mapOf(TuplesKt.to("gigyaUid", str), TuplesKt.to("fromRegion", str2), TuplesKt.to("toRegion", str3), TuplesKt.to("cause", str4), TuplesKt.to("platform", "android"), TuplesKt.to("time", Long.valueOf(System.currentTimeMillis()))), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "gigyaUid");
            Intrinsics.checkNotNullParameter(str2, "fromRegion");
            Intrinsics.checkNotNullParameter(str3, "toRegion");
            Intrinsics.checkNotNullParameter(str4, "cause");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$GigyaGetAccountErrorEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "gigyaUid", "", "gigyaRegion", "errorCode", "errorMessage", "errorData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class GigyaGetAccountErrorEvent extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GigyaGetAccountErrorEvent(String str, String str2, String str3, String str4, String str5) {
            super("gigya_get_account_error", MapsKt.mapOf(TuplesKt.to("gigyaUid", str), TuplesKt.to("gigyaRegion", str2), TuplesKt.to("errorCode", str3), TuplesKt.to("errorMessage", str4), TuplesKt.to("errorData", str5), TuplesKt.to("platform", "android"), TuplesKt.to("time", Long.valueOf(System.currentTimeMillis()))), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "gigyaUid");
            Intrinsics.checkNotNullParameter(str2, "gigyaRegion");
            Intrinsics.checkNotNullParameter(str3, "errorCode");
            Intrinsics.checkNotNullParameter(str4, "errorMessage");
            Intrinsics.checkNotNullParameter(str5, "errorData");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_SUCCESS;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_SUCCESS extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_SUCCESS(String str) {
            super("bt_success", MapsKt.mapOf(TuplesKt.to("uuid", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "uuid");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_FOUND;", "Lcom/blueair/core/model/AnalyticEvent;", "mac", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_PRODUCT_FOUND extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_PRODUCT_FOUND(String str) {
            super("bt_product_found", MapsKt.mapOf(TuplesKt.to(AnalyticEvent.KEY_MAC, str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, AnalyticEvent.KEY_MAC);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED;", "Lcom/blueair/core/model/AnalyticEvent;", "mac", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_PRODUCT_SELECTED extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_PRODUCT_SELECTED(String str) {
            super("bt_product_selected", MapsKt.mapOf(TuplesKt.to(AnalyticEvent.KEY_MAC, str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, AnalyticEvent.KEY_MAC);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_PRODUCT_SELECTED_ERROR;", "Lcom/blueair/core/model/AnalyticEvent;", "errorDescription", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_PRODUCT_SELECTED_ERROR extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_PRODUCT_SELECTED_ERROR(String str) {
            super("bt_product_selected_error", MapsKt.mapOf(TuplesKt.to("error_description", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorDescription");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_INCORRECT_PW;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_INCORRECT_PW extends AnalyticEvent {
        public BT_INCORRECT_PW() {
            super("bt_incorrect_pw", MapsKt.emptyMap(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_EVENT;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "eventName", "errorCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_EVENT extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_EVENT(String str, String str2, int i) {
            super("bt_event", MapsKt.mapOf(TuplesKt.to("uuid", str), TuplesKt.to(AnalyticEvent.KEY_EVENT_NAME, str2), TuplesKt.to("error_code", Integer.valueOf(i))), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "uuid");
            Intrinsics.checkNotNullParameter(str2, GigyaPluginEvent.EVENT_NAME);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_EVENT_FAILURE;", "Lcom/blueair/core/model/AnalyticEvent;", "uuid", "", "eventName", "errorCode", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_EVENT_FAILURE extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_EVENT_FAILURE(String str, String str2, int i) {
            super("bt_event_failure", MapsKt.mapOf(TuplesKt.to("uuid", str), TuplesKt.to(AnalyticEvent.KEY_EVENT_NAME, str2), TuplesKt.to("error_code", Integer.valueOf(i))), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "uuid");
            Intrinsics.checkNotNullParameter(str2, GigyaPluginEvent.EVENT_NAME);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_REGISTER_ONBOARDING_ERROR;", "Lcom/blueair/core/model/AnalyticEvent;", "errorDescription", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_REGISTER_ONBOARDING_ERROR extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_REGISTER_ONBOARDING_ERROR(String str) {
            super("bt_register_onboarding_error", MapsKt.mapOf(TuplesKt.to("error_description", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "errorDescription");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_CHOOSE_DEFAULT_NAME;", "Lcom/blueair/core/model/AnalyticEvent;", "name", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_CHOOSE_DEFAULT_NAME extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BT_CHOOSE_DEFAULT_NAME(String str) {
            super("bt_choose_default_name", MapsKt.mapOf(TuplesKt.to("name", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "name");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BT_FINALIZE;", "Lcom/blueair/core/model/AnalyticEvent;", "duration", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class BT_FINALIZE extends AnalyticEvent {
        public BT_FINALIZE(int i) {
            super("bt_finalizing", MapsKt.mapOf(TuplesKt.to(AnalyticEvent.KEY_ONLINE_TIME, Integer.valueOf(i))), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b1\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:/\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456B\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u0001/789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcde¨\u0006f"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "setting", "", "value", "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "SET_FAN_SPEED", "SET_GERM_SHIELD", "SET_GERM_SHIELD_NIGHT_MODE", "SET_STANDBY", "SET_ECO", "SET_HINS_MODE", "SET_HINS_NIGHT_MODE", "SET_AUTO_MODE", "SET_NIGHT_MODE", "SET_CHILD_LOCK", "SET_BRIGHTNESS", "SET_DISINFECTION", "SET_WICK_DRY_ENABLED", "SET_WICK_DRY_ON", "SET_AUTO_RH", "SET_TIMER_STATUS", "SET_TIMER_DURATION", "SET_TEMPERATURE_UNIT", "SET_OSCILLATION_STATE", "SET_MAIN_MODE", "SET_AP_SUBMODE", "SET_AP_FANSPEED", "SET_HEAT_SUBMODE", "SET_HEAT_FANSPEED", "SET_HEAT_AUTO_TMP", "SET_HEAT_ECO_TMP", "SET_COOL_SUBMODE", "SET_COOL_FANSPEED", "SET_MODE", "SET_HUM_MODE", "SET_DEH_SUBMODE", "SET_SMART_SUBMODE", "SET_TARE", "SET_PANEL_DISPLAY_MODE", "SET_HOVER_ENABLED", "SET_AIR_REFRESH_STATUS", "SET_AIR_REFRESH_ENABLED", "SET_NIGHT_LAMP_BRIGHTNESS", "SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS", "SET_WICK_DRY_DURATION", "SET_YWRM_ENABLED", "SET_ALARM", "PLAY_ALARM", "STOP_ALARM", "SET_HUM_SUBMODE", "SET_USE_24_HOUR", "SET_SENSOR_MODE", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$PLAY_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_RH;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_CHILD_LOCK;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DEH_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DISINFECTION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ECO;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_FAN_SPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_AUTO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_ECO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HOVER_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MAIN_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_OSCILLATION_STATE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_PANEL_DISPLAY_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SENSOR_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SMART_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_STANDBY;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TARE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TEMPERATURE_UNIT;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_USE_24_HOUR;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ON;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_YWRM_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$STOP_ALARM;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class DeviceSettingEvent extends AnalyticEvent {
        public /* synthetic */ DeviceSettingEvent(String str, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, obj);
        }

        private DeviceSettingEvent(String str, Object obj) {
            super("device_setting", MapsKt.mapOf(TuplesKt.to(AnalyticEvent.KEY_SETTING, str), TuplesKt.to("value", obj)), (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_FAN_SPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_FAN_SPEED extends DeviceSettingEvent {
            public SET_FAN_SPEED(int i) {
                super("fanspeed", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_GERM_SHIELD extends DeviceSettingEvent {
            public SET_GERM_SHIELD(boolean z) {
                super("germshield", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_GERM_SHIELD_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_GERM_SHIELD_NIGHT_MODE extends DeviceSettingEvent {
            public SET_GERM_SHIELD_NIGHT_MODE(boolean z) {
                super("gsnm", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_STANDBY;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_STANDBY extends DeviceSettingEvent {
            public SET_STANDBY(boolean z) {
                super("standby", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ECO;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_ECO extends DeviceSettingEvent {
            public SET_ECO(boolean z) {
                super("eco", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HINS_MODE extends DeviceSettingEvent {
            public SET_HINS_MODE(boolean z) {
                super("hins", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HINS_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HINS_NIGHT_MODE extends DeviceSettingEvent {
            public SET_HINS_NIGHT_MODE(boolean z) {
                super("nmhins", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_AUTO_MODE extends DeviceSettingEvent {
            public SET_AUTO_MODE(boolean z) {
                super("automode", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_NIGHT_MODE extends DeviceSettingEvent {
            public SET_NIGHT_MODE(boolean z) {
                super("nightmode", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_CHILD_LOCK;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_CHILD_LOCK extends DeviceSettingEvent {
            public SET_CHILD_LOCK(boolean z) {
                super("childlock", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_BRIGHTNESS extends DeviceSettingEvent {
            public SET_BRIGHTNESS(int i) {
                super("brightness", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DISINFECTION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_DISINFECTION extends DeviceSettingEvent {
            public SET_DISINFECTION(boolean z) {
                super("disinfection", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_WICK_DRY_ENABLED extends DeviceSettingEvent {
            public SET_WICK_DRY_ENABLED(boolean z) {
                super("wickdrye", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_ON;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_WICK_DRY_ON extends DeviceSettingEvent {
            public SET_WICK_DRY_ON(boolean z) {
                super("wickdrys", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AUTO_RH;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_AUTO_RH extends DeviceSettingEvent {
            public SET_AUTO_RH(int i) {
                super("autorh", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_TIMER_STATUS extends DeviceSettingEvent {
            public SET_TIMER_STATUS(int i) {
                super("timstate", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TIMER_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_TIMER_DURATION extends DeviceSettingEvent {
            public SET_TIMER_DURATION(int i) {
                super("timdur", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TEMPERATURE_UNIT;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_TEMPERATURE_UNIT extends DeviceSettingEvent {
            public SET_TEMPERATURE_UNIT(int i) {
                super("tu", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_OSCILLATION_STATE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_OSCILLATION_STATE extends DeviceSettingEvent {
            public SET_OSCILLATION_STATE(int i) {
                super("oscstate", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MAIN_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_MAIN_MODE extends DeviceSettingEvent {
            public SET_MAIN_MODE(int i) {
                super("mainmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_AP_SUBMODE extends DeviceSettingEvent {
            public SET_AP_SUBMODE(int i) {
                super("apsubmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AP_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_AP_FANSPEED extends DeviceSettingEvent {
            public SET_AP_FANSPEED(int i) {
                super("fsp0", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HEAT_SUBMODE extends DeviceSettingEvent {
            public SET_HEAT_SUBMODE(int i) {
                super("heatsubmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HEAT_FANSPEED extends DeviceSettingEvent {
            public SET_HEAT_FANSPEED(int i) {
                super("heatfs", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_AUTO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(D)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HEAT_AUTO_TMP extends DeviceSettingEvent {
            public SET_HEAT_AUTO_TMP(double d) {
                super("heattemp", Double.valueOf(d), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HEAT_ECO_TMP;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(D)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HEAT_ECO_TMP extends DeviceSettingEvent {
            public SET_HEAT_ECO_TMP(double d) {
                super("ecoheattemp", Double.valueOf(d), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_COOL_SUBMODE extends DeviceSettingEvent {
            public SET_COOL_SUBMODE(int i) {
                super("coolsubmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_COOL_FANSPEED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_COOL_FANSPEED extends DeviceSettingEvent {
            public SET_COOL_FANSPEED(int i) {
                super("coolfs", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_MODE extends DeviceSettingEvent {
            public SET_MODE(int i) {
                super("mode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HUM_MODE extends DeviceSettingEvent {
            public SET_HUM_MODE(boolean z) {
                super("hummode", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_DEH_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_DEH_SUBMODE extends DeviceSettingEvent {
            public SET_DEH_SUBMODE(int i) {
                super("dehsubmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SMART_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_SMART_SUBMODE extends DeviceSettingEvent {
            public SET_SMART_SUBMODE(int i) {
                super("smartsubmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_TARE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_TARE extends DeviceSettingEvent {
            public static final SET_TARE INSTANCE = new SET_TARE();

            private SET_TARE() {
                super("nw", 1, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_PANEL_DISPLAY_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_PANEL_DISPLAY_MODE extends DeviceSettingEvent {
            public SET_PANEL_DISPLAY_MODE(int i) {
                super("displaymode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HOVER_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HOVER_ENABLED extends DeviceSettingEvent {
            public SET_HOVER_ENABLED(boolean z) {
                super("hover", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_STATUS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_AIR_REFRESH_STATUS extends DeviceSettingEvent {
            public SET_AIR_REFRESH_STATUS(int i) {
                super("arstate", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_AIR_REFRESH_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_AIR_REFRESH_ENABLED extends DeviceSettingEvent {
            public SET_AIR_REFRESH_ENABLED(boolean z) {
                super("airrefresh", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_NIGHT_LAMP_BRIGHTNESS extends DeviceSettingEvent {
            public SET_NIGHT_LAMP_BRIGHTNESS(int i) {
                super("nlbrightness", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS extends DeviceSettingEvent {
            public SET_NIGHT_LAMP_STEPLESS_BRIGHTNESS(int i) {
                super("nlstepless", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_WICK_DRY_DURATION;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_WICK_DRY_DURATION extends DeviceSettingEvent {
            public SET_WICK_DRY_DURATION(int i) {
                super("wickdrydur", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_YWRM_ENABLED;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_YWRM_ENABLED extends DeviceSettingEvent {
            public SET_YWRM_ENABLED(boolean z) {
                super("wickdrydur", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "index", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_ALARM extends DeviceSettingEvent {
            public SET_ALARM(int i) {
                super(NotificationCompat.CATEGORY_ALARM + i, "", (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$PLAY_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "sound", "", "volume", "<init>", "(II)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class PLAY_ALARM extends DeviceSettingEvent {
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public PLAY_ALARM(int r2, int r3) {
                /*
                    r1 = this;
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    r0.append(r2)
                    r2 = 95
                    r0.append(r2)
                    r0.append(r3)
                    java.lang.String r2 = r0.toString()
                    r3 = 0
                    java.lang.String r0 = "alarmpreview"
                    r1.<init>(r0, r2, r3)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.DeviceSettingEvent.PLAY_ALARM.<init>(int, int):void");
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$STOP_ALARM;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class STOP_ALARM extends DeviceSettingEvent {
            public static final STOP_ALARM INSTANCE = new STOP_ALARM();

            private STOP_ALARM() {
                super("alarmstop", 1, (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_HUM_SUBMODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_HUM_SUBMODE extends DeviceSettingEvent {
            public SET_HUM_SUBMODE(int i) {
                super("humsubmode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_USE_24_HOUR;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(Z)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_USE_24_HOUR extends DeviceSettingEvent {
            public SET_USE_24_HOUR(boolean z) {
                super("hourformat", Boolean.valueOf(z), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent$SET_SENSOR_MODE;", "Lcom/blueair/core/model/AnalyticEvent$DeviceSettingEvent;", "value", "", "<init>", "(I)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_SENSOR_MODE extends DeviceSettingEvent {
            public SET_SENSOR_MODE(int i) {
                super("sensormode", Integer.valueOf(i), (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB+\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0004\b\b\u0010\t\u0001\u0003\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "name", "", "settings", "", "Lkotlin/Pair;", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "SET_OSCILLATION_PARAMS", "SET_COOL_AUTO_PRESETS", "SET_COOL_ECO_PRESETS", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_AUTO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_ECO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_OSCILLATION_PARAMS;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class DeviceBatchSettingEvent extends AnalyticEvent {
        public /* synthetic */ DeviceBatchSettingEvent(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, list);
        }

        private DeviceBatchSettingEvent(String str, List<? extends Pair<String, ? extends Object>> list) {
            super("device_batch_setting", MapsKt.mapOf(TuplesKt.to(AnalyticEvent.KEY_SETTING, str), TuplesKt.to("value", CollectionsKt.joinToString$default(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null))), (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_OSCILLATION_PARAMS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "angle", "", "direction", "fanSpeed", "<init>", "(III)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_OSCILLATION_PARAMS extends DeviceBatchSettingEvent {
            public SET_OSCILLATION_PARAMS(int i, int i2, int i3) {
                super("osc_params", CollectionsKt.listOf(TuplesKt.to("osc", Integer.valueOf(i)), TuplesKt.to("oscdir", Integer.valueOf(i2)), TuplesKt.to("oscfs", Integer.valueOf(i3))), (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_AUTO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "tag", "", "presets", "", "<init>", "(I[D)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_COOL_AUTO_PRESETS extends DeviceBatchSettingEvent {
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x001b, code lost:
                if (r3 == null) goto L_0x001d;
             */
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public SET_COOL_AUTO_PRESETS(int r3, double[] r4) {
                /*
                    r2 = this;
                    r0 = 2
                    kotlin.Pair[] r0 = new kotlin.Pair[r0]
                    java.lang.String r1 = "coolautotag"
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    kotlin.Pair r3 = kotlin.TuplesKt.to(r1, r3)
                    r1 = 0
                    r0[r1] = r3
                    if (r4 == 0) goto L_0x001d
                    java.lang.String r3 = java.util.Arrays.toString(r4)
                    java.lang.String r4 = "toString(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                    if (r3 != 0) goto L_0x001f
                L_0x001d:
                    java.lang.String r3 = "null"
                L_0x001f:
                    java.lang.String r4 = "coolautofs"
                    kotlin.Pair r3 = kotlin.TuplesKt.to(r4, r3)
                    r4 = 1
                    r0[r4] = r3
                    java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r0)
                    r4 = 0
                    java.lang.String r0 = "cool_auto_presets"
                    r2.<init>(r0, r3, r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.DeviceBatchSettingEvent.SET_COOL_AUTO_PRESETS.<init>(int, double[]):void");
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent$SET_COOL_ECO_PRESETS;", "Lcom/blueair/core/model/AnalyticEvent$DeviceBatchSettingEvent;", "tag", "", "presets", "", "<init>", "(I[D)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class SET_COOL_ECO_PRESETS extends DeviceBatchSettingEvent {
            /* JADX WARNING: Code restructure failed: missing block: B:3:0x001b, code lost:
                if (r3 == null) goto L_0x001d;
             */
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public SET_COOL_ECO_PRESETS(int r3, double[] r4) {
                /*
                    r2 = this;
                    r0 = 2
                    kotlin.Pair[] r0 = new kotlin.Pair[r0]
                    java.lang.String r1 = "coolecotag"
                    java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                    kotlin.Pair r3 = kotlin.TuplesKt.to(r1, r3)
                    r1 = 0
                    r0[r1] = r3
                    if (r4 == 0) goto L_0x001d
                    java.lang.String r3 = java.util.Arrays.toString(r4)
                    java.lang.String r4 = "toString(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                    if (r3 != 0) goto L_0x001f
                L_0x001d:
                    java.lang.String r3 = "null"
                L_0x001f:
                    java.lang.String r4 = "coolecofs"
                    kotlin.Pair r3 = kotlin.TuplesKt.to(r4, r3)
                    r4 = 1
                    r0[r4] = r3
                    java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r0)
                    r4 = 0
                    java.lang.String r0 = "cool_eco_presets"
                    r2.<init>(r0, r3, r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.DeviceBatchSettingEvent.SET_COOL_ECO_PRESETS.<init>(int, double[]):void");
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$OPEN_FAN_HISTORY;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class OPEN_FAN_HISTORY extends AnalyticEvent {
        public OPEN_FAN_HISTORY() {
            super("opened_fan_history", MapsKt.emptyMap(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$SET_SCHEDULE;", "Lcom/blueair/core/model/AnalyticEvent;", "startTime", "", "endTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class SET_SCHEDULE extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SET_SCHEDULE(String str, String str2) {
            super("schedule_set", MapsKt.mapOf(TuplesKt.to(AnalyticEvent.KEY_TIME_START, str), TuplesKt.to("end_time", str2)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "startTime");
            Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_END_TIME);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$SAVE_OUTDOOR_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent;", "city", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class SAVE_OUTDOOR_LOCATION extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SAVE_OUTDOOR_LOCATION(String str) {
            super("saving_outdoor_location", MapsKt.mapOf(TuplesKt.to("city", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "city");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$ENABLE_GPS_LOCATION;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class ENABLE_GPS_LOCATION extends AnalyticEvent {
        public ENABLE_GPS_LOCATION() {
            super("enabled_gps_location", MapsKt.emptyMap(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$TAP_TROUBLESHOOTING;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class TAP_TROUBLESHOOTING extends AnalyticEvent {
        public TAP_TROUBLESHOOTING() {
            super("troubleshooting_tapped", MapsKt.emptyMap(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$TAP_CUSTOMER_SUPPORT;", "Lcom/blueair/core/model/AnalyticEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class TAP_CUSTOMER_SUPPORT extends AnalyticEvent {
        public TAP_CUSTOMER_SUPPORT() {
            super("customer_support_tapped", MapsKt.emptyMap(), (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$REFRESH_GIGYA_JWT;", "Lcom/blueair/core/model/AnalyticEvent;", "gsResponseText", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static final class REFRESH_GIGYA_JWT extends AnalyticEvent {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public REFRESH_GIGYA_JWT(String str) {
            super("refresh_gigya_jwt", MapsKt.mapOf(TuplesKt.to("gs_response", str)), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "gsResponseText");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "type", "", "<init>", "(Ljava/lang/String;)V", "Volatile", "Historical", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Historical;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Volatile;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class BreezoApiEvent extends AnalyticEvent {
        public /* synthetic */ BreezoApiEvent(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }

        private BreezoApiEvent(String str) {
            super("breezometer_api_call", MapsKt.mapOf(TuplesKt.to("type", str)), (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Volatile;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Volatile extends BreezoApiEvent {
            public Volatile() {
                super("location", (DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent$Historical;", "Lcom/blueair/core/model/AnalyticEvent$BreezoApiEvent;", "<init>", "()V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Historical extends BreezoApiEvent {
            public Historical() {
                super("historical", (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0007\b\t\nB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0001\u0004\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "eventName", "", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "StompConnectFail", "BlueAirSdkFail", "LogoutFail", "KlaviyoFail", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$BlueAirSdkFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$KlaviyoFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$LogoutFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent$StompConnectFail;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class BugEvent extends AnalyticEvent {
        public /* synthetic */ BugEvent(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        private BugEvent(String str, String str2) {
            super(str, MapsKt.mapOf(TuplesKt.to("error_description", str2)), (DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$StompConnectFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class StompConnectFail extends BugEvent {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public StompConnectFail(String str) {
                super("stomp_connection_failure", str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$BlueAirSdkFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class BlueAirSdkFail extends BugEvent {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BlueAirSdkFail(String str) {
                super("blueair_sdk_failure", str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$LogoutFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class LogoutFail extends BugEvent {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public LogoutFail(String str) {
                super("logout_failure", str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$BugEvent$KlaviyoFail;", "Lcom/blueair/core/model/AnalyticEvent$BugEvent;", "message", "", "<init>", "(Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class KlaviyoFail extends BugEvent {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public KlaviyoFail(String str) {
                super("klaviyo_failure", str, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "message");
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\f\rB;\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000b\u0001\u0002\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "eventName", "", "deeplink", "path", "type", "action", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Device;)V", "Receive", "Click", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Click;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Receive;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class KlaviyoEvent extends AnalyticEvent {
        public /* synthetic */ KlaviyoEvent(String str, String str2, String str3, String str4, String str5, Device device, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, str4, str5, device);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private KlaviyoEvent(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, com.blueair.core.model.Device r8) {
            /*
                r2 = this;
                java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
                r0.<init>()
                java.util.Map r0 = (java.util.Map) r0
                java.lang.String r1 = "deeplink"
                r0.put(r1, r4)
                java.lang.String r4 = "deeplink_path"
                r0.put(r4, r5)
                java.lang.String r4 = "deeplink_type"
                r0.put(r4, r6)
                java.lang.String r4 = "deeplink_action"
                r0.put(r4, r7)
                r4 = 0
                if (r8 == 0) goto L_0x00a2
                java.lang.String r5 = "device_model"
                java.lang.String r6 = r8.getModelName()
                r0.put(r5, r6)
                java.lang.String r5 = "device_uuid"
                java.lang.String r6 = r8.getUid()
                r0.put(r5, r6)
                boolean r5 = r8 instanceof com.blueair.core.model.HasSKU
                if (r5 == 0) goto L_0x0038
                r5 = r8
                com.blueair.core.model.HasSKU r5 = (com.blueair.core.model.HasSKU) r5
                goto L_0x0039
            L_0x0038:
                r5 = r4
            L_0x0039:
                if (r5 == 0) goto L_0x0051
                java.lang.String r6 = r5.getSku()
                if (r6 != 0) goto L_0x0043
                java.lang.String r6 = ""
            L_0x0043:
                java.lang.String r7 = "device_sku"
                r0.put(r7, r6)
                java.lang.String r6 = "device_serial"
                java.lang.String r5 = r5.getSerial()
                r0.put(r6, r5)
            L_0x0051:
                java.lang.String r5 = "device_mac"
                java.lang.String r6 = r8.getMac()
                r0.put(r5, r6)
                java.lang.String r5 = "device_mcu_firmware"
                java.lang.String r6 = r8.getMcuFirmware()
                r0.put(r5, r6)
                java.lang.String r5 = "device_wifi_firmware"
                java.lang.String r6 = r8.getWifiFirmware()
                r0.put(r5, r6)
                java.lang.String r5 = "device_timezone"
                java.lang.String r6 = r8.getTimeZone()
                r0.put(r5, r6)
                boolean r5 = r8 instanceof com.blueair.core.model.HasFanSpeed
                if (r5 == 0) goto L_0x007d
                r5 = r8
                com.blueair.core.model.HasFanSpeed r5 = (com.blueair.core.model.HasFanSpeed) r5
                goto L_0x007e
            L_0x007d:
                r5 = r4
            L_0x007e:
                if (r5 == 0) goto L_0x008b
                java.lang.Integer r5 = r5.getFilterLife()
                if (r5 == 0) goto L_0x008b
                int r5 = r5.intValue()
                goto L_0x008c
            L_0x008b:
                r5 = 0
            L_0x008c:
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.String r6 = "device_filter_life"
                r0.put(r6, r5)
                com.blueair.core.model.ConnectivityStatus r5 = r8.getConnectivityStatus()
                java.lang.String r5 = r5.name()
                java.lang.String r6 = "device_status"
                r0.put(r6, r5)
            L_0x00a2:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                r2.<init>(r3, r0, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.KlaviyoEvent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.blueair.core.model.Device):void");
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Receive;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "deeplink", "", "path", "type", "action", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Device;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Receive extends KlaviyoEvent {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Receive(String str, String str2, String str3, String str4, Device device) {
                super("notification_received", str, str2, str3, str4, device, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK);
                Intrinsics.checkNotNullParameter(str2, "path");
                Intrinsics.checkNotNullParameter(str3, "type");
                Intrinsics.checkNotNullParameter(str4, "action");
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent$Click;", "Lcom/blueair/core/model/AnalyticEvent$KlaviyoEvent;", "deeplink", "", "path", "type", "action", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/blueair/core/model/Device;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class Click extends KlaviyoEvent {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Click(String str, String str2, String str3, String str4, Device device) {
                super("notification_click", str, str2, str3, str4, device, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, SDKConstants.PARAM_TOURNAMENTS_DEEPLINK);
                Intrinsics.checkNotNullParameter(str2, "path");
                Intrinsics.checkNotNullParameter(str3, "type");
                Intrinsics.checkNotNullParameter(str4, "action");
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013BA\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u0001\u0005\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "Lcom/blueair/core/model/AnalyticEvent;", "eventName", "", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(Ljava/lang/String;JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "FilterCLickPurchase", "FilterCLickSubscribe", "OnboardingFilterCLickSubscribe", "HomepageFilterClickPurchase", "HomepageFilterClickSubscribe", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$OnboardingFilterCLickSubscribe;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AnalyticEvent.kt */
    public static abstract class FilterClickEvent extends AnalyticEvent {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.REFRESHER     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ FilterClickEvent(String str, long j, DeviceFilterType deviceFilterType, String str2, Device device, String str3, String str4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, j, deviceFilterType, str2, device, str3, str4);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private FilterClickEvent(java.lang.String r14, long r15, com.blueair.core.model.DeviceFilterType r17, java.lang.String r18, com.blueair.core.model.Device r19, java.lang.String r20, java.lang.String r21) {
            /*
                r13 = this;
                r0 = r18
                r1 = r19
                java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
                r2.<init>()
                java.util.Map r2 = (java.util.Map) r2
                java.lang.String r3 = "click_time"
                java.lang.Long r4 = java.lang.Long.valueOf(r15)
                r2.put(r3, r4)
                java.lang.String r3 = "device_model"
                java.lang.String r4 = r1.getModelName()
                r2.put(r3, r4)
                java.lang.String r3 = "device_uuid"
                java.lang.String r4 = r1.getUid()
                r2.put(r3, r4)
                java.lang.String r3 = com.blueair.core.model.DeviceKt.getSkuCompat(r1)
                if (r3 != 0) goto L_0x002e
                java.lang.String r3 = ""
            L_0x002e:
                java.lang.String r4 = "device_sku"
                r2.put(r4, r3)
                java.lang.String r3 = "device_mcu_firmware"
                java.lang.String r4 = r1.getMcuFirmware()
                r2.put(r3, r4)
                r3 = 0
                r4 = 1
                java.util.TimeZone r5 = com.blueair.core.model.Device.CC.getTimezone$default(r1, r3, r4, r3)
                int r5 = r5.getRawOffset()
                if (r5 < 0) goto L_0x004b
                r6 = 43
                goto L_0x004d
            L_0x004b:
                r6 = 45
            L_0x004d:
                int r5 = java.lang.Math.abs(r5)
                long r7 = (long) r5
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
                long r9 = r5.toHours(r7)
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
                r11 = 3600000(0x36ee80, float:5.044674E-39)
                long r11 = (long) r11
                long r11 = r11 * r9
                long r7 = r7 - r11
                long r7 = r5.toMinutes(r7)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                r5.append(r6)
                r5.append(r9)
                java.lang.String r6 = ":%02d"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                java.lang.Long r6 = java.lang.Long.valueOf(r7)
                java.lang.Object[] r7 = new java.lang.Object[r4]
                r8 = 0
                r7[r8] = r6
                java.lang.Object[] r6 = java.util.Arrays.copyOf(r7, r4)
                java.lang.String r5 = java.lang.String.format(r5, r6)
                java.lang.String r6 = "format(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                java.lang.String r6 = "device_timezone"
                r2.put(r6, r5)
                int[] r5 = com.blueair.core.model.AnalyticEvent.FilterClickEvent.WhenMappings.$EnumSwitchMapping$0
                int r6 = r17.ordinal()
                r5 = r5[r6]
                r6 = 3
                r7 = 2
                if (r5 == r4) goto L_0x00af
                if (r5 == r7) goto L_0x00ac
                if (r5 != r6) goto L_0x00a6
                java.lang.String r5 = "refresher"
                goto L_0x00b1
            L_0x00a6:
                kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
                r14.<init>()
                throw r14
            L_0x00ac:
                java.lang.String r5 = "wick"
                goto L_0x00b1
            L_0x00af:
                java.lang.String r5 = "filter"
            L_0x00b1:
                java.lang.String r9 = "device_filter_type"
                r2.put(r9, r5)
                int[] r5 = com.blueair.core.model.AnalyticEvent.FilterClickEvent.WhenMappings.$EnumSwitchMapping$0
                int r9 = r17.ordinal()
                r5 = r5[r9]
                if (r5 == r4) goto L_0x00ea
                if (r5 == r7) goto L_0x00d6
                if (r5 != r6) goto L_0x00d0
                java.lang.String r4 = "null cannot be cast to non-null type com.blueair.core.model.HasRemoveYellowWater"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
                com.blueair.core.model.HasRemoveYellowWater r1 = (com.blueair.core.model.HasRemoveYellowWater) r1
                int r1 = r1.getRefresherLifeLeft()
                goto L_0x00f2
            L_0x00d0:
                kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
                r14.<init>()
                throw r14
            L_0x00d6:
                java.lang.String r4 = "null cannot be cast to non-null type com.blueair.core.model.HasWick"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
                com.blueair.core.model.HasWick r1 = (com.blueair.core.model.HasWick) r1
                int r1 = r1.getWickUsage()
                r4 = 100
                int r1 = 100 - r1
                int r1 = kotlin.ranges.RangesKt.coerceIn((int) r1, (int) r8, (int) r4)
                goto L_0x00f2
            L_0x00ea:
                com.blueair.core.model.FilterLifeTime r1 = com.blueair.core.model.DeviceKt.getFilterLifeTime(r1)
                int r1 = r1.getFilterLife()
            L_0x00f2:
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.String r4 = "device_filter_left_life"
                r2.put(r4, r1)
                r1 = r0
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0109
                java.lang.String r1 = "filter_name"
                r2.put(r1, r0)
            L_0x0109:
                java.lang.String r0 = "user_id"
                r1 = r20
                r2.put(r0, r1)
                java.lang.String r0 = "user_region"
                r1 = r21
                r2.put(r0, r1)
                java.lang.String r0 = "phone_os"
                java.lang.String r1 = "android"
                r2.put(r0, r1)
                java.lang.String r0 = android.os.Build.MODEL
                java.lang.String r1 = "MODEL"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.lang.String r1 = "phone_device"
                r2.put(r1, r0)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                r13.<init>(r14, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.<init>(java.lang.String, long, com.blueair.core.model.DeviceFilterType, java.lang.String, com.blueair.core.model.Device, java.lang.String, java.lang.String):void");
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class FilterCLickPurchase extends FilterClickEvent {
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public FilterCLickPurchase(long r12, com.blueair.core.model.DeviceFilterType r14, java.lang.String r15, com.blueair.core.model.Device r16, java.lang.String r17, java.lang.String r18) {
                /*
                    r11 = this;
                    java.lang.String r0 = "filterType"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                    java.lang.String r0 = "filterName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                    java.lang.String r0 = "device"
                    r7 = r16
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "userId"
                    r8 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    java.lang.String r0 = "userRegion"
                    r9 = r18
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r2 = "purchase_filter_click"
                    r10 = 0
                    r1 = r11
                    r3 = r12
                    r5 = r14
                    r6 = r15
                    r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.FilterCLickPurchase.<init>(long, com.blueair.core.model.DeviceFilterType, java.lang.String, com.blueair.core.model.Device, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$FilterCLickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class FilterCLickSubscribe extends FilterClickEvent {
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public FilterCLickSubscribe(long r12, com.blueair.core.model.DeviceFilterType r14, java.lang.String r15, com.blueair.core.model.Device r16, java.lang.String r17, java.lang.String r18) {
                /*
                    r11 = this;
                    java.lang.String r0 = "filterType"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                    java.lang.String r0 = "filterName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                    java.lang.String r0 = "device"
                    r7 = r16
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "userId"
                    r8 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    java.lang.String r0 = "userRegion"
                    r9 = r18
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r2 = "subscribe_filter_click"
                    r10 = 0
                    r1 = r11
                    r3 = r12
                    r5 = r14
                    r6 = r15
                    r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.FilterCLickSubscribe.<init>(long, com.blueair.core.model.DeviceFilterType, java.lang.String, com.blueair.core.model.Device, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$OnboardingFilterCLickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class OnboardingFilterCLickSubscribe extends FilterClickEvent {
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public OnboardingFilterCLickSubscribe(long r12, com.blueair.core.model.DeviceFilterType r14, java.lang.String r15, com.blueair.core.model.Device r16, java.lang.String r17, java.lang.String r18) {
                /*
                    r11 = this;
                    java.lang.String r0 = "filterType"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                    java.lang.String r0 = "filterName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                    java.lang.String r0 = "device"
                    r7 = r16
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "userId"
                    r8 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    java.lang.String r0 = "userRegion"
                    r9 = r18
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r2 = "subscribe_filter_onboarding_click"
                    r10 = 0
                    r1 = r11
                    r3 = r12
                    r5 = r14
                    r6 = r15
                    r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.OnboardingFilterCLickSubscribe.<init>(long, com.blueair.core.model.DeviceFilterType, java.lang.String, com.blueair.core.model.Device, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickPurchase;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class HomepageFilterClickPurchase extends FilterClickEvent {
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public HomepageFilterClickPurchase(long r12, com.blueair.core.model.DeviceFilterType r14, java.lang.String r15, com.blueair.core.model.Device r16, java.lang.String r17, java.lang.String r18) {
                /*
                    r11 = this;
                    java.lang.String r0 = "filterType"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                    java.lang.String r0 = "filterName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                    java.lang.String r0 = "device"
                    r7 = r16
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "userId"
                    r8 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    java.lang.String r0 = "userRegion"
                    r9 = r18
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r2 = "purchase_filter_homepage_click"
                    r10 = 0
                    r1 = r11
                    r3 = r12
                    r5 = r14
                    r6 = r15
                    r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.HomepageFilterClickPurchase.<init>(long, com.blueair.core.model.DeviceFilterType, java.lang.String, com.blueair.core.model.Device, java.lang.String, java.lang.String):void");
            }
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent$HomepageFilterClickSubscribe;", "Lcom/blueair/core/model/AnalyticEvent$FilterClickEvent;", "clickTime", "", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "", "device", "Lcom/blueair/core/model/Device;", "userId", "userRegion", "<init>", "(JLcom/blueair/core/model/DeviceFilterType;Ljava/lang/String;Lcom/blueair/core/model/Device;Ljava/lang/String;Ljava/lang/String;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: AnalyticEvent.kt */
        public static final class HomepageFilterClickSubscribe extends FilterClickEvent {
            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public HomepageFilterClickSubscribe(long r12, com.blueair.core.model.DeviceFilterType r14, java.lang.String r15, com.blueair.core.model.Device r16, java.lang.String r17, java.lang.String r18) {
                /*
                    r11 = this;
                    java.lang.String r0 = "filterType"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
                    java.lang.String r0 = "filterName"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                    java.lang.String r0 = "device"
                    r7 = r16
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    java.lang.String r0 = "userId"
                    r8 = r17
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                    java.lang.String r0 = "userRegion"
                    r9 = r18
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                    java.lang.String r2 = "subscribe_filter_homepage_click"
                    r10 = 0
                    r1 = r11
                    r3 = r12
                    r5 = r14
                    r6 = r15
                    r1.<init>(r2, r3, r5, r6, r7, r8, r9, r10)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.AnalyticEvent.FilterClickEvent.HomepageFilterClickSubscribe.<init>(long, com.blueair.core.model.DeviceFilterType, java.lang.String, com.blueair.core.model.Device, java.lang.String, java.lang.String):void");
            }
        }
    }
}
