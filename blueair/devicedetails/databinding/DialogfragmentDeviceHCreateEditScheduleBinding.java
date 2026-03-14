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

public final class DialogfragmentDeviceHCreateEditScheduleBinding implements ViewBinding {
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
   public final ImageView endMainModeIcon;
   public final LinearLayout endTimeGroup;
   public final TextView endTimeValue;
   public final TextView endTitle;
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
   public final ConstraintLayout settingsEnd;
   public final ConstraintLayout settingsStart;
   public final Guideline startGuideline;
   public final ImageView startIcon;
   public final ImageView startMainModeIcon;
   public final LinearLayout startTimeGroup;
   public final TextView startTimeValue;
   public final TextView startTitle;
   public final TextView timezoneLabel;
   public final TextView timezoneValue;
   public final TextView title;

   private DialogfragmentDeviceHCreateEditScheduleBinding(FrameLayout var1, ImageButton var2, View var3, CheckBox var4, CheckBox var5, CheckBox var6, CheckBox var7, CheckBox var8, CheckBox var9, CheckBox var10, ConstraintLayout var11, ConstraintLayout var12, ConstraintLayout var13, MaterialButton var14, Guideline var15, ImageView var16, ImageView var17, LinearLayout var18, TextView var19, TextView var20, ProgressBlockerView var21, MaterialButton var22, EditText var23, TextView var24, SwitchCompat var25, TextView var26, TextView var27, TextView var28, TextView var29, ConstraintLayout var30, ConstraintLayout var31, Guideline var32, ImageView var33, ImageView var34, LinearLayout var35, TextView var36, TextView var37, TextView var38, TextView var39, TextView var40) {
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
      this.endMainModeIcon = var17;
      this.endTimeGroup = var18;
      this.endTimeValue = var19;
      this.endTitle = var20;
      this.progressView = var21;
      this.saveBtn = var22;
      this.scheduleName = var23;
      this.scheduleRepeat = var24;
      this.scheduleSwitchBtn = var25;
      this.setDays = var26;
      this.setName = var27;
      this.setTime = var28;
      this.settings = var29;
      this.settingsEnd = var30;
      this.settingsStart = var31;
      this.startGuideline = var32;
      this.startIcon = var33;
      this.startMainModeIcon = var34;
      this.startTimeGroup = var35;
      this.startTimeValue = var36;
      this.startTitle = var37;
      this.timezoneLabel = var38;
      this.timezoneValue = var39;
      this.title = var40;
   }

   public static DialogfragmentDeviceHCreateEditScheduleBinding bind(View var0) {
      int var1 = R.id.back_btn;
      ImageButton var4 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.bottom_space;
         View var24 = ViewBindings.findChildViewById(var0, var1);
         if (var24 != null) {
            var1 = R.id.cb_fri;
            CheckBox var28 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
            if (var28 != null) {
               var1 = R.id.cb_mon;
               CheckBox var6 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.cb_sat;
                  CheckBox var22 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                  if (var22 != null) {
                     var1 = R.id.cb_sun;
                     CheckBox var15 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                     if (var15 != null) {
                        var1 = R.id.cb_thu;
                        CheckBox var14 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                        if (var14 != null) {
                           var1 = R.id.cb_tue;
                           CheckBox var3 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                           if (var3 != null) {
                              var1 = R.id.cb_wed;
                              CheckBox var34 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                              if (var34 != null) {
                                 var1 = R.id.content_container;
                                 ConstraintLayout var19 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                 if (var19 != null) {
                                    var1 = R.id.content_container_active;
                                    ConstraintLayout var37 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                    if (var37 != null) {
                                       var1 = R.id.days_list;
                                       ConstraintLayout var33 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                       if (var33 != null) {
                                          var1 = R.id.delete_btn;
                                          MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                          if (var11 != null) {
                                             var1 = R.id.end_guideline;
                                             Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                             if (var5 != null) {
                                                var1 = R.id.end_icon;
                                                ImageView var40 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                if (var40 != null) {
                                                   var1 = R.id.end_main_mode_icon;
                                                   ImageView var32 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                   if (var32 != null) {
                                                      var1 = R.id.end_time_group;
                                                      LinearLayout var7 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                      if (var7 != null) {
                                                         var1 = R.id.end_time_value;
                                                         TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var20 != null) {
                                                            var1 = R.id.end_title;
                                                            TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var16 != null) {
                                                               var1 = R.id.progress_view;
                                                               ProgressBlockerView var10 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var10 != null) {
                                                                  var1 = R.id.save_btn;
                                                                  MaterialButton var36 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var36 != null) {
                                                                     var1 = R.id.schedule_name;
                                                                     EditText var29 = (EditText)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var29 != null) {
                                                                        var1 = R.id.schedule_repeat;
                                                                        TextView var27 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var27 != null) {
                                                                           var1 = R.id.schedule_switch_btn;
                                                                           SwitchCompat var17 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var17 != null) {
                                                                              var1 = R.id.set_days;
                                                                              TextView var31 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var31 != null) {
                                                                                 var1 = R.id.set_name;
                                                                                 TextView var12 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var12 != null) {
                                                                                    var1 = R.id.set_time;
                                                                                    TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var21 != null) {
                                                                                       var1 = R.id.settings;
                                                                                       TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var13 != null) {
                                                                                          var1 = R.id.settings_end;
                                                                                          ConstraintLayout var39 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var39 != null) {
                                                                                             var1 = R.id.settings_start;
                                                                                             ConstraintLayout var25 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var25 != null) {
                                                                                                var1 = R.id.start_guideline;
                                                                                                Guideline var26 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var26 != null) {
                                                                                                   var1 = R.id.start_icon;
                                                                                                   ImageView var18 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var18 != null) {
                                                                                                      var1 = R.id.start_main_mode_icon;
                                                                                                      ImageView var38 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var38 != null) {
                                                                                                         var1 = R.id.start_time_group;
                                                                                                         LinearLayout var30 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var30 != null) {
                                                                                                            var1 = R.id.start_time_value;
                                                                                                            TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var23 != null) {
                                                                                                               var1 = R.id.start_title;
                                                                                                               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var2 != null) {
                                                                                                                  var1 = R.id.timezone_label;
                                                                                                                  TextView var35 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var35 != null) {
                                                                                                                     var1 = R.id.timezone_value;
                                                                                                                     TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var8 != null) {
                                                                                                                        var1 = R.id.title;
                                                                                                                        TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var9 != null) {
                                                                                                                           return new DialogfragmentDeviceHCreateEditScheduleBinding((FrameLayout)var0, var4, var24, var28, var6, var22, var15, var14, var3, var34, var19, var37, var33, var11, var5, var40, var32, var7, var20, var16, var10, var36, var29, var27, var17, var31, var12, var21, var13, var39, var25, var26, var18, var38, var30, var23, var2, var35, var8, var9);
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
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentDeviceHCreateEditScheduleBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentDeviceHCreateEditScheduleBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_device_h_create_edit_schedule, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
