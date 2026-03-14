package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda11 implements Function1 {
   public final String f$0;
   public final long f$1;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda11(String var1, long var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return DeviceDataDao_Impl.lambda$getLiveDeviceDataSince$9(this.f$0, this.f$1, (SQLiteConnection)var1);
   }
}
