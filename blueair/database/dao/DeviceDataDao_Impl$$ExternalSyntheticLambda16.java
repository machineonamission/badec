package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda16 implements Function1 {
   public final DeviceDataDao_Impl f$0;
   public final List f$1;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda16(DeviceDataDao_Impl var1, List var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$insertAll$1$com-blueair-database-dao-DeviceDataDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
