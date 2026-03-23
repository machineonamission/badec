package com.blueair.auth;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AuthService$$ExternalSyntheticLambda3 implements Interceptor {
    public final /* synthetic */ AuthService f$0;

    public /* synthetic */ AuthService$$ExternalSyntheticLambda3(AuthService authService) {
        this.f$0 = authService;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return AuthService.userOkhttpClient_delegate$lambda$5$lambda$4(this.f$0, chain);
    }
}
