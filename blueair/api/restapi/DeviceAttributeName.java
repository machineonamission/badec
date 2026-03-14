package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"},
   d2 = {"Lcom/blueair/api/restapi/DeviceAttributeName;", "", "attributeName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getAttributeName", "()Ljava/lang/String;", "Brightness", "FanSpeed", "FilterRemainingMinutes", "ChildLock", "DealerCountry", "DealerName", "FanUsage", "Mode", "FilterType", "AutoModeDependency", "PurchaseDate", "SerialNumber", "UnknownAttribute", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public enum DeviceAttributeName {
   private static final EnumEntries $ENTRIES;
   private static final DeviceAttributeName[] $VALUES;
   AutoModeDependency("auto_mode_dependency"),
   Brightness("brightness"),
   ChildLock("child_lock");

   public static final Companion Companion;
   DealerCountry("dealerCountry"),
   DealerName("dealerName"),
   FanSpeed("fan_speed"),
   FanUsage("fan_usage"),
   FilterRemainingMinutes("filter_remaining_minutes"),
   FilterType("filterType"),
   Mode("mode"),
   PurchaseDate("purchaseDate"),
   SerialNumber("serial"),
   UnknownAttribute("unknown");

   private final String attributeName;

   // $FF: synthetic method
   private static final DeviceAttributeName[] $values() {
      return new DeviceAttributeName[]{Brightness, FanSpeed, FilterRemainingMinutes, ChildLock, DealerCountry, DealerName, FanUsage, Mode, FilterType, AutoModeDependency, PurchaseDate, SerialNumber, UnknownAttribute};
   }

   static {
      DeviceAttributeName[] var0 = $values();
      $VALUES = var0;
      $ENTRIES = EnumEntriesKt.enumEntries(var0);
      Companion = new Companion((DefaultConstructorMarker)null);
   }

   private DeviceAttributeName(String var3) {
      this.attributeName = var3;
   }

   public static EnumEntries getEntries() {
      return $ENTRIES;
   }

   public final String getAttributeName() {
      return this.attributeName;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttributeName$Companion;", "", "<init>", "()V", "fromName", "Lcom/blueair/api/restapi/DeviceAttributeName;", "name", "", "api_otherRelease"},
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

      public final DeviceAttributeName fromName(String var1) {
         Intrinsics.checkNotNullParameter(var1, "name");
         DeviceAttributeName[] var5 = DeviceAttributeName.values();
         int var3 = var5.length;
         int var2 = 0;

         while(true) {
            if (var2 >= var3) {
               var6 = null;
               break;
            }

            DeviceAttributeName var4 = var5[var2];
            if (Intrinsics.areEqual(var4.getAttributeName(), var1)) {
               var6 = var4;
               break;
            }

            ++var2;
         }

         return var6 == null ? DeviceAttributeName.UnknownAttribute : var6;
      }
   }
}
