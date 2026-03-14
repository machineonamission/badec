package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003JP\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0003HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006)"},
   d2 = {"Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "", "userId", "", "uuid", "", "scope", "name", "currentValue", "defaultValue", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUuid", "()Ljava/lang/String;", "getScope", "getName", "getCurrentValue", "getDefaultValue", "getParsedAttribute", "Lcom/blueair/api/restapi/DeviceAttribute;", "getBooleanForAttribute", "", "getStringForAttribute", "getIntForAttribute", "getLongForAttribute", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "equals", "other", "hashCode", "toString", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAttributeOnAbl {
   private final String currentValue;
   private final String defaultValue;
   private final String name;
   private final String scope;
   private final Integer userId;
   private final String uuid;

   public DeviceAttributeOnAbl(Integer var1, String var2, String var3, String var4, String var5, String var6) {
      Intrinsics.checkNotNullParameter(var2, "uuid");
      Intrinsics.checkNotNullParameter(var3, "scope");
      Intrinsics.checkNotNullParameter(var4, "name");
      super();
      this.userId = var1;
      this.uuid = var2;
      this.scope = var3;
      this.name = var4;
      this.currentValue = var5;
      this.defaultValue = var6;
   }

   // $FF: synthetic method
   public DeviceAttributeOnAbl(Integer var1, String var2, String var3, String var4, String var5, String var6, int var7, DefaultConstructorMarker var8) {
      if ((var7 & 4) != 0) {
         var3 = "device";
      }

      this(var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static DeviceAttributeOnAbl copy$default(DeviceAttributeOnAbl var0, Integer var1, String var2, String var3, String var4, String var5, String var6, int var7, Object var8) {
      if ((var7 & 1) != 0) {
         var1 = var0.userId;
      }

      if ((var7 & 2) != 0) {
         var2 = var0.uuid;
      }

      if ((var7 & 4) != 0) {
         var3 = var0.scope;
      }

      if ((var7 & 8) != 0) {
         var4 = var0.name;
      }

      if ((var7 & 16) != 0) {
         var5 = var0.currentValue;
      }

      if ((var7 & 32) != 0) {
         var6 = var0.defaultValue;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6);
   }

   private final boolean getBooleanForAttribute() {
      return this.getIntForAttribute() == 1;
   }

   private final int getIntForAttribute() {
      CharSequence var1;
      try {
         var1 = (CharSequence)this.currentValue;
      } catch (NumberFormatException var8) {
         boolean var10001 = false;
         return 0;
      }

      label65: {
         if (var1 != null) {
            try {
               if (var1.length() != 0) {
                  break label65;
               }
            } catch (NumberFormatException var7) {
               boolean var11 = false;
               return 0;
            }
         }

         try {
            var1 = (CharSequence)this.defaultValue;
         } catch (NumberFormatException var6) {
            boolean var12 = false;
            return 0;
         }

         if (var1 == null) {
            return 0;
         }

         try {
            if (var1.length() == 0) {
               return 0;
            }
         } catch (NumberFormatException var5) {
            boolean var13 = false;
            return 0;
         }
      }

      try {
         var10 = this.currentValue;
      } catch (NumberFormatException var4) {
         boolean var14 = false;
         return 0;
      }

      if (var10 == null) {
         try {
            var10 = this.defaultValue;
         } catch (NumberFormatException var3) {
            boolean var15 = false;
            return 0;
         }

         if (var10 == null) {
            return 0;
         }
      }

      try {
         return Integer.parseInt(var10);
      } catch (NumberFormatException var2) {
         boolean var16 = false;
         return 0;
      }
   }

   private final long getLongForAttribute() {
      CharSequence var1;
      try {
         var1 = (CharSequence)this.currentValue;
      } catch (NumberFormatException var8) {
         boolean var10001 = false;
         return 0L;
      }

      label65: {
         if (var1 != null) {
            try {
               if (var1.length() != 0) {
                  break label65;
               }
            } catch (NumberFormatException var7) {
               boolean var11 = false;
               return 0L;
            }
         }

         try {
            var1 = (CharSequence)this.defaultValue;
         } catch (NumberFormatException var6) {
            boolean var12 = false;
            return 0L;
         }

         if (var1 == null) {
            return 0L;
         }

         try {
            if (var1.length() == 0) {
               return 0L;
            }
         } catch (NumberFormatException var5) {
            boolean var13 = false;
            return 0L;
         }
      }

      try {
         var10 = this.currentValue;
      } catch (NumberFormatException var4) {
         boolean var14 = false;
         return 0L;
      }

      if (var10 == null) {
         try {
            var10 = this.defaultValue;
         } catch (NumberFormatException var3) {
            boolean var15 = false;
            return 0L;
         }

         if (var10 == null) {
            return 0L;
         }
      }

      try {
         return Long.parseLong(var10);
      } catch (NumberFormatException var2) {
         boolean var16 = false;
         return 0L;
      }
   }

   private final String getStringForAttribute() {
      String var2 = this.currentValue;
      String var1 = var2;
      if (var2 == null) {
         var2 = this.defaultValue;
         var1 = var2;
         if (var2 == null) {
            var1 = "";
         }
      }

      return var1;
   }

   public final Integer component1() {
      return this.userId;
   }

   public final String component2() {
      return this.uuid;
   }

   public final String component3() {
      return this.scope;
   }

   public final String component4() {
      return this.name;
   }

   public final String component5() {
      return this.currentValue;
   }

   public final String component6() {
      return this.defaultValue;
   }

   public final DeviceAttributeOnAbl copy(Integer var1, String var2, String var3, String var4, String var5, String var6) {
      Intrinsics.checkNotNullParameter(var2, "uuid");
      Intrinsics.checkNotNullParameter(var3, "scope");
      Intrinsics.checkNotNullParameter(var4, "name");
      return new DeviceAttributeOnAbl(var1, var2, var3, var4, var5, var6);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceAttributeOnAbl)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.userId, var1.userId)) {
            return false;
         } else if (!Intrinsics.areEqual(this.uuid, var1.uuid)) {
            return false;
         } else if (!Intrinsics.areEqual(this.scope, var1.scope)) {
            return false;
         } else if (!Intrinsics.areEqual(this.name, var1.name)) {
            return false;
         } else if (!Intrinsics.areEqual(this.currentValue, var1.currentValue)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.defaultValue, var1.defaultValue);
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

   public final DeviceAttribute getParsedAttribute() {
      Timber.Forest var1 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("Attempting to parse ");
      var2.append(this);
      var1.v(var2.toString(), new Object[0]);
      DeviceAttributeName var3 = DeviceAttributeName.Companion.fromName(this.name);
      switch (DeviceAttributeOnAbl.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()]) {
         case 1:
            return new DeviceAttribute.Brightness(this.getIntForAttribute());
         case 2:
            return new DeviceAttribute.FanSpeed(this.getIntForAttribute());
         case 3:
            return new DeviceAttribute.FilterRemainingMinutes(this.getIntForAttribute());
         case 4:
            return new DeviceAttribute.ChildLock(this.getBooleanForAttribute());
         case 5:
            return new DeviceAttribute.DealerCountry(this.getStringForAttribute());
         case 6:
            return new DeviceAttribute.DealerName(this.getStringForAttribute());
         case 7:
            return new DeviceAttribute.FanUsage(this.getStringForAttribute());
         case 8:
            return new DeviceAttribute.Mode(this.getStringForAttribute());
         case 9:
            return new DeviceAttribute.FilterType(this.getStringForAttribute());
         case 10:
            return new DeviceAttribute.AutoModeDependency(this.getStringForAttribute());
         case 11:
            return new DeviceAttribute.PurchaseDate(this.getStringForAttribute());
         case 12:
            return new DeviceAttribute.SerialNumber(this.getStringForAttribute());
         case 13:
            return new DeviceAttribute.UnknownAttribute(this.getStringForAttribute());
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public final String getScope() {
      return this.scope;
   }

   public final Integer getUserId() {
      return this.userId;
   }

   public final String getUuid() {
      return this.uuid;
   }

   public int hashCode() {
      Integer var7 = this.userId;
      int var3 = 0;
      int var1;
      if (var7 == null) {
         var1 = 0;
      } else {
         var1 = var7.hashCode();
      }

      int var5 = this.uuid.hashCode();
      int var4 = this.scope.hashCode();
      int var6 = this.name.hashCode();
      String var8 = this.currentValue;
      int var2;
      if (var8 == null) {
         var2 = 0;
      } else {
         var2 = var8.hashCode();
      }

      var8 = this.defaultValue;
      if (var8 != null) {
         var3 = var8.hashCode();
      }

      return ((((var1 * 31 + var5) * 31 + var4) * 31 + var6) * 31 + var2) * 31 + var3;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceAttributeOnAbl(userId=");
      var1.append(this.userId);
      var1.append(", uuid=");
      var1.append(this.uuid);
      var1.append(", scope=");
      var1.append(this.scope);
      var1.append(", name=");
      var1.append(this.name);
      var1.append(", currentValue=");
      var1.append(this.currentValue);
      var1.append(", defaultValue=");
      var1.append(this.defaultValue);
      var1.append(')');
      return var1.toString();
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;

      static {
         int[] var0 = new int[DeviceAttributeName.values().length];

         try {
            var0[DeviceAttributeName.Brightness.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[DeviceAttributeName.FanSpeed.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DeviceAttributeName.FilterRemainingMinutes.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DeviceAttributeName.ChildLock.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceAttributeName.DealerCountry.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceAttributeName.DealerName.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceAttributeName.FanUsage.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceAttributeName.Mode.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceAttributeName.FilterType.ordinal()] = 9;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceAttributeName.AutoModeDependency.ordinal()] = 10;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceAttributeName.PurchaseDate.ordinal()] = 11;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceAttributeName.SerialNumber.ordinal()] = 12;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceAttributeName.UnknownAttribute.ordinal()] = 13;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
