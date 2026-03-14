package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.model.TimerState;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceAttribute;
import com.blueair.devicedetails.viewholder.DeviceAttributeHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoModeHolder;
import com.blueair.devicedetails.viewholder.DeviceBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceC3FanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceCOnOffButtonHolder;
import com.blueair.devicedetails.viewholder.DeviceDetectCatHolder;
import com.blueair.devicedetails.viewholder.DeviceDisinfectionStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceEtaHolder;
import com.blueair.devicedetails.viewholder.DeviceFanPresetHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterOrWickStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldNightModeHolder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceHAuthRhHolder;
import com.blueair.devicedetails.viewholder.DeviceHDryModeHolder;
import com.blueair.devicedetails.viewholder.DeviceHTimerHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceManualModeHolder;
import com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceNBrightnessHolder;
import com.blueair.devicedetails.viewholder.DeviceNChildLockHolder;
import com.blueair.devicedetails.viewholder.DeviceNCleanAirEtaHolder;
import com.blueair.devicedetails.viewholder.DeviceNFanSpeedHolder;
import com.blueair.devicedetails.viewholder.DeviceNFilterStatusHolder;
import com.blueair.devicedetails.viewholder.DeviceNHinsHolder;
import com.blueair.devicedetails.viewholder.DeviceNModeButtonsHolder;
import com.blueair.devicedetails.viewholder.DeviceOTAHolder;
import com.blueair.devicedetails.viewholder.DeviceOfflineHolder;
import com.blueair.devicedetails.viewholder.DeviceOscillationHolder;
import com.blueair.devicedetails.viewholder.DeviceSeparatorHolder;
import com.blueair.devicedetails.viewholder.DeviceStandbyModeHolder;
import com.blueair.devicedetails.viewholder.DeviceSubAutoHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetTemperatureHolder;
import com.blueair.devicedetails.viewholder.DeviceTimezoneHintHolder;
import com.blueair.devicedetails.viewholder.DeviceWeightHolder;
import com.blueair.viewcore.utils.ModeIcon;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\u000eJ\u0006\u0010*\u001a\u00020\u000eJ\u0006\u0010+\u001a\u00020\u000eJ\u0006\u0010,\u001a\u00020\u000eR\u0018\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceAttributesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "onActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "<init>", "(Lio/reactivex/subjects/PublishSubject;)V", "attributes", "", "Lcom/blueair/devicedetails/util/DeviceAttribute;", "forceOffline", "", "setForceOffline", "", "value", "Lcom/blueair/core/model/IndoorDatapoint;", "latestDatapoint", "getLatestDatapoint", "()Lcom/blueair/core/model/IndoorDatapoint;", "setLatestDatapoint", "(Lcom/blueair/core/model/IndoorDatapoint;)V", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "handleModeAction", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "notifyDisinfectLeftTimeChanged", "notifyTimerLeftTimeChanged", "notifyWickDryLeftTimeChanged", "notifySubAutoChanged", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAttributesAdapter extends RecyclerView.Adapter {
   private List attributes;
   private Device device;
   private boolean forceOffline;
   private IndoorDatapoint latestDatapoint;
   private final PublishSubject onActionPublisher;

   // $FF: synthetic method
   public static Unit $r8$lambda$0G6eBpPRiF8HygrAnEuOhg4t3OQ(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2LeAhtSDz3Y5mVHl5U6hHEYeYJE(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$35(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2UiQNLpyqCW_m_ds3XeFwJVATn0/* $FF was: $r8$lambda$2UiQNLpyqCW_m-ds3XeFwJVATn0*/(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$3FAMKWK6Trs5ttKQiuWGTUQS3yY(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$27(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$57GeG3wNebd6E7GbCtDBFKJuIqc(DeviceAttributesAdapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$954Jkf8cgaTaD7Jv48oygq_opD0/* $FF was: $r8$lambda$954Jkf8cgaTaD7Jv48oygq-opD0*/(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$9(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$9P7kuAO3f_ipIFSdn4EkpjT7_w4/* $FF was: $r8$lambda$9P7kuAO3f-ipIFSdn4EkpjT7-w4*/(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$26(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$BvvY9McbHyB_W0Y2zL448GrXg6o(DeviceAttributesAdapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$C_hZOUI_OqCFcirpLup3NE5T3vI/* $FF was: $r8$lambda$C_hZOUI-OqCFcirpLup3NE5T3vI*/(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$34(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Djazh5tbjquUxYHP27J_g4pnTlg/* $FF was: $r8$lambda$Djazh5tbjquUxYHP27J-g4pnTlg*/(DeviceAttributesAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      return onCreateViewHolder$lambda$39(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$G_ju0I3oYnIjhg3_udG5GPo0b6Y/* $FF was: $r8$lambda$G_ju0I3oYnIjhg3-udG5GPo0b6Y*/(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$40(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$NP2fthORM6aH6YR2OBlxwHQpa8s(DeviceAttributesAdapter var0, int var1) {
      return onCreateViewHolder$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PoUSAqYTweAc5dJU2bBsclCCZ98(DeviceAttributesAdapter var0, double var1) {
      return onCreateViewHolder$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Q70saxVXUQ0GMi3y5oehK7x0ibQ(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$36(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$RuGL_G96MJmEk_e7CvxkZWk24nM/* $FF was: $r8$lambda$RuGL-G96MJmEk-e7CvxkZWk24nM*/(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$37(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$U_mW2NpCJW6V3y1FagZj5entWO0(DeviceAttributesAdapter var0, int var1) {
      return onCreateViewHolder$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Ue8oPSoBZYKdfq7bG4mGilhJI28(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$5(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$UloWD5tHogdn32idCfNjzdtR58s(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Usvnv76TNP2bGLM8xlhxgCefHw8(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$31(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$VqjA472RstG9RCq0wOEIamvZtCE(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$23(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Xa0PE1rVZxFnhTqIEGk_G4eRSS4/* $FF was: $r8$lambda$Xa0PE1rVZxFnhTqIEGk-G4eRSS4*/(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$8(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$XaC1XfqqmMu30WTsFlzMMiJEito(DeviceAttributesAdapter var0, ApSubMode var1) {
      return onCreateViewHolder$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YA1RT_UrBerAFhY5To_nXhDRMfM(DeviceAttributesAdapter var0, int var1) {
      return onCreateViewHolder$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YQXatBlb1t8fPRr7QklhA0O4C6Q(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YktpL4Vzr04GqatveXrRB2j__OU/* $FF was: $r8$lambda$YktpL4Vzr04GqatveXrRB2j-_OU*/(DeviceAttributesAdapter var0, TimerState var1) {
      return onCreateViewHolder$lambda$32(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$i8UxitWz0dQ0R6p2hPKZWSrOq_A/* $FF was: $r8$lambda$i8UxitWz0dQ0R6p2hPKZWSrOq-A*/(DeviceAttributesAdapter var0, Brightness var1) {
      return onCreateViewHolder$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iqKfr0aenw2bg6T2pG7nnFzIN_U/* $FF was: $r8$lambda$iqKfr0aenw2bg6T2pG7nnFzIN-U*/(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$24(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jf_HhkWk5bQLCA3hvSqe9wKHDAw/* $FF was: $r8$lambda$jf-HhkWk5bQLCA3hvSqe9wKHDAw*/(DeviceAttributesAdapter var0, MainMode var1) {
      return onCreateViewHolder$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$kFBHbmCek5f1ZRBI7enWQ8QjVxg(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$30(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ko61s6z_N5pDNyTmbkwOI2lUWCc(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$29(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$lIfU2ujYuvWulQLOHBkJJN_E08w(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$22(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$lRO4e1GA5VnDcWvsv80D1_FlGoc/* $FF was: $r8$lambda$lRO4e1GA5VnDcWvsv80D1-FlGoc*/(DeviceAttributesAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      return onCreateViewHolder$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$l_Ibstq1pb2ssU2hqY_p6EcidrE/* $FF was: $r8$lambda$l_Ibstq1pb2ssU2hqY-p6EcidrE*/(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mBaBVadSsJ76z8ZRsM1W2616KWw(DeviceAttributesAdapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$op_LuaIwXlQfQ0x6L124RlMmPFE/* $FF was: $r8$lambda$op-LuaIwXlQfQ0x6L124RlMmPFE*/(DeviceAttributesAdapter var0, int var1) {
      return onCreateViewHolder$lambda$28(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$oyGh_GSu0_rsHT759vuBhVO6D0E/* $FF was: $r8$lambda$oyGh-GSu0_rsHT759vuBhVO6D0E*/(DeviceAttributesAdapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tzaLO7oBG2QZZWt4Ht8kG4T8o24(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uAxfG71Rl3M3PvlYmN49_9zUoeg(DeviceAttributesAdapter var0) {
      return onCreateViewHolder$lambda$38(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yhV_OTmaz6J6u3oh2omRu5LyoaE/* $FF was: $r8$lambda$yhV-OTmaz6J6u3oh2omRu5LyoaE*/(DeviceAttributesAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$25(var0, var1);
   }

   public DeviceAttributesAdapter(PublishSubject var1) {
      Intrinsics.checkNotNullParameter(var1, "onActionPublisher");
      super();
      this.onActionPublisher = var1;
      this.attributes = CollectionsKt.emptyList();
   }

   private final void handleModeAction(ModeIcon var1) {
      Device var2 = this.device;
      if (var2 != null) {
         switch (DeviceAttributesAdapter.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()]) {
            case 1:
               this.onActionPublisher.onNext(AttributeAction.StandbyModeAction.INSTANCE);
               break;
            case 2:
               this.onActionPublisher.onNext(AttributeAction.ManualModeAction.INSTANCE);
               return;
            case 3:
            case 4:
               if (var2 instanceof HasStandBy && var2 instanceof HasFanSpeed) {
                  Timber.Forest var10 = Timber.Forest;
                  StringBuilder var4 = new StringBuilder("auto mode clicked & is standby on =  ");
                  HasStandBy var7 = (HasStandBy)var2;
                  var4.append(var7.isStandByOn());
                  var10.d(var4.toString(), new Object[0]);
                  if (!var7.isStandByOn()) {
                     HasFanSpeed var8 = (HasFanSpeed)var2;
                     if (var8.getAutoMode() == AutoMode.ON) {
                        this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(DeviceKt.isDisinfectionOn(var2)));
                        return;
                     }

                     if (var8.getAutoMode() == AutoMode.OFF) {
                        this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(true));
                        return;
                     }
                  }
               } else {
                  Timber.Forest.d("auto mode clicked ", new Object[0]);
                  HasFanSpeed var6 = (HasFanSpeed)var2;
                  if (var6.getAutoMode() == AutoMode.ON) {
                     this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(false));
                     return;
                  }

                  if (var6.getAutoMode() == AutoMode.OFF) {
                     this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(true));
                     return;
                  }
               }
               break;
            case 5:
               if (!(var2 instanceof HasStandBy)) {
                  Timber.Forest.d("night mode clicked ", new Object[0]);
                  this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                  return;
               }

               Timber.Forest var3 = Timber.Forest;
               StringBuilder var5 = new StringBuilder("night mode clicked & is standby on =  ");
               HasStandBy var9 = (HasStandBy)var2;
               var5.append(var9.isStandByOn());
               var3.d(var5.toString(), new Object[0]);
               if (!var9.isStandByOn()) {
                  this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                  return;
               }
               break;
            case 6:
               this.onActionPublisher.onNext(AttributeAction.ChildLockAction.INSTANCE);
               return;
            case 7:
               this.onActionPublisher.onNext(AttributeAction.DisinfectionModeAction.INSTANCE);
               return;
            case 8:
               this.onActionPublisher.onNext(AttributeAction.EcoModeAction.INSTANCE);
               return;
         }
      }

   }

   private static final Unit onCreateViewHolder$lambda$0(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenGermShieldInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$1(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDisinfectionInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$10(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenHinsInfoAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$11(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.HinsLockAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$12(DeviceAttributesAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      var0.onActionPublisher.onNext(AttributeAction.StandbyModeAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$13(DeviceAttributesAdapter var0, MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "mainMode");
      var0.onActionPublisher.onNext(new AttributeAction.MainModeAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$14(DeviceAttributesAdapter var0, ApSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "subMode");
      var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$17(DeviceAttributesAdapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      Device var2 = var0.device;
      if (var2 instanceof DevicePet20) {
         if (var1 == ModeIcon.SMART) {
            var0.onActionPublisher.onNext(new AttributeAction.MainModeAction(MainMode.SMART));
         } else {
            ApSubMode var3 = var1.toApSubMode();
            if (var3 != null) {
               var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var3));
            }
         }
      } else if (var2 instanceof HasMode) {
         Mode var4 = var1.toMode();
         if (var4 != null) {
            var0.onActionPublisher.onNext(new AttributeAction.ModeAction(var4));
         }
      } else {
         var0.handleModeAction(var1);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$18(DeviceAttributesAdapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.FanSpeedAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$19(DeviceAttributesAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.BrightnessPercentageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$2(DeviceAttributesAdapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.FanSpeedAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$20(DeviceAttributesAdapter var0, boolean var1) {
      PublishSubject var2 = var0.onActionPublisher;
      SmartSubMode var3;
      if (var1) {
         var3 = SmartSubMode.AUTO_ON;
      } else {
         var3 = SmartSubMode.AUTO_OFF;
      }

      var2.onNext(new AttributeAction.SmartSubModeAction(var3));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$21(DeviceAttributesAdapter var0, double var1) {
      var0.onActionPublisher.onNext(new AttributeAction.TargetTemperatureAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$22(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenFilterInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$23(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$24(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenFilterInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$25(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$26(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(AttributeAction.ChildLockAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$27(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.AutoRhInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$28(DeviceAttributesAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.AutoRhAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$29(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenWickInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$3(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$30(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenWickPageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$31(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenTimerInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$32(DeviceAttributesAdapter var0, TimerState var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.TimerStateAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$33(DeviceAttributesAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.TimerDurationAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$34(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDryModeInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$35(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.DryModeCancelAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$36(DeviceAttributesAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(AttributeAction.OscillationEnableAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$37(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OscillationSettingAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$38(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenFanPresetPageAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$39(DeviceAttributesAdapter var0, DeviceCOnOffButtonHolder.Type var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      var0.onActionPublisher.onNext(AttributeAction.HumModeAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$4(DeviceAttributesAdapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      var0.handleModeAction(var1);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$40(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.PeelingAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$5(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.GsnmSwitchAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$6(DeviceAttributesAdapter var0, Brightness var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.BrightnessAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$7(DeviceAttributesAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.BrightnessPercentageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$8(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.TroubleShootAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$9(DeviceAttributesAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.TimeZoneAction.INSTANCE);
      return Unit.INSTANCE;
   }

   public final Device getDevice() {
      return this.device;
   }

   public int getItemCount() {
      return this.device != null ? this.attributes.size() : 0;
   }

   public int getItemViewType(int var1) {
      return ((DeviceAttribute)this.attributes.get(var1)).ordinal();
   }

   public final IndoorDatapoint getLatestDatapoint() {
      return this.latestDatapoint;
   }

   public final void notifyDisinfectLeftTimeChanged() {
      Timber.Forest var2 = Timber.Forest;
      int var1 = 0;
      var2.d("disinftime adapter.notifyDisinfectLeftTimeChanged", new Object[0]);
      Iterator var3 = this.attributes.iterator();

      while(true) {
         if (!var3.hasNext()) {
            var1 = -1;
            break;
         }

         if ((DeviceAttribute)var3.next() == DeviceAttribute.DISINFECTION_STATUS) {
            break;
         }

         ++var1;
      }

      if (var1 >= 0) {
         this.notifyItemChanged(var1);
      }

   }

   public final void notifySubAutoChanged() {
      Iterator var2 = this.attributes.iterator();
      int var1 = 0;

      while(true) {
         if (!var2.hasNext()) {
            var1 = -1;
            break;
         }

         if ((DeviceAttribute)var2.next() == DeviceAttribute.SUB_AUTO) {
            break;
         }

         ++var1;
      }

      if (var1 >= 0) {
         this.notifyItemChanged(var1);
      }

   }

   public final void notifyTimerLeftTimeChanged() {
      Iterator var2 = this.attributes.iterator();
      int var1 = 0;

      while(true) {
         if (!var2.hasNext()) {
            var1 = -1;
            break;
         }

         if ((DeviceAttribute)var2.next() == DeviceAttribute.TIMER) {
            break;
         }

         ++var1;
      }

      if (var1 >= 0) {
         this.notifyItemChanged(var1);
      }

   }

   public final void notifyWickDryLeftTimeChanged() {
      Iterator var2 = this.attributes.iterator();
      int var1 = 0;

      while(true) {
         if (!var2.hasNext()) {
            var1 = -1;
            break;
         }

         if ((DeviceAttribute)var2.next() == DeviceAttribute.DRY_MODE) {
            break;
         }

         ++var1;
      }

      if (var1 >= 0) {
         this.notifyItemChanged(var1);
      }

   }

   public void onBindViewHolder(DeviceAttributeHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Device var3 = this.device;
      if (var3 != null) {
         var1.update(var3);
      }

      if (var1 instanceof DeviceNFilterStatusHolder) {
         if (this.forceOffline) {
            ((DeviceNFilterStatusHolder)var1).setOffline();
            return;
         }
      } else if (var1 instanceof DeviceFilterOrWickStatusHolder) {
         if (this.forceOffline) {
            ((DeviceFilterOrWickStatusHolder)var1).setOffline();
            return;
         }
      } else if (var1 instanceof DeviceEtaHolder) {
         Device var5 = this.device;
         if (var5 != null) {
            IndoorDatapoint var4 = this.latestDatapoint;
            IndoorDatapoint var7 = var4;
            if (var4 == null) {
               if (var5 instanceof HasSensorData) {
                  var7 = ((HasSensorData)var5).getLatestSensorDatapoint();
               } else {
                  var7 = null;
               }
            }

            if (var7 != null) {
               ((DeviceEtaHolder)var1).update((HasFanSpeed)var5, var7);
               return;
            }
         }
      } else if (var1 instanceof DeviceNCleanAirEtaHolder) {
         DeviceNCleanAirEtaHolder var8 = (DeviceNCleanAirEtaHolder)var1;
         if (!Intrinsics.areEqual(var8.getBinding().cleanAirEta.getTag(), "dev_holder")) {
            Device var6 = this.device;
            if (var6 != null) {
               var8.update(var6, this.latestDatapoint);
               return;
            }
         }
      } else if (var1 instanceof DeviceC3FanSpeedHolder) {
         var3 = this.device;
         if (var3 != null) {
            ((DeviceC3FanSpeedHolder)var1).update(var3, this.latestDatapoint);
            return;
         }
      } else if (var1 instanceof DeviceNFanSpeedHolder) {
         var3 = this.device;
         if (var3 != null) {
            ((DeviceNFanSpeedHolder)var1).update(var3, this.latestDatapoint);
            return;
         }
      } else if (var1 instanceof DeviceWeightHolder) {
         var3 = this.device;
         if (var3 != null) {
            ((DeviceWeightHolder)var1).update(var3, this.latestDatapoint);
            return;
         }
      } else if (var1 instanceof DeviceBrightnessHolder && var2 == 0) {
         ((DeviceBrightnessHolder)var1).getBinding().getRoot().setPadding(0, 0, 0, 0);
      }

   }

   public DeviceAttributeHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      DeviceAttribute var5 = DeviceAttribute.Companion.getATTRIBUTES()[var2];
      switch (DeviceAttributesAdapter.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()]) {
         case 1:
            return DeviceGermShieldStatusHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda0(this));
         case 2:
            return DeviceStandbyModeHolder.Companion.newInstance(var1);
         case 3:
            return DeviceDisinfectionStatusHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda2(this));
         case 4:
            return DeviceManualModeHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda14(this));
         case 5:
            return DeviceAutoModeHolder.Companion.newInstance(var1);
         case 6:
            return DeviceFilterStatusHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda25(this));
         case 7:
            return DeviceModeButtonsHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda26(this));
         case 8:
            return DeviceGermShieldNightModeHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda27(this));
         case 9:
            return DeviceBrightnessHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda28(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda29(this));
         case 10:
            return DeviceEtaHolder.Companion.newInstance(var1);
         case 11:
         case 12:
            return DeviceOfflineHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda30(this));
         case 13:
            return DeviceOTAHolder.Companion.newInstance(var1);
         case 14:
            return DeviceTimezoneHintHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda31(this));
         case 15:
            return DeviceSeparatorHolder.Companion.newInstance(var1);
         case 16:
            return DeviceNHinsHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda11(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda22(this));
         case 17:
            return DeviceCOnOffButtonHolder.Companion.newInstance$default(DeviceCOnOffButtonHolder.Companion, var1, this.device, DeviceCOnOffButtonHolder.Type.STANDBY, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda32(this), 8, (Object)null);
         case 18:
            if (this.device instanceof HasCombo3in1MainMode) {
               return DeviceMainModeButtonsHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda33(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda34(this));
            }

            return DeviceNModeButtonsHolder.Companion.newInstance(var1, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda35(this));
         case 19:
            return DeviceNFanSpeedHolder.Companion.newInstance(var1, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda36(this));
         case 20:
            return DeviceNBrightnessHolder.Companion.newInstance(var1, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda37(this));
         case 21:
            return DeviceSubAutoHolder.Companion.newInstance(var1, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda38(this));
         case 22:
            return DeviceTargetTemperatureHolder.Companion.newInstance$default(DeviceTargetTemperatureHolder.Companion, var1, this.device, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda1(this), 4, (Object)null);
         case 23:
            if (this.device instanceof DeviceNewClassic) {
               return DeviceNFilterStatusHolder.Companion.newInstance(var1, new DeviceAttributesAdapter$$ExternalSyntheticLambda3(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda4(this));
            }

            return DeviceFilterOrWickStatusHolder.Companion.newInstance(var1, DeviceFilterType.FILTER, new DeviceAttributesAdapter$$ExternalSyntheticLambda5(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda6(this));
         case 24:
            return DeviceNChildLockHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda7(this));
         case 25:
            return DeviceHAuthRhHolder.Companion.newInstance(var1, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda8(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda9(this));
         case 26:
            return DeviceFilterOrWickStatusHolder.Companion.newInstance(var1, DeviceFilterType.WICK, new DeviceAttributesAdapter$$ExternalSyntheticLambda10(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda12(this));
         case 27:
            return DeviceHTimerHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda13(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda15(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda16(this));
         case 28:
            return DeviceHDryModeHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda17(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda18(this));
         case 29:
            return DeviceOscillationHolder.Companion.newInstance(var1, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda19(this), new DeviceAttributesAdapter$$ExternalSyntheticLambda20(this));
         case 30:
            return DeviceFanPresetHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda21(this));
         case 31:
            return DeviceCOnOffButtonHolder.Companion.newInstance$default(DeviceCOnOffButtonHolder.Companion, var1, this.device, DeviceCOnOffButtonHolder.Type.HUM, false, new DeviceAttributesAdapter$$ExternalSyntheticLambda23(this), 8, (Object)null);
         case 32:
            return DeviceWeightHolder.Companion.newInstance(var1, this.device, new DeviceAttributesAdapter$$ExternalSyntheticLambda24(this));
         case 33:
            return DeviceDetectCatHolder.Companion.newInstance(var1, this.device);
         default:
            DeviceNCleanAirEtaHolder var3 = DeviceNCleanAirEtaHolder.Companion.newInstance(var1);
            var3.getBinding().cleanAirEta.setText((CharSequence)var5.name());
            TextView var4 = var3.getBinding().cleanAirEta;
            String var6;
            if (var5 == DeviceAttribute.N_CLEAN_AIR_ETA) {
               var6 = null;
            } else {
               var6 = "dev_holder";
            }

            var4.setTag(var6);
            return var3;
      }
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         this.attributes = DeviceAttribute.Companion.getSupportedAttributes(var1, this.forceOffline);
         this.notifyDataSetChanged();
      }

   }

   public final void setForceOffline(boolean var1) {
      this.forceOffline = var1;
      this.attributes = DeviceAttribute.Companion.getSupportedAttributes(this.device, var1);
      this.notifyDataSetChanged();
   }

   public final void setLatestDatapoint(IndoorDatapoint var1) {
      IndoorDatapoint var6 = this.latestDatapoint;
      if (!Intrinsics.areEqual(var1, var6)) {
         this.latestDatapoint = var1;
         Object var5 = null;
         Float var7;
         if (var1 != null) {
            var7 = var1.getPm25();
         } else {
            var7 = null;
         }

         Float var4;
         if (var6 != null) {
            var4 = var6.getPm25();
         } else {
            var4 = null;
         }

         if (!Intrinsics.areEqual(var7, var4)) {
            int var3 = this.attributes.indexOf(DeviceAttribute.N_FAN_SPEED);
            int var2 = var3;
            if (var3 < 0) {
               var2 = this.attributes.indexOf(DeviceAttribute.CLEAN_AIR_ETA);
            }

            var3 = var2;
            if (var2 < 0) {
               var3 = this.attributes.indexOf(DeviceAttribute.N_CLEAN_AIR_ETA);
            }

            if (var3 >= 0) {
               this.notifyItemChanged(var3);
            }
         }

         IndoorDatapoint var8 = this.latestDatapoint;
         Float var9;
         if (var8 != null) {
            var9 = var8.getWeight();
         } else {
            var9 = null;
         }

         var4 = (Float)var5;
         if (var6 != null) {
            var4 = var6.getWeight();
         }

         if (!Intrinsics.areEqual(var9, var4)) {
            int var10 = this.attributes.indexOf(DeviceAttribute.WEIGHT);
            if (var10 >= 0) {
               this.notifyItemChanged(var10);
            }
         }
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
         int[] var0 = new int[DeviceAttribute.values().length];

         try {
            var0[DeviceAttribute.GERMSHIELD_STATUS.ordinal()] = 1;
         } catch (NoSuchFieldError var42) {
         }

         try {
            var0[DeviceAttribute.STANDBY_MODE.ordinal()] = 2;
         } catch (NoSuchFieldError var41) {
         }

         try {
            var0[DeviceAttribute.DISINFECTION_STATUS.ordinal()] = 3;
         } catch (NoSuchFieldError var40) {
         }

         try {
            var0[DeviceAttribute.MANUAL_MODE.ordinal()] = 4;
         } catch (NoSuchFieldError var39) {
         }

         try {
            var0[DeviceAttribute.AUTO_MODE.ordinal()] = 5;
         } catch (NoSuchFieldError var38) {
         }

         try {
            var0[DeviceAttribute.FILTER_STATUS.ordinal()] = 6;
         } catch (NoSuchFieldError var37) {
         }

         try {
            var0[DeviceAttribute.MODE_BUTTONS.ordinal()] = 7;
         } catch (NoSuchFieldError var36) {
         }

         try {
            var0[DeviceAttribute.GERMSHIELD_NM.ordinal()] = 8;
         } catch (NoSuchFieldError var35) {
         }

         try {
            var0[DeviceAttribute.BRIGHTNESS.ordinal()] = 9;
         } catch (NoSuchFieldError var34) {
         }

         try {
            var0[DeviceAttribute.CLEAN_AIR_ETA.ordinal()] = 10;
         } catch (NoSuchFieldError var33) {
         }

         try {
            var0[DeviceAttribute.OFFLINE.ordinal()] = 11;
         } catch (NoSuchFieldError var32) {
         }

         try {
            var0[DeviceAttribute.N_OFFLINE.ordinal()] = 12;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[DeviceAttribute.OTA.ordinal()] = 13;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[DeviceAttribute.TIMEZONE.ordinal()] = 14;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[DeviceAttribute.SEPARATOR.ordinal()] = 15;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[DeviceAttribute.N_HINS.ordinal()] = 16;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[DeviceAttribute.N_ON_OFF.ordinal()] = 17;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[DeviceAttribute.N_MODE_BUTTONS.ordinal()] = 18;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[DeviceAttribute.N_FAN_SPEED.ordinal()] = 19;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[DeviceAttribute.N_BRIGHTNESS.ordinal()] = 20;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[DeviceAttribute.SUB_AUTO.ordinal()] = 21;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[DeviceAttribute.TARGET_TEMPERATURE.ordinal()] = 22;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[DeviceAttribute.N_FILTER_STATUS.ordinal()] = 23;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[DeviceAttribute.N_CHILD_LOCK.ordinal()] = 24;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[DeviceAttribute.AUTO_RH.ordinal()] = 25;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[DeviceAttribute.WICK_STATUS.ordinal()] = 26;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[DeviceAttribute.TIMER.ordinal()] = 27;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[DeviceAttribute.DRY_MODE.ordinal()] = 28;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[DeviceAttribute.OSCILLATION.ordinal()] = 29;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[DeviceAttribute.FAN_PRESET.ordinal()] = 30;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DeviceAttribute.HUM_ON_OFF.ordinal()] = 31;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DeviceAttribute.WEIGHT.ordinal()] = 32;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceAttribute.DETECT_CAT.ordinal()] = 33;
         } catch (NoSuchFieldError var10) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ModeIcon.values().length];

         try {
            var0[ModeIcon.STANDBY.ordinal()] = 1;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[ModeIcon.FAN_SPEED.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[ModeIcon.AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[ModeIcon.WATERDROP_AUTO.ordinal()] = 4;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ModeIcon.NIGHT.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ModeIcon.CHILD_LOCK.ordinal()] = 6;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ModeIcon.DISINFECTION.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ModeIcon.ECO.ordinal()] = 8;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
