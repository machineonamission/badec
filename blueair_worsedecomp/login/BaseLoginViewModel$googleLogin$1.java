package com.blueair.login;

import com.blueair.auth.GigyaAccountExtended;
import com.blueair.auth.GigyaService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLoginViewModel.kt */
final /* synthetic */ class BaseLoginViewModel$googleLogin$1 extends FunctionReferenceImpl implements Function1<Continuation<? super GigyaAccountExtended>, Object>, SuspendFunction {
    BaseLoginViewModel$googleLogin$1(Object obj) {
        super(1, obj, GigyaService.class, "googleLogin", "googleLogin(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super GigyaAccountExtended> continuation) {
        return ((GigyaService) this.receiver).googleLogin(continuation);
    }
}
