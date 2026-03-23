package com.blueair.auth;

import com.blueair.auth.retrofit.AblUserApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
final /* synthetic */ class AuthService$fetchAblGranularRegion$response$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Response<AblUserApi.BlueairGranularRegion>>, Object>, SuspendFunction {
    AuthService$fetchAblGranularRegion$response$1(Object obj) {
        super(1, obj, AblUserApi.class, "getSpecificRegionSync", "getSpecificRegionSync(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super Response<AblUserApi.BlueairGranularRegion>> continuation) {
        return ((AblUserApi) this.receiver).getSpecificRegionSync(continuation);
    }
}
