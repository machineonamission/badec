package com.blueair.android.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.android.R;
import com.blueair.android.databinding.HolderOutdoorLocationBinding;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.LocationUtils;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.OutdoorUiUtils;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u000e\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"},
   d2 = {"Lcom/blueair/android/adapter/OutdoorLocationItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/android/databinding/HolderOutdoorLocationBinding;", "trackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "aqiData", "Lcom/blueair/core/model/AqiData;", "useCurrentLocation", "", "<init>", "(Lcom/blueair/core/model/TrackedLocation;Lcom/blueair/core/model/AqiData;Z)V", "getTrackedLocation", "()Lcom/blueair/core/model/TrackedLocation;", "setTrackedLocation", "(Lcom/blueair/core/model/TrackedLocation;)V", "getAqiData", "()Lcom/blueair/core/model/AqiData;", "setAqiData", "(Lcom/blueair/core/model/AqiData;)V", "getUseCurrentLocation", "()Z", "type", "", "getType", "()I", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "bindView", "", "binding", "payloads", "", "", "hydrateProgress", "hydrateAqiData", "hydrateTrackedLocation", "isLocationEnable", "context", "Landroid/content/Context;", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class OutdoorLocationItem extends AbstractBindingItem {
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String PAYLOAD_AQIDATA = "payload_aqidata";
   public static final String PAYLOAD_PROGRESS = "payload_progress";
   public static final String PAYLOAD_TRACKED_LOCATION = "payload_tracked_location";
   private AqiData aqiData;
   private TrackedLocation trackedLocation;
   private final int type;
   private final boolean useCurrentLocation;

   public OutdoorLocationItem() {
      this((TrackedLocation)null, (AqiData)null, false, 7, (DefaultConstructorMarker)null);
   }

   public OutdoorLocationItem(TrackedLocation var1, AqiData var2, boolean var3) {
      this.trackedLocation = var1;
      this.aqiData = var2;
      this.useCurrentLocation = var3;
      this.type = R.layout.holder_outdoor_location;
   }

   // $FF: synthetic method
   public OutdoorLocationItem(TrackedLocation var1, AqiData var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 1) != 0) {
         var1 = null;
      }

      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   private final void hydrateAqiData(HolderOutdoorLocationBinding var1) {
      AqiData var5 = this.aqiData;
      if (var5 != null) {
         OutdoorPollutants var6 = var5.getPollutants();
         if (var6 != null) {
            Double var7 = var6.getCalculatedAQI();
            float var2;
            if (var7 != null) {
               var2 = (float)var7;
            } else {
               var2 = 0.0F;
            }

            int var3 = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition(var2, PollutantType.AQI.INSTANCE);
            if (var3 < 0) {
               var3 = OutdoorAirRatingRanges.INSTANCE.getMaxPollutantRangePosition(PollutantType.AQI.INSTANCE);
            }

            Context var8 = var1.getRoot().getContext();
            int var4 = ContextCompat.getColor(var8, ((Number)OutdoorUiUtils.INSTANCE.getAqiSeverityColorsNew().get(var3)).intValue());
            var1.airQualityIndicator.setBackgroundTintList(ColorStateList.valueOf(var4));
            var1.tvAirQuality.setText((CharSequence)var8.getResources().getStringArray(com.blueair.viewcore.R.array.severity_strings)[var3]);
         }
      }

   }

   private final void hydrateProgress(HolderOutdoorLocationBinding var1) {
      LottieAnimationView var2 = var1.progressView;
      Intrinsics.checkNotNullExpressionValue(var2, "progressView");
      ViewExtensionsKt.show$default((View)var2, false, 1, (Object)null);
      var1.progressView.playAnimation();
   }

   private final void hydrateTrackedLocation(HolderOutdoorLocationBinding var1) {
      Context var6 = var1.getRoot().getContext();
      if (this.useCurrentLocation) {
         Intrinsics.checkNotNull(var6);
         if (!this.isLocationEnable(var6)) {
            AppCompatTextView var19 = var1.tvEnableLocation;
            Intrinsics.checkNotNullExpressionValue(var19, "tvEnableLocation");
            ViewExtensionsKt.show$default((View)var19, false, 1, (Object)null);
            Group var10 = var1.groupInfo;
            Intrinsics.checkNotNullExpressionValue(var10, "groupInfo");
            ViewExtensionsKt.hide((View)var10);
            return;
         }
      }

      if (this.trackedLocation != null) {
         LottieAnimationView var3 = var1.progressView;
         var3.setVisibility(4);
         var3.pauseAnimation();
      }

      AppCompatTextView var11 = var1.tvEnableLocation;
      Intrinsics.checkNotNullExpressionValue(var11, "tvEnableLocation");
      ViewExtensionsKt.hide((View)var11);
      TrackedLocation var12 = this.trackedLocation;
      String var13;
      if (var12 != null) {
         var13 = var12.getLocationName();
      } else {
         var13 = null;
      }

      TrackedLocation var4 = this.trackedLocation;
      String var20;
      if (var4 != null) {
         var20 = var4.getCityName();
      } else {
         var20 = null;
      }

      TrackedLocation var5 = this.trackedLocation;
      String var21;
      if (var5 != null) {
         var21 = var5.getCountryName();
      } else {
         var21 = null;
      }

      AppCompatTextView var7;
      label81: {
         var7 = var1.tvLocation;
         CharSequence var8 = (CharSequence)var13;
         if (var8 != null && var8.length() != 0) {
            var8 = (CharSequence)var20;
            if (var8 != null && var8.length() != 0) {
               StringBuilder var22 = new StringBuilder();
               var22.append(var13);
               var22.append(", ");
               var22.append(var20);
               var15 = (CharSequence)var22.toString();
               break label81;
            }
         }

         CharSequence var14 = (CharSequence)var20;
         if (var14 == null || var14.length() == 0) {
            var15 = (CharSequence)var21;
            if (var15 == null || var15.length() == 0) {
               if (var15 == null || var15.length() == 0) {
                  if (this.useCurrentLocation) {
                     String var17 = var6.getString(com.blueair.viewcore.R.string.outdoor_location_current);
                     Intrinsics.checkNotNull(var17);
                     var15 = (CharSequence)var17;
                  } else {
                     String var18 = var6.getString(com.blueair.viewcore.R.string.unknown_city_placeholder);
                     Intrinsics.checkNotNull(var18);
                     var15 = (CharSequence)var18;
                  }
               }
               break label81;
            }
         }

         StringBuilder var16 = new StringBuilder();
         var16.append(var20);
         var16.append(", ");
         var16.append(var21);
         var15 = (CharSequence)var16.toString();
      }

      var7.setText(var15);
      int var2;
      if (this.useCurrentLocation) {
         var2 = com.blueair.viewcore.R.drawable.ic_current_location;
      } else {
         var2 = com.blueair.viewcore.R.drawable.ic_user_location;
      }

      var7.setCompoundDrawablesRelativeWithIntrinsicBounds(var2, 0, 0, 0);
      Group var9 = var1.groupInfo;
      Intrinsics.checkNotNullExpressionValue(var9, "groupInfo");
      ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
   }

   public void bindView(HolderOutdoorLocationBinding var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "payloads");
      if (!((Collection)var2).isEmpty()) {
         for(Object var3 : var2) {
            if (Intrinsics.areEqual(var3, "payload_tracked_location")) {
               this.hydrateTrackedLocation(var1);
            } else if (Intrinsics.areEqual(var3, "payload_aqidata")) {
               this.hydrateAqiData(var1);
            } else if (Intrinsics.areEqual(var3, "payload_progress")) {
               this.hydrateProgress(var1);
            }
         }
      } else {
         this.hydrateTrackedLocation(var1);
         this.hydrateAqiData(var1);
      }

      ViewUtils var5 = ViewUtils.INSTANCE;
      ConstraintLayout var6 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      ViewUtils.setAccessibilityDelegate$default(var5, (View)var6, (KClass)null, var1.getRoot().getContext().getString(com.blueair.viewcore.R.string.button_role), (Function2)null, 10, (Object)null);
   }

   public HolderOutdoorLocationBinding createBinding(LayoutInflater var1, ViewGroup var2) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      HolderOutdoorLocationBinding var3 = HolderOutdoorLocationBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return var3;
   }

   public final AqiData getAqiData() {
      return this.aqiData;
   }

   public final TrackedLocation getTrackedLocation() {
      return this.trackedLocation;
   }

   public int getType() {
      return this.type;
   }

   public final boolean getUseCurrentLocation() {
      return this.useCurrentLocation;
   }

   public final boolean isLocationEnable(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return LocationUtils.INSTANCE.isLocationPermissionGranted(var1) && LocationUtils.INSTANCE.isLocationEnabled(var1);
   }

   public final void setAqiData(AqiData var1) {
      this.aqiData = var1;
   }

   public final void setTrackedLocation(TrackedLocation var1) {
      this.trackedLocation = var1;
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"},
      d2 = {"Lcom/blueair/android/adapter/OutdoorLocationItem$Companion;", "", "<init>", "()V", "PAYLOAD_TRACKED_LOCATION", "", "PAYLOAD_AQIDATA", "PAYLOAD_PROGRESS", "app_otherRelease"},
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
