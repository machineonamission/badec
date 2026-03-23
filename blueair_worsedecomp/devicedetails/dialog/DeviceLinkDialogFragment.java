package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.devicedetails.adapter.LinkedDeviceSelectionAction;
import com.blueair.devicedetails.adapter.LinkedDevicesAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceLinkBinding;
import com.blueair.devicedetails.viewmodel.DeviceDetailsState;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 52\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J&\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020(2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00100\u001a\u00020.H\u0016J\b\u00101\u001a\u00020.H\u0002J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u00066"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceLinkDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/HasLinkingCapability;", "getDevice", "()Lcom/blueair/core/model/HasLinkingCapability;", "setDevice", "(Lcom/blueair/core/model/HasLinkingCapability;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceLinkBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "deviceSelectedPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/adapter/LinkedDeviceSelectionAction;", "getDeviceSelectedPublisher", "()Lio/reactivex/subjects/PublishSubject;", "deviceSelectedPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "adapter", "Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/LinkedDevicesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "onResume", "bindViewModel", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceLinkDialogFragment.kt */
public final class DeviceLinkDialogFragment extends BaseDialogFragment<DeviceDetailsViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceLinkDialogFragment.class, "deviceSelectedPublisher", "getDeviceSelectedPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy adapter$delegate = LazyKt.lazy(new DeviceLinkDialogFragment$$ExternalSyntheticLambda2(this));
    public HasLinkingCapability device;
    private final LazyPublishSubject deviceSelectedPublisher$delegate = new LazyPublishSubject();
    private final String screenName;
    private DialogfragmentDeviceLinkBinding viewDataBinding;
    public DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/devicedetails/dialog/DeviceLinkDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceLinkDialogFragment;", "device", "Lcom/blueair/core/model/HasLinkingCapability;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceLinkDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceLinkDialogFragment newInstance(HasLinkingCapability hasLinkingCapability) {
            Intrinsics.checkNotNullParameter(hasLinkingCapability, "device");
            DeviceLinkDialogFragment deviceLinkDialogFragment = new DeviceLinkDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("device", hasLinkingCapability);
            deviceLinkDialogFragment.setArguments(bundle);
            return deviceLinkDialogFragment;
        }
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public final HasLinkingCapability getDevice() {
        HasLinkingCapability hasLinkingCapability = this.device;
        if (hasLinkingCapability != null) {
            return hasLinkingCapability;
        }
        Intrinsics.throwUninitializedPropertyAccessException("device");
        return null;
    }

    public final void setDevice(HasLinkingCapability hasLinkingCapability) {
        Intrinsics.checkNotNullParameter(hasLinkingCapability, "<set-?>");
        this.device = hasLinkingCapability;
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

    private final PublishSubject<LinkedDeviceSelectionAction> getDeviceSelectedPublisher() {
        return this.deviceSelectedPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final LinkedDevicesAdapter getAdapter() {
        return (LinkedDevicesAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final LinkedDevicesAdapter adapter_delegate$lambda$0(DeviceLinkDialogFragment deviceLinkDialogFragment) {
        return new LinkedDevicesAdapter(deviceLinkDialogFragment.getDeviceSelectedPublisher());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Window window;
        Dialog dialog = new Dialog(requireContext());
        FragmentActivity activity = getActivity();
        if (!(activity == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(ContextCompat.getDrawable(activity, R.drawable.rounded_rectangle_white));
        }
        return dialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogfragmentDeviceLinkBinding inflate = DialogfragmentDeviceLinkBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.setDeviceDetailsViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        inflate.setLifecycleOwner(this);
        this.viewDataBinding = inflate;
        DialogfragmentDeviceLinkBinding dialogfragmentDeviceLinkBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            inflate = null;
        }
        DeviceDetailsViewModel deviceDetailsViewModel = inflate.getDeviceDetailsViewModel();
        if (deviceDetailsViewModel != null) {
            setViewModel(deviceDetailsViewModel);
            DialogfragmentDeviceLinkBinding dialogfragmentDeviceLinkBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceLinkBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                dialogfragmentDeviceLinkBinding2 = null;
            }
            dialogfragmentDeviceLinkBinding2.closeBtn.setOnClickListener(new DeviceLinkDialogFragment$$ExternalSyntheticLambda5(this));
            DialogfragmentDeviceLinkBinding dialogfragmentDeviceLinkBinding3 = this.viewDataBinding;
            if (dialogfragmentDeviceLinkBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceLinkBinding = dialogfragmentDeviceLinkBinding3;
            }
            return dialogfragmentDeviceLinkBinding.getRoot();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$3(DeviceLinkDialogFragment deviceLinkDialogFragment, View view) {
        deviceLinkDialogFragment.dismiss();
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        DialogfragmentDeviceLinkBinding dialogfragmentDeviceLinkBinding = null;
        HasLinkingCapability hasLinkingCapability = arguments != null ? (HasLinkingCapability) arguments.getParcelable("device") : null;
        if (hasLinkingCapability != null) {
            setDevice(hasLinkingCapability);
            Timber.Forest forest = Timber.Forest;
            forest.d("onViewCreated: viewModel = " + getViewModel() + ",  device = " + getDevice(), new Object[0]);
            getViewModel().setDeviceId(getDevice().getUid());
            DialogfragmentDeviceLinkBinding dialogfragmentDeviceLinkBinding2 = this.viewDataBinding;
            if (dialogfragmentDeviceLinkBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                dialogfragmentDeviceLinkBinding = dialogfragmentDeviceLinkBinding2;
            }
            dialogfragmentDeviceLinkBinding.productList.setAdapter(getAdapter());
            bindViewModel();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onResume() {
        super.onResume();
        CompositeDisposable rxSubs = getRxSubs();
        Observable<LinkedDeviceSelectionAction> throttleFirst = getDeviceSelectedPublisher().throttleFirst(100, TimeUnit.MILLISECONDS);
        Intrinsics.checkNotNullExpressionValue(throttleFirst, "throttleFirst(...)");
        rxSubs.add(RxExtensionsKt.subscribeAndLogE(throttleFirst, new DeviceLinkDialogFragment$$ExternalSyntheticLambda3(this)));
        DialogfragmentDeviceLinkBinding dialogfragmentDeviceLinkBinding = this.viewDataBinding;
        if (dialogfragmentDeviceLinkBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            dialogfragmentDeviceLinkBinding = null;
        }
        dialogfragmentDeviceLinkBinding.connectButton.setOnClickListener(new DeviceLinkDialogFragment$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$4(DeviceLinkDialogFragment deviceLinkDialogFragment, LinkedDeviceSelectionAction linkedDeviceSelectionAction) {
        Timber.Forest forest = Timber.Forest;
        forest.d("selected aware : " + linkedDeviceSelectionAction.getLinkedDevice(), new Object[0]);
        deviceLinkDialogFragment.getAdapter().setSelectedAware(linkedDeviceSelectionAction.getLinkedDevice());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onResume$lambda$6(DeviceLinkDialogFragment deviceLinkDialogFragment, View view) {
        Device device2;
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("parent device  = ");
        DeviceDetailsState value = deviceLinkDialogFragment.getViewModel().getDeviceDetailsState().getValue();
        sb.append(value != null ? value.getDevice() : null);
        sb.append("  & linkedDevice =  ");
        sb.append(deviceLinkDialogFragment.getAdapter().getSelectedAware());
        forest.d(sb.toString(), new Object[0]);
        DeviceDetailsState value2 = deviceLinkDialogFragment.getViewModel().getDeviceDetailsState().getValue();
        if (!(value2 == null || (device2 = value2.getDevice()) == null || !(device2 instanceof HasLinkingCapability))) {
            deviceLinkDialogFragment.getViewModel().linkDeviceSelected((HasLinkingCapability) device2, deviceLinkDialogFragment.getAdapter().getSelectedAware());
        }
        deviceLinkDialogFragment.dismiss();
    }

    private final void bindViewModel() {
        LiveData<List<Device>> liveDevices = getViewModel().getLiveDevices();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveDevices, viewLifecycleOwner, new DeviceLinkDialogFragment$$ExternalSyntheticLambda0(this));
        LiveData<DeviceDetailsState> deviceDetailsState = getViewModel().getDeviceDetailsState();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(deviceDetailsState, viewLifecycleOwner2, new DeviceLinkDialogFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$7(DeviceLinkDialogFragment deviceLinkDialogFragment, List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        LinkedDevicesAdapter adapter = deviceLinkDialogFragment.getAdapter();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (next instanceof DeviceAware) {
                arrayList.add(next);
            }
        }
        adapter.setAwares((List) arrayList);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$8(DeviceLinkDialogFragment deviceLinkDialogFragment, DeviceDetailsState deviceDetailsState) {
        Intrinsics.checkNotNullParameter(deviceDetailsState, "state");
        deviceLinkDialogFragment.getAdapter().setParentDevice(deviceLinkDialogFragment.getDevice());
        return Unit.INSTANCE;
    }
}
