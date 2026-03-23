package com.blueair.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.blueair.android.databinding.ActivityWelcomeBinding;
import com.blueair.auth.AuthService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/blueair/android/activity/WelcomeActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityWelcomeBinding;", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "loginLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setWelcomeSpan", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeActivity.kt */
public final class WelcomeActivity extends BaseActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(WelcomeActivity.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))};
    public static final int $stable = 8;
    private final Lazy authService$delegate;
    private ActivityWelcomeBinding binding;
    private ActivityResultLauncher<Intent> loginLauncher;
    private final String screenName = AnalyticEvent.ScreenViewEvent.WELCOME;

    public WelcomeActivity() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new WelcomeActivity$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.authService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityWelcomeBinding inflate = ActivityWelcomeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityWelcomeBinding activityWelcomeBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        immersiveStatusBar(true);
        setWelcomeSpan();
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WelcomeActivity$$ExternalSyntheticLambda0(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.loginLauncher = registerForActivityResult;
        ActivityWelcomeBinding activityWelcomeBinding2 = this.binding;
        if (activityWelcomeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeBinding2 = null;
        }
        activityWelcomeBinding2.btnLogin.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda1(this));
        ActivityWelcomeBinding activityWelcomeBinding3 = this.binding;
        if (activityWelcomeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWelcomeBinding = activityWelcomeBinding3;
        }
        activityWelcomeBinding.btnRegister.setOnClickListener(new WelcomeActivity$$ExternalSyntheticLambda2(this));
        if (getAuthService().isUserLoggedIn().getValue().booleanValue()) {
            startActivity(Actions.INSTANCE.openHomeIntent(this));
            finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(WelcomeActivity welcomeActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            welcomeActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(WelcomeActivity welcomeActivity, View view) {
        ActivityResultLauncher<Intent> activityResultLauncher = welcomeActivity.loginLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(Actions.openLoginIntent$default(Actions.INSTANCE, welcomeActivity, (String) null, 2, (Object) null));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2(WelcomeActivity welcomeActivity, View view) {
        ActivityResultLauncher<Intent> activityResultLauncher = welcomeActivity.loginLauncher;
        if (activityResultLauncher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginLauncher");
            activityResultLauncher = null;
        }
        activityResultLauncher.launch(Actions.INSTANCE.openLoginIntent(welcomeActivity, Actions.ACTION_REGISTER));
    }

    private final void setWelcomeSpan() {
        ActivityWelcomeBinding activityWelcomeBinding = this.binding;
        ActivityWelcomeBinding activityWelcomeBinding2 = null;
        if (activityWelcomeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeBinding = null;
        }
        CharSequence text = activityWelcomeBinding.txtWelcomeMsg.getText();
        Intrinsics.checkNotNull(text);
        if (text.length() > 0) {
            SpannableString spannableString = new SpannableString(text);
            CharSequence charSequence = spannableString;
            int indexOf$default = StringsKt.indexOf$default(charSequence, IOUtils.LINE_SEPARATOR_UNIX, 0, false, 6, (Object) null);
            if (indexOf$default > 0) {
                spannableString.setSpan(new ForegroundColorSpan(-1), 0, indexOf$default, 33);
                ActivityWelcomeBinding activityWelcomeBinding3 = this.binding;
                if (activityWelcomeBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    activityWelcomeBinding2 = activityWelcomeBinding3;
                }
                activityWelcomeBinding2.txtWelcomeMsg.setText(charSequence);
            }
        }
    }
}
