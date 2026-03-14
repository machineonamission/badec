package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\"\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 (2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0010\u0010'\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006)"},
   d2 = {"Lcom/blueair/core/model/FanSpeedEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "ELEVEN", "FIFTEEN", "NINETEEN", "TWENTY_THREE", "TWENTY_SEVEN", "THIRTY_ONE", "THIRTY_FIVE", "THIRTY_SEVEN", "THIRTY_NINE", "FORTY_THREE", "FORTY_SEVEN", "FIFTY_ONE", "FIFTY_FIVE", "FIFTY_NINE", "SIXTY_THREE", "SIXTY_FOUR", "SIXTY_SEVEN", "SEVENTY_ONE", "SEVENTY_FIVE", "SEVENTY_NINE", "EIGHTY_THREE", "EIGHTY_SEVEN", "NINETY_ONE", "SNAP_STEP", "toServerValue", "", "device", "Lcom/blueair/core/model/Device;", "toStep", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum FanSpeedEnum {
   private static final EnumEntries $ENTRIES;
   private static final FanSpeedEnum[] $VALUES;
   public static final Companion Companion;
   EIGHTY_SEVEN,
   EIGHTY_THREE,
   ELEVEN,
   FIFTEEN,
   FIFTY_FIVE,
   FIFTY_NINE,
   FIFTY_ONE,
   FIVE,
   FORTY_SEVEN,
   FORTY_THREE,
   FOUR,
   NINETEEN,
   NINETY_ONE,
   OFF,
   ONE,
   SEVENTY_FIVE,
   SEVENTY_NINE,
   SEVENTY_ONE,
   SIX,
   SIXTY_FOUR,
   SIXTY_SEVEN,
   SIXTY_THREE,
   SNAP_STEP,
   THIRTY_FIVE,
   THIRTY_NINE,
   THIRTY_ONE,
   THIRTY_SEVEN,
   THREE,
   TWENTY_SEVEN,
   TWENTY_THREE,
   TWO;

   // $FF: synthetic method
   private static final FanSpeedEnum[] $values() {
      return new FanSpeedEnum[]{OFF, ONE, TWO, THREE, FOUR, FIVE, SIX, ELEVEN, FIFTEEN, NINETEEN, TWENTY_THREE, TWENTY_SEVEN, THIRTY_ONE, THIRTY_FIVE, THIRTY_SEVEN, THIRTY_NINE, FORTY_THREE, FORTY_SEVEN, FIFTY_ONE, FIFTY_FIVE, FIFTY_NINE, SIXTY_THREE, SIXTY_FOUR, SIXTY_SEVEN, SEVENTY_ONE, SEVENTY_FIVE, SEVENTY_NINE, EIGHTY_THREE, EIGHTY_SEVEN, NINETY_ONE, SNAP_STEP};
   }

   static {
      FanSpeedEnum[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int toServerValue(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof DeviceFanTable) {
         int var4 = FanSpeedEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
         if (var4 != 1) {
            if (var4 != 2) {
               if (var4 != 3) {
                  if (var4 != 4) {
                     return var4 != 5 ? 1 : 6;
                  } else {
                     return 5;
                  }
               } else {
                  return 4;
               }
            } else {
               return 3;
            }
         } else {
            return 2;
         }
      } else {
         Companion var3 = Companion;
         if (var3.isUsingTypicallyConfig(var1)) {
            switch (FanSpeedEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
               case 6:
                  return 0;
               case 7:
                  return 11;
               case 8:
                  return 51;
               case 9:
                  return 91;
               default:
                  return 0;
            }
         } else if (var3.isUsingFourGearConfig(var1)) {
            switch (FanSpeedEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
               case 6:
                  return 0;
               case 7:
                  return 11;
               case 8:
               default:
                  return 0;
               case 9:
                  return 91;
               case 10:
                  return 37;
               case 11:
                  return 64;
            }
         } else if (var1 instanceof HasFanSpeed && ((HasFanSpeed)var1).getHasGear4()) {
            switch (FanSpeedEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
               case 6:
                  return 0;
               case 7:
                  return 11;
               case 8:
                  return 51;
               case 9:
                  return 91;
               case 10:
                  return 37;
               case 11:
                  return 64;
               case 12:
                  return 15;
               case 13:
                  return 19;
               case 14:
                  return 23;
               case 15:
                  return 27;
               case 16:
                  return 31;
               case 17:
                  return 35;
               case 18:
                  return 39;
               case 19:
                  return 43;
               case 20:
                  return 47;
               case 21:
                  return 55;
               case 22:
                  return 59;
               case 23:
                  return 67;
               case 24:
                  return 71;
               case 25:
                  return 75;
               case 26:
                  return 79;
               case 27:
                  return 83;
               case 28:
                  return 87;
               default:
                  return 0;
            }
         } else if (DeviceKt.isG4orB4orNB(var1)) {
            switch (FanSpeedEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
               case 6:
                  return 0;
               case 7:
                  return 11;
               case 8:
                  return 51;
               case 9:
                  return 91;
               case 10:
                  return 37;
               case 11:
                  return 64;
               case 12:
                  return 15;
               case 13:
                  return 19;
               case 14:
                  return 23;
               case 15:
                  return 27;
               case 16:
                  return 31;
               case 17:
                  return 35;
               case 18:
                  return 39;
               case 19:
                  return 43;
               case 20:
                  return 47;
               case 21:
                  return 55;
               case 22:
                  return 59;
               case 23:
                  return 67;
               case 24:
                  return 71;
               case 25:
                  return 75;
               case 26:
                  return 79;
               case 27:
                  return 83;
               case 28:
                  return 87;
               case 29:
                  return 63;
               default:
                  return 0;
            }
         } else {
            int var2 = FanSpeedEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 6) {
                     return var2 != 30 ? 0 : 1;
                  } else {
                     return 0;
                  }
               } else {
                  return 3;
               }
            } else {
               return 2;
            }
         }
      }
   }

   public final int toStep(Device var1) {
      if (Companion.isUsingTypicallyConfig(var1)) {
         if (this.compareTo(ELEVEN) < 0) {
            return 0;
         } else if (this.compareTo(FIFTY_ONE) < 0) {
            return 1;
         } else {
            return this.compareTo(NINETY_ONE) < 0 ? 2 : 3;
         }
      } else if (this.compareTo(ELEVEN) < 0) {
         return 0;
      } else if (this.compareTo(THIRTY_SEVEN) < 0) {
         return 1;
      } else if (this.compareTo(SIXTY_FOUR) < 0) {
         return 2;
      } else if (this.compareTo(NINETY_ONE) < 0) {
         return 3;
      } else {
         if (var1 instanceof HasFanSpeed) {
            var1 = var1;
         } else {
            var1 = null;
         }

         return var1 != null && var1.getHasGear4() ? 4 : 3;
      }
   }

   @Metadata(
      d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\tJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\u0014"},
      d2 = {"Lcom/blueair/core/model/FanSpeedEnum$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/FanSpeedEnum;", "device", "Lcom/blueair/core/model/Device;", "speed", "", "isUsingFourGearConfig", "", "isUsingTypicallyConfig", "fanSpeedEnumFromProgressG4", "progress", "fanSpeedEnumFromProgressBluePremium", "fanSpeedEnumFromProgressLegacy", "fanSpeedEnumFromProgressIcp", "fromStep", "step", "core_otherRelease"},
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

      public final FanSpeedEnum fanSpeedEnumFromProgressBluePremium(int var1) {
         if (var1 != -1) {
            if (var1 != 0) {
               switch (var1) {
                  case 11:
                     return FanSpeedEnum.ELEVEN;
                  case 15:
                     return FanSpeedEnum.FIFTEEN;
                  case 19:
                     return FanSpeedEnum.NINETEEN;
                  case 23:
                     return FanSpeedEnum.TWENTY_THREE;
                  case 27:
                     return FanSpeedEnum.TWENTY_SEVEN;
                  case 31:
                     return FanSpeedEnum.THIRTY_ONE;
                  case 35:
                     return FanSpeedEnum.THIRTY_FIVE;
                  case 37:
                     return FanSpeedEnum.THIRTY_SEVEN;
                  case 39:
                     return FanSpeedEnum.THIRTY_NINE;
                  case 43:
                     return FanSpeedEnum.FORTY_THREE;
                  case 47:
                     return FanSpeedEnum.FORTY_SEVEN;
                  case 51:
                     return FanSpeedEnum.FIFTY_ONE;
                  case 55:
                     return FanSpeedEnum.FIFTY_FIVE;
                  case 59:
                     return FanSpeedEnum.FIFTY_NINE;
                  case 64:
                     return FanSpeedEnum.SIXTY_FOUR;
                  case 67:
                     return FanSpeedEnum.SIXTY_SEVEN;
                  case 71:
                     return FanSpeedEnum.SEVENTY_ONE;
                  case 75:
                     return FanSpeedEnum.SEVENTY_FIVE;
                  case 79:
                     return FanSpeedEnum.SEVENTY_NINE;
                  case 83:
                     return FanSpeedEnum.EIGHTY_THREE;
                  case 87:
                     return FanSpeedEnum.EIGHTY_SEVEN;
                  case 91:
                     return FanSpeedEnum.NINETY_ONE;
                  default:
                     return FanSpeedEnum.OFF;
               }
            } else {
               return FanSpeedEnum.OFF;
            }
         } else {
            return FanSpeedEnum.SNAP_STEP;
         }
      }

      public final FanSpeedEnum fanSpeedEnumFromProgressG4(int var1) {
         if (var1 != -1) {
            if (var1 != 0) {
               switch (var1) {
                  case 11:
                     return FanSpeedEnum.ELEVEN;
                  case 15:
                     return FanSpeedEnum.FIFTEEN;
                  case 19:
                     return FanSpeedEnum.NINETEEN;
                  case 23:
                     return FanSpeedEnum.TWENTY_THREE;
                  case 27:
                     return FanSpeedEnum.TWENTY_SEVEN;
                  case 31:
                     return FanSpeedEnum.THIRTY_ONE;
                  case 35:
                     return FanSpeedEnum.THIRTY_FIVE;
                  case 39:
                     return FanSpeedEnum.THIRTY_NINE;
                  case 43:
                     return FanSpeedEnum.FORTY_THREE;
                  case 47:
                     return FanSpeedEnum.FORTY_SEVEN;
                  case 51:
                     return FanSpeedEnum.FIFTY_ONE;
                  case 55:
                     return FanSpeedEnum.FIFTY_FIVE;
                  case 59:
                     return FanSpeedEnum.FIFTY_NINE;
                  case 63:
                     return FanSpeedEnum.SIXTY_THREE;
                  case 67:
                     return FanSpeedEnum.SIXTY_SEVEN;
                  case 71:
                     return FanSpeedEnum.SEVENTY_ONE;
                  case 75:
                     return FanSpeedEnum.SEVENTY_FIVE;
                  case 79:
                     return FanSpeedEnum.SEVENTY_NINE;
                  case 83:
                     return FanSpeedEnum.EIGHTY_THREE;
                  case 87:
                     return FanSpeedEnum.EIGHTY_SEVEN;
                  case 91:
                     return FanSpeedEnum.NINETY_ONE;
                  default:
                     return FanSpeedEnum.OFF;
               }
            } else {
               return FanSpeedEnum.OFF;
            }
         } else {
            return FanSpeedEnum.SNAP_STEP;
         }
      }

      public final FanSpeedEnum fanSpeedEnumFromProgressIcp(int var1) {
         if (var1 != -1) {
            if (var1 != 1) {
               if (var1 != 2) {
                  return var1 != 3 ? FanSpeedEnum.ONE : FanSpeedEnum.THREE;
               } else {
                  return FanSpeedEnum.TWO;
               }
            } else {
               return FanSpeedEnum.ONE;
            }
         } else {
            return FanSpeedEnum.SNAP_STEP;
         }
      }

      public final FanSpeedEnum fanSpeedEnumFromProgressLegacy(int var1) {
         if (var1 != -1) {
            if (var1 != 0) {
               if (var1 != 1) {
                  if (var1 != 2) {
                     return var1 != 3 ? FanSpeedEnum.OFF : FanSpeedEnum.THREE;
                  } else {
                     return FanSpeedEnum.TWO;
                  }
               } else {
                  return FanSpeedEnum.ONE;
               }
            } else {
               return FanSpeedEnum.OFF;
            }
         } else {
            return FanSpeedEnum.SNAP_STEP;
         }
      }

      public final FanSpeedEnum fromServerValue(Device var1, int var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         if (var1 instanceof DeviceFanTable) {
            if (var2 != 2) {
               if (var2 != 3) {
                  if (var2 != 4) {
                     if (var2 != 5) {
                        return var2 != 6 ? FanSpeedEnum.ONE : FanSpeedEnum.SIX;
                     } else {
                        return FanSpeedEnum.FIVE;
                     }
                  } else {
                     return FanSpeedEnum.FOUR;
                  }
               } else {
                  return FanSpeedEnum.THREE;
               }
            } else {
               return FanSpeedEnum.TWO;
            }
         } else if (!(var1 instanceof HasFanSpeed)) {
            return FanSpeedEnum.OFF;
         } else if (this.isUsingTypicallyConfig(var1)) {
            if (var2 >= 0 && var2 < 11) {
               return ((HasFanSpeed)var1).getHasGear0() ? FanSpeedEnum.OFF : FanSpeedEnum.ELEVEN;
            } else if (11 <= var2 && var2 < 51) {
               return FanSpeedEnum.ELEVEN;
            } else if (51 <= var2 && var2 < 91) {
               return FanSpeedEnum.FIFTY_ONE;
            } else {
               return 91 <= var2 && var2 < 101 ? FanSpeedEnum.NINETY_ONE : FanSpeedEnum.OFF;
            }
         } else if (this.isUsingFourGearConfig(var1)) {
            if (var2 >= 0 && var2 < 11) {
               return FanSpeedEnum.OFF;
            } else if (11 <= var2 && var2 < 37) {
               return FanSpeedEnum.ELEVEN;
            } else if (37 <= var2 && var2 < 64) {
               return FanSpeedEnum.THIRTY_SEVEN;
            } else if (64 <= var2 && var2 < 91) {
               return FanSpeedEnum.SIXTY_FOUR;
            } else {
               return 91 <= var2 && var2 < 101 ? FanSpeedEnum.NINETY_ONE : FanSpeedEnum.OFF;
            }
         } else if (((HasFanSpeed)var1).getHasGear4()) {
            if (var2 >= 0 && var2 < 11) {
               return FanSpeedEnum.OFF;
            } else if (11 <= var2 && var2 < 15) {
               return FanSpeedEnum.ELEVEN;
            } else if (15 <= var2 && var2 < 19) {
               return FanSpeedEnum.FIFTEEN;
            } else if (19 <= var2 && var2 < 23) {
               return FanSpeedEnum.NINETEEN;
            } else if (23 <= var2 && var2 < 27) {
               return FanSpeedEnum.TWENTY_THREE;
            } else if (27 <= var2 && var2 < 31) {
               return FanSpeedEnum.TWENTY_SEVEN;
            } else if (31 <= var2 && var2 < 35) {
               return FanSpeedEnum.THIRTY_ONE;
            } else if (35 <= var2 && var2 < 37) {
               return FanSpeedEnum.THIRTY_FIVE;
            } else if (37 <= var2 && var2 < 39) {
               return FanSpeedEnum.THIRTY_SEVEN;
            } else if (39 <= var2 && var2 < 43) {
               return FanSpeedEnum.THIRTY_NINE;
            } else if (43 <= var2 && var2 < 47) {
               return FanSpeedEnum.FORTY_THREE;
            } else if (47 <= var2 && var2 < 51) {
               return FanSpeedEnum.FORTY_SEVEN;
            } else if (51 <= var2 && var2 < 55) {
               return FanSpeedEnum.FIFTY_ONE;
            } else if (55 <= var2 && var2 < 59) {
               return FanSpeedEnum.FIFTY_FIVE;
            } else if (59 <= var2 && var2 < 64) {
               return FanSpeedEnum.FIFTY_NINE;
            } else if (64 <= var2 && var2 < 67) {
               return FanSpeedEnum.SIXTY_FOUR;
            } else if (67 <= var2 && var2 < 71) {
               return FanSpeedEnum.SIXTY_SEVEN;
            } else if (71 <= var2 && var2 < 75) {
               return FanSpeedEnum.SEVENTY_ONE;
            } else if (75 <= var2 && var2 < 79) {
               return FanSpeedEnum.SEVENTY_FIVE;
            } else if (79 <= var2 && var2 < 83) {
               return FanSpeedEnum.SEVENTY_NINE;
            } else if (83 <= var2 && var2 < 87) {
               return FanSpeedEnum.EIGHTY_THREE;
            } else if (87 <= var2 && var2 < 91) {
               return FanSpeedEnum.EIGHTY_SEVEN;
            } else {
               return 91 <= var2 && var2 < 101 ? FanSpeedEnum.NINETY_ONE : FanSpeedEnum.OFF;
            }
         } else if (var1 instanceof DeviceG4) {
            if (var2 >= 0 && var2 < 2) {
               return FanSpeedEnum.OFF;
            } else if (2 <= var2 && var2 < 15) {
               return FanSpeedEnum.ELEVEN;
            } else if (15 <= var2 && var2 < 19) {
               return FanSpeedEnum.FIFTEEN;
            } else if (19 <= var2 && var2 < 23) {
               return FanSpeedEnum.NINETEEN;
            } else if (23 <= var2 && var2 < 26) {
               return FanSpeedEnum.TWENTY_THREE;
            } else if (26 <= var2 && var2 < 31) {
               return FanSpeedEnum.TWENTY_SEVEN;
            } else if (31 <= var2 && var2 < 35) {
               return FanSpeedEnum.THIRTY_ONE;
            } else if (35 <= var2 && var2 < 37) {
               return FanSpeedEnum.THIRTY_FIVE;
            } else if (37 <= var2 && var2 < 39) {
               return FanSpeedEnum.THIRTY_SEVEN;
            } else if (39 <= var2 && var2 < 43) {
               return FanSpeedEnum.THIRTY_NINE;
            } else if (43 <= var2 && var2 < 47) {
               return FanSpeedEnum.FORTY_THREE;
            } else if (47 <= var2 && var2 < 51) {
               return FanSpeedEnum.FORTY_SEVEN;
            } else if (51 <= var2 && var2 < 55) {
               return FanSpeedEnum.FIFTY_ONE;
            } else if (55 <= var2 && var2 < 59) {
               return FanSpeedEnum.FIFTY_FIVE;
            } else if (59 <= var2 && var2 < 64) {
               return FanSpeedEnum.FIFTY_NINE;
            } else if (64 <= var2 && var2 < 67) {
               return FanSpeedEnum.SIXTY_FOUR;
            } else if (67 <= var2 && var2 < 71) {
               return FanSpeedEnum.SIXTY_SEVEN;
            } else if (71 <= var2 && var2 < 75) {
               return FanSpeedEnum.SEVENTY_ONE;
            } else if (75 <= var2 && var2 < 79) {
               return FanSpeedEnum.SEVENTY_FIVE;
            } else if (79 <= var2 && var2 < 83) {
               return FanSpeedEnum.SEVENTY_NINE;
            } else if (83 <= var2 && var2 < 87) {
               return FanSpeedEnum.EIGHTY_THREE;
            } else if (87 <= var2 && var2 < 91) {
               return FanSpeedEnum.EIGHTY_SEVEN;
            } else {
               return 91 <= var2 && var2 < 101 ? FanSpeedEnum.NINETY_ONE : FanSpeedEnum.OFF;
            }
         } else if (DeviceKt.isG4orB4orNB(var1)) {
            if (var2 >= 0 && var2 < 11) {
               return FanSpeedEnum.OFF;
            } else if (11 <= var2 && var2 < 15) {
               return FanSpeedEnum.ELEVEN;
            } else if (15 <= var2 && var2 < 19) {
               return FanSpeedEnum.FIFTEEN;
            } else if (19 <= var2 && var2 < 23) {
               return FanSpeedEnum.NINETEEN;
            } else if (23 <= var2 && var2 < 27) {
               return FanSpeedEnum.TWENTY_THREE;
            } else if (27 <= var2 && var2 < 31) {
               return FanSpeedEnum.TWENTY_SEVEN;
            } else if (31 <= var2 && var2 < 35) {
               return FanSpeedEnum.THIRTY_ONE;
            } else if (35 <= var2 && var2 < 39) {
               return FanSpeedEnum.THIRTY_FIVE;
            } else if (39 <= var2 && var2 < 43) {
               return FanSpeedEnum.THIRTY_NINE;
            } else if (43 <= var2 && var2 < 47) {
               return FanSpeedEnum.FORTY_THREE;
            } else if (47 <= var2 && var2 < 51) {
               return FanSpeedEnum.FORTY_SEVEN;
            } else if (51 <= var2 && var2 < 55) {
               return FanSpeedEnum.FIFTY_ONE;
            } else if (55 <= var2 && var2 < 59) {
               return FanSpeedEnum.FIFTY_FIVE;
            } else if (59 <= var2 && var2 < 63) {
               return FanSpeedEnum.FIFTY_NINE;
            } else if (63 <= var2 && var2 < 67) {
               return FanSpeedEnum.SIXTY_THREE;
            } else if (67 <= var2 && var2 < 71) {
               return FanSpeedEnum.SIXTY_SEVEN;
            } else if (71 <= var2 && var2 < 75) {
               return FanSpeedEnum.SEVENTY_ONE;
            } else if (75 <= var2 && var2 < 79) {
               return FanSpeedEnum.SEVENTY_FIVE;
            } else if (79 <= var2 && var2 < 83) {
               return FanSpeedEnum.SEVENTY_NINE;
            } else if (83 <= var2 && var2 < 87) {
               return FanSpeedEnum.EIGHTY_THREE;
            } else if (87 <= var2 && var2 < 91) {
               return FanSpeedEnum.EIGHTY_SEVEN;
            } else {
               return 91 <= var2 && var2 < 101 ? FanSpeedEnum.NINETY_ONE : FanSpeedEnum.OFF;
            }
         } else if (3 <= var2 && var2 <= Integer.MAX_VALUE) {
            return FanSpeedEnum.THREE;
         } else if (var2 == 2) {
            return FanSpeedEnum.TWO;
         } else {
            return var2 == 1 ? FanSpeedEnum.ONE : FanSpeedEnum.OFF;
         }
      }

      public final FanSpeedEnum fromStep(int var1, Device var2) {
         if (this.isUsingTypicallyConfig(var2)) {
            if (var1 != 0) {
               if (var1 != 1) {
                  if (var1 != 2) {
                     return var1 != 3 ? FanSpeedEnum.OFF : FanSpeedEnum.NINETY_ONE;
                  } else {
                     return FanSpeedEnum.FIFTY_ONE;
                  }
               } else {
                  return FanSpeedEnum.ELEVEN;
               }
            } else {
               return FanSpeedEnum.OFF;
            }
         } else if (var2 instanceof DeviceFanTable) {
            if (var1 != 2) {
               if (var1 != 3) {
                  if (var1 != 4) {
                     if (var1 != 5) {
                        return var1 != 6 ? FanSpeedEnum.ONE : FanSpeedEnum.SIX;
                     } else {
                        return FanSpeedEnum.FIVE;
                     }
                  } else {
                     return FanSpeedEnum.FOUR;
                  }
               } else {
                  return FanSpeedEnum.THREE;
               }
            } else {
               return FanSpeedEnum.TWO;
            }
         } else if (var1 != 0) {
            if (var1 != 1) {
               if (var1 != 2) {
                  if (var1 != 3) {
                     return var1 != 4 ? FanSpeedEnum.OFF : FanSpeedEnum.NINETY_ONE;
                  } else {
                     return FanSpeedEnum.SIXTY_FOUR;
                  }
               } else {
                  return FanSpeedEnum.THIRTY_SEVEN;
               }
            } else {
               return FanSpeedEnum.ELEVEN;
            }
         } else {
            return FanSpeedEnum.OFF;
         }
      }

      public final boolean isUsingFourGearConfig(Device var1) {
         return var1 instanceof DeviceBlue40 && !((DeviceBlue40)var1).isSmallSize() || var1 instanceof DeviceHumidifier20 || var1 instanceof DeviceHumidifier;
      }

      public final boolean isUsingTypicallyConfig(Device var1) {
         return var1 instanceof DeviceDehumidifier || var1 instanceof DeviceMiniRestful || var1 instanceof DevicePet20 || var1 instanceof DeviceBlue40 && ((DeviceBlue40)var1).isSmallSize();
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
         int[] var0 = new int[FanSpeedEnum.values().length];

         try {
            var0[FanSpeedEnum.TWO.ordinal()] = 1;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[FanSpeedEnum.THREE.ordinal()] = 2;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[FanSpeedEnum.FOUR.ordinal()] = 3;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[FanSpeedEnum.FIVE.ordinal()] = 4;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[FanSpeedEnum.SIX.ordinal()] = 5;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[FanSpeedEnum.OFF.ordinal()] = 6;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[FanSpeedEnum.ELEVEN.ordinal()] = 7;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_ONE.ordinal()] = 8;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[FanSpeedEnum.NINETY_ONE.ordinal()] = 9;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_SEVEN.ordinal()] = 10;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_FOUR.ordinal()] = 11;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[FanSpeedEnum.FIFTEEN.ordinal()] = 12;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[FanSpeedEnum.NINETEEN.ordinal()] = 13;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[FanSpeedEnum.TWENTY_THREE.ordinal()] = 14;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[FanSpeedEnum.TWENTY_SEVEN.ordinal()] = 15;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_ONE.ordinal()] = 16;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_FIVE.ordinal()] = 17;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[FanSpeedEnum.THIRTY_NINE.ordinal()] = 18;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[FanSpeedEnum.FORTY_THREE.ordinal()] = 19;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[FanSpeedEnum.FORTY_SEVEN.ordinal()] = 20;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_FIVE.ordinal()] = 21;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[FanSpeedEnum.FIFTY_NINE.ordinal()] = 22;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_SEVEN.ordinal()] = 23;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_ONE.ordinal()] = 24;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_FIVE.ordinal()] = 25;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[FanSpeedEnum.SEVENTY_NINE.ordinal()] = 26;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[FanSpeedEnum.EIGHTY_THREE.ordinal()] = 27;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[FanSpeedEnum.EIGHTY_SEVEN.ordinal()] = 28;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[FanSpeedEnum.SIXTY_THREE.ordinal()] = 29;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[FanSpeedEnum.ONE.ordinal()] = 30;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
