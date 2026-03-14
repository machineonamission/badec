package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda19 implements Function1 {
   public final long f$0;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda19(long var1) {
      this.f$0 = var1;
   }

   public final Object invoke(Object var1) {
      return DeviceDataDao_Impl.lambda$deleteAllOldDeviceData$20(this.f$0, (SQLiteConnection)var1);
   }
}
