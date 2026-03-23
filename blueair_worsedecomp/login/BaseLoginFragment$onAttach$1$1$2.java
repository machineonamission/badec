package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLoginFragment.kt */
final /* synthetic */ class BaseLoginFragment$onAttach$1$1$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    BaseLoginFragment$onAttach$1$1$2(Object obj) {
        super(1, obj, LoginActivity.class, "renderLoading", "renderLoading(Ljava/lang/Boolean;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Boolean bool) {
        ((LoginActivity) this.receiver).renderLoading(bool);
    }
}
