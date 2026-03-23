package com.blueair.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.login.databinding.ActivityDisableIotConfirmBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/blueair/login/DisableIoTConfirmActivity;", "Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDisablingFailed", "onIoTDisabled", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DisableIoTConfirmActivity.kt */
public final class DisableIoTConfirmActivity extends BaseLokaliseActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DisableIoTConfirmViewModel disableIoTConfirmViewModel = (DisableIoTConfirmViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DisableIoTConfirmViewModel.class);
        ActivityDisableIotConfirmBinding activityDisableIotConfirmBinding = (ActivityDisableIotConfirmBinding) DataBindingUtil.setContentView(this, R.layout.activity_disable_iot_confirm);
        activityDisableIotConfirmBinding.btnClose.setOnClickListener(new DisableIoTConfirmActivity$$ExternalSyntheticLambda0(this));
        activityDisableIotConfirmBinding.btnDelete.setOnClickListener(new DisableIoTConfirmActivity$$ExternalSyntheticLambda1(this));
        LifecycleOwner lifecycleOwner = this;
        FlowKt.launchIn(FlowKt.onEach(disableIoTConfirmViewModel.getState(), new DisableIoTConfirmActivity$onCreate$1$3(activityDisableIotConfirmBinding, this, (Continuation<? super DisableIoTConfirmActivity$onCreate$1$3>) null)), LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
        getSupportFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, lifecycleOwner, new DisableIoTConfirmActivity$$ExternalSyntheticLambda2(disableIoTConfirmViewModel));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(DisableIoTConfirmActivity disableIoTConfirmActivity, View view) {
        disableIoTConfirmActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(DisableIoTConfirmActivity disableIoTConfirmActivity, View view) {
        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.confirmation_dialog_title_delete_account), Integer.valueOf(R.string.confirmation_dialog_text_disable_iot), R.string.delete, Integer.valueOf(R.string.btn_cancel), true, true, false, (String[]) null, 192, (Object) null).show(disableIoTConfirmActivity.getSupportFragmentManager(), DisableIoTConfirmActivity.class.getName());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(DisableIoTConfirmViewModel disableIoTConfirmViewModel, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            disableIoTConfirmViewModel.disableIoT();
        }
    }

    /* access modifiers changed from: private */
    public final void onDisablingFailed() {
        Toast.makeText(this, R.string.toast_disable_iot_failed, 0).show();
    }

    /* access modifiers changed from: private */
    public final void onIoTDisabled() {
        finishAffinity();
        startActivity(new Intent(this, PostDisableIoTActivity.class));
    }
}
