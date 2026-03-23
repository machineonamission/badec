package com.blueair.api.restapi;

import com.blueair.core.model.BlueDeviceSchedule;
import com.blueair.core.model.BlueWelcomeHomeLocation;
import com.squareup.moshi.Json;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 (2\u00020\u0001:\u0002()J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0003\u0010\f\u001a\u00020\tH'J(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\b\u001a\u00020\t2\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fH'JD\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u000f0\u00032\b\b\u0001\u0010\u0012\u001a\u00020\t2\u0014\b\u0001\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00142\u000e\b\u0001\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH'J\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0001H'J\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH'J(\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH'J,\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\t2\b\b\u0001\u0010!\u001a\u00020\tH'J(\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010 \u001a\u00020\tH'J\u001e\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\tH'J\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\t2\b\b\u0001\u0010%\u001a\u00020&H'J\u0018\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0019\u001a\u00020\tH'¨\u0006*À\u0006\u0003"}, d2 = {"Lcom/blueair/api/restapi/BlueCloudRestApi;", "", "sendSecureVerification", "Lkotlinx/coroutines/Deferred;", "Lokhttp3/ResponseBody;", "body", "Lcom/blueair/api/restapi/BlueCloudRestApi$VerificationWrapper;", "setActuator", "deviceUuid", "", "actuatorWrapper", "Lcom/blueair/api/restapi/ActuatorWrapper;", "actuatorId", "setActuators", "actuatorWrappers", "", "getMonthDatapoints", "Lcom/blueair/api/restapi/BlueDataWrapper;", "userUuid", "map", "", "sensors", "update", "Lcom/blueair/api/restapi/SimpleResponse;", "createSchedule", "appId", "model", "Lcom/blueair/core/model/BlueDeviceSchedule;", "updateSchedule", "Lretrofit2/Response;", "", "deleteSchedule", "deviceId", "scheduleId", "getSchedule", "getSchedules", "createUpdateWelcomeHome", "location", "Lcom/blueair/core/model/BlueWelcomeHomeLocation;", "deleteWelcomeHome", "Companion", "VerificationWrapper", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BlueCloudRestApi.kt */
public interface BlueCloudRestApi {
    public static final Companion Companion = Companion.$$INSTANCE;
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

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueCloudRestApi.kt */
    public static final class DefaultImpls {
    }

    @POST("c/{uuid}/schedule")
    Deferred<ResponseBody> createSchedule(@Path("uuid") String str, @Body BlueDeviceSchedule blueDeviceSchedule);

    @POST("c/{uuid}/welcomehome")
    Deferred<Unit> createUpdateWelcomeHome(@Path("uuid") String str, @Body BlueWelcomeHomeLocation blueWelcomeHomeLocation);

    @DELETE("c/{uuid}/schedule")
    Deferred<ResponseBody> deleteSchedule(@Path("uuid") String str, @Query("deviceid") String str2, @Query("scheduleid") String str3);

    @DELETE("c/{uuid}/welcomehome")
    Deferred<Unit> deleteWelcomeHome(@Path("uuid") String str);

    @GET("c/{userUuid}/r/telemetry/5m/historical")
    Deferred<List<BlueDataWrapper>> getMonthDatapoints(@Path("userUuid") String str, @QueryMap Map<String, String> map, @Query("s") List<String> list);

    @GET("c/{uuid}/schedule")
    Deferred<List<BlueDeviceSchedule>> getSchedule(@Path("uuid") String str, @Query("deviceid") String str2);

    @GET("c/{uuid}/schedule/get-schedules")
    Deferred<List<BlueDeviceSchedule>> getSchedules(@Path("uuid") String str);

    @POST("c/register-for-onboarding")
    Deferred<ResponseBody> sendSecureVerification(@Body VerificationWrapper verificationWrapper);

    @POST("c/{deviceUuid}/a/{id}")
    Deferred<ResponseBody> setActuator(@Path("deviceUuid") String str, @Body ActuatorWrapper actuatorWrapper, @Path("id") String str2);

    @POST("c/{deviceUuid}/a/multiple")
    Deferred<ResponseBody> setActuators(@Path("deviceUuid") String str, @Body List<ActuatorWrapper> list);

    @PATCH("c/cm/update")
    Deferred<SimpleResponse> update(@Body Object obj);

    @PATCH("c/{uuid}/schedule")
    Deferred<Response<Unit>> updateSchedule(@Path("uuid") String str, @Body BlueDeviceSchedule blueDeviceSchedule);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/blueair/api/restapi/BlueCloudRestApi$Companion;", "", "<init>", "()V", "VERIFICATION_ONBOARDING", "", "SET_ACTUATOR", "SET_ACTUATORS", "MONTH_DATAPOINTS", "UPDATE", "DEVICE_UUID", "USER_UUID", "UUID", "DEVICE_ID", "SCHEDULE_ID", "SCHEDULE", "GET_SCHEDULES", "WELCOME_HOME", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueCloudRestApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
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

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/restapi/BlueCloudRestApi$VerificationWrapper;", "", "rand", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRand", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: BlueCloudRestApi.kt */
    public static final class VerificationWrapper {
        private final String rand;
        private final String text;

        public static /* synthetic */ VerificationWrapper copy$default(VerificationWrapper verificationWrapper, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = verificationWrapper.rand;
            }
            if ((i & 2) != 0) {
                str2 = verificationWrapper.text;
            }
            return verificationWrapper.copy(str, str2);
        }

        public final String component1() {
            return this.rand;
        }

        public final String component2() {
            return this.text;
        }

        public final VerificationWrapper copy(@Json(name = "secure-random") String str, @Json(name = "random-text") String str2) {
            Intrinsics.checkNotNullParameter(str, "rand");
            Intrinsics.checkNotNullParameter(str2, "text");
            return new VerificationWrapper(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VerificationWrapper)) {
                return false;
            }
            VerificationWrapper verificationWrapper = (VerificationWrapper) obj;
            return Intrinsics.areEqual((Object) this.rand, (Object) verificationWrapper.rand) && Intrinsics.areEqual((Object) this.text, (Object) verificationWrapper.text);
        }

        public int hashCode() {
            return (this.rand.hashCode() * 31) + this.text.hashCode();
        }

        public String toString() {
            return "VerificationWrapper(rand=" + this.rand + ", text=" + this.text + ')';
        }

        public VerificationWrapper(@Json(name = "secure-random") String str, @Json(name = "random-text") String str2) {
            Intrinsics.checkNotNullParameter(str, "rand");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.rand = str;
            this.text = str2;
        }

        public final String getRand() {
            return this.rand;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* renamed from: com.blueair.api.restapi.BlueCloudRestApi$-CC  reason: invalid class name */
    /* compiled from: BlueCloudRestApi.kt */
    public final /* synthetic */ class CC {
        static {
            Companion companion = BlueCloudRestApi.Companion;
        }

        public static /* synthetic */ Deferred setActuator$default(BlueCloudRestApi blueCloudRestApi, String str, ActuatorWrapper actuatorWrapper, String str2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str2 = actuatorWrapper.getN();
                }
                return blueCloudRestApi.setActuator(str, actuatorWrapper, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActuator");
        }
    }
}
