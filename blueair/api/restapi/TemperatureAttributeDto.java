package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"},
   d2 = {"Lcom/blueair/api/restapi/TemperatureAttributeDto;", "", "currentValue", "", "defaultValue", "userId", "", "name", "scope", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCurrentValue", "()Ljava/lang/String;", "getDefaultValue", "getUserId", "()I", "getName", "getScope", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TemperatureAttributeDto {
   private final String currentValue;
   private final String defaultValue;
   private final String name;
   private final String scope;
   private final int userId;

   public TemperatureAttributeDto(String var1, String var2, int var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "currentValue");
      Intrinsics.checkNotNullParameter(var2, "defaultValue");
      Intrinsics.checkNotNullParameter(var4, "name");
      Intrinsics.checkNotNullParameter(var5, "scope");
      super();
      this.currentValue = var1;
      this.defaultValue = var2;
      this.userId = var3;
      this.name = var4;
      this.scope = var5;
   }

   // $FF: synthetic method
   public TemperatureAttributeDto(String var1, String var2, int var3, String var4, String var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = "temperature";
      }

      if ((var6 & 16) != 0) {
         var5 = "User";
      }

      this(var1, var2, var3, var4, var5);
   }

   // $FF: synthetic method
   public static TemperatureAttributeDto copy$default(TemperatureAttributeDto var0, String var1, String var2, int var3, String var4, String var5, int var6, Object var7) {
      if ((var6 & 1) != 0) {
         var1 = var0.currentValue;
      }

      if ((var6 & 2) != 0) {
         var2 = var0.defaultValue;
      }

      if ((var6 & 4) != 0) {
         var3 = var0.userId;
      }

      if ((var6 & 8) != 0) {
         var4 = var0.name;
      }

      if ((var6 & 16) != 0) {
         var5 = var0.scope;
      }

      return var0.copy(var1, var2, var3, var4, var5);
   }

   public final String component1() {
      return this.currentValue;
   }

   public final String component2() {
      return this.defaultValue;
   }

   public final int component3() {
      return this.userId;
   }

   public final String component4() {
      return this.name;
   }

   public final String component5() {
      return this.scope;
   }

   public final TemperatureAttributeDto copy(String var1, String var2, int var3, String var4, String var5) {
      Intrinsics.checkNotNullParameter(var1, "currentValue");
      Intrinsics.checkNotNullParameter(var2, "defaultValue");
      Intrinsics.checkNotNullParameter(var4, "name");
      Intrinsics.checkNotNullParameter(var5, "scope");
      return new TemperatureAttributeDto(var1, var2, var3, var4, var5);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof TemperatureAttributeDto)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.currentValue, var1.currentValue)) {
            return false;
         } else if (!Intrinsics.areEqual(this.defaultValue, var1.defaultValue)) {
            return false;
         } else if (this.userId != var1.userId) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.scope, var1.scope);
         }
      }
   }

   public final String getCurrentValue() {
      return this.currentValue;
   }

   public final String getDefaultValue() {
      return this.defaultValue;
   }

   public final String getName() {
      return this.name;
   }

   public final String getScope() {
      return this.scope;
   }

   public final int getUserId() {
      return this.userId;
   }

   public int hashCode() {
      return (((this.currentValue.hashCode() * 31 + this.defaultValue.hashCode()) * 31 + this.userId) * 31 + this.name.hashCode()) * 31 + this.scope.hashCode();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("TemperatureAttributeDto(currentValue=");
      var1.append(this.currentValue);
      var1.append(", defaultValue=");
      var1.append(this.defaultValue);
      var1.append(", userId=");
      var1.append(this.userId);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", scope=");
      var1.append(this.scope);
      var1.append(')');
      return var1.toString();
   }
}
