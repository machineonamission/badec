package com.blueair.api.model;

import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"},
   d2 = {"Lcom/blueair/api/model/ConnectionCapability;", "", "uid", "", "getUid", "()Ljava/lang/String;", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface ConnectionCapability {
   Companion Companion = ConnectionCapability.Companion.$$INSTANCE;

   String getUid();

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/api/model/ConnectionCapability$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/api/model/ConnectionCapability;", "device", "Lcom/blueair/core/model/Device;", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      static final Companion $$INSTANCE = new Companion();

      private Companion() {
      }

      public final ConnectionCapability from(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceType var2 = var1.getType();
         if (Intrinsics.areEqual(var2, DeviceType.Icp.INSTANCE)) {
            return new CapabilityBluetoothAbl(var1.getUid());
         } else {
            return !Intrinsics.areEqual(var2, DeviceType.Classic.INSTANCE) && !Intrinsics.areEqual(var2, DeviceType.ClassicWithoutSensor.INSTANCE) && !Intrinsics.areEqual(var2, DeviceType.Sense.INSTANCE) && !Intrinsics.areEqual(var2, DeviceType.Aware.INSTANCE) ? (ConnectionCapability)(new CapabilityWifiCloud(var1.getUid())) : (ConnectionCapability)(new CapabilityWifiAbl(var1.getUid()));
         }
      }
   }
}
