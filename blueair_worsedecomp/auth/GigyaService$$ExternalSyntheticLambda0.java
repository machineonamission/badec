package com.blueair.auth;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GigyaService$$ExternalSyntheticLambda0 implements Interceptor {
    public final /* synthetic */ GigyaService f$0;

    public /* synthetic */ GigyaService$$ExternalSyntheticLambda0(GigyaService gigyaService) {
        this.f$0 = gigyaService;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return GigyaService.gigyaRestAdapter_delegate$lambda$3$lambda$2(this.f$0, chain);
    }
}
