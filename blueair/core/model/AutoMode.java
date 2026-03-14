package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"},
   d2 = {"Lcom/blueair/core/model/AutoMode;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_AVAILABLE", "ON", "OFF", "toText", "", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum AutoMode {
   private static final EnumEntries $ENTRIES;
   private static final AutoMode[] $VALUES;
   public static final String AUTO_MODE_DISABLED = "manual";
   public static final String AUTO_MODE_ENABLED = "auto";
   public static final Companion Companion;
   NOT_AVAILABLE,
   OFF,
   ON;

   // $FF: synthetic method
   private static final AutoMode[] $values() {
      return new AutoMode[]{NOT_AVAILABLE, ON, OFF};
   }

   static {
      AutoMode[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final String toText() {
      int var1 = AutoMode.WhenMappings.$EnumSwitchMapping$0[this.ordinal()];
      if (var1 != 1) {
         if (var1 != 2 && var1 != 3) {
            throw new NoWhenBranchMatchedException();
         } else {
            return "manual";
         }
      } else {
         return "auto";
      }
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/core/model/AutoMode$Companion;", "", "<init>", "()V", "AUTO_MODE_ENABLED", "", "AUTO_MODE_DISABLED", "from", "Lcom/blueair/core/model/AutoMode;", "device", "Lcom/blueair/core/model/Device;", "input", "fromBoolean", "autoMode", "", "core_otherRelease"},
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

      public final AutoMode from(Device var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var2, "input");
         if (var1 instanceof DeviceClassic || DeviceKt.isG4orB4orNB(var1) || var1 instanceof DeviceIcp || var1 instanceof HasLinkingCapability && ((HasLinkingCapability)var1).isLinked()) {
            return Intrinsics.areEqual(var2, "auto") ? AutoMode.ON : AutoMode.OFF;
         } else {
            return AutoMode.NOT_AVAILABLE;
         }
      }

      public final AutoMode fromBoolean(boolean var1) {
         return var1 ? AutoMode.ON : AutoMode.OFF;
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
         int[] var0 = new int[AutoMode.values().length];

         try {
            var0[AutoMode.ON.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[AutoMode.NOT_AVAILABLE.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[AutoMode.OFF.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
