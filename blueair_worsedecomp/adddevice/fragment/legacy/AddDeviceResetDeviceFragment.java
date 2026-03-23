package com.blueair.adddevice.fragment.legacy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.FragmentAddDeviceResetClassicBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceResetDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceResetClassicBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceResetDeviceFragment.kt */
public final class AddDeviceResetDeviceFragment extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentAddDeviceResetClassicBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceResetDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceResetDeviceFragment;", "deviceModelType", "", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: AddDeviceResetDeviceFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AddDeviceResetDeviceFragment newInstance(int i) {
            AddDeviceResetDeviceFragment addDeviceResetDeviceFragment = new AddDeviceResetDeviceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            addDeviceResetDeviceFragment.setArguments(bundle);
            return addDeviceResetDeviceFragment;
        }
    }

    public ConstraintLayout getRootView() {
        FragmentAddDeviceResetClassicBinding fragmentAddDeviceResetClassicBinding = this.binding;
        if (fragmentAddDeviceResetClassicBinding != null) {
            return fragmentAddDeviceResetClassicBinding.getRoot();
        }
        return null;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentAddDeviceResetClassicBinding fragmentAddDeviceResetClassicBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        int deviceModelType = getDeviceModelType();
        ConstraintLayout constraintLayout = null;
        if (deviceModelType == 1 || deviceModelType == 2 || deviceModelType == 3) {
            fragmentAddDeviceResetClassicBinding = FragmentAddDeviceResetClassicBinding.inflate(layoutInflater, viewGroup, false);
        } else {
            fragmentAddDeviceResetClassicBinding = null;
        }
        this.binding = fragmentAddDeviceResetClassicBinding;
        if (fragmentAddDeviceResetClassicBinding != null) {
            constraintLayout = fragmentAddDeviceResetClassicBinding.getRoot();
        }
        return constraintLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentAddDeviceResetClassicBinding fragmentAddDeviceResetClassicBinding = this.binding;
        if (fragmentAddDeviceResetClassicBinding != null) {
            int deviceModelType = getDeviceModelType();
            if (deviceModelType == 1) {
                AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.device_aware_rotate_and_flash_blue);
                fragmentAddDeviceResetClassicBinding.imageAuto.setImageDrawable(create);
                if (create != null) {
                    create.start();
                }
                if (create != null) {
                    create.registerAnimationCallback(new AddDeviceResetDeviceFragment$onViewCreated$1(create));
                }
                fragmentAddDeviceResetClassicBinding.textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.aware_reset_turn_around);
            } else if (deviceModelType == 2) {
                fragmentAddDeviceResetClassicBinding.imageAuto.setImageDrawable(getResources().getDrawable(R.drawable.device_sense_step2));
                fragmentAddDeviceResetClassicBinding.textAddDeviceSubtitle.setText(com.blueair.viewcore.R.string.sense_reset_turn_around);
            } else if (deviceModelType == 3) {
                fragmentAddDeviceResetClassicBinding.imageAuto.setImageDrawable(getResources().getDrawable(R.drawable.device_classic_step2));
            }
            int deviceModelType2 = getDeviceModelType();
            if (deviceModelType2 == 1 || deviceModelType2 == 2 || deviceModelType2 == 3) {
                fragmentAddDeviceResetClassicBinding.buttonNext.setOnClickListener(new AddDeviceResetDeviceFragment$$ExternalSyntheticLambda0(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(AddDeviceResetDeviceFragment addDeviceResetDeviceFragment, View view) {
        addDeviceResetDeviceFragment.getAddService().startManualConfig();
    }
}
