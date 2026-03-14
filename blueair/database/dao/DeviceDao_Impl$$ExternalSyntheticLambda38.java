package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda38 implements Function1 {
   public final Double f$0;
   public final Double f$1;
   public final Integer f$2;
   public final String f$3;
   public final Boolean f$4;
   public final String f$5;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda38(Double var1, Double var2, Integer var3, String var4, Boolean var5, String var6) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
      this.f$3 = var4;
      this.f$4 = var5;
      this.f$5 = var6;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateWelcomeHome$43(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, (SQLiteConnection)var1);
   }
}
