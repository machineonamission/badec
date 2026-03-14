package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.DeviceDataEntity;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda22 implements Function1 {
   public final DeviceDataDao_Impl f$0;
   public final DeviceDataEntity f$1;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda22(DeviceDataDao_Impl var1, DeviceDataEntity var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$insert$0$com-blueair-database-dao-DeviceDataDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
