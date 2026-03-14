package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDevicePCreateEditScheduleBinding implements ViewBinding {
   public final ImageButton backBtn;
   public final View bottomSpace;
   public final CheckBox cbFri;
   public final CheckBox cbMon;
   public final CheckBox cbSat;
   public final CheckBox cbSun;
   public final CheckBox cbThu;
   public final CheckBox cbTue;
   public final CheckBox cbWed;
   public final ConstraintLayout contentContainer;
   public final ConstraintLayout contentContainerActive;
   public final ConstraintLayout daysList;
   public final MaterialButton deleteBtn;
   public final Guideline endGuideline;
   public final LinearLayout endTimeGroup;
   public final TextView endTimeValue;
   public final ConstraintLayout nestedContentContainer;
   public final ProgressBlockerView progressView;
   private final FrameLayout rootView;
   public final RecyclerView rvEndMode;
   public final RecyclerView rvStartMode;
   public final MaterialButton saveBtn;
   public final EditText scheduleName;
   public final TextView scheduleRepeat;
   public final SwitchCompat scheduleSwitchBtn;
   public final TextView setDays;
   public final TextView setName;
   public final TextView setTime;
   public final Guideline startGuideline;
   public final LinearLayout startTimeGroup;
   public final TextView startTimeValue;
   public final TextView timezoneLabel;
   public final TextView timezoneValue;
   public final TextView title;
   public final TextView tvEndMode;
   public final TextView tvStartMode;

   private DialogfragmentDevicePCreateEditScheduleBinding(FrameLayout var1, ImageButton var2, View var3, CheckBox var4, CheckBox var5, CheckBox var6, CheckBox var7, CheckBox var8, CheckBox var9, CheckBox var10, ConstraintLayout var11, ConstraintLayout var12, ConstraintLayout var13, MaterialButton var14, Guideline var15, LinearLayout var16, TextView var17, ConstraintLayout var18, ProgressBlockerView var19, RecyclerView var20, RecyclerView var21, MaterialButton var22, EditText var23, TextView var24, SwitchCompat var25, TextView var26, TextView var27, TextView var28, Guideline var29, LinearLayout var30, TextView var31, TextView var32, TextView var33, TextView var34, TextView var35, TextView var36) {
      this.rootView = var1;
      this.backBtn = var2;
      this.bottomSpace = var3;
      this.cbFri = var4;
      this.cbMon = var5;
      this.cbSat = var6;
      this.cbSun = var7;
      this.cbThu = var8;
      this.cbTue = var9;
      this.cbWed = var10;
      this.contentContainer = var11;
      this.contentContainerActive = var12;
      this.daysList = var13;
      this.deleteBtn = var14;
      this.endGuideline = var15;
      this.endTimeGroup = var16;
      this.endTimeValue = var17;
      this.nestedContentContainer = var18;
      this.progressView = var19;
      this.rvEndMode = var20;
      this.rvStartMode = var21;
      this.saveBtn = var22;
      this.scheduleName = var23;
      this.scheduleRepeat = var24;
      this.scheduleSwitchBtn = var25;
      this.setDays = var26;
      this.setName = var27;
      this.setTime = var28;
      this.startGuideline = var29;
      this.startTimeGroup = var30;
      this.startTimeValue = var31;
      this.timezoneLabel = var32;
      this.timezoneValue = var33;
      this.title = var34;
      this.tvEndMode = var35;
      this.tvStartMode = var36;
   }

   public static DialogfragmentDevicePCreateEditScheduleBinding bind(View var0) {
      int var1 = R.id.back_btn;
      ImageButton var21 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var21 != null) {
         var1 = R.id.bottom_space;
         View var5 = ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.cb_fri;
            CheckBox var16 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
            if (var16 != null) {
               var1 = R.id.cb_mon;
               CheckBox var12 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
               if (var12 != null) {
                  var1 = R.id.cb_sat;
                  CheckBox var17 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                  if (var17 != null) {
                     var1 = R.id.cb_sun;
                     CheckBox var26 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                     if (var26 != null) {
                        var1 = R.id.cb_thu;
                        CheckBox var28 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                        if (var28 != null) {
                           var1 = R.id.cb_tue;
                           CheckBox var22 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                           if (var22 != null) {
                              var1 = R.id.cb_wed;
                              CheckBox var18 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                              if (var18 != null) {
                                 var1 = R.id.content_container;
                                 ConstraintLayout var32 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                 if (var32 != null) {
                                    var1 = R.id.content_container_active;
                                    ConstraintLayout var24 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var24 != null) {
                                       var1 = R.id.days_list;
                                       ConstraintLayout var29 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                       if (var29 != null) {
                                          var1 = R.id.delete_btn;
                                          MaterialButton var25 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                          if (var25 != null) {
                                             var1 = R.id.end_guideline;
                                             Guideline var14 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                             if (var14 != null) {
                                                var1 = R.id.end_time_group;
                                                LinearLayout var20 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                if (var20 != null) {
                                                   var1 = R.id.end_time_value;
                                                   TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var6 != null) {
                                                      var1 = R.id.nested_content_container;
                                                      ConstraintLayout var9 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                      if (var9 != null) {
                                                         var1 = R.id.progress_view;
                                                         ProgressBlockerView var3 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var3 != null) {
                                                            var1 = R.id.rv_end_mode;
                                                            RecyclerView var33 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var33 != null) {
                                                               var1 = R.id.rv_start_mode;
                                                               RecyclerView var10 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var10 != null) {
                                                                  var1 = R.id.save_btn;
                                                                  MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var11 != null) {
                                                                     var1 = R.id.schedule_name;
                                                                     EditText var23 = (EditText)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var23 != null) {
                                                                        var1 = R.id.schedule_repeat;
                                                                        TextView var30 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var30 != null) {
                                                                           var1 = R.id.schedule_switch_btn;
                                                                           SwitchCompat var8 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var8 != null) {
                                                                              var1 = R.id.set_days;
                                                                              TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var7 != null) {
                                                                                 var1 = R.id.set_name;
                                                                                 TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var19 != null) {
                                                                                    var1 = R.id.set_time;
                                                                                    TextView var27 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var27 != null) {
                                                                                       var1 = R.id.start_guideline;
                                                                                       Guideline var35 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var35 != null) {
                                                                                          var1 = R.id.start_time_group;
                                                                                          LinearLayout var34 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var34 != null) {
                                                                                             var1 = R.id.start_time_value;
                                                                                             TextView var36 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var36 != null) {
                                                                                                var1 = R.id.timezone_label;
                                                                                                TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var13 != null) {
                                                                                                   var1 = R.id.timezone_value;
                                                                                                   TextView var31 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var31 != null) {
                                                                                                      var1 = R.id.title;
                                                                                                      TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var4 != null) {
                                                                                                         var1 = R.id.tv_end_mode;
                                                                                                         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var2 != null) {
                                                                                                            var1 = R.id.tv_start_mode;
                                                                                                            TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var15 != null) {
                                                                                                               return new DialogfragmentDevicePCreateEditScheduleBinding((FrameLayout)var0, var21, var5, var16, var12, var17, var26, var28, var22, var18, var32, var24, var29, var25, var14, var20, var6, var9, var3, var33, var10, var11, var23, var30, var8, var7, var19, var27, var35, var34, var36, var13, var31, var4, var2, var15);
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   }
                                                                                                }
                                                                                             }
                                                                                          }
                                                                                       }
                                                                                    }
                                                                                 }
                                                                              }
                                                                           }
                                                                        }
                                                                     }
                                                                  }
                                                               }
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentDevicePCreateEditScheduleBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDevicePCreateEditScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_p_create_edit_schedule, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
