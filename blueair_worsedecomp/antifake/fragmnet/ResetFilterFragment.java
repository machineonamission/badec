package com.blueair.antifake.fragmnet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.antifake.databinding.FragmentResetFilterBinding;
import com.blueair.antifake.dialog.AntiFakeActionDialogFragment;
import com.blueair.antifake.dialog.ManualResetFilterDialog;
import com.blueair.antifake.viewmodel.AntiFakeViewModel;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.activity.DeviceFilterDetailActivity;
import com.blueair.devicedetails.dialog.DeviceDetailsDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.StepGuideDialogFragment;
import com.blueair.viewcore.extensions.TextViewExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/blueair/antifake/fragmnet/ResetFilterFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "<init>", "()V", "binding", "Lcom/blueair/antifake/databinding/FragmentResetFilterBinding;", "viewModel", "getViewModel", "()Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;", "setViewModel", "(Lcom/blueair/antifake/viewmodel/AntiFakeViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setupFinishBtn", "", "setupManualResetBtn", "showProgress", "shouldShowProgress", "", "Companion", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ResetFilterFragment.kt */
public final class ResetFilterFragment extends BaseFragment<AntiFakeViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private FragmentResetFilterBinding binding;
    public AntiFakeViewModel viewModel;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ResetFilterFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005f */
        static {
            /*
                com.blueair.antifake.viewmodel.BluetoothResult[] r0 = com.blueair.antifake.viewmodel.BluetoothResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.antifake.viewmodel.BluetoothResult r2 = com.blueair.antifake.viewmodel.BluetoothResult.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                $EnumSwitchMapping$0 = r0
                com.blueair.antifake.viewmodel.ResetResult[] r0 = com.blueair.antifake.viewmodel.ResetResult.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.antifake.viewmodel.ResetResult r2 = com.blueair.antifake.viewmodel.ResetResult.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                r2 = 2
                com.blueair.antifake.viewmodel.ResetResult r3 = com.blueair.antifake.viewmodel.ResetResult.INVALID_CODE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.blueair.antifake.viewmodel.ResetResult r3 = com.blueair.antifake.viewmodel.ResetResult.DEVICE_MISMATCH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.antifake.viewmodel.ResetResult r3 = com.blueair.antifake.viewmodel.ResetResult.DEVICE_OFFLINE     // Catch:{ NoSuchFieldError -> 0x003c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.blueair.antifake.viewmodel.ResetResult r3 = com.blueair.antifake.viewmodel.ResetResult.INTERNAL_ERROR     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r4 = 5
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.blueair.antifake.viewmodel.ResetResult r3 = com.blueair.antifake.viewmodel.ResetResult.BLUETOOTH_FAILED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4 = 6
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                $EnumSwitchMapping$1 = r0
                com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DeviceFilterType r3 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x005f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.fragmnet.ResetFilterFragment.WhenMappings.<clinit>():void");
        }
    }

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/antifake/fragmnet/ResetFilterFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/fragmnet/ResetFilterFragment;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ResetFilterFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ResetFilterFragment newInstance() {
            return new ResetFilterFragment();
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
        FragmentResetFilterBinding inflate = FragmentResetFilterBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        setViewModel((AntiFakeViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AntiFakeViewModel.class)));
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        Intrinsics.checkNotNullExpressionValue(onBackPressedDispatcher, "<get-onBackPressedDispatcher>(...)");
        OnBackPressedDispatcherKt.addCallback$default(onBackPressedDispatcher, getViewLifecycleOwner(), false, new ResetFilterFragment$$ExternalSyntheticLambda8(this), 2, (Object) null);
        FragmentResetFilterBinding fragmentResetFilterBinding = this.binding;
        FragmentResetFilterBinding fragmentResetFilterBinding2 = null;
        if (fragmentResetFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentResetFilterBinding = null;
        }
        fragmentResetFilterBinding.btnHowToReplace.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda9(this));
        FragmentResetFilterBinding fragmentResetFilterBinding3 = this.binding;
        if (fragmentResetFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentResetFilterBinding3 = null;
        }
        fragmentResetFilterBinding3.btnCustomerSupport.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda10(this));
        setupManualResetBtn();
        if (getViewModel().getResetDeviceMac().length() == 0) {
            FragmentResetFilterBinding fragmentResetFilterBinding4 = this.binding;
            if (fragmentResetFilterBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentResetFilterBinding4 = null;
            }
            ConstraintLayout constraintLayout = fragmentResetFilterBinding4.connectingLine;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "connectingLine");
            ViewExtensionsKt.hide(constraintLayout);
        } else {
            FragmentResetFilterBinding fragmentResetFilterBinding5 = this.binding;
            if (fragmentResetFilterBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragmentResetFilterBinding5 = null;
            }
            ConstraintLayout constraintLayout2 = fragmentResetFilterBinding5.connectingLine;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "connectingLine");
            ViewExtensionsKt.show$default(constraintLayout2, false, 1, (Object) null);
            getViewModel().getBluetoothResult().observe(getViewLifecycleOwner(), new ResetFilterFragment$sam$androidx_lifecycle_Observer$0(new ResetFilterFragment$$ExternalSyntheticLambda11(this)));
        }
        getViewModel().getResetResult().observe(getViewLifecycleOwner(), new ResetFilterFragment$sam$androidx_lifecycle_Observer$0(new ResetFilterFragment$$ExternalSyntheticLambda1(this)));
        FragmentResetFilterBinding fragmentResetFilterBinding6 = this.binding;
        if (fragmentResetFilterBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentResetFilterBinding2 = fragmentResetFilterBinding6;
        }
        ConstraintLayout root = fragmentResetFilterBinding2.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2(ResetFilterFragment resetFilterFragment, OnBackPressedCallback onBackPressedCallback) {
        Intrinsics.checkNotNullParameter(onBackPressedCallback, "$this$addCallback");
        FragmentManager childFragmentManager = resetFilterFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.quit_with_questing_mark, (Integer) null, R.string.quit_process_warning, Integer.valueOf(R.string.yes), Integer.valueOf(R.string.f85no), false, false, false, true, (String[]) null, (String) null, new ResetFilterFragment$$ExternalSyntheticLambda0(resetFilterFragment), 1632, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2$lambda$1$lambda$0(ResetFilterFragment resetFilterFragment, boolean z) {
        if (z) {
            resetFilterFragment.requireActivity().finish();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$4(ResetFilterFragment resetFilterFragment, View view) {
        HasSKU device = resetFilterFragment.getViewModel().getDevice();
        if (device == null || !DeviceKt.useV2UI(device)) {
            FragmentManager childFragmentManager = resetFilterFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<DeviceNFilterDialogFragment> cls = DeviceNFilterDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !childFragmentManager.isStateSaved()) {
                DeviceNFilterDialogFragment.Companion.newInstance$default(DeviceNFilterDialogFragment.Companion, (Device) null, resetFilterFragment.getViewModel().getResetDeviceSku(), resetFilterFragment.getViewModel().getFilterType(), false, false, 16, (Object) null).show(childFragmentManager, "DeviceNFilterDialogFragment");
                return;
            }
            return;
        }
        DeviceFilterDetailActivity.Companion companion = DeviceFilterDetailActivity.Companion;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        DeviceFilterDetailActivity.Companion.launch$default(companion, context, resetFilterFragment.getViewModel().getDevice(), resetFilterFragment.getViewModel().getResetDeviceSku(), resetFilterFragment.getViewModel().getFilterType(), false, 16, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$5(ResetFilterFragment resetFilterFragment, View view) {
        resetFilterFragment.startActivity(Actions.INSTANCE.openDialerIntent(AntiFakeViewModel.CUSTOMER_SUPPORT_TEL));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: androidx.fragment.app.DialogFragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit onCreateView$lambda$8(com.blueair.antifake.fragmnet.ResetFilterFragment r7, com.blueair.antifake.viewmodel.BluetoothResult r8) {
        /*
            java.lang.String r0 = "connectingIcResult"
            java.lang.String r1 = "connectingIcPending"
            r2 = 0
            r3 = 1
            java.lang.String r4 = "binding"
            r5 = 0
            if (r8 != 0) goto L_0x0033
            com.blueair.antifake.databinding.FragmentResetFilterBinding r8 = r7.binding
            if (r8 != 0) goto L_0x0013
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r5
        L_0x0013:
            com.blueair.viewcore.view.ProgressBlockerView r8 = r8.connectingIcPending
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r1)
            android.view.View r8 = (android.view.View) r8
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r8, r2, r3, r5)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r7 = r7.binding
            if (r7 != 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x0026
        L_0x0025:
            r5 = r7
        L_0x0026:
            androidx.appcompat.widget.AppCompatImageView r7 = r5.connectingIcResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            android.view.View r7 = (android.view.View) r7
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0033:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r6 = r7.binding
            if (r6 != 0) goto L_0x003b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r6 = r5
        L_0x003b:
            com.blueair.viewcore.view.ProgressBlockerView r6 = r6.connectingIcPending
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            android.view.View r6 = (android.view.View) r6
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r6)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r7.binding
            if (r1 != 0) goto L_0x004d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r1 = r5
        L_0x004d:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.connectingIcResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r2, r3, r5)
            int[] r0 = com.blueair.antifake.fragmnet.ResetFilterFragment.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r0[r8]
            if (r8 != r3) goto L_0x0073
            com.blueair.antifake.databinding.FragmentResetFilterBinding r7 = r7.binding
            if (r7 != 0) goto L_0x0069
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            goto L_0x006a
        L_0x0069:
            r5 = r7
        L_0x006a:
            androidx.appcompat.widget.AppCompatImageView r7 = r5.connectingIcResult
            int r8 = com.blueair.viewcore.R.drawable.ic_success_new
            r7.setImageResource(r8)
            goto L_0x0108
        L_0x0073:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r8 = r7.binding
            if (r8 != 0) goto L_0x007b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r5
        L_0x007b:
            androidx.appcompat.widget.AppCompatImageView r8 = r8.connectingIcResult
            int r0 = com.blueair.viewcore.R.drawable.ic_error_new
            r8.setImageResource(r0)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r8 = r7.binding
            if (r8 != 0) goto L_0x008a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r5
        L_0x008a:
            com.google.android.material.button.MaterialButton r8 = r8.btnCustomerSupport
            java.lang.String r0 = "btnCustomerSupport"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            android.view.View r8 = (android.view.View) r8
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r8, r2, r3, r5)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r8 = r7.binding
            if (r8 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
            r8 = r5
        L_0x009e:
            android.widget.TextView r8 = r8.btnManualReset
            java.lang.String r0 = "btnManualReset"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            android.view.View r8 = (android.view.View) r8
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r8, r2, r3, r5)
            r7.setupFinishBtn()
            com.blueair.antifake.viewmodel.AntiFakeViewModel r8 = r7.getViewModel()
            com.blueair.core.model.DeviceType r8 = r8.getResetDeviceType()
            com.blueair.core.model.DeviceType$Pet20 r0 = com.blueair.core.model.DeviceType.Pet20.INSTANCE
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r8 == 0) goto L_0x00c4
            com.blueair.viewcore.dialog.GuidesData r8 = com.blueair.viewcore.dialog.GuidesData.INSTANCE
            com.blueair.viewcore.dialog.StepGuides r8 = r8.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN()
            goto L_0x00ca
        L_0x00c4:
            com.blueair.viewcore.dialog.GuidesData r8 = com.blueair.viewcore.dialog.GuidesData.INSTANCE
            com.blueair.viewcore.dialog.StepGuides r8 = r8.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET()
        L_0x00ca:
            androidx.fragment.app.FragmentManager r0 = r7.getChildFragmentManager()
            java.lang.String r1 = "getChildFragmentManager(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Class<com.blueair.viewcore.dialog.StepGuideDialogFragment> r1 = com.blueair.viewcore.dialog.StepGuideDialogFragment.class
            java.lang.String r1 = "getSimpleName(...)"
            java.lang.String r2 = "StepGuideDialogFragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            androidx.fragment.app.Fragment r1 = r0.findFragmentByTag(r2)
            boolean r1 = r1 instanceof com.blueair.viewcore.dialog.StepGuideDialogFragment
            if (r1 != 0) goto L_0x00f6
            boolean r1 = r0.isStateSaved()
            if (r1 != 0) goto L_0x00f6
            com.blueair.viewcore.dialog.StepGuideDialogFragment$Companion r1 = com.blueair.viewcore.dialog.StepGuideDialogFragment.Companion
            com.blueair.viewcore.dialog.StepGuideDialogFragment r1 = r1.newInstance(r8)
            r5 = r1
            androidx.fragment.app.DialogFragment r5 = (androidx.fragment.app.DialogFragment) r5
            r5.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r2)
        L_0x00f6:
            com.blueair.viewcore.dialog.StepGuideDialogFragment r5 = (com.blueair.viewcore.dialog.StepGuideDialogFragment) r5
            if (r5 == 0) goto L_0x0108
            androidx.fragment.app.Fragment r5 = (androidx.fragment.app.Fragment) r5
            java.lang.String r8 = r8.getRequestKey()
            com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda4 r0 = new com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda4
            r0.<init>(r7)
            com.blueair.viewcore.extensions.FragmentExtensionsKt.setFragmentResultListenerWithClear(r5, r8, r0)
        L_0x0108:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.fragmnet.ResetFilterFragment.onCreateView$lambda$8(com.blueair.antifake.fragmnet.ResetFilterFragment, com.blueair.antifake.viewmodel.BluetoothResult):kotlin.Unit");
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$8$lambda$7(ResetFilterFragment resetFilterFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "r");
        if (bundle.getBoolean(StepGuideDialogFragment.DATA_COMPLETED)) {
            resetFilterFragment.getViewModel().retryResetFilterByBluetooth();
        }
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: androidx.fragment.app.DialogFragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: androidx.fragment.app.DialogFragment} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: com.blueair.antifake.databinding.FragmentResetFilterBinding} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit onCreateView$lambda$14(com.blueair.antifake.fragmnet.ResetFilterFragment r24, com.blueair.antifake.viewmodel.ResetResult r25) {
        /*
            r0 = r24
            java.lang.String r1 = "resettingIcResult"
            java.lang.String r2 = "resettingIcPending"
            java.lang.String r3 = "btnManualReset"
            java.lang.String r4 = "btnCustomerSupport"
            r5 = 1
            r6 = 0
            java.lang.String r7 = "binding"
            r8 = 0
            if (r25 != 0) goto L_0x0084
            com.blueair.antifake.databinding.FragmentResetFilterBinding r9 = r0.binding
            if (r9 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r9 = r8
        L_0x0019:
            com.blueair.viewcore.view.ProgressBlockerView r9 = r9.resettingIcPending
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            android.view.View r9 = (android.view.View) r9
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r9, r6, r5, r8)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x002b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r2 = r8
        L_0x002b:
            androidx.appcompat.widget.AppCompatImageView r2 = r2.resettingIcResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r2)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x003d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x003d:
            com.google.android.material.button.MaterialButton r1 = r1.btnFinish
            android.content.Context r2 = r0.requireContext()
            int r5 = com.blueair.viewcore.R.color.smokegray
            int r2 = r2.getColor(r5)
            r1.setTextColor(r2)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0054
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x0054:
            com.google.android.material.button.MaterialButton r1 = r1.btnFinish
            r1.setOnClickListener(r8)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0061
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x0061:
            com.google.android.material.button.MaterialButton r1 = r1.btnCustomerSupport
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r1)
            r0.setupManualResetBtn()
            com.blueair.antifake.databinding.FragmentResetFilterBinding r0 = r0.binding
            if (r0 != 0) goto L_0x0076
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x0077
        L_0x0076:
            r8 = r0
        L_0x0077:
            android.widget.TextView r0 = r8.btnManualReset
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.view.View r0 = (android.view.View) r0
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0084:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r9 = r0.binding
            if (r9 != 0) goto L_0x008c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r9 = r8
        L_0x008c:
            com.blueair.viewcore.view.ProgressBlockerView r9 = r9.resettingIcPending
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            android.view.View r9 = (android.view.View) r9
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r9)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r2 = r8
        L_0x009e:
            androidx.appcompat.widget.AppCompatImageView r2 = r2.resettingIcResult
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
            android.view.View r2 = (android.view.View) r2
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r2, r6, r5, r8)
            r0.setupFinishBtn()
            int[] r1 = com.blueair.antifake.fragmnet.ResetFilterFragment.WhenMappings.$EnumSwitchMapping$1
            int r2 = r25.ordinal()
            r1 = r1[r2]
            java.lang.String r2 = "getSimpleName(...)"
            java.lang.String r9 = "StepGuideDialogFragment"
            java.lang.String r10 = "getChildFragmentManager(...)"
            switch(r1) {
                case 1: goto L_0x02ef;
                case 2: goto L_0x02a2;
                case 3: goto L_0x0255;
                case 4: goto L_0x01ab;
                case 5: goto L_0x014c;
                case 6: goto L_0x00c2;
                default: goto L_0x00bc;
            }
        L_0x00bc:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x00c2:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x00ca
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x00ca:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.resettingIcResult
            int r11 = com.blueair.viewcore.R.drawable.ic_error_new
            r1.setImageResource(r11)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x00d9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x00d9:
            com.google.android.material.button.MaterialButton r1 = r1.btnCustomerSupport
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x00eb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x00eb:
            android.widget.TextView r1 = r1.btnManualReset
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.antifake.viewmodel.AntiFakeViewModel r1 = r0.getViewModel()
            com.blueair.core.model.DeviceType r1 = r1.getResetDeviceType()
            com.blueair.core.model.DeviceType$Pet20 r3 = com.blueair.core.model.DeviceType.Pet20.INSTANCE
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x010c
            com.blueair.viewcore.dialog.GuidesData r1 = com.blueair.viewcore.dialog.GuidesData.INSTANCE
            com.blueair.viewcore.dialog.StepGuides r1 = r1.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET_FAN()
            goto L_0x0112
        L_0x010c:
            com.blueair.viewcore.dialog.GuidesData r1 = com.blueair.viewcore.dialog.GuidesData.INSTANCE
            com.blueair.viewcore.dialog.StepGuides r1 = r1.getRESET_FILTER_TROUBLESHOOTING_BLUETOOTH_RESET()
        L_0x0112:
            androidx.fragment.app.FragmentManager r3 = r0.getChildFragmentManager()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r10)
            java.lang.Class<com.blueair.viewcore.dialog.StepGuideDialogFragment> r4 = com.blueair.viewcore.dialog.StepGuideDialogFragment.class
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            androidx.fragment.app.Fragment r2 = r3.findFragmentByTag(r9)
            boolean r2 = r2 instanceof com.blueair.viewcore.dialog.StepGuideDialogFragment
            if (r2 != 0) goto L_0x0138
            boolean r2 = r3.isStateSaved()
            if (r2 != 0) goto L_0x0138
            com.blueair.viewcore.dialog.StepGuideDialogFragment$Companion r2 = com.blueair.viewcore.dialog.StepGuideDialogFragment.Companion
            com.blueair.viewcore.dialog.StepGuideDialogFragment r2 = r2.newInstance(r1)
            r8 = r2
            androidx.fragment.app.DialogFragment r8 = (androidx.fragment.app.DialogFragment) r8
            r8.show((androidx.fragment.app.FragmentManager) r3, (java.lang.String) r9)
        L_0x0138:
            com.blueair.viewcore.dialog.StepGuideDialogFragment r8 = (com.blueair.viewcore.dialog.StepGuideDialogFragment) r8
            if (r8 == 0) goto L_0x0351
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            java.lang.String r1 = r1.getRequestKey()
            com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda7 r2 = new com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda7
            r2.<init>(r0)
            com.blueair.viewcore.extensions.FragmentExtensionsKt.setFragmentResultListenerWithClear(r8, r1, r2)
            goto L_0x0351
        L_0x014c:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0154
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x0154:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.resettingIcResult
            int r2 = com.blueair.viewcore.R.drawable.ic_error_new
            r1.setImageResource(r2)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0163
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x0163:
            com.google.android.material.button.MaterialButton r1 = r1.btnCustomerSupport
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0175
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x0175:
            android.widget.TextView r1 = r1.btnManualReset
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned$Companion r9 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion
            int r10 = com.blueair.viewcore.R.string.reset_failed
            int r12 = com.blueair.viewcore.R.string.troubleshotting_reset_filter_internal_error
            int r1 = com.blueair.viewcore.R.string.add_device_success_btn_okay
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r22 = 3808(0xee0, float:5.336E-42)
            r23 = 0
            r11 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            r20 = 0
            r21 = 0
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned r1 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion.newInstance$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            r1.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r8)
            goto L_0x0351
        L_0x01ab:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x01b3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x01b3:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.resettingIcResult
            int r11 = com.blueair.viewcore.R.drawable.ic_error_new
            r1.setImageResource(r11)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x01c2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x01c2:
            com.google.android.material.button.MaterialButton r1 = r1.btnCustomerSupport
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x01d4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x01d4:
            android.widget.TextView r1 = r1.btnManualReset
            int r4 = com.blueair.viewcore.R.string.reset_via_bluetooth
            r1.setText(r4)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x01e3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x01e3:
            android.widget.TextView r1 = r1.btnManualReset
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.blueair.viewcore.extensions.TextViewExtensionsKt.underlineText(r1)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x01f3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x01f3:
            android.widget.TextView r1 = r1.btnManualReset
            com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda5 r4 = new com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda5
            r4.<init>(r0)
            r1.setOnClickListener(r4)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x0205
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x0205:
            android.widget.TextView r1 = r1.btnManualReset
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            androidx.fragment.app.FragmentManager r1 = r0.getChildFragmentManager()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r10)
            java.lang.Class<com.blueair.viewcore.dialog.StepGuideDialogFragment> r3 = com.blueair.viewcore.dialog.StepGuideDialogFragment.class
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            androidx.fragment.app.Fragment r2 = r1.findFragmentByTag(r9)
            boolean r2 = r2 instanceof com.blueair.viewcore.dialog.StepGuideDialogFragment
            if (r2 != 0) goto L_0x023b
            boolean r2 = r1.isStateSaved()
            if (r2 != 0) goto L_0x023b
            com.blueair.viewcore.dialog.StepGuideDialogFragment$Companion r2 = com.blueair.viewcore.dialog.StepGuideDialogFragment.Companion
            com.blueair.viewcore.dialog.GuidesData r3 = com.blueair.viewcore.dialog.GuidesData.INSTANCE
            com.blueair.viewcore.dialog.StepGuides r3 = r3.getRESET_FILTER_TROUBLESHOOTING_OFFLINE()
            com.blueair.viewcore.dialog.StepGuideDialogFragment r2 = r2.newInstance(r3)
            r8 = r2
            androidx.fragment.app.DialogFragment r8 = (androidx.fragment.app.DialogFragment) r8
            r8.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r9)
        L_0x023b:
            com.blueair.viewcore.dialog.StepGuideDialogFragment r8 = (com.blueair.viewcore.dialog.StepGuideDialogFragment) r8
            if (r8 == 0) goto L_0x0351
            androidx.fragment.app.Fragment r8 = (androidx.fragment.app.Fragment) r8
            com.blueair.viewcore.dialog.GuidesData r1 = com.blueair.viewcore.dialog.GuidesData.INSTANCE
            com.blueair.viewcore.dialog.StepGuides r1 = r1.getRESET_FILTER_TROUBLESHOOTING_OFFLINE()
            java.lang.String r1 = r1.getRequestKey()
            com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda6 r2 = new com.blueair.antifake.fragmnet.ResetFilterFragment$$ExternalSyntheticLambda6
            r2.<init>(r0)
            com.blueair.viewcore.extensions.FragmentExtensionsKt.setFragmentResultListenerWithClear(r8, r1, r2)
            goto L_0x0351
        L_0x0255:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x025d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x025d:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.resettingIcResult
            int r2 = com.blueair.viewcore.R.drawable.ic_error_new
            r1.setImageResource(r2)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x026c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x026c:
            com.google.android.material.button.MaterialButton r1 = r1.btnCustomerSupport
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned$Companion r9 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion
            int r10 = com.blueair.viewcore.R.string.device_mismatch
            int r12 = com.blueair.viewcore.R.string.device_filter_mismatch
            int r1 = com.blueair.viewcore.R.string.add_device_success_btn_okay
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r22 = 3808(0xee0, float:5.336E-42)
            r23 = 0
            r11 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            r20 = 0
            r21 = 0
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned r1 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion.newInstance$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            r1.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r8)
            goto L_0x0351
        L_0x02a2:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x02aa
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x02aa:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.resettingIcResult
            int r2 = com.blueair.viewcore.R.drawable.ic_error_new
            r1.setImageResource(r2)
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x02b9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x02b9:
            com.google.android.material.button.MaterialButton r1 = r1.btnCustomerSupport
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r1, r6, r5, r8)
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned$Companion r9 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion
            int r10 = com.blueair.viewcore.R.string.invalid_verification_code
            int r12 = com.blueair.viewcore.R.string.invalid_verification_code_desc
            int r1 = com.blueair.viewcore.R.string.add_device_success_btn_okay
            java.lang.Integer r13 = java.lang.Integer.valueOf(r1)
            r22 = 3808(0xee0, float:5.336E-42)
            r23 = 0
            r11 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 1
            r19 = 0
            r20 = 0
            r21 = 0
            com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned r1 = com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned.Companion.newInstance$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            androidx.fragment.app.FragmentManager r0 = r0.getChildFragmentManager()
            r1.show((androidx.fragment.app.FragmentManager) r0, (java.lang.String) r8)
            goto L_0x0351
        L_0x02ef:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r1 = r0.binding
            if (r1 != 0) goto L_0x02f7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r1 = r8
        L_0x02f7:
            androidx.appcompat.widget.AppCompatImageView r1 = r1.resettingIcResult
            int r2 = com.blueair.viewcore.R.drawable.ic_success_new
            r1.setImageResource(r2)
            com.blueair.antifake.viewmodel.AntiFakeViewModel r1 = r0.getViewModel()
            com.blueair.core.model.HasSKU r1 = r1.getDevice()
            if (r1 != 0) goto L_0x0351
            com.blueair.antifake.viewmodel.AntiFakeViewModel r1 = r0.getViewModel()
            com.blueair.core.model.FilterConfig r1 = r1.getFilterConfig()
            com.blueair.viewcore.utils.DeviceConfigProvider r2 = com.blueair.viewcore.utils.DeviceConfigProvider.INSTANCE
            if (r1 == 0) goto L_0x0319
            com.blueair.core.model.AwsLinkConfig r1 = r1.getVideo()
            goto L_0x031a
        L_0x0319:
            r1 = r8
        L_0x031a:
            java.lang.String r1 = r2.getAwsLinkValue(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x032b
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0329
            goto L_0x032b
        L_0x0329:
            r1 = r6
            goto L_0x032c
        L_0x032b:
            r1 = r5
        L_0x032c:
            com.blueair.antifake.databinding.FragmentResetFilterBinding r2 = r0.binding
            if (r2 != 0) goto L_0x0334
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            goto L_0x0335
        L_0x0334:
            r8 = r2
        L_0x0335:
            com.google.android.material.button.MaterialButton r2 = r8.btnHowToReplace
            java.lang.String r3 = "btnHowToReplace"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            if (r1 == 0) goto L_0x034e
            com.blueair.antifake.viewmodel.AntiFakeViewModel r0 = r0.getViewModel()
            com.blueair.core.model.HasSKU r0 = r0.getDevice()
            boolean r0 = r0 instanceof com.blueair.core.model.DeviceBlue40
            if (r0 == 0) goto L_0x034d
            goto L_0x034e
        L_0x034d:
            r5 = r6
        L_0x034e:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r2, r5)
        L_0x0351:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.antifake.fragmnet.ResetFilterFragment.onCreateView$lambda$14(com.blueair.antifake.fragmnet.ResetFilterFragment, com.blueair.antifake.viewmodel.ResetResult):kotlin.Unit");
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$14$lambda$9(ResetFilterFragment resetFilterFragment, View view) {
        resetFilterFragment.getViewModel().retryViaBluetooth();
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$14$lambda$11(ResetFilterFragment resetFilterFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "r");
        if (bundle.getBoolean(StepGuideDialogFragment.DATA_COMPLETED)) {
            resetFilterFragment.getViewModel().retryResetFilterByWifi();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$14$lambda$13(ResetFilterFragment resetFilterFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "r");
        if (bundle.getBoolean(StepGuideDialogFragment.DATA_COMPLETED)) {
            resetFilterFragment.getViewModel().retryResetFilterByBluetooth();
        }
        return Unit.INSTANCE;
    }

    private final void setupFinishBtn() {
        FragmentResetFilterBinding fragmentResetFilterBinding = this.binding;
        FragmentResetFilterBinding fragmentResetFilterBinding2 = null;
        if (fragmentResetFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentResetFilterBinding = null;
        }
        fragmentResetFilterBinding.btnFinish.setTextColor(requireContext().getColor(R.color.colorPrimaryText));
        FragmentResetFilterBinding fragmentResetFilterBinding3 = this.binding;
        if (fragmentResetFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentResetFilterBinding2 = fragmentResetFilterBinding3;
        }
        fragmentResetFilterBinding2.btnFinish.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void setupFinishBtn$lambda$15(ResetFilterFragment resetFilterFragment, View view) {
        String str;
        AntiFakeActionDialogFragment.Companion.setShouldDismiss(true);
        DeviceNFilterDialogFragment.Companion.setShouldDismiss(true);
        DeviceDetailsDialogFragment.Companion companion = DeviceDetailsDialogFragment.Companion;
        DeviceFilterType targetType = resetFilterFragment.getViewModel().getTargetType();
        int i = targetType == null ? -1 : WhenMappings.$EnumSwitchMapping$2[targetType.ordinal()];
        if (i == 1) {
            str = NotificationService.ACTION_TYPE_FILTER_STATUS;
        } else if (i != 2) {
            str = null;
        } else {
            str = NotificationService.ACTION_TYPE_WICK_STATUS;
        }
        companion.setJumpToAction(str);
        resetFilterFragment.requireActivity().finish();
    }

    private final void setupManualResetBtn() {
        FragmentResetFilterBinding fragmentResetFilterBinding = this.binding;
        FragmentResetFilterBinding fragmentResetFilterBinding2 = null;
        if (fragmentResetFilterBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentResetFilterBinding = null;
        }
        fragmentResetFilterBinding.btnManualReset.setText(R.string.manual_reset);
        FragmentResetFilterBinding fragmentResetFilterBinding3 = this.binding;
        if (fragmentResetFilterBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentResetFilterBinding3 = null;
        }
        TextView textView = fragmentResetFilterBinding3.btnManualReset;
        Intrinsics.checkNotNullExpressionValue(textView, "btnManualReset");
        TextViewExtensionsKt.underlineText(textView);
        FragmentResetFilterBinding fragmentResetFilterBinding4 = this.binding;
        if (fragmentResetFilterBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentResetFilterBinding2 = fragmentResetFilterBinding4;
        }
        fragmentResetFilterBinding2.btnManualReset.setOnClickListener(new ResetFilterFragment$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void setupManualResetBtn$lambda$17(ResetFilterFragment resetFilterFragment, View view) {
        FragmentManager childFragmentManager = resetFilterFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ManualResetFilterDialog> cls = ManualResetFilterDialog.class;
        Intrinsics.checkNotNullExpressionValue("ManualResetFilterDialog", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ManualResetFilterDialog") instanceof ManualResetFilterDialog) && !childFragmentManager.isStateSaved()) {
            ManualResetFilterDialog.Companion.newInstance(resetFilterFragment.getViewModel().getFilterType()).show(childFragmentManager, "ManualResetFilterDialog");
        }
    }
}
