package com.blueair.login;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileActivity.kt */
final /* synthetic */ class ProfileActivity$onCreate$2$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    ProfileActivity$onCreate$2$2(Object obj) {
        super(1, obj, ProfileActivity.class, "renderFailure", "renderFailure(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        ((ProfileActivity) this.receiver).renderFailure(str);
    }
}
