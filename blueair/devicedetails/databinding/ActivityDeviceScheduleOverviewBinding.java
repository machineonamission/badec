package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ActivityDeviceScheduleOverviewBinding implements ViewBinding {
   public final ImageButton backBtn;
   public final LinearLayout bottomBar;
   public final MaterialButton btnCancel;
   public final MaterialButton btnLastUsed;
   public final MaterialButton btnSaveChange;
   public final CheckBox cbEveryday;
   public final CheckBox cbFri;
   public final CheckBox cbMon;
   public final CheckBox cbSat;
   public final CheckBox cbSun;
   public final CheckBox cbThu;
   public final CheckBox cbTue;
   public final CheckBox cbWed;
   public final CheckBox cbWeekdays;
   public final CheckBox cbWeekends;
   public final ConstraintLayout contentContainer;
   public final Guideline endGuideline;
   public final TextView endModeLabel;
   public final ShadowLayout endTimeGroup;
   public final TextView endTimeLabel;
   public final AppCompatTextView endTimeValue;
   public final FrameLayout flEndTime;
   public final FrameLayout flStartTime;
   public final Flow flowDayOfWeek;
   public final Flow flowRepeat;
   public final SimpleIconTextView ictvEndMode;
   public final SimpleIconTextView ictvStartMode;
   public final TextInputLayout inputDeviceName;
   public final ImageView ivEndMainMode;
   public final ImageView ivStartMainMode;
   public final LinearLayout llEndMode;
   public final ConstraintLayout llRoot;
   public final LinearLayout llStartMode;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;
   public final TextInputEditText scheduleName;
   public final NestedScrollView scrollView;
   public final View separator;
   public final TextView setDays;
   public final ShadowLayout settingsEnd;
   public final ShadowLayout settingsStart;
   public final Guideline startGuideline;
   public final TextView startModeLabel;
   public final ShadowLayout startTimeGroup;
   public final TextView startTimeLabel;
   public final AppCompatTextView startTimeValue;
   public final TextView title;
   public final FrameLayout titleBar;

   private ActivityDeviceScheduleOverviewBinding(ConstraintLayout var1, ImageButton var2, LinearLayout var3, MaterialButton var4, MaterialButton var5, MaterialButton var6, CheckBox var7, CheckBox var8, CheckBox var9, CheckBox var10, CheckBox var11, CheckBox var12, CheckBox var13, CheckBox var14, CheckBox var15, CheckBox var16, ConstraintLayout var17, Guideline var18, TextView var19, ShadowLayout var20, TextView var21, AppCompatTextView var22, FrameLayout var23, FrameLayout var24, Flow var25, Flow var26, SimpleIconTextView var27, SimpleIconTextView var28, TextInputLayout var29, ImageView var30, ImageView var31, LinearLayout var32, ConstraintLayout var33, LinearLayout var34, ProgressBlockerView var35, TextInputEditText var36, NestedScrollView var37, View var38, TextView var39, ShadowLayout var40, ShadowLayout var41, Guideline var42, TextView var43, ShadowLayout var44, TextView var45, AppCompatTextView var46, TextView var47, FrameLayout var48) {
      this.rootView = var1;
      this.backBtn = var2;
      this.bottomBar = var3;
      this.btnCancel = var4;
      this.btnLastUsed = var5;
      this.btnSaveChange = var6;
      this.cbEveryday = var7;
      this.cbFri = var8;
      this.cbMon = var9;
      this.cbSat = var10;
      this.cbSun = var11;
      this.cbThu = var12;
      this.cbTue = var13;
      this.cbWed = var14;
      this.cbWeekdays = var15;
      this.cbWeekends = var16;
      this.contentContainer = var17;
      this.endGuideline = var18;
      this.endModeLabel = var19;
      this.endTimeGroup = var20;
      this.endTimeLabel = var21;
      this.endTimeValue = var22;
      this.flEndTime = var23;
      this.flStartTime = var24;
      this.flowDayOfWeek = var25;
      this.flowRepeat = var26;
      this.ictvEndMode = var27;
      this.ictvStartMode = var28;
      this.inputDeviceName = var29;
      this.ivEndMainMode = var30;
      this.ivStartMainMode = var31;
      this.llEndMode = var32;
      this.llRoot = var33;
      this.llStartMode = var34;
      this.progressView = var35;
      this.scheduleName = var36;
      this.scrollView = var37;
      this.separator = var38;
      this.setDays = var39;
      this.settingsEnd = var40;
      this.settingsStart = var41;
      this.startGuideline = var42;
      this.startModeLabel = var43;
      this.startTimeGroup = var44;
      this.startTimeLabel = var45;
      this.startTimeValue = var46;
      this.title = var47;
      this.titleBar = var48;
   }

   public static ActivityDeviceScheduleOverviewBinding bind(View var0) {
      int var1 = R.id.back_btn;
      ImageButton var22 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var22 != null) {
         var1 = R.id.bottom_bar;
         LinearLayout var28 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var28 != null) {
            var1 = R.id.btn_cancel;
            MaterialButton var26 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var26 != null) {
               var1 = R.id.btn_lastUsed;
               MaterialButton var47 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var47 != null) {
                  var1 = R.id.btn_saveChange;
                  MaterialButton var15 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                  if (var15 != null) {
                     var1 = R.id.cb_everyday;
                     CheckBox var39 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                     if (var39 != null) {
                        var1 = R.id.cb_fri;
                        CheckBox var34 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                        if (var34 != null) {
                           var1 = R.id.cb_mon;
                           CheckBox var37 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                           if (var37 != null) {
                              var1 = R.id.cb_sat;
                              CheckBox var12 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                              if (var12 != null) {
                                 var1 = R.id.cb_sun;
                                 CheckBox var41 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                 if (var41 != null) {
                                    var1 = R.id.cb_thu;
                                    CheckBox var38 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                    if (var38 != null) {
                                       var1 = R.id.cb_tue;
                                       CheckBox var3 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                       if (var3 != null) {
                                          var1 = R.id.cb_wed;
                                          CheckBox var42 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                          if (var42 != null) {
                                             var1 = R.id.cb_weekdays;
                                             CheckBox var48 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                             if (var48 != null) {
                                                var1 = R.id.cb_weekends;
                                                CheckBox var23 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                                if (var23 != null) {
                                                   var1 = R.id.content_container;
                                                   ConstraintLayout var43 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                   if (var43 != null) {
                                                      var1 = R.id.end_guideline;
                                                      Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                      if (var5 != null) {
                                                         var1 = R.id.end_mode_label;
                                                         TextView var18 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var18 != null) {
                                                            var1 = R.id.end_time_group;
                                                            ShadowLayout var31 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                            if (var31 != null) {
                                                               var1 = R.id.end_time_label;
                                                               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var6 != null) {
                                                                  var1 = R.id.end_time_value;
                                                                  AppCompatTextView var21 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var21 != null) {
                                                                     var1 = R.id.fl_end_time;
                                                                     FrameLayout var17 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var17 != null) {
                                                                        var1 = R.id.fl_start_time;
                                                                        FrameLayout var2 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var2 != null) {
                                                                           var1 = R.id.flow_dayOfWeek;
                                                                           Flow var10 = (Flow)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var10 != null) {
                                                                              var1 = R.id.flow_repeat;
                                                                              Flow var7 = (Flow)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var7 != null) {
                                                                                 var1 = R.id.ictv_endMode;
                                                                                 SimpleIconTextView var16 = (SimpleIconTextView)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var16 != null) {
                                                                                    var1 = R.id.ictv_startMode;
                                                                                    SimpleIconTextView var45 = (SimpleIconTextView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var45 != null) {
                                                                                       var1 = R.id.input_deviceName;
                                                                                       TextInputLayout var29 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var29 != null) {
                                                                                          var1 = R.id.iv_endMainMode;
                                                                                          ImageView var13 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var13 != null) {
                                                                                             var1 = R.id.iv_startMainMode;
                                                                                             ImageView var25 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var25 != null) {
                                                                                                var1 = R.id.ll_endMode;
                                                                                                LinearLayout var46 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var46 != null) {
                                                                                                   ConstraintLayout var9 = (ConstraintLayout)var0;
                                                                                                   var1 = R.id.ll_startMode;
                                                                                                   LinearLayout var14 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var14 != null) {
                                                                                                      var1 = R.id.progress_view;
                                                                                                      ProgressBlockerView var27 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var27 != null) {
                                                                                                         var1 = R.id.schedule_name;
                                                                                                         TextInputEditText var30 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var30 != null) {
                                                                                                            var1 = R.id.scroll_view;
                                                                                                            NestedScrollView var40 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var40 != null) {
                                                                                                               var1 = R.id.separator;
                                                                                                               View var35 = ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var35 != null) {
                                                                                                                  var1 = R.id.set_days;
                                                                                                                  TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var11 != null) {
                                                                                                                     var1 = R.id.settings_end;
                                                                                                                     ShadowLayout var44 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var44 != null) {
                                                                                                                        var1 = R.id.settings_start;
                                                                                                                        ShadowLayout var20 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var20 != null) {
                                                                                                                           var1 = R.id.start_guideline;
                                                                                                                           Guideline var24 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                                                           if (var24 != null) {
                                                                                                                              var1 = R.id.start_mode_label;
                                                                                                                              TextView var36 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                              if (var36 != null) {
                                                                                                                                 var1 = R.id.start_time_group;
                                                                                                                                 ShadowLayout var33 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                 if (var33 != null) {
                                                                                                                                    var1 = R.id.start_time_label;
                                                                                                                                    TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                    if (var19 != null) {
                                                                                                                                       var1 = R.id.start_time_value;
                                                                                                                                       AppCompatTextView var8 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                       if (var8 != null) {
                                                                                                                                          var1 = R.id.title;
                                                                                                                                          TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                          if (var4 != null) {
                                                                                                                                             var1 = R.id.title_bar;
                                                                                                                                             FrameLayout var32 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                             if (var32 != null) {
                                                                                                                                                return new ActivityDeviceScheduleOverviewBinding(var9, var22, var28, var26, var47, var15, var39, var34, var37, var12, var41, var38, var3, var42, var48, var23, var43, var5, var18, var31, var6, var21, var17, var2, var10, var7, var16, var45, var29, var13, var25, var46, var9, var14, var27, var30, var40, var35, var11, var44, var20, var24, var36, var33, var19, var8, var4, var32);
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
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityDeviceScheduleOverviewBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityDeviceScheduleOverviewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_device_schedule_overview, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
