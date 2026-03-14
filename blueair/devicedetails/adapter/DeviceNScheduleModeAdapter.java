package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.devicedetails.viewholder.DeviceAttributeHolder;
import com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder;
import com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceNOnOffButtonHolder;
import com.blueair.devicedetails.viewholder.DeviceNScheduleCustomTypeHolder;
import com.blueair.devicedetails.viewholder.DeviceOscillationHolder;
import com.blueair.devicedetails.viewholder.DeviceSubAutoHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b+\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TBw\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010I\u001a\u00020JH\u0002J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0010H\u0016J\b\u0010O\u001a\u00020\u0010H\u0016J\u0010\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u0010H\u0016J\u0018\u0010R\u001a\u00020J2\u0006\u0010S\u001a\u00020\u00022\u0006\u0010Q\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010 R$\u0010\u0007\u001a\u00020\b2\u0006\u0010!\u001a\u00020\b@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\n2\u0006\u0010!\u001a\u00020\n@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010\u0011\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u0013\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u000b\u001a\u00020\f2\u0006\u0010!\u001a\u00020\f@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010<R\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010 R$\u0010\u001b\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010AR\u001e\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR*\u0010F\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020E0D@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bG\u0010H¨\u0006U"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "device", "Lcom/blueair/core/model/Device;", "isStartMode", "", "customType", "", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "autoRh", "", "mainMode", "Lcom/blueair/core/model/MainMode;", "apSubMode", "Lcom/blueair/core/model/ApSubMode;", "smartSubMode", "Lcom/blueair/core/model/SmartSubMode;", "heatAutoTemp", "", "heatEcoTmp", "oscillationEnabled", "humMode", "<init>", "(Lcom/blueair/core/model/Device;ZLjava/lang/String;Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;ILcom/blueair/core/model/MainMode;Lcom/blueair/core/model/ApSubMode;Lcom/blueair/core/model/SmartSubMode;DDZZ)V", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "value", "getCustomType", "()Ljava/lang/String;", "setCustomType", "(Ljava/lang/String;)V", "lastMode", "getMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "getMainMode", "()Lcom/blueair/core/model/MainMode;", "setMainMode", "(Lcom/blueair/core/model/MainMode;)V", "getApSubMode", "()Lcom/blueair/core/model/ApSubMode;", "setApSubMode", "(Lcom/blueair/core/model/ApSubMode;)V", "getFanSpeed", "()Lcom/blueair/core/model/FanSpeedEnum;", "setFanSpeed", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "getBrightness", "()Ljava/lang/Object;", "getAutoRh", "()I", "getHeatAutoTemp", "()D", "getHeatEcoTmp", "getOscillationEnabled", "getHumMode", "setHumMode", "(Z)V", "getSmartSubMode", "()Lcom/blueair/core/model/SmartSubMode;", "", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter$ModeControl;", "modeControls", "setModeControls", "(Ljava/util/List;)V", "refreshControls", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "ModeControl", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNScheduleModeAdapter extends RecyclerView.Adapter {
   private ApSubMode apSubMode;
   private int autoRh;
   private Object brightness;
   private String customType;
   private final Device device;
   private FanSpeedEnum fanSpeed;
   private double heatAutoTemp;
   private double heatEcoTmp;
   private boolean humMode;
   private final boolean isStartMode;
   private DeviceCreateEditScheduleViewModel.PurifierMode lastMode;
   private MainMode mainMode;
   private DeviceCreateEditScheduleViewModel.PurifierMode mode;
   private List modeControls;
   private boolean oscillationEnabled;
   private SmartSubMode smartSubMode;

   // $FF: synthetic method
   public static Unit $r8$lambda$_qmhQVPgR_yrWErRSb_csVW7e9o/* $FF was: $r8$lambda$-qmhQVPgR-yrWErRSb-csVW7e9o*/(DeviceNScheduleModeAdapter var0, String var1) {
      return onBindViewHolder$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Beoh7zQc0uqMenauJRxVG7_ITM4(DeviceNScheduleModeAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      return onCreateViewHolder$lambda$9(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$C39DMHtFGf9_aIRNJv9tHzsKmik/* $FF was: $r8$lambda$C39DMHtFGf9-aIRNJv9tHzsKmik*/(DeviceNScheduleModeAdapter var0) {
      return onCreateViewHolder$lambda$8(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ClBDiPrfIhSdXVj_XVgffmraZ_Y/* $FF was: $r8$lambda$ClBDiPrfIhSdXVj_XVgffmraZ-Y*/(DeviceNScheduleModeAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$DWNVNwV98UJv4gvsTwN9spbwoYE(DeviceNScheduleModeAdapter var0, int var1) {
      return onCreateViewHolder$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$M_G7Im_TOeS34bvJn87zyJtD9LI/* $FF was: $r8$lambda$M-G7Im_TOeS34bvJn87zyJtD9LI*/(DeviceNScheduleModeAdapter var0, int var1) {
      return onCreateViewHolder$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$XgiCZJvtVwSFMnBtsj8fnapsZ9U(DeviceNScheduleModeAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      return onCreateViewHolder$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_tyuQJGI0HamnKJXgAox4OXr79s() {
      return onCreateViewHolder$lambda$6();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$aOyXdDPYoVoH_9eb_9pMs4taa4A/* $FF was: $r8$lambda$aOyXdDPYoVoH_9eb-9pMs4taa4A*/(DeviceNScheduleModeAdapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$he__tHE_4Zi5ANawkrWruzKcK8Q/* $FF was: $r8$lambda$he--tHE-4Zi5ANawkrWruzKcK8Q*/(DeviceNScheduleModeAdapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mS5HwzhZGZWLrsmaG_K303oq3zo/* $FF was: $r8$lambda$mS5HwzhZGZWLrsmaG-K303oq3zo*/(DeviceNScheduleModeAdapter var0, MainMode var1) {
      return onCreateViewHolder$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$s4PYMuTSXPpLeJVJZC3_niEPrO4() {
      return onCreateViewHolder$lambda$13();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$sXYRv4BnqxoQ1oFDmFiF4Y8vAus(DeviceNScheduleModeAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tDi06tNbGYmYkMe3uqdq4QUL9_g(DeviceNScheduleModeAdapter var0, double var1) {
      return onCreateViewHolder$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uiJHt9jUEs5OA_Ie3t7rUywI3Zg(DeviceNScheduleModeAdapter var0, ApSubMode var1) {
      return onCreateViewHolder$lambda$1(var0, var1);
   }

   public DeviceNScheduleModeAdapter(Device var1, boolean var2, String var3, DeviceCreateEditScheduleViewModel.PurifierMode var4, FanSpeedEnum var5, Object var6, int var7, MainMode var8, ApSubMode var9, SmartSubMode var10, double var11, double var13, boolean var15, boolean var16) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var3, "customType");
      Intrinsics.checkNotNullParameter(var4, "mode");
      Intrinsics.checkNotNullParameter(var5, "fanSpeed");
      Intrinsics.checkNotNullParameter(var6, "brightness");
      Intrinsics.checkNotNullParameter(var8, "mainMode");
      Intrinsics.checkNotNullParameter(var9, "apSubMode");
      Intrinsics.checkNotNullParameter(var10, "smartSubMode");
      super();
      this.device = var1;
      this.isStartMode = var2;
      this.customType = var3;
      this.lastMode = var4;
      this.mode = var4;
      this.mainMode = var8;
      this.apSubMode = var9;
      this.fanSpeed = var5;
      this.brightness = var6;
      this.autoRh = var7;
      this.heatAutoTemp = var11;
      this.heatEcoTmp = var13;
      this.oscillationEnabled = var15;
      this.humMode = var16;
      this.smartSubMode = var10;
      this.modeControls = CollectionsKt.emptyList();
      this.refreshControls();
   }

   private static final Unit onBindViewHolder$lambda$15(DeviceNScheduleModeAdapter var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.setCustomType(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$0(DeviceNScheduleModeAdapter var0, MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.setMainMode(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$1(DeviceNScheduleModeAdapter var0, ApSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.setApSubMode(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$10(DeviceNScheduleModeAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      var0.setHumMode(var0.humMode ^ true);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$11(DeviceNScheduleModeAdapter var0, double var1) {
      if (var0.device instanceof HasCombo3in1MainMode) {
         ApSubMode var4 = var0.apSubMode;
         int var3 = DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$1[var4.ordinal()];
         if (var3 != 2) {
            if (var3 == 3) {
               var0.heatEcoTmp = var1;
            }
         } else {
            var0.heatAutoTemp = var1;
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$12(DeviceNScheduleModeAdapter var0, boolean var1) {
      var0.oscillationEnabled = var1;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$13() {
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$14(DeviceNScheduleModeAdapter var0, boolean var1) {
      SmartSubMode var2;
      if (var1) {
         var2 = SmartSubMode.AUTO_ON;
      } else {
         var2 = SmartSubMode.AUTO_OFF;
      }

      var0.smartSubMode = var2;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$3(DeviceNScheduleModeAdapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "selectedMode");
      DeviceCreateEditScheduleViewModel.PurifierMode var2 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromModeIcon(var1);
      if (var2 != null) {
         var0.setMode(var2);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$4(DeviceNScheduleModeAdapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.setFanSpeed(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$5(DeviceNScheduleModeAdapter var0, int var1) {
      var0.brightness = var1;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$6() {
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$7(DeviceNScheduleModeAdapter var0, int var1) {
      var0.autoRh = var1;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$8(DeviceNScheduleModeAdapter var0) {
      DeviceCreateEditScheduleViewModel.PurifierMode var1;
      if (var0.mode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         if (var0.lastMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            var1 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
         } else {
            var1 = var0.lastMode;
         }
      } else {
         var1 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
      }

      var0.setMode(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$9(DeviceNScheduleModeAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      DeviceCreateEditScheduleViewModel.PurifierMode var3;
      if (var0.mode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         if (var0.lastMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            if (var0.device instanceof DevicePet20) {
               var3 = DeviceCreateEditScheduleViewModel.PurifierMode.SMART;
            } else {
               var3 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            }
         } else {
            var3 = var0.lastMode;
         }
      } else {
         var3 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
      }

      var0.setMode(var3);
      return Unit.INSTANCE;
   }

   private final void refreshControls() {
      List var2 = (List)(new ArrayList());
      if (!this.isStartMode) {
         var2.add(DeviceNScheduleModeAdapter.ModeControl.CUSTOM_TYPE);
         if (!Intrinsics.areEqual(this.customType, "custom")) {
            this.setModeControls(var2);
            return;
         }
      }

      Device var3 = this.device;
      if (var3 instanceof HasPetMainMode) {
         var2.add(DeviceNScheduleModeAdapter.ModeControl.ON_OFF);
         if (this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            var2.add(DeviceNScheduleModeAdapter.ModeControl.MODE_BUTTONS);
            DeviceCreateEditScheduleViewModel.PurifierMode var7 = this.mode;
            int var1 = DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
            if (var1 != 1) {
               if (var1 == 2) {
                  var2.add(DeviceNScheduleModeAdapter.ModeControl.FAN_SPEED);
                  var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
               }
            } else {
               var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
            }
         }
      } else if (var3 instanceof HasCombo3in1MainMode) {
         var2.add(DeviceNScheduleModeAdapter.ModeControl.ON_OFF);
         var2.add(DeviceNScheduleModeAdapter.ModeControl.MAIN_MODE_BUTTONS);
         if (this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY && (!this.device.isUsDevice() || this.mainMode != MainMode.HEAT)) {
            ApSubMode var8 = this.apSubMode;
            int var4 = DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$1[var8.ordinal()];
            if (var4 != 1) {
               if (var4 != 2) {
                  if (var4 != 3) {
                     if (var4 == 4 && this.device instanceof HasOscillation) {
                        var2.add(DeviceNScheduleModeAdapter.ModeControl.OSCILLATION);
                     }
                  } else if (this.mainMode == MainMode.HEAT) {
                     var2.add(DeviceNScheduleModeAdapter.ModeControl.TARGET_TEMPERATURE);
                  }
               } else {
                  if (this.device instanceof HasAutoRh) {
                     var2.add(DeviceNScheduleModeAdapter.ModeControl.AUTO_RH);
                  }

                  if (this.mainMode == MainMode.HEAT) {
                     var2.add(DeviceNScheduleModeAdapter.ModeControl.TARGET_TEMPERATURE);
                  }

                  if (this.device instanceof HasOscillation) {
                     var2.add(DeviceNScheduleModeAdapter.ModeControl.OSCILLATION);
                  }

                  var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
               }
            } else {
               var2.add(DeviceNScheduleModeAdapter.ModeControl.FAN_SPEED);
               if (this.device instanceof HasOscillation && this.fanSpeed.compareTo(FanSpeedEnum.OFF) > 0) {
                  var2.add(DeviceNScheduleModeAdapter.ModeControl.OSCILLATION);
               }

               var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
            }
         }
      } else if (var3 instanceof HasMode) {
         var2.add(DeviceNScheduleModeAdapter.ModeControl.ON_OFF);
         if (this.device instanceof HasHumMode && this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            var2.add(DeviceNScheduleModeAdapter.ModeControl.HUM_MODE);
         }

         var2.add(DeviceNScheduleModeAdapter.ModeControl.MODE_BUTTONS);
         DeviceCreateEditScheduleViewModel.PurifierMode var9 = this.mode;
         int var5 = DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$0[var9.ordinal()];
         if (var5 != 2) {
            if (var5 == 3) {
               Device var10 = this.device;
               if (var10 instanceof HasAutoRh && (!(var10 instanceof HasHumMode) || this.humMode)) {
                  var2.add(DeviceNScheduleModeAdapter.ModeControl.AUTO_RH);
               }

               var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
            }
         } else {
            var2.add(DeviceNScheduleModeAdapter.ModeControl.FAN_SPEED);
            var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
         }
      } else {
         var2.add(DeviceNScheduleModeAdapter.ModeControl.MODE_BUTTONS);
         DeviceCreateEditScheduleViewModel.PurifierMode var11 = this.mode;
         int var6 = DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$0[var11.ordinal()];
         if (var6 != 2) {
            if (var6 != 3) {
               if (var6 == 4 && !(this.device instanceof DeviceNewClassic)) {
                  var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
               }
            } else {
               Device var12 = this.device;
               if (var12 instanceof HasAutoRh && (!(var12 instanceof HasHumMode) || this.humMode)) {
                  var2.add(DeviceNScheduleModeAdapter.ModeControl.AUTO_RH);
               }

               var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
            }
         } else {
            var2.add(DeviceNScheduleModeAdapter.ModeControl.FAN_SPEED);
            var2.add(DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS);
         }

         var2.add(DeviceNScheduleModeAdapter.ModeControl.ON_OFF);
      }

      this.setModeControls(var2);
   }

   private final void setApSubMode(ApSubMode var1) {
      if (this.apSubMode != var1) {
         this.apSubMode = var1;
         this.refreshControls();
      }
   }

   private final void setCustomType(String var1) {
      if (!Intrinsics.areEqual(this.customType, var1)) {
         this.customType = var1;
         this.refreshControls();
      }
   }

   private final void setFanSpeed(FanSpeedEnum var1) {
      if (this.fanSpeed != var1) {
         this.fanSpeed = var1;
         if (this.device instanceof HasCombo3in1MainMode) {
            this.refreshControls();
         }
      }

   }

   private final void setHumMode(boolean var1) {
      if (this.humMode != var1) {
         this.humMode = var1;
         this.refreshControls();
      }
   }

   private final void setMainMode(MainMode var1) {
      if (this.mainMode != var1) {
         this.mainMode = var1;
         this.setApSubMode(ApSubMode.FAN);
         this.setFanSpeed(FanSpeedEnum.ELEVEN);
         this.refreshControls();
      }
   }

   private final void setMode(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      DeviceCreateEditScheduleViewModel.PurifierMode var2 = this.mode;
      if (var2 != var1) {
         this.lastMode = var2;
         this.mode = var1;
         this.refreshControls();
      }
   }

   private final void setModeControls(List var1) {
      this.modeControls = var1;
      this.notifyDataSetChanged();
   }

   public final ApSubMode getApSubMode() {
      return this.apSubMode;
   }

   public final int getAutoRh() {
      return this.autoRh;
   }

   public final Object getBrightness() {
      return this.brightness;
   }

   public final String getCustomType() {
      return this.customType;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final FanSpeedEnum getFanSpeed() {
      return this.fanSpeed;
   }

   public final double getHeatAutoTemp() {
      return this.heatAutoTemp;
   }

   public final double getHeatEcoTmp() {
      return this.heatEcoTmp;
   }

   public final boolean getHumMode() {
      return this.humMode;
   }

   public int getItemCount() {
      return this.modeControls.size();
   }

   public int getItemViewType(int var1) {
      return ((ModeControl)this.modeControls.get(var1)).ordinal();
   }

   public final MainMode getMainMode() {
      return this.mainMode;
   }

   public final DeviceCreateEditScheduleViewModel.PurifierMode getMode() {
      return this.mode;
   }

   public final boolean getOscillationEnabled() {
      return this.oscillationEnabled;
   }

   public final SmartSubMode getSmartSubMode() {
      return this.smartSubMode;
   }

   public final boolean isStartMode() {
      return this.isStartMode;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof DeviceNScheduleCustomTypeHolder) {
         var1 = (DeviceNScheduleCustomTypeHolder)var1;
         var1.update(this.customType);
         var1.setOnTypeSelectedListener(new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda5(this));
      } else if (var1 instanceof DeviceNModeButtonsHolder) {
         ((DeviceNModeButtonsHolder)var1).update(this.device, this.mode);
      } else if (var1 instanceof DeviceNFanSpeedHolder) {
         ((DeviceNFanSpeedHolder)var1).update(this.fanSpeed);
      } else {
         if (var1 instanceof DeviceNBrightnessHolder) {
            Object var7 = this.brightness;
            boolean var3 = var7 instanceof Brightness;
            Object var8 = null;
            Brightness var20;
            if (var3) {
               var20 = (Brightness)var7;
            } else {
               var20 = null;
            }

            if (var20 != null) {
               ((DeviceNBrightnessHolder)var1).update(var20.toPercentage());
            }

            Object var9 = this.brightness;
            Integer var21 = (Integer)var8;
            if (var9 instanceof Integer) {
               var21 = (Integer)var9;
            }

            if (var21 != null) {
               var2 = ((Number)var21).intValue();
               ((DeviceNBrightnessHolder)var1).update(var2);
               return;
            }
         } else if (var1 instanceof DeviceHAuthRhHolder) {
            Integer var22 = this.autoRh;
            if (var22 != null) {
               var2 = ((Number)var22).intValue();
               ((DeviceHAuthRhHolder)var1).update(var2);
               return;
            }
         } else {
            boolean var6 = var1 instanceof DeviceNOnOffButtonHolder;
            boolean var17 = true;
            boolean var4 = true;
            boolean var5 = true;
            if (var6) {
               var1 = (DeviceNOnOffButtonHolder)var1;
               if (this.mode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                  var17 = var5;
               } else {
                  var17 = false;
               }

               var1.update(var17);
               return;
            }

            if (var1 instanceof DeviceMainModeButtonsHolder) {
               DeviceMainModeButtonsHolder var25 = (DeviceMainModeButtonsHolder)var1;
               Device var11 = this.device;
               MainMode var26 = this.mainMode;
               ApSubMode var24 = this.apSubMode;
               if (this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                  var17 = false;
               }

               var25.update(var11, var26, var24, var17);
               return;
            }

            if (var1 instanceof DeviceCOnOffButtonHolder) {
               var1 = var1;
               if (var1.getType() == DeviceCOnOffButtonHolder.Type.HUM) {
                  var17 = this.humMode;
               } else if (this.mode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                  var17 = var4;
               } else {
                  var17 = false;
               }

               var1.update(var17);
               return;
            }

            if (var1 instanceof DeviceC3FanSpeedHolder) {
               ((DeviceC3FanSpeedHolder)var1).update(this.fanSpeed);
               return;
            }

            if (var1 instanceof DeviceOscillationHolder) {
               ((DeviceOscillationHolder)var1).update(this.device, this.oscillationEnabled);
               return;
            }

            if (var1 instanceof DeviceTargetTemperatureHolder) {
               ApSubMode var23 = this.apSubMode;
               var2 = DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$1[var23.ordinal()];
               if (var2 == 2) {
                  ((DeviceTargetTemperatureHolder)var1).update(this.heatAutoTemp);
                  return;
               }

               if (var2 == 3) {
                  ((DeviceTargetTemperatureHolder)var1).update(this.heatEcoTmp);
                  return;
               }
            } else if (var1 instanceof DeviceSubAutoHolder) {
               ((DeviceSubAutoHolder)var1).update(this.smartSubMode);
            }
         }

      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      ModeControl var3 = (ModeControl)DeviceNScheduleModeAdapter.ModeControl.getEntries().get(var2);
      switch (DeviceNScheduleModeAdapter.WhenMappings.$EnumSwitchMapping$2[var3.ordinal()]) {
         case 1:
            return DeviceNScheduleCustomTypeHolder.Companion.newInstance(var1, this.device);
         case 2:
            return DeviceMainModeButtonsHolder.Companion.newInstance(var1, this.device, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda0(this), new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda10(this));
         case 3:
            return DeviceNModeButtonsHolder.Companion.newInstance(var1, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda11(this));
         case 4:
            return DeviceNFanSpeedHolder.Companion.newInstance(var1, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda12(this));
         case 5:
            return DeviceNBrightnessHolder.Companion.newInstance(var1, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda13(this));
         case 6:
            return DeviceHAuthRhHolder.Companion.newInstance(var1, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda14(), new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda1(this));
         case 7:
            Device var5 = this.device;
            DeviceAttributeHolder var4;
            if (!(var5 instanceof DeviceNewClassic) && !(var5 instanceof DeviceHumidifier)) {
               var4 = DeviceCOnOffButtonHolder.Companion.newInstance(var1, this.device, DeviceCOnOffButtonHolder.Type.STANDBY, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda3(this));
            } else {
               var4 = DeviceNOnOffButtonHolder.Companion.newInstance(var1, this.device, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda2(this));
            }

            return var4;
         case 8:
            return DeviceCOnOffButtonHolder.Companion.newInstance(var1, this.device, DeviceCOnOffButtonHolder.Type.HUM, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda4(this));
         case 9:
            return DeviceTargetTemperatureHolder.Companion.newInstance(var1, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda6(this));
         case 10:
            return DeviceOscillationHolder.Companion.newInstance(var1, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda7(this), new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda8());
         case 11:
            return DeviceSubAutoHolder.Companion.newInstance(var1, this.device, true, new DeviceNScheduleModeAdapter$$ExternalSyntheticLambda9(this));
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter$ModeControl;", "", "<init>", "(Ljava/lang/String;I)V", "CUSTOM_TYPE", "MAIN_MODE_BUTTONS", "MODE_BUTTONS", "FAN_SPEED", "BRIGHTNESS", "AUTO_RH", "ON_OFF", "HUM_MODE", "TARGET_TEMPERATURE", "OSCILLATION", "SUB_AUTO", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum ModeControl {
      private static final EnumEntries $ENTRIES;
      private static final ModeControl[] $VALUES;
      AUTO_RH,
      BRIGHTNESS,
      CUSTOM_TYPE,
      FAN_SPEED,
      HUM_MODE,
      MAIN_MODE_BUTTONS,
      MODE_BUTTONS,
      ON_OFF,
      OSCILLATION,
      SUB_AUTO,
      TARGET_TEMPERATURE;

      // $FF: synthetic method
      private static final ModeControl[] $values() {
         return new ModeControl[]{CUSTOM_TYPE, MAIN_MODE_BUTTONS, MODE_BUTTONS, FAN_SPEED, BRIGHTNESS, AUTO_RH, ON_OFF, HUM_MODE, TARGET_TEMPERATURE, OSCILLATION, SUB_AUTO};
      }

      static {
         ModeControl[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
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
      public static final int[] $EnumSwitchMapping$2;

      static {
         int[] var0 = new int[DeviceCreateEditScheduleViewModel.PurifierMode.values().length];

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.SMART.ordinal()] = 1;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL.ordinal()] = 2;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.ECO.ordinal()] = 4;
         } catch (NoSuchFieldError var17) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[ApSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[ApSubMode.ECO.ordinal()] = 3;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[ApSubMode.NIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var13) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[DeviceNScheduleModeAdapter.ModeControl.values().length];

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.CUSTOM_TYPE.ordinal()] = 1;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.MAIN_MODE_BUTTONS.ordinal()] = 2;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.MODE_BUTTONS.ordinal()] = 3;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.FAN_SPEED.ordinal()] = 4;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.BRIGHTNESS.ordinal()] = 5;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.AUTO_RH.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.ON_OFF.ordinal()] = 7;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.HUM_MODE.ordinal()] = 8;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.TARGET_TEMPERATURE.ordinal()] = 9;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.OSCILLATION.ordinal()] = 10;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceNScheduleModeAdapter.ModeControl.SUB_AUTO.ordinal()] = 11;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$2 = var0;
      }
   }
}
