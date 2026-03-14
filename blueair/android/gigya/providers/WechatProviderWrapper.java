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
   private IWXAPI _api;
   private BaseResp _resp;

   public WechatProviderWrapper(Context var1) {
      super(var1, R.string.wechatAppID);
      if (this.pId != null) {
         IWXAPI var2 = WXAPIFactory.createWXAPI(var1, this.pId, false);
         this._api = var2;
         var2.registerApp(this.pId);
      } else {
         GigyaLogger.error("WechatProviderWrapper", "Missing App ID.");
      }
   }

   private void handleResponse(Map var1, BaseResp var2, Activity var3, IProviderWrapperCallback var4) {
      int var5 = var2.errCode;
      if (var5 != -4) {
         if (var5 != -2) {
            if (var5 == 0) {
               try {
                  String var8 = ((SendAuth.Resp)var2).code;
                  var1 = new HashMap();
                  var1.put("code", var8);
                  var1.put("uid", this.pId);
                  var4.onLogin(var1);
               } catch (Exception var6) {
                  var6.printStackTrace();
               }
            }
         } else {
            var4.onCanceled();
         }
      } else {
         var4.onFailed("authentication_denied");
      }

      if (var3 != null) {
         this._resp = null;
         var3.finish();
      }

   }

   public void handleIntent(Intent var1, IWXAPIEventHandler var2) {
      IWXAPI var3 = this._api;
      if (var3 != null) {
         var3.handleIntent(var1, var2);
      }

   }

   public void login(Context var1, Map var2, IProviderWrapperCallback var3) {
      HostActivity.present(var1, new HostActivity.HostActivityLifecycleCallbacks(this, var2, var3) {
         final WechatProviderWrapper this$0;
         final IProviderWrapperCallback val$callback;
         final Map val$params;

         {
            this.this$0 = var1;
            this.val$params = var2;
            this.val$callback = var3;
         }

         public void onCreate(AppCompatActivity var1, Bundle var2) {
            SendAuth.Req var3 = new SendAuth.Req();
            var3.scope = "snsapi_userinfo";
            var3.state = "";
            this.this$0._api.sendReq(var3);
         }

         public void onResume(AppCompatActivity var1) {
            if (this.this$0._resp != null) {
               WechatProviderWrapper var2 = this.this$0;
               var2.handleResponse(this.val$params, var2._resp, var1, this.val$callback);
            }

         }
      });
   }

   public void logout() {
      IWXAPI var1 = this._api;
      if (var1 != null) {
         var1.detach();
      }

   }

   public void onResponse(BaseResp var1) {
      this._resp = var1;
   }
}
