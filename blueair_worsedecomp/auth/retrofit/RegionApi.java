package com.blueair.auth.retrofit;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.Response;
import retrofit2.http.GET;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H§@¢\u0006\u0002\u0010\u0005¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/blueair/auth/retrofit/RegionApi;", "", "getRegion", "Lretrofit2/Response;", "Lcom/blueair/auth/retrofit/BlueairRegion;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAblRegion", "Lcom/blueair/auth/retrofit/AblRegion;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RegionApi.kt */
public interface RegionApi {
    @GET("/")
    Object getAblRegion(Continuation<? super Response<AblRegion>> continuation);

    @GET("v2/geocode/ip")
    Object getRegion(Continuation<? super Response<BlueairRegion>> continuation);
}
