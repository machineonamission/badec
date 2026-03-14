package com.blueair.devicemanager;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.service.UnsecurePrefs;
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
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J \u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\u0018\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J(\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0014\u00106\u001a\u00020\u000f2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908J\u0006\u0010:\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R+\u0010*\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010\u0013R+\u00100\u001a\u00020/2\u0006\u0010)\u001a\u00020/8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b1\u00102\"\u0004\b3\u00104R+\u0010;\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u000f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010.\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013¨\u0006@"},
   d2 = {"Lcom/blueair/devicemanager/WelcomeHomeService;", "", "context", "Landroid/content/Context;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "<init>", "(Landroid/content/Context;Lcom/blueair/core/service/UnsecurePrefs;)V", "geofenceClient", "Lcom/google/android/gms/location/GeofencingClient;", "getGeofenceClient", "()Lcom/google/android/gms/location/GeofencingClient;", "geofenceClient$delegate", "Lkotlin/Lazy;", "countryAvailable", "", "getCountryAvailable", "()Z", "setCountryAvailable", "(Z)V", "addWelcomeHomeLocation", "", "deviceId", "", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "setWelcomeHomeLocation", "isMinimal", "addGeofence", "request", "Lcom/google/android/gms/location/GeofencingRequest;", "disableWelcomeHomeLocation", "setEnabledForDevice", "buildGeofence", "Lcom/google/android/gms/location/Geofence;", "requestId", "lat", "", "lng", "radius", "", "<set-?>", "shouldShowDev", "getShouldShowDev", "setShouldShowDev", "shouldShowDev$delegate", "Lkotlin/properties/ReadWriteProperty;", "", "whExploreShowedCount", "getWhExploreShowedCount", "()I", "setWhExploreShowedCount", "(I)V", "whExploreShowedCount$delegate", "shouldShowWHExplore", "devices", "", "Lcom/blueair/core/model/Device;", "setWelcomeHomeAsShowed", "addHomeInstructionsShowed", "getAddHomeInstructionsShowed", "setAddHomeInstructionsShowed", "addHomeInstructionsShowed$delegate", "Companion", "devicemanager_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class WelcomeHomeService {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(WelcomeHomeService.class, "shouldShowDev", "getShouldShowDev()Z", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(WelcomeHomeService.class, "whExploreShowedCount", "getWhExploreShowedCount()I", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(WelcomeHomeService.class, "addHomeInstructionsShowed", "getAddHomeInstructionsShowed()Z", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String KEY_ADD_HOME_INSTRUCTIONS_SHOWED = "key_add_home_instructions_showed";
   private static final String KEY_WH_EXPLORE_SHOWED_COUNT = "key_wh_explore_showed_count";
   private static final String KEY_WH_SHOW_DEV = "key_wh_show_dev";
   public static final float MIN_RADIUS = 200.0F;
   public static final String MIN_RADIUS_KEY_SUFFIX = "-min_radius";
   private final ReadWriteProperty addHomeInstructionsShowed$delegate;
   private final Context context;
   private boolean countryAvailable;
   private final Lazy geofenceClient$delegate;
   private final ReadWriteProperty shouldShowDev$delegate;
   private final ReadWriteProperty whExploreShowedCount$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$1rA8JYWhsX8sBMK8MirZotcJGaM(String var0, Exception var1) {
      addGeofence$lambda$4$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$D929FaBXGAB5ZvF9VprwGODTlNA(String var0, Void var1) {
      return disableWelcomeHomeLocation$lambda$8$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ISGpMahMID53bmlfWggnY1Ri8M0(Function1 var0, Object var1) {
      addGeofence$lambda$4$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$QE0sz3Jbq1tkTN92BWmSiTPkF6k(Function1 var0, Object var1) {
      disableWelcomeHomeLocation$lambda$8$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$_oCOpqkLYDgjtblp3hD7CafE5VM(String var0, Exception var1) {
      disableWelcomeHomeLocation$lambda$8$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static GeofencingClient $r8$lambda$kpyPkrWL1fd3Frjb1e2DNlFEW8E(WelcomeHomeService var0) {
      return geofenceClient_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$kvjNzAycaTeXVZOsNF1aBGPQ6Yo(String var0, Void var1) {
      return addGeofence$lambda$4$lambda$1(var0, var1);
   }

   public WelcomeHomeService(Context var1, UnsecurePrefs var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "prefs");
      super();
      this.context = var1;
      this.geofenceClient$delegate = LazyKt.lazy(new WelcomeHomeService$$ExternalSyntheticLambda0(this));
      Prefs var4 = var2;
      Boolean var5 = false;
      this.shouldShowDev$delegate = (ReadWriteProperty)(new ObservableProperty(var4, "key_wh_show_dev", var5, PreferencesHelper.INSTANCE.get(var4.getBackend(), "key_wh_show_dev", var5, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var5 = this.$prefs;
               String var4 = this.$key;
               PreferencesHelper.INSTANCE.set(var5.getBackend(), var4, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      Integer var3 = 0;
      this.whExploreShowedCount$delegate = (ReadWriteProperty)(new ObservableProperty(var4, "key_wh_explore_showed_count", var3, PreferencesHelper.INSTANCE.get(var4.getBackend(), "key_wh_explore_showed_count", var3, Reflection.getOrCreateKotlinClass(Integer.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Integer.class));
            }

         }
      });
      this.addHomeInstructionsShowed$delegate = (ReadWriteProperty)(new ObservableProperty(var4, "key_add_home_instructions_showed", var5, PreferencesHelper.INSTANCE.get(var4.getBackend(), "key_add_home_instructions_showed", var5, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
   }

   private final void addGeofence(String var1, GeofencingRequest var2) {
      Intent var4 = new Intent(this.context, WelcomeHomeBroadcastReceiver.class);
      int var3;
      if (VERSION.SDK_INT >= 31) {
         var3 = 167772160;
      } else {
         var3 = 134217728;
      }

      PendingIntent var6 = PendingIntent.getBroadcast(this.context, 0, var4, var3);
      Task var5 = this.getGeofenceClient().addGeofences(var2, var6);
      var5.addOnSuccessListener(new WelcomeHomeService$$ExternalSyntheticLambda2(new WelcomeHomeService$$ExternalSyntheticLambda1(var1)));
      var5.addOnFailureListener(new WelcomeHomeService$$ExternalSyntheticLambda3(var1));
   }

   private static final Unit addGeofence$lambda$4$lambda$1(String var0, Void var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Geofence add success for ");
      var2.append(var0);
      var3.d(var2.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void addGeofence$lambda$4$lambda$2(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final void addGeofence$lambda$4$lambda$3(String var0, Exception var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Geofence add failure for ");
      var2.append(var0);
      var3.d(var2.toString(), new Object[0]);
   }

   private final Geofence buildGeofence(String var1, double var2, double var4, float var6) {
      Geofence var7 = (new Geofence.Builder()).setRequestId(var1).setCircularRegion(var2, var4, var6).setTransitionTypes(3).setExpirationDuration(-1L).build();
      Intrinsics.checkNotNullExpressionValue(var7, "build(...)");
      return var7;
   }

   private static final Unit disableWelcomeHomeLocation$lambda$8$lambda$5(String var0, Void var1) {
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Geofence remove success for ");
      var2.append(var0);
      var3.d(var2.toString(), new Object[0]);
      return Unit.INSTANCE;
   }

   private static final void disableWelcomeHomeLocation$lambda$8$lambda$6(Function1 var0, Object var1) {
      var0.invoke(var1);
   }

   private static final void disableWelcomeHomeLocation$lambda$8$lambda$7(String var0, Exception var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("Geofence remove failure for ");
      var3.append(var0);
      var2.d(var3.toString(), new Object[0]);
   }

   private static final GeofencingClient geofenceClient_delegate$lambda$0(WelcomeHomeService var0) {
      return LocationServices.getGeofencingClient(var0.context);
   }

   private final GeofencingClient getGeofenceClient() {
      return (GeofencingClient)this.geofenceClient$delegate.getValue();
   }

   private final int getWhExploreShowedCount() {
      return ((Number)this.whExploreShowedCount$delegate.getValue(this, $$delegatedProperties[1])).intValue();
   }

   private final void setWelcomeHomeLocation(String var1, WelcomeHomeLocation var2, boolean var3) {
      GeofencingRequest.Builder var10 = new GeofencingRequest.Builder();
      byte var9;
      if (var3) {
         var9 = 0;
      } else {
         var9 = 3;
      }

      GeofencingRequest.Builder var11 = var10.setInitialTrigger(var9);
      String var14;
      if (var3) {
         StringBuilder var13 = new StringBuilder();
         var13.append(var1);
         var13.append("-min_radius");
         var14 = var13.toString();
      } else {
         var14 = var1;
      }

      double var6 = var2.getLat();
      double var4 = var2.getLng();
      float var8;
      if (var3) {
         var8 = 200.0F;
      } else {
         var8 = (float)var2.getRadius();
      }

      GeofencingRequest var12 = var11.addGeofence(this.buildGeofence(var14, var6, var4, var8)).build();
      Intrinsics.checkNotNullExpressionValue(var12, "build(...)");
      this.addGeofence(var1, var12);
   }

   private final void setWhExploreShowedCount(int var1) {
      this.whExploreShowedCount$delegate.setValue(this, $$delegatedProperties[1], var1);
   }

   public final void addWelcomeHomeLocation(String var1, WelcomeHomeLocation var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "location");
      this.setWelcomeHomeLocation(var1, var2, false);
      this.setWelcomeHomeLocation(var1, var2, true);
   }

   public final void disableWelcomeHomeLocation(String var1) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      GeofencingClient var3 = this.getGeofenceClient();
      StringBuilder var2 = new StringBuilder();
      var2.append(var1);
      var2.append("-min_radius");
      Task var4 = var3.removeGeofences(CollectionsKt.listOf(new String[]{var1, var2.toString()}));
      var4.addOnSuccessListener(new WelcomeHomeService$$ExternalSyntheticLambda5(new WelcomeHomeService$$ExternalSyntheticLambda4(var1)));
      var4.addOnFailureListener(new WelcomeHomeService$$ExternalSyntheticLambda6(var1));
   }

   public final boolean getAddHomeInstructionsShowed() {
      return (Boolean)this.addHomeInstructionsShowed$delegate.getValue(this, $$delegatedProperties[2]);
   }

   public final boolean getCountryAvailable() {
      return this.countryAvailable;
   }

   public final boolean getShouldShowDev() {
      return (Boolean)this.shouldShowDev$delegate.getValue(this, $$delegatedProperties[0]);
   }

   public final void setAddHomeInstructionsShowed(boolean var1) {
      this.addHomeInstructionsShowed$delegate.setValue(this, $$delegatedProperties[2], var1);
   }

   public final void setCountryAvailable(boolean var1) {
      this.countryAvailable = var1;
   }

   public final void setEnabledForDevice(String var1, WelcomeHomeLocation var2) {
      Intrinsics.checkNotNullParameter(var1, "deviceId");
      Intrinsics.checkNotNullParameter(var2, "location");
      if (var2.isEnabled()) {
         this.addWelcomeHomeLocation(var1, var2);
      } else {
         this.disableWelcomeHomeLocation(var1);
      }
   }

   public final void setShouldShowDev(boolean var1) {
      this.shouldShowDev$delegate.setValue(this, $$delegatedProperties[0], var1);
   }

   public final void setWelcomeHomeAsShowed() {
      this.setWhExploreShowedCount(2);
   }

   public final boolean shouldShowWHExplore(List var1) {
      Intrinsics.checkNotNullParameter(var1, "devices");
      boolean var3 = this.getShouldShowDev();
      boolean var2 = false;
      if (var3) {
         this.setShouldShowDev(false);
         return true;
      } else if (!this.countryAvailable) {
         return false;
      } else if (this.getWhExploreShowedCount() >= 2) {
         return false;
      } else {
         Iterator var4 = ((Iterable)var1).iterator();

         do {
            if (!var4.hasNext()) {
               var5 = null;
               break;
            }

            var5 = var4.next();
         } while(!((Device)var5 instanceof HasWelcomeHome));

         if (var5 != null) {
            var2 = true;
         }

         if (var2) {
            this.setWhExploreShowedCount(this.getWhExploreShowedCount() + 1);
         }

         return var2;
      }
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"},
      d2 = {"Lcom/blueair/devicemanager/WelcomeHomeService$Companion;", "", "<init>", "()V", "MIN_RADIUS_KEY_SUFFIX", "", "MIN_RADIUS", "", "KEY_WH_EXPLORE_SHOWED_COUNT", "KEY_WH_SHOW_DEV", "KEY_ADD_HOME_INSTRUCTIONS_SHOWED", "devicemanager_otherRelease"},
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
}
