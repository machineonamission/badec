package com.blueair.viewcore.utils;

import android.content.Context;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceClassic;
import com.blueair.core.model.DeviceSense;
import com.blueair.core.model.Filter;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\u0015"},
   d2 = {"Lcom/blueair/viewcore/utils/FilterUtils;", "", "<init>", "()V", "filterName", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "isDualProtectionRegion", "", "filterImageRes", "", "legacyFilterImageRes", "filter", "Lcom/blueair/core/model/Filter;", "legacyFilterName", "deviceClassicSmokeStopFilterImageRes", "deviceClassicParticleFilterImageRes", "isDualProtection", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FilterUtils {
   public static final FilterUtils INSTANCE = new FilterUtils();

   private FilterUtils() {
   }

   private final boolean isDualProtection(Device var1, boolean var2) {
      boolean var3;
      if (var1 instanceof DeviceClassic) {
         var3 = ((DeviceClassic)var1).getHasNewSensors();
      } else {
         var3 = false;
      }

      return var2 && var3;
   }

   public final int deviceClassicParticleFilterImageRes(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("device classic modelName: ");
      var2.append(var1.getModelName());
      var3.d(var2.toString(), new Object[0]);
      CharSequence var4 = (CharSequence)var1.getModelName();
      if (!StringsKt.contains$default(var4, (CharSequence)"20", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"290", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"280", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"260", false, 2, (Object)null)) {
         return !StringsKt.contains$default(var4, (CharSequence)"405", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"460", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"480", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"490", false, 2, (Object)null) ? R.drawable.particle_500_600 : R.drawable.particle_400;
      } else {
         return R.drawable.particle_500_600;
      }
   }

   public final int deviceClassicSmokeStopFilterImageRes(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("device classic modelName: ");
      var3.append(var1.getModelName());
      var2.d(var3.toString(), new Object[0]);
      CharSequence var4 = (CharSequence)var1.getModelName();
      if (!StringsKt.contains$default(var4, (CharSequence)"20", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"290", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"280", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"260", false, 2, (Object)null)) {
         return !StringsKt.contains$default(var4, (CharSequence)"405", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"460", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"480", false, 2, (Object)null) && !StringsKt.contains$default(var4, (CharSequence)"490", false, 2, (Object)null) ? R.drawable.smokestop_500_600 : R.drawable.smokestop_400;
      } else {
         return R.drawable.smokestop_200;
      }
   }

   public final int filterImageRes(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return var1 instanceof HasFanSpeed ? this.legacyFilterImageRes(var1, ((HasFanSpeed)var1).getFilter(), var2) : 0;
   }

   public final String filterName(Context var1, Device var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "device");
      return var2 instanceof HasFanSpeed ? this.legacyFilterName(var1, var2, ((HasFanSpeed)var2).getFilter(), var3) : "Unknown Filter";
   }

   public final int legacyFilterImageRes(Device var1, Filter var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "filter");
      if (Intrinsics.areEqual(var2, Filter.SmokeStopFilter.INSTANCE)) {
         return this.isDualProtection(var1, var3) ? R.drawable.dual_protection_filter : this.deviceClassicSmokeStopFilterImageRes(var1);
      } else if (!Intrinsics.areEqual(var2, Filter.ParticleFilter.INSTANCE) && !Intrinsics.areEqual(var2, Filter.UnknownFilter.INSTANCE)) {
         throw new NoWhenBranchMatchedException();
      } else {
         return var1 instanceof DeviceSense ? R.drawable.particle_filter : this.deviceClassicParticleFilterImageRes(var1);
      }
   }

   public final String legacyFilterName(Context var1, Device var2, Filter var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "device");
      Intrinsics.checkNotNullParameter(var3, "filter");
      if (Intrinsics.areEqual(var3, Filter.SmokeStopFilter.INSTANCE)) {
         if (this.isDualProtection(var2, var4)) {
            String var8 = var1.getString(R.string.filter_dual_protection);
            Intrinsics.checkNotNull(var8);
            return var8;
         } else {
            String var7 = var1.getString(R.string.filter_smokestop);
            Intrinsics.checkNotNull(var7);
            return var7;
         }
      } else if (Intrinsics.areEqual(var3, Filter.ParticleFilter.INSTANCE)) {
         String var6 = var1.getString(R.string.filter_particle);
         Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
         return var6;
      } else if (Intrinsics.areEqual(var3, Filter.UnknownFilter.INSTANCE)) {
         String var5 = var1.getString(R.string.filter_unknown);
         Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
         return var5;
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }
}
