package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.DeviceScheduleEntity;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceScheduleDao_Impl$$ExternalSyntheticLambda3 implements Function1 {
   public final DeviceScheduleDao_Impl f$0;
   public final DeviceScheduleEntity f$1;

   // $FF: synthetic method
   public DeviceScheduleDao_Impl$$ExternalSyntheticLambda3(DeviceScheduleDao_Impl var1, DeviceScheduleEntity var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$update$1$com-blueair-database-dao-DeviceScheduleDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
