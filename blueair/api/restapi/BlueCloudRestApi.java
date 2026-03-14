package com.blueair.api.restapi;

import com.blueair.core.model.BlueDeviceSchedule;
import com.blueair.core.model.BlueWelcomeHomeLocation;
import com.squareup.moshi.Json;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 (2\u00020\u0001:\u0002()J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\tH'J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH'JD\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000f0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\t2\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00142\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0001H'J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH'J(\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH'J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\tH'J(\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\tH'J\u001e\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\tH'J\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010%\u001a\u00020&H'J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\tH'¨\u0006*À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/restapi/BlueCloudRestApi;", "", "sendSecureVerification", "Lkotlinx/coroutines/Deferred;", "Lokhttp3/ResponseBody;", "body", "Lcom/blueair/api/restapi/BlueCloudRestApi$VerificationWrapper;", "setActuator", "deviceUuid", "", "actuatorWrapper", "Lcom/blueair/api/restapi/ActuatorWrapper;", "actuatorId", "setActuators", "actuatorWrappers", "", "getMonthDatapoints", "Lcom/blueair/api/restapi/BlueDataWrapper;", "userUuid", "map", "", "sensors", "update", "Lcom/blueair/api/restapi/SimpleResponse;", "createSchedule", "appId", "model", "Lcom/blueair/core/model/BlueDeviceSchedule;", "updateSchedule", "Lretrofit2/Response;", "", "deleteSchedule", "deviceId", "scheduleId", "getSchedule", "getSchedules", "createUpdateWelcomeHome", "location", "Lcom/blueair/core/model/BlueWelcomeHomeLocation;", "deleteWelcomeHome", "Companion", "VerificationWrapper", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface BlueCloudRestApi {
   Companion Companion = BlueCloudRestApi.Companion.$$INSTANCE;
   String DEVICE_ID = "deviceid";
   String DEVICE_UUID = "deviceUuid";
   String GET_SCHEDULES = "c/{uuid}/schedule/get-schedules";
   String MONTH_DATAPOINTS = "c/{userUuid}/r/telemetry/5m/historical";
   String SCHEDULE = "c/{uuid}/schedule";
   String SCHEDULE_ID = "scheduleid";
   String SET_ACTUATOR = "c/{deviceUuid}/a/{id}";
   String SET_ACTUATORS = "c/{deviceUuid}/a/multiple";
   String UPDATE = "c/cm/update";
   String USER_UUID = "userUuid";
   String UUID = "uuid";
   String VERIFICATION_ONBOARDING = "c/register-for-onboarding";
   String WELCOME_HOME = "c/{uuid}/welcomehome";

   @POST("c/{uuid}/schedule")
   Deferred createSchedule(@Path("uuid") String var1, @Body BlueDeviceSchedule var2);

   @POST("c/{uuid}/welcomehome")
   Deferred createUpdateWelcomeHome(@Path("uuid") String var1, @Body BlueWelcomeHomeLocation var2);

   @DELETE("c/{uuid}/schedule")
   Deferred deleteSchedule(@Path("uuid") String var1, @Query("deviceid") String var2, @Query("scheduleid") String var3);

   @DELETE("c/{uuid}/welcomehome")
   Deferred deleteWelcomeHome(@Path("uuid") String var1);

   @GET("c/{userUuid}/r/telemetry/5m/historical")
   Deferred getMonthDatapoints(@Path("userUuid") String var1, @QueryMap Map var2, @Query("s") List var3);

   @GET("c/{uuid}/schedule")
   Deferred getSchedule(@Path("uuid") String var1, @Query("deviceid") String var2);

   @GET("c/{uuid}/schedule/get-schedules")
   Deferred getSchedules(@Path("uuid") String var1);

   @POST("c/register-for-onboarding")
   Deferred sendSecureVerification(@Body VerificationWrapper var1);

   @POST("c/{deviceUuid}/a/{id}")
   Deferred setActuator(@Path("deviceUuid") String var1, @Body ActuatorWrapper var2, @Path("id") String var3);

   @POST("c/{deviceUuid}/a/multiple")
   Deferred setActuators(@Path("deviceUuid") String var1, @Body List var2);

   @PATCH("c/cm/update")
   Deferred update(@Body Object var1);

   @PATCH("c/{uuid}/schedule")
   Deferred updateSchedule(@Path("uuid") String var1, @Body BlueDeviceSchedule var2);

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"},
      d2 = {"Lcom/blueair/api/restapi/BlueCloudRestApi$Companion;", "", "<init>", "()V", "VERIFICATION_ONBOARDING", "", "SET_ACTUATOR", "SET_ACTUATORS", "MONTH_DATAPOINTS", "UPDATE", "DEVICE_UUID", "USER_UUID", "UUID", "DEVICE_ID", "SCHEDULE_ID", "SCHEDULE", "GET_SCHEDULES", "WELCOME_HOME", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();
      public static final String DEVICE_ID = "deviceid";
      public static final String DEVICE_UUID = "deviceUuid";
      public static final String GET_SCHEDULES = "c/{uuid}/schedule/get-schedules";
      public static final String MONTH_DATAPOINTS = "c/{userUuid}/r/telemetry/5m/historical";
      public static final String SCHEDULE = "c/{uuid}/schedule";
      public static final String SCHEDULE_ID = "scheduleid";
      public static final String SET_ACTUATOR = "c/{deviceUuid}/a/{id}";
      public static final String SET_ACTUATORS = "c/{deviceUuid}/a/multiple";
      public static final String UPDATE = "c/cm/update";
      public static final String USER_UUID = "userUuid";
      public static final String UUID = "uuid";
      public static final String VERIFICATION_ONBOARDING = "c/register-for-onboarding";
      public static final String WELCOME_HOME = "c/{uuid}/welcomehome";

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
      public static Deferred setActuator$default(BlueCloudRestApi var0, String var1, ActuatorWrapper var2, String var3, int var4, Object var5) {
         return BlueCloudRestApi$_CC.setActuator$default(var0, var1, var2, var3, var4, var5);
      }
   }

   @Metadata(
      d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"},
      d2 = {"Lcom/blueair/api/restapi/BlueCloudRestApi$VerificationWrapper;", "", "rand", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRand", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class VerificationWrapper {
      private final String rand;
      private final String text;

      public VerificationWrapper(@Json(name = "secure-random") String var1, @Json(name = "random-text") String var2) {
         Intrinsics.checkNotNullParameter(var1, "rand");
         Intrinsics.checkNotNullParameter(var2, "text");
         super();
         this.rand = var1;
         this.text = var2;
      }

      // $FF: synthetic method
      public static VerificationWrapper copy$default(VerificationWrapper var0, String var1, String var2, int var3, Object var4) {
         if ((var3 & 1) != 0) {
            var1 = var0.rand;
         }

         if ((var3 & 2) != 0) {
            var2 = var0.text;
         }

         return var0.copy(var1, var2);
      }

      public final String component1() {
         return this.rand;
      }

      public final String component2() {
         return this.text;
      }

      public final VerificationWrapper copy(@Json(name = "secure-random") String var1, @Json(name = "random-text") String var2) {
         Intrinsics.checkNotNullParameter(var1, "rand");
         Intrinsics.checkNotNullParameter(var2, "text");
         return new VerificationWrapper(var1, var2);
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof VerificationWrapper)) {
            return false;
         } else {
            var1 = var1;
            if (!Intrinsics.areEqual(this.rand, var1.rand)) {
               return false;
            } else {
               return Intrinsics.areEqual(this.text, var1.text);
            }
         }
      }

      public final String getRand() {
         return this.rand;
      }

      public final String getText() {
         return this.text;
      }

      public int hashCode() {
         return this.rand.hashCode() * 31 + this.text.hashCode();
      }

      public String toString() {
         StringBuilder var1 = new StringBuilder("VerificationWrapper(rand=");
         var1.append(this.rand);
         var1.append(", text=");
         var1.append(this.text);
         var1.append(')');
         return var1.toString();
      }
   }
}
