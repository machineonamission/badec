package com.blueair.devicedetails.viewholder;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.databinding.HolderDeviceModeButtonV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J<\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\u000e\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00132\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonV2Binding;", "forMainMode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonV2Binding;Z)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonV2Binding;", "updateMode", "", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "updateSubmode", "modeValues", "", "stayOffIcons", "disableModeIcons", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModeButtonV2Holder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceModeButtonV2Binding binding;
   private final boolean forMainMode;

   public DeviceModeButtonV2Holder(HolderDeviceModeButtonV2Binding var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
      this.forMainMode = var2;
   }

   private final void updateSubmode(ModeIcon var1, Device var2, boolean var3) {
      this.binding.modeText.setText(var1.getTextShort());
      boolean var6 = var2 instanceof HasWaterLevel;
      boolean var11 = true;
      boolean var4;
      if (var6 && ((HasWaterLevel)var2).isInWaterLevel(WaterLevel.SHORTAGE)) {
         var4 = 1;
      } else {
         var4 = 0;
      }

      boolean var12 = var2 instanceof DeviceHumidifier20;
      boolean var5;
      if (var12) {
         var5 = (boolean)var4;
      } else {
         label395: {
            label394: {
               if (var2 instanceof DeviceHumidifier) {
                  DeviceHumidifier var13 = (DeviceHumidifier)var2;
                  if (Intrinsics.areEqual(var13.getHardware(), "hum_n") && var13.getWaterShortage()) {
                     break label394;
                  }
               } else if (var2 instanceof HasBody && !((HasBody)var2).getBodyMounted()) {
                  break label394;
               }

               var5 = false;
               break label395;
            }

            var5 = true;
         }
      }

      if (!DeviceKt.isStandByOn(var2) && var2.isOnline() && !var3 && !var5) {
         var5 = false;
      } else {
         var5 = true;
      }

      Set var29;
      if (var2 instanceof DeviceCombo2in120) {
         if (!var4 && !((DeviceCombo2in120)var2).getWaterTankFailure()) {
            var29 = SetsKt.emptySet();
         } else if (((DeviceCombo2in120)var2).isInMainMode(MainMode.Humidification)) {
            var29 = SetsKt.setOf(new ModeIcon[]{ModeIcon.FAN_SPEED, ModeIcon.AUTO, ModeIcon.NIGHT, ModeIcon.SKIN});
         } else {
            var29 = SetsKt.setOf(ModeIcon.SKIN);
         }
      } else if (var2 instanceof HasCombo3in1MainMode) {
         MainMode var30 = ((HasCombo3in1MainMode)var2).mainMode();
         var4 = DeviceModeButtonV2Holder.WhenMappings.$EnumSwitchMapping$0[var30.ordinal()];
         if (var4 != 1) {
            if (var4 != 2) {
               var29 = SetsKt.emptySet();
            } else {
               var29 = SetsKt.setOf(new ModeIcon[]{ModeIcon.NIGHT, ModeIcon.ECO});
            }
         } else {
            var29 = SetsKt.setOf(new ModeIcon[]{ModeIcon.AUTO, ModeIcon.ECO});
         }
      } else {
         var29 = SetsKt.emptySet();
      }

      if (!var5 && !var29.contains(var1)) {
         boolean var7;
         boolean var8;
         boolean var9;
         boolean var10;
         if (var2 instanceof HasCombo3in1MainMode) {
            HasCombo3in1MainMode var31 = (HasCombo3in1MainMode)var2;
            ApSubMode var14 = var31.currentSubMode();
            if (var2.isUsDevice() && var31.isInMainMode(MainMode.HEAT)) {
               var10 = true;
            } else {
               var10 = false;
            }

            if (var14 == ApSubMode.FAN) {
               var6 = true;
            } else {
               var6 = false;
            }

            if (var14 == ApSubMode.AUTO) {
               var7 = true;
            } else {
               var7 = false;
            }

            if (var14 == ApSubMode.ECO) {
               var8 = true;
            } else {
               var8 = false;
            }

            if (var14 == ApSubMode.NIGHT) {
               var3 = true;
            } else {
               var3 = false;
            }

            var9 = false;
         } else {
            label368: {
               if (var2 instanceof HasCoolMainMode) {
                  HasCoolMainMode var32 = (HasCoolMainMode)var2;
                  var6 = var32.isInSubMode(CoolSubMode.FAN);
                  var7 = var32.isInSubMode(CoolSubMode.AUTO);
                  var3 = var32.isInSubMode(CoolSubMode.NIGHT);
               } else {
                  if (!(var2 instanceof HasDehumidifierMainMode)) {
                     if (var2 instanceof HasHumMainMode) {
                        if (var2 instanceof HasWick && ((HasWick)var2).getWickdryOn()) {
                           var4 = 1;
                        } else {
                           var4 = 0;
                        }

                        HasHumMainMode var34 = (HasHumMainMode)var2;
                        if (var34.isInMainMode(MainMode.Humidification)) {
                           if (var34.isInHumSubMode(HumSubMode.FAN) && !var4) {
                              var6 = true;
                           } else {
                              var6 = false;
                           }

                           if (var34.isInHumSubMode(HumSubMode.NIGHT) && !var4) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           if (var34.isInHumSubMode(HumSubMode.SKIN) && !var4) {
                              var7 = true;
                           } else {
                              var7 = false;
                           }

                           if (var34.isInHumSubMode(HumSubMode.AUTO) && !var4) {
                              var8 = true;
                           } else {
                              var8 = false;
                           }

                           var9 = var7;
                           var7 = var8;
                           var10 = false;
                           var8 = false;
                        } else {
                           if (var34.isInApSubMode(ApSubMode.FAN) && !var4) {
                              var6 = true;
                           } else {
                              var6 = false;
                           }

                           if (var34.isInApSubMode(ApSubMode.NIGHT) && !var4) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           if (var34.isInApSubMode(ApSubMode.AUTO) && !var4) {
                              var7 = true;
                           } else {
                              var7 = false;
                           }

                           var8 = false;
                           var9 = false;
                           var10 = var9;
                        }
                     } else {
                        if (var2 instanceof HasMainMode) {
                           HasMainMode var36 = var2;
                           if (var36.isInMainMode(MainMode.AirPurify) && var36.isInApSubMode(ApSubMode.FAN)) {
                              var6 = true;
                           } else {
                              var6 = false;
                           }

                           if (var36.isInMainMode(MainMode.AirPurify) && var36.isInApSubMode(ApSubMode.NIGHT)) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           if (var36.isInMainMode(MainMode.AirPurify) && var36.isInApSubMode(ApSubMode.AUTO)) {
                              var7 = true;
                           } else {
                              var7 = false;
                           }

                           if (var36.isInMainMode(MainMode.AirPurify) && var36.isInApSubMode(ApSubMode.ECO)) {
                              var8 = true;
                           } else {
                              var8 = false;
                           }
                        } else if (var2 instanceof HasMode) {
                           HasMode var35 = (HasMode)var2;
                           var6 = var35.isInMode(Mode.FAN);
                           var7 = var35.isInMode(Mode.AUTO);
                           var8 = var35.isInMode(Mode.ECO);
                           var3 = var35.isInMode(Mode.NIGHT);
                        } else {
                           var6 = DeviceKt.isDisinfectionOn(var2);
                           if (var2 instanceof HasFanSpeed && ((HasFanSpeed)var2).getAutoMode() == AutoMode.ON && !var6) {
                              var7 = true;
                           } else {
                              var7 = false;
                           }

                           if (var2 instanceof HasEcoMode && ((HasEcoMode)var2).isEcoModeOn() && !var6) {
                              var8 = true;
                           } else {
                              var8 = false;
                           }

                           if (var2 instanceof HasG4NightMode && ((HasG4NightMode)var2).isG4NightModeOn() && !var6) {
                              var3 = true;
                           } else {
                              var3 = false;
                           }

                           if (!var7 && !var3 && !var8 && !var6) {
                              var6 = true;
                           } else {
                              var6 = false;
                           }
                        }

                        var10 = false;
                        var9 = false;
                     }
                     break label368;
                  }

                  HasDehumidifierMainMode var33 = var2;
                  if (var33.isInMainMode(MainMode.AirPurify) && var33.isInApSubMode(ApSubMode.FAN)) {
                     var6 = true;
                  } else {
                     var6 = false;
                  }

                  if (var33.isInMainMode(MainMode.AirPurify) && var33.isInApSubMode(ApSubMode.NIGHT)) {
                     var3 = true;
                  } else {
                     var3 = false;
                  }

                  if (var33.isInMainMode(MainMode.Dehumidification) && var33.isInDehSubMode(DehSubMode.AUTO)) {
                     var7 = true;
                  } else {
                     var7 = false;
                  }
               }

               var10 = false;
               var8 = false;
               var9 = var8;
            }
         }

         label426: {
            if (!var12 || !((DeviceHumidifier20)var2).getWickdryOn()) {
               label248: {
                  label247: {
                     switch (DeviceModeButtonV2Holder.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()]) {
                        case 1:
                           var3 = var6;
                        case 2:
                           break label248;
                        case 3:
                        case 4:
                           if (!(var2 instanceof DeviceNewClassic)) {
                              var3 = var7;
                              break label248;
                           }

                           if (!var7 && !var8) {
                              break label247;
                           }
                           break;
                        case 5:
                           var3 = var8;
                           break label248;
                        case 6:
                           var3 = var9;
                           break label248;
                        case 7:
                           if (!(var2 instanceof HasStandBy) || !((HasStandBy)var2).isStandByOn()) {
                              break label247;
                           }
                           break;
                        case 8:
                           if (!(var2 instanceof HasChildLock) || !((HasChildLock)var2).isChildLockOn()) {
                              break label247;
                           }
                           break;
                        case 9:
                           if (!(var2 instanceof HasDisinfection) || !DeviceKt.isDisinfectionOn(var2)) {
                              break label247;
                           }
                           break;
                        case 10:
                           if (!(var2 instanceof HasPetMainMode) || !((HasPetMainMode)var2).isInMainMode(MainMode.SMART)) {
                              break label247;
                           }
                           break;
                        case 11:
                        case 12:
                           if (!(var2 instanceof HasDehumidifierMainMode)) {
                              break label247;
                           }

                           var2 = var2;
                           if (!var2.isInMainMode(MainMode.Dehumidification) || !var2.isInDehSubMode(DehSubMode.DRYING)) {
                              break label247;
                           }
                           break;
                        case 13:
                           if (var2 instanceof HasDehumidifierMainMode) {
                              var2 = var2;
                              if (!var2.isInMainMode(MainMode.Dehumidification) || !var2.isInDehSubMode(DehSubMode.CONTINUOUS)) {
                                 break label247;
                              }
                              break;
                           }
                        default:
                           break label247;
                     }

                     var3 = true;
                     break label248;
                  }

                  var3 = false;
               }

               if (var3) {
                  var3 = var11;
                  break label426;
               }
            }

            var3 = false;
         }

         HolderDeviceModeButtonV2Binding var38 = this.binding;
         var38.modeRoot.setTag(var3);
         var38.modeRoot.setEnabled(var10 ^ true);
         TextView var37 = var38.modeText;
         Resources var18 = this.itemView.getResources();
         if (var10) {
            var4 = R.color.surface_dark_55;
         } else if (var3) {
            var4 = R.color.colorPrimaryText;
         } else {
            var4 = R.color.surface_dark_65;
         }

         var37.setTextColor(var18.getColor(var4, (Resources.Theme)null));
         var38.modeIcon.setImageResource(var1.obtainIconV2Res(var3, var10));
      } else {
         HolderDeviceModeButtonV2Binding var15 = this.binding;
         var15.modeRoot.setTag(false);
         var15.modeRoot.setEnabled(false);
         var15.modeIcon.setImageResource(var1.getDisabledIconV2());
         var15.modeText.setTextColor(this.itemView.getResources().getColor(R.color.surface_dark_55, (Resources.Theme)null));
      }
   }

   public final HolderDeviceModeButtonV2Binding getBinding() {
      return this.binding;
   }

   public final void updateMode(ModeIcon var1, Device var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      Intrinsics.checkNotNullParameter(var2, "device");
      if (!this.forMainMode) {
         this.updateSubmode(var1, var2, var3);
      } else {
         boolean var8 = DeviceKt.isStandByOn(var2);
         boolean var5 = false;
         boolean var6 = false;
         boolean var7 = true;
         boolean var4;
         if (!var8 && var2.isOnline() && !var3) {
            var4 = 0;
         } else {
            var4 = 1;
         }

         this.binding.modeText.setText(var1.getText());
         HolderDeviceModeButtonV2Binding var9 = this.binding;
         if (var4) {
            var6 = var5;
            var3 = var7;
         } else if (var2 instanceof HasCombo3in1MainMode) {
            if (var1.toMainMode() == ((HasCombo3in1MainMode)var2).mainMode()) {
               var3 = true;
            } else {
               var3 = false;
            }

            var5 = var6;
            if (var2.isUsDevice()) {
               var5 = var6;
               if (var1 == ModeIcon.HEAT) {
                  var5 = true;
               }
            }

            var6 = var3;
            var3 = var5;
         } else {
            var3 = false;
            var6 = var5;
         }

         var9.modeRoot.setTag(var6);
         var9.modeRoot.setEnabled(var3 ^ true);
         var9.modeIcon.setImageResource(var1.obtainIconV2Res(var6, var3));
         TextView var11 = var9.modeText;
         Resources var10 = this.itemView.getResources();
         if (var3) {
            var4 = R.color.surface_dark_55;
         } else if (var6) {
            var4 = R.color.colorPrimaryText;
         } else {
            var4 = R.color.surface_dark_65;
         }

         var11.setTextColor(var10.getColor(var4, (Resources.Theme)null));
      }
   }

   public final void updateMode(ModeIcon var1, Set var2, Set var3, Set var4) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      Intrinsics.checkNotNullParameter(var2, "modeValues");
      Intrinsics.checkNotNullParameter(var3, "stayOffIcons");
      Intrinsics.checkNotNullParameter(var4, "disableModeIcons");
      HolderDeviceModeButtonV2Binding var8 = this.binding;
      TextView var9 = var8.modeText;
      int var5;
      if (this.forMainMode) {
         var5 = var1.getText();
      } else {
         var5 = var1.getTextShort();
      }

      var9.setText(var5);
      boolean var6 = var2.contains(ModeIcon.STANDBY);
      boolean var7 = false;
      if (!var6 && !var4.contains(var1)) {
         var8.modeRoot.setEnabled(true);
         var6 = var7;
         if (var2.contains(var1)) {
            var6 = var7;
            if (!var3.contains(var1)) {
               var6 = true;
            }
         }

         var8.modeRoot.setTag(var6);
         TextView var11 = var8.modeText;
         Resources var10 = this.itemView.getResources();
         if (var6) {
            var5 = R.color.colorPrimaryText;
         } else {
            var5 = R.color.surface_dark_65;
         }

         var11.setTextColor(var10.getColor(var5, (Resources.Theme)null));
         if (var6) {
            var5 = var1.getOnIconV2();
         } else {
            var5 = var1.getOffIconV2();
         }

         var8.modeIcon.setImageResource(var5);
      } else {
         var8.modeRoot.setTag(false);
         var8.modeRoot.setEnabled(false);
         var8.modeIcon.setImageResource(var1.getDisabledIconV2());
         var8.modeText.setTextColor(this.itemView.getResources().getColor(R.color.surface_dark_55, (Resources.Theme)null));
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonV2Holder;", "parentView", "Landroid/view/ViewGroup;", "forMainMode", "", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      // $FF: synthetic method
      public static Unit $r8$lambda$de4lATFBzZ7aIVrlP38BjQLZr7E(View var0, AccessibilityNodeInfoCompat var1) {
         return newInstance$lambda$0(var0, var1);
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      private static final Unit newInstance$lambda$0(View var0, AccessibilityNodeInfoCompat var1) {
         Intrinsics.checkNotNullParameter(var0, "v");
         Intrinsics.checkNotNullParameter(var1, "info");
         var1.setSelected(Intrinsics.areEqual(var0.getTag(), true));
         return Unit.INSTANCE;
      }

      public final DeviceModeButtonV2Holder newInstance(ViewGroup var1, boolean var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceModeButtonV2Binding var3 = HolderDeviceModeButtonV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         ViewUtils var4 = ViewUtils.INSTANCE;
         FrameLayout var5 = var3.getRoot();
         Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
         ViewUtils.setAccessibilityDelegate$default(var4, (View)var5, Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, new DeviceModeButtonV2Holder$Companion$$ExternalSyntheticLambda0(), 4, (Object)null);
         if (var2) {
            var3.modeText.setMaxLines(2);
         }

         return new DeviceModeButtonV2Holder(var3, var2);
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
            var0[MainMode.COOL.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ModeIcon.values().length];

         try {
            var0[ModeIcon.FAN_SPEED.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[ModeIcon.NIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[ModeIcon.AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[ModeIcon.WATERDROP_AUTO.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[ModeIcon.ECO.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[ModeIcon.SKIN.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[ModeIcon.STANDBY.ordinal()] = 7;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[ModeIcon.CHILD_LOCK.ordinal()] = 8;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[ModeIcon.DISINFECTION.ordinal()] = 9;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ModeIcon.SMART.ordinal()] = 10;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ModeIcon.DRYING.ordinal()] = 11;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ModeIcon.BOOST.ordinal()] = 12;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ModeIcon.CONTINUOUS.ordinal()] = 13;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
