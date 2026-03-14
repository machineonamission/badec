package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jq\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006,"},
   d2 = {"Lcom/blueair/api/restapi/ConfigurationAutoMode;", "", "p", "", "a", "tf", "", "e", "ot", "autoModeTrigger", "nightModeTrigger", "tn", "n", "fe", "<init>", "(ZZLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getP", "()Z", "getA", "getTf", "()Ljava/lang/String;", "getE", "getOt", "getAutoModeTrigger", "getNightModeTrigger", "getTn", "getN", "getFe", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "other", "hashCode", "", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ConfigurationAutoMode {
   private final boolean a;
   private final String autoModeTrigger;
   private final boolean e;
   private final boolean fe;
   private final String n;
   private final String nightModeTrigger;
   private final String ot;
   private final boolean p;
   private final String tf;
   private final String tn;

   public ConfigurationAutoMode(boolean var1, boolean var2, String var3, boolean var4, String var5, @Json(name = "amt") String var6, @Json(name = "nmt") String var7, String var8, String var9, boolean var10) {
      Intrinsics.checkNotNullParameter(var3, "tf");
      Intrinsics.checkNotNullParameter(var5, "ot");
      Intrinsics.checkNotNullParameter(var8, "tn");
      Intrinsics.checkNotNullParameter(var9, "n");
      super();
      this.p = var1;
      this.a = var2;
      this.tf = var3;
      this.e = var4;
      this.ot = var5;
      this.autoModeTrigger = var6;
      this.nightModeTrigger = var7;
      this.tn = var8;
      this.n = var9;
      this.fe = var10;
   }

   // $FF: synthetic method
   public static ConfigurationAutoMode copy$default(ConfigurationAutoMode var0, boolean var1, boolean var2, String var3, boolean var4, String var5, String var6, String var7, String var8, String var9, boolean var10, int var11, Object var12) {
      if ((var11 & 1) != 0) {
         var1 = var0.p;
      }

      if ((var11 & 2) != 0) {
         var2 = var0.a;
      }

      if ((var11 & 4) != 0) {
         var3 = var0.tf;
      }

      if ((var11 & 8) != 0) {
         var4 = var0.e;
      }

      if ((var11 & 16) != 0) {
         var5 = var0.ot;
      }

      if ((var11 & 32) != 0) {
         var6 = var0.autoModeTrigger;
      }

      if ((var11 & 64) != 0) {
         var7 = var0.nightModeTrigger;
      }

      if ((var11 & 128) != 0) {
         var8 = var0.tn;
      }

      if ((var11 & 256) != 0) {
         var9 = var0.n;
      }

      if ((var11 & 512) != 0) {
         var10 = var0.fe;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public final boolean component1() {
      return this.p;
   }

   public final boolean component10() {
      return this.fe;
   }

   public final boolean component2() {
      return this.a;
   }

   public final String component3() {
      return this.tf;
   }

   public final boolean component4() {
      return this.e;
   }

   public final String component5() {
      return this.ot;
   }

   public final String component6() {
      return this.autoModeTrigger;
   }

   public final String component7() {
      return this.nightModeTrigger;
   }

   public final String component8() {
      return this.tn;
   }

   public final String component9() {
      return this.n;
   }

   public final ConfigurationAutoMode copy(boolean var1, boolean var2, String var3, boolean var4, String var5, @Json(name = "amt") String var6, @Json(name = "nmt") String var7, String var8, String var9, boolean var10) {
      Intrinsics.checkNotNullParameter(var3, "tf");
      Intrinsics.checkNotNullParameter(var5, "ot");
      Intrinsics.checkNotNullParameter(var8, "tn");
      Intrinsics.checkNotNullParameter(var9, "n");
      return new ConfigurationAutoMode(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ConfigurationAutoMode)) {
         return false;
      } else {
         var1 = var1;
         if (this.p != var1.p) {
            return false;
         } else if (this.a != var1.a) {
            return false;
         } else if (!Intrinsics.areEqual(this.tf, var1.tf)) {
            return false;
         } else if (this.e != var1.e) {
            return false;
         } else if (!Intrinsics.areEqual(this.ot, var1.ot)) {
            return false;
         } else if (!Intrinsics.areEqual(this.autoModeTrigger, var1.autoModeTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.nightModeTrigger, var1.nightModeTrigger)) {
            return false;
         } else if (!Intrinsics.areEqual(this.tn, var1.tn)) {
            return false;
         } else if (!Intrinsics.areEqual(this.n, var1.n)) {
            return false;
         } else {
            return this.fe == var1.fe;
         }
      }
   }

   public final boolean getA() {
      return this.a;
   }

   public final String getAutoModeTrigger() {
      return this.autoModeTrigger;
   }

   public final boolean getE() {
      return this.e;
   }

   public final boolean getFe() {
      return this.fe;
   }

   public final String getN() {
      return this.n;
   }

   public final String getNightModeTrigger() {
      return this.nightModeTrigger;
   }

   public final String getOt() {
      return this.ot;
   }

   public final boolean getP() {
      return this.p;
   }

   public final String getTf() {
      return this.tf;
   }

   public final String getTn() {
      return this.tn;
   }

   public int hashCode() {
      int var4 = AddDeviceState$$ExternalSyntheticBackport0.m(this.p);
      int var7 = AddDeviceState$$ExternalSyntheticBackport0.m(this.a);
      int var5 = this.tf.hashCode();
      int var6 = AddDeviceState$$ExternalSyntheticBackport0.m(this.e);
      int var3 = this.ot.hashCode();
      String var8 = this.autoModeTrigger;
      int var2 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      var8 = this.nightModeTrigger;
      if (var8 != null) {
         var2 = var8.hashCode();
      }

      return ((((((((var4 * 31 + var7) * 31 + var5) * 31 + var6) * 31 + var3) * 31 + var1) * 31 + var2) * 31 + this.tn.hashCode()) * 31 + this.n.hashCode()) * 31 + AddDeviceState$$ExternalSyntheticBackport0.m(this.fe);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("ConfigurationAutoMode(p=");
      var1.append(this.p);
      var1.append(", a=");
      var1.append(this.a);
      var1.append(", tf=");
      var1.append(this.tf);
      var1.append(", e=");
      var1.append(this.e);
      var1.append(", ot=");
      var1.append(this.ot);
      var1.append(", autoModeTrigger=");
      var1.append(this.autoModeTrigger);
      var1.append(", nightModeTrigger=");
      var1.append(this.nightModeTrigger);
      var1.append(", tn=");
      var1.append(this.tn);
      var1.append(", n=");
      var1.append(this.n);
      var1.append(", fe=");
      var1.append(this.fe);
      var1.append(')');
      return var1.toString();
   }
}
