package com.blueair.android.fragment;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.AddLocationItem;
import com.blueair.android.adapter.OutdoorLocationItem;
import com.blueair.android.databinding.FragmentOutdoorBinding;
import com.blueair.android.util.SimpleScrollingPagerIndicator;
import com.blueair.android.viewmodel.OutdoorViewModel;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.LocationPermissionTracker;
import com.blueair.core.util.LocationUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.dialog.DialogUtils;
import com.blueair.viewcore.fragment.BaseFragment;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.blueair.viewcore.view.ScrollingPageIndicatorAccessibilityDelegate;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002NOB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001a\u00101\u001a\u0002022\u0006\u00103\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00104\u001a\u000202H\u0002J\f\u00105\u001a\u000202*\u00020\u0000H\u0002J\b\u00106\u001a\u000202H\u0002J\u0016\u00107\u001a\u0002022\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020:H\u0002J\b\u0010=\u001a\u000202H\u0016J\u0012\u0010>\u001a\u0002022\b\b\u0002\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002022\u0006\u0010B\u001a\u00020CH\u0003J\b\u0010D\u001a\u000202H\u0003J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020GH\u0002J&\u0010H\u001a\u0002022\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010J\u001a\u00020K2\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010L\u001a\u0002022\u0006\u0010M\u001a\u00020@H\u0016R\u001a\u0010\u0005\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\b \u0010!R#\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0$8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b&\u0010'¨\u0006P"}, d2 = {"Lcom/blueair/android/fragment/OutdoorFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/android/viewmodel/OutdoorViewModel;", "<init>", "()V", "viewModel", "getViewModel", "()Lcom/blueair/android/viewmodel/OutdoorViewModel;", "setViewModel", "(Lcom/blueair/android/viewmodel/OutdoorViewModel;)V", "viewDataBinding", "Lcom/blueair/android/databinding/FragmentOutdoorBinding;", "curLocationItem", "Lcom/blueair/android/adapter/OutdoorLocationItem;", "userLocationAdapter", "Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "currentLocationAdapter", "getCurrentLocationAdapter", "()Lcom/mikepenz/fastadapter/adapters/ItemAdapter;", "currentLocationAdapter$delegate", "Lkotlin/Lazy;", "addLocationAdapter", "Lcom/blueair/android/adapter/AddLocationItem;", "getAddLocationAdapter", "addLocationAdapter$delegate", "locationPermissionTracker", "Lcom/blueair/core/util/LocationPermissionTracker;", "getLocationPermissionTracker", "()Lcom/blueair/core/util/LocationPermissionTracker;", "locationPermissionTracker$delegate", "locationListener", "Lcom/blueair/android/fragment/OutdoorFragment$CurrentLocationListener;", "getLocationListener", "()Lcom/blueair/android/fragment/OutdoorFragment$CurrentLocationListener;", "locationListener$delegate", "aqiDataObserver", "Landroidx/lifecycle/Observer;", "Lcom/blueair/core/model/AqiData;", "getAqiDataObserver", "()Landroidx/lifecycle/Observer;", "aqiDataObserver$delegate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupRecyclerView", "enableLocation", "observeViewModel", "observeAqiForUserLocation", "userLocations", "", "Lcom/blueair/core/model/TrackedLocation;", "observeAqiWithLocation", "trackedLocation", "onResume", "handleCurLocation", "forceTrack", "", "startLocationTracking", "context", "Landroid/content/Context;", "stopLocationTracking", "notifyCurLocationItemChange", "payload", "", "notifyLocationItemChange", "itemAdapter", "position", "", "showProgress", "shouldShowProgress", "Companion", "CurrentLocationListener", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorFragment.kt */
public final class OutdoorFragment extends BaseFragment<OutdoorViewModel> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(OutdoorFragment.class, "locationPermissionTracker", "getLocationPermissionTracker()Lcom/blueair/core/util/LocationPermissionTracker;", 0))};
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_LOCATION_SERVICE = 10102;
    private final Lazy addLocationAdapter$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda10());
    private final Lazy aqiDataObserver$delegate;
    private final OutdoorLocationItem curLocationItem = new OutdoorLocationItem((TrackedLocation) null, (AqiData) null, true, 3, (DefaultConstructorMarker) null);
    private final Lazy currentLocationAdapter$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda9(this));
    private final Lazy locationListener$delegate;
    private final Lazy locationPermissionTracker$delegate;
    private final ItemAdapter<OutdoorLocationItem> userLocationAdapter = new ItemAdapter<>();
    /* access modifiers changed from: private */
    public FragmentOutdoorBinding viewDataBinding;
    public OutdoorViewModel viewModel;

    public void showProgress(boolean z) {
    }

    public OutdoorFragment() {
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationPermissionTracker$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, LocationPermissionTracker.class), (Object) null).provideDelegate(this, $$delegatedProperties[0]);
        this.locationListener$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda11());
        this.aqiDataObserver$delegate = LazyKt.lazy(new OutdoorFragment$$ExternalSyntheticLambda12(this));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/android/fragment/OutdoorFragment$Companion;", "", "<init>", "()V", "REQUEST_LOCATION_SERVICE", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public OutdoorViewModel getViewModel() {
        OutdoorViewModel outdoorViewModel = this.viewModel;
        if (outdoorViewModel != null) {
            return outdoorViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public void setViewModel(OutdoorViewModel outdoorViewModel) {
        Intrinsics.checkNotNullParameter(outdoorViewModel, "<set-?>");
        this.viewModel = outdoorViewModel;
    }

    private final ItemAdapter<OutdoorLocationItem> getCurrentLocationAdapter() {
        return (ItemAdapter) this.currentLocationAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ItemAdapter currentLocationAdapter_delegate$lambda$1(OutdoorFragment outdoorFragment) {
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.add((Object[]) new OutdoorLocationItem[]{outdoorFragment.curLocationItem});
        return itemAdapter;
    }

    private final ItemAdapter<AddLocationItem> getAddLocationAdapter() {
        return (ItemAdapter) this.addLocationAdapter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ItemAdapter addLocationAdapter_delegate$lambda$3() {
        ItemAdapter itemAdapter = new ItemAdapter();
        itemAdapter.add((Object[]) new AddLocationItem[]{AddLocationItem.INSTANCE});
        return itemAdapter;
    }

    private final LocationPermissionTracker getLocationPermissionTracker() {
        return (LocationPermissionTracker) this.locationPermissionTracker$delegate.getValue();
    }

    private final CurrentLocationListener getLocationListener() {
        return (CurrentLocationListener) this.locationListener$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final CurrentLocationListener locationListener_delegate$lambda$4() {
        return new CurrentLocationListener();
    }

    private final Observer<AqiData> getAqiDataObserver() {
        return (Observer) this.aqiDataObserver$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Observer aqiDataObserver_delegate$lambda$7(OutdoorFragment outdoorFragment) {
        return new OutdoorFragment$$ExternalSyntheticLambda3(outdoorFragment);
    }

    /* access modifiers changed from: private */
    public static final void aqiDataObserver_delegate$lambda$7$lambda$6(OutdoorFragment outdoorFragment, AqiData aqiData) {
        if (aqiData != null) {
            String locationId = aqiData.getLocationId();
            if (Intrinsics.areEqual((Object) locationId, (Object) "current")) {
                outdoorFragment.curLocationItem.setAqiData(aqiData);
                outdoorFragment.notifyCurLocationItemChange(OutdoorLocationItem.PAYLOAD_AQIDATA);
                return;
            }
            Iterator<OutdoorLocationItem> it = outdoorFragment.userLocationAdapter.getAdapterItems().iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                TrackedLocation trackedLocation = it.next().getTrackedLocation();
                if (Intrinsics.areEqual((Object) trackedLocation != null ? trackedLocation.getId() : null, (Object) locationId)) {
                    break;
                }
                i++;
            }
            if (i > -1) {
                outdoorFragment.userLocationAdapter.getAdapterItem(i).setAqiData(aqiData);
                outdoorFragment.notifyLocationItemChange(outdoorFragment.userLocationAdapter, i, OutdoorLocationItem.PAYLOAD_AQIDATA);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentOutdoorBinding inflate = FragmentOutdoorBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        inflate.setOutdoorViewModel((OutdoorViewModel) ((BaseViewModel) new ViewModelProvider((ViewModelStoreOwner) requireActivity).get(OutdoorViewModel.class)));
        inflate.setLifecycleOwner(this);
        this.viewDataBinding = inflate;
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("onCreateView: viewDataBinding = ");
        FragmentOutdoorBinding fragmentOutdoorBinding = this.viewDataBinding;
        FragmentOutdoorBinding fragmentOutdoorBinding2 = null;
        if (fragmentOutdoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding = null;
        }
        sb.append(fragmentOutdoorBinding);
        sb.append(", root = ");
        FragmentOutdoorBinding fragmentOutdoorBinding3 = this.viewDataBinding;
        if (fragmentOutdoorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding3 = null;
        }
        sb.append(fragmentOutdoorBinding3.getRoot());
        sb.append(", outdoorViewModel = ");
        FragmentOutdoorBinding fragmentOutdoorBinding4 = this.viewDataBinding;
        if (fragmentOutdoorBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding4 = null;
        }
        sb.append(fragmentOutdoorBinding4.getOutdoorViewModel());
        forest.d(sb.toString(), new Object[0]);
        FragmentOutdoorBinding fragmentOutdoorBinding5 = this.viewDataBinding;
        if (fragmentOutdoorBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding5 = null;
        }
        OutdoorViewModel outdoorViewModel = fragmentOutdoorBinding5.getOutdoorViewModel();
        if (outdoorViewModel != null) {
            setViewModel(outdoorViewModel);
            FragmentOutdoorBinding fragmentOutdoorBinding6 = this.viewDataBinding;
            if (fragmentOutdoorBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentOutdoorBinding2 = fragmentOutdoorBinding6;
            }
            View root = fragmentOutdoorBinding2.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            return root;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        setupRecyclerView();
        FragmentOutdoorBinding fragmentOutdoorBinding = this.viewDataBinding;
        FragmentOutdoorBinding fragmentOutdoorBinding2 = null;
        if (fragmentOutdoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding = null;
        }
        SimpleScrollingPagerIndicator simpleScrollingPagerIndicator = fragmentOutdoorBinding.pageDots;
        FragmentOutdoorBinding fragmentOutdoorBinding3 = this.viewDataBinding;
        if (fragmentOutdoorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentOutdoorBinding2 = fragmentOutdoorBinding3;
        }
        simpleScrollingPagerIndicator.attachToRecyclerView(fragmentOutdoorBinding2.rvLocation);
        simpleScrollingPagerIndicator.setFocusable(true);
        simpleScrollingPagerIndicator.setFocusableInTouchMode(false);
        if (Build.VERSION.SDK_INT > 27) {
            simpleScrollingPagerIndicator.setScreenReaderFocusable(true);
        }
        Intrinsics.checkNotNullExpressionValue(simpleScrollingPagerIndicator, "apply(...)");
        ViewCompat.setAccessibilityDelegate(simpleScrollingPagerIndicator, new ScrollingPageIndicatorAccessibilityDelegate(new OutdoorFragment$$ExternalSyntheticLambda6(simpleScrollingPagerIndicator), new OutdoorFragment$$ExternalSyntheticLambda7(this)));
        observeViewModel();
    }

    /* access modifiers changed from: private */
    public static final int onViewCreated$lambda$10(SimpleScrollingPagerIndicator simpleScrollingPagerIndicator) {
        return simpleScrollingPagerIndicator.getCurrentPostion() + 1;
    }

    /* access modifiers changed from: private */
    public static final int onViewCreated$lambda$11(OutdoorFragment outdoorFragment) {
        FragmentOutdoorBinding fragmentOutdoorBinding = outdoorFragment.viewDataBinding;
        if (fragmentOutdoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding = null;
        }
        RecyclerView.Adapter adapter = fragmentOutdoorBinding.rvLocation.getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    private final void setupRecyclerView() {
        FastAdapter with = FastAdapter.Companion.with(CollectionsKt.listOf(getCurrentLocationAdapter(), this.userLocationAdapter, getAddLocationAdapter()));
        with.setOnClickListener(new OutdoorFragment$$ExternalSyntheticLambda8(this));
        FragmentOutdoorBinding fragmentOutdoorBinding = this.viewDataBinding;
        FragmentOutdoorBinding fragmentOutdoorBinding2 = null;
        if (fragmentOutdoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding = null;
        }
        fragmentOutdoorBinding.rvLocation.setAdapter(with);
        float dpToPx = TypedValueCompat.dpToPx(8.0f, getResources().getDisplayMetrics());
        FragmentOutdoorBinding fragmentOutdoorBinding3 = this.viewDataBinding;
        if (fragmentOutdoorBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding3 = null;
        }
        fragmentOutdoorBinding3.rvLocation.addItemDecoration(new SimpleSpacingDecoration((int) dpToPx, 0, false, 4, (DefaultConstructorMarker) null));
        FragmentOutdoorBinding fragmentOutdoorBinding4 = this.viewDataBinding;
        if (fragmentOutdoorBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
        } else {
            fragmentOutdoorBinding2 = fragmentOutdoorBinding4;
        }
        fragmentOutdoorBinding2.rvLocation.addOnScrollListener(new OutdoorFragment$setupRecyclerView$2(this));
    }

    /* access modifiers changed from: private */
    public static final boolean setupRecyclerView$lambda$12(OutdoorFragment outdoorFragment, View view, IAdapter iAdapter, AbstractBindingItem abstractBindingItem, int i) {
        String str;
        Intrinsics.checkNotNullParameter(iAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(abstractBindingItem, "item");
        if (abstractBindingItem instanceof OutdoorLocationItem) {
            OutdoorLocationItem outdoorLocationItem = (OutdoorLocationItem) abstractBindingItem;
            if (outdoorLocationItem.getUseCurrentLocation()) {
                Context requireContext = outdoorFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                if (!outdoorLocationItem.isLocationEnable(requireContext)) {
                    outdoorFragment.enableLocation(outdoorFragment);
                    return true;
                }
            }
            Actions actions = Actions.INSTANCE;
            FragmentActivity requireActivity = outdoorFragment.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            Context context = requireActivity;
            LocationService.MapType mapType = outdoorFragment.getViewModel().getMapType();
            TrackedLocation trackedLocation = outdoorLocationItem.getTrackedLocation();
            if (trackedLocation == null || (str = trackedLocation.getId()) == null) {
                str = "";
            }
            outdoorFragment.startActivity(Actions.openMapIntent$default(actions, context, mapType, str, false, outdoorLocationItem.getUseCurrentLocation(), (String) null, 40, (Object) null));
            return true;
        } else if (!(abstractBindingItem instanceof AddLocationItem)) {
            return true;
        } else {
            Actions actions2 = Actions.INSTANCE;
            Context requireContext2 = outdoorFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
            outdoorFragment.startActivity(Actions.openMapIntent$default(actions2, requireContext2, outdoorFragment.getViewModel().getMapType(), (String) null, true, false, (String) null, 52, (Object) null));
            return true;
        }
    }

    private final void enableLocation(OutdoorFragment outdoorFragment) {
        LocationUtils locationUtils = LocationUtils.INSTANCE;
        Context requireContext = outdoorFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        if (!locationUtils.isLocationPermissionGranted(requireContext)) {
            outdoorFragment.getLocationPermissionTracker().requestLocationPermission(outdoorFragment, new OutdoorFragment$$ExternalSyntheticLambda4());
        } else {
            outdoorFragment.startActivityForResult(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), REQUEST_LOCATION_SERVICE);
        }
        outdoorFragment.getViewModel().trackEvent(new AnalyticEvent.ENABLE_GPS_LOCATION());
    }

    /* access modifiers changed from: private */
    public static final Unit enableLocation$lambda$13() {
        DialogUtils.INSTANCE.showRequestPermissionHint(R.string.permission_request_title_location_outdoor, R.string.permission_request_message_location_outdoor);
        return Unit.INSTANCE;
    }

    private final void observeViewModel() {
        getViewModel().getLiveUserLocations().observe(getViewLifecycleOwner(), new OutdoorFragment$sam$androidx_lifecycle_Observer$0(new OutdoorFragment$$ExternalSyntheticLambda13(this)));
        getViewModel().getLiveCurrentLocation().observe(getViewLifecycleOwner(), new OutdoorFragment$sam$androidx_lifecycle_Observer$0(new OutdoorFragment$$ExternalSyntheticLambda1(this)));
        LiveData<Location> liveLocation = getLocationListener().getLiveLocation();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        LiveDataExtensionsKt.observeNonNull(liveLocation, viewLifecycleOwner, new OutdoorFragment$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$15(OutdoorFragment outdoorFragment, List list) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        IItemAdapter iItemAdapter = outdoorFragment.userLocationAdapter;
        Iterable<TrackedLocation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TrackedLocation outdoorLocationItem : iterable) {
            arrayList.add(new OutdoorLocationItem(outdoorLocationItem, (AqiData) null, false, 6, (DefaultConstructorMarker) null));
        }
        IItemAdapter.DefaultImpls.setNewList$default(iItemAdapter, (List) arrayList, false, 2, (Object) null);
        outdoorFragment.observeAqiForUserLocation(list);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$16(OutdoorFragment outdoorFragment, TrackedLocation trackedLocation) {
        outdoorFragment.curLocationItem.setTrackedLocation(trackedLocation);
        outdoorFragment.notifyCurLocationItemChange(OutdoorLocationItem.PAYLOAD_TRACKED_LOCATION);
        if (trackedLocation == null) {
            LiveData remove = outdoorFragment.getViewModel().getAqiDataMap().remove("current");
            if (remove != null) {
                remove.removeObserver(outdoorFragment.getAqiDataObserver());
            }
        } else {
            outdoorFragment.observeAqiWithLocation(trackedLocation);
            outdoorFragment.getViewModel().refreshAqiData(trackedLocation);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$17(OutdoorFragment outdoorFragment, Location location) {
        Intrinsics.checkNotNullParameter(location, "loc");
        outdoorFragment.getViewModel().setCurrentLocation(location.getLatitude(), location.getLongitude());
        outdoorFragment.stopLocationTracking();
        return Unit.INSTANCE;
    }

    private final void observeAqiForUserLocation(List<TrackedLocation> list) {
        Iterable<TrackedLocation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TrackedLocation id : iterable) {
            arrayList.add(id.getId());
        }
        Set set = CollectionsKt.toSet((List) arrayList);
        Iterator it = getViewModel().getAqiDataMap().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            if (!set.contains(str) && !Intrinsics.areEqual((Object) str, (Object) "current")) {
                ((LiveData) entry.getValue()).removeObserver(getAqiDataObserver());
                it.remove();
            }
        }
        for (TrackedLocation observeAqiWithLocation : iterable) {
            observeAqiWithLocation(observeAqiWithLocation);
        }
    }

    private final void observeAqiWithLocation(TrackedLocation trackedLocation) {
        String id = trackedLocation.getId();
        LiveData<AqiData> liveData = getViewModel().getAqiDataMap().get(id);
        if (liveData == null) {
            liveData = getViewModel().liveAqiData(trackedLocation);
            getViewModel().getAqiDataMap().put(id, liveData);
        }
        if (!liveData.hasObservers()) {
            liveData.observe(getViewLifecycleOwner(), getAqiDataObserver());
        }
    }

    public void onResume() {
        super.onResume();
        getViewModel().refreshTrackedLocationList(getHasBeenPaused());
        handleCurLocation(true);
        TrackedLocation trackedLocation = this.curLocationItem.getTrackedLocation();
        if (trackedLocation != null) {
            getViewModel().refreshAqiData(trackedLocation);
        }
    }

    static /* synthetic */ void handleCurLocation$default(OutdoorFragment outdoorFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        outdoorFragment.handleCurLocation(z);
    }

    private final void handleCurLocation(boolean z) {
        Context context = getContext();
        if (context != null) {
            if (!this.curLocationItem.isLocationEnable(context)) {
                getViewModel().clearCurrentLocation();
            } else if (this.curLocationItem.getTrackedLocation() == null || z) {
                startLocationTracking(context);
            }
        }
        notifyCurLocationItemChange(OutdoorLocationItem.PAYLOAD_TRACKED_LOCATION);
    }

    private final void startLocationTracking(Context context) {
        getLocationListener().start(false);
        notifyCurLocationItemChange(OutdoorLocationItem.PAYLOAD_PROGRESS);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        Object systemService = context.getSystemService("location");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
        LocationManager locationManager = (LocationManager) systemService;
        if (Build.VERSION.SDK_INT >= 31) {
            String bestProvider = locationManager.getBestProvider(criteria, true);
            if (bestProvider != null) {
                locationManager.requestLocationUpdates(bestProvider, 1000, 10.0f, getLocationListener(), (Looper) null);
                return;
            }
            return;
        }
        locationManager.requestLocationUpdates(1000, 10.0f, criteria, getLocationListener(), (Looper) null);
    }

    private final void stopLocationTracking() {
        getLocationListener().stop();
        try {
            Object systemService = requireContext().getSystemService("location");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.location.LocationManager");
            ((LocationManager) systemService).removeUpdates(getLocationListener());
        } catch (Throwable th) {
            Timber.Forest.d(th, "stopLocationTracking fail", new Object[0]);
        }
    }

    private final void notifyCurLocationItemChange(String str) {
        notifyLocationItemChange(getCurrentLocationAdapter(), 0, str);
    }

    private static final void notifyLocationItemChange$notifyItemChangeReal(int i, ItemAdapter<OutdoorLocationItem> itemAdapter, String str) {
        FastAdapter<OutdoorLocationItem> fastAdapter;
        if (i >= 0 && i < itemAdapter.getAdapterItemCount() && (fastAdapter = itemAdapter.getFastAdapter()) != null) {
            fastAdapter.notifyItemChanged(itemAdapter.getGlobalPosition(i), str);
        }
    }

    private final void notifyLocationItemChange(ItemAdapter<OutdoorLocationItem> itemAdapter, int i, String str) {
        FragmentOutdoorBinding fragmentOutdoorBinding = this.viewDataBinding;
        FragmentOutdoorBinding fragmentOutdoorBinding2 = null;
        if (fragmentOutdoorBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            fragmentOutdoorBinding = null;
        }
        if (fragmentOutdoorBinding.rvLocation.isComputingLayout()) {
            FragmentOutdoorBinding fragmentOutdoorBinding3 = this.viewDataBinding;
            if (fragmentOutdoorBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            } else {
                fragmentOutdoorBinding2 = fragmentOutdoorBinding3;
            }
            fragmentOutdoorBinding2.rvLocation.post(new OutdoorFragment$$ExternalSyntheticLambda5(i, itemAdapter, str));
            return;
        }
        notifyLocationItemChange$notifyItemChangeReal(i, itemAdapter, str);
    }

    /* access modifiers changed from: private */
    public static final void notifyLocationItemChange$lambda$22(int i, ItemAdapter itemAdapter, String str) {
        notifyLocationItemChange$notifyItemChangeReal(i, itemAdapter, str);
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0016J$\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0017J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\n8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/blueair/android/fragment/OutdoorFragment$CurrentLocationListener;", "Landroid/location/LocationListener;", "<init>", "()V", "stopped", "", "_liveLocation", "Landroidx/lifecycle/MutableLiveData;", "Landroid/location/Location;", "liveLocation", "Landroidx/lifecycle/LiveData;", "getLiveLocation", "()Landroidx/lifecycle/LiveData;", "_showLoading", "stop", "", "start", "showLoading", "getShowLoading", "onLocationChanged", "loc", "onStatusChanged", "p0", "", "p1", "", "p2", "Landroid/os/Bundle;", "onProviderEnabled", "provider", "onProviderDisabled", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorFragment.kt */
    public static final class CurrentLocationListener implements LocationListener {
        public static final int $stable = 8;
        private final MutableLiveData<Location> _liveLocation = new MutableLiveData<>();
        private final MutableLiveData<Boolean> _showLoading = new MutableLiveData<>(false);
        private volatile boolean stopped;

        public void onProviderDisabled(String str) {
            Intrinsics.checkNotNullParameter(str, "p0");
        }

        @Deprecated(message = "Deprecated in Java")
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public final LiveData<Location> getLiveLocation() {
            return this._liveLocation;
        }

        public final void stop() {
            this.stopped = true;
            this._showLoading.postValue(false);
        }

        public final void start(boolean z) {
            this.stopped = false;
            if (z) {
                this._showLoading.postValue(true);
            }
        }

        public final LiveData<Boolean> getShowLoading() {
            return this._showLoading;
        }

        public void onLocationChanged(Location location) {
            Intrinsics.checkNotNullParameter(location, "loc");
            if (!this.stopped) {
                this._liveLocation.postValue(location);
            }
        }

        public void onProviderEnabled(String str) {
            Intrinsics.checkNotNullParameter(str, "provider");
            Timber.Forest forest = Timber.Forest;
            forest.d("onProviderEnabled: provider = " + str, new Object[0]);
        }
    }
}
