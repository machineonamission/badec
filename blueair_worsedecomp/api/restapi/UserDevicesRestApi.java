package com.blueair.api.restapi;

import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.SkuConfigurationData;
import com.blueair.core.model.UserForm;
import com.blueair.core.model.UserInfoCollections;
import com.blueair.core.util.TimezoneNames;
import com.gigya.android.sdk.GigyaDefinitions;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 W2\u00020\u0001:\u0001WJ\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\fH'J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001aH'J\u001a\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001a0\u0003H'J$\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001a0\u00032\b\b\u0001\u0010\u0017\u001a\u00020\fH'J\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u001fH'J\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\"H'J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010%\u001a\u00020\f2\b\b\u0003\u0010&\u001a\u00020\fH'J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010%\u001a\u00020\fH'J\u0014\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000b0\u0003H'J\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010,\u001a\u00020*H'J\"\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00032\b\b\u0001\u0010\n\u001a\u00020\f2\b\b\u0001\u0010/\u001a\u00020\fH'J\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u00101\u001a\u000202H'J\u0018\u00103\u001a\b\u0012\u0004\u0012\u0002040\u00032\b\b\u0001\u00105\u001a\u00020\fH'J\"\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00032\b\b\u0001\u00105\u001a\u00020$2\b\b\u0001\u00108\u001a\u00020$H'J\"\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00032\b\b\u0001\u00105\u001a\u00020$2\b\b\u0001\u00108\u001a\u00020$H'J\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010<\u001a\u00020:H'J\u0018\u0010=\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0007\u001a\u00020>H'J(\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u000b0\u00032\b\b\u0001\u0010A\u001a\u00020\f2\b\b\u0001\u0010&\u001a\u00020\fH'J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00032\b\b\u0001\u0010D\u001a\u00020\fH'J\u0018\u0010E\u001a\b\u0012\u0004\u0012\u00020F0\u00032\b\b\u0001\u0010\u0007\u001a\u00020GH'J\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0007\u001a\u00020IH'J\u0018\u0010J\u001a\b\u0012\u0004\u0012\u00020F0\u00032\b\b\u0001\u0010\u0007\u001a\u00020KH'J\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010M\u001a\u00020NH'J\u0018\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0007\u001a\u00020PH'J\u0018\u0010Q\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010R\u001a\u00020SH'J\u0018\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u00032\b\b\u0001\u0010\u0007\u001a\u00020VH'¨\u0006XÀ\u0006\u0003"}, d2 = {"Lcom/blueair/api/restapi/UserDevicesRestApi;", "", "getDeviceList", "Lkotlinx/coroutines/Deferred;", "Lcom/blueair/api/restapi/DeviceBlueWrapper;", "getDeviceStatus", "Lcom/blueair/api/restapi/GetDeviceStatusRsp;", "req", "Lcom/blueair/api/restapi/GetDeviceStatusReq;", "removeDevice", "deviceId", "", "", "registerMqttEvents", "userId", "include", "Lcom/blueair/api/restapi/MqttIncludeWrapper;", "initialSetupCall", "Lcom/blueair/api/restapi/InitialResponse;", "body", "Lcom/blueair/api/restapi/InitialBody;", "getAlexaUrls", "Lcom/blueair/api/restapi/AlexaUrls;", "stage", "state", "alexaLinkAccount", "", "getAlexaLinkStatus", "unlinkAlexa", "getAlexaRedirectUrl", "Lcom/blueair/api/restapi/UrlResponse;", "Lcom/blueair/api/restapi/AlexaLinkAppReq;", "getGoogleAuthCode", "Lcom/blueair/api/restapi/GetGoogleAuthCodeRsp;", "Lcom/blueair/api/restapi/GetGoogleAuthCodeReq;", "getGoogleLinkStatus", "", "clientId", "type", "unlinkGoogle", "Lokhttp3/ResponseBody;", "getNotificationSettings", "Lcom/blueair/core/model/NotificationSetting;", "updateNotificationSetting", "model", "getTimezone", "Lcom/blueair/api/restapi/TimezoneConfiguration;", "defaultTimezone", "setTimezone", "setTimezoneReq", "Lcom/blueair/api/restapi/SetTimezoneReq;", "getTimezoneList", "Lcom/blueair/core/util/TimezoneNames;", "version", "getSkuConfigurations", "Lcom/blueair/core/model/SkuConfigurationData;", "series", "getUserInfoCollections", "Lcom/blueair/core/model/UserInfoCollections;", "uploadUserInfoCollections", "collections", "setupDeviceLocation", "Lcom/blueair/api/restapi/SetupDeviceLocationReq;", "getLocationInfo", "Lcom/blueair/api/restapi/DeviceLocationInfo;", "id", "antiFakeVerify", "Lcom/blueair/api/restapi/AntiFakeVerifyResult;", "code", "antiFakeReset", "Lcom/blueair/api/restapi/AntiFakeResetResp;", "Lcom/blueair/api/restapi/AntiFakeResetReq;", "antiFakeLog", "Lcom/blueair/api/restapi/AntiFakeLogReq;", "resetFilterLife", "Lcom/blueair/api/restapi/FilterResetReq;", "analyticsLogFilterClickEvent", "event", "Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent;", "shopifyMultiPassLink", "Lcom/blueair/api/restapi/ShopifyMultiPassReq;", "postUserForm", "userForm", "Lcom/blueair/core/model/UserForm;", "presignUploadLog", "Lcom/blueair/api/restapi/UploadLogRsp;", "Lcom/blueair/api/restapi/UploadLogReq;", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public interface UserDevicesRestApi {
    public static final String ALEXA_LINK_ACCOUNT = "c/alexa/lwa/enableskill";
    public static final String ALEXA_LINK_APP = "c/alexa-link-app";
    public static final String ALEXA_LINK_STATUS = "c/alexa/lwa/getskillstatus";
    public static final String ALEXA_UNLINK = "c/alexa/lwa/disableskill";
    public static final String ALEXA_URLS = "c/alexa/appurl";
    public static final String ANALYTICS_FILTER_CLICK = "c/firebase-purchase-event";
    public static final String ANTI_FAKE_LOG = "c/consumable/log";
    public static final String ANTI_FAKE_RESET = "c/consumable/reset";
    public static final String ANTI_FAKE_VERIFY = "c/consumable/verification";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String DEVICE_LOCATION = "c/device/location";
    public static final String FILTER_RESET = "c/consumable/direct-reset";
    public static final String GET_DEVICE_LIST = "c/registered-devices";
    public static final String GET_DEVICE_STATUS = "c/device-status";
    public static final String GOOGLE_AUTH_CODE = "c/cloud-oauth2/authentication/idtoken";
    public static final String GOOGLE_LINK_STATUS = "c/querylinkstatus";
    public static final String GOOGLE_UNLINK = "c/googleaccountunlink";
    public static final String INITIAL = "c/{userId}/r/initial";
    public static final String NOTIFICATION_SETTING = "c/push-notification-setting";
    public static final String PRESIGN_SIGN_UPLOAD = "c/uploads/presign";
    public static final String REGISTER_DEVICES_FOR_MQTT = "c/{userId}/events/subscription";
    public static final String REMOVE_DEVICE = "c/deregister-devices";
    public static final String SHOPIFY_MULTIPASS = "c/shopify-multipass";
    public static final String SKU_CONFIGURATIONS = "c/configs/sku-configurations";
    public static final String TIMEZONE_GET = "c/timezone/getorcreate";
    public static final String TIMEZONE_LIST = "c/timezone/namelist";
    public static final String TIMEZONE_SET = "c/timezone/updateorcreate";
    public static final String USER_FORM = "c/user-form";
    public static final String USER_ID = "userId";
    public static final String USER_INFO_COLLECTIONS = "c/userinfo";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserDevicesBlueRestApi.kt */
    public static final class DefaultImpls {
    }

    @POST("c/alexa/lwa/enableskill")
    Deferred<Object> alexaLinkAccount(@Body Map<String, String> map);

    @POST("c/firebase-purchase-event")
    Deferred<ResponseBody> analyticsLogFilterClickEvent(@Body AnalyticsFilterCLickEvent analyticsFilterCLickEvent);

    @POST("c/consumable/log")
    Deferred<ResponseBody> antiFakeLog(@Body AntiFakeLogReq antiFakeLogReq);

    @POST("c/consumable/reset")
    Deferred<AntiFakeResetResp> antiFakeReset(@Body AntiFakeResetReq antiFakeResetReq);

    @GET("c/consumable/verification")
    Deferred<AntiFakeVerifyResult> antiFakeVerify(@Query("antifakecode") String str);

    @GET("c/alexa/lwa/getskillstatus")
    Deferred<Map<String, String>> getAlexaLinkStatus();

    @POST("c/alexa-link-app")
    Deferred<UrlResponse> getAlexaRedirectUrl(@Body AlexaLinkAppReq alexaLinkAppReq);

    @GET("c/alexa/appurl")
    Deferred<AlexaUrls> getAlexaUrls(@Query("skillStage") String str, @Query("state") String str2);

    @GET("c/registered-devices")
    Deferred<DeviceBlueWrapper> getDeviceList();

    @POST("c/device-status")
    Deferred<GetDeviceStatusRsp> getDeviceStatus(@Body GetDeviceStatusReq getDeviceStatusReq);

    @POST("c/cloud-oauth2/authentication/idtoken")
    Deferred<GetGoogleAuthCodeRsp> getGoogleAuthCode(@Body GetGoogleAuthCodeReq getGoogleAuthCodeReq);

    @GET("c/querylinkstatus")
    Deferred<Integer> getGoogleLinkStatus(@Query("clientid") String str, @Query("type") String str2);

    @GET("c/device/location")
    Deferred<List<DeviceLocationInfo>> getLocationInfo(@Query("id") String str, @Query("type") String str2);

    @GET("c/push-notification-setting")
    Deferred<List<NotificationSetting>> getNotificationSettings();

    @GET("c/configs/sku-configurations")
    Deferred<SkuConfigurationData> getSkuConfigurations(@Query("version") int i, @Query("series") int i2);

    @GET("c/timezone/getorcreate")
    Deferred<TimezoneConfiguration> getTimezone(@Query("deviceid") String str, @Query("timezone") String str2);

    @GET("c/timezone/namelist")
    Deferred<TimezoneNames> getTimezoneList(@Query("version") String str);

    @GET("c/userinfo")
    Deferred<UserInfoCollections> getUserInfoCollections(@Query("version") int i, @Query("series") int i2);

    @POST("c/{userId}/r/initial")
    Deferred<InitialResponse> initialSetupCall(@Path("userId") String str, @Body InitialBody initialBody);

    @POST("c/user-form")
    Deferred<ResponseBody> postUserForm(@Body UserForm userForm);

    @POST("c/uploads/presign")
    Deferred<UploadLogRsp> presignUploadLog(@Body UploadLogReq uploadLogReq);

    @POST("c/{userId}/events/subscription")
    Deferred<Object> registerMqttEvents(@Path("userId") String str, @Body MqttIncludeWrapper mqttIncludeWrapper);

    @POST("c/deregister-devices")
    Deferred<Object> removeDevice(@Body List<String> list);

    @POST("c/consumable/direct-reset")
    Deferred<AntiFakeResetResp> resetFilterLife(@Body FilterResetReq filterResetReq);

    @POST("c/timezone/updateorcreate")
    Deferred<ResponseBody> setTimezone(@Body SetTimezoneReq setTimezoneReq);

    @POST("c/device/location")
    Deferred<ResponseBody> setupDeviceLocation(@Body SetupDeviceLocationReq setupDeviceLocationReq);

    @POST("c/shopify-multipass")
    Deferred<UrlResponse> shopifyMultiPassLink(@Body ShopifyMultiPassReq shopifyMultiPassReq);

    @DELETE("c/alexa/lwa/disableskill")
    Deferred<Map<String, String>> unlinkAlexa(@Query("stage_value") String str);

    @DELETE("c/googleaccountunlink")
    Deferred<ResponseBody> unlinkGoogle(@Query("clientid") String str);

    @POST("c/push-notification-setting")
    Deferred<ResponseBody> updateNotificationSetting(@Body NotificationSetting notificationSetting);

    @POST("c/userinfo")
    Deferred<ResponseBody> uploadUserInfoCollections(@Body UserInfoCollections userInfoCollections);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001d\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/api/restapi/UserDevicesRestApi$Companion;", "", "<init>", "()V", "GET_DEVICE_LIST", "", "REMOVE_DEVICE", "REGISTER_DEVICES_FOR_MQTT", "INITIAL", "GET_DEVICE_STATUS", "TIMEZONE_GET", "TIMEZONE_SET", "TIMEZONE_LIST", "DEVICE_LOCATION", "ALEXA_URLS", "ALEXA_LINK_ACCOUNT", "ALEXA_LINK_STATUS", "ALEXA_UNLINK", "ALEXA_LINK_APP", "GOOGLE_AUTH_CODE", "GOOGLE_LINK_STATUS", "GOOGLE_UNLINK", "NOTIFICATION_SETTING", "ANTI_FAKE_VERIFY", "ANTI_FAKE_RESET", "ANTI_FAKE_LOG", "FILTER_RESET", "ANALYTICS_FILTER_CLICK", "SKU_CONFIGURATIONS", "USER_INFO_COLLECTIONS", "USER_FORM", "PRESIGN_SIGN_UPLOAD", "SHOPIFY_MULTIPASS", "USER_ID", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserDevicesBlueRestApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ALEXA_LINK_ACCOUNT = "c/alexa/lwa/enableskill";
        public static final String ALEXA_LINK_APP = "c/alexa-link-app";
        public static final String ALEXA_LINK_STATUS = "c/alexa/lwa/getskillstatus";
        public static final String ALEXA_UNLINK = "c/alexa/lwa/disableskill";
        public static final String ALEXA_URLS = "c/alexa/appurl";
        public static final String ANALYTICS_FILTER_CLICK = "c/firebase-purchase-event";
        public static final String ANTI_FAKE_LOG = "c/consumable/log";
        public static final String ANTI_FAKE_RESET = "c/consumable/reset";
        public static final String ANTI_FAKE_VERIFY = "c/consumable/verification";
        public static final String DEVICE_LOCATION = "c/device/location";
        public static final String FILTER_RESET = "c/consumable/direct-reset";
        public static final String GET_DEVICE_LIST = "c/registered-devices";
        public static final String GET_DEVICE_STATUS = "c/device-status";
        public static final String GOOGLE_AUTH_CODE = "c/cloud-oauth2/authentication/idtoken";
        public static final String GOOGLE_LINK_STATUS = "c/querylinkstatus";
        public static final String GOOGLE_UNLINK = "c/googleaccountunlink";
        public static final String INITIAL = "c/{userId}/r/initial";
        public static final String NOTIFICATION_SETTING = "c/push-notification-setting";
        public static final String PRESIGN_SIGN_UPLOAD = "c/uploads/presign";
        public static final String REGISTER_DEVICES_FOR_MQTT = "c/{userId}/events/subscription";
        public static final String REMOVE_DEVICE = "c/deregister-devices";
        public static final String SHOPIFY_MULTIPASS = "c/shopify-multipass";
        public static final String SKU_CONFIGURATIONS = "c/configs/sku-configurations";
        public static final String TIMEZONE_GET = "c/timezone/getorcreate";
        public static final String TIMEZONE_LIST = "c/timezone/namelist";
        public static final String TIMEZONE_SET = "c/timezone/updateorcreate";
        public static final String USER_FORM = "c/user-form";
        public static final String USER_ID = "userId";
        public static final String USER_INFO_COLLECTIONS = "c/userinfo";

        private Companion() {
        }
    }

    /* renamed from: com.blueair.api.restapi.UserDevicesRestApi$-CC  reason: invalid class name */
    /* compiled from: UserDevicesBlueRestApi.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = UserDevicesRestApi.Companion;
        }

        public static /* synthetic */ Deferred getGoogleLinkStatus$default(UserDevicesRestApi userDevicesRestApi, String str, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = GigyaDefinitions.Providers.GOOGLE;
                }
                return userDevicesRestApi.getGoogleLinkStatus(str, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGoogleLinkStatus");
        }
    }
}
