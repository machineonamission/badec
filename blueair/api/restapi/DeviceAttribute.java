package com.blueair.api.restapi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u000e\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u000e\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$¨\u0006%"},
   d2 = {"Lcom/blueair/api/restapi/DeviceAttribute;", "T", "", "value", "<init>", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "Brightness", "ChildLock", "DealerCountry", "DealerName", "FanSpeed", "FilterRemainingMinutes", "FanUsage", "Mode", "FilterType", "AutoModeDependency", "PurchaseDate", "SerialNumber", "McuFirmware", "UnknownAttribute", "Lcom/blueair/api/restapi/DeviceAttribute$AutoModeDependency;", "Lcom/blueair/api/restapi/DeviceAttribute$Brightness;", "Lcom/blueair/api/restapi/DeviceAttribute$ChildLock;", "Lcom/blueair/api/restapi/DeviceAttribute$DealerCountry;", "Lcom/blueair/api/restapi/DeviceAttribute$DealerName;", "Lcom/blueair/api/restapi/DeviceAttribute$FanSpeed;", "Lcom/blueair/api/restapi/DeviceAttribute$FanUsage;", "Lcom/blueair/api/restapi/DeviceAttribute$FilterRemainingMinutes;", "Lcom/blueair/api/restapi/DeviceAttribute$FilterType;", "Lcom/blueair/api/restapi/DeviceAttribute$McuFirmware;", "Lcom/blueair/api/restapi/DeviceAttribute$Mode;", "Lcom/blueair/api/restapi/DeviceAttribute$PurchaseDate;", "Lcom/blueair/api/restapi/DeviceAttribute$SerialNumber;", "Lcom/blueair/api/restapi/DeviceAttribute$UnknownAttribute;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class DeviceAttribute {
   private final Object value;

   private DeviceAttribute(Object var1) {
      this.value = var1;
   }

   // $FF: synthetic method
   public DeviceAttribute(Object var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   public final Object getValue() {
      return this.value;
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$AutoModeDependency;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class AutoModeDependency extends DeviceAttribute {
      public AutoModeDependency(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$Brightness;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(I)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Brightness extends DeviceAttribute {
      public Brightness(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$ChildLock;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Z)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ChildLock extends DeviceAttribute {
      public ChildLock(boolean var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$DealerCountry;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DealerCountry extends DeviceAttribute {
      public DealerCountry(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$DealerName;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DealerName extends DeviceAttribute {
      public DealerName(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$FanSpeed;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(I)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanSpeed extends DeviceAttribute {
      public FanSpeed(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$FanUsage;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FanUsage extends DeviceAttribute {
      public FanUsage(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$FilterRemainingMinutes;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(I)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterRemainingMinutes extends DeviceAttribute {
      public FilterRemainingMinutes(int var1) {
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$FilterType;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FilterType extends DeviceAttribute {
      public FilterType(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$McuFirmware;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class McuFirmware extends DeviceAttribute {
      public McuFirmware(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$Mode;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Mode extends DeviceAttribute {
      public Mode(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$PurchaseDate;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PurchaseDate extends DeviceAttribute {
      public PurchaseDate(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$SerialNumber;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class SerialNumber extends DeviceAttribute {
      public SerialNumber(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/api/restapi/DeviceAttribute$UnknownAttribute;", "Lcom/blueair/api/restapi/DeviceAttribute;", "", "value", "<init>", "(Ljava/lang/String;)V", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class UnknownAttribute extends DeviceAttribute {
      public UnknownAttribute(String var1) {
         Intrinsics.checkNotNullParameter(var1, "value");
         super(var1, (DefaultConstructorMarker)null);
      }
   }
}
