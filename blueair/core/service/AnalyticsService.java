package com.blueair.core.service;

import android.app.Application;
import android.os.Bundle;
import com.amplitude.api.Amplitude;
import com.amplitude.api.AmplitudeClient;
import com.amplitude.api.Identify;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.OnboardingFlowEvent;
import com.blueair.core.model.OnboardingStartedEvent;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0019J$\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00182\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/core/service/AnalyticsService;", "", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "firebase", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "getFirebase", "()Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebase$delegate", "Lkotlin/Lazy;", "amplitude", "Lcom/amplitude/api/AmplitudeClient;", "initAmplitude", "", "debug", "", "inChina", "event", "Lcom/blueair/core/model/AnalyticEvent;", "firebaseLog", "amplitudeLog", "onboardingId", "", "Lcom/blueair/core/model/AmplitudeEvent;", "setUserId", "ablUid", "gigyaUid", "cloudRegion", "setPropertyCloudRegion", "setWelcomeHomeEnabled", "enabled", "CrashlyticsTree", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AnalyticsService {
   private static final String AMPLITUDE_DEBUG_KEY = "ad41433cbd2c7506305377c8db044ea1";
   private static final String AMPLITUDE_RELEASE_KEY = "077494ebdb38272b5ba3b7b4b5cc3f2f";
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private AmplitudeClient amplitude;
   private final Application application;
   private final Lazy firebase$delegate;
   private String onboardingId;

   // $FF: synthetic method
   public static FirebaseAnalytics $r8$lambda$Rc648iljyhdqm5KfoSAFIkyUoiw(AnalyticsService var0) {
      return firebase_delegate$lambda$0(var0);
   }

   public AnalyticsService(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super();
      this.application = var1;
      this.firebase$delegate = LazyKt.lazy(new AnalyticsService$$ExternalSyntheticLambda0(this));
      this.getFirebase().setUserProperty("versionCode", String.valueOf(BuildEnvironment.INSTANCE.getVersionCode()));
   }

   private final void amplitudeLog(AnalyticEvent var1) {
      JSONObject var2 = new JSONObject();

      for(Map.Entry var4 : var1.getPayload().entrySet()) {
         String var5 = (String)var4.getKey();
         Object var10 = var4.getValue();

         try {
            if (var10 instanceof Integer) {
               var2.put(var5, ((Number)var10).intValue());
            } else if (var10 instanceof String) {
               var2.put(var5, var10);
            } else if (var10 instanceof Boolean) {
               var2.put(var5, (Boolean)var10);
            } else {
               Timber.Forest var13 = Timber.Forest;
               StringBuilder var6 = new StringBuilder();
               var6.append("amplitudeLog: Event type not supported ");
               var6.append(var10);
               var13.e(var6.toString(), new Object[0]);
               Unit var11 = Unit.INSTANCE;
            }
         } catch (JSONException var7) {
            Timber.Forest.e(var7.getLocalizedMessage(), new Object[0]);
         }
      }

      Timber.Forest var8 = Timber.Forest;
      StringBuilder var12 = new StringBuilder("amplitudeLog: event: name = ");
      var12.append(var1.getEventName());
      var12.append(", json = ");
      var12.append(var2);
      var8.v(var12.toString(), new Object[0]);
      AmplitudeClient var9 = this.amplitude;
      if (var9 != null) {
         var9.logEvent(var1.getEventName(), var2);
      }

   }

   private final void firebaseLog(AnalyticEvent var1) {
      Bundle var2 = new Bundle();

      for(Map.Entry var4 : var1.getPayload().entrySet()) {
         String var5 = (String)var4.getKey();
         Object var8 = var4.getValue();
         if (var8 instanceof Integer) {
            var2.putInt(var5, ((Number)var8).intValue());
         } else if (var8 instanceof Long) {
            var2.putLong(var5, ((Number)var8).longValue());
         } else if (var8 instanceof String) {
            var2.putString(var5, (String)var8);
         } else if (var8 instanceof Boolean) {
            var2.putBoolean(var5, (Boolean)var8);
         } else {
            Timber.Forest var10 = Timber.Forest;
            StringBuilder var6 = new StringBuilder("firebaseLog: Event type not supported ");
            var6.append(var8);
            var10.e(var6.toString(), new Object[0]);
         }
      }

      Timber.Forest var9 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("firebaseLog: event: name = ");
      var7.append(var1.getEventName());
      var7.append(", bundle = ");
      var7.append(var2);
      var9.v(var7.toString(), new Object[0]);
      UserInfoCollectionsManager.addRecord$default(UserInfoCollectionsManager.INSTANCE, UserInfoItem.USER_BEHAVIOR, var1.getEventName(), false, 4, (Object)null);
      this.getFirebase().logEvent(var1.getEventName(), var2);
   }

   private static final FirebaseAnalytics firebase_delegate$lambda$0(AnalyticsService var0) {
      FirebaseAnalytics var1 = FirebaseAnalytics.getInstance(var0.application.getApplicationContext());
      Intrinsics.checkNotNullExpressionValue(var1, "getInstance(...)");
      var1.setAnalyticsCollectionEnabled(true);
      return var1;
   }

   private final FirebaseAnalytics getFirebase() {
      return (FirebaseAnalytics)this.firebase$delegate.getValue();
   }

   public final void amplitudeLog(AmplitudeEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      Timber.Forest.d("Logging amplitude event: %s", new Object[]{var1.toString()});
      if (var1 instanceof OnboardingStartedEvent) {
         this.onboardingId = UUID.randomUUID().toString();
      }

      JSONObject var2 = new JSONObject();
      Map var3 = var1.getProps();
      if (var3 != null) {
         Set var8 = var3.entrySet();
         if (var8 != null) {
            for(Map.Entry var5 : (Iterable)var8) {
               try {
                  Object var4 = var5.getValue();
                  if (var4 instanceof Integer) {
                     var2.put((String)var5.getKey(), ((Number)var4).intValue());
                  } else if (var4 instanceof String) {
                     var2.put((String)var5.getKey(), var4);
                  } else if (var4 instanceof Boolean) {
                     var2.put((String)var5.getKey(), (Boolean)var4);
                  } else {
                     Timber.Forest var6 = Timber.Forest;
                     StringBuilder var12 = new StringBuilder();
                     var12.append("amplitudeLog: Event type not supported ");
                     var12.append(var4);
                     var6.e(var12.toString(), new Object[0]);
                     Unit var11 = Unit.INSTANCE;
                  }
               } catch (JSONException var7) {
                  Timber.Forest.e(var7.getLocalizedMessage(), new Object[0]);
               }
            }
         }
      }

      if (var1 instanceof OnboardingFlowEvent) {
         var2.put("Onboarding ID", this.onboardingId);
      }

      AmplitudeClient var10 = this.amplitude;
      if (var10 != null) {
         var10.logEvent(var1.getEventName(), var2);
      }

   }

   public final void event(AnalyticEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      this.firebaseLog(var1);
   }

   public final void initAmplitude(boolean var1, boolean var2) {
      String var3;
      if (var1) {
         var3 = "ad41433cbd2c7506305377c8db044ea1";
      } else {
         var3 = "077494ebdb38272b5ba3b7b4b5cc3f2f";
      }

      AmplitudeClient var4 = this.amplitude;
      if (var4 == null || var4.initialize(this.application.getApplicationContext(), var3) == null) {
         var4 = Amplitude.getInstance();
         if (var2) {
            var4.setServerUrl("api2.amplitude.com");
         }

         this.amplitude = var4.initialize(this.application.getApplicationContext(), var3);
      }

      AmplitudeClient var5 = this.amplitude;
      if (var5 != null) {
         var5.enableForegroundTracking(this.application);
      }

   }

   public final void setPropertyCloudRegion(String var1) {
      this.getFirebase().setUserProperty("cloudRegion", var1);
   }

   public final void setUserId(String var1, String var2, String var3) {
      this.getFirebase().setUserId(var1);
      this.getFirebase().setUserProperty("gigyaUid", var2);
      this.getFirebase().setUserProperty("cloudRegion", var3);
      AmplitudeClient var4 = this.amplitude;
      if (var4 != null) {
         var4.setUserId(var2);
      }

   }

   public final void setWelcomeHomeEnabled(boolean var1) {
      String var2;
      if (var1) {
         var2 = "enabled";
      } else {
         var2 = "disabled";
      }

      AmplitudeClient var3 = this.amplitude;
      if (var3 != null) {
         var3.identify((new Identify()).set("Welcome home", var2));
      }

   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/core/service/AnalyticsService$Companion;", "", "<init>", "()V", "AMPLITUDE_DEBUG_KEY", "", "AMPLITUDE_RELEASE_KEY", "core_otherRelease"},
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

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014¨\u0006\r"},
      d2 = {"Lcom/blueair/core/service/AnalyticsService$CrashlyticsTree;", "Ltimber/log/Timber$Tree;", "<init>", "()V", "log", "", "priority", "", "tag", "", "message", "t", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class CrashlyticsTree extends Timber.Tree {
      protected void log(int var1, String var2, String var3, Throwable var4) {
         Intrinsics.checkNotNullParameter(var3, "message");
         if (var1 != 2 && var1 != 3 && var1 != 4 && var1 != 5) {
            FirebaseCrashlytics var5 = FirebaseCrashlytics.getInstance();
            Throwable var6 = var4;
            if (var4 == null) {
               var6 = (Throwable)(new Exception(var3));
            }

            var5.recordException(var6);
         }

      }
   }
}
