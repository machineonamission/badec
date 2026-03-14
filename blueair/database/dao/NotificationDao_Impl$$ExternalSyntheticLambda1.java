package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class NotificationDao_Impl$$ExternalSyntheticLambda1 implements Function1 {
   public final String f$0;
   public final String f$1;
   public final String f$2;

   // $FF: synthetic method
   public NotificationDao_Impl$$ExternalSyntheticLambda1(String var1, String var2, String var3) {
      this.f$0 = var1;
      this.f$1 = var2;
      this.f$2 = var3;
   }

   public final Object invoke(Object var1) {
      return NotificationDao_Impl.lambda$getNotification$4(this.f$0, this.f$1, this.f$2, (SQLiteConnection)var1);
   }
}
