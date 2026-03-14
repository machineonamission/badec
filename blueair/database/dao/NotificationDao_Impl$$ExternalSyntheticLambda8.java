package com.blueair.database.dao;

import androidx.sqlite.SQLiteConnection;
import com.blueair.database.entity.NotificationEntity;
import kotlin.jvm.functions.Function1;

// $FF: synthetic class
public final class NotificationDao_Impl$$ExternalSyntheticLambda8 implements Function1 {
   public final NotificationDao_Impl f$0;
   public final NotificationEntity f$1;

   // $FF: synthetic method
   public NotificationDao_Impl$$ExternalSyntheticLambda8(NotificationDao_Impl var1, NotificationEntity var2) {
      this.f$0 = var1;
      this.f$1 = var2;
   }

   public final Object invoke(Object var1) {
      return this.f$0.lambda$delete$1$com-blueair-database-dao-NotificationDao_Impl(this.f$1, (SQLiteConnection)var1);
   }
}
