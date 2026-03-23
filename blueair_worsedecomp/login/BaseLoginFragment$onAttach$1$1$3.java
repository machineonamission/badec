package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLoginFragment.kt */
final /* synthetic */ class BaseLoginFragment$onAttach$1$1$3 extends FunctionReferenceImpl implements Function1<LoginFailure, Unit> {
    BaseLoginFragment$onAttach$1$1$3(Object obj) {
        super(1, obj, LoginActivity.class, "renderFailure", "renderFailure(Lcom/blueair/login/LoginFailure;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LoginFailure) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(LoginFailure loginFailure) {
        ((LoginActivity) this.receiver).renderFailure(loginFailure);
    }
}
