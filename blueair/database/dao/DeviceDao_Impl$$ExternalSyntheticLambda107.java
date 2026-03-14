package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda107 implements Function1 {
   public final int f$0;
   public final long f$1;
   public final String f$2;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda107(int var1, long var2, String var4) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var4;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateWickdryLeftTime$48(this.f$0, this.f$1, this.f$2, (SQLiteConnection)var1);
   }
}
