package com.blueair.android.dialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.viewcore.dialog.BaseEditTextDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0006H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/blueair/android/dialog/EditGigyaTokenDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/DevSettingsViewModel;)V", "gigyaToken", "getGigyaToken", "gigyaToken$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "onSaveBtnClicked", "text", "validateText", "", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: EditGigyaTokenDialogFragment.kt */
public final class EditGigyaTokenDialogFragment extends BaseEditTextDialogFragment<DevSettingsViewModel> {
    public static final int $stable = 8;
    private static final String ARG_GIGYA_TOKEN = "gigya_token";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy gigyaToken$delegate = LazyKt.lazy(new EditGigyaTokenDialogFragment$$ExternalSyntheticLambda0(this));
    private final String screenName;
    public DevSettingsViewModel viewModel;

    /* access modifiers changed from: protected */
    public boolean validateText() {
        return true;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/android/dialog/EditGigyaTokenDialogFragment$Companion;", "", "<init>", "()V", "ARG_GIGYA_TOKEN", "", "newInstance", "Lcom/blueair/android/dialog/EditGigyaTokenDialogFragment;", "gigyaToken", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: EditGigyaTokenDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditGigyaTokenDialogFragment newInstance(String str) {
            Intrinsics.checkNotNullParameter(str, "gigyaToken");
            EditGigyaTokenDialogFragment editGigyaTokenDialogFragment = new EditGigyaTokenDialogFragment();
            editGigyaTokenDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(EditGigyaTokenDialogFragment.ARG_GIGYA_TOKEN, str)));
            return editGigyaTokenDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public DevSettingsViewModel getViewModel() {
        DevSettingsViewModel devSettingsViewModel = this.viewModel;
        if (devSettingsViewModel != null) {
            return devSettingsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DevSettingsViewModel devSettingsViewModel) {
        Intrinsics.checkNotNullParameter(devSettingsViewModel, "<set-?>");
        this.viewModel = devSettingsViewModel;
    }

    private final String getGigyaToken() {
        return (String) this.gigyaToken$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.getString(ARG_GIGYA_TOKEN);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String gigyaToken_delegate$lambda$0(com.blueair.android.dialog.EditGigyaTokenDialogFragment r1) {
        /*
            android.os.Bundle r1 = r1.getArguments()
            if (r1 == 0) goto L_0x0010
            java.lang.String r0 = "gigya_token"
            java.lang.String r1 = r1.getString(r0)
            if (r1 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            return r1
        L_0x0010:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.dialog.EditGigyaTokenDialogFragment.gigyaToken_delegate$lambda$0(com.blueair.android.dialog.EditGigyaTokenDialogFragment):java.lang.String");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((DevSettingsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DevSettingsViewModel.class)));
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        TextView dialogTitle = getDialogTitle();
        if (dialogTitle != null) {
            dialogTitle.setText("Set gigya token");
        }
        TextView dialogMsg = getDialogMsg();
        if (dialogMsg != null) {
            dialogMsg.setText("This will change logged in user.\nFormat:\nusername:gigyaToken\n\"username:\" is optional");
        }
        TextView dialogMsg2 = getDialogMsg();
        if (dialogMsg2 != null) {
            dialogMsg2.setGravity(3);
        }
        EditText editText = getEditText();
        if (editText != null) {
            editText.setText(getGigyaToken());
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveBtnClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        getViewModel().setGigyaJwt(str);
        super.onSaveBtnClicked(str);
    }
}
