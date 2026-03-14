package com.blueair.api.restapi;

import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "},
   d2 = {"Lcom/blueair/api/restapi/InitialBody;", "", "eventsubscription", "Lcom/blueair/api/restapi/EventSubscription;", "deviceconfigquery", "", "Lcom/blueair/api/restapi/DeviceConfigQuery;", "includestates", "", "deviceInfo", "Lcom/blueair/api/restapi/DeviceInfo;", "<init>", "(Lcom/blueair/api/restapi/EventSubscription;Ljava/util/List;ZLcom/blueair/api/restapi/DeviceInfo;)V", "getEventsubscription", "()Lcom/blueair/api/restapi/EventSubscription;", "getDeviceconfigquery", "()Ljava/util/List;", "getIncludestates", "()Z", "getDeviceInfo", "()Lcom/blueair/api/restapi/DeviceInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class InitialBody {
   private final DeviceInfo deviceInfo;
   private final List deviceconfigquery;
   private final EventSubscription eventsubscription;
   private final boolean includestates;

   public InitialBody(EventSubscription var1, List var2, boolean var3, DeviceInfo var4) {
      Intrinsics.checkNotNullParameter(var1, "eventsubscription");
      Intrinsics.checkNotNullParameter(var2, "deviceconfigquery");
      super();
      this.eventsubscription = var1;
      this.deviceconfigquery = var2;
      this.includestates = var3;
      this.deviceInfo = var4;
   }

   // $FF: synthetic method
   public InitialBody(EventSubscription var1, List var2, boolean var3, DeviceInfo var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 4) != 0) {
         var3 = true;
      }

      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static InitialBody copy$default(InitialBody var0, EventSubscription var1, List var2, boolean var3, DeviceInfo var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.eventsubscription;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.deviceconfigquery;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.includestates;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.deviceInfo;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   public final EventSubscription component1() {
      return this.eventsubscription;
   }

   public final List component2() {
      return this.deviceconfigquery;
   }

   public final boolean component3() {
      return this.includestates;
   }

   public final DeviceInfo component4() {
      return this.deviceInfo;
   }

   public final InitialBody copy(EventSubscription var1, List var2, boolean var3, DeviceInfo var4) {
      Intrinsics.checkNotNullParameter(var1, "eventsubscription");
      Intrinsics.checkNotNullParameter(var2, "deviceconfigquery");
      return new InitialBody(var1, var2, var3, var4);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof InitialBody)) {
         return false;
      } else {
         var1 = var1;
         if (!Intrinsics.areEqual(this.eventsubscription, var1.eventsubscription)) {
            return false;
         } else if (!Intrinsics.areEqual(this.deviceconfigquery, var1.deviceconfigquery)) {
            return false;
         } else if (this.includestates != var1.includestates) {
            return false;
         } else {
            return Intrinsics.areEqual(this.deviceInfo, var1.deviceInfo);
         }
      }
   }

   public final DeviceInfo getDeviceInfo() {
      return this.deviceInfo;
   }

   public final List getDeviceconfigquery() {
      return this.deviceconfigquery;
   }

   public final EventSubscription getEventsubscription() {
      return this.eventsubscription;
   }

   public final boolean getIncludestates() {
      return this.includestates;
   }

   public int hashCode() {
      int var2 = this.eventsubscription.hashCode();
      int var4 = this.deviceconfigquery.hashCode();
      int var3 = AddDeviceState$$ExternalSyntheticBackport0.m(this.includestates);
      DeviceInfo var5 = this.deviceInfo;
      int var1;
      if (var5 == null) {
         var1 = 0;
      } else {
         var1 = var5.hashCode();
      }

      return ((var2 * 31 + var4) * 31 + var3) * 31 + var1;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("InitialBody(eventsubscription=");
      var1.append(this.eventsubscription);
      var1.append(", deviceconfigquery=");
      var1.append(this.deviceconfigquery);
      var1.append(", includestates=");
      var1.append(this.includestates);
      var1.append(", deviceInfo=");
      var1.append(this.deviceInfo);
      var1.append(')');
      return var1.toString();
   }
}
