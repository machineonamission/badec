package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ActivityAlarmEditBinding implements ViewBinding {
   public final TextInputEditText alarmName;
   public final LinearLayout bottomBar;
   public final ImageButton btnBack;
   public final MaterialButton btnCancel;
   public final Button btnCloseHint;
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
   public final View clickViewSound;
   public final ConstraintLayout contentContainer;
   public final Guideline endGuideline;
   public final Flow flowDayOfWeek;
   public final Flow flowRepeat;
   public final ConstraintLayout hintContainer;
   public final TextView hintText;
   public final ImageView icVolume;
   public final TextInputLayout inputDeviceName;
   public final FrameLayout offlineContainer;
   public final ProgressBlockerView progressView;
   public final Group ringtoneContent;
   public final ShadowLayout ringtoneGroup;
   public final SwitchCompat ringtoneSwitch;
   private final ConstraintLayout rootView;
   public final NestedScrollView scrollView;
   public final AccessibleSeekBar seekbarDuration;
   public final AccessibleSeekBar seekbarVolume;
   public final View separator;
   public final View separator1;
   public final View separator2;
   public final View separator3;
   public final View separatorEnd;
   public final View separatorStart;
   public final TextView setDays;
   public final ShadowLayout setTimeGroup;
   public final Guideline startGuideline;
   public final Group sunriseContent;
   public final ShadowLayout sunriseGroup;
   public final SwitchCompat sunriseSwitch;
   public final AppCompatTextView timeValue;
   public final TextView title;
   public final FrameLayout titleBar;
   public final TextView tvDurationValue;
   public final TextView tvProgress0;
   public final TextView tvProgress100;
   public final TextView tvRingtone;
   public final TextView tvSound;
   public final TextView tvSoundValue;
   public final TextView tvSunriseDuration;
   public final TextView tvSunriseLight;
   public final TextView tvVolume;
   public final TextView tvVolumeValue;

   private ActivityAlarmEditBinding(ConstraintLayout var1, TextInputEditText var2, LinearLayout var3, ImageButton var4, MaterialButton var5, Button var6, MaterialButton var7, CheckBox var8, CheckBox var9, CheckBox var10, CheckBox var11, CheckBox var12, CheckBox var13, CheckBox var14, CheckBox var15, CheckBox var16, CheckBox var17, View var18, ConstraintLayout var19, Guideline var20, Flow var21, Flow var22, ConstraintLayout var23, TextView var24, ImageView var25, TextInputLayout var26, FrameLayout var27, ProgressBlockerView var28, Group var29, ShadowLayout var30, SwitchCompat var31, NestedScrollView var32, AccessibleSeekBar var33, AccessibleSeekBar var34, View var35, View var36, View var37, View var38, View var39, View var40, TextView var41, ShadowLayout var42, Guideline var43, Group var44, ShadowLayout var45, SwitchCompat var46, AppCompatTextView var47, TextView var48, FrameLayout var49, TextView var50, TextView var51, TextView var52, TextView var53, TextView var54, TextView var55, TextView var56, TextView var57, TextView var58, TextView var59) {
      this.rootView = var1;
      this.alarmName = var2;
      this.bottomBar = var3;
      this.btnBack = var4;
      this.btnCancel = var5;
      this.btnCloseHint = var6;
      this.btnSaveChange = var7;
      this.cbEveryday = var8;
      this.cbFri = var9;
      this.cbMon = var10;
      this.cbSat = var11;
      this.cbSun = var12;
      this.cbThu = var13;
      this.cbTue = var14;
      this.cbWed = var15;
      this.cbWeekdays = var16;
      this.cbWeekends = var17;
      this.clickViewSound = var18;
      this.contentContainer = var19;
      this.endGuideline = var20;
      this.flowDayOfWeek = var21;
      this.flowRepeat = var22;
      this.hintContainer = var23;
      this.hintText = var24;
      this.icVolume = var25;
      this.inputDeviceName = var26;
      this.offlineContainer = var27;
      this.progressView = var28;
      this.ringtoneContent = var29;
      this.ringtoneGroup = var30;
      this.ringtoneSwitch = var31;
      this.scrollView = var32;
      this.seekbarDuration = var33;
      this.seekbarVolume = var34;
      this.separator = var35;
      this.separator1 = var36;
      this.separator2 = var37;
      this.separator3 = var38;
      this.separatorEnd = var39;
      this.separatorStart = var40;
      this.setDays = var41;
      this.setTimeGroup = var42;
      this.startGuideline = var43;
      this.sunriseContent = var44;
      this.sunriseGroup = var45;
      this.sunriseSwitch = var46;
      this.timeValue = var47;
      this.title = var48;
      this.titleBar = var49;
      this.tvDurationValue = var50;
      this.tvProgress0 = var51;
      this.tvProgress100 = var52;
      this.tvRingtone = var53;
      this.tvSound = var54;
      this.tvSoundValue = var55;
      this.tvSunriseDuration = var56;
      this.tvSunriseLight = var57;
      this.tvVolume = var58;
      this.tvVolumeValue = var59;
   }

   public static ActivityAlarmEditBinding bind(View var0) {
      int var1 = R.id.alarm_name;
      TextInputEditText var16 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
      if (var16 != null) {
         var1 = R.id.bottom_bar;
         LinearLayout var9 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.btn_back;
            ImageButton var44 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
            if (var44 != null) {
               var1 = R.id.btn_cancel;
               MaterialButton var47 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var47 != null) {
                  var1 = R.id.btn_close_hint;
                  Button var49 = (Button)ViewBindings.findChildViewById(var0, var1);
                  if (var49 != null) {
                     var1 = R.id.btn_saveChange;
                     MaterialButton var52 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
                     if (var52 != null) {
                        var1 = R.id.cb_everyday;
                        CheckBox var28 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                        if (var28 != null) {
                           var1 = R.id.cb_fri;
                           CheckBox var37 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                           if (var37 != null) {
                              var1 = R.id.cb_mon;
                              CheckBox var36 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                              if (var36 != null) {
                                 var1 = R.id.cb_sat;
                                 CheckBox var2 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                 if (var2 != null) {
                                    var1 = R.id.cb_sun;
                                    CheckBox var8 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                    if (var8 != null) {
                                       var1 = R.id.cb_thu;
                                       CheckBox var17 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                       if (var17 != null) {
                                          var1 = R.id.cb_tue;
                                          CheckBox var46 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                          if (var46 != null) {
                                             var1 = R.id.cb_wed;
                                             CheckBox var57 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                             if (var57 != null) {
                                                var1 = R.id.cb_weekdays;
                                                CheckBox var43 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                                if (var43 != null) {
                                                   var1 = R.id.cb_weekends;
                                                   CheckBox var21 = (CheckBox)ViewBindings.findChildViewById(var0, var1);
                                                   if (var21 != null) {
                                                      var1 = R.id.click_view_sound;
                                                      View var50 = ViewBindings.findChildViewById(var0, var1);
                                                      if (var50 != null) {
                                                         var1 = R.id.content_container;
                                                         ConstraintLayout var4 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                         if (var4 != null) {
                                                            var1 = R.id.end_guideline;
                                                            Guideline var12 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                            if (var12 != null) {
                                                               var1 = R.id.flow_dayOfWeek;
                                                               Flow var27 = (Flow)ViewBindings.findChildViewById(var0, var1);
                                                               if (var27 != null) {
                                                                  var1 = R.id.flow_repeat;
                                                                  Flow var58 = (Flow)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var58 != null) {
                                                                     var1 = R.id.hint_container;
                                                                     ConstraintLayout var40 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var40 != null) {
                                                                        var1 = R.id.hint_text;
                                                                        TextView var29 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var29 != null) {
                                                                           var1 = R.id.ic_volume;
                                                                           ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var10 != null) {
                                                                              var1 = R.id.input_deviceName;
                                                                              TextInputLayout var18 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var18 != null) {
                                                                                 var1 = R.id.offline_container;
                                                                                 FrameLayout var31 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var31 != null) {
                                                                                    var1 = R.id.progress_view;
                                                                                    ProgressBlockerView var3 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var3 != null) {
                                                                                       var1 = R.id.ringtone_content;
                                                                                       Group var7 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var7 != null) {
                                                                                          var1 = R.id.ringtone_group;
                                                                                          ShadowLayout var51 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var51 != null) {
                                                                                             var1 = R.id.ringtone_switch;
                                                                                             SwitchCompat var34 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var34 != null) {
                                                                                                var1 = R.id.scroll_view;
                                                                                                NestedScrollView var24 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var24 != null) {
                                                                                                   var1 = R.id.seekbar_duration;
                                                                                                   AccessibleSeekBar var41 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var41 != null) {
                                                                                                      var1 = R.id.seekbar_volume;
                                                                                                      AccessibleSeekBar var13 = (AccessibleSeekBar)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var13 != null) {
                                                                                                         var1 = R.id.separator;
                                                                                                         View var23 = ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var23 != null) {
                                                                                                            var1 = R.id.separator1;
                                                                                                            View var56 = ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var56 != null) {
                                                                                                               var1 = R.id.separator2;
                                                                                                               View var42 = ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var42 != null) {
                                                                                                                  var1 = R.id.separator3;
                                                                                                                  View var19 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var19 != null) {
                                                                                                                     var1 = R.id.separator_end;
                                                                                                                     View var5 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var5 != null) {
                                                                                                                        var1 = R.id.separator_start;
                                                                                                                        View var25 = ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var25 != null) {
                                                                                                                           var1 = R.id.set_days;
                                                                                                                           TextView var53 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                           if (var53 != null) {
                                                                                                                              var1 = R.id.set_time_group;
                                                                                                                              ShadowLayout var33 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                              if (var33 != null) {
                                                                                                                                 var1 = R.id.start_guideline;
                                                                                                                                 Guideline var48 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                 if (var48 != null) {
                                                                                                                                    var1 = R.id.sunrise_content;
                                                                                                                                    Group var59 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                    if (var59 != null) {
                                                                                                                                       var1 = R.id.sunrise_group;
                                                                                                                                       ShadowLayout var38 = (ShadowLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                       if (var38 != null) {
                                                                                                                                          var1 = R.id.sunrise_switch;
                                                                                                                                          SwitchCompat var39 = (SwitchCompat)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                          if (var39 != null) {
                                                                                                                                             var1 = R.id.time_value;
                                                                                                                                             AppCompatTextView var30 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                             if (var30 != null) {
                                                                                                                                                var1 = R.id.title;
                                                                                                                                                TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                if (var11 != null) {
                                                                                                                                                   var1 = R.id.title_bar;
                                                                                                                                                   FrameLayout var35 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                   if (var35 != null) {
                                                                                                                                                      var1 = R.id.tv_duration_value;
                                                                                                                                                      TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                      if (var6 != null) {
                                                                                                                                                         var1 = R.id.tv_progress_0;
                                                                                                                                                         TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                         if (var15 != null) {
                                                                                                                                                            var1 = R.id.tv_progress_100;
                                                                                                                                                            TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                            if (var20 != null) {
                                                                                                                                                               var1 = R.id.tv_ringtone;
                                                                                                                                                               TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                               if (var22 != null) {
                                                                                                                                                                  var1 = R.id.tv_sound;
                                                                                                                                                                  TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                  if (var14 != null) {
                                                                                                                                                                     var1 = R.id.tv_sound_value;
                                                                                                                                                                     TextView var45 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                     if (var45 != null) {
                                                                                                                                                                        var1 = R.id.tv_sunrise_duration;
                                                                                                                                                                        TextView var54 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                        if (var54 != null) {
                                                                                                                                                                           var1 = R.id.tv_sunrise_light;
                                                                                                                                                                           TextView var26 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                           if (var26 != null) {
                                                                                                                                                                              var1 = R.id.tv_volume;
                                                                                                                                                                              TextView var32 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                              if (var32 != null) {
                                                                                                                                                                                 var1 = R.id.tv_volume_value;
                                                                                                                                                                                 TextView var55 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                 if (var55 != null) {
                                                                                                                                                                                    return new ActivityAlarmEditBinding((ConstraintLayout)var0, var16, var9, var44, var47, var49, var52, var28, var37, var36, var2, var8, var17, var46, var57, var43, var21, var50, var4, var12, var27, var58, var40, var29, var10, var18, var31, var3, var7, var51, var34, var24, var41, var13, var23, var56, var42, var19, var5, var25, var53, var33, var48, var59, var38, var39, var30, var11, var35, var6, var15, var20, var22, var14, var45, var54, var26, var32, var55);
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

   public static ActivityAlarmEditBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityAlarmEditBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_alarm_edit, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
