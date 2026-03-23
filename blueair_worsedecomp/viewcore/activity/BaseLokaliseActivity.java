package com.blueair.viewcore.activity;

import android.content.Context;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.blueair.sdk.LokaliseSdk;
import com.blueair.viewcore.dialog.DialogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0004J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000e¨\u0006\u0013"}, d2 = {"Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onResume", "immersiveStatusBar", "withNavigationBar", "", "setStatusBarColor", "color", "", "lightMode", "(ILjava/lang/Boolean;)V", "setStatusMode", "getStatusBarHeight", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLokaliseActivity.kt */
public abstract class BaseLokaliseActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "newBase");
        super.attachBaseContext(LokaliseSdk.INSTANCE.wrapContext(context));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        DialogUtils.INSTANCE.hideRequestPermissionHints();
    }

    public static /* synthetic */ void immersiveStatusBar$default(BaseLokaliseActivity baseLokaliseActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseLokaliseActivity.immersiveStatusBar(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: immersiveStatusBar");
    }

    /* access modifiers changed from: protected */
    public final void immersiveStatusBar(boolean z) {
        getWindow().clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(0);
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        int i = systemUiVisibility | 1280;
        if (z) {
            i = systemUiVisibility | 1792;
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
    }

    public static /* synthetic */ void setStatusBarColor$default(BaseLokaliseActivity baseLokaliseActivity, int i, Boolean bool, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bool = null;
            }
            baseLokaliseActivity.setStatusBarColor(i, bool);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusBarColor");
    }

    public final void setStatusBarColor(int i, Boolean bool) {
        if (bool != null) {
            setStatusMode(bool.booleanValue());
        }
        getWindow().setStatusBarColor(i);
    }

    public static /* synthetic */ void setStatusMode$default(BaseLokaliseActivity baseLokaliseActivity, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            baseLokaliseActivity.setStatusMode(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusMode");
    }

    public final void setStatusMode(boolean z) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & -8193);
    }

    public final int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
    }
}
