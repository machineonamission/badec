package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.AqiDataEntity;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class AqiDataDao_Impl$$ExternalSyntheticLambda5 implements Function1 {
   public final AqiDataDao_Impl f$0;
   public final AqiDataEntity f$1;

   // $FF: synthetic method
   public AqiDataDao_Impl$$ExternalSyntheticLambda5(AqiDataDao_Impl var1, AqiDataEntity var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$insert$0$com-blueair-database-dao-AqiDataDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
