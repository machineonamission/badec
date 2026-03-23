package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepOneBinding;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepOneFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceAutoStepOneFragment.kt */
public final class AddDeviceAutoStepOneFragment extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentAddDeviceAutoStepOneBinding binding;

    public ConstraintLayout getRootView() {
        FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding = this.binding;
        if (fragmentAddDeviceAutoStepOneBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepOneBinding = null;
        }
        ConstraintLayout root = fragmentAddDeviceAutoStepOneBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAddDeviceAutoStepOneBinding inflate = FragmentAddDeviceAutoStepOneBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        inflate.buttonNext.setOnClickListener(new AddDeviceAutoStepOneFragment$$ExternalSyntheticLambda0(this));
        FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding2 = this.binding;
        if (fragmentAddDeviceAutoStepOneBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentAddDeviceAutoStepOneBinding = fragmentAddDeviceAutoStepOneBinding2;
        }
        ConstraintLayout root = fragmentAddDeviceAutoStepOneBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(AddDeviceAutoStepOneFragment addDeviceAutoStepOneFragment, View view) {
        addDeviceAutoStepOneFragment.getAddService().autoStepCompleted();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        int deviceModelType = getDeviceModelType();
        FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding = null;
        if (deviceModelType == 1) {
            FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding2 = this.binding;
            if (fragmentAddDeviceAutoStepOneBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAddDeviceAutoStepOneBinding2 = null;
            }
            fragmentAddDeviceAutoStepOneBinding2.textAddDeviceSubtitle.setText(R.string.aware_step1);
            FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding3 = this.binding;
            if (fragmentAddDeviceAutoStepOneBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAddDeviceAutoStepOneBinding = fragmentAddDeviceAutoStepOneBinding3;
            }
            fragmentAddDeviceAutoStepOneBinding.imageAuto.setImageDrawable(getResources().getDrawable(com.blueair.adddevice.R.drawable.device_aware_step1));
        } else if (deviceModelType == 2) {
            FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding4 = this.binding;
            if (fragmentAddDeviceAutoStepOneBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentAddDeviceAutoStepOneBinding4 = null;
            }
            fragmentAddDeviceAutoStepOneBinding4.textAddDeviceSubtitle.setText(R.string.sense_step1);
            AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(requireContext(), com.blueair.adddevice.R.drawable.device_sense_step1_animated);
            FragmentAddDeviceAutoStepOneBinding fragmentAddDeviceAutoStepOneBinding5 = this.binding;
            if (fragmentAddDeviceAutoStepOneBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentAddDeviceAutoStepOneBinding = fragmentAddDeviceAutoStepOneBinding5;
            }
            fragmentAddDeviceAutoStepOneBinding.imageAuto.setImageDrawable(create);
            if (create != null) {
                create.start();
            }
            if (create != null) {
                create.registerAnimationCallback(new AddDeviceAutoStepOneFragment$onViewCreated$1(create));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepOneFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoStepOneFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceAutoStepOneFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceAutoStepOneFragment newInstance(int i) {
            AddDeviceAutoStepOneFragment addDeviceAutoStepOneFragment = new AddDeviceAutoStepOneFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceAutoStepOneFragment.setArguments(bundle);
            return addDeviceAutoStepOneFragment;
        }
    }
}
