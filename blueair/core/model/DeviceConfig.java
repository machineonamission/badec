package com.blueair.core.model;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003Jc\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006+"},
   d2 = {"Lcom/blueair/core/model/DeviceConfig;", "", "type", "Lcom/blueair/core/model/DeviceType;", "modelName", "Lcom/blueair/core/model/I18nConfig;", "familyName", "image", "Lcom/blueair/core/model/DeviceImage;", "filter", "Lcom/blueair/core/model/FilterConfig;", "manual", "market", "", "", "<init>", "(Lcom/blueair/core/model/DeviceType;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/I18nConfig;Lcom/blueair/core/model/DeviceImage;Lcom/blueair/core/model/FilterConfig;Lcom/blueair/core/model/I18nConfig;Ljava/util/Set;)V", "getType", "()Lcom/blueair/core/model/DeviceType;", "getModelName", "()Lcom/blueair/core/model/I18nConfig;", "getFamilyName", "getImage", "()Lcom/blueair/core/model/DeviceImage;", "getFilter", "()Lcom/blueair/core/model/FilterConfig;", "getManual", "getMarket", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceConfig {
   private final I18nConfig familyName;
   private final FilterConfig filter;
   private final DeviceImage image;
   private final I18nConfig manual;
   private final Set market;
   private final I18nConfig modelName;
   private final DeviceType type;

   public DeviceConfig(DeviceType var1, I18nConfig var2, I18nConfig var3, DeviceImage var4, FilterConfig var5, I18nConfig var6, Set var7) {
      this.type = var1;
      this.modelName = var2;
      this.familyName = var3;
      this.image = var4;
      this.filter = var5;
      this.manual = var6;
      this.market = var7;
   }

   // $FF: synthetic method
   public static DeviceConfig copy$default(DeviceConfig var0, DeviceType var1, I18nConfig var2, I18nConfig var3, DeviceImage var4, FilterConfig var5, I18nConfig var6, Set var7, int var8, Object var9) {
      if ((var8 & 1) != 0) {
         var1 = var0.type;
      }

      if ((var8 & 2) != 0) {
         var2 = var0.modelName;
      }

      if ((var8 & 4) != 0) {
         var3 = var0.familyName;
      }

      if ((var8 & 8) != 0) {
         var4 = var0.image;
      }

      if ((var8 & 16) != 0) {
         var5 = var0.filter;
      }

      if ((var8 & 32) != 0) {
         var6 = var0.manual;
      }

      if ((var8 & 64) != 0) {
         var7 = var0.market;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7);
   }

   public final DeviceType component1() {
      return this.type;
   }

   public final I18nConfig component2() {
      return this.modelName;
   }

   public final I18nConfig component3() {
      return this.familyName;
   }

   public final DeviceImage component4() {
      return this.image;
   }

   public final FilterConfig component5() {
      return this.filter;
   }

   public final I18nConfig component6() {
      return this.manual;
   }

   public final Set component7() {
      return this.market;
   }

   public final DeviceConfig copy(DeviceType var1, I18nConfig var2, I18nConfig var3, DeviceImage var4, FilterConfig var5, I18nConfig var6, Set var7) {
      return new DeviceConfig(var1, var2, var3, var4, var5, var6, var7);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceConfig)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.type, var1.type)) {
            return false;
         } else if (!Intrinsics.areEqual(this.modelName, var1.modelName)) {
            return false;
         } else if (!Intrinsics.areEqual(this.familyName, var1.familyName)) {
            return false;
         } else if (this.image != var1.image) {
            return false;
         } else if (!Intrinsics.areEqual(this.filter, var1.filter)) {
            return false;
         } else if (!Intrinsics.areEqual(this.manual, var1.manual)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.market, var1.market);
         }
      }
   }

   public final I18nConfig getFamilyName() {
      return this.familyName;
   }

   public final FilterConfig getFilter() {
      return this.filter;
   }

   public final DeviceImage getImage() {
      return this.image;
   }

   public final I18nConfig getManual() {
      return this.manual;
   }

   public final Set getMarket() {
      return this.market;
   }

   public final I18nConfig getModelName() {
      return this.modelName;
   }

   public final DeviceType getType() {
      return this.type;
   }

   public int hashCode() {
      DeviceType var8 = this.type;
      int var7 = 0;
      int var1;
      if (var8 == null) {
         var1 = 0;
      } else {
         var1 = var8.hashCode();
      }

      I18nConfig var9 = this.modelName;
      int var2;
      if (var9 == null) {
         var2 = 0;
      } else {
         var2 = var9.hashCode();
      }

      var9 = this.familyName;
      int var3;
      if (var9 == null) {
         var3 = 0;
      } else {
         var3 = var9.hashCode();
      }

      DeviceImage var11 = this.image;
      int var4;
      if (var11 == null) {
         var4 = 0;
      } else {
         var4 = var11.hashCode();
      }

      FilterConfig var12 = this.filter;
      int var5;
      if (var12 == null) {
         var5 = 0;
      } else {
         var5 = var12.hashCode();
      }

      I18nConfig var13 = this.manual;
      int var6;
      if (var13 == null) {
         var6 = 0;
      } else {
         var6 = var13.hashCode();
      }

      Set var14 = this.market;
      if (var14 != null) {
         var7 = var14.hashCode();
      }

      return (((((var1 * 31 + var2) * 31 + var3) * 31 + var4) * 31 + var5) * 31 + var6) * 31 + var7;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceConfig(type=");
      var1.append(this.type);
      var1.append(", modelName=");
      var1.append(this.modelName);
      var1.append(", familyName=");
      var1.append(this.familyName);
      var1.append(", image=");
      var1.append(this.image);
      var1.append(", filter=");
      var1.append(this.filter);
      var1.append(", manual=");
      var1.append(this.manual);
      var1.append(", market=");
      var1.append(this.market);
      var1.append(')');
      return var1.toString();
   }
}
