package com.blueair.viewcore.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.blueair.auth.LocationService;
import com.blueair.core.model.ChinaPrivacy;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasSKU;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\u001e\u0010\"\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010&\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005J\u0018\u0010'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020\u0005J\u0016\u0010+\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020-J&\u0010.\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u000102J>\u00103\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020)2\b\b\u0002\u00108\u001a\u00020)2\b\b\u0002\u0010 \u001a\u00020\u0005J\u000e\u00109\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ)\u0010:\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010;\u001a\u00020\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010$H\u0002¢\u0006\u0002\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006>"},
   d2 = {"Lcom/blueair/viewcore/activity/Actions;", "", "<init>", "()V", "EXTRA_DEVICE_ID", "", "EXTRA_DEVICE_SKU", "EXTRA_DEVICE", "SEARCH_MODE", "LOCATION_ID", "CURRENT_LOCATION", "EXTRA_SCHEDULE_MERGED", "EXTRA_ACTION_TYPE", "EXTRA_FILTER_TYPE", "EXTRA_NOTIFICATION_ID", "EXTRA_SCREEN_NAME", "EXTRA_VERSION", "EXTRA_TEXT", "EXTRA_LINK", "ACTION_DEVICE_STOP_ALARM", "MAP_IGNORE_LOCATION_ID", "ACTION_REGISTER", "openDialerIntent", "Landroid/content/Intent;", "tel", "openBrowserIntent", "url", "openJdMallIntent", "openHomeIntent", "context", "Landroid/content/Context;", "openNotificationIntent", "deviceId", "actionType", "stopAlarmIntent", "notificationId", "", "openAddDeviceIntent", "openDeviceDetailsIntent", "openWelcomeIntent", "clearTask", "", "openLoginIntent", "openChinaPrivacyPolicyIntent", "privacy", "Lcom/blueair/core/model/ChinaPrivacy;", "openAntiFakeScanIntent", "device", "Lcom/blueair/core/model/HasSKU;", "targetType", "Lcom/blueair/core/model/DeviceFilterType;", "openMapIntent", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "navigateToLocationId", "searchMode", "isCurrentLocation", "openTroubleShootIntent", "internalIntent", "action", "flags", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/Intent;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class Actions {
   public static final String ACTION_DEVICE_STOP_ALARM = "blueair.action.devicestopalarm";
   public static final String ACTION_REGISTER = "action_register";
   public static final String CURRENT_LOCATION = "current_location";
   public static final String EXTRA_ACTION_TYPE = "action_type";
   public static final String EXTRA_DEVICE = "device";
   public static final String EXTRA_DEVICE_ID = "device_id";
   public static final String EXTRA_DEVICE_SKU = "device_sku";
   public static final String EXTRA_FILTER_TYPE = "filter_type";
   public static final String EXTRA_LINK = "extra_link";
   public static final String EXTRA_NOTIFICATION_ID = "notification_id";
   public static final String EXTRA_SCHEDULE_MERGED = "schedule_merged";
   public static final String EXTRA_SCREEN_NAME = "screen_name";
   public static final String EXTRA_TEXT = "extra_text";
   public static final String EXTRA_VERSION = "extra_version";
   public static final Actions INSTANCE = new Actions();
   public static final String LOCATION_ID = "location_id";
   public static final String MAP_IGNORE_LOCATION_ID = "";
   public static final String SEARCH_MODE = "search_mode";

   private Actions() {
   }

   private final Intent internalIntent(Context var1, String var2, Integer var3) {
      Intent var4 = (new Intent(var2)).setPackage(var1.getPackageName());
      Intrinsics.checkNotNullExpressionValue(var4, "setPackage(...)");
      if (var3 != null) {
         var4.setFlags(var3);
      }

      return var4;
   }

   // $FF: synthetic method
   static Intent internalIntent$default(Actions var0, Context var1, String var2, Integer var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = null;
      }

      return var0.internalIntent(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Intent openAntiFakeScanIntent$default(Actions var0, Context var1, HasSKU var2, DeviceFilterType var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      return var0.openAntiFakeScanIntent(var1, var2, var3);
   }

   // $FF: synthetic method
   public static Intent openLoginIntent$default(Actions var0, Context var1, String var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = "";
      }

      return var0.openLoginIntent(var1, var2);
   }

   // $FF: synthetic method
   public static Intent openMapIntent$default(Actions var0, Context var1, LocationService.MapType var2, String var3, boolean var4, boolean var5, String var6, int var7, Object var8) {
      if ((var7 & 4) != 0) {
         var3 = "";
      }

      if ((var7 & 8) != 0) {
         var4 = false;
      }

      if ((var7 & 16) != 0) {
         var5 = false;
      }

      if ((var7 & 32) != 0) {
         var6 = "";
      }

      return var0.openMapIntent(var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static Intent openWelcomeIntent$default(Actions var0, Context var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return var0.openWelcomeIntent(var1, var2);
   }

   public final Intent openAddDeviceIntent(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return internalIntent$default(this, var1, "blueair.action.adddevice", (Integer)null, 4, (Object)null);
   }

   public final Intent openAntiFakeScanIntent(Context var1, HasSKU var2, DeviceFilterType var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intent var4 = internalIntent$default(this, var1, "blueair.action.antifakescan", (Integer)null, 4, (Object)null);
      if (var2 != null) {
         var4.putExtra("device", var2);
      }

      if (var3 != null) {
         var4.putExtra("filter_type", var3.name());
      }

      return var4;
   }

   public final Intent openBrowserIntent(String var1) {
      Intrinsics.checkNotNullParameter(var1, "url");
      return new Intent("android.intent.action.VIEW", Uri.parse(var1));
   }

   public final Intent openChinaPrivacyPolicyIntent(Context var1, ChinaPrivacy var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "privacy");
      Intent var3 = internalIntent$default(this, var1, "blueair.action.chinaprivacypolicy", (Integer)null, 4, (Object)null);
      var3.putExtra("extra_version", var2.getVersion());
      var3.putExtra("extra_text", var2.getText().getValue());
      var3.putExtra("extra_link_terms", var2.getLinkTerms().getValue());
      var3.putExtra("extra_link_privacy", var2.getLinkPrivacy().getValue());
      return var3;
   }

   public final Intent openDeviceDetailsIntent(Context var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Intent var3 = internalIntent$default(this, var1, "blueair.action.devicedetails", (Integer)null, 4, (Object)null).putExtra("device_id", var2);
      Intrinsics.checkNotNullExpressionValue(var3, "putExtra(...)");
      return var3;
   }

   public final Intent openDialerIntent(String var1) {
      Intrinsics.checkNotNullParameter(var1, "tel");
      StringBuilder var2 = new StringBuilder("tel:");
      var2.append(var1);
      return new Intent("android.intent.action.DIAL", Uri.parse(var2.toString()));
   }

   public final Intent openHomeIntent(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      return this.internalIntent(var1, "blueair.action.home", 603979776);
   }

   public final Intent openJdMallIntent(String var1) {
      Intrinsics.checkNotNullParameter(var1, "url");
      Intent var2 = (new Intent("android.intent.action.VIEW", Uri.parse(var1))).setPackage("com.jingdong.app.mall");
      Intrinsics.checkNotNullExpressionValue(var2, "setPackage(...)");
      return var2;
   }

   public final Intent openLoginIntent(Context var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "actionType");
      Intent var3 = internalIntent$default(this, var1, "blueair.action.login", (Integer)null, 4, (Object)null);
      var3.putExtra("action_type", var2);
      return var3;
   }

   public final Intent openMapIntent(Context var1, LocationService.MapType var2, String var3, boolean var4, boolean var5, String var6) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "mapType");
      Intrinsics.checkNotNullParameter(var3, "navigateToLocationId");
      Intrinsics.checkNotNullParameter(var6, "deviceId");
      int var7 = Actions.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      String var9;
      if (var7 != 1) {
         if (var7 != 2) {
            if (var7 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var9 = "blueair.action.mapbox";
         } else {
            var9 = "blueair.action.googlemaps";
         }
      } else {
         var9 = "blueair.action.amap";
      }

      Intent var8 = internalIntent$default(this, var1, var9, (Integer)null, 4, (Object)null).putExtra("search_mode", var4).putExtra("location_id", var3).putExtra("current_location", var5).putExtra("device_id", var6);
      Intrinsics.checkNotNullExpressionValue(var8, "putExtra(...)");
      return var8;
   }

   public final Intent openNotificationIntent(Context var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Intrinsics.checkNotNullParameter(var3, "actionType");
      Intent var4 = this.internalIntent(var1, "blueair.action.home", 67108864);
      var4.putExtra("device_id", var2);
      var4.putExtra("action_type", var3);
      return var4;
   }

   public final Intent openTroubleShootIntent(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intent var2 = internalIntent$default(this, var1, "blueair.action.info", (Integer)null, 4, (Object)null).putExtra("display_key", 7).putExtra("toolbar_key", var1.getString(R.string.customer_support));
      Intrinsics.checkNotNullExpressionValue(var2, "putExtra(...)");
      return var2;
   }

   public final Intent openWelcomeIntent(Context var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Integer var3;
      if (var2) {
         var3 = 268468224;
      } else {
         var3 = null;
      }

      return this.internalIntent(var1, "blueair.action.welcome", var3);
   }

   public final Intent stopAlarmIntent(Context var1, String var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "deviceId");
      Intent var4 = internalIntent$default(this, var1, "blueair.action.devicestopalarm", (Integer)null, 4, (Object)null);
      var4.putExtra("device_id", var2);
      var4.putExtra("notification_id", var3);
      return var4;
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
