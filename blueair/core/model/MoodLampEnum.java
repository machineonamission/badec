package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"},
   d2 = {"Lcom/blueair/core/model/MoodLampEnum;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "WARM", "NORMAL", "BRIGHT", "toServerValue", "", "toStep", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum MoodLampEnum {
   private static final EnumEntries $ENTRIES;
   private static final MoodLampEnum[] $VALUES;
   BRIGHT;

   public static final Companion Companion;
   NORMAL,
   OFF,
   WARM;

   // $FF: synthetic method
   private static final MoodLampEnum[] $values() {
      return new MoodLampEnum[]{OFF, WARM, NORMAL, BRIGHT};
   }

   static {
      MoodLampEnum[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int toServerValue() {
      return this.toStep();
   }

   public final int toStep() {
      int var1 = MoodLampEnum.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            if (var1 != 3) {
               if (var1 == 4) {
                  return 3;
               } else {
                  throw new NoWhenBranchMatchedException();
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
   }

   @Metadata(
      d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"},
      d2 = {"Lcom/blueair/core/model/MoodLampEnum$Companion;", "", "<init>", "()V", "fromServerValue", "Lcom/blueair/core/model/MoodLampEnum;", "device", "Lcom/blueair/core/model/HasMoodLamp;", "fromStep", "step", "", "core_otherRelease"},
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

      public final MoodLampEnum fromServerValue(HasMoodLamp var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         int var2 = var1.getNightLampBrightness();
         if (var2 != 1) {
            if (var2 != 2) {
               return var2 != 3 ? MoodLampEnum.OFF : MoodLampEnum.BRIGHT;
            } else {
               return MoodLampEnum.NORMAL;
            }
         } else {
            return MoodLampEnum.WARM;
         }
      }

      public final MoodLampEnum fromStep(int var1) {
         if (var1 != 0) {
            if (var1 != 1) {
               if (var1 != 2) {
                  return var1 != 3 ? MoodLampEnum.OFF : MoodLampEnum.BRIGHT;
               } else {
                  return MoodLampEnum.NORMAL;
               }
            } else {
               return MoodLampEnum.WARM;
            }
         } else {
            return MoodLampEnum.OFF;
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
         int[] var0 = new int[MoodLampEnum.values().length];

         try {
            var0[MoodLampEnum.OFF.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[MoodLampEnum.WARM.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MoodLampEnum.NORMAL.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MoodLampEnum.BRIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
