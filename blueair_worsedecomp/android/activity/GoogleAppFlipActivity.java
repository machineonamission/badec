package com.blueair.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.HtmlCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.R;
import com.blueair.android.databinding.ActivityGoogleAppFlipBinding;
import com.blueair.android.fragment.integration.Integration;
import com.blueair.android.viewmodel.AccountLinkingViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.LoginPendingAction;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0014J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J2\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u0012H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/blueair/android/activity/GoogleAppFlipActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityGoogleAppFlipBinding;", "viewModel", "Lcom/blueair/android/viewmodel/AccountLinkingViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "verifyFingerprint", "", "expectedPackage", "expectedFingerprint", "algorithm", "setSuccessResult", "authCode", "setErrorResult", "resultCode", "", "errorType", "errorCode", "errorMsg", "jumpToFailurePage", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GoogleAppFlipActivity.kt */
public final class GoogleAppFlipActivity extends BaseActivity {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public ActivityGoogleAppFlipBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.GOOGLE_APP_FLIP;
    private AccountLinkingViewModel viewModel;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_google_app_flip);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.binding = (ActivityGoogleAppFlipBinding) contentView;
        AccountLinkingViewModel accountLinkingViewModel = (AccountLinkingViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(AccountLinkingViewModel.class);
        this.viewModel = accountLinkingViewModel;
        if (accountLinkingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            accountLinkingViewModel = null;
        }
        accountLinkingViewModel.setAccountType(Integration.GoogleAssistant);
        AccountLinkingViewModel accountLinkingViewModel2 = this.viewModel;
        if (accountLinkingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            accountLinkingViewModel2 = null;
        }
        accountLinkingViewModel2.setGoogleLinkRequested(false);
        Bundle extras = getIntent().getExtras();
        Intrinsics.checkNotNull(extras);
        Timber.Forest.d("onCreate: " + getIntent() + ", " + extras.getString("CLIENT_ID") + ", " + extras.getStringArrayList("SCOPE") + ", " + extras.getString("REDIRECT_URI"), new Object[0]);
        String stringExtra = getIntent().getStringExtra("CLIENT_ID");
        AccountLinkingViewModel accountLinkingViewModel3 = this.viewModel;
        if (accountLinkingViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            accountLinkingViewModel3 = null;
        }
        if (!Intrinsics.areEqual((Object) stringExtra, (Object) accountLinkingViewModel3.getGoogleClientId())) {
            setErrorResult$default(this, -2, 2, 9, "INVALID_CLIENT", false, 16, (Object) null);
        } else if (!verifyFingerprint("com.google.android.googlequicksearchbox", "F0:FD:6C:5B:41:0F:25:CB:25:C3:B5:33:46:C8:97:2F:AE:30:F8:EE:74:11:DF:91:04:80:AD:6B:2D:60:DB:83", "SHA-256")) {
            setErrorResult$default(this, -2, 2, 8, "CLIENT_VERIFICATION_FAILED", false, 16, (Object) null);
        } else {
            ActivityGoogleAppFlipBinding activityGoogleAppFlipBinding = this.binding;
            if (activityGoogleAppFlipBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityGoogleAppFlipBinding = null;
            }
            TextView textView = activityGoogleAppFlipBinding.signedInAs;
            String string = getString(com.blueair.viewcore.R.string.google_appflip_signed_in_as);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            AccountLinkingViewModel accountLinkingViewModel4 = this.viewModel;
            if (accountLinkingViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                accountLinkingViewModel4 = null;
            }
            String format = String.format(string, Arrays.copyOf(new Object[]{accountLinkingViewModel4.getUsername()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            String string2 = getString(com.blueair.viewcore.R.string.privacy_policy);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String string3 = getString(com.blueair.viewcore.R.string.google_appflip_review_policy);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String format2 = String.format(string3, Arrays.copyOf(new Object[]{"<a href=\"https://policies.google.com/\">" + string2 + "</a>"}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            activityGoogleAppFlipBinding.reviewPolicy.setText(HtmlCompat.fromHtml(format2, 0));
            activityGoogleAppFlipBinding.reviewPolicy.setMovementMethod(LinkMovementMethod.getInstance());
            activityGoogleAppFlipBinding.btnCancel.setOnClickListener(new GoogleAppFlipActivity$$ExternalSyntheticLambda1(this));
            activityGoogleAppFlipBinding.btnAgree.setOnClickListener(new GoogleAppFlipActivity$$ExternalSyntheticLambda2(this));
            AccountLinkingViewModel accountLinkingViewModel5 = this.viewModel;
            if (accountLinkingViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                accountLinkingViewModel5 = null;
            }
            FlowKt.launchIn(FlowKt.onEach(accountLinkingViewModel5.getState(), new GoogleAppFlipActivity$onCreate$2(this, (Continuation<? super GoogleAppFlipActivity$onCreate$2>) null)), LifecycleOwnerKt.getLifecycleScope(this));
            AccountLinkingViewModel accountLinkingViewModel6 = this.viewModel;
            if (accountLinkingViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                accountLinkingViewModel6 = null;
            }
            if (!accountLinkingViewModel6.isUserLoggedIn()) {
                AccountLinkingViewModel accountLinkingViewModel7 = this.viewModel;
                if (accountLinkingViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    accountLinkingViewModel7 = null;
                }
                accountLinkingViewModel7.setLoginPendingAction(LoginPendingAction.Companion.googleLinking());
                startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, this, false, 2, (Object) null));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(GoogleAppFlipActivity googleAppFlipActivity, View view) {
        googleAppFlipActivity.setErrorResult(-2, 2, 14, "CANCELLED_BY_USER", false);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(GoogleAppFlipActivity googleAppFlipActivity, View view) {
        AccountLinkingViewModel accountLinkingViewModel = googleAppFlipActivity.viewModel;
        if (accountLinkingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            accountLinkingViewModel = null;
        }
        accountLinkingViewModel.finishGoogleLinking();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ActivityGoogleAppFlipBinding activityGoogleAppFlipBinding = this.binding;
        AccountLinkingViewModel accountLinkingViewModel = null;
        if (activityGoogleAppFlipBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityGoogleAppFlipBinding = null;
        }
        TextView textView = activityGoogleAppFlipBinding.signedInAs;
        String string = getString(com.blueair.viewcore.R.string.google_appflip_signed_in_as);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        AccountLinkingViewModel accountLinkingViewModel2 = this.viewModel;
        if (accountLinkingViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            accountLinkingViewModel = accountLinkingViewModel2;
        }
        String format = String.format(string, Arrays.copyOf(new Object[]{accountLinkingViewModel.getUsername()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0023, code lost:
        r10 = r10[0];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean verifyFingerprint(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            r9 = this;
            android.content.ComponentName r0 = r9.getCallingActivity()
            r1 = 0
            if (r0 == 0) goto L_0x006c
            java.lang.String r0 = r0.getPackageName()
            if (r0 == 0) goto L_0x006c
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r0)
            if (r10 == 0) goto L_0x006c
            android.content.pm.PackageManager r10 = r9.getPackageManager()
            r2 = 64
            android.content.pm.PackageInfo r10 = r10.getPackageInfo(r0, r2)
            android.content.pm.Signature[] r10 = r10.signatures
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            if (r10 == 0) goto L_0x002c
            r10 = r10[r1]
            if (r10 == 0) goto L_0x002c
            byte[] r10 = r10.toByteArray()
            goto L_0x002d
        L_0x002c:
            r10 = 0
        L_0x002d:
            r0.<init>(r10)
            java.lang.String r10 = "X509"
            java.security.cert.CertificateFactory r10 = java.security.cert.CertificateFactory.getInstance(r10)
            java.io.InputStream r0 = (java.io.InputStream) r0
            java.security.cert.Certificate r10 = r10.generateCertificate(r0)
            java.lang.String r0 = "null cannot be cast to non-null type java.security.cert.X509Certificate"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r0)
            java.security.cert.X509Certificate r10 = (java.security.cert.X509Certificate) r10
            java.security.MessageDigest r12 = java.security.MessageDigest.getInstance(r12)
            byte[] r10 = r10.getEncoded()
            byte[] r0 = r12.digest(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r10 = ":"
            r1 = r10
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            com.blueair.android.activity.GoogleAppFlipActivity$$ExternalSyntheticLambda0 r6 = new com.blueair.android.activity.GoogleAppFlipActivity$$ExternalSyntheticLambda0
            r6.<init>()
            r7 = 30
            r8 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            java.lang.String r10 = kotlin.collections.ArraysKt.joinToString$default((byte[]) r0, (java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (int) r4, (java.lang.CharSequence) r5, (kotlin.jvm.functions.Function1) r6, (int) r7, (java.lang.Object) r8)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r10)
            return r10
        L_0x006c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.GoogleAppFlipActivity.verifyFingerprint(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    /* access modifiers changed from: private */
    public static final CharSequence verifyFingerprint$lambda$4$lambda$3(byte b) {
        String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* access modifiers changed from: private */
    public final void setSuccessResult(String str) {
        Timber.Forest forest = Timber.Forest;
        forest.d("setSuccessResult(" + str + ')', new Object[0]);
        Intent intent = new Intent();
        intent.putExtra("AUTHORIZATION_CODE", str);
        setResult(-1, intent);
        AccountLinkingViewModel accountLinkingViewModel = this.viewModel;
        if (accountLinkingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            accountLinkingViewModel = null;
        }
        accountLinkingViewModel.setGoogleLinkRequested(true);
        finish();
    }

    static /* synthetic */ void setErrorResult$default(GoogleAppFlipActivity googleAppFlipActivity, int i, int i2, int i3, String str, boolean z, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            z = true;
        }
        googleAppFlipActivity.setErrorResult(i, i2, i3, str, z);
    }

    private final void setErrorResult(int i, int i2, int i3, String str, boolean z) {
        Timber.Forest forest = Timber.Forest;
        forest.d("setErrorResult(" + i + ", " + i2 + ", " + i3 + ", " + str + ')', new Object[0]);
        Intent intent = new Intent();
        intent.putExtra("ERROR_TYPE", i2);
        intent.putExtra("ERROR_CODE", i3);
        intent.putExtra("ERROR_DESCRIPTION", str);
        setResult(i, intent);
        finish();
        if (z) {
            startActivity(new Intent(this, AccountLinkingActivity.class).putExtra(AccountLinkingActivity.EXTRA_NAME, "GoogleAssistant").putExtra(AccountLinkingActivity.EXTRA_LINKED, false).putExtra(AccountLinkingActivity.EXTRA_STATE, AccountLinkingActivity.STATE_FAILED));
        }
    }
}
