package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda24 implements Function1 {
   public final String f$0;
   public final String f$1;
   public final String f$2;
   public final String f$3;
   public final String f$4;
   public final String f$5;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda24(String var1, String var2, String var3, String var4, String var5, String var6) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
      this.f$4 = var5;
      this.f$5 = var6;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateSensorRange$24(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (SQLiteConnection)var1);
   }
}
