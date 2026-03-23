package com.blueair.login;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.blueair.login.databinding.ActivityPostDeleteAccountBinding;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/blueair/login/PostDeleteAccountActivity;", "Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "<init>", "()V", "onBackPressedCallback", "com/blueair/login/PostDeleteAccountActivity$onBackPressedCallback$1", "Lcom/blueair/login/PostDeleteAccountActivity$onBackPressedCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onClose", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PostDeleteAccountActivity.kt */
public final class PostDeleteAccountActivity extends BaseLokaliseActivity {
    private final PostDeleteAccountActivity$onBackPressedCallback$1 onBackPressedCallback = new PostDeleteAccountActivity$onBackPressedCallback$1(this);

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityPostDeleteAccountBinding activityPostDeleteAccountBinding = (ActivityPostDeleteAccountBinding) DataBindingUtil.setContentView(this, R.layout.activity_post_delete_account);
        activityPostDeleteAccountBinding.btnClose.setOnClickListener(new PostDeleteAccountActivity$$ExternalSyntheticLambda0(this));
        activityPostDeleteAccountBinding.btnOkay.setOnClickListener(new PostDeleteAccountActivity$$ExternalSyntheticLambda1(this));
        getOnBackPressedDispatcher().addCallback(this.onBackPressedCallback);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(PostDeleteAccountActivity postDeleteAccountActivity, View view) {
        postDeleteAccountActivity.onClose();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(PostDeleteAccountActivity postDeleteAccountActivity, View view) {
        postDeleteAccountActivity.onClose();
    }

    /* access modifiers changed from: private */
    public final void onClose() {
        finish();
        startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    }
}
