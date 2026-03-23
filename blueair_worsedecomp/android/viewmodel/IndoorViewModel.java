package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.gigya.android.sdk.GigyaDefinitions;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020&J&\u0010I\u001a\u00020G2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MJ8\u0010N\u001a\u00020G2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020:0,2\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010Q2\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010QJ\u000e\u0010S\u001a\u00020&H@¢\u0006\u0002\u0010TJ\u0006\u0010U\u001a\u00020&J\u0016\u0010V\u001a\u00020G2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ\u0016\u0010[\u001a\u00020G2\u0006\u0010W\u001a\u00020\\2\u0006\u0010]\u001a\u00020^J\u0016\u0010_\u001a\u00020G2\u0006\u0010W\u001a\u00020`2\u0006\u0010]\u001a\u00020aJ\u000e\u0010b\u001a\u00020G2\u0006\u0010W\u001a\u00020:J\u000e\u0010c\u001a\u00020G2\u0006\u0010W\u001a\u00020:J\u0006\u0010d\u001a\u00020&J\u0006\u0010e\u001a\u00020&J\u0006\u0010f\u001a\u00020&J\u0006\u0010g\u001a\u00020GJ\u0006\u0010h\u001a\u00020&R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b%\u0010'R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0+8F¢\u0006\u0006\u001a\u0004\b.\u0010/R+\u00101\u001a\u00020&2\u0006\u00100\u001a\u00020&8F@FX\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b2\u0010'\"\u0004\b3\u00104R+\u00107\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020:\u0012\u0006\u0012\u0004\u0018\u00010;090,088F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020:0,8BX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020&0+X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020&088F¢\u0006\u0006\u001a\u0004\bC\u0010=R\u001d\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0,08¢\u0006\b\n\u0000\u001a\u0004\bE\u0010=R\u0011\u0010i\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bi\u0010'¨\u0006j"}, d2 = {"Lcom/blueair/android/viewmodel/IndoorViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "getPrefs", "()Lio/flatcircle/preferenceshelper2/Prefs;", "prefs$delegate", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "getWelcomeHomeService", "()Lcom/blueair/devicemanager/WelcomeHomeService;", "welcomeHomeService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "isUserLoggedIn", "", "()Z", "isLoading", "Landroidx/databinding/ObservableBoolean;", "nullTimezoneDeviceIdList", "Landroidx/lifecycle/MutableLiveData;", "", "", "getNullTimezoneDeviceIdList", "()Landroidx/lifecycle/MutableLiveData;", "<set-?>", "hasConfirmedDstPromptDialog", "getHasConfirmedDstPromptDialog", "setHasConfirmedDstPromptDialog", "(Z)V", "hasConfirmedDstPromptDialog$delegate", "Lkotlin/properties/ReadWriteProperty;", "liveDevicesWithLatestDataPoint", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/IndoorDatapoint;", "getLiveDevicesWithLatestDataPoint", "()Landroidx/lifecycle/LiveData;", "observedLiveDevices", "getObservedLiveDevices", "()Ljava/util/List;", "_networkAvailable", "networkAvailable", "getNetworkAvailable", "liveDevices", "getLiveDevices", "refreshDeviceList", "", "force", "ensureDeviceTimezone", "timezone", "Ljava/util/TimeZone;", "context", "Landroid/content/Context;", "runWhAndRateUsLogic", "devices", "onShouldShowRateUs", "Lkotlin/Function0;", "onShouldShowWHExplore", "shouldShowWhExplore", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containsIcpDevice", "autoModeChanged", "device", "Lcom/blueair/core/model/HasFanSpeed;", "currentMode", "Lcom/blueair/core/model/AutoMode;", "setMainMode", "Lcom/blueair/core/model/HasCombo3in1MainMode;", "mode", "Lcom/blueair/core/model/MainMode;", "setToMode", "Lcom/blueair/core/model/HasMode;", "Lcom/blueair/core/model/Mode;", "standByChanged", "g4NightModeChanged", "shouldShowRateUsT2", "shouldShowRateUsT3", "shouldShowInAppReview", "setWelcomeHomeAsShowed", "isWelcomeHomeAvailable", "isInChina", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorViewModel.kt */
public final class IndoorViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _networkAvailable;
    private final Lazy authService$delegate;
    private final Lazy happyUserService$delegate;
    private final ReadWriteProperty hasConfirmedDstPromptDialog$delegate;
    private final boolean isInChina;
    /* access modifiers changed from: private */
    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    private final LiveData<List<Device>> liveDevices;
    private final Lazy locationService$delegate;
    private final Lazy networkMonitor$delegate;
    private final Lazy prefs$delegate;
    private final Lazy welcomeHomeService$delegate;

    static {
        Class<IndoorViewModel> cls = IndoorViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lio/flatcircle/preferenceshelper2/Prefs;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "welcomeHomeService", "getWelcomeHomeService()Lcom/blueair/devicemanager/WelcomeHomeService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "hasConfirmedDstPromptDialog", "getHasConfirmedDstPromptDialog()Z", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IndoorViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new IndoorViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new IndoorViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new IndoorViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.networkMonitor$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, NetworkMonitor.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new IndoorViewModel$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.happyUserService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, HappyUserService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new IndoorViewModel$special$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.welcomeHomeService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, WelcomeHomeService.class), (Object) null).provideDelegate(this, kPropertyArr[4]);
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new IndoorViewModel$special$$inlined$instance$default$6().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken6, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[5]);
        Prefs prefs = getPrefs();
        this.hasConfirmedDstPromptDialog$delegate = new IndoorViewModel$special$$inlined$ObservablePreference$1(prefs, PrefKeys.hasConfirmedDstPromptDialog, false, PreferencesHelper.INSTANCE.get(prefs.getBackend(), PrefKeys.hasConfirmedDstPromptDialog, false, Reflection.getOrCreateKotlinClass(Boolean.class)));
        this._networkAvailable = new MutableLiveData<>();
        this.liveDevices = FlowLiveDataConversions.asLiveData$default((Flow) getDeviceManager().getFlowDevices(), getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        this.isInChina = getLocationService().isInChina();
    }

    /* access modifiers changed from: private */
    public final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Prefs getPrefs() {
        return (Prefs) this.prefs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NetworkMonitor getNetworkMonitor() {
        return (NetworkMonitor) this.networkMonitor$delegate.getValue();
    }

    private final HappyUserService getHappyUserService() {
        return (HappyUserService) this.happyUserService$delegate.getValue();
    }

    private final WelcomeHomeService getWelcomeHomeService() {
        return (WelcomeHomeService) this.welcomeHomeService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    public final boolean isUserLoggedIn() {
        return getAuthService().isUserLoggedIn().getValue().booleanValue();
    }

    public final MutableLiveData<List<String>> getNullTimezoneDeviceIdList() {
        return getDeviceManager().getNullTimezoneDeviceIdList();
    }

    public final boolean getHasConfirmedDstPromptDialog() {
        return ((Boolean) this.hasConfirmedDstPromptDialog$delegate.getValue(this, $$delegatedProperties[6])).booleanValue();
    }

    public final void setHasConfirmedDstPromptDialog(boolean z) {
        this.hasConfirmedDstPromptDialog$delegate.setValue(this, $$delegatedProperties[6], Boolean.valueOf(z));
    }

    public final LiveData<List<Pair<Device, IndoorDatapoint>>> getLiveDevicesWithLatestDataPoint() {
        return FlowLiveDataConversions.asLiveData$default((Flow) FlowKt.flowCombine(getDeviceManager().getFlowDevices(), getDeviceManager().getFlowLatestDevicesDatapoints(), new IndoorViewModel$liveDevicesWithLatestDataPoint$1(this, (Continuation<? super IndoorViewModel$liveDevicesWithLatestDataPoint$1>) null)), getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    private final List<Device> getObservedLiveDevices() {
        List value = getLiveDevicesWithLatestDataPoint().getValue();
        if (value == null) {
            return CollectionsKt.emptyList();
        }
        Iterable<Pair> iterable = value;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Pair first : iterable) {
            arrayList.add((Device) first.getFirst());
        }
        return (List) arrayList;
    }

    public final LiveData<Boolean> getNetworkAvailable() {
        return this._networkAvailable;
    }

    public final LiveData<List<Device>> getLiveDevices() {
        return this.liveDevices;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.android.viewmodel.IndoorViewModel$1", f = "IndoorViewModel.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.android.viewmodel.IndoorViewModel$1  reason: invalid class name */
    /* compiled from: IndoorViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ IndoorViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> connectivityStatus = this.this$0.getNetworkMonitor().getConnectivityStatus();
                final IndoorViewModel indoorViewModel = this.this$0;
                this.label = 1;
                if (connectivityStatus.collect(new FlowCollector() {
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        indoorViewModel._networkAvailable.postValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void refreshDeviceList$default(IndoorViewModel indoorViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        indoorViewModel.refreshDeviceList(z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x002f, code lost:
        r0 = r6.liveDevices.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void refreshDeviceList(boolean r7) {
        /*
            r6 = this;
            io.flatcircle.preferenceshelper2.Prefs r0 = r6.getPrefs()
            r1 = 0
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            io.flatcircle.preferenceshelper2.PreferencesHelper r2 = io.flatcircle.preferenceshelper2.PreferencesHelper.INSTANCE
            io.flatcircle.preferenceshelper2.PrefsBackend r0 = r0.getBackend()
            java.lang.Class<java.lang.Long> r3 = java.lang.Long.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.String r4 = "last_refresh_time"
            java.lang.Object r0 = r2.get(r0, r4, r1, r3)
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r0
            r0 = 300000(0x493e0, double:1.482197E-318)
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r1 = 0
            if (r0 > 0) goto L_0x0042
            androidx.lifecycle.LiveData<java.util.List<com.blueair.core.model.Device>> r0 = r6.liveDevices
            java.lang.Object r0 = r0.getValue()
            java.util.Collection r0 = (java.util.Collection) r0
            if (r0 == 0) goto L_0x0042
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r0 = r1
            goto L_0x0043
        L_0x0042:
            r0 = 1
        L_0x0043:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "refreshDeviceList: shouldRefresh = "
            r3.<init>(r4)
            r3.append(r0)
            java.lang.String r4 = ", force = "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2.d(r3, r1)
            if (r0 != 0) goto L_0x0064
            if (r7 == 0) goto L_0x0078
        L_0x0064:
            com.blueair.auth.AuthService r7 = r6.getAuthService()
            kotlinx.coroutines.flow.StateFlow r7 = r7.isUserLoggedIn()
            java.lang.Object r7 = r7.getValue()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0079
        L_0x0078:
            return
        L_0x0079:
            r0 = r6
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
            r1 = r7
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.blueair.android.viewmodel.IndoorViewModel$refreshDeviceList$1 r7 = new com.blueair.android.viewmodel.IndoorViewModel$refreshDeviceList$1
            r2 = 0
            r7.<init>(r6, r2)
            r3 = r7
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 2
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r0, r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.IndoorViewModel.refreshDeviceList(boolean):void");
    }

    public final void ensureDeviceTimezone(List<String> list, TimeZone timeZone, Context context) {
        Intrinsics.checkNotNullParameter(list, "nullTimezoneDeviceIdList");
        Intrinsics.checkNotNullParameter(timeZone, GigyaDefinitions.AccountProfileExtraFields.TIMEZONE);
        Timber.Forest forest = Timber.Forest;
        forest.d("set device timezone for " + list, new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new IndoorViewModel$ensureDeviceTimezone$1(this, list, timeZone, context, (Continuation<? super IndoorViewModel$ensureDeviceTimezone$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ void runWhAndRateUsLogic$default(IndoorViewModel indoorViewModel, List list, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        if ((i & 4) != 0) {
            function02 = null;
        }
        indoorViewModel.runWhAndRateUsLogic(list, function0, function02);
    }

    public final void runWhAndRateUsLogic(List<? extends Device> list, Function0<Unit> function0, Function0<Unit> function02) {
        Boolean calculateHappyPoint;
        Intrinsics.checkNotNullParameter(list, "devices");
        if (getHappyUserService().getShouldShowDev()) {
            getHappyUserService().setShouldShowDev(false);
            if (function0 != null) {
                function0.invoke();
            }
        } else if (!getHappyUserService().isRateUsShown() && (calculateHappyPoint = getDeviceManager().calculateHappyPoint(list)) != null) {
            getHappyUserService().incrementPoints(calculateHappyPoint.booleanValue());
            if (getHappyUserService().shouldShowRateUsDialogT1() && function0 != null) {
                function0.invoke();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object shouldShowWhExplore(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$1 r0 = (com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$1 r0 = new com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004c
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$devices$1 r2 = new com.blueair.android.viewmodel.IndoorViewModel$shouldShowWhExplore$devices$1
            r4 = 0
            r2.<init>(r5, r4)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            java.util.List r6 = (java.util.List) r6
            com.blueair.devicemanager.WelcomeHomeService r0 = r5.getWelcomeHomeService()
            boolean r6 = r0.shouldShowWHExplore(r6)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewmodel.IndoorViewModel.shouldShowWhExplore(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean containsIcpDevice() {
        for (Device device : getObservedLiveDevices()) {
            if (device instanceof DeviceIcp) {
                return true;
            }
        }
        return false;
    }

    public final void autoModeChanged(HasFanSpeed hasFanSpeed, AutoMode autoMode) {
        Intrinsics.checkNotNullParameter(hasFanSpeed, "device");
        Intrinsics.checkNotNullParameter(autoMode, "currentMode");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new IndoorViewModel$autoModeChanged$1(this, hasFanSpeed, autoMode, (Continuation<? super IndoorViewModel$autoModeChanged$1>) null), 2, (Object) null);
    }

    public final void setMainMode(HasCombo3in1MainMode hasCombo3in1MainMode, MainMode mainMode) {
        Intrinsics.checkNotNullParameter(hasCombo3in1MainMode, "device");
        Intrinsics.checkNotNullParameter(mainMode, "mode");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new IndoorViewModel$setMainMode$1(this, hasCombo3in1MainMode, mainMode, (Continuation<? super IndoorViewModel$setMainMode$1>) null), 2, (Object) null);
    }

    public final void setToMode(HasMode hasMode, Mode mode) {
        Intrinsics.checkNotNullParameter(hasMode, "device");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new IndoorViewModel$setToMode$1(this, hasMode, mode, (Continuation<? super IndoorViewModel$setToMode$1>) null), 2, (Object) null);
    }

    public final void standByChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new IndoorViewModel$standByChanged$1(device, this, (Continuation<? super IndoorViewModel$standByChanged$1>) null), 2, (Object) null);
    }

    public final void g4NightModeChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new IndoorViewModel$g4NightModeChanged$1(device, this, (Continuation<? super IndoorViewModel$g4NightModeChanged$1>) null), 2, (Object) null);
    }

    public final boolean shouldShowRateUsT2() {
        return getHappyUserService().shouldShowRateUsDialogT2();
    }

    public final boolean shouldShowRateUsT3() {
        return getHappyUserService().shouldShowRateUsDialogT3();
    }

    public final boolean shouldShowInAppReview() {
        return getHappyUserService().shouldShowNativeInAppReview();
    }

    public final void setWelcomeHomeAsShowed() {
        getWelcomeHomeService().setWelcomeHomeAsShowed();
    }

    public final boolean isWelcomeHomeAvailable() {
        return getWelcomeHomeService().getCountryAvailable();
    }

    public final boolean isInChina() {
        return this.isInChina;
    }
}
