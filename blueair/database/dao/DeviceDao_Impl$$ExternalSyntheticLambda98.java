package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda98 implements Function1 {
   public final boolean f$0;
   public final String f$1;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda98(boolean var1, String var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateWickdryDone$95(this.f$0, this.f$1, (SQLiteConnection)var1);
   }
}
