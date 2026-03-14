package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \t2\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0003\n\u000b\f¨\u0006\r"},
   d2 = {"Lcom/blueair/core/model/UiAutoMode;", "", "state", "", "<init>", "(Ljava/lang/String;)V", "NotAvailable", "On", "Off", "Companion", "Lcom/blueair/core/model/UiAutoMode$NotAvailable;", "Lcom/blueair/core/model/UiAutoMode$Off;", "Lcom/blueair/core/model/UiAutoMode$On;", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class UiAutoMode {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   private UiAutoMode(String var1) {
   }

   // $FF: synthetic method
   public UiAutoMode(String var1, DefaultConstructorMarker var2) {
      this(var1);
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/core/model/UiAutoMode$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/core/model/UiAutoMode;", "device", "Lcom/blueair/core/model/Device;", "input", "", "core_otherRelease"},
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

      public final UiAutoMode from(Device var1, String var2) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var2, "input");
         if (var1 instanceof DeviceClassic || DeviceKt.isG4orB4orNB(var1) || var1 instanceof DeviceIcp || var1 instanceof HasLinkingCapability && ((HasLinkingCapability)var1).isLinked()) {
            return Intrinsics.areEqual(var2, "auto") ? (UiAutoMode)UiAutoMode.On.INSTANCE : (UiAutoMode)UiAutoMode.Off.INSTANCE;
         } else {
            return UiAutoMode.NotAvailable.INSTANCE;
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/UiAutoMode$NotAvailable;", "Lcom/blueair/core/model/UiAutoMode;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class NotAvailable extends UiAutoMode {
      public static final NotAvailable INSTANCE = new NotAvailable();

      private NotAvailable() {
         super("not_available", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/UiAutoMode$Off;", "Lcom/blueair/core/model/UiAutoMode;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Off extends UiAutoMode {
      public static final Off INSTANCE = new Off();

      private Off() {
         super("off", (DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"},
      d2 = {"Lcom/blueair/core/model/UiAutoMode$On;", "Lcom/blueair/core/model/UiAutoMode;", "<init>", "()V", "core_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class On extends UiAutoMode {
      public static final On INSTANCE = new On();

      private On() {
         super("on", (DefaultConstructorMarker)null);
      }
   }
}
