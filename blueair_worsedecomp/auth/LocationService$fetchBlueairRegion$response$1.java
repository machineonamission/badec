package com.blueair.auth;

import com.blueair.auth.retrofit.BlueairRegion;
import com.blueair.auth.retrofit.RegionApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationService.kt */
final /* synthetic */ class LocationService$fetchBlueairRegion$response$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Response<BlueairRegion>>, Object>, SuspendFunction {
    LocationService$fetchBlueairRegion$response$1(Object obj) {
        super(1, obj, RegionApi.class, "getRegion", "getRegion(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super Response<BlueairRegion>> continuation) {
        return ((RegionApi) this.receiver).getRegion(continuation);
    }
}
