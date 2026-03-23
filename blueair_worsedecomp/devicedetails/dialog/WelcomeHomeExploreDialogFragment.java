package com.blueair.devicedetails.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import com.blueair.devicedetails.databinding.DialogfragmentWhExploreBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/devicedetails/dialog/WelcomeHomeExploreDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "onProceed", "Lkotlin/Function0;", "", "onNeverShow", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentWhExploreBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomeExploreDialogFragment.kt */
public final class WelcomeHomeExploreDialogFragment extends DialogFragment {
    private DialogfragmentWhExploreBinding binding;
    private final Function0<Unit> onNeverShow;
    private final Function0<Unit> onProceed;

    public WelcomeHomeExploreDialogFragment(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "onProceed");
        Intrinsics.checkNotNullParameter(function02, "onNeverShow");
        this.onProceed = function0;
        this.onNeverShow = function02;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentWhExploreBinding inflate = DialogfragmentWhExploreBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentWhExploreBinding dialogfragmentWhExploreBinding = this.binding;
        DialogfragmentWhExploreBinding dialogfragmentWhExploreBinding2 = null;
        if (dialogfragmentWhExploreBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhExploreBinding = null;
        }
        dialogfragmentWhExploreBinding.buttonProceed.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda0(this));
        DialogfragmentWhExploreBinding dialogfragmentWhExploreBinding3 = this.binding;
        if (dialogfragmentWhExploreBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhExploreBinding3 = null;
        }
        dialogfragmentWhExploreBinding3.buttonTryLater.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda1(this));
        DialogfragmentWhExploreBinding dialogfragmentWhExploreBinding4 = this.binding;
        if (dialogfragmentWhExploreBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentWhExploreBinding4 = null;
        }
        dialogfragmentWhExploreBinding4.buttonNeverShow.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda2(this));
        DialogfragmentWhExploreBinding dialogfragmentWhExploreBinding5 = this.binding;
        if (dialogfragmentWhExploreBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentWhExploreBinding2 = dialogfragmentWhExploreBinding5;
        }
        dialogfragmentWhExploreBinding2.imClose.setOnClickListener(new WelcomeHomeExploreDialogFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(WelcomeHomeExploreDialogFragment welcomeHomeExploreDialogFragment, View view) {
        welcomeHomeExploreDialogFragment.onProceed.invoke();
        welcomeHomeExploreDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(WelcomeHomeExploreDialogFragment welcomeHomeExploreDialogFragment, View view) {
        welcomeHomeExploreDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(WelcomeHomeExploreDialogFragment welcomeHomeExploreDialogFragment, View view) {
        welcomeHomeExploreDialogFragment.onNeverShow.invoke();
        welcomeHomeExploreDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(WelcomeHomeExploreDialogFragment welcomeHomeExploreDialogFragment, View view) {
        welcomeHomeExploreDialogFragment.dismiss();
    }
}
