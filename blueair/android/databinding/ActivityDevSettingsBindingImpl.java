package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public class ActivityDevSettingsBindingImpl extends ActivityDevSettingsBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final CoordinatorLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.toolbar, 1);
      var0.put(R.id.layoutMain, 2);
      var0.put(R.id.app_build_info, 3);
      var0.put(R.id.checkChina, 4);
      var0.put(R.id.checkUSA, 5);
      var0.put(R.id.checkKorea, 6);
      var0.put(R.id.checkForceG4, 7);
      var0.put(R.id.checkForceB4, 8);
      var0.put(R.id.checkForceAware, 9);
      var0.put(R.id.checkForceIcp, 10);
      var0.put(R.id.checkForceAlexa, 11);
      var0.put(R.id.checkForceTmall, 12);
      var0.put(R.id.checkForceGAssistant, 13);
      var0.put(R.id.checkForceWelcomeHome, 14);
      var0.put(R.id.checkAmplitudeDebug, 15);
      var0.put(R.id.checkFacebookLogin, 16);
      var0.put(R.id.checkGoogleLogin, 17);
      var0.put(R.id.checkWeChatQQApple, 18);
      var0.put(R.id.checkLokalisePreRelease, 19);
      var0.put(R.id.checkGoogleDev, 20);
      var0.put(R.id.checkAlexaDev, 21);
      var0.put(R.id.useGigyaSandbox, 22);
      var0.put(R.id.checkUAT, 23);
      var0.put(R.id.checkKlaviyoDev, 24);
      var0.put(R.id.checkShowDetectCat, 25);
      var0.put(R.id.sendLogs, 26);
      var0.put(R.id.show_notification, 27);
      var0.put(R.id.resetUserInfoSyncTime, 28);
      var0.put(R.id.force_crash, 29);
      var0.put(R.id.forceUpdate, 30);
      var0.put(R.id.forceRateUs, 31);
      var0.put(R.id.forceWelcomeHomeIntro, 32);
      var0.put(R.id.separator_api, 33);
      var0.put(R.id.gigya_user_region, 34);
      var0.put(R.id.legacy_homehost, 35);
      var0.put(R.id.reset_homehost, 36);
      var0.put(R.id.set_url_us, 37);
      var0.put(R.id.set_url_eu, 38);
      var0.put(R.id.set_url_cn, 39);
      var0.put(R.id.force_release, 40);
      var0.put(R.id.force_qa, 41);
      var0.put(R.id.force_reset, 42);
      var0.put(R.id.labelTextBaseUrl, 43);
      var0.put(R.id.editTextBaseUrl, 44);
      var0.put(R.id.labelBrokerBaseURL, 45);
      var0.put(R.id.editBrokerBaseURL, 46);
      var0.put(R.id.buttonSaveUrl, 47);
      var0.put(R.id.set_gigya_token, 48);
      var0.put(R.id.textViewAPIhint, 49);
      var0.put(R.id.textViewAPI, 50);
      var0.put(R.id.textViewFCMhint, 51);
      var0.put(R.id.textViewFCM, 52);
      var0.put(R.id.textViewIMAhint, 53);
      var0.put(R.id.textViewIAM, 54);
      var0.put(R.id.separator_welcome_home, 55);
      var0.put(R.id.welcome_home_title, 56);
      var0.put(R.id.welcome_home_device_spinner, 57);
      var0.put(R.id.welcome_home_is_min_radius, 58);
      var0.put(R.id.welcome_home_is_enter, 59);
      var0.put(R.id.welcome_home_test_btn, 60);
      var0.put(R.id.separator_notification, 61);
      var0.put(R.id.notification_title, 62);
      var0.put(R.id.revoke_dismission, 63);
      var0.put(R.id.notification_intermittent, 64);
      var0.put(R.id.et_intermittent, 65);
      var0.put(R.id.notification_continuous, 66);
      var0.put(R.id.et_continuous, 67);
      var0.put(R.id.btn_saveAqiThresold, 68);
   }

   public ActivityDevSettingsBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 69, sIncludes, sViewsWithIds));
   }

   private ActivityDevSettingsBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (TextView)var3[3], (MaterialButton)var3[68], (MaterialButton)var3[47], (CheckBox)var3[21], (CheckBox)var3[15], (CheckBox)var3[4], (CheckBox)var3[16], (CheckBox)var3[11], (CheckBox)var3[9], (CheckBox)var3[8], (CheckBox)var3[7], (CheckBox)var3[13], (CheckBox)var3[10], (CheckBox)var3[12], (CheckBox)var3[14], (CheckBox)var3[20], (CheckBox)var3[17], (CheckBox)var3[24], (CheckBox)var3[6], (CheckBox)var3[19], (CheckBox)var3[25], (CheckBox)var3[23], (CheckBox)var3[5], (CheckBox)var3[18], (EditText)var3[46], (EditText)var3[44], (EditText)var3[67], (EditText)var3[65], (MaterialButton)var3[29], (MaterialButton)var3[41], (MaterialButton)var3[31], (MaterialButton)var3[40], (MaterialButton)var3[42], (MaterialButton)var3[30], (MaterialButton)var3[32], (TextView)var3[34], (TextView)var3[45], (TextView)var3[43], (ConstraintLayout)var3[2], (TextView)var3[35], (TextView)var3[66], (TextView)var3[64], (TextView)var3[62], (MaterialButton)var3[36], (MaterialButton)var3[28], (Button)var3[63], (MaterialButton)var3[26], (View)var3[33], (View)var3[61], (View)var3[55], (MaterialButton)var3[48], (MaterialButton)var3[39], (MaterialButton)var3[38], (MaterialButton)var3[37], (MaterialButton)var3[27], (TextView)var3[50], (TextView)var3[49], (TextView)var3[52], (TextView)var3[51], (TextView)var3[54], (TextView)var3[53], (Toolbar)var3[1], (CheckBox)var3[22], (Spinner)var3[57], (CheckBox)var3[59], (CheckBox)var3[58], (Button)var3[60], (TextView)var3[56]);
      this.mDirtyFlags = -1L;
      CoordinatorLayout var4 = (CoordinatorLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   protected void executeBindings() {
      // $FF: Couldn't be decompiled
   }

   public boolean hasPendingBindings() {
      synchronized(this){}

      Throwable var10000;
      label123: {
         try {
            if (this.mDirtyFlags != 0L) {
               return true;
            }
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var10001 = false;
            break label123;
         }

         label117:
         try {
            return false;
         } catch (Throwable var12) {
            var10000 = var12;
            boolean var14 = false;
            break label117;
         }
      }

      while(true) {
         Throwable var1 = var10000;

         try {
            throw var1;
         } catch (Throwable var11) {
            var10000 = var11;
            boolean var15 = false;
            continue;
         }
      }
   }

   public void invalidateAll() {
      // $FF: Couldn't be decompiled
   }

   protected boolean onFieldChange(int var1, Object var2, int var3) {
      return false;
   }

   public boolean setVariable(int var1, Object var2) {
      return true;
   }
}
