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
final /* synthetic */ class AuthService$updateHomeHost$1$response$1 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Response<String>>, Object>, SuspendFunction {
    AuthService$updateHomeHost$1$response$1(Object obj) {
        super(2, obj, AblUserApi.class, "getHomehost", "getHomehost(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super Response<String>> continuation) {
        return ((AblUserApi) this.receiver).getHomehost(str, continuation);
    }
}
