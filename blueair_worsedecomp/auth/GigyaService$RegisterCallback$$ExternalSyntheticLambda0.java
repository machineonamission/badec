package com.blueair.auth;

import com.blueair.auth.GigyaService;
import com.gigya.android.sdk.interruption.link.ILinkAccountsResolver;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GigyaService$RegisterCallback$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ GigyaService.RegisterCallback f$0;
    public final /* synthetic */ ILinkAccountsResolver f$1;

    public /* synthetic */ GigyaService$RegisterCallback$$ExternalSyntheticLambda0(GigyaService.RegisterCallback registerCallback, ILinkAccountsResolver iLinkAccountsResolver) {
        this.f$0 = registerCallback;
        this.f$1 = iLinkAccountsResolver;
    }

    public final Object invoke(Object obj) {
        return GigyaService.RegisterCallback.onConflictingAccounts$lambda$0(this.f$0, this.f$1, (String) obj);
    }
}
