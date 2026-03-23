package com.blueair.core.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blueair.core.PrefKeys;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u001c\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u001c\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001c\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/util/LocationPermissionTracker;", "", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "<init>", "(Lio/flatcircle/preferenceshelper2/Prefs;)V", "requestLocationPermission", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "preAction", "Lkotlin/Function0;", "requestCoarseLocationPermission", "requestLocationPermissionDialogOnly", "hasRequestedPermission", "", "hasRequestedCoarsePermission", "notifyRequestedPermission", "notifyRequestedCoarsePermission", "displayLocationPermissionDialog", "displayCoarseLocationPermissionDialog", "displayLocationPermissionAppInfo", "shouldShowLocationRequestPermissionDialog", "shouldShowCoarseLocationRequestPermissionDialog", "Companion", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LocationPermissionTracker.kt */
public final class LocationPermissionTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_CODE_LOCATION_PERMISSION = 10101;
    private final Prefs prefs;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/blueair/core/util/LocationPermissionTracker$Companion;", "", "<init>", "()V", "REQUEST_CODE_LOCATION_PERMISSION", "", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LocationPermissionTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LocationPermissionTracker(Prefs prefs2) {
        Intrinsics.checkNotNullParameter(prefs2, "prefs");
        this.prefs = prefs2;
    }

    public final void requestLocationPermission(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (shouldShowLocationRequestPermissionDialog(activity)) {
            displayLocationPermissionDialog(activity);
        } else {
            displayLocationPermissionAppInfo$default(this, activity, (Fragment) null, 2, (Object) null);
        }
    }

    public final void requestLocationPermission(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(function0, "preAction");
        if (shouldShowLocationRequestPermissionDialog(fragment)) {
            displayLocationPermissionDialog(fragment, function0);
        } else {
            displayLocationPermissionAppInfo(fragment);
        }
    }

    public final void requestCoarseLocationPermission(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (shouldShowCoarseLocationRequestPermissionDialog(fragment)) {
            displayCoarseLocationPermissionDialog(fragment);
        } else {
            displayLocationPermissionAppInfo(fragment);
        }
    }

    public final void requestLocationPermissionDialogOnly(Fragment fragment, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(function0, "preAction");
        if (shouldShowLocationRequestPermissionDialog(fragment)) {
            displayLocationPermissionDialog(fragment, function0);
        }
    }

    private final boolean hasRequestedPermission() {
        return ((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.hasRequestedLocationPermission, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    private final boolean hasRequestedCoarsePermission() {
        return ((Boolean) PreferencesHelper.INSTANCE.get(this.prefs.getBackend(), PrefKeys.hasRequestedCoarseLocationPermission, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    private final void notifyRequestedPermission() {
        PreferencesHelper.INSTANCE.set(this.prefs.getBackend(), PrefKeys.hasRequestedLocationPermission, true, Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    private final void notifyRequestedCoarsePermission() {
        PreferencesHelper.INSTANCE.set(this.prefs.getBackend(), PrefKeys.hasRequestedCoarseLocationPermission, true, Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    private final void displayLocationPermissionDialog(Activity activity) {
        notifyRequestedPermission();
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, REQUEST_CODE_LOCATION_PERMISSION);
    }

    private final void displayLocationPermissionDialog(Fragment fragment, Function0<Unit> function0) {
        notifyRequestedPermission();
        function0.invoke();
        fragment.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, REQUEST_CODE_LOCATION_PERMISSION);
    }

    private final void displayCoarseLocationPermissionDialog(Fragment fragment) {
        notifyRequestedCoarsePermission();
        fragment.requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, REQUEST_CODE_LOCATION_PERMISSION);
    }

    static /* synthetic */ void displayLocationPermissionAppInfo$default(LocationPermissionTracker locationPermissionTracker, Activity activity, Fragment fragment, int i, Object obj) {
        if ((i & 2) != 0) {
            fragment = null;
        }
        locationPermissionTracker.displayLocationPermissionAppInfo(activity, fragment);
    }

    private final void displayLocationPermissionAppInfo(Activity activity, Fragment fragment) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), (String) null));
        if (fragment != null) {
            fragment.startActivityForResult(intent, REQUEST_CODE_LOCATION_PERMISSION);
        } else {
            activity.startActivityForResult(intent, REQUEST_CODE_LOCATION_PERMISSION);
        }
    }

    private final void displayLocationPermissionAppInfo(Fragment fragment) {
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            displayLocationPermissionAppInfo(activity, fragment);
        }
    }

    private final boolean shouldShowLocationRequestPermissionDialog(Activity activity) {
        return !hasRequestedPermission() || ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_FINE_LOCATION") || ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.ACCESS_COARSE_LOCATION");
    }

    public final boolean shouldShowLocationRequestPermissionDialog(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        return !hasRequestedPermission() || fragment.shouldShowRequestPermissionRationale("android.permission.ACCESS_FINE_LOCATION") || fragment.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION");
    }

    private final boolean shouldShowCoarseLocationRequestPermissionDialog(Fragment fragment) {
        return !hasRequestedCoarsePermission() || fragment.shouldShowRequestPermissionRationale("android.permission.ACCESS_COARSE_LOCATION");
    }
}
