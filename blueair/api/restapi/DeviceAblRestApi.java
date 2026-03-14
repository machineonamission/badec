package com.blueair.api.restapi;

import com.blueair.api.model.DeviceInfoData;
import com.blueair.core.model.LegacyDeviceSchedule;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b`\u0018\u0000 $2\u00020\u0001:\u0001$J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J,\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\fH'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0013H'J\u001e\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0006H'J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0017\u001a\u00020\u0006H'J\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u001fH'J\u001e\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u000b0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u0006H'J\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\"\u001a\u00020\u0006H'J\u0018\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006%À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/restapi/DeviceAblRestApi;", "", "getDatapoint", "Lkotlinx/coroutines/Deferred;", "Lcom/blueair/api/restapi/DatapointsWrapper;", "deviceUuid", "", "getMonthDatapoints", "fromTime", "toTime", "getAttributes", "", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "setAttribute", "Lcom/blueair/api/restapi/SimpleResponse;", "uuid", "attribute", "value", "getDeviceInfoData", "Lcom/blueair/api/model/DeviceInfoData;", "setDeviceInfoData", "getLink", "setLink", "linkedUuid", "deleteLink", "getIsUpdating", "", "createSchedule", "Lokhttp3/ResponseBody;", "deviceId", "model", "Lcom/blueair/core/model/LegacyDeviceSchedule;", "getSchedules", "deleteSchedules", "scheduleId", "getDeviceStatus", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface DeviceAblRestApi {
   String ATTRIBUTE = "attribute";
   Companion Companion = DeviceAblRestApi.Companion.$$INSTANCE;
   String DEVICE_ATTRIBUTES = "/v2/device/{uuid}/attributes/";
   String DEVICE_INFO_DATA = "/v2/device/{uuid}/info/";
   String FROM_TIME = "fromtime";
   String GET_LINK = "/v2/device/{uuid}/link/";
   String GET_STATUS = "/v2/device/{uuid}/status/";
   String IS_UPDATING = "/v2/device/{uuid}/upgrading/";
   String LATEST_DATAPOINT = "/v2/device/{uuid}/datapoint/0/last/0/";
   String MONTH_DATAPOINTS = "/v2/device/{uuid}/datapoint/{fromtime}/{totime}/0/";
   String SET_ATTRIBUTE = "/v2/device/{uuid}/attribute/{attribute}/";
   String SET_LINK = "/v2/device/{uuid}/link/{uuid2}/";
   String TO_TIME = "totime";
   String UUID = "uuid";
   String UUID2 = "uuid2";

   @POST("/v2/device/{device_id}/schedule/daily/")
   Deferred createSchedule(@Path("device_id") String var1, @Body LegacyDeviceSchedule var2);

   @DELETE("/v2/device/{uuid}/link/{uuid2}/")
   Deferred deleteLink(@Path("uuid") String var1, @Path("uuid2") String var2);

   @DELETE("/v2/device/{device_id}/schedule/{schedule_id}/")
   Deferred deleteSchedules(@Path("device_id") String var1, @Path("schedule_id") String var2);

   @GET("/v2/device/{uuid}/attributes/")
   Deferred getAttributes(@Path("uuid") String var1);

   @GET("/v2/device/{uuid}/datapoint/0/last/0/")
   Deferred getDatapoint(@Path("uuid") String var1);

   @GET("/v2/device/{uuid}/info/")
   Deferred getDeviceInfoData(@Path("uuid") String var1);

   @GET("/v2/device/{uuid}/status/")
   Deferred getDeviceStatus(@Path("uuid") String var1);

   @GET("/v2/device/{uuid}/upgrading/")
   Deferred getIsUpdating(@Path("uuid") String var1);

   @GET("/v2/device/{uuid}/link/")
   Deferred getLink(@Path("uuid") String var1);

   @GET("/v2/device/{uuid}/datapoint/{fromtime}/{totime}/0/")
   Deferred getMonthDatapoints(@Path("uuid") String var1, @Path("fromtime") String var2, @Path("totime") String var3);

   @GET("/v2/device/{device_id}/schedules/")
   Deferred getSchedules(@Path("device_id") String var1);

   @POST("/v2/device/{uuid}/attribute/{attribute}/")
   Deferred setAttribute(@Path("uuid") String var1, @Path("attribute") String var2, @Body DeviceAttributeOnAbl var3);

   @POST("/v2/device/{uuid}/info/")
   Deferred setDeviceInfoData(@Path("uuid") String var1, @Body DeviceInfoData var2);

   @POST("/v2/device/{uuid}/link/{uuid2}/")
   Deferred setLink(@Path("uuid") String var1, @Path("uuid2") String var2);

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAblRestApi$Companion;", "", "<init>", "()V", "LATEST_DATAPOINT", "", "MONTH_DATAPOINTS", "DEVICE_ATTRIBUTES", "SET_ATTRIBUTE", "DEVICE_INFO_DATA", "GET_LINK", "SET_LINK", "UUID", "UUID2", "ATTRIBUTE", "FROM_TIME", "TO_TIME", "IS_UPDATING", "GET_STATUS", "PARAM_DEVICE_ID", "PARAM_SCHEDULE_ID", "ENDPOINT_SCHEDULE_CREATE", "ENDPOINT_SCHEDULE_GET", "ENDPOINT_SCHEDULE_DELETE", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final String ATTRIBUTE = "attribute";
      public static final String DEVICE_ATTRIBUTES = "/v2/device/{uuid}/attributes/";
      public static final String DEVICE_INFO_DATA = "/v2/device/{uuid}/info/";
      private static final String ENDPOINT_SCHEDULE_CREATE = "/v2/device/{device_id}/schedule/daily/";
      private static final String ENDPOINT_SCHEDULE_DELETE = "/v2/device/{device_id}/schedule/{schedule_id}/";
      private static final String ENDPOINT_SCHEDULE_GET = "/v2/device/{device_id}/schedules/";
      public static final String FROM_TIME = "fromtime";
      public static final String GET_LINK = "/v2/device/{uuid}/link/";
      public static final String GET_STATUS = "/v2/device/{uuid}/status/";
      public static final String IS_UPDATING = "/v2/device/{uuid}/upgrading/";
      public static final String LATEST_DATAPOINT = "/v2/device/{uuid}/datapoint/0/last/0/";
      public static final String MONTH_DATAPOINTS = "/v2/device/{uuid}/datapoint/{fromtime}/{totime}/0/";
      private static final String PARAM_DEVICE_ID = "device_id";
      private static final String PARAM_SCHEDULE_ID = "schedule_id";
      public static final String SET_ATTRIBUTE = "/v2/device/{uuid}/attribute/{attribute}/";
      public static final String SET_LINK = "/v2/device/{uuid}/link/{uuid2}/";
      public static final String TO_TIME = "totime";
      public static final String UUID = "uuid";
      public static final String UUID2 = "uuid2";

      private Companion() {
      }
   }
}
