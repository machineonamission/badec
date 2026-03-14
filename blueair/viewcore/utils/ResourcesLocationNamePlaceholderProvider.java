package com.blueair.viewcore.utils;

import android.content.Context;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"},
   d2 = {"Lcom/blueair/viewcore/utils/ResourcesLocationNamePlaceholderProvider;", "Lcom/blueair/core/service/LocationNamePlaceholderProvider;", "applicationContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getApplicationContext", "()Landroid/content/Context;", "unknownCity", "", "getUnknownCity", "()Ljava/lang/String;", "unknownStationName", "getUnknownStationName", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ResourcesLocationNamePlaceholderProvider implements LocationNamePlaceholderProvider {
   private final Context applicationContext;

   public ResourcesLocationNamePlaceholderProvider(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "applicationContext");
      super();
      this.applicationContext = var1;
   }

   public final Context getApplicationContext() {
      return this.applicationContext;
   }

   public String getUnknownCity() {
      String var1 = this.applicationContext.getString(R.string.unknown_city_placeholder);
      Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
      return var1;
   }

   public String getUnknownStationName() {
      String var1 = this.applicationContext.getString(R.string.unknown_station_name_placeholder);
      Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
      return var1;
   }
}
