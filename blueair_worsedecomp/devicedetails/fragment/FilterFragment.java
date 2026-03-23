package com.blueair.devicedetails.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.auth.LocationService;
import com.blueair.core.model.Device;
import com.blueair.core.model.Filter;
import com.blueair.devicedetails.databinding.FragmentFilterBinding;
import com.blueair.devicedetails.dialog.FilterSelectionDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.FilterUtils;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/blueair/devicedetails/fragment/FilterFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/FragmentFilterBinding;", "filter", "Lcom/blueair/core/model/Filter;", "getFilter", "()Lcom/blueair/core/model/Filter;", "setFilter", "(Lcom/blueair/core/model/Filter;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FilterFragment.kt */
public final class FilterFragment extends BaseFragment<DeviceDetailsViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(FilterFragment.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_FILTER = "KEY_FILTER";
    private Device device;
    private Filter filter;
    private final Lazy locationService$delegate;
    private FragmentFilterBinding viewDataBinding;
    public DeviceDetailsViewModel viewModel;

    public void showProgress(boolean z) {
    }

    public FilterFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new FilterFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/fragment/FilterFragment$Companion;", "", "<init>", "()V", "KEY_FILTER", "", "newInstance", "Lcom/blueair/devicedetails/fragment/FilterFragment;", "device", "Lcom/blueair/core/model/Device;", "filter", "Lcom/blueair/core/model/Filter;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: FilterFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FilterFragment newInstance(Device device, Filter filter) {
            Intrinsics.checkNotNullParameter(filter, NotificationService.ACTION_TYPE_FILTER);
            Bundle bundle = new Bundle();
            FilterFragment filterFragment = new FilterFragment();
            bundle.putString(FilterFragment.KEY_FILTER, filter.getName());
            bundle.putParcelable("device", device);
            filterFragment.setArguments(bundle);
            return filterFragment;
        }
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

    public final Filter getFilter() {
        return this.filter;
    }

    public final void setFilter(Filter filter2) {
        this.filter = filter2;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        this.device = device2;
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Device device2;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Timber.Forest.d("parent fragment: " + getParentFragment(), new Object[0]);
        Bundle arguments = getArguments();
        FragmentFilterBinding fragmentFilterBinding = null;
        String string = arguments != null ? arguments.getString(KEY_FILTER) : null;
        Bundle arguments2 = getArguments();
        this.device = arguments2 != null ? (Device) arguments2.getParcelable("device") : null;
        Timber.Forest.d("filterName : " + string, new Object[0]);
        if (string != null) {
            this.filter = Filter.Companion.fromName(string);
        }
        FragmentFilterBinding inflate = FragmentFilterBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setViewModel((DeviceDetailsViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) this).get(DeviceDetailsViewModel.class)));
        inflate.setLifecycleOwner(this);
        this.viewDataBinding = inflate;
        Filter filter2 = this.filter;
        if (!(filter2 == null || (device2 = this.device) == null)) {
            if (inflate == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
                inflate = null;
            }
            inflate.filterImage.setImageResource(FilterUtils.INSTANCE.legacyFilterImageRes(device2, filter2, getLocationService().isInDualProtectionRegion()));
        }
        FragmentFilterBinding fragmentFilterBinding2 = this.viewDataBinding;
        if (fragmentFilterBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentFilterBinding = fragmentFilterBinding2;
        }
        return fragmentFilterBinding.getRoot();
    }

    public void onResume() {
        Filter filter2;
        Device device2;
        super.onResume();
        if ((getParentFragment() instanceof FilterSelectionDialogFragment) && (filter2 = this.filter) != null && (device2 = this.device) != null) {
            Fragment parentFragment = getParentFragment();
            Intrinsics.checkNotNull(parentFragment, "null cannot be cast to non-null type com.blueair.devicedetails.dialog.FilterSelectionDialogFragment");
            TextView toolbarTitleView = ((FilterSelectionDialogFragment) parentFragment).getToolbarTitleView();
            FilterUtils filterUtils = FilterUtils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            toolbarTitleView.setText(filterUtils.legacyFilterName(requireContext, device2, filter2, getLocationService().isInDualProtectionRegion()));
        }
    }
}
