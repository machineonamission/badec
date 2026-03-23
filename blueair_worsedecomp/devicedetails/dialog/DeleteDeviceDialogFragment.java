package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.DialogfragmentDeleteDeviceBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u001eH\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001d\u0010\u001f¨\u00064"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeleteDeviceDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeleteDeviceBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "isFromActivity", "", "()Z", "isFromActivity$delegate", "Lkotlin/Lazy;", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "showProgress", "shouldShowProgress", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeleteDeviceDialogFragment.kt */
public final class DeleteDeviceDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> implements ProgressFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_IS_FROM_ACTIVITY = "EXTRA_IS_FROM_ACTIVITY";
    public Device device;
    private final Lazy isFromActivity$delegate = LazyKt.lazy(new DeleteDeviceDialogFragment$$ExternalSyntheticLambda0(this));
    private ProgressBlockerView progressBlockerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_DELETE;
    private DialogfragmentDeleteDeviceBinding viewDataBinding;
    public DeviceDetailsViewModel viewModel;

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeleteDeviceDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_IS_FROM_ACTIVITY", "", "newInstance", "Lcom/blueair/devicedetails/dialog/DeleteDeviceDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "isFromActivity", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeleteDeviceDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeleteDeviceDialogFragment newInstance(Device device, boolean z) {
            Intrinsics.checkNotNullParameter(device, "device");
            DeleteDeviceDialogFragment deleteDeviceDialogFragment = new DeleteDeviceDialogFragment();
            deleteDeviceDialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to("device", device), TuplesKt.to(DeleteDeviceDialogFragment.EXTRA_IS_FROM_ACTIVITY, Boolean.valueOf(z))));
            return deleteDeviceDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
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

    public DeviceDetailsViewModel getViewModel() {
        DeviceDetailsViewModel deviceDetailsViewModel = this.viewModel;
        if (deviceDetailsViewModel != null) {
            return deviceDetailsViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(DeviceDetailsViewModel deviceDetailsViewModel) {
        Intrinsics.checkNotNullParameter(deviceDetailsViewModel, "<set-?>");
        this.viewModel = deviceDetailsViewModel;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    /* access modifiers changed from: private */
    public static final boolean isFromActivity_delegate$lambda$0(DeleteDeviceDialogFragment deleteDeviceDialogFragment) {
        Bundle arguments = deleteDeviceDialogFragment.getArguments();
        if (arguments != null) {
            return arguments.getBoolean(EXTRA_IS_FROM_ACTIVITY);
        }
        return false;
    }

    public final boolean isFromActivity() {
        return ((Boolean) this.isFromActivity$delegate.getValue()).booleanValue();
    }

    public ConstraintLayout getRootView() {
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding = this.viewDataBinding;
        if (dialogfragmentDeleteDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeleteDeviceBinding = null;
        }
        ConstraintLayout constraintLayout = dialogfragmentDeleteDeviceBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        FragmentActivity activity = getActivity();
        View view = null;
        LayoutInflater layoutInflater = activity != null ? activity.getLayoutInflater() : null;
        if (layoutInflater != null) {
            view = layoutInflater.inflate(R.layout.dialogfragment_delete_device, (ViewGroup) null);
        }
        Dialog dialog = new Dialog(requireContext());
        if (view != null) {
            dialog.setContentView(view);
        }
        FragmentActivity activity2 = getActivity();
        if (!(activity2 == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity2, com.blueair.viewcore.R.drawable.rounded_rectangle_white));
        }
        dialog.show();
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentDeleteDeviceBinding inflate = DialogfragmentDeleteDeviceBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.viewDataBinding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(DeviceDetailsViewModel.class)));
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding = this.viewDataBinding;
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding2 = null;
        if (dialogfragmentDeleteDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeleteDeviceBinding = null;
        }
        setProgressBlockerView(dialogfragmentDeleteDeviceBinding.progressView);
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding3 = this.viewDataBinding;
        if (dialogfragmentDeleteDeviceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeleteDeviceBinding3 = null;
        }
        dialogfragmentDeleteDeviceBinding3.cancelView.setOnClickListener(new DeleteDeviceDialogFragment$$ExternalSyntheticLambda1(this));
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding4 = this.viewDataBinding;
        if (dialogfragmentDeleteDeviceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeleteDeviceBinding4 = null;
        }
        dialogfragmentDeleteDeviceBinding4.okView.setOnClickListener(new DeleteDeviceDialogFragment$$ExternalSyntheticLambda2(this));
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding5 = this.viewDataBinding;
        if (dialogfragmentDeleteDeviceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            dialogfragmentDeleteDeviceBinding2 = dialogfragmentDeleteDeviceBinding5;
        }
        return dialogfragmentDeleteDeviceBinding2.getRoot();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3(DeleteDeviceDialogFragment deleteDeviceDialogFragment, View view) {
        deleteDeviceDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4(DeleteDeviceDialogFragment deleteDeviceDialogFragment, View view) {
        Dialog dialog = deleteDeviceDialogFragment.getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
        Dialog dialog2 = deleteDeviceDialogFragment.getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(deleteDeviceDialogFragment.getViewModel(), (CoroutineContext) null, (CoroutineStart) null, new DeleteDeviceDialogFragment$onCreateView$2$1(deleteDeviceDialogFragment, (Continuation<? super DeleteDeviceDialogFragment$onCreateView$2$1>) null), 3, (Object) null);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding = null;
        Device device2 = arguments != null ? (Device) arguments.getParcelable("device") : null;
        if (device2 != null) {
            setDevice(device2);
            DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding2 = this.viewDataBinding;
            if (dialogfragmentDeleteDeviceBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeleteDeviceBinding2 = null;
            }
            dialogfragmentDeleteDeviceBinding2.dialogTitle.setText(getString(com.blueair.viewcore.R.string.delete_product_title, getDevice().getName()));
            DialogfragmentDeleteDeviceBinding dialogfragmentDeleteDeviceBinding3 = this.viewDataBinding;
            if (dialogfragmentDeleteDeviceBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeleteDeviceBinding = dialogfragmentDeleteDeviceBinding3;
            }
            dialogfragmentDeleteDeviceBinding.dialogMsg.setText(getString(com.blueair.viewcore.R.string.delete_confirmation_msg, getDevice().getName()));
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }
}
