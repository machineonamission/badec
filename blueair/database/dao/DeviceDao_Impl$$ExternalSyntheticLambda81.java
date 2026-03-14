package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class DeviceDao_Impl$$ExternalSyntheticLambda81 implements Function1 {
   public final long f$0;
   public final Float f$1;
   public final Float f$2;
   public final Float f$3;
   public final Float f$4;
   public final Float f$5;
   public final Float f$6;
   public final Float f$7;
   public final Float f$8;
   public final String f$9;

   // $FF: synthetic method
   public DeviceDao_Impl$$ExternalSyntheticLambda81(long var1, Float var3, Float var4, Float var5, Float var6, Float var7, Float var8, Float var9, Float var10, String var11) {
      this.f$0 = var1;
      this.f$1 = var3;
      this.f$2 = var4;
      this.f$3 = var5;
      this.f$4 = var6;
      this.f$5 = var7;
      this.f$6 = var8;
      this.f$7 = var9;
      this.f$8 = var10;
      this.f$9 = var11;
   }

   public final Object invoke(Object var1) {
      return DeviceDao_Impl.lambda$updateLatestSensorDataPoint$11(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (SQLiteConnection)var1);
   }
}
