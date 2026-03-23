package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.FragmentAddDeviceAutoStepOneIcpBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0003J\"\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpAddDeviceFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceAutoStepOneIcpBinding;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "isBluetoothEnabled", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IcpAddDeviceFragment.kt */
public final class IcpAddDeviceFragment extends AddDeviceBaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REQUEST_CODE_ENABLE_BT = 100;
    private FragmentAddDeviceAutoStepOneIcpBinding binding;

    public ConstraintLayout getRootView() {
        FragmentAddDeviceAutoStepOneIcpBinding fragmentAddDeviceAutoStepOneIcpBinding = this.binding;
        if (fragmentAddDeviceAutoStepOneIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepOneIcpBinding = null;
        }
        ConstraintLayout root = fragmentAddDeviceAutoStepOneIcpBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAddDeviceAutoStepOneIcpBinding inflate = FragmentAddDeviceAutoStepOneIcpBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        ConstraintLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentAddDeviceAutoStepOneIcpBinding fragmentAddDeviceAutoStepOneIcpBinding = this.binding;
        if (fragmentAddDeviceAutoStepOneIcpBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentAddDeviceAutoStepOneIcpBinding = null;
        }
        fragmentAddDeviceAutoStepOneIcpBinding.buttonNext.setOnClickListener(new IcpAddDeviceFragment$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(IcpAddDeviceFragment icpAddDeviceFragment, View view) {
        if (!icpAddDeviceFragment.isBluetoothEnabled()) {
            Timber.Forest.w("attemptToCompleteStep ble not enabled", new Object[0]);
            icpAddDeviceFragment.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), REQUEST_CODE_ENABLE_BT);
            return;
        }
        Timber.Forest.w("attemptToCompleteStep ready to complete", new Object[0]);
        icpAddDeviceFragment.getAddService().icpAddDeviceCompleted();
    }

    private final boolean isBluetoothEnabled() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != REQUEST_CODE_ENABLE_BT) {
            return;
        }
        if (i2 == -1) {
            getAddService().icpAddDeviceCompleted();
            return;
        }
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        viewUtils.showError((Activity) requireActivity, R.string.add_device_turn_on_bluetooth);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/blueair/adddevice/fragment/legacy/IcpAddDeviceFragment$Companion;", "", "<init>", "()V", "REQUEST_CODE_ENABLE_BT", "", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/IcpAddDeviceFragment;", "deviceModelType", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IcpAddDeviceFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final IcpAddDeviceFragment newInstance(int i) {
            IcpAddDeviceFragment icpAddDeviceFragment = new IcpAddDeviceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(AddDeviceBaseFragment.ARG_DEVICE_MODEL_TYPE, i);
            icpAddDeviceFragment.setArguments(bundle);
            return icpAddDeviceFragment;
        }
    }
}
