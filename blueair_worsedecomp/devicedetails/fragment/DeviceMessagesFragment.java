package com.blueair.devicedetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceControlsAdapter;
import com.blueair.devicedetails.databinding.FragmentDeviceMessagesBinding;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceControlGroup;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R%\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceMessagesFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/FragmentDeviceMessagesBinding;", "controlActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "getControlActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "controlActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "dpToPx1", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "handlePadding", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceMessagesFragment.kt */
public final class DeviceMessagesFragment extends BaseFragment<DeviceDetailsViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceMessagesFragment.class, "controlActionPublisher", "getControlActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy adapter$delegate = LazyKt.lazy(new DeviceMessagesFragment$$ExternalSyntheticLambda1(this));
    private FragmentDeviceMessagesBinding binding;
    private final LazyPublishSubject controlActionPublisher$delegate = new LazyPublishSubject();
    private float dpToPx1;
    public DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/blueair/devicedetails/fragment/DeviceMessagesFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/fragment/DeviceMessagesFragment;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceMessagesFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceMessagesFragment newInstance() {
            return new DeviceMessagesFragment();
        }
    }

    private final PublishSubject<AttributeAction<?>> getControlActionPublisher() {
        return this.controlActionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public static final DeviceControlsAdapter adapter_delegate$lambda$0(DeviceMessagesFragment deviceMessagesFragment) {
        return new DeviceControlsAdapter(DeviceControlGroup.MESSAGE, deviceMessagesFragment.getControlActionPublisher());
    }

    private final DeviceControlsAdapter getAdapter() {
        return (DeviceControlsAdapter) this.adapter$delegate.getValue();
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseFragment baseFragment = this;
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS()).get(DeviceDetailsViewModel.class)));
        FragmentDeviceMessagesBinding inflate = FragmentDeviceMessagesBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        FragmentDeviceMessagesBinding fragmentDeviceMessagesBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        inflate.messageList.setLayoutManager(new LinearLayoutManager(requireContext()));
        FragmentDeviceMessagesBinding fragmentDeviceMessagesBinding2 = this.binding;
        if (fragmentDeviceMessagesBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceMessagesBinding2 = null;
        }
        fragmentDeviceMessagesBinding2.messageList.setAdapter(getAdapter());
        this.dpToPx1 = TypedValueCompat.dpToPx(1.0f, requireContext().getResources().getDisplayMetrics());
        getAdapter().setOnItemCountChangedListener(new DeviceMessagesFragment$$ExternalSyntheticLambda2(this));
        LiveData<Device> liveDevice = getViewModel().getLiveDevice();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevice, viewLifecycleOwner, new DeviceMessagesFragment$$ExternalSyntheticLambda3(this));
        LiveData<Boolean> networkAvailable = getViewModel().getNetworkAvailable();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(networkAvailable, viewLifecycleOwner2, new DeviceMessagesFragment$$ExternalSyntheticLambda4(this));
        FragmentDeviceMessagesBinding fragmentDeviceMessagesBinding3 = this.binding;
        if (fragmentDeviceMessagesBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragmentDeviceMessagesBinding = fragmentDeviceMessagesBinding3;
        }
        RecyclerView root = fragmentDeviceMessagesBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$1(DeviceMessagesFragment deviceMessagesFragment) {
        deviceMessagesFragment.handlePadding();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$2(DeviceMessagesFragment deviceMessagesFragment, Device device) {
        deviceMessagesFragment.getAdapter().setDevice(device);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreateView$lambda$3(DeviceMessagesFragment deviceMessagesFragment, boolean z) {
        deviceMessagesFragment.getAdapter().setForceOffline(!z);
        return Unit.INSTANCE;
    }

    public void onResume() {
        super.onResume();
        CompositeDisposable rxSubs = getRxSubs();
        Observable<AttributeAction<?>> throttleLatest = getControlActionPublisher().throttleLatest(300, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleLatest, "throttleLatest(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(throttleLatest, new DeviceMessagesFragment$$ExternalSyntheticLambda0(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$6(DeviceMessagesFragment deviceMessagesFragment, AttributeAction attributeAction) {
        Timber.Forest forest = Timber.Forest;
        forest.v("throttleLatest action: " + attributeAction, new Object[0]);
        if (deviceMessagesFragment.getViewModel().getDevice() != null && (attributeAction instanceof AttributeAction.TroubleShootAction)) {
            FragmentManager childFragmentManager = deviceMessagesFragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            Class<TroubleshootingDialog> cls = TroubleshootingDialog.class;
            Intrinsics.checkNotNullExpressionValue(TroubleshootingDialog.REQUEST_KEY, "getSimpleName(...)");
            if (!(childFragmentManager.findFragmentByTag(TroubleshootingDialog.REQUEST_KEY) instanceof TroubleshootingDialog) && !childFragmentManager.isStateSaved()) {
                TroubleshootingDialog.Companion.newInstance(TroubleshootingDialog.ACTION_TYPE_DEVICE_OFFLINE, deviceMessagesFragment.getAdapter().getDevice()).show(childFragmentManager, TroubleshootingDialog.REQUEST_KEY);
                childFragmentManager.executePendingTransactions();
            }
        }
        return Unit.INSTANCE;
    }

    private final void handlePadding() {
        FragmentDeviceMessagesBinding fragmentDeviceMessagesBinding = this.binding;
        if (fragmentDeviceMessagesBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragmentDeviceMessagesBinding = null;
        }
        RecyclerView recyclerView = fragmentDeviceMessagesBinding.messageList;
        if (getAdapter().getItemCount() == 0) {
            recyclerView.setPadding(recyclerView.getPaddingLeft(), 0, recyclerView.getPaddingRight(), 0);
        } else {
            recyclerView.setPadding(recyclerView.getPaddingLeft(), MathKt.roundToInt(this.dpToPx1 * ((float) 24)), recyclerView.getPaddingRight(), 0);
        }
    }
}
