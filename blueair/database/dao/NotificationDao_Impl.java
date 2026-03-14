package com.blueair.database.dao;

import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.NotificationEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

public final class NotificationDao_Impl implements NotificationDao {
   private final RoomDatabase __db;
   private final EntityDeleteOrUpdateAdapter __deleteAdapterOfNotificationEntity;
   private final EntityInsertAdapter __insertAdapterOfNotificationEntity;
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfNotificationEntity;

   public NotificationDao_Impl(RoomDatabase var1) {
      this.__db = var1;
      this.__insertAdapterOfNotificationEntity = new EntityInsertAdapter(this) {
         final NotificationDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, NotificationEntity var2) {
            if (var2.getDeviceId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getDeviceId());
            }

            if (var2.getType() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getType());
            }

            if (var2.getSubType() == null) {
               var1.bindNull(3);
            } else {
               var1.bindText(3, var2.getSubType());
            }

            var1.bindLong(4, (long)var2.getSubLevel());
            var1.bindLong(5, (long)var2.getDismissed());
            var1.bindLong(6, var2.getDismissTime());
            var1.bindLong(7, var2.getDatetime());
         }

         protected String createQuery() {
            return "INSERT OR REPLACE INTO `notification_table` (`deviceId`,`type`,`subType`,`subLevel`,`dismissed`,`dismissTime`,`datetime`) VALUES (?,?,?,?,?,?,?)";
         }
      };
      this.__deleteAdapterOfNotificationEntity = new EntityDeleteOrUpdateAdapter(this) {
         final NotificationDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, NotificationEntity var2) {
            if (var2.getDeviceId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getDeviceId());
            }

            if (var2.getType() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getType());
            }

            if (var2.getSubType() == null) {
               var1.bindNull(3);
            } else {
               var1.bindText(3, var2.getSubType());
            }
         }

         protected String createQuery() {
            return "DELETE FROM `notification_table` WHERE `deviceId` = ? AND `type` = ? AND `subType` = ?";
         }
      };
      this.__updateAdapterOfNotificationEntity = new EntityDeleteOrUpdateAdapter(this) {
         final NotificationDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, NotificationEntity var2) {
            if (var2.getDeviceId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getDeviceId());
            }

            if (var2.getType() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getType());
            }

            if (var2.getSubType() == null) {
               var1.bindNull(3);
            } else {
               var1.bindText(3, var2.getSubType());
            }

            var1.bindLong(4, (long)var2.getSubLevel());
            var1.bindLong(5, (long)var2.getDismissed());
            var1.bindLong(6, var2.getDismissTime());
            var1.bindLong(7, var2.getDatetime());
            if (var2.getDeviceId() == null) {
               var1.bindNull(8);
            } else {
               var1.bindText(8, var2.getDeviceId());
            }

            if (var2.getType() == null) {
               var1.bindNull(9);
            } else {
               var1.bindText(9, var2.getType());
            }

            if (var2.getSubType() == null) {
               var1.bindNull(10);
            } else {
               var1.bindText(10, var2.getSubType());
            }
         }

         protected String createQuery() {
            return "UPDATE OR ABORT `notification_table` SET `deviceId` = ?,`type` = ?,`subType` = ?,`subLevel` = ?,`dismissed` = ?,`dismissTime` = ?,`datetime` = ? WHERE `deviceId` = ? AND `type` = ? AND `subType` = ?";
         }
      };
   }

   public static List getRequiredConverters() {
      return Collections.EMPTY_LIST;
   }

   // $FF: synthetic method
   static Unit lambda$delete$5(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var16 = var1.prepare("DELETE FROM notification_table WHERE deviceId = ?");
            if (var0 == null) {
               try {
                  var16.bindNull(1);
               } catch (Throwable var13) {
                  var10000 = var13;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var16.bindText(1, var0);
               } catch (Throwable var12) {
                  var10000 = var12;
                  boolean var17 = false;
                  break label98;
               }
            }

            label92:
            try {
               var16.step();
               var15 = Unit.INSTANCE;
               break label99;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var18 = false;
               break label92;
            }
         }

         Throwable var14 = var10000;
         var16.close();
         throw var14;
      }

      var16.close();
      return var15;
   }

   // $FF: synthetic method
   static Unit lambda$deleteAll$6(SQLiteConnection var0) {
      SQLiteStatement var4 = var0.prepare("DELETE FROM notification_table");

      Unit var1;
      try {
         var4.step();
         var1 = Unit.INSTANCE;
      } finally {
         var4.close();
      }

      return var1;
   }

   // $FF: synthetic method
   static Unit lambda$dismiss$7(long var0, String var2, String var3, String var4, SQLiteConnection var5) {
      SQLiteStatement var80 = var5.prepare("UPDATE notification_table SET dismissed = 1, dismissTime = ? WHERE deviceId = ?  and type = ? and subType = ?");

      label484: {
         Throwable var10000;
         label488: {
            try {
               var80.bindLong(1, var0);
            } catch (Throwable var77) {
               var10000 = var77;
               boolean var10001 = false;
               break label488;
            }

            if (var2 == null) {
               try {
                  var80.bindNull(2);
               } catch (Throwable var76) {
                  var10000 = var76;
                  boolean var81 = false;
                  break label488;
               }
            } else {
               try {
                  var80.bindText(2, var2);
               } catch (Throwable var75) {
                  var10000 = var75;
                  boolean var82 = false;
                  break label488;
               }
            }

            if (var3 == null) {
               try {
                  var80.bindNull(3);
               } catch (Throwable var74) {
                  var10000 = var74;
                  boolean var83 = false;
                  break label488;
               }
            } else {
               try {
                  var80.bindText(3, var3);
               } catch (Throwable var73) {
                  var10000 = var73;
                  boolean var84 = false;
                  break label488;
               }
            }

            if (var4 == null) {
               try {
                  var80.bindNull(4);
               } catch (Throwable var72) {
                  var10000 = var72;
                  boolean var85 = false;
                  break label488;
               }
            } else {
               try {
                  var80.bindText(4, var4);
               } catch (Throwable var71) {
                  var10000 = var71;
                  boolean var86 = false;
                  break label488;
               }
            }

            label464:
            try {
               var80.step();
               var79 = Unit.INSTANCE;
               break label484;
            } catch (Throwable var70) {
               var10000 = var70;
               boolean var87 = false;
               break label464;
            }
         }

         Throwable var78 = var10000;
         var80.close();
         throw var78;
      }

      var80.close();
      return var79;
   }

   // $FF: synthetic method
   static Unit lambda$dismissAll$8(long var0, SQLiteConnection var2) {
      SQLiteStatement var6 = var2.prepare("UPDATE notification_table SET dismissed = 1, dismissTime = ?");

      Unit var3;
      try {
         var6.bindLong(1, var0);
         var6.step();
         var3 = Unit.INSTANCE;
      } finally {
         var6.close();
      }

      return var3;
   }

   // $FF: synthetic method
   static List lambda$getFlowNotifications$3(SQLiteConnection var0) {
      SQLiteStatement var16 = var0.prepare("SELECT * from notification_table where dismissed = 0 ORDER BY CASE WHEN type = 'FILTER_LIFE' AND subLevel = 0 THEN 0 WHEN type = 'AQI' THEN 1 ELSE 2 END ASC, datetime DESC");

      ArrayList var17;
      label747: {
         Throwable var10000;
         label746: {
            int var1;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            try {
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "deviceId");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "type");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "subType");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "subLevel");
               var1 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "dismissed");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "dismissTime");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var16, "datetime");
               var17 = new ArrayList();
            } catch (Throwable var108) {
               var10000 = var108;
               boolean var10001 = false;
               break label746;
            }

            while(true) {
               boolean var13;
               try {
                  if (!var16.step()) {
                     break label747;
                  }

                  var13 = var16.isNull(var5);
               } catch (Throwable var104) {
                  var10000 = var104;
                  boolean var112 = false;
                  break;
               }

               String var15 = null;
               String var109;
               if (var13) {
                  var109 = null;
               } else {
                  try {
                     var109 = var16.getText(var5);
                  } catch (Throwable var103) {
                     var10000 = var103;
                     boolean var113 = false;
                     break;
                  }
               }

               String var14;
               label740: {
                  label739: {
                     try {
                        if (var16.isNull(var6)) {
                           break label739;
                        }
                     } catch (Throwable var107) {
                        var10000 = var107;
                        boolean var114 = false;
                        break;
                     }

                     try {
                        var14 = var16.getText(var6);
                        break label740;
                     } catch (Throwable var102) {
                        var10000 = var102;
                        boolean var115 = false;
                        break;
                     }
                  }

                  var14 = null;
               }

               label733: {
                  try {
                     if (var16.isNull(var3)) {
                        break label733;
                     }
                  } catch (Throwable var106) {
                     var10000 = var106;
                     boolean var116 = false;
                     break;
                  }

                  try {
                     var15 = var16.getText(var3);
                  } catch (Throwable var101) {
                     var10000 = var101;
                     boolean var117 = false;
                     break;
                  }
               }

               int var2;
               label727: {
                  label726: {
                     try {
                        var2 = (int)var16.getLong(var7);
                        if ((int)var16.getLong(var1) != 0) {
                           break label726;
                        }
                     } catch (Throwable var105) {
                        var10000 = var105;
                        boolean var118 = false;
                        break;
                     }

                     var13 = false;
                     break label727;
                  }

                  var13 = true;
               }

               try {
                  long var9 = var16.getLong(var4);
                  long var11 = var16.getLong(var8);
                  NotificationEntity var18 = new NotificationEntity(var109, var14, var15, var2, var13, var9, var11);
                  var17.add(var18);
               } catch (Throwable var100) {
                  var10000 = var100;
                  boolean var119 = false;
                  break;
               }
            }
         }

         Throwable var110 = var10000;
         var16.close();
         throw var110;
      }

      var16.close();
      return var17;
   }

   // $FF: synthetic method
   static NotificationEntity lambda$getNotification$4(String var0, String var1, String var2, SQLiteConnection var3) {
      label1713: {
         Throwable var10000;
         label1716: {
            var258 = var3.prepare("SELECT * from notification_table WHERE deviceId = ? and type = ? and subType = ?");
            boolean var11 = true;
            if (var0 == null) {
               try {
                  var258.bindNull(1);
               } catch (Throwable var252) {
                  var10000 = var252;
                  boolean var10001 = false;
                  break label1716;
               }
            } else {
               try {
                  var258.bindText(1, var0);
               } catch (Throwable var251) {
                  var10000 = var251;
                  boolean var260 = false;
                  break label1716;
               }
            }

            if (var1 == null) {
               try {
                  var258.bindNull(2);
               } catch (Throwable var250) {
                  var10000 = var250;
                  boolean var261 = false;
                  break label1716;
               }
            } else {
               try {
                  var258.bindText(2, var1);
               } catch (Throwable var249) {
                  var10000 = var249;
                  boolean var262 = false;
                  break label1716;
               }
            }

            if (var2 == null) {
               try {
                  var258.bindNull(3);
               } catch (Throwable var248) {
                  var10000 = var248;
                  boolean var263 = false;
                  break label1716;
               }
            } else {
               try {
                  var258.bindText(3, var2);
               } catch (Throwable var247) {
                  var10000 = var247;
                  boolean var264 = false;
                  break label1716;
               }
            }

            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            boolean var12;
            try {
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "deviceId");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "type");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "subType");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "subLevel");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "dismissed");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "dismissTime");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var258, "datetime");
               var12 = var258.step();
            } catch (Throwable var246) {
               var10000 = var246;
               boolean var265 = false;
               break label1716;
            }

            var253 = null;
            var2 = null;
            if (!var12) {
               break label1713;
            }

            label1691: {
               label1690: {
                  try {
                     if (var258.isNull(var10)) {
                        break label1690;
                     }
                  } catch (Throwable var245) {
                     var10000 = var245;
                     boolean var266 = false;
                     break label1716;
                  }

                  try {
                     var0 = var258.getText(var10);
                     break label1691;
                  } catch (Throwable var244) {
                     var10000 = var244;
                     boolean var267 = false;
                     break label1716;
                  }
               }

               var0 = null;
            }

            label1682: {
               label1681: {
                  try {
                     if (var258.isNull(var8)) {
                        break label1681;
                     }
                  } catch (Throwable var243) {
                     var10000 = var243;
                     boolean var268 = false;
                     break label1716;
                  }

                  try {
                     var1 = var258.getText(var8);
                     break label1682;
                  } catch (Throwable var242) {
                     var10000 = var242;
                     boolean var269 = false;
                     break label1716;
                  }
               }

               var1 = null;
            }

            label1673: {
               try {
                  if (var258.isNull(var9)) {
                     break label1673;
                  }
               } catch (Throwable var241) {
                  var10000 = var241;
                  boolean var270 = false;
                  break label1716;
               }

               try {
                  var2 = var258.getText(var9);
               } catch (Throwable var240) {
                  var10000 = var240;
                  boolean var271 = false;
                  break label1716;
               }
            }

            label1664: {
               try {
                  var7 = (int)var258.getLong(var7);
                  if ((int)var258.getLong(var5) != 0) {
                     break label1664;
                  }
               } catch (Throwable var239) {
                  var10000 = var239;
                  boolean var272 = false;
                  break label1716;
               }

               var11 = false;
            }

            label1658:
            try {
               var253 = new NotificationEntity(var0, var1, var2, var7, var11, var258.getLong(var4), var258.getLong(var6));
               break label1713;
            } catch (Throwable var238) {
               var10000 = var238;
               boolean var273 = false;
               break label1658;
            }
         }

         Throwable var255 = var10000;
         var258.close();
         throw var255;
      }

      var258.close();
      return var253;
   }

   // $FF: synthetic method
   static Unit lambda$revokeDismission$9(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var16 = var1.prepare("UPDATE notification_table SET dismissed = 0, dismissTime = 0 WHERE type = ?");
            if (var0 == null) {
               try {
                  var16.bindNull(1);
               } catch (Throwable var13) {
                  var10000 = var13;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var16.bindText(1, var0);
               } catch (Throwable var12) {
                  var10000 = var12;
                  boolean var17 = false;
                  break label98;
               }
            }

            label92:
            try {
               var16.step();
               var15 = Unit.INSTANCE;
               break label99;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var18 = false;
               break label92;
            }
         }

         Throwable var14 = var10000;
         var16.close();
         throw var14;
      }

      var16.close();
      return var15;
   }

   public Object delete(NotificationEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda8(this, var1), var2);
   }

   public Object delete(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda7(var1), var2);
   }

   public Object deleteAll(Continuation var1) {
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda0(), var1);
   }

   public Object dismiss(String var1, String var2, String var3, long var4, Continuation var6) {
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda6(var4, var1, var2, var3), var6);
   }

   public Object dismissAll(long var1, Continuation var3) {
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda9(var1), var3);
   }

   public Flow getFlowNotifications() {
      RoomDatabase var2 = this.__db;
      NotificationDao_Impl$$ExternalSyntheticLambda4 var1 = new NotificationDao_Impl$$ExternalSyntheticLambda4();
      return FlowUtil.createFlow(var2, false, new String[]{"notification_table"}, var1);
   }

   public Object getNotification(String var1, String var2, String var3, Continuation var4) {
      return DBUtil.performSuspending(this.__db, true, false, new NotificationDao_Impl$$ExternalSyntheticLambda1(var1, var2, var3), var4);
   }

   public Object insert(NotificationEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda5(this, var1), var2);
   }

   // $FF: synthetic method
   Unit lambda$delete$1$com_blueair_database_dao_NotificationDao_Impl/* $FF was: lambda$delete$1$com-blueair-database-dao-NotificationDao_Impl*/(NotificationEntity var1, SQLiteConnection var2) {
      this.__deleteAdapterOfNotificationEntity.handle(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$insert$0$com_blueair_database_dao_NotificationDao_Impl/* $FF was: lambda$insert$0$com-blueair-database-dao-NotificationDao_Impl*/(NotificationEntity var1, SQLiteConnection var2) {
      this.__insertAdapterOfNotificationEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$update$2$com_blueair_database_dao_NotificationDao_Impl/* $FF was: lambda$update$2$com-blueair-database-dao-NotificationDao_Impl*/(NotificationEntity var1, SQLiteConnection var2) {
      this.__updateAdapterOfNotificationEntity.handle(var2, var1);
      return Unit.INSTANCE;
   }

   public Object revokeDismission(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda2(var1), var2);
   }

   public Object update(NotificationEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new NotificationDao_Impl$$ExternalSyntheticLambda3(this, var1), var2);
   }
}
