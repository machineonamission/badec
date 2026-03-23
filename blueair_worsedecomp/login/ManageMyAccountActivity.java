package com.blueair.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.databinding.DataBindingUtil;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.login.databinding.ActivityManageMyAccountBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/blueair/login/ManageMyAccountActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ManageMyAccountActivity.kt */
public final class ManageMyAccountActivity extends BaseActivity {
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_PROFILE_MANAGE_ACCOUNT;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityManageMyAccountBinding activityManageMyAccountBinding = (ActivityManageMyAccountBinding) DataBindingUtil.setContentView(this, R.layout.activity_manage_my_account);
        setSupportActionBar(activityManageMyAccountBinding.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setHomeActionContentDescription(R.string.home_as_up_content_description);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setDisplayShowTitleEnabled(false);
        }
        ActionBar supportActionBar5 = getSupportActionBar();
        if (supportActionBar5 != null) {
            supportActionBar5.setHomeButtonEnabled(true);
        }
        activityManageMyAccountBinding.deleteAccountCell.setOnClickListener(new ManageMyAccountActivity$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1$lambda$0(ManageMyAccountActivity manageMyAccountActivity, View view) {
        manageMyAccountActivity.startActivity(new Intent(manageMyAccountActivity, DeleteAccountConfirmActivity.class));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
