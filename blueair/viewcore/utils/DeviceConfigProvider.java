package com.blueair.viewcore.utils;

import android.content.Context;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceConfig;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasCompatibility;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.blueair.core.model.UserManual;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.WebViewActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0016J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\nJ\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018J\u001e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nJ\u0017\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020$J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u0013\u001a\u00020\nJ\u0014\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010.\u001a\u0004\u0018\u00010,2\u0006\u0010\u0013\u001a\u00020\nJ\u0012\u0010/\u001a\u0004\u0018\u00010\n2\b\u0010-\u001a\u0004\u0018\u000100J\u0012\u00101\u001a\u0004\u0018\u00010\n2\b\u00102\u001a\u0004\u0018\u000103R \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058\u0006@BX\u0087.¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u00064"},
   d2 = {"Lcom/blueair/viewcore/utils/DeviceConfigProvider;", "", "<init>", "()V", "value", "Lcom/blueair/auth/LocationService;", "locationService", "getLocationService", "()Lcom/blueair/auth/LocationService;", "ip", "", "getIp", "()Ljava/lang/String;", "init", "", "getDeviceConfig", "Lcom/blueair/core/model/DeviceConfig;", "device", "Lcom/blueair/core/model/Device;", "sku", "getDeviceImage", "Lcom/blueair/core/model/DeviceImage;", "Lcom/blueair/core/model/BluetoothDevice;", "getFilterConfig", "Lcom/blueair/core/model/FilterConfig;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "hasBuyFilterLink", "", "filterConfig", "openFilterUrl", "context", "Landroid/content/Context;", "url", "title", "getFilterLifeLeftPercentage", "", "(Lcom/blueair/core/model/Device;)Ljava/lang/Integer;", "getFilterStatusColor", "filterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "getWickStatusColor", "wickLifeLeft", "getUserManual", "Lcom/blueair/core/model/UserManual;", "config", "getRefresherManual", "getIpConfigValue", "Lcom/blueair/core/model/IpConfig;", "getAwsLinkValue", "link", "Lcom/blueair/core/model/AwsLinkConfig;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceConfigProvider {
   public static final DeviceConfigProvider INSTANCE = new DeviceConfigProvider();
   private static LocationService locationService;

   private DeviceConfigProvider() {
   }

   private final FilterConfig getFilterConfig(String var1, DeviceFilterType var2, Device var3) {
      DeviceConfig var7 = this.getDeviceConfig(var1);
      FilterConfig var8;
      if (var7 != null) {
         var8 = var7.getFilter();
      } else {
         var8 = null;
      }

      if (var8 != null && !(var3 instanceof HasCompatibility)) {
         if (var2 == null) {
            return var8;
         } else {
            Iterable var18 = (Iterable)var8.getFilters();
            Collection var17 = (Collection)(new ArrayList());

            for(Object var20 : var18) {
               if (((FilterInfo)var20).getType() == var2) {
                  var17.add(var20);
               }
            }

            return FilterConfig.copy$default(var8, (AwsLinkConfig)null, 0, (List)var17, 3, (Object)null);
         }
      } else if (var2 == DeviceFilterType.FILTER && var3 != null) {
         int var4;
         ArrayList var5;
         I18nConfig var6;
         label52: {
            var5 = new ArrayList();
            String var12 = FilterUtils.INSTANCE.filterName(this.getLocationService().getContext(), var3, this.getLocationService().isInDualProtectionRegion());
            var4 = FilterUtils.INSTANCE.filterImageRes(var3, this.getLocationService().isInDualProtectionRegion());
            var16 = DeviceFilterType.FILTER;
            var6 = new I18nConfig(var12, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, 2046, (DefaultConstructorMarker)null);
            if (var8 != null) {
               List var13 = var8.getFilters();
               if (var13 != null) {
                  FilterInfo var14 = (FilterInfo)CollectionsKt.firstOrNull(var13);
                  if (var14 != null) {
                     var15 = var14.getLinkSubscribe();
                     break label52;
                  }
               }
            }

            var15 = null;
         }

         label46: {
            if (var8 != null) {
               List var9 = var8.getFilters();
               if (var9 != null) {
                  FilterInfo var10 = (FilterInfo)CollectionsKt.firstOrNull(var9);
                  if (var10 != null) {
                     var11 = var10.getLinkPurchase();
                     break label46;
                  }
               }
            }

            var11 = null;
         }

         var5.add(new FilterInfo(var16, var6, var4, 0, (I18nConfig)null, var15, var11));
         return new FilterConfig((AwsLinkConfig)null, 0, (List)var5);
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   public static FilterConfig getFilterConfig$default(DeviceConfigProvider var0, Device var1, DeviceFilterType var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return var0.getFilterConfig(var1, var2);
   }

   // $FF: synthetic method
   public static FilterConfig getFilterConfig$default(DeviceConfigProvider var0, String var1, DeviceFilterType var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      return var0.getFilterConfig(var1, var2);
   }

   private final UserManual getUserManual(DeviceConfig var1) {
      if (var1 != null) {
         I18nConfig var2 = var1.getManual();
         if (var2 != null) {
            String var3 = var2.getValue();
            if (var3 != null) {
               return new UserManual(var3);
            }
         }
      }

      return null;
   }

   public final String getAwsLinkValue(AwsLinkConfig var1) {
      return var1 != null ? var1.getValue(this.getLocationService().getCloudRegion()) : null;
   }

   public final DeviceConfig getDeviceConfig(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return this.getDeviceConfig(DeviceKt.getSkuCompat(var1));
   }

   public final DeviceConfig getDeviceConfig(String var1) {
      return SkuConfigurationManager.INSTANCE.getConfig().getDeviceConfig(var1);
   }

   public final DeviceImage getDeviceImage(BluetoothDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return this.getDeviceImage(var1.getSku());
   }

   public final DeviceImage getDeviceImage(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      String var2 = DeviceKt.getSkuCompat(var1);
      return var2 == null ? null : this.getDeviceImage(var2);
   }

   public final DeviceImage getDeviceImage(String var1) {
      Intrinsics.checkNotNullParameter(var1, "sku");
      DeviceConfig var2 = this.getDeviceConfig(var1);
      if (var2 != null) {
         DeviceImage var4 = var2.getImage();
         if (var4 != null) {
            return var4;
         }
      }

      DeviceType var3 = DeviceType.Companion.fromSkuCompat(var1);
      if (Intrinsics.areEqual(var3, DeviceType.Aware.INSTANCE)) {
         return DeviceImage.AWARE;
      } else if (!Intrinsics.areEqual(var3, DeviceType.Classic.INSTANCE) && !Intrinsics.areEqual(var3, DeviceType.ClassicWithoutSensor.INSTANCE)) {
         if (Intrinsics.areEqual(var3, DeviceType.Sense.INSTANCE)) {
            return DeviceImage.SENSE;
         } else {
            return Intrinsics.areEqual(var3, DeviceType.Icp.INSTANCE) ? DeviceImage.ICP : null;
         }
      } else {
         return DeviceImage.CLASSIC;
      }
   }

   public final FilterConfig getFilterConfig(Device var1, DeviceFilterType var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      String var3 = DeviceKt.getSkuCompat(var1);
      return var3 == null ? null : this.getFilterConfig(var3, var2, var1);
   }

   public final FilterConfig getFilterConfig(String var1, DeviceFilterType var2) {
      Intrinsics.checkNotNullParameter(var1, "sku");
      return this.getFilterConfig(var1, var2, (Device)null);
   }

   public final Integer getFilterLifeLeftPercentage(Device var1) {
      FilterLifeTime var2;
      if (var1 != null) {
         var2 = DeviceKt.getFilterLifeTime(var1);
      } else {
         var2 = null;
      }

      if (var2 instanceof FilterLifeTime.FilterPercentageLeft) {
         return ((FilterLifeTime.FilterPercentageLeft)var2).getFilterLife();
      } else {
         return var2 instanceof FilterLifeTime.FilterDaysLeft ? ((FilterLifeTime.FilterDaysLeft)var2).getFilterLifePercentage() : null;
      }
   }

   public final int getFilterStatusColor(FilterLifeTime var1) {
      Intrinsics.checkNotNullParameter(var1, "filterLifeTime");
      int var5;
      if (var1 instanceof FilterLifeTime.FilterPercentageLeft) {
         var5 = ((FilterLifeTime.FilterPercentageLeft)var1).getFilterLife();
         if (11 <= var5 && var5 <= Integer.MAX_VALUE) {
            var5 = R.color.aquamarine;
         } else if (1 <= var5 && var5 < 11) {
            var5 = R.color.mustard_yellow;
         } else {
            var5 = R.color.warmpink;
         }
      } else if (var1 instanceof FilterLifeTime.FilterDaysLeft) {
         Integer var4 = ((FilterLifeTime.FilterDaysLeft)var1).getFilterLifePercentage();
         IntRange var3 = new IntRange(11, Integer.MAX_VALUE);
         if (var4 != null && var3.contains(var4)) {
            var5 = R.color.aquamarine;
         } else {
            var3 = new IntRange(1, 10);
            if (var4 != null && var3.contains(var4)) {
               var5 = R.color.mustard_yellow;
            } else {
               var5 = R.color.warmpink;
            }
         }
      } else {
         if (!(var1 instanceof FilterLifeTime.NoFilterInfo)) {
            throw new NoWhenBranchMatchedException();
         }

         var5 = R.color.aquamarine;
      }

      return this.getLocationService().getContext().getColor(var5);
   }

   public final String getIp() {
      return this.getLocationService().getCountry();
   }

   public final String getIpConfigValue(IpConfig var1) {
      return var1 != null ? var1.getValue(this.getIp()) : null;
   }

   public final LocationService getLocationService() {
      LocationService var1 = locationService;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("locationService");
         return null;
      }
   }

   public final UserManual getRefresherManual(String var1) {
      Intrinsics.checkNotNullParameter(var1, "sku");
      DeviceConfig var5 = this.getDeviceConfig(var1);
      Object var2 = null;
      if (var5 == null) {
         return null;
      } else {
         FilterConfig var3 = var5.getFilter();
         UserManual var6 = (UserManual)var2;
         if (var3 != null) {
            List var9 = var3.getFilters();
            var6 = (UserManual)var2;
            if (var9 != null) {
               Iterator var10 = ((Iterable)var9).iterator();

               FilterInfo var4;
               do {
                  if (!var10.hasNext()) {
                     var7 = null;
                     break;
                  }

                  var7 = var10.next();
                  var4 = (FilterInfo)var7;
               } while(var4.getType() != DeviceFilterType.REFRESHER || var4.getManual() == null);

               FilterInfo var8 = (FilterInfo)var7;
               if (var8 == null) {
                  var6 = (UserManual)var2;
               } else {
                  I18nConfig var11 = var8.getManual();
                  var6 = (UserManual)var2;
                  if (var11 != null) {
                     String var12 = var11.getValue();
                     var6 = (UserManual)var2;
                     if (var12 != null) {
                        var6 = new UserManual(var12);
                     }
                  }
               }
            }
         }

         return var6;
      }
   }

   public final UserManual getUserManual(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      return this.getUserManual(this.getDeviceConfig(var1));
   }

   public final UserManual getUserManual(String var1) {
      Intrinsics.checkNotNullParameter(var1, "sku");
      return this.getUserManual(this.getDeviceConfig(var1));
   }

   public final int getWickStatusColor(int var1) {
      if (var1 <= 0) {
         var1 = R.color.warmpink;
      } else if (var1 < 11) {
         var1 = R.color.mustard_yellow;
      } else {
         var1 = R.color.aquamarine;
      }

      return this.getLocationService().getContext().getColor(var1);
   }

   public final boolean hasBuyFilterLink(FilterConfig var1) {
      if (var1 != null) {
         List var5 = var1.getFilters();
         if (var5 != null) {
            Iterable var6 = (Iterable)var5;
            if (!(var6 instanceof Collection) || !((Collection)var6).isEmpty()) {
               for(FilterInfo var4 : var6) {
                  DeviceConfigProvider var2 = INSTANCE;
                  CharSequence var3 = (CharSequence)var2.getIpConfigValue(var4.getLinkPurchase());
                  if (var3 != null && var3.length() != 0) {
                     return true;
                  }

                  CharSequence var8 = (CharSequence)var2.getIpConfigValue(var4.getLinkSubscribe());
                  if (var8 != null && var8.length() != 0) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public final void init(LocationService var1) {
      Intrinsics.checkNotNullParameter(var1, "locationService");
      locationService = var1;
   }

   public final void openFilterUrl(Context var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "url");
      Intrinsics.checkNotNullParameter(var3, "title");
      if (StringsKt.startsWith$default(var2, "https://item.jd.com", false, 2, (Object)null)) {
         try {
            var1.startActivity(Actions.INSTANCE.openJdMallIntent(var2));
         } finally {
            var1.startActivity(Actions.INSTANCE.openBrowserIntent(var2));
            return;
         }
      } else if (StringsKt.contains$default((CharSequence)var2, (CharSequence)"youzan.com", false, 2, (Object)null)) {
         var1.startActivity(Actions.INSTANCE.openBrowserIntent(var2));
      } else {
         WebViewActivity.Companion.launch(var1, "device_filter_buy_web", var3, var2);
      }
   }
}
