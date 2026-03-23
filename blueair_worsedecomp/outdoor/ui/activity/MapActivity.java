package com.blueair.outdoor.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.R;
import com.blueair.outdoor.ui.adapters.LocationAdapter;
import com.blueair.outdoor.ui.adapters.LocationItem;
import com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager;
import com.blueair.outdoor.ui.adapters.LocationPageIndicatorItemDecorator;
import com.blueair.outdoor.ui.adapters.LocationView;
import com.blueair.outdoor.ui.dialog.AssignProductDialogFragment;
import com.blueair.outdoor.ui.dialog.AssignProductNoDeviceDialogFragment;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.outdoor.ui.viewmodels.MapsViewModel;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.dialog.ConfirmationDialogCenteredKt;
import com.blueair.viewcore.extensions.RecyclerExtensionsKt;
import com.blueair.viewcore.utils.SnapOnScrollListener;
import com.blueair.viewcore.utils.ToastUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\b\u0010J\u001a\u00020GH\u0014J\b\u0010K\u001a\u00020GH\u0002J\b\u0010L\u001a\u00020GH\u0004J\b\u0010M\u001a\u00020GH\u0002J\b\u0010N\u001a\u00020GH\u0002J\b\u0010O\u001a\u00020GH\u0002J\b\u0010P\u001a\u00020GH\u0002J\b\u0010Q\u001a\u00020GH\u0002J\b\u0010R\u001a\u00020GH\u0002J\b\u0010S\u001a\u00020GH\u0002J\u0010\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020VH\u0017J\b\u0010W\u001a\u00020GH\u0002J\b\u0010X\u001a\u00020GH\u0002J\b\u0010Y\u001a\u00020GH\u0002J\b\u0010Z\u001a\u00020GH$J\b\u0010[\u001a\u00020GH\u0004J\"\u0010\\\u001a\u00020G2\u0006\u0010]\u001a\u0002012\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\"\u0010`\u001a\u00020G2\u0006\u0010]\u001a\u0002012\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\"\u0010a\u001a\u00020G2\u0006\u0010]\u001a\u0002012\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\"\u0010b\u001a\u00020G2\u0006\u0010c\u001a\u00020d2\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\u0010\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020,H\u0002J\u000e\u0010g\u001a\u00020G2\u0006\u0010]\u001a\u00020\u0005J\u0010\u0010h\u001a\u00020G2\u0006\u0010i\u001a\u00020\u0005H\u0002J\u001a\u0010h\u001a\u00020G2\u0006\u0010j\u001a\u0002012\b\b\u0002\u0010k\u001a\u00020\u001bH\u0002J\b\u0010l\u001a\u00020GH\u0002J\b\u0010m\u001a\u00020GH$J\u0016\u0010n\u001a\u00020G2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020,0AH$J \u0010p\u001a\u00020G2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u001b2\u0006\u0010s\u001a\u00020\u001bH$J\u0018\u0010t\u001a\u00020G2\u0006\u0010f\u001a\u00020,2\u0006\u0010u\u001a\u00020?H$J\b\u0010v\u001a\u00020GH\u0002J\u0016\u0010w\u001a\u00020G2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020,0AH\u0002J\u0018\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020,2\u0006\u0010u\u001a\u00020?H\u0002J\"\u0010x\u001a\u00020G2\u0006\u0010y\u001a\u0002012\u0006\u0010z\u001a\u0002012\b\u0010{\u001a\u0004\u0018\u00010|H\u0015J\u0019\u0010}\u001a\u00020G2\u0006\u0010~\u001a\u000202\u0007\u0010\u0001\u001a\u00020H\u0004J\t\u0010\u0001\u001a\u00020GH\u0014J\t\u0010\u0001\u001a\u00020GH\u0002J\t\u0010\u0001\u001a\u00020GH\u0002J'\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u0002012\u0007\u0010\u0001\u001a\u0002012\u0007\u0010\u0001\u001a\u000201H\u0004R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8DX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001b8DX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001fR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020,07X\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0002¢\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b;\u0010\u0007R\u001c\u0010=\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020?\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\u0004\u0018\u00010\u00058BX\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0007R\u0014\u0010E\u001a\u00020\u001b8BX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u001f¨\u0006\u0001"}, d2 = {"Lcom/blueair/outdoor/ui/activity/MapActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "searchBar", "Landroid/widget/TextView;", "viewModel", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "locationAdapter", "Lcom/blueair/outdoor/ui/adapters/LocationAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "maximizeButton", "Landroid/widget/Button;", "locationLinearLayoutManager", "Lcom/blueair/outdoor/ui/adapters/LocationLinearLayoutManager;", "currentLocationView", "Lcom/blueair/outdoor/ui/adapters/LocationView;", "startedForSearchMode", "", "hasInitiallyNavigateToStation", "shouldNavigateToStationByIntent", "getShouldNavigateToStationByIntent", "()Z", "navigateToStationByIntent", "navigateToCurrentLocation", "deviceId", "inAssignProductMode", "value", "shouldShowAssignProduct", "setShouldShowAssignProduct", "(Z)V", "navigateToStationIdBySearchResult", "shouldNavigateToStationIdBySearchResult", "getShouldNavigateToStationIdBySearchResult", "scrollToStationByAdd", "Lcom/blueair/core/model/TrackedLocation;", "scrollToStationByDelete", "navigateToPrediction", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "mapViewId", "", "getMapViewId", "()I", "setMapViewId", "(I)V", "currentLocationDebounceFetchedPublisher", "Lio/reactivex/subjects/PublishSubject;", "mapType", "getMapType", "localMapType", "getLocalMapType", "localMapType$delegate", "pendingGotoLocation", "Lkotlin/Pair;", "", "pendingMarkers", "", "selectedLocationId", "selectedMarkerId", "getSelectedMarkerId", "isCurrentLocationSelected", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "configureUsingIntentParameters", "setupLocationServices", "configureMode", "configureSearchBar", "configureAddLocationButton", "configureAddLocationCard", "configureAddLocationListeners", "configureAddLocationRxListeners", "configureGPSButton", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "configureSavedLocations", "disableSavedLocationScrolling", "enableSavedLocationScrolling", "startSearchIntent", "setMinimizedModeIfNeeded", "showCard", "id", "completion", "Lkotlin/Function0;", "showMinimizedCard", "hideCard", "animate", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "gotoLocation", "location", "onMarkerTapped", "moveToLocation", "locationId", "position", "shouldScroll", "changeSearchBarStyle", "clearMapMarkersImpl", "addMapMarkersImpl", "locations", "styleMarker", "markerId", "isSelected", "isCurrentLocation", "gotoLocationImpl", "zoom", "clearMapMarkers", "addMapMarkers", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "updateAirQualityIfNeeded", "lat", "", "lng", "onResume", "navigateToStationFromSearchActivityIfNeeded", "navigateToPredictionFromSearchActivityIfNeeded", "getMarkerIcon", "Landroid/graphics/Bitmap;", "drawableId", "width", "height", "Companion", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MapActivity.kt */
public abstract class MapActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIALOG_TAG = "Dialog";
    private static final String KEY_LOCATION = "location";
    public static final long MAP_MOVE_UPDATE_STATION_DELAY = 1200;
    public static final int MARKER_SIZE_GPS = 45;
    public static final int MARKER_SIZE_LOCATION = 80;
    public static final String NO_ELEMENT = "";
    public static final float ZOOM_LEVEL_FOCUS = 7.0f;
    public static final float ZOOM_LEVEL_MAX = 16.0f;
    public static final float ZOOM_LEVEL_STREET = 13.0f;
    private final PublishSubject<TrackedLocation> currentLocationDebounceFetchedPublisher;
    private LocationView currentLocationView;
    /* access modifiers changed from: private */
    public String deviceId;
    private boolean hasInitiallyNavigateToStation;
    private boolean inAssignProductMode;
    private final Lazy localMapType$delegate;
    private LocationAdapter locationAdapter;
    private LocationLinearLayoutManager locationLinearLayoutManager;
    private int mapViewId;
    private Button maximizeButton;
    private boolean navigateToCurrentLocation;
    private CustomPlace navigateToPrediction;
    private String navigateToStationByIntent;
    private String navigateToStationIdBySearchResult;
    private Pair<TrackedLocation, Float> pendingGotoLocation;
    private List<TrackedLocation> pendingMarkers;
    private RecyclerView recyclerView;
    private final String screenName = AnalyticEvent.ScreenViewEvent.OUTDOOR_MAP;
    /* access modifiers changed from: private */
    public TrackedLocation scrollToStationByAdd;
    private TrackedLocation scrollToStationByDelete;
    private TextView searchBar;
    private String selectedLocationId;
    private boolean shouldShowAssignProduct;
    private boolean startedForSearchMode;
    private final Lazy viewModel$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MapActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.outdoor.ui.viewmodels.MapsViewModel$MapMode[] r0 = com.blueair.outdoor.ui.viewmodels.MapsViewModel.MapMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.outdoor.ui.viewmodels.MapsViewModel$MapMode r1 = com.blueair.outdoor.ui.viewmodels.MapsViewModel.MapMode.MINIMIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.outdoor.ui.viewmodels.MapsViewModel$MapMode r1 = com.blueair.outdoor.ui.viewmodels.MapsViewModel.MapMode.SAVED_LOCATIONS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.outdoor.ui.viewmodels.MapsViewModel$MapMode r1 = com.blueair.outdoor.ui.viewmodels.MapsViewModel.MapMode.ADD_LOCATION     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.activity.MapActivity.WhenMappings.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void addMapMarkersImpl(List<TrackedLocation> list);

    /* access modifiers changed from: protected */
    public abstract void clearMapMarkersImpl();

    public abstract String getMapType();

    /* access modifiers changed from: protected */
    public abstract void gotoLocationImpl(TrackedLocation trackedLocation, float f);

    /* access modifiers changed from: protected */
    public abstract void startSearchIntent();

    /* access modifiers changed from: protected */
    public abstract void styleMarker(String str, boolean z, boolean z2);

    public MapActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(MapsViewModel.class), new MapActivity$special$$inlined$viewModels$default$2(componentActivity), new MapActivity$special$$inlined$viewModels$default$1(componentActivity), new MapActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.deviceId = "";
        this.navigateToStationIdBySearchResult = "";
        this.mapViewId = -1;
        PublishSubject<TrackedLocation> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        this.currentLocationDebounceFetchedPublisher = create;
        this.localMapType$delegate = LazyKt.lazy(new MapActivity$$ExternalSyntheticLambda18(this));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/outdoor/ui/activity/MapActivity$Companion;", "", "<init>", "()V", "NO_ELEMENT", "", "MARKER_SIZE_LOCATION", "", "MARKER_SIZE_GPS", "MAP_MOVE_UPDATE_STATION_DELAY", "", "ZOOM_LEVEL_STREET", "", "ZOOM_LEVEL_FOCUS", "ZOOM_LEVEL_MAX", "DIALOG_TAG", "KEY_LOCATION", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: MapActivity.kt */
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

    /* access modifiers changed from: protected */
    public final MapsViewModel getViewModel() {
        return (MapsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final boolean getShouldNavigateToStationByIntent() {
        CharSequence charSequence = this.navigateToStationByIntent;
        return !(charSequence == null || StringsKt.isBlank(charSequence));
    }

    /* access modifiers changed from: private */
    public final void setShouldShowAssignProduct(boolean z) {
        if (this.shouldShowAssignProduct != z) {
            this.shouldShowAssignProduct = z;
            LocationAdapter locationAdapter2 = this.locationAdapter;
            if (locationAdapter2 != null) {
                if (locationAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                    locationAdapter2 = null;
                }
                locationAdapter2.setShowAssignProduct(z);
            }
        }
    }

    private final boolean getShouldNavigateToStationIdBySearchResult() {
        return !Intrinsics.areEqual((Object) this.navigateToStationIdBySearchResult, (Object) "");
    }

    public final int getMapViewId() {
        return this.mapViewId;
    }

    public final void setMapViewId(int i) {
        this.mapViewId = i;
    }

    /* access modifiers changed from: private */
    public static final String localMapType_delegate$lambda$0(MapActivity mapActivity) {
        return Intrinsics.areEqual((Object) mapActivity.getMapType(), (Object) TrackedLocation.MAP_TYPE_WGS) ? TrackedLocation.MAP_TYPE_WGS_LOCAL : TrackedLocation.MAP_TYPE_GCJ_LOCAL;
    }

    public final String getLocalMapType() {
        return (String) this.localMapType$delegate.getValue();
    }

    private final String getSelectedMarkerId() {
        Object obj;
        String str = this.selectedLocationId;
        if (str != null) {
            Iterator it = getViewModel().getMarkers().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), (Object) str)) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) obj;
            if (entry != null) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    private final boolean isCurrentLocationSelected() {
        return Intrinsics.areEqual((Object) this.selectedLocationId, (Object) "current");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        super.onCreate(bundle);
        setContentView(R.layout.activity_maps);
        boolean z = false;
        this.startedForSearchMode = getIntent().getBooleanExtra(Actions.SEARCH_MODE, false);
        this.navigateToStationByIntent = getIntent().getStringExtra("location_id");
        this.navigateToCurrentLocation = getIntent().getBooleanExtra(Actions.CURRENT_LOCATION, false);
        String stringExtra = getIntent().getStringExtra("device_id");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.deviceId = stringExtra;
        boolean z2 = stringExtra.length() > 0;
        this.inAssignProductMode = z2;
        if (z2 && ((charSequence = this.navigateToStationByIntent) == null || charSequence.length() == 0)) {
            z = true;
        }
        setShouldShowAssignProduct(z);
        configureSearchBar();
        configureSavedLocations();
        configureAddLocationButton();
        configureAddLocationCard();
        configureAddLocationListeners();
        configureGPSButton();
        configureMode();
        configureUsingIntentParameters();
    }

    /* access modifiers changed from: protected */
    public void onMapReady() {
        getViewModel().setMapIsReady(true);
        List<TrackedLocation> list = this.pendingMarkers;
        if (list != null) {
            Timber.Forest forest = Timber.Forest;
            forest.d("pendingMarkers: " + list, new Object[0]);
            addMapMarkersImpl(list);
            this.pendingMarkers = null;
        }
        Pair<TrackedLocation, Float> pair = this.pendingGotoLocation;
        if (pair != null) {
            Timber.Forest forest2 = Timber.Forest;
            forest2.d("pendingGotoLocation: " + pair, new Object[0]);
            gotoLocation(pair.getFirst(), pair.getSecond().floatValue());
            this.pendingGotoLocation = null;
        }
    }

    private final void configureUsingIntentParameters() {
        if (this.startedForSearchMode) {
            startSearchIntent();
        }
    }

    /* access modifiers changed from: protected */
    public final void setupLocationServices() {
        getViewModel().getViewLocation().observe(this, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda20(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit setupLocationServices$lambda$6(MapActivity mapActivity, TrackedLocation trackedLocation) {
        if (trackedLocation != null) {
            mapActivity.gotoLocation(trackedLocation);
        }
        return Unit.INSTANCE;
    }

    private final void configureMode() {
        getViewModel().getMode().observe(this, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda3(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit configureMode$lambda$13(MapActivity mapActivity, MapsViewModel.MapMode mapMode) {
        int i;
        if (mapMode == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[mapMode.ordinal()];
        }
        Button button = null;
        if (i == 1) {
            mapActivity.disableSavedLocationScrolling();
            Button button2 = mapActivity.maximizeButton;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maximizeButton");
                button2 = null;
            }
            ViewExtensionsKt.show$default(button2, false, 1, (Object) null);
            showMinimizedCard$default(mapActivity, R.id.saved_location_recycler_view, (Function0) null, 2, (Object) null);
        } else if (i == 2) {
            Button button3 = mapActivity.maximizeButton;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maximizeButton");
            } else {
                button = button3;
            }
            ViewExtensionsKt.hide(button);
            mapActivity.enableSavedLocationScrolling();
            ImageButton imageButton = (ImageButton) mapActivity.findViewById(R.id.add_location_btn);
            imageButton.setImageResource(com.blueair.viewcore.R.drawable.ic_location_marker_plus);
            imageButton.setContentDescription(mapActivity.getString(com.blueair.viewcore.R.string.add_pin_content_description));
            View findViewById = mapActivity.findViewById(R.id.pin);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ViewExtensionsKt.hide(findViewById);
            mapActivity.hideCard(R.id.current_location, new MapActivity$$ExternalSyntheticLambda0(mapActivity));
        } else if (i == 3) {
            TrackedLocation currentlyViewedLocation = mapActivity.getViewModel().getCurrentlyViewedLocation();
            if (currentlyViewedLocation != null) {
                mapActivity.updateAirQualityIfNeeded(currentlyViewedLocation.getLat(), currentlyViewedLocation.getLon());
            }
            ImageButton imageButton2 = (ImageButton) mapActivity.findViewById(R.id.add_location_btn);
            imageButton2.setImageResource(com.blueair.viewcore.R.drawable.ic_close);
            imageButton2.setContentDescription(mapActivity.getString(com.blueair.viewcore.R.string.remove_pin_content_description));
            View findViewById2 = mapActivity.findViewById(R.id.pin);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            ViewExtensionsKt.show$default(findViewById2, false, 1, (Object) null);
            String selectedMarkerId = mapActivity.getSelectedMarkerId();
            if (selectedMarkerId != null) {
                mapActivity.styleMarker(selectedMarkerId, false, mapActivity.isCurrentLocationSelected());
                mapActivity.selectedLocationId = null;
            }
            mapActivity.hideCard(R.id.saved_location_recycler_view, new MapActivity$$ExternalSyntheticLambda11(mapActivity));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r0.getShowCurrentLocation() != false) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.Unit configureMode$lambda$13$lambda$8(com.blueair.outdoor.ui.activity.MapActivity r3) {
        /*
            com.blueair.outdoor.ui.adapters.LocationAdapter r0 = r3.locationAdapter
            java.lang.String r1 = "locationAdapter"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            java.util.List r0 = r0.getMergedData()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0025
            com.blueair.outdoor.ui.adapters.LocationAdapter r0 = r3.locationAdapter
            if (r0 != 0) goto L_0x001f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x001f:
            boolean r0 = r0.getShowCurrentLocation()
            if (r0 == 0) goto L_0x002b
        L_0x0025:
            int r0 = com.blueair.outdoor.R.id.saved_location_recycler_view
            r1 = 2
            showCard$default(r3, r0, r2, r1, r2)
        L_0x002b:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.activity.MapActivity.configureMode$lambda$13$lambda$8(com.blueair.outdoor.ui.activity.MapActivity):kotlin.Unit");
    }

    /* access modifiers changed from: private */
    public static final Unit configureMode$lambda$13$lambda$12(MapActivity mapActivity) {
        showCard$default(mapActivity, R.id.current_location, (Function0) null, 2, (Object) null);
        return Unit.INSTANCE;
    }

    private final void configureSearchBar() {
        View findViewById = findViewById(R.id.search_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        TextView textView = (TextView) findViewById;
        this.searchBar = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            textView = null;
        }
        textView.setOnClickListener(new MapActivity$$ExternalSyntheticLambda24(this));
        View findViewById2 = findViewById(R.id.close_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        ((ImageButton) findViewById2).setOnClickListener(new MapActivity$$ExternalSyntheticLambda25(this));
    }

    /* access modifiers changed from: private */
    public static final void configureSearchBar$lambda$14(MapActivity mapActivity, View view) {
        mapActivity.startSearchIntent();
    }

    /* access modifiers changed from: private */
    public static final void configureSearchBar$lambda$15(MapActivity mapActivity, View view) {
        mapActivity.finish();
    }

    private final void configureAddLocationButton() {
        ((ImageButton) findViewById(R.id.add_location_btn)).setOnClickListener(new MapActivity$$ExternalSyntheticLambda17(this));
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [com.blueair.outdoor.ui.viewmodels.MapsViewModel$MapMode] */
    /* access modifiers changed from: private */
    public static final void configureAddLocationButton$lambda$16(MapActivity mapActivity, View view) {
        ? mode = mapActivity.getViewModel().getMode();
        if ((mode == 0 ? -1 : WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) == 3) {
            mapActivity.getViewModel().setNormalMode();
        } else {
            mapActivity.getViewModel().setAddMode();
        }
    }

    private final void configureAddLocationCard() {
        View findViewById = findViewById(R.id.current_location);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        LocationView locationView = (LocationView) findViewById;
        this.currentLocationView = locationView;
        if (locationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
            locationView = null;
        }
        LocationView.bind$default(locationView, (LocationItem) null, getMapType(), LocationView.TYPE.ADD_LOCATION, this.inAssignProductMode, getViewModel().isUserLoggedIn(), (Function2) null, (Function1) null, (Function3) null, 224, (Object) null);
    }

    private final void configureAddLocationListeners() {
        getViewModel().getAddLocationModel().observe(this, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda26(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit configureAddLocationListeners$lambda$21(MapActivity mapActivity, Pair pair) {
        LocationView locationView;
        TrackedLocation trackedLocation;
        LocationView locationView2;
        MapActivity mapActivity2 = mapActivity;
        if (pair != null) {
            if (mapActivity2.navigateToPrediction != null) {
                TrackedLocation trackedLocation2 = (TrackedLocation) pair.getFirst();
                CustomPlace customPlace = mapActivity2.navigateToPrediction;
                trackedLocation = TrackedLocation.copy$default(trackedLocation2, (String) null, 0.0d, 0.0d, customPlace != null ? customPlace.getAddress() : null, (String) null, (String) null, (String) null, (String) null, (String) null, TypedValues.PositionType.TYPE_PERCENT_WIDTH, (Object) null);
                mapActivity2.navigateToPrediction = null;
            } else {
                trackedLocation = (TrackedLocation) pair.getFirst();
            }
            LocationView locationView3 = mapActivity2.currentLocationView;
            if (locationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
                locationView2 = null;
            } else {
                locationView2 = locationView3;
            }
            LocationView.bind$default(locationView2, new LocationItem(trackedLocation, (AqiData) pair.getSecond(), CollectionsKt.emptyList()), mapActivity2.getMapType(), LocationView.TYPE.ADD_LOCATION, mapActivity2.inAssignProductMode, mapActivity2.getViewModel().isUserLoggedIn(), new MapActivity$$ExternalSyntheticLambda4(mapActivity2), (Function1) null, new MapActivity$$ExternalSyntheticLambda5(mapActivity2), 64, (Object) null);
        } else {
            LocationView locationView4 = mapActivity2.currentLocationView;
            if (locationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
                locationView = null;
            } else {
                locationView = locationView4;
            }
            LocationView.bind$default(locationView, (LocationItem) null, mapActivity2.getMapType(), LocationView.TYPE.NO_DATA, mapActivity2.inAssignProductMode, mapActivity2.getViewModel().isUserLoggedIn(), (Function2) null, (Function1) null, (Function3) null, 224, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureAddLocationListeners$lambda$21$lambda$18(MapActivity mapActivity, TrackedLocation trackedLocation, AqiData aqiData) {
        Intrinsics.checkNotNullParameter(trackedLocation, "newLocation");
        Intrinsics.checkNotNullParameter(aqiData, "pollutant");
        mapActivity.scrollToStationByAdd = trackedLocation;
        MapsViewModel.insertTrackedLocation$default(mapActivity.getViewModel(), trackedLocation, aqiData, false, (Function1) null, 8, (Object) null);
        mapActivity.getViewModel().setNormalMode();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureAddLocationListeners$lambda$21$lambda$20$showFailure(MapActivity mapActivity) {
        LocationView locationView = mapActivity.currentLocationView;
        if (locationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
            locationView = null;
        }
        FrameLayout frameLayout = locationView.getBinding().progressBar;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "progressBar");
        ViewExtensionsKt.hide(frameLayout);
        ToastUtils.showCenterToast$default(ToastUtils.INSTANCE, mapActivity, com.blueair.viewcore.R.string.request_failed, 0, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit configureAddLocationListeners$lambda$21$lambda$20(MapActivity mapActivity, TrackedLocation trackedLocation, List list, AqiData aqiData) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        Intrinsics.checkNotNullParameter(list, "devices");
        if (aqiData == null || mapActivity.deviceId.length() == 0) {
            configureAddLocationListeners$lambda$21$lambda$20$showFailure(mapActivity);
        } else {
            mapActivity.getViewModel().insertTrackedLocation(trackedLocation, aqiData, false, new MapActivity$$ExternalSyntheticLambda21(mapActivity, trackedLocation));
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureAddLocationListeners$lambda$21$lambda$20$lambda$19(MapActivity mapActivity, TrackedLocation trackedLocation, ApiResult apiResult) {
        Intrinsics.checkNotNullParameter(apiResult, "result");
        TrackedLocation trackedLocation2 = (TrackedLocation) apiResult.getOrNull();
        if (!apiResult.isSuccess() || trackedLocation2 == null) {
            configureAddLocationListeners$lambda$21$lambda$20$showFailure(mapActivity);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(mapActivity.getViewModel(), Dispatchers.getIO(), (CoroutineStart) null, new MapActivity$configureAddLocationListeners$1$2$1$1(mapActivity, trackedLocation, trackedLocation2, (Continuation<? super MapActivity$configureAddLocationListeners$1$2$1$1>) null), 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private final void configureAddLocationRxListeners() {
        getRxSubs().add(this.currentLocationDebounceFetchedPublisher.debounce(MAP_MOVE_UPDATE_STATION_DELAY, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new MapActivity$$ExternalSyntheticLambda2(new MapActivity$$ExternalSyntheticLambda1(this))));
    }

    /* access modifiers changed from: private */
    public static final void configureAddLocationRxListeners$lambda$23(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit configureAddLocationRxListeners$lambda$22(MapActivity mapActivity, TrackedLocation trackedLocation) {
        MapActivity mapActivity2 = mapActivity;
        LocationView locationView = mapActivity2.currentLocationView;
        if (locationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
            locationView = null;
        }
        LocationView.bind$default(locationView, (LocationItem) null, mapActivity2.getMapType(), LocationView.TYPE.ADD_LOCATION, mapActivity2.inAssignProductMode, mapActivity2.getViewModel().isUserLoggedIn(), (Function2) null, (Function1) null, (Function3) null, 224, (Object) null);
        mapActivity2.getViewModel().fetchAirQuality(trackedLocation.getLat(), trackedLocation.getLon(), mapActivity2.getLocalMapType());
        return Unit.INSTANCE;
    }

    private final void configureGPSButton() {
        ((ImageButton) findViewById(R.id.gps_btn)).setOnClickListener(new MapActivity$$ExternalSyntheticLambda22(this));
        getViewModel().getCurrentLocation().observe(this, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda23(this)));
    }

    /* access modifiers changed from: private */
    public static final void configureGPSButton$lambda$26(MapActivity mapActivity, View view) {
        Object obj;
        Timber.Forest.d("OnGPSClick", new Object[0]);
        Iterator it = mapActivity.getViewModel().getMarkers().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), (Object) "current")) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            mapActivity.onMarkerTapped((String) entry.getKey());
        }
    }

    /* access modifiers changed from: private */
    public static final Unit configureGPSButton$lambda$27(MapActivity mapActivity, TrackedLocation trackedLocation) {
        if (trackedLocation == null) {
            View findViewById = mapActivity.findViewById(R.id.gps_btn);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ViewExtensionsKt.hide(findViewById);
        } else {
            View findViewById2 = mapActivity.findViewById(R.id.gps_btn);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            ViewExtensionsKt.show$default(findViewById2, false, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onAttachFragment(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.onAttachFragment(fragment);
        if ((fragment instanceof ConfirmationDialogCentered) && Intrinsics.areEqual((Object) ((ConfirmationDialogCentered) fragment).getTag(), (Object) DIALOG_TAG)) {
            getSupportFragmentManager().setFragmentResultListener(ConfirmationDialogCenteredKt.CONFIRMATION_REQUEST_KEY, this, new MapActivity$$ExternalSyntheticLambda19(fragment, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void onAttachFragment$lambda$29(Fragment fragment, MapActivity mapActivity, String str, Bundle bundle) {
        Bundle arguments;
        TrackedLocation trackedLocation;
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(bundle, "result");
        if (bundle.getBoolean(ConfirmationDialogCenteredKt.IS_CONFIRMED_KEY) && (arguments = ((ConfirmationDialogCentered) fragment).getArguments()) != null && (trackedLocation = (TrackedLocation) arguments.getParcelable("location")) != null) {
            mapActivity.scrollToStationByDelete = trackedLocation;
            mapActivity.getViewModel().deleteLocation(trackedLocation);
        }
    }

    private final void configureSavedLocations() {
        RecyclerView recyclerView2;
        View findViewById = findViewById(R.id.saved_location_recycler_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.recyclerView = (RecyclerView) findViewById;
        Context context = this;
        this.locationAdapter = new LocationAdapter(context, getMapType(), this.shouldShowAssignProduct, getViewModel().isUserLoggedIn(), new MapActivity$$ExternalSyntheticLambda6(this), new MapActivity$$ExternalSyntheticLambda7(this), new MapActivity$$ExternalSyntheticLambda8(this));
        this.locationLinearLayoutManager = new LocationLinearLayoutManager(context, 0, false);
        RecyclerView recyclerView3 = this.recyclerView;
        Button button = null;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        LocationAdapter locationAdapter2 = this.locationAdapter;
        if (locationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            locationAdapter2 = null;
        }
        recyclerView3.setAdapter(locationAdapter2);
        LocationLinearLayoutManager locationLinearLayoutManager2 = this.locationLinearLayoutManager;
        if (locationLinearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationLinearLayoutManager");
            locationLinearLayoutManager2 = null;
        }
        recyclerView3.setLayoutManager(locationLinearLayoutManager2);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        RecyclerView recyclerView4 = this.recyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        } else {
            recyclerView2 = recyclerView4;
        }
        RecyclerExtensionsKt.attachSnapHelperWithListener$default(recyclerView2, pagerSnapHelper, (SnapOnScrollListener.Behavior) null, new MapActivity$configureSavedLocations$5(booleanRef, this), 2, (Object) null);
        LocationPageIndicatorItemDecorator locationPageIndicatorItemDecorator = new LocationPageIndicatorItemDecorator(context);
        RecyclerView recyclerView5 = this.recyclerView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView5 = null;
        }
        recyclerView5.addItemDecoration(locationPageIndicatorItemDecorator);
        RecyclerView recyclerView6 = this.recyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView6 = null;
        }
        recyclerView6.setOnClickListener(new MapActivity$$ExternalSyntheticLambda9(this));
        View findViewById2 = findViewById(R.id.saved_location_maximize_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        Button button2 = (Button) findViewById2;
        this.maximizeButton = button2;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maximizeButton");
        } else {
            button = button2;
        }
        button.setOnClickListener(new MapActivity$$ExternalSyntheticLambda10(this));
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getCurrentLocation().observe(lifecycleOwner, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda12(this, new Ref.BooleanRef())));
        getViewModel().getAllLocations().observe(lifecycleOwner, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda13(this)));
        LiveDataExtensionsKt.observeNonNull(getViewModel().getCurrentLocationWithPollutants(), lifecycleOwner, new MapActivity$$ExternalSyntheticLambda14(this));
        getViewModel().getTrackedLocationWithPollutants().observe(lifecycleOwner, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda15(this)));
        getViewModel().getSavedLocationViewIndex().observe(lifecycleOwner, new MapActivity$sam$androidx_lifecycle_Observer$0(new MapActivity$$ExternalSyntheticLambda16(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$30(MapActivity mapActivity, TrackedLocation trackedLocation, AqiData aqiData) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        Intrinsics.checkNotNullParameter(aqiData, "pollutant");
        mapActivity.scrollToStationByAdd = trackedLocation;
        MapsViewModel.insertTrackedLocation$default(mapActivity.getViewModel(), trackedLocation, aqiData, true, (Function1) null, 8, (Object) null);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$31(MapActivity mapActivity, TrackedLocation trackedLocation) {
        Intrinsics.checkNotNullParameter(trackedLocation, "onDeleteLocation");
        ConfirmationDialogCentered newInstance$default = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, Integer.valueOf(com.blueair.viewcore.R.string.outdoor_delete_location_title), Integer.valueOf(com.blueair.viewcore.R.string.outdoor_delete_location_content), com.blueair.viewcore.R.string.outdoor_delete_location_confirm, Integer.valueOf(com.blueair.viewcore.R.string.confirmation_negative_default), true, false, false, (String[]) null, 224, (Object) null);
        Bundle arguments = newInstance$default.getArguments();
        if (arguments != null) {
            arguments.putParcelable("location", trackedLocation);
        }
        newInstance$default.show(mapActivity.getSupportFragmentManager(), DIALOG_TAG);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$37(MapActivity mapActivity, TrackedLocation trackedLocation, List list, AqiData aqiData) {
        Intrinsics.checkNotNullParameter(trackedLocation, "location");
        Intrinsics.checkNotNullParameter(list, "devices");
        if (mapActivity.shouldShowAssignProduct) {
            Pair value = mapActivity.getViewModel().getSavedLocationViewIndex().getValue();
            Integer num = value != null ? (Integer) value.getFirst() : null;
            if (mapActivity.deviceId.length() > 0) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(mapActivity.getViewModel(), Dispatchers.getIO(), (CoroutineStart) null, new MapActivity$configureSavedLocations$3$1(mapActivity, trackedLocation, num, (Continuation<? super MapActivity$configureSavedLocations$3$1>) null), 2, (Object) null);
            } else {
                configureSavedLocations$lambda$37$showFailure$33(num, mapActivity);
            }
        } else {
            List value2 = mapActivity.getViewModel().getDevices().getValue();
            if (value2 != null) {
                Collection arrayList = new ArrayList();
                for (Object next : value2) {
                    if (next instanceof HasLocation) {
                        arrayList.add(next);
                    }
                }
                if (!((List) arrayList).isEmpty()) {
                    FragmentManager supportFragmentManager = mapActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    Class<AssignProductDialogFragment> cls = AssignProductDialogFragment.class;
                    Intrinsics.checkNotNullExpressionValue("AssignProductDialogFragment", "getSimpleName(...)");
                    if (!(supportFragmentManager.findFragmentByTag("AssignProductDialogFragment") instanceof AssignProductDialogFragment) && !supportFragmentManager.isStateSaved()) {
                        AssignProductDialogFragment.Companion companion = AssignProductDialogFragment.Companion;
                        Collection arrayList2 = new ArrayList();
                        for (Object next2 : list) {
                            if (next2 instanceof HasLocation) {
                                arrayList2.add(next2);
                            }
                        }
                        companion.newInstance(trackedLocation, (List) arrayList2).show(supportFragmentManager, "AssignProductDialogFragment");
                    }
                }
            }
            FragmentManager supportFragmentManager2 = mapActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
            Class<AssignProductNoDeviceDialogFragment> cls2 = AssignProductNoDeviceDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("AssignProductNoDeviceDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager2.findFragmentByTag("AssignProductNoDeviceDialogFragment") instanceof AssignProductNoDeviceDialogFragment) && !supportFragmentManager2.isStateSaved()) {
                AssignProductNoDeviceDialogFragment.Companion companion2 = AssignProductNoDeviceDialogFragment.Companion;
                String locationName = trackedLocation.getLocationName();
                if (locationName == null) {
                    locationName = mapActivity.getString(com.blueair.viewcore.R.string.unknown_station_name_placeholder);
                    Intrinsics.checkNotNullExpressionValue(locationName, "getString(...)");
                }
                companion2.newInstance(locationName).show(supportFragmentManager2, "AssignProductNoDeviceDialogFragment");
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void configureSavedLocations$lambda$37$showFailure$33(Integer num, MapActivity mapActivity) {
        if (num != null) {
            num.intValue();
            LocationAdapter locationAdapter2 = mapActivity.locationAdapter;
            if (locationAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                locationAdapter2 = null;
            }
            locationAdapter2.notifyItemChanged(num.intValue());
        }
        ToastUtils.showCenterToast$default(ToastUtils.INSTANCE, mapActivity, com.blueair.viewcore.R.string.request_failed, 0, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void configureSavedLocations$lambda$39(MapActivity mapActivity, View view) {
        if (mapActivity.getViewModel().getMode() == MapsViewModel.MapMode.MINIMIZED) {
            mapActivity.getViewModel().setNormalMode();
        }
    }

    /* access modifiers changed from: private */
    public static final void configureSavedLocations$lambda$40(MapActivity mapActivity, View view) {
        mapActivity.getViewModel().setNormalMode();
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$41(MapActivity mapActivity, Ref.BooleanRef booleanRef, TrackedLocation trackedLocation) {
        if (!mapActivity.startedForSearchMode && !booleanRef.element && !mapActivity.getShouldNavigateToStationByIntent() && trackedLocation != null && mapActivity.getViewModel().isUserLoggedIn()) {
            booleanRef.element = true;
            mapActivity.getViewModel().viewLocation(trackedLocation.getLat(), trackedLocation.getLon(), trackedLocation.getMapType());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$43(MapActivity mapActivity, List list) {
        mapActivity.clearMapMarkers();
        Intrinsics.checkNotNull(list);
        mapActivity.addMapMarkers(list);
        String selectedMarkerId = mapActivity.getSelectedMarkerId();
        if (selectedMarkerId != null) {
            mapActivity.styleMarker(selectedMarkerId, true, mapActivity.isCurrentLocationSelected());
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$44(MapActivity mapActivity, LocationItem locationItem) {
        LocationAdapter locationAdapter2 = mapActivity.locationAdapter;
        if (locationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            locationAdapter2 = null;
        }
        locationAdapter2.setMergedCurrentLocation(locationItem);
        if (mapActivity.navigateToCurrentLocation && !mapActivity.hasInitiallyNavigateToStation) {
            mapActivity.moveToLocation("current");
            mapActivity.getViewModel().setNormalMode();
            mapActivity.hasInitiallyNavigateToStation = true;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$51(MapActivity mapActivity, List list) {
        LocationAdapter locationAdapter2 = mapActivity.locationAdapter;
        LocationAdapter locationAdapter3 = null;
        if (locationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            locationAdapter2 = null;
        }
        List<LocationItem> mergedData = locationAdapter2.getMergedData();
        LocationAdapter locationAdapter4 = mapActivity.locationAdapter;
        if (locationAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            locationAdapter4 = null;
        }
        Intrinsics.checkNotNull(list);
        locationAdapter4.setMergedData(list);
        if (!mapActivity.getShouldNavigateToStationByIntent() || mapActivity.hasInitiallyNavigateToStation || mapActivity.navigateToCurrentLocation || list.isEmpty()) {
            TrackedLocation trackedLocation = mapActivity.scrollToStationByAdd;
            int i = -1;
            if (trackedLocation == null) {
                TrackedLocation trackedLocation2 = mapActivity.scrollToStationByDelete;
                if (!(trackedLocation2 == null || trackedLocation2 == null)) {
                    mapActivity.scrollToStationByDelete = null;
                    Iterator<LocationItem> it = mergedData.iterator();
                    int i2 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual((Object) it.next().getLocation().getId(), (Object) trackedLocation2.getId())) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (i < mergedData.size() - 1) {
                            MutableLiveData<Pair<Integer, Boolean>> savedLocationViewIndex = mapActivity.getViewModel().getSavedLocationViewIndex();
                            LocationAdapter locationAdapter5 = mapActivity.locationAdapter;
                            if (locationAdapter5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                            } else {
                                locationAdapter3 = locationAdapter5;
                            }
                            savedLocationViewIndex.setValue(new Pair(Integer.valueOf(i + (locationAdapter3.getShowCurrentLocation() ? 1 : 0)), false));
                        } else if (i == 0) {
                            LocationAdapter locationAdapter6 = mapActivity.locationAdapter;
                            if (locationAdapter6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                            } else {
                                locationAdapter3 = locationAdapter6;
                            }
                            if (locationAdapter3.getShowCurrentLocation()) {
                                mapActivity.getViewModel().getSavedLocationViewIndex().setValue(new Pair(0, false));
                            }
                        }
                    }
                }
            } else if (trackedLocation != null) {
                Iterator it2 = list.iterator();
                int i3 = 0;
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    TrackedLocation location = ((LocationItem) it2.next()).getLocation();
                    if (location.getLat() == trackedLocation.getLat() && location.getLon() == trackedLocation.getLon()) {
                        i = i3;
                        break;
                    }
                    i3++;
                }
                if (i >= 0) {
                    mapActivity.scrollToStationByAdd = null;
                    LocationAdapter locationAdapter7 = mapActivity.locationAdapter;
                    if (locationAdapter7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                        locationAdapter7 = null;
                    }
                    moveToLocation$default(mapActivity, i + (locationAdapter7.getShowCurrentLocation() ? 1 : 0), false, 2, (Object) null);
                }
            }
        } else {
            String str = mapActivity.navigateToStationByIntent;
            Intrinsics.checkNotNull(str);
            mapActivity.moveToLocation(str);
            mapActivity.getViewModel().setNormalMode();
            mapActivity.hasInitiallyNavigateToStation = true;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit configureSavedLocations$lambda$52(MapActivity mapActivity, Pair pair) {
        mapActivity.moveToLocation(((Number) pair.getFirst()).intValue(), ((Boolean) pair.getSecond()).booleanValue());
        return Unit.INSTANCE;
    }

    private final void disableSavedLocationScrolling() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager");
        ((LocationLinearLayoutManager) layoutManager).setScrollingEnabled(false);
    }

    private final void enableSavedLocationScrolling() {
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager");
        ((LocationLinearLayoutManager) layoutManager).setScrollingEnabled(true);
    }

    /* access modifiers changed from: protected */
    public final void setMinimizedModeIfNeeded() {
        if (getViewModel().getMode() == MapsViewModel.MapMode.SAVED_LOCATIONS) {
            getViewModel().setMinimizedMode();
        }
    }

    static /* synthetic */ void showCard$default(MapActivity mapActivity, int i, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                function0 = null;
            }
            mapActivity.showCard(i, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCard");
    }

    private final void showCard(int i, Function0<Unit> function0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        if (constraintSet.getConstraint(i).layout.bottomToTop != R.id.root_bottom_guideline) {
            constraintSet.clear(i, 3);
            constraintSet.clear(i, 4);
            constraintSet.connect(i, 4, R.id.root_bottom_guideline, 3);
            Intrinsics.checkNotNull(constraintLayout);
            animate(constraintLayout, function0);
            constraintSet.applyTo(constraintLayout);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    static /* synthetic */ void showMinimizedCard$default(MapActivity mapActivity, int i, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                function0 = null;
            }
            mapActivity.showMinimizedCard(i, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMinimizedCard");
    }

    private final void showMinimizedCard(int i, Function0<Unit> function0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        if (constraintSet.getConstraint(i).layout.topToTop != R.id.minimized_bottom_guideline) {
            constraintSet.clear(i, 3);
            constraintSet.clear(i, 4);
            constraintSet.connect(i, 3, R.id.minimized_bottom_guideline, 3);
            Intrinsics.checkNotNull(constraintLayout);
            animate(constraintLayout, function0);
            constraintSet.applyTo(constraintLayout);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    static /* synthetic */ void hideCard$default(MapActivity mapActivity, int i, Function0 function0, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                function0 = null;
            }
            mapActivity.hideCard(i, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideCard");
    }

    private final void hideCard(int i, Function0<Unit> function0) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        if (constraintSet.getConstraint(i).layout.topToBottom != 0) {
            constraintSet.clear(i, 3);
            constraintSet.clear(i, 4);
            constraintSet.connect(i, 3, 0, 4);
            Intrinsics.checkNotNull(constraintLayout);
            animate(constraintLayout, function0);
            constraintSet.applyTo(constraintLayout);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    static /* synthetic */ void animate$default(MapActivity mapActivity, ConstraintLayout constraintLayout, Function0 function0, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            mapActivity.animate(constraintLayout, function0);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animate");
    }

    private final void animate(ConstraintLayout constraintLayout, Function0<Unit> function0) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.addListener(new MapActivity$animate$1(function0));
        changeBounds.setDuration(300);
        TransitionManager.beginDelayedTransition(constraintLayout, changeBounds);
    }

    private final void gotoLocation(TrackedLocation trackedLocation) {
        gotoLocation(trackedLocation, 16.0f);
    }

    public final void onMarkerTapped(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        getViewModel().setNormalMode();
        String str2 = getViewModel().getMarkers().get(str);
        if (str2 != null) {
            List value = getViewModel().getAllLocations().getValue();
            if (value == null) {
                value = CollectionsKt.emptyList();
            }
            Iterator it = value.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else if (Intrinsics.areEqual((Object) ((TrackedLocation) it.next()).getId(), (Object) str2)) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                LocationLinearLayoutManager locationLinearLayoutManager2 = this.locationLinearLayoutManager;
                if (locationLinearLayoutManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationLinearLayoutManager");
                    locationLinearLayoutManager2 = null;
                }
                locationLinearLayoutManager2.scrollToPosition(i);
                gotoLocation((TrackedLocation) value.get(i));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        r2 = r2.getLocation();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void moveToLocation(java.lang.String r9) {
        /*
            r8 = this;
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "moveToLocation: stationId = "
            r1.<init>(r2)
            r1.append(r9)
            java.lang.String r2 = ", locationAdapter.showCurrentLocation = "
            r1.append(r2)
            com.blueair.outdoor.ui.adapters.LocationAdapter r2 = r8.locationAdapter
            java.lang.String r3 = "locationAdapter"
            r4 = 0
            if (r2 != 0) goto L_0x001c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r2 = r4
        L_0x001c:
            boolean r2 = r2.getShowCurrentLocation()
            r1.append(r2)
            java.lang.String r2 = ", mergedCurrentLocation.first.stationId = "
            r1.append(r2)
            com.blueair.outdoor.ui.adapters.LocationAdapter r2 = r8.locationAdapter
            if (r2 != 0) goto L_0x0030
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r2 = r4
        L_0x0030:
            com.blueair.outdoor.ui.adapters.LocationItem r2 = r2.getMergedCurrentLocation()
            if (r2 == 0) goto L_0x0041
            com.blueair.core.model.TrackedLocation r2 = r2.getLocation()
            if (r2 == 0) goto L_0x0041
            java.lang.String r2 = r2.getId()
            goto L_0x0042
        L_0x0041:
            r2 = r4
        L_0x0042:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r5 = new java.lang.Object[r2]
            r0.d(r1, r5)
            com.blueair.outdoor.ui.adapters.LocationAdapter r0 = r8.locationAdapter
            if (r0 != 0) goto L_0x0057
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x0057:
            boolean r0 = r0.getShowCurrentLocation()
            r1 = 1
            if (r0 == 0) goto L_0x0096
            com.blueair.outdoor.ui.adapters.LocationAdapter r0 = r8.locationAdapter
            if (r0 != 0) goto L_0x0066
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x0066:
            com.blueair.outdoor.ui.adapters.LocationItem r0 = r0.getMergedCurrentLocation()
            if (r0 == 0) goto L_0x0077
            com.blueair.core.model.TrackedLocation r0 = r0.getLocation()
            if (r0 == 0) goto L_0x0077
            java.lang.String r0 = r0.getId()
            goto L_0x0078
        L_0x0077:
            r0 = r4
        L_0x0078:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)
            if (r0 == 0) goto L_0x0096
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r0 = r8.getViewModel()
            androidx.lifecycle.MutableLiveData r0 = r0.getSavedLocationViewIndex()
            kotlin.Pair r5 = new kotlin.Pair
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r1)
            r5.<init>(r6, r7)
            r0.setValue(r5)
        L_0x0096:
            boolean r0 = r8.navigateToCurrentLocation
            if (r0 == 0) goto L_0x00c1
            com.blueair.outdoor.ui.adapters.LocationAdapter r0 = r8.locationAdapter
            if (r0 != 0) goto L_0x00a2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x00a2:
            boolean r0 = r0.getShowCurrentLocation()
            if (r0 == 0) goto L_0x00c1
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r9 = r8.getViewModel()
            androidx.lifecycle.MutableLiveData r9 = r9.getSavedLocationViewIndex()
            kotlin.Pair r0 = new kotlin.Pair
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.<init>(r2, r1)
            r9.setValue(r0)
            return
        L_0x00c1:
            com.blueair.outdoor.ui.adapters.LocationAdapter r0 = r8.locationAdapter
            if (r0 != 0) goto L_0x00c9
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = r4
        L_0x00c9:
            java.util.List r0 = r0.getMergedData()
            java.util.Iterator r0 = r0.iterator()
        L_0x00d1:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x00ef
            java.lang.Object r5 = r0.next()
            com.blueair.outdoor.ui.adapters.LocationItem r5 = (com.blueair.outdoor.ui.adapters.LocationItem) r5
            com.blueair.core.model.TrackedLocation r5 = r5.getLocation()
            java.lang.String r5 = r5.getId()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r9)
            if (r5 == 0) goto L_0x00ec
            goto L_0x00f0
        L_0x00ec:
            int r2 = r2 + 1
            goto L_0x00d1
        L_0x00ef:
            r2 = -1
        L_0x00f0:
            if (r2 < 0) goto L_0x0118
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r9 = r8.getViewModel()
            androidx.lifecycle.MutableLiveData r9 = r9.getSavedLocationViewIndex()
            kotlin.Pair r0 = new kotlin.Pair
            com.blueair.outdoor.ui.adapters.LocationAdapter r5 = r8.locationAdapter
            if (r5 != 0) goto L_0x0104
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x0105
        L_0x0104:
            r4 = r5
        L_0x0105:
            boolean r3 = r4.getShowCurrentLocation()
            int r2 = r2 + r3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.<init>(r2, r1)
            r9.setValue(r0)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.activity.MapActivity.moveToLocation(java.lang.String):void");
    }

    static /* synthetic */ void moveToLocation$default(MapActivity mapActivity, int i, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                z = true;
            }
            mapActivity.moveToLocation(i, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToLocation");
    }

    private final void moveToLocation(int i, boolean z) {
        LocationAdapter locationAdapter2 = this.locationAdapter;
        LocationAdapter locationAdapter3 = null;
        if (locationAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            locationAdapter2 = null;
        }
        int size = locationAdapter2.getMergedData().size();
        LocationAdapter locationAdapter4 = this.locationAdapter;
        if (locationAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            locationAdapter4 = null;
        }
        int i2 = size + (locationAdapter4.getShowCurrentLocation() ? 1 : 0);
        if (i >= 0 && i < i2) {
            if (z) {
                LocationLinearLayoutManager locationLinearLayoutManager2 = this.locationLinearLayoutManager;
                if (locationLinearLayoutManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("locationLinearLayoutManager");
                    locationLinearLayoutManager2 = null;
                }
                locationLinearLayoutManager2.scrollToPosition(i);
            }
            LocationAdapter locationAdapter5 = this.locationAdapter;
            if (locationAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            } else {
                locationAdapter3 = locationAdapter5;
            }
            gotoLocation(locationAdapter3.getItem(i).getLocation());
        }
    }

    private final void changeSearchBarStyle() {
        TextView textView = this.searchBar;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            textView = null;
        }
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        TextView textView3 = this.searchBar;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(ContextCompat.getColor(this, com.blueair.viewcore.R.color.colorPrimaryText));
    }

    private final void clearMapMarkers() {
        if (getViewModel().getMapIsReady()) {
            clearMapMarkersImpl();
        }
    }

    private final void addMapMarkers(List<TrackedLocation> list) {
        if (getViewModel().getMapIsReady()) {
            addMapMarkersImpl(list);
        } else {
            this.pendingMarkers = list;
        }
    }

    private final void gotoLocation(TrackedLocation trackedLocation, float f) {
        String selectedMarkerId = getSelectedMarkerId();
        int i = 0;
        if (selectedMarkerId != null) {
            styleMarker(selectedMarkerId, false, isCurrentLocationSelected());
        }
        List value = getViewModel().getAllLocations().getValue();
        int i2 = -1;
        if (value != null) {
            Iterator it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (Intrinsics.areEqual((Object) ((TrackedLocation) it.next()).getId(), (Object) trackedLocation.getId())) {
                    i2 = i;
                    break;
                } else {
                    i++;
                }
            }
        }
        if (i2 >= 0) {
            this.selectedLocationId = trackedLocation.getId();
            String selectedMarkerId2 = getSelectedMarkerId();
            if (selectedMarkerId2 != null) {
                styleMarker(selectedMarkerId2, true, isCurrentLocationSelected());
            }
        }
        if (getViewModel().getMapIsReady()) {
            gotoLocationImpl(trackedLocation, f);
        } else {
            this.pendingGotoLocation = new Pair<>(trackedLocation, Float.valueOf(f));
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Timber.Forest.d(String.valueOf(intent), new Object[0]);
        if (i2 == -1) {
            TrackedLocation trackedLocation = null;
            CustomPlace customPlace = intent != null ? (CustomPlace) intent.getParcelableExtra(SearchActivity.SEARCH_REQUEST_KEY) : null;
            if (intent != null) {
                trackedLocation = (TrackedLocation) intent.getParcelableExtra(SearchActivity.SAVED_LOCATION_KEY);
            }
            if (customPlace != null) {
                changeSearchBarStyle();
                this.navigateToPrediction = customPlace;
            } else if (trackedLocation != null) {
                this.navigateToStationIdBySearchResult = trackedLocation.getId();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void updateAirQualityIfNeeded(double d, double d2) {
        if (getViewModel().getMode() == MapsViewModel.MapMode.ADD_LOCATION) {
            this.currentLocationDebounceFetchedPublisher.onNext(getViewModel().createEmptyLocation(d, d2, getLocalMapType()));
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        configureAddLocationRxListeners();
        navigateToStationFromSearchActivityIfNeeded();
        navigateToPredictionFromSearchActivityIfNeeded();
    }

    private final void navigateToStationFromSearchActivityIfNeeded() {
        if (getShouldNavigateToStationIdBySearchResult()) {
            moveToLocation(this.navigateToStationIdBySearchResult);
            getViewModel().getMode().setValue(MapsViewModel.MapMode.SAVED_LOCATIONS);
            this.navigateToStationIdBySearchResult = "";
        }
    }

    private final void navigateToPredictionFromSearchActivityIfNeeded() {
        CustomPlace customPlace = this.navigateToPrediction;
        if (customPlace != null) {
            TextView textView = this.searchBar;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchBar");
                textView = null;
            }
            textView.setText(customPlace.getAddress());
            getViewModel().viewLocation(customPlace.getLat(), customPlace.getLng(), getLocalMapType());
            getViewModel().setAddMode();
        }
    }

    /* access modifiers changed from: protected */
    public final Bitmap getMarkerIcon(int i, int i2, int i3) {
        Drawable drawable = AppCompatResources.getDrawable(this, i);
        if (drawable == null) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        canvas.setBitmap(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(createBitmap, i2, i3, false);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        createBitmap.recycle();
        return createScaledBitmap;
    }
}
