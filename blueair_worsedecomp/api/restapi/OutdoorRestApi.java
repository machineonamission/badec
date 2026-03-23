package com.blueair.api.restapi;

import com.blueair.core.model.BlueAqiData;
import com.blueair.core.model.BlueAqiDataContent;
import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u0005H'J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH'J\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'J\u001e\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0012H'¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/blueair/api/restapi/OutdoorRestApi;", "", "getTrackedLocations", "Lkotlinx/coroutines/Deferred;", "", "Lcom/blueair/core/model/TrackedLocation;", "addTrackedLocation", "location", "removeTrackedLocation", "Lokhttp3/ResponseBody;", "locationId", "", "getAqiDataByLocationId", "Lcom/blueair/core/model/BlueAqiData;", "req", "Lcom/blueair/api/restapi/GetAqiDataByLocationIdReq;", "getAqiDataByLatLng", "Lcom/blueair/core/model/BlueAqiDataContent;", "Lcom/blueair/api/restapi/GetAqiDataByLatLngReq;", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorRestApi.kt */
public interface OutdoorRestApi {
    public static final String AQI_DATA = "c/outdoor/aqidata";
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String REMOVE_TRACKED_LOCATION = "c/outdoor/{locationId}";
    public static final String TRACKED_LOCATION = "c/outdoor";

    @POST("c/outdoor")
    Deferred<TrackedLocation> addTrackedLocation(@Body TrackedLocation trackedLocation);

    @POST("c/outdoor/aqidata")
    Deferred<List<BlueAqiDataContent>> getAqiDataByLatLng(@Body GetAqiDataByLatLngReq getAqiDataByLatLngReq);

    @POST("c/outdoor/aqidata")
    Deferred<List<BlueAqiData>> getAqiDataByLocationId(@Body GetAqiDataByLocationIdReq getAqiDataByLocationIdReq);

    @GET("c/outdoor")
    Deferred<List<TrackedLocation>> getTrackedLocations();

    @DELETE("c/outdoor/{locationId}")
    Deferred<ResponseBody> removeTrackedLocation(@Path("locationId") String str);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/blueair/api/restapi/OutdoorRestApi$Companion;", "", "<init>", "()V", "TRACKED_LOCATION", "", "REMOVE_TRACKED_LOCATION", "AQI_DATA", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorRestApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String AQI_DATA = "c/outdoor/aqidata";
        public static final String REMOVE_TRACKED_LOCATION = "c/outdoor/{locationId}";
        public static final String TRACKED_LOCATION = "c/outdoor";

        private Companion() {
        }
    }
}
