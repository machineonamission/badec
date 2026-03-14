package com.blueair.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u001a\u0010\u001e\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015¨\u0006!"},
   d2 = {"Lcom/blueair/core/BuildEnvironment;", "", "<init>", "()V", "variant", "Lcom/blueair/core/BuildVariant;", "getVariant", "()Lcom/blueair/core/BuildVariant;", "flavor", "Lcom/blueair/core/BuildFlavor;", "getFlavor", "()Lcom/blueair/core/BuildFlavor;", "isRelease", "", "()Z", "isChina", "versionName", "", "getVersionName", "()Ljava/lang/String;", "setVersionName", "(Ljava/lang/String;)V", "versionCode", "", "getVersionCode", "()I", "setVersionCode", "(I)V", "displayVersion", "getDisplayVersion", "applicationId", "getApplicationId", "setApplicationId", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BuildEnvironment {
   public static final BuildEnvironment INSTANCE = new BuildEnvironment();
   private static String applicationId;
   private static final BuildFlavor flavor;
   private static final boolean isChina;
   private static final boolean isRelease;
   private static final BuildVariant variant;
   private static int versionCode;
   private static String versionName;

   static {
      BuildVariant var4 = BuildVariant.RELEASE;
      variant = var4;
      BuildFlavor var2 = BuildFlavor.OTHER;
      flavor = var2;
      BuildVariant var3 = BuildVariant.RELEASE;
      boolean var1 = true;
      boolean var0;
      if (var4 == var3) {
         var0 = true;
      } else {
         var0 = false;
      }

      isRelease = var0;
      if (var2 == BuildFlavor.CHINA) {
         var0 = var1;
      } else {
         var0 = false;
      }

      isChina = var0;
      versionName = "";
      applicationId = "com.blueair.android";
   }

   private BuildEnvironment() {
   }

   public final String getApplicationId() {
      return applicationId;
   }

   public final String getDisplayVersion() {
      StringBuilder var1 = new StringBuilder();
      var1.append(versionName);
      var1.append(" (");
      var1.append(versionCode);
      var1.append(')');
      return var1.toString();
   }

   public final BuildFlavor getFlavor() {
      return flavor;
   }

   public final BuildVariant getVariant() {
      return variant;
   }

   public final int getVersionCode() {
      return versionCode;
   }

   public final String getVersionName() {
      return versionName;
   }

   public final boolean isChina() {
      return isChina;
   }

   public final boolean isRelease() {
      return isRelease;
   }

   public final void setApplicationId(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      applicationId = var1;
   }

   public final void setVersionCode(int var1) {
      versionCode = var1;
   }

   public final void setVersionName(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      versionName = var1;
   }
}
