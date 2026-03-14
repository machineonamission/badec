package com.blueair.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.blueair.database.DayOfWeekConverter;
import com.blueair.database.DeviceScheduleInstructionsConverter;
import com.blueair.database.entity.DeviceScheduleEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

public final class DeviceScheduleDao_Impl implements DeviceScheduleDao {
   private final RoomDatabase __db;
   private final EntityInsertAdapter __insertAdapterOfDeviceScheduleEntity;

   public DeviceScheduleDao_Impl(RoomDatabase var1) {
      this.__db = var1;
      this.__insertAdapterOfDeviceScheduleEntity = new EntityInsertAdapter(this) {
         final DeviceScheduleDao_Impl this$0;

         {
            this.this$0 = var1;
         }

         protected void bind(SQLiteStatement var1, DeviceScheduleEntity var2) {
            if (var2.getDeviceId() == null) {
               var1.bindNull(1);
            } else {
               var1.bindText(1, var2.getDeviceId());
            }

            if (var2.getScheduleId() == null) {
               var1.bindNull(2);
            } else {
               var1.bindText(2, var2.getScheduleId());
            }

            if (var2.getScheduleName() == null) {
               var1.bindNull(3);
            } else {
               var1.bindText(3, var2.getScheduleName());
            }

            if (var2.getStartTime() == null) {
               var1.bindNull(4);
            } else {
               var1.bindText(4, var2.getStartTime());
            }

            if (var2.getEndTime() == null) {
               var1.bindNull(5);
            } else {
               var1.bindText(5, var2.getEndTime());
            }

            String var3 = DeviceScheduleInstructionsConverter.listToJson(var2.getInstructions());
            if (var3 == null) {
               var1.bindNull(6);
            } else {
               var1.bindText(6, var3);
            }

            var1.bindLong(7, (long)var2.getPaused());
            var3 = DayOfWeekConverter.listToJson(var2.getDaysOfWeek());
            if (var3 == null) {
               var1.bindNull(8);
            } else {
               var1.bindText(8, var3);
            }

            if (var2.getTimeZone() == null) {
               var1.bindNull(9);
            } else {
               var1.bindText(9, var2.getTimeZone());
            }

            var3 = DeviceScheduleInstructionsConverter.listToJson(var2.getEndInstructions());
            if (var3 == null) {
               var1.bindNull(10);
            } else {
               var1.bindText(10, var3);
            }

            if (var2.getScheduleEndType() == null) {
               var1.bindNull(11);
            } else {
               var1.bindText(11, var2.getScheduleEndType());
            }
         }

         protected String createQuery() {
            return "INSERT OR REPLACE INTO `device_schedule_table` (`deviceId`,`scheduleId`,`scheduleName`,`startTime`,`endTime`,`instructions`,`paused`,`daysOfWeek`,`timeZone`,`endInstructions`,`scheduleEndType`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
         }
      };
   }

   public static List getRequiredConverters() {
      return Collections.EMPTY_LIST;
   }

   // $FF: synthetic method
   static Integer lambda$delete$6(String var0, SQLiteConnection var1) {
      int var2;
      SQLiteStatement var3;
      label99: {
         Throwable var10000;
         label98: {
            var3 = var1.prepare("DELETE FROM device_schedule_table WHERE scheduleId = ?");
            if (var0 == null) {
               try {
                  var3.bindNull(1);
               } catch (Throwable var15) {
                  var10000 = var15;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var3.bindText(1, var0);
               } catch (Throwable var14) {
                  var10000 = var14;
                  boolean var17 = false;
                  break label98;
               }
            }

            label92:
            try {
               var3.step();
               var2 = SQLiteConnectionUtil.getTotalChangedRows(var1);
               break label99;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var18 = false;
               break label92;
            }
         }

         Throwable var16 = var10000;
         var3.close();
         throw var16;
      }

      var3.close();
      return var2;
   }

   // $FF: synthetic method
   static Integer lambda$deleteAll$8(SQLiteConnection var0) {
      SQLiteStatement var2 = var0.prepare("DELETE FROM device_schedule_table");

      int var1;
      try {
         var2.step();
         var1 = SQLiteConnectionUtil.getTotalChangedRows(var0);
      } finally {
         var2.close();
      }

      return var1;
   }

   // $FF: synthetic method
   static Integer lambda$deleteAllForDevice$7(String var0, SQLiteConnection var1) {
      int var2;
      SQLiteStatement var3;
      label99: {
         Throwable var10000;
         label98: {
            var3 = var1.prepare("DELETE FROM device_schedule_table WHERE deviceId = ?");
            if (var0 == null) {
               try {
                  var3.bindNull(1);
               } catch (Throwable var15) {
                  var10000 = var15;
                  boolean var10001 = false;
                  break label98;
               }
            } else {
               try {
                  var3.bindText(1, var0);
               } catch (Throwable var14) {
                  var10000 = var14;
                  boolean var17 = false;
                  break label98;
               }
            }

            label92:
            try {
               var3.step();
               var2 = SQLiteConnectionUtil.getTotalChangedRows(var1);
               break label99;
            } catch (Throwable var13) {
               var10000 = var13;
               boolean var18 = false;
               break label92;
            }
         }

         Throwable var16 = var10000;
         var3.close();
         throw var16;
      }

      var3.close();
      return var2;
   }

   // $FF: synthetic method
   static List lambda$getAll$5(SQLiteConnection var0) {
      SQLiteStatement var19 = var0.prepare("SELECT * from device_schedule_table");

      ArrayList var20;
      label4052: {
         Throwable var10000;
         label4051: {
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
            try {
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "deviceId");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "scheduleId");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "scheduleName");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "startTime");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "endTime");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "instructions");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "paused");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "daysOfWeek");
               var1 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "timeZone");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "endInstructions");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "scheduleEndType");
               var20 = new ArrayList();
            } catch (Throwable var576) {
               var10000 = var576;
               boolean var10001 = false;
               break label4051;
            }

            while(true) {
               label4046: {
                  label4045: {
                     try {
                        if (!var19.step()) {
                           break label4052;
                        }

                        if (var19.isNull(var3)) {
                           break label4045;
                        }
                     } catch (Throwable var575) {
                        var10000 = var575;
                        boolean var582 = false;
                        break;
                     }

                     try {
                        var577 = var19.getText(var3);
                        break label4046;
                     } catch (Throwable var564) {
                        var10000 = var564;
                        boolean var583 = false;
                        break;
                     }
                  }

                  var577 = null;
               }

               String var13;
               label4038: {
                  label4037: {
                     try {
                        if (var19.isNull(var6)) {
                           break label4037;
                        }
                     } catch (Throwable var574) {
                        var10000 = var574;
                        boolean var584 = false;
                        break;
                     }

                     try {
                        var13 = var19.getText(var6);
                        break label4038;
                     } catch (Throwable var563) {
                        var10000 = var563;
                        boolean var585 = false;
                        break;
                     }
                  }

                  var13 = null;
               }

               String var14;
               label4031: {
                  label4030: {
                     try {
                        if (var19.isNull(var7)) {
                           break label4030;
                        }
                     } catch (Throwable var573) {
                        var10000 = var573;
                        boolean var586 = false;
                        break;
                     }

                     try {
                        var14 = var19.getText(var7);
                        break label4031;
                     } catch (Throwable var562) {
                        var10000 = var562;
                        boolean var587 = false;
                        break;
                     }
                  }

                  var14 = null;
               }

               String var15;
               label4024: {
                  label4023: {
                     try {
                        if (var19.isNull(var2)) {
                           break label4023;
                        }
                     } catch (Throwable var572) {
                        var10000 = var572;
                        boolean var588 = false;
                        break;
                     }

                     try {
                        var15 = var19.getText(var2);
                        break label4024;
                     } catch (Throwable var561) {
                        var10000 = var561;
                        boolean var589 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               String var16;
               label4017: {
                  label4016: {
                     try {
                        if (var19.isNull(var8)) {
                           break label4016;
                        }
                     } catch (Throwable var571) {
                        var10000 = var571;
                        boolean var590 = false;
                        break;
                     }

                     try {
                        var16 = var19.getText(var8);
                        break label4017;
                     } catch (Throwable var560) {
                        var10000 = var560;
                        boolean var591 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               String var17;
               label4010: {
                  label4009: {
                     try {
                        if (var19.isNull(var4)) {
                           break label4009;
                        }
                     } catch (Throwable var570) {
                        var10000 = var570;
                        boolean var592 = false;
                        break;
                     }

                     try {
                        var17 = var19.getText(var4);
                        break label4010;
                     } catch (Throwable var559) {
                        var10000 = var559;
                        boolean var593 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               boolean var12;
               List var21;
               label4003: {
                  label4002: {
                     try {
                        var21 = DeviceScheduleInstructionsConverter.jsonToList(var17);
                        if ((int)var19.getLong(var5) != 0) {
                           break label4002;
                        }
                     } catch (Throwable var569) {
                        var10000 = var569;
                        boolean var594 = false;
                        break;
                     }

                     var12 = false;
                     break label4003;
                  }

                  var12 = true;
               }

               label3996: {
                  label3995: {
                     try {
                        if (var19.isNull(var10)) {
                           break label3995;
                        }
                     } catch (Throwable var568) {
                        var10000 = var568;
                        boolean var595 = false;
                        break;
                     }

                     try {
                        var17 = var19.getText(var10);
                        break label3996;
                     } catch (Throwable var558) {
                        var10000 = var558;
                        boolean var596 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               Set var22;
               label3989: {
                  label3988: {
                     try {
                        var22 = DayOfWeekConverter.jsonToSet(var17);
                        if (var19.isNull(var1)) {
                           break label3988;
                        }
                     } catch (Throwable var567) {
                        var10000 = var567;
                        boolean var597 = false;
                        break;
                     }

                     try {
                        var17 = var19.getText(var1);
                        break label3989;
                     } catch (Throwable var557) {
                        var10000 = var557;
                        boolean var598 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               String var18;
               label3982: {
                  label3981: {
                     try {
                        if (var19.isNull(var9)) {
                           break label3981;
                        }
                     } catch (Throwable var566) {
                        var10000 = var566;
                        boolean var599 = false;
                        break;
                     }

                     try {
                        var18 = var19.getText(var9);
                        break label3982;
                     } catch (Throwable var556) {
                        var10000 = var556;
                        boolean var600 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               List var23;
               label3975: {
                  label3974: {
                     try {
                        var23 = DeviceScheduleInstructionsConverter.jsonToList(var18);
                        if (var19.isNull(var11)) {
                           break label3974;
                        }
                     } catch (Throwable var565) {
                        var10000 = var565;
                        boolean var601 = false;
                        break;
                     }

                     try {
                        var18 = var19.getText(var11);
                        break label3975;
                     } catch (Throwable var555) {
                        var10000 = var555;
                        boolean var602 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               try {
                  DeviceScheduleEntity var24 = new DeviceScheduleEntity(var577, var13, var14, var15, var16, var21, var12, var22, var17, var23, var18);
                  var20.add(var24);
               } catch (Throwable var554) {
                  var10000 = var554;
                  boolean var603 = false;
                  break;
               }
            }
         }

         Throwable var578 = var10000;
         var19.close();
         throw var578;
      }

      var19.close();
      return var20;
   }

   // $FF: synthetic method
   static List lambda$getByDeviceId$4(String var0, SQLiteConnection var1) {
      SQLiteStatement var20;
      ArrayList var21;
      label4601: {
         Throwable var10000;
         label4603: {
            var20 = var1.prepare("SELECT * FROM device_schedule_table WHERE deviceId = ?");
            if (var0 == null) {
               try {
                  var20.bindNull(1);
               } catch (Throwable var674) {
                  var10000 = var674;
                  boolean var10001 = false;
                  break label4603;
               }
            } else {
               try {
                  var20.bindText(1, var0);
               } catch (Throwable var673) {
                  var10000 = var673;
                  boolean var683 = false;
                  break label4603;
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
            try {
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "deviceId");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "scheduleId");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "scheduleName");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "startTime");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "endTime");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "instructions");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "paused");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "daysOfWeek");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "timeZone");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "endInstructions");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var20, "scheduleEndType");
               var21 = new ArrayList();
            } catch (Throwable var672) {
               var10000 = var672;
               boolean var684 = false;
               break label4603;
            }

            while(true) {
               boolean var13;
               try {
                  if (!var20.step()) {
                     break label4601;
                  }

                  var13 = var20.isNull(var11);
               } catch (Throwable var661) {
                  var10000 = var661;
                  boolean var685 = false;
                  break;
               }

               Object var19 = null;
               if (var13) {
                  var0 = null;
               } else {
                  try {
                     var0 = var20.getText(var11);
                  } catch (Throwable var660) {
                     var10000 = var660;
                     boolean var686 = false;
                     break;
                  }
               }

               label4588: {
                  label4587: {
                     try {
                        if (var20.isNull(var2)) {
                           break label4587;
                        }
                     } catch (Throwable var671) {
                        var10000 = var671;
                        boolean var687 = false;
                        break;
                     }

                     try {
                        var677 = var20.getText(var2);
                        break label4588;
                     } catch (Throwable var659) {
                        var10000 = var659;
                        boolean var688 = false;
                        break;
                     }
                  }

                  var677 = null;
               }

               String var14;
               label4581: {
                  label4580: {
                     try {
                        if (var20.isNull(var7)) {
                           break label4580;
                        }
                     } catch (Throwable var670) {
                        var10000 = var670;
                        boolean var689 = false;
                        break;
                     }

                     try {
                        var14 = var20.getText(var7);
                        break label4581;
                     } catch (Throwable var658) {
                        var10000 = var658;
                        boolean var690 = false;
                        break;
                     }
                  }

                  var14 = null;
               }

               String var15;
               label4574: {
                  label4573: {
                     try {
                        if (var20.isNull(var9)) {
                           break label4573;
                        }
                     } catch (Throwable var669) {
                        var10000 = var669;
                        boolean var691 = false;
                        break;
                     }

                     try {
                        var15 = var20.getText(var9);
                        break label4574;
                     } catch (Throwable var657) {
                        var10000 = var657;
                        boolean var692 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               String var16;
               label4567: {
                  label4566: {
                     try {
                        if (var20.isNull(var6)) {
                           break label4566;
                        }
                     } catch (Throwable var668) {
                        var10000 = var668;
                        boolean var693 = false;
                        break;
                     }

                     try {
                        var16 = var20.getText(var6);
                        break label4567;
                     } catch (Throwable var656) {
                        var10000 = var656;
                        boolean var694 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               String var17;
               label4560: {
                  label4559: {
                     try {
                        if (var20.isNull(var8)) {
                           break label4559;
                        }
                     } catch (Throwable var667) {
                        var10000 = var667;
                        boolean var695 = false;
                        break;
                     }

                     try {
                        var17 = var20.getText(var8);
                        break label4560;
                     } catch (Throwable var655) {
                        var10000 = var655;
                        boolean var696 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               List var22;
               label4553: {
                  label4552: {
                     try {
                        var22 = DeviceScheduleInstructionsConverter.jsonToList(var17);
                        if ((int)var20.getLong(var4) != 0) {
                           break label4552;
                        }
                     } catch (Throwable var666) {
                        var10000 = var666;
                        boolean var697 = false;
                        break;
                     }

                     var13 = false;
                     break label4553;
                  }

                  var13 = true;
               }

               label4546: {
                  label4545: {
                     try {
                        if (var20.isNull(var10)) {
                           break label4545;
                        }
                     } catch (Throwable var665) {
                        var10000 = var665;
                        boolean var698 = false;
                        break;
                     }

                     try {
                        var17 = var20.getText(var10);
                        break label4546;
                     } catch (Throwable var654) {
                        var10000 = var654;
                        boolean var699 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               Set var23;
               label4539: {
                  label4538: {
                     try {
                        var23 = DayOfWeekConverter.jsonToSet(var17);
                        if (var20.isNull(var5)) {
                           break label4538;
                        }
                     } catch (Throwable var664) {
                        var10000 = var664;
                        boolean var700 = false;
                        break;
                     }

                     try {
                        var17 = var20.getText(var5);
                        break label4539;
                     } catch (Throwable var653) {
                        var10000 = var653;
                        boolean var701 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               String var18;
               label4532: {
                  label4531: {
                     try {
                        if (var20.isNull(var12)) {
                           break label4531;
                        }
                     } catch (Throwable var663) {
                        var10000 = var663;
                        boolean var702 = false;
                        break;
                     }

                     try {
                        var18 = var20.getText(var12);
                        break label4532;
                     } catch (Throwable var652) {
                        var10000 = var652;
                        boolean var703 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               List var24;
               label4525: {
                  label4524: {
                     try {
                        var24 = DeviceScheduleInstructionsConverter.jsonToList(var18);
                        if (var20.isNull(var3)) {
                           break label4524;
                        }
                     } catch (Throwable var662) {
                        var10000 = var662;
                        boolean var704 = false;
                        break;
                     }

                     try {
                        var18 = var20.getText(var3);
                        break label4525;
                     } catch (Throwable var651) {
                        var10000 = var651;
                        boolean var705 = false;
                        break;
                     }
                  }

                  var18 = (String)var19;
               }

               try {
                  DeviceScheduleEntity var682 = new DeviceScheduleEntity(var0, var677, var14, var15, var16, var22, var13, var23, var17, var24, var18);
                  var21.add(var682);
               } catch (Throwable var650) {
                  var10000 = var650;
                  boolean var706 = false;
                  break;
               }
            }
         }

         Throwable var676 = var10000;
         var20.close();
         throw var676;
      }

      var20.close();
      return var21;
   }

   // $FF: synthetic method
   static DeviceScheduleEntity lambda$getByScheduleId$3(String var0, SQLiteConnection var1) {
      SQLiteStatement var21;
      label4836: {
         Throwable var10000;
         label4839: {
            var21 = var1.prepare("SELECT * from device_schedule_table WHERE scheduleId = ?");
            boolean var13 = true;
            if (var0 == null) {
               try {
                  var21.bindNull(1);
               } catch (Throwable var674) {
                  var10000 = var674;
                  boolean var10001 = false;
                  break label4839;
               }
            } else {
               try {
                  var21.bindText(1, var0);
               } catch (Throwable var673) {
                  var10000 = var673;
                  boolean var682 = false;
                  break label4839;
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
            boolean var14;
            try {
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "deviceId");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "scheduleId");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "scheduleName");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "startTime");
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "endTime");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "instructions");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "paused");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "daysOfWeek");
               var12 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "timeZone");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "endInstructions");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var21, "scheduleEndType");
               var14 = var21.step();
            } catch (Throwable var672) {
               var10000 = var672;
               boolean var683 = false;
               break label4839;
            }

            var675 = null;
            Object var20 = null;
            if (!var14) {
               break label4836;
            }

            label4824: {
               label4823: {
                  try {
                     if (var21.isNull(var10)) {
                        break label4823;
                     }
                  } catch (Throwable var671) {
                     var10000 = var671;
                     boolean var684 = false;
                     break label4839;
                  }

                  try {
                     var0 = var21.getText(var10);
                     break label4824;
                  } catch (Throwable var670) {
                     var10000 = var670;
                     boolean var685 = false;
                     break label4839;
                  }
               }

               var0 = null;
            }

            label4815: {
               label4814: {
                  try {
                     if (var21.isNull(var3)) {
                        break label4814;
                     }
                  } catch (Throwable var669) {
                     var10000 = var669;
                     boolean var686 = false;
                     break label4839;
                  }

                  try {
                     var678 = var21.getText(var3);
                     break label4815;
                  } catch (Throwable var668) {
                     var10000 = var668;
                     boolean var687 = false;
                     break label4839;
                  }
               }

               var678 = null;
            }

            String var15;
            label4806: {
               label4805: {
                  try {
                     if (var21.isNull(var2)) {
                        break label4805;
                     }
                  } catch (Throwable var667) {
                     var10000 = var667;
                     boolean var688 = false;
                     break label4839;
                  }

                  try {
                     var15 = var21.getText(var2);
                     break label4806;
                  } catch (Throwable var666) {
                     var10000 = var666;
                     boolean var689 = false;
                     break label4839;
                  }
               }

               var15 = null;
            }

            String var16;
            label4797: {
               label4796: {
                  try {
                     if (var21.isNull(var5)) {
                        break label4796;
                     }
                  } catch (Throwable var665) {
                     var10000 = var665;
                     boolean var690 = false;
                     break label4839;
                  }

                  try {
                     var16 = var21.getText(var5);
                     break label4797;
                  } catch (Throwable var664) {
                     var10000 = var664;
                     boolean var691 = false;
                     break label4839;
                  }
               }

               var16 = null;
            }

            String var17;
            label4788: {
               label4787: {
                  try {
                     if (var21.isNull(var11)) {
                        break label4787;
                     }
                  } catch (Throwable var663) {
                     var10000 = var663;
                     boolean var692 = false;
                     break label4839;
                  }

                  try {
                     var17 = var21.getText(var11);
                     break label4788;
                  } catch (Throwable var662) {
                     var10000 = var662;
                     boolean var693 = false;
                     break label4839;
                  }
               }

               var17 = null;
            }

            String var18;
            label4779: {
               label4778: {
                  try {
                     if (var21.isNull(var7)) {
                        break label4778;
                     }
                  } catch (Throwable var661) {
                     var10000 = var661;
                     boolean var694 = false;
                     break label4839;
                  }

                  try {
                     var18 = var21.getText(var7);
                     break label4779;
                  } catch (Throwable var660) {
                     var10000 = var660;
                     boolean var695 = false;
                     break label4839;
                  }
               }

               var18 = null;
            }

            List var22;
            label4769: {
               try {
                  var22 = DeviceScheduleInstructionsConverter.jsonToList(var18);
                  if ((int)var21.getLong(var8) != 0) {
                     break label4769;
                  }
               } catch (Throwable var659) {
                  var10000 = var659;
                  boolean var696 = false;
                  break label4839;
               }

               var13 = false;
            }

            label4762: {
               label4761: {
                  try {
                     if (var21.isNull(var9)) {
                        break label4761;
                     }
                  } catch (Throwable var658) {
                     var10000 = var658;
                     boolean var697 = false;
                     break label4839;
                  }

                  try {
                     var18 = var21.getText(var9);
                     break label4762;
                  } catch (Throwable var657) {
                     var10000 = var657;
                     boolean var698 = false;
                     break label4839;
                  }
               }

               var18 = null;
            }

            Set var23;
            label4753: {
               label4752: {
                  try {
                     var23 = DayOfWeekConverter.jsonToSet(var18);
                     if (var21.isNull(var12)) {
                        break label4752;
                     }
                  } catch (Throwable var656) {
                     var10000 = var656;
                     boolean var699 = false;
                     break label4839;
                  }

                  try {
                     var18 = var21.getText(var12);
                     break label4753;
                  } catch (Throwable var655) {
                     var10000 = var655;
                     boolean var700 = false;
                     break label4839;
                  }
               }

               var18 = null;
            }

            String var19;
            label4744: {
               label4743: {
                  try {
                     if (var21.isNull(var6)) {
                        break label4743;
                     }
                  } catch (Throwable var654) {
                     var10000 = var654;
                     boolean var701 = false;
                     break label4839;
                  }

                  try {
                     var19 = var21.getText(var6);
                     break label4744;
                  } catch (Throwable var653) {
                     var10000 = var653;
                     boolean var702 = false;
                     break label4839;
                  }
               }

               var19 = null;
            }

            List var24;
            label4735: {
               label4734: {
                  try {
                     var24 = DeviceScheduleInstructionsConverter.jsonToList(var19);
                     if (var21.isNull(var4)) {
                        break label4734;
                     }
                  } catch (Throwable var652) {
                     var10000 = var652;
                     boolean var703 = false;
                     break label4839;
                  }

                  try {
                     var19 = var21.getText(var4);
                     break label4735;
                  } catch (Throwable var651) {
                     var10000 = var651;
                     boolean var704 = false;
                     break label4839;
                  }
               }

               var19 = (String)var20;
            }

            label4727:
            try {
               var675 = new DeviceScheduleEntity(var0, var678, var15, var16, var17, var22, var13, var23, var18, var24, var19);
               break label4836;
            } catch (Throwable var650) {
               var10000 = var650;
               boolean var705 = false;
               break label4727;
            }
         }

         Throwable var677 = var10000;
         var21.close();
         throw var677;
      }

      var21.close();
      return var675;
   }

   // $FF: synthetic method
   static List lambda$getLiveSchedules$2(SQLiteConnection var0) {
      SQLiteStatement var19 = var0.prepare("SELECT * from device_schedule_table");

      ArrayList var20;
      label4052: {
         Throwable var10000;
         label4051: {
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
            try {
               var11 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "deviceId");
               var4 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "scheduleId");
               var9 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "scheduleName");
               var2 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "startTime");
               var8 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "endTime");
               var1 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "instructions");
               var3 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "paused");
               var5 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "daysOfWeek");
               var10 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "timeZone");
               var7 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "endInstructions");
               var6 = SQLiteStatementUtil.getColumnIndexOrThrow(var19, "scheduleEndType");
               var20 = new ArrayList();
            } catch (Throwable var576) {
               var10000 = var576;
               boolean var10001 = false;
               break label4051;
            }

            while(true) {
               label4046: {
                  label4045: {
                     try {
                        if (!var19.step()) {
                           break label4052;
                        }

                        if (var19.isNull(var11)) {
                           break label4045;
                        }
                     } catch (Throwable var575) {
                        var10000 = var575;
                        boolean var582 = false;
                        break;
                     }

                     try {
                        var577 = var19.getText(var11);
                        break label4046;
                     } catch (Throwable var564) {
                        var10000 = var564;
                        boolean var583 = false;
                        break;
                     }
                  }

                  var577 = null;
               }

               String var13;
               label4038: {
                  label4037: {
                     try {
                        if (var19.isNull(var4)) {
                           break label4037;
                        }
                     } catch (Throwable var574) {
                        var10000 = var574;
                        boolean var584 = false;
                        break;
                     }

                     try {
                        var13 = var19.getText(var4);
                        break label4038;
                     } catch (Throwable var563) {
                        var10000 = var563;
                        boolean var585 = false;
                        break;
                     }
                  }

                  var13 = null;
               }

               String var14;
               label4031: {
                  label4030: {
                     try {
                        if (var19.isNull(var9)) {
                           break label4030;
                        }
                     } catch (Throwable var573) {
                        var10000 = var573;
                        boolean var586 = false;
                        break;
                     }

                     try {
                        var14 = var19.getText(var9);
                        break label4031;
                     } catch (Throwable var562) {
                        var10000 = var562;
                        boolean var587 = false;
                        break;
                     }
                  }

                  var14 = null;
               }

               String var15;
               label4024: {
                  label4023: {
                     try {
                        if (var19.isNull(var2)) {
                           break label4023;
                        }
                     } catch (Throwable var572) {
                        var10000 = var572;
                        boolean var588 = false;
                        break;
                     }

                     try {
                        var15 = var19.getText(var2);
                        break label4024;
                     } catch (Throwable var561) {
                        var10000 = var561;
                        boolean var589 = false;
                        break;
                     }
                  }

                  var15 = null;
               }

               String var16;
               label4017: {
                  label4016: {
                     try {
                        if (var19.isNull(var8)) {
                           break label4016;
                        }
                     } catch (Throwable var571) {
                        var10000 = var571;
                        boolean var590 = false;
                        break;
                     }

                     try {
                        var16 = var19.getText(var8);
                        break label4017;
                     } catch (Throwable var560) {
                        var10000 = var560;
                        boolean var591 = false;
                        break;
                     }
                  }

                  var16 = null;
               }

               String var17;
               label4010: {
                  label4009: {
                     try {
                        if (var19.isNull(var1)) {
                           break label4009;
                        }
                     } catch (Throwable var570) {
                        var10000 = var570;
                        boolean var592 = false;
                        break;
                     }

                     try {
                        var17 = var19.getText(var1);
                        break label4010;
                     } catch (Throwable var559) {
                        var10000 = var559;
                        boolean var593 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               boolean var12;
               List var21;
               label4003: {
                  label4002: {
                     try {
                        var21 = DeviceScheduleInstructionsConverter.jsonToList(var17);
                        if ((int)var19.getLong(var3) != 0) {
                           break label4002;
                        }
                     } catch (Throwable var569) {
                        var10000 = var569;
                        boolean var594 = false;
                        break;
                     }

                     var12 = false;
                     break label4003;
                  }

                  var12 = true;
               }

               label3996: {
                  label3995: {
                     try {
                        if (var19.isNull(var5)) {
                           break label3995;
                        }
                     } catch (Throwable var568) {
                        var10000 = var568;
                        boolean var595 = false;
                        break;
                     }

                     try {
                        var17 = var19.getText(var5);
                        break label3996;
                     } catch (Throwable var558) {
                        var10000 = var558;
                        boolean var596 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               Set var22;
               label3989: {
                  label3988: {
                     try {
                        var22 = DayOfWeekConverter.jsonToSet(var17);
                        if (var19.isNull(var10)) {
                           break label3988;
                        }
                     } catch (Throwable var567) {
                        var10000 = var567;
                        boolean var597 = false;
                        break;
                     }

                     try {
                        var17 = var19.getText(var10);
                        break label3989;
                     } catch (Throwable var557) {
                        var10000 = var557;
                        boolean var598 = false;
                        break;
                     }
                  }

                  var17 = null;
               }

               String var18;
               label3982: {
                  label3981: {
                     try {
                        if (var19.isNull(var7)) {
                           break label3981;
                        }
                     } catch (Throwable var566) {
                        var10000 = var566;
                        boolean var599 = false;
                        break;
                     }

                     try {
                        var18 = var19.getText(var7);
                        break label3982;
                     } catch (Throwable var556) {
                        var10000 = var556;
                        boolean var600 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               List var23;
               label3975: {
                  label3974: {
                     try {
                        var23 = DeviceScheduleInstructionsConverter.jsonToList(var18);
                        if (var19.isNull(var6)) {
                           break label3974;
                        }
                     } catch (Throwable var565) {
                        var10000 = var565;
                        boolean var601 = false;
                        break;
                     }

                     try {
                        var18 = var19.getText(var6);
                        break label3975;
                     } catch (Throwable var555) {
                        var10000 = var555;
                        boolean var602 = false;
                        break;
                     }
                  }

                  var18 = null;
               }

               try {
                  DeviceScheduleEntity var24 = new DeviceScheduleEntity(var577, var13, var14, var15, var16, var21, var12, var22, var17, var23, var18);
                  var20.add(var24);
               } catch (Throwable var554) {
                  var10000 = var554;
                  boolean var603 = false;
                  break;
               }
            }
         }

         Throwable var578 = var10000;
         var19.close();
         throw var578;
      }

      var19.close();
      return var20;
   }

   public Object delete(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda0(var1), var2);
   }

   public int deleteAll() {
      return (Integer)DBUtil.performBlocking(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda8());
   }

   public Object deleteAllForDevice(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda6(var1), var2);
   }

   public Object getAll(Continuation var1) {
      return DBUtil.performSuspending(this.__db, true, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda2(), var1);
   }

   public Object getByDeviceId(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, true, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda1(var1), var2);
   }

   public Object getByScheduleId(String var1, Continuation var2) {
      return DBUtil.performSuspending(this.__db, true, false, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda4(var1), var2);
   }

   public LiveData getLiveSchedules() {
      InvalidationTracker var1 = this.__db.getInvalidationTracker();
      DeviceScheduleDao_Impl$$ExternalSyntheticLambda7 var2 = new DeviceScheduleDao_Impl$$ExternalSyntheticLambda7();
      return var1.createLiveData(new String[]{"device_schedule_table"}, false, var2);
   }

   public Object insert(List var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda5(this, var1), var2);
   }

   // $FF: synthetic method
   Unit lambda$insert$0$com_blueair_database_dao_DeviceScheduleDao_Impl/* $FF was: lambda$insert$0$com-blueair-database-dao-DeviceScheduleDao_Impl*/(List var1, SQLiteConnection var2) {
      this.__insertAdapterOfDeviceScheduleEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }

   // $FF: synthetic method
   Unit lambda$update$1$com_blueair_database_dao_DeviceScheduleDao_Impl/* $FF was: lambda$update$1$com-blueair-database-dao-DeviceScheduleDao_Impl*/(DeviceScheduleEntity var1, SQLiteConnection var2) {
      this.__insertAdapterOfDeviceScheduleEntity.insert(var2, var1);
      return Unit.INSTANCE;
   }

   public Object update(DeviceScheduleEntity var1, Continuation var2) {
      var1.getClass();
      return DBUtil.performSuspending(this.__db, false, true, new DeviceScheduleDao_Impl$$ExternalSyntheticLambda3(this, var1), var2);
   }
}
