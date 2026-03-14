package com.blueair.database.entity;

import com.blueair.core.model.DeviceScheduleInstruction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0016"},
   d2 = {"Lcom/blueair/database/entity/DeviceScheduleInstructionEntity;", "", "attributeName", "", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAttributeName", "()Ljava/lang/String;", "getValue", "toDeviceScheduleInstruction", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "database_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleInstructionEntity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final String attributeName;
   private final String value;

   public DeviceScheduleInstructionEntity(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "attributeName");
      Intrinsics.checkNotNullParameter(var2, "value");
      super();
      this.attributeName = var1;
      this.value = var2;
   }

   // $FF: synthetic method
   public static DeviceScheduleInstructionEntity copy$default(DeviceScheduleInstructionEntity var0, String var1, String var2, int var3, Object var4) {
      if ((var3 & 1) != 0) {
         var1 = var0.attributeName;
      }

      if ((var3 & 2) != 0) {
         var2 = var0.value;
      }

      return var0.copy(var1, var2);
   }

   public final String component1() {
      return this.attributeName;
   }

   public final String component2() {
      return this.value;
   }

   public final DeviceScheduleInstructionEntity copy(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "attributeName");
      Intrinsics.checkNotNullParameter(var2, "value");
      return new DeviceScheduleInstructionEntity(var1, var2);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof DeviceScheduleInstructionEntity)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.attributeName, var1.attributeName)) {
            return false;
         } else {
            return Intrinsics.areEqual(this.value, var1.value);
         }
      }
   }

   public final String getAttributeName() {
      return this.attributeName;
   }

   public final String getValue() {
      return this.value;
   }

   public int hashCode() {
      return this.attributeName.hashCode() * 31 + this.value.hashCode();
   }

   public final DeviceScheduleInstruction toDeviceScheduleInstruction() {
      return new DeviceScheduleInstruction(this.attributeName, this.value);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("DeviceScheduleInstructionEntity(attributeName=");
      var1.append(this.attributeName);
      var1.append(", value=");
      var1.append(this.value);
      var1.append(')');
      return var1.toString();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/database/entity/DeviceScheduleInstructionEntity$Companion;", "", "<init>", "()V", "fromDeviceScheduleInstruction", "Lcom/blueair/database/entity/DeviceScheduleInstructionEntity;", "model", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "database_otherRelease"},
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

      public final DeviceScheduleInstructionEntity fromDeviceScheduleInstruction(DeviceScheduleInstruction var1) {
         Intrinsics.checkNotNullParameter(var1, "model");
         return new DeviceScheduleInstructionEntity(var1.getName(), var1.getValue());
      }
   }
}
