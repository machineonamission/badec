package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.devicedetails.activity.DeviceSettingsActivity;
import com.blueair.devicedetails.databinding.FragmentDeviceHSettingsBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceNSettingsBinding;
import com.blueair.devicedetails.databinding.FragmentDeviceSettingsBinding;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSettingsFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsFragment.kt */
public final class DeviceSettingsFragment extends Fragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ViewBinding binding;
    private Device device;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceSettingsFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceSettingsFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSettingsFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSettingsFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceSettingsFragment deviceSettingsFragment = new DeviceSettingsFragment();
            deviceSettingsFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device)));
            return deviceSettingsFragment;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewBinding viewBinding;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Bundle arguments = getArguments();
        ViewBinding viewBinding2 = null;
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            this.device = device2;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            if (device2 instanceof DeviceNewClassic) {
                FragmentDeviceNSettingsBinding inflate = FragmentDeviceNSettingsBinding.inflate(layoutInflater, viewGroup, false);
                inflate.getRoot().setOnClickListener(new DeviceSettingsFragment$$ExternalSyntheticLambda0(this));
                Intrinsics.checkNotNullExpressionValue(inflate, "apply(...)");
                viewBinding = inflate;
            } else {
                Device device3 = this.device;
                if (device3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("device");
                    device3 = null;
                }
                if (DeviceKt.isAfterG4(device3)) {
                    FragmentDeviceHSettingsBinding inflate2 = FragmentDeviceHSettingsBinding.inflate(layoutInflater, viewGroup, false);
                    inflate2.btnSettings.setOnClickListener(new DeviceSettingsFragment$$ExternalSyntheticLambda1(this));
                    Intrinsics.checkNotNullExpressionValue(inflate2, "apply(...)");
                    viewBinding = inflate2;
                } else {
                    FragmentDeviceSettingsBinding inflate3 = FragmentDeviceSettingsBinding.inflate(layoutInflater, viewGroup, false);
                    inflate3.getRoot().setOnClickListener(new DeviceSettingsFragment$$ExternalSyntheticLambda2(this));
                    Intrinsics.checkNotNullExpressionValue(inflate3, "apply(...)");
                    viewBinding = inflate3;
                }
            }
            this.binding = viewBinding;
            if (viewBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewBinding2 = viewBinding;
            }
            View root = viewBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private static final void onCreateView$gotoDeviceSettings(DeviceSettingsFragment deviceSettingsFragment) {
        Context context = deviceSettingsFragment.getContext();
        if (context != null) {
            DeviceSettingsActivity.Companion companion = DeviceSettingsActivity.Companion;
            Device device2 = deviceSettingsFragment.device;
            if (device2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("device");
                device2 = null;
            }
            companion.launch(context, device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$2$lambda$1(DeviceSettingsFragment deviceSettingsFragment, View view) {
        onCreateView$gotoDeviceSettings(deviceSettingsFragment);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4$lambda$3(DeviceSettingsFragment deviceSettingsFragment, View view) {
        onCreateView$gotoDeviceSettings(deviceSettingsFragment);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$6$lambda$5(DeviceSettingsFragment deviceSettingsFragment, View view) {
        onCreateView$gotoDeviceSettings(deviceSettingsFragment);
    }
}
