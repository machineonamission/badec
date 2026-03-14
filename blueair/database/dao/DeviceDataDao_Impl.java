package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.FlowUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.DeviceDataEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

public final class DeviceDataDao_Impl implements DeviceDataDao {
   private final RoomDatabase __db;
   private final EntityInsertAdapter __insertAdapterOfDeviceDataEntity;

   public DeviceDataDao_Impl(RoomDatabase var1) {
      this.__db = var1;
      this.__insertAdapterOfDeviceDataEntity = new EntityInsertAdapter(this) {
         final DeviceDataDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, DeviceDataEntity var2) {
            if (var2.getId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getId());
            }

            if (var2.getDeviceId() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getDeviceId());
            }

            var1.bindLong(3, var2.getTime());
            if (var2.getPm1() == null) {
               var1.bindNull(4);
            } else {
               var1.bindDouble(4, (double)var2.getPm1());
            }

            if (var2.getPm10() == null) {
               var1.bindNull(5);
            } else {
               var1.bindDouble(5, (double)var2.getPm10());
            }

            if (var2.getPm25() == null) {
               var1.bindNull(6);
            } else {
               var1.bindDouble(6, (double)var2.getPm25());
            }

            if (var2.getVoc() == null) {
               var1.bindNull(7);
            } else {
               var1.bindDouble(7, (double)var2.getVoc());
            }

            if (var2.getHcho() == null) {
               var1.bindNull(8);
            } else {
               var1.bindDouble(8, (double)var2.getHcho());
            }

            if (var2.getTmp() == null) {
               var1.bindNull(9);
            } else {
               var1.bindDouble(9, (double)var2.getTmp());
            }

            if (var2.getHum() == null) {
               var1.bindNull(10);
            } else {
               var1.bindDouble(10, (double)var2.getHum());
            }

            if (var2.getFan() == null) {
               var1.bindNull(11);
            } else {
               var1.bindDouble(11, (double)var2.getFan());
            }

            if (var2.getWeight() == null) {
               var1.bindNull(12);
            } else {
               var1.bindDouble(12, (double)var2.getWeight());
            }

            if (var2.getRpm() == null) {
               var1.bindNull(13);
            } else {
               var1.bindDouble(13, (double)var2.getRpm());
            }

            var1.bindLong(14, (long)var2.getTrend());
         }

         protected String createQuery() {
            return "INSERT OR REPLACE INTO `device_data` (`id`,`deviceId`,`time`,`pm1`,`pm10`,`pm25`,`voc`,`hcho`,`tmp`,`hum`,`fan`,`weight`,`rpm`,`trend`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         }
      };
   }

   public static List getRequiredConverters() {
      return Collections.EMPTY_LIST;
   }

   // $FF: synthetic method
   static Object lambda$delete$17(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var15 = var1.prepare("DELETE FROM device_data WHERE id = ?");
            if (var0 == null) {
               try {
                  var15.bindNull(1);
               } catch (Throwable var13) {
                  var10000 = var13;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var15.bindText(1, var0);
               } catch (Throwable var12) {
                  var10000 = var12;
                  boolean var16 = false;
                  break label98;
               }
            }

            label92:
            try {
               var15.step();
               break label99;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               break label92;
            }
         }

         Throwable var14 = var10000;
         var15.close();
         throw var14;
      }

      var15.close();
      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteAll$19(SQLiteConnection var0) {
      SQLiteStatement var4 = var0.prepare("DELETE FROM device_data");

      try {
         var4.step();
      } finally {
         var4.close();
      }

      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteAllForDevice$18(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var15 = var1.prepare("DELETE FROM device_data WHERE deviceId = ?");
            if (var0 == null) {
               try {
                  var15.bindNull(1);
               } catch (Throwable var13) {
                  var10000 = var13;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var15.bindText(1, var0);
               } catch (Throwable var12) {
                  var10000 = var12;
                  boolean var16 = false;
                  break label98;
               }
            }

            label92:
            try {
               var15.step();
               break label99;
            } catch (Throwable var11) {
               var10000 = var11;
               boolean var17 = false;
               break label92;
            }
         }

         Throwable var14 = var10000;
         var15.close();
         throw var14;
      }

      var15.close();
      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteAllOldDeviceData$20(long var0, SQLiteConnection var2) {
      SQLiteStatement var3 = var2.prepare("DELETE FROM device_data WHERE time<?");

      try {
         var3.bindLong(1, var0);
         var3.step();
      } finally {
         var3.close();
      }

      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteDeviceDataInInclusiveRange$22(String var0, long var1, long var3, SQLiteConnection var5) {
      label99: {
         Throwable var10000;
         label98: {
            var19 = var5.prepare("DELETE FROM device_data WHERE deviceId = ? AND time >= ? AND time <= ?");
            if (var0 == null) {
               try {
                  var19.bindNull(1);
               } catch (Throwable var17) {
                  var10000 = var17;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var19.bindText(1, var0);
               } catch (Throwable var16) {
                  var10000 = var16;
                  boolean var20 = false;
                  break label98;
               }
            }

            label92:
            try {
               var19.bindLong(2, var1);
               var19.bindLong(3, var3);
               var19.step();
               break label99;
            } catch (Throwable var15) {
               var10000 = var15;
               boolean var21 = false;
               break label92;
            }
         }

         Throwable var18 = var10000;
         var19.close();
         throw var18;
      }

      var19.close();
      return null;
   }

   // $FF: synthetic method
   static Object lambda$deleteOldDeviceData$21(String var0, long var1, SQLiteConnection var3) {
      label99: {
         Throwable var10000;
         label98: {
            var17 = var3.prepare("DELETE FROM device_data WHERE deviceId = ? AND time<?");
            if (var0 == null) {
               try {
                  var17.bindNull(1);
               } catch (Throwable var15) {
                  var10000 = var15;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var17.bindText(1, var0);
               } catch (Throwable var14) {
                  var10000 = var14;
                  boolean var18 = false;
                  break label98;
               }
            }

            label92:
            try {
               var17.bindLong(2, var1);
               var17.step();
               break label99;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var19 = false;
               break label92;
            }
         }

         Throwable var16 = var10000;
         var17.close();
         throw var16;
      }

      var17.close();
      return null;
   }

   // $FF: synthetic method
   static List lambda$deviceData$4(String var0, SQLiteConnection var1) {
      SQLiteStatement var30;
      ArrayList var31;
      label5537: {
         Throwable var10000;
         label5539: {
            var30 = var1.prepare("SELECT * from device_data WHERE deviceId = ?");
            if (var0 == null) {
               try {
                  var30.bindNull(1);
               } catch (Throwable var844) {
                  var10000 = var844;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var30.bindText(1, var0);
               } catch (Throwable var843) {
                  var10000 = var843;
                  boolean var848 = false;
                  break label5539;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            try {
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "id");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "deviceId");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "time");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm1");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm10");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm25");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "voc");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hcho");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "tmp");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hum");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "fan");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "weight");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "rpm");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "trend");
               var31 = new ArrayList();
            } catch (Throwable var842) {
               var10000 = var842;
               boolean var849 = false;
               break label5539;
            }

            while(true) {
               boolean var19;
               try {
                  if (!var30.step()) {
                     break label5537;
                  }

                  var19 = var30.isNull(var4);
               } catch (Throwable var830) {
                  var10000 = var830;
                  boolean var850 = false;
                  break;
               }

               Float var29 = null;
               if (var19) {
                  var0 = null;
               } else {
                  try {
                     var0 = var30.getText(var4);
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var851 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var30.isNull(var3)) {
                           break label5523;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var852 = false;
                        break;
                     }

                     try {
                        var847 = var30.getText(var3);
                        break label5524;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var853 = false;
                        break;
                     }
                  }

                  var847 = null;
               }

               long var17;
               Float var20;
               label5517: {
                  label5516: {
                     try {
                        var17 = var30.getLong(var2);
                        if (var30.isNull(var5)) {
                           break label5516;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var854 = false;
                        break;
                     }

                     try {
                        var20 = (float)var30.getDouble(var5);
                        break label5517;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var855 = false;
                        break;
                     }
                  }

                  var20 = null;
               }

               Float var21;
               label5510: {
                  label5509: {
                     try {
                        if (var30.isNull(var9)) {
                           break label5509;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var856 = false;
                        break;
                     }

                     try {
                        var21 = (float)var30.getDouble(var9);
                        break label5510;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var857 = false;
                        break;
                     }
                  }

                  var21 = null;
               }

               Float var22;
               label5503: {
                  label5502: {
                     try {
                        if (var30.isNull(var13)) {
                           break label5502;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var858 = false;
                        break;
                     }

                     try {
                        var22 = (float)var30.getDouble(var13);
                        break label5503;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var859 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5496: {
                  label5495: {
                     try {
                        if (var30.isNull(var10)) {
                           break label5495;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var860 = false;
                        break;
                     }

                     try {
                        var23 = (float)var30.getDouble(var10);
                        break label5496;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var861 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5489: {
                  label5488: {
                     try {
                        if (var30.isNull(var6)) {
                           break label5488;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var862 = false;
                        break;
                     }

                     try {
                        var24 = (float)var30.getDouble(var6);
                        break label5489;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var863 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5482: {
                  label5481: {
                     try {
                        if (var30.isNull(var12)) {
                           break label5481;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var864 = false;
                        break;
                     }

                     try {
                        var25 = (float)var30.getDouble(var12);
                        break label5482;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var865 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5475: {
                  label5474: {
                     try {
                        if (var30.isNull(var7)) {
                           break label5474;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var866 = false;
                        break;
                     }

                     try {
                        var26 = (float)var30.getDouble(var7);
                        break label5475;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var867 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5468: {
                  label5467: {
                     try {
                        if (var30.isNull(var14)) {
                           break label5467;
                        }
                     } catch (Throwable var833) {
                        var10000 = var833;
                        boolean var868 = false;
                        break;
                     }

                     try {
                        var27 = (float)var30.getDouble(var14);
                        break label5468;
                     } catch (Throwable var820) {
                        var10000 = var820;
                        boolean var869 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5461: {
                  label5460: {
                     try {
                        if (var30.isNull(var8)) {
                           break label5460;
                        }
                     } catch (Throwable var832) {
                        var10000 = var832;
                        boolean var870 = false;
                        break;
                     }

                     try {
                        var28 = (float)var30.getDouble(var8);
                        break label5461;
                     } catch (Throwable var819) {
                        var10000 = var819;
                        boolean var871 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               label5454: {
                  try {
                     if (var30.isNull(var11)) {
                        break label5454;
                     }
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var872 = false;
                     break;
                  }

                  try {
                     var29 = (float)var30.getDouble(var11);
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var873 = false;
                     break;
                  }
               }

               try {
                  int var16 = (int)var30.getLong(var15);
                  DeviceDataEntity var32 = new DeviceDataEntity(var0, var847, var17, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var16);
                  var31.add(var32);
               } catch (Throwable var817) {
                  var10000 = var817;
                  boolean var874 = false;
                  break;
               }
            }
         }

         Throwable var846 = var10000;
         var30.close();
         throw var846;
      }

      var30.close();
      return var31;
   }

   // $FF: synthetic method
   static List lambda$flowDeviceData$5(String var0, SQLiteConnection var1) {
      SQLiteStatement var30;
      ArrayList var31;
      label5537: {
         Throwable var10000;
         label5539: {
            var30 = var1.prepare("SELECT * from device_data WHERE deviceId = ?");
            if (var0 == null) {
               try {
                  var30.bindNull(1);
               } catch (Throwable var844) {
                  var10000 = var844;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var30.bindText(1, var0);
               } catch (Throwable var843) {
                  var10000 = var843;
                  boolean var848 = false;
                  break label5539;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            try {
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "id");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "deviceId");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "time");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm1");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm10");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm25");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "voc");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hcho");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "tmp");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hum");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "fan");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "weight");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "rpm");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "trend");
               var31 = new ArrayList();
            } catch (Throwable var842) {
               var10000 = var842;
               boolean var849 = false;
               break label5539;
            }

            while(true) {
               boolean var17;
               try {
                  if (!var30.step()) {
                     break label5537;
                  }

                  var17 = var30.isNull(var5);
               } catch (Throwable var830) {
                  var10000 = var830;
                  boolean var850 = false;
                  break;
               }

               Float var29 = null;
               if (var17) {
                  var0 = null;
               } else {
                  try {
                     var0 = var30.getText(var5);
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var851 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var30.isNull(var3)) {
                           break label5523;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var852 = false;
                        break;
                     }

                     try {
                        var847 = var30.getText(var3);
                        break label5524;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var853 = false;
                        break;
                     }
                  }

                  var847 = null;
               }

               long var18;
               Float var20;
               label5517: {
                  label5516: {
                     try {
                        var18 = var30.getLong(var2);
                        if (var30.isNull(var7)) {
                           break label5516;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var854 = false;
                        break;
                     }

                     try {
                        var20 = (float)var30.getDouble(var7);
                        break label5517;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var855 = false;
                        break;
                     }
                  }

                  var20 = null;
               }

               Float var21;
               label5510: {
                  label5509: {
                     try {
                        if (var30.isNull(var11)) {
                           break label5509;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var856 = false;
                        break;
                     }

                     try {
                        var21 = (float)var30.getDouble(var11);
                        break label5510;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var857 = false;
                        break;
                     }
                  }

                  var21 = null;
               }

               Float var22;
               label5503: {
                  label5502: {
                     try {
                        if (var30.isNull(var4)) {
                           break label5502;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var858 = false;
                        break;
                     }

                     try {
                        var22 = (float)var30.getDouble(var4);
                        break label5503;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var859 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5496: {
                  label5495: {
                     try {
                        if (var30.isNull(var12)) {
                           break label5495;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var860 = false;
                        break;
                     }

                     try {
                        var23 = (float)var30.getDouble(var12);
                        break label5496;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var861 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5489: {
                  label5488: {
                     try {
                        if (var30.isNull(var8)) {
                           break label5488;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var862 = false;
                        break;
                     }

                     try {
                        var24 = (float)var30.getDouble(var8);
                        break label5489;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var863 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5482: {
                  label5481: {
                     try {
                        if (var30.isNull(var15)) {
                           break label5481;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var864 = false;
                        break;
                     }

                     try {
                        var25 = (float)var30.getDouble(var15);
                        break label5482;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var865 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5475: {
                  label5474: {
                     try {
                        if (var30.isNull(var14)) {
                           break label5474;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var866 = false;
                        break;
                     }

                     try {
                        var26 = (float)var30.getDouble(var14);
                        break label5475;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var867 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5468: {
                  label5467: {
                     try {
                        if (var30.isNull(var9)) {
                           break label5467;
                        }
                     } catch (Throwable var833) {
                        var10000 = var833;
                        boolean var868 = false;
                        break;
                     }

                     try {
                        var27 = (float)var30.getDouble(var9);
                        break label5468;
                     } catch (Throwable var820) {
                        var10000 = var820;
                        boolean var869 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5461: {
                  label5460: {
                     try {
                        if (var30.isNull(var10)) {
                           break label5460;
                        }
                     } catch (Throwable var832) {
                        var10000 = var832;
                        boolean var870 = false;
                        break;
                     }

                     try {
                        var28 = (float)var30.getDouble(var10);
                        break label5461;
                     } catch (Throwable var819) {
                        var10000 = var819;
                        boolean var871 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               label5454: {
                  try {
                     if (var30.isNull(var13)) {
                        break label5454;
                     }
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var872 = false;
                     break;
                  }

                  try {
                     var29 = (float)var30.getDouble(var13);
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var873 = false;
                     break;
                  }
               }

               try {
                  int var16 = (int)var30.getLong(var6);
                  DeviceDataEntity var32 = new DeviceDataEntity(var0, var847, var18, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var16);
                  var31.add(var32);
               } catch (Throwable var817) {
                  var10000 = var817;
                  boolean var874 = false;
                  break;
               }
            }
         }

         Throwable var846 = var10000;
         var30.close();
         throw var846;
      }

      var30.close();
      return var31;
   }

   // $FF: synthetic method
   static List lambda$getFlowDeviceDataBetween$7(String var0, long var1, long var3, SQLiteConnection var5) {
      SQLiteStatement var32;
      ArrayList var33;
      label5537: {
         Throwable var10000;
         label5539: {
            var32 = var5.prepare("SELECT * from device_data WHERE deviceId = ? AND time >= ? AND time <= ? ORDER BY time");
            if (var0 == null) {
               try {
                  var32.bindNull(1);
               } catch (Throwable var846) {
                  var10000 = var846;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var32.bindText(1, var0);
               } catch (Throwable var845) {
                  var10000 = var845;
                  boolean var851 = false;
                  break label5539;
               }
            }

            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            try {
               var32.bindLong(2, var1);
               var32.bindLong(3, var3);
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "id");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "deviceId");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "time");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "pm1");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "pm10");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "pm25");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "voc");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "hcho");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "tmp");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "hum");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "fan");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "weight");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "rpm");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "trend");
               var33 = new ArrayList();
            } catch (Throwable var844) {
               var10000 = var844;
               boolean var852 = false;
               break label5539;
            }

            while(true) {
               boolean var21;
               try {
                  if (!var32.step()) {
                     break label5537;
                  }

                  var21 = var32.isNull(var9);
               } catch (Throwable var832) {
                  var10000 = var832;
                  boolean var853 = false;
                  break;
               }

               Float var31 = null;
               if (var21) {
                  var0 = null;
               } else {
                  try {
                     var0 = var32.getText(var9);
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var854 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var32.isNull(var7)) {
                           break label5523;
                        }
                     } catch (Throwable var843) {
                        var10000 = var843;
                        boolean var855 = false;
                        break;
                     }

                     try {
                        var850 = var32.getText(var7);
                        break label5524;
                     } catch (Throwable var830) {
                        var10000 = var830;
                        boolean var856 = false;
                        break;
                     }
                  }

                  var850 = null;
               }

               Float var22;
               label5517: {
                  label5516: {
                     try {
                        var1 = var32.getLong(var6);
                        if (var32.isNull(var18)) {
                           break label5516;
                        }
                     } catch (Throwable var842) {
                        var10000 = var842;
                        boolean var857 = false;
                        break;
                     }

                     try {
                        var22 = (float)var32.getDouble(var18);
                        break label5517;
                     } catch (Throwable var829) {
                        var10000 = var829;
                        boolean var858 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5510: {
                  label5509: {
                     try {
                        if (var32.isNull(var13)) {
                           break label5509;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var859 = false;
                        break;
                     }

                     try {
                        var23 = (float)var32.getDouble(var13);
                        break label5510;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var860 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5503: {
                  label5502: {
                     try {
                        if (var32.isNull(var10)) {
                           break label5502;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var861 = false;
                        break;
                     }

                     try {
                        var24 = (float)var32.getDouble(var10);
                        break label5503;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var862 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5496: {
                  label5495: {
                     try {
                        if (var32.isNull(var11)) {
                           break label5495;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var863 = false;
                        break;
                     }

                     try {
                        var25 = (float)var32.getDouble(var11);
                        break label5496;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var864 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5489: {
                  label5488: {
                     try {
                        if (var32.isNull(var14)) {
                           break label5488;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var865 = false;
                        break;
                     }

                     try {
                        var26 = (float)var32.getDouble(var14);
                        break label5489;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var866 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5482: {
                  label5481: {
                     try {
                        if (var32.isNull(var17)) {
                           break label5481;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var867 = false;
                        break;
                     }

                     try {
                        var27 = (float)var32.getDouble(var17);
                        break label5482;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var868 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5475: {
                  label5474: {
                     try {
                        if (var32.isNull(var16)) {
                           break label5474;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var869 = false;
                        break;
                     }

                     try {
                        var28 = (float)var32.getDouble(var16);
                        break label5475;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var870 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               Float var29;
               label5468: {
                  label5467: {
                     try {
                        if (var32.isNull(var8)) {
                           break label5467;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var871 = false;
                        break;
                     }

                     try {
                        var29 = (float)var32.getDouble(var8);
                        break label5468;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var872 = false;
                        break;
                     }
                  }

                  var29 = null;
               }

               Float var30;
               label5461: {
                  label5460: {
                     try {
                        if (var32.isNull(var15)) {
                           break label5460;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var873 = false;
                        break;
                     }

                     try {
                        var30 = (float)var32.getDouble(var15);
                        break label5461;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var874 = false;
                        break;
                     }
                  }

                  var30 = null;
               }

               label5454: {
                  try {
                     if (var32.isNull(var12)) {
                        break label5454;
                     }
                  } catch (Throwable var833) {
                     var10000 = var833;
                     boolean var875 = false;
                     break;
                  }

                  try {
                     var31 = (float)var32.getDouble(var12);
                  } catch (Throwable var820) {
                     var10000 = var820;
                     boolean var876 = false;
                     break;
                  }
               }

               try {
                  int var20 = (int)var32.getLong(var19);
                  DeviceDataEntity var34 = new DeviceDataEntity(var0, var850, var1, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var20);
                  var33.add(var34);
               } catch (Throwable var819) {
                  var10000 = var819;
                  boolean var877 = false;
                  break;
               }
            }
         }

         Throwable var848 = var10000;
         var32.close();
         throw var848;
      }

      var32.close();
      return var33;
   }

   // $FF: synthetic method
   static List lambda$getFlowDeviceDataSince$6(String var0, long var1, SQLiteConnection var3) {
      SQLiteStatement var30;
      ArrayList var31;
      label5537: {
         Throwable var10000;
         label5539: {
            var30 = var3.prepare("SELECT * from device_data WHERE deviceId = ? AND time >= ? ORDER BY time");
            if (var0 == null) {
               try {
                  var30.bindNull(1);
               } catch (Throwable var844) {
                  var10000 = var844;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var30.bindText(1, var0);
               } catch (Throwable var843) {
                  var10000 = var843;
                  boolean var849 = false;
                  break label5539;
               }
            }

            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            try {
               var30.bindLong(2, var1);
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "id");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "deviceId");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "time");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm1");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm10");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm25");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "voc");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hcho");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "tmp");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hum");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "fan");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "weight");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "rpm");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "trend");
               var31 = new ArrayList();
            } catch (Throwable var842) {
               var10000 = var842;
               boolean var850 = false;
               break label5539;
            }

            while(true) {
               boolean var19;
               try {
                  if (!var30.step()) {
                     break label5537;
                  }

                  var19 = var30.isNull(var12);
               } catch (Throwable var830) {
                  var10000 = var830;
                  boolean var851 = false;
                  break;
               }

               Float var29 = null;
               if (var19) {
                  var0 = null;
               } else {
                  try {
                     var0 = var30.getText(var12);
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var852 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var30.isNull(var5)) {
                           break label5523;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var853 = false;
                        break;
                     }

                     try {
                        var848 = var30.getText(var5);
                        break label5524;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var854 = false;
                        break;
                     }
                  }

                  var848 = null;
               }

               Float var20;
               label5517: {
                  label5516: {
                     try {
                        var1 = var30.getLong(var4);
                        if (var30.isNull(var9)) {
                           break label5516;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var855 = false;
                        break;
                     }

                     try {
                        var20 = (float)var30.getDouble(var9);
                        break label5517;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var856 = false;
                        break;
                     }
                  }

                  var20 = null;
               }

               Float var21;
               label5510: {
                  label5509: {
                     try {
                        if (var30.isNull(var6)) {
                           break label5509;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var857 = false;
                        break;
                     }

                     try {
                        var21 = (float)var30.getDouble(var6);
                        break label5510;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var858 = false;
                        break;
                     }
                  }

                  var21 = null;
               }

               Float var22;
               label5503: {
                  label5502: {
                     try {
                        if (var30.isNull(var15)) {
                           break label5502;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var859 = false;
                        break;
                     }

                     try {
                        var22 = (float)var30.getDouble(var15);
                        break label5503;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var860 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5496: {
                  label5495: {
                     try {
                        if (var30.isNull(var13)) {
                           break label5495;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var861 = false;
                        break;
                     }

                     try {
                        var23 = (float)var30.getDouble(var13);
                        break label5496;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var862 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5489: {
                  label5488: {
                     try {
                        if (var30.isNull(var17)) {
                           break label5488;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var863 = false;
                        break;
                     }

                     try {
                        var24 = (float)var30.getDouble(var17);
                        break label5489;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var864 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5482: {
                  label5481: {
                     try {
                        if (var30.isNull(var10)) {
                           break label5481;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var865 = false;
                        break;
                     }

                     try {
                        var25 = (float)var30.getDouble(var10);
                        break label5482;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var866 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5475: {
                  label5474: {
                     try {
                        if (var30.isNull(var11)) {
                           break label5474;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var867 = false;
                        break;
                     }

                     try {
                        var26 = (float)var30.getDouble(var11);
                        break label5475;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var868 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5468: {
                  label5467: {
                     try {
                        if (var30.isNull(var7)) {
                           break label5467;
                        }
                     } catch (Throwable var833) {
                        var10000 = var833;
                        boolean var869 = false;
                        break;
                     }

                     try {
                        var27 = (float)var30.getDouble(var7);
                        break label5468;
                     } catch (Throwable var820) {
                        var10000 = var820;
                        boolean var870 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5461: {
                  label5460: {
                     try {
                        if (var30.isNull(var16)) {
                           break label5460;
                        }
                     } catch (Throwable var832) {
                        var10000 = var832;
                        boolean var871 = false;
                        break;
                     }

                     try {
                        var28 = (float)var30.getDouble(var16);
                        break label5461;
                     } catch (Throwable var819) {
                        var10000 = var819;
                        boolean var872 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               label5454: {
                  try {
                     if (var30.isNull(var8)) {
                        break label5454;
                     }
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var873 = false;
                     break;
                  }

                  try {
                     var29 = (float)var30.getDouble(var8);
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var874 = false;
                     break;
                  }
               }

               try {
                  int var18 = (int)var30.getLong(var14);
                  DeviceDataEntity var32 = new DeviceDataEntity(var0, var848, var1, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var18);
                  var31.add(var32);
               } catch (Throwable var817) {
                  var10000 = var817;
                  boolean var875 = false;
                  break;
               }
            }
         }

         Throwable var846 = var10000;
         var30.close();
         throw var846;
      }

      var30.close();
      return var31;
   }

   // $FF: synthetic method
   static List lambda$getFlowDeviceNonRealTimeDataBetween$8(String var0, long var1, long var3, SQLiteConnection var5) {
      SQLiteStatement var32;
      ArrayList var33;
      label5537: {
         Throwable var10000;
         label5539: {
            var32 = var5.prepare("SELECT * from device_data WHERE deviceId = ? AND trend != 2 AND time >= ? AND time <= ? ORDER BY time");
            if (var0 == null) {
               try {
                  var32.bindNull(1);
               } catch (Throwable var846) {
                  var10000 = var846;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var32.bindText(1, var0);
               } catch (Throwable var845) {
                  var10000 = var845;
                  boolean var851 = false;
                  break label5539;
               }
            }

            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            try {
               var32.bindLong(2, var1);
               var32.bindLong(3, var3);
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "id");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "deviceId");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "time");
               var19 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "pm1");
               var18 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "pm10");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "pm25");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "voc");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "hcho");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "tmp");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "hum");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "fan");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "weight");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "rpm");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var32, "trend");
               var33 = new ArrayList();
            } catch (Throwable var844) {
               var10000 = var844;
               boolean var852 = false;
               break label5539;
            }

            while(true) {
               boolean var21;
               try {
                  if (!var32.step()) {
                     break label5537;
                  }

                  var21 = var32.isNull(var9);
               } catch (Throwable var832) {
                  var10000 = var832;
                  boolean var853 = false;
                  break;
               }

               Float var31 = null;
               if (var21) {
                  var0 = null;
               } else {
                  try {
                     var0 = var32.getText(var9);
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var854 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var32.isNull(var7)) {
                           break label5523;
                        }
                     } catch (Throwable var843) {
                        var10000 = var843;
                        boolean var855 = false;
                        break;
                     }

                     try {
                        var850 = var32.getText(var7);
                        break label5524;
                     } catch (Throwable var830) {
                        var10000 = var830;
                        boolean var856 = false;
                        break;
                     }
                  }

                  var850 = null;
               }

               Float var22;
               label5517: {
                  label5516: {
                     try {
                        var1 = var32.getLong(var6);
                        if (var32.isNull(var19)) {
                           break label5516;
                        }
                     } catch (Throwable var842) {
                        var10000 = var842;
                        boolean var857 = false;
                        break;
                     }

                     try {
                        var22 = (float)var32.getDouble(var19);
                        break label5517;
                     } catch (Throwable var829) {
                        var10000 = var829;
                        boolean var858 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5510: {
                  label5509: {
                     try {
                        if (var32.isNull(var18)) {
                           break label5509;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var859 = false;
                        break;
                     }

                     try {
                        var23 = (float)var32.getDouble(var18);
                        break label5510;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var860 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5503: {
                  label5502: {
                     try {
                        if (var32.isNull(var16)) {
                           break label5502;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var861 = false;
                        break;
                     }

                     try {
                        var24 = (float)var32.getDouble(var16);
                        break label5503;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var862 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5496: {
                  label5495: {
                     try {
                        if (var32.isNull(var12)) {
                           break label5495;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var863 = false;
                        break;
                     }

                     try {
                        var25 = (float)var32.getDouble(var12);
                        break label5496;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var864 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5489: {
                  label5488: {
                     try {
                        if (var32.isNull(var10)) {
                           break label5488;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var865 = false;
                        break;
                     }

                     try {
                        var26 = (float)var32.getDouble(var10);
                        break label5489;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var866 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5482: {
                  label5481: {
                     try {
                        if (var32.isNull(var14)) {
                           break label5481;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var867 = false;
                        break;
                     }

                     try {
                        var27 = (float)var32.getDouble(var14);
                        break label5482;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var868 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5475: {
                  label5474: {
                     try {
                        if (var32.isNull(var8)) {
                           break label5474;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var869 = false;
                        break;
                     }

                     try {
                        var28 = (float)var32.getDouble(var8);
                        break label5475;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var870 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               Float var29;
               label5468: {
                  label5467: {
                     try {
                        if (var32.isNull(var11)) {
                           break label5467;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var871 = false;
                        break;
                     }

                     try {
                        var29 = (float)var32.getDouble(var11);
                        break label5468;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var872 = false;
                        break;
                     }
                  }

                  var29 = null;
               }

               Float var30;
               label5461: {
                  label5460: {
                     try {
                        if (var32.isNull(var13)) {
                           break label5460;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var873 = false;
                        break;
                     }

                     try {
                        var30 = (float)var32.getDouble(var13);
                        break label5461;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var874 = false;
                        break;
                     }
                  }

                  var30 = null;
               }

               label5454: {
                  try {
                     if (var32.isNull(var15)) {
                        break label5454;
                     }
                  } catch (Throwable var833) {
                     var10000 = var833;
                     boolean var875 = false;
                     break;
                  }

                  try {
                     var31 = (float)var32.getDouble(var15);
                  } catch (Throwable var820) {
                     var10000 = var820;
                     boolean var876 = false;
                     break;
                  }
               }

               try {
                  int var20 = (int)var32.getLong(var17);
                  DeviceDataEntity var34 = new DeviceDataEntity(var0, var850, var1, var22, var23, var24, var25, var26, var27, var28, var29, var30, var31, var20);
                  var33.add(var34);
               } catch (Throwable var819) {
                  var10000 = var819;
                  boolean var877 = false;
                  break;
               }
            }
         }

         Throwable var848 = var10000;
         var32.close();
         throw var848;
      }

      var32.close();
      return var33;
   }

   // $FF: synthetic method
   static List lambda$getFlowRealTimeDeviceData$10(String var0, SQLiteConnection var1) {
      SQLiteStatement var30;
      ArrayList var31;
      label5537: {
         Throwable var10000;
         label5539: {
            var30 = var1.prepare("SELECT * from device_data WHERE deviceId = ? AND trend = 2 ORDER BY time");
            if (var0 == null) {
               try {
                  var30.bindNull(1);
               } catch (Throwable var844) {
                  var10000 = var844;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var30.bindText(1, var0);
               } catch (Throwable var843) {
                  var10000 = var843;
                  boolean var848 = false;
                  break label5539;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            try {
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "id");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "deviceId");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "time");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm1");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm10");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm25");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "voc");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hcho");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "tmp");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hum");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "fan");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "weight");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "rpm");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "trend");
               var31 = new ArrayList();
            } catch (Throwable var842) {
               var10000 = var842;
               boolean var849 = false;
               break label5539;
            }

            while(true) {
               boolean var19;
               try {
                  if (!var30.step()) {
                     break label5537;
                  }

                  var19 = var30.isNull(var10);
               } catch (Throwable var830) {
                  var10000 = var830;
                  boolean var850 = false;
                  break;
               }

               Float var29 = null;
               if (var19) {
                  var0 = null;
               } else {
                  try {
                     var0 = var30.getText(var10);
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var851 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var30.isNull(var3)) {
                           break label5523;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var852 = false;
                        break;
                     }

                     try {
                        var847 = var30.getText(var3);
                        break label5524;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var853 = false;
                        break;
                     }
                  }

                  var847 = null;
               }

               long var17;
               Float var20;
               label5517: {
                  label5516: {
                     try {
                        var17 = var30.getLong(var2);
                        if (var30.isNull(var8)) {
                           break label5516;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var854 = false;
                        break;
                     }

                     try {
                        var20 = (float)var30.getDouble(var8);
                        break label5517;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var855 = false;
                        break;
                     }
                  }

                  var20 = null;
               }

               Float var21;
               label5510: {
                  label5509: {
                     try {
                        if (var30.isNull(var6)) {
                           break label5509;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var856 = false;
                        break;
                     }

                     try {
                        var21 = (float)var30.getDouble(var6);
                        break label5510;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var857 = false;
                        break;
                     }
                  }

                  var21 = null;
               }

               Float var22;
               label5503: {
                  label5502: {
                     try {
                        if (var30.isNull(var4)) {
                           break label5502;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var858 = false;
                        break;
                     }

                     try {
                        var22 = (float)var30.getDouble(var4);
                        break label5503;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var859 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5496: {
                  label5495: {
                     try {
                        if (var30.isNull(var15)) {
                           break label5495;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var860 = false;
                        break;
                     }

                     try {
                        var23 = (float)var30.getDouble(var15);
                        break label5496;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var861 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5489: {
                  label5488: {
                     try {
                        if (var30.isNull(var5)) {
                           break label5488;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var862 = false;
                        break;
                     }

                     try {
                        var24 = (float)var30.getDouble(var5);
                        break label5489;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var863 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5482: {
                  label5481: {
                     try {
                        if (var30.isNull(var12)) {
                           break label5481;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var864 = false;
                        break;
                     }

                     try {
                        var25 = (float)var30.getDouble(var12);
                        break label5482;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var865 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5475: {
                  label5474: {
                     try {
                        if (var30.isNull(var11)) {
                           break label5474;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var866 = false;
                        break;
                     }

                     try {
                        var26 = (float)var30.getDouble(var11);
                        break label5475;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var867 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5468: {
                  label5467: {
                     try {
                        if (var30.isNull(var9)) {
                           break label5467;
                        }
                     } catch (Throwable var833) {
                        var10000 = var833;
                        boolean var868 = false;
                        break;
                     }

                     try {
                        var27 = (float)var30.getDouble(var9);
                        break label5468;
                     } catch (Throwable var820) {
                        var10000 = var820;
                        boolean var869 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5461: {
                  label5460: {
                     try {
                        if (var30.isNull(var13)) {
                           break label5460;
                        }
                     } catch (Throwable var832) {
                        var10000 = var832;
                        boolean var870 = false;
                        break;
                     }

                     try {
                        var28 = (float)var30.getDouble(var13);
                        break label5461;
                     } catch (Throwable var819) {
                        var10000 = var819;
                        boolean var871 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               label5454: {
                  try {
                     if (var30.isNull(var7)) {
                        break label5454;
                     }
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var872 = false;
                     break;
                  }

                  try {
                     var29 = (float)var30.getDouble(var7);
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var873 = false;
                     break;
                  }
               }

               try {
                  int var16 = (int)var30.getLong(var14);
                  DeviceDataEntity var32 = new DeviceDataEntity(var0, var847, var17, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var16);
                  var31.add(var32);
               } catch (Throwable var817) {
                  var10000 = var817;
                  boolean var874 = false;
                  break;
               }
            }
         }

         Throwable var846 = var10000;
         var30.close();
         throw var846;
      }

      var30.close();
      return var31;
   }

   // $FF: synthetic method
   static Long lambda$getLatestHistoricalDataTime$16(String var0, SQLiteConnection var1) {
      SQLiteStatement var3;
      label244: {
         label243: {
            Throwable var10000;
            label246: {
               var3 = var1.prepare("SELECT time from device_data where deviceId = ? AND trend = 0 ORDER BY time DESC LIMIT 1");
               if (var0 == null) {
                  try {
                     var3.bindNull(1);
                  } catch (Throwable var33) {
                     var10000 = var33;
                     boolean var10001 = false;
                     break label246;
                  }
               } else {
                  try {
                     var3.bindText(1, var0);
                  } catch (Throwable var32) {
                     var10000 = var32;
                     boolean var37 = false;
                     break label246;
                  }
               }

               boolean var2;
               try {
                  var2 = var3.step();
               } catch (Throwable var31) {
                  var10000 = var31;
                  boolean var38 = false;
                  break label246;
               }

               var36 = null;
               var34 = (Long)var36;
               if (!var2) {
                  break label244;
               }

               try {
                  if (var3.isNull(0)) {
                     break label243;
                  }
               } catch (Throwable var30) {
                  var10000 = var30;
                  boolean var39 = false;
                  break label246;
               }

               label229:
               try {
                  var34 = var3.getLong(0);
                  break label244;
               } catch (Throwable var29) {
                  var10000 = var29;
                  boolean var40 = false;
                  break label229;
               }
            }

            Throwable var35 = var10000;
            var3.close();
            throw var35;
         }

         var34 = (Long)var36;
      }

      var3.close();
      return var34;
   }

   // $FF: synthetic method
   static List lambda$getLiveDeviceDataSince$9(String var0, long var1, SQLiteConnection var3) {
      SQLiteStatement var30;
      ArrayList var31;
      label5537: {
         Throwable var10000;
         label5539: {
            var30 = var3.prepare("SELECT * from device_data WHERE deviceId = ? AND time >= ? ORDER BY time");
            if (var0 == null) {
               try {
                  var30.bindNull(1);
               } catch (Throwable var844) {
                  var10000 = var844;
                  boolean var10001 = false;
                  break label5539;
               }
            } else {
               try {
                  var30.bindText(1, var0);
               } catch (Throwable var843) {
                  var10000 = var843;
                  boolean var849 = false;
                  break label5539;
               }
            }

            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            try {
               var30.bindLong(2, var1);
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "id");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "deviceId");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "time");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm1");
               var17 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm10");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm25");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "voc");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hcho");
               var16 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "tmp");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hum");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "fan");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "weight");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "rpm");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "trend");
               var31 = new ArrayList();
            } catch (Throwable var842) {
               var10000 = var842;
               boolean var850 = false;
               break label5539;
            }

            while(true) {
               boolean var19;
               try {
                  if (!var30.step()) {
                     break label5537;
                  }

                  var19 = var30.isNull(var13);
               } catch (Throwable var830) {
                  var10000 = var830;
                  boolean var851 = false;
                  break;
               }

               Float var29 = null;
               if (var19) {
                  var0 = null;
               } else {
                  try {
                     var0 = var30.getText(var13);
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var852 = false;
                     break;
                  }
               }

               label5524: {
                  label5523: {
                     try {
                        if (var30.isNull(var5)) {
                           break label5523;
                        }
                     } catch (Throwable var841) {
                        var10000 = var841;
                        boolean var853 = false;
                        break;
                     }

                     try {
                        var848 = var30.getText(var5);
                        break label5524;
                     } catch (Throwable var828) {
                        var10000 = var828;
                        boolean var854 = false;
                        break;
                     }
                  }

                  var848 = null;
               }

               Float var20;
               label5517: {
                  label5516: {
                     try {
                        var1 = var30.getLong(var4);
                        if (var30.isNull(var10)) {
                           break label5516;
                        }
                     } catch (Throwable var840) {
                        var10000 = var840;
                        boolean var855 = false;
                        break;
                     }

                     try {
                        var20 = (float)var30.getDouble(var10);
                        break label5517;
                     } catch (Throwable var827) {
                        var10000 = var827;
                        boolean var856 = false;
                        break;
                     }
                  }

                  var20 = null;
               }

               Float var21;
               label5510: {
                  label5509: {
                     try {
                        if (var30.isNull(var17)) {
                           break label5509;
                        }
                     } catch (Throwable var839) {
                        var10000 = var839;
                        boolean var857 = false;
                        break;
                     }

                     try {
                        var21 = (float)var30.getDouble(var17);
                        break label5510;
                     } catch (Throwable var826) {
                        var10000 = var826;
                        boolean var858 = false;
                        break;
                     }
                  }

                  var21 = null;
               }

               Float var22;
               label5503: {
                  label5502: {
                     try {
                        if (var30.isNull(var7)) {
                           break label5502;
                        }
                     } catch (Throwable var838) {
                        var10000 = var838;
                        boolean var859 = false;
                        break;
                     }

                     try {
                        var22 = (float)var30.getDouble(var7);
                        break label5503;
                     } catch (Throwable var825) {
                        var10000 = var825;
                        boolean var860 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label5496: {
                  label5495: {
                     try {
                        if (var30.isNull(var15)) {
                           break label5495;
                        }
                     } catch (Throwable var837) {
                        var10000 = var837;
                        boolean var861 = false;
                        break;
                     }

                     try {
                        var23 = (float)var30.getDouble(var15);
                        break label5496;
                     } catch (Throwable var824) {
                        var10000 = var824;
                        boolean var862 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label5489: {
                  label5488: {
                     try {
                        if (var30.isNull(var8)) {
                           break label5488;
                        }
                     } catch (Throwable var836) {
                        var10000 = var836;
                        boolean var863 = false;
                        break;
                     }

                     try {
                        var24 = (float)var30.getDouble(var8);
                        break label5489;
                     } catch (Throwable var823) {
                        var10000 = var823;
                        boolean var864 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label5482: {
                  label5481: {
                     try {
                        if (var30.isNull(var16)) {
                           break label5481;
                        }
                     } catch (Throwable var835) {
                        var10000 = var835;
                        boolean var865 = false;
                        break;
                     }

                     try {
                        var25 = (float)var30.getDouble(var16);
                        break label5482;
                     } catch (Throwable var822) {
                        var10000 = var822;
                        boolean var866 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label5475: {
                  label5474: {
                     try {
                        if (var30.isNull(var12)) {
                           break label5474;
                        }
                     } catch (Throwable var834) {
                        var10000 = var834;
                        boolean var867 = false;
                        break;
                     }

                     try {
                        var26 = (float)var30.getDouble(var12);
                        break label5475;
                     } catch (Throwable var821) {
                        var10000 = var821;
                        boolean var868 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label5468: {
                  label5467: {
                     try {
                        if (var30.isNull(var14)) {
                           break label5467;
                        }
                     } catch (Throwable var833) {
                        var10000 = var833;
                        boolean var869 = false;
                        break;
                     }

                     try {
                        var27 = (float)var30.getDouble(var14);
                        break label5468;
                     } catch (Throwable var820) {
                        var10000 = var820;
                        boolean var870 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label5461: {
                  label5460: {
                     try {
                        if (var30.isNull(var6)) {
                           break label5460;
                        }
                     } catch (Throwable var832) {
                        var10000 = var832;
                        boolean var871 = false;
                        break;
                     }

                     try {
                        var28 = (float)var30.getDouble(var6);
                        break label5461;
                     } catch (Throwable var819) {
                        var10000 = var819;
                        boolean var872 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               label5454: {
                  try {
                     if (var30.isNull(var9)) {
                        break label5454;
                     }
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var873 = false;
                     break;
                  }

                  try {
                     var29 = (float)var30.getDouble(var9);
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var874 = false;
                     break;
                  }
               }

               try {
                  int var18 = (int)var30.getLong(var11);
                  DeviceDataEntity var32 = new DeviceDataEntity(var0, var848, var1, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var18);
                  var31.add(var32);
               } catch (Throwable var817) {
                  var10000 = var817;
                  boolean var875 = false;
                  break;
               }
            }
         }

         Throwable var846 = var10000;
         var30.close();
         throw var846;
      }

      var30.close();
      return var31;
   }

   // $FF: synthetic method
   static DeviceDataEntity lambda$latestDeviceData$11(String var0, SQLiteConnection var1) {
      SQLiteStatement var29;
      label5828: {
         Throwable var10000;
         label5830: {
            var29 = var1.prepare("SELECT * from device_data WHERE deviceId = ? ORDER BY time DESC LIMIT 1");
            if (var0 == null) {
               try {
                  var29.bindNull(1);
               } catch (Throwable var841) {
                  var10000 = var841;
                  boolean var10001 = false;
                  break label5830;
               }
            } else {
               try {
                  var29.bindText(1, var0);
               } catch (Throwable var840) {
                  var10000 = var840;
                  boolean var846 = false;
                  break label5830;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            boolean var18;
            try {
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "id");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "deviceId");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "time");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm1");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm10");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm25");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "voc");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hcho");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "tmp");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hum");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "fan");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "weight");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "rpm");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "trend");
               var18 = var29.step();
            } catch (Throwable var839) {
               var10000 = var839;
               boolean var847 = false;
               break label5830;
            }

            var842 = null;
            Float var28 = null;
            if (!var18) {
               break label5828;
            }

            label5816: {
               label5815: {
                  try {
                     if (var29.isNull(var11)) {
                        break label5815;
                     }
                  } catch (Throwable var838) {
                     var10000 = var838;
                     boolean var848 = false;
                     break label5830;
                  }

                  try {
                     var0 = var29.getText(var11);
                     break label5816;
                  } catch (Throwable var837) {
                     var10000 = var837;
                     boolean var849 = false;
                     break label5830;
                  }
               }

               var0 = null;
            }

            label5807: {
               label5806: {
                  try {
                     if (var29.isNull(var7)) {
                        break label5806;
                     }
                  } catch (Throwable var836) {
                     var10000 = var836;
                     boolean var850 = false;
                     break label5830;
                  }

                  try {
                     var845 = var29.getText(var7);
                     break label5807;
                  } catch (Throwable var835) {
                     var10000 = var835;
                     boolean var851 = false;
                     break label5830;
                  }
               }

               var845 = null;
            }

            long var16;
            Float var19;
            label5798: {
               label5797: {
                  try {
                     var16 = var29.getLong(var12);
                     if (var29.isNull(var15)) {
                        break label5797;
                     }
                  } catch (Throwable var834) {
                     var10000 = var834;
                     boolean var852 = false;
                     break label5830;
                  }

                  try {
                     var19 = (float)var29.getDouble(var15);
                     break label5798;
                  } catch (Throwable var833) {
                     var10000 = var833;
                     boolean var853 = false;
                     break label5830;
                  }
               }

               var19 = null;
            }

            Float var20;
            label5789: {
               label5788: {
                  try {
                     if (var29.isNull(var9)) {
                        break label5788;
                     }
                  } catch (Throwable var832) {
                     var10000 = var832;
                     boolean var854 = false;
                     break label5830;
                  }

                  try {
                     var20 = (float)var29.getDouble(var9);
                     break label5789;
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var855 = false;
                     break label5830;
                  }
               }

               var20 = null;
            }

            Float var21;
            label5780: {
               label5779: {
                  try {
                     if (var29.isNull(var6)) {
                        break label5779;
                     }
                  } catch (Throwable var830) {
                     var10000 = var830;
                     boolean var856 = false;
                     break label5830;
                  }

                  try {
                     var21 = (float)var29.getDouble(var6);
                     break label5780;
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var857 = false;
                     break label5830;
                  }
               }

               var21 = null;
            }

            Float var22;
            label5771: {
               label5770: {
                  try {
                     if (var29.isNull(var8)) {
                        break label5770;
                     }
                  } catch (Throwable var828) {
                     var10000 = var828;
                     boolean var858 = false;
                     break label5830;
                  }

                  try {
                     var22 = (float)var29.getDouble(var8);
                     break label5771;
                  } catch (Throwable var827) {
                     var10000 = var827;
                     boolean var859 = false;
                     break label5830;
                  }
               }

               var22 = null;
            }

            Float var23;
            label5762: {
               label5761: {
                  try {
                     if (var29.isNull(var2)) {
                        break label5761;
                     }
                  } catch (Throwable var826) {
                     var10000 = var826;
                     boolean var860 = false;
                     break label5830;
                  }

                  try {
                     var23 = (float)var29.getDouble(var2);
                     break label5762;
                  } catch (Throwable var825) {
                     var10000 = var825;
                     boolean var861 = false;
                     break label5830;
                  }
               }

               var23 = null;
            }

            Float var24;
            label5753: {
               label5752: {
                  try {
                     if (var29.isNull(var14)) {
                        break label5752;
                     }
                  } catch (Throwable var824) {
                     var10000 = var824;
                     boolean var862 = false;
                     break label5830;
                  }

                  try {
                     var24 = (float)var29.getDouble(var14);
                     break label5753;
                  } catch (Throwable var823) {
                     var10000 = var823;
                     boolean var863 = false;
                     break label5830;
                  }
               }

               var24 = null;
            }

            Float var25;
            label5744: {
               label5743: {
                  try {
                     if (var29.isNull(var4)) {
                        break label5743;
                     }
                  } catch (Throwable var822) {
                     var10000 = var822;
                     boolean var864 = false;
                     break label5830;
                  }

                  try {
                     var25 = (float)var29.getDouble(var4);
                     break label5744;
                  } catch (Throwable var821) {
                     var10000 = var821;
                     boolean var865 = false;
                     break label5830;
                  }
               }

               var25 = null;
            }

            Float var26;
            label5735: {
               label5734: {
                  try {
                     if (var29.isNull(var5)) {
                        break label5734;
                     }
                  } catch (Throwable var820) {
                     var10000 = var820;
                     boolean var866 = false;
                     break label5830;
                  }

                  try {
                     var26 = (float)var29.getDouble(var5);
                     break label5735;
                  } catch (Throwable var819) {
                     var10000 = var819;
                     boolean var867 = false;
                     break label5830;
                  }
               }

               var26 = null;
            }

            Float var27;
            label5726: {
               label5725: {
                  try {
                     if (var29.isNull(var10)) {
                        break label5725;
                     }
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var868 = false;
                     break label5830;
                  }

                  try {
                     var27 = (float)var29.getDouble(var10);
                     break label5726;
                  } catch (Throwable var817) {
                     var10000 = var817;
                     boolean var869 = false;
                     break label5830;
                  }
               }

               var27 = null;
            }

            label5717: {
               try {
                  if (var29.isNull(var3)) {
                     break label5717;
                  }
               } catch (Throwable var816) {
                  var10000 = var816;
                  boolean var870 = false;
                  break label5830;
               }

               try {
                  var28 = (float)var29.getDouble(var3);
               } catch (Throwable var815) {
                  var10000 = var815;
                  boolean var871 = false;
                  break label5830;
               }
            }

            label5710:
            try {
               var842 = new DeviceDataEntity(var0, var845, var16, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, (int)var29.getLong(var13));
               break label5828;
            } catch (Throwable var814) {
               var10000 = var814;
               boolean var872 = false;
               break label5710;
            }
         }

         Throwable var844 = var10000;
         var29.close();
         throw var844;
      }

      var29.close();
      return var842;
   }

   // $FF: synthetic method
   static DeviceDataEntity lambda$latestFlowDeviceData$13(String var0, SQLiteConnection var1) {
      SQLiteStatement var29;
      label5828: {
         Throwable var10000;
         label5830: {
            var29 = var1.prepare("SELECT * from device_data WHERE deviceId = ? ORDER BY time DESC LIMIT 1");
            if (var0 == null) {
               try {
                  var29.bindNull(1);
               } catch (Throwable var841) {
                  var10000 = var841;
                  boolean var10001 = false;
                  break label5830;
               }
            } else {
               try {
                  var29.bindText(1, var0);
               } catch (Throwable var840) {
                  var10000 = var840;
                  boolean var846 = false;
                  break label5830;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            boolean var16;
            try {
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "id");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "deviceId");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "time");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm1");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm10");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm25");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "voc");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hcho");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "tmp");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hum");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "fan");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "weight");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "rpm");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "trend");
               var16 = var29.step();
            } catch (Throwable var839) {
               var10000 = var839;
               boolean var847 = false;
               break label5830;
            }

            var842 = null;
            Float var28 = null;
            if (!var16) {
               break label5828;
            }

            label5816: {
               label5815: {
                  try {
                     if (var29.isNull(var13)) {
                        break label5815;
                     }
                  } catch (Throwable var838) {
                     var10000 = var838;
                     boolean var848 = false;
                     break label5830;
                  }

                  try {
                     var0 = var29.getText(var13);
                     break label5816;
                  } catch (Throwable var837) {
                     var10000 = var837;
                     boolean var849 = false;
                     break label5830;
                  }
               }

               var0 = null;
            }

            label5807: {
               label5806: {
                  try {
                     if (var29.isNull(var8)) {
                        break label5806;
                     }
                  } catch (Throwable var836) {
                     var10000 = var836;
                     boolean var850 = false;
                     break label5830;
                  }

                  try {
                     var845 = var29.getText(var8);
                     break label5807;
                  } catch (Throwable var835) {
                     var10000 = var835;
                     boolean var851 = false;
                     break label5830;
                  }
               }

               var845 = null;
            }

            long var17;
            Float var19;
            label5798: {
               label5797: {
                  try {
                     var17 = var29.getLong(var10);
                     if (var29.isNull(var7)) {
                        break label5797;
                     }
                  } catch (Throwable var834) {
                     var10000 = var834;
                     boolean var852 = false;
                     break label5830;
                  }

                  try {
                     var19 = (float)var29.getDouble(var7);
                     break label5798;
                  } catch (Throwable var833) {
                     var10000 = var833;
                     boolean var853 = false;
                     break label5830;
                  }
               }

               var19 = null;
            }

            Float var20;
            label5789: {
               label5788: {
                  try {
                     if (var29.isNull(var6)) {
                        break label5788;
                     }
                  } catch (Throwable var832) {
                     var10000 = var832;
                     boolean var854 = false;
                     break label5830;
                  }

                  try {
                     var20 = (float)var29.getDouble(var6);
                     break label5789;
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var855 = false;
                     break label5830;
                  }
               }

               var20 = null;
            }

            Float var21;
            label5780: {
               label5779: {
                  try {
                     if (var29.isNull(var5)) {
                        break label5779;
                     }
                  } catch (Throwable var830) {
                     var10000 = var830;
                     boolean var856 = false;
                     break label5830;
                  }

                  try {
                     var21 = (float)var29.getDouble(var5);
                     break label5780;
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var857 = false;
                     break label5830;
                  }
               }

               var21 = null;
            }

            Float var22;
            label5771: {
               label5770: {
                  try {
                     if (var29.isNull(var14)) {
                        break label5770;
                     }
                  } catch (Throwable var828) {
                     var10000 = var828;
                     boolean var858 = false;
                     break label5830;
                  }

                  try {
                     var22 = (float)var29.getDouble(var14);
                     break label5771;
                  } catch (Throwable var827) {
                     var10000 = var827;
                     boolean var859 = false;
                     break label5830;
                  }
               }

               var22 = null;
            }

            Float var23;
            label5762: {
               label5761: {
                  try {
                     if (var29.isNull(var2)) {
                        break label5761;
                     }
                  } catch (Throwable var826) {
                     var10000 = var826;
                     boolean var860 = false;
                     break label5830;
                  }

                  try {
                     var23 = (float)var29.getDouble(var2);
                     break label5762;
                  } catch (Throwable var825) {
                     var10000 = var825;
                     boolean var861 = false;
                     break label5830;
                  }
               }

               var23 = null;
            }

            Float var24;
            label5753: {
               label5752: {
                  try {
                     if (var29.isNull(var15)) {
                        break label5752;
                     }
                  } catch (Throwable var824) {
                     var10000 = var824;
                     boolean var862 = false;
                     break label5830;
                  }

                  try {
                     var24 = (float)var29.getDouble(var15);
                     break label5753;
                  } catch (Throwable var823) {
                     var10000 = var823;
                     boolean var863 = false;
                     break label5830;
                  }
               }

               var24 = null;
            }

            Float var25;
            label5744: {
               label5743: {
                  try {
                     if (var29.isNull(var9)) {
                        break label5743;
                     }
                  } catch (Throwable var822) {
                     var10000 = var822;
                     boolean var864 = false;
                     break label5830;
                  }

                  try {
                     var25 = (float)var29.getDouble(var9);
                     break label5744;
                  } catch (Throwable var821) {
                     var10000 = var821;
                     boolean var865 = false;
                     break label5830;
                  }
               }

               var25 = null;
            }

            Float var26;
            label5735: {
               label5734: {
                  try {
                     if (var29.isNull(var12)) {
                        break label5734;
                     }
                  } catch (Throwable var820) {
                     var10000 = var820;
                     boolean var866 = false;
                     break label5830;
                  }

                  try {
                     var26 = (float)var29.getDouble(var12);
                     break label5735;
                  } catch (Throwable var819) {
                     var10000 = var819;
                     boolean var867 = false;
                     break label5830;
                  }
               }

               var26 = null;
            }

            Float var27;
            label5726: {
               label5725: {
                  try {
                     if (var29.isNull(var4)) {
                        break label5725;
                     }
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var868 = false;
                     break label5830;
                  }

                  try {
                     var27 = (float)var29.getDouble(var4);
                     break label5726;
                  } catch (Throwable var817) {
                     var10000 = var817;
                     boolean var869 = false;
                     break label5830;
                  }
               }

               var27 = null;
            }

            label5717: {
               try {
                  if (var29.isNull(var3)) {
                     break label5717;
                  }
               } catch (Throwable var816) {
                  var10000 = var816;
                  boolean var870 = false;
                  break label5830;
               }

               try {
                  var28 = (float)var29.getDouble(var3);
               } catch (Throwable var815) {
                  var10000 = var815;
                  boolean var871 = false;
                  break label5830;
               }
            }

            label5710:
            try {
               var842 = new DeviceDataEntity(var0, var845, var17, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, (int)var29.getLong(var11));
               break label5828;
            } catch (Throwable var814) {
               var10000 = var814;
               boolean var872 = false;
               break label5710;
            }
         }

         Throwable var844 = var10000;
         var29.close();
         throw var844;
      }

      var29.close();
      return var842;
   }

   // $FF: synthetic method
   static List lambda$latestFlowDeviceDataForAllDevices$14(SQLiteConnection var0) {
      SQLiteStatement var30 = var0.prepare("SELECT d.*, t.latest_time AS time FROM device_data d INNER JOIN (SELECT deviceId, MAX(time) AS latest_time FROM device_data GROUP BY deviceId) t ON d.deviceId = t.deviceId AND d.time = t.latest_time");

      ArrayList var31;
      label4884: {
         Throwable var10000;
         label4883: {
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            try {
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "id");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "deviceId");
               var1 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "time");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm1");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm10");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "pm25");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "voc");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hcho");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "tmp");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "hum");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "fan");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "weight");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "rpm");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var30, "trend");
               var31 = new ArrayList();
            } catch (Throwable var734) {
               var10000 = var734;
               boolean var10001 = false;
               break label4883;
            }

            while(true) {
               boolean var18;
               try {
                  if (!var30.step()) {
                     break label4884;
                  }

                  var18 = var30.isNull(var12);
               } catch (Throwable var722) {
                  var10000 = var722;
                  boolean var737 = false;
                  break;
               }

               Float var29 = null;
               String var735;
               if (var18) {
                  var735 = null;
               } else {
                  try {
                     var735 = var30.getText(var12);
                  } catch (Throwable var721) {
                     var10000 = var721;
                     boolean var738 = false;
                     break;
                  }
               }

               String var19;
               label4877: {
                  label4876: {
                     try {
                        if (var30.isNull(var2)) {
                           break label4876;
                        }
                     } catch (Throwable var733) {
                        var10000 = var733;
                        boolean var739 = false;
                        break;
                     }

                     try {
                        var19 = var30.getText(var2);
                        break label4877;
                     } catch (Throwable var720) {
                        var10000 = var720;
                        boolean var740 = false;
                        break;
                     }
                  }

                  var19 = null;
               }

               long var16;
               Float var20;
               label4870: {
                  label4869: {
                     try {
                        var16 = var30.getLong(var1);
                        if (var30.isNull(var6)) {
                           break label4869;
                        }
                     } catch (Throwable var732) {
                        var10000 = var732;
                        boolean var741 = false;
                        break;
                     }

                     try {
                        var20 = (float)var30.getDouble(var6);
                        break label4870;
                     } catch (Throwable var719) {
                        var10000 = var719;
                        boolean var742 = false;
                        break;
                     }
                  }

                  var20 = null;
               }

               Float var21;
               label4863: {
                  label4862: {
                     try {
                        if (var30.isNull(var11)) {
                           break label4862;
                        }
                     } catch (Throwable var731) {
                        var10000 = var731;
                        boolean var743 = false;
                        break;
                     }

                     try {
                        var21 = (float)var30.getDouble(var11);
                        break label4863;
                     } catch (Throwable var718) {
                        var10000 = var718;
                        boolean var744 = false;
                        break;
                     }
                  }

                  var21 = null;
               }

               Float var22;
               label4856: {
                  label4855: {
                     try {
                        if (var30.isNull(var10)) {
                           break label4855;
                        }
                     } catch (Throwable var730) {
                        var10000 = var730;
                        boolean var745 = false;
                        break;
                     }

                     try {
                        var22 = (float)var30.getDouble(var10);
                        break label4856;
                     } catch (Throwable var717) {
                        var10000 = var717;
                        boolean var746 = false;
                        break;
                     }
                  }

                  var22 = null;
               }

               Float var23;
               label4849: {
                  label4848: {
                     try {
                        if (var30.isNull(var13)) {
                           break label4848;
                        }
                     } catch (Throwable var729) {
                        var10000 = var729;
                        boolean var747 = false;
                        break;
                     }

                     try {
                        var23 = (float)var30.getDouble(var13);
                        break label4849;
                     } catch (Throwable var716) {
                        var10000 = var716;
                        boolean var748 = false;
                        break;
                     }
                  }

                  var23 = null;
               }

               Float var24;
               label4842: {
                  label4841: {
                     try {
                        if (var30.isNull(var9)) {
                           break label4841;
                        }
                     } catch (Throwable var728) {
                        var10000 = var728;
                        boolean var749 = false;
                        break;
                     }

                     try {
                        var24 = (float)var30.getDouble(var9);
                        break label4842;
                     } catch (Throwable var715) {
                        var10000 = var715;
                        boolean var750 = false;
                        break;
                     }
                  }

                  var24 = null;
               }

               Float var25;
               label4835: {
                  label4834: {
                     try {
                        if (var30.isNull(var4)) {
                           break label4834;
                        }
                     } catch (Throwable var727) {
                        var10000 = var727;
                        boolean var751 = false;
                        break;
                     }

                     try {
                        var25 = (float)var30.getDouble(var4);
                        break label4835;
                     } catch (Throwable var714) {
                        var10000 = var714;
                        boolean var752 = false;
                        break;
                     }
                  }

                  var25 = null;
               }

               Float var26;
               label4828: {
                  label4827: {
                     try {
                        if (var30.isNull(var8)) {
                           break label4827;
                        }
                     } catch (Throwable var726) {
                        var10000 = var726;
                        boolean var753 = false;
                        break;
                     }

                     try {
                        var26 = (float)var30.getDouble(var8);
                        break label4828;
                     } catch (Throwable var713) {
                        var10000 = var713;
                        boolean var754 = false;
                        break;
                     }
                  }

                  var26 = null;
               }

               Float var27;
               label4821: {
                  label4820: {
                     try {
                        if (var30.isNull(var3)) {
                           break label4820;
                        }
                     } catch (Throwable var725) {
                        var10000 = var725;
                        boolean var755 = false;
                        break;
                     }

                     try {
                        var27 = (float)var30.getDouble(var3);
                        break label4821;
                     } catch (Throwable var712) {
                        var10000 = var712;
                        boolean var756 = false;
                        break;
                     }
                  }

                  var27 = null;
               }

               Float var28;
               label4814: {
                  label4813: {
                     try {
                        if (var30.isNull(var5)) {
                           break label4813;
                        }
                     } catch (Throwable var724) {
                        var10000 = var724;
                        boolean var757 = false;
                        break;
                     }

                     try {
                        var28 = (float)var30.getDouble(var5);
                        break label4814;
                     } catch (Throwable var711) {
                        var10000 = var711;
                        boolean var758 = false;
                        break;
                     }
                  }

                  var28 = null;
               }

               label4807: {
                  try {
                     if (var30.isNull(var7)) {
                        break label4807;
                     }
                  } catch (Throwable var723) {
                     var10000 = var723;
                     boolean var759 = false;
                     break;
                  }

                  try {
                     var29 = (float)var30.getDouble(var7);
                  } catch (Throwable var710) {
                     var10000 = var710;
                     boolean var760 = false;
                     break;
                  }
               }

               try {
                  int var15 = (int)var30.getLong(var14);
                  DeviceDataEntity var32 = new DeviceDataEntity(var735, var19, var16, var20, var21, var22, var23, var24, var25, var26, var27, var28, var29, var15);
                  var31.add(var32);
               } catch (Throwable var709) {
                  var10000 = var709;
                  boolean var761 = false;
                  break;
               }
            }
         }

         Throwable var736 = var10000;
         var30.close();
         throw var736;
      }

      var30.close();
      return var31;
   }

   // $FF: synthetic method
   static DeviceDataEntity lambda$latestFlowNonRealTimeDeviceData$15(String var0, SQLiteConnection var1) {
      SQLiteStatement var29;
      label5828: {
         Throwable var10000;
         label5830: {
            var29 = var1.prepare("SELECT * from device_data WHERE deviceId = ? AND trend != 2 ORDER BY time DESC LIMIT 1");
            if (var0 == null) {
               try {
                  var29.bindNull(1);
               } catch (Throwable var841) {
                  var10000 = var841;
                  boolean var10001 = false;
                  break label5830;
               }
            } else {
               try {
                  var29.bindText(1, var0);
               } catch (Throwable var840) {
                  var10000 = var840;
                  boolean var846 = false;
                  break label5830;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            boolean var16;
            try {
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "id");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "deviceId");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "time");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm1");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm10");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm25");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "voc");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hcho");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "tmp");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hum");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "fan");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "weight");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "rpm");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "trend");
               var16 = var29.step();
            } catch (Throwable var839) {
               var10000 = var839;
               boolean var847 = false;
               break label5830;
            }

            var842 = null;
            Float var28 = null;
            if (!var16) {
               break label5828;
            }

            label5816: {
               label5815: {
                  try {
                     if (var29.isNull(var6)) {
                        break label5815;
                     }
                  } catch (Throwable var838) {
                     var10000 = var838;
                     boolean var848 = false;
                     break label5830;
                  }

                  try {
                     var0 = var29.getText(var6);
                     break label5816;
                  } catch (Throwable var837) {
                     var10000 = var837;
                     boolean var849 = false;
                     break label5830;
                  }
               }

               var0 = null;
            }

            label5807: {
               label5806: {
                  try {
                     if (var29.isNull(var14)) {
                        break label5806;
                     }
                  } catch (Throwable var836) {
                     var10000 = var836;
                     boolean var850 = false;
                     break label5830;
                  }

                  try {
                     var845 = var29.getText(var14);
                     break label5807;
                  } catch (Throwable var835) {
                     var10000 = var835;
                     boolean var851 = false;
                     break label5830;
                  }
               }

               var845 = null;
            }

            long var17;
            Float var19;
            label5798: {
               label5797: {
                  try {
                     var17 = var29.getLong(var9);
                     if (var29.isNull(var3)) {
                        break label5797;
                     }
                  } catch (Throwable var834) {
                     var10000 = var834;
                     boolean var852 = false;
                     break label5830;
                  }

                  try {
                     var19 = (float)var29.getDouble(var3);
                     break label5798;
                  } catch (Throwable var833) {
                     var10000 = var833;
                     boolean var853 = false;
                     break label5830;
                  }
               }

               var19 = null;
            }

            Float var20;
            label5789: {
               label5788: {
                  try {
                     if (var29.isNull(var5)) {
                        break label5788;
                     }
                  } catch (Throwable var832) {
                     var10000 = var832;
                     boolean var854 = false;
                     break label5830;
                  }

                  try {
                     var20 = (float)var29.getDouble(var5);
                     break label5789;
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var855 = false;
                     break label5830;
                  }
               }

               var20 = null;
            }

            Float var21;
            label5780: {
               label5779: {
                  try {
                     if (var29.isNull(var12)) {
                        break label5779;
                     }
                  } catch (Throwable var830) {
                     var10000 = var830;
                     boolean var856 = false;
                     break label5830;
                  }

                  try {
                     var21 = (float)var29.getDouble(var12);
                     break label5780;
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var857 = false;
                     break label5830;
                  }
               }

               var21 = null;
            }

            Float var22;
            label5771: {
               label5770: {
                  try {
                     if (var29.isNull(var15)) {
                        break label5770;
                     }
                  } catch (Throwable var828) {
                     var10000 = var828;
                     boolean var858 = false;
                     break label5830;
                  }

                  try {
                     var22 = (float)var29.getDouble(var15);
                     break label5771;
                  } catch (Throwable var827) {
                     var10000 = var827;
                     boolean var859 = false;
                     break label5830;
                  }
               }

               var22 = null;
            }

            Float var23;
            label5762: {
               label5761: {
                  try {
                     if (var29.isNull(var10)) {
                        break label5761;
                     }
                  } catch (Throwable var826) {
                     var10000 = var826;
                     boolean var860 = false;
                     break label5830;
                  }

                  try {
                     var23 = (float)var29.getDouble(var10);
                     break label5762;
                  } catch (Throwable var825) {
                     var10000 = var825;
                     boolean var861 = false;
                     break label5830;
                  }
               }

               var23 = null;
            }

            Float var24;
            label5753: {
               label5752: {
                  try {
                     if (var29.isNull(var13)) {
                        break label5752;
                     }
                  } catch (Throwable var824) {
                     var10000 = var824;
                     boolean var862 = false;
                     break label5830;
                  }

                  try {
                     var24 = (float)var29.getDouble(var13);
                     break label5753;
                  } catch (Throwable var823) {
                     var10000 = var823;
                     boolean var863 = false;
                     break label5830;
                  }
               }

               var24 = null;
            }

            Float var25;
            label5744: {
               label5743: {
                  try {
                     if (var29.isNull(var2)) {
                        break label5743;
                     }
                  } catch (Throwable var822) {
                     var10000 = var822;
                     boolean var864 = false;
                     break label5830;
                  }

                  try {
                     var25 = (float)var29.getDouble(var2);
                     break label5744;
                  } catch (Throwable var821) {
                     var10000 = var821;
                     boolean var865 = false;
                     break label5830;
                  }
               }

               var25 = null;
            }

            Float var26;
            label5735: {
               label5734: {
                  try {
                     if (var29.isNull(var4)) {
                        break label5734;
                     }
                  } catch (Throwable var820) {
                     var10000 = var820;
                     boolean var866 = false;
                     break label5830;
                  }

                  try {
                     var26 = (float)var29.getDouble(var4);
                     break label5735;
                  } catch (Throwable var819) {
                     var10000 = var819;
                     boolean var867 = false;
                     break label5830;
                  }
               }

               var26 = null;
            }

            Float var27;
            label5726: {
               label5725: {
                  try {
                     if (var29.isNull(var8)) {
                        break label5725;
                     }
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var868 = false;
                     break label5830;
                  }

                  try {
                     var27 = (float)var29.getDouble(var8);
                     break label5726;
                  } catch (Throwable var817) {
                     var10000 = var817;
                     boolean var869 = false;
                     break label5830;
                  }
               }

               var27 = null;
            }

            label5717: {
               try {
                  if (var29.isNull(var11)) {
                     break label5717;
                  }
               } catch (Throwable var816) {
                  var10000 = var816;
                  boolean var870 = false;
                  break label5830;
               }

               try {
                  var28 = (float)var29.getDouble(var11);
               } catch (Throwable var815) {
                  var10000 = var815;
                  boolean var871 = false;
                  break label5830;
               }
            }

            label5710:
            try {
               var842 = new DeviceDataEntity(var0, var845, var17, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, (int)var29.getLong(var7));
               break label5828;
            } catch (Throwable var814) {
               var10000 = var814;
               boolean var872 = false;
               break label5710;
            }
         }

         Throwable var844 = var10000;
         var29.close();
         throw var844;
      }

      var29.close();
      return var842;
   }

   // $FF: synthetic method
   static DeviceDataEntity lambda$latestLiveDeviceData$12(String var0, SQLiteConnection var1) {
      SQLiteStatement var29;
      label5828: {
         Throwable var10000;
         label5830: {
            var29 = var1.prepare("SELECT * from device_data WHERE deviceId = ? ORDER BY time DESC LIMIT 1");
            if (var0 == null) {
               try {
                  var29.bindNull(1);
               } catch (Throwable var841) {
                  var10000 = var841;
                  boolean var10001 = false;
                  break label5830;
               }
            } else {
               try {
                  var29.bindText(1, var0);
               } catch (Throwable var840) {
                  var10000 = var840;
                  boolean var846 = false;
                  break label5830;
               }
            }

            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            int var14;
            int var15;
            boolean var18;
            try {
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "id");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "deviceId");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "time");
               var15 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm1");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm10");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "pm25");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "voc");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hcho");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "tmp");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "hum");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "fan");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "weight");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "rpm");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var29, "trend");
               var18 = var29.step();
            } catch (Throwable var839) {
               var10000 = var839;
               boolean var847 = false;
               break label5830;
            }

            var842 = null;
            Float var28 = null;
            if (!var18) {
               break label5828;
            }

            label5816: {
               label5815: {
                  try {
                     if (var29.isNull(var12)) {
                        break label5815;
                     }
                  } catch (Throwable var838) {
                     var10000 = var838;
                     boolean var848 = false;
                     break label5830;
                  }

                  try {
                     var0 = var29.getText(var12);
                     break label5816;
                  } catch (Throwable var837) {
                     var10000 = var837;
                     boolean var849 = false;
                     break label5830;
                  }
               }

               var0 = null;
            }

            label5807: {
               label5806: {
                  try {
                     if (var29.isNull(var13)) {
                        break label5806;
                     }
                  } catch (Throwable var836) {
                     var10000 = var836;
                     boolean var850 = false;
                     break label5830;
                  }

                  try {
                     var845 = var29.getText(var13);
                     break label5807;
                  } catch (Throwable var835) {
                     var10000 = var835;
                     boolean var851 = false;
                     break label5830;
                  }
               }

               var845 = null;
            }

            long var16;
            Float var19;
            label5798: {
               label5797: {
                  try {
                     var16 = var29.getLong(var14);
                     if (var29.isNull(var15)) {
                        break label5797;
                     }
                  } catch (Throwable var834) {
                     var10000 = var834;
                     boolean var852 = false;
                     break label5830;
                  }

                  try {
                     var19 = (float)var29.getDouble(var15);
                     break label5798;
                  } catch (Throwable var833) {
                     var10000 = var833;
                     boolean var853 = false;
                     break label5830;
                  }
               }

               var19 = null;
            }

            Float var20;
            label5789: {
               label5788: {
                  try {
                     if (var29.isNull(var5)) {
                        break label5788;
                     }
                  } catch (Throwable var832) {
                     var10000 = var832;
                     boolean var854 = false;
                     break label5830;
                  }

                  try {
                     var20 = (float)var29.getDouble(var5);
                     break label5789;
                  } catch (Throwable var831) {
                     var10000 = var831;
                     boolean var855 = false;
                     break label5830;
                  }
               }

               var20 = null;
            }

            Float var21;
            label5780: {
               label5779: {
                  try {
                     if (var29.isNull(var10)) {
                        break label5779;
                     }
                  } catch (Throwable var830) {
                     var10000 = var830;
                     boolean var856 = false;
                     break label5830;
                  }

                  try {
                     var21 = (float)var29.getDouble(var10);
                     break label5780;
                  } catch (Throwable var829) {
                     var10000 = var829;
                     boolean var857 = false;
                     break label5830;
                  }
               }

               var21 = null;
            }

            Float var22;
            label5771: {
               label5770: {
                  try {
                     if (var29.isNull(var7)) {
                        break label5770;
                     }
                  } catch (Throwable var828) {
                     var10000 = var828;
                     boolean var858 = false;
                     break label5830;
                  }

                  try {
                     var22 = (float)var29.getDouble(var7);
                     break label5771;
                  } catch (Throwable var827) {
                     var10000 = var827;
                     boolean var859 = false;
                     break label5830;
                  }
               }

               var22 = null;
            }

            Float var23;
            label5762: {
               label5761: {
                  try {
                     if (var29.isNull(var6)) {
                        break label5761;
                     }
                  } catch (Throwable var826) {
                     var10000 = var826;
                     boolean var860 = false;
                     break label5830;
                  }

                  try {
                     var23 = (float)var29.getDouble(var6);
                     break label5762;
                  } catch (Throwable var825) {
                     var10000 = var825;
                     boolean var861 = false;
                     break label5830;
                  }
               }

               var23 = null;
            }

            Float var24;
            label5753: {
               label5752: {
                  try {
                     if (var29.isNull(var9)) {
                        break label5752;
                     }
                  } catch (Throwable var824) {
                     var10000 = var824;
                     boolean var862 = false;
                     break label5830;
                  }

                  try {
                     var24 = (float)var29.getDouble(var9);
                     break label5753;
                  } catch (Throwable var823) {
                     var10000 = var823;
                     boolean var863 = false;
                     break label5830;
                  }
               }

               var24 = null;
            }

            Float var25;
            label5744: {
               label5743: {
                  try {
                     if (var29.isNull(var8)) {
                        break label5743;
                     }
                  } catch (Throwable var822) {
                     var10000 = var822;
                     boolean var864 = false;
                     break label5830;
                  }

                  try {
                     var25 = (float)var29.getDouble(var8);
                     break label5744;
                  } catch (Throwable var821) {
                     var10000 = var821;
                     boolean var865 = false;
                     break label5830;
                  }
               }

               var25 = null;
            }

            Float var26;
            label5735: {
               label5734: {
                  try {
                     if (var29.isNull(var11)) {
                        break label5734;
                     }
                  } catch (Throwable var820) {
                     var10000 = var820;
                     boolean var866 = false;
                     break label5830;
                  }

                  try {
                     var26 = (float)var29.getDouble(var11);
                     break label5735;
                  } catch (Throwable var819) {
                     var10000 = var819;
                     boolean var867 = false;
                     break label5830;
                  }
               }

               var26 = null;
            }

            Float var27;
            label5726: {
               label5725: {
                  try {
                     if (var29.isNull(var3)) {
                        break label5725;
                     }
                  } catch (Throwable var818) {
                     var10000 = var818;
                     boolean var868 = false;
                     break label5830;
                  }

                  try {
                     var27 = (float)var29.getDouble(var3);
                     break label5726;
                  } catch (Throwable var817) {
                     var10000 = var817;
                     boolean var869 = false;
                     break label5830;
                  }
               }

               var27 = null;
            }

            label5717: {
               try {
                  if (var29.isNull(var4)) {
                     break label5717;
                  }
               } catch (Throwable var816) {
                  var10000 = var816;
                  boolean var870 = false;
                  break label5830;
               }

               try {
                  var28 = (float)var29.getDouble(var4);
               } catch (Throwable var815) {
                  var10000 = var815;
                  boolean var871 = false;
                  break label5830;
               }
            }

            label5710:
            try {
               var842 = new DeviceDataEntity(var0, var845, var16, var19, var20, var21, var22, var23, var24, var25, var26, var27, var28, (int)var29.getLong(var2));
               break label5828;
            } catch (Throwable var814) {
               var10000 = var814;
               boolean var872 = false;
               break label5710;
            }
         }

         Throwable var844 = var10000;
         var29.close();
         throw var844;
      }

      var29.close();
      return var842;
   }

   public void delete(String var1) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda6(var1));
   }

   public void deleteAll() {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda4());
   }

   public void deleteAllForDevice(String var1) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda10(var1));
   }

   public void deleteAllOldDeviceData(long var1) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda19(var1));
   }

   public void deleteDeviceDataInInclusiveRange(String var1, long var2, long var4) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda5(var1, var2, var4));
   }

   public void deleteOldDeviceData(String var1, long var2) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda17(var1, var2));
   }

   public List deviceData(String var1) {
      return (List)DBUtil.performBlocking(this.__db, true, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda0(var1));
   }

   public Flow flowDeviceData(String var1) {
      RoomDatabase var2 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda3 var3 = new DeviceDataDao_Impl$$ExternalSyntheticLambda3(var1);
      return FlowUtil.createFlow(var2, true, new String[]{"device_data"}, var3);
   }

   public Flow getFlowDeviceDataBetween(String var1, long var2, long var4) {
      RoomDatabase var6 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda9 var7 = new DeviceDataDao_Impl$$ExternalSyntheticLambda9(var1, var2, var4);
      return FlowUtil.createFlow(var6, true, new String[]{"device_data"}, var7);
   }

   public Flow getFlowDeviceDataSince(String var1, long var2) {
      RoomDatabase var4 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda12 var5 = new DeviceDataDao_Impl$$ExternalSyntheticLambda12(var1, var2);
      return FlowUtil.createFlow(var4, true, new String[]{"device_data"}, var5);
   }

   public Flow getFlowDeviceNonRealTimeDataBetween(String var1, long var2, long var4) {
      RoomDatabase var6 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda8 var7 = new DeviceDataDao_Impl$$ExternalSyntheticLambda8(var1, var2, var4);
      return FlowUtil.createFlow(var6, true, new String[]{"device_data"}, var7);
   }

   public Flow getFlowRealTimeDeviceData(String var1) {
      RoomDatabase var2 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda15 var3 = new DeviceDataDao_Impl$$ExternalSyntheticLambda15(var1);
      return FlowUtil.createFlow(var2, true, new String[]{"device_data"}, var3);
   }

   public Long getLatestHistoricalDataTime(String var1) {
      return (Long)DBUtil.performBlocking(this.__db, true, false, new DeviceDataDao_Impl$$ExternalSyntheticLambda2(var1));
   }

   public LiveData getLiveDeviceDataSince(String var1, long var2) {
      InvalidationTracker var4 = this.__db.getInvalidationTracker();
      DeviceDataDao_Impl$$ExternalSyntheticLambda11 var5 = new DeviceDataDao_Impl$$ExternalSyntheticLambda11(var1, var2);
      return var4.createLiveData(new String[]{"device_data"}, false, var5);
   }

   public void insert(DeviceDataEntity var1) {
      var1.getClass();
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda22(this, var1));
   }

   public void insertAll(List var1) {
      var1.getClass();
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda16(this, var1));
   }

   public void insertAllAndDeletePrevious(String var1, List var2) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda20(this, var1, var2));
   }

   public void insertAllAndReplace(String var1, List var2) {
      DBUtil.performBlocking(this.__db, false, true, new DeviceDataDao_Impl$$ExternalSyntheticLambda18(this, var1, var2));
   }

   // $FF: synthetic method
   Object lambda$insert$0$com_blueair_database_dao_DeviceDataDao_Impl/* $FF was: lambda$insert$0$com-blueair-database-dao-DeviceDataDao_Impl*/(DeviceDataEntity var1, SQLiteConnection var2) {
      this.__insertAdapterOfDeviceDataEntity.insert(var2, var1);
      return null;
   }

   // $FF: synthetic method
   Object lambda$insertAll$1$com_blueair_database_dao_DeviceDataDao_Impl/* $FF was: lambda$insertAll$1$com-blueair-database-dao-DeviceDataDao_Impl*/(List var1, SQLiteConnection var2) {
      this.__insertAdapterOfDeviceDataEntity.insert(var2, var1);
      return null;
   }

   // $FF: synthetic method
   Unit lambda$insertAllAndDeletePrevious$2$com_blueair_database_dao_DeviceDataDao_Impl/* $FF was: lambda$insertAllAndDeletePrevious$2$com-blueair-database-dao-DeviceDataDao_Impl*/(String var1, List var2, SQLiteConnection var3) {
      DeviceDataDao$_CC.$default$insertAllAndDeletePrevious(this, var1, var2);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$insertAllAndReplace$3$com_blueair_database_dao_DeviceDataDao_Impl/* $FF was: lambda$insertAllAndReplace$3$com-blueair-database-dao-DeviceDataDao_Impl*/(String var1, List var2, SQLiteConnection var3) {
      DeviceDataDao$_CC.$default$insertAllAndReplace(this, var1, var2);
      return Unit.INSTANCE;
   }

   public Object latestDeviceData(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, true, false, new DeviceDataDao_Impl$$ExternalSyntheticLambda1(var1), var2);
   }

   public Flow latestFlowDeviceData(String var1) {
      RoomDatabase var2 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda21 var3 = new DeviceDataDao_Impl$$ExternalSyntheticLambda21(var1);
      return FlowUtil.createFlow(var2, false, new String[]{"device_data"}, var3);
   }

   public Flow latestFlowDeviceDataForAllDevices() {
      RoomDatabase var1 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda13 var2 = new DeviceDataDao_Impl$$ExternalSyntheticLambda13();
      return FlowUtil.createFlow(var1, false, new String[]{"device_data"}, var2);
   }

   public Flow latestFlowNonRealTimeDeviceData(String var1) {
      RoomDatabase var2 = this.__db;
      DeviceDataDao_Impl$$ExternalSyntheticLambda14 var3 = new DeviceDataDao_Impl$$ExternalSyntheticLambda14(var1);
      return FlowUtil.createFlow(var2, false, new String[]{"device_data"}, var3);
   }

   public LiveData latestLiveDeviceData(String var1) {
      InvalidationTracker var2 = this.__db.getInvalidationTracker();
      DeviceDataDao_Impl$$ExternalSyntheticLambda7 var3 = new DeviceDataDao_Impl$$ExternalSyntheticLambda7(var1);
      return var2.createLiveData(new String[]{"device_data"}, false, var3);
   }
}
