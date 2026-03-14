package com.blueair.core.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"},
   d2 = {"Lcom/blueair/core/model/WickDryingGear;", "", "duration", "", "<init>", "(Ljava/lang/String;II)V", "getDuration", "()I", "OFF", "LOW", "HIGH", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum WickDryingGear {
   private static final EnumEntries $ENTRIES;
   private static final WickDryingGear[] $VALUES;
   public static final Companion Companion;
   HIGH(1800),
   LOW(7200),
   OFF(0);

   private final int duration;

   // $FF: synthetic method
   private static final WickDryingGear[] $values() {
      return new WickDryingGear[]{OFF, LOW, HIGH};
   }

   static {
      WickDryingGear[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private WickDryingGear(int var3) {
      this.duration = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getDuration() {
      return this.duration;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/WickDryingGear$Companion;", "", "<init>", "()V", "fromDuration", "Lcom/blueair/core/model/WickDryingGear;", "duration", "", "core_otherRelease"},
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

      public final WickDryingGear fromDuration(int var1) {
         Iterator var3 = ((Iterable)WickDryingGear.getEntries()).iterator();

         Object var2;
         do {
            if (!var3.hasNext()) {
               var2 = null;
               break;
            }

            var2 = var3.next();
         } while(((WickDryingGear)var2).getDuration() != var1);

         WickDryingGear var4 = (WickDryingGear)var2;
         return var4 == null ? WickDryingGear.OFF : var4;
      }
   }
}
