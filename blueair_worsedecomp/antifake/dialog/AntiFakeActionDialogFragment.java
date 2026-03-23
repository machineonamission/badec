package com.blueair.antifake.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.antifake.activity.ScanActivity;
import com.blueair.antifake.databinding.DialogfragmentAntifakeActionBinding;
import com.blueair.antifake.viewmodel.AntiFakeActionViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.LoginPendingAction;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/blueair/antifake/dialog/AntiFakeActionDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeActionViewModel;)V", "binding", "Lcom/blueair/antifake/databinding/DialogfragmentAntifakeActionBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AntiFakeActionDialogFragment.kt */
public final class AntiFakeActionDialogFragment extends BaseDialogFragment<AntiFakeActionViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean shouldDismiss;
    private DialogfragmentAntifakeActionBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ANTIFAKE_INSTRUCTION;
    public AntiFakeActionViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/blueair/antifake/dialog/AntiFakeActionDialogFragment$Companion;", "", "<init>", "()V", "shouldDismiss", "", "getShouldDismiss", "()Z", "setShouldDismiss", "(Z)V", "newInstance", "Lcom/blueair/antifake/dialog/AntiFakeActionDialogFragment;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AntiFakeActionDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getShouldDismiss() {
            return AntiFakeActionDialogFragment.shouldDismiss;
        }

        public final void setShouldDismiss(boolean z) {
            AntiFakeActionDialogFragment.shouldDismiss = z;
        }

        public final AntiFakeActionDialogFragment newInstance() {
            return new AntiFakeActionDialogFragment();
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public AntiFakeActionViewModel getViewModel() {
        AntiFakeActionViewModel antiFakeActionViewModel = this.viewModel;
        if (antiFakeActionViewModel != null) {
            return antiFakeActionViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(AntiFakeActionViewModel antiFakeActionViewModel) {
        Intrinsics.checkNotNullParameter(antiFakeActionViewModel, "<set-?>");
        this.viewModel = antiFakeActionViewModel;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        shouldDismiss = false;
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        DialogfragmentAntifakeActionBinding inflate = DialogfragmentAntifakeActionBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        setViewModel((AntiFakeActionViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(AntiFakeActionViewModel.class)));
        DialogfragmentAntifakeActionBinding dialogfragmentAntifakeActionBinding = this.binding;
        if (dialogfragmentAntifakeActionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentAntifakeActionBinding = null;
        }
        FrameLayout root = dialogfragmentAntifakeActionBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentAntifakeActionBinding dialogfragmentAntifakeActionBinding = this.binding;
        DialogfragmentAntifakeActionBinding dialogfragmentAntifakeActionBinding2 = null;
        if (dialogfragmentAntifakeActionBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentAntifakeActionBinding = null;
        }
        dialogfragmentAntifakeActionBinding.backBtn.setOnClickListener(new AntiFakeActionDialogFragment$$ExternalSyntheticLambda0(this));
        DialogfragmentAntifakeActionBinding dialogfragmentAntifakeActionBinding3 = this.binding;
        if (dialogfragmentAntifakeActionBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentAntifakeActionBinding2 = dialogfragmentAntifakeActionBinding3;
        }
        dialogfragmentAntifakeActionBinding2.scanBtn.setOnClickListener(new AntiFakeActionDialogFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(AntiFakeActionDialogFragment antiFakeActionDialogFragment, View view) {
        antiFakeActionDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(AntiFakeActionDialogFragment antiFakeActionDialogFragment, View view) {
        if (antiFakeActionDialogFragment.getViewModel().isUserLoggedIn()) {
            antiFakeActionDialogFragment.startActivity(new Intent(antiFakeActionDialogFragment.requireContext(), ScanActivity.class));
            return;
        }
        antiFakeActionDialogFragment.getViewModel().setLoginPendingAction(LoginPendingAction.Companion.antiFakeScan());
        Actions actions = Actions.INSTANCE;
        Context requireContext = antiFakeActionDialogFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        antiFakeActionDialogFragment.startActivity(Actions.openWelcomeIntent$default(actions, requireContext, false, 2, (Object) null));
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -1);
        }
    }

    public void onResume() {
        super.onResume();
        if (shouldDismiss) {
            shouldDismiss = false;
            dismiss();
        }
    }

    public void onPause() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onPause();
    }
}
