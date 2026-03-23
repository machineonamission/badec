package com.blueair.auth;

import com.blueair.auth.retrofit.AblUserApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
final /* synthetic */ class AuthService$getAblJwt$2$response$1 extends FunctionReferenceImpl implements Function2<AblUserApi.GigyaJwtTokenExchange, Continuation<? super Response<AblUserApi.GigyaJwtTokenExchange>>, Object>, SuspendFunction {
    AuthService$getAblJwt$2$response$1(Object obj) {
        super(2, obj, AblUserApi.class, "doTokenExchange", "doTokenExchange(Lcom/blueair/auth/retrofit/AblUserApi$GigyaJwtTokenExchange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(AblUserApi.GigyaJwtTokenExchange gigyaJwtTokenExchange, Continuation<? super Response<AblUserApi.GigyaJwtTokenExchange>> continuation) {
        return ((AblUserApi) this.receiver).doTokenExchange(gigyaJwtTokenExchange, continuation);
    }
}
