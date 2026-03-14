package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class AqiDataDao_Impl$$ExternalSyntheticLambda6 implements Function1 {
   public final String f$0;

   // $FF: synthetic method
   public AqiDataDao_Impl$$ExternalSyntheticLambda6(String var1) {
      this.f$0 = var1;
   }

   public final Object invoke(Object var1) {
      return AqiDataDao_Impl.lambda$getAqiData$3(this.f$0, (SQLiteConnection)var1);
   }
}
