package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.AqiHumLevel;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.NotificationMessage;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicedetails.activity.DeviceFilterDetailActivity;
import com.blueair.devicedetails.databinding.BottomSheetFilterOrderBinding;
import com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment;
import com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002J\u0006\u00100\u001a\u000201J\u0016\u00102\u001a\u0002012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J \u00107\u001a\u0002012\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:H\u0002J(\u0010;\u001a\u0002012\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:2\u0006\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020>H\u0002J(\u0010?\u001a\u0002012\u0006\u00108\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00132\u0006\u0010<\u001a\u00020,H\u0002J\u0016\u0010C\u001a\u0002012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0018\u0010D\u001a\u0002012\u0006\u00103\u001a\u0002042\b\b\u0002\u0010E\u001a\u00020,R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fRI\u0010\u0011\u001a:\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0012j\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006F"}, d2 = {"Lcom/blueair/android/viewmodel/NotificationsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "aqiHumLevelMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Lcom/blueair/core/model/AqiHumLevel;", "", "Lkotlin/collections/HashMap;", "getAqiHumLevelMap", "()Ljava/util/HashMap;", "notificationsNum", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getNotificationsNum", "()Landroidx/lifecycle/MutableLiveData;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "lvNotificationMsgs", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/NotificationMessage;", "getLvNotificationMsgs", "()Landroidx/lifecycle/LiveData;", "shouldReplace", "", "lastDevice", "Lcom/blueair/core/model/Device;", "newDevice", "dismissAll", "", "executeBuyFilterEvent", "item", "Lcom/blueair/android/adapter/NotificationItem;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "showFilterPurchaseOptionDialog", "device", "deviceFilter", "Lcom/blueair/core/model/FilterInfo;", "toPurchaseOrSubscribe", "purchase", "activityContext", "Landroid/content/Context;", "analyticsLogFilterClickEvent", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "executeReplaceFilterEvent", "dismissMsg", "withDelay", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationsViewModel.kt */
public final class NotificationsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private final HashMap<String, Pair<AqiHumLevel, Long>> aqiHumLevelMap = new HashMap<>();
    private final Lazy authService$delegate;
    private final Lazy locationService$delegate;
    private final MutableLiveData<Integer> notificationsNum = new MutableLiveData<>(0);
    private final Lazy prefs$delegate;

    static {
        Class<NotificationsViewModel> cls = NotificationsViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "app");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new NotificationsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new NotificationsViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new NotificationsViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    public final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public final HashMap<String, Pair<AqiHumLevel, Long>> getAqiHumLevelMap() {
        return this.aqiHumLevelMap;
    }

    public final MutableLiveData<Integer> getNotificationsNum() {
        return this.notificationsNum;
    }

    /* access modifiers changed from: private */
    public final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    public final LiveData<List<NotificationMessage>> getLvNotificationMsgs() {
        return FlowLiveDataConversions.asLiveData$default((Flow) FlowKt.distinctUntilChanged(FlowKt.flowCombine(getDeviceManager().getFlowNotifications(), getDeviceManager().getFlowDevices(), new NotificationsViewModel$lvNotificationMsgs$1(this, (Continuation<? super NotificationsViewModel$lvNotificationMsgs$1>) null))), getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean shouldReplace(Device device, Device device2) {
        if (!Intrinsics.areEqual((Object) device.getName(), (Object) device2.getName()) || !Intrinsics.areEqual((Object) DeviceKt.getSkuCompat(device), (Object) DeviceKt.getSkuCompat(device2))) {
            return true;
        }
        if (!(device instanceof HasRemoveYellowWater) || !(device2 instanceof HasRemoveYellowWater) || Intrinsics.areEqual((Object) ((HasRemoveYellowWater) device).getYwrmEnabled(), (Object) ((HasRemoveYellowWater) device2).getYwrmEnabled())) {
            return false;
        }
        return true;
    }

    public final void dismissAll() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new NotificationsViewModel$dismissAll$1(this, (Continuation<? super NotificationsViewModel$dismissAll$1>) null), 2, (Object) null);
    }

    public final void executeBuyFilterEvent(NotificationItem notificationItem, FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(notificationItem, "item");
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        List<FilterInfo> deviceFilters = notificationItem.getDeviceFilters();
        Device device = notificationItem.getMessage().getDevice();
        Collection collection = deviceFilters;
        if (collection != null && !collection.isEmpty()) {
            DeviceFilterType valueOf = DeviceFilterType.valueOf(notificationItem.getMessage().getSubType());
            if (DeviceKt.useV2UI(device)) {
                FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                Class<BuyFilterV2DialogFragment> cls = BuyFilterV2DialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
                if (!(supportFragmentManager.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !supportFragmentManager.isStateSaved()) {
                    BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, device, (String) null, valueOf, true, (String) null, 16, (Object) null).show(supportFragmentManager, "BuyFilterV2DialogFragment");
                }
            } else if (DeviceKt.useNewFilterConfig(device)) {
                FragmentManager supportFragmentManager2 = fragmentActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                Class<DeviceNFilterDialogFragment> cls2 = DeviceNFilterDialogFragment.class;
                Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
                if (!(supportFragmentManager2.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !supportFragmentManager2.isStateSaved()) {
                    DeviceNFilterDialogFragment.Companion.newInstance(device, (String) null, valueOf, true, true).show(supportFragmentManager2, "DeviceNFilterDialogFragment");
                }
            } else {
                FilterInfo filterInfo = (FilterInfo) CollectionsKt.first(deviceFilters);
                CharSequence ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkPurchase());
                boolean z = ipConfigValue == null || ipConfigValue.length() == 0;
                CharSequence ipConfigValue2 = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkSubscribe());
                boolean z2 = ipConfigValue2 == null || ipConfigValue2.length() == 0;
                if (!z && !z2) {
                    showFilterPurchaseOptionDialog(fragmentActivity, device, filterInfo);
                } else if (!z && z2) {
                    toPurchaseOrSubscribe(device, filterInfo, true, fragmentActivity);
                } else if (z && !z2) {
                    toPurchaseOrSubscribe(device, filterInfo, false, fragmentActivity);
                }
            }
        }
    }

    private final void showFilterPurchaseOptionDialog(FragmentActivity fragmentActivity, Device device, FilterInfo filterInfo) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(fragmentActivity, R.style.BottomSheetDialog);
        BottomSheetFilterOrderBinding inflate = BottomSheetFilterOrderBinding.inflate(fragmentActivity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        inflate.buttonFilterOneTimePurchase.setOnClickListener(new NotificationsViewModel$$ExternalSyntheticLambda0(this, device, filterInfo, bottomSheetDialog));
        inflate.buttonFilterSubscription.setOnClickListener(new NotificationsViewModel$$ExternalSyntheticLambda1(this, device, filterInfo, bottomSheetDialog));
        inflate.btnCancel.setOnClickListener(new NotificationsViewModel$$ExternalSyntheticLambda2(bottomSheetDialog));
        bottomSheetDialog.setContentView((View) inflate.getRoot());
        bottomSheetDialog.show();
    }

    /* access modifiers changed from: private */
    public static final void showFilterPurchaseOptionDialog$lambda$2(NotificationsViewModel notificationsViewModel, Device device, FilterInfo filterInfo, BottomSheetDialog bottomSheetDialog, View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        notificationsViewModel.toPurchaseOrSubscribe(device, filterInfo, true, context);
        bottomSheetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showFilterPurchaseOptionDialog$lambda$3(NotificationsViewModel notificationsViewModel, Device device, FilterInfo filterInfo, BottomSheetDialog bottomSheetDialog, View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        notificationsViewModel.toPurchaseOrSubscribe(device, filterInfo, false, context);
        bottomSheetDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showFilterPurchaseOptionDialog$lambda$4(BottomSheetDialog bottomSheetDialog, View view) {
        bottomSheetDialog.dismiss();
    }

    private final void toPurchaseOrSubscribe(Device device, FilterInfo filterInfo, boolean z, Context context) {
        int i;
        String str;
        if (filterInfo.getType() == DeviceFilterType.FILTER) {
            i = R.string.order_filter;
        } else {
            i = R.string.order_wick;
        }
        String string = context.getString(i);
        Intrinsics.checkNotNull(string);
        DeviceFilterType type = filterInfo.getType();
        String value$default = I18nConfig.getValue$default(filterInfo.getName(), (Locale) null, 1, (Object) null);
        if (value$default == null) {
            value$default = "";
        }
        analyticsLogFilterClickEvent(device, type, value$default, z);
        if (z) {
            str = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkPurchase());
        } else {
            str = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkSubscribe());
        }
        if (str != null) {
            DeviceConfigProvider.INSTANCE.openFilterUrl(context, str, string);
        }
    }

    private final void analyticsLogFilterClickEvent(Device device, DeviceFilterType deviceFilterType, String str, boolean z) {
        AnalyticEvent.FilterClickEvent filterClickEvent;
        if (z) {
            DeviceFilterType deviceFilterType2 = deviceFilterType;
            String str2 = str;
            filterClickEvent = new AnalyticEvent.FilterClickEvent.HomepageFilterClickPurchase(System.currentTimeMillis(), deviceFilterType2, str2, device, getAuthService().getUserIdForBlueCloud(), getAuthService().getCloudUserRegion());
        } else {
            String str3 = str;
            long currentTimeMillis = System.currentTimeMillis();
            filterClickEvent = new AnalyticEvent.FilterClickEvent.HomepageFilterClickSubscribe(currentTimeMillis, deviceFilterType, str3, device, getAuthService().getUserIdForBlueCloud(), getAuthService().getCloudUserRegion());
        }
        getAnalyticsService().event(filterClickEvent);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new NotificationsViewModel$analyticsLogFilterClickEvent$1(this, filterClickEvent, (Continuation<? super NotificationsViewModel$analyticsLogFilterClickEvent$1>) null), 2, (Object) null);
    }

    public final void executeReplaceFilterEvent(NotificationItem notificationItem, FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(notificationItem, "item");
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        Device device = notificationItem.getMessage().getDevice();
        DeviceFilterType valueOf = DeviceFilterType.valueOf(notificationItem.getMessage().getSubType());
        if (DeviceKt.useV2UI(device)) {
            Device device2 = device;
            DeviceFilterDetailActivity.Companion.launch(fragmentActivity, device2, (String) null, valueOf, true);
            return;
        }
        DeviceFilterType deviceFilterType = valueOf;
        DialogFragment dialogFragment = null;
        if (DeviceKt.useNewFilterConfig(device)) {
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            Class<DeviceNFilterDialogFragment> cls = DeviceNFilterDialogFragment.class;
            Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
            if (!(supportFragmentManager.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !supportFragmentManager.isStateSaved()) {
                dialogFragment = DeviceNFilterDialogFragment.Companion.newInstance(device, (String) null, deviceFilterType, false, true);
                dialogFragment.show(supportFragmentManager, "DeviceNFilterDialogFragment");
            }
            BaseDialogFragment baseDialogFragment = (BaseDialogFragment) dialogFragment;
            return;
        }
        FragmentManager supportFragmentManager2 = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
        Class<DeviceFilterPageDialogFragment> cls2 = DeviceFilterPageDialogFragment.class;
        Intrinsics.checkNotNullExpressionValue("DeviceFilterPageDialogFragment", "getSimpleName(...)");
        if (!(supportFragmentManager2.findFragmentByTag("DeviceFilterPageDialogFragment") instanceof DeviceFilterPageDialogFragment) && !supportFragmentManager2.isStateSaved()) {
            dialogFragment = DeviceFilterPageDialogFragment.Companion.newInstance(device, true);
            dialogFragment.show(supportFragmentManager2, "DeviceFilterPageDialogFragment");
        }
        BaseDialogFragment baseDialogFragment2 = (BaseDialogFragment) dialogFragment;
    }

    public static /* synthetic */ void dismissMsg$default(NotificationsViewModel notificationsViewModel, NotificationItem notificationItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        notificationsViewModel.dismissMsg(notificationItem, z);
    }

    public final void dismissMsg(NotificationItem notificationItem, boolean z) {
        Intrinsics.checkNotNullParameter(notificationItem, "item");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new NotificationsViewModel$dismissMsg$1(z, this, notificationItem, (Continuation<? super NotificationsViewModel$dismissMsg$1>) null), 2, (Object) null);
    }
}
