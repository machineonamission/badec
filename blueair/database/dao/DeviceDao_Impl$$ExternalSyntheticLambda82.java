package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda82 implements Function1 {
   public final double f$0;
   public final String f$1;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda82(double var1, String var3) {
      this.f$0 = var1;
      this.f$1 = var3;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateHeatEcoTmp$66(this.f$0, this.f$1, (SQLiteConnection)var1);
   }
}
