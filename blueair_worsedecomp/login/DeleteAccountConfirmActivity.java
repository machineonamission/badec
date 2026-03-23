package com.blueair.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.util.LinkUtils;
import com.blueair.login.databinding.ActivityDeleteAccountConfirmBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0014\u0010\f\u001a\u00020\t*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/blueair/login/DeleteAccountConfirmActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setNoticeText", "Landroid/widget/TextView;", "country", "onDeletionFailed", "onAccountDeleted", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeleteAccountConfirmActivity.kt */
public final class DeleteAccountConfirmActivity extends BaseActivity {
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_PROFILE_DELETE_ACCOUNT;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DeleteAccountConfirmViewModel deleteAccountConfirmViewModel = (DeleteAccountConfirmViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeleteAccountConfirmViewModel.class);
        ActivityDeleteAccountConfirmBinding activityDeleteAccountConfirmBinding = (ActivityDeleteAccountConfirmBinding) DataBindingUtil.setContentView(this, R.layout.activity_delete_account_confirm);
        activityDeleteAccountConfirmBinding.btnClose.setOnClickListener(new DeleteAccountConfirmActivity$$ExternalSyntheticLambda0(this));
        activityDeleteAccountConfirmBinding.btnDelete.setOnClickListener(new DeleteAccountConfirmActivity$$ExternalSyntheticLambda1(this));
        LifecycleOwner lifecycleOwner = this;
        FlowKt.launchIn(FlowKt.onEach(deleteAccountConfirmViewModel.getState(), new DeleteAccountConfirmActivity$onCreate$1$3(activityDeleteAccountConfirmBinding, this, (Continuation<? super DeleteAccountConfirmActivity$onCreate$1$3>) null)), LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
        getSupportFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, lifecycleOwner, new DeleteAccountConfirmActivity$$ExternalSyntheticLambda2(deleteAccountConfirmViewModel));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(DeleteAccountConfirmActivity deleteAccountConfirmActivity, View view) {
        deleteAccountConfirmActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(DeleteAccountConfirmActivity deleteAccountConfirmActivity, View view) {
        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(R.string.confirmation_dialog_title_delete_account), Integer.valueOf(R.string.confirmation_dialog_text_delete_account), R.string.delete, Integer.valueOf(R.string.btn_cancel), true, true, false, (String[]) null, 192, (Object) null).show(deleteAccountConfirmActivity.getSupportFragmentManager(), DeleteAccountConfirmActivity.class.getName());
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(DeleteAccountConfirmViewModel deleteAccountConfirmViewModel, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            deleteAccountConfirmViewModel.deleteAccount();
        }
    }

    /* access modifiers changed from: private */
    public final void setNoticeText(TextView textView, String str) {
        String string = getString(R.string.notice_delete_account_link, new Object[]{LinkUtils.INSTANCE.getPrivacyLinkFromCountryCode(str)});
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(HtmlCompat.fromHtml(string, 0));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* access modifiers changed from: private */
    public final void onDeletionFailed() {
        Toast.makeText(this, R.string.toast_delete_account_failed, 0).show();
    }

    /* access modifiers changed from: private */
    public final void onAccountDeleted() {
        finishAffinity();
        startActivity(new Intent(this, PostDeleteAccountActivity.class));
    }
}
