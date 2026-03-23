package com.blueair.adddevice.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.FragmentAddDeviceSuccessBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.DeviceImage;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.jakewharton.rxbinding2.view.RxView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u001c\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002J\u0011\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001cH\u0001R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!X\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010$\u001a\u00020\u0002X\u000f¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/blueair/adddevice/fragment/AddDeviceSuccessFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceSuccessBinding;", "troubleShowTime", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "showSuccess", "isSuccess", "", "errorMessage", "showProgress", "shouldShowProgress", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceSuccessFragment.kt */
public final class AddDeviceSuccessFragment extends BaseFragment<AddDeviceViewModel> implements BaseFragmentInterface<AddDeviceViewModel> {
    private final /* synthetic */ AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_CONNECTING;
    /* access modifiers changed from: private */
    public long troubleShowTime;
    /* access modifiers changed from: private */
    public FragmentAddDeviceSuccessBinding viewDataBinding;

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

    public void showProgress(boolean z) {
        this.$$delegate_0.showProgress(z);
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        AddDeviceViewModel addDeviceViewModel = (AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class));
        FragmentAddDeviceSuccessBinding inflate = FragmentAddDeviceSuccessBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setAddDeviceViewModel(addDeviceViewModel);
        setViewModel(addDeviceViewModel);
        inflate.setLifecycleOwner(requireActivity());
        this.viewDataBinding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        BluetoothDevice selectedUiDevice = getViewModel().getSelectedUiDevice();
        if (selectedUiDevice != null) {
            FragmentAddDeviceSuccessBinding fragmentAddDeviceSuccessBinding = this.viewDataBinding;
            if (fragmentAddDeviceSuccessBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                fragmentAddDeviceSuccessBinding = null;
            }
            AppCompatImageView appCompatImageView = fragmentAddDeviceSuccessBinding.ivDevice;
            DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(selectedUiDevice);
            appCompatImageView.setImageResource(deviceImage != null ? deviceImage.getDevice() : 0);
        }
    }

    public void onResume() {
        super.onResume();
        getViewModel().recordResume("onboarding");
        Boolean isSelectedBleDeviceBounded = getViewModel().isSelectedBleDeviceBounded();
        BleDeviceError selectedBleDeviceError = getViewModel().getSelectedBleDeviceError();
        FragmentAddDeviceSuccessBinding fragmentAddDeviceSuccessBinding = null;
        if (Intrinsics.areEqual((Object) isSelectedBleDeviceBounded, (Object) true)) {
            showSuccess$default(this, true, (String) null, 2, (Object) null);
        } else if (getViewModel().getPolling()) {
            if (Intrinsics.areEqual((Object) selectedBleDeviceError != null ? selectedBleDeviceError.getStateOccurred() : null, (Object) BleDeviceState.WifiConnected.INSTANCE)) {
                showSuccess(false, selectedBleDeviceError.getMessage());
            }
        }
        Observable<BleDeviceError> selectedBleDeviceErrorObserver = getViewModel().getSelectedBleDeviceErrorObserver();
        if (selectedBleDeviceErrorObserver != null) {
            CompositeDisposable rxSubs = getRxSubs();
            Observable<BleDeviceError> filter = selectedBleDeviceErrorObserver.observeOn(AndroidSchedulers.mainThread()).filter(new AddDeviceSuccessFragment$$ExternalSyntheticLambda1(new AddDeviceSuccessFragment$$ExternalSyntheticLambda0(this)));
            Intrinsics.checkNotNullExpressionValue(filter, "filter(...)");
            rxSubs.add(RxExtensionsKt.subscribeAndLogE(filter, new AddDeviceSuccessFragment$$ExternalSyntheticLambda2(this)));
        }
        Observable<BleDeviceState> selectedBleDeviceStateObserver = getViewModel().getSelectedBleDeviceStateObserver();
        if (selectedBleDeviceStateObserver != null) {
            CompositeDisposable rxSubs2 = getRxSubs();
            Observable<BleDeviceState> observeOn = selectedBleDeviceStateObserver.observeOn(AndroidSchedulers.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(...)");
            rxSubs2.add(RxExtensionsKt.subscribeAndLogE(observeOn, new AddDeviceSuccessFragment$$ExternalSyntheticLambda3(this)));
        }
        CompositeDisposable rxSubs3 = getRxSubs();
        FragmentAddDeviceSuccessBinding fragmentAddDeviceSuccessBinding2 = this.viewDataBinding;
        if (fragmentAddDeviceSuccessBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentAddDeviceSuccessBinding = fragmentAddDeviceSuccessBinding2;
        }
        Observable<Object> clicks = RxView.clicks(fragmentAddDeviceSuccessBinding.buttonContinue);
        Intrinsics.checkNotNullExpressionValue(clicks, "clicks(...)");
        Observable<Object> filterRapidClicks = RxExtensionsKt.filterRapidClicks(clicks);
        Intrinsics.checkNotNullExpressionValue(filterRapidClicks, "filterRapidClicks(...)");
        rxSubs3.add(RxExtensionsKt.subscribeAndLogE(filterRapidClicks, new AddDeviceSuccessFragment$$ExternalSyntheticLambda4(this)));
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$5$lambda$3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(obj, "p0");
        return ((Boolean) function1.invoke(obj)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static final boolean onResume$lambda$5$lambda$2(AddDeviceSuccessFragment addDeviceSuccessFragment, BleDeviceError bleDeviceError) {
        Intrinsics.checkNotNullParameter(bleDeviceError, "it");
        return addDeviceSuccessFragment.getViewModel().getPolling();
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5$lambda$4(AddDeviceSuccessFragment addDeviceSuccessFragment, BleDeviceError bleDeviceError) {
        Timber.Forest forest = Timber.Forest;
        forest.d("selectedBleDeviceStateObserver: state = " + bleDeviceError, new Object[0]);
        if (Intrinsics.areEqual((Object) bleDeviceError.getStateOccurred(), (Object) BleDeviceState.WifiConnected.INSTANCE)) {
            addDeviceSuccessFragment.showSuccess(false, bleDeviceError.getMessage());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7$lambda$6(AddDeviceSuccessFragment addDeviceSuccessFragment, BleDeviceState bleDeviceState) {
        Timber.Forest forest = Timber.Forest;
        forest.d("selectedBleDeviceStateObserver: state = " + bleDeviceState, new Object[0]);
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.Bounded.INSTANCE)) {
            showSuccess$default(addDeviceSuccessFragment, true, (String) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$8(AddDeviceSuccessFragment addDeviceSuccessFragment, Object obj) {
        addDeviceSuccessFragment.getViewModel().gotoEnterNameScreen();
        return Unit.INSTANCE;
    }

    static /* synthetic */ void showSuccess$default(AddDeviceSuccessFragment addDeviceSuccessFragment, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        addDeviceSuccessFragment.showSuccess(z, str);
    }

    private final void showSuccess(boolean z, String str) {
        Timber.Forest forest = Timber.Forest;
        forest.d("showSuccess: isSuccess = " + z + ", errorMessage = " + str, new Object[0]);
        FragmentAddDeviceSuccessBinding fragmentAddDeviceSuccessBinding = null;
        if (z) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new AddDeviceSuccessFragment$showSuccess$1(this, (Continuation<? super AddDeviceSuccessFragment$showSuccess$1>) null), 2, (Object) null);
            FragmentAddDeviceSuccessBinding fragmentAddDeviceSuccessBinding2 = this.viewDataBinding;
            if (fragmentAddDeviceSuccessBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentAddDeviceSuccessBinding = fragmentAddDeviceSuccessBinding2;
            }
            fragmentAddDeviceSuccessBinding.buttonContinue.setVisibility(0);
            return;
        }
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getMain(), (CoroutineStart) null, new AddDeviceSuccessFragment$showSuccess$2(this, str, (Continuation<? super AddDeviceSuccessFragment$showSuccess$2>) null), 2, (Object) null);
    }
}
