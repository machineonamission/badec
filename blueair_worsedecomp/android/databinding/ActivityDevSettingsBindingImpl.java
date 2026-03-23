package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;

public class ActivityDevSettingsBindingImpl extends ActivityDevSettingsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CoordinatorLayout mboundView0;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 1);
        sparseIntArray.put(R.id.layoutMain, 2);
        sparseIntArray.put(R.id.app_build_info, 3);
        sparseIntArray.put(R.id.checkChina, 4);
        sparseIntArray.put(R.id.checkUSA, 5);
        sparseIntArray.put(R.id.checkKorea, 6);
        sparseIntArray.put(R.id.checkForceG4, 7);
        sparseIntArray.put(R.id.checkForceB4, 8);
        sparseIntArray.put(R.id.checkForceAware, 9);
        sparseIntArray.put(R.id.checkForceIcp, 10);
        sparseIntArray.put(R.id.checkForceAlexa, 11);
        sparseIntArray.put(R.id.checkForceTmall, 12);
        sparseIntArray.put(R.id.checkForceGAssistant, 13);
        sparseIntArray.put(R.id.checkForceWelcomeHome, 14);
        sparseIntArray.put(R.id.checkAmplitudeDebug, 15);
        sparseIntArray.put(R.id.checkFacebookLogin, 16);
        sparseIntArray.put(R.id.checkGoogleLogin, 17);
        sparseIntArray.put(R.id.checkWeChatQQApple, 18);
        sparseIntArray.put(R.id.checkLokalisePreRelease, 19);
        sparseIntArray.put(R.id.checkGoogleDev, 20);
        sparseIntArray.put(R.id.checkAlexaDev, 21);
        sparseIntArray.put(R.id.checkUAT, 22);
        sparseIntArray.put(R.id.checkKlaviyoDev, 23);
        sparseIntArray.put(R.id.checkShowDetectCat, 24);
        sparseIntArray.put(R.id.sendLogs, 25);
        sparseIntArray.put(R.id.show_notification, 26);
        sparseIntArray.put(R.id.resetUserInfoSyncTime, 27);
        sparseIntArray.put(R.id.force_crash, 28);
        sparseIntArray.put(R.id.forceUpdate, 29);
        sparseIntArray.put(R.id.forceRateUs, 30);
        sparseIntArray.put(R.id.forceWelcomeHomeIntro, 31);
        sparseIntArray.put(R.id.separator_api, 32);
        sparseIntArray.put(R.id.gigya_user_region, 33);
        sparseIntArray.put(R.id.legacy_homehost, 34);
        sparseIntArray.put(R.id.reset_homehost, 35);
        sparseIntArray.put(R.id.set_url_us, 36);
        sparseIntArray.put(R.id.set_url_eu, 37);
        sparseIntArray.put(R.id.set_url_cn, 38);
        sparseIntArray.put(R.id.force_release, 39);
        sparseIntArray.put(R.id.force_qa, 40);
        sparseIntArray.put(R.id.force_reset, 41);
        sparseIntArray.put(R.id.labelTextBaseUrl, 42);
        sparseIntArray.put(R.id.editTextBaseUrl, 43);
        sparseIntArray.put(R.id.labelBrokerBaseURL, 44);
        sparseIntArray.put(R.id.editBrokerBaseURL, 45);
        sparseIntArray.put(R.id.buttonSaveUrl, 46);
        sparseIntArray.put(R.id.set_gigya_token, 47);
        sparseIntArray.put(R.id.textViewAPIhint, 48);
        sparseIntArray.put(R.id.textViewAPI, 49);
        sparseIntArray.put(R.id.textViewFCMhint, 50);
        sparseIntArray.put(R.id.textViewFCM, 51);
        sparseIntArray.put(R.id.textViewIMAhint, 52);
        sparseIntArray.put(R.id.textViewIAM, 53);
        sparseIntArray.put(R.id.separator_welcome_home, 54);
        sparseIntArray.put(R.id.welcome_home_title, 55);
        sparseIntArray.put(R.id.welcome_home_device_spinner, 56);
        sparseIntArray.put(R.id.welcome_home_is_min_radius, 57);
        sparseIntArray.put(R.id.welcome_home_is_enter, 58);
        sparseIntArray.put(R.id.welcome_home_test_btn, 59);
        sparseIntArray.put(R.id.separator_notification, 60);
        sparseIntArray.put(R.id.notification_title, 61);
        sparseIntArray.put(R.id.revoke_dismission, 62);
        sparseIntArray.put(R.id.notification_intermittent, 63);
        sparseIntArray.put(R.id.et_intermittent, 64);
        sparseIntArray.put(R.id.notification_continuous, 65);
        sparseIntArray.put(R.id.et_continuous, 66);
        sparseIntArray.put(R.id.btn_saveAqiThresold, 67);
    }

    public ActivityDevSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 68, sIncludes, sViewsWithIds));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private ActivityDevSettingsBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[3], objArr[67], objArr[46], objArr[21], objArr[15], objArr[4], objArr[16], objArr[11], objArr[9], objArr[8], objArr[7], objArr[13], objArr[10], objArr[12], objArr[14], objArr[20], objArr[17], objArr[23], objArr[6], objArr[19], objArr[24], objArr[22], objArr[5], objArr[18], objArr[45], objArr[43], objArr[66], objArr[64], objArr[28], objArr[40], objArr[30], objArr[39], objArr[41], objArr[29], objArr[31], objArr[33], objArr[44], objArr[42], objArr[2], objArr[34], objArr[65], objArr[63], objArr[61], objArr[35], objArr[27], objArr[62], objArr[25], objArr[32], objArr[60], objArr[54], objArr[47], objArr[38], objArr[37], objArr[36], objArr[26], objArr[49], objArr[48], objArr[51], objArr[50], objArr[53], objArr[52], objArr[1], objArr[56], objArr[58], objArr[57], objArr[59], objArr[55]);
        this.mDirtyFlags = -1;
        CoordinatorLayout coordinatorLayout = objArr[0];
        this.mboundView0 = coordinatorLayout;
        coordinatorLayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0;
        }
    }
}
