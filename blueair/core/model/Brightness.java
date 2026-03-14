package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000f"},
   d2 = {"Lcom/blueair/core/model/Brightness;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "ONE", "TWO", "THREE", "FOUR", "toServerValue", "", "device", "Lcom/blueair/core/model/Device;", "toPercentage", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum Brightness {
   private static final EnumEntries $ENTRIES;
   private static final Brightness[] $VALUES;
   public static final Companion Companion;
   FOUR,
   OFF,
   ONE,
   THREE,
   TWO;

   // $FF: synthetic method
   private static final Brightness[] $values() {
      return new Brightness[]{OFF, ONE, TWO, THREE, FOUR};
   }

   static {
      Brightness[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int toPercentage() {
      int var1 = Brightness.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               if (var1 != 4) {
                  if (var1 == 5) {
                     return 100;
                  } else {
                     throw new NoWhenBranchMatchedException();
                  }
               } else {
                  return 75;
               }
            } else {
               return 50;
            }
         } else {
            return 25;
         }
      } else {
         return 0;
      }
   }

   public final int toServerValue(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (!(var1 instanceof HasBlueCloudFunctions) && !(var1 instanceof DeviceAware)) {
         int var3 = Brightness.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
         if (var3 != 1) {
            if (var3 != 2) {
               if (var3 != 3) {
                  if (var3 != 4) {
                     if (var3 == 5) {
                        return 4;
                     } else {
                        throw new NoWhenBranchMatchedException();
                     }
                  } else {
                     return 3;
                  }
               } else {
                  return 2;
               }
            } else {
               return 1;
            }
         } else {
            return 0;
         }
      } else {
         int var2 = Brightness.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               if (var2 != 3) {
                  if (var2 != 4) {
                     if (var2 == 5) {
                        return 100;
                     } else {
                        throw new NoWhenBranchMatchedException();
                     }
                  } else {
                     return 75;
                  }
               } else {
                  return 50;
               }
            } else {
               return 25;
            }
         } else {
            return 0;
         }
      }
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"},
      d2 = {"Lcom/blueair/core/model/Brightness$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/Brightness;", "device", "Lcom/blueair/core/model/Device;", "value", "", "fromPercentage", "percentage", "isSlidingRight", "", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final Brightness fromPercentage(int var1, boolean var2) {
         if (var1 == 100) {
            return Brightness.FOUR;
         } else if (76 <= var1 && var1 <= Integer.MAX_VALUE) {
            return var2 ? Brightness.FOUR : Brightness.THREE;
         } else if (var1 == 75) {
            return Brightness.THREE;
         } else if (51 <= var1 && var1 < 75) {
            return var2 ? Brightness.THREE : Brightness.TWO;
         } else if (var1 == 50) {
            return Brightness.TWO;
         } else if (26 <= var1 && var1 < 50) {
            return var2 ? Brightness.TWO : Brightness.ONE;
         } else if (var1 == 25) {
            return Brightness.ONE;
         } else if (1 <= var1 && var1 < 25) {
            return var2 ? Brightness.ONE : Brightness.OFF;
         } else {
            return Brightness.OFF;
         }
      }

      public final Brightness fromServerValue(Device var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         if (!(var1 instanceof HasBrightness)) {
            return Brightness.OFF;
         } else if (!(var1 instanceof DeviceAware) && !DeviceKt.isG4orB4orNB(var1)) {
            if (4 <= var2 && var2 <= Integer.MAX_VALUE) {
               return Brightness.FOUR;
            } else if (var2 == 3) {
               return Brightness.THREE;
            } else if (var2 == 2) {
               return Brightness.TWO;
            } else {
               return var2 == 1 ? Brightness.ONE : Brightness.OFF;
            }
         } else if (76 <= var2 && var2 <= Integer.MAX_VALUE) {
            return Brightness.FOUR;
         } else if (51 <= var2 && var2 < 76) {
            return Brightness.THREE;
         } else if (26 <= var2 && var2 < 51) {
            return Brightness.TWO;
         } else {
            return 1 <= var2 && var2 < 26 ? Brightness.ONE : Brightness.OFF;
         }
      }
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
         int[] var0 = new int[Brightness.values().length];

         try {
            var0[Brightness.OFF.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[Brightness.ONE.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[Brightness.TWO.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[Brightness.THREE.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Brightness.FOUR.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
