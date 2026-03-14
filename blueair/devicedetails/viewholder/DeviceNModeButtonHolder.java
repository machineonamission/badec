package com.blueair.devicedetails.viewholder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J,\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;", "updateMode", "", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "device", "Lcom/blueair/core/model/Device;", "purifierMainMode", "Lcom/blueair/core/model/MainMode;", "purifierMode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "updateMainMode", "mainMode", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNModeButtonHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNModeButtonBinding binding;

   public DeviceNModeButtonHolder(HolderDeviceNModeButtonBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
      ViewUtils var2 = ViewUtils.INSTANCE;
      LinearLayout var3 = var1.modeRoot;
      Intrinsics.checkNotNullExpressionValue(var3, "modeRoot");
      ViewUtils.setAccessibilityDelegate$default(var2, (View)var3, Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
   }

   public final HolderDeviceNModeButtonBinding getBinding() {
      return this.binding;
   }

   public final void updateMainMode(ModeIcon var1, Device var2, MainMode var3, DeviceCreateEditScheduleViewModel.PurifierMode var4) {
      Intrinsics.checkNotNullParameter(var1, "mainMode");
      this.binding.modeText.setText(var1.getText());
      boolean var6 = false;
      boolean var7;
      if (var2 != null && var2.isUsDevice() && var1 == ModeIcon.HEAT) {
         var7 = true;
      } else {
         var7 = false;
      }

      AppCompatImageView var8 = this.binding.infoView;
      Intrinsics.checkNotNullExpressionValue(var8, "infoView");
      ViewExtensionsKt.show((View)var8, var7);
      if (var2 != null) {
         label64: {
            if (var3 == null) {
               HasStandBy var18;
               if (var2 instanceof HasStandBy) {
                  var18 = (HasStandBy)var2;
               } else {
                  var18 = null;
               }

               if (var18 != null && var18.isStandByOn()) {
                  break label64;
               }
            }

            if (var4 != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
               MainMode var19 = var1.toMainMode();
               MainMode var15 = var3;
               if (var3 == null) {
                  if (var2 instanceof HasCombo3in1MainMode) {
                     var2 = var2;
                  } else {
                     var2 = null;
                  }

                  if (var2 != null) {
                     var15 = var2.mainMode();
                  } else {
                     var15 = null;
                  }
               }

               if (var19 == var15) {
                  var6 = true;
               }

               HolderDeviceNModeButtonBinding var16 = this.binding;
               var16.modeRoot.setEnabled(var7 ^ true);
               TextView var14 = var16.modeText;
               Resources var12 = this.itemView.getResources();
               int var5;
               if (var7) {
                  var5 = R.color.light_gray;
               } else {
                  var5 = R.color.colorPrimaryText;
               }

               var14.setTextColor(var12.getColor(var5, (Resources.Theme)null));
               if (var6) {
                  if (var7) {
                     var5 = var1.getOnIconDisabled();
                  } else {
                     var5 = var1.getOnIcon();
                  }
               } else if (var7) {
                  var5 = var1.getOffIconDisabled();
               } else {
                  var5 = var1.getOffIcon();
               }

               var16.modeIcon.setImageResource(var5);
               TextView var9 = var16.modeText;
               Intrinsics.checkNotNullExpressionValue(var9, "modeText");
               if (var6) {
                  com.blueair.viewcore.ViewExtensionsKt.bold(var9);
                  return;
               }

               com.blueair.viewcore.ViewExtensionsKt.unbold(var9);
               return;
            }
         }
      }

      HolderDeviceNModeButtonBinding var13 = this.binding;
      var13.modeRoot.setEnabled(false);
      var13.modeIcon.setImageResource(var1.getOffIconDisabled());
      TextView var10 = var13.modeText;
      Intrinsics.checkNotNullExpressionValue(var10, "modeText");
      com.blueair.viewcore.ViewExtensionsKt.unbold(var10);
      var13.modeText.setTextColor(this.itemView.getResources().getColor(R.color.smokegray, (Resources.Theme)null));
   }

   public final void updateMode(ModeIcon var1, Device var2, MainMode var3, DeviceCreateEditScheduleViewModel.PurifierMode var4) {
      boolean var7;
      boolean var11;
      int var26;
      label291: {
         label290: {
            Intrinsics.checkNotNullParameter(var1, "mode");
            this.binding.modeText.setText(var1.getText());
            var7 = var2 instanceof HasCombo3in1MainMode;
            var11 = true;
            if (var7) {
               DeviceNModeButtonHolder var13 = this;
               MainMode var30;
               if (var3 == null) {
                  var30 = ((HasCombo3in1MainMode)var2).mainMode();
               } else {
                  var30 = var3;
               }

               var26 = DeviceNModeButtonHolder.WhenMappings.$EnumSwitchMapping$0[var30.ordinal()];
               if (var26 != 1) {
                  if (var26 == 2 && (var1 == ModeIcon.AUTO || var1 == ModeIcon.WATERDROP_AUTO || var1 == ModeIcon.ECO)) {
                     break label290;
                  }
               } else if (var1 == ModeIcon.NIGHT || var1 == ModeIcon.ECO) {
                  break label290;
               }
            }

            var26 = 0;
            break label291;
         }

         var26 = 1;
      }

      if (var2 != null) {
         label273: {
            if (var4 == null) {
               HasStandBy var31;
               if (var2 instanceof HasStandBy) {
                  var31 = (HasStandBy)var2;
               } else {
                  var31 = null;
               }

               if (var31 != null && var31.isStandByOn()) {
                  break label273;
               }
            }

            if (var4 != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
               label305: {
                  if (!var26 && (!var2.isUsDevice() || !var7 || (var3 != null || !((HasCombo3in1MainMode)var2).isInMainMode(MainMode.HEAT)) && var3 != MainMode.HEAT)) {
                     label311: {
                        if (var1 != ModeIcon.STANDBY && var2 instanceof DeviceHumidifier) {
                           DeviceHumidifier var20 = (DeviceHumidifier)var2;
                           if (Intrinsics.areEqual(var20.getHardware(), "hum_n") && var20.getWaterShortage()) {
                              break label311;
                           }
                        }

                        if (!(var2 instanceof HasBody) || ((HasBody)var2).getBodyMounted()) {
                           var26 = 0;
                           break label305;
                        }
                     }
                  }

                  var26 = 1;
               }

               label242: {
                  if (var4 != null) {
                     switch (DeviceNModeButtonHolder.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()]) {
                        case 1:
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 2:
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 3:
                        case 4:
                           var7 = var11;
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
                              break label242;
                           }

                           if (var2 instanceof DeviceNewClassic && var4 == DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 5:
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 6:
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 7:
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 8:
                           if (var4 == DeviceCreateEditScheduleViewModel.PurifierMode.SMART) {
                              var7 = var11;
                              break label242;
                           }
                     }
                  } else {
                     boolean var12 = var2 instanceof HasPetMainMode;
                     boolean var8;
                     boolean var9;
                     boolean var10;
                     if (var12) {
                        HasPetMainMode var23 = (HasPetMainMode)var2;
                        if (var23.isInMainMode(MainMode.AirPurify) && var23.isInApSubMode(ApSubMode.FAN)) {
                           var8 = true;
                        } else {
                           var8 = false;
                        }

                        if (var23.isInMainMode(MainMode.AirPurify) && var23.isInApSubMode(ApSubMode.NIGHT)) {
                           var7 = true;
                        } else {
                           var7 = false;
                        }

                        var9 = false;
                        var10 = false;
                     } else if (var7) {
                        ApSubMode var22 = ((HasCombo3in1MainMode)var2).currentSubMode();
                        if (var22 == ApSubMode.FAN) {
                           var8 = true;
                        } else {
                           var8 = false;
                        }

                        if (var22 == ApSubMode.AUTO) {
                           var9 = true;
                        } else {
                           var9 = false;
                        }

                        if (var22 == ApSubMode.ECO) {
                           var10 = true;
                        } else {
                           var10 = false;
                        }

                        if (var22 == ApSubMode.NIGHT) {
                           var7 = true;
                        } else {
                           var7 = false;
                        }
                     } else if (var2 instanceof HasMode) {
                        HasMode var21 = (HasMode)var2;
                        var8 = var21.isInMode(Mode.FAN);
                        var9 = var21.isInMode(Mode.AUTO);
                        var7 = var21.isInMode(Mode.NIGHT);
                        var10 = false;
                     } else {
                        if (var2 instanceof HasFanSpeed && ((HasFanSpeed)var2).getAutoMode() == AutoMode.ON) {
                           var9 = true;
                        } else {
                           var9 = false;
                        }

                        if (var2 instanceof HasEcoMode && ((HasEcoMode)var2).isEcoModeOn()) {
                           var10 = true;
                        } else {
                           var10 = false;
                        }

                        if (var2 instanceof HasG4NightMode && ((HasG4NightMode)var2).isG4NightModeOn()) {
                           var7 = true;
                        } else {
                           var7 = false;
                        }

                        if (!var9 && !var7 && !var10) {
                           var8 = true;
                        } else {
                           var8 = false;
                        }
                     }

                     switch (DeviceNModeButtonHolder.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()]) {
                        case 1:
                           var7 = var8;
                        case 2:
                           break label242;
                        case 3:
                        case 4:
                           if (!(var2 instanceof DeviceNewClassic)) {
                              var7 = var9;
                              break label242;
                           }

                           var7 = var11;
                           if (var9) {
                              break label242;
                           }

                           if (var10) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 5:
                           var7 = var10;
                           break label242;
                        case 6:
                           if (var2 instanceof HasStandBy && ((HasStandBy)var2).isStandByOn()) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 7:
                           if (var2 instanceof HasDisinfection && DeviceKt.isDisinfectionOn(var2)) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 8:
                           if (var12 && ((HasPetMainMode)var2).isInMainMode(MainMode.SMART)) {
                              var7 = var11;
                              break label242;
                           }
                           break;
                        case 9:
                           if (var2 instanceof HasChildLock && ((HasChildLock)var2).isChildLockOn()) {
                              var7 = var11;
                              break label242;
                           }
                     }
                  }

                  var7 = false;
               }

               HolderDeviceNModeButtonBinding var18 = this.binding;
               var18.modeRoot.setEnabled((boolean)(var26 ^ true));
               if (var1 == ModeIcon.STANDBY) {
                  var18.modeText.setText(R.string.turn_on);
               }

               TextView var24 = var18.modeText;
               Resources var25 = this.itemView.getResources();
               int var6;
               if (var26) {
                  var6 = R.color.light_gray;
               } else {
                  var6 = R.color.colorPrimaryText;
               }

               var24.setTextColor(var25.getColor(var6, (Resources.Theme)null));
               if (var7) {
                  if (var26) {
                     var26 = var1.getOnIconDisabled();
                  } else {
                     var26 = var1.getOnIcon();
                  }
               } else if (var26) {
                  var26 = var1.getOffIconDisabled();
               } else {
                  var26 = var1.getOffIcon();
               }

               var18.modeIcon.setImageResource(var26);
               if (!var7 && var1 != ModeIcon.STANDBY) {
                  TextView var15 = var18.modeText;
                  Intrinsics.checkNotNullExpressionValue(var15, "modeText");
                  com.blueair.viewcore.ViewExtensionsKt.unbold(var15);
               } else {
                  TextView var14 = var18.modeText;
                  Intrinsics.checkNotNullExpressionValue(var14, "modeText");
                  com.blueair.viewcore.ViewExtensionsKt.bold(var14);
               }

               var18.modeRoot.setSelected(var7);
               return;
            }
         }
      }

      HolderDeviceNModeButtonBinding var19 = this.binding;
      if (var1 == ModeIcon.STANDBY) {
         var19.modeRoot.setEnabled(true);
         var19.modeIcon.setImageResource(var1.getOnIcon());
         TextView var17 = var19.modeText;
         Intrinsics.checkNotNullExpressionValue(var17, "modeText");
         com.blueair.viewcore.ViewExtensionsKt.unbold(var17);
         var19.modeText.setText(R.string.turn_on);
         var19.modeText.setTextColor(this.itemView.getResources().getColor(R.color.colorPrimaryText, (Resources.Theme)null));
      } else {
         var19.modeRoot.setSelected(false);
         var19.modeRoot.setEnabled(false);
         var19.modeIcon.setImageResource(var1.getOffIconDisabled());
         TextView var16 = var19.modeText;
         Intrinsics.checkNotNullExpressionValue(var16, "modeText");
         com.blueair.viewcore.ViewExtensionsKt.unbold(var16);
         var19.modeText.setTextColor(this.itemView.getResources().getColor(R.color.smokegray, (Resources.Theme)null));
      }
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final DeviceNModeButtonHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceNModeButtonBinding var2 = HolderDeviceNModeButtonBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceNModeButtonHolder(var2);
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.HEAT.ordinal()] = 1;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 2;
         } catch (NoSuchFieldError var11) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ModeIcon.values().length];

         try {
            var0[ModeIcon.FAN_SPEED.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[ModeIcon.NIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[ModeIcon.AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[ModeIcon.WATERDROP_AUTO.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[ModeIcon.ECO.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ModeIcon.STANDBY.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ModeIcon.DISINFECTION.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ModeIcon.SMART.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ModeIcon.CHILD_LOCK.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
