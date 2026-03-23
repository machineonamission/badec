package com.blueair.auth;

import com.blueair.auth.retrofit.AblUserApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
final /* synthetic */ class AuthService$updateLanguage$2 extends FunctionReferenceImpl implements Function3<String, String, Continuation<? super Response<Unit>>, Object>, SuspendFunction {
    AuthService$updateLanguage$2(Object obj) {
        super(3, obj, AblUserApi.class, "setLanguage", "setLanguage(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, String str2, Continuation<? super Response<Unit>> continuation) {
        return ((AblUserApi) this.receiver).setLanguage(str, str2, continuation);
    }
}
