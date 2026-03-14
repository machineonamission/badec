package com.blueair.devicedetails.util;

import android.content.Context;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import com.blueair.core.model.HasDisinfection;
import com.blueair.viewcore.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/util/DisinfectionUtils;", "", "<init>", "()V", "getCountdownStatus", "Lkotlin/Pair;", "", "Landroid/text/Spanned;", "device", "Lcom/blueair/core/model/HasDisinfection;", "context", "Landroid/content/Context;", "getCountdownText", "", "getLeftSeconds", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DisinfectionUtils {
   public static final DisinfectionUtils INSTANCE = new DisinfectionUtils();

   private DisinfectionUtils() {
   }

   public final Pair getCountdownStatus(HasDisinfection var1, Context var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "context");
      int var4 = this.getLeftSeconds(var1);
      int var5 = (int)Math.ceil((double)var4 / (double)60.0F);
      int var3;
      if (var5 <= 1) {
         var3 = R.string.disinfection_left_time_1min;
      } else {
         var3 = R.string.disinfection_left_time;
      }

      String var9 = var2.getString(var3);
      Intrinsics.checkNotNullExpressionValue(var9, "getString(...)");
      StringBuilder var6 = new StringBuilder("<b>");
      var6.append(var5);
      var6.append("</b>");
      String var7 = String.format(var9, Arrays.copyOf(new Object[]{var6.toString()}, 1));
      Intrinsics.checkNotNullExpressionValue(var7, "format(...)");
      Spanned var8 = HtmlCompat.fromHtml(var7, 0);
      Intrinsics.checkNotNullExpressionValue(var8, "fromHtml(...)");
      return new Pair(var4, var8);
   }

   public final String getCountdownText(HasDisinfection var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      int var2 = this.getLeftSeconds(var1);
      int var4 = var2 / 3600;
      int var5 = (int)Math.ceil((double)(var2 - var4 * 3600) / (double)60.0F);
      int var3 = var4;
      var2 = var5;
      if (var5 > 59) {
         var3 = var4 + 1;
         var2 = 0;
      }

      String var6 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{var3, var2}, 2));
      Intrinsics.checkNotNullExpressionValue(var6, "format(...)");
      return var6;
   }

   public final int getLeftSeconds(HasDisinfection var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Integer var3 = var1.getDisinfectLeftTime();
      Long var4 = var1.getDisinfectLeftTimeUpdateTime();
      int var2;
      if (var3 != null && var4 != null) {
         var2 = RangesKt.coerceAtLeast((int)((long)var3 - (System.currentTimeMillis() / (long)1000 - var4)), 0);
      } else {
         var2 = 7200;
      }

      return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(var2, 0), 7200);
   }
}
