package com.blueair.android.gigya.wxapi;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.blueair.android.gigya.providers.WechatProviderWrapper;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.gigya.android.sdk.Gigya;
import com.gigya.android.sdk.providers.external.ExternalProvider;
import com.gigya.android.sdk.providers.external.IProviderWrapper;
import com.gigya.android.sdk.providers.provider.Provider;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/android/gigya/wxapi/WXEntryActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "<init>", "()V", "provider", "Lcom/blueair/android/gigya/providers/WechatProviderWrapper;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onReq", "baseReq", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "onResp", "baseResp", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "finish", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WXEntryActivity.kt */
public final class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
    public static final int $stable = 8;
    private WechatProviderWrapper provider;

    public void onReq(BaseReq baseReq) {
        Intrinsics.checkNotNullParameter(baseReq, "baseReq");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Provider usedSocialProvider = Gigya.getInstance().getUsedSocialProvider("wechat");
        Intrinsics.checkNotNull(usedSocialProvider, "null cannot be cast to non-null type com.gigya.android.sdk.providers.external.ExternalProvider");
        ExternalProvider externalProvider = (ExternalProvider) usedSocialProvider;
        externalProvider.setProvidersRoot("com.blueair.login.wxapi");
        IProviderWrapper wrapper = externalProvider.getWrapper();
        Intrinsics.checkNotNull(wrapper, "null cannot be cast to non-null type com.blueair.android.gigya.providers.WechatProviderWrapper");
        WechatProviderWrapper wechatProviderWrapper = (WechatProviderWrapper) wrapper;
        this.provider = wechatProviderWrapper;
        if (wechatProviderWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            wechatProviderWrapper = null;
        }
        wechatProviderWrapper.handleIntent(getIntent(), this);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        super.onNewIntent(intent);
        WechatProviderWrapper wechatProviderWrapper = this.provider;
        if (wechatProviderWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            wechatProviderWrapper = null;
        }
        wechatProviderWrapper.handleIntent(getIntent(), this);
    }

    public void onResp(BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(baseResp, "baseResp");
        WechatProviderWrapper wechatProviderWrapper = this.provider;
        if (wechatProviderWrapper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("provider");
            wechatProviderWrapper = null;
        }
        wechatProviderWrapper.onResponse(baseResp);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
