package com.blueair.outdoor.service;

import android.content.Context;
import android.location.Address;
import com.blueair.api.client.MbGeoClient;
import com.blueair.auth.LocationService;
import com.blueair.core.model.MbGeoLocations;
import com.blueair.core.model.MbLocationFeatures;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import com.blueair.core.util.CoordinateTransformUtils;
import io.flatcircle.coroutinehelper.DefaultCoroutineScope;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@¢\u0006\u0002\u0010\u001aJ,\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%J\u0012\u0010&\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0003J\u0012\u0010'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001a\u0010*\u001a\n +*\u0004\u0018\u00010!0!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010,\u001a\u00020-X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"},
   d2 = {"Lcom/blueair/outdoor/service/GeocodeService;", "Lkotlinx/coroutines/CoroutineScope;", "appContext", "Landroid/content/Context;", "geoClient", "Lcom/blueair/api/client/MbGeoClient;", "locationService", "Lcom/blueair/auth/LocationService;", "locationNamePlaceholderProvider", "Lcom/blueair/core/service/LocationNamePlaceholderProvider;", "<init>", "(Landroid/content/Context;Lcom/blueair/api/client/MbGeoClient;Lcom/blueair/auth/LocationService;Lcom/blueair/core/service/LocationNamePlaceholderProvider;)V", "geocoder", "Landroid/location/Geocoder;", "getGeocoder", "()Landroid/location/Geocoder;", "geocoder$delegate", "Lkotlin/Lazy;", "amapGeocoder", "Lcom/blueair/outdoor/service/Geocoder;", "getAmapGeocoder", "()Lcom/blueair/outdoor/service/Geocoder;", "amapGeocoder$delegate", "getTrackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "location", "(Lcom/blueair/core/model/TrackedLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrackedLocationUsingAmap", "getTrackedLocationUsingMapBox", "mapboxSearch", "", "Lcom/blueair/core/model/MbLocationFeatures;", "query", "", "lngLat", "countryCode", "limit", "", "getTrackedLocationUsingGoogle", "getCityName", "address", "Landroid/location/Address;", "getStationName", "kotlin.jvm.PlatformType", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GeocodeService implements CoroutineScope {
   private final DefaultCoroutineScope $$delegate_0;
   private final Lazy amapGeocoder$delegate;
   private final Context appContext;
   private final MbGeoClient geoClient;
   private final Lazy geocoder$delegate;
   private final LocationNamePlaceholderProvider locationNamePlaceholderProvider;
   private final LocationService locationService;

   // $FF: synthetic method
   public static AmapGeocoder $r8$lambda$_H2zUPbfQZdljn0_fl3cimD0t9s/* $FF was: $r8$lambda$-H2zUPbfQZdljn0-fl3cimD0t9s*/(GeocodeService var0) {
      return amapGeocoder_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static android.location.Geocoder $r8$lambda$wz1PyL9i_NnmfRjUb_Ep8kTAoXo(GeocodeService var0) {
      return geocoder_delegate$lambda$0(var0);
   }

   public GeocodeService(Context var1, MbGeoClient var2, LocationService var3, LocationNamePlaceholderProvider var4) {
      Intrinsics.checkNotNullParameter(var1, "appContext");
      Intrinsics.checkNotNullParameter(var2, "geoClient");
      Intrinsics.checkNotNullParameter(var3, "locationService");
      Intrinsics.checkNotNullParameter(var4, "locationNamePlaceholderProvider");
      super();
      this.$$delegate_0 = new DefaultCoroutineScope();
      this.appContext = var1;
      this.geoClient = var2;
      this.locationService = var3;
      this.locationNamePlaceholderProvider = var4;
      this.geocoder$delegate = LazyKt.lazy(new GeocodeService$$ExternalSyntheticLambda0(this));
      this.amapGeocoder$delegate = LazyKt.lazy(new GeocodeService$$ExternalSyntheticLambda1(this));
   }

   // $FF: synthetic method
   public static final Object access$getTrackedLocationUsingAmap(GeocodeService var0, TrackedLocation var1, Continuation var2) {
      return var0.getTrackedLocationUsingAmap(var1, var2);
   }

   private static final AmapGeocoder amapGeocoder_delegate$lambda$1(GeocodeService var0) {
      return new AmapGeocoder(var0.appContext, var0.locationNamePlaceholderProvider);
   }

   private static final android.location.Geocoder geocoder_delegate$lambda$0(GeocodeService var0) {
      return new android.location.Geocoder(var0.appContext);
   }

   private final Geocoder getAmapGeocoder() {
      return (Geocoder)this.amapGeocoder$delegate.getValue();
   }

   private final String getCityName(Address var1) {
      if (var1 != null) {
         CharSequence var2 = (CharSequence)var1.getLocality();
         String var3;
         if (var2 != null && var2.length() != 0) {
            var3 = var1.getLocality();
         } else {
            var2 = (CharSequence)var1.getSubAdminArea();
            if (var2 != null && var2.length() != 0) {
               var3 = var1.getSubAdminArea();
            } else {
               var2 = (CharSequence)var1.getAdminArea();
               if (var2 != null && var2.length() != 0) {
                  var3 = var1.getAdminArea();
               } else {
                  var2 = (CharSequence)var1.getAddressLine(0);
                  if (var2 != null && var2.length() != 0) {
                     var3 = var1.getAddressLine(0);
                  } else {
                     var3 = this.locationNamePlaceholderProvider.getUnknownCity();
                  }
               }
            }
         }

         if (var3 != null) {
            return var3;
         }
      }

      return this.locationNamePlaceholderProvider.getUnknownCity();
   }

   private final android.location.Geocoder getGeocoder() {
      return (android.location.Geocoder)this.geocoder$delegate.getValue();
   }

   private final String getStationName(Address var1) {
      if (var1 != null) {
         CharSequence var2 = (CharSequence)var1.getFeatureName();
         if (var2 != null && var2.length() != 0) {
            var2 = (CharSequence)var1.getThoroughfare();
            if (var2 != null && var2.length() != 0 && !Intrinsics.areEqual(var1.getFeatureName(), var1.getThoroughfare())) {
               Timber.Forest.d("Station is throughfare: %s", new Object[]{var1.getThoroughfare()});
               StringBuilder var5 = new StringBuilder();
               var5.append(var1.getFeatureName());
               var5.append(' ');
               var5.append(var1.getThoroughfare());
               return var5.toString();
            } else {
               return var1.getFeatureName();
            }
         } else {
            var2 = (CharSequence)var1.getThoroughfare();
            return var2 != null && var2.length() != 0 ? var1.getThoroughfare() : this.locationNamePlaceholderProvider.getUnknownStationName();
         }
      } else {
         return this.locationNamePlaceholderProvider.getUnknownStationName();
      }
   }

   private final Object getTrackedLocationUsingAmap(TrackedLocation var1, Continuation var2) {
      return this.getAmapGeocoder().getTrackedLocation(var1, var2);
   }

   private final TrackedLocation getTrackedLocationUsingGoogle(TrackedLocation var1) {
      String var5 = null;

      Address var3;
      label148: {
         Throwable var10000;
         label152: {
            List var15;
            try {
               Pair var2 = var1.getLatLngInGCJ();
               var15 = this.getGeocoder().getFromLocation(((Number)var2.getFirst()).doubleValue(), ((Number)var2.getSecond()).doubleValue(), 1);
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var10001 = false;
               break label152;
            }

            if (var15 == null) {
               var3 = null;
               break label148;
            }

            label142:
            try {
               var3 = (Address)CollectionsKt.firstOrNull(var15);
               break label148;
            } catch (Throwable var12) {
               var10000 = var12;
               boolean var20 = false;
               break label142;
            }
         }

         Throwable var14 = var10000;
         Timber.Forest.e(var14, "geocodeBreezometerGoogle: geocoder.getFromLocation failed", new Object[0]);
         return null;
      }

      if (var3 != null) {
         Timber.Forest.d("geocodeBreezometerGoogle: address: locality = %s, subLocality = %s, \nthoroughfare = %s, subThoroughfare = %s, adminArea = %s, subAdminArea = %s, \npremises = %s, featureName = %s", new Object[]{var3.getLocality(), var3.getSubLocality(), var3.getThoroughfare(), var3.getSubThoroughfare(), var3.getAdminArea(), var3.getSubAdminArea(), var3.getPremises(), var3.getFeatureName()});
      }

      String var16;
      if (var3 != null) {
         String var4 = var3.getAdminArea();
         var16 = var4;
         if (var4 == null) {
            var4 = var3.getSubAdminArea();
            var16 = var4;
            if (var4 == null) {
               var4 = var3.getLocality();
               var16 = var4;
               if (var4 == null) {
                  var16 = var3.getSubLocality();
               }
            }
         }
      } else {
         var16 = null;
      }

      String var7 = this.getStationName(var3);
      String var6 = this.getCityName(var3);
      String var19;
      if (var3 != null) {
         var19 = var3.getCountryName();
      } else {
         var19 = null;
      }

      if (var3 != null) {
         var5 = var3.getCountryCode();
      }

      return TrackedLocation.copy$default(var1, (String)null, (double)0.0F, (double)0.0F, var7, var6, var16, var19, var5, (String)null, 263, (Object)null);
   }

   private final Object getTrackedLocationUsingMapBox(TrackedLocation var1, Continuation var2) {
      Object var8;
      label577: {
         if (var2 instanceof <undefinedtype>) {
            var8 = (<undefinedtype>)var2;
            if ((((<undefinedtype>)var8).label & Integer.MIN_VALUE) != 0) {
               ((<undefinedtype>)var8).label += Integer.MIN_VALUE;
               break label577;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            int label;
            Object result;
            final GeocodeService this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getTrackedLocationUsingMapBox((TrackedLocation)null, (Continuation)this);
            }
         };
      }

      String var13;
      MbGeoLocations var67;
      TrackedLocation var73;
      label571: {
         Object var53;
         label581: {
            Object var22 = ((<undefinedtype>)var8).result;
            Object var14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var7 = ((<undefinedtype>)var8).label;
            var13 = "CN";
            Pair var9;
            double[] var10;
            MbGeoLocations var17;
            TrackedLocation var23;
            if (var7 != 0) {
               if (var7 != 1) {
                  if (var7 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var1 = (TrackedLocation)((<undefinedtype>)var8).L$4;
                  double[] var51 = (double[])((<undefinedtype>)var8).L$3;
                  MbGeoLocations var64 = (MbGeoLocations)((<undefinedtype>)var8).L$2;
                  Pair var52 = (Pair)((<undefinedtype>)var8).L$1;
                  var45 = (TrackedLocation)((<undefinedtype>)var8).L$0;
                  ResultKt.throwOnFailure(var22);
                  var53 = var22;
                  var24 = var64;
                  break label581;
               }

               var10 = (double[])((<undefinedtype>)var8).L$3;
               var17 = (MbGeoLocations)((<undefinedtype>)var8).L$2;
               var9 = (Pair)((<undefinedtype>)var8).L$1;
               var73 = (TrackedLocation)((<undefinedtype>)var8).L$0;
               ResultKt.throwOnFailure(var22);
               var67 = (MbGeoLocations)var22;
               var23 = var73;
            } else {
               ResultKt.throwOnFailure(var22);
               Pair var70 = var1.getLatLngInWGS();

               label566: {
                  label565:
                  try {
                     Response var25 = this.geoClient.getLocations(String.valueOf(((Number)var70.getFirst()).doubleValue()), String.valueOf(((Number)var70.getSecond()).doubleValue())).execute();
                     Timber.Forest.d("geocodeBreezometerMb response: %s", new Object[]{var25.toString()});
                     if (var25.isSuccessful()) {
                        var26 = (MbGeoLocations)var25.body();
                        break label566;
                     }
                  } catch (Throwable var16) {
                     Timber.Forest.e(var16, "geocodeBreezometerMb: mbGeoService.getLocations failed", new Object[0]);
                     break label565;
                  }

                  var26 = null;
               }

               Timber.Forest.d("geocodeBreezometerMb locations: %s", new Object[]{String.valueOf(var26)});
               var10 = CoordinateTransformUtils.INSTANCE.wgs84togcj02(((Number)var70.getSecond()).doubleValue(), ((Number)var70.getFirst()).doubleValue(), Boxing.boxBoolean(true));
               double var3 = var10[1];
               double var5 = var10[0];
               TrackedLocation var54 = var1;
               TrackedLocation var19 = TrackedLocation.copy$default(var1, (String)null, var3, var5, (String)null, (String)null, (String)null, (String)null, (String)null, "GCJ", 249, (Object)null);
               ((<undefinedtype>)var8).L$0 = var54;
               ((<undefinedtype>)var8).L$1 = SpillingKt.nullOutSpilledVariable(var70);
               ((<undefinedtype>)var8).L$2 = var26;
               ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var10);
               ((<undefinedtype>)var8).label = 1;
               var67 = (MbGeoLocations)getTrackedLocationUsingMapBox$getLocationWithCountryCode(this, var19, (Continuation)var8);
               if (var67 == var14) {
                  return var14;
               }

               var17 = var26;
               var23 = var54;
               var9 = var70;
            }

            TrackedLocation var66 = (TrackedLocation)var67;
            String var71;
            if (var66 != null) {
               var71 = var66.getCountryCode();
            } else {
               var71 = null;
            }

            if (Intrinsics.areEqual(var71, "CN")) {
               var46 = var66;
               var73 = var23;
               var27 = null;
               var67 = var17;
               break label571;
            }

            TrackedLocation var72 = TrackedLocation.copy$default(var23, (String)null, (double)0.0F, (double)0.0F, (String)null, (String)null, (String)null, (String)null, (String)null, "WGS", 255, (Object)null);
            ((<undefinedtype>)var8).L$0 = var23;
            ((<undefinedtype>)var8).L$1 = SpillingKt.nullOutSpilledVariable(var9);
            ((<undefinedtype>)var8).L$2 = var17;
            ((<undefinedtype>)var8).L$3 = SpillingKt.nullOutSpilledVariable(var10);
            ((<undefinedtype>)var8).L$4 = var66;
            ((<undefinedtype>)var8).label = 2;
            var53 = getTrackedLocationUsingMapBox$getLocationWithCountryCode(this, var72, (Continuation)var8);
            if (var53 == var14) {
               return var14;
            }

            var45 = var23;
            var24 = var17;
            var1 = var66;
         }

         TrackedLocation var55 = (TrackedLocation)var53;
         var73 = var45;
         var67 = var24;
         var46 = var1;
         var27 = var55;
      }

      String var56;
      if (var27 != null) {
         var56 = var27.getCountryCode();
      } else {
         var56 = null;
      }

      String var20 = var13;
      if (!Intrinsics.areEqual(var56, "CN")) {
         if (var46 != null) {
            var20 = var46.getCountryCode();
         } else {
            var20 = null;
         }

         if (Intrinsics.areEqual(var20, "CN")) {
            var20 = var13;
         } else {
            label543: {
               if (var46 != null) {
                  String var47 = var46.getCountryCode();
                  var20 = var47;
                  if (var47 != null) {
                     break label543;
                  }
               }

               if (var27 != null) {
                  var20 = var27.getCountryCode();
               } else {
                  var20 = null;
               }
            }
         }
      }

      String var65 = this.locationNamePlaceholderProvider.getUnknownCity();
      var13 = this.locationNamePlaceholderProvider.getUnknownStationName();
      String var44;
      String var50;
      String var69;
      if (var67 != null) {
         Iterator var48 = ((Iterable)var67.getFeatures()).iterator();

         do {
            if (!var48.hasNext()) {
               var28 = null;
               break;
            }

            var28 = var48.next();
         } while(!((MbLocationFeatures)var28).getPlace_type().contains("country"));

         MbLocationFeatures var29 = (MbLocationFeatures)var28;
         String var49;
         if (var29 != null) {
            var49 = var29.getText();
         } else {
            var49 = null;
         }

         Iterator var57 = ((Iterable)var67.getFeatures()).iterator();

         do {
            if (!var57.hasNext()) {
               var30 = null;
               break;
            }

            var30 = var57.next();
         } while(!((MbLocationFeatures)var30).getPlace_type().contains("region"));

         MbLocationFeatures var58 = (MbLocationFeatures)var30;
         var29 = var58;
         if (var58 == null) {
            Iterator var59 = ((Iterable)var67.getFeatures()).iterator();

            do {
               if (!var59.hasNext()) {
                  var32 = null;
                  break;
               }

               var32 = var59.next();
            } while(!((MbLocationFeatures)var32).getPlace_type().contains("district"));

            MbLocationFeatures var60 = (MbLocationFeatures)var32;
            var29 = var60;
            if (var60 == null) {
               Iterator var61 = ((Iterable)var67.getFeatures()).iterator();

               do {
                  if (!var61.hasNext()) {
                     var33 = null;
                     break;
                  }

                  var33 = var61.next();
               } while(!((MbLocationFeatures)var33).getPlace_type().contains("place"));

               var29 = (MbLocationFeatures)var33;
            }
         }

         String var62;
         if (var29 != null) {
            var62 = var29.getText();
         } else {
            var62 = null;
         }

         Iterator var76 = ((Iterable)var67.getFeatures()).iterator();

         do {
            if (!var76.hasNext()) {
               var34 = null;
               break;
            }

            var34 = var76.next();
         } while(!((MbLocationFeatures)var34).getPlace_type().contains("place"));

         MbLocationFeatures var77 = (MbLocationFeatures)var34;
         var29 = var77;
         if (var77 == null) {
            Iterator var78 = ((Iterable)var67.getFeatures()).iterator();

            do {
               if (!var78.hasNext()) {
                  var36 = null;
                  break;
               }

               var36 = var78.next();
            } while(!((MbLocationFeatures)var36).getPlace_type().contains("district"));

            MbLocationFeatures var79 = (MbLocationFeatures)var36;
            var29 = var79;
            if (var79 == null) {
               Iterator var80 = ((Iterable)var67.getFeatures()).iterator();

               do {
                  if (!var80.hasNext()) {
                     var37 = null;
                     break;
                  }

                  var37 = var80.next();
               } while(!((MbLocationFeatures)var37).getPlace_type().contains("region"));

               MbLocationFeatures var81 = (MbLocationFeatures)var37;
               var29 = var81;
               if (var81 == null) {
                  Iterator var82 = ((Iterable)var67.getFeatures()).iterator();

                  do {
                     if (!var82.hasNext()) {
                        var38 = null;
                        break;
                     }

                     var38 = var82.next();
                  } while(!((MbLocationFeatures)var38).getPlace_type().contains("country"));

                  var29 = (MbLocationFeatures)var38;
               }
            }
         }

         if (var29 != null) {
            var65 = var29.getText();
         }

         Iterator var83 = ((Iterable)var67.getFeatures()).iterator();

         do {
            if (!var83.hasNext()) {
               var39 = null;
               break;
            }

            var39 = var83.next();
         } while(!((MbLocationFeatures)var39).getPlace_type().contains("poi"));

         MbLocationFeatures var84 = (MbLocationFeatures)var39;
         var29 = var84;
         if (var84 == null) {
            Iterator var85 = ((Iterable)var67.getFeatures()).iterator();

            do {
               if (!var85.hasNext()) {
                  var41 = null;
                  break;
               }

               var41 = var85.next();
            } while(!((MbLocationFeatures)var41).getPlace_type().contains("address"));

            MbLocationFeatures var86 = (MbLocationFeatures)var41;
            var29 = var86;
            if (var86 == null) {
               Iterator var87 = ((Iterable)var67.getFeatures()).iterator();

               do {
                  if (!var87.hasNext()) {
                     var42 = null;
                     break;
                  }

                  var42 = var87.next();
               } while(!((MbLocationFeatures)var42).getPlace_type().contains("neighborhood"));

               MbLocationFeatures var88 = (MbLocationFeatures)var42;
               var29 = var88;
               if (var88 == null) {
                  Iterator var68 = ((Iterable)var67.getFeatures()).iterator();

                  do {
                     if (!var68.hasNext()) {
                        var43 = null;
                        break;
                     }

                     var43 = var68.next();
                  } while(!((MbLocationFeatures)var43).getPlace_type().contains("locality"));

                  var29 = (MbLocationFeatures)var43;
               }
            }
         }

         var69 = var13;
         if (var29 != null) {
            var69 = var29.getText();
         }

         var44 = var49;
         var50 = var62;
      } else {
         var50 = null;
         var44 = null;
         var69 = var13;
      }

      Timber.Forest var75 = Timber.Forest;
      StringBuilder var63 = new StringBuilder("geocodeBreezometerMb: tracked location state: ");
      var63.append(var69);
      var63.append(", city: ");
      var63.append(var65);
      var63.append(", station: ");
      var63.append(var69);
      var63.append(", countryCode: ");
      var63.append(var20);
      var75.d(var63.toString(), new Object[0]);
      return TrackedLocation.copy$default(var73, (String)null, (double)0.0F, (double)0.0F, var69, var65, var50, var44, var20, (String)null, 263, (Object)null);
   }

   private static final Object getTrackedLocationUsingMapBox$getLocationWithCountryCode(GeocodeService var0, TrackedLocation var1, Continuation var2) {
      label27: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var6 = var4;
               break label27;
            }
         }

         var6 = new ContinuationImpl(var2) {
            Object L$0;
            Object L$1;
            int label;
            Object result;

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return GeocodeService.getTrackedLocationUsingMapBox$getLocationWithCountryCode((GeocodeService)null, (TrackedLocation)null, (Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var6).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var6).label;
      Object var7;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = (TrackedLocation)((<undefinedtype>)var6).L$1;
         var0 = (GeocodeService)((<undefinedtype>)var6).L$0;
         ResultKt.throwOnFailure(var9);
         var7 = var9;
      } else {
         ResultKt.throwOnFailure(var9);
         ((<undefinedtype>)var6).L$0 = var0;
         ((<undefinedtype>)var6).L$1 = var1;
         ((<undefinedtype>)var6).label = 1;
         var9 = var0.getTrackedLocationUsingAmap(var1, (Continuation)var6);
         var7 = var9;
         if (var9 == var5) {
            return var5;
         }
      }

      TrackedLocation var8 = (TrackedLocation)var7;
      return var8 == null ? var0.getTrackedLocationUsingGoogle(var1) : var8;
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public final Object getTrackedLocation(TrackedLocation var1, Continuation var2) {
      LocationService.MapType var4 = this.locationService.getMapType();
      int var3 = GeocodeService.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
      if (var3 != 1) {
         if (var3 != 2) {
            if (var3 == 3) {
               Object var5 = this.getTrackedLocationUsingMapBox(var1, var2);
               return var5 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var5 : (TrackedLocation)var5;
            } else {
               throw new NoWhenBranchMatchedException();
            }
         } else {
            return this.getTrackedLocationUsingGoogle(var1);
         }
      } else {
         return this.getTrackedLocationUsingAmap(var1, var2);
      }
   }

   public final List mapboxSearch(String var1, String var2, String var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "query");
      Intrinsics.checkNotNullParameter(var2, "lngLat");
      Intrinsics.checkNotNullParameter(var3, "countryCode");
      Response var5 = this.geoClient.query(var1, var2, var3, var4).execute();
      if (var5.isSuccessful()) {
         MbGeoLocations var6 = (MbGeoLocations)var5.body();
         if (var6 != null) {
            List var7 = var6.getFeatures();
            if (var7 != null) {
               return var7;
            }
         }

         return CollectionsKt.emptyList();
      } else {
         return CollectionsKt.emptyList();
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
         int[] var0 = new int[LocationService.MapType.values().length];

         try {
            var0[LocationService.MapType.AMAP.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[LocationService.MapType.GOOGLE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[LocationService.MapType.MAPBOX.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
