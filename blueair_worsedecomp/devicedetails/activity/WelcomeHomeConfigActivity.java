package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.util.PhoneUtil;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.ActivityWelcomeHomeConfigBinding;
import com.blueair.devicedetails.dialog.SimpleWelcomeHomePermissionsDialogFragment;
import com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel;
import com.blueair.outdoor.ui.activity.SearchActivity;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.ViewUtilsKt;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.mapbox.maps.plugin.locationcomponent.LocationComponentConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\b\u00101\u001a\u00020,H\u0002J\u0012\u00102\u001a\u00020,2\b\b\u0002\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020,H\u0002J\b\u00105\u001a\u00020,H\u0002J\b\u00106\u001a\u00020,H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u00108\u001a\u00020,2\b\b\u0002\u00103\u001a\u00020\u001eH\u0002J\b\u00109\u001a\u00020,H\u0002J\u0010\u0010:\u001a\u00020,2\u0006\u0010;\u001a\u00020<H\u0002R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0010\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0010\u001a\u0004\b&\u0010'R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/blueair/devicedetails/activity/WelcomeHomeConfigActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityWelcomeHomeConfigBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/CreateUpdateWelcomeHomeViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/CreateUpdateWelcomeHomeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "getMap", "()Lcom/google/android/gms/maps/GoogleMap;", "setMap", "(Lcom/google/android/gms/maps/GoogleMap;)V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "marker", "Lcom/google/android/gms/maps/model/Marker;", "circle", "Lcom/google/android/gms/maps/model/Circle;", "playServicesAvailable", "", "icon", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "getIcon", "()Lcom/google/android/gms/maps/model/BitmapDescriptor;", "icon$delegate", "radiusColor", "", "getRadiusColor", "()I", "radiusColor$delegate", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initView", "initRadiusButtons", "initMap", "requestLocation", "animate", "showArrivingHomeInfoDialog", "bindViewModel", "renderFailure", "onMapReady", "updateMarker", "updateRadius", "handleActivityResult", "result", "Landroidx/activity/result/ActivityResult;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomeConfigActivity.kt */
public final class WelcomeHomeConfigActivity extends BaseActivity implements OnMapReadyCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityWelcomeHomeConfigBinding binding;
    private Circle circle;
    private HasWelcomeHome device;
    private FusedLocationProviderClient fusedLocationClient;
    private final Lazy icon$delegate;
    private GoogleMap map;
    private Marker marker;
    private boolean playServicesAvailable;
    private final Lazy radiusColor$delegate;
    private final String screenName = AnalyticEvent.ScreenViewEvent.DEVICE_SETTINGS_WELCOME_HOME;
    private final Lazy viewModel$delegate;

    public WelcomeHomeConfigActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CreateUpdateWelcomeHomeViewModel.class), new WelcomeHomeConfigActivity$special$$inlined$viewModels$default$2(componentActivity), new WelcomeHomeConfigActivity$special$$inlined$viewModels$default$1(componentActivity), new WelcomeHomeConfigActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.icon$delegate = LazyKt.lazy(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda15(this));
        this.radiusColor$delegate = LazyKt.lazy(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda16(this));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final CreateUpdateWelcomeHomeViewModel getViewModel() {
        return (CreateUpdateWelcomeHomeViewModel) this.viewModel$delegate.getValue();
    }

    public final GoogleMap getMap() {
        return this.map;
    }

    public final void setMap(GoogleMap googleMap) {
        this.map = googleMap;
    }

    private final BitmapDescriptor getIcon() {
        return (BitmapDescriptor) this.icon$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final BitmapDescriptor icon_delegate$lambda$0(WelcomeHomeConfigActivity welcomeHomeConfigActivity) {
        if (welcomeHomeConfigActivity.playServicesAvailable) {
            return BitmapDescriptorFactory.fromResource(R.drawable.ic_home_marker);
        }
        return null;
    }

    private final int getRadiusColor() {
        return ((Number) this.radiusColor$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public static final int radiusColor_delegate$lambda$1(WelcomeHomeConfigActivity welcomeHomeConfigActivity) {
        return ContextCompat.getColor(welcomeHomeConfigActivity, com.blueair.viewcore.R.color.blue_opaque);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = null;
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_welcome_home_config);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding2 = (ActivityWelcomeHomeConfigBinding) contentView;
        this.binding = activityWelcomeHomeConfigBinding2;
        if (activityWelcomeHomeConfigBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWelcomeHomeConfigBinding = activityWelcomeHomeConfigBinding2;
        }
        setContentView(activityWelcomeHomeConfigBinding.getRoot());
        this.playServicesAvailable = PhoneUtil.INSTANCE.isGoogleServicesAvailable(this);
        Parcelable parcelableExtra = getIntent().getParcelableExtra("device");
        if (parcelableExtra != null) {
            this.device = (HasWelcomeHome) parcelableExtra;
            bindViewModel();
            initView();
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void initView() {
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = this.binding;
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding2 = null;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        activityWelcomeHomeConfigBinding.gpsBtn.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda21(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding3 = this.binding;
        if (activityWelcomeHomeConfigBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding3 = null;
        }
        AppCompatImageView appCompatImageView = activityWelcomeHomeConfigBinding3.imInfo;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "imInfo");
        ViewUtilsKt.setOnClickListener(appCompatImageView, LocationComponentConstants.MAX_ANIMATION_DURATION_MS, new WelcomeHomeConfigActivity$$ExternalSyntheticLambda22(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding4 = this.binding;
        if (activityWelcomeHomeConfigBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding4 = null;
        }
        activityWelcomeHomeConfigBinding4.imInfo.setContentDescription(getString(com.blueair.viewcore.R.string.more_info_about, new Object[]{getString(com.blueair.viewcore.R.string.how_do_you_arrive_title)}));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding5 = this.binding;
        if (activityWelcomeHomeConfigBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding5 = null;
        }
        activityWelcomeHomeConfigBinding5.btnBack.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda23(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding6 = this.binding;
        if (activityWelcomeHomeConfigBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding6 = null;
        }
        activityWelcomeHomeConfigBinding6.btnClose.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda24(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding7 = this.binding;
        if (activityWelcomeHomeConfigBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding7 = null;
        }
        activityWelcomeHomeConfigBinding7.btnDeleteHome.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda25(this));
        initRadiusButtons();
        initMap();
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WelcomeHomeConfigActivity$$ExternalSyntheticLambda26(this));
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding8 = this.binding;
        if (activityWelcomeHomeConfigBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWelcomeHomeConfigBinding2 = activityWelcomeHomeConfigBinding8;
        }
        activityWelcomeHomeConfigBinding2.tvAddress.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda1(this, registerForActivityResult));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.requestLocation(true);
    }

    /* access modifiers changed from: private */
    public static final Unit initView$lambda$3(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        Intrinsics.checkNotNullParameter(view, "it");
        welcomeHomeConfigActivity.showArrivingHomeInfoDialog();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(com.blueair.viewcore.R.string.delete_home_title), Integer.valueOf(com.blueair.viewcore.R.string.delete_home_content), com.blueair.viewcore.R.string.delete_home_positive, Integer.valueOf(com.blueair.viewcore.R.string.btn_cancel), true, false, false, (String[]) null, 224, (Object) null).show(welcomeHomeConfigActivity.getSupportFragmentManager(), "Delete home dialog");
        welcomeHomeConfigActivity.getSupportFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, welcomeHomeConfigActivity, new WelcomeHomeConfigActivity$$ExternalSyntheticLambda11(welcomeHomeConfigActivity));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6(WelcomeHomeConfigActivity welcomeHomeConfigActivity, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY)) {
            ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = welcomeHomeConfigActivity.binding;
            if (activityWelcomeHomeConfigBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityWelcomeHomeConfigBinding = null;
            }
            ProgressBlockerView progressBlockerView = activityWelcomeHomeConfigBinding.progressView;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
            ViewExtensionsKt.show$default(progressBlockerView, false, 1, (Object) null);
            welcomeHomeConfigActivity.getViewModel().deleteWelcomeHome();
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$8(WelcomeHomeConfigActivity welcomeHomeConfigActivity, ActivityResult activityResult) {
        Intrinsics.checkNotNull(activityResult);
        welcomeHomeConfigActivity.handleActivityResult(activityResult);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$9(WelcomeHomeConfigActivity welcomeHomeConfigActivity, ActivityResultLauncher activityResultLauncher, View view) {
        Intent intent = new Intent(welcomeHomeConfigActivity, SearchActivity.class);
        intent.putExtra("request_code", SearchActivity.SearchType.MAPBOX);
        activityResultLauncher.launch(intent);
    }

    private final void initRadiusButtons() {
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = this.binding;
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding2 = null;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        activityWelcomeHomeConfigBinding.tvCar.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda10(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding3 = this.binding;
        if (activityWelcomeHomeConfigBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding3 = null;
        }
        activityWelcomeHomeConfigBinding3.tvBicycle.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda12(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding4 = this.binding;
        if (activityWelcomeHomeConfigBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding4 = null;
        }
        activityWelcomeHomeConfigBinding4.tvWalk.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda13(this));
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding5 = this.binding;
        if (activityWelcomeHomeConfigBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWelcomeHomeConfigBinding2 = activityWelcomeHomeConfigBinding5;
        }
        activityWelcomeHomeConfigBinding2.tvCommute.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda14(this));
    }

    /* access modifiers changed from: private */
    public static final void initRadiusButtons$lambda$10(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.CAR);
        welcomeHomeConfigActivity.updateRadius();
    }

    /* access modifiers changed from: private */
    public static final void initRadiusButtons$lambda$11(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.BICYCLE);
        welcomeHomeConfigActivity.updateRadius();
    }

    /* access modifiers changed from: private */
    public static final void initRadiusButtons$lambda$12(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.WALK);
        welcomeHomeConfigActivity.updateRadius();
    }

    /* access modifiers changed from: private */
    public static final void initRadiusButtons$lambda$13(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        welcomeHomeConfigActivity.getViewModel().setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.COMMUTE);
        welcomeHomeConfigActivity.updateRadius();
    }

    private final void initMap() {
        SupportMapFragment newInstance = SupportMapFragment.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
        getSupportFragmentManager().beginTransaction().replace(com.blueair.outdoor.R.id.map_container, newInstance).commit();
        newInstance.getMapAsync(this);
    }

    static /* synthetic */ void requestLocation$default(WelcomeHomeConfigActivity welcomeHomeConfigActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        welcomeHomeConfigActivity.requestLocation(z);
    }

    private final void requestLocation(boolean z) {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
            fusedLocationProviderClient = null;
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda20(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda19(this, z)));
    }

    /* access modifiers changed from: private */
    public static final void requestLocation$lambda$16(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit requestLocation$lambda$15(WelcomeHomeConfigActivity welcomeHomeConfigActivity, boolean z, Location location) {
        if (welcomeHomeConfigActivity.playServicesAvailable && location != null) {
            CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 16.0f);
            Intrinsics.checkNotNullExpressionValue(newLatLngZoom, "newLatLngZoom(...)");
            GoogleMap googleMap = welcomeHomeConfigActivity.map;
            if (z) {
                if (googleMap != null) {
                    googleMap.animateCamera(newLatLngZoom);
                }
            } else if (googleMap != null) {
                googleMap.moveCamera(newLatLngZoom);
            }
        }
        return Unit.INSTANCE;
    }

    private final void showArrivingHomeInfoDialog() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<ConfirmationDialogLeftAligned> cls = ConfirmationDialogLeftAligned.class;
        Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !supportFragmentManager.isStateSaved()) {
            ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, com.blueair.viewcore.R.string.label_arriving_home, (Integer) null, com.blueair.viewcore.R.string.arriving_home_info, (Integer) null, (Integer) null, false, false, false, false, (String[]) null, (String) null, (Function1) null, 3936, (Object) null).show(supportFragmentManager, "ConfirmationDialogLeftAligned");
        }
    }

    private final void bindViewModel() {
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = this.binding;
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding2 = null;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        activityWelcomeHomeConfigBinding.setVm(getViewModel());
        LifecycleOwner lifecycleOwner = this;
        activityWelcomeHomeConfigBinding.setLifecycleOwner(lifecycleOwner);
        CreateUpdateWelcomeHomeViewModel viewModel = getViewModel();
        HasWelcomeHome hasWelcomeHome = this.device;
        if (hasWelcomeHome == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            hasWelcomeHome = null;
        }
        viewModel.setDevice(hasWelcomeHome);
        getViewModel().getSaveEnabled().observe(lifecycleOwner, new WelcomeHomeConfigActivity$sam$androidx_lifecycle_Observer$0(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda5(this)));
        getViewModel().getLoading().observe(lifecycleOwner, new WelcomeHomeConfigActivity$sam$androidx_lifecycle_Observer$0(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda6(this)));
        getViewModel().getFailure().observe(lifecycleOwner, new WelcomeHomeConfigActivity$sam$androidx_lifecycle_Observer$0(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda7(this)));
        getViewModel().getSuccess().observe(lifecycleOwner, new WelcomeHomeConfigActivity$sam$androidx_lifecycle_Observer$0(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda8(this)));
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient((Activity) this);
        Intrinsics.checkNotNullExpressionValue(fusedLocationProviderClient, "getFusedLocationProviderClient(...)");
        this.fusedLocationClient = fusedLocationProviderClient;
        getViewModel().setUseShortAddress(true);
        getViewModel().loadHomeLocation();
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding3 = this.binding;
        if (activityWelcomeHomeConfigBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityWelcomeHomeConfigBinding2 = activityWelcomeHomeConfigBinding3;
        }
        activityWelcomeHomeConfigBinding2.btnSave.setOnClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$19(WelcomeHomeConfigActivity welcomeHomeConfigActivity, Boolean bool) {
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = welcomeHomeConfigActivity.binding;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        MaterialButton materialButton = activityWelcomeHomeConfigBinding.btnSave;
        Intrinsics.checkNotNull(bool);
        materialButton.setEnabled(bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$20(WelcomeHomeConfigActivity welcomeHomeConfigActivity, Boolean bool) {
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = welcomeHomeConfigActivity.binding;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        ProgressBlockerView progressBlockerView = activityWelcomeHomeConfigBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(progressBlockerView, "progressView");
        Intrinsics.checkNotNull(bool);
        ViewExtensionsKt.show(progressBlockerView, bool.booleanValue());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$21(WelcomeHomeConfigActivity welcomeHomeConfigActivity, Unit unit) {
        welcomeHomeConfigActivity.renderFailure();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$22(WelcomeHomeConfigActivity welcomeHomeConfigActivity, Unit unit) {
        welcomeHomeConfigActivity.finish();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void bindViewModel$lambda$25(WelcomeHomeConfigActivity welcomeHomeConfigActivity, View view) {
        if (Intrinsics.areEqual((Object) welcomeHomeConfigActivity.getViewModel().getWelcomeHomeExist().getValue(), (Object) true)) {
            welcomeHomeConfigActivity.getViewModel().saveHomeLocation();
            return;
        }
        FragmentManager supportFragmentManager = welcomeHomeConfigActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Class<SimpleWelcomeHomePermissionsDialogFragment> cls = SimpleWelcomeHomePermissionsDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("SimpleWelcomeHomePermissionsDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager.findFragmentByTag("SimpleWelcomeHomePermissionsDialogFragment") instanceof SimpleWelcomeHomePermissionsDialogFragment) && !supportFragmentManager.isStateSaved()) {
            SimpleWelcomeHomePermissionsDialogFragment.Companion.newInstance(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda17(welcomeHomeConfigActivity)).show(supportFragmentManager, "SimpleWelcomeHomePermissionsDialogFragment");
        }
    }

    /* access modifiers changed from: private */
    public static final Unit bindViewModel$lambda$25$lambda$24$lambda$23(WelcomeHomeConfigActivity welcomeHomeConfigActivity, boolean z) {
        if (z) {
            welcomeHomeConfigActivity.getViewModel().saveHomeLocation();
        }
        return Unit.INSTANCE;
    }

    private final void renderFailure() {
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = this.binding;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        ConstraintLayout constraintLayout = activityWelcomeHomeConfigBinding.rootLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "rootLayout");
        viewUtils.showSnackbar((View) constraintLayout, com.blueair.viewcore.R.string.something_went_wrong, (ViewUtils.MessageType) ViewUtils.MessageType.ERROR.INSTANCE);
    }

    public void onMapReady(GoogleMap googleMap) {
        Intrinsics.checkNotNullParameter(googleMap, "map");
        this.map = googleMap;
        googleMap.setMyLocationEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.getUiSettings().setZoomControlsEnabled(false);
        googleMap.getUiSettings().setRotateGesturesEnabled(false);
        googleMap.getUiSettings().setTiltGesturesEnabled(false);
        googleMap.getUiSettings().setIndoorLevelPickerEnabled(false);
        googleMap.getUiSettings().setMyLocationButtonEnabled(false);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = this.binding;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        MaterialCardView materialCardView = activityWelcomeHomeConfigBinding.cvHome;
        materialCardView.post(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda2(googleMap, this, materialCardView));
        googleMap.setMaxZoomPreference(16.0f);
        googleMap.setOnMapClickListener(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda3(this));
        if (getViewModel().getAddress().getValue() == null) {
            requestLocation$default(this, false, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void onMapReady$lambda$27$lambda$26(GoogleMap googleMap, WelcomeHomeConfigActivity welcomeHomeConfigActivity, MaterialCardView materialCardView) {
        ActivityWelcomeHomeConfigBinding activityWelcomeHomeConfigBinding = welcomeHomeConfigActivity.binding;
        if (activityWelcomeHomeConfigBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityWelcomeHomeConfigBinding = null;
        }
        int bottom = activityWelcomeHomeConfigBinding.tvAddress.getBottom();
        int height = materialCardView.getHeight();
        Intrinsics.checkNotNull(materialCardView);
        ViewGroup.LayoutParams layoutParams = materialCardView.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        googleMap.setPadding(0, bottom, 0, height + (marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0));
        if (welcomeHomeConfigActivity.getViewModel().getAddress().getValue() != null) {
            updateMarker$default(welcomeHomeConfigActivity, false, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void onMapReady$lambda$30(WelcomeHomeConfigActivity welcomeHomeConfigActivity, LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "it");
        welcomeHomeConfigActivity.getViewModel().setAddressFromLatLng(latLng.latitude, latLng.longitude, new WelcomeHomeConfigActivity$$ExternalSyntheticLambda4(welcomeHomeConfigActivity));
    }

    /* access modifiers changed from: private */
    public static final Unit onMapReady$lambda$30$lambda$29(WelcomeHomeConfigActivity welcomeHomeConfigActivity) {
        welcomeHomeConfigActivity.runOnUiThread(new WelcomeHomeConfigActivity$$ExternalSyntheticLambda18(welcomeHomeConfigActivity));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onMapReady$lambda$30$lambda$29$lambda$28(WelcomeHomeConfigActivity welcomeHomeConfigActivity) {
        welcomeHomeConfigActivity.updateMarker(true);
    }

    static /* synthetic */ void updateMarker$default(WelcomeHomeConfigActivity welcomeHomeConfigActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        welcomeHomeConfigActivity.updateMarker(z);
    }

    private final void updateMarker(boolean z) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.remove();
        }
        Double lat = getViewModel().getLat();
        if (lat != null) {
            lat.doubleValue();
            MarkerOptions markerOptions = new MarkerOptions();
            Double lat2 = getViewModel().getLat();
            Intrinsics.checkNotNull(lat2);
            double doubleValue = lat2.doubleValue();
            Double lng = getViewModel().getLng();
            Intrinsics.checkNotNull(lng);
            MarkerOptions icon = markerOptions.position(new LatLng(doubleValue, lng.doubleValue())).icon(getIcon());
            Intrinsics.checkNotNullExpressionValue(icon, "icon(...)");
            GoogleMap googleMap = this.map;
            this.marker = googleMap != null ? googleMap.addMarker(icon) : null;
            updateRadius();
            if (this.playServicesAvailable) {
                Double lat3 = getViewModel().getLat();
                Intrinsics.checkNotNull(lat3);
                double doubleValue2 = lat3.doubleValue();
                Double lng2 = getViewModel().getLng();
                Intrinsics.checkNotNull(lng2);
                CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(new LatLng(doubleValue2, lng2.doubleValue()), 16.0f);
                Intrinsics.checkNotNullExpressionValue(newLatLngZoom, "newLatLngZoom(...)");
                if (z) {
                    GoogleMap googleMap2 = this.map;
                    if (googleMap2 != null) {
                        googleMap2.animateCamera(newLatLngZoom);
                        return;
                    }
                    return;
                }
                GoogleMap googleMap3 = this.map;
                if (googleMap3 != null) {
                    googleMap3.moveCamera(newLatLngZoom);
                }
            }
        }
    }

    private final void updateRadius() {
        WelcomeHomeLocation.WelcomeHomeRadius selectedRadius;
        if (getViewModel().getAddress().getValue() != null && (selectedRadius = getViewModel().getSelectedRadius()) != null) {
            Circle circle2 = this.circle;
            if (circle2 != null) {
                circle2.remove();
            }
            CircleOptions circleOptions = new CircleOptions();
            Double lat = getViewModel().getLat();
            Intrinsics.checkNotNull(lat);
            double doubleValue = lat.doubleValue();
            Double lng = getViewModel().getLng();
            Intrinsics.checkNotNull(lng);
            CircleOptions strokeWidth = circleOptions.center(new LatLng(doubleValue, lng.doubleValue())).radius((double) selectedRadius.getValue()).fillColor(getRadiusColor()).strokeWidth(0.0f);
            Intrinsics.checkNotNullExpressionValue(strokeWidth, "strokeWidth(...)");
            GoogleMap googleMap = this.map;
            this.circle = googleMap != null ? googleMap.addCircle(strokeWidth) : null;
        }
    }

    private final void handleActivityResult(ActivityResult activityResult) {
        Intent data;
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                CustomPlace customPlace = (CustomPlace) data.getParcelableExtra(SearchActivity.SEARCH_REQUEST_KEY, CustomPlace.class);
                if (customPlace != null) {
                    getViewModel().setCustomPlace(customPlace);
                    updateMarker$default(this, false, 1, (Object) null);
                    return;
                }
                TrackedLocation trackedLocation = (TrackedLocation) data.getParcelableExtra(SearchActivity.SAVED_LOCATION_KEY, TrackedLocation.class);
                if (trackedLocation != null) {
                    getViewModel().setTrackedLocation(trackedLocation);
                    updateMarker$default(this, false, 1, (Object) null);
                    return;
                }
                return;
            }
            CustomPlace customPlace2 = (CustomPlace) data.getParcelableExtra(SearchActivity.SEARCH_REQUEST_KEY);
            if (customPlace2 != null) {
                getViewModel().setCustomPlace(customPlace2);
                updateMarker$default(this, false, 1, (Object) null);
                return;
            }
            TrackedLocation trackedLocation2 = (TrackedLocation) data.getParcelableExtra(SearchActivity.SAVED_LOCATION_KEY);
            if (trackedLocation2 != null) {
                getViewModel().setTrackedLocation(trackedLocation2);
                updateMarker$default(this, false, 1, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/activity/WelcomeHomeConfigActivity$Companion;", "", "<init>", "()V", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/HasWelcomeHome;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomeConfigActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Intent getLaunchIntent(Context context, HasWelcomeHome hasWelcomeHome) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(hasWelcomeHome, "device");
            Intent intent = new Intent(context, WelcomeHomeConfigActivity.class);
            intent.putExtra("device", hasWelcomeHome);
            return intent;
        }
    }
}
