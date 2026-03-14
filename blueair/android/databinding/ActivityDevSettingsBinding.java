package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public abstract class ActivityDevSettingsBinding extends ViewDataBinding {
   public final TextView appBuildInfo;
   public final MaterialButton btnSaveAqiThresold;
   public final MaterialButton buttonSaveUrl;
   public final CheckBox checkAlexaDev;
   public final CheckBox checkAmplitudeDebug;
   public final CheckBox checkChina;
   public final CheckBox checkFacebookLogin;
   public final CheckBox checkForceAlexa;
   public final CheckBox checkForceAware;
   public final CheckBox checkForceB4;
   public final CheckBox checkForceG4;
   public final CheckBox checkForceGAssistant;
   public final CheckBox checkForceIcp;
   public final CheckBox checkForceTmall;
   public final CheckBox checkForceWelcomeHome;
   public final CheckBox checkGoogleDev;
   public final CheckBox checkGoogleLogin;
   public final CheckBox checkKlaviyoDev;
   public final CheckBox checkKorea;
   public final CheckBox checkLokalisePreRelease;
   public final CheckBox checkShowDetectCat;
   public final CheckBox checkUAT;
   public final CheckBox checkUSA;
   public final CheckBox checkWeChatQQApple;
   public final EditText editBrokerBaseURL;
   public final EditText editTextBaseUrl;
   public final EditText etContinuous;
   public final EditText etIntermittent;
   public final MaterialButton forceCrash;
   public final MaterialButton forceQa;
   public final MaterialButton forceRateUs;
   public final MaterialButton forceRelease;
   public final MaterialButton forceReset;
   public final MaterialButton forceUpdate;
   public final MaterialButton forceWelcomeHomeIntro;
   public final TextView gigyaUserRegion;
   public final TextView labelBrokerBaseURL;
   public final TextView labelTextBaseUrl;
   public final ConstraintLayout layoutMain;
   public final TextView legacyHomehost;
   public final TextView notificationContinuous;
   public final TextView notificationIntermittent;
   public final TextView notificationTitle;
   public final MaterialButton resetHomehost;
   public final MaterialButton resetUserInfoSyncTime;
   public final Button revokeDismission;
   public final MaterialButton sendLogs;
   public final View separatorApi;
   public final View separatorNotification;
   public final View separatorWelcomeHome;
   public final MaterialButton setGigyaToken;
   public final MaterialButton setUrlCn;
   public final MaterialButton setUrlEu;
   public final MaterialButton setUrlUs;
   public final MaterialButton showNotification;
   public final TextView textViewAPI;
   public final TextView textViewAPIhint;
   public final TextView textViewFCM;
   public final TextView textViewFCMhint;
   public final TextView textViewIAM;
   public final TextView textViewIMAhint;
   public final Toolbar toolbar;
   public final CheckBox useGigyaSandbox;
   public final Spinner welcomeHomeDeviceSpinner;
   public final CheckBox welcomeHomeIsEnter;
   public final CheckBox welcomeHomeIsMinRadius;
   public final Button welcomeHomeTestBtn;
   public final TextView welcomeHomeTitle;

   protected ActivityDevSettingsBinding(Object var1, View var2, int var3, TextView var4, MaterialButton var5, MaterialButton var6, CheckBox var7, CheckBox var8, CheckBox var9, CheckBox var10, CheckBox var11, CheckBox var12, CheckBox var13, CheckBox var14, CheckBox var15, CheckBox var16, CheckBox var17, CheckBox var18, CheckBox var19, CheckBox var20, CheckBox var21, CheckBox var22, CheckBox var23, CheckBox var24, CheckBox var25, CheckBox var26, CheckBox var27, EditText var28, EditText var29, EditText var30, EditText var31, MaterialButton var32, MaterialButton var33, MaterialButton var34, MaterialButton var35, MaterialButton var36, MaterialButton var37, MaterialButton var38, TextView var39, TextView var40, TextView var41, ConstraintLayout var42, TextView var43, TextView var44, TextView var45, TextView var46, MaterialButton var47, MaterialButton var48, Button var49, MaterialButton var50, View var51, View var52, View var53, MaterialButton var54, MaterialButton var55, MaterialButton var56, MaterialButton var57, MaterialButton var58, TextView var59, TextView var60, TextView var61, TextView var62, TextView var63, TextView var64, Toolbar var65, CheckBox var66, Spinner var67, CheckBox var68, CheckBox var69, Button var70, TextView var71) {
      super(var1, var2, var3);
      this.appBuildInfo = var4;
      this.btnSaveAqiThresold = var5;
      this.buttonSaveUrl = var6;
      this.checkAlexaDev = var7;
      this.checkAmplitudeDebug = var8;
      this.checkChina = var9;
      this.checkFacebookLogin = var10;
      this.checkForceAlexa = var11;
      this.checkForceAware = var12;
      this.checkForceB4 = var13;
      this.checkForceG4 = var14;
      this.checkForceGAssistant = var15;
      this.checkForceIcp = var16;
      this.checkForceTmall = var17;
      this.checkForceWelcomeHome = var18;
      this.checkGoogleDev = var19;
      this.checkGoogleLogin = var20;
      this.checkKlaviyoDev = var21;
      this.checkKorea = var22;
      this.checkLokalisePreRelease = var23;
      this.checkShowDetectCat = var24;
      this.checkUAT = var25;
      this.checkUSA = var26;
      this.checkWeChatQQApple = var27;
      this.editBrokerBaseURL = var28;
      this.editTextBaseUrl = var29;
      this.etContinuous = var30;
      this.etIntermittent = var31;
      this.forceCrash = var32;
      this.forceQa = var33;
      this.forceRateUs = var34;
      this.forceRelease = var35;
      this.forceReset = var36;
      this.forceUpdate = var37;
      this.forceWelcomeHomeIntro = var38;
      this.gigyaUserRegion = var39;
      this.labelBrokerBaseURL = var40;
      this.labelTextBaseUrl = var41;
      this.layoutMain = var42;
      this.legacyHomehost = var43;
      this.notificationContinuous = var44;
      this.notificationIntermittent = var45;
      this.notificationTitle = var46;
      this.resetHomehost = var47;
      this.resetUserInfoSyncTime = var48;
      this.revokeDismission = var49;
      this.sendLogs = var50;
      this.separatorApi = var51;
      this.separatorNotification = var52;
      this.separatorWelcomeHome = var53;
      this.setGigyaToken = var54;
      this.setUrlCn = var55;
      this.setUrlEu = var56;
      this.setUrlUs = var57;
      this.showNotification = var58;
      this.textViewAPI = var59;
      this.textViewAPIhint = var60;
      this.textViewFCM = var61;
      this.textViewFCMhint = var62;
      this.textViewIAM = var63;
      this.textViewIMAhint = var64;
      this.toolbar = var65;
      this.useGigyaSandbox = var66;
      this.welcomeHomeDeviceSpinner = var67;
      this.welcomeHomeIsEnter = var68;
      this.welcomeHomeIsMinRadius = var69;
      this.welcomeHomeTestBtn = var70;
      this.welcomeHomeTitle = var71;
   }

   public static ActivityDevSettingsBinding bind(View var0) {
      return bind(var0, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDevSettingsBinding bind(View var0, Object var1) {
      return (ActivityDevSettingsBinding)bind(var1, var0, R.layout.activity_dev_settings);
   }

   public static ActivityDevSettingsBinding inflate(LayoutInflater var0) {
      return inflate(var0, DataBindingUtil.getDefaultComponent());
   }

   public static ActivityDevSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      return inflate(var0, var1, var2, DataBindingUtil.getDefaultComponent());
   }

   @Deprecated
   public static ActivityDevSettingsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2, Object var3) {
      return (ActivityDevSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_dev_settings, var1, var2, var3);
   }

   @Deprecated
   public static ActivityDevSettingsBinding inflate(LayoutInflater var0, Object var1) {
      return (ActivityDevSettingsBinding)ViewDataBinding.inflateInternal(var0, R.layout.activity_dev_settings, (ViewGroup)null, false, var1);
   }
}
