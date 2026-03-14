package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0017\u001a\u00020\tH\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"},
   d2 = {"Lcom/blueair/core/model/NotificationMessage;", "", "device", "Lcom/blueair/core/model/Device;", "type", "Lcom/blueair/core/model/NotificationMsgType;", "subType", "", "subLevel", "", "<init>", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/NotificationMsgType;Ljava/lang/String;I)V", "getDevice", "()Lcom/blueair/core/model/Device;", "getType", "()Lcom/blueair/core/model/NotificationMsgType;", "getSubType", "()Ljava/lang/String;", "getSubLevel", "()I", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "copy", "toString", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationMessage {
   private final Device device;
   private final int subLevel;
   private final String subType;
   private final NotificationMsgType type;

   public NotificationMessage(Device var1, NotificationMsgType var2, String var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "type");
      Intrinsics.checkNotNullParameter(var3, "subType");
      super();
      this.device = var1;
      this.type = var2;
      this.subType = var3;
      this.subLevel = var4;
   }

   // $FF: synthetic method
   public static NotificationMessage copy$default(NotificationMessage var0, Device var1, NotificationMsgType var2, String var3, int var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.device;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.type;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.subType;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.subLevel;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final Device component1() {
      return this.device;
   }

   public final NotificationMsgType component2() {
      return this.type;
   }

   public final String component3() {
      return this.subType;
   }

   public final int component4() {
      return this.subLevel;
   }

   public final NotificationMessage copy(Device var1, NotificationMsgType var2, String var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "type");
      Intrinsics.checkNotNullParameter(var3, "subType");
      return new NotificationMessage(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof NotificationMessage)) {
         return false;
      } else {
         String var2 = this.device.getUid();
         var1 = var1;
         if (!Intrinsics.areEqual(var2, var1.device.getUid())) {
            return false;
         } else if (!Intrinsics.areEqual(this.device.getName(), var1.device.getName())) {
            return false;
         } else {
            Device var4 = this.device;
            if (var4 instanceof HasSKU && var1.device instanceof HasSKU && !Intrinsics.areEqual(((HasSKU)var4).getSku(), ((HasSKU)var1.device).getSku())) {
               return false;
            } else if (this.type != var1.type) {
               return false;
            } else if (!Intrinsics.areEqual(this.subType, var1.subType)) {
               return false;
            } else {
               return this.subLevel == var1.subLevel;
            }
         }
      }
   }

   public final Device getDevice() {
      return this.device;
   }

   public final int getSubLevel() {
      return this.subLevel;
   }

   public final String getSubType() {
      return this.subType;
   }

   public final NotificationMsgType getType() {
      return this.type;
   }

   public int hashCode() {
      return ((this.device.getUid().hashCode() * 31 + this.type.hashCode()) * 31 + this.subType.hashCode()) * 31 + this.subLevel;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("NotificationMessage(device=");
      var1.append(this.device);
      var1.append(", type=");
      var1.append(this.type);
      var1.append(", subType=");
      var1.append(this.subType);
      var1.append(", subLevel=");
      var1.append(this.subLevel);
      var1.append(')');
      return var1.toString();
   }
}
