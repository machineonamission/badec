package com.blueair.android.gigya.providers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.blueair.login.R;
import com.gigya.android.sdk.GigyaLogger;
import com.gigya.android.sdk.providers.external.IProviderWrapper;
import com.gigya.android.sdk.providers.external.IProviderWrapperCallback;
import com.gigya.android.sdk.providers.external.ProviderWrapper;
import com.gigya.android.sdk.ui.HostActivity;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.Map;

public class WechatProviderWrapper extends ProviderWrapper implements IProviderWrapper {
    /* access modifiers changed from: private */
    public IWXAPI _api;
    /* access modifiers changed from: private */
    public BaseResp _resp;

    public WechatProviderWrapper(Context context) {
        super(context, R.string.wechatAppID);
        if (this.pId != null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, this.pId, false);
            this._api = createWXAPI;
            createWXAPI.registerApp(this.pId);
            return;
        }
        GigyaLogger.error("WechatProviderWrapper", "Missing App ID.");
    }

    public void login(Context context, final Map<String, Object> map, final IProviderWrapperCallback iProviderWrapperCallback) {
        HostActivity.present(context, new HostActivity.HostActivityLifecycleCallbacks() {
            public void onCreate(AppCompatActivity appCompatActivity, Bundle bundle) {
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "";
                WechatProviderWrapper.this._api.sendReq(req);
            }

            public void onResume(AppCompatActivity appCompatActivity) {
                if (WechatProviderWrapper.this._resp != null) {
                    WechatProviderWrapper wechatProviderWrapper = WechatProviderWrapper.this;
                    wechatProviderWrapper.handleResponse(map, wechatProviderWrapper._resp, appCompatActivity, iProviderWrapperCallback);
                }
            }
        });
    }

    public void logout() {
        IWXAPI iwxapi = this._api;
        if (iwxapi != null) {
            iwxapi.detach();
        }
    }

    public void onResponse(BaseResp baseResp) {
        this._resp = baseResp;
    }

    /* access modifiers changed from: private */
    public void handleResponse(Map<String, Object> map, BaseResp baseResp, Activity activity, IProviderWrapperCallback iProviderWrapperCallback) {
        int i = baseResp.errCode;
        if (i == -4) {
            iProviderWrapperCallback.onFailed("authentication_denied");
        } else if (i == -2) {
            iProviderWrapperCallback.onCanceled();
        } else if (i == 0) {
            try {
                String str = ((SendAuth.Resp) baseResp).code;
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put("uid", this.pId);
                iProviderWrapperCallback.onLogin(hashMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (activity != null) {
            this._resp = null;
            activity.finish();
        }
    }

    public void handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        IWXAPI iwxapi = this._api;
        if (iwxapi != null) {
            iwxapi.handleIntent(intent, iWXAPIEventHandler);
        }
    }
}
