package com.blueair.auth;

import com.blueair.auth.retrofit.AblUserApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import retrofit2.Response;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthService.kt */
final /* synthetic */ class AuthService$authenticateAblUser$extUid$2 extends FunctionReferenceImpl implements Function2<String, Continuation<? super Response<List<? extends AblUserApi.UserAttribute>>>, Object>, SuspendFunction {
    AuthService$authenticateAblUser$extUid$2(Object obj) {
        super(2, obj, AblUserApi.class, "getAttributes", "getAttributes(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super Response<List<AblUserApi.UserAttribute>>> continuation) {
        return ((AblUserApi) this.receiver).getAttributes(str, continuation);
    }
}
