package com.blueair.adddevice.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.databinding.FragmentAddDeviceWifiBinding;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Ssid;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00020\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\u0016\u00102\u001a\u00020\"2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001c04H\u0002R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR!\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u001b8BX\u0002¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b#\u0010\u001eR\u0012\u00105\u001a\u000206X\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0018\u00109\u001a\u00020\u0002X\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/blueair/adddevice/fragment/AddDeviceWifiFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewDataBinding", "Lcom/blueair/adddevice/databinding/FragmentAddDeviceWifiBinding;", "ssidAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "Lcom/blueair/adddevice/fragment/RegularSsidItem;", "hiddenNetworkAdapter", "Lcom/blueair/adddevice/fragment/HiddenSsidItem;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ssidSelectPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/Ssid;", "getSsidSelectPublisher", "()Lio/reactivex/subjects/PublishSubject;", "ssidSelectPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "hiddenNetworkSelectPublisher", "", "getHiddenNetworkSelectPublisher", "hiddenNetworkSelectPublisher$delegate", "showProgress", "shouldShowProgress", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "updateSsidList", "newList", "", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceWifiFragment.kt */
public final class AddDeviceWifiFragment extends BaseFragment<AddDeviceViewModel> implements ProgressFragment, BaseFragmentInterface<AddDeviceViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final /* synthetic */ AddDeviceFragment $$delegate_0 = new AddDeviceFragment();
    private final ItemAdapter<HiddenSsidItem> hiddenNetworkAdapter;
    private final LazyPublishSubject hiddenNetworkSelectPublisher$delegate;
    private ProgressBlockerView progressBlockerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.ADD_DEVICE_WIFI_LIST;
    private final ItemAdapter<RegularSsidItem> ssidAdapter = new ItemAdapter<>();
    private final LazyPublishSubject ssidSelectPublisher$delegate;
    /* access modifiers changed from: private */
    public FragmentAddDeviceWifiBinding viewDataBinding;

    static {
        Class<AddDeviceWifiFragment> cls = AddDeviceWifiFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "ssidSelectPublisher", "getSsidSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "hiddenNetworkSelectPublisher", "getHiddenNetworkSelectPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    }

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

    public AddDeviceWifiFragment() {
        ItemAdapter<HiddenSsidItem> itemAdapter = new ItemAdapter<>();
        itemAdapter.add((Object[]) new HiddenSsidItem[]{HiddenSsidItem.INSTANCE});
        this.hiddenNetworkAdapter = itemAdapter;
        this.ssidSelectPublisher$delegate = new LazyPublishSubject();
        this.hiddenNetworkSelectPublisher$delegate = new LazyPublishSubject();
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

    public ProgressBlockerView getProgressBlockerView() {
        return this.progressBlockerView;
    }

    public void setProgressBlockerView(ProgressBlockerView progressBlockerView2) {
        this.progressBlockerView = progressBlockerView2;
    }

    public ConstraintLayout getRootView() {
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding = this.viewDataBinding;
        if (fragmentAddDeviceWifiBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentAddDeviceWifiBinding = null;
        }
        ConstraintLayout constraintLayout = fragmentAddDeviceWifiBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        return constraintLayout;
    }

    private final PublishSubject<Ssid> getSsidSelectPublisher() {
        return this.ssidSelectPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final PublishSubject<Unit> getHiddenNetworkSelectPublisher() {
        return this.hiddenNetworkSelectPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[1]);
    }

    public void showProgress(boolean z) {
        ProgressFragment.CC.showProgress$default(this, getContext(), z, (Integer) null, 4, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentAddDeviceWifiBinding inflate = FragmentAddDeviceWifiBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        inflate.setAddDeviceViewModel((AddDeviceViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(AddDeviceViewModel.class)));
        inflate.setLifecycleOwner(requireActivity());
        this.viewDataBinding = inflate;
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        setProgressBlockerView(inflate.progressView);
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding2 = this.viewDataBinding;
        if (fragmentAddDeviceWifiBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentAddDeviceWifiBinding2 = null;
        }
        fragmentAddDeviceWifiBinding2.swipeToRefresh.setEnabled(false);
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding3 = this.viewDataBinding;
        if (fragmentAddDeviceWifiBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentAddDeviceWifiBinding3 = null;
        }
        AddDeviceViewModel addDeviceViewModel = fragmentAddDeviceWifiBinding3.getAddDeviceViewModel();
        Intrinsics.checkNotNull(addDeviceViewModel);
        setViewModel(addDeviceViewModel);
        Flow onEach = FlowKt.onEach(getViewModel().isRefreshingSsids(), new AddDeviceWifiFragment$onCreateView$2(this, (Continuation<? super AddDeviceWifiFragment$onCreateView$2>) null));
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        FlowKt.launchIn(onEach, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2).launchWhenResumed(new AddDeviceWifiFragment$onCreateView$3(this, (Continuation<? super AddDeviceWifiFragment$onCreateView$3>) null));
        FastAdapter with = FastAdapter.Companion.with(CollectionsKt.listOf(this.ssidAdapter, this.hiddenNetworkAdapter));
        with.setOnClickListener(new AddDeviceWifiFragment$$ExternalSyntheticLambda0(this));
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding4 = this.viewDataBinding;
        if (fragmentAddDeviceWifiBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentAddDeviceWifiBinding4 = null;
        }
        fragmentAddDeviceWifiBinding4.recyclerViewSsid.setAdapter(with);
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding5 = this.viewDataBinding;
        if (fragmentAddDeviceWifiBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentAddDeviceWifiBinding = fragmentAddDeviceWifiBinding5;
        }
        View root = fragmentAddDeviceWifiBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final boolean onCreateView$lambda$2(AddDeviceWifiFragment addDeviceWifiFragment, View view, IAdapter iAdapter, AbstractBindingItem abstractBindingItem, int i) {
        Intrinsics.checkNotNullParameter(iAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(abstractBindingItem, "item");
        if (abstractBindingItem instanceof RegularSsidItem) {
            addDeviceWifiFragment.getSsidSelectPublisher().onNext(((RegularSsidItem) abstractBindingItem).getSsid());
            return true;
        } else if (!Intrinsics.areEqual((Object) abstractBindingItem, (Object) HiddenSsidItem.INSTANCE)) {
            return true;
        } else {
            addDeviceWifiFragment.getHiddenNetworkSelectPublisher().onNext(Unit.INSTANCE);
            return true;
        }
    }

    public void onResume() {
        super.onResume();
        getViewModel().recordResume("wifi_list");
        Observable<BleDeviceError> selectedBleDeviceErrorObserver = getViewModel().getSelectedBleDeviceErrorObserver();
        if (selectedBleDeviceErrorObserver != null) {
            CompositeDisposable rxSubs = getRxSubs();
            Observable<BleDeviceError> observeOn = selectedBleDeviceErrorObserver.observeOn(AndroidSchedulers.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(...)");
            rxSubs.add(RxExtensionsKt.subscribeAndLogE(observeOn, new AddDeviceWifiFragment$$ExternalSyntheticLambda1(this)));
        }
        getRxSubs().add(RxExtensionsKt.uiThread(getViewModel().getBluetoothConnectionStateObserver()).subscribe(new AddDeviceWifiFragment$$ExternalSyntheticLambda3(new AddDeviceWifiFragment$$ExternalSyntheticLambda2(this)), new AddDeviceWifiFragment$$ExternalSyntheticLambda5(new AddDeviceWifiFragment$$ExternalSyntheticLambda4())));
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getSsidSelectPublisher(), new AddDeviceWifiFragment$$ExternalSyntheticLambda6(this)));
        Observable<BleDeviceState> selectedBleDeviceStateObserver = getViewModel().getSelectedBleDeviceStateObserver();
        if (selectedBleDeviceStateObserver != null) {
            CompositeDisposable rxSubs2 = getRxSubs();
            Observable<BleDeviceState> observeOn2 = selectedBleDeviceStateObserver.observeOn(AndroidSchedulers.mainThread());
            Intrinsics.checkNotNullExpressionValue(observeOn2, "observeOn(...)");
            rxSubs2.add(RxExtensionsKt.subscribeAndLogE(observeOn2, new AddDeviceWifiFragment$$ExternalSyntheticLambda7(this)));
        }
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getHiddenNetworkSelectPublisher(), new AddDeviceWifiFragment$$ExternalSyntheticLambda8(this)));
        FragmentAddDeviceWifiBinding fragmentAddDeviceWifiBinding = this.viewDataBinding;
        if (fragmentAddDeviceWifiBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentAddDeviceWifiBinding = null;
        }
        fragmentAddDeviceWifiBinding.btnRefresh.setOnClickListener(new AddDeviceWifiFragment$$ExternalSyntheticLambda9(this));
        getViewModel().refreshSsidsList();
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$4$lambda$3(AddDeviceWifiFragment addDeviceWifiFragment, BleDeviceError bleDeviceError) {
        Timber.Forest forest = Timber.Forest;
        forest.w("selectedBleDeviceErrorObserver: error = " + bleDeviceError, new Object[0]);
        addDeviceWifiFragment.getViewModel().showConnectionLost();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$6(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(AddDeviceWifiFragment addDeviceWifiFragment, Boolean bool) {
        Timber.Forest forest = Timber.Forest;
        forest.d("connectionChangedObserver: hasBluetooth = " + bool + ", hasSelectedBleDevice = " + addDeviceWifiFragment.getViewModel().getHasSelectedBleDevice(), new Object[0]);
        if (!bool.booleanValue()) {
            addDeviceWifiFragment.getViewModel().showConnectionLost();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$8(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        Timber.Forest.e(th, "Connection Change Observer failed", new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$9(AddDeviceWifiFragment addDeviceWifiFragment, Ssid ssid) {
        addDeviceWifiFragment.getViewModel().gotoWifiPassword(ssid, false);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$11$lambda$10(AddDeviceWifiFragment addDeviceWifiFragment, BleDeviceState bleDeviceState) {
        Timber.Forest forest = Timber.Forest;
        forest.d("selectedBleDeviceStateObserver: state = " + bleDeviceState, new Object[0]);
        if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.WifiConnected.INSTANCE)) {
            addDeviceWifiFragment.getViewModel().gotoSuccessScreen();
        } else if (Intrinsics.areEqual((Object) bleDeviceState, (Object) BleDeviceState.Disconnected.INSTANCE)) {
            addDeviceWifiFragment.getViewModel().showConnectionLost();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$12(AddDeviceWifiFragment addDeviceWifiFragment, Unit unit) {
        addDeviceWifiFragment.getViewModel().gotoWifiPassword((Ssid) null, true);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$13(AddDeviceWifiFragment addDeviceWifiFragment, View view) {
        addDeviceWifiFragment.updateSsidList(CollectionsKt.emptyList());
        Job unused = BuildersKt__Builders_commonKt.launch$default(addDeviceWifiFragment, Dispatchers.getMain(), (CoroutineStart) null, new AddDeviceWifiFragment$onResume$7$1(addDeviceWifiFragment, (Continuation<? super AddDeviceWifiFragment$onResume$7$1>) null), 2, (Object) null);
    }

    public void onDestroy() {
        clearProgressFragment();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public final void updateSsidList(List<Ssid> list) {
        Timber.Forest forest = Timber.Forest;
        forest.i("new list = " + list, new Object[0]);
        this.ssidAdapter.clear();
        ItemAdapter<RegularSsidItem> itemAdapter = this.ssidAdapter;
        Iterable<Ssid> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Ssid regularSsidItem : iterable) {
            arrayList.add(new RegularSsidItem(regularSsidItem));
        }
        itemAdapter.add((List) arrayList);
        hideProgress(getContext());
    }
}
