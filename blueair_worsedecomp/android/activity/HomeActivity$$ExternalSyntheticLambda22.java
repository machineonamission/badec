package com.blueair.android.activity;

import android.net.Uri;
import com.blueair.core.model.Device;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeActivity$$ExternalSyntheticLambda22 implements Function1 {
    public final /* synthetic */ HomeActivity f$0;
    public final /* synthetic */ Uri f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ HomeActivity$$ExternalSyntheticLambda22(HomeActivity homeActivity, Uri uri, String str, String str2, String str3) {
        this.f$0 = homeActivity;
        this.f$1 = uri;
        this.f$2 = str;
        this.f$3 = str2;
        this.f$4 = str3;
    }

    public final Object invoke(Object obj) {
        return HomeActivity.onNewIntent$lambda$30(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Device) obj);
    }
}
