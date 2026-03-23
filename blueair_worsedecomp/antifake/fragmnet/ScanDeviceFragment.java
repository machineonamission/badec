package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blueair.adddevice.dialog.ConnectInstructionsDialog;
import com.blueair.antifake.adapter.SearchedDevice;
import com.blueair.antifake.adapter.SearchedDeviceAdapter;
import com.blueair.antifake.databinding.FragmentScanDeviceBinding;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u000fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/blueair/antifake/fragmnet/ScanDeviceFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentScanDeviceBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "adapter", "Lcom/blueair/antifake/adapter/SearchedDeviceAdapter;", "deviceFounded", "", "pendingConnectableDevice", "Lcom/blueair/core/model/BluetoothDevice;", "connectInstructionsDialog", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "launchTroubleshootingTask", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "showProgress", "shouldShowProgress", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScanDeviceFragment.kt */
public final class ScanDeviceFragment extends BaseFragment<AntiFakeViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final SearchedDeviceAdapter adapter = new SearchedDeviceAdapter();
    /* access modifiers changed from: private */
    public FragmentScanDeviceBinding binding;
    /* access modifiers changed from: private */
    public ConnectInstructionsDialog connectInstructionsDialog;
    /* access modifiers changed from: private */
    public boolean deviceFounded;
    /* access modifiers changed from: private */
    public BluetoothDevice pendingConnectableDevice;
    public AntiFakeViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/antifake/fragmnet/ScanDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/ScanDeviceFragment;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScanDeviceFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScanDeviceFragment newInstance() {
            return new ScanDeviceFragment();
        }
    }

    public AntiFakeViewModel getViewModel() {
        AntiFakeViewModel antiFakeViewModel = this.viewModel;
        if (antiFakeViewModel != null) {
            return antiFakeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(AntiFakeViewModel antiFakeViewModel) {
        Intrinsics.checkNotNullParameter(antiFakeViewModel, "<set-?>");
        this.viewModel = antiFakeViewModel;
    }

    /* access modifiers changed from: private */
    public final void launchTroubleshootingTask() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new ScanDeviceFragment$launchTroubleshootingTask$1(this, (Continuation<? super ScanDeviceFragment$launchTroubleshootingTask$1>) null), 3, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentScanDeviceBinding inflate = FragmentScanDeviceBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AntiFakeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AntiFakeViewModel.class)));
        getViewModel().startBluetoothScanning();
        showProgress(true);
        launchTroubleshootingTask();
        FragmentScanDeviceBinding fragmentScanDeviceBinding = null;
        if (getViewModel().getResetDeviceWifiMac().length() == 0) {
            FragmentScanDeviceBinding fragmentScanDeviceBinding2 = this.binding;
            if (fragmentScanDeviceBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanDeviceBinding2 = null;
            }
            fragmentScanDeviceBinding2.deviceList.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            FragmentScanDeviceBinding fragmentScanDeviceBinding3 = this.binding;
            if (fragmentScanDeviceBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanDeviceBinding3 = null;
            }
            fragmentScanDeviceBinding3.deviceList.setAdapter(this.adapter);
            this.adapter.setAcceptedSkus(CollectionsKt.toSet(getViewModel().getFilterSupportedDeviceSku()));
            this.adapter.setOnDeviceSelectedListener(new ScanDeviceFragment$$ExternalSyntheticLambda0(this));
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new ScanDeviceFragment$onCreateView$2(this, (Continuation<? super ScanDeviceFragment$onCreateView$2>) null), 3, (Object) null);
        } else {
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), (CoroutineContext) null, (CoroutineStart) null, new ScanDeviceFragment$onCreateView$3(this, (Continuation<? super ScanDeviceFragment$onCreateView$3>) null), 3, (Object) null);
        }
        FragmentScanDeviceBinding fragmentScanDeviceBinding4 = this.binding;
        if (fragmentScanDeviceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanDeviceBinding4 = null;
        }
        fragmentScanDeviceBinding4.btnCustomerSupport.setOnClickListener(new ScanDeviceFragment$$ExternalSyntheticLambda1(this));
        FragmentScanDeviceBinding fragmentScanDeviceBinding5 = this.binding;
        if (fragmentScanDeviceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentScanDeviceBinding = fragmentScanDeviceBinding5;
        }
        ConstraintLayout root = fragmentScanDeviceBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3(ScanDeviceFragment scanDeviceFragment, SearchedDevice searchedDevice) {
        DialogFragment dialogFragment;
        Intrinsics.checkNotNullParameter(searchedDevice, "searchedDevice");
        BluetoothDevice bluetoothDevice = searchedDevice.getBluetoothDevice();
        if (bluetoothDevice == null) {
            return Unit.INSTANCE;
        }
        if (bluetoothDevice.getConnectable()) {
            scanDeviceFragment.getViewModel().resetFilterByBluetooth(bluetoothDevice);
        } else {
            FragmentManager childFragmentManager = scanDeviceFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConnectInstructionsDialog> cls = ConnectInstructionsDialog.class;
            Intrinsics.checkNotNullExpressionValue(ConnectInstructionsDialog.REQUEST_KEY, "getSimpleName(...)");
            if ((childFragmentManager.findFragmentByTag(ConnectInstructionsDialog.REQUEST_KEY) instanceof ConnectInstructionsDialog) || childFragmentManager.isStateSaved()) {
                dialogFragment = null;
            } else {
                dialogFragment = ConnectInstructionsDialog.Companion.newInstance$default(ConnectInstructionsDialog.Companion, bluetoothDevice.getFamilyName(), bluetoothDevice.getHasNoAutoButton() ? ConnectInstructionsDialog.ACTION_FAN_SPEED : ConnectInstructionsDialog.ACTION_AUTO, bluetoothDevice, false, 8, (Object) null);
                dialogFragment.show(childFragmentManager, ConnectInstructionsDialog.REQUEST_KEY);
            }
            ConnectInstructionsDialog connectInstructionsDialog2 = (ConnectInstructionsDialog) dialogFragment;
            if (connectInstructionsDialog2 != null) {
                scanDeviceFragment.pendingConnectableDevice = bluetoothDevice;
                scanDeviceFragment.connectInstructionsDialog = connectInstructionsDialog2;
                FragmentExtensionsKt.setFragmentResultListenerWithClear(connectInstructionsDialog2, ConnectInstructionsDialog.REQUEST_KEY, new ScanDeviceFragment$$ExternalSyntheticLambda2(scanDeviceFragment));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3$lambda$2$lambda$1(ScanDeviceFragment scanDeviceFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        scanDeviceFragment.pendingConnectableDevice = null;
        scanDeviceFragment.connectInstructionsDialog = null;
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4(ScanDeviceFragment scanDeviceFragment, View view) {
        scanDeviceFragment.startActivity(Actions.INSTANCE.openDialerIntent(AntiFakeViewModel.CUSTOMER_SUPPORT_TEL));
    }

    public void onResume() {
        super.onResume();
        if (getViewModel().isBluetoothEnabled() && !getViewModel().isBluetoothScanning()) {
            getViewModel().startBluetoothScanning();
        }
    }

    public void onPause() {
        super.onPause();
        if (getViewModel().isBluetoothScanning()) {
            getViewModel().resetBluetoothScanning();
        }
    }

    public void showProgress(boolean z) {
        FragmentScanDeviceBinding fragmentScanDeviceBinding = this.binding;
        if (fragmentScanDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanDeviceBinding = null;
        }
        LinearLayout linearLayout = fragmentScanDeviceBinding.scanningViewCenter;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "scanningViewCenter");
        ViewExtensionsKt.show(linearLayout, z);
    }
}
