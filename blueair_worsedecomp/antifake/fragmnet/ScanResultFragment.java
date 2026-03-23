package com.blueair.antifake.fragmnet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.antifake.databinding.FragmentScanResultBinding;
import com.blueair.antifake.dialog.BluetoothInstructionsDialog;
import com.blueair.antifake.dialog.ManualResetFilterDialog;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.extensions.TextViewExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J(\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020 H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/blueair/antifake/fragmnet/ScanResultFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentScanResultBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setContent", "icon", "", "title", "message", "code", "", "setButtons", "isCorrect", "", "showProgress", "shouldShowProgress", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScanResultFragment.kt */
public final class ScanResultFragment extends BaseFragment<AntiFakeViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentScanResultBinding binding;
    public AntiFakeViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScanResultFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.antifake.viewmodel.ScanResult[] r0 = com.blueair.antifake.viewmodel.ScanResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.antifake.viewmodel.ScanResult r1 = com.blueair.antifake.viewmodel.ScanResult.CORRECT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.antifake.viewmodel.ScanResult r1 = com.blueair.antifake.viewmodel.ScanResult.REPEAT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.antifake.viewmodel.ScanResult r1 = com.blueair.antifake.viewmodel.ScanResult.INVALID     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.antifake.viewmodel.ScanResult r1 = com.blueair.antifake.viewmodel.ScanResult.UNRECOG     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.antifake.viewmodel.ScanResult r1 = com.blueair.antifake.viewmodel.ScanResult.NETWORK     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.fragmnet.ScanResultFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/antifake/fragmnet/ScanResultFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/ScanResultFragment;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ScanResultFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ScanResultFragment newInstance() {
            return new ScanResultFragment();
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
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentScanResultBinding inflate = FragmentScanResultBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AntiFakeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AntiFakeViewModel.class)));
        int i = WhenMappings.$EnumSwitchMapping$0[getViewModel().getVerifyResult().ordinal()];
        FragmentScanResultBinding fragmentScanResultBinding = null;
        if (i == 1) {
            setContent(R.drawable.ic_scan_result_correct, R.string.scan_result_correct, R.string.correct_query_desc, getViewModel().getCode());
            setButtons(true);
        } else if (i == 2) {
            setContent(R.drawable.ic_scan_result_repeat, R.string.scan_result_repeat, R.string.repeat_verification_desc, getViewModel().getCode());
            setButtons(false);
        } else if (i == 3) {
            setContent(R.drawable.ic_scan_result_invalid, R.string.error_code, R.string.error_code_desc, getViewModel().getCode());
            setButtons(false);
        } else if (i == 4) {
            setContent(R.drawable.ic_scan_result_unrecognizable, R.string.scan_result_unrecognizable, R.string.scan_result_unrecognizable_hint, getViewModel().getCode());
            FragmentScanResultBinding fragmentScanResultBinding2 = this.binding;
            if (fragmentScanResultBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanResultBinding2 = null;
            }
            Group group = fragmentScanResultBinding2.groupCode;
            Intrinsics.checkNotNullExpressionValue(group, "groupCode");
            ViewExtensionsKt.hide(group);
            setButtons(false);
        } else if (i == 5) {
            FragmentScanResultBinding fragmentScanResultBinding3 = this.binding;
            if (fragmentScanResultBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanResultBinding3 = null;
            }
            fragmentScanResultBinding3.stateLoadingFailed.getRoot().setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda1(this));
            FragmentScanResultBinding fragmentScanResultBinding4 = this.binding;
            if (fragmentScanResultBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanResultBinding4 = null;
            }
            ConstraintLayout root = fragmentScanResultBinding4.stateLoadingFailed.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            ViewExtensionsKt.show$default(root, false, 1, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        FragmentScanResultBinding fragmentScanResultBinding5 = this.binding;
        if (fragmentScanResultBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentScanResultBinding = fragmentScanResultBinding5;
        }
        ConstraintLayout root2 = fragmentScanResultBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
        return root2;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(ScanResultFragment scanResultFragment, View view) {
        scanResultFragment.getViewModel().retryValidateCode();
    }

    public void onViewCreated(View view, Bundle bundle) {
        HasSKU device;
        DialogFragment dialogFragment;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        if (getViewModel().getRetryViaBluetooth() && (device = getViewModel().getDevice()) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<BluetoothInstructionsDialog> cls = BluetoothInstructionsDialog.class;
            Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
            if ((childFragmentManager.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) || childFragmentManager.isStateSaved()) {
                dialogFragment = null;
            } else {
                dialogFragment = BluetoothInstructionsDialog.Companion.newInstance(new ScanResultFragment$$ExternalSyntheticLambda0(this, device));
                dialogFragment.show(childFragmentManager, "BluetoothInstructionsDialog");
            }
            BluetoothInstructionsDialog bluetoothInstructionsDialog = (BluetoothInstructionsDialog) dialogFragment;
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3$lambda$2$lambda$1(ScanResultFragment scanResultFragment, HasSKU hasSKU) {
        scanResultFragment.getViewModel().scanBluetooth(hasSKU.getMac());
        return Unit.INSTANCE;
    }

    private final void setContent(int i, int i2, int i3, String str) {
        FragmentScanResultBinding fragmentScanResultBinding = this.binding;
        FragmentScanResultBinding fragmentScanResultBinding2 = null;
        if (fragmentScanResultBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanResultBinding = null;
        }
        fragmentScanResultBinding.imageCodeStatus.setImageResource(i);
        FragmentScanResultBinding fragmentScanResultBinding3 = this.binding;
        if (fragmentScanResultBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanResultBinding3 = null;
        }
        fragmentScanResultBinding3.titleCodeStatus.setText(i2);
        FragmentScanResultBinding fragmentScanResultBinding4 = this.binding;
        if (fragmentScanResultBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanResultBinding4 = null;
        }
        fragmentScanResultBinding4.infoCodeStatus.setText(i3);
        FragmentScanResultBinding fragmentScanResultBinding5 = this.binding;
        if (fragmentScanResultBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentScanResultBinding2 = fragmentScanResultBinding5;
        }
        fragmentScanResultBinding2.securityCode.setText(str);
    }

    private final void setButtons(boolean z) {
        FragmentScanResultBinding fragmentScanResultBinding = null;
        if (z) {
            if (getViewModel().getDeviceMismatch()) {
                FragmentScanResultBinding fragmentScanResultBinding2 = this.binding;
                if (fragmentScanResultBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragmentScanResultBinding2 = null;
                }
                MaterialButton materialButton = fragmentScanResultBinding2.btnResetFilter;
                Intrinsics.checkNotNullExpressionValue(materialButton, "btnResetFilter");
                ViewExtensionsKt.hide(materialButton);
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.device_mismatch, (Integer) null, R.string.device_filter_mismatch, Integer.valueOf(R.string.add_device_success_btn_okay), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(getChildFragmentManager(), (String) null);
            } else if (getViewModel().getFilterMismatch()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.prompt, (Integer) null, getViewModel().getTargetType() == DeviceFilterType.FILTER ? R.string.type_mismatch_wick_on_filter : R.string.type_mismatch_filter_on_wick, Integer.valueOf(R.string.add_device_success_btn_okay), (Integer) null, false, false, false, true, (String[]) null, (String) null, (Function1) null, 3808, (Object) null).show(getChildFragmentManager(), (String) null);
            }
            FragmentScanResultBinding fragmentScanResultBinding3 = this.binding;
            if (fragmentScanResultBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanResultBinding3 = null;
            }
            fragmentScanResultBinding3.btnResetFilter.setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda3(this));
            FragmentScanResultBinding fragmentScanResultBinding4 = this.binding;
            if (fragmentScanResultBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentScanResultBinding4 = null;
            }
            MaterialButton materialButton2 = fragmentScanResultBinding4.btnCustomerSupport;
            Intrinsics.checkNotNullExpressionValue(materialButton2, "btnCustomerSupport");
            ViewExtensionsKt.hide(materialButton2);
            FragmentScanResultBinding fragmentScanResultBinding5 = this.binding;
            if (fragmentScanResultBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragmentScanResultBinding = fragmentScanResultBinding5;
            }
            TextView textView = fragmentScanResultBinding.btnManualReset;
            Intrinsics.checkNotNullExpressionValue(textView, "btnManualReset");
            ViewExtensionsKt.hide(textView);
            return;
        }
        FragmentScanResultBinding fragmentScanResultBinding6 = this.binding;
        if (fragmentScanResultBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanResultBinding6 = null;
        }
        MaterialButton materialButton3 = fragmentScanResultBinding6.btnResetFilter;
        Intrinsics.checkNotNullExpressionValue(materialButton3, "btnResetFilter");
        ViewExtensionsKt.hide(materialButton3);
        FragmentScanResultBinding fragmentScanResultBinding7 = this.binding;
        if (fragmentScanResultBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanResultBinding7 = null;
        }
        fragmentScanResultBinding7.btnCustomerSupport.setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda4(this));
        FragmentScanResultBinding fragmentScanResultBinding8 = this.binding;
        if (fragmentScanResultBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentScanResultBinding8 = null;
        }
        TextView textView2 = fragmentScanResultBinding8.btnManualReset;
        Intrinsics.checkNotNullExpressionValue(textView2, "btnManualReset");
        TextViewExtensionsKt.underlineText(textView2);
        FragmentScanResultBinding fragmentScanResultBinding9 = this.binding;
        if (fragmentScanResultBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentScanResultBinding = fragmentScanResultBinding9;
        }
        fragmentScanResultBinding.btnManualReset.setOnClickListener(new ScanResultFragment$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    public static final void setButtons$lambda$7(ScanResultFragment scanResultFragment, View view) {
        HasSKU device = scanResultFragment.getViewModel().getDevice();
        if (device == null || device.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
            scanResultFragment.getViewModel().resetFilter();
            return;
        }
        FragmentManager childFragmentManager = scanResultFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<BluetoothInstructionsDialog> cls = BluetoothInstructionsDialog.class;
        Intrinsics.checkNotNullExpressionValue("BluetoothInstructionsDialog", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("BluetoothInstructionsDialog") instanceof BluetoothInstructionsDialog) && !childFragmentManager.isStateSaved()) {
            BluetoothInstructionsDialog.Companion.newInstance(new ScanResultFragment$$ExternalSyntheticLambda2(scanResultFragment)).show(childFragmentManager, "BluetoothInstructionsDialog");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit setButtons$lambda$7$lambda$6$lambda$5(ScanResultFragment scanResultFragment) {
        AntiFakeViewModel viewModel2 = scanResultFragment.getViewModel();
        HasSKU device = scanResultFragment.getViewModel().getDevice();
        Intrinsics.checkNotNull(device);
        viewModel2.scanBluetooth(device.getMac());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void setButtons$lambda$8(ScanResultFragment scanResultFragment, View view) {
        scanResultFragment.startActivity(Actions.INSTANCE.openDialerIntent(AntiFakeViewModel.CUSTOMER_SUPPORT_TEL));
    }

    /* access modifiers changed from: private */
    public static final void setButtons$lambda$10(ScanResultFragment scanResultFragment, View view) {
        FragmentManager childFragmentManager = scanResultFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ManualResetFilterDialog> cls = ManualResetFilterDialog.class;
        Intrinsics.checkNotNullExpressionValue("ManualResetFilterDialog", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ManualResetFilterDialog") instanceof ManualResetFilterDialog) && !childFragmentManager.isStateSaved()) {
            ManualResetFilterDialog.Companion.newInstance(scanResultFragment.getViewModel().getFilterType()).show(childFragmentManager, "ManualResetFilterDialog");
        }
    }
}
