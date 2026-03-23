package com.blueair.android.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ScrollView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.android.databinding.DialogfragmentRateUsBinding;
import com.blueair.core.util.PhoneUtil;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\b\u0010%\u001a\u00020\u001fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u000f\u0010\u000bR\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000b¨\u0006'"}, d2 = {"Lcom/blueair/android/dialog/RateUsDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "skip", "", "binding", "Lcom/blueair/android/databinding/DialogfragmentRateUsBinding;", "visitHuaweiStore", "", "getVisitHuaweiStore", "()Ljava/lang/String;", "visitHuaweiStore$delegate", "Lkotlin/Lazy;", "visitTencentStore", "getVisitTencentStore", "visitTencentStore$delegate", "viewModel", "Lcom/blueair/android/dialog/RateUsViewModel;", "trigger", "getTrigger", "trigger$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "redirectToMarket", "openFeedbackLink", "switchLayouts", "animateRateUsShow", "dismiss", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RateUsDialogFragment.kt */
public final class RateUsDialogFragment extends DialogFragment {
    public static final int $stable = 8;
    private static final String ARGUMENT_IS_IN_CHINA = "IS_IN_CHINA";
    private static final String ARGUMENT_TRIGGER = "TRIGGER";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public DialogfragmentRateUsBinding binding;
    private boolean skip = true;
    private final Lazy trigger$delegate = LazyKt.lazy(new RateUsDialogFragment$$ExternalSyntheticLambda2(this));
    private RateUsViewModel viewModel;
    private final Lazy visitHuaweiStore$delegate = LazyKt.lazy(new RateUsDialogFragment$$ExternalSyntheticLambda0(this));
    private final Lazy visitTencentStore$delegate = LazyKt.lazy(new RateUsDialogFragment$$ExternalSyntheticLambda1(this));

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/android/dialog/RateUsDialogFragment$Companion;", "", "<init>", "()V", "ARGUMENT_IS_IN_CHINA", "", "ARGUMENT_TRIGGER", "newInstance", "Lcom/blueair/android/dialog/RateUsDialogFragment;", "isInChina", "", "trigger", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: RateUsDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RateUsDialogFragment newInstance(boolean z, String str) {
            Intrinsics.checkNotNullParameter(str, "trigger");
            RateUsDialogFragment rateUsDialogFragment = new RateUsDialogFragment();
            rateUsDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(RateUsDialogFragment.ARGUMENT_IS_IN_CHINA, Boolean.valueOf(z)), TuplesKt.to(RateUsDialogFragment.ARGUMENT_TRIGGER, str)));
            return rateUsDialogFragment;
        }
    }

    private final String getVisitHuaweiStore() {
        return (String) this.visitHuaweiStore$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String visitHuaweiStore_delegate$lambda$0(RateUsDialogFragment rateUsDialogFragment) {
        return rateUsDialogFragment.getString(R.string.rate_us_visit_huawei_store);
    }

    private final String getVisitTencentStore() {
        return (String) this.visitTencentStore$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String visitTencentStore_delegate$lambda$1(RateUsDialogFragment rateUsDialogFragment) {
        return rateUsDialogFragment.getString(R.string.rate_us_visit_tencent_store);
    }

    private final String getTrigger() {
        return (String) this.trigger$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final String trigger_delegate$lambda$2(RateUsDialogFragment rateUsDialogFragment) {
        String string = rateUsDialogFragment.requireArguments().getString(ARGUMENT_TRIGGER, (String) null);
        if (string != null) {
            return string;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.viewModel = (RateUsViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(RateUsViewModel.class);
        DialogfragmentRateUsBinding inflate = DialogfragmentRateUsBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        ScrollView root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding = this.binding;
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding2 = null;
        if (dialogfragmentRateUsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding = null;
        }
        dialogfragmentRateUsBinding.buttonImprovePositive.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda3(this));
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding3 = this.binding;
        if (dialogfragmentRateUsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding3 = null;
        }
        dialogfragmentRateUsBinding3.buttonImproveNegative.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda4(this));
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding4 = this.binding;
        if (dialogfragmentRateUsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding4 = null;
        }
        dialogfragmentRateUsBinding4.buttonRateRedirect.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda5(this));
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding5 = this.binding;
        if (dialogfragmentRateUsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding5 = null;
        }
        dialogfragmentRateUsBinding5.buttonRateCancel.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda6(this));
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding6 = this.binding;
        if (dialogfragmentRateUsBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding6 = null;
        }
        dialogfragmentRateUsBinding6.imClose.setOnClickListener(new RateUsDialogFragment$$ExternalSyntheticLambda7(this));
        if (requireArguments().getBoolean(ARGUMENT_IS_IN_CHINA)) {
            DialogfragmentRateUsBinding dialogfragmentRateUsBinding7 = this.binding;
            if (dialogfragmentRateUsBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                dialogfragmentRateUsBinding2 = dialogfragmentRateUsBinding7;
            }
            MaterialButton materialButton = dialogfragmentRateUsBinding2.buttonRateRedirect;
            PhoneUtil phoneUtil = PhoneUtil.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (phoneUtil.isHuaweiServicesAvailable(requireContext)) {
                charSequence = getVisitHuaweiStore();
            } else {
                charSequence = getVisitTencentStore();
            }
            materialButton.setText(charSequence);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(RateUsDialogFragment rateUsDialogFragment, View view) {
        rateUsDialogFragment.skip = false;
        RateUsViewModel rateUsViewModel = rateUsDialogFragment.viewModel;
        if (rateUsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rateUsViewModel = null;
        }
        rateUsViewModel.onImprovePositive(rateUsDialogFragment.getTrigger());
        rateUsDialogFragment.switchLayouts();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$4(RateUsDialogFragment rateUsDialogFragment, View view) {
        rateUsDialogFragment.skip = false;
        RateUsViewModel rateUsViewModel = rateUsDialogFragment.viewModel;
        if (rateUsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rateUsViewModel = null;
        }
        rateUsViewModel.onImproveNegative(rateUsDialogFragment.getTrigger());
        rateUsDialogFragment.openFeedbackLink();
        rateUsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5(RateUsDialogFragment rateUsDialogFragment, View view) {
        rateUsDialogFragment.redirectToMarket();
        rateUsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(RateUsDialogFragment rateUsDialogFragment, View view) {
        rateUsDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$7(RateUsDialogFragment rateUsDialogFragment, View view) {
        rateUsDialogFragment.dismiss();
    }

    private final void redirectToMarket() {
        RateUsViewModel rateUsViewModel = this.viewModel;
        if (rateUsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rateUsViewModel = null;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(rateUsViewModel.getMarketLink())));
    }

    private final void openFeedbackLink() {
        RateUsViewModel rateUsViewModel = this.viewModel;
        if (rateUsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            rateUsViewModel = null;
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(rateUsViewModel.getFeedbackLink())));
    }

    private final void switchLayouts() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding = this.binding;
        if (dialogfragmentRateUsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding = null;
        }
        ViewPropertyAnimator animate = dialogfragmentRateUsBinding.viewHelpUsImprove.animate();
        if (animate != null && (alpha = animate.alpha(0.0f)) != null && (duration = alpha.setDuration(150)) != null && (listener = duration.setListener(new RateUsDialogFragment$switchLayouts$1(this))) != null) {
            listener.start();
        }
    }

    /* access modifiers changed from: private */
    public final void animateRateUsShow() {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        DialogfragmentRateUsBinding dialogfragmentRateUsBinding = this.binding;
        if (dialogfragmentRateUsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentRateUsBinding = null;
        }
        ViewPropertyAnimator animate = dialogfragmentRateUsBinding.viewRateUs.animate();
        if (animate != null && (alpha = animate.alpha(1.0f)) != null && (duration = alpha.setDuration(150)) != null && (listener = duration.setListener(new RateUsDialogFragment$animateRateUsShow$1(this))) != null) {
            listener.start();
        }
    }

    public void dismiss() {
        if (this.skip) {
            RateUsViewModel rateUsViewModel = this.viewModel;
            if (rateUsViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                rateUsViewModel = null;
            }
            rateUsViewModel.onSkip(getTrigger());
        }
        super.dismiss();
    }
}
