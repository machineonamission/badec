package com.blueair.viewcore.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
   d2 = {"Lcom/blueair/viewcore/utils/AppSettingsIntent;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AppSettingsIntent {
   public static final AppSettingsIntent INSTANCE = new AppSettingsIntent();

   private AppSettingsIntent() {
   }

   public final void start(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intent var3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      StringBuilder var2 = new StringBuilder("package:");
      var2.append(var1.getPackageName());
      var3.setData(Uri.parse(var2.toString()));
      var1.startActivity(var3);
   }
}
