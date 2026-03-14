package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import java.util.List;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class TrackedLocationDao_Impl$$ExternalSyntheticLambda10 implements Function1 {
   public final TrackedLocationDao_Impl f$0;
   public final List f$1;

   // $FF: synthetic method
   public TrackedLocationDao_Impl$$ExternalSyntheticLambda10(TrackedLocationDao_Impl var1, List var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$insert$1$com-blueair-database-dao-TrackedLocationDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
