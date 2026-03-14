package com.blueair.devicedetails.util;

import android.content.Context;
import android.text.Spanned;
import androidx.core.text.HtmlCompat;
import com.blueair.viewcore.R;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005J%\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"},
   d2 = {"Lcom/blueair/devicedetails/util/EtaUtils;", "", "<init>", "()V", "ETA_MIN", "", "ETA_MAX", "FAN_KEY_MIN", "FAN_KEY_MAX", "CLEAN_PM25", "TOO_LONG_DURATION", "etaTable", "", "", "getEtaTable", "()Ljava/util/Map;", "eta", "fan", "pm25", "calcEtaPercent", "etaString", "", "context", "Landroid/content/Context;", "fanSpeed", "", "(Landroid/content/Context;ILjava/lang/Float;)Ljava/lang/CharSequence;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class EtaUtils {
   public static final int CLEAN_PM25 = 25;
   public static final int ETA_MAX = 60;
   public static final int ETA_MIN = 0;
   public static final int FAN_KEY_MAX = 91;
   public static final int FAN_KEY_MIN = 11;
   public static final EtaUtils INSTANCE = new EtaUtils();
   public static final int TOO_LONG_DURATION = Integer.MAX_VALUE;
   private static final Map etaTable;

   static {
      Integer var0 = 27;
      Integer var6 = 5;
      Integer var7 = 9;
      Integer var9 = 17;
      Integer var14 = 20;
      Integer var10 = 19;
      Integer var1 = 4;
      Integer var2 = 6;
      Integer var15 = 8;
      Integer var13 = 11;
      Integer var11 = 12;
      Integer var5 = 14;
      Integer var12 = 15;
      Pair var8 = TuplesKt.to(1, CollectionsKt.listOf(new Integer[]{0, 1, var6, var7, 13, var9, var14, 23, 26, 29, 33, 36, 39, 42, 45, 49, 52, 56, 60}));
      Integer var3 = 24;
      Integer var4 = 21;
      etaTable = MapsKt.mapOf(new Pair[]{var8, TuplesKt.to(2, CollectionsKt.listOf(new Integer[]{0, 1, var1, var2, var7, var13, 13, var12, var9, var10, var14, 22, var3, 25, var0, 28, 30, 32, 34, 35, 36, 38, 40, 42, 43, 45, 47, 49, 52, 54, 56, 59, 60})), TuplesKt.to(3, CollectionsKt.listOf(new Integer[]{0, 1, 3, var6, var2, var15, var7, var13, var11, var5, var12, 16, var9, 18, var10, var14, var4, 22, 23, var3, 25, 26, var0, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 43, 44, 46, 47, 49, 51, 53, 55, 58, 60})), TuplesKt.to(var1, CollectionsKt.listOf(new Integer[]{0, 1, 2, var1, var6, 7, var15, var7, 10, var13, var11, 13, var5, var12, var12, 16, var9, var9, 18, var10, var14, var14, var4, var4, 22, 23, 23, var3, 25, 25, 26, var0, var0, 28, 29, 30, 30, 31, 32, 32, 33, 34, 35, 36, 37, 37, 38, 39, 40, 42, 43, 44, 46, 47, 49, 51, 54, 57, 60})), TuplesKt.to(var13, CollectionsKt.listOf(new Integer[]{0, 1, var1, var2, var7, var13, var5, 16, var10, var4, var3, 26, 28, 31, 33, 35, 38, 42, 45, 47, 50, 52, 55, 57, 58, 60})), TuplesKt.to(var12, CollectionsKt.listOf(new Integer[]{0, 1, var1, var2, var15, 10, 13, var12, var9, var14, 22, var3, 26, 29, 31, 33, 36, 39, 41, 44, 46, 49, 51, 53, 54, 56, 58, 60})), TuplesKt.to(var10, CollectionsKt.listOf(new Integer[]{0, 1, 3, var2, var15, 10, var11, var5, 16, 18, var14, 22, var3, var0, 29, 30, 33, 36, 38, 41, 43, 45, 47, 49, 50, 52, 54, 56, 58, 60})), TuplesKt.to(23, CollectionsKt.listOf(new Integer[]{0, 1, 3, var6, 7, var7, var13, 13, var12, var9, var10, var4, 23, var3, 26, 28, 30, 33, 35, 37, 39, 41, 43, 45, 46, 47, 49, 50, 52, 54, 56, 58, 60})), TuplesKt.to(var0, CollectionsKt.listOf(new Integer[]{0, 1, 3, var6, 7, var15, 10, var11, var5, var12, var9, var10, var4, 22, var3, 25, 28, 30, 32, 34, 36, 37, 39, 41, 42, 43, 44, 46, 47, 48, 49, 51, 52, 54, 56, 58, 60})), TuplesKt.to(31, CollectionsKt.listOf(new Integer[]{0, 1, 3, var1, var2, var15, var7, var13, var11, var5, var12, var9, var10, var14, 22, 23, 25, var0, 29, 31, 32, 34, 35, 37, 38, 39, 40, 41, 42, 44, 45, 46, 47, 48, 49, 50, 52, 52, 54, 56, 58, 60})), TuplesKt.to(35, CollectionsKt.listOf(new Integer[]{0, 1, 3, var1, var6, 7, var15, 10, var13, var11, var5, var12, var9, 18, var10, var4, 22, var3, 26, var0, 29, 30, 31, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 50, 51, 52, 52, 52, 54, 56, 58, 60})), TuplesKt.to(37, CollectionsKt.listOf(new Integer[]{0, 1, 3, var1, var6, 7, var15, 10, var13, var11, var5, var12, var9, 18, var10, var4, 22, var3, 26, var0, 29, 30, 31, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 50, 51, 52, 52, 52, 54, 56, 58, 60})), TuplesKt.to(39, CollectionsKt.listOf(new Integer[]{0, 1, 2, var1, var6, var2, 7, var7, 10, var13, var11, 13, var12, 16, var9, 18, var14, var4, 22, var3, 25, 26, var0, 28, 30, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 58, 60})), TuplesKt.to(43, CollectionsKt.listOf(new Integer[]{0, 1, 2, 3, var1, var6, var2, 7, var15, 10, var13, var11, 13, var5, var12, 16, var9, 18, var10, var14, var4, 23, var3, var3, 25, 26, var0, 28, 29, 30, 31, 32, 32, 33, 34, 35, 36, 37, 38, 39, 39, 40, 41, 42, 43, 44, 45, 46, 47, 47, 48, 49, 50, 51, 52, 53, 54, 58, 60})), TuplesKt.to(47, CollectionsKt.listOf(new Integer[]{0, 1, 2, 3, var1, var6, var6, var2, 7, var15, var7, 10, var13, var11, var11, 13, var5, var12, 16, var9, 18, var10, var14, var14, var4, 22, 23, var3, var3, 25, 26, var0, 28, 28, 29, 30, 31, 32, 32, 33, 34, 35, 31, 32, 33, 34, 34, 35, 37, 38, 39, 40, 41, 43, 44, 46, 47, 49, 50, 52, 54, 58, 60})), TuplesKt.to(51, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, var1, var6, var6, var2, 7, 7, var15, var7, var7, 10, var13, var11, var11, 13, var5, var5, var12, 16, 16, var9, 18, var10, var10, var14, var4, var4, 22, 23, 23, var3, 25, 26, 26, var0, 28, 28, 29, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 42, 43, 44, 46, 47, 49, 51, 52, 54, 56, 58, 60})), TuplesKt.to(55, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, var1, var1, var6, var2, var2, 7, var15, var15, var7, 10, 10, var13, var11, var11, 13, var5, var5, var12, 16, 16, var9, 18, 18, var10, var14, var14, var4, 22, 22, 23, 23, var3, 25, 25, 26, var0, var0, 28, 29, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 42, 43, 44, 46, 47, 49, 51, 52, 54, 56, 57, 59, 60})), TuplesKt.to(59, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, var1, var1, var6, var2, var2, 7, 7, var15, var7, var7, 10, 10, var13, var11, var11, 13, var5, var5, var12, var12, 16, var9, var9, 18, 18, var10, var14, var14, var4, 22, 22, 23, 23, var3, 25, 25, 26, 26, var0, 28, 28, 29, 30, 31, 32, 32, 33, 34, 36, 37, 38, 39, 40, 42, 43, 44, 46, 47, 49, 50, 52, 53, 55, 56, 60})), TuplesKt.to(63, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, var1, var1, var6, var6, var2, var2, 7, var15, var15, var7, var7, 10, 10, var13, var11, var11, 13, 13, var5, var12, var12, 16, 16, var9, var9, 18, var10, var10, var14, var14, var4, var4, 22, 23, 23, var3, var3, 25, 25, 26, var0, var0, 28, 29, 30, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 41, 42, 44, 45, 46, 48, 49, 50, 52, 53, 55, 56, 60})), TuplesKt.to(64, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, var1, var1, var6, var6, var2, var2, 7, var15, var15, var7, var7, 10, 10, var13, var11, var11, 13, 13, var5, var12, var12, 16, 16, var9, var9, 18, var10, var10, var14, var14, var4, var4, 22, 23, 23, var3, var3, 25, 25, 26, var0, var0, 28, 29, 30, 30, 31, 32, 33, 34, 35, 36, 37, 39, 40, 41, 42, 44, 45, 46, 48, 49, 50, 52, 53, 55, 56, 60})), TuplesKt.to(67, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, var1, var1, var6, var6, var2, var2, 7, 7, var15, var15, var7, var7, 10, 10, var13, var11, var11, 13, 13, var5, var5, var12, var12, 16, 16, var9, var9, 18, 18, var10, var10, var14, var4, var4, 22, 22, 23, 23, var3, var3, 25, 25, 26, var0, 28, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 44, 45, 46, 47, 49, 50, 51, 52, 54, 55, 60})), TuplesKt.to(71, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, 3, var1, var1, var6, var6, var2, var2, 7, 7, var15, var15, var7, var7, 10, 10, var13, var13, var11, var11, 13, 13, var5, var5, var12, var12, 16, 16, var9, var9, 18, 18, var10, var10, var14, var14, var4, var4, var4, 22, 22, 23, var3, var3, 25, 25, 26, var0, 28, 28, 29, 30, 31, 32, 33, 34, 35, 35, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 52, 53, 54, 55, 60})), TuplesKt.to(75, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, 3, var1, var1, var6, var6, var2, var2, 7, 7, 7, var15, var15, var7, var7, 10, 10, var13, var13, var13, var11, var11, 13, 13, var5, var5, var12, var12, var12, 16, 16, var9, var9, 18, 18, var10, var10, var10, var14, var14, var4, var4, 22, 22, 23, 23, var3, 25, 25, 26, var0, var0, 28, 29, 30, 30, 31, 32, 33, 34, 35, 36, 37, 38, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 49, 50, 51, 52, 53, 54, 55, 56, 57, 60})), TuplesKt.to(79, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, 3, var1, var1, var6, var6, var6, var2, var2, 7, 7, 7, var15, var15, var7, var7, var7, 10, 10, var13, var13, var13, var11, var11, 13, 13, 13, var5, var5, var12, var12, var12, 16, 16, var9, var9, var9, 18, 18, var10, var10, var10, var14, var14, var4, var4, 22, 22, 23, var3, var3, 25, 25, 26, var0, var0, 28, 29, 29, 30, 31, 32, 32, 33, 34, 35, 36, 36, 37, 38, 39, 39, 40, 41, 42, 42, 43, 44, 45, 45, 46, 47, 48, 48, 49, 50, 51, 51, 52, 53, 54, 54, 60})), TuplesKt.to(83, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, 3, var1, var1, var1, var6, var6, var6, var2, var2, 7, 7, 7, var15, var15, var15, var7, var7, var7, 10, 10, 10, var13, var13, var11, var11, var11, 13, 13, 13, var5, var5, var5, var12, var12, 16, 16, 16, var9, var9, var9, 18, 18, var10, var10, var10, var14, var14, var4, var4, 22, 22, 23, 23, var3, var3, 25, 25, 26, var0, var0, 28, 28, 29, 30, 30, 31, 31, 32, 33, 33, 34, 34, 35, 36, 36, 37, 37, 38, 39, 39, 40, 40, 41, 41, 42, 43, 43, 44, 44, 45, 46, 46, 47, 47, 48, 49, 49, 50, 51, 51, 52, 53, 55, 60})), TuplesKt.to(87, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, 3, var1, var1, var1, var1, var6, var6, var6, var2, var2, var2, 7, 7, 7, var15, var15, var15, var7, var7, var7, 10, 10, 10, var13, var13, var13, var13, var11, var11, var11, 13, 13, 13, var5, var5, var5, var12, var12, var12, 16, 16, 16, var9, var9, var9, 18, 18, 18, var10, var10, var14, var14, var14, var4, var4, 22, 22, 22, 23, 23, var3, var3, 25, 25, 25, 26, 26, var0, var0, 28, 28, 29, 29, 29, 30, 30, 31, 31, 32, 32, 33, 33, 33, 34, 34, 35, 35, 36, 36, 36, 37, 37, 38, 38, 39, 39, 40, 40, 40, 41, 41, 42, 42, 43, 43, 43, 44, 44, 45, 46, 49, 52, 56, 60})), TuplesKt.to(91, CollectionsKt.listOf(new Integer[]{0, 1, 2, 2, 3, 3, 3, var1, var1, var1, var6, var6, var6, var6, var2, var2, var2, var2, 7, 7, 7, var15, var15, var15, var15, var7, var7, var7, var7, 10, 10, 10, var13, var13, var13, var13, var11, var11, var11, 13, 13, 13, 13, var5, var5, var5, var5, var12, var12, var12, 16, 16, 16, 16, var9, var9, var9, 18, 18, 18, 18, var10, var10, var10, var10, var14, var14, var14, var4, var4, var4, var4, 22, 22, 22, 23, 23, 23, 23, var3, var3, var0, var0, var0, var0, 26, 26, 26, 26, 26, var0, var0, var0, var0, var0, 28, 28, 28, 29, 29, 30, 30, 31, 32, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 46, 47, 48, 50, 51, 53, 54, 56, 60}))});
   }

   private EtaUtils() {
   }

   public final int calcEtaPercent(int var1) {
      return 100 - (int)Math.max(Math.min((double)var1 / (double)60.0F * (double)100.0F, (double)100.0F), (double)0.0F);
   }

   public final int eta(int var1, int var2) {
      if (var2 <= 25) {
         return 0;
      } else {
         List var3 = (List)etaTable.get(var1);
         if (var3 != null) {
            Integer var4 = (Integer)CollectionsKt.getOrNull(var3, var2 - 25);
            if (var4 != null) {
               return Math.min(60, Math.max(((Number)var4).intValue(), 0));
            }
         }

         return Integer.MAX_VALUE;
      }
   }

   public final CharSequence etaString(Context var1, int var2, Float var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      int var4;
      if (var3 != null) {
         var4 = (int)var3;
      } else {
         var4 = Integer.MAX_VALUE;
      }

      int var5 = this.eta(var2, var4);
      if (var5 > 60) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      int var6 = this.calcEtaPercent(var5);
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var8 = new StringBuilder("update: eta = ");
      var8.append(var5);
      var8.append(", perc = ");
      var8.append(var6);
      var8.append(", pm25 = ");
      var8.append(var3);
      var8.append(", fanspeed = ");
      var8.append(var2);
      var7.d(var8.toString(), new Object[0]);
      String var9;
      String var11;
      if (var5 == 0) {
         var9 = var1.getResources().getString(R.string.eta_success);
         var11 = null;
      } else {
         String var14 = var1.getResources().getString(R.string.clear_air_in);
         var8 = new StringBuilder();
         if (var4) {
            var11 = "> ";
         } else {
            var11 = "";
         }

         var8.append(var11);
         var8.append(Math.min(var5, 60));
         var8.append(' ');
         var8.append(var1.getResources().getString(R.string.eta_minutes));
         var11 = var8.toString();
         var9 = var14;
      }

      if (var11 == null) {
         return (CharSequence)var9;
      } else {
         StringBuilder var15 = new StringBuilder();
         var15.append(var9);
         var15.append(" <b>");
         var15.append(var11);
         var15.append("</b>");
         Spanned var10 = HtmlCompat.fromHtml(var15.toString(), 0);
         Intrinsics.checkNotNull(var10);
         return (CharSequence)var10;
      }
   }

   public final Map getEtaTable() {
      return etaTable;
   }
}
