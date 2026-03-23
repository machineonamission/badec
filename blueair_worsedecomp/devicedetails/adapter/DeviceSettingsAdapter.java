package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.AnalyticEvent;
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
import com.blueair.viewcore.R;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001NBÉ\u0001\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004\u0012\u0018\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00120\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020@H\u0016J\u0018\u0010C\u001a\u00020\u00022\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020@H\u0016J\u0018\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u00022\u0006\u0010B\u001a\u00020@H\u0016J\u0017\u0010I\u001a\u0004\u0018\u00010@2\u0006\u0010B\u001a\u00020@H\u0002¢\u0006\u0002\u0010JJ\u000e\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u001bJ\u000e\u0010M\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004X\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00120\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001b0#X\u0004¢\u0006\u0002\n\u0000R(\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u0001008BX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0004\u0018\u0001092\b\u0010$\u001a\u0004\u0018\u000109@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\"\u0010=\u001a\u0004\u0018\u0001092\b\u0010$\u001a\u0004\u0018\u000109@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b>\u0010<¨\u0006O"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceSettingHolder;", "deviceInfoPublisher", "Lio/reactivex/subjects/PublishSubject;", "", "childLockPublisher", "Lcom/blueair/core/model/Device;", "standbyPublisher", "germShieldPublisher", "linkedPublisher", "deviceNameClickPublisher", "autoRefreshClickPublisher", "hourFormatClickPublisher", "displayModeClickPublisher", "timezoneClickPublisher", "", "eventPublisher", "Lcom/blueair/core/model/SimpleEvent;", "", "triggerChangedListener", "Lkotlin/Function0;", "errorReportListener", "<init>", "(Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lio/reactivex/subjects/PublishSubject;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "settings", "", "Lcom/blueair/devicedetails/util/DeviceSetting;", "deviceWelcomeHomeProvider", "Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "getDeviceWelcomeHomeProvider", "()Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;", "setDeviceWelcomeHomeProvider", "(Lcom/blueair/devicedetails/util/DeviceWelcomeHomeProvider;)V", "excludeSettings", "", "value", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "deviceOffline", "getDeviceOffline", "()Z", "setDeviceOffline", "(Z)V", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "getLinkedDevice", "()Lcom/blueair/core/model/DeviceAware;", "awares", "", "getAwares", "()Ljava/util/List;", "setAwares", "(Ljava/util/List;)V", "Lcom/blueair/core/model/FilterTrigger;", "autoModeTriggerSelected", "getAutoModeTriggerSelected", "()Lcom/blueair/core/model/FilterTrigger;", "g4NightModeTriggerSelected", "getG4NightModeTriggerSelected", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "getSettingType", "(I)Ljava/lang/Integer;", "notifyItemChanged", "setting", "addExcluedeSetting", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSettingsAdapter.kt */
public final class DeviceSettingsAdapter extends RecyclerView.Adapter<DeviceSettingHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_AUTODRY_CHECK = "EVENT_AUTODRY_CHECK";
    public static final String EVENT_DRYMODE_CLICK = "EVENT_DRYMODE_CLICK";
    public static final String EVENT_HOME_LOCATION_CLICK = "EVENT_HOME_LOCATION_CLICK";
    public static final String EVENT_REFRESHER_CHECK = "EVENT_REFRESHER_CHECK";
    public static final String EVENT_TEMPERATURE_CLICK = "EVENT_TEMPERATURE_CLICK";
    public static final String EVENT_TVOC_CHECK = "EVENT_TVOC_CHECK";
    public static final String EVENT_USERMANUAL_CLICK = "EVENT_USERMANUAL_CLICK";
    public static final String EVENT_WELCOME_ENABLED_CHANGE = "EVENT_WELCOME_ENABLED_CHANGE";
    private FilterTrigger autoModeTriggerSelected;
    private final PublishSubject<Device> autoRefreshClickPublisher;
    private List<DeviceAware> awares = CollectionsKt.emptyList();
    private final PublishSubject<Device> childLockPublisher;
    private Device device;
    private final PublishSubject<Boolean> deviceInfoPublisher;
    private final PublishSubject<Device> deviceNameClickPublisher;
    private boolean deviceOffline;
    private DeviceWelcomeHomeProvider deviceWelcomeHomeProvider;
    private final PublishSubject<Boolean> displayModeClickPublisher;
    private final Function0<Unit> errorReportListener;
    private final PublishSubject<SimpleEvent<String, Device>> eventPublisher;
    private final Set<DeviceSetting> excludeSettings = new LinkedHashSet();
    private FilterTrigger g4NightModeTriggerSelected;
    private final PublishSubject<Device> germShieldPublisher;
    private final PublishSubject<Boolean> hourFormatClickPublisher;
    private final PublishSubject<Device> linkedPublisher;
    private List<DeviceSetting> settings = new ArrayList();
    private final PublishSubject<Device> standbyPublisher;
    private final PublishSubject<Unit> timezoneClickPublisher;
    private final Function0<Unit> triggerChangedListener;

    public DeviceSettingsAdapter(PublishSubject<Boolean> publishSubject, PublishSubject<Device> publishSubject2, PublishSubject<Device> publishSubject3, PublishSubject<Device> publishSubject4, PublishSubject<Device> publishSubject5, PublishSubject<Device> publishSubject6, PublishSubject<Device> publishSubject7, PublishSubject<Boolean> publishSubject8, PublishSubject<Boolean> publishSubject9, PublishSubject<Unit> publishSubject10, PublishSubject<SimpleEvent<String, Device>> publishSubject11, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(publishSubject, "deviceInfoPublisher");
        Intrinsics.checkNotNullParameter(publishSubject2, "childLockPublisher");
        Intrinsics.checkNotNullParameter(publishSubject3, "standbyPublisher");
        Intrinsics.checkNotNullParameter(publishSubject4, "germShieldPublisher");
        Intrinsics.checkNotNullParameter(publishSubject5, "linkedPublisher");
        Intrinsics.checkNotNullParameter(publishSubject6, "deviceNameClickPublisher");
        Intrinsics.checkNotNullParameter(publishSubject7, "autoRefreshClickPublisher");
        Intrinsics.checkNotNullParameter(publishSubject8, "hourFormatClickPublisher");
        Intrinsics.checkNotNullParameter(publishSubject9, "displayModeClickPublisher");
        Intrinsics.checkNotNullParameter(publishSubject10, "timezoneClickPublisher");
        Intrinsics.checkNotNullParameter(publishSubject11, "eventPublisher");
        Intrinsics.checkNotNullParameter(function0, "triggerChangedListener");
        Intrinsics.checkNotNullParameter(function02, "errorReportListener");
        this.deviceInfoPublisher = publishSubject;
        this.childLockPublisher = publishSubject2;
        this.standbyPublisher = publishSubject3;
        this.germShieldPublisher = publishSubject4;
        this.linkedPublisher = publishSubject5;
        this.deviceNameClickPublisher = publishSubject6;
        this.autoRefreshClickPublisher = publishSubject7;
        this.hourFormatClickPublisher = publishSubject8;
        this.displayModeClickPublisher = publishSubject9;
        this.timezoneClickPublisher = publishSubject10;
        this.eventPublisher = publishSubject11;
        this.triggerChangedListener = function0;
        this.errorReportListener = function02;
    }

    public final DeviceWelcomeHomeProvider getDeviceWelcomeHomeProvider() {
        return this.deviceWelcomeHomeProvider;
    }

    public final void setDeviceWelcomeHomeProvider(DeviceWelcomeHomeProvider deviceWelcomeHomeProvider2) {
        this.deviceWelcomeHomeProvider = deviceWelcomeHomeProvider2;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device2) {
        if (!Intrinsics.areEqual((Object) this.device, (Object) device2)) {
            this.device = device2;
            List<DeviceSetting> list = this.settings;
            this.settings = CollectionsKt.toMutableList(DeviceSetting.Companion.getSupportedSettings(this.device));
            if (!this.excludeSettings.isEmpty()) {
                for (DeviceSetting remove : this.excludeSettings) {
                    this.settings.remove(remove);
                }
            }
            Timber.Forest forest = Timber.Forest;
            forest.d("settings.size: " + this.settings.size(), new Object[0]);
            if (!Intrinsics.areEqual((Object) list, (Object) this.settings)) {
                notifyDataSetChanged();
            } else {
                notifyItemRangeChanged(0, getItemCount());
            }
        }
    }

    public final boolean getDeviceOffline() {
        return this.deviceOffline;
    }

    public final void setDeviceOffline(boolean z) {
        if (this.deviceOffline != z) {
            this.deviceOffline = z;
            notifyItemChanged(DeviceSetting.HOUR_FORMAT.INSTANCE);
            notifyItemChanged(DeviceSetting.AUTO_REFRESH.INSTANCE);
            notifyItemChanged(DeviceSetting.DISPLAY_MODE.INSTANCE);
            notifyItemChanged(DeviceSetting.WATER_REFRESHER.INSTANCE);
            notifyItemChanged(DeviceSetting.WICK_DRY.INSTANCE);
        }
    }

    private final DeviceAware getLinkedDevice() {
        Object obj;
        Iterator it = this.awares.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            DeviceAware deviceAware = (DeviceAware) obj;
            Device device2 = this.device;
            boolean z = false;
            if (device2 != null && (device2 instanceof HasLinkingCapability)) {
                z = Intrinsics.areEqual((Object) deviceAware.getUid(), (Object) ((HasLinkingCapability) device2).getLinkedToUid());
                continue;
            }
            if (z) {
                break;
            }
        }
        return (DeviceAware) obj;
    }

    public final List<DeviceAware> getAwares() {
        return this.awares;
    }

    public final void setAwares(List<DeviceAware> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.awares = list;
    }

    public final FilterTrigger getAutoModeTriggerSelected() {
        return this.autoModeTriggerSelected;
    }

    public final FilterTrigger getG4NightModeTriggerSelected() {
        return this.g4NightModeTriggerSelected;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/devicedetails/adapter/DeviceSettingsAdapter$Companion;", "", "<init>", "()V", "EVENT_WELCOME_ENABLED_CHANGE", "", "EVENT_HOME_LOCATION_CLICK", "EVENT_TEMPERATURE_CLICK", "EVENT_DRYMODE_CLICK", "EVENT_AUTODRY_CHECK", "EVENT_REFRESHER_CHECK", "EVENT_USERMANUAL_CLICK", "EVENT_TVOC_CHECK", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceSettingsAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public int getItemCount() {
        if (this.device != null) {
            return this.settings.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        Timber.Forest forest = Timber.Forest;
        forest.d("getItemViewType:  supported settings = " + this.settings, new Object[0]);
        Integer settingType = getSettingType(i);
        if (settingType != null) {
            return settingType.intValue();
        }
        throw new Exception("viewType should not be null if itemcount > 0");
    }

    public DeviceSettingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        DeviceSetting deviceSetting = DeviceSetting.Companion.getSETTINGS().get(i);
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CUSTOM_NAME.INSTANCE)) {
            return DeviceCustomNameHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.PRODUCT_INFO.INSTANCE)) {
            return DeviceProductInfoHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.ERROR_REPORT.INSTANCE)) {
            return DeviceErrorReportHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.STANDBY_MODE.INSTANCE)) {
            return DeviceSettingStandByModeHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.GERM_SHIELD_MODE.INSTANCE)) {
            return DeviceGermShieldHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.CHILD_LOCK_MODE.INSTANCE)) {
            return DeviceChildLockHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_MODE_TRIGGERS.INSTANCE)) {
            return DeviceAutoModeTriggersHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.LINKED_DEVICE.INSTANCE)) {
            return DeviceLinkedHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.TIMEZONE.INSTANCE)) {
            return DeviceTimezoneSettingsHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.AUTO_REFRESH.INSTANCE)) {
            return DeviceAutoRefreshEnabledHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.DISPLAY_MODE.INSTANCE)) {
            return DeviceDisplayModeHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.WELCOME_HOME.INSTANCE)) {
            return DeviceWelcomeHomeHolder.Companion.newInstance(viewGroup, this.deviceWelcomeHomeProvider);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.DRY_MODE.INSTANCE)) {
            return DeviceAutoDryEnabledHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.TEMPERATURE.INSTANCE)) {
            return DeviceTemperatureHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.USER_MANUAL.INSTANCE)) {
            return DeviceUserManualHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.WICK_DRY.INSTANCE)) {
            return DeviceWickDryEnabledHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.WATER_REFRESHER.INSTANCE)) {
            return DeviceRefresherEnabledHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.HOUR_FORMAT.INSTANCE)) {
            return DeviceHourFormatHolder.Companion.newInstance(viewGroup);
        }
        if (Intrinsics.areEqual((Object) deviceSetting, (Object) DeviceSetting.TVOC.INSTANCE)) {
            return DeviceTVOCSettingHolder.Companion.newInstance(viewGroup);
        }
        throw new NoWhenBranchMatchedException();
    }

    public void onBindViewHolder(DeviceSettingHolder deviceSettingHolder, int i) {
        Intrinsics.checkNotNullParameter(deviceSettingHolder, "holder");
        Device device2 = this.device;
        if (device2 != null) {
            deviceSettingHolder.update(device2);
        }
        if (deviceSettingHolder instanceof DeviceLinkedHolder) {
            DeviceLinkedHolder deviceLinkedHolder = (DeviceLinkedHolder) deviceSettingHolder;
            deviceLinkedHolder.update(getLinkedDevice());
            deviceLinkedHolder.getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda0(this));
        } else if (deviceSettingHolder instanceof DeviceAutoModeTriggersHolder) {
            Device device3 = this.device;
            if (device3 != null) {
                ((DeviceAutoModeTriggersHolder) deviceSettingHolder).update(device3, this.autoModeTriggerSelected, this.g4NightModeTriggerSelected);
            }
            DeviceAutoModeTriggersHolder deviceAutoModeTriggersHolder = (DeviceAutoModeTriggersHolder) deviceSettingHolder;
            deviceAutoModeTriggersHolder.getAutoGroup().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda2(this));
            deviceAutoModeTriggersHolder.getNightGroup().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda5(this));
        } else if (deviceSettingHolder instanceof DeviceProductInfoHolder) {
            ((DeviceProductInfoHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda6(this));
        } else if (deviceSettingHolder instanceof DeviceCustomNameHolder) {
            ((DeviceCustomNameHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda7(this));
        } else if (deviceSettingHolder instanceof DeviceErrorReportHolder) {
            ((DeviceErrorReportHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda8(this));
        } else if (deviceSettingHolder instanceof DeviceChildLockHolder) {
            ((DeviceChildLockHolder) deviceSettingHolder).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda9(this));
        } else if (deviceSettingHolder instanceof DeviceSettingStandByModeHolder) {
            ((DeviceSettingStandByModeHolder) deviceSettingHolder).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda10(this));
        } else if (deviceSettingHolder instanceof DeviceGermShieldHolder) {
            ((DeviceGermShieldHolder) deviceSettingHolder).getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda12(this));
        } else if (deviceSettingHolder instanceof DeviceTimezoneSettingsHolder) {
            ((DeviceTimezoneSettingsHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda13(this));
        } else if (deviceSettingHolder instanceof DeviceAutoRefreshEnabledHolder) {
            DeviceAutoRefreshEnabledHolder deviceAutoRefreshEnabledHolder = (DeviceAutoRefreshEnabledHolder) deviceSettingHolder;
            deviceAutoRefreshEnabledHolder.update(this.deviceOffline);
            deviceAutoRefreshEnabledHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda11(this));
        } else if (deviceSettingHolder instanceof DeviceHourFormatHolder) {
            DeviceHourFormatHolder deviceHourFormatHolder = (DeviceHourFormatHolder) deviceSettingHolder;
            deviceHourFormatHolder.update(this.deviceOffline);
            deviceHourFormatHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda14(this));
        } else if (deviceSettingHolder instanceof DeviceDisplayModeHolder) {
            DeviceDisplayModeHolder deviceDisplayModeHolder = (DeviceDisplayModeHolder) deviceSettingHolder;
            deviceDisplayModeHolder.update(this.deviceOffline);
            deviceDisplayModeHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda15(this));
        } else if (deviceSettingHolder instanceof DeviceWelcomeHomeHolder) {
            DeviceWelcomeHomeHolder deviceWelcomeHomeHolder = (DeviceWelcomeHomeHolder) deviceSettingHolder;
            deviceWelcomeHomeHolder.getSettingSwitch().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda16(this));
            deviceWelcomeHomeHolder.getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda17(this));
        } else if (deviceSettingHolder instanceof DeviceTemperatureHolder) {
            ((DeviceTemperatureHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda18(this));
        } else if (deviceSettingHolder instanceof DeviceDryModeHolder) {
            ((DeviceDryModeHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda19(this));
        } else if (deviceSettingHolder instanceof DeviceWickDryEnabledHolder) {
            DeviceWickDryEnabledHolder deviceWickDryEnabledHolder = (DeviceWickDryEnabledHolder) deviceSettingHolder;
            deviceWickDryEnabledHolder.update(this.deviceOffline);
            deviceWickDryEnabledHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda20(this));
        } else if (deviceSettingHolder instanceof DeviceAutoDryEnabledHolder) {
            DeviceAutoDryEnabledHolder deviceAutoDryEnabledHolder = (DeviceAutoDryEnabledHolder) deviceSettingHolder;
            deviceAutoDryEnabledHolder.update(this.deviceOffline);
            deviceAutoDryEnabledHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda21(this));
        } else if (deviceSettingHolder instanceof DeviceUserManualHolder) {
            ((DeviceUserManualHolder) deviceSettingHolder).getClickView().setOnClickListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda1(this));
        } else if (deviceSettingHolder instanceof DeviceRefresherEnabledHolder) {
            DeviceRefresherEnabledHolder deviceRefresherEnabledHolder = (DeviceRefresherEnabledHolder) deviceSettingHolder;
            deviceRefresherEnabledHolder.update(this.deviceOffline);
            deviceRefresherEnabledHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda3(this));
        } else if (deviceSettingHolder instanceof DeviceTVOCSettingHolder) {
            DeviceTVOCSettingHolder deviceTVOCSettingHolder = (DeviceTVOCSettingHolder) deviceSettingHolder;
            deviceTVOCSettingHolder.update(this.deviceOffline);
            deviceTVOCSettingHolder.getSettingSwitch().setOnCheckedChangeListener(new DeviceSettingsAdapter$$ExternalSyntheticLambda4(this));
        }
        if (!(deviceSettingHolder.itemView instanceof ButtonTileConstraintLayout)) {
            return;
        }
        if (i == 0) {
            deviceSettingHolder.itemView.setBackgroundResource(R.drawable.button_focus_top_r16_bg);
        } else if (i == getItemCount() - 1) {
            deviceSettingHolder.itemView.setBackgroundResource(R.drawable.button_focus_bottom_r16_bg);
        } else {
            deviceSettingHolder.itemView.setBackgroundResource(R.drawable.button_focus_bg);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$5(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.linkedPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$8(DeviceSettingsAdapter deviceSettingsAdapter, RadioGroup radioGroup, int i) {
        FilterTrigger filterTrigger;
        if (i == com.blueair.devicedetails.R.id.auto_mode_pm_button) {
            filterTrigger = FilterTrigger.Particles.INSTANCE;
        } else {
            filterTrigger = FilterTrigger.ParticlesAndGases.INSTANCE;
        }
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null && (device2 instanceof HasFanSpeed)) {
            if (!Intrinsics.areEqual((Object) filterTrigger, (Object) ((HasFanSpeed) device2).getTrigger())) {
                deviceSettingsAdapter.autoModeTriggerSelected = filterTrigger;
                deviceSettingsAdapter.triggerChangedListener.invoke();
                return;
            }
            deviceSettingsAdapter.autoModeTriggerSelected = null;
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$10(DeviceSettingsAdapter deviceSettingsAdapter, RadioGroup radioGroup, int i) {
        FilterTrigger filterTrigger;
        if (i == com.blueair.devicedetails.R.id.night_mode_pm_button) {
            filterTrigger = FilterTrigger.Particles.INSTANCE;
        } else {
            filterTrigger = FilterTrigger.ParticlesAndGases.INSTANCE;
        }
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null && (device2 instanceof HasG4NightMode)) {
            if (!Intrinsics.areEqual((Object) filterTrigger, (Object) ((HasG4NightMode) device2).getG4NightModeTrigger())) {
                deviceSettingsAdapter.g4NightModeTriggerSelected = filterTrigger;
                deviceSettingsAdapter.triggerChangedListener.invoke();
                return;
            }
            deviceSettingsAdapter.g4NightModeTriggerSelected = null;
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$11(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        deviceSettingsAdapter.deviceInfoPublisher.onNext(true);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$13(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.deviceNameClickPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$14(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        deviceSettingsAdapter.errorReportListener.invoke();
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$16(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null && (device2 instanceof HasChildLock) && z != ((HasChildLock) device2).isChildLockOn()) {
            Timber.Forest forest = Timber.Forest;
            forest.d("childlock nuValue = " + z, new Object[0]);
            deviceSettingsAdapter.childLockPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$18(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null && (device2 instanceof HasStandBy) && z != ((HasStandBy) device2).isStandByOn()) {
            Timber.Forest forest = Timber.Forest;
            forest.d("standby nuValue = " + z, new Object[0]);
            deviceSettingsAdapter.standbyPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$20(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null && (device2 instanceof HasGermShieldMode) && z != ((HasGermShieldMode) device2).isGermShieldModeOn()) {
            Timber.Forest forest = Timber.Forest;
            forest.d("germshield nuValue = " + z, new Object[0]);
            deviceSettingsAdapter.germShieldPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$21(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        deviceSettingsAdapter.timezoneClickPublisher.onNext(Unit.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$23(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.autoRefreshClickPublisher.onNext(device2);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$25(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        if (deviceSettingsAdapter.device != null) {
            deviceSettingsAdapter.hourFormatClickPublisher.onNext(Boolean.valueOf(z));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$27(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        if (deviceSettingsAdapter.device != null) {
            deviceSettingsAdapter.displayModeClickPublisher.onNext(Boolean.valueOf(z));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$29(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_WELCOME_ENABLED_CHANGE, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$31(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_HOME_LOCATION_CLICK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$33(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_TEMPERATURE_CLICK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$35(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_DRYMODE_CLICK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$37(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_AUTODRY_CHECK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$39(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_AUTODRY_CHECK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$41(DeviceSettingsAdapter deviceSettingsAdapter, View view) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_USERMANUAL_CLICK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$43(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_REFRESHER_CHECK, device2));
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$45(DeviceSettingsAdapter deviceSettingsAdapter, CompoundButton compoundButton, boolean z) {
        Device device2 = deviceSettingsAdapter.device;
        if (device2 != null) {
            deviceSettingsAdapter.eventPublisher.onNext(new SimpleEvent(EVENT_TVOC_CHECK, device2));
        }
    }

    private final Integer getSettingType(int i) {
        return DeviceSetting.Companion.getSettingsToViewType().get(this.settings.get(i));
    }

    public final void notifyItemChanged(DeviceSetting deviceSetting) {
        Intrinsics.checkNotNullParameter(deviceSetting, AnalyticEvent.KEY_SETTING);
        int indexOf = this.settings.indexOf(deviceSetting);
        if (indexOf >= 0) {
            notifyItemChanged(indexOf);
        }
    }

    public final void addExcluedeSetting(DeviceSetting deviceSetting) {
        Intrinsics.checkNotNullParameter(deviceSetting, AnalyticEvent.KEY_SETTING);
        this.excludeSettings.add(deviceSetting);
    }
}
