package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda5 implements Function1 {
   public final String f$0;
   public final long f$1;
   public final long f$2;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda5(String var1, long var2, long var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var4;
   }

   public final Object invoke(Object var1) {
      return DeviceDataDao_Impl.lambda$deleteDeviceDataInInclusiveRange$22(this.f$0, this.f$1, this.f$2, (SQLiteConnection)var1);
   }
}
