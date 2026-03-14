package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasGermShieldMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.SimpleEvent;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.util.DeviceSetting;
import com.blueair.devicedetails.util.DeviceWelcomeHomeProvider;
import com.blueair.devicedetails.view.ButtonTileConstraintLayout;
import com.blueair.devicedetails.viewholder.DeviceAutoDryEnabledHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoModeTriggersHolder;
import com.blueair.devicedetails.viewholder.DeviceAutoRefreshEnabledHolder;
import com.blueair.devicedetails.viewholder.DeviceChildLockHolder;
import com.blueair.devicedetails.viewholder.DeviceCustomNameHolder;
import com.blueair.devicedetails.viewholder.DeviceDisplayModeHolder;
import com.blueair.devicedetails.viewholder.DeviceDryModeHolder;
import com.blueair.devicedetails.viewholder.DeviceErrorReportHolder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldHolder;
import com.blueair.devicedetails.viewholder.DeviceGermShieldNightSettingHolder;
import com.blueair.devicedetails.viewholder.DeviceHourFormatHolder;
import com.blueair.devicedetails.viewholder.DeviceLinkedHolder;
import com.blueair.devicedetails.viewholder.DeviceProductInfoHolder;
import com.blueair.devicedetails.viewholder.DeviceRefresherEnabledHolder;
import com.blueair.devicedetails.viewholder.DeviceSettingHolder;
import com.blueair.devicedetails.viewholder.DeviceSettingStandByModeHolder;
import com.blueair.devicedetails.viewholder.DeviceTVOCSettingHolder;
import com.blueair.devicedetails.viewholder.DeviceTemperatureHolder;
import com.blueair.devicedetails.viewholder.DeviceTimezoneSettingsHolder;
import com.blueair.devicedetails.viewholder.DeviceUserManualHolder;
import com.blueair.devicedetails.viewholder.DeviceWelcomeHomeHolder;
import com.blueair.devicedetails.viewholder.DeviceWickDryEnabledHolder;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001NBÉ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00120\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0016J\u0018\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020@H\u0016J\u0018\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u00022\u0006\u0010B\u001a\u00020@H\u0016J\u0017\u0010I\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020@H\u0002¢\u0006\u0002\u0010JJ\u000e\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00120\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0#X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u0001008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0004\u0018\u0001092\b\u0010$\u001a\u0004\u0018\u000109@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\"\u0010=\u001a\u0004\u0018\u0001092\b\u0010$\u001a\u0004\u0018\u000109@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<¨\u0006O"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "deviceInfoPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "childLockPublisher", "Lcom/blueair/core/model/Device;", "standbyPublisher", "germShieldPublisher", "linkedPublisher", "deviceNameClickPublisher", "autoRefreshClickPublisher", "hourFormatClickPublisher", "displayModeClickPublisher", "timezoneClickPublisher", "", "eventPublisher", "Lcom/blueair/core/model/SimpleEvent;", "", "triggerChangedListener", "Lkotlin/Function0;", "errorReportListener", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "settings", "", "Lcom/blueair/devicedetails/util/DeviceSetting;", "deviceWelcomeHomeProvider", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "getDeviceWelcomeHomeProvider", "()Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "setDeviceWelcomeHomeProvider", "(Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;)V", "excludeSettings", "", "value", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "deviceOffline", "getDeviceOffline", "()Z", "setDeviceOffline", "(Z)V", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "getLinkedDevice", "()Lcom/blueair/core/model/DeviceAware;", "awares", "", "getAwares", "()Ljava/util/List;", "setAwares", "(Ljava/util/List;)V", "Lcom/blueair/core/model/FilterTrigger;", "autoModeTriggerSelected", "getAutoModeTriggerSelected", "()Lcom/blueair/core/model/FilterTrigger;", "g4NightModeTriggerSelected", "getG4NightModeTriggerSelected", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getSettingType", "(I)Ljava/lang/Integer;", "notifyItemChanged", "setting", "addExcluedeSetting", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSettingsAdapter extends RecyclerView.Adapter {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String EVENT_AUTODRY_CHECK = "EVENT_AUTODRY_CHECK";
   public static final String EVENT_DRYMODE_CLICK = "EVENT_DRYMODE_CLICK";
   public static final String EVENT_GERMSHIELD_NIGHT_CHECK = "EVENT_GERMSHIELD_NIGHT_CHECK";
   public static final String EVENT_HOME_LOCATION_CLICK = "EVENT_HOME_LOCATION_CLICK";
   public static final String EVENT_REFRESHER_CHECK = "EVENT_REFRESHER_CHECK";
   public static final String EVENT_TEMPERATURE_CLICK = "EVENT_TEMPERATURE_CLICK";
   public static final String EVENT_TVOC_CHECK = "EVENT_TVOC_CHECK";
   public static final String EVENT_USERMANUAL_CLICK = "EVENT_USERMANUAL_CLICK";
   public static final String EVENT_WELCOME_ENABLED_CHANGE = "EVENT_WELCOME_ENABLED_CHANGE";
   private FilterTrigger autoModeTriggerSelected;
   private final PublishSubject autoRefreshClickPublisher;
   private List awares;
   private final PublishSubject childLockPublisher;
   private Device device;
   private final PublishSubject deviceInfoPublisher;
   private final PublishSubject deviceNameClickPublisher;
   private boolean deviceOffline;
   private DeviceWelcomeHomeProvider deviceWelcomeHomeProvider;
   private final PublishSubject displayModeClickPublisher;
   private final Function0 errorReportListener;
   private final PublishSubject eventPublisher;
   private final Set excludeSettings;
   private FilterTrigger g4NightModeTriggerSelected;
   private final PublishSubject germShieldPublisher;
   private final PublishSubject hourFormatClickPublisher;
   private final PublishSubject linkedPublisher;
   private List settings;
   private final PublishSubject standbyPublisher;
   private final PublishSubject timezoneClickPublisher;
   private final Function0 triggerChangedListener;

   // $FF: synthetic method
   public static void $r8$lambda$03YgI1VBt9iTEIkaZgaQuc3K658(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$37(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$3SF_jiolZ7LRJwnCsU_guJoFoa0(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$20(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$6ivhw5ju0XQJgZreV8IXf6sDao0(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$8yMYsgx5Sxnec9EocRNfcs0cItQ(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$27(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$AfH4PH5hYlpvSdaAg6J1CafjF_M(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$EeQ_luCgq8mPwc27wcvi5T62jvg/* $FF was: $r8$lambda$EeQ-luCgq8mPwc27wcvi5T62jvg*/(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$29(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$MSnd8Bi1ijRTxIhNNAxfckZulsU(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Ni2uTIC4bYlelBkjfK2YRI3UaQ0(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$45(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OFJ3704H5gfjtgkR0q4VQRq_FMo/* $FF was: $r8$lambda$OFJ3704H5gfjtgkR0q4VQRq-FMo*/(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$16(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OjObulhpHe_Ke9NaE7oJg2wmEz4(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$18(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$PIXuP_cjk589tGIan98H3gcdDMY/* $FF was: $r8$lambda$PIXuP-cjk589tGIan98H3gcdDMY*/(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$S0687zo65E3S8Ct33louw9KHdTs(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$47(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$WEaKkj9mGPvElHxCV_0fDS1Z22Y/* $FF was: $r8$lambda$WEaKkj9mGPvElHxCV-0fDS1Z22Y*/(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$41(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$WqThEcfIacNwKKIsHmf_JM8l_EU(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$43(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Yt4btWRb8zAQsmI9s2zTNoR_YNs(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$flIAJqI2zG2s407SDTCd1_iif6I/* $FF was: $r8$lambda$flIAJqI2zG2s407SDTCd1-iif6I*/(DeviceSettingsAdapter var0, RadioGroup var1, int var2) {
      onBindViewHolder$lambda$8(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ifHErDcJd7eTpLe_NQLqN2UaEFY(DeviceSettingsAdapter var0, RadioGroup var1, int var2) {
      onBindViewHolder$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pbyQoLuS_BKhvlCNQYRH26fvTcY(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pe8Qb2ObJUXVkacAEhsGm170sXs(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$35(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uH_8N4P7F0zcKVAxDUNTic5T0Is/* $FF was: $r8$lambda$uH-8N4P7F0zcKVAxDUNTic5T0Is*/(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$39(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uNsIbbqZgHP6_IEks62Ub6Nml2E(DeviceSettingsAdapter var0, View var1) {
      onBindViewHolder$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xHvHvK_HEs3FftwYpJ_0bP_8FWE/* $FF was: $r8$lambda$xHvHvK_HEs3FftwYpJ-0bP_8FWE*/(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$25(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zFCLfGAURK6pxzZcDfSlXYKS4ls(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      onBindViewHolder$lambda$23(var0, var1, var2);
   }

   public DeviceSettingsAdapter(PublishSubject var1, PublishSubject var2, PublishSubject var3, PublishSubject var4, PublishSubject var5, PublishSubject var6, PublishSubject var7, PublishSubject var8, PublishSubject var9, PublishSubject var10, PublishSubject var11, Function0 var12, Function0 var13) {
      Intrinsics.checkNotNullParameter(var1, "deviceInfoPublisher");
      Intrinsics.checkNotNullParameter(var2, "childLockPublisher");
      Intrinsics.checkNotNullParameter(var3, "standbyPublisher");
      Intrinsics.checkNotNullParameter(var4, "germShieldPublisher");
      Intrinsics.checkNotNullParameter(var5, "linkedPublisher");
      Intrinsics.checkNotNullParameter(var6, "deviceNameClickPublisher");
      Intrinsics.checkNotNullParameter(var7, "autoRefreshClickPublisher");
      Intrinsics.checkNotNullParameter(var8, "hourFormatClickPublisher");
      Intrinsics.checkNotNullParameter(var9, "displayModeClickPublisher");
      Intrinsics.checkNotNullParameter(var10, "timezoneClickPublisher");
      Intrinsics.checkNotNullParameter(var11, "eventPublisher");
      Intrinsics.checkNotNullParameter(var12, "triggerChangedListener");
      Intrinsics.checkNotNullParameter(var13, "errorReportListener");
      super();
      this.deviceInfoPublisher = var1;
      this.childLockPublisher = var2;
      this.standbyPublisher = var3;
      this.germShieldPublisher = var4;
      this.linkedPublisher = var5;
      this.deviceNameClickPublisher = var6;
      this.autoRefreshClickPublisher = var7;
      this.hourFormatClickPublisher = var8;
      this.displayModeClickPublisher = var9;
      this.timezoneClickPublisher = var10;
      this.eventPublisher = var11;
      this.triggerChangedListener = var12;
      this.errorReportListener = var13;
      this.settings = (List)(new ArrayList());
      this.excludeSettings = (Set)(new LinkedHashSet());
      this.awares = CollectionsKt.emptyList();
   }

   private final DeviceAware getLinkedDevice() {
      Iterator var5 = ((Iterable)this.awares).iterator();

      boolean var1;
      Object var3;
      do {
         if (!var5.hasNext()) {
            var3 = null;
            break;
         }

         var3 = var5.next();
         DeviceAware var6 = (DeviceAware)var3;
         Device var4 = this.device;
         boolean var2 = false;
         var1 = var2;
         if (var4 != null) {
            var1 = var2;
            if (var4 instanceof HasLinkingCapability) {
               var1 = Intrinsics.areEqual(var6.getUid(), ((HasLinkingCapability)var4).getLinkedToUid());
            }
         }
      } while(!var1);

      return (DeviceAware)var3;
   }

   private final Integer getSettingType(int var1) {
      return (Integer)DeviceSetting.Companion.getSettingsToViewType().get(this.settings.get(var1));
   }

   private static final void onBindViewHolder$lambda$10(DeviceSettingsAdapter var0, RadioGroup var1, int var2) {
      FilterTrigger var4;
      if (var2 == R.id.night_mode_pm_button) {
         var4 = FilterTrigger.Particles.INSTANCE;
      } else {
         var4 = FilterTrigger.ParticlesAndGases.INSTANCE;
      }

      Device var3 = var0.device;
      if (var3 != null && var3 instanceof HasG4NightMode) {
         if (!Intrinsics.areEqual(var4, ((HasG4NightMode)var3).getG4NightModeTrigger())) {
            var0.g4NightModeTriggerSelected = var4;
            var0.triggerChangedListener.invoke();
            return;
         }

         var0.g4NightModeTriggerSelected = null;
      }

   }

   private static final void onBindViewHolder$lambda$11(DeviceSettingsAdapter var0, View var1) {
      var0.deviceInfoPublisher.onNext(true);
   }

   private static final void onBindViewHolder$lambda$13(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.deviceNameClickPublisher.onNext(var2);
      }

   }

   private static final void onBindViewHolder$lambda$14(DeviceSettingsAdapter var0, View var1) {
      var0.errorReportListener.invoke();
   }

   private static final void onBindViewHolder$lambda$16(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var5 = var0.device;
      if (var5 != null && var5 instanceof HasChildLock && var2 != ((HasChildLock)var5).isChildLockOn()) {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("childlock nuValue = ");
         var3.append(var2);
         var4.d(var3.toString(), new Object[0]);
         var0.childLockPublisher.onNext(var5);
      }

   }

   private static final void onBindViewHolder$lambda$18(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var5 = var0.device;
      if (var5 != null && var5 instanceof HasStandBy && var2 != ((HasStandBy)var5).isStandByOn()) {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("standby nuValue = ");
         var3.append(var2);
         var4.d(var3.toString(), new Object[0]);
         var0.standbyPublisher.onNext(var5);
      }

   }

   private static final void onBindViewHolder$lambda$20(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var5 = var0.device;
      if (var5 != null && var5 instanceof HasGermShieldMode && var2 != ((HasGermShieldMode)var5).isGermShieldModeOn()) {
         Timber.Forest var4 = Timber.Forest;
         StringBuilder var3 = new StringBuilder("germshield nuValue = ");
         var3.append(var2);
         var4.d(var3.toString(), new Object[0]);
         var0.germShieldPublisher.onNext(var5);
      }

   }

   private static final void onBindViewHolder$lambda$21(DeviceSettingsAdapter var0, View var1) {
      var0.timezoneClickPublisher.onNext(Unit.INSTANCE);
   }

   private static final void onBindViewHolder$lambda$23(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.device;
      if (var3 != null) {
         var0.autoRefreshClickPublisher.onNext(var3);
      }

   }

   private static final void onBindViewHolder$lambda$25(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      if (var0.device != null) {
         var0.hourFormatClickPublisher.onNext(var2);
      }

   }

   private static final void onBindViewHolder$lambda$27(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      if (var0.device != null) {
         var0.displayModeClickPublisher.onNext(var2);
      }

   }

   private static final void onBindViewHolder$lambda$29(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_WELCOME_ENABLED_CHANGE", var2));
      }

   }

   private static final void onBindViewHolder$lambda$31(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_HOME_LOCATION_CLICK", var2));
      }

   }

   private static final void onBindViewHolder$lambda$33(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_TEMPERATURE_CLICK", var2));
      }

   }

   private static final void onBindViewHolder$lambda$35(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_DRYMODE_CLICK", var2));
      }

   }

   private static final void onBindViewHolder$lambda$37(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.device;
      if (var3 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_AUTODRY_CHECK", var3));
      }

   }

   private static final void onBindViewHolder$lambda$39(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.device;
      if (var3 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_AUTODRY_CHECK", var3));
      }

   }

   private static final void onBindViewHolder$lambda$41(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_USERMANUAL_CLICK", var2));
      }

   }

   private static final void onBindViewHolder$lambda$43(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.device;
      if (var3 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_REFRESHER_CHECK", var3));
      }

   }

   private static final void onBindViewHolder$lambda$45(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.device;
      if (var3 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_TVOC_CHECK", var3));
      }

   }

   private static final void onBindViewHolder$lambda$47(DeviceSettingsAdapter var0, CompoundButton var1, boolean var2) {
      Device var3 = var0.device;
      if (var3 != null) {
         var0.eventPublisher.onNext(new SimpleEvent("EVENT_GERMSHIELD_NIGHT_CHECK", var3));
      }

   }

   private static final void onBindViewHolder$lambda$5(DeviceSettingsAdapter var0, View var1) {
      Device var2 = var0.device;
      if (var2 != null) {
         var0.linkedPublisher.onNext(var2);
      }

   }

   private static final void onBindViewHolder$lambda$8(DeviceSettingsAdapter var0, RadioGroup var1, int var2) {
      FilterTrigger var4;
      if (var2 == R.id.auto_mode_pm_button) {
         var4 = FilterTrigger.Particles.INSTANCE;
      } else {
         var4 = FilterTrigger.ParticlesAndGases.INSTANCE;
      }

      Device var3 = var0.device;
      if (var3 != null && var3 instanceof HasFanSpeed) {
         if (!Intrinsics.areEqual(var4, ((HasFanSpeed)var3).getTrigger())) {
            var0.autoModeTriggerSelected = var4;
            var0.triggerChangedListener.invoke();
            return;
         }

         var0.autoModeTriggerSelected = null;
      }

   }

   public final void addExcluedeSetting(DeviceSetting var1) {
      Intrinsics.checkNotNullParameter(var1, "setting");
      this.excludeSettings.add(var1);
   }

   public final FilterTrigger getAutoModeTriggerSelected() {
      return this.autoModeTriggerSelected;
   }

   public final List getAwares() {
      return this.awares;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean getDeviceOffline() {
      return this.deviceOffline;
   }

   public final DeviceWelcomeHomeProvider getDeviceWelcomeHomeProvider() {
      return this.deviceWelcomeHomeProvider;
   }

   public final FilterTrigger getG4NightModeTriggerSelected() {
      return this.g4NightModeTriggerSelected;
   }

   public int getItemCount() {
      return this.device != null ? this.settings.size() : 0;
   }

   public int getItemViewType(int var1) {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("getItemViewType:  supported settings = ");
      var3.append(this.settings);
      var2.d(var3.toString(), new Object[0]);
      Integer var4 = this.getSettingType(var1);
      if (var4 != null) {
         return var4;
      } else {
         throw new Exception("viewType should not be null if itemcount > 0");
      }
   }

   public final void notifyItemChanged(DeviceSetting var1) {
      Intrinsics.checkNotNullParameter(var1, "setting");
      int var2 = this.settings.indexOf(var1);
      if (var2 >= 0) {
         this.notifyItemChanged(var2);
      }

   }

   public void onBindViewHolder(DeviceSettingHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Device var3 = this.device;
      if (var3 != null) {
         var1.update(var3);
      }

      if (var1 instanceof DeviceLinkedHolder) {
         DeviceLinkedHolder var4 = (DeviceLinkedHolder)var1;
         var4.update(this.getLinkedDevice());
         var4.getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda0(this));
      } else if (var1 instanceof DeviceAutoModeTriggersHolder) {
         var3 = this.device;
         if (var3 != null) {
            ((DeviceAutoModeTriggersHolder)var1).update(var3, this.autoModeTriggerSelected, this.g4NightModeTriggerSelected);
         }

         DeviceAutoModeTriggersHolder var6 = (DeviceAutoModeTriggersHolder)var1;
         var6.getAutoGroup().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda2(this));
         var6.getNightGroup().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda6(this));
      } else if (var1 instanceof DeviceProductInfoHolder) {
         ((DeviceProductInfoHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda7(this));
      } else if (var1 instanceof DeviceCustomNameHolder) {
         ((DeviceCustomNameHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda8(this));
      } else if (var1 instanceof DeviceErrorReportHolder) {
         ((DeviceErrorReportHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda9(this));
      } else if (var1 instanceof DeviceChildLockHolder) {
         ((DeviceChildLockHolder)var1).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda10(this));
      } else if (var1 instanceof DeviceSettingStandByModeHolder) {
         ((DeviceSettingStandByModeHolder)var1).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda12(this));
      } else if (var1 instanceof DeviceGermShieldHolder) {
         ((DeviceGermShieldHolder)var1).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda13(this));
      } else if (var1 instanceof DeviceTimezoneSettingsHolder) {
         ((DeviceTimezoneSettingsHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda14(this));
      } else if (var1 instanceof DeviceAutoRefreshEnabledHolder) {
         DeviceAutoRefreshEnabledHolder var7 = (DeviceAutoRefreshEnabledHolder)var1;
         var7.update(this.deviceOffline);
         var7.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda11(this));
      } else if (var1 instanceof DeviceHourFormatHolder) {
         DeviceHourFormatHolder var8 = (DeviceHourFormatHolder)var1;
         var8.update(this.deviceOffline);
         var8.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda15(this));
      } else if (var1 instanceof DeviceDisplayModeHolder) {
         DeviceDisplayModeHolder var9 = (DeviceDisplayModeHolder)var1;
         var9.update(this.deviceOffline);
         var9.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda16(this));
      } else if (var1 instanceof DeviceWelcomeHomeHolder) {
         DeviceWelcomeHomeHolder var10 = (DeviceWelcomeHomeHolder)var1;
         var10.getSettingSwitch().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda17(this));
         var10.getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda18(this));
      } else if (var1 instanceof DeviceTemperatureHolder) {
         ((DeviceTemperatureHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda19(this));
      } else if (var1 instanceof DeviceDryModeHolder) {
         ((DeviceDryModeHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda20(this));
      } else if (var1 instanceof DeviceWickDryEnabledHolder) {
         DeviceWickDryEnabledHolder var11 = (DeviceWickDryEnabledHolder)var1;
         var11.update(this.deviceOffline);
         var11.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda21(this));
      } else if (var1 instanceof DeviceAutoDryEnabledHolder) {
         DeviceAutoDryEnabledHolder var12 = (DeviceAutoDryEnabledHolder)var1;
         var12.update(this.deviceOffline);
         var12.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda22(this));
      } else if (var1 instanceof DeviceUserManualHolder) {
         ((DeviceUserManualHolder)var1).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda1(this));
      } else if (var1 instanceof DeviceRefresherEnabledHolder) {
         DeviceRefresherEnabledHolder var13 = (DeviceRefresherEnabledHolder)var1;
         var13.update(this.deviceOffline);
         var13.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda3(this));
      } else if (var1 instanceof DeviceTVOCSettingHolder) {
         DeviceTVOCSettingHolder var14 = (DeviceTVOCSettingHolder)var1;
         var14.update(this.deviceOffline);
         var14.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda4(this));
      } else if (var1 instanceof DeviceGermShieldNightSettingHolder) {
         ((DeviceGermShieldNightSettingHolder)var1).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda5(this));
      }

      if (var1.itemView instanceof ButtonTileConstraintLayout) {
         if (var2 == 0) {
            var1.itemView.setBackgroundResource(com.blueair.viewcore.R.drawable.button_focus_top_r16_bg);
            return;
         }

         if (var2 == this.getItemCount() - 1) {
            var1.itemView.setBackgroundResource(com.blueair.viewcore.R.drawable.button_focus_bottom_r16_bg);
            return;
         }

         var1.itemView.setBackgroundResource(com.blueair.viewcore.R.drawable.button_focus_bg);
      }

   }

   public DeviceSettingHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      DeviceSetting var3 = (DeviceSetting)DeviceSetting.Companion.getSETTINGS().get(var2);
      if (Intrinsics.areEqual(var3, DeviceSetting.CUSTOM_NAME.INSTANCE)) {
         return DeviceCustomNameHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.PRODUCT_INFO.INSTANCE)) {
         return DeviceProductInfoHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.ERROR_REPORT.INSTANCE)) {
         return DeviceErrorReportHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.STANDBY_MODE.INSTANCE)) {
         return DeviceSettingStandByModeHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.GERM_SHIELD_MODE.INSTANCE)) {
         return DeviceGermShieldHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.CHILD_LOCK_MODE.INSTANCE)) {
         return DeviceChildLockHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
         return DeviceAutoModeTriggersHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.LINKED_DEVICE.INSTANCE)) {
         return DeviceLinkedHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.TIMEZONE.INSTANCE)) {
         return DeviceTimezoneSettingsHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.AUTO_REFRESH.INSTANCE)) {
         return DeviceAutoRefreshEnabledHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.DISPLAY_MODE.INSTANCE)) {
         return DeviceDisplayModeHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.WELCOME_HOME.INSTANCE)) {
         return DeviceWelcomeHomeHolder.Companion.newInstance(var1, this.deviceWelcomeHomeProvider);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.DRY_MODE.INSTANCE)) {
         return DeviceAutoDryEnabledHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.TEMPERATURE.INSTANCE)) {
         return DeviceTemperatureHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.USER_MANUAL.INSTANCE)) {
         return DeviceUserManualHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.WICK_DRY.INSTANCE)) {
         return DeviceWickDryEnabledHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.WATER_REFRESHER.INSTANCE)) {
         return DeviceRefresherEnabledHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.HOUR_FORMAT.INSTANCE)) {
         return DeviceHourFormatHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.TVOC.INSTANCE)) {
         return DeviceTVOCSettingHolder.Companion.newInstance(var1);
      } else if (Intrinsics.areEqual(var3, DeviceSetting.GERM_SHIELD_IN_NIGHT_MODE.INSTANCE)) {
         return DeviceGermShieldNightSettingHolder.Companion.newInstance(var1);
      } else {
         throw new NoWhenBranchMatchedException();
      }
   }

   public final void setAwares(List var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.awares = var1;
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         List var4 = this.settings;
         this.settings = CollectionsKt.toMutableList((Collection)DeviceSetting.Companion.getSupportedSettings(this.device));
         if (!((Collection)this.excludeSettings).isEmpty()) {
            for(DeviceSetting var3 : (Iterable)this.excludeSettings) {
               this.settings.remove(var3);
            }
         }

         Timber.Forest var5 = Timber.Forest;
         StringBuilder var6 = new StringBuilder("settings.size: ");
         var6.append(this.settings.size());
         var5.d(var6.toString(), new Object[0]);
         if (!Intrinsics.areEqual(var4, this.settings)) {
            this.notifyDataSetChanged();
            return;
         }

         this.notifyItemRangeChanged(0, this.getItemCount());
      }

   }

   public final void setDeviceOffline(boolean var1) {
      if (this.deviceOffline != var1) {
         this.deviceOffline = var1;
         this.notifyItemChanged(DeviceSetting.HOUR_FORMAT.INSTANCE);
         this.notifyItemChanged(DeviceSetting.AUTO_REFRESH.INSTANCE);
         this.notifyItemChanged(DeviceSetting.DISPLAY_MODE.INSTANCE);
         this.notifyItemChanged(DeviceSetting.WATER_REFRESHER.INSTANCE);
         this.notifyItemChanged(DeviceSetting.WICK_DRY.INSTANCE);
      }
   }

   public final void setDeviceWelcomeHomeProvider(DeviceWelcomeHomeProvider var1) {
      this.deviceWelcomeHomeProvider = var1;
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter$Companion;", "", "<init>", "()V", "EVENT_WELCOME_ENABLED_CHANGE", "", "EVENT_HOME_LOCATION_CLICK", "EVENT_TEMPERATURE_CLICK", "EVENT_DRYMODE_CLICK", "EVENT_AUTODRY_CHECK", "EVENT_REFRESHER_CHECK", "EVENT_USERMANUAL_CLICK", "EVENT_TVOC_CHECK", "EVENT_GERMSHIELD_NIGHT_CHECK", "devicedetails_otherRelease"},
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
   }
}
