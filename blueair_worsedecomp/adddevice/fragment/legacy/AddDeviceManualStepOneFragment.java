package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepOneBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceManualStepOneClassicBinding;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepOneFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "classicBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneClassicBinding;", "getClassicBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneClassicBinding;", "classicBinding$delegate", "Lkotlin/Lazy;", "otherBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneBinding;", "getOtherBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceManualStepOneBinding;", "otherBinding$delegate", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceManualStepOneFragment.kt */
public final class AddDeviceManualStepOneFragment extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    private final Lazy classicBinding$delegate = LazyKt.lazy(new AddDeviceManualStepOneFragment$$ExternalSyntheticLambda0(this));
    private final Lazy otherBinding$delegate = LazyKt.lazy(new AddDeviceManualStepOneFragment$$ExternalSyntheticLambda1(this));

    private final FragmentAddDeviceManualStepOneClassicBinding getClassicBinding() {
        return (FragmentAddDeviceManualStepOneClassicBinding) this.classicBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceManualStepOneClassicBinding classicBinding_delegate$lambda$0(AddDeviceManualStepOneFragment addDeviceManualStepOneFragment) {
        ViewBinding viewBinding = addDeviceManualStepOneFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceManualStepOneClassicBinding) viewBinding;
    }

    private final FragmentAddDeviceManualStepOneBinding getOtherBinding() {
        return (FragmentAddDeviceManualStepOneBinding) this.otherBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceManualStepOneBinding otherBinding_delegate$lambda$1(AddDeviceManualStepOneFragment addDeviceManualStepOneFragment) {
        ViewBinding viewBinding = addDeviceManualStepOneFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceManualStepOneBinding) viewBinding;
    }

    public ConstraintLayout getRootView() {
        ViewBinding viewBinding = this.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNull(root, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        return (ConstraintLayout) root;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewBinding viewBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (getDeviceModelType() == 3) {
            FragmentAddDeviceManualStepOneClassicBinding inflate = FragmentAddDeviceManualStepOneClassicBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceManualStepOneBinding inflate2 = FragmentAddDeviceManualStepOneBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate2);
            viewBinding = inflate2;
        }
        this.binding = viewBinding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        View root = viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        MaterialButton materialButton;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            getOtherBinding().textAddDeviceSubtitle.setText(R.string.aware_manual_subtitle);
            AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(requireContext(), com.blueair.adddevice.R.drawable.device_aware_rotate_and_flash_orange);
            getOtherBinding().imageAuto.setImageDrawable(create);
            if (create != null) {
                create.start();
            }
            if (create != null) {
                create.registerAnimationCallback(new AddDeviceManualStepOneFragment$onViewCreated$1(create));
            }
        } else if (deviceModelType == 2) {
            getOtherBinding().imageAuto.setImageDrawable(getResources().getDrawable(com.blueair.adddevice.R.drawable.device_sense_step2));
            getOtherBinding().textAddDeviceSubtitle.setText(R.string.sense_manual_subtitle);
        }
        int deviceModelType2 = getDeviceModelType();
        if (deviceModelType2 == 1 || deviceModelType2 == 2) {
            materialButton = getOtherBinding().buttonNext;
        } else if (deviceModelType2 != 3) {
            materialButton = null;
        } else {
            materialButton = getClassicBinding().buttonNext;
        }
        if (materialButton != null) {
            materialButton.setOnClickListener(new AddDeviceManualStepOneFragment$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(AddDeviceManualStepOneFragment addDeviceManualStepOneFragment, View view) {
        addDeviceManualStepOneFragment.getAddService().manualStepCompleted();
    }

    public void onResume() {
        super.onResume();
        if (getDeviceModelType() == 3) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(R.string.manual_configuration));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepOneFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceManualStepOneFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceManualStepOneFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceManualStepOneFragment newInstance(int i) {
            AddDeviceManualStepOneFragment addDeviceManualStepOneFragment = new AddDeviceManualStepOneFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceManualStepOneFragment.setArguments(bundle);
            return addDeviceManualStepOneFragment;
        }
    }
}
