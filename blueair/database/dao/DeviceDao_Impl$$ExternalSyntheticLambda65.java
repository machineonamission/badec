package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.DeviceEntity;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda65 implements Function1 {
   public final DeviceDao_Impl f$0;
   public final DeviceEntity f$1;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda65(DeviceDao_Impl var1, DeviceEntity var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$insert$0$com-blueair-database-dao-DeviceDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
