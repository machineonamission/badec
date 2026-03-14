package com.blueair.viewcore.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t¨\u0006\u000b"},
   d2 = {"Lcom/blueair/viewcore/utils/ToastUtils;", "", "<init>", "()V", "showCenterToast", "", "context", "Landroid/content/Context;", "text", "", "duration", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ToastUtils {
   public static final ToastUtils INSTANCE = new ToastUtils();

   private ToastUtils() {
   }

   // $FF: synthetic method
   public static void showCenterToast$default(ToastUtils var0, Context var1, int var2, int var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = 0;
      }

      var0.showCenterToast(var1, var2, var3);
   }

   public final void showCenterToast(Context var1, int var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      View var4 = LayoutInflater.from(var1).inflate(R.layout.default_toast, (ViewGroup)null);
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type android.widget.TextView");
      TextView var6 = (TextView)var4;
      var6.setText(var2);
      Toast var5 = new Toast(var1);
      var5.setView((View)var6);
      var5.setGravity(17, 0, 0);
      var5.setDuration(var3);
      var5.show();
   }
}
