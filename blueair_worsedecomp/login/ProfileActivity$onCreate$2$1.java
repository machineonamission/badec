package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileActivity.kt */
final /* synthetic */ class ProfileActivity$onCreate$2$1 extends FunctionReferenceImpl implements Function1<Unit, Unit> {
    ProfileActivity$onCreate$2$1(Object obj) {
        super(1, obj, ProfileActivity.class, "renderSuccess", "renderSuccess(Lkotlin/Unit;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Unit) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Unit unit) {
        ((ProfileActivity) this.receiver).renderSuccess(unit);
    }
}
