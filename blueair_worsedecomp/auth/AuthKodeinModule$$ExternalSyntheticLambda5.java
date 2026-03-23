package com.blueair.auth;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import org.kodein.di.DI;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AuthKodeinModule$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ AuthKodeinModule$$ExternalSyntheticLambda5(Context context) {
        this.f$0 = context;
    }

    public final Object invoke(Object obj) {
        return AuthKodeinModule.getModule$lambda$6(this.f$0, (DI.Builder) obj);
    }
}
