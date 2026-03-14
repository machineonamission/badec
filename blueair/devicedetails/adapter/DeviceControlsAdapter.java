package com.blueair.devicedetails.adapter;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoLevel;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.CoolSubMode;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasCoolMainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.core.model.TimerState;
import com.blueair.core.model.WickDryingGear;
import com.blueair.devicedetails.databinding.HolderDeviceTestBinding;
import com.blueair.devicedetails.util.AttributeAction;
import com.blueair.devicedetails.util.DeviceControl;
import com.blueair.devicedetails.util.DeviceControlGroup;
import com.blueair.devicedetails.viewholder.DeviceAlarmsHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoDryHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoLevelHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoRefreshHolder;
import com.blueair.devicedetails.viewholder.DeviceBrightnessV2Holder;
import com.blueair.devicedetails.viewholder.DeviceControlHolder;
import com.blueair.devicedetails.viewholder.DeviceDisinfectingHolder;
import com.blueair.devicedetails.viewholder.DeviceDualOscillationHolder;
import com.blueair.devicedetails.viewholder.DeviceFanSpeedV2Holder;
import com.blueair.devicedetails.viewholder.DeviceFilterV2Holder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldStatusV2Holder;
import com.blueair.devicedetails.viewholder.DeviceHinsPureHolder;
import com.blueair.devicedetails.viewholder.DeviceHintHolder;
import com.blueair.devicedetails.viewholder.DeviceHumidificationHolder;
import com.blueair.devicedetails.viewholder.DeviceMainModeDehumHolder;
import com.blueair.devicedetails.viewholder.DeviceModeButtonsV2Holder;
import com.blueair.devicedetails.viewholder.DeviceMoodLampHolder;
import com.blueair.devicedetails.viewholder.DeviceMsgHolder;
import com.blueair.devicedetails.viewholder.DeviceNightLampHolder;
import com.blueair.devicedetails.viewholder.DeviceNightSleepHolder;
import com.blueair.devicedetails.viewholder.DeviceOfflineV2Holder;
import com.blueair.devicedetails.viewholder.DeviceOscillationV2Holder;
import com.blueair.devicedetails.viewholder.DeviceSchedulesHolder;
import com.blueair.devicedetails.viewholder.DeviceSettingsHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetHumidityHolder;
import com.blueair.devicedetails.viewholder.DeviceTargetTemperatureV2Holder;
import com.blueair.devicedetails.viewholder.DeviceTestHolder;
import com.blueair.devicedetails.viewholder.DeviceTimerHolder;
import com.blueair.devicedetails.viewholder.DeviceWickDryingHolder;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ModeIcon;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010,\u001a\u00020&H\u0002J\u000e\u0010-\u001a\u00020&2\u0006\u0010.\u001a\u00020\u000eJ\u000e\u0010/\u001a\u00020&2\u0006\u0010#\u001a\u00020\u001cJ\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cJ\u000e\u00102\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cJ\u0006\u00103\u001a\u00020&J\u0006\u00104\u001a\u00020&J\u0006\u00105\u001a\u00020&J\u0006\u00106\u001a\u00020&J\u000e\u00107\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cJ\u000e\u00108\u001a\u00020&2\u0006\u00101\u001a\u00020\u001cJ\u0014\u00109\u001a\u00020&2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\rJ\u001c\u0010:\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>H\u0016J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020AH\u0002J\u001c\u0010B\u001a\u00020&2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010D\u001a\u00020>H\u0016J\u0010\u0010E\u001a\u00020>2\u0006\u0010D\u001a\u00020>H\u0016J\b\u0010F\u001a\u00020>H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00180\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceControlsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "group", "Lcom/blueair/devicedetails/util/DeviceControlGroup;", "onActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/devicedetails/util/AttributeAction;", "<init>", "(Lcom/blueair/devicedetails/util/DeviceControlGroup;Lio/reactivex/subjects/PublishSubject;)V", "getGroup", "()Lcom/blueair/devicedetails/util/DeviceControlGroup;", "controls", "", "Lcom/blueair/devicedetails/util/DeviceControl;", "closedControls", "", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "Lcom/blueair/core/model/DeviceScheduleMerged;", "schedules", "getSchedules", "()Ljava/util/List;", "", "autoRefreshHintClosedBefore", "getAutoRefreshHintClosedBefore", "()Z", "humHintClosedBefore", "loopHintClosedBefore", "nightSleepHintClosedBefore", "forceOffline", "onItemCountChangedListener", "Lkotlin/Function0;", "", "getOnItemCountChangedListener", "()Lkotlin/jvm/functions/Function0;", "setOnItemCountChangedListener", "(Lkotlin/jvm/functions/Function0;)V", "firstRefresh", "refreshControls", "notifyItemChanged", "control", "setForceOffline", "setAutoRefreshHintClosedBefore", "closedBefore", "setHumHintClosedBefore", "markSkinHintClosedBefore", "markSmartHintClosedBefore", "markHeatingHintClosedBefore", "markCantHeatHintClosedBefore", "setLoopHintClosedBefore", "setNightSleepHintClosedBefore", "notifySchedulesUpdate", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "handleModeAction", "mode", "Lcom/blueair/viewcore/utils/ModeIcon;", "onBindViewHolder", "holder", "position", "getItemViewType", "getItemCount", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceControlsAdapter extends RecyclerView.Adapter {
   private boolean autoRefreshHintClosedBefore;
   private final Set closedControls;
   private List controls;
   private Device device;
   private boolean firstRefresh;
   private boolean forceOffline;
   private final DeviceControlGroup group;
   private boolean humHintClosedBefore;
   private boolean loopHintClosedBefore;
   private boolean nightSleepHintClosedBefore;
   private final PublishSubject onActionPublisher;
   private Function0 onItemCountChangedListener;
   private List schedules;

   // $FF: synthetic method
   public static Unit $r8$lambda$_S_fkWCIXxkQb8yI_S2uwHsQUFE/* $FF was: $r8$lambda$-S_fkWCIXxkQb8yI-S2uwHsQUFE*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$58(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$0CP6H2HGK7xZw7rjIu6HMj0n_Ng/* $FF was: $r8$lambda$0CP6H2HGK7xZw7rjIu6HMj0n-Ng*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$69(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$0cbNy6bdTi78OfkebHeaqasylWo(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$45(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$0mmLc2Wirr3oLVUsP1Zw1AhBoVk(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2JJbV1zpnqxt1AsU95Cl5wrwwSA(DeviceControlsAdapter var0, int var1) {
      return onCreateViewHolder$lambda$28(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2p9XAN1SPIuTxpnvSmiFMRDQYTs(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$72(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$2shu6cAcgMK_EqGxQhFM01GzRoM(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$27(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4_5g7D2JrhFS7X9wlfDMUdmp_cE/* $FF was: $r8$lambda$4-5g7D2JrhFS7X9wlfDMUdmp_cE*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$59(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4Vdr6k2tG_ADdNX9Pd_O0aiW2a4/* $FF was: $r8$lambda$4Vdr6k2tG_ADdNX9Pd-O0aiW2a4*/(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$65(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$5L6sRRln_uz8D7ox4LP__go_bFo/* $FF was: $r8$lambda$5L6sRRln-uz8D7ox4LP--go-bFo*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$62(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$5xnGYpVxZ_c5HDUNIFT7ecfssGc/* $FF was: $r8$lambda$5xnGYpVxZ-c5HDUNIFT7ecfssGc*/(DeviceControlsAdapter var0, FanSpeedEnum var1) {
      return onCreateViewHolder$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$6JVG12AuNDqOMNmEt1dvWr1tEZE(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$47(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$6xtopQk6Rm9dvZHWGCxkXN26FW8(DeviceControlsAdapter var0, AutoLevel var1) {
      return onCreateViewHolder$lambda$75(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$BzxqQt0Eilws0_sx5_BcIUrviS8(DeviceControlsAdapter var0, MainMode var1) {
      return onCreateViewHolder$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$EVhhchqBJsVpGgsqUfOPxySzmNU(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$64(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$FYwq8RjUzJC0_RTBbIVscKfkc1I/* $FF was: $r8$lambda$FYwq8RjUzJC0-RTBbIVscKfkc1I*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$19(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GgpZ8Foi5ZTJyE_25iGdWeBScqc/* $FF was: $r8$lambda$GgpZ8Foi5ZTJyE-25iGdWeBScqc*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$24(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$GxEyK2N2p1x40rxiTFv_erBpvcM/* $FF was: $r8$lambda$GxEyK2N2p1x40rxiTFv-erBpvcM*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$26(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$HTPyfn8oyeRsBo2kZD7iKqa0tA8(DeviceControlsAdapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Hx6VwJY2cyxSSo5_RcqD1RMSNNs/* $FF was: $r8$lambda$Hx6VwJY2cyxSSo5-RcqD1RMSNNs*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$23(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$IsiVGumU2HsVncdkq_GlR29tzO8/* $FF was: $r8$lambda$IsiVGumU2HsVncdkq-GlR29tzO8*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$43(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$IuTqtOCGuathA0FtBVDNt53NxcY(DeviceControlsAdapter var0, MoodLampEnum var1) {
      return onCreateViewHolder$lambda$48(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$JKl8ivO3fLF95A9JFxiOLqM_yPk(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$34(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$LEvaK_A4CnzwktPQsSqP4ZOTv9Q/* $FF was: $r8$lambda$LEvaK-A4CnzwktPQsSqP4ZOTv9Q*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$16(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$M7SDn5rad81hKDN0wIytbzqMN3o(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$77(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$O_TGDuVj50H2gNXLUHU0cfhlo1w(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$60(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$PKWgfoqvmJD0Xju74wRFUAbv6h0(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$57(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$QSMwYDtf8Zv0JrQs0dsOJ39hzL4(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$QXeiAofw8pNjXrhndMZoD_KZSBE(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SkvHdFv_ca1_fDxAzUO_auOEcV8/* $FF was: $r8$lambda$SkvHdFv_ca1-fDxAzUO_auOEcV8*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$67(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Sqz266T502QJLq8zSJRHGvbOGec(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$17(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$SxVSGxV2c8D0XOJpgLx8l7Wl5ac(DeviceControlsAdapter var0, WickDryingGear var1) {
      return onCreateViewHolder$lambda$52(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WvmRShKD9xTICTlG1Mg8gOKa47s(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$56(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$X19HZ6vCIAcWfmXG1sFPFHh_gtU(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$55(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Xzc8YwKCWf5I3qsSaLzwiieC0qA(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YQTZNG2502lCSric4Kp0C3EnoWA(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$25(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Z6ygVYnpiOECWeYSLFNkewDZ_Vs(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$66(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ZkR6I7_yxFVudk1WGQ8xJerNWiE(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$38(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_RKA8ZzxFH1nCYHdWPsO0jP2yjk(DeviceControlsAdapter var0, TimerState var1) {
      return onCreateViewHolder$lambda$46(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$a5bsJtEJhiz6wRg2lGvxHqGqGiY(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$78(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$eELoyB7zzfOzLrlvKFmzL0NwjEQ(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$37(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$fm_uVYc7VLjFyZLWWQ8sjsoM2JQ(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$53(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gqM96qdgTcga8_LVYGEvm9rEd4I/* $FF was: $r8$lambda$gqM96qdgTcga8-LVYGEvm9rEd4I*/(AutoLevel var0) {
      return onCreateViewHolder$lambda$76(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iMCzDSnEg_R7tS4Gr2xTOuRbviM(DeviceControlsAdapter var0, int var1) {
      return onCreateViewHolder$lambda$35(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iQ_08GCyKCnbX2nzG8E5_GLgQPY/* $FF was: $r8$lambda$iQ_08GCyKCnbX2nzG8E5-GLgQPY*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$20(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$k3cYIrP972HTsFzW1JpJ8XdsbF8(DeviceControlsAdapter var0, int var1) {
      return onCreateViewHolder$lambda$49(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$k_4nzOIe_ENOaETQGseLdTQB5bs/* $FF was: $r8$lambda$k_4nzOIe-ENOaETQGseLdTQB5bs*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$74(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$kjO_d2IY7KkxZM1vF0T8PRixwCA/* $FF was: $r8$lambda$kjO-d2IY7KkxZM1vF0T8PRixwCA*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$63(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mDqbqyJIQtcFOxW_cq2tj_JBn2A/* $FF was: $r8$lambda$mDqbqyJIQtcFOxW_cq2tj-JBn2A*/(DeviceControlsAdapter var0, ModeIcon var1) {
      return onCreateViewHolder$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$nQfl_OhBd5SOrlP2OC1mtS7VQvs/* $FF was: $r8$lambda$nQfl-OhBd5SOrlP2OC1mtS7VQvs*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$61(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$nwPvx3VaF_lXchFi7ejwEncFK4M(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$54(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pLKIZzznDm9muhH9tsPlL2vUDIo(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$29(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pV7OPzIRsmzDVQTTEg75FddT2ts(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$71(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$qfmivEAOd8R8fQ9399d6aPJIBSQ(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$32(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$rvXgeyOGIdbaLQ_Lvv992FBBBy4(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$41(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$sJ2w7dK7WdrWhbuK795Lkn_Fc5Q/* $FF was: $r8$lambda$sJ2w7dK7WdrWhbuK795Lkn-Fc5Q*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$50(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$tQ7euU3MDCjxucwBJ1EgP3Gvjg4(DeviceControlsAdapter var0, double var1) {
      return onCreateViewHolder$lambda$68(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uVAaylBtFn6UcR7SZz7_si0wck0/* $FF was: $r8$lambda$uVAaylBtFn6UcR7SZz7-si0wck0*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$73(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$uXqeeiDKHbmU89y__fSKMOuYBqQ/* $FF was: $r8$lambda$uXqeeiDKHbmU89y-_fSKMOuYBqQ*/(DeviceControlsAdapter var0, boolean var1) {
      return onCreateViewHolder$lambda$44(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$vGQ4hOpaYVv4Cq_nNYOUUN_Koko/* $FF was: $r8$lambda$vGQ4hOpaYVv4Cq-nNYOUUN_Koko*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$21(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xFemjG4s5sjmlDW_Jui_Ko4y8LY/* $FF was: $r8$lambda$xFemjG4s5sjmlDW-Jui-Ko4y8LY*/(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$70(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$xGCNVpgheLbEANdp5_hvqHGvqRY(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$51(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$z5zQyS_gdpF1Hp5OQb_yd03q7ec(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$18(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zMBycYuHvAQAS1fllnH81Ad4EzE(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$30(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zOooANmYL8oz8wn_bbB_T8fPzas(DeviceControlsAdapter var0) {
      return onCreateViewHolder$lambda$40(var0);
   }

   public DeviceControlsAdapter(DeviceControlGroup var1, PublishSubject var2) {
      Intrinsics.checkNotNullParameter(var1, "group");
      Intrinsics.checkNotNullParameter(var2, "onActionPublisher");
      super();
      this.group = var1;
      this.onActionPublisher = var2;
      this.controls = CollectionsKt.emptyList();
      this.closedControls = (Set)(new LinkedHashSet());
      this.schedules = CollectionsKt.emptyList();
      this.firstRefresh = true;
   }

   private final void handleModeAction(ModeIcon var1) {
      Device var2 = this.device;
      if (var2 != null) {
         switch (DeviceControlsAdapter.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()]) {
            case 1:
               this.onActionPublisher.onNext(AttributeAction.ManualModeAction.INSTANCE);
               break;
            case 2:
            case 3:
               if (var2 instanceof HasStandBy && var2 instanceof HasFanSpeed) {
                  if (!((HasStandBy)var2).isStandByOn()) {
                     HasFanSpeed var4 = (HasFanSpeed)var2;
                     if (var4.getAutoMode() == AutoMode.ON) {
                        this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(DeviceKt.isDisinfectionOn(var2)));
                        return;
                     }

                     if (var4.getAutoMode() == AutoMode.OFF) {
                        this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(true));
                        return;
                     }
                  }
               } else if (var2 instanceof HasFanSpeed) {
                  HasFanSpeed var3 = (HasFanSpeed)var2;
                  if (var3.getAutoMode() == AutoMode.ON) {
                     this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(false));
                     return;
                  }

                  if (var3.getAutoMode() == AutoMode.OFF) {
                     this.onActionPublisher.onNext(new AttributeAction.AutoModeAction(true));
                     return;
                  }
               }
               break;
            case 4:
               if (!(var2 instanceof HasStandBy)) {
                  this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                  return;
               }

               if (!((HasStandBy)var2).isStandByOn()) {
                  this.onActionPublisher.onNext(AttributeAction.NightModeAction.INSTANCE);
                  return;
               }
               break;
            case 5:
               this.onActionPublisher.onNext(AttributeAction.DisinfectionModeAction.INSTANCE);
               return;
            case 6:
               this.onActionPublisher.onNext(AttributeAction.EcoModeAction.INSTANCE);
               return;
         }
      }

   }

   private static final Unit onCreateViewHolder$lambda$1(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.OFFLINE);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$15(DeviceControlsAdapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      Device var2 = var0.device;
      if (var2 instanceof HasDehumidifierMainMode) {
         DehSubMode var13 = var1.toDehSubMode();
         if (var13 != null) {
            var0.onActionPublisher.onNext(new AttributeAction.DehSubModeAction(var13));
            Enum var3 = var13;
         } else {
            ApSubMode var5 = var1.toApSubMode();
            if (var5 != null) {
               var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var5));
               Enum var4 = var5;
            }
         }
      } else if (!(var2 instanceof DeviceBlue40) && !(var2 instanceof DeviceMiniRestful)) {
         if (var2 instanceof HasMode) {
            Mode var7 = var1.toMode();
            if (var7 != null) {
               var0.onActionPublisher.onNext(new AttributeAction.ModeAction(var7));
            }
         } else if (var2 instanceof HasHumMainMode) {
            Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.blueair.core.model.HasHumMainMode");
            if (((HasHumMainMode)var2).isInMainMode(MainMode.Humidification)) {
               HumSubMode var8 = var1.toHumSubMode();
               if (var8 != null) {
                  var0.onActionPublisher.onNext(new AttributeAction.HumSubModeAction(var8));
               }
            } else if (var1 == ModeIcon.SKIN) {
               var0.onActionPublisher.onNext(new AttributeAction.HumSubModeAction(HumSubMode.SKIN));
            } else {
               ApSubMode var9 = var1.toApSubMode();
               if (var9 != null) {
                  var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var9));
               }
            }
         } else if (var2 instanceof DevicePet20) {
            if (var1 == ModeIcon.SMART) {
               var0.onActionPublisher.onNext(new AttributeAction.MainModeAction(MainMode.SMART));
            } else {
               ApSubMode var10 = var1.toApSubMode();
               if (var10 != null) {
                  var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var10));
               }
            }
         } else if (var2 instanceof HasCoolMainMode) {
            CoolSubMode var11 = var1.toCoolSubMode();
            if (var11 != null) {
               var0.onActionPublisher.onNext(new AttributeAction.CoolSubModeAction(var11));
            }
         } else if (var2 instanceof HasCombo3in1MainMode) {
            ApSubMode var12 = var1.toApSubMode();
            if (var12 != null) {
               var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var12));
            }
         } else {
            var0.handleModeAction(var1);
         }
      } else {
         ApSubMode var6 = var1.toApSubMode();
         if (var6 != null) {
            var0.onActionPublisher.onNext(new AttributeAction.ApSubModeAction(var6));
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$16(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.MSG_FILTER_DOOR_OPEN);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$17(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.MSG_FRONT_PANEL_OPEN);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$18(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.MSG_TOP_PART_DISPLACED);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$19(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.MSG_WATER_TANK_FULL);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$2(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.TroubleShootAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$20(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.MSG_WATER_TANK_FAILURE);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$21(DeviceControlsAdapter var0) {
      var0.closedControls.add(DeviceControl.MSG_WATER_TANK_SHORTAGE);
      var0.refreshControls();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$22(DeviceControlsAdapter var0, FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeed");
      var0.onActionPublisher.onNext(new AttributeAction.FanSpeedAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$23(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.AutoRefreshInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$24(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.AutoRefreshCancelAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$25(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.AutoRefreshHintClosedAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$26(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.AutoRhInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$27(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.AutoRhShowHintAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$28(DeviceControlsAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.AutoRhAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$29(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.ChildLockAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$3(DeviceControlsAdapter var0, MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "mainMode");
      var0.onActionPublisher.onNext(new AttributeAction.MainModeAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$30(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDeviceSchedulesAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$31(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.DualOscillationSettingAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$32(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.DualOscillationStateAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$33(DeviceControlsAdapter var0, boolean var1) {
      if (var1) {
         var0.onActionPublisher.onNext(AttributeAction.OscillationLoopHintClosedAction.INSTANCE);
      } else {
         var0.onActionPublisher.onNext(AttributeAction.OscillationLoopInfoAction.INSTANCE);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$34(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OscillationLoopStateAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$35(DeviceControlsAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.BrightnessPercentageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$37(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenFilterInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$38(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenFilterPageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$40(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenWickInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$41(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenWickPageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$43(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenCubeInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$44(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenCubePageAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$45(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDeviceSettingsAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$46(DeviceControlsAdapter var0, TimerState var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.TimerStateAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$47(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.SelectTimerDurationAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$48(DeviceControlsAdapter var0, MoodLampEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.MoodLampAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$49(DeviceControlsAdapter var0, int var1) {
      var0.onActionPublisher.onNext(new AttributeAction.NightLampAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$5(DeviceControlsAdapter var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "mode");
      MainMode var2 = var1.toMainMode();
      if (var2 != null) {
         var0.onActionPublisher.onNext(new AttributeAction.MainModeAction(var2));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$50(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDeviceAlarmsAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$51(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.WickDryingInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$52(DeviceControlsAdapter var0, WickDryingGear var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.WickDryingAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$53(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDryModeInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$54(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.DryModeCancelAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$55(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.HumModeAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$56(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.CloseHumHintAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$57(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.CloseSkinHintAction.INSTANCE);
      var0.markSkinHintClosedBefore();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$58(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.CloseSmartHintAction.INSTANCE);
      var0.markSmartHintClosedBefore();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$59(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.CloseHeatingHintAction.INSTANCE);
      var0.markHeatingHintClosedBefore();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$60(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.CloseCantHeatHintAction.INSTANCE);
      var0.markCantHeatHintClosedBefore();
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$61(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenGermShieldInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$62(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.GermShieldSwitchAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$63(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenGsnmInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$64(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.GsnmSwitchAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$65(DeviceControlsAdapter var0, boolean var1) {
      var0.onActionPublisher.onNext(AttributeAction.OscillationEnableAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$66(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OscillationSettingAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$67(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenTargetTmpInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$68(DeviceControlsAdapter var0, double var1) {
      var0.onActionPublisher.onNext(new AttributeAction.TargetTemperatureAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$69(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.OpenDisinfectionInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$70(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenHinsInfoAction(false));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$71(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(new AttributeAction.HinsLockAction(false));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$72(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(new AttributeAction.OpenHinsInfoAction(true));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$73(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(new AttributeAction.HinsLockAction(true));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$74(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.AutoLevelInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$75(DeviceControlsAdapter var0, AutoLevel var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.onActionPublisher.onNext(new AttributeAction.AutoLevelAction(var1));
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$76(AutoLevel var0) {
      Intrinsics.checkNotNullParameter(var0, "it");
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$77(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.NightSleepInfoAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private static final Unit onCreateViewHolder$lambda$78(DeviceControlsAdapter var0) {
      var0.onActionPublisher.onNext(AttributeAction.NightSleepHintClosedAction.INSTANCE);
      return Unit.INSTANCE;
   }

   private final void refreshControls() {
      int var1 = this.controls.size();
      Iterable var3 = (Iterable)DeviceControl.Companion.getSupportedControls(this.device, this.group, this.forceOffline);
      Collection var2 = (Collection)(new ArrayList());

      for(Object var5 : var3) {
         DeviceControl var8 = (DeviceControl)var5;
         if (!this.closedControls.contains(var8)) {
            var2.add(var5);
         }
      }

      List var6 = (List)var2;
      this.controls = var6;
      this.notifyItemRangeChanged(0, var6.size());
      if (this.controls.size() != var1 || this.firstRefresh) {
         Function0 var7 = this.onItemCountChangedListener;
         if (var7 != null) {
            var7.invoke();
         }
      }

   }

   public final boolean getAutoRefreshHintClosedBefore() {
      return this.autoRefreshHintClosedBefore;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final DeviceControlGroup getGroup() {
      return this.group;
   }

   public int getItemCount() {
      return this.controls.size();
   }

   public int getItemViewType(int var1) {
      return ((DeviceControl)this.controls.get(var1)).ordinal();
   }

   public final Function0 getOnItemCountChangedListener() {
      return this.onItemCountChangedListener;
   }

   public final List getSchedules() {
      return this.schedules;
   }

   public final void markCantHeatHintClosedBefore() {
      if (this.closedControls.add(DeviceControl.CANT_HEAT_HINT)) {
         this.refreshControls();
      }

   }

   public final void markHeatingHintClosedBefore() {
      if (this.closedControls.add(DeviceControl.HEATING_HINT)) {
         this.refreshControls();
      }

   }

   public final void markSkinHintClosedBefore() {
      if (this.closedControls.add(DeviceControl.SKIN_HINT)) {
         this.refreshControls();
      }

   }

   public final void markSmartHintClosedBefore() {
      if (this.closedControls.add(DeviceControl.SMART_HINT)) {
         this.refreshControls();
      }

   }

   public final void notifyItemChanged(DeviceControl var1) {
      Intrinsics.checkNotNullParameter(var1, "control");
      int var2 = this.controls.indexOf(var1);
      if (var2 >= 0) {
         this.notifyItemChanged(var2);
      }

   }

   public final void notifySchedulesUpdate(List var1) {
      Intrinsics.checkNotNullParameter(var1, "schedules");
      this.schedules = var1;
      this.notifyItemChanged(DeviceControl.SCHEDULE);
   }

   public void onBindViewHolder(DeviceControlHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Device var3 = this.device;
      if (var3 != null) {
         if (var1 instanceof DeviceSchedulesHolder) {
            ((DeviceSchedulesHolder)var1).update(var3, this.forceOffline, this.schedules);
            return;
         }

         if (var1 instanceof DeviceAutoRefreshHolder) {
            ((DeviceAutoRefreshHolder)var1).update(var3, this.forceOffline, this.autoRefreshHintClosedBefore);
            return;
         }

         if (var1 instanceof DeviceHumidificationHolder) {
            ((DeviceHumidificationHolder)var1).update(var3, this.forceOffline, this.humHintClosedBefore);
            return;
         }

         if (var1 instanceof DeviceDualOscillationHolder) {
            ((DeviceDualOscillationHolder)var1).update(var3, this.forceOffline, this.loopHintClosedBefore);
            return;
         }

         if (var1 instanceof DeviceNightSleepHolder) {
            ((DeviceNightSleepHolder)var1).update(var3, this.forceOffline, this.nightSleepHintClosedBefore);
            return;
         }

         var1.update(var3, this.forceOffline);
      }

   }

   public DeviceControlHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      DeviceControl var6 = (DeviceControl)DeviceControl.getEntries().get(var2);
      var2 = DeviceControlsAdapter.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
      FilterConfig var3 = null;
      Object var5 = null;
      Object var4 = null;
      Float var7 = 16.0F;
      switch (var2) {
         case 1:
            return DeviceOfflineV2Holder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda0(this), new DeviceControlsAdapter$$ExternalSyntheticLambda2(this));
         case 2:
            return DeviceMainModeDehumHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda14(this));
         case 3:
            return DeviceModeButtonsV2Holder.Companion.newInstance(var1, this.device, true, new DeviceControlsAdapter$$ExternalSyntheticLambda26(this));
         case 4:
            return DeviceModeButtonsV2Holder.Companion.newInstance$default(DeviceModeButtonsV2Holder.Companion, var1, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda38(this), 4, (Object)null);
         case 5:
            return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, var1, R.string.filter_door_open, R.string.filter_door_open_content, (Float)null, (Integer)null, new DeviceControlsAdapter$$ExternalSyntheticLambda50(this), 24, (Object)null);
         case 6:
            return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, var1, R.string.front_panel_open, R.string.front_panel_open_content, (Float)null, (Integer)null, new DeviceControlsAdapter$$ExternalSyntheticLambda57(this), 24, (Object)null);
         case 7:
            return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, var1, R.string.body_not_in_position, R.string.body_not_in_position_desc, (Float)null, (Integer)null, new DeviceControlsAdapter$$ExternalSyntheticLambda58(this), 24, (Object)null);
         case 8:
            return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, var1, R.string.msg_title_water_tank_full, R.string.msg_content_water_tank_full, (Float)null, (Integer)null, new DeviceControlsAdapter$$ExternalSyntheticLambda59(this), 24, (Object)null);
         case 9:
            return DeviceMsgHolder.Companion.newInstance$default(DeviceMsgHolder.Companion, var1, R.string.msg_title_water_tank_failure, R.string.msg_content_water_tank_failure, (Float)null, (Integer)null, new DeviceControlsAdapter$$ExternalSyntheticLambda60(this), 24, (Object)null);
         case 10:
            return DeviceMsgHolder.Companion.newInstance(var1, R.string.msg_title_water_tank_shortage, R.string.msg_content_water_tank_shortage, 32.0F, R.drawable.ic_water_shortage, new DeviceControlsAdapter$$ExternalSyntheticLambda11(this));
         case 11:
            return DeviceFanSpeedV2Holder.Companion.newInstance(var1, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda22(this));
         case 12:
            return DeviceAutoRefreshHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda33(this), new DeviceControlsAdapter$$ExternalSyntheticLambda44(this), new DeviceControlsAdapter$$ExternalSyntheticLambda55(this));
         case 13:
            return DeviceTargetHumidityHolder.Companion.newInstance(var1, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda61(this), new DeviceControlsAdapter$$ExternalSyntheticLambda62(this), new DeviceControlsAdapter$$ExternalSyntheticLambda63(this));
         case 14:
            return DeviceSchedulesHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda64(this), new DeviceControlsAdapter$$ExternalSyntheticLambda1(this));
         case 15:
            return DeviceDualOscillationHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda3(this), new DeviceControlsAdapter$$ExternalSyntheticLambda4(this), new DeviceControlsAdapter$$ExternalSyntheticLambda5(this), new DeviceControlsAdapter$$ExternalSyntheticLambda6(this));
         case 16:
            return DeviceBrightnessV2Holder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda7(this));
         case 17:
            DeviceFilterV2Holder.Companion var27 = DeviceFilterV2Holder.Companion;
            Device var22 = this.device;
            DeviceFilterType var16 = DeviceFilterType.FILTER;
            DeviceConfigProvider var25 = DeviceConfigProvider.INSTANCE;
            Device var28 = this.device;
            var3 = (FilterConfig)var5;
            if (var28 != null) {
               var3 = DeviceConfigProvider.INSTANCE.getFilterConfig(var28, DeviceFilterType.FILTER);
            }

            return var27.newInstance(var1, var22, var16, var25.hasBuyFilterLink(var3), new DeviceControlsAdapter$$ExternalSyntheticLambda8(this), new DeviceControlsAdapter$$ExternalSyntheticLambda9(this));
         case 18:
            DeviceFilterV2Holder.Companion var21 = DeviceFilterV2Holder.Companion;
            Device var24 = this.device;
            DeviceFilterType var19 = DeviceFilterType.WICK;
            DeviceConfigProvider var15 = DeviceConfigProvider.INSTANCE;
            Device var26 = this.device;
            if (var26 != null) {
               var3 = DeviceConfigProvider.INSTANCE.getFilterConfig(var26, DeviceFilterType.WICK);
            }

            return var21.newInstance(var1, var24, var19, var15.hasBuyFilterLink(var3), new DeviceControlsAdapter$$ExternalSyntheticLambda10(this), new DeviceControlsAdapter$$ExternalSyntheticLambda12(this));
         case 19:
            DeviceFilterV2Holder.Companion var20 = DeviceFilterV2Holder.Companion;
            Device var23 = this.device;
            DeviceFilterType var18 = DeviceFilterType.REFRESHER;
            DeviceConfigProvider var8 = DeviceConfigProvider.INSTANCE;
            Device var9 = this.device;
            var3 = (FilterConfig)var4;
            if (var9 != null) {
               var3 = DeviceConfigProvider.INSTANCE.getFilterConfig(var9, DeviceFilterType.REFRESHER);
            }

            return var20.newInstance(var1, var23, var18, var8.hasBuyFilterLink(var3), new DeviceControlsAdapter$$ExternalSyntheticLambda13(this), new DeviceControlsAdapter$$ExternalSyntheticLambda15(this));
         case 20:
            return DeviceSettingsHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda16(this));
         case 21:
            return DeviceTimerHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda17(this), new DeviceControlsAdapter$$ExternalSyntheticLambda18(this));
         case 22:
            return DeviceMoodLampHolder.Companion.newInstance(var1, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda19(this));
         case 23:
            return DeviceNightLampHolder.Companion.newInstance(var1, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda20(this));
         case 24:
            return DeviceAlarmsHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda21(this));
         case 25:
            return DeviceWickDryingHolder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda23(this), new DeviceControlsAdapter$$ExternalSyntheticLambda24(this));
         case 26:
            return DeviceAutoDryHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda25(this), new DeviceControlsAdapter$$ExternalSyntheticLambda27(this));
         case 27:
            return DeviceHumidificationHolder.Companion.newInstance$default(DeviceHumidificationHolder.Companion, var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda28(this), new DeviceControlsAdapter$$ExternalSyntheticLambda29(this), 2, (Object)null);
         case 28:
            return DeviceHintHolder.Companion.newInstance(var1, R.string.skin_mode_hint, 8.0F, new DeviceControlsAdapter$$ExternalSyntheticLambda30(this));
         case 29:
            return DeviceHintHolder.Companion.newInstance(var1, R.string.smart_mode_hint, var7, new DeviceControlsAdapter$$ExternalSyntheticLambda31(this));
         case 30:
            return DeviceHintHolder.Companion.newInstance(var1, R.string.heating_mode_hint, var7, new DeviceControlsAdapter$$ExternalSyntheticLambda32(this));
         case 31:
            return DeviceHintHolder.Companion.newInstance(var1, R.string.cant_heat_hint, var7, new DeviceControlsAdapter$$ExternalSyntheticLambda34(this));
         case 32:
            return DeviceGermShieldStatusV2Holder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda35(this), new DeviceControlsAdapter$$ExternalSyntheticLambda36(this));
         case 33:
            return DeviceGermShieldStatusV2Holder.Companion.newInstance(var1, true, new DeviceControlsAdapter$$ExternalSyntheticLambda37(this), new DeviceControlsAdapter$$ExternalSyntheticLambda39(this));
         case 34:
            return DeviceOscillationV2Holder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda40(this), new DeviceControlsAdapter$$ExternalSyntheticLambda41(this));
         case 35:
            return DeviceTargetTemperatureV2Holder.Companion.newInstance(var1, this.device, false, new DeviceControlsAdapter$$ExternalSyntheticLambda42(this), new DeviceControlsAdapter$$ExternalSyntheticLambda43(this));
         case 36:
            return DeviceDisinfectingHolder.Companion.newInstance(var1, new DeviceControlsAdapter$$ExternalSyntheticLambda45(this));
         case 37:
            return DeviceHinsPureHolder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda46(this), new DeviceControlsAdapter$$ExternalSyntheticLambda47(this));
         case 38:
            return DeviceHinsPureHolder.Companion.newInstance(var1, true, new DeviceControlsAdapter$$ExternalSyntheticLambda48(this), new DeviceControlsAdapter$$ExternalSyntheticLambda49(this));
         case 39:
            return DeviceAutoLevelHolder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda51(this), new DeviceControlsAdapter$$ExternalSyntheticLambda52(this), new DeviceControlsAdapter$$ExternalSyntheticLambda53());
         case 40:
            return DeviceNightSleepHolder.Companion.newInstance(var1, false, new DeviceControlsAdapter$$ExternalSyntheticLambda54(this), new DeviceControlsAdapter$$ExternalSyntheticLambda56(this));
         default:
            DeviceTestHolder var10 = DeviceTestHolder.Companion.newInstance(var1);
            TextView var17 = ((HolderDeviceTestBinding)var10.getBinding()).title;
            StringBuilder var14 = new StringBuilder();
            var14.append(var6.name());
            var14.append(" - ");
            var14.append(var6.getGroup());
            var17.setText((CharSequence)var14.toString());
            return var10;
      }
   }

   public final void setAutoRefreshHintClosedBefore(boolean var1) {
      this.autoRefreshHintClosedBefore = var1;
      this.notifyItemChanged(DeviceControl.AUTO_REFRESH);
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         this.refreshControls();
         this.firstRefresh = false;
      }

   }

   public final void setForceOffline(boolean var1) {
      this.forceOffline = var1;
      this.refreshControls();
   }

   public final void setHumHintClosedBefore(boolean var1) {
      this.humHintClosedBefore = var1;
      this.notifyItemChanged(DeviceControl.MODE_HUMIDIFICATION);
   }

   public final void setLoopHintClosedBefore(boolean var1) {
      if (var1 != this.loopHintClosedBefore) {
         this.loopHintClosedBefore = var1;
         this.notifyItemChanged(DeviceControl.DUAL_OSCILLATION);
      }

   }

   public final void setNightSleepHintClosedBefore(boolean var1) {
      if (var1 != this.nightSleepHintClosedBefore) {
         this.nightSleepHintClosedBefore = var1;
         this.notifyItemChanged(DeviceControl.NIGHT_SLEEP);
      }

   }

   public final void setOnItemCountChangedListener(Function0 var1) {
      this.onItemCountChangedListener = var1;
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
         int[] var0 = new int[DeviceControl.values().length];

         try {
            var0[DeviceControl.OFFLINE.ordinal()] = 1;
         } catch (NoSuchFieldError var47) {
         }

         try {
            var0[DeviceControl.MAIN_MODES_DEHUM.ordinal()] = 2;
         } catch (NoSuchFieldError var46) {
         }

         try {
            var0[DeviceControl.MAIN_MODES_COMBO3IN1.ordinal()] = 3;
         } catch (NoSuchFieldError var45) {
         }

         try {
            var0[DeviceControl.MODE_BUTTONS.ordinal()] = 4;
         } catch (NoSuchFieldError var44) {
         }

         try {
            var0[DeviceControl.MSG_FILTER_DOOR_OPEN.ordinal()] = 5;
         } catch (NoSuchFieldError var43) {
         }

         try {
            var0[DeviceControl.MSG_FRONT_PANEL_OPEN.ordinal()] = 6;
         } catch (NoSuchFieldError var42) {
         }

         try {
            var0[DeviceControl.MSG_TOP_PART_DISPLACED.ordinal()] = 7;
         } catch (NoSuchFieldError var41) {
         }

         try {
            var0[DeviceControl.MSG_WATER_TANK_FULL.ordinal()] = 8;
         } catch (NoSuchFieldError var40) {
         }

         try {
            var0[DeviceControl.MSG_WATER_TANK_FAILURE.ordinal()] = 9;
         } catch (NoSuchFieldError var39) {
         }

         try {
            var0[DeviceControl.MSG_WATER_TANK_SHORTAGE.ordinal()] = 10;
         } catch (NoSuchFieldError var38) {
         }

         try {
            var0[DeviceControl.FAN_SPEED.ordinal()] = 11;
         } catch (NoSuchFieldError var37) {
         }

         try {
            var0[DeviceControl.AUTO_REFRESH.ordinal()] = 12;
         } catch (NoSuchFieldError var36) {
         }

         try {
            var0[DeviceControl.TARGET_HUM.ordinal()] = 13;
         } catch (NoSuchFieldError var35) {
         }

         try {
            var0[DeviceControl.SCHEDULE.ordinal()] = 14;
         } catch (NoSuchFieldError var34) {
         }

         try {
            var0[DeviceControl.DUAL_OSCILLATION.ordinal()] = 15;
         } catch (NoSuchFieldError var33) {
         }

         try {
            var0[DeviceControl.BRIGHTNESS.ordinal()] = 16;
         } catch (NoSuchFieldError var32) {
         }

         try {
            var0[DeviceControl.FILTER.ordinal()] = 17;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[DeviceControl.WICK.ordinal()] = 18;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[DeviceControl.REFRESHER.ordinal()] = 19;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[DeviceControl.SETTINGS.ordinal()] = 20;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[DeviceControl.TIMER.ordinal()] = 21;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[DeviceControl.MOOD_LAMP.ordinal()] = 22;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[DeviceControl.NIGHT_LAMP.ordinal()] = 23;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[DeviceControl.ALARMS.ordinal()] = 24;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[DeviceControl.WICK_DRYING.ordinal()] = 25;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[DeviceControl.AUTO_DRY.ordinal()] = 26;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[DeviceControl.MODE_HUMIDIFICATION.ordinal()] = 27;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[DeviceControl.SKIN_HINT.ordinal()] = 28;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[DeviceControl.SMART_HINT.ordinal()] = 29;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[DeviceControl.HEATING_HINT.ordinal()] = 30;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[DeviceControl.CANT_HEAT_HINT.ordinal()] = 31;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[DeviceControl.GERM_SHIELD.ordinal()] = 32;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[DeviceControl.GERM_SHIELD_NIGHT.ordinal()] = 33;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[DeviceControl.OSCILLATION.ordinal()] = 34;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[DeviceControl.TARGET_TEMPERATURE.ordinal()] = 35;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DeviceControl.DISINFECTION.ordinal()] = 36;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DeviceControl.HINS_PURE.ordinal()] = 37;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DeviceControl.HINS_PURE_NIGHT.ordinal()] = 38;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceControl.AUTO_LEVEL.ordinal()] = 39;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceControl.NIGHT_SLEEP.ordinal()] = 40;
         } catch (NoSuchFieldError var8) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ModeIcon.values().length];

         try {
            var0[ModeIcon.FAN_SPEED.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[ModeIcon.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[ModeIcon.WATERDROP_AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ModeIcon.NIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ModeIcon.DISINFECTION.ordinal()] = 5;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ModeIcon.ECO.ordinal()] = 6;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
