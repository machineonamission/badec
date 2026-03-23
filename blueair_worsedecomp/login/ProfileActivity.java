package com.blueair.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.adddevice.service.AddDeviceService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.login.databinding.ActivityProfileBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0017\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/blueair/login/ProfileActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "Lcom/blueair/login/ProfileViewModel;", "getViewModel", "()Lcom/blueair/login/ProfileViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "renderSuccess", "unit", "(Lkotlin/Unit;)V", "renderFailure", "msg", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileActivity.kt */
public final class ProfileActivity extends BaseActivity {
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_PROFILE;
    private final Lazy viewModel$delegate;

    public ProfileActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new ProfileActivity$special$$inlined$viewModels$default$2(componentActivity), new ProfileActivity$special$$inlined$viewModels$default$1(componentActivity), new ProfileActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final ProfileViewModel getViewModel() {
        return (ProfileViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityProfileBinding activityProfileBinding = (ActivityProfileBinding) DataBindingUtil.setContentView(this, R.layout.activity_profile);
        LifecycleOwner lifecycleOwner = this;
        activityProfileBinding.setLifecycleOwner(lifecycleOwner);
        activityProfileBinding.setVariable(BR.viewModel, getViewModel());
        activityProfileBinding.btnClose.setOnClickListener(new ProfileActivity$$ExternalSyntheticLambda0(this));
        activityProfileBinding.btnManageMyAccount.setOnClickListener(new ProfileActivity$$ExternalSyntheticLambda1(this));
        ProfileViewModel viewModel = getViewModel();
        BaseLoginViewModelKt.observe(lifecycleOwner, viewModel.getSuccess(), new ProfileActivity$onCreate$2$1(this));
        BaseLoginViewModelKt.observe(lifecycleOwner, viewModel.getFailure(), new ProfileActivity$onCreate$2$2(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(ProfileActivity profileActivity, View view) {
        profileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(ProfileActivity profileActivity, View view) {
        profileActivity.startActivity(new Intent(profileActivity, ManageMyAccountActivity.class));
    }

    /* access modifiers changed from: private */
    public final void renderSuccess(Unit unit) {
        if (unit != null) {
            ViewUtils.INSTANCE.showSnackbar((Activity) this, R.string.msg_update_profile_success, (ViewUtils.MessageType) ViewUtils.MessageType.SUCCESS.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public final void renderFailure(String str) {
        String str2 = Intrinsics.areEqual((Object) str, (Object) "400106") ? "Please check your internet connection" : str == null ? null : AddDeviceService.USER_FRIENDLY_MIGRATION_OTA_FAILURE_MSG;
        if (str2 != null) {
            ViewUtils.INSTANCE.showSnackbar((Activity) this, str2, (ViewUtils.MessageType) ViewUtils.MessageType.ERROR.INSTANCE);
        }
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
