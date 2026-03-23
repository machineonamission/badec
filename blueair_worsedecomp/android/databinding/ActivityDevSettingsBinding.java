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
    public final Spinner welcomeHomeDeviceSpinner;
    public final CheckBox welcomeHomeIsEnter;
    public final CheckBox welcomeHomeIsMinRadius;
    public final Button welcomeHomeTestBtn;
    public final TextView welcomeHomeTitle;

    protected ActivityDevSettingsBinding(Object obj, View view, int i, TextView textView, MaterialButton materialButton, MaterialButton materialButton2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, CheckBox checkBox11, CheckBox checkBox12, CheckBox checkBox13, CheckBox checkBox14, CheckBox checkBox15, CheckBox checkBox16, CheckBox checkBox17, CheckBox checkBox18, CheckBox checkBox19, CheckBox checkBox20, CheckBox checkBox21, EditText editText, EditText editText2, EditText editText3, EditText editText4, MaterialButton materialButton3, MaterialButton materialButton4, MaterialButton materialButton5, MaterialButton materialButton6, MaterialButton materialButton7, MaterialButton materialButton8, MaterialButton materialButton9, TextView textView2, TextView textView3, TextView textView4, ConstraintLayout constraintLayout, TextView textView5, TextView textView6, TextView textView7, TextView textView8, MaterialButton materialButton10, MaterialButton materialButton11, Button button, MaterialButton materialButton12, View view2, View view3, View view4, MaterialButton materialButton13, MaterialButton materialButton14, MaterialButton materialButton15, MaterialButton materialButton16, MaterialButton materialButton17, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, Toolbar toolbar2, Spinner spinner, CheckBox checkBox22, CheckBox checkBox23, Button button2, TextView textView15) {
        super(obj, view, i);
        this.appBuildInfo = textView;
        this.btnSaveAqiThresold = materialButton;
        this.buttonSaveUrl = materialButton2;
        this.checkAlexaDev = checkBox;
        this.checkAmplitudeDebug = checkBox2;
        this.checkChina = checkBox3;
        this.checkFacebookLogin = checkBox4;
        this.checkForceAlexa = checkBox5;
        this.checkForceAware = checkBox6;
        this.checkForceB4 = checkBox7;
        this.checkForceG4 = checkBox8;
        this.checkForceGAssistant = checkBox9;
        this.checkForceIcp = checkBox10;
        this.checkForceTmall = checkBox11;
        this.checkForceWelcomeHome = checkBox12;
        this.checkGoogleDev = checkBox13;
        this.checkGoogleLogin = checkBox14;
        this.checkKlaviyoDev = checkBox15;
        this.checkKorea = checkBox16;
        this.checkLokalisePreRelease = checkBox17;
        this.checkShowDetectCat = checkBox18;
        this.checkUAT = checkBox19;
        this.checkUSA = checkBox20;
        this.checkWeChatQQApple = checkBox21;
        this.editBrokerBaseURL = editText;
        this.editTextBaseUrl = editText2;
        this.etContinuous = editText3;
        this.etIntermittent = editText4;
        this.forceCrash = materialButton3;
        this.forceQa = materialButton4;
        this.forceRateUs = materialButton5;
        this.forceRelease = materialButton6;
        this.forceReset = materialButton7;
        this.forceUpdate = materialButton8;
        this.forceWelcomeHomeIntro = materialButton9;
        this.gigyaUserRegion = textView2;
        this.labelBrokerBaseURL = textView3;
        this.labelTextBaseUrl = textView4;
        this.layoutMain = constraintLayout;
        this.legacyHomehost = textView5;
        this.notificationContinuous = textView6;
        this.notificationIntermittent = textView7;
        this.notificationTitle = textView8;
        this.resetHomehost = materialButton10;
        this.resetUserInfoSyncTime = materialButton11;
        this.revokeDismission = button;
        this.sendLogs = materialButton12;
        this.separatorApi = view2;
        this.separatorNotification = view3;
        this.separatorWelcomeHome = view4;
        this.setGigyaToken = materialButton13;
        this.setUrlCn = materialButton14;
        this.setUrlEu = materialButton15;
        this.setUrlUs = materialButton16;
        this.showNotification = materialButton17;
        this.textViewAPI = textView9;
        this.textViewAPIhint = textView10;
        this.textViewFCM = textView11;
        this.textViewFCMhint = textView12;
        this.textViewIAM = textView13;
        this.textViewIMAhint = textView14;
        this.toolbar = toolbar2;
        this.welcomeHomeDeviceSpinner = spinner;
        this.welcomeHomeIsEnter = checkBox22;
        this.welcomeHomeIsMinRadius = checkBox23;
        this.welcomeHomeTestBtn = button2;
        this.welcomeHomeTitle = textView15;
    }

    public static ActivityDevSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDevSettingsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityDevSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_dev_settings, viewGroup, z, obj);
    }

    public static ActivityDevSettingsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDevSettingsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityDevSettingsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_dev_settings, (ViewGroup) null, false, obj);
    }

    public static ActivityDevSettingsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDevSettingsBinding bind(View view, Object obj) {
        return (ActivityDevSettingsBinding) bind(obj, view, R.layout.activity_dev_settings);
    }
}
