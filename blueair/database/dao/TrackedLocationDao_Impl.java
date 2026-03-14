package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.entity.TrackedLocationEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class TrackedLocationDao_Impl implements TrackedLocationDao {
   private final RoomDatabase __db;
   private final EntityDeleteOrUpdateAdapter __deleteAdapterOfTrackedLocationEntity;
   private final EntityInsertAdapter __insertAdapterOfTrackedLocationEntity;
   private final EntityDeleteOrUpdateAdapter __updateAdapterOfTrackedLocationEntity;

   public TrackedLocationDao_Impl(RoomDatabase var1) {
      this.__db = var1;
      this.__insertAdapterOfTrackedLocationEntity = new EntityInsertAdapter(this) {
         final TrackedLocationDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, TrackedLocationEntity var2) {
            if (var2.getId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getId());
            }

            var1.bindDouble(2, var2.getLatitude());
            var1.bindDouble(3, var2.getLongitude());
            if (var2.getLocationName() == null) {
               var1.bindNull(4);
            } else {
               var1.bindText(4, var2.getLocationName());
            }

            if (var2.getCityName() == null) {
               var1.bindNull(5);
            } else {
               var1.bindText(5, var2.getCityName());
            }

            if (var2.getStateName() == null) {
               var1.bindNull(6);
            } else {
               var1.bindText(6, var2.getStateName());
            }

            if (var2.getCountryName() == null) {
               var1.bindNull(7);
            } else {
               var1.bindText(7, var2.getCountryName());
            }

            if (var2.getCountryCode() == null) {
               var1.bindNull(8);
            } else {
               var1.bindText(8, var2.getCountryCode());
            }

            if (var2.getMapType() == null) {
               var1.bindNull(9);
            } else {
               var1.bindText(9, var2.getMapType());
            }
         }

         protected String createQuery() {
            return "INSERT OR REPLACE INTO `tracked_location_table` (`id`,`latitude`,`longitude`,`locationName`,`cityName`,`stateName`,`countryName`,`countryCode`,`mapType`) VALUES (?,?,?,?,?,?,?,?,?)";
         }
      };
      this.__deleteAdapterOfTrackedLocationEntity = new EntityDeleteOrUpdateAdapter(this) {
         final TrackedLocationDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, TrackedLocationEntity var2) {
            if (var2.getId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getId());
            }
         }

         protected String createQuery() {
            return "DELETE FROM `tracked_location_table` WHERE `id` = ?";
         }
      };
      this.__updateAdapterOfTrackedLocationEntity = new EntityDeleteOrUpdateAdapter(this) {
         final TrackedLocationDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, TrackedLocationEntity var2) {
            if (var2.getId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getId());
            }

            var1.bindDouble(2, var2.getLatitude());
            var1.bindDouble(3, var2.getLongitude());
            if (var2.getLocationName() == null) {
               var1.bindNull(4);
            } else {
               var1.bindText(4, var2.getLocationName());
            }

            if (var2.getCityName() == null) {
               var1.bindNull(5);
            } else {
               var1.bindText(5, var2.getCityName());
            }

            if (var2.getStateName() == null) {
               var1.bindNull(6);
            } else {
               var1.bindText(6, var2.getStateName());
            }

            if (var2.getCountryName() == null) {
               var1.bindNull(7);
            } else {
               var1.bindText(7, var2.getCountryName());
            }

            if (var2.getCountryCode() == null) {
               var1.bindNull(8);
            } else {
               var1.bindText(8, var2.getCountryCode());
            }

            if (var2.getMapType() == null) {
               var1.bindNull(9);
            } else {
               var1.bindText(9, var2.getMapType());
            }

            if (var2.getId() == null) {
               var1.bindNull(10);
            } else {
               var1.bindText(10, var2.getId());
            }
         }

         protected String createQuery() {
            return "UPDATE OR REPLACE `tracked_location_table` SET `id` = ?,`latitude` = ?,`longitude` = ?,`locationName` = ?,`cityName` = ?,`stateName` = ?,`countryName` = ?,`countryCode` = ?,`mapType` = ? WHERE `id` = ?";
         }
      };
   }

   public static List getRequiredConverters() {
      return Collections.EMPTY_LIST;
   }

   // $FF: synthetic method
   static Unit lambda$deleteAll$13(SQLiteConnection var0) {
      SQLiteStatement var4 = var0.prepare("DELETE FROM tracked_location_table");

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
   static Unit lambda$deleteTrackedLocation$11(String var0, SQLiteConnection var1) {
      label99: {
         Throwable var10000;
         label98: {
            var16 = var1.prepare("DELETE FROM tracked_location_table WHERE id = ?");
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
   static Object lambda$deleteTrackedLocations$12(String var0, List var1, SQLiteConnection var2) {
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

                  var37 = (String)var35.next();
               } catch (Throwable var32) {
                  var10000 = var32;
                  boolean var38 = false;
                  break label276;
               }

               if (var37 == null) {
                  try {
                     var34.bindNull(var3);
                  } catch (Throwable var31) {
                     var10000 = var31;
                     boolean var39 = false;
                     break label276;
                  }
               } else {
                  try {
                     var34.bindText(var3, var37);
                  } catch (Throwable var30) {
                     var10000 = var30;
                     boolean var40 = false;
                     break label276;
                  }
               }

               ++var3;
            }

            label255:
            try {
               var34.step();
               break label272;
            } catch (Throwable var29) {
               var10000 = var29;
               boolean var41 = false;
               break label255;
            }
         }

         Throwable var36 = var10000;
         var34.close();
         throw var36;
      }

      var34.close();
      return null;
   }

   // $FF: synthetic method
   static TrackedLocationEntity lambda$getCurrentLocation$7(SQLiteConnection var0) {
      SQLiteStatement var21 = var0.prepare("SELECT * from tracked_location_table where id = 'current'");

      label2071: {
         Throwable var10000;
         label2075: {
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            boolean var14;
            try {
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "id");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "latitude");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "longitude");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "locationName");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "cityName");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "stateName");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryName");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryCode");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "mapType");
               var14 = var21.step();
            } catch (Throwable var293) {
               var10000 = var293;
               boolean var10001 = false;
               break label2075;
            }

            var294 = null;
            String var20 = null;
            if (!var14) {
               break label2071;
            }

            label2065: {
               label2064: {
                  try {
                     if (var21.isNull(var10)) {
                        break label2064;
                     }
                  } catch (Throwable var292) {
                     var10000 = var292;
                     boolean var297 = false;
                     break label2075;
                  }

                  try {
                     var295 = var21.getText(var10);
                     break label2065;
                  } catch (Throwable var291) {
                     var10000 = var291;
                     boolean var298 = false;
                     break label2075;
                  }
               }

               var295 = null;
            }

            double var1;
            double var3;
            String var15;
            label2056: {
               label2055: {
                  try {
                     var3 = var21.getDouble(var9);
                     var1 = var21.getDouble(var8);
                     if (var21.isNull(var6)) {
                        break label2055;
                     }
                  } catch (Throwable var290) {
                     var10000 = var290;
                     boolean var299 = false;
                     break label2075;
                  }

                  try {
                     var15 = var21.getText(var6);
                     break label2056;
                  } catch (Throwable var289) {
                     var10000 = var289;
                     boolean var300 = false;
                     break label2075;
                  }
               }

               var15 = null;
            }

            String var16;
            label2047: {
               label2046: {
                  try {
                     if (var21.isNull(var13)) {
                        break label2046;
                     }
                  } catch (Throwable var288) {
                     var10000 = var288;
                     boolean var301 = false;
                     break label2075;
                  }

                  try {
                     var16 = var21.getText(var13);
                     break label2047;
                  } catch (Throwable var287) {
                     var10000 = var287;
                     boolean var302 = false;
                     break label2075;
                  }
               }

               var16 = null;
            }

            String var17;
            label2038: {
               label2037: {
                  try {
                     if (var21.isNull(var11)) {
                        break label2037;
                     }
                  } catch (Throwable var286) {
                     var10000 = var286;
                     boolean var303 = false;
                     break label2075;
                  }

                  try {
                     var17 = var21.getText(var11);
                     break label2038;
                  } catch (Throwable var285) {
                     var10000 = var285;
                     boolean var304 = false;
                     break label2075;
                  }
               }

               var17 = null;
            }

            String var18;
            label2029: {
               label2028: {
                  try {
                     if (var21.isNull(var5)) {
                        break label2028;
                     }
                  } catch (Throwable var284) {
                     var10000 = var284;
                     boolean var305 = false;
                     break label2075;
                  }

                  try {
                     var18 = var21.getText(var5);
                     break label2029;
                  } catch (Throwable var283) {
                     var10000 = var283;
                     boolean var306 = false;
                     break label2075;
                  }
               }

               var18 = null;
            }

            String var19;
            label2020: {
               label2019: {
                  try {
                     if (var21.isNull(var12)) {
                        break label2019;
                     }
                  } catch (Throwable var282) {
                     var10000 = var282;
                     boolean var307 = false;
                     break label2075;
                  }

                  try {
                     var19 = var21.getText(var12);
                     break label2020;
                  } catch (Throwable var281) {
                     var10000 = var281;
                     boolean var308 = false;
                     break label2075;
                  }
               }

               var19 = null;
            }

            label2011: {
               try {
                  if (var21.isNull(var7)) {
                     break label2011;
                  }
               } catch (Throwable var280) {
                  var10000 = var280;
                  boolean var309 = false;
                  break label2075;
               }

               try {
                  var20 = var21.getText(var7);
               } catch (Throwable var279) {
                  var10000 = var279;
                  boolean var310 = false;
                  break label2075;
               }
            }

            label2004:
            try {
               var294 = new TrackedLocationEntity(var295, var3, var1, var15, var16, var17, var18, var19, var20);
               break label2071;
            } catch (Throwable var278) {
               var10000 = var278;
               boolean var311 = false;
               break label2004;
            }
         }

         Throwable var296 = var10000;
         var21.close();
         throw var296;
      }

      var21.close();
      return var294;
   }

   // $FF: synthetic method
   static TrackedLocationEntity lambda$getLiveCurrentLocation$8(SQLiteConnection var0) {
      SQLiteStatement var21 = var0.prepare("SELECT * from tracked_location_table where id = 'current'");

      label2071: {
         Throwable var10000;
         label2075: {
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            boolean var14;
            try {
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "id");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "latitude");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "longitude");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "locationName");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "cityName");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "stateName");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryName");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryCode");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "mapType");
               var14 = var21.step();
            } catch (Throwable var293) {
               var10000 = var293;
               boolean var10001 = false;
               break label2075;
            }

            var294 = null;
            String var20 = null;
            if (!var14) {
               break label2071;
            }

            label2065: {
               label2064: {
                  try {
                     if (var21.isNull(var9)) {
                        break label2064;
                     }
                  } catch (Throwable var292) {
                     var10000 = var292;
                     boolean var297 = false;
                     break label2075;
                  }

                  try {
                     var295 = var21.getText(var9);
                     break label2065;
                  } catch (Throwable var291) {
                     var10000 = var291;
                     boolean var298 = false;
                     break label2075;
                  }
               }

               var295 = null;
            }

            double var1;
            double var3;
            String var15;
            label2056: {
               label2055: {
                  try {
                     var3 = var21.getDouble(var7);
                     var1 = var21.getDouble(var10);
                     if (var21.isNull(var13)) {
                        break label2055;
                     }
                  } catch (Throwable var290) {
                     var10000 = var290;
                     boolean var299 = false;
                     break label2075;
                  }

                  try {
                     var15 = var21.getText(var13);
                     break label2056;
                  } catch (Throwable var289) {
                     var10000 = var289;
                     boolean var300 = false;
                     break label2075;
                  }
               }

               var15 = null;
            }

            String var16;
            label2047: {
               label2046: {
                  try {
                     if (var21.isNull(var8)) {
                        break label2046;
                     }
                  } catch (Throwable var288) {
                     var10000 = var288;
                     boolean var301 = false;
                     break label2075;
                  }

                  try {
                     var16 = var21.getText(var8);
                     break label2047;
                  } catch (Throwable var287) {
                     var10000 = var287;
                     boolean var302 = false;
                     break label2075;
                  }
               }

               var16 = null;
            }

            String var17;
            label2038: {
               label2037: {
                  try {
                     if (var21.isNull(var6)) {
                        break label2037;
                     }
                  } catch (Throwable var286) {
                     var10000 = var286;
                     boolean var303 = false;
                     break label2075;
                  }

                  try {
                     var17 = var21.getText(var6);
                     break label2038;
                  } catch (Throwable var285) {
                     var10000 = var285;
                     boolean var304 = false;
                     break label2075;
                  }
               }

               var17 = null;
            }

            String var18;
            label2029: {
               label2028: {
                  try {
                     if (var21.isNull(var12)) {
                        break label2028;
                     }
                  } catch (Throwable var284) {
                     var10000 = var284;
                     boolean var305 = false;
                     break label2075;
                  }

                  try {
                     var18 = var21.getText(var12);
                     break label2029;
                  } catch (Throwable var283) {
                     var10000 = var283;
                     boolean var306 = false;
                     break label2075;
                  }
               }

               var18 = null;
            }

            String var19;
            label2020: {
               label2019: {
                  try {
                     if (var21.isNull(var5)) {
                        break label2019;
                     }
                  } catch (Throwable var282) {
                     var10000 = var282;
                     boolean var307 = false;
                     break label2075;
                  }

                  try {
                     var19 = var21.getText(var5);
                     break label2020;
                  } catch (Throwable var281) {
                     var10000 = var281;
                     boolean var308 = false;
                     break label2075;
                  }
               }

               var19 = null;
            }

            label2011: {
               try {
                  if (var21.isNull(var11)) {
                     break label2011;
                  }
               } catch (Throwable var280) {
                  var10000 = var280;
                  boolean var309 = false;
                  break label2075;
               }

               try {
                  var20 = var21.getText(var11);
               } catch (Throwable var279) {
                  var10000 = var279;
                  boolean var310 = false;
                  break label2075;
               }
            }

            label2004:
            try {
               var294 = new TrackedLocationEntity(var295, var3, var1, var15, var16, var17, var18, var19, var20);
               break label2071;
            } catch (Throwable var278) {
               var10000 = var278;
               boolean var311 = false;
               break label2004;
            }
         }

         Throwable var296 = var10000;
         var21.close();
         throw var296;
      }

      var21.close();
      return var294;
   }

   // $FF: synthetic method
   static List lambda$getLiveTrackedLocations$6(SQLiteConnection var0) {
      SQLiteStatement var21 = var0.prepare("SELECT * from tracked_location_table");

      ArrayList var22;
      label1969: {
         Throwable var10000;
         label1968: {
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            try {
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "id");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "latitude");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "longitude");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "locationName");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "cityName");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "stateName");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryName");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryCode");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "mapType");
               var22 = new ArrayList();
            } catch (Throwable var295) {
               var10000 = var295;
               boolean var10001 = false;
               break label1968;
            }

            while(true) {
               boolean var14;
               try {
                  if (!var21.step()) {
                     break label1969;
                  }

                  var14 = var21.isNull(var9);
               } catch (Throwable var288) {
                  var10000 = var288;
                  boolean var298 = false;
                  break;
               }

               String var20 = null;
               String var296;
               if (var14) {
                  var296 = null;
               } else {
                  try {
                     var296 = var21.getText(var9);
                  } catch (Throwable var287) {
                     var10000 = var287;
                     boolean var299 = false;
                     break;
                  }
               }

               double var1;
               double var3;
               String var15;
               label1962: {
                  label1961: {
                     try {
                        var1 = var21.getDouble(var6);
                        var3 = var21.getDouble(var10);
                        if (var21.isNull(var8)) {
                           break label1961;
                        }
                     } catch (Throwable var294) {
                        var10000 = var294;
                        boolean var300 = false;
                        break;
                     }

                     try {
                        var15 = var21.getText(var8);
                        break label1962;
                     } catch (Throwable var286) {
                        var10000 = var286;
                        boolean var301 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               String var16;
               label1955: {
                  label1954: {
                     try {
                        if (var21.isNull(var12)) {
                           break label1954;
                        }
                     } catch (Throwable var293) {
                        var10000 = var293;
                        boolean var302 = false;
                        break;
                     }

                     try {
                        var16 = var21.getText(var12);
                        break label1955;
                     } catch (Throwable var285) {
                        var10000 = var285;
                        boolean var303 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               String var17;
               label1948: {
                  label1947: {
                     try {
                        if (var21.isNull(var7)) {
                           break label1947;
                        }
                     } catch (Throwable var292) {
                        var10000 = var292;
                        boolean var304 = false;
                        break;
                     }

                     try {
                        var17 = var21.getText(var7);
                        break label1948;
                     } catch (Throwable var284) {
                        var10000 = var284;
                        boolean var305 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               String var18;
               label1941: {
                  label1940: {
                     try {
                        if (var21.isNull(var11)) {
                           break label1940;
                        }
                     } catch (Throwable var291) {
                        var10000 = var291;
                        boolean var306 = false;
                        break;
                     }

                     try {
                        var18 = var21.getText(var11);
                        break label1941;
                     } catch (Throwable var283) {
                        var10000 = var283;
                        boolean var307 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               String var19;
               label1934: {
                  label1933: {
                     try {
                        if (var21.isNull(var5)) {
                           break label1933;
                        }
                     } catch (Throwable var290) {
                        var10000 = var290;
                        boolean var308 = false;
                        break;
                     }

                     try {
                        var19 = var21.getText(var5);
                        break label1934;
                     } catch (Throwable var282) {
                        var10000 = var282;
                        boolean var309 = false;
                        break;
                     }
                  }

                  var19 = null;
               }

               label1927: {
                  try {
                     if (var21.isNull(var13)) {
                        break label1927;
                     }
                  } catch (Throwable var289) {
                     var10000 = var289;
                     boolean var310 = false;
                     break;
                  }

                  try {
                     var20 = var21.getText(var13);
                  } catch (Throwable var281) {
                     var10000 = var281;
                     boolean var311 = false;
                     break;
                  }
               }

               try {
                  TrackedLocationEntity var23 = new TrackedLocationEntity(var296, var1, var3, var15, var16, var17, var18, var19, var20);
                  var22.add(var23);
               } catch (Throwable var280) {
                  var10000 = var280;
                  boolean var312 = false;
                  break;
               }
            }
         }

         Throwable var297 = var10000;
         var21.close();
         throw var297;
      }

      var21.close();
      return var22;
   }

   // $FF: synthetic method
   static TrackedLocationEntity lambda$getTrackedLocation$10(String var0, SQLiteConnection var1) {
      SQLiteStatement var21;
      label2488: {
         Throwable var10000;
         label2490: {
            var21 = var1.prepare("SELECT * from tracked_location_table  WHERE id = ?");
            if (var0 == null) {
               try {
                  var21.bindNull(1);
               } catch (Throwable var363) {
                  var10000 = var363;
                  boolean var10001 = false;
                  break label2490;
               }
            } else {
               try {
                  var21.bindText(1, var0);
               } catch (Throwable var362) {
                  var10000 = var362;
                  boolean var368 = false;
                  break label2490;
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
            boolean var15;
            try {
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "id");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "latitude");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "longitude");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "locationName");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "cityName");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "stateName");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryName");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryCode");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "mapType");
               var15 = var21.step();
            } catch (Throwable var361) {
               var10000 = var361;
               boolean var369 = false;
               break label2490;
            }

            var364 = null;
            String var20 = null;
            if (!var15) {
               break label2488;
            }

            label2476: {
               label2475: {
                  try {
                     if (var21.isNull(var11)) {
                        break label2475;
                     }
                  } catch (Throwable var360) {
                     var10000 = var360;
                     boolean var370 = false;
                     break label2490;
                  }

                  try {
                     var0 = var21.getText(var11);
                     break label2476;
                  } catch (Throwable var359) {
                     var10000 = var359;
                     boolean var371 = false;
                     break label2490;
                  }
               }

               var0 = null;
            }

            double var2;
            double var4;
            label2467: {
               label2466: {
                  try {
                     var2 = var21.getDouble(var8);
                     var4 = var21.getDouble(var6);
                     if (var21.isNull(var14)) {
                        break label2466;
                     }
                  } catch (Throwable var358) {
                     var10000 = var358;
                     boolean var372 = false;
                     break label2490;
                  }

                  try {
                     var367 = var21.getText(var14);
                     break label2467;
                  } catch (Throwable var357) {
                     var10000 = var357;
                     boolean var373 = false;
                     break label2490;
                  }
               }

               var367 = null;
            }

            String var16;
            label2458: {
               label2457: {
                  try {
                     if (var21.isNull(var12)) {
                        break label2457;
                     }
                  } catch (Throwable var356) {
                     var10000 = var356;
                     boolean var374 = false;
                     break label2490;
                  }

                  try {
                     var16 = var21.getText(var12);
                     break label2458;
                  } catch (Throwable var355) {
                     var10000 = var355;
                     boolean var375 = false;
                     break label2490;
                  }
               }

               var16 = null;
            }

            String var17;
            label2449: {
               label2448: {
                  try {
                     if (var21.isNull(var9)) {
                        break label2448;
                     }
                  } catch (Throwable var354) {
                     var10000 = var354;
                     boolean var376 = false;
                     break label2490;
                  }

                  try {
                     var17 = var21.getText(var9);
                     break label2449;
                  } catch (Throwable var353) {
                     var10000 = var353;
                     boolean var377 = false;
                     break label2490;
                  }
               }

               var17 = null;
            }

            String var18;
            label2440: {
               label2439: {
                  try {
                     if (var21.isNull(var10)) {
                        break label2439;
                     }
                  } catch (Throwable var352) {
                     var10000 = var352;
                     boolean var378 = false;
                     break label2490;
                  }

                  try {
                     var18 = var21.getText(var10);
                     break label2440;
                  } catch (Throwable var351) {
                     var10000 = var351;
                     boolean var379 = false;
                     break label2490;
                  }
               }

               var18 = null;
            }

            String var19;
            label2431: {
               label2430: {
                  try {
                     if (var21.isNull(var7)) {
                        break label2430;
                     }
                  } catch (Throwable var350) {
                     var10000 = var350;
                     boolean var380 = false;
                     break label2490;
                  }

                  try {
                     var19 = var21.getText(var7);
                     break label2431;
                  } catch (Throwable var349) {
                     var10000 = var349;
                     boolean var381 = false;
                     break label2490;
                  }
               }

               var19 = null;
            }

            label2422: {
               try {
                  if (var21.isNull(var13)) {
                     break label2422;
                  }
               } catch (Throwable var348) {
                  var10000 = var348;
                  boolean var382 = false;
                  break label2490;
               }

               try {
                  var20 = var21.getText(var13);
               } catch (Throwable var347) {
                  var10000 = var347;
                  boolean var383 = false;
                  break label2490;
               }
            }

            label2415:
            try {
               var364 = new TrackedLocationEntity(var0, var2, var4, var367, var16, var17, var18, var19, var20);
               break label2488;
            } catch (Throwable var346) {
               var10000 = var346;
               boolean var384 = false;
               break label2415;
            }
         }

         Throwable var366 = var10000;
         var21.close();
         throw var366;
      }

      var21.close();
      return var364;
   }

   // $FF: synthetic method
   static List lambda$getTrackedLocations$5(SQLiteConnection var0) {
      SQLiteStatement var21 = var0.prepare("SELECT * from tracked_location_table");

      ArrayList var22;
      label1969: {
         Throwable var10000;
         label1968: {
            int var5;
            int var6;
            int var7;
            int var8;
            int var9;
            int var10;
            int var11;
            int var12;
            int var13;
            try {
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "id");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "latitude");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "longitude");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "locationName");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "cityName");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "stateName");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryName");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryCode");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "mapType");
               var22 = new ArrayList();
            } catch (Throwable var295) {
               var10000 = var295;
               boolean var10001 = false;
               break label1968;
            }

            while(true) {
               boolean var14;
               try {
                  if (!var21.step()) {
                     break label1969;
                  }

                  var14 = var21.isNull(var9);
               } catch (Throwable var288) {
                  var10000 = var288;
                  boolean var298 = false;
                  break;
               }

               String var20 = null;
               String var296;
               if (var14) {
                  var296 = null;
               } else {
                  try {
                     var296 = var21.getText(var9);
                  } catch (Throwable var287) {
                     var10000 = var287;
                     boolean var299 = false;
                     break;
                  }
               }

               double var1;
               double var3;
               String var15;
               label1962: {
                  label1961: {
                     try {
                        var1 = var21.getDouble(var11);
                        var3 = var21.getDouble(var10);
                        if (var21.isNull(var8)) {
                           break label1961;
                        }
                     } catch (Throwable var294) {
                        var10000 = var294;
                        boolean var300 = false;
                        break;
                     }

                     try {
                        var15 = var21.getText(var8);
                        break label1962;
                     } catch (Throwable var286) {
                        var10000 = var286;
                        boolean var301 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               String var16;
               label1955: {
                  label1954: {
                     try {
                        if (var21.isNull(var6)) {
                           break label1954;
                        }
                     } catch (Throwable var293) {
                        var10000 = var293;
                        boolean var302 = false;
                        break;
                     }

                     try {
                        var16 = var21.getText(var6);
                        break label1955;
                     } catch (Throwable var285) {
                        var10000 = var285;
                        boolean var303 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               String var17;
               label1948: {
                  label1947: {
                     try {
                        if (var21.isNull(var13)) {
                           break label1947;
                        }
                     } catch (Throwable var292) {
                        var10000 = var292;
                        boolean var304 = false;
                        break;
                     }

                     try {
                        var17 = var21.getText(var13);
                        break label1948;
                     } catch (Throwable var284) {
                        var10000 = var284;
                        boolean var305 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               String var18;
               label1941: {
                  label1940: {
                     try {
                        if (var21.isNull(var7)) {
                           break label1940;
                        }
                     } catch (Throwable var291) {
                        var10000 = var291;
                        boolean var306 = false;
                        break;
                     }

                     try {
                        var18 = var21.getText(var7);
                        break label1941;
                     } catch (Throwable var283) {
                        var10000 = var283;
                        boolean var307 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               String var19;
               label1934: {
                  label1933: {
                     try {
                        if (var21.isNull(var5)) {
                           break label1933;
                        }
                     } catch (Throwable var290) {
                        var10000 = var290;
                        boolean var308 = false;
                        break;
                     }

                     try {
                        var19 = var21.getText(var5);
                        break label1934;
                     } catch (Throwable var282) {
                        var10000 = var282;
                        boolean var309 = false;
                        break;
                     }
                  }

                  var19 = null;
               }

               label1927: {
                  try {
                     if (var21.isNull(var12)) {
                        break label1927;
                     }
                  } catch (Throwable var289) {
                     var10000 = var289;
                     boolean var310 = false;
                     break;
                  }

                  try {
                     var20 = var21.getText(var12);
                  } catch (Throwable var281) {
                     var10000 = var281;
                     boolean var311 = false;
                     break;
                  }
               }

               try {
                  TrackedLocationEntity var23 = new TrackedLocationEntity(var296, var1, var3, var15, var16, var17, var18, var19, var20);
                  var22.add(var23);
               } catch (Throwable var280) {
                  var10000 = var280;
                  boolean var312 = false;
                  break;
               }
            }
         }

         Throwable var297 = var10000;
         var21.close();
         throw var297;
      }

      var21.close();
      return var22;
   }

   // $FF: synthetic method
   static TrackedLocationEntity lambda$liveTrackedLocation$9(String var0, SQLiteConnection var1) {
      SQLiteStatement var21;
      label2488: {
         Throwable var10000;
         label2490: {
            var21 = var1.prepare("SELECT * from tracked_location_table  WHERE id = ?");
            if (var0 == null) {
               try {
                  var21.bindNull(1);
               } catch (Throwable var363) {
                  var10000 = var363;
                  boolean var10001 = false;
                  break label2490;
               }
            } else {
               try {
                  var21.bindText(1, var0);
               } catch (Throwable var362) {
                  var10000 = var362;
                  boolean var368 = false;
                  break label2490;
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
            boolean var15;
            try {
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "id");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "latitude");
               var14 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "longitude");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "locationName");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "cityName");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "stateName");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryName");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "countryCode");
               var13 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "mapType");
               var15 = var21.step();
            } catch (Throwable var361) {
               var10000 = var361;
               boolean var369 = false;
               break label2490;
            }

            var364 = null;
            String var20 = null;
            if (!var15) {
               break label2488;
            }

            label2476: {
               label2475: {
                  try {
                     if (var21.isNull(var10)) {
                        break label2475;
                     }
                  } catch (Throwable var360) {
                     var10000 = var360;
                     boolean var370 = false;
                     break label2490;
                  }

                  try {
                     var0 = var21.getText(var10);
                     break label2476;
                  } catch (Throwable var359) {
                     var10000 = var359;
                     boolean var371 = false;
                     break label2490;
                  }
               }

               var0 = null;
            }

            double var2;
            double var4;
            label2467: {
               label2466: {
                  try {
                     var4 = var21.getDouble(var12);
                     var2 = var21.getDouble(var14);
                     if (var21.isNull(var11)) {
                        break label2466;
                     }
                  } catch (Throwable var358) {
                     var10000 = var358;
                     boolean var372 = false;
                     break label2490;
                  }

                  try {
                     var367 = var21.getText(var11);
                     break label2467;
                  } catch (Throwable var357) {
                     var10000 = var357;
                     boolean var373 = false;
                     break label2490;
                  }
               }

               var367 = null;
            }

            String var16;
            label2458: {
               label2457: {
                  try {
                     if (var21.isNull(var9)) {
                        break label2457;
                     }
                  } catch (Throwable var356) {
                     var10000 = var356;
                     boolean var374 = false;
                     break label2490;
                  }

                  try {
                     var16 = var21.getText(var9);
                     break label2458;
                  } catch (Throwable var355) {
                     var10000 = var355;
                     boolean var375 = false;
                     break label2490;
                  }
               }

               var16 = null;
            }

            String var17;
            label2449: {
               label2448: {
                  try {
                     if (var21.isNull(var7)) {
                        break label2448;
                     }
                  } catch (Throwable var354) {
                     var10000 = var354;
                     boolean var376 = false;
                     break label2490;
                  }

                  try {
                     var17 = var21.getText(var7);
                     break label2449;
                  } catch (Throwable var353) {
                     var10000 = var353;
                     boolean var377 = false;
                     break label2490;
                  }
               }

               var17 = null;
            }

            String var18;
            label2440: {
               label2439: {
                  try {
                     if (var21.isNull(var8)) {
                        break label2439;
                     }
                  } catch (Throwable var352) {
                     var10000 = var352;
                     boolean var378 = false;
                     break label2490;
                  }

                  try {
                     var18 = var21.getText(var8);
                     break label2440;
                  } catch (Throwable var351) {
                     var10000 = var351;
                     boolean var379 = false;
                     break label2490;
                  }
               }

               var18 = null;
            }

            String var19;
            label2431: {
               label2430: {
                  try {
                     if (var21.isNull(var6)) {
                        break label2430;
                     }
                  } catch (Throwable var350) {
                     var10000 = var350;
                     boolean var380 = false;
                     break label2490;
                  }

                  try {
                     var19 = var21.getText(var6);
                     break label2431;
                  } catch (Throwable var349) {
                     var10000 = var349;
                     boolean var381 = false;
                     break label2490;
                  }
               }

               var19 = null;
            }

            label2422: {
               try {
                  if (var21.isNull(var13)) {
                     break label2422;
                  }
               } catch (Throwable var348) {
                  var10000 = var348;
                  boolean var382 = false;
                  break label2490;
               }

               try {
                  var20 = var21.getText(var13);
               } catch (Throwable var347) {
                  var10000 = var347;
                  boolean var383 = false;
                  break label2490;
               }
            }

            label2415:
            try {
               var364 = new TrackedLocationEntity(var0, var4, var2, var367, var16, var17, var18, var19, var20);
               break label2488;
            } catch (Throwable var346) {
               var10000 = var346;
               boolean var384 = false;
               break label2415;
            }
         }

         Throwable var366 = var10000;
         var21.close();
         throw var366;
      }

      var21.close();
      return var364;
   }

   public Object deleteAll(Continuation var1) {
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda7(), var1);
   }

   public Object deleteTrackedLocation(TrackedLocationEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda2(this, var1), var2);
   }

   public Object deleteTrackedLocation(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda5(var1), var2);
   }

   public Object deleteTrackedLocations(List var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda3(this, var1), var2);
   }

   public void deleteTrackedLocations(List var1) {
      StringBuilder var2 = new StringBuilder();
      var2.append(" DELETE FROM tracked_location_table where id in (");
      StringUtil.appendPlaceholders(var2, var1.size());
      var2.append(")");
      String var3 = var2.toString();
      DBUtil.performBlocking(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda1(var3, var1));
   }

   public TrackedLocationEntity getCurrentLocation() {
      return (TrackedLocationEntity)DBUtil.performBlocking(this.__db, true, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda0());
   }

   public LiveData getLiveCurrentLocation() {
      InvalidationTracker var2 = this.__db.getInvalidationTracker();
      TrackedLocationDao_Impl$$ExternalSyntheticLambda11 var1 = new TrackedLocationDao_Impl$$ExternalSyntheticLambda11();
      return var2.createLiveData(new String[]{"tracked_location_table"}, false, var1);
   }

   public LiveData getLiveTrackedLocations() {
      InvalidationTracker var1 = this.__db.getInvalidationTracker();
      TrackedLocationDao_Impl$$ExternalSyntheticLambda8 var2 = new TrackedLocationDao_Impl$$ExternalSyntheticLambda8();
      return var1.createLiveData(new String[]{"tracked_location_table"}, false, var2);
   }

   public Object getTrackedLocation(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, true, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda6(var1), var2);
   }

   public List getTrackedLocations() {
      return (List)DBUtil.performBlocking(this.__db, true, false, new TrackedLocationDao_Impl$$ExternalSyntheticLambda12());
   }

   public Object insert(TrackedLocationEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda9(this, var1), var2);
   }

   public Object insert(List var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda10(this, var1), var2);
   }

   // $FF: synthetic method
   Unit lambda$deleteTrackedLocation$2$com_blueair_database_dao_TrackedLocationDao_Impl/* $FF was: lambda$deleteTrackedLocation$2$com-blueair-database-dao-TrackedLocationDao_Impl*/(TrackedLocationEntity var1, SQLiteConnection var2) {
      this.__deleteAdapterOfTrackedLocationEntity.handle(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$deleteTrackedLocations$3$com_blueair_database_dao_TrackedLocationDao_Impl/* $FF was: lambda$deleteTrackedLocations$3$com-blueair-database-dao-TrackedLocationDao_Impl*/(List var1, SQLiteConnection var2) {
      this.__deleteAdapterOfTrackedLocationEntity.handleMultiple(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$insert$0$com_blueair_database_dao_TrackedLocationDao_Impl/* $FF was: lambda$insert$0$com-blueair-database-dao-TrackedLocationDao_Impl*/(TrackedLocationEntity var1, SQLiteConnection var2) {
      this.__insertAdapterOfTrackedLocationEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$insert$1$com_blueair_database_dao_TrackedLocationDao_Impl/* $FF was: lambda$insert$1$com-blueair-database-dao-TrackedLocationDao_Impl*/(List var1, SQLiteConnection var2) {
      this.__insertAdapterOfTrackedLocationEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Integer lambda$update$4$com_blueair_database_dao_TrackedLocationDao_Impl/* $FF was: lambda$update$4$com-blueair-database-dao-TrackedLocationDao_Impl*/(TrackedLocationEntity var1, SQLiteConnection var2) {
      return this.__updateAdapterOfTrackedLocationEntity.handle(var2, var1);
   }

   public LiveData liveTrackedLocation(String var1) {
      InvalidationTracker var2 = this.__db.getInvalidationTracker();
      TrackedLocationDao_Impl$$ExternalSyntheticLambda4 var3 = new TrackedLocationDao_Impl$$ExternalSyntheticLambda4(var1);
      return var2.createLiveData(new String[]{"tracked_location_table"}, false, var3);
   }

   public Object update(TrackedLocationEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new TrackedLocationDao_Impl$$ExternalSyntheticLambda13(this, var1), var2);
   }
}
