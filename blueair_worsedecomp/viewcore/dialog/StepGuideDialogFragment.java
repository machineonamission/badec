package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import androidx.core.os.BundleKt;
import androidx.core.text.HtmlCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.MutableLiveData;
import com.blueair.viewcore.databinding.DialogfragmentStepGuideBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J(\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0014H\u0002J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010&\u001a\u00020\u001eH\u0016J\u0010\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/blueair/viewcore/dialog/StepGuideDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/viewcore/databinding/DialogfragmentStepGuideBinding;", "stepGuides", "Lcom/blueair/viewcore/dialog/StepGuides;", "getStepGuides", "()Lcom/blueair/viewcore/dialog/StepGuides;", "stepGuides$delegate", "Lkotlin/Lazy;", "currentStep", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "currentStepValue", "getCurrentStepValue", "()I", "isCompleteBtnClicked", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setPage", "", "title", "", "content", "btn", "backEnabled", "onViewCreated", "view", "onStart", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StepGuideDialogFragment.kt */
public final class StepGuideDialogFragment extends DialogFragment {
    private static final String ARG_STEP_GUIDES = "ARG_STEP_GUIDES";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DATA_COMPLETED = "DATA_COMPLETED";
    public static final String DEFAULT_REQUEST_KEY = "StepGuideDialogFragment";
    private DialogfragmentStepGuideBinding binding;
    private MutableLiveData<Integer> currentStep = new MutableLiveData<>(0);
    private boolean isCompleteBtnClicked;
    private final Lazy stepGuides$delegate = LazyKt.lazy(new StepGuideDialogFragment$$ExternalSyntheticLambda0(this));

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/viewcore/dialog/StepGuideDialogFragment$Companion;", "", "<init>", "()V", "DEFAULT_REQUEST_KEY", "", "DATA_COMPLETED", "ARG_STEP_GUIDES", "newInstance", "Lcom/blueair/viewcore/dialog/StepGuideDialogFragment;", "stepGuides", "Lcom/blueair/viewcore/dialog/StepGuides;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StepGuideDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StepGuideDialogFragment newInstance(StepGuides stepGuides) {
            Intrinsics.checkNotNullParameter(stepGuides, "stepGuides");
            StepGuideDialogFragment stepGuideDialogFragment = new StepGuideDialogFragment();
            stepGuideDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(StepGuideDialogFragment.ARG_STEP_GUIDES, stepGuides)));
            return stepGuideDialogFragment;
        }
    }

    private final StepGuides getStepGuides() {
        return (StepGuides) this.stepGuides$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final StepGuides stepGuides_delegate$lambda$0(StepGuideDialogFragment stepGuideDialogFragment) {
        return (StepGuides) stepGuideDialogFragment.requireArguments().getParcelable(ARG_STEP_GUIDES);
    }

    private final int getCurrentStepValue() {
        Integer value = this.currentStep.getValue();
        Intrinsics.checkNotNull(value);
        return value.intValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentStepGuideBinding inflate = DialogfragmentStepGuideBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void setPage(String str, int i, int i2, boolean z) {
        DialogfragmentStepGuideBinding dialogfragmentStepGuideBinding = this.binding;
        if (dialogfragmentStepGuideBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            dialogfragmentStepGuideBinding = null;
        }
        dialogfragmentStepGuideBinding.txtStepTitle.setText(str);
        dialogfragmentStepGuideBinding.txtStepDescription.setText(HtmlCompat.fromHtml(getString(i), 0));
        dialogfragmentStepGuideBinding.btnNext.setText(i2);
        ImageButton imageButton = dialogfragmentStepGuideBinding.btnBack;
        Intrinsics.checkNotNullExpressionValue(imageButton, "btnBack");
        ViewExtensionsKt.show(imageButton, z);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        StepGuides stepGuides = getStepGuides();
        DialogfragmentStepGuideBinding dialogfragmentStepGuideBinding = null;
        if (stepGuides != null) {
            int i = stepGuides.getHeadTitle() == null ? -1 : 0;
            DialogfragmentStepGuideBinding dialogfragmentStepGuideBinding2 = this.binding;
            if (dialogfragmentStepGuideBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentStepGuideBinding2 = null;
            }
            dialogfragmentStepGuideBinding2.txtStepDescription.setMinLines(stepGuides.getMinLines());
            DialogfragmentStepGuideBinding dialogfragmentStepGuideBinding3 = this.binding;
            if (dialogfragmentStepGuideBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentStepGuideBinding3 = null;
            }
            dialogfragmentStepGuideBinding3.btnBack.setOnClickListener(new StepGuideDialogFragment$$ExternalSyntheticLambda1(this));
            DialogfragmentStepGuideBinding dialogfragmentStepGuideBinding4 = this.binding;
            if (dialogfragmentStepGuideBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                dialogfragmentStepGuideBinding4 = null;
            }
            dialogfragmentStepGuideBinding4.btnNext.setOnClickListener(new StepGuideDialogFragment$$ExternalSyntheticLambda2(this, stepGuides));
            this.currentStep.observe(getViewLifecycleOwner(), new StepGuideDialogFragment$sam$androidx_lifecycle_Observer$0(new StepGuideDialogFragment$$ExternalSyntheticLambda3(i, this, stepGuides)));
        }
        DialogfragmentStepGuideBinding dialogfragmentStepGuideBinding5 = this.binding;
        if (dialogfragmentStepGuideBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            dialogfragmentStepGuideBinding = dialogfragmentStepGuideBinding5;
        }
        dialogfragmentStepGuideBinding.btnClose.setOnClickListener(new StepGuideDialogFragment$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$2(StepGuideDialogFragment stepGuideDialogFragment, View view) {
        stepGuideDialogFragment.currentStep.setValue(Integer.valueOf(stepGuideDialogFragment.getCurrentStepValue() - 1));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$3(StepGuideDialogFragment stepGuideDialogFragment, StepGuides stepGuides, View view) {
        if (stepGuideDialogFragment.getCurrentStepValue() == stepGuides.getPageSize() - 1) {
            stepGuideDialogFragment.isCompleteBtnClicked = true;
            stepGuideDialogFragment.dismiss();
            return;
        }
        stepGuideDialogFragment.currentStep.setValue(Integer.valueOf(stepGuideDialogFragment.getCurrentStepValue() + 1));
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$5$lambda$4(int i, StepGuideDialogFragment stepGuideDialogFragment, StepGuides stepGuides, Integer num) {
        boolean z = false;
        if (num != null && num.intValue() == i) {
            Integer headTitle = stepGuides.getHeadTitle();
            Intrinsics.checkNotNull(headTitle);
            String string = stepGuideDialogFragment.getString(headTitle.intValue());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Integer headMessage = stepGuides.getHeadMessage();
            Intrinsics.checkNotNull(headMessage);
            int intValue = headMessage.intValue();
            Integer headBtn = stepGuides.getHeadBtn();
            Intrinsics.checkNotNull(headBtn);
            stepGuideDialogFragment.setPage(string, intValue, headBtn.intValue(), false);
        } else {
            int pageSize = stepGuides.getPageSize() - 1;
            if (num != null && num.intValue() == pageSize) {
                String string2 = stepGuideDialogFragment.getString(stepGuides.getCompleteTitle());
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                stepGuideDialogFragment.setPage(string2, stepGuides.getCompleteMessage(), stepGuides.getCompleteBtn(), true);
            } else {
                IntRange intRange = new IntRange(i + 1, stepGuides.getPageSize());
                int first = intRange.getFirst();
                int last = intRange.getLast();
                Intrinsics.checkNotNull(num);
                int intValue2 = num.intValue();
                if (first <= intValue2 && intValue2 <= last) {
                    int intValue3 = num.intValue() - (stepGuides.getHeadTitle() == null ? 0 : 1);
                    int intValue4 = stepGuides.getStepMessages().get(intValue3).intValue();
                    String str = stepGuideDialogFragment.getString(stepGuides.getStepTitle()) + TokenParser.SP + (intValue3 + 1) + '/' + stepGuides.getStepMessages().size();
                    int stepBtn = stepGuides.getStepBtn();
                    if (num.intValue() > 0) {
                        z = true;
                    }
                    stepGuideDialogFragment.setPage(str, intValue4, stepBtn, z);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$6(StepGuideDialogFragment stepGuideDialogFragment, View view) {
        stepGuideDialogFragment.dismiss();
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        String str;
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        Fragment fragment = this;
        StepGuides stepGuides = getStepGuides();
        if (stepGuides == null || (str = stepGuides.getRequestKey()) == null) {
            str = DEFAULT_REQUEST_KEY;
        }
        FragmentKt.setFragmentResult(fragment, str, BundleKt.bundleOf(TuplesKt.to(DATA_COMPLETED, Boolean.valueOf(this.isCompleteBtnClicked))));
    }
}
