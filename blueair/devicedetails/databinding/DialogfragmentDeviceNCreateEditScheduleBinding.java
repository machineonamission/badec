package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceNCreateEditScheduleBinding implements ViewBinding {
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
   public final ImageView endIcon;
   public final LinearLayout endTimeGroup;
   public final TextView endTimeValue;
   public final ProgressBlockerView progressView;
   private final FrameLayout rootView;
   public final MaterialButton saveBtn;
   public final EditText scheduleName;
   public final TextView scheduleRepeat;
   public final SwitchCompat scheduleSwitchBtn;
   public final TextView setDays;
   public final TextView setName;
   public final TextView setTime;
   public final TextView settings;
   public final LinearLayout settingsEnd;
   public final LinearLayout settingsStart;
   public final Guideline startGuideline;
   public final ImageView startIcon;
   public final LinearLayout startTimeGroup;
   public final TextView startTimeValue;
   public final TextView timezoneLabel;
   public final TextView timezoneValue;
   public final TextView title;

   private DialogfragmentDeviceNCreateEditScheduleBinding(FrameLayout var1, ImageButton var2, View var3, CheckBox var4, CheckBox var5, CheckBox var6, CheckBox var7, CheckBox var8, CheckBox var9, CheckBox var10, ConstraintLayout var11, ConstraintLayout var12, ConstraintLayout var13, MaterialButton var14, Guideline var15, ImageView var16, LinearLayout var17, TextView var18, ProgressBlockerView var19, MaterialButton var20, EditText var21, TextView var22, SwitchCompat var23, TextView var24, TextView var25, TextView var26, TextView var27, LinearLayout var28, LinearLayout var29, Guideline var30, ImageView var31, LinearLayout var32, TextView var33, TextView var34, TextView var35, TextView var36) {
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
      this.endIcon = var16;
      this.endTimeGroup = var17;
      this.endTimeValue = var18;
      this.progressView = var19;
      this.saveBtn = var20;
      this.scheduleName = var21;
      this.scheduleRepeat = var22;
      this.scheduleSwitchBtn = var23;
      this.setDays = var24;
      this.setName = var25;
      this.setTime = var26;
      this.settings = var27;
      this.settingsEnd = var28;
      this.settingsStart = var29;
      this.startGuideline = var30;
      this.startIcon = var31;
      this.startTimeGroup = var32;
      this.startTimeValue = var33;
      this.timezoneLabel = var34;
      this.timezoneValue = var35;
      this.title = var36;
   }

   public static DialogfragmentDeviceNCreateEditScheduleBinding bind(View var0) {
      int var1 = R.id.back_btn;
      ImageButton var2 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.bottom_space;
         View var5 = ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.cb_fri;
            CheckBox var19 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
            if (var19 != null) {
               var1 = R.id.cb_mon;
               CheckBox var27 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
               if (var27 != null) {
                  var1 = R.id.cb_sat;
                  CheckBox var26 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                  if (var26 != null) {
                     var1 = R.id.cb_sun;
                     CheckBox var18 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                     if (var18 != null) {
                        var1 = R.id.cb_thu;
                        CheckBox var21 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                        if (var21 != null) {
                           var1 = R.id.cb_tue;
                           CheckBox var29 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                           if (var29 != null) {
                              var1 = R.id.cb_wed;
                              CheckBox var8 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                              if (var8 != null) {
                                 var1 = R.id.content_container;
                                 ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                 if (var3 != null) {
                                    var1 = R.id.content_container_active;
                                    ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var6 != null) {
                                       var1 = R.id.days_list;
                                       ConstraintLayout var25 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                       if (var25 != null) {
                                          var1 = R.id.delete_btn;
                                          MaterialButton var10 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                          if (var10 != null) {
                                             var1 = R.id.end_guideline;
                                             Guideline var31 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                             if (var31 != null) {
                                                var1 = R.id.end_icon;
                                                ImageView var20 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                if (var20 != null) {
                                                   var1 = R.id.end_time_group;
                                                   LinearLayout var32 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                   if (var32 != null) {
                                                      var1 = R.id.end_time_value;
                                                      TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                      if (var13 != null) {
                                                         var1 = R.id.progress_view;
                                                         ProgressBlockerView var9 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var9 != null) {
                                                            var1 = R.id.save_btn;
                                                            MaterialButton var14 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                                            if (var14 != null) {
                                                               var1 = R.id.schedule_name;
                                                               EditText var15 = (EditText)ViewBindings.findChildViewById(var0, var1);
                                                               if (var15 != null) {
                                                                  var1 = R.id.schedule_repeat;
                                                                  TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var7 != null) {
                                                                     var1 = R.id.schedule_switch_btn;
                                                                     SwitchCompat var11 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var11 != null) {
                                                                        var1 = R.id.set_days;
                                                                        TextView var33 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var33 != null) {
                                                                           var1 = R.id.set_name;
                                                                           TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var23 != null) {
                                                                              var1 = R.id.set_time;
                                                                              TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var4 != null) {
                                                                                 var1 = R.id.settings;
                                                                                 TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var22 != null) {
                                                                                    var1 = R.id.settings_end;
                                                                                    LinearLayout var24 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var24 != null) {
                                                                                       var1 = R.id.settings_start;
                                                                                       LinearLayout var12 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var12 != null) {
                                                                                          var1 = R.id.start_guideline;
                                                                                          Guideline var30 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var30 != null) {
                                                                                             var1 = R.id.start_icon;
                                                                                             ImageView var28 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var28 != null) {
                                                                                                var1 = R.id.start_time_group;
                                                                                                LinearLayout var35 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var35 != null) {
                                                                                                   var1 = R.id.start_time_value;
                                                                                                   TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var16 != null) {
                                                                                                      var1 = R.id.timezone_label;
                                                                                                      TextView var36 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var36 != null) {
                                                                                                         var1 = R.id.timezone_value;
                                                                                                         TextView var34 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var34 != null) {
                                                                                                            var1 = R.id.title;
                                                                                                            TextView var17 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var17 != null) {
                                                                                                               return new DialogfragmentDeviceNCreateEditScheduleBinding((FrameLayout)var0, var2, var5, var19, var27, var26, var18, var21, var29, var8, var3, var6, var25, var10, var31, var20, var32, var13, var9, var14, var15, var7, var11, var33, var23, var4, var22, var24, var12, var30, var28, var35, var16, var36, var34, var17);
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

   public static DialogfragmentDeviceNCreateEditScheduleBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceNCreateEditScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_n_create_edit_schedule, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
