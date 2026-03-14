package com.blueair.viewcore.activity;

import android.content.Context;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import com.blueair.sdk.LokaliseSdk;
import com.blueair.viewcore.dialog.DialogUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0004J\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000e¨\u0006\u0013"},
   d2 = {"Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onResume", "immersiveStatusBar", "withNavigationBar", "", "setStatusBarColor", "color", "", "lightMode", "(ILjava/lang/Boolean;)V", "setStatusMode", "getStatusBarHeight", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseLokaliseActivity extends AppCompatActivity {
   // $FF: synthetic method
   public static void immersiveStatusBar$default(BaseLokaliseActivity var0, boolean var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         var0.immersiveStatusBar(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: immersiveStatusBar");
      }
   }

   // $FF: synthetic method
   public static void setStatusBarColor$default(BaseLokaliseActivity var0, int var1, Boolean var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = null;
         }

         var0.setStatusBarColor(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusBarColor");
      }
   }

   // $FF: synthetic method
   public static void setStatusMode$default(BaseLokaliseActivity var0, boolean var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = false;
         }

         var0.setStatusMode(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusMode");
      }
   }

   protected void attachBaseContext(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "newBase");
      super.attachBaseContext(LokaliseSdk.INSTANCE.wrapContext(var1));
   }

   public final int getStatusBarHeight() {
      int var1 = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
      return var1 > 0 ? this.getResources().getDimensionPixelSize(var1) : (int)TypedValue.applyDimension(1, 40.0F, this.getResources().getDisplayMetrics());
   }

   protected final void immersiveStatusBar(boolean var1) {
      this.getWindow().clearFlags(67108864);
      this.getWindow().addFlags(Integer.MIN_VALUE);
      this.getWindow().setStatusBarColor(0);
      int var3 = this.getWindow().getDecorView().getSystemUiVisibility();
      int var2 = var3 | 1280;
      if (var1) {
         var2 = var3 | 1792;
      }

      this.getWindow().getDecorView().setSystemUiVisibility(var2);
   }

   protected void onResume() {
      super.onResume();
      DialogUtils.INSTANCE.hideRequestPermissionHints();
   }

   public final void setStatusBarColor(int var1, Boolean var2) {
      if (var2 != null) {
         this.setStatusMode(var2);
      }

      this.getWindow().setStatusBarColor(var1);
   }

   public final void setStatusMode(boolean var1) {
      int var2 = this.getWindow().getDecorView().getSystemUiVisibility();
      if (var1) {
         var2 |= 8192;
      } else {
         var2 &= -8193;
      }

      this.getWindow().getDecorView().setSystemUiVisibility(var2);
   }
}
