package com.blueair.auth;

import com.blueair.auth.retrofit.AblUserApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
final /* synthetic */ class AuthService$authenticateAblUser$3 extends FunctionReferenceImpl implements Function3<String, AblUserApi.UserAttribute, Continuation<? super Response<String>>, Object>, SuspendFunction {
    AuthService$authenticateAblUser$3(Object obj) {
        super(3, obj, AblUserApi.class, "setExternalUidAttr", "setExternalUidAttr(Ljava/lang/String;Lcom/blueair/auth/retrofit/AblUserApi$UserAttribute;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, AblUserApi.UserAttribute userAttribute, Continuation<? super Response<String>> continuation) {
        return ((AblUserApi) this.receiver).setExternalUidAttr(str, userAttribute, continuation);
    }
}
