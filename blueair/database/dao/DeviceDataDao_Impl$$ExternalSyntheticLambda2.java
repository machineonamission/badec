package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda2 implements Function1 {
   public final String f$0;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda2(String var1) {
      this.f$0 = var1;
   }

   public final Object invoke(Object var1) {
      return DeviceDataDao_Impl.lambda$getLatestHistoricalDataTime$16(this.f$0, (SQLiteConnection)var1);
   }
}
