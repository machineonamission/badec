package com.blueair.antifake.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"},
   d2 = {"Lcom/blueair/antifake/viewmodel/ResetResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "INVALID_CODE", "DEVICE_MISMATCH", "DEVICE_OFFLINE", "INTERNAL_ERROR", "BLUETOOTH_FAILED", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum ResetResult {
   private static final EnumEntries $ENTRIES;
   private static final ResetResult[] $VALUES;
   BLUETOOTH_FAILED;

   public static final Companion Companion;
   DEVICE_MISMATCH,
   DEVICE_OFFLINE,
   INTERNAL_ERROR,
   INVALID_CODE,
   SUCCESS;

   // $FF: synthetic method
   private static final ResetResult[] $values() {
      return new ResetResult[]{SUCCESS, INVALID_CODE, DEVICE_MISMATCH, DEVICE_OFFLINE, INTERNAL_ERROR, BLUETOOTH_FAILED};
   }

   static {
      ResetResult[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/antifake/viewmodel/ResetResult$Companion;", "", "<init>", "()V", "fromStatusCode", "Lcom/blueair/antifake/viewmodel/ResetResult;", "code", "", "antifake_otherRelease"},
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

      public final ResetResult fromStatusCode(int var1) {
         if (var1 != 0) {
            if (var1 != 1) {
               if (var1 != 2) {
                  return var1 != 3 ? ResetResult.INTERNAL_ERROR : ResetResult.DEVICE_OFFLINE;
               } else {
                  return ResetResult.DEVICE_MISMATCH;
               }
            } else {
               return ResetResult.INVALID_CODE;
            }
         } else {
            return ResetResult.SUCCESS;
         }
      }
   }
}
