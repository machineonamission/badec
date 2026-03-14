package com.blueair.sdk;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
   d2 = {"Lcom/blueair/sdk/GoogleOssSdk;", "", "<init>", "()V", "startOssLicensesMenuActivity", "", "context", "Landroid/content/Context;", "sdk_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class GoogleOssSdk {
   public static final GoogleOssSdk INSTANCE = new GoogleOssSdk();

   private GoogleOssSdk() {
   }

   public final void startOssLicensesMenuActivity(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      var1.startActivity(new Intent(var1, OssLicensesMenuActivity.class));
   }
}
