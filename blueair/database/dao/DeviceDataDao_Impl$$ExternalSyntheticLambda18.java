package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDataDao_Impl$$ExternalSyntheticLambda18 implements Function1 {
   public final DeviceDataDao_Impl f$0;
   public final String f$1;
   public final List f$2;

   // $FF: synthetic method
   public DeviceDataDao_Impl$$ExternalSyntheticLambda18(DeviceDataDao_Impl var1, String var2, List var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$insertAllAndReplace$3$com-blueair-database-dao-DeviceDataDao_Impl(this.f$1, this.f$2, (SQLiteConnection)var1);
   }
}
