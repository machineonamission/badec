package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.AqiDataEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class AqiDataDao_Impl implements AqiDataDao {
   private final RoomDatabase __db;
   private final EntityInsertAdapter __insertAdapterOfAqiDataEntity;

   public AqiDataDao_Impl(RoomDatabase var1) {
      this.__db = var1;
      this.__insertAdapterOfAqiDataEntity = new EntityInsertAdapter(this) {
         final AqiDataDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, AqiDataEntity var2) {
            if (var2.getTrackedLocationId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getTrackedLocationId());
            }

            var1.bindLong(2, var2.getDatetime());
            if (var2.getCo() == null) {
               var1.bindNull(3);
            } else {
               var1.bindDouble(3, var2.getCo());
            }

            if (var2.getNo2() == null) {
               var1.bindNull(4);
            } else {
               var1.bindDouble(4, var2.getNo2());
            }

            if (var2.getO3() == null) {
               var1.bindNull(5);
            } else {
               var1.bindDouble(5, var2.getO3());
            }

            if (var2.getPm10() == null) {
               var1.bindNull(6);
            } else {
               var1.bindDouble(6, var2.getPm10());
            }

            if (var2.getPm25() == null) {
               var1.bindNull(7);
            } else {
               var1.bindDouble(7, var2.getPm25());
            }

            if (var2.getSo2() == null) {
               var1.bindNull(8);
            } else {
               var1.bindDouble(8, var2.getSo2());
            }

            if (var2.getAqi() == null) {
               var1.bindNull(9);
            } else {
               var1.bindDouble(9, var2.getAqi());
            }
         }

         protected String createQuery() {
            return "INSERT OR REPLACE INTO `aqi_data_table` (`trackedLocationId`,`datetime`,`co`,`no2`,`o3`,`pm10`,`pm25`,`so2`,`aqi`) VALUES (?,?,?,?,?,?,?,?,?)";
         }
      };
   }

   public static List getRequiredConverters() {
      return Collections.EMPTY_LIST;
   }

   // $FF: synthetic method
   static Unit lambda$delete$6(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var16 = var1.prepare("DELETE FROM aqi_data_table WHERE trackedLocationId = ?");
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
   static Unit lambda$delete$7(String var0, List var1, SQLiteConnection var2) {
      SQLiteStatement var34 = var2.prepare(var0);

      label272: {
         Throwable var10000;
         label276: {
            try {
               var35 = var1.iterator();
            } catch (Throwable var33) {
               var10000 = var33;
               boolean var10001 = false;
               break label276;
            }

            int var3 = 1;

            while(true) {
               try {
                  if (!var35.hasNext()) {
                     break;
                  }

                  var38 = (String)var35.next();
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var39 = false;
                  break label276;
               }

               if (var38 == null) {
                  try {
                     var34.bindNull(var3);
                  } catch (Throwable var31) {
                     var10000 = var31;
                     boolean var40 = false;
                     break label276;
                  }
               } else {
                  try {
                     var34.bindText(var3, var38);
                  } catch (Throwable var30) {
                     var10000 = var30;
                     boolean var41 = false;
                     break label276;
                  }
               }

               ++var3;
            }

            label255:
            try {
               var34.step();
               var37 = Unit.INSTANCE;
               break label272;
            } catch (Throwable var29) {
               var10000 = var29;
               boolean var42 = false;
               break label255;
            }
         }

         Throwable var36 = var10000;
         var34.close();
         throw var36;
      }

      var34.close();
      return var37;
   }

   // $FF: synthetic method
   static Unit lambda$deleteAll$8(SQLiteConnection var0) {
      SQLiteStatement var4 = var0.prepare("DELETE FROM aqi_data_table");

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
   static List lambda$getAqiData$2(SQLiteConnection var0) {
      SQLiteStatement var20 = var0.prepare("SELECT * from aqi_data_table");

      ArrayList var21;
      label2448: {
         Throwable var10000;
         label2447: {
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            try {
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "trackedLocationId");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "datetime");
               var1 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "co");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "no2");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "o3");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm10");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm25");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "so2");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "aqi");
               var21 = new ArrayList();
            } catch (Throwable var364) {
               var10000 = var364;
               boolean var10001 = false;
               break label2447;
            }

            while(true) {
               boolean var10;
               try {
                  if (!var20.step()) {
                     break label2448;
                  }

                  var10 = var20.isNull(var9);
               } catch (Throwable var356) {
                  var10000 = var356;
                  boolean var367 = false;
                  break;
               }

               Double var19 = null;
               String var365;
               if (var10) {
                  var365 = null;
               } else {
                  try {
                     var365 = var20.getText(var9);
                  } catch (Throwable var355) {
                     var10000 = var355;
                     boolean var368 = false;
                     break;
                  }
               }

               long var11;
               Double var13;
               label2441: {
                  label2440: {
                     try {
                        var11 = var20.getLong(var7);
                        if (var20.isNull(var1)) {
                           break label2440;
                        }
                     } catch (Throwable var363) {
                        var10000 = var363;
                        boolean var369 = false;
                        break;
                     }

                     try {
                        var13 = var20.getDouble(var1);
                        break label2441;
                     } catch (Throwable var354) {
                        var10000 = var354;
                        boolean var370 = false;
                        break;
                     }
                  }

                  var13 = null;
               }

               Double var14;
               label2434: {
                  label2433: {
                     try {
                        if (var20.isNull(var4)) {
                           break label2433;
                        }
                     } catch (Throwable var362) {
                        var10000 = var362;
                        boolean var371 = false;
                        break;
                     }

                     try {
                        var14 = var20.getDouble(var4);
                        break label2434;
                     } catch (Throwable var353) {
                        var10000 = var353;
                        boolean var372 = false;
                        break;
                     }
                  }

                  var14 = null;
               }

               Double var15;
               label2427: {
                  label2426: {
                     try {
                        if (var20.isNull(var5)) {
                           break label2426;
                        }
                     } catch (Throwable var361) {
                        var10000 = var361;
                        boolean var373 = false;
                        break;
                     }

                     try {
                        var15 = var20.getDouble(var5);
                        break label2427;
                     } catch (Throwable var352) {
                        var10000 = var352;
                        boolean var374 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               Double var16;
               label2420: {
                  label2419: {
                     try {
                        if (var20.isNull(var3)) {
                           break label2419;
                        }
                     } catch (Throwable var360) {
                        var10000 = var360;
                        boolean var375 = false;
                        break;
                     }

                     try {
                        var16 = var20.getDouble(var3);
                        break label2420;
                     } catch (Throwable var351) {
                        var10000 = var351;
                        boolean var376 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               Double var17;
               label2413: {
                  label2412: {
                     try {
                        if (var20.isNull(var2)) {
                           break label2412;
                        }
                     } catch (Throwable var359) {
                        var10000 = var359;
                        boolean var377 = false;
                        break;
                     }

                     try {
                        var17 = var20.getDouble(var2);
                        break label2413;
                     } catch (Throwable var350) {
                        var10000 = var350;
                        boolean var378 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               Double var18;
               label2406: {
                  label2405: {
                     try {
                        if (var20.isNull(var6)) {
                           break label2405;
                        }
                     } catch (Throwable var358) {
                        var10000 = var358;
                        boolean var379 = false;
                        break;
                     }

                     try {
                        var18 = var20.getDouble(var6);
                        break label2406;
                     } catch (Throwable var349) {
                        var10000 = var349;
                        boolean var380 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               label2399: {
                  try {
                     if (var20.isNull(var8)) {
                        break label2399;
                     }
                  } catch (Throwable var357) {
                     var10000 = var357;
                     boolean var381 = false;
                     break;
                  }

                  try {
                     var19 = var20.getDouble(var8);
                  } catch (Throwable var348) {
                     var10000 = var348;
                     boolean var382 = false;
                     break;
                  }
               }

               try {
                  AqiDataEntity var22 = new AqiDataEntity(var365, var11, var13, var14, var15, var16, var17, var18, var19);
                  var21.add(var22);
               } catch (Throwable var347) {
                  var10000 = var347;
                  boolean var383 = false;
                  break;
               }
            }
         }

         Throwable var366 = var10000;
         var20.close();
         throw var366;
      }

      var20.close();
      return var21;
   }

   // $FF: synthetic method
   static AqiDataEntity lambda$getAqiData$3(String var0, SQLiteConnection var1) {
      SQLiteStatement var20;
      label3044: {
         Throwable var10000;
         label3046: {
            var20 = var1.prepare("SELECT * from aqi_data_table WHERE trackedLocationId = ?");
            if (var0 == null) {
               try {
                  var20.bindNull(1);
               } catch (Throwable var440) {
                  var10000 = var440;
                  boolean var10001 = false;
                  break label3046;
               }
            } else {
               try {
                  var20.bindText(1, var0);
               } catch (Throwable var439) {
                  var10000 = var439;
                  boolean var445 = false;
                  break label3046;
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
            boolean var13;
            try {
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "trackedLocationId");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "datetime");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "co");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "no2");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "o3");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm10");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm25");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "so2");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "aqi");
               var13 = var20.step();
            } catch (Throwable var438) {
               var10000 = var438;
               boolean var446 = false;
               break label3046;
            }

            var441 = null;
            Double var19 = null;
            if (!var13) {
               break label3044;
            }

            label3032: {
               label3031: {
                  try {
                     if (var20.isNull(var8)) {
                        break label3031;
                     }
                  } catch (Throwable var437) {
                     var10000 = var437;
                     boolean var447 = false;
                     break label3046;
                  }

                  try {
                     var0 = var20.getText(var8);
                     break label3032;
                  } catch (Throwable var436) {
                     var10000 = var436;
                     boolean var448 = false;
                     break label3046;
                  }
               }

               var0 = null;
            }

            long var11;
            label3023: {
               label3022: {
                  try {
                     var11 = var20.getLong(var5);
                     if (var20.isNull(var6)) {
                        break label3022;
                     }
                  } catch (Throwable var435) {
                     var10000 = var435;
                     boolean var449 = false;
                     break label3046;
                  }

                  try {
                     var444 = var20.getDouble(var6);
                     break label3023;
                  } catch (Throwable var434) {
                     var10000 = var434;
                     boolean var450 = false;
                     break label3046;
                  }
               }

               var444 = null;
            }

            Double var14;
            label3014: {
               label3013: {
                  try {
                     if (var20.isNull(var3)) {
                        break label3013;
                     }
                  } catch (Throwable var433) {
                     var10000 = var433;
                     boolean var451 = false;
                     break label3046;
                  }

                  try {
                     var14 = var20.getDouble(var3);
                     break label3014;
                  } catch (Throwable var432) {
                     var10000 = var432;
                     boolean var452 = false;
                     break label3046;
                  }
               }

               var14 = null;
            }

            Double var15;
            label3005: {
               label3004: {
                  try {
                     if (var20.isNull(var9)) {
                        break label3004;
                     }
                  } catch (Throwable var431) {
                     var10000 = var431;
                     boolean var453 = false;
                     break label3046;
                  }

                  try {
                     var15 = var20.getDouble(var9);
                     break label3005;
                  } catch (Throwable var430) {
                     var10000 = var430;
                     boolean var454 = false;
                     break label3046;
                  }
               }

               var15 = null;
            }

            Double var16;
            label2996: {
               label2995: {
                  try {
                     if (var20.isNull(var2)) {
                        break label2995;
                     }
                  } catch (Throwable var429) {
                     var10000 = var429;
                     boolean var455 = false;
                     break label3046;
                  }

                  try {
                     var16 = var20.getDouble(var2);
                     break label2996;
                  } catch (Throwable var428) {
                     var10000 = var428;
                     boolean var456 = false;
                     break label3046;
                  }
               }

               var16 = null;
            }

            Double var17;
            label2987: {
               label2986: {
                  try {
                     if (var20.isNull(var4)) {
                        break label2986;
                     }
                  } catch (Throwable var427) {
                     var10000 = var427;
                     boolean var457 = false;
                     break label3046;
                  }

                  try {
                     var17 = var20.getDouble(var4);
                     break label2987;
                  } catch (Throwable var426) {
                     var10000 = var426;
                     boolean var458 = false;
                     break label3046;
                  }
               }

               var17 = null;
            }

            Double var18;
            label2978: {
               label2977: {
                  try {
                     if (var20.isNull(var7)) {
                        break label2977;
                     }
                  } catch (Throwable var425) {
                     var10000 = var425;
                     boolean var459 = false;
                     break label3046;
                  }

                  try {
                     var18 = var20.getDouble(var7);
                     break label2978;
                  } catch (Throwable var424) {
                     var10000 = var424;
                     boolean var460 = false;
                     break label3046;
                  }
               }

               var18 = null;
            }

            label2969: {
               try {
                  if (var20.isNull(var10)) {
                     break label2969;
                  }
               } catch (Throwable var423) {
                  var10000 = var423;
                  boolean var461 = false;
                  break label3046;
               }

               try {
                  var19 = var20.getDouble(var10);
               } catch (Throwable var422) {
                  var10000 = var422;
                  boolean var462 = false;
                  break label3046;
               }
            }

            label2962:
            try {
               var441 = new AqiDataEntity(var0, var11, var444, var14, var15, var16, var17, var18, var19);
               break label3044;
            } catch (Throwable var421) {
               var10000 = var421;
               boolean var463 = false;
               break label2962;
            }
         }

         Throwable var443 = var10000;
         var20.close();
         throw var443;
      }

      var20.close();
      return var441;
   }

   // $FF: synthetic method
   static List lambda$getLiveAqiData$4(SQLiteConnection var0) {
      SQLiteStatement var20 = var0.prepare("SELECT * from aqi_data_table");

      ArrayList var21;
      label2448: {
         Throwable var10000;
         label2447: {
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            try {
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "trackedLocationId");
               var1 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "datetime");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "co");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "no2");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "o3");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm10");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm25");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "so2");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "aqi");
               var21 = new ArrayList();
            } catch (Throwable var364) {
               var10000 = var364;
               boolean var10001 = false;
               break label2447;
            }

            while(true) {
               boolean var10;
               try {
                  if (!var20.step()) {
                     break label2448;
                  }

                  var10 = var20.isNull(var9);
               } catch (Throwable var356) {
                  var10000 = var356;
                  boolean var367 = false;
                  break;
               }

               Double var19 = null;
               String var365;
               if (var10) {
                  var365 = null;
               } else {
                  try {
                     var365 = var20.getText(var9);
                  } catch (Throwable var355) {
                     var10000 = var355;
                     boolean var368 = false;
                     break;
                  }
               }

               long var11;
               Double var13;
               label2441: {
                  label2440: {
                     try {
                        var11 = var20.getLong(var1);
                        if (var20.isNull(var8)) {
                           break label2440;
                        }
                     } catch (Throwable var363) {
                        var10000 = var363;
                        boolean var369 = false;
                        break;
                     }

                     try {
                        var13 = var20.getDouble(var8);
                        break label2441;
                     } catch (Throwable var354) {
                        var10000 = var354;
                        boolean var370 = false;
                        break;
                     }
                  }

                  var13 = null;
               }

               Double var14;
               label2434: {
                  label2433: {
                     try {
                        if (var20.isNull(var2)) {
                           break label2433;
                        }
                     } catch (Throwable var362) {
                        var10000 = var362;
                        boolean var371 = false;
                        break;
                     }

                     try {
                        var14 = var20.getDouble(var2);
                        break label2434;
                     } catch (Throwable var353) {
                        var10000 = var353;
                        boolean var372 = false;
                        break;
                     }
                  }

                  var14 = null;
               }

               Double var15;
               label2427: {
                  label2426: {
                     try {
                        if (var20.isNull(var3)) {
                           break label2426;
                        }
                     } catch (Throwable var361) {
                        var10000 = var361;
                        boolean var373 = false;
                        break;
                     }

                     try {
                        var15 = var20.getDouble(var3);
                        break label2427;
                     } catch (Throwable var352) {
                        var10000 = var352;
                        boolean var374 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               Double var16;
               label2420: {
                  label2419: {
                     try {
                        if (var20.isNull(var6)) {
                           break label2419;
                        }
                     } catch (Throwable var360) {
                        var10000 = var360;
                        boolean var375 = false;
                        break;
                     }

                     try {
                        var16 = var20.getDouble(var6);
                        break label2420;
                     } catch (Throwable var351) {
                        var10000 = var351;
                        boolean var376 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               Double var17;
               label2413: {
                  label2412: {
                     try {
                        if (var20.isNull(var5)) {
                           break label2412;
                        }
                     } catch (Throwable var359) {
                        var10000 = var359;
                        boolean var377 = false;
                        break;
                     }

                     try {
                        var17 = var20.getDouble(var5);
                        break label2413;
                     } catch (Throwable var350) {
                        var10000 = var350;
                        boolean var378 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               Double var18;
               label2406: {
                  label2405: {
                     try {
                        if (var20.isNull(var4)) {
                           break label2405;
                        }
                     } catch (Throwable var358) {
                        var10000 = var358;
                        boolean var379 = false;
                        break;
                     }

                     try {
                        var18 = var20.getDouble(var4);
                        break label2406;
                     } catch (Throwable var349) {
                        var10000 = var349;
                        boolean var380 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               label2399: {
                  try {
                     if (var20.isNull(var7)) {
                        break label2399;
                     }
                  } catch (Throwable var357) {
                     var10000 = var357;
                     boolean var381 = false;
                     break;
                  }

                  try {
                     var19 = var20.getDouble(var7);
                  } catch (Throwable var348) {
                     var10000 = var348;
                     boolean var382 = false;
                     break;
                  }
               }

               try {
                  AqiDataEntity var22 = new AqiDataEntity(var365, var11, var13, var14, var15, var16, var17, var18, var19);
                  var21.add(var22);
               } catch (Throwable var347) {
                  var10000 = var347;
                  boolean var383 = false;
                  break;
               }
            }
         }

         Throwable var366 = var10000;
         var20.close();
         throw var366;
      }

      var20.close();
      return var21;
   }

   // $FF: synthetic method
   static AqiDataEntity lambda$getLiveAqiData$5(String var0, SQLiteConnection var1) {
      SQLiteStatement var20;
      label3044: {
         Throwable var10000;
         label3046: {
            var20 = var1.prepare("SELECT * from aqi_data_table WHERE trackedLocationId = ?");
            if (var0 == null) {
               try {
                  var20.bindNull(1);
               } catch (Throwable var440) {
                  var10000 = var440;
                  boolean var10001 = false;
                  break label3046;
               }
            } else {
               try {
                  var20.bindText(1, var0);
               } catch (Throwable var439) {
                  var10000 = var439;
                  boolean var445 = false;
                  break label3046;
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
            boolean var13;
            try {
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "trackedLocationId");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "datetime");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "co");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "no2");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "o3");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm10");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "pm25");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "so2");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "aqi");
               var13 = var20.step();
            } catch (Throwable var438) {
               var10000 = var438;
               boolean var446 = false;
               break label3046;
            }

            var441 = null;
            Double var19 = null;
            if (!var13) {
               break label3044;
            }

            label3032: {
               label3031: {
                  try {
                     if (var20.isNull(var8)) {
                        break label3031;
                     }
                  } catch (Throwable var437) {
                     var10000 = var437;
                     boolean var447 = false;
                     break label3046;
                  }

                  try {
                     var0 = var20.getText(var8);
                     break label3032;
                  } catch (Throwable var436) {
                     var10000 = var436;
                     boolean var448 = false;
                     break label3046;
                  }
               }

               var0 = null;
            }

            long var11;
            label3023: {
               label3022: {
                  try {
                     var11 = var20.getLong(var4);
                     if (var20.isNull(var5)) {
                        break label3022;
                     }
                  } catch (Throwable var435) {
                     var10000 = var435;
                     boolean var449 = false;
                     break label3046;
                  }

                  try {
                     var444 = var20.getDouble(var5);
                     break label3023;
                  } catch (Throwable var434) {
                     var10000 = var434;
                     boolean var450 = false;
                     break label3046;
                  }
               }

               var444 = null;
            }

            Double var14;
            label3014: {
               label3013: {
                  try {
                     if (var20.isNull(var6)) {
                        break label3013;
                     }
                  } catch (Throwable var433) {
                     var10000 = var433;
                     boolean var451 = false;
                     break label3046;
                  }

                  try {
                     var14 = var20.getDouble(var6);
                     break label3014;
                  } catch (Throwable var432) {
                     var10000 = var432;
                     boolean var452 = false;
                     break label3046;
                  }
               }

               var14 = null;
            }

            Double var15;
            label3005: {
               label3004: {
                  try {
                     if (var20.isNull(var9)) {
                        break label3004;
                     }
                  } catch (Throwable var431) {
                     var10000 = var431;
                     boolean var453 = false;
                     break label3046;
                  }

                  try {
                     var15 = var20.getDouble(var9);
                     break label3005;
                  } catch (Throwable var430) {
                     var10000 = var430;
                     boolean var454 = false;
                     break label3046;
                  }
               }

               var15 = null;
            }

            Double var16;
            label2996: {
               label2995: {
                  try {
                     if (var20.isNull(var2)) {
                        break label2995;
                     }
                  } catch (Throwable var429) {
                     var10000 = var429;
                     boolean var455 = false;
                     break label3046;
                  }

                  try {
                     var16 = var20.getDouble(var2);
                     break label2996;
                  } catch (Throwable var428) {
                     var10000 = var428;
                     boolean var456 = false;
                     break label3046;
                  }
               }

               var16 = null;
            }

            Double var17;
            label2987: {
               label2986: {
                  try {
                     if (var20.isNull(var7)) {
                        break label2986;
                     }
                  } catch (Throwable var427) {
                     var10000 = var427;
                     boolean var457 = false;
                     break label3046;
                  }

                  try {
                     var17 = var20.getDouble(var7);
                     break label2987;
                  } catch (Throwable var426) {
                     var10000 = var426;
                     boolean var458 = false;
                     break label3046;
                  }
               }

               var17 = null;
            }

            Double var18;
            label2978: {
               label2977: {
                  try {
                     if (var20.isNull(var3)) {
                        break label2977;
                     }
                  } catch (Throwable var425) {
                     var10000 = var425;
                     boolean var459 = false;
                     break label3046;
                  }

                  try {
                     var18 = var20.getDouble(var3);
                     break label2978;
                  } catch (Throwable var424) {
                     var10000 = var424;
                     boolean var460 = false;
                     break label3046;
                  }
               }

               var18 = null;
            }

            label2969: {
               try {
                  if (var20.isNull(var10)) {
                     break label2969;
                  }
               } catch (Throwable var423) {
                  var10000 = var423;
                  boolean var461 = false;
                  break label3046;
               }

               try {
                  var19 = var20.getDouble(var10);
               } catch (Throwable var422) {
                  var10000 = var422;
                  boolean var462 = false;
                  break label3046;
               }
            }

            label2962:
            try {
               var441 = new AqiDataEntity(var0, var11, var444, var14, var15, var16, var17, var18, var19);
               break label3044;
            } catch (Throwable var421) {
               var10000 = var421;
               boolean var463 = false;
               break label2962;
            }
         }

         Throwable var443 = var10000;
         var20.close();
         throw var443;
      }

      var20.close();
      return var441;
   }

   public Object delete(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda0(var1), var2);
   }

   public Object delete(List var1, Continuation var2) {
      StringBuilder var3 = new StringBuilder();
      var3.append("DELETE FROM aqi_data_table WHERE trackedLocationId in (");
      StringUtil.appendPlaceholders(var3, var1.size());
      var3.append(")");
      String var4 = var3.toString();
      return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda8(var4, var1), var2);
   }

   public Object deleteAll(Continuation var1) {
      return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda7(), var1);
   }

   public Object getAqiData(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, true, false, new AqiDataDao_Impl$$ExternalSyntheticLambda6(var1), var2);
   }

   public List getAqiData() {
      return (List)DBUtil.performBlocking(this.__db, true, false, new AqiDataDao_Impl$$ExternalSyntheticLambda4());
   }

   public LiveData getLiveAqiData() {
      InvalidationTracker var2 = this.__db.getInvalidationTracker();
      AqiDataDao_Impl$$ExternalSyntheticLambda3 var1 = new AqiDataDao_Impl$$ExternalSyntheticLambda3();
      return var2.createLiveData(new String[]{"aqi_data_table"}, false, var1);
   }

   public LiveData getLiveAqiData(String var1) {
      InvalidationTracker var2 = this.__db.getInvalidationTracker();
      AqiDataDao_Impl$$ExternalSyntheticLambda1 var3 = new AqiDataDao_Impl$$ExternalSyntheticLambda1(var1);
      return var2.createLiveData(new String[]{"aqi_data_table"}, false, var3);
   }

   public Object insert(AqiDataEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda5(this, var1), var2);
   }

   public Object insertAll(List var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new AqiDataDao_Impl$$ExternalSyntheticLambda2(this, var1), var2);
   }

   // $FF: synthetic method
   Unit lambda$insert$0$com_blueair_database_dao_AqiDataDao_Impl/* $FF was: lambda$insert$0$com-blueair-database-dao-AqiDataDao_Impl*/(AqiDataEntity var1, SQLiteConnection var2) {
      this.__insertAdapterOfAqiDataEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$insertAll$1$com_blueair_database_dao_AqiDataDao_Impl/* $FF was: lambda$insertAll$1$com-blueair-database-dao-AqiDataDao_Impl*/(List var1, SQLiteConnection var2) {
      this.__insertAdapterOfAqiDataEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }
}
