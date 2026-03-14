package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceScheduleDao_Impl$$ExternalSyntheticLambda1 implements Function1 {
   public final String f$0;

   // $FF: synthetic method
   public DeviceScheduleDao_Impl$$ExternalSyntheticLambda1(String var1) {
      this.f$0 = var1;
   }

   public final Object invoke(Object var1) {
      return DeviceScheduleDao_Impl.lambda$getByDeviceId$4(this.f$0, (SQLiteConnection)var1);
   }
}
