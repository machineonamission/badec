package com.blueair.api.restapi;

import com.blueair.core.model.MbGeoLocations;
import kotlin.Metadata;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H'JJ\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/blueair/api/restapi/MbGeoApi;", "", "getPoint", "Lretrofit2/Call;", "Lcom/blueair/core/model/MbGeoLocations;", "lat", "", "lon", "key", "lang", "queryAsync", "query", "token", "lngLat", "countryCode", "limit", "", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MbGeoApi.kt */
public interface MbGeoApi {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String QUERY = "query";
    public static final String accessToken = "access_token";
    public static final String geocoding = "{query}.json";
    public static final String language = "language";
    public static final String mapbox_auth_key = "pk.eyJ1IjoiaXZhbi1zZXJoZWl0c2V2IiwiYSI6ImNrdjJla3JjajN4aWEybnM3NHB6MjFzZTYifQ.DLzKWJTXeKIM9a_yQn1Z7w";
    public static final String mb_geo_rest_base_url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    public static final String reverseGeocoding = "{lng},{lat}.json";

    @GET("{lng},{lat}.json")
    Call<MbGeoLocations> getPoint(@Path("lat") String str, @Path("lng") String str2, @Query("access_token") String str3, @Query("language") String str4);

    @GET("{query}.json")
    Call<MbGeoLocations> queryAsync(@Path("query") String str, @Query("access_token") String str2, @Query("proximity") String str3, @Query("country") String str4, @Query("language") String str5, @Query("limit") int i);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/api/restapi/MbGeoApi$Companion;", "", "<init>", "()V", "mb_geo_rest_base_url", "", "mapbox_auth_key", "geocoding", "QUERY", "reverseGeocoding", "accessToken", "language", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MbGeoApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String QUERY = "query";
        public static final String accessToken = "access_token";
        public static final String geocoding = "{query}.json";
        public static final String language = "language";
        public static final String mapbox_auth_key = "pk.eyJ1IjoiaXZhbi1zZXJoZWl0c2V2IiwiYSI6ImNrdjJla3JjajN4aWEybnM3NHB6MjFzZTYifQ.DLzKWJTXeKIM9a_yQn1Z7w";
        public static final String mb_geo_rest_base_url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
        public static final String reverseGeocoding = "{lng},{lat}.json";

        private Companion() {
        }
    }
}
