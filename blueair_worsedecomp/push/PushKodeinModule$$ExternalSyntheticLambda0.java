package com.blueair.push;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import org.kodein.di.DI;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PushKodeinModule$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ PushKodeinModule$$ExternalSyntheticLambda0(Context context) {
        this.f$0 = context;
    }

    public final Object invoke(Object obj) {
        return PushKodeinModule.getModule$lambda$1(this.f$0, (DI.Builder) obj);
    }
}
