package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class NotificationDao_Impl$$ExternalSyntheticLambda6 implements Function1 {
   public final long f$0;
   public final String f$1;
   public final String f$2;
   public final String f$3;

   // $FF: synthetic method
   public NotificationDao_Impl$$ExternalSyntheticLambda6(long var1, String var3, String var4, String var5) {
      this.f$0 = var1;
      this.f$1 = var3;
      this.f$2 = var4;
      this.f$3 = var5;
   }

   public final Object invoke(Object var1) {
      return NotificationDao_Impl.lambda$dismiss$7(this.f$0, this.f$1, this.f$2, this.f$3, (SQLiteConnection)var1);
   }
}
