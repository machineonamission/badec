package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder;
import com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder;
import com.blueair.devicedetails.viewholder.DeviceHumidificationHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder;
import com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder;
import com.blueair.devicedetails.viewholder.DeviceOscillationV2Holder;
import com.blueair.devicedetails.viewholder.DeviceScheduleCustomTypeV2Holder;
import com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetTemperatureV2Holder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b*\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003ghiB\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\b\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\b\u0012\u0016\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010Y\u001a\u00020\u001dH\u0002J\u0018\u0010Z\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u0014H\u0016J\b\u0010^\u001a\u00020\u0014H\u0016J\u0010\u0010_\u001a\u00020\u00142\u0006\u0010`\u001a\u00020\u0014H\u0016J\u0018\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u00022\u0006\u0010`\u001a\u00020\u0014H\u0016J\b\u0010c\u001a\u00020\bH\u0002J\u0010\u0010d\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020RH\u0002J\b\u0010f\u001a\u00020\bH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u001a\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c\u0012\u0004\u0012\u00020\u001d0\u001b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R$\u0010\t\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R&\u0010\r\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010\u0011\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R$\u0010\u0015\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u001e\u0010D\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0017@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bE\u0010CR\u001e\u0010\u0019\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bF\u0010,R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020I0H8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020I0H8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010KR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020I0H8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bO\u0010KR\u000e\u0010P\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010S\u001a\b\u0012\u0004\u0012\u00020R0Q2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020R0Q@CX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\bT\u0010UR$\u0010V\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010,\"\u0004\bX\u0010.¨\u0006j"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "device", "Lcom/blueair/core/model/Device;", "group", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "isStartMode", "", "customType", "", "mainMode", "Lcom/blueair/core/model/MainMode;", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "fanSpeed", "Lcom/blueair/core/model/FanSpeedEnum;", "brightness", "", "autoRh", "", "humMode", "heatAutoTemp", "", "heatEcoTemp", "oscillationEnabled", "onActionListener", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "(Lcom/blueair/core/model/Device;Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;ZLjava/lang/String;Lcom/blueair/core/model/MainMode;Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Object;IZDDZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "getGroup", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "getOnActionListener", "()Lkotlin/jvm/functions/Function1;", "value", "getCustomType", "()Ljava/lang/String;", "setCustomType", "(Ljava/lang/String;)V", "isStandByOn", "()Z", "setStandByOn", "(Z)V", "getMainMode", "()Lcom/blueair/core/model/MainMode;", "setMainMode", "(Lcom/blueair/core/model/MainMode;)V", "expectedValue", "getMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "getFanSpeed", "()Lcom/blueair/core/model/FanSpeedEnum;", "setFanSpeed", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "getBrightness", "()Ljava/lang/Object;", "getAutoRh", "()I", "getHumMode", "setHumMode", "getHeatAutoTemp", "()D", "heatEcoTmp", "getHeatEcoTmp", "getOscillationEnabled", "stayOffSubModes", "", "Lcom/blueair/viewcore/utils/ModeIcon;", "getStayOffSubModes", "()Ljava/util/Set;", "disableMainModes", "getDisableMainModes", "disableSubModes", "getDisableSubModes", "firstRefresh", "", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ModeControl;", "modeControls", "setModeControls", "(Ljava/util/List;)V", "endTypeHintClosedBefore", "getEndTypeHintClosedBefore", "setEndTypeHintClosedBefore", "refreshControls", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "isHumOn", "notifyControlChange", "modeControl", "hasHumidification", "ControlGroup", "ModeControl", "Action", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceScheduleModeV2Adapter extends RecyclerView.Adapter {
   private int autoRh;
   private Object brightness;
   private String customType;
   private final Device device;
   private boolean endTypeHintClosedBefore;
   private FanSpeedEnum fanSpeed;
   private boolean firstRefresh;
   private final ControlGroup group;
   private double heatAutoTemp;
   private double heatEcoTmp;
   private boolean humMode;
   private boolean isStandByOn;
   private final boolean isStartMode;
   private MainMode mainMode;
   private DeviceCreateEditScheduleViewModel.PurifierMode mode;
   private List modeControls;
   private final Function1 onActionListener;
   private boolean oscillationEnabled;

   // $FF: synthetic method
   public static Unit $r8$lambda$6Fn7ZhTYujcPqofjDErbsDHy7ds(DeviceScheduleModeV2Adapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$6vggut36L5EJAomsOQd_KCFhacs/* $FF was: $r8$lambda$6vggut36L5EJAomsOQd-KCFhacs*/(boolean var0) {
      return onCreateViewHolder$lambda$11(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Ef4BuVGmmmXnlnTO5vohJSFUvjY(DeviceScheduleModeV2Adapter var0, int var1) {
      return onCreateViewHolder$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$H7C09g61v_25nPvBy85N8T_fwQY/* $FF was: $r8$lambda$H7C09g61v-25nPvBy85N8T_fwQY*/(DeviceScheduleModeV2Adapter var0, double var1) {
      return onCreateViewHolder$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$bu_GEp0YVtu_sA5WZLXLqJm73AE/* $FF was: $r8$lambda$bu_GEp0YVtu-sA5WZLXLqJm73AE*/(DeviceScheduleModeV2Adapter var0, int var1) {
      return onCreateViewHolder$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$e3k66WqW0jUeZq8Y8_8HTs40EQw(DeviceScheduleModeV2Adapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gyKhjJZooy3zu1dFdpMLVDza_9M(DeviceScheduleModeV2Adapter var0, MainMode var1) {
      return onCreateViewHolder$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jeYLgohtcvG9icfacvumRoW4BgE(DeviceScheduleModeV2Adapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$n1M_0wljXJ0kw0qQxYL6je3MHKM/* $FF was: $r8$lambda$n1M-0wljXJ0kw0qQxYL6je3MHKM*/(DeviceScheduleModeV2Adapter var0) {
      return onCreateViewHolder$lambda$10(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$oUyu8sQx6gk9YLsvgX9lK_W67q8(DeviceScheduleModeV2Adapter var0, String var1) {
      return onCreateViewHolder$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$teSvJw_yyixuzmJnkn7Hwg0fNmc(DeviceScheduleModeV2Adapter var0) {
      return onCreateViewHolder$lambda$16(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tvY6d2xVR22WB034RbOSe1ZMwvE(DeviceScheduleModeV2Adapter var0) {
      return onCreateViewHolder$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$u_9_IqROj2fsi84hGfiCj9P2FAY(DeviceScheduleModeV2Adapter var0) {
      return onCreateViewHolder$lambda$13(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$whSiuMxa_3wlkrMJK_bGyR0Y0jY/* $FF was: $r8$lambda$whSiuMxa-3wlkrMJK_bGyR0Y0jY*/(DeviceScheduleModeV2Adapter var0, boolean var1) {
      return onCreateViewHolder$lambda$9(var0, var1);
   }

   public DeviceScheduleModeV2Adapter(Device var1, ControlGroup var2, boolean var3, String var4, MainMode var5, DeviceCreateEditScheduleViewModel.PurifierMode var6, FanSpeedEnum var7, Object var8, int var9, boolean var10, double var11, double var13, boolean var15, Function1 var16) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "group");
      Intrinsics.checkNotNullParameter(var4, "customType");
      Intrinsics.checkNotNullParameter(var5, "mainMode");
      Intrinsics.checkNotNullParameter(var6, "mode");
      Intrinsics.checkNotNullParameter(var7, "fanSpeed");
      Intrinsics.checkNotNullParameter(var8, "brightness");
      Intrinsics.checkNotNullParameter(var16, "onActionListener");
      super();
      this.device = var1;
      this.group = var2;
      this.isStartMode = var3;
      this.onActionListener = var16;
      this.customType = var4;
      if (var6 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.isStandByOn = var3;
      this.mainMode = var5;
      DeviceScheduleModeV2Adapter var18 = this;
      DeviceCreateEditScheduleViewModel.PurifierMode var19 = var6;
      if (var6 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         int var17 = DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
         if (var17 != 1) {
            if (var17 != 4) {
               var19 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            } else {
               var19 = DeviceCreateEditScheduleViewModel.PurifierMode.SMART;
            }
         } else {
            Device var20 = this.device;
            if (!(var20 instanceof DeviceDehumidifier) && !(var20 instanceof DeviceMiniRestful) && !(var20 instanceof DevicePet20)) {
               var19 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            } else {
               var19 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
            }
         }
      }

      this.mode = var19;
      this.fanSpeed = var7;
      this.brightness = var8;
      this.autoRh = var9;
      this.humMode = var10;
      this.heatAutoTemp = var11;
      this.heatEcoTmp = var13;
      this.oscillationEnabled = var15;
      this.firstRefresh = true;
      this.modeControls = CollectionsKt.emptyList();
      this.refreshControls();
   }

   private final Set getDisableMainModes() {
      Device var1 = this.device;
      return var1 instanceof HasCombo3in1MainMode && var1.isUsDevice() ? SetsKt.setOf(ModeIcon.HEAT) : SetsKt.emptySet();
   }

   private final Set getDisableSubModes() {
      if (this.device instanceof HasCombo3in1MainMode) {
         MainMode var2 = this.mainMode;
         int var1 = DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
         if (var1 != 2) {
            return var1 != 3 ? SetsKt.emptySet() : SetsKt.setOf(new ModeIcon[]{ModeIcon.AUTO, ModeIcon.ECO});
         } else {
            return SetsKt.setOf(new ModeIcon[]{ModeIcon.NIGHT, ModeIcon.ECO});
         }
      } else {
         return SetsKt.emptySet();
      }
   }

   private final Set getStayOffSubModes() {
      return SetsKt.emptySet();
   }

   private final boolean hasHumidification() {
      Device var1 = this.device;
      return var1 instanceof HasHumMode || var1 instanceof HasHumMainMode;
   }

   private final boolean isHumOn() {
      Device var1 = this.device;
      if (var1 instanceof HasHumMainMode) {
         return this.mainMode == MainMode.Humidification;
      } else {
         return var1 instanceof HasHumMode ? this.humMode : false;
      }
   }

   private final void notifyControlChange(ModeControl var1) {
      int var2 = this.modeControls.indexOf(var1);
      if (var2 >= 0) {
         this.notifyItemChanged(var2);
      }

   }

   private static final Unit onCreateViewHolder$lambda$1(DeviceScheduleModeV2Adapter var0) {
      var0.onActionListener.invoke(DeviceScheduleModeV2Adapter.Action.END_TYPE_HINT_CLOSED.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$10(DeviceScheduleModeV2Adapter var0) {
      var0.onActionListener.invoke(DeviceScheduleModeV2Adapter.Action.OPEN_TARGET_HUMIDITY_INFO.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$11(boolean var0) {
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$12(DeviceScheduleModeV2Adapter var0, int var1) {
      var0.autoRh = var1;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$13(DeviceScheduleModeV2Adapter var0) {
      var0.onActionListener.invoke(DeviceScheduleModeV2Adapter.Action.OPEN_TARGET_TEMPERATURE_INFO.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$14(DeviceScheduleModeV2Adapter var0, double var1) {
      if (var0.device instanceof HasCombo3in1MainMode) {
         DeviceCreateEditScheduleViewModel.PurifierMode var4 = var0.getMode();
         int var3 = DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$1[var4.ordinal()];
         if (var3 != 2) {
            if (var3 == 7) {
               var0.heatEcoTmp = var1;
            }
         } else {
            var0.heatAutoTemp = var1;
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$15(DeviceScheduleModeV2Adapter var0, int var1) {
      var0.brightness = var1;
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$16(DeviceScheduleModeV2Adapter var0) {
      boolean var1 = var0.isHumOn();
      if (var0.device instanceof HasHumMainMode) {
         MainMode var2;
         if (var1) {
            var2 = MainMode.AirPurify;
         } else {
            var2 = MainMode.Humidification;
         }

         var0.setMainMode(var2);
      } else {
         var0.setHumMode(var1 ^ true);
         var0.onActionListener.invoke(new Action.HUM_MODE_CHANGED(var0.humMode));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$2(DeviceScheduleModeV2Adapter var0, String var1) {
      Intrinsics.checkNotNullParameter(var1, "type");
      var0.setCustomType(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$3(DeviceScheduleModeV2Adapter var0, MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.setMainMode(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$5(DeviceScheduleModeV2Adapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "selectedMode");
      MainMode var2 = var1.toMainMode();
      if (var2 != null) {
         var0.setMainMode(var2);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$7(DeviceScheduleModeV2Adapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "selectedMode");
      DeviceCreateEditScheduleViewModel.PurifierMode var2 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromModeIcon(var1);
      if (var2 != null) {
         Device var3 = var0.device;
         DeviceCreateEditScheduleViewModel.PurifierMode var4;
         if (var3 instanceof HasHumMainMode) {
            var4 = var2;
            if (DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$1[var2.ordinal()] == 4) {
               var0.setMainMode(MainMode.Humidification);
               var4 = var2;
            }
         } else {
            var4 = var2;
            if (var3 instanceof DeviceNewClassic) {
               var4 = var2;
               if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
                  var4 = var2;
                  if (var0.getMode() == DeviceCreateEditScheduleViewModel.PurifierMode.ECO) {
                     var4 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
                  }
               }
            }
         }

         var0.setMode(var4);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$8(DeviceScheduleModeV2Adapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.setFanSpeed(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$9(DeviceScheduleModeV2Adapter var0, boolean var1) {
      var0.oscillationEnabled ^= true;
      return Unit.INSTANCE;
   }

   private final void refreshControls() {
      List var2 = (List)(new ArrayList());
      ControlGroup var3 = this.group;
      int var1 = DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$2[var3.ordinal()];
      if (var1 != 1) {
         if (var1 != 2) {
            throw new NoWhenBranchMatchedException();
         }

         if (!this.isStartMode && Intrinsics.areEqual(this.customType, "previous")) {
            this.setModeControls(CollectionsKt.emptyList());
            return;
         }

         if (this.device instanceof DeviceCombo3in1) {
            if ((this.mainMode != MainMode.HEAT || !this.device.isUsDevice()) && (this.getMode() != DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL || this.fanSpeed != FanSpeedEnum.OFF) && this.getMode() != DeviceCreateEditScheduleViewModel.PurifierMode.ECO && this.getMode() != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
               var2.add(DeviceScheduleModeV2Adapter.ModeControl.OSCILLATION);
            }

            if (this.mainMode == MainMode.HEAT && this.getMode() == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
               var2.add(DeviceScheduleModeV2Adapter.ModeControl.TARGET_TEMPERATURE);
            }
         }

         Device var4 = this.device;
         if (var4 instanceof DeviceDehumidifier || var4 instanceof HasWick) {
            var2.add(DeviceScheduleModeV2Adapter.ModeControl.TARGET_HUM);
         }

         DeviceCreateEditScheduleViewModel.PurifierMode var5 = this.getMode();
         switch (DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$1[var5.ordinal()]) {
            case 1:
               var2.add(0, DeviceScheduleModeV2Adapter.ModeControl.FAN_SPEED);
               var2.add(DeviceScheduleModeV2Adapter.ModeControl.BRIGHTNESS);
               break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
               var2.add(DeviceScheduleModeV2Adapter.ModeControl.BRIGHTNESS);
         }
      } else {
         if (!this.isStartMode) {
            var2.add(DeviceScheduleModeV2Adapter.ModeControl.CUSTOM_TYPE);
            if (Intrinsics.areEqual(this.customType, "previous")) {
               this.setModeControls(var2);
               return;
            }
         }

         if (this.hasHumidification()) {
            var2.add(DeviceScheduleModeV2Adapter.ModeControl.HUMIDIFICATION);
         }

         if (this.device instanceof DeviceDehumidifier) {
            var2.add(DeviceScheduleModeV2Adapter.ModeControl.MAIN_MODES_DEHUM);
         }

         if (this.device instanceof DeviceCombo3in1) {
            var2.add(DeviceScheduleModeV2Adapter.ModeControl.MAIN_MODES_COMBO3IN1);
         }

         Device var6 = this.device;
         if (!(var6 instanceof DeviceMiniRestful) || ((DeviceMiniRestful)var6).hasNightMode()) {
            var2.add(DeviceScheduleModeV2Adapter.ModeControl.MODE_BUTTONS);
         }
      }

      this.setModeControls(var2);
      if (this.firstRefresh) {
         this.firstRefresh = false;
      }

   }

   private final void setFanSpeed(FanSpeedEnum var1) {
      FanSpeedEnum var5 = this.fanSpeed;
      this.fanSpeed = var1;
      if (var5 != var1 && this.device instanceof HasCombo3in1MainMode) {
         FanSpeedEnum var4 = FanSpeedEnum.OFF;
         boolean var3 = true;
         boolean var2;
         if (var5 == var4) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var1 != FanSpeedEnum.OFF) {
            var3 = false;
         }

         if (var2 != var3) {
            this.refreshControls();
         }
      }

   }

   private final void setModeControls(List var1) {
      int var2 = this.modeControls.size();
      this.modeControls = var1;
      this.notifyDataSetChanged();
      if (var1.size() != var2 || this.firstRefresh) {
         this.onActionListener.invoke(new Action.ITEM_COUNT_CHANGED(var1.size()));
      }
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

   public final boolean getEndTypeHintClosedBefore() {
      return this.endTypeHintClosedBefore;
   }

   public final FanSpeedEnum getFanSpeed() {
      return this.fanSpeed;
   }

   public final ControlGroup getGroup() {
      return this.group;
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
      return this.isStandByOn ? DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY : this.mode;
   }

   public final Function1 getOnActionListener() {
      return this.onActionListener;
   }

   public final boolean getOscillationEnabled() {
      return this.oscillationEnabled;
   }

   public final boolean isStandByOn() {
      return this.isStandByOn;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      if (var1 instanceof DeviceScheduleCustomTypeV2Holder) {
         ((DeviceScheduleCustomTypeV2Holder)var1).update(this.customType, this.endTypeHintClosedBefore);
      } else {
         boolean var9 = var1 instanceof DeviceMainModeDehumHolder;
         boolean var7 = true;
         boolean var8 = true;
         boolean var5 = true;
         boolean var6 = true;
         if (var9) {
            ((DeviceMainModeDehumHolder)var1).update(this.mainMode, true ^ this.isStandByOn);
         } else if (var1 instanceof DeviceModeButtonsV2Holder) {
            DeviceModeButtonsV2Holder var34 = (DeviceModeButtonsV2Holder)var1;
            if (var34.getForMainMode()) {
               MainMode var33 = this.mainMode;
               ModeIcon var17;
               if (this.getMode() == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                  var17 = this.getMode().toModeIcon(this.device);
               } else {
                  var17 = ModeIcon.Companion.fromMainMode(this.mainMode);
               }

               DeviceModeButtonsV2Holder.update$default(var34, var33, var17, (Set)null, this.getDisableMainModes(), 4, (Object)null);
            } else {
               if (DeviceKt.supportDisinfection(this.device) && !this.isStartMode) {
                  var34.registerModeIconForHide(ModeIcon.DISINFECTION);
               }

               var34.update(this.mainMode, this.getMode().toModeIcon(this.device), this.getStayOffSubModes(), this.getDisableSubModes());
            }
         } else {
            var9 = var1 instanceof DeviceFanSpeedV2Holder;
            Object var11 = null;
            if (var9) {
               DeviceFanSpeedV2Holder.update$default((DeviceFanSpeedV2Holder)var1, this.fanSpeed, (Integer)null, 2, (Object)null);
            } else {
               if (var1 instanceof DeviceBrightnessV2Holder) {
                  Object var10 = this.brightness;
                  Brightness var27;
                  if (var10 instanceof Brightness) {
                     var27 = (Brightness)var10;
                  } else {
                     var27 = null;
                  }

                  if (var27 != null) {
                     ((DeviceBrightnessV2Holder)var1).update(this.device, var27.toPercentage());
                  }

                  Object var12 = this.brightness;
                  Integer var28 = (Integer)var11;
                  if (var12 instanceof Integer) {
                     var28 = (Integer)var12;
                  }

                  if (var28 != null) {
                     var2 = ((Number)var28).intValue();
                     ((DeviceBrightnessV2Holder)var1).update(this.device, var2);
                     return;
                  }
               } else {
                  if (var1 instanceof DeviceTargetHumidityHolder) {
                     var1 = (DeviceTargetHumidityHolder)var1;
                     var2 = this.autoRh;
                     DeviceCreateEditScheduleViewModel.PurifierMode var32 = this.getMode();
                     var5 = var6;
                     if (!this.isHumOn()) {
                        if (!this.hasHumidification()) {
                           var5 = var6;
                        } else {
                           var5 = false;
                        }
                     }

                     var1.update(var2, var32, var5);
                     return;
                  }

                  if (var1 instanceof DeviceTargetTemperatureV2Holder) {
                     DeviceCreateEditScheduleViewModel.PurifierMode var29 = this.getMode();
                     var2 = DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$1[var29.ordinal()];
                     if (var2 != 2) {
                        if (var2 != 7) {
                           ((DeviceTargetTemperatureV2Holder)var1).update(this.heatAutoTemp, this.getMode(), false);
                           return;
                        }

                        DeviceTargetTemperatureV2Holder var31 = (DeviceTargetTemperatureV2Holder)var1;
                        double var21 = this.heatEcoTmp;
                        DeviceCreateEditScheduleViewModel.PurifierMode var15 = this.getMode();
                        if (this.mainMode == MainMode.HEAT) {
                           var5 = var7;
                        } else {
                           var5 = false;
                        }

                        var31.update(var21, var15, var5);
                        return;
                     }

                     var1 = (DeviceTargetTemperatureV2Holder)var1;
                     double var3 = this.heatAutoTemp;
                     var29 = this.getMode();
                     if (this.mainMode == MainMode.HEAT) {
                        var5 = var8;
                     } else {
                        var5 = false;
                     }

                     var1.update(var3, var29, var5);
                     return;
                  }

                  if (var1 instanceof DeviceHumidificationHolder) {
                     var1 = var1;
                     var6 = this.isHumOn();
                     if (this.getMode() != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                        var5 = false;
                     }

                     var1.update(var6, var5);
                     return;
                  }

                  if (var1 instanceof DeviceOscillationV2Holder) {
                     ((DeviceOscillationV2Holder)var1).update(this.oscillationEnabled, this.getMode());
                  }
               }

            }
         }
      }
   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      ModeControl var3 = (ModeControl)DeviceScheduleModeV2Adapter.ModeControl.getEntries().get(var2);
      switch (DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$3[var3.ordinal()]) {
         case 1:
            return DeviceScheduleCustomTypeV2Holder.Companion.newInstance(var1, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda0(this), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda9(this));
         case 2:
            return DeviceMainModeDehumHolder.Companion.newInstance(var1, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda10(this));
         case 3:
            return DeviceModeButtonsV2Holder.Companion.newInstance(var1, this.device, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda11(this));
         case 4:
            return DeviceModeButtonsV2Holder.Companion.newInstance$default(DeviceModeButtonsV2Holder.Companion, var1, this.device, false, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda12(this), 4, (Object)null);
         case 5:
            return DeviceFanSpeedV2Holder.Companion.newInstance(var1, this.device, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda13(this));
         case 6:
            return DeviceOscillationV2Holder.Companion.newInstance$default(DeviceOscillationV2Holder.Companion, var1, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda1(this), (Function0)null, 8, (Object)null);
         case 7:
            return DeviceTargetHumidityHolder.Companion.newInstance(var1, this.device, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda2(this), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda3(), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda4(this));
         case 8:
            return DeviceTargetTemperatureV2Holder.Companion.newInstance(var1, this.device, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda5(this), new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda6(this));
         case 9:
            return DeviceBrightnessV2Holder.Companion.newInstance(var1, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda7(this));
         case 10:
            return DeviceHumidificationHolder.Companion.newInstance$default(DeviceHumidificationHolder.Companion, var1, true, new DeviceScheduleModeV2Adapter$$ExternalSyntheticLambda8(this), (Function0)null, 8, (Object)null);
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public final void setCustomType(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (!Intrinsics.areEqual(this.customType, var1)) {
         this.customType = var1;
         this.refreshControls();
         this.onActionListener.invoke(new Action.CUSTOM_TYPE_CHANGED(var1));
      }
   }

   public final void setEndTypeHintClosedBefore(boolean var1) {
      if (this.endTypeHintClosedBefore != var1) {
         this.endTypeHintClosedBefore = var1;
         this.notifyControlChange(DeviceScheduleModeV2Adapter.ModeControl.CUSTOM_TYPE);
      }
   }

   public final void setHumMode(boolean var1) {
      if (this.humMode != var1) {
         this.humMode = var1;
         this.notifyControlChange(DeviceScheduleModeV2Adapter.ModeControl.TARGET_HUM);
      }
   }

   public final void setMainMode(MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (this.mainMode != var1) {
         this.mainMode = var1;
         int var2 = DeviceScheduleModeV2Adapter.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()];
         DeviceCreateEditScheduleViewModel.PurifierMode var3;
         if (var2 != 1) {
            if (var2 != 2 && var2 != 3) {
               var3 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            } else {
               var3 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
            }
         } else {
            Device var4 = this.device;
            if (!(var4 instanceof DeviceDehumidifier) && !(var4 instanceof DeviceCombo2in120) && !(var4 instanceof HasCombo3in1MainMode)) {
               var3 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
            } else {
               var3 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
            }
         }

         this.setMode(var3);
         Device var5 = this.device;
         if (var5 instanceof HasHumMainMode) {
            this.notifyControlChange(DeviceScheduleModeV2Adapter.ModeControl.TARGET_HUM);
         } else if (var5 instanceof HasCombo3in1MainMode) {
            this.refreshControls();
         }

         this.onActionListener.invoke(new Action.MAIN_MODE_CHANGED(var1));
      }
   }

   public final void setMode(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "expectedValue");
      boolean var2;
      if (var1 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setStandByOn(var2);
      if (this.mode != var1) {
         if (this.isStandByOn) {
            return;
         }

         this.mode = var1;
         this.refreshControls();
         this.onActionListener.invoke(new Action.SUB_MODE_CHANGED(this.getMode()));
      }

   }

   public final void setStandByOn(boolean var1) {
      if (this.isStandByOn != var1) {
         this.isStandByOn = var1;
         this.refreshControls();
         Timber.Forest var2 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("StandByOn: ");
         var3.append(this.isStandByOn);
         var3.append(", mode: ");
         var3.append(this.getMode());
         var2.d(var3.toString(), new Object[0]);
         this.onActionListener.invoke(new Action.SUB_MODE_CHANGED(this.getMode()));
      }
   }

   @Metadata(
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\b\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018¨\u0006\u0019"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "T", "", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "MAIN_MODE_CHANGED", "SUB_MODE_CHANGED", "OPEN_TARGET_HUMIDITY_INFO", "END_TYPE_HINT_CLOSED", "CUSTOM_TYPE_CHANGED", "ITEM_COUNT_CHANGED", "HUM_MODE_CHANGED", "OPEN_TARGET_TEMPERATURE_INFO", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$CUSTOM_TYPE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$END_TYPE_HINT_CLOSED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$HUM_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$ITEM_COUNT_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$MAIN_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$OPEN_TARGET_HUMIDITY_INFO;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$OPEN_TARGET_TEMPERATURE_INFO;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED;", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public abstract static class Action {
      private final Object data;

      private Action(Object var1) {
         this.data = var1;
      }

      // $FF: synthetic method
      public Action(Object var1, DefaultConstructorMarker var2) {
         this(var1);
      }

      public final Object getData() {
         return this.data;
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$CUSTOM_TYPE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "type", "<init>", "(Ljava/lang/String;)V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class CUSTOM_TYPE_CHANGED extends Action {
         public CUSTOM_TYPE_CHANGED(String var1) {
            Intrinsics.checkNotNullParameter(var1, "type");
            super(var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$END_TYPE_HINT_CLOSED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class END_TYPE_HINT_CLOSED extends Action {
         public static final END_TYPE_HINT_CLOSED INSTANCE = new END_TYPE_HINT_CLOSED();

         private END_TYPE_HINT_CLOSED() {
            super(Unit.INSTANCE, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$HUM_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "humMode", "<init>", "(Z)V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class HUM_MODE_CHANGED extends Action {
         public HUM_MODE_CHANGED(boolean var1) {
            super(var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$ITEM_COUNT_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "count", "<init>", "(I)V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class ITEM_COUNT_CHANGED extends Action {
         public ITEM_COUNT_CHANGED(int var1) {
            super(var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$MAIN_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "Lcom/blueair/core/model/MainMode;", "mainMode", "<init>", "(Lcom/blueair/core/model/MainMode;)V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class MAIN_MODE_CHANGED extends Action {
         public MAIN_MODE_CHANGED(MainMode var1) {
            Intrinsics.checkNotNullParameter(var1, "mainMode");
            super(var1, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$OPEN_TARGET_HUMIDITY_INFO;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class OPEN_TARGET_HUMIDITY_INFO extends Action {
         public static final OPEN_TARGET_HUMIDITY_INFO INSTANCE = new OPEN_TARGET_HUMIDITY_INFO();

         private OPEN_TARGET_HUMIDITY_INFO() {
            super(Unit.INSTANCE, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$OPEN_TARGET_TEMPERATURE_INFO;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "", "<init>", "()V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class OPEN_TARGET_TEMPERATURE_INFO extends Action {
         public static final OPEN_TARGET_TEMPERATURE_INFO INSTANCE = new OPEN_TARGET_TEMPERATURE_INFO();

         private OPEN_TARGET_TEMPERATURE_INFO() {
            super(Unit.INSTANCE, (DefaultConstructorMarker)null);
         }
      }

      @Metadata(
         d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"},
         d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action$SUB_MODE_CHANGED;", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$Action;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "subMode", "<init>", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "devicedetails_otherRelease"},
         k = 1,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class SUB_MODE_CHANGED extends Action {
         public SUB_MODE_CHANGED(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
            Intrinsics.checkNotNullParameter(var1, "subMode");
            super(var1, (DefaultConstructorMarker)null);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "", "<init>", "(Ljava/lang/String;I)V", "MODES", "CONTROLS", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum ControlGroup {
      private static final EnumEntries $ENTRIES;
      private static final ControlGroup[] $VALUES;
      CONTROLS,
      MODES;

      // $FF: synthetic method
      private static final ControlGroup[] $values() {
         return new ControlGroup[]{MODES, CONTROLS};
      }

      static {
         ControlGroup[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ModeControl;", "", "group", "Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "<init>", "(Ljava/lang/String;ILcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;)V", "getGroup", "()Lcom/blueair/devicedetails/adapter/DeviceScheduleModeV2Adapter$ControlGroup;", "CUSTOM_TYPE", "MAIN_MODES_DEHUM", "MAIN_MODES_COMBO3IN1", "HUMIDIFICATION", "MODE_BUTTONS", "FAN_SPEED", "OSCILLATION", "TARGET_HUM", "TARGET_TEMPERATURE", "BRIGHTNESS", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum ModeControl {
      private static final EnumEntries $ENTRIES;
      private static final ModeControl[] $VALUES;
      BRIGHTNESS(DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS),
      CUSTOM_TYPE(DeviceScheduleModeV2Adapter.ControlGroup.MODES),
      FAN_SPEED(DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS),
      HUMIDIFICATION(DeviceScheduleModeV2Adapter.ControlGroup.MODES),
      MAIN_MODES_COMBO3IN1(DeviceScheduleModeV2Adapter.ControlGroup.MODES),
      MAIN_MODES_DEHUM(DeviceScheduleModeV2Adapter.ControlGroup.MODES),
      MODE_BUTTONS(DeviceScheduleModeV2Adapter.ControlGroup.MODES),
      OSCILLATION(DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS),
      TARGET_HUM(DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS),
      TARGET_TEMPERATURE(DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS);

      private final ControlGroup group;

      // $FF: synthetic method
      private static final ModeControl[] $values() {
         return new ModeControl[]{CUSTOM_TYPE, MAIN_MODES_DEHUM, MAIN_MODES_COMBO3IN1, HUMIDIFICATION, MODE_BUTTONS, FAN_SPEED, OSCILLATION, TARGET_HUM, TARGET_TEMPERATURE, BRIGHTNESS};
      }

      static {
         ModeControl[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      private ModeControl(ControlGroup var3) {
         this.group = var3;
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }

      public final ControlGroup getGroup() {
         return this.group;
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
      public static final int[] $EnumSwitchMapping$3;

      static {
         int[] var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.AirPurify.ordinal()] = 1;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 3;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[MainMode.SMART.ordinal()] = 4;
         } catch (NoSuchFieldError var21) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[DeviceCreateEditScheduleViewModel.PurifierMode.values().length];

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL.ordinal()] = 1;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.DRYING.ordinal()] = 3;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.SKIN.ordinal()] = 4;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.SMART.ordinal()] = 5;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS.ordinal()] = 6;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.ECO.ordinal()] = 7;
         } catch (NoSuchFieldError var14) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[DeviceScheduleModeV2Adapter.ControlGroup.values().length];

         try {
            var0[DeviceScheduleModeV2Adapter.ControlGroup.MODES.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ControlGroup.CONTROLS.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
         }

         $EnumSwitchMapping$2 = var0;
         var0 = new int[DeviceScheduleModeV2Adapter.ModeControl.values().length];

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.CUSTOM_TYPE.ordinal()] = 1;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.MAIN_MODES_DEHUM.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.MAIN_MODES_COMBO3IN1.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.MODE_BUTTONS.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.FAN_SPEED.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.OSCILLATION.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.TARGET_HUM.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.TARGET_TEMPERATURE.ordinal()] = 8;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.BRIGHTNESS.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceScheduleModeV2Adapter.ModeControl.HUMIDIFICATION.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$3 = var0;
      }
   }
}
