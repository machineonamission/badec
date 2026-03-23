package com.blueair.adddevice.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.FragmentEnterDeviceNameBinding;
import com.blueair.adddevice.dialog.FinalizeDialog;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceType;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001cH\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0012\u0010*\u001a\u00020+X\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0018\u0010.\u001a\u00020\u0002X\u000f¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/blueair/adddevice/fragment/EnterDeviceNameFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentEnterDeviceNameBinding;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showProgress", "", "shouldShowProgress", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "observeViewModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: EnterDeviceNameFragment.kt */
public final class EnterDeviceNameFragment extends BaseFragment<AddDeviceViewModel> implements BaseFragmentInterface<AddDeviceViewModel>, ProgressFragment {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(EnterDeviceNameFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    private final /* synthetic */ AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
    private final Lazy locationService$delegate;
    private ProgressBlockerView progressBlockerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_SET_NAME;
    private FragmentEnterDeviceNameBinding viewDataBinding;

    public CompositeDisposable getRxSubs() {
        return this.$$delegate_0.getRxSubs();
    }

    public AddDeviceViewModel getViewModel() {
        return this.$$delegate_0.getViewModel();
    }

    public void setViewModel(AddDeviceViewModel addDeviceViewModel) {
        Intrinsics.checkNotNullParameter(addDeviceViewModel, "<set-?>");
        this.$$delegate_0.setViewModel(addDeviceViewModel);
    }

    public EnterDeviceNameFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new EnterDeviceNameFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public ConstraintLayout getRootView() {
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding = this.viewDataBinding;
        if (fragmentEnterDeviceNameBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentEnterDeviceNameBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentEnterDeviceNameBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentEnterDeviceNameBinding inflate = FragmentEnterDeviceNameBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        inflate.setAddDeviceViewModel((AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class)));
        AddDeviceViewModel addDeviceViewModel = inflate.getAddDeviceViewModel();
        Intrinsics.checkNotNull(addDeviceViewModel);
        setViewModel(addDeviceViewModel);
        inflate.setLifecycleOwner(requireActivity());
        this.viewDataBinding = inflate;
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        setProgressBlockerView(inflate.progressView);
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding2 = this.viewDataBinding;
        if (fragmentEnterDeviceNameBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentEnterDeviceNameBinding = fragmentEnterDeviceNameBinding2;
        }
        View root = fragmentEnterDeviceNameBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        observeViewModel();
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding = this.viewDataBinding;
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding2 = null;
        if (fragmentEnterDeviceNameBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentEnterDeviceNameBinding = null;
        }
        fragmentEnterDeviceNameBinding.buttonDone.setOnClickListener(new EnterDeviceNameFragment$$ExternalSyntheticLambda2(this));
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding3 = this.viewDataBinding;
        if (fragmentEnterDeviceNameBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentEnterDeviceNameBinding3 = null;
        }
        TextInputEditText textInputEditText = fragmentEnterDeviceNameBinding3.etDeviceName;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "etDeviceName");
        textInputEditText.addTextChangedListener(new EnterDeviceNameFragment$onViewCreated$$inlined$addTextChangedListener$default$1(this));
        BluetoothDevice selectedUiDevice = getViewModel().getSelectedUiDevice();
        if (selectedUiDevice == null || (str = selectedUiDevice.getFamilyName()) == null) {
            str = "";
        }
        CharSequence charSequence = str;
        if (StringsKt.contains$default(charSequence, (CharSequence) IOUtils.LINE_SEPARATOR_UNIX, false, 2, (Object) null)) {
            str = (String) CollectionsKt.first(StringsKt.split$default(charSequence, new String[]{IOUtils.LINE_SEPARATOR_UNIX}, false, 0, 6, (Object) null));
        }
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding4 = this.viewDataBinding;
        if (fragmentEnterDeviceNameBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentEnterDeviceNameBinding2 = fragmentEnterDeviceNameBinding4;
        }
        fragmentEnterDeviceNameBinding2.etDeviceName.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(EnterDeviceNameFragment enterDeviceNameFragment, View view) {
        DialogFragment dialogFragment;
        FragmentManager childFragmentManager = enterDeviceNameFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<FinalizeDialog> cls = FinalizeDialog.class;
        Intrinsics.checkNotNullExpressionValue(FinalizeDialog.REQUEST_KEY, "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag(FinalizeDialog.REQUEST_KEY) instanceof FinalizeDialog) || childFragmentManager.isStateSaved()) {
            dialogFragment = null;
        } else {
            FinalizeDialog.Companion companion = FinalizeDialog.Companion;
            String detectedDeviceUuid = enterDeviceNameFragment.getViewModel().getDetectedDeviceUuid();
            if (detectedDeviceUuid == null) {
                detectedDeviceUuid = "";
            }
            String selectedDeviceName = enterDeviceNameFragment.getViewModel().getSelectedDeviceName();
            if (selectedDeviceName == null) {
                selectedDeviceName = enterDeviceNameFragment.getLocationService().isInG4ProtectRegion() ? DeviceType.PROTECT : DeviceType.HEALTH_PROTECT;
            }
            BluetoothDevice selectedUiDevice = enterDeviceNameFragment.getViewModel().getSelectedUiDevice();
            Intrinsics.checkNotNull(selectedUiDevice);
            dialogFragment = companion.newInstance(detectedDeviceUuid, selectedDeviceName, selectedUiDevice);
            dialogFragment.show(childFragmentManager, FinalizeDialog.REQUEST_KEY);
        }
        FinalizeDialog finalizeDialog = (FinalizeDialog) dialogFragment;
        if (finalizeDialog != null) {
            FragmentExtensionsKt.setFragmentResultListenerWithClear(finalizeDialog, FinalizeDialog.REQUEST_KEY, new EnterDeviceNameFragment$$ExternalSyntheticLambda1(enterDeviceNameFragment));
        }
    }

    /* access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3$lambda$2(EnterDeviceNameFragment enterDeviceNameFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(FinalizeDialog.ACTION_CHOOSE_DEVICE)) {
            enterDeviceNameFragment.getViewModel().clearOnboardedDevices();
            enterDeviceNameFragment.getViewModel().reset();
            enterDeviceNameFragment.getViewModel().restart();
        }
        return Unit.INSTANCE;
    }

    private final void observeViewModel() {
        getViewModel().getLiveSelectedDeviceName().observe(getViewLifecycleOwner(), new EnterDeviceNameFragment$sam$androidx_lifecycle_Observer$0(new EnterDeviceNameFragment$$ExternalSyntheticLambda0(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$5(EnterDeviceNameFragment enterDeviceNameFragment, String str) {
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding = enterDeviceNameFragment.viewDataBinding;
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding2 = null;
        if (fragmentEnterDeviceNameBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentEnterDeviceNameBinding = null;
        }
        MaterialButton materialButton = fragmentEnterDeviceNameBinding.buttonDone;
        CharSequence obj = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        boolean z = false;
        materialButton.setEnabled(!(obj == null || obj.length() == 0));
        FragmentEnterDeviceNameBinding fragmentEnterDeviceNameBinding3 = enterDeviceNameFragment.viewDataBinding;
        if (fragmentEnterDeviceNameBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentEnterDeviceNameBinding2 = fragmentEnterDeviceNameBinding3;
        }
        TextInputLayout textInputLayout = fragmentEnterDeviceNameBinding2.inputDeviceName;
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        textInputLayout.setEndIconVisible(!z);
        return Unit.INSTANCE;
    }
}
