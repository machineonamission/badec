package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class TrackedLocationDao_Impl$$ExternalSyntheticLambda5 implements Function1 {
   public final String f$0;

   // $FF: synthetic method
   public TrackedLocationDao_Impl$$ExternalSyntheticLambda5(String var1) {
      this.f$0 = var1;
   }

   public final Object invoke(Object var1) {
      return TrackedLocationDao_Impl.lambda$deleteTrackedLocation$11(this.f$0, (SQLiteConnection)var1);
   }
}
