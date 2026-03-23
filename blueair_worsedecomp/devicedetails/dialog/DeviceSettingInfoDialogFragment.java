package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceInfoAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSettingInfoBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.EmptyViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DIAware;
import timber.log.Timber;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u00062"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSettingInfoDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/EmptyViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceSettingInfoBinding;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceInfoAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceInfoAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingInfoDialogFragment.kt */
public final class DeviceSettingInfoDialogFragment extends BaseDialogFragment<EmptyViewModel> implements DIAware {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy adapter$delegate = LazyKt.lazy(new DeviceSettingInfoDialogFragment$$ExternalSyntheticLambda1());
    public Device device;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_INFO;
    private DialogfragmentDeviceSettingInfoBinding viewDataBinding;
    public EmptyViewModel viewModel;

    public void showProgress(boolean z) {
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public EmptyViewModel getViewModel() {
        EmptyViewModel emptyViewModel = this.viewModel;
        if (emptyViewModel != null) {
            return emptyViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(EmptyViewModel emptyViewModel) {
        Intrinsics.checkNotNullParameter(emptyViewModel, "<set-?>");
        this.viewModel = emptyViewModel;
    }

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

    private final DeviceInfoAdapter getAdapter() {
        return (DeviceInfoAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final DeviceInfoAdapter adapter_delegate$lambda$0() {
        return new DeviceInfoAdapter();
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
        setViewModel((EmptyViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(EmptyViewModel.class)));
        DialogfragmentDeviceSettingInfoBinding inflate = DialogfragmentDeviceSettingInfoBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        DialogfragmentDeviceSettingInfoBinding dialogfragmentDeviceSettingInfoBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        inflate.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new DeviceSettingInfoDialogFragment$$ExternalSyntheticLambda0(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Resources resources = getResources();
        int i = com.blueair.devicedetails.R.drawable.item_decoration;
        FragmentActivity activity = getActivity();
        Drawable drawable = ResourcesCompat.getDrawable(resources, i, activity != null ? activity.getTheme() : null);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        DialogfragmentDeviceSettingInfoBinding dialogfragmentDeviceSettingInfoBinding2 = this.viewDataBinding;
        if (dialogfragmentDeviceSettingInfoBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceSettingInfoBinding2 = null;
        }
        dialogfragmentDeviceSettingInfoBinding2.recyclerViewDeviceInfo.addItemDecoration(dividerItemDecoration);
        DialogfragmentDeviceSettingInfoBinding dialogfragmentDeviceSettingInfoBinding3 = this.viewDataBinding;
        if (dialogfragmentDeviceSettingInfoBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeviceSettingInfoBinding = dialogfragmentDeviceSettingInfoBinding3;
        }
        View root = dialogfragmentDeviceSettingInfoBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$3(DeviceSettingInfoDialogFragment deviceSettingInfoDialogFragment, MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "it");
        deviceSettingInfoDialogFragment.dismiss();
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        WindowManager.LayoutParams attributes;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null || (attributes = window.getAttributes()) == null)) {
            attributes.windowAnimations = R.style.dialog_animation;
        }
        Bundle arguments = getArguments();
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onResume() {
        super.onResume();
        DialogfragmentDeviceSettingInfoBinding dialogfragmentDeviceSettingInfoBinding = this.viewDataBinding;
        if (dialogfragmentDeviceSettingInfoBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceSettingInfoBinding = null;
        }
        dialogfragmentDeviceSettingInfoBinding.recyclerViewDeviceInfo.setAdapter(getAdapter());
        getAdapter().setDevice(getDevice());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSettingInfoDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceSettingInfoDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSettingInfoDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceSettingInfoDialogFragment newInstance(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeviceSettingInfoDialogFragment deviceSettingInfoDialogFragment = new DeviceSettingInfoDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", device);
            deviceSettingInfoDialogFragment.setArguments(bundle);
            return deviceSettingInfoDialogFragment;
        }
    }
}
