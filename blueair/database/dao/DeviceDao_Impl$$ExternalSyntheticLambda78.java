package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda78 implements Function1 {
   public final Integer f$0;
   public final Long f$1;
   public final String f$2;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda78(Integer var1, Long var2, String var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateDisinfectLeftTime$45(this.f$0, this.f$1, this.f$2, (SQLiteConnection)var1);
   }
}
