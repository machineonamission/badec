package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
import com.blueair.antifake.databinding.FragmentSearchDeviceBinding;
import com.blueair.antifake.dialog.BluetoothInstructionsDialog;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.extensions.TextViewExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0002J\u001a\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/blueair/antifake/fragmnet/SearchDeviceFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentSearchDeviceBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "adapter", "Lcom/blueair/antifake/adapter/SearchedDeviceAdapter;", "pendingConnectableDevice", "Lcom/blueair/core/model/BluetoothDevice;", "connectInstructionsDialog", "Lcom/blueair/adddevice/dialog/ConnectInstructionsDialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "doBluetoothReset", "", "device", "onViewCreated", "view", "onResume", "onPause", "showProgress", "shouldShowProgress", "", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SearchDeviceFragment.kt */
public final class SearchDeviceFragment extends BaseFragment<AntiFakeViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final SearchedDeviceAdapter adapter = new SearchedDeviceAdapter();
    /* access modifiers changed from: private */
    public FragmentSearchDeviceBinding binding;
    /* access modifiers changed from: private */
    public ConnectInstructionsDialog connectInstructionsDialog;
    /* access modifiers changed from: private */
    public BluetoothDevice pendingConnectableDevice;
    public AntiFakeViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/antifake/fragmnet/SearchDeviceFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/SearchDeviceFragment;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SearchDeviceFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SearchDeviceFragment newInstance() {
            return new SearchDeviceFragment();
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflater2 = layoutInflater;
        Intrinsics.checkNotNullParameter(layoutInflater2, "inflater");
        FragmentSearchDeviceBinding inflate = FragmentSearchDeviceBinding.inflate(layoutInflater2, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AntiFakeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AntiFakeViewModel.class)));
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding = this.binding;
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding2 = null;
        if (fragmentSearchDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchDeviceBinding = null;
        }
        fragmentSearchDeviceBinding.deviceList.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding3 = this.binding;
        if (fragmentSearchDeviceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchDeviceBinding3 = null;
        }
        fragmentSearchDeviceBinding3.deviceList.setAdapter(this.adapter);
        this.adapter.setAcceptedSkus(CollectionsKt.toSet(getViewModel().getFilterSupportedDeviceSku()));
        this.adapter.setOnDeviceSelectedListener(new SearchDeviceFragment$$ExternalSyntheticLambda1(this));
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding4 = this.binding;
        if (fragmentSearchDeviceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchDeviceBinding4 = null;
        }
        fragmentSearchDeviceBinding4.btnCustomerSupport.setOnClickListener(new SearchDeviceFragment$$ExternalSyntheticLambda2(this));
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding5 = this.binding;
        if (fragmentSearchDeviceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchDeviceBinding5 = null;
        }
        TextView textView = fragmentSearchDeviceBinding5.btnDeviceNotFound;
        Intrinsics.checkNotNullExpressionValue(textView, "btnDeviceNotFound");
        TextViewExtensionsKt.underlineText(textView);
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding6 = this.binding;
        if (fragmentSearchDeviceBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchDeviceBinding6 = null;
        }
        fragmentSearchDeviceBinding6.btnDeviceNotFound.setOnClickListener(new SearchDeviceFragment$$ExternalSyntheticLambda3(this));
        showProgress(true);
        if (getViewModel().isBluetoothEnabled()) {
            getViewModel().startBluetoothScanning();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new SearchDeviceFragment$onCreateView$4(this, (Continuation<? super SearchDeviceFragment$onCreateView$4>) null), 3, (Object) null);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new SearchDeviceFragment$onCreateView$5(this, (Continuation<? super SearchDeviceFragment$onCreateView$5>) null), 3, (Object) null);
        }
        getViewModel().getLiveDevices().observe(getViewLifecycleOwner(), new SearchDeviceFragment$sam$androidx_lifecycle_Observer$0(new SearchDeviceFragment$$ExternalSyntheticLambda4(this)));
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding7 = this.binding;
        if (fragmentSearchDeviceBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentSearchDeviceBinding2 = fragmentSearchDeviceBinding7;
        }
        ConstraintLayout root = fragmentSearchDeviceBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$4(SearchDeviceFragment searchDeviceFragment, SearchedDevice searchedDevice) {
        SearchDeviceFragment searchDeviceFragment2 = searchDeviceFragment;
        SearchedDevice searchedDevice2 = searchedDevice;
        Intrinsics.checkNotNullParameter(searchedDevice2, "device");
        if (searchedDevice2.isOnboarded()) {
            Device device = searchedDevice2.getDevice();
            Intrinsics.checkNotNull(device);
            HasSKU hasSKU = (HasSKU) device;
            if (searchedDevice2.isOnline()) {
                FragmentManager childFragmentManager = searchDeviceFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
                Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
                Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
                if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                    ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.confirm_reset, (Integer) null, R.string.confirm_reset_desc, Integer.valueOf(R.string.reset), Integer.valueOf(R.string.btn_cancel), false, false, false, true, (String[]) null, (String) null, new SearchDeviceFragment$$ExternalSyntheticLambda5(searchDeviceFragment2, hasSKU), 1632, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                }
            } else if (searchedDevice2.getBluetoothAvailable()) {
                BluetoothDevice bluetoothDevice = searchedDevice2.getBluetoothDevice();
                Intrinsics.checkNotNull(bluetoothDevice);
                searchDeviceFragment2.doBluetoothReset(bluetoothDevice);
            } else {
                FragmentManager childFragmentManager2 = searchDeviceFragment2.getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "getChildFragmentManager(...)");
                Class<BluetoothInstructionsDialog> cls2 = BluetoothInstructionsDialog.class;
                Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
                if (!(childFragmentManager2.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !childFragmentManager2.isStateSaved()) {
                    BluetoothInstructionsDialog.Companion.newInstance(new SearchDeviceFragment$$ExternalSyntheticLambda6(searchDeviceFragment2, hasSKU)).show(childFragmentManager2, "BluetoothInstructionsDialog");
                }
            }
        } else if (searchedDevice2.getBluetoothAvailable()) {
            BluetoothDevice bluetoothDevice2 = searchedDevice2.getBluetoothDevice();
            Intrinsics.checkNotNull(bluetoothDevice2);
            searchDeviceFragment2.doBluetoothReset(bluetoothDevice2);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$4$lambda$1$lambda$0(SearchDeviceFragment searchDeviceFragment, HasSKU hasSKU, boolean z) {
        if (z) {
            searchDeviceFragment.getViewModel().resetFilter(hasSKU);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$4$lambda$3$lambda$2(SearchDeviceFragment searchDeviceFragment, HasSKU hasSKU) {
        searchDeviceFragment.getViewModel().scanBluetooth(hasSKU.getMac());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5(SearchDeviceFragment searchDeviceFragment, View view) {
        searchDeviceFragment.startActivity(Actions.INSTANCE.openDialerIntent(AntiFakeViewModel.CUSTOMER_SUPPORT_TEL));
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$8(SearchDeviceFragment searchDeviceFragment, View view) {
        FragmentManager childFragmentManager = searchDeviceFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<BluetoothInstructionsDialog> cls = BluetoothInstructionsDialog.class;
        Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !childFragmentManager.isStateSaved()) {
            BluetoothInstructionsDialog.Companion.newInstance(new SearchDeviceFragment$$ExternalSyntheticLambda7(searchDeviceFragment)).show(childFragmentManager, "BluetoothInstructionsDialog");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$8$lambda$7$lambda$6(SearchDeviceFragment searchDeviceFragment) {
        searchDeviceFragment.getViewModel().scanBluetooth((String) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$9(SearchDeviceFragment searchDeviceFragment, List list) {
        SearchedDeviceAdapter searchedDeviceAdapter = searchDeviceFragment.adapter;
        Intrinsics.checkNotNull(list);
        searchedDeviceAdapter.updateOnboardedDevices(list);
        if (searchDeviceFragment.adapter.getItemCount() != 0) {
            searchDeviceFragment.showProgress(false);
        } else if (!searchDeviceFragment.getViewModel().isBluetoothScanning()) {
            searchDeviceFragment.showProgress(false);
            FragmentSearchDeviceBinding fragmentSearchDeviceBinding = searchDeviceFragment.binding;
            if (fragmentSearchDeviceBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentSearchDeviceBinding = null;
            }
            MaterialButton materialButton = fragmentSearchDeviceBinding.btnCustomerSupport;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnCustomerSupport");
            ViewExtensionsKt.show$default(materialButton, false, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private final void doBluetoothReset(BluetoothDevice bluetoothDevice) {
        DialogFragment dialogFragment;
        BluetoothDevice bluetoothDevice2;
        if (bluetoothDevice.getConnectable()) {
            getViewModel().resetFilterByBluetooth(bluetoothDevice);
            return;
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConnectInstructionsDialog> cls = ConnectInstructionsDialog.class;
        Intrinsics.checkNotNullExpressionValue(ConnectInstructionsDialog.REQUEST_KEY, "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag(ConnectInstructionsDialog.REQUEST_KEY) instanceof ConnectInstructionsDialog) || childFragmentManager.isStateSaved()) {
            bluetoothDevice2 = bluetoothDevice;
            dialogFragment = null;
        } else {
            bluetoothDevice2 = bluetoothDevice;
            dialogFragment = ConnectInstructionsDialog.Companion.newInstance$default(ConnectInstructionsDialog.Companion, bluetoothDevice.getFamilyName(), bluetoothDevice.getHasNoAutoButton() ? ConnectInstructionsDialog.ACTION_FAN_SPEED : ConnectInstructionsDialog.ACTION_AUTO, bluetoothDevice2, false, 8, (Object) null);
            dialogFragment.show(childFragmentManager, ConnectInstructionsDialog.REQUEST_KEY);
        }
        ConnectInstructionsDialog connectInstructionsDialog2 = (ConnectInstructionsDialog) dialogFragment;
        if (connectInstructionsDialog2 != null) {
            this.pendingConnectableDevice = bluetoothDevice2;
            this.connectInstructionsDialog = connectInstructionsDialog2;
            FragmentExtensionsKt.setFragmentResultListenerWithClear(connectInstructionsDialog2, ConnectInstructionsDialog.REQUEST_KEY, new SearchDeviceFragment$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit doBluetoothReset$lambda$12$lambda$11(SearchDeviceFragment searchDeviceFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "<unused var>");
        searchDeviceFragment.pendingConnectableDevice = null;
        searchDeviceFragment.connectInstructionsDialog = null;
        return Unit.INSTANCE;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        if (getViewModel().getRetryViaBluetooth()) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<BluetoothInstructionsDialog> cls = BluetoothInstructionsDialog.class;
            Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !childFragmentManager.isStateSaved()) {
                BluetoothInstructionsDialog.Companion.newInstance(new SearchDeviceFragment$$ExternalSyntheticLambda8(this)).show(childFragmentManager, "BluetoothInstructionsDialog");
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$14$lambda$13(SearchDeviceFragment searchDeviceFragment) {
        searchDeviceFragment.getViewModel().scanBluetooth(searchDeviceFragment.getViewModel().getResetDeviceWifiMac());
        return Unit.INSTANCE;
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
        FragmentSearchDeviceBinding fragmentSearchDeviceBinding = this.binding;
        if (fragmentSearchDeviceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentSearchDeviceBinding = null;
        }
        ProgressBlockerView progressBlockerView = fragmentSearchDeviceBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        ViewExtensionsKt.show(progressBlockerView, z);
    }
}
