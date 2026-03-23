package com.blueair.login;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.view.ProgressBlockerView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0017J\u0015\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/blueair/login/LoginActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "loading", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "kotlin.jvm.PlatformType", "getLoading", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "loading$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "renderLoading", "show", "", "(Ljava/lang/Boolean;)V", "renderFailure", "failure", "Lcom/blueair/login/LoginFailure;", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LoginActivity.kt */
public final class LoginActivity extends BaseActivity {
    private String _screenName;
    private final Lazy loading$delegate = LazyKt.lazy(new LoginActivity$$ExternalSyntheticLambda0(this));

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
    }

    private final ProgressBlockerView getLoading() {
        return (ProgressBlockerView) this.loading$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ProgressBlockerView loading_delegate$lambda$0(LoginActivity loginActivity) {
        return (ProgressBlockerView) loginActivity.findViewById(R.id.loading);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        String stringExtra = getIntent().getStringExtra("action_type");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        if (Intrinsics.areEqual((Object) stringExtra, (Object) Actions.ACTION_REGISTER)) {
            this._screenName = AnalyticEvent.ScreenViewEvent.REGISTER;
            beginTransaction.replace(R.id.fragmentContainer, new RegisterFragment());
        } else {
            this._screenName = "login";
            beginTransaction.replace(R.id.fragmentContainer, new SignInFragment());
        }
        beginTransaction.commit();
    }

    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    public final void renderLoading(Boolean bool) {
        ProgressBlockerView loading = getLoading();
        Intrinsics.checkNotNullExpressionValue(loading, "<get-loading>(...)");
        ViewExtensionsKt.show(loading, bool != null ? bool.booleanValue() : false);
    }

    public final void renderFailure(LoginFailure loginFailure) {
        Integer textResourceId;
        if (loginFailure != null && (textResourceId = loginFailure.getTextResourceId()) != null) {
            ViewUtils.INSTANCE.showSnackbar((Activity) this, textResourceId.intValue(), (ViewUtils.MessageType) ViewUtils.MessageType.ERROR.INSTANCE);
        }
    }
}
