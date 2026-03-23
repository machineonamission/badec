package com.blueair.devicemanager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.database.entity.DeviceDataEntity;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingClient;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0014\u00106\u001a\u00020\u000f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908J\u0006\u0010:\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f8F@FX\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R+\u00100\u001a\u00020/2\u0006\u0010)\u001a\u00020/8B@BX\u0002¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b1\u00102\"\u0004\b3\u00104R+\u0010;\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f8F@FX\u0002¢\u0006\u0012\n\u0004\b>\u0010.\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013¨\u0006@"}, d2 = {"Lcom/blueair/devicemanager/WelcomeHomeService;", "", "context", "Landroid/content/Context;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "<init>", "(Landroid/content/Context;Lcom/blueair/core/service/UnsecurePrefs;)V", "geofenceClient", "Lcom/google/android/gms/location/GeofencingClient;", "getGeofenceClient", "()Lcom/google/android/gms/location/GeofencingClient;", "geofenceClient$delegate", "Lkotlin/Lazy;", "countryAvailable", "", "getCountryAvailable", "()Z", "setCountryAvailable", "(Z)V", "addWelcomeHomeLocation", "", "deviceId", "", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "setWelcomeHomeLocation", "isMinimal", "addGeofence", "request", "Lcom/google/android/gms/location/GeofencingRequest;", "disableWelcomeHomeLocation", "setEnabledForDevice", "buildGeofence", "Lcom/google/android/gms/location/Geofence;", "requestId", "lat", "", "lng", "radius", "", "<set-?>", "shouldShowDev", "getShouldShowDev", "setShouldShowDev", "shouldShowDev$delegate", "Lkotlin/properties/ReadWriteProperty;", "", "whExploreShowedCount", "getWhExploreShowedCount", "()I", "setWhExploreShowedCount", "(I)V", "whExploreShowedCount$delegate", "shouldShowWHExplore", "devices", "", "Lcom/blueair/core/model/Device;", "setWelcomeHomeAsShowed", "addHomeInstructionsShowed", "getAddHomeInstructionsShowed", "setAddHomeInstructionsShowed", "addHomeInstructionsShowed$delegate", "Companion", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: WelcomeHomeService.kt */
public final class WelcomeHomeService {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_ADD_HOME_INSTRUCTIONS_SHOWED = "key_add_home_instructions_showed";
    private static final String KEY_WH_EXPLORE_SHOWED_COUNT = "key_wh_explore_showed_count";
    private static final String KEY_WH_SHOW_DEV = "key_wh_show_dev";
    public static final float MIN_RADIUS = 200.0f;
    public static final String MIN_RADIUS_KEY_SUFFIX = "-min_radius";
    private final ReadWriteProperty addHomeInstructionsShowed$delegate;
    private final Context context;
    private boolean countryAvailable;
    private final Lazy geofenceClient$delegate = LazyKt.lazy(new WelcomeHomeService$$ExternalSyntheticLambda0(this));
    private final ReadWriteProperty shouldShowDev$delegate;
    private final ReadWriteProperty whExploreShowedCount$delegate;

    static {
        Class<WelcomeHomeService> cls = WelcomeHomeService.class;
        $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "shouldShowDev", "getShouldShowDev()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "whExploreShowedCount", "getWhExploreShowedCount()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "addHomeInstructionsShowed", "getAddHomeInstructionsShowed()Z", 0))};
    }

    public WelcomeHomeService(Context context2, UnsecurePrefs unsecurePrefs) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(unsecurePrefs, "prefs");
        this.context = context2;
        Prefs prefs = unsecurePrefs;
        this.shouldShowDev$delegate = new WelcomeHomeService$special$$inlined$ObservablePreference$1(prefs, KEY_WH_SHOW_DEV, false, PreferencesHelper.INSTANCE.get(prefs.getBackend(), KEY_WH_SHOW_DEV, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        this.whExploreShowedCount$delegate = new WelcomeHomeService$special$$inlined$ObservablePreference$2(prefs, KEY_WH_EXPLORE_SHOWED_COUNT, 0, PreferencesHelper.INSTANCE.get(prefs.getBackend(), KEY_WH_EXPLORE_SHOWED_COUNT, 0, Reflection.getOrCreateKotlinClass(Integer.class)));
        this.addHomeInstructionsShowed$delegate = new WelcomeHomeService$special$$inlined$ObservablePreference$3(prefs, KEY_ADD_HOME_INSTRUCTIONS_SHOWED, false, PreferencesHelper.INSTANCE.get(prefs.getBackend(), KEY_ADD_HOME_INSTRUCTIONS_SHOWED, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
    }

    private final GeofencingClient getGeofenceClient() {
        return (GeofencingClient) this.geofenceClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final GeofencingClient geofenceClient_delegate$lambda$0(WelcomeHomeService welcomeHomeService) {
        return LocationServices.getGeofencingClient(welcomeHomeService.context);
    }

    public final boolean getCountryAvailable() {
        return this.countryAvailable;
    }

    public final void setCountryAvailable(boolean z) {
        this.countryAvailable = z;
    }

    public final void addWelcomeHomeLocation(String str, WelcomeHomeLocation welcomeHomeLocation) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(welcomeHomeLocation, "location");
        setWelcomeHomeLocation(str, welcomeHomeLocation, false);
        setWelcomeHomeLocation(str, welcomeHomeLocation, true);
    }

    private final void setWelcomeHomeLocation(String str, WelcomeHomeLocation welcomeHomeLocation, boolean z) {
        String str2;
        float f;
        GeofencingRequest.Builder initialTrigger = new GeofencingRequest.Builder().setInitialTrigger(z ? 0 : 3);
        if (z) {
            str2 = str + MIN_RADIUS_KEY_SUFFIX;
        } else {
            str2 = str;
        }
        double lat = welcomeHomeLocation.getLat();
        double lng = welcomeHomeLocation.getLng();
        if (z) {
            f = 200.0f;
        } else {
            f = (float) welcomeHomeLocation.getRadius();
        }
        GeofencingRequest build = initialTrigger.addGeofence(buildGeofence(str2, lat, lng, f)).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        addGeofence(str, build);
    }

    private final void addGeofence(String str, GeofencingRequest geofencingRequest) {
        Task<Void> addGeofences = getGeofenceClient().addGeofences(geofencingRequest, PendingIntent.getBroadcast(this.context, 0, new Intent(this.context, WelcomeHomeBroadcastReceiver.class), Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728));
        addGeofences.addOnSuccessListener(new WelcomeHomeService$$ExternalSyntheticLambda2(new WelcomeHomeService$$ExternalSyntheticLambda1(str)));
        addGeofences.addOnFailureListener(new WelcomeHomeService$$ExternalSyntheticLambda3(str));
    }

    /* access modifiers changed from: private */
    public static final void addGeofence$lambda$4$lambda$2(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit addGeofence$lambda$4$lambda$1(String str, Void voidR) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Geofence add success for " + str, new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void addGeofence$lambda$4$lambda$3(String str, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        Timber.Forest forest = Timber.Forest;
        forest.d("Geofence add failure for " + str, new Object[0]);
    }

    public final void disableWelcomeHomeLocation(String str) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        GeofencingClient geofenceClient = getGeofenceClient();
        Task<Void> removeGeofences = geofenceClient.removeGeofences((List<String>) CollectionsKt.listOf(str, str + MIN_RADIUS_KEY_SUFFIX));
        removeGeofences.addOnSuccessListener(new WelcomeHomeService$$ExternalSyntheticLambda5(new WelcomeHomeService$$ExternalSyntheticLambda4(str)));
        removeGeofences.addOnFailureListener(new WelcomeHomeService$$ExternalSyntheticLambda6(str));
    }

    /* access modifiers changed from: private */
    public static final void disableWelcomeHomeLocation$lambda$8$lambda$6(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final Unit disableWelcomeHomeLocation$lambda$8$lambda$5(String str, Void voidR) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Geofence remove success for " + str, new Object[0]);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void disableWelcomeHomeLocation$lambda$8$lambda$7(String str, Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        Timber.Forest forest = Timber.Forest;
        forest.d("Geofence remove failure for " + str, new Object[0]);
    }

    public final void setEnabledForDevice(String str, WelcomeHomeLocation welcomeHomeLocation) {
        Intrinsics.checkNotNullParameter(str, DeviceDataEntity.DEVICE_ID);
        Intrinsics.checkNotNullParameter(welcomeHomeLocation, "location");
        if (welcomeHomeLocation.isEnabled()) {
            addWelcomeHomeLocation(str, welcomeHomeLocation);
        } else {
            disableWelcomeHomeLocation(str);
        }
    }

    private final Geofence buildGeofence(String str, double d, double d2, float f) {
        Geofence build = new Geofence.Builder().setRequestId(str).setCircularRegion(d, d2, f).setTransitionTypes(3).setExpirationDuration(-1).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    public final boolean getShouldShowDev() {
        return ((Boolean) this.shouldShowDev$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setShouldShowDev(boolean z) {
        this.shouldShowDev$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    private final int getWhExploreShowedCount() {
        return ((Number) this.whExploreShowedCount$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    private final void setWhExploreShowedCount(int i) {
        this.whExploreShowedCount$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i));
    }

    public final boolean shouldShowWHExplore(List<? extends Device> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "devices");
        boolean z = false;
        if (getShouldShowDev()) {
            setShouldShowDev(false);
            return true;
        } else if (!this.countryAvailable || getWhExploreShowedCount() >= 2) {
            return false;
        } else {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Device) obj) instanceof HasWelcomeHome) {
                    break;
                }
            }
            if (obj != null) {
                z = true;
            }
            if (z) {
                setWhExploreShowedCount(getWhExploreShowedCount() + 1);
            }
            return z;
        }
    }

    public final void setWelcomeHomeAsShowed() {
        setWhExploreShowedCount(2);
    }

    public final boolean getAddHomeInstructionsShowed() {
        return ((Boolean) this.addHomeInstructionsShowed$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void setAddHomeInstructionsShowed(boolean z) {
        this.addHomeInstructionsShowed$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/devicemanager/WelcomeHomeService$Companion;", "", "<init>", "()V", "MIN_RADIUS_KEY_SUFFIX", "", "MIN_RADIUS", "", "KEY_WH_EXPLORE_SHOWED_COUNT", "KEY_WH_SHOW_DEV", "KEY_ADD_HOME_INSTRUCTIONS_SHOWED", "devicemanager_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: WelcomeHomeService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
