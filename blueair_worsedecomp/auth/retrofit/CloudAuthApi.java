package com.blueair.auth.retrofit;

import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J:\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0007H'J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0007H'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/blueair/auth/retrofit/CloudAuthApi;", "", "login", "Lkotlinx/coroutines/Deferred;", "Lcom/blueair/auth/retrofit/BlueLoginDetails;", "headers", "", "", "map", "disableUserAccount", "Lokhttp3/ResponseBody;", "bearerToken", "deleteUserAccount", "setPushToken", "request", "Lcom/blueair/auth/retrofit/SetPushTokenRequest;", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CloudAuthApi.kt */
public interface CloudAuthApi {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String DELETE_USER_ACCOUNT = "c/deleteuseraccountapp";
    public static final String DISABLE_USER_ACCOUNT = "c/disableuseraccount";
    public static final String KEY_AUTH = "Authorization";
    public static final String LOGIN = "c/login";
    public static final String PUSH_TOKEN = "c/adddevicetoken";

    @POST("c/deleteuseraccountapp")
    Deferred<ResponseBody> deleteUserAccount(@Header("Authorization") String str);

    @POST("c/disableuseraccount")
    Deferred<ResponseBody> disableUserAccount(@Header("Authorization") String str);

    @POST("c/login")
    Deferred<BlueLoginDetails> login(@HeaderMap Map<String, String> map, @QueryMap Map<String, String> map2);

    @POST("c/adddevicetoken")
    Deferred<ResponseBody> setPushToken(@Header("Authorization") String str, @Body SetPushTokenRequest setPushTokenRequest);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/auth/retrofit/CloudAuthApi$Companion;", "", "<init>", "()V", "LOGIN", "", "DISABLE_USER_ACCOUNT", "DELETE_USER_ACCOUNT", "PUSH_TOKEN", "KEY_AUTH", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: CloudAuthApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String DELETE_USER_ACCOUNT = "c/deleteuseraccountapp";
        public static final String DISABLE_USER_ACCOUNT = "c/disableuseraccount";
        public static final String KEY_AUTH = "Authorization";
        public static final String LOGIN = "c/login";
        public static final String PUSH_TOKEN = "c/adddevicetoken";

        private Companion() {
        }
    }
}
