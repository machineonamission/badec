package com.blueair.adddevice.fragment;

import android.app.Activity;
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
import com.blueair.adddevice.databinding.FragmentWifiPasswordBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.Ssid;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.ViewUtilsKt;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
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
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.jakewharton.rxbinding2.view.RxView;
import io.flatcircle.viewhelper.ViewHelperUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 E2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004:\u0001EB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001aH\u0002J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u001aH\u0016J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u000eH\u0002J\b\u00101\u001a\u00020\u001aH\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u001aH\u0002J\b\u00105\u001a\u00020\u001aH\u0002J\b\u00106\u001a\u00020\u001cH\u0002J\b\u00109\u001a\u00020\u001cH\u0002J\u0012\u0010:\u001a\u00020\u001a2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J\u001a\u0010=\u001a\u00020\u001a2\b\u0010>\u001a\u0004\u0018\u00010\b2\u0006\u0010?\u001a\u00020\u001cH\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u001f\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010@\u001a\u00020\u0002X\u000f¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/blueair/adddevice/fragment/WifiPasswordFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentWifiPasswordBinding;", "passwordErrorCount", "", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "showProgress", "", "shouldShowProgress", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "polling", "updateNextEnabled", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onResume", "displayLegalCharactersDescription", "doSuccess", "resetInputError", "showErrorMsg", "msgRes", "showInputError", "showNetworkError", "showInputWifiConnError", "showInputConnectError", "showRandRegisterError", "validateFields", "validator", "Lkotlin/text/Regex;", "validatePassword", "hideProgress", "context", "Landroid/content/Context;", "updateDebugView", "message", "isError", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "Companion", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WifiPasswordFragment.kt */
public final class WifiPasswordFragment extends BaseFragment<AddDeviceViewModel> implements ProgressFragment, BaseFragmentInterface<AddDeviceViewModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String INCORRECT_PASSWORD_ERROR = "AuthError";
    private static final String WIFI_REGEX_PATTERN = "[A-Za-z0-9~!@#$%^&*()_+`\\-={}\\[\\]:;<>./\\\\]*";
    private final /* synthetic */ AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
    private int passwordErrorCount;
    /* access modifiers changed from: private */
    public volatile boolean polling;
    private ProgressBlockerView progressBlockerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_WIFI_PASSWORD;
    private final Regex validator = new Regex(WIFI_REGEX_PATTERN);
    private FragmentWifiPasswordBinding viewDataBinding;

    private final void updateDebugView(String str, boolean z) {
    }

    public AddDeviceViewModel getViewModel() {
        return this.$$delegate_0.getViewModel();
    }

    public void setViewModel(AddDeviceViewModel addDeviceViewModel) {
        Intrinsics.checkNotNullParameter(addDeviceViewModel, "<set-?>");
        this.$$delegate_0.setViewModel(addDeviceViewModel);
    }

    public void clearProgressFragment() {
        ProgressFragment.CC.$default$clearProgressFragment(this);
    }

    public void showProgress(Context context, boolean z, Integer num) {
        ProgressFragment.CC.$default$showProgress(this, context, z, num);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/blueair/adddevice/fragment/WifiPasswordFragment$Companion;", "", "<init>", "()V", "INCORRECT_PASSWORD_ERROR", "", "WIFI_REGEX_PATTERN", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WifiPasswordFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public CompositeDisposable getRxSubs() {
        return super.getRxSubs();
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public ConstraintLayout getRootView() {
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentWifiPasswordBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    /* access modifiers changed from: private */
    public final void updateNextEnabled() {
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding2 = null;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        boolean z = true;
        boolean z2 = String.valueOf(fragmentWifiPasswordBinding.ssidEditText.getText()).length() > 0;
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding3 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding3 = null;
        }
        boolean z3 = String.valueOf(fragmentWifiPasswordBinding3.passwordEditText.getText()).length() >= 8;
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding4 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentWifiPasswordBinding2 = fragmentWifiPasswordBinding4;
        }
        MaterialButton materialButton = fragmentWifiPasswordBinding2.buttonNext;
        if (!getViewModel().isHiddenNetwork()) {
            z = z3;
        } else if (!z2 || !z3) {
            z = false;
        }
        materialButton.setEnabled(z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWifiPasswordBinding inflate = FragmentWifiPasswordBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        inflate.setAddDeviceViewModel((AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class)));
        inflate.setLifecycleOwner(requireActivity());
        this.viewDataBinding = inflate;
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        setProgressBlockerView(inflate.progressView);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding2 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding2 = null;
        }
        AddDeviceViewModel addDeviceViewModel = fragmentWifiPasswordBinding2.getAddDeviceViewModel();
        Intrinsics.checkNotNull(addDeviceViewModel);
        setViewModel(addDeviceViewModel);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding3 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentWifiPasswordBinding = fragmentWifiPasswordBinding3;
        }
        View root = fragmentWifiPasswordBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = null;
        if (getViewModel().isHiddenNetwork()) {
            FragmentWifiPasswordBinding fragmentWifiPasswordBinding2 = this.viewDataBinding;
            if (fragmentWifiPasswordBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentWifiPasswordBinding2 = null;
            }
            fragmentWifiPasswordBinding2.ssidEditTextLayout.setEnabled(true);
            FragmentWifiPasswordBinding fragmentWifiPasswordBinding3 = this.viewDataBinding;
            if (fragmentWifiPasswordBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentWifiPasswordBinding3 = null;
            }
            fragmentWifiPasswordBinding3.tvSubtitle.setText(getString(R.string.label_enter_wifi_info));
        }
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding4 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding4 = null;
        }
        TextInputEditText textInputEditText = fragmentWifiPasswordBinding4.ssidEditText;
        Ssid value = getViewModel().getSelectedSsid().getValue();
        textInputEditText.setText(value != null ? value.getSsid() : null);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding5 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding5 = null;
        }
        TextInputEditText textInputEditText2 = fragmentWifiPasswordBinding5.ssidEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText2, "ssidEditText");
        textInputEditText2.addTextChangedListener(new WifiPasswordFragment$onViewCreated$$inlined$addTextChangedListener$default$1(this));
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding6 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentWifiPasswordBinding = fragmentWifiPasswordBinding6;
        }
        TextInputEditText textInputEditText3 = fragmentWifiPasswordBinding.passwordEditText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText3, "passwordEditText");
        textInputEditText3.addTextChangedListener(new WifiPasswordFragment$onViewCreated$$inlined$addTextChangedListener$default$2(this));
    }

    public void onResume() {
        BleDeviceError selectedBleDeviceError;
        super.onResume();
        getViewModel().recordResume("wifi_password");
        getRxSubs().add(RxExtensionsKt.uiThread(getViewModel().getBluetoothConnectionStateObserver()).subscribe(new WifiPasswordFragment$$ExternalSyntheticLambda7(new WifiPasswordFragment$$ExternalSyntheticLambda6(this)), new WifiPasswordFragment$$ExternalSyntheticLambda9(new WifiPasswordFragment$$ExternalSyntheticLambda8())));
        if (this.polling && (selectedBleDeviceError = getViewModel().getSelectedBleDeviceError()) != null) {
            Timber.Forest forest = Timber.Forest;
            forest.d("selectedBleDeviceError: error = " + selectedBleDeviceError, new Object[0]);
            showInputError();
        }
        Observable<BleDeviceError> selectedBleDeviceErrorObserver = getViewModel().getSelectedBleDeviceErrorObserver();
        if (selectedBleDeviceErrorObserver != null) {
            CompositeDisposable rxSubs = getRxSubs();
            Observable<BleDeviceError> filter = selectedBleDeviceErrorObserver.observeOn(AndroidSchedulers.mainThread()).filter(new WifiPasswordFragment$$ExternalSyntheticLambda11(new WifiPasswordFragment$$ExternalSyntheticLambda10(this)));
            Intrinsics.checkNotNullExpressionValue(filter, "filter(...)");
            rxSubs.add(RxExtensionsKt.subscribeAndLogE(filter, new WifiPasswordFragment$$ExternalSyntheticLambda12(selectedBleDeviceErrorObserver, this)));
        }
        if (Intrinsics.areEqual((Object) getViewModel().isSelectedBleDeviceWifiConnected(), (Object) true)) {
            doSuccess();
        }
        Observable<BleDeviceState> selectedBleDeviceStateObserver = getViewModel().getSelectedBleDeviceStateObserver();
        if (selectedBleDeviceStateObserver != null) {
            CompositeDisposable rxSubs2 = getRxSubs();
            Observable<BleDeviceState> observeOn = selectedBleDeviceStateObserver.observeOn(AndroidSchedulers.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(...)");
            rxSubs2.add(RxExtensionsKt.subscribeAndLogE(observeOn, new WifiPasswordFragment$$ExternalSyntheticLambda13(this)));
        }
        CompositeDisposable rxSubs3 = getRxSubs();
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        Observable<Object> clicks = RxView.clicks(fragmentWifiPasswordBinding.buttonNext);
        Intrinsics.checkNotNullExpressionValue(clicks, "clicks(...)");
        Observable<Object> filter2 = RxExtensionsKt.filterRapidClicks(RxExtensionsKt.uiThread(clicks)).filter(new WifiPasswordFragment$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(filter2, "filter(...)");
        rxSubs3.add(RxExtensionsKt.subscribeAndLogE(filter2, new WifiPasswordFragment$$ExternalSyntheticLambda2(this)));
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$4(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$3(WifiPasswordFragment wifiPasswordFragment, Boolean bool) {
        Timber.Forest forest = Timber.Forest;
        forest.d("connectionChangedObserver: hasBluetooth = " + bool + ", hasSelectedBleDevice = " + wifiPasswordFragment.getViewModel().getHasSelectedBleDevice(), new Object[0]);
        if (!bool.booleanValue()) {
            wifiPasswordFragment.getViewModel().showConnectionLost();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$6(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest.e(th, "Connection Change Observer failed", new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$11$lambda$9(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$11$lambda$8(WifiPasswordFragment wifiPasswordFragment, BleDeviceError bleDeviceError) {
        Intrinsics.checkNotNullParameter(bleDeviceError, "error");
        wifiPasswordFragment.updateDebugView(bleDeviceError.getMessage(), true);
        return wifiPasswordFragment.polling;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$11$lambda$10(Observable observable, WifiPasswordFragment wifiPasswordFragment, BleDeviceError bleDeviceError) {
        Timber.Forest forest = Timber.Forest;
        forest.d("selectedBleDeviceStateObserver: state = " + observable + ", error = " + bleDeviceError, new Object[0]);
        wifiPasswordFragment.hideProgress(wifiPasswordFragment.getContext());
        if ((bleDeviceError.getStateOccurred() instanceof BleDeviceState.PollingWifiConfigStatus) && Intrinsics.areEqual((Object) bleDeviceError.getMessage(), (Object) INCORRECT_PASSWORD_ERROR)) {
            wifiPasswordFragment.showInputError();
        } else if ((bleDeviceError.getStateOccurred() instanceof BleDeviceState.PollingWifiConfigStatus) && Intrinsics.areEqual((Object) bleDeviceError.getMessage(), (Object) "NetworkNotFound")) {
            wifiPasswordFragment.showNetworkError();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$13$lambda$12(WifiPasswordFragment wifiPasswordFragment, BleDeviceState bleDeviceState) {
        Timber.Forest forest = Timber.Forest;
        forest.d("selectedBleDeviceStateObserver: state = " + bleDeviceState, new Object[0]);
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.WifiConnected.INSTANCE)) {
            wifiPasswordFragment.doSuccess();
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.Disconnected.INSTANCE)) {
            wifiPasswordFragment.getViewModel().showConnectionLost();
        }
        wifiPasswordFragment.updateDebugView(bleDeviceState.getName(), false);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$14(WifiPasswordFragment wifiPasswordFragment, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        return wifiPasswordFragment.validateFields();
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$15(WifiPasswordFragment wifiPasswordFragment, Object obj) {
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = wifiPasswordFragment.viewDataBinding;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        fragmentWifiPasswordBinding.buttonNext.setEnabled(false);
        BaseViewModel.showProgress$default(wifiPasswordFragment.getViewModel(), false, 1, (Object) null);
        AddDeviceViewModel.blockNavigation$default(wifiPasswordFragment.getViewModel(), false, 1, (Object) null);
        wifiPasswordFragment.resetInputError();
        AddDeviceViewModel viewModel = wifiPasswordFragment.getViewModel();
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding2 = wifiPasswordFragment.viewDataBinding;
        if (fragmentWifiPasswordBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding2 = null;
        }
        viewModel.setPassword$adddevice_otherRelease(String.valueOf(fragmentWifiPasswordBinding2.passwordEditText.getText()));
        ViewHelperUtil.INSTANCE.hideSoftKeyboard(wifiPasswordFragment.getView());
        Job unused = BuildersKt__Builders_commonKt.launch$default(wifiPasswordFragment, Dispatchers.getMain(), (CoroutineStart) null, new WifiPasswordFragment$onResume$7$1(wifiPasswordFragment, (Continuation<? super WifiPasswordFragment$onResume$7$1>) null), 2, (Object) null);
        return Unit.INSTANCE;
    }

    private final void displayLegalCharactersDescription() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.wifi_password_description_title, (Integer) null, R.string.wifi_password_description_content, Integer.valueOf(R.string.snackbar_ok), (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 4064, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    private final void doSuccess() {
        hideProgress(getContext());
        getViewModel().gotoSuccessScreen();
    }

    private final void resetInputError() {
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding2 = null;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        fragmentWifiPasswordBinding.tvError.setText((CharSequence) null);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding3 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding3 = null;
        }
        fragmentWifiPasswordBinding3.tvError.setVisibility(8);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding4 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentWifiPasswordBinding2 = fragmentWifiPasswordBinding4;
        }
        TextInputLayout textInputLayout = fragmentWifiPasswordBinding2.inputPassword;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "inputPassword");
        ViewUtilsKt.bindSelected(textInputLayout, false);
    }

    private final void showErrorMsg(int i) {
        this.polling = false;
        hideProgress(getContext());
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding2 = null;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        fragmentWifiPasswordBinding.buttonNext.setEnabled(true);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding3 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding3 = null;
        }
        fragmentWifiPasswordBinding3.tvError.setText(getString(i));
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding4 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding4 = null;
        }
        fragmentWifiPasswordBinding4.tvError.setVisibility(0);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding5 = this.viewDataBinding;
        if (fragmentWifiPasswordBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentWifiPasswordBinding2 = fragmentWifiPasswordBinding5;
        }
        TextInputLayout textInputLayout = fragmentWifiPasswordBinding2.inputPassword;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "inputPassword");
        ViewUtilsKt.bindSelected(textInputLayout, true);
    }

    private final void showInputError() {
        showErrorMsg(R.string.password_error_msg);
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        TextInputLayout textInputLayout = fragmentWifiPasswordBinding.inputPassword;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "inputPassword");
        ViewUtilsKt.bindSelected(textInputLayout, true);
        getViewModel().postAnalyticsEvent(new AnalyticEvent.BT_INCORRECT_PW());
        int i = this.passwordErrorCount + 1;
        this.passwordErrorCount = i;
        if (i >= 2) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !childFragmentManager.isStateSaved()) {
                ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_trouble_connecting_wifi, (Integer) null, R.string.hint_trouble_connecting_wifi, Integer.valueOf(R.string.connection_to_purifier_try_again), Integer.valueOf(R.string.action_read_tips), false, false, false, false, (String[]) null, (String) null, new WifiPasswordFragment$$ExternalSyntheticLambda0(this), 1888, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
                childFragmentManager.executePendingTransactions();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Unit showInputError$lambda$20$lambda$19(WifiPasswordFragment wifiPasswordFragment, boolean z) {
        if (z) {
            wifiPasswordFragment.getViewModel().restart();
        } else {
            FragmentManager childFragmentManager = wifiPasswordFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
            Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
            DialogFragment dialogFragment = null;
            if (!(childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager.isStateSaved()) {
                dialogFragment = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, TroubleshootingDialog.ACTION_TYPE_WIFI_GUIDE, (Device) null, 2, (Object) null);
                dialogFragment.show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
                childFragmentManager.executePendingTransactions();
            }
            TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
            if (troubleshootingDialog != null) {
                FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new WifiPasswordFragment$$ExternalSyntheticLambda4(wifiPasswordFragment));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showInputError$lambda$20$lambda$19$lambda$18(WifiPasswordFragment wifiPasswordFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY)) {
            wifiPasswordFragment.getViewModel().restart();
        }
        return Unit.INSTANCE;
    }

    private final void showNetworkError() {
        showErrorMsg(R.string.network_found_error);
    }

    /* access modifiers changed from: private */
    public final void showInputWifiConnError() {
        showErrorMsg(R.string.wifi_disconnected);
    }

    /* access modifiers changed from: private */
    public final void showInputConnectError() {
        showErrorMsg(R.string.connection_to_purifier_lost);
    }

    /* access modifiers changed from: private */
    public final void showRandRegisterError() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if ((childFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) || childFragmentManager.isStateSaved()) {
            return;
        }
        ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.label_failed_to_register_device, (Integer) null, R.string.hint_failed_to_register_device, Integer.valueOf(R.string.connection_to_purifier_try_again), Integer.valueOf(R.string.action_read_tips), false, false, false, false, (String[]) null, (String) null, new WifiPasswordFragment$$ExternalSyntheticLambda5(this), 1888, (Object) null).show(childFragmentManager, "ConfirmationDialogLeftAligned");
        childFragmentManager.executePendingTransactions();
    }

    /* access modifiers changed from: private */
    public static final Unit showRandRegisterError$lambda$24$lambda$23(WifiPasswordFragment wifiPasswordFragment, boolean z) {
        if (z) {
            wifiPasswordFragment.getViewModel().restart();
        } else {
            FragmentManager childFragmentManager = wifiPasswordFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
            Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
            DialogFragment dialogFragment = null;
            if (!(childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager.isStateSaved()) {
                dialogFragment = TroubleshootingDialog.Companion.newInstance$default(TroubleshootingDialog.Companion, TroubleshootingDialog.ACTION_TYPE_WIFI_GUIDE, (Device) null, 2, (Object) null);
                dialogFragment.show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
                childFragmentManager.executePendingTransactions();
            }
            TroubleshootingDialog troubleshootingDialog = (TroubleshootingDialog) dialogFragment;
            if (troubleshootingDialog != null) {
                FragmentExtensionsKt.setFragmentResultListenerWithClear(troubleshootingDialog, TroubleshootingDialog.REQUEST_KEY, new WifiPasswordFragment$$ExternalSyntheticLambda3(wifiPasswordFragment));
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit showRandRegisterError$lambda$24$lambda$23$lambda$22(WifiPasswordFragment wifiPasswordFragment, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(TroubleshootingDialog.ACTION_RETRY)) {
            wifiPasswordFragment.getViewModel().restart();
        }
        return Unit.INSTANCE;
    }

    private final boolean validateFields() {
        if (getViewModel().isHiddenNetwork()) {
            FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
            if (fragmentWifiPasswordBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentWifiPasswordBinding = null;
            }
            getViewModel().getSelectedSsid().setValue(new Ssid(String.valueOf(fragmentWifiPasswordBinding.ssidEditText.getText()), (String) null, 0, (String) null));
        }
        if (!validatePassword()) {
            return false;
        }
        return true;
    }

    private final boolean validatePassword() {
        FragmentWifiPasswordBinding fragmentWifiPasswordBinding = this.viewDataBinding;
        String str = null;
        if (fragmentWifiPasswordBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentWifiPasswordBinding = null;
        }
        String.valueOf(fragmentWifiPasswordBinding.passwordEditText.getText());
        Ssid value = getViewModel().getSelectedSsid().getValue();
        if (value != null) {
            str = value.getSsid();
        }
        if (str != null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        ViewUtils.INSTANCE.showSnackbar((Activity) activity, R.string.select_network_error, (ViewUtils.MessageType) ViewUtils.MessageType.WARNING.INSTANCE);
        return false;
    }

    public void hideProgress(Context context) {
        ProgressFragment.CC.$default$hideProgress(this, context);
        getViewModel().blockNavigation(false);
    }
}
