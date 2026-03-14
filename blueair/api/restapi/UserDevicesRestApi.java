package com.blueair.api.restapi;

import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.UserForm;
import com.blueair.core.model.UserInfoCollections;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(
   d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \\2\u00020\u0001:\u0001\\J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u000e\u001a\u00020\f2\b\b\u0001\u0010\u0013\u001a\u00020\u0014H'J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0017\u001a\u00020\f2\b\b\u0001\u0010\u0018\u001a\u00020\fH'J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001aH'J\u001a\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001a0\u0003H'J$\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u001a0\u00032\b\b\u0001\u0010\u0017\u001a\u00020\fH'J\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u001fH'J\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\"H'J\"\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u00032\b\b\u0001\u0010%\u001a\u00020\f2\b\b\u0003\u0010&\u001a\u00020\fH'J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010%\u001a\u00020\fH'J\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0007\u001a\u00020*H'J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010,\u001a\u00020\f2\b\b\u0001\u0010-\u001a\u00020\fH'J\u0014\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u000b0\u0003H'J\u0018\u00100\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u00101\u001a\u00020/H'J\"\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00032\b\b\u0001\u0010\n\u001a\u00020\f2\b\b\u0001\u00104\u001a\u00020\fH'J\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u00106\u001a\u000207H'J\u0018\u00108\u001a\b\u0012\u0004\u0012\u0002090\u00032\b\b\u0001\u0010:\u001a\u00020\fH'J\"\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u00032\b\b\u0001\u0010:\u001a\u00020$2\b\b\u0001\u0010=\u001a\u00020$H'J\"\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00032\b\b\u0001\u0010:\u001a\u00020$2\b\b\u0001\u0010=\u001a\u00020$H'J\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010A\u001a\u00020?H'J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0007\u001a\u00020CH'J(\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0\u000b0\u00032\b\b\u0001\u0010F\u001a\u00020\f2\b\b\u0001\u0010&\u001a\u00020\fH'J\u0018\u0010G\u001a\b\u0012\u0004\u0012\u00020H0\u00032\b\b\u0001\u0010I\u001a\u00020\fH'J\u0018\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u00032\b\b\u0001\u0010\u0007\u001a\u00020LH'J\u0018\u0010M\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010\u0007\u001a\u00020NH'J\u0018\u0010O\u001a\b\u0012\u0004\u0012\u00020K0\u00032\b\b\u0001\u0010\u0007\u001a\u00020PH'J\u0018\u0010Q\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010R\u001a\u00020SH'J\u0018\u0010T\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0007\u001a\u00020UH'J\u0018\u0010V\u001a\b\u0012\u0004\u0012\u00020(0\u00032\b\b\u0001\u0010W\u001a\u00020XH'J\u0018\u0010Y\u001a\b\u0012\u0004\u0012\u00020Z0\u00032\b\b\u0001\u0010\u0007\u001a\u00020[H'¨\u0006]À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/restapi/UserDevicesRestApi;", "", "getDeviceList", "Lkotlinx/coroutines/Deferred;", "Lcom/blueair/api/restapi/DeviceBlueWrapper;", "getDeviceStatus", "Lcom/blueair/api/restapi/GetDeviceStatusRsp;", "req", "Lcom/blueair/api/restapi/GetDeviceStatusReq;", "removeDevice", "deviceId", "", "", "registerMqttEvents", "userId", "include", "Lcom/blueair/api/restapi/MqttIncludeWrapper;", "initialSetupCall", "Lcom/blueair/api/restapi/InitialResponse;", "body", "Lcom/blueair/api/restapi/InitialBody;", "getAlexaUrls", "Lcom/blueair/api/restapi/AlexaUrls;", "stage", "state", "alexaLinkAccount", "", "getAlexaLinkStatus", "unlinkAlexa", "getAlexaRedirectUrl", "Lcom/blueair/api/restapi/UrlResponse;", "Lcom/blueair/api/restapi/AlexaLinkAppReq;", "getGoogleAuthCode", "Lcom/blueair/api/restapi/GetGoogleAuthCodeRsp;", "Lcom/blueair/api/restapi/GetGoogleAuthCodeReq;", "getGoogleLinkStatus", "", "clientId", "type", "unlinkGoogle", "Lokhttp3/ResponseBody;", "jpushLink", "Lcom/blueair/api/restapi/JPushLinkReq;", "jpushUnlink", "bearerToken", "jgid", "getNotificationSettings", "Lcom/blueair/core/model/NotificationSetting;", "updateNotificationSetting", "model", "getTimezone", "Lcom/blueair/api/restapi/TimezoneConfiguration;", "defaultTimezone", "setTimezone", "setTimezoneReq", "Lcom/blueair/api/restapi/SetTimezoneReq;", "getTimezoneList", "Lcom/blueair/core/util/TimezoneNames;", "version", "getSkuConfigurations", "Lcom/blueair/core/model/SkuConfigurationData;", "series", "getUserInfoCollections", "Lcom/blueair/core/model/UserInfoCollections;", "uploadUserInfoCollections", "collections", "setupDeviceLocation", "Lcom/blueair/api/restapi/SetupDeviceLocationReq;", "getLocationInfo", "Lcom/blueair/api/restapi/DeviceLocationInfo;", "id", "antiFakeVerify", "Lcom/blueair/api/restapi/AntiFakeVerifyResult;", "code", "antiFakeReset", "Lcom/blueair/api/restapi/AntiFakeResetResp;", "Lcom/blueair/api/restapi/AntiFakeResetReq;", "antiFakeLog", "Lcom/blueair/api/restapi/AntiFakeLogReq;", "resetFilterLife", "Lcom/blueair/api/restapi/FilterResetReq;", "analyticsLogFilterClickEvent", "event", "Lcom/blueair/api/restapi/AnalyticsFilterCLickEvent;", "shopifyMultiPassLink", "Lcom/blueair/api/restapi/ShopifyMultiPassReq;", "postUserForm", "userForm", "Lcom/blueair/core/model/UserForm;", "presignUploadLog", "Lcom/blueair/api/restapi/UploadLogRsp;", "Lcom/blueair/api/restapi/UploadLogReq;", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface UserDevicesRestApi {
   String ALEXA_LINK_ACCOUNT = "c/alexa/lwa/enableskill";
   String ALEXA_LINK_APP = "c/alexa-link-app";
   String ALEXA_LINK_STATUS = "c/alexa/lwa/getskillstatus";
   String ALEXA_UNLINK = "c/alexa/lwa/disableskill";
   String ALEXA_URLS = "c/alexa/appurl";
   String ANALYTICS_FILTER_CLICK = "c/firebase-purchase-event";
   String ANTI_FAKE_LOG = "c/consumable/log";
   String ANTI_FAKE_RESET = "c/consumable/reset";
   String ANTI_FAKE_VERIFY = "c/consumable/verification";
   Companion Companion = UserDevicesRestApi.Companion.$$INSTANCE;
   String DEVICE_LOCATION = "c/device/location";
   String FILTER_RESET = "c/consumable/direct-reset";
   String GET_DEVICE_LIST = "c/registered-devices";
   String GET_DEVICE_STATUS = "c/device-status";
   String GOOGLE_AUTH_CODE = "c/cloud-oauth2/authentication/idtoken";
   String GOOGLE_LINK_STATUS = "c/querylinkstatus";
   String GOOGLE_UNLINK = "c/googleaccountunlink";
   String INITIAL = "c/{userId}/r/initial";
   String JPUSH_LINK = "c/save-jiguang";
   String JPUSH_UNLINK = "c/delete-jiguang/{jgid}";
   String NOTIFICATION_SETTING = "c/push-notification-setting";
   String PRESIGN_SIGN_UPLOAD = "c/uploads/presign";
   String REGISTER_DEVICES_FOR_MQTT = "c/{userId}/events/subscription";
   String REMOVE_DEVICE = "c/deregister-devices";
   String SHOPIFY_MULTIPASS = "c/shopify-multipass";
   String SKU_CONFIGURATIONS = "c/configs/sku-configurations";
   String TIMEZONE_GET = "c/timezone/getorcreate";
   String TIMEZONE_LIST = "c/timezone/namelist";
   String TIMEZONE_SET = "c/timezone/updateorcreate";
   String USER_FORM = "c/user-form";
   String USER_ID = "userId";
   String USER_INFO_COLLECTIONS = "c/userinfo";

   @POST("c/alexa/lwa/enableskill")
   Deferred alexaLinkAccount(@Body Map var1);

   @POST("c/firebase-purchase-event")
   Deferred analyticsLogFilterClickEvent(@Body AnalyticsFilterCLickEvent var1);

   @POST("c/consumable/log")
   Deferred antiFakeLog(@Body AntiFakeLogReq var1);

   @POST("c/consumable/reset")
   Deferred antiFakeReset(@Body AntiFakeResetReq var1);

   @GET("c/consumable/verification")
   Deferred antiFakeVerify(@Query("antifakecode") String var1);

   @GET("c/alexa/lwa/getskillstatus")
   Deferred getAlexaLinkStatus();

   @POST("c/alexa-link-app")
   Deferred getAlexaRedirectUrl(@Body AlexaLinkAppReq var1);

   @GET("c/alexa/appurl")
   Deferred getAlexaUrls(@Query("skillStage") String var1, @Query("state") String var2);

   @GET("c/registered-devices")
   Deferred getDeviceList();

   @POST("c/device-status")
   Deferred getDeviceStatus(@Body GetDeviceStatusReq var1);

   @POST("c/cloud-oauth2/authentication/idtoken")
   Deferred getGoogleAuthCode(@Body GetGoogleAuthCodeReq var1);

   @GET("c/querylinkstatus")
   Deferred getGoogleLinkStatus(@Query("clientid") String var1, @Query("type") String var2);

   @GET("c/device/location")
   Deferred getLocationInfo(@Query("id") String var1, @Query("type") String var2);

   @GET("c/push-notification-setting")
   Deferred getNotificationSettings();

   @GET("c/configs/sku-configurations")
   Deferred getSkuConfigurations(@Query("version") int var1, @Query("series") int var2);

   @GET("c/timezone/getorcreate")
   Deferred getTimezone(@Query("deviceid") String var1, @Query("timezone") String var2);

   @GET("c/timezone/namelist")
   Deferred getTimezoneList(@Query("version") String var1);

   @GET("c/userinfo")
   Deferred getUserInfoCollections(@Query("version") int var1, @Query("series") int var2);

   @POST("c/{userId}/r/initial")
   Deferred initialSetupCall(@Path("userId") String var1, @Body InitialBody var2);

   @POST("c/save-jiguang")
   Deferred jpushLink(@Body JPushLinkReq var1);

   @DELETE("c/delete-jiguang/{jgid}")
   Deferred jpushUnlink(@Header("Authorization") String var1, @Path("jgid") String var2);

   @POST("c/user-form")
   Deferred postUserForm(@Body UserForm var1);

   @POST("c/uploads/presign")
   Deferred presignUploadLog(@Body UploadLogReq var1);

   @POST("c/{userId}/events/subscription")
   Deferred registerMqttEvents(@Path("userId") String var1, @Body MqttIncludeWrapper var2);

   @POST("c/deregister-devices")
   Deferred removeDevice(@Body List var1);

   @POST("c/consumable/direct-reset")
   Deferred resetFilterLife(@Body FilterResetReq var1);

   @POST("c/timezone/updateorcreate")
   Deferred setTimezone(@Body SetTimezoneReq var1);

   @POST("c/device/location")
   Deferred setupDeviceLocation(@Body SetupDeviceLocationReq var1);

   @POST("c/shopify-multipass")
   Deferred shopifyMultiPassLink(@Body ShopifyMultiPassReq var1);

   @DELETE("c/alexa/lwa/disableskill")
   Deferred unlinkAlexa(@Query("stage_value") String var1);

   @DELETE("c/googleaccountunlink")
   Deferred unlinkGoogle(@Query("clientid") String var1);

   @POST("c/push-notification-setting")
   Deferred updateNotificationSetting(@Body NotificationSetting var1);

   @POST("c/userinfo")
   Deferred uploadUserInfoCollections(@Body UserInfoCollections var1);

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006$"},
      d2 = {"Lcom/blueair/api/restapi/UserDevicesRestApi$Companion;", "", "<init>", "()V", "GET_DEVICE_LIST", "", "REMOVE_DEVICE", "REGISTER_DEVICES_FOR_MQTT", "INITIAL", "GET_DEVICE_STATUS", "TIMEZONE_GET", "TIMEZONE_SET", "TIMEZONE_LIST", "DEVICE_LOCATION", "ALEXA_URLS", "ALEXA_LINK_ACCOUNT", "ALEXA_LINK_STATUS", "ALEXA_UNLINK", "ALEXA_LINK_APP", "GOOGLE_AUTH_CODE", "GOOGLE_LINK_STATUS", "GOOGLE_UNLINK", "NOTIFICATION_SETTING", "JPUSH_LINK", "JPUSH_UNLINK", "ANTI_FAKE_VERIFY", "ANTI_FAKE_RESET", "ANTI_FAKE_LOG", "FILTER_RESET", "ANALYTICS_FILTER_CLICK", "SKU_CONFIGURATIONS", "USER_INFO_COLLECTIONS", "USER_FORM", "PRESIGN_SIGN_UPLOAD", "SHOPIFY_MULTIPASS", "USER_ID", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
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
      public static final String JPUSH_LINK = "c/save-jiguang";
      public static final String JPUSH_UNLINK = "c/delete-jiguang/{jgid}";
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

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static Deferred getGoogleLinkStatus$default(UserDevicesRestApi var0, String var1, String var2, int var3, Object var4) {
         return UserDevicesRestApi$_CC.getGoogleLinkStatus$default(var0, var1, var2, var3, var4);
      }
   }
}
