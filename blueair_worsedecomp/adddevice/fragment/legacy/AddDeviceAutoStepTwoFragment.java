package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.viewbinding.ViewBinding;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepOneBinding;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepTwoBinding;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepTwoFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "stepOneBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneBinding;", "getStepOneBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneBinding;", "stepOneBinding$delegate", "Lkotlin/Lazy;", "stepTwoBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepTwoBinding;", "getStepTwoBinding", "()Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepTwoBinding;", "stepTwoBinding$delegate", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceAutoStepTwoFragment.kt */
public final class AddDeviceAutoStepTwoFragment extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    private final Lazy stepOneBinding$delegate = LazyKt.lazy(new AddDeviceAutoStepTwoFragment$$ExternalSyntheticLambda1(this));
    private final Lazy stepTwoBinding$delegate = LazyKt.lazy(new AddDeviceAutoStepTwoFragment$$ExternalSyntheticLambda2(this));

    private final FragmentAddDeviceAutoStepOneBinding getStepOneBinding() {
        return (FragmentAddDeviceAutoStepOneBinding) this.stepOneBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceAutoStepOneBinding stepOneBinding_delegate$lambda$0(AddDeviceAutoStepTwoFragment addDeviceAutoStepTwoFragment) {
        ViewBinding viewBinding = addDeviceAutoStepTwoFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceAutoStepOneBinding) viewBinding;
    }

    private final FragmentAddDeviceAutoStepTwoBinding getStepTwoBinding() {
        return (FragmentAddDeviceAutoStepTwoBinding) this.stepTwoBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final FragmentAddDeviceAutoStepTwoBinding stepTwoBinding_delegate$lambda$1(AddDeviceAutoStepTwoFragment addDeviceAutoStepTwoFragment) {
        ViewBinding viewBinding = addDeviceAutoStepTwoFragment.binding;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        return (FragmentAddDeviceAutoStepTwoBinding) viewBinding;
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
            FragmentAddDeviceAutoStepTwoBinding inflate = FragmentAddDeviceAutoStepTwoBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate);
            viewBinding = inflate;
        } else {
            FragmentAddDeviceAutoStepOneBinding inflate2 = FragmentAddDeviceAutoStepOneBinding.inflate(layoutInflater, viewGroup, false);
            Intrinsics.checkNotNull(inflate2);
            viewBinding = inflate2;
        }
        this.binding = viewBinding;
        ViewBinding viewBinding2 = null;
        if (viewBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding = null;
        }
        ((Button) viewBinding.getRoot().findViewById(R.id.buttonNext)).setOnClickListener(new AddDeviceAutoStepTwoFragment$$ExternalSyntheticLambda0(this));
        ViewBinding viewBinding3 = this.binding;
        if (viewBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewBinding3 = null;
        }
        ((TextView) viewBinding3.getRoot().findViewById(R.id.textAddDeviceSubtitle)).setText(com.blueair.viewcore.R.string.add_device_classic_activate_wifi_subtitle);
        ViewBinding viewBinding4 = this.binding;
        if (viewBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewBinding2 = viewBinding4;
        }
        View root = viewBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2(AddDeviceAutoStepTwoFragment addDeviceAutoStepTwoFragment, View view) {
        if (addDeviceAutoStepTwoFragment.getAddService().getCurrentNetworkSSIDEstimate().length() == 0) {
            ViewUtils viewUtils = ViewUtils.INSTANCE;
            FragmentActivity requireActivity = addDeviceAutoStepTwoFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            viewUtils.showError((Activity) requireActivity, com.blueair.viewcore.R.string.error_connect_to_network);
            return;
        }
        addDeviceAutoStepTwoFragment.getAddService().autoStepCompleted();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        int deviceModelType = getDeviceModelType();
        if (deviceModelType == 1) {
            getStepOneBinding().textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.aware_step2);
            AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.device_aware_rotate_and_flash_blue);
            ((ImageView) view.findViewById(R.id.imageAuto)).setImageDrawable(create);
            if (create != null) {
                create.start();
            }
            if (create != null) {
                create.registerAnimationCallback(new AddDeviceAutoStepTwoFragment$onViewCreated$1(create));
            }
        } else if (deviceModelType == 2) {
            getStepOneBinding().textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.sense_step2);
            getStepOneBinding().imageAuto.setImageDrawable(getResources().getDrawable(R.drawable.device_sense_step2));
        } else if (deviceModelType == 3) {
            getStepTwoBinding().textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.add_device_classic_activate_wifi_subtitle);
        }
    }

    public void onResume() {
        super.onResume();
        if (getDeviceModelType() == 3) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            ActionBar supportActionBar = ((AppCompatActivity) activity).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setTitle((CharSequence) getString(com.blueair.viewcore.R.string.activate_wifi));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepTwoFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepTwoFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoStepTwoFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceAutoStepTwoFragment newInstance(int i) {
            AddDeviceAutoStepTwoFragment addDeviceAutoStepTwoFragment = new AddDeviceAutoStepTwoFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceAutoStepTwoFragment.setArguments(bundle);
            return addDeviceAutoStepTwoFragment;
        }
    }
}
