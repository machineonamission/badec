package com.blueair.core.model;

import com.blueair.core.R;
import com.blueair.core.util.SkuConfigurationManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0018"},
   d2 = {"Lcom/blueair/core/model/AlarmSound;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Mute", "Birds", "Waves", "Ting", "NordicFlow", "BlueAwakening", "HappyRise", "MorningChime", "SkylightDance", "MidnightRain", "HarmonicLight", "GentleGlow", "getName", "mcuFirmware", "", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum AlarmSound {
   private static final EnumEntries $ENTRIES;
   private static final AlarmSound[] $VALUES;
   Birds(1),
   BlueAwakening(5);

   public static final Companion Companion;
   GentleGlow(11),
   HappyRise(6),
   HarmonicLight(10),
   MidnightRain(9),
   MorningChime(7),
   Mute(0),
   NordicFlow(4),
   SkylightDance(8),
   Ting(3),
   Waves(2);

   private final int value;

   // $FF: synthetic method
   private static final AlarmSound[] $values() {
      return new AlarmSound[]{Mute, Birds, Waves, Ting, NordicFlow, BlueAwakening, HappyRise, MorningChime, SkylightDance, MidnightRain, HarmonicLight, GentleGlow};
   }

   static {
      AlarmSound[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private AlarmSound(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getName(String var1) {
      Intrinsics.checkNotNullParameter(var1, "mcuFirmware");
      if (McuFirmwareVersions.Companion.compare(var1, SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestAlarmSoundV2()) >= 0) {
         switch (AlarmSound.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1:
               return R.string.sound_brid_song;
            case 2:
               return R.string.sound_mantra_breeze;
            case 3:
               return R.string.sound_meadow_notes;
            case 4:
               return R.string.sound_nordic_flow;
            case 5:
               return R.string.sound_blue_awakening;
            case 6:
               return R.string.sound_happy_rise;
            case 7:
               return R.string.sound_morning_chime;
            case 8:
               return R.string.sound_skylight_dance;
            case 9:
               return R.string.sound_midnight_rain;
            case 10:
               return R.string.sound_harmonic_light;
            case 11:
               return R.string.sound_gentle_glow;
            default:
               return R.string.sound_brid_song;
         }
      } else {
         int var2 = AlarmSound.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
         if (var2 != 1) {
            if (var2 != 2) {
               return var2 != 3 ? R.string.sound_birds : R.string.sound_ting;
            } else {
               return R.string.sound_waves;
            }
         } else {
            return R.string.sound_birds;
         }
      }
   }

   public final int getValue() {
      return this.value;
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"},
      d2 = {"Lcom/blueair/core/model/AlarmSound$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/AlarmSound;", "value", "", "entries", "", "mcuFirmware", "", "core_otherRelease"},
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

      public final List entries(String var1) {
         Intrinsics.checkNotNullParameter(var1, "mcuFirmware");
         return McuFirmwareVersions.Companion.compare(var1, SkuConfigurationManager.INSTANCE.getMcuFirmwareVersions().getMrestAlarmSoundV2()) >= 0 ? CollectionsKt.drop((Iterable)AlarmSound.getEntries(), 1) : CollectionsKt.take((Iterable)CollectionsKt.drop((Iterable)AlarmSound.getEntries(), 1), 3);
      }

      public final AlarmSound fromValue(int var1) {
         Iterator var3 = ((Iterable)AlarmSound.getEntries()).iterator();

         Object var2;
         do {
            if (!var3.hasNext()) {
               var2 = null;
               break;
            }

            var2 = var3.next();
         } while(((AlarmSound)var2).getValue() != var1);

         AlarmSound var4 = (AlarmSound)var2;
         return var4 == null ? AlarmSound.Birds : var4;
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
         int[] var0 = new int[AlarmSound.values().length];

         try {
            var0[AlarmSound.Birds.ordinal()] = 1;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[AlarmSound.Waves.ordinal()] = 2;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[AlarmSound.Ting.ordinal()] = 3;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[AlarmSound.NordicFlow.ordinal()] = 4;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[AlarmSound.BlueAwakening.ordinal()] = 5;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[AlarmSound.HappyRise.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[AlarmSound.MorningChime.ordinal()] = 7;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[AlarmSound.SkylightDance.ordinal()] = 8;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[AlarmSound.MidnightRain.ordinal()] = 9;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[AlarmSound.HarmonicLight.ordinal()] = 10;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[AlarmSound.GentleGlow.ordinal()] = 11;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
