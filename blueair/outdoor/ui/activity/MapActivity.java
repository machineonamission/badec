package com.blueair.outdoor.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.Transition.TransitionListener._CC;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.HasLocation;
import com.blueair.core.model.TrackedLocation;
import com.blueair.outdoor.ui.adapters.LocationAdapter;
import com.blueair.outdoor.ui.adapters.LocationItem;
import com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager;
import com.blueair.outdoor.ui.adapters.LocationPageIndicatorItemDecorator;
import com.blueair.outdoor.ui.adapters.LocationView;
import com.blueair.outdoor.ui.dialog.AssignProductDialogFragment;
import com.blueair.outdoor.ui.dialog.AssignProductNoDeviceDialogFragment;
import com.blueair.outdoor.ui.viewmodels.CustomPlace;
import com.blueair.outdoor.ui.viewmodels.MapsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.extensions.RecyclerExtensionsKt;
import com.blueair.viewcore.utils.SnapOnScrollListener;
import com.blueair.viewcore.utils.ToastUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
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
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okhttp3.ResponseBody;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u0089\u00012\u00020\u0001:\u0002\u0089\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0014J\b\u0010J\u001a\u00020GH\u0014J\b\u0010K\u001a\u00020GH\u0002J\b\u0010L\u001a\u00020GH\u0004J\b\u0010M\u001a\u00020GH\u0002J\b\u0010N\u001a\u00020GH\u0002J\b\u0010O\u001a\u00020GH\u0002J\b\u0010P\u001a\u00020GH\u0002J\b\u0010Q\u001a\u00020GH\u0002J\b\u0010R\u001a\u00020GH\u0002J\b\u0010S\u001a\u00020GH\u0002J\u0010\u0010T\u001a\u00020G2\u0006\u0010U\u001a\u00020VH\u0017J\b\u0010W\u001a\u00020GH\u0002J\b\u0010X\u001a\u00020GH\u0002J\b\u0010Y\u001a\u00020GH\u0002J\b\u0010Z\u001a\u00020GH$J\b\u0010[\u001a\u00020GH\u0004J\"\u0010\\\u001a\u00020G2\u0006\u0010]\u001a\u0002012\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\"\u0010`\u001a\u00020G2\u0006\u0010]\u001a\u0002012\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\"\u0010a\u001a\u00020G2\u0006\u0010]\u001a\u0002012\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\"\u0010b\u001a\u00020G2\u0006\u0010c\u001a\u00020d2\u0010\b\u0002\u0010^\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010_H\u0002J\u0010\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020,H\u0002J\u000e\u0010g\u001a\u00020G2\u0006\u0010]\u001a\u00020\u0005J\u0010\u0010h\u001a\u00020G2\u0006\u0010i\u001a\u00020\u0005H\u0002J\u001a\u0010h\u001a\u00020G2\u0006\u0010j\u001a\u0002012\b\b\u0002\u0010k\u001a\u00020\u001bH\u0002J\b\u0010l\u001a\u00020GH\u0002J\b\u0010m\u001a\u00020GH$J\u0016\u0010n\u001a\u00020G2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020,0AH$J \u0010p\u001a\u00020G2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u001b2\u0006\u0010s\u001a\u00020\u001bH$J\u0018\u0010t\u001a\u00020G2\u0006\u0010f\u001a\u00020,2\u0006\u0010u\u001a\u00020?H$J\b\u0010v\u001a\u00020GH\u0002J\u0016\u0010w\u001a\u00020G2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020,0AH\u0002J\u0018\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020,2\u0006\u0010u\u001a\u00020?H\u0002J\"\u0010x\u001a\u00020G2\u0006\u0010y\u001a\u0002012\u0006\u0010z\u001a\u0002012\b\u0010{\u001a\u0004\u0018\u00010|H\u0015J\u0019\u0010}\u001a\u00020G2\u0006\u0010~\u001a\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020\u007fH\u0004J\t\u0010\u0081\u0001\u001a\u00020GH\u0014J\t\u0010\u0082\u0001\u001a\u00020GH\u0002J\t\u0010\u0083\u0001\u001a\u00020GH\u0002J'\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u00012\u0007\u0010\u0086\u0001\u001a\u0002012\u0007\u0010\u0087\u0001\u001a\u0002012\u0007\u0010\u0088\u0001\u001a\u000201H\u0004R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001fR\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020,07X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0007R\u001b\u0010:\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b;\u0010\u0007R\u001c\u0010=\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020?\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010C\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010\u0007R\u0014\u0010E\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u001f¨\u0006\u008a\u0001"},
   d2 = {"Lcom/blueair/outdoor/ui/activity/MapActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "searchBar", "Landroid/widget/TextView;", "viewModel", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "locationAdapter", "Lcom/blueair/outdoor/ui/adapters/LocationAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "maximizeButton", "Landroid/widget/Button;", "locationLinearLayoutManager", "Lcom/blueair/outdoor/ui/adapters/LocationLinearLayoutManager;", "currentLocationView", "Lcom/blueair/outdoor/ui/adapters/LocationView;", "startedForSearchMode", "", "hasInitiallyNavigateToStation", "shouldNavigateToStationByIntent", "getShouldNavigateToStationByIntent", "()Z", "navigateToStationByIntent", "navigateToCurrentLocation", "deviceId", "inAssignProductMode", "value", "shouldShowAssignProduct", "setShouldShowAssignProduct", "(Z)V", "navigateToStationIdBySearchResult", "shouldNavigateToStationIdBySearchResult", "getShouldNavigateToStationIdBySearchResult", "scrollToStationByAdd", "Lcom/blueair/core/model/TrackedLocation;", "scrollToStationByDelete", "navigateToPrediction", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "mapViewId", "", "getMapViewId", "()I", "setMapViewId", "(I)V", "currentLocationDebounceFetchedPublisher", "Lio/reactivex/subjects/PublishSubject;", "mapType", "getMapType", "localMapType", "getLocalMapType", "localMapType$delegate", "pendingGotoLocation", "Lkotlin/Pair;", "", "pendingMarkers", "", "selectedLocationId", "selectedMarkerId", "getSelectedMarkerId", "isCurrentLocationSelected", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onMapReady", "configureUsingIntentParameters", "setupLocationServices", "configureMode", "configureSearchBar", "configureAddLocationButton", "configureAddLocationCard", "configureAddLocationListeners", "configureAddLocationRxListeners", "configureGPSButton", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "configureSavedLocations", "disableSavedLocationScrolling", "enableSavedLocationScrolling", "startSearchIntent", "setMinimizedModeIfNeeded", "showCard", "id", "completion", "Lkotlin/Function0;", "showMinimizedCard", "hideCard", "animate", "layout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "gotoLocation", "location", "onMarkerTapped", "moveToLocation", "locationId", "position", "shouldScroll", "changeSearchBarStyle", "clearMapMarkersImpl", "addMapMarkersImpl", "locations", "styleMarker", "markerId", "isSelected", "isCurrentLocation", "gotoLocationImpl", "zoom", "clearMapMarkers", "addMapMarkers", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "updateAirQualityIfNeeded", "lat", "", "lng", "onResume", "navigateToStationFromSearchActivityIfNeeded", "navigateToPredictionFromSearchActivityIfNeeded", "getMarkerIcon", "Landroid/graphics/Bitmap;", "drawableId", "width", "height", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class MapActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DIALOG_TAG = "Dialog";
   private static final String KEY_LOCATION = "location";
   public static final long MAP_MOVE_UPDATE_STATION_DELAY = 1200L;
   public static final int MARKER_SIZE_GPS = 45;
   public static final int MARKER_SIZE_LOCATION = 80;
   public static final String NO_ELEMENT = "";
   public static final float ZOOM_LEVEL_FOCUS = 7.0F;
   public static final float ZOOM_LEVEL_MAX = 16.0F;
   public static final float ZOOM_LEVEL_STREET = 13.0F;
   private final PublishSubject currentLocationDebounceFetchedPublisher;
   private LocationView currentLocationView;
   private String deviceId;
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
   private Pair pendingGotoLocation;
   private List pendingMarkers;
   private RecyclerView recyclerView;
   private final String screenName = "outdoor_map";
   private TrackedLocation scrollToStationByAdd;
   private TrackedLocation scrollToStationByDelete;
   private TextView searchBar;
   private String selectedLocationId;
   private boolean shouldShowAssignProduct;
   private boolean startedForSearchMode;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$25MuRhD0SILp8IVPhvf2LXxUmnU(MapActivity var0, TrackedLocation var1) {
      return configureGPSButton$lambda$27(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2HqwNwv7zVCuN18MUg3igelWqa0(MapActivity var0, LocationItem var1) {
      return configureSavedLocations$lambda$44(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$2zAkJ_9zG03_n7chJOlK3MzApk4/* $FF was: $r8$lambda$2zAkJ_9zG03-n7chJOlK3MzApk4*/(Fragment var0, MapActivity var1, String var2, Bundle var3) {
      onAttachFragment$lambda$29(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$48bczD3zKYVpD_pGEaZztovOolM(MapActivity var0, TrackedLocation var1) {
      return setupLocationServices$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$5LpR5_02K3hBl5UlN7sryAdwHVg(MapActivity var0, TrackedLocation var1) {
      return configureSavedLocations$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5qG5ICZfJWiNQe54dHlyHMaxbsg(MapActivity var0, View var1) {
      configureSearchBar$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ENxzm8kx2SEZBM8TAreqAsMoEL8(MapActivity var0, TrackedLocation var1) {
      return configureAddLocationRxListeners$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$G_pwic_CPAHWINXmWQ5O8y27LTY/* $FF was: $r8$lambda$G-pwic-CPAHWINXmWQ5O8y27LTY*/(MapActivity var0, TrackedLocation var1, List var2, AqiData var3) {
      return configureAddLocationListeners$lambda$21$lambda$20(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$LgCGwkGM5etJ9puvlcF43LrL8cI(MapActivity var0, Pair var1) {
      return configureSavedLocations$lambda$52(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$NGAsZ20UY_IgvUedDFy0P03OXyI/* $FF was: $r8$lambda$NGAsZ20UY-IgvUedDFy0P03OXyI*/(MapActivity var0, View var1) {
      configureAddLocationButton$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$QslghU77IIepdXNPws8teeGyWE4(MapActivity var0, Ref.BooleanRef var1, TrackedLocation var2) {
      return configureSavedLocations$lambda$41(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$RKSElFzaDIX2V1B_5GG7RCcMkzk(Function1 var0, Object var1) {
      configureAddLocationRxListeners$lambda$23(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$TJDxpuOmyCvN91HxLDnughPwIhc(MapActivity var0, TrackedLocation var1, AqiData var2) {
      return configureAddLocationListeners$lambda$21$lambda$18(var0, var1, var2);
   }

   // $FF: synthetic method
   public static String $r8$lambda$UqXuw3BwqNNtkBGtMmAlm1K6yy8(MapActivity var0) {
      return localMapType_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$VzJImXA95cA6Kecfrchd0zJTwgQ(MapActivity var0) {
      return configureMode$lambda$13$lambda$12(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$cz4N4gtVPM61mKqSPVhC_syNDuQ/* $FF was: $r8$lambda$cz4N4gtVPM61mKqSPVhC-syNDuQ*/(MapActivity var0, TrackedLocation var1, List var2, AqiData var3) {
      return configureSavedLocations$lambda$37(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$eRU1DESuOOxBjiyI7IrJ9PYMw6E(MapActivity var0, View var1) {
      configureSavedLocations$lambda$40(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iOg63IgXDXnhZyL_ZOOBwDzKUgY/* $FF was: $r8$lambda$iOg63IgXDXnhZyL-ZOOBwDzKUgY*/(MapActivity var0, Pair var1) {
      return configureAddLocationListeners$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$inouQsTcO828qlBCq0jcFv4zW9g(MapActivity var0, View var1) {
      configureGPSButton$lambda$26(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mdC9NwfXoG4ExZWwfe0RnnBkCJM(MapActivity var0) {
      return configureMode$lambda$13$lambda$8(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mySrkXn05f73ENlnaWyv4En8nUQ(MapActivity var0, TrackedLocation var1, AqiData var2) {
      return configureSavedLocations$lambda$30(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$plEy7rKTvqAhg755Vw78Fyb6cLc(MapActivity var0, TrackedLocation var1, ApiResult var2) {
      return configureAddLocationListeners$lambda$21$lambda$20$lambda$19(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qA_1Od_xloBe3lcVGb7F2ozJp5s/* $FF was: $r8$lambda$qA-1Od_xloBe3lcVGb7F2ozJp5s*/(MapActivity var0, View var1) {
      configureSearchBar$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vuOa4jc8T1_wRfT_IdfyaYfIy0w(MapActivity var0, List var1) {
      return configureSavedLocations$lambda$43(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$z6BQI4sqp4KvwSoB3zdGLZ4VAlA(MapActivity var0, MapsViewModel.MapMode var1) {
      return configureMode$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$z95u9K4xOCZi2kJ2xs76XKomkXg(MapActivity var0, List var1) {
      return configureSavedLocations$lambda$51(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zb40KymkvRtzy_l4OemiJaoB7PY(MapActivity var0, View var1) {
      configureSavedLocations$lambda$39(var0, var1);
   }

   public MapActivity() {
      ComponentActivity var2 = (ComponentActivity)this;
      Function0 var1 = new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(MapsViewModel.class), new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var1, new Function0((Function0)null, var2) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      this.deviceId = "";
      this.navigateToStationIdBySearchResult = "";
      this.mapViewId = -1;
      PublishSubject var3 = PublishSubject.create();
      Intrinsics.checkNotNullExpressionValue(var3, "create(...)");
      this.currentLocationDebounceFetchedPublisher = var3;
      this.localMapType$delegate = LazyKt.lazy(new MapActivity$$ExternalSyntheticLambda18(this));
   }

   private final void addMapMarkers(List var1) {
      if (this.getViewModel().getMapIsReady()) {
         this.addMapMarkersImpl(var1);
      } else {
         this.pendingMarkers = var1;
      }
   }

   private final void animate(ConstraintLayout var1, Function0 var2) {
      ChangeBounds var3 = new ChangeBounds();
      var3.addListener(new Transition.TransitionListener(var2) {
         final Function0 $completion;

         {
            this.$completion = var1;
         }

         public void onTransitionCancel(Transition var1) {
            Intrinsics.checkNotNullParameter(var1, "transition");
         }

         public void onTransitionEnd(Transition var1) {
            Intrinsics.checkNotNullParameter(var1, "transition");
            Function0 var2 = this.$completion;
            if (var2 != null) {
               var2.invoke();
            }

         }

         // $FF: synthetic method
         public void onTransitionEnd(Transition var1, boolean var2) {
            _CC.$default$onTransitionEnd(this, var1, var2);
         }

         public void onTransitionPause(Transition var1) {
            Intrinsics.checkNotNullParameter(var1, "transition");
         }

         public void onTransitionResume(Transition var1) {
            Intrinsics.checkNotNullParameter(var1, "transition");
         }

         public void onTransitionStart(Transition var1) {
            Intrinsics.checkNotNullParameter(var1, "transition");
         }

         // $FF: synthetic method
         public void onTransitionStart(Transition var1, boolean var2) {
            _CC.$default$onTransitionStart(this, var1, var2);
         }
      });
      var3.setDuration(300L);
      TransitionManager.beginDelayedTransition((ViewGroup)var1, (Transition)var3);
   }

   // $FF: synthetic method
   static void animate$default(MapActivity var0, ConstraintLayout var1, Function0 var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         var0.animate(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animate");
      }
   }

   private final void changeSearchBarStyle() {
      TextView var3 = this.searchBar;
      Object var2 = null;
      TextView var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("searchBar");
         var1 = null;
      }

      var1.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable)null, (Drawable)null, (Drawable)null, (Drawable)null);
      var1 = this.searchBar;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("searchBar");
         var1 = (TextView)var2;
      }

      var1.setTextColor(ContextCompat.getColor((Context)this, R.color.colorPrimaryText));
   }

   private final void clearMapMarkers() {
      if (this.getViewModel().getMapIsReady()) {
         this.clearMapMarkersImpl();
      }

   }

   private final void configureAddLocationButton() {
      ((ImageButton)this.findViewById(com.blueair.outdoor.R.id.add_location_btn)).setOnClickListener(new MapActivity$$ExternalSyntheticLambda17(this));
   }

   private static final void configureAddLocationButton$lambda$16(MapActivity var0, View var1) {
      MapsViewModel.MapMode var3 = var0.getViewModel().getMode();
      int var2;
      if (var3 == null) {
         var2 = -1;
      } else {
         var2 = MapActivity.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      }

      if (var2 == 3) {
         var0.getViewModel().setNormalMode();
      } else {
         var0.getViewModel().setAddMode();
      }
   }

   private final void configureAddLocationCard() {
      View var1 = this.findViewById(com.blueair.outdoor.R.id.current_location);
      Intrinsics.checkNotNullExpressionValue(var1, "findViewById(...)");
      LocationView var2 = (LocationView)var1;
      this.currentLocationView = var2;
      LocationView var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
         var3 = null;
      }

      LocationView.bind$default(var3, (LocationItem)null, this.getMapType(), LocationView.TYPE.ADD_LOCATION, this.inAssignProductMode, this.getViewModel().isUserLoggedIn(), (Function2)null, (Function1)null, (Function3)null, 224, (Object)null);
   }

   private final void configureAddLocationListeners() {
      this.getViewModel().getAddLocationModel().observe((LifecycleOwner)this, new Observer(new MapActivity$$ExternalSyntheticLambda26(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   private static final Unit configureAddLocationListeners$lambda$21(MapActivity var0, Pair var1) {
      if (var1 != null) {
         TrackedLocation var6;
         if (var0.navigateToPrediction != null) {
            TrackedLocation var3 = (TrackedLocation)var1.getFirst();
            CustomPlace var2 = var0.navigateToPrediction;
            String var5;
            if (var2 != null) {
               var5 = var2.getAddress();
            } else {
               var5 = null;
            }

            var6 = TrackedLocation.copy$default(var3, (String)null, (double)0.0F, (double)0.0F, var5, (String)null, (String)null, (String)null, (String)null, (String)null, 503, (Object)null);
            var0.navigateToPrediction = null;
         } else {
            var6 = (TrackedLocation)var1.getFirst();
         }

         LocationView var7 = var0.currentLocationView;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
            var7 = null;
         }

         LocationView.bind$default(var7, new LocationItem(var6, (AqiData)var1.getSecond(), CollectionsKt.emptyList()), var0.getMapType(), LocationView.TYPE.ADD_LOCATION, var0.inAssignProductMode, var0.getViewModel().isUserLoggedIn(), new MapActivity$$ExternalSyntheticLambda4(var0), (Function1)null, new MapActivity$$ExternalSyntheticLambda5(var0), 64, (Object)null);
      } else {
         LocationView var4 = var0.currentLocationView;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
            var4 = null;
         }

         LocationView.bind$default(var4, (LocationItem)null, var0.getMapType(), LocationView.TYPE.NO_DATA, var0.inAssignProductMode, var0.getViewModel().isUserLoggedIn(), (Function2)null, (Function1)null, (Function3)null, 224, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureAddLocationListeners$lambda$21$lambda$18(MapActivity var0, TrackedLocation var1, AqiData var2) {
      Intrinsics.checkNotNullParameter(var1, "newLocation");
      Intrinsics.checkNotNullParameter(var2, "pollutant");
      var0.scrollToStationByAdd = var1;
      MapsViewModel.insertTrackedLocation$default(var0.getViewModel(), var1, var2, false, (Function1)null, 8, (Object)null);
      var0.getViewModel().setNormalMode();
      return Unit.INSTANCE;
   }

   private static final Unit configureAddLocationListeners$lambda$21$lambda$20(MapActivity var0, TrackedLocation var1, List var2, AqiData var3) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var2, "devices");
      if (var3 != null && ((CharSequence)var0.deviceId).length() != 0) {
         var0.getViewModel().insertTrackedLocation(var1, var3, false, new MapActivity$$ExternalSyntheticLambda21(var0, var1));
      } else {
         configureAddLocationListeners$lambda$21$lambda$20$showFailure(var0);
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureAddLocationListeners$lambda$21$lambda$20$lambda$19(MapActivity var0, TrackedLocation var1, ApiResult var2) {
      Intrinsics.checkNotNullParameter(var2, "result");
      TrackedLocation var3 = (TrackedLocation)var2.getOrNull();
      if (var2.isSuccess() && var3 != null) {
         BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, var3, (Continuation)null) {
            final TrackedLocation $location;
            final TrackedLocation $locationCreated;
            int label;
            final MapActivity this$0;

            {
               this.this$0 = var1;
               this.$location = var2;
               this.$locationCreated = var3;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$location, this.$locationCreated, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var4;
               label32: {
                  var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                           return Unit.INSTANCE;
                        }

                        ResultKt.throwOnFailure(var1);
                        break label32;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     this.this$0.scrollToStationByAdd = this.$location;
                     MapsViewModel var8 = this.this$0.getViewModel();
                     String var6 = this.$locationCreated.getId();
                     List var7 = CollectionsKt.listOf(this.this$0.deviceId);
                     List var3 = CollectionsKt.emptyList();
                     Continuation var5 = (Continuation)this;
                     this.label = 1;
                     Object var11 = var8.setLocationDevices(var6, var7, var3, var5);
                     var1 = var11;
                     if (var11 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var12 = (ApiResult)var1;
                  Function2 var9 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final MapActivity this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                     }

                     public final Object invoke(ResponseBody var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           CoroutineContext var6 = (CoroutineContext)Dispatchers.getMain();
                           Function2 var4 = new Function2(this.this$0, (Continuation)null) {
                              int label;
                              final MapActivity this$0;

                              {
                                 this.this$0 = var1;
                              }

                              public final Continuation create(Object var1, Continuation var2) {
                                 return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                              }

                              public final Object invoke(CoroutineScope var1, Continuation var2) {
                                 return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 if (this.label == 0) {
                                    ResultKt.throwOnFailure(var1);
                                    this.this$0.setShouldShowAssignProduct(false);
                                    this.this$0.getViewModel().setNormalMode();
                                    return Unit.INSTANCE;
                                 } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }
                              }
                           };
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           if (BuildersKt.withContext(var6, var4, var5) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  Continuation var15 = (Continuation)this;
                  this.label = 2;
                  Object var13 = ApiResultKt.onSuccess(var12, var9, var15);
                  var1 = var13;
                  if (var13 == var4) {
                     return var4;
                  }
               }

               ApiResult var10 = (ApiResult)var1;
               Function2 var16 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final MapActivity this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                  }

                  public final Object invoke(Throwable var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        CoroutineContext var4 = (CoroutineContext)Dispatchers.getMain();
                        Function2 var6 = new Function2(this.this$0, (Continuation)null) {
                           int label;
                           final MapActivity this$0;

                           {
                              this.this$0 = var1;
                           }

                           public final Continuation create(Object var1, Continuation var2) {
                              return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                           }

                           public final Object invoke(CoroutineScope var1, Continuation var2) {
                              return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                           }

                           public final Object invokeSuspend(Object var1) {
                              IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              if (this.label == 0) {
                                 ResultKt.throwOnFailure(var1);
                                 MapActivity.configureAddLocationListeners$lambda$21$lambda$20$showFailure(this.this$0);
                                 return Unit.INSTANCE;
                              } else {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }
                           }
                        };
                        Continuation var5 = (Continuation)this;
                        this.label = 1;
                        if (BuildersKt.withContext(var4, var6, var5) == var3) {
                           return var3;
                        }
                     }

                     return Unit.INSTANCE;
                  }
               };
               Continuation var14 = (Continuation)this;
               this.label = 3;
               if (ApiResultKt.onFail(var10, var16, var14) == var4) {
                  return var4;
               } else {
                  return Unit.INSTANCE;
               }
            }
         }, 2, (Object)null);
      } else {
         configureAddLocationListeners$lambda$21$lambda$20$showFailure(var0);
      }

      return Unit.INSTANCE;
   }

   private static final void configureAddLocationListeners$lambda$21$lambda$20$showFailure(MapActivity var0) {
      LocationView var2 = var0.currentLocationView;
      LocationView var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
         var1 = null;
      }

      FrameLayout var3 = var1.getBinding().progressBar;
      Intrinsics.checkNotNullExpressionValue(var3, "progressBar");
      ViewExtensionsKt.hide((View)var3);
      ToastUtils.showCenterToast$default(ToastUtils.INSTANCE, (Context)var0, R.string.request_failed, 0, 4, (Object)null);
   }

   private final void configureAddLocationRxListeners() {
      this.getRxSubs().add(this.currentLocationDebounceFetchedPublisher.debounce(1200L, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread()).subscribe(new MapActivity$$ExternalSyntheticLambda2(new MapActivity$$ExternalSyntheticLambda1(this))));
   }

   private static final Unit configureAddLocationRxListeners$lambda$22(MapActivity var0, TrackedLocation var1) {
      LocationView var3 = var0.currentLocationView;
      LocationView var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentLocationView");
         var2 = null;
      }

      LocationView.bind$default(var2, (LocationItem)null, var0.getMapType(), LocationView.TYPE.ADD_LOCATION, var0.inAssignProductMode, var0.getViewModel().isUserLoggedIn(), (Function2)null, (Function1)null, (Function3)null, 224, (Object)null);
      var0.getViewModel().fetchAirQuality(var1.getLat(), var1.getLon(), var0.getLocalMapType());
      return Unit.INSTANCE;
   }

   private static final void configureAddLocationRxListeners$lambda$23(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private final void configureGPSButton() {
      ((ImageButton)this.findViewById(com.blueair.outdoor.R.id.gps_btn)).setOnClickListener(new MapActivity$$ExternalSyntheticLambda22(this));
      this.getViewModel().getCurrentLocation().observe((LifecycleOwner)this, new Observer(new MapActivity$$ExternalSyntheticLambda23(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   private static final void configureGPSButton$lambda$26(MapActivity var0, View var1) {
      Timber.Forest.d("OnGPSClick", new Object[0]);
      Iterator var2 = ((Iterable)var0.getViewModel().getMarkers().entrySet()).iterator();

      do {
         if (!var2.hasNext()) {
            var3 = null;
            break;
         }

         var3 = var2.next();
      } while(!Intrinsics.areEqual(((Map.Entry)var3).getValue(), "current"));

      Map.Entry var4 = (Map.Entry)var3;
      if (var4 != null) {
         var0.onMarkerTapped((String)var4.getKey());
      }

   }

   private static final Unit configureGPSButton$lambda$27(MapActivity var0, TrackedLocation var1) {
      if (var1 == null) {
         View var2 = var0.findViewById(com.blueair.outdoor.R.id.gps_btn);
         Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
         ViewExtensionsKt.hide(var2);
      } else {
         View var3 = var0.findViewById(com.blueair.outdoor.R.id.gps_btn);
         Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
         ViewExtensionsKt.show$default(var3, false, 1, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private final void configureMode() {
      this.getViewModel().getMode().observe((LifecycleOwner)this, new Observer(new MapActivity$$ExternalSyntheticLambda3(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   private static final Unit configureMode$lambda$13(MapActivity var0, MapsViewModel.MapMode var1) {
      int var2;
      if (var1 == null) {
         var2 = -1;
      } else {
         var2 = MapActivity.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
      }

      Object var3 = null;
      if (var2 != 1) {
         if (var2 != 2) {
            if (var2 == 3) {
               TrackedLocation var4 = var0.getViewModel().getCurrentlyViewedLocation();
               if (var4 != null) {
                  var0.updateAirQualityIfNeeded(var4.getLat(), var4.getLon());
               }

               ImageButton var5 = (ImageButton)var0.findViewById(com.blueair.outdoor.R.id.add_location_btn);
               var5.setImageResource(R.drawable.ic_close);
               var5.setContentDescription((CharSequence)var0.getString(R.string.remove_pin_content_description));
               View var6 = var0.findViewById(com.blueair.outdoor.R.id.pin);
               Intrinsics.checkNotNullExpressionValue(var6, "findViewById(...)");
               ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
               String var7 = var0.getSelectedMarkerId();
               if (var7 != null) {
                  var0.styleMarker(var7, false, var0.isCurrentLocationSelected());
                  var0.selectedLocationId = null;
               }

               var0.hideCard(com.blueair.outdoor.R.id.saved_location_recycler_view, new MapActivity$$ExternalSyntheticLambda11(var0));
            }
         } else {
            Button var8 = var0.maximizeButton;
            if (var8 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("maximizeButton");
               var8 = (Button)var3;
            }

            ViewExtensionsKt.hide((View)var8);
            var0.enableSavedLocationScrolling();
            ImageButton var9 = (ImageButton)var0.findViewById(com.blueair.outdoor.R.id.add_location_btn);
            var9.setImageResource(R.drawable.ic_location_marker_plus);
            var9.setContentDescription((CharSequence)var0.getString(R.string.add_pin_content_description));
            View var10 = var0.findViewById(com.blueair.outdoor.R.id.pin);
            Intrinsics.checkNotNullExpressionValue(var10, "findViewById(...)");
            ViewExtensionsKt.hide(var10);
            var0.hideCard(com.blueair.outdoor.R.id.current_location, new MapActivity$$ExternalSyntheticLambda0(var0));
         }
      } else {
         var0.disableSavedLocationScrolling();
         Button var12 = var0.maximizeButton;
         Button var11 = var12;
         if (var12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("maximizeButton");
            var11 = null;
         }

         ViewExtensionsKt.show$default((View)var11, false, 1, (Object)null);
         showMinimizedCard$default(var0, com.blueair.outdoor.R.id.saved_location_recycler_view, (Function0)null, 2, (Object)null);
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureMode$lambda$13$lambda$12(MapActivity var0) {
      showCard$default(var0, com.blueair.outdoor.R.id.current_location, (Function0)null, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit configureMode$lambda$13$lambda$8(MapActivity var0) {
      LocationAdapter var2 = var0.locationAdapter;
      LocationAdapter var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var1 = null;
      }

      if (((Collection)var1.getMergedData()).isEmpty()) {
         var2 = var0.locationAdapter;
         var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            var1 = null;
         }

         if (!var1.getShowCurrentLocation()) {
            return Unit.INSTANCE;
         }
      }

      showCard$default(var0, com.blueair.outdoor.R.id.saved_location_recycler_view, (Function0)null, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private final void configureSavedLocations() {
      View var1 = this.findViewById(com.blueair.outdoor.R.id.saved_location_recycler_view);
      Intrinsics.checkNotNullExpressionValue(var1, "findViewById(...)");
      this.recyclerView = (RecyclerView)var1;
      Context var5 = (Context)this;
      this.locationAdapter = new LocationAdapter(var5, this.getMapType(), this.shouldShowAssignProduct, this.getViewModel().isUserLoggedIn(), new MapActivity$$ExternalSyntheticLambda6(this), new MapActivity$$ExternalSyntheticLambda7(this), new MapActivity$$ExternalSyntheticLambda8(this));
      this.locationLinearLayoutManager = new LocationLinearLayoutManager(var5, 0, false);
      RecyclerView var2 = this.recyclerView;
      Object var3 = null;
      RecyclerView var6 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
         var6 = null;
      }

      LocationAdapter var4 = this.locationAdapter;
      LocationAdapter var13 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var13 = null;
      }

      var6.setAdapter(var13);
      LocationLinearLayoutManager var20 = this.locationLinearLayoutManager;
      LocationLinearLayoutManager var14 = var20;
      if (var20 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationLinearLayoutManager");
         var14 = null;
      }

      var6.setLayoutManager((RecyclerView.LayoutManager)var14);
      PagerSnapHelper var15 = new PagerSnapHelper();
      Ref.BooleanRef var21 = new Ref.BooleanRef();
      var21.element = true;
      var6 = this.recyclerView;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
         var6 = null;
      }

      RecyclerExtensionsKt.attachSnapHelperWithListener$default(var6, (SnapHelper)var15, (SnapOnScrollListener.Behavior)null, new SnapOnScrollListener.OnSnapPositionChangeListener(var21, this) {
         final Ref.BooleanRef $skipScroll;
         final MapActivity this$0;

         {
            this.$skipScroll = var1;
            this.this$0 = var2;
         }

         public void onSnapPositionChange(int var1) {
            if (!this.$skipScroll.element) {
               this.this$0.getViewModel().getSavedLocationViewIndex().setValue(new Pair(var1, false));
            }

            this.$skipScroll.element = false;
         }
      }, 2, (Object)null);
      LocationPageIndicatorItemDecorator var22 = new LocationPageIndicatorItemDecorator(var5);
      RecyclerView var16 = this.recyclerView;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
         var6 = null;
      }

      var6.addItemDecoration(var22);
      var16 = this.recyclerView;
      var6 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
         var6 = null;
      }

      var6.setOnClickListener(new MapActivity$$ExternalSyntheticLambda9(this));
      View var10 = this.findViewById(com.blueair.outdoor.R.id.saved_location_maximize_button);
      Intrinsics.checkNotNullExpressionValue(var10, "findViewById(...)");
      Button var11 = (Button)var10;
      this.maximizeButton = var11;
      if (var11 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("maximizeButton");
         var11 = (Button)var3;
      }

      var11.setOnClickListener(new MapActivity$$ExternalSyntheticLambda10(this));
      Ref.BooleanRef var19 = new Ref.BooleanRef();
      LiveData var18 = this.getViewModel().getCurrentLocation();
      LifecycleOwner var12 = (LifecycleOwner)this;
      var18.observe(var12, new Observer(new MapActivity$$ExternalSyntheticLambda12(this, var19)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getAllLocations().observe(var12, new Observer(new MapActivity$$ExternalSyntheticLambda13(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      LiveDataExtensionsKt.observeNonNull((LiveData)this.getViewModel().getCurrentLocationWithPollutants(), var12, new MapActivity$$ExternalSyntheticLambda14(this));
      this.getViewModel().getTrackedLocationWithPollutants().observe(var12, new Observer(new MapActivity$$ExternalSyntheticLambda15(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.getViewModel().getSavedLocationViewIndex().observe(var12, new Observer(new MapActivity$$ExternalSyntheticLambda16(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   private static final Unit configureSavedLocations$lambda$30(MapActivity var0, TrackedLocation var1, AqiData var2) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var2, "pollutant");
      var0.scrollToStationByAdd = var1;
      MapsViewModel.insertTrackedLocation$default(var0.getViewModel(), var1, var2, true, (Function1)null, 8, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit configureSavedLocations$lambda$31(MapActivity var0, TrackedLocation var1) {
      Intrinsics.checkNotNullParameter(var1, "onDeleteLocation");
      ConfirmationDialogCentered var3 = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.outdoor_delete_location_title, R.string.outdoor_delete_location_content, R.string.outdoor_delete_location_confirm, R.string.confirmation_negative_default, true, false, false, (String[])null, 224, (Object)null);
      Bundle var2 = var3.getArguments();
      if (var2 != null) {
         var2.putParcelable("location", var1);
      }

      var3.show(var0.getSupportFragmentManager(), "Dialog");
      return Unit.INSTANCE;
   }

   private static final Unit configureSavedLocations$lambda$37(MapActivity var0, TrackedLocation var1, List var2, AqiData var3) {
      Intrinsics.checkNotNullParameter(var1, "location");
      Intrinsics.checkNotNullParameter(var2, "devices");
      if (var0.shouldShowAssignProduct) {
         Pair var8 = (Pair)var0.getViewModel().getSavedLocationViewIndex().getValue();
         Integer var9;
         if (var8 != null) {
            var9 = (Integer)var8.getFirst();
         } else {
            var9 = null;
         }

         if (((CharSequence)var0.deviceId).length() > 0) {
            BuildersKt.launch$default(var0.getViewModel(), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, var9, (Continuation)null) {
               final Integer $currentIndex;
               final TrackedLocation $location;
               int label;
               final MapActivity this$0;

               {
                  this.this$0 = var1;
                  this.$location = var2;
                  this.$currentIndex = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$location, this.$currentIndex, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var4;
                  label32: {
                     var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           if (var2 != 2) {
                              if (var2 != 3) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           }

                           ResultKt.throwOnFailure(var1);
                           break label32;
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        MapsViewModel var5 = this.this$0.getViewModel();
                        String var7 = this.$location.getId();
                        List var3 = CollectionsKt.listOf(this.this$0.deviceId);
                        List var8 = CollectionsKt.emptyList();
                        Continuation var6 = (Continuation)this;
                        this.label = 1;
                        Object var11 = var5.setLocationDevices(var7, var3, var8, var6);
                        var1 = var11;
                        if (var11 == var4) {
                           return var4;
                        }
                     }

                     ApiResult var9 = (ApiResult)var1;
                     Function2 var12 = new Function2(this.this$0, (Continuation)null) {
                        int label;
                        final MapActivity this$0;

                        {
                           this.this$0 = var1;
                        }

                        public final Continuation create(Object var1, Continuation var2) {
                           return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                        }

                        public final Object invoke(ResponseBody var1, Continuation var2) {
                           return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object var1) {
                           Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                           int var2 = this.label;
                           if (var2 != 0) {
                              if (var2 != 1) {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }

                              ResultKt.throwOnFailure(var1);
                           } else {
                              ResultKt.throwOnFailure(var1);
                              CoroutineContext var4 = (CoroutineContext)Dispatchers.getMain();
                              Function2 var5 = new Function2(this.this$0, (Continuation)null) {
                                 int label;
                                 final MapActivity this$0;

                                 {
                                    this.this$0 = var1;
                                 }

                                 public final Continuation create(Object var1, Continuation var2) {
                                    return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                                 }

                                 public final Object invoke(CoroutineScope var1, Continuation var2) {
                                    return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                                 }

                                 public final Object invokeSuspend(Object var1) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label == 0) {
                                       ResultKt.throwOnFailure(var1);
                                       this.this$0.setShouldShowAssignProduct(false);
                                       return Unit.INSTANCE;
                                    } else {
                                       throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                 }
                              };
                              Continuation var6 = (Continuation)this;
                              this.label = 1;
                              if (BuildersKt.withContext(var4, var5, var6) == var3) {
                                 return var3;
                              }
                           }

                           return Unit.INSTANCE;
                        }
                     };
                     Continuation var15 = (Continuation)this;
                     this.label = 2;
                     Object var13 = ApiResultKt.onSuccess(var9, var12, var15);
                     var1 = var13;
                     if (var13 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var10 = (ApiResult)var1;
                  Function2 var14 = new Function2(this.$currentIndex, this.this$0, (Continuation)null) {
                     final Integer $currentIndex;
                     int label;
                     final MapActivity this$0;

                     {
                        this.$currentIndex = var1;
                        this.this$0 = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.$currentIndex, this.this$0, var2));
                     }

                     public final Object invoke(Throwable var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 != 1) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                        } else {
                           ResultKt.throwOnFailure(var1);
                           CoroutineContext var4 = (CoroutineContext)Dispatchers.getMain();
                           Function2 var5 = new Function2(this.$currentIndex, this.this$0, (Continuation)null) {
                              final Integer $currentIndex;
                              int label;
                              final MapActivity this$0;

                              {
                                 this.$currentIndex = var1;
                                 this.this$0 = var2;
                              }

                              public final Continuation create(Object var1, Continuation var2) {
                                 return (Continuation)(new <anonymous constructor>(this.$currentIndex, this.this$0, var2));
                              }

                              public final Object invoke(CoroutineScope var1, Continuation var2) {
                                 return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 if (this.label == 0) {
                                    ResultKt.throwOnFailure(var1);
                                    MapActivity.configureSavedLocations$lambda$37$showFailure$33(this.$currentIndex, this.this$0);
                                    return Unit.INSTANCE;
                                 } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }
                              }
                           };
                           Continuation var6 = (Continuation)this;
                           this.label = 1;
                           if (BuildersKt.withContext(var4, var5, var6) == var3) {
                              return var3;
                           }
                        }

                        return Unit.INSTANCE;
                     }
                  };
                  Continuation var16 = (Continuation)this;
                  this.label = 3;
                  if (ApiResultKt.onFail(var10, var14, var16) == var4) {
                     return var4;
                  } else {
                     return Unit.INSTANCE;
                  }
               }
            }, 2, (Object)null);
         } else {
            configureSavedLocations$lambda$37$showFailure$33(var9, var0);
         }
      } else {
         List var12 = (List)var0.getViewModel().getDevices().getValue();
         if (var12 != null) {
            Iterable var4 = (Iterable)var12;
            Collection var13 = (Collection)(new ArrayList());

            for(Object var5 : var4) {
               if (var5 instanceof HasLocation) {
                  var13.add(var5);
               }
            }

            if (!((List)var13).isEmpty()) {
               FragmentManager var15 = var0.getSupportFragmentManager();
               Intrinsics.checkNotNullExpressionValue(var15, "getSupportFragmentManager(...)");
               Intrinsics.checkNotNullExpressionValue("AssignProductDialogFragment", "getSimpleName(...)");
               if (!(var15.findFragmentByTag("AssignProductDialogFragment") instanceof AssignProductDialogFragment) && !var15.isStateSaved()) {
                  AssignProductDialogFragment.Companion var6 = AssignProductDialogFragment.Companion;
                  var4 = (Iterable)var2;
                  Collection var11 = (Collection)(new ArrayList());

                  for(Object var19 : var4) {
                     if (var19 instanceof HasLocation) {
                        var11.add(var19);
                     }
                  }

                  ((DialogFragment)var6.newInstance(var1, (List)var11)).show(var15, "AssignProductDialogFragment");
               }

               return Unit.INSTANCE;
            }
         }

         FragmentManager var14 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var14, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("AssignProductNoDeviceDialogFragment", "getSimpleName(...)");
         if (!(var14.findFragmentByTag("AssignProductNoDeviceDialogFragment") instanceof AssignProductNoDeviceDialogFragment) && !var14.isStateSaved()) {
            AssignProductNoDeviceDialogFragment.Companion var17 = AssignProductNoDeviceDialogFragment.Companion;
            String var10 = var1.getLocationName();
            String var7 = var10;
            if (var10 == null) {
               var7 = var0.getString(R.string.unknown_station_name_placeholder);
               Intrinsics.checkNotNullExpressionValue(var7, "getString(...)");
            }

            ((DialogFragment)var17.newInstance(var7)).show(var14, "AssignProductNoDeviceDialogFragment");
         }
      }

      return Unit.INSTANCE;
   }

   private static final void configureSavedLocations$lambda$37$showFailure$33(Integer var0, MapActivity var1) {
      if (var0 != null) {
         ((Number)var0).intValue();
         LocationAdapter var3 = var1.locationAdapter;
         LocationAdapter var2 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            var2 = null;
         }

         var2.notifyItemChanged(var0);
      }

      ToastUtils.showCenterToast$default(ToastUtils.INSTANCE, (Context)var1, R.string.request_failed, 0, 4, (Object)null);
   }

   private static final void configureSavedLocations$lambda$39(MapActivity var0, View var1) {
      if (var0.getViewModel().getMode() == MapsViewModel.MapMode.MINIMIZED) {
         var0.getViewModel().setNormalMode();
      }

   }

   private static final void configureSavedLocations$lambda$40(MapActivity var0, View var1) {
      var0.getViewModel().setNormalMode();
   }

   private static final Unit configureSavedLocations$lambda$41(MapActivity var0, Ref.BooleanRef var1, TrackedLocation var2) {
      if (!var0.startedForSearchMode && !var1.element && !var0.getShouldNavigateToStationByIntent() && var2 != null && var0.getViewModel().isUserLoggedIn()) {
         var1.element = true;
         var0.getViewModel().viewLocation(var2.getLat(), var2.getLon(), var2.getMapType());
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureSavedLocations$lambda$43(MapActivity var0, List var1) {
      var0.clearMapMarkers();
      Intrinsics.checkNotNull(var1);
      var0.addMapMarkers(var1);
      String var2 = var0.getSelectedMarkerId();
      if (var2 != null) {
         var0.styleMarker(var2, true, var0.isCurrentLocationSelected());
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureSavedLocations$lambda$44(MapActivity var0, LocationItem var1) {
      LocationAdapter var3 = var0.locationAdapter;
      LocationAdapter var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var2 = null;
      }

      var2.setMergedCurrentLocation(var1);
      if (var0.navigateToCurrentLocation && !var0.hasInitiallyNavigateToStation) {
         var0.moveToLocation("current");
         var0.getViewModel().setNormalMode();
         var0.hasInitiallyNavigateToStation = true;
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureSavedLocations$lambda$51(MapActivity var0, List var1) {
      LocationAdapter var8 = var0.locationAdapter;
      Object var7 = null;
      Object var6 = null;
      LocationAdapter var5 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var5 = null;
      }

      List var9 = var5.getMergedData();
      var8 = var0.locationAdapter;
      var5 = var8;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var5 = null;
      }

      Intrinsics.checkNotNull(var1);
      var5.setMergedData(var1);
      if (var0.getShouldNavigateToStationByIntent() && !var0.hasInitiallyNavigateToStation && !var0.navigateToCurrentLocation && !((Collection)var1).isEmpty()) {
         String var16 = var0.navigateToStationByIntent;
         Intrinsics.checkNotNull(var16);
         var0.moveToLocation(var16);
         var0.getViewModel().setNormalMode();
         var0.hasInitiallyNavigateToStation = true;
      } else {
         TrackedLocation var20 = var0.scrollToStationByAdd;
         byte var3 = -1;
         if (var20 != null) {
            if (var20 != null) {
               Iterator var11 = var1.iterator();
               int var2 = 0;

               int var4;
               while(true) {
                  var4 = var3;
                  if (!var11.hasNext()) {
                     break;
                  }

                  TrackedLocation var23 = ((LocationItem)var11.next()).getLocation();
                  if (var23.getLat() == var20.getLat() && var23.getLon() == var20.getLon()) {
                     var4 = var2;
                     break;
                  }

                  ++var2;
               }

               if (var4 >= 0) {
                  var0.scrollToStationByAdd = null;
                  LocationAdapter var21 = var0.locationAdapter;
                  LocationAdapter var12 = var21;
                  if (var21 == null) {
                     Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                     var12 = null;
                  }

                  moveToLocation$default(var0, var4 + var12.getShowCurrentLocation(), false, 2, (Object)null);
               }
            }
         } else {
            TrackedLocation var13 = var0.scrollToStationByDelete;
            if (var13 != null && var13 != null) {
               var0.scrollToStationByDelete = null;
               Iterator var22 = var9.iterator();
               int var17 = 0;

               int var18;
               while(true) {
                  var18 = var3;
                  if (!var22.hasNext()) {
                     break;
                  }

                  if (Intrinsics.areEqual(((LocationItem)var22.next()).getLocation().getId(), var13.getId())) {
                     var18 = var17;
                     break;
                  }

                  ++var17;
               }

               if (var18 >= 0) {
                  if (var18 < var9.size() - 1) {
                     MutableLiveData var14 = var0.getViewModel().getSavedLocationViewIndex();
                     LocationAdapter var10 = var0.locationAdapter;
                     if (var10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                        var10 = (LocationAdapter)var6;
                     }

                     var14.setValue(new Pair(var18 + var10.getShowCurrentLocation(), false));
                  } else if (var18 == 0) {
                     LocationAdapter var15 = var0.locationAdapter;
                     if (var15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
                        var15 = (LocationAdapter)var7;
                     }

                     if (var15.getShowCurrentLocation()) {
                        var0.getViewModel().getSavedLocationViewIndex().setValue(new Pair(0, false));
                     }
                  }
               }
            }
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit configureSavedLocations$lambda$52(MapActivity var0, Pair var1) {
      var0.moveToLocation(((Number)var1.getFirst()).intValue(), (Boolean)var1.getSecond());
      return Unit.INSTANCE;
   }

   private final void configureSearchBar() {
      View var1 = this.findViewById(com.blueair.outdoor.R.id.search_bar);
      Intrinsics.checkNotNullExpressionValue(var1, "findViewById(...)");
      TextView var2 = (TextView)var1;
      this.searchBar = var2;
      TextView var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("searchBar");
         var3 = null;
      }

      var3.setOnClickListener(new MapActivity$$ExternalSyntheticLambda24(this));
      View var4 = this.findViewById(com.blueair.outdoor.R.id.close_btn);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      ((ImageButton)var4).setOnClickListener(new MapActivity$$ExternalSyntheticLambda25(this));
   }

   private static final void configureSearchBar$lambda$14(MapActivity var0, View var1) {
      var0.startSearchIntent();
   }

   private static final void configureSearchBar$lambda$15(MapActivity var0, View var1) {
      var0.finish();
   }

   private final void configureUsingIntentParameters() {
      if (this.startedForSearchMode) {
         this.startSearchIntent();
      }

   }

   private final void disableSavedLocationScrolling() {
      RecyclerView var2 = this.recyclerView;
      RecyclerView var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
         var1 = null;
      }

      RecyclerView.LayoutManager var3 = var1.getLayoutManager();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager");
      ((LocationLinearLayoutManager)var3).setScrollingEnabled(false);
   }

   private final void enableSavedLocationScrolling() {
      RecyclerView var2 = this.recyclerView;
      RecyclerView var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
         var1 = null;
      }

      RecyclerView.LayoutManager var3 = var1.getLayoutManager();
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.outdoor.ui.adapters.LocationLinearLayoutManager");
      ((LocationLinearLayoutManager)var3).setScrollingEnabled(true);
   }

   private final String getSelectedMarkerId() {
      String var2 = this.selectedLocationId;
      if (var2 != null) {
         Iterator var3 = ((Iterable)this.getViewModel().getMarkers().entrySet()).iterator();

         Object var1;
         do {
            if (!var3.hasNext()) {
               var1 = null;
               break;
            }

            var1 = var3.next();
         } while(!Intrinsics.areEqual(((Map.Entry)var1).getValue(), var2));

         Map.Entry var4 = (Map.Entry)var1;
         if (var4 != null) {
            return (String)var4.getKey();
         }
      }

      return null;
   }

   private final boolean getShouldNavigateToStationIdBySearchResult() {
      return Intrinsics.areEqual(this.navigateToStationIdBySearchResult, "") ^ true;
   }

   private final void gotoLocation(TrackedLocation var1) {
      this.gotoLocation(var1, 16.0F);
   }

   private final void gotoLocation(TrackedLocation var1, float var2) {
      String var6 = this.getSelectedMarkerId();
      int var3 = 0;
      if (var6 != null) {
         this.styleMarker(var6, false, this.isCurrentLocationSelected());
      }

      List var7 = (List)this.getViewModel().getAllLocations().getValue();
      byte var5 = -1;
      int var4 = var5;
      if (var7 != null) {
         Iterator var8 = var7.iterator();

         while(true) {
            var4 = var5;
            if (!var8.hasNext()) {
               break;
            }

            if (Intrinsics.areEqual(((TrackedLocation)var8.next()).getId(), var1.getId())) {
               var4 = var3;
               break;
            }

            ++var3;
         }
      }

      if (var4 >= 0) {
         this.selectedLocationId = var1.getId();
         String var9 = this.getSelectedMarkerId();
         if (var9 != null) {
            this.styleMarker(var9, true, this.isCurrentLocationSelected());
         }
      }

      if (this.getViewModel().getMapIsReady()) {
         this.gotoLocationImpl(var1, var2);
      } else {
         this.pendingGotoLocation = new Pair(var1, var2);
      }
   }

   private final void hideCard(int var1, Function0 var2) {
      ConstraintLayout var3 = (ConstraintLayout)this.findViewById(com.blueair.outdoor.R.id.constraint_layout);
      ConstraintSet var4 = new ConstraintSet();
      var4.clone(var3);
      if (var4.getConstraint(var1).layout.topToBottom == 0) {
         if (var2 != null) {
            var2.invoke();
         }

      } else {
         var4.clear(var1, 3);
         var4.clear(var1, 4);
         var4.connect(var1, 3, 0, 4);
         Intrinsics.checkNotNull(var3);
         this.animate(var3, var2);
         var4.applyTo(var3);
      }
   }

   // $FF: synthetic method
   static void hideCard$default(MapActivity var0, int var1, Function0 var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         var0.hideCard(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: hideCard");
      }
   }

   private final boolean isCurrentLocationSelected() {
      return Intrinsics.areEqual(this.selectedLocationId, "current");
   }

   private static final String localMapType_delegate$lambda$0(MapActivity var0) {
      return Intrinsics.areEqual(var0.getMapType(), "WGS") ? "WGS_LOCAL" : "GCJ_LOCAL";
   }

   private final void moveToLocation(int var1, boolean var2) {
      LocationAdapter var7 = this.locationAdapter;
      Object var6 = null;
      LocationAdapter var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var5 = null;
      }

      int var3 = ((Collection)var5.getMergedData()).size();
      var7 = this.locationAdapter;
      var5 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var5 = null;
      }

      byte var4 = var5.getShowCurrentLocation();
      if (var1 >= 0 && var1 < var3 + var4) {
         if (var2) {
            LocationLinearLayoutManager var12 = this.locationLinearLayoutManager;
            LocationLinearLayoutManager var9 = var12;
            if (var12 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("locationLinearLayoutManager");
               var9 = null;
            }

            var9.scrollToPosition(var1);
         }

         var5 = this.locationAdapter;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            var5 = (LocationAdapter)var6;
         }

         this.gotoLocation(var5.getItem(var1).getLocation());
      }

   }

   private final void moveToLocation(String var1) {
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("moveToLocation: stationId = ");
      var7.append(var1);
      var7.append(", locationAdapter.showCurrentLocation = ");
      LocationAdapter var5 = this.locationAdapter;
      Object var4 = null;
      LocationAdapter var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var3 = null;
      }

      var7.append(var3.getShowCurrentLocation());
      var7.append(", mergedCurrentLocation.first.stationId = ");
      var5 = this.locationAdapter;
      var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var3 = null;
      }

      label76: {
         LocationItem var10 = var3.getMergedCurrentLocation();
         if (var10 != null) {
            TrackedLocation var11 = var10.getLocation();
            if (var11 != null) {
               var12 = var11.getId();
               break label76;
            }
         }

         var12 = null;
      }

      var7.append(var12);
      String var13 = var7.toString();
      int var2 = 0;
      var6.d(var13, new Object[0]);
      var5 = this.locationAdapter;
      LocationAdapter var14 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var14 = null;
      }

      if (var14.getShowCurrentLocation()) {
         var5 = this.locationAdapter;
         var14 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            var14 = null;
         }

         label67: {
            LocationItem var16 = var14.getMergedCurrentLocation();
            if (var16 != null) {
               TrackedLocation var17 = var16.getLocation();
               if (var17 != null) {
                  var18 = var17.getId();
                  break label67;
               }
            }

            var18 = null;
         }

         if (Intrinsics.areEqual(var18, var1)) {
            this.getViewModel().getSavedLocationViewIndex().setValue(new Pair(0, true));
         }
      }

      if (this.navigateToCurrentLocation) {
         var5 = this.locationAdapter;
         var14 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            var14 = null;
         }

         if (var14.getShowCurrentLocation()) {
            this.getViewModel().getSavedLocationViewIndex().setValue(new Pair(0, true));
            return;
         }
      }

      var5 = this.locationAdapter;
      var14 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
         var14 = null;
      }

      Iterator var21 = var14.getMergedData().iterator();

      while(true) {
         if (!var21.hasNext()) {
            var2 = -1;
            break;
         }

         if (Intrinsics.areEqual(((LocationItem)var21.next()).getLocation().getId(), var1)) {
            break;
         }

         ++var2;
      }

      if (var2 >= 0) {
         MutableLiveData var22 = this.getViewModel().getSavedLocationViewIndex();
         LocationAdapter var8 = this.locationAdapter;
         if (var8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
            var8 = (LocationAdapter)var4;
         }

         var22.setValue(new Pair(var2 + var8.getShowCurrentLocation(), true));
      }

   }

   // $FF: synthetic method
   static void moveToLocation$default(MapActivity var0, int var1, boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = true;
         }

         var0.moveToLocation(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToLocation");
      }
   }

   private final void navigateToPredictionFromSearchActivityIfNeeded() {
      CustomPlace var3 = this.navigateToPrediction;
      if (var3 != null) {
         TextView var2 = this.searchBar;
         TextView var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchBar");
            var1 = null;
         }

         var1.setText((CharSequence)var3.getAddress());
         this.getViewModel().viewLocation(var3.getLat(), var3.getLng(), this.getLocalMapType());
         this.getViewModel().setAddMode();
      }

   }

   private final void navigateToStationFromSearchActivityIfNeeded() {
      if (this.getShouldNavigateToStationIdBySearchResult()) {
         this.moveToLocation(this.navigateToStationIdBySearchResult);
         this.getViewModel().getMode().setValue(MapsViewModel.MapMode.SAVED_LOCATIONS);
         this.navigateToStationIdBySearchResult = "";
      }

   }

   private static final void onAttachFragment$lambda$29(Fragment var0, MapActivity var1, String var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "result");
      if (var3.getBoolean("IS_CONFIRMED")) {
         Bundle var4 = ((ConfirmationDialogCentered)var0).getArguments();
         if (var4 != null) {
            TrackedLocation var5 = (TrackedLocation)var4.getParcelable("location");
            if (var5 != null) {
               var1.scrollToStationByDelete = var5;
               var1.getViewModel().deleteLocation(var5);
            }
         }
      }

   }

   private final void setShouldShowAssignProduct(boolean var1) {
      if (this.shouldShowAssignProduct != var1) {
         this.shouldShowAssignProduct = var1;
         LocationAdapter var3 = this.locationAdapter;
         if (var3 != null) {
            LocationAdapter var2 = var3;
            if (var3 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("locationAdapter");
               var2 = null;
            }

            var2.setShowAssignProduct(var1);
         }
      }

   }

   private static final Unit setupLocationServices$lambda$6(MapActivity var0, TrackedLocation var1) {
      if (var1 != null) {
         var0.gotoLocation(var1);
      }

      return Unit.INSTANCE;
   }

   private final void showCard(int var1, Function0 var2) {
      ConstraintLayout var4 = (ConstraintLayout)this.findViewById(com.blueair.outdoor.R.id.constraint_layout);
      ConstraintSet var3 = new ConstraintSet();
      var3.clone(var4);
      if (var3.getConstraint(var1).layout.bottomToTop == com.blueair.outdoor.R.id.root_bottom_guideline) {
         if (var2 != null) {
            var2.invoke();
         }

      } else {
         var3.clear(var1, 3);
         var3.clear(var1, 4);
         var3.connect(var1, 4, com.blueair.outdoor.R.id.root_bottom_guideline, 3);
         Intrinsics.checkNotNull(var4);
         this.animate(var4, var2);
         var3.applyTo(var4);
      }
   }

   // $FF: synthetic method
   static void showCard$default(MapActivity var0, int var1, Function0 var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         var0.showCard(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showCard");
      }
   }

   private final void showMinimizedCard(int var1, Function0 var2) {
      ConstraintLayout var3 = (ConstraintLayout)this.findViewById(com.blueair.outdoor.R.id.constraint_layout);
      ConstraintSet var4 = new ConstraintSet();
      var4.clone(var3);
      if (var4.getConstraint(var1).layout.topToTop == com.blueair.outdoor.R.id.minimized_bottom_guideline) {
         if (var2 != null) {
            var2.invoke();
         }

      } else {
         var4.clear(var1, 3);
         var4.clear(var1, 4);
         var4.connect(var1, 3, com.blueair.outdoor.R.id.minimized_bottom_guideline, 3);
         Intrinsics.checkNotNull(var3);
         this.animate(var3, var2);
         var4.applyTo(var3);
      }
   }

   // $FF: synthetic method
   static void showMinimizedCard$default(MapActivity var0, int var1, Function0 var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         var0.showMinimizedCard(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMinimizedCard");
      }
   }

   protected abstract void addMapMarkersImpl(List var1);

   protected abstract void clearMapMarkersImpl();

   public final String getLocalMapType() {
      return (String)this.localMapType$delegate.getValue();
   }

   public abstract String getMapType();

   public final int getMapViewId() {
      return this.mapViewId;
   }

   protected final Bitmap getMarkerIcon(int var1, int var2, int var3) {
      Drawable var6 = AppCompatResources.getDrawable((Context)this, var1);
      if (var6 == null) {
         return null;
      } else {
         Canvas var5 = new Canvas();
         Bitmap var4 = Bitmap.createBitmap(var6.getIntrinsicWidth(), var6.getIntrinsicHeight(), Config.ARGB_8888);
         Intrinsics.checkNotNullExpressionValue(var4, "createBitmap(...)");
         var5.setBitmap(var4);
         var6.setBounds(0, 0, var6.getIntrinsicWidth(), var6.getIntrinsicHeight());
         var6.draw(var5);
         Bitmap var7 = Bitmap.createScaledBitmap(var4, var2, var3, false);
         Intrinsics.checkNotNullExpressionValue(var7, "createScaledBitmap(...)");
         var4.recycle();
         return var7;
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected final boolean getShouldNavigateToStationByIntent() {
      CharSequence var2 = (CharSequence)this.navigateToStationByIntent;
      boolean var1;
      if (var2 != null && !StringsKt.isBlank(var2)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1 ^ true;
   }

   protected final MapsViewModel getViewModel() {
      return (MapsViewModel)this.viewModel$delegate.getValue();
   }

   protected abstract void gotoLocationImpl(TrackedLocation var1, float var2);

   @Deprecated(
      message = "Deprecated in Java"
   )
   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      Timber.Forest.d(String.valueOf(var3), new Object[0]);
      if (var2 == -1) {
         TrackedLocation var5 = null;
         CustomPlace var4;
         if (var3 != null) {
            var4 = (CustomPlace)var3.getParcelableExtra("place");
         } else {
            var4 = null;
         }

         if (var3 != null) {
            var5 = (TrackedLocation)var3.getParcelableExtra("savedloc");
         }

         if (var4 != null) {
            this.changeSearchBarStyle();
            this.navigateToPrediction = var4;
            return;
         }

         if (var5 != null) {
            this.navigateToStationIdBySearchResult = var5.getId();
         }
      }

   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   public void onAttachFragment(Fragment var1) {
      Intrinsics.checkNotNullParameter(var1, "fragment");
      super.onAttachFragment(var1);
      if (var1 instanceof ConfirmationDialogCentered && Intrinsics.areEqual(((ConfirmationDialogCentered)var1).getTag(), "Dialog")) {
         this.getSupportFragmentManager().setFragmentResultListener("CONFIRMATION", (LifecycleOwner)this, new MapActivity$$ExternalSyntheticLambda19(var1, this));
      }

   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(com.blueair.outdoor.R.layout.activity_maps);
      Intent var6 = this.getIntent();
      boolean var4 = false;
      this.startedForSearchMode = var6.getBooleanExtra("search_mode", false);
      this.navigateToStationByIntent = this.getIntent().getStringExtra("location_id");
      this.navigateToCurrentLocation = this.getIntent().getBooleanExtra("current_location", false);
      String var5 = this.getIntent().getStringExtra("device_id");
      String var7 = var5;
      if (var5 == null) {
         var7 = "";
      }

      this.deviceId = var7;
      boolean var2;
      if (((CharSequence)var7).length() > 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.inAssignProductMode = var2;
      boolean var3 = var4;
      if (var2) {
         label18: {
            CharSequence var8 = (CharSequence)this.navigateToStationByIntent;
            if (var8 != null) {
               var3 = var4;
               if (var8.length() != 0) {
                  break label18;
               }
            }

            var3 = true;
         }
      }

      this.setShouldShowAssignProduct(var3);
      this.configureSearchBar();
      this.configureSavedLocations();
      this.configureAddLocationButton();
      this.configureAddLocationCard();
      this.configureAddLocationListeners();
      this.configureGPSButton();
      this.configureMode();
      this.configureUsingIntentParameters();
   }

   protected void onMapReady() {
      this.getViewModel().setMapIsReady(true);
      List var2 = this.pendingMarkers;
      if (var2 != null) {
         Timber.Forest var3 = Timber.Forest;
         StringBuilder var1 = new StringBuilder("pendingMarkers: ");
         var1.append(var2);
         var3.d(var1.toString(), new Object[0]);
         this.addMapMarkersImpl(var2);
         this.pendingMarkers = null;
      }

      Pair var6 = this.pendingGotoLocation;
      if (var6 != null) {
         Timber.Forest var5 = Timber.Forest;
         StringBuilder var4 = new StringBuilder("pendingGotoLocation: ");
         var4.append(var6);
         var5.d(var4.toString(), new Object[0]);
         this.gotoLocation((TrackedLocation)var6.getFirst(), ((Number)var6.getSecond()).floatValue());
         this.pendingGotoLocation = null;
      }

   }

   public final void onMarkerTapped(String var1) {
      Intrinsics.checkNotNullParameter(var1, "id");
      this.getViewModel().setNormalMode();
      String var4 = (String)this.getViewModel().getMarkers().get(var1);
      if (var4 != null) {
         List var3 = (List)this.getViewModel().getAllLocations().getValue();
         List var5 = var3;
         if (var3 == null) {
            var5 = CollectionsKt.emptyList();
         }

         Iterator var6 = var5.iterator();
         int var2 = 0;

         while(true) {
            if (!var6.hasNext()) {
               var2 = -1;
               break;
            }

            if (Intrinsics.areEqual(((TrackedLocation)var6.next()).getId(), var4)) {
               break;
            }

            ++var2;
         }

         if (var2 >= 0) {
            LocationLinearLayoutManager var8 = this.locationLinearLayoutManager;
            LocationLinearLayoutManager var7 = var8;
            if (var8 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("locationLinearLayoutManager");
               var7 = null;
            }

            var7.scrollToPosition(var2);
            this.gotoLocation((TrackedLocation)var5.get(var2));
         }
      }

   }

   protected void onResume() {
      super.onResume();
      this.configureAddLocationRxListeners();
      this.navigateToStationFromSearchActivityIfNeeded();
      this.navigateToPredictionFromSearchActivityIfNeeded();
   }

   public final void setMapViewId(int var1) {
      this.mapViewId = var1;
   }

   protected final void setMinimizedModeIfNeeded() {
      if (this.getViewModel().getMode() == MapsViewModel.MapMode.SAVED_LOCATIONS) {
         this.getViewModel().setMinimizedMode();
      }

   }

   protected final void setupLocationServices() {
      this.getViewModel().getViewLocation().observe((LifecycleOwner)this, new Observer(new MapActivity$$ExternalSyntheticLambda20(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   protected abstract void startSearchIntent();

   protected abstract void styleMarker(String var1, boolean var2, boolean var3);

   protected final void updateAirQualityIfNeeded(double var1, double var3) {
      if (this.getViewModel().getMode() == MapsViewModel.MapMode.ADD_LOCATION) {
         this.currentLocationDebounceFetchedPublisher.onNext(this.getViewModel().createEmptyLocation(var1, var3, this.getLocalMapType()));
      }

   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"},
      d2 = {"Lcom/blueair/outdoor/ui/activity/MapActivity$Companion;", "", "<init>", "()V", "NO_ELEMENT", "", "MARKER_SIZE_LOCATION", "", "MARKER_SIZE_GPS", "MAP_MOVE_UPDATE_STATION_DELAY", "", "ZOOM_LEVEL_STREET", "", "ZOOM_LEVEL_FOCUS", "ZOOM_LEVEL_MAX", "DIALOG_TAG", "KEY_LOCATION", "outdoor_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[MapsViewModel.MapMode.values().length];

         try {
            var0[MapsViewModel.MapMode.MINIMIZED.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MapsViewModel.MapMode.SAVED_LOCATIONS.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MapsViewModel.MapMode.ADD_LOCATION.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
