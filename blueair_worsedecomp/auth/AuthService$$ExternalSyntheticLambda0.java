package com.blueair.auth;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AuthService$$ExternalSyntheticLambda0 implements Interceptor {
    public final /* synthetic */ AuthService f$0;

    public /* synthetic */ AuthService$$ExternalSyntheticLambda0(AuthService authService) {
        this.f$0 = authService;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return AuthService._get_cloudRestAdapter_$lambda$6(this.f$0, chain);
    }
}
