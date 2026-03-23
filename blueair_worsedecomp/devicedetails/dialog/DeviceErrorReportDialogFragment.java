package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCompatibility;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceErrorReportBinding;
import com.blueair.devicedetails.viewholder.DeviceInfoItem;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import io.flatcircle.connectivityhelper.NetUtil;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceErrorReportDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceErrorReportBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceErrorReportDialogFragment.kt */
public final class DeviceErrorReportDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public Device device;
    private DialogfragmentDeviceErrorReportBinding viewDataBinding;

    public final Device getDevice() {
        Device device2 = this.device;
        if (device2 != null) {
            return device2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "<set-?>");
        this.device = device2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.DialogTheme);
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                window.setLayout(-1, -2);
            }
            Window window2 = dialog.getWindow();
            if (window2 != null) {
                window2.setGravity(80);
            }
        }
    }

    public void onStop() {
        Window window;
        WindowManager.LayoutParams attributes;
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation_exit_only;
        }
        super.onStop();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
        Dialog dialog = new Dialog(requireContext());
        Timber.Forest forest = Timber.Forest;
        forest.d("onCreateDialog: dialog = " + dialog, new Object[0]);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.top_rounded_rectangle_white));
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentDeviceErrorReportBinding inflate = DialogfragmentDeviceErrorReportBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        DialogfragmentDeviceErrorReportBinding dialogfragmentDeviceErrorReportBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        inflate.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new DeviceErrorReportDialogFragment$$ExternalSyntheticLambda0(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Resources resources = getResources();
        int i = com.blueair.devicedetails.R.drawable.item_decoration;
        FragmentActivity activity = getActivity();
        Drawable drawable = ResourcesCompat.getDrawable(resources, i, activity != null ? activity.getTheme() : null);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        DialogfragmentDeviceErrorReportBinding dialogfragmentDeviceErrorReportBinding2 = this.viewDataBinding;
        if (dialogfragmentDeviceErrorReportBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceErrorReportBinding2 = null;
        }
        dialogfragmentDeviceErrorReportBinding2.recyclerViewDeviceInfo.addItemDecoration(dividerItemDecoration);
        DialogfragmentDeviceErrorReportBinding dialogfragmentDeviceErrorReportBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceErrorReportBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceErrorReportBinding = dialogfragmentDeviceErrorReportBinding3;
        }
        View root = dialogfragmentDeviceErrorReportBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2(DeviceErrorReportDialogFragment deviceErrorReportDialogFragment, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "it");
        deviceErrorReportDialogFragment.dismiss();
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        Window window;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation;
        }
        Bundle arguments = getArguments();
        DialogfragmentDeviceErrorReportBinding dialogfragmentDeviceErrorReportBinding = null;
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            Device device3 = getDevice();
            if (device3 instanceof HasSKU) {
                Device device4 = getDevice();
                Intrinsics.checkNotNull(device4, "null cannot be cast to non-null type com.blueair.core.model.HasSKU");
                str = ((HasSKU) device4).getSku();
            } else if (device3 instanceof HasCompatibility) {
                Device device5 = getDevice();
                Intrinsics.checkNotNull(device5, "null cannot be cast to non-null type com.blueair.core.model.HasCompatibility");
                str = ((HasCompatibility) device5).getCompatibility();
            } else {
                str = getDevice().getModelName();
            }
            ItemAdapter itemAdapter = new ItemAdapter();
            itemAdapter.add((Object[]) new DeviceInfoItem[]{new DeviceInfoItem(TuplesKt.to("App version", "v 4.4.0 (2272)")), new DeviceInfoItem(TuplesKt.to("Phone model", Build.DEVICE + TokenParser.SP + Build.MODEL)), new DeviceInfoItem(TuplesKt.to("Phone OS version", String.valueOf(Build.VERSION.SDK_INT))), new DeviceInfoItem(TuplesKt.to("Device UUID", String.valueOf(getDevice().getUid()))), new DeviceInfoItem(TuplesKt.to("Device SKU", String.valueOf(str))), new DeviceInfoItem(TuplesKt.to("Device MAC", String.valueOf(getDevice().getMac()))), new DeviceInfoItem(TuplesKt.to("Wifi info", String.valueOf(NetUtil.INSTANCE.getActiveWifiInfo(getContext()))))});
            FastAdapter with = FastAdapter.Companion.with(itemAdapter);
            DialogfragmentDeviceErrorReportBinding dialogfragmentDeviceErrorReportBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceErrorReportBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceErrorReportBinding = dialogfragmentDeviceErrorReportBinding2;
            }
            dialogfragmentDeviceErrorReportBinding.recyclerViewDeviceInfo.swapAdapter(with, false);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceErrorReportDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceErrorReportDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceErrorReportDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceErrorReportDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceErrorReportDialogFragment deviceErrorReportDialogFragment = new DeviceErrorReportDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            deviceErrorReportDialogFragment.setArguments(bundle);
            return deviceErrorReportDialogFragment;
        }
    }
}
