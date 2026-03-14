package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(
   d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aJ$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0002\u0010\u0011J(\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u000b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\rJ\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\u0016\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\b¨\u0006\u001bÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/api/restapi/UserDevicesAblRestApi;", "", "getDeviceList", "Lretrofit2/Response;", "", "Lcom/blueair/api/restapi/DeviceSparseOnAblServer;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDeviceDetails", "Lcom/blueair/core/model/DeviceDetailsOnAblServer;", "deviceUuid", "removeDevice", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "repairDevice", "Lcom/blueair/api/restapi/RepairBody;", "repairBody", "(Ljava/lang/String;Lcom/blueair/api/restapi/RepairBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addDevice", "resetAttributes", "setTemperaturePreference", "", "body", "Lcom/blueair/api/restapi/TemperatureAttributeDto;", "(Ljava/lang/String;Lcom/blueair/api/restapi/TemperatureAttributeDto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTemperaturePreference", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface UserDevicesAblRestApi {
   String ADD_DEVICE = "/v2/owner/{username}/add/{uuid}/";
   Companion Companion = UserDevicesAblRestApi.Companion.$$INSTANCE;
   String GET_DEVICE_DETAILS = "/v2/device/{uuid}/info/";
   String GET_DEVICE_LIST = "/v2/owner/{username}/device/";
   String REMOVE_DEVICE = "/v2/owner/{username}/release/{uuid}/";
   String REPAIR_DEVICE = "/v2/device/{uuid}/repair_id/";
   String RESET_ATTRIBUTES = "/v2/device/{uuid}/attributes/reset/";
   String TEMPERATURE = "/v2/user/{username}/attribute/temperature/";
   String USERNAME = "username";
   String UUID = "uuid";

   @POST("/v2/owner/{username}/add/{uuid}/")
   Object addDevice(@Path("username") String var1, @Path("uuid") String var2, Continuation var3);

   @GET("/v2/device/{uuid}/info/")
   Object getDeviceDetails(@Path("uuid") String var1, Continuation var2);

   @GET("/v2/owner/{username}/device/")
   Object getDeviceList(@Path("username") String var1, Continuation var2);

   @GET("/v2/user/{username}/attribute/temperature/")
   Object getTemperaturePreference(@Path("username") String var1, Continuation var2);

   @POST("/v2/owner/{username}/release/{uuid}/")
   Object removeDevice(@Path("username") String var1, @Path("uuid") String var2, Continuation var3);

   @POST("/v2/device/{uuid}/repair_id/")
   Object repairDevice(@Path("uuid") String var1, @Body RepairBody var2, Continuation var3);

   @POST("/v2/device/{uuid}/attributes/reset/")
   Object resetAttributes(@Path("uuid") String var1, Continuation var2);

   @POST("/v2/user/{username}/attribute/temperature/")
   Object setTemperaturePreference(@Path("username") String var1, @Body TemperatureAttributeDto var2, Continuation var3);

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/api/restapi/UserDevicesAblRestApi$Companion;", "", "<init>", "()V", "USERNAME", "", "UUID", "GET_DEVICE_LIST", "GET_DEVICE_DETAILS", "REMOVE_DEVICE", "REPAIR_DEVICE", "ADD_DEVICE", "RESET_ATTRIBUTES", "TEMPERATURE", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final String ADD_DEVICE = "/v2/owner/{username}/add/{uuid}/";
      public static final String GET_DEVICE_DETAILS = "/v2/device/{uuid}/info/";
      public static final String GET_DEVICE_LIST = "/v2/owner/{username}/device/";
      public static final String REMOVE_DEVICE = "/v2/owner/{username}/release/{uuid}/";
      public static final String REPAIR_DEVICE = "/v2/device/{uuid}/repair_id/";
      public static final String RESET_ATTRIBUTES = "/v2/device/{uuid}/attributes/reset/";
      public static final String TEMPERATURE = "/v2/user/{username}/attribute/temperature/";
      public static final String USERNAME = "username";
      public static final String UUID = "uuid";

      private Companion() {
      }
   }
}
