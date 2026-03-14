package com.blueair.core.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"},
   d2 = {"Lcom/blueair/core/model/CalibrationState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "CALIBRATING", "SUCCESS", "CANCELED", "FAILED_TIMEOUT", "FAILED_REASON1", "FAILED_REASON2", "FAILED_REASON3", "Companion", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum CalibrationState {
   private static final EnumEntries $ENTRIES;
   private static final CalibrationState[] $VALUES;
   CALIBRATING(0),
   CANCELED(2);

   public static final Companion Companion;
   FAILED_REASON1(4),
   FAILED_REASON2(5),
   FAILED_REASON3(6),
   FAILED_TIMEOUT(3),
   SUCCESS(1);

   private final int value;

   // $FF: synthetic method
   private static final CalibrationState[] $values() {
      return new CalibrationState[]{CALIBRATING, SUCCESS, CANCELED, FAILED_TIMEOUT, FAILED_REASON1, FAILED_REASON2, FAILED_REASON3};
   }

   static {
      CalibrationState[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private CalibrationState(int var3) {
      this.value = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final int getValue() {
      return this.value;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/core/model/CalibrationState$Companion;", "", "<init>", "()V", "fromValue", "Lcom/blueair/core/model/CalibrationState;", "value", "", "core_otherRelease"},
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

      public final CalibrationState fromValue(int var1) {
         Iterator var3 = ((Iterable)CalibrationState.getEntries()).iterator();

         Object var2;
         do {
            if (!var3.hasNext()) {
               var2 = null;
               break;
            }

            var2 = var3.next();
         } while(((CalibrationState)var2).getValue() != var1);

         CalibrationState var4 = (CalibrationState)var2;
         return var4 == null ? CalibrationState.CALIBRATING : var4;
      }
   }
}
