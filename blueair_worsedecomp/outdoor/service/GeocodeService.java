package com.blueair.outdoor.service;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import com.blueair.api.client.MbGeoClient;
import com.blueair.auth.LocationService;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H@¢\u0006\u0002\u0010\u001aJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0003J\u0012\u0010'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001a\u0010*\u001a\n +*\u0004\u0018\u00010!0!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010,\u001a\u00020-X\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/blueair/outdoor/service/GeocodeService;", "Lkotlinx/coroutines/CoroutineScope;", "appContext", "Landroid/content/Context;", "geoClient", "Lcom/blueair/api/client/MbGeoClient;", "locationService", "Lcom/blueair/auth/LocationService;", "locationNamePlaceholderProvider", "Lcom/blueair/core/service/LocationNamePlaceholderProvider;", "<init>", "(Landroid/content/Context;Lcom/blueair/api/client/MbGeoClient;Lcom/blueair/auth/LocationService;Lcom/blueair/core/service/LocationNamePlaceholderProvider;)V", "geocoder", "Landroid/location/Geocoder;", "getGeocoder", "()Landroid/location/Geocoder;", "geocoder$delegate", "Lkotlin/Lazy;", "amapGeocoder", "Lcom/blueair/outdoor/service/Geocoder;", "getAmapGeocoder", "()Lcom/blueair/outdoor/service/Geocoder;", "amapGeocoder$delegate", "getTrackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "location", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrackedLocationUsingAmap", "getTrackedLocationUsingMapBox", "mapboxSearch", "", "Lcom/blueair/core/model/MbLocationFeatures;", "query", "", "lngLat", "countryCode", "limit", "", "getTrackedLocationUsingGoogle", "getCityName", "address", "Landroid/location/Address;", "getStationName", "kotlin.jvm.PlatformType", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GeocodeService.kt */
public final class GeocodeService implements CoroutineScope {
    private final /* synthetic */ DefaultCoroutineScope $$delegate_0 = new DefaultCoroutineScope();
    private final Lazy amapGeocoder$delegate;
    private final Context appContext;
    private final MbGeoClient geoClient;
    private final Lazy geocoder$delegate;
    private final LocationNamePlaceholderProvider locationNamePlaceholderProvider;
    private final LocationService locationService;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GeocodeService.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.auth.LocationService$MapType[] r0 = com.blueair.auth.LocationService.MapType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.auth.LocationService$MapType r1 = com.blueair.auth.LocationService.MapType.AMAP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.auth.LocationService$MapType r1 = com.blueair.auth.LocationService.MapType.GOOGLE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.auth.LocationService$MapType r1 = com.blueair.auth.LocationService.MapType.MAPBOX     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.GeocodeService.WhenMappings.<clinit>():void");
        }
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    public GeocodeService(Context context, MbGeoClient mbGeoClient, LocationService locationService2, LocationNamePlaceholderProvider locationNamePlaceholderProvider2) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(mbGeoClient, "geoClient");
        Intrinsics.checkNotNullParameter(locationService2, "locationService");
        Intrinsics.checkNotNullParameter(locationNamePlaceholderProvider2, "locationNamePlaceholderProvider");
        this.appContext = context;
        this.geoClient = mbGeoClient;
        this.locationService = locationService2;
        this.locationNamePlaceholderProvider = locationNamePlaceholderProvider2;
        this.geocoder$delegate = LazyKt.lazy(new GeocodeService$$ExternalSyntheticLambda0(this));
        this.amapGeocoder$delegate = LazyKt.lazy(new GeocodeService$$ExternalSyntheticLambda1(this));
    }

    private final Geocoder getGeocoder() {
        return (Geocoder) this.geocoder$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final Geocoder geocoder_delegate$lambda$0(GeocodeService geocodeService) {
        return new Geocoder(geocodeService.appContext);
    }

    /* access modifiers changed from: private */
    public static final AmapGeocoder amapGeocoder_delegate$lambda$1(GeocodeService geocodeService) {
        return new AmapGeocoder(geocodeService.appContext, geocodeService.locationNamePlaceholderProvider);
    }

    private final Geocoder getAmapGeocoder() {
        return (Geocoder) this.amapGeocoder$delegate.getValue();
    }

    public final Object getTrackedLocation(TrackedLocation trackedLocation, Continuation<? super TrackedLocation> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.locationService.getMapType().ordinal()];
        if (i == 1) {
            return getTrackedLocationUsingAmap(trackedLocation, continuation);
        }
        if (i == 2) {
            return getTrackedLocationUsingGoogle(trackedLocation);
        }
        if (i == 3) {
            Object trackedLocationUsingMapBox = getTrackedLocationUsingMapBox(trackedLocation, continuation);
            return trackedLocationUsingMapBox == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? trackedLocationUsingMapBox : (TrackedLocation) trackedLocationUsingMapBox;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: private */
    public final Object getTrackedLocationUsingAmap(TrackedLocation trackedLocation, Continuation<? super TrackedLocation> continuation) {
        return getAmapGeocoder().getTrackedLocation(trackedLocation, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v12, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v16, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v30, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v31, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v32, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v17, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: com.blueair.core.model.MbLocationFeatures} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getTrackedLocationUsingMapBox(com.blueair.core.model.TrackedLocation r27, kotlin.coroutines.Continuation<? super com.blueair.core.model.TrackedLocation> r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r28
            boolean r2 = r0 instanceof com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$1 r2 = (com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$1 r2 = new com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            java.lang.String r6 = "CN"
            r7 = 0
            r8 = 1
            if (r4 == 0) goto L_0x006b
            if (r4 == r8) goto L_0x0051
            if (r4 != r5) goto L_0x0049
            java.lang.Object r3 = r2.L$4
            com.blueair.core.model.TrackedLocation r3 = (com.blueair.core.model.TrackedLocation) r3
            java.lang.Object r4 = r2.L$3
            double[] r4 = (double[]) r4
            java.lang.Object r4 = r2.L$2
            com.blueair.core.model.MbGeoLocations r4 = (com.blueair.core.model.MbGeoLocations) r4
            java.lang.Object r5 = r2.L$1
            kotlin.Pair r5 = (kotlin.Pair) r5
            java.lang.Object r2 = r2.L$0
            com.blueair.core.model.TrackedLocation r2 = (com.blueair.core.model.TrackedLocation) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0171
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0051:
            java.lang.Object r4 = r2.L$3
            double[] r4 = (double[]) r4
            java.lang.Object r8 = r2.L$2
            com.blueair.core.model.MbGeoLocations r8 = (com.blueair.core.model.MbGeoLocations) r8
            java.lang.Object r10 = r2.L$1
            kotlin.Pair r10 = (kotlin.Pair) r10
            java.lang.Object r11 = r2.L$0
            com.blueair.core.model.TrackedLocation r11 = (com.blueair.core.model.TrackedLocation) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r25 = r8
            r8 = r4
            r4 = r25
            goto L_0x0126
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.Pair r10 = r27.getLatLngInWGS()
            com.blueair.api.client.MbGeoClient r0 = r1.geoClient     // Catch:{ all -> 0x00b4 }
            java.lang.Object r4 = r10.getFirst()     // Catch:{ all -> 0x00b4 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ all -> 0x00b4 }
            double r11 = r4.doubleValue()     // Catch:{ all -> 0x00b4 }
            java.lang.String r4 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x00b4 }
            java.lang.Object r11 = r10.getSecond()     // Catch:{ all -> 0x00b4 }
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ all -> 0x00b4 }
            double r11 = r11.doubleValue()     // Catch:{ all -> 0x00b4 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ all -> 0x00b4 }
            retrofit2.Call r0 = r0.getLocations(r4, r11)     // Catch:{ all -> 0x00b4 }
            retrofit2.Response r0 = r0.execute()     // Catch:{ all -> 0x00b4 }
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest     // Catch:{ all -> 0x00b4 }
            java.lang.String r11 = "geocodeBreezometerMb response: %s"
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x00b4 }
            java.lang.Object[] r13 = new java.lang.Object[r8]     // Catch:{ all -> 0x00b4 }
            r13[r7] = r12     // Catch:{ all -> 0x00b4 }
            r4.d(r11, r13)     // Catch:{ all -> 0x00b4 }
            boolean r4 = r0.isSuccessful()     // Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x00be
            java.lang.Object r0 = r0.body()     // Catch:{ all -> 0x00b4 }
            com.blueair.core.model.MbGeoLocations r0 = (com.blueair.core.model.MbGeoLocations) r0     // Catch:{ all -> 0x00b4 }
            goto L_0x00bf
        L_0x00b4:
            r0 = move-exception
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.String r11 = "geocodeBreezometerMb: mbGeoService.getLocations failed"
            java.lang.Object[] r12 = new java.lang.Object[r7]
            r4.e(r0, r11, r12)
        L_0x00be:
            r0 = 0
        L_0x00bf:
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.String r11 = java.lang.String.valueOf(r0)
            java.lang.Object[] r12 = new java.lang.Object[r8]
            r12[r7] = r11
            java.lang.String r11 = "geocodeBreezometerMb locations: %s"
            r4.d(r11, r12)
            com.blueair.core.util.CoordinateTransformUtils r13 = com.blueair.core.util.CoordinateTransformUtils.INSTANCE
            java.lang.Object r4 = r10.getSecond()
            java.lang.Number r4 = (java.lang.Number) r4
            double r14 = r4.doubleValue()
            java.lang.Object r4 = r10.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            double r16 = r4.doubleValue()
            java.lang.Boolean r18 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            double[] r4 = r13.wgs84togcj02(r14, r16, r18)
            r13 = r4[r8]
            r15 = r4[r7]
            r23 = 249(0xf9, float:3.49E-43)
            r24 = 0
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.String r22 = "GCJ"
            r11 = r27
            com.blueair.core.model.TrackedLocation r12 = com.blueair.core.model.TrackedLocation.copy$default(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23, r24)
            r2.L$0 = r11
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r2.L$1 = r13
            r2.L$2 = r0
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r2.L$3 = r13
            r2.label = r8
            java.lang.Object r8 = getTrackedLocationUsingMapBox$getLocationWithCountryCode(r1, r12, r2)
            if (r8 != r3) goto L_0x0120
            goto L_0x016d
        L_0x0120:
            r25 = r4
            r4 = r0
            r0 = r8
            r8 = r25
        L_0x0126:
            com.blueair.core.model.TrackedLocation r0 = (com.blueair.core.model.TrackedLocation) r0
            if (r0 == 0) goto L_0x012f
            java.lang.String r12 = r0.getCountryCode()
            goto L_0x0130
        L_0x012f:
            r12 = 0
        L_0x0130:
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r6)
            if (r12 == 0) goto L_0x013a
            r3 = r0
            r10 = r11
            r0 = 0
            goto L_0x0174
        L_0x013a:
            r23 = 255(0xff, float:3.57E-43)
            r24 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            java.lang.String r22 = "WGS"
            com.blueair.core.model.TrackedLocation r12 = com.blueair.core.model.TrackedLocation.copy$default(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23, r24)
            r2.L$0 = r11
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r2.L$1 = r10
            r2.L$2 = r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$3 = r8
            r2.L$4 = r0
            r2.label = r5
            java.lang.Object r2 = getTrackedLocationUsingMapBox$getLocationWithCountryCode(r1, r12, r2)
            if (r2 != r3) goto L_0x016e
        L_0x016d:
            return r3
        L_0x016e:
            r3 = r0
            r0 = r2
            r2 = r11
        L_0x0171:
            com.blueair.core.model.TrackedLocation r0 = (com.blueair.core.model.TrackedLocation) r0
            r10 = r2
        L_0x0174:
            if (r0 == 0) goto L_0x017b
            java.lang.String r2 = r0.getCountryCode()
            goto L_0x017c
        L_0x017b:
            r2 = 0
        L_0x017c:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 != 0) goto L_0x01a1
            if (r3 == 0) goto L_0x0189
            java.lang.String r2 = r3.getCountryCode()
            goto L_0x018a
        L_0x0189:
            r2 = 0
        L_0x018a:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)
            if (r2 == 0) goto L_0x0191
            goto L_0x01a1
        L_0x0191:
            if (r3 == 0) goto L_0x0199
            java.lang.String r6 = r3.getCountryCode()
            if (r6 != 0) goto L_0x01a1
        L_0x0199:
            if (r0 == 0) goto L_0x01a0
            java.lang.String r6 = r0.getCountryCode()
            goto L_0x01a1
        L_0x01a0:
            r6 = 0
        L_0x01a1:
            com.blueair.core.service.LocationNamePlaceholderProvider r0 = r1.locationNamePlaceholderProvider
            java.lang.String r0 = r0.getUnknownCity()
            com.blueair.core.service.LocationNamePlaceholderProvider r2 = r1.locationNamePlaceholderProvider
            java.lang.String r2 = r2.getUnknownStationName()
            if (r4 == 0) goto L_0x03b4
            java.util.List r3 = r4.getFeatures()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x01b9:
            boolean r5 = r3.hasNext()
            java.lang.String r8 = "country"
            if (r5 == 0) goto L_0x01d3
            java.lang.Object r5 = r3.next()
            r11 = r5
            com.blueair.core.model.MbLocationFeatures r11 = (com.blueair.core.model.MbLocationFeatures) r11
            java.util.List r11 = r11.getPlace_type()
            boolean r11 = r11.contains(r8)
            if (r11 == 0) goto L_0x01b9
            goto L_0x01d4
        L_0x01d3:
            r5 = 0
        L_0x01d4:
            com.blueair.core.model.MbLocationFeatures r5 = (com.blueair.core.model.MbLocationFeatures) r5
            if (r5 == 0) goto L_0x01dd
            java.lang.String r3 = r5.getText()
            goto L_0x01de
        L_0x01dd:
            r3 = 0
        L_0x01de:
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x01e8:
            boolean r11 = r5.hasNext()
            java.lang.String r12 = "region"
            if (r11 == 0) goto L_0x0202
            java.lang.Object r11 = r5.next()
            r13 = r11
            com.blueair.core.model.MbLocationFeatures r13 = (com.blueair.core.model.MbLocationFeatures) r13
            java.util.List r13 = r13.getPlace_type()
            boolean r13 = r13.contains(r12)
            if (r13 == 0) goto L_0x01e8
            goto L_0x0203
        L_0x0202:
            r11 = 0
        L_0x0203:
            com.blueair.core.model.MbLocationFeatures r11 = (com.blueair.core.model.MbLocationFeatures) r11
            java.lang.String r5 = "place"
            java.lang.String r13 = "district"
            if (r11 != 0) goto L_0x0259
            java.util.List r11 = r4.getFeatures()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L_0x0215:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x022d
            java.lang.Object r14 = r11.next()
            r15 = r14
            com.blueair.core.model.MbLocationFeatures r15 = (com.blueair.core.model.MbLocationFeatures) r15
            java.util.List r15 = r15.getPlace_type()
            boolean r15 = r15.contains(r13)
            if (r15 == 0) goto L_0x0215
            goto L_0x022e
        L_0x022d:
            r14 = 0
        L_0x022e:
            r11 = r14
            com.blueair.core.model.MbLocationFeatures r11 = (com.blueair.core.model.MbLocationFeatures) r11
            if (r11 != 0) goto L_0x0259
            java.util.List r11 = r4.getFeatures()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
        L_0x023d:
            boolean r14 = r11.hasNext()
            if (r14 == 0) goto L_0x0255
            java.lang.Object r14 = r11.next()
            r15 = r14
            com.blueair.core.model.MbLocationFeatures r15 = (com.blueair.core.model.MbLocationFeatures) r15
            java.util.List r15 = r15.getPlace_type()
            boolean r15 = r15.contains(r5)
            if (r15 == 0) goto L_0x023d
            goto L_0x0256
        L_0x0255:
            r14 = 0
        L_0x0256:
            r11 = r14
            com.blueair.core.model.MbLocationFeatures r11 = (com.blueair.core.model.MbLocationFeatures) r11
        L_0x0259:
            if (r11 == 0) goto L_0x0260
            java.lang.String r11 = r11.getText()
            goto L_0x0261
        L_0x0260:
            r11 = 0
        L_0x0261:
            java.util.List r14 = r4.getFeatures()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x026b:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0284
            java.lang.Object r15 = r14.next()
            r16 = r15
            com.blueair.core.model.MbLocationFeatures r16 = (com.blueair.core.model.MbLocationFeatures) r16
            java.util.List r9 = r16.getPlace_type()
            boolean r9 = r9.contains(r5)
            if (r9 == 0) goto L_0x026b
            goto L_0x0285
        L_0x0284:
            r15 = 0
        L_0x0285:
            com.blueair.core.model.MbLocationFeatures r15 = (com.blueair.core.model.MbLocationFeatures) r15
            if (r15 != 0) goto L_0x02ff
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0293:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x02ab
            java.lang.Object r9 = r5.next()
            r14 = r9
            com.blueair.core.model.MbLocationFeatures r14 = (com.blueair.core.model.MbLocationFeatures) r14
            java.util.List r14 = r14.getPlace_type()
            boolean r14 = r14.contains(r13)
            if (r14 == 0) goto L_0x0293
            goto L_0x02ac
        L_0x02ab:
            r9 = 0
        L_0x02ac:
            r15 = r9
            com.blueair.core.model.MbLocationFeatures r15 = (com.blueair.core.model.MbLocationFeatures) r15
            if (r15 != 0) goto L_0x02ff
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x02bb:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x02d3
            java.lang.Object r9 = r5.next()
            r13 = r9
            com.blueair.core.model.MbLocationFeatures r13 = (com.blueair.core.model.MbLocationFeatures) r13
            java.util.List r13 = r13.getPlace_type()
            boolean r13 = r13.contains(r12)
            if (r13 == 0) goto L_0x02bb
            goto L_0x02d4
        L_0x02d3:
            r9 = 0
        L_0x02d4:
            r15 = r9
            com.blueair.core.model.MbLocationFeatures r15 = (com.blueair.core.model.MbLocationFeatures) r15
            if (r15 != 0) goto L_0x02ff
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x02e3:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x02fb
            java.lang.Object r9 = r5.next()
            r12 = r9
            com.blueair.core.model.MbLocationFeatures r12 = (com.blueair.core.model.MbLocationFeatures) r12
            java.util.List r12 = r12.getPlace_type()
            boolean r12 = r12.contains(r8)
            if (r12 == 0) goto L_0x02e3
            goto L_0x02fc
        L_0x02fb:
            r9 = 0
        L_0x02fc:
            r15 = r9
            com.blueair.core.model.MbLocationFeatures r15 = (com.blueair.core.model.MbLocationFeatures) r15
        L_0x02ff:
            if (r15 == 0) goto L_0x0305
            java.lang.String r0 = r15.getText()
        L_0x0305:
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x030f:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0329
            java.lang.Object r8 = r5.next()
            r9 = r8
            com.blueair.core.model.MbLocationFeatures r9 = (com.blueair.core.model.MbLocationFeatures) r9
            java.util.List r9 = r9.getPlace_type()
            java.lang.String r12 = "poi"
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x030f
            goto L_0x032a
        L_0x0329:
            r8 = 0
        L_0x032a:
            com.blueair.core.model.MbLocationFeatures r8 = (com.blueair.core.model.MbLocationFeatures) r8
            if (r8 != 0) goto L_0x03a9
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0338:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x0352
            java.lang.Object r8 = r5.next()
            r9 = r8
            com.blueair.core.model.MbLocationFeatures r9 = (com.blueair.core.model.MbLocationFeatures) r9
            java.util.List r9 = r9.getPlace_type()
            java.lang.String r12 = "address"
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x0338
            goto L_0x0353
        L_0x0352:
            r8 = 0
        L_0x0353:
            com.blueair.core.model.MbLocationFeatures r8 = (com.blueair.core.model.MbLocationFeatures) r8
            if (r8 != 0) goto L_0x03a9
            java.util.List r5 = r4.getFeatures()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0361:
            boolean r8 = r5.hasNext()
            if (r8 == 0) goto L_0x037b
            java.lang.Object r8 = r5.next()
            r9 = r8
            com.blueair.core.model.MbLocationFeatures r9 = (com.blueair.core.model.MbLocationFeatures) r9
            java.util.List r9 = r9.getPlace_type()
            java.lang.String r12 = "neighborhood"
            boolean r9 = r9.contains(r12)
            if (r9 == 0) goto L_0x0361
            goto L_0x037c
        L_0x037b:
            r8 = 0
        L_0x037c:
            com.blueair.core.model.MbLocationFeatures r8 = (com.blueair.core.model.MbLocationFeatures) r8
            if (r8 != 0) goto L_0x03a9
            java.util.List r4 = r4.getFeatures()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x038a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x03a5
            java.lang.Object r5 = r4.next()
            r8 = r5
            com.blueair.core.model.MbLocationFeatures r8 = (com.blueair.core.model.MbLocationFeatures) r8
            java.util.List r8 = r8.getPlace_type()
            java.lang.String r9 = "locality"
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x038a
            r9 = r5
            goto L_0x03a6
        L_0x03a5:
            r9 = 0
        L_0x03a6:
            r8 = r9
            com.blueair.core.model.MbLocationFeatures r8 = (com.blueair.core.model.MbLocationFeatures) r8
        L_0x03a9:
            if (r8 == 0) goto L_0x03af
            java.lang.String r2 = r8.getText()
        L_0x03af:
            r19 = r3
            r18 = r11
            goto L_0x03b8
        L_0x03b4:
            r18 = 0
            r19 = 0
        L_0x03b8:
            timber.log.Timber$Forest r3 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "geocodeBreezometerMb: tracked location state: "
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r5 = ", city: "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r5 = ", station: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = ", countryCode: "
            r4.append(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r3.d(r4, r5)
            r22 = 263(0x107, float:3.69E-43)
            r23 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r21 = 0
            r17 = r0
            r16 = r2
            r20 = r6
            com.blueair.core.model.TrackedLocation r0 = com.blueair.core.model.TrackedLocation.copy$default(r10, r11, r12, r14, r16, r17, r18, r19, r20, r21, r22, r23)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.GeocodeService.getTrackedLocationUsingMapBox(com.blueair.core.model.TrackedLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.blueair.core.model.TrackedLocation} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object getTrackedLocationUsingMapBox$getLocationWithCountryCode(com.blueair.outdoor.service.GeocodeService r4, com.blueair.core.model.TrackedLocation r5, kotlin.coroutines.Continuation<? super com.blueair.core.model.TrackedLocation> r6) {
        /*
            boolean r0 = r6 instanceof com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1 r0 = (com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1 r0 = new com.blueair.outdoor.service.GeocodeService$getTrackedLocationUsingMapBox$getLocationWithCountryCode$1
            r0.<init>(r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r4 = r0.L$1
            r5 = r4
            com.blueair.core.model.TrackedLocation r5 = (com.blueair.core.model.TrackedLocation) r5
            java.lang.Object r4 = r0.L$0
            com.blueair.outdoor.service.GeocodeService r4 = (com.blueair.outdoor.service.GeocodeService) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004b
        L_0x0033:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r4.getTrackedLocationUsingAmap(r5, r0)
            if (r6 != r1) goto L_0x004b
            return r1
        L_0x004b:
            com.blueair.core.model.TrackedLocation r6 = (com.blueair.core.model.TrackedLocation) r6
            if (r6 != 0) goto L_0x0054
            com.blueair.core.model.TrackedLocation r4 = r4.getTrackedLocationUsingGoogle(r5)
            return r4
        L_0x0054:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.GeocodeService.getTrackedLocationUsingMapBox$getLocationWithCountryCode(com.blueair.outdoor.service.GeocodeService, com.blueair.core.model.TrackedLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0027, code lost:
        r2 = r2.getFeatures();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.blueair.core.model.MbLocationFeatures> mapboxSearch(java.lang.String r2, java.lang.String r3, java.lang.String r4, int r5) {
        /*
            r1 = this;
            java.lang.String r0 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "lngLat"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "countryCode"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.blueair.api.client.MbGeoClient r0 = r1.geoClient
            retrofit2.Call r2 = r0.query(r2, r3, r4, r5)
            retrofit2.Response r2 = r2.execute()
            boolean r3 = r2.isSuccessful()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r2 = r2.body()
            com.blueair.core.model.MbGeoLocations r2 = (com.blueair.core.model.MbGeoLocations) r2
            if (r2 == 0) goto L_0x002f
            java.util.List r2 = r2.getFeatures()
            if (r2 != 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            return r2
        L_0x002f:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            return r2
        L_0x0034:
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.service.GeocodeService.mapboxSearch(java.lang.String, java.lang.String, java.lang.String, int):java.util.List");
    }

    private final TrackedLocation getTrackedLocationUsingGoogle(TrackedLocation trackedLocation) {
        String str;
        String str2 = null;
        try {
            Pair<Double, Double> latLngInGCJ = trackedLocation.getLatLngInGCJ();
            List<Address> fromLocation = getGeocoder().getFromLocation(latLngInGCJ.getFirst().doubleValue(), latLngInGCJ.getSecond().doubleValue(), 1);
            Address address = fromLocation != null ? (Address) CollectionsKt.firstOrNull(fromLocation) : null;
            if (address != null) {
                Timber.Forest.d("geocodeBreezometerGoogle: address: locality = %s, subLocality = %s, \nthoroughfare = %s, subThoroughfare = %s, adminArea = %s, subAdminArea = %s, \npremises = %s, featureName = %s", address.getLocality(), address.getSubLocality(), address.getThoroughfare(), address.getSubThoroughfare(), address.getAdminArea(), address.getSubAdminArea(), address.getPremises(), address.getFeatureName());
            }
            if (address != null) {
                String adminArea = address.getAdminArea();
                if (adminArea == null && (adminArea = address.getSubAdminArea()) == null && (adminArea = address.getLocality()) == null) {
                    adminArea = address.getSubLocality();
                }
                str = adminArea;
            } else {
                str = null;
            }
            String stationName = getStationName(address);
            String cityName = getCityName(address);
            String countryName = address != null ? address.getCountryName() : null;
            if (address != null) {
                str2 = address.getCountryCode();
            }
            return TrackedLocation.copy$default(trackedLocation, (String) null, 0.0d, 0.0d, stationName, cityName, str, countryName, str2, (String) null, 263, (Object) null);
        } catch (Throwable th) {
            Timber.Forest.e(th, "geocodeBreezometerGoogle: geocoder.getFromLocation failed", new Object[0]);
            return null;
        }
    }

    private final String getCityName(Address address) {
        String str;
        if (address != null) {
            CharSequence locality = address.getLocality();
            if (locality == null || locality.length() == 0) {
                CharSequence subAdminArea = address.getSubAdminArea();
                if (subAdminArea == null || subAdminArea.length() == 0) {
                    CharSequence adminArea = address.getAdminArea();
                    if (adminArea == null || adminArea.length() == 0) {
                        CharSequence addressLine = address.getAddressLine(0);
                        if (addressLine == null || addressLine.length() == 0) {
                            str = this.locationNamePlaceholderProvider.getUnknownCity();
                        } else {
                            str = address.getAddressLine(0);
                        }
                    } else {
                        str = address.getAdminArea();
                    }
                } else {
                    str = address.getSubAdminArea();
                }
            } else {
                str = address.getLocality();
            }
            if (str != null) {
                return str;
            }
        }
        return this.locationNamePlaceholderProvider.getUnknownCity();
    }

    private final String getStationName(Address address) {
        if (address == null) {
            return this.locationNamePlaceholderProvider.getUnknownStationName();
        }
        CharSequence featureName = address.getFeatureName();
        if (featureName == null || featureName.length() == 0) {
            CharSequence thoroughfare = address.getThoroughfare();
            if (thoroughfare == null || thoroughfare.length() == 0) {
                return this.locationNamePlaceholderProvider.getUnknownStationName();
            }
            return address.getThoroughfare();
        }
        CharSequence thoroughfare2 = address.getThoroughfare();
        if (thoroughfare2 == null || thoroughfare2.length() == 0 || Intrinsics.areEqual((Object) address.getFeatureName(), (Object) address.getThoroughfare())) {
            return address.getFeatureName();
        }
        Timber.Forest.d("Station is throughfare: %s", address.getThoroughfare());
        return address.getFeatureName() + TokenParser.SP + address.getThoroughfare();
    }
}
