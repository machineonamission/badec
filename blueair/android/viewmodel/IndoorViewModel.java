package com.blueair.android.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.WelcomeHomeService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020&J&\u0010I\u001a\u00020G2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MJ8\u0010N\u001a\u00020G2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020:0,2\u0010\b\u0002\u0010P\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010Q2\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010QJ\u000e\u0010S\u001a\u00020&H\u0086@¢\u0006\u0002\u0010TJ\u0006\u0010U\u001a\u00020&J\u0016\u0010V\u001a\u00020G2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ\u0016\u0010[\u001a\u00020G2\u0006\u0010W\u001a\u00020\\2\u0006\u0010]\u001a\u00020^J\u0016\u0010_\u001a\u00020G2\u0006\u0010W\u001a\u00020`2\u0006\u0010]\u001a\u00020aJ\u000e\u0010b\u001a\u00020G2\u0006\u0010W\u001a\u00020:J\u000e\u0010c\u001a\u00020G2\u0006\u0010W\u001a\u00020:J\u0006\u0010d\u001a\u00020&J\u0006\u0010e\u001a\u00020&J\u0006\u0010f\u001a\u00020&J\u0006\u0010g\u001a\u00020GJ\u0006\u0010h\u001a\u00020&R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b%\u0010'R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0+8F¢\u0006\u0006\u001a\u0004\b.\u0010/R+\u00101\u001a\u00020&2\u0006\u00100\u001a\u00020&8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b2\u0010'\"\u0004\b3\u00104R+\u00107\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020:\u0012\u0006\u0012\u0004\u0018\u00010;090,088F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020:0,8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0014\u0010A\u001a\b\u0012\u0004\u0012\u00020&0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020&088F¢\u0006\u0006\u001a\u0004\bC\u0010=R\u001d\u0010D\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0,08¢\u0006\b\n\u0000\u001a\u0004\bE\u0010=R\u0011\u0010i\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\bi\u0010'¨\u0006j"},
   d2 = {"Lcom/blueair/android/viewmodel/IndoorViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "prefs", "Lio/flatcircle/preferenceshelper2/Prefs;", "getPrefs", "()Lio/flatcircle/preferenceshelper2/Prefs;", "prefs$delegate", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "welcomeHomeService", "Lcom/blueair/devicemanager/WelcomeHomeService;", "getWelcomeHomeService", "()Lcom/blueair/devicemanager/WelcomeHomeService;", "welcomeHomeService$delegate", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "isUserLoggedIn", "", "()Z", "isLoading", "Landroidx/databinding/ObservableBoolean;", "nullTimezoneDeviceIdList", "Landroidx/lifecycle/MutableLiveData;", "", "", "getNullTimezoneDeviceIdList", "()Landroidx/lifecycle/MutableLiveData;", "<set-?>", "hasConfirmedDstPromptDialog", "getHasConfirmedDstPromptDialog", "setHasConfirmedDstPromptDialog", "(Z)V", "hasConfirmedDstPromptDialog$delegate", "Lkotlin/properties/ReadWriteProperty;", "liveDevicesWithLatestDataPoint", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "Lcom/blueair/core/model/Device;", "Lcom/blueair/core/model/IndoorDatapoint;", "getLiveDevicesWithLatestDataPoint", "()Landroidx/lifecycle/LiveData;", "observedLiveDevices", "getObservedLiveDevices", "()Ljava/util/List;", "_networkAvailable", "networkAvailable", "getNetworkAvailable", "liveDevices", "getLiveDevices", "refreshDeviceList", "", "force", "ensureDeviceTimezone", "timezone", "Ljava/util/TimeZone;", "context", "Landroid/content/Context;", "runWhAndRateUsLogic", "devices", "onShouldShowRateUs", "Lkotlin/Function0;", "onShouldShowWHExplore", "shouldShowWhExplore", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containsIcpDevice", "autoModeChanged", "device", "Lcom/blueair/core/model/HasFanSpeed;", "currentMode", "Lcom/blueair/core/model/AutoMode;", "setMainMode", "Lcom/blueair/core/model/HasCombo3in1MainMode;", "mode", "Lcom/blueair/core/model/MainMode;", "setToMode", "Lcom/blueair/core/model/HasMode;", "Lcom/blueair/core/model/Mode;", "standByChanged", "g4NightModeChanged", "shouldShowRateUsT2", "shouldShowRateUsT3", "shouldShowInAppReview", "setWelcomeHomeAsShowed", "isWelcomeHomeAvailable", "isInChina", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IndoorViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorViewModel.class, "prefs", "getPrefs()Lio/flatcircle/preferenceshelper2/Prefs;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorViewModel.class, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorViewModel.class, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorViewModel.class, "welcomeHomeService", "getWelcomeHomeService()Lcom/blueair/devicemanager/WelcomeHomeService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(IndoorViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(IndoorViewModel.class, "hasConfirmedDstPromptDialog", "getHasConfirmedDstPromptDialog()Z", 0)))};
   public static final int $stable = 8;
   private final MutableLiveData _networkAvailable;
   private final Lazy authService$delegate;
   private final Lazy happyUserService$delegate;
   private final ReadWriteProperty hasConfirmedDstPromptDialog$delegate;
   private final boolean isInChina;
   private final ObservableBoolean isLoading;
   private final LiveData liveDevices;
   private final Lazy locationService$delegate;
   private final Lazy networkMonitor$delegate;
   private final Lazy prefs$delegate;
   private final Lazy welcomeHomeService$delegate;

   public IndoorViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null);
      KProperty[] var6 = $$delegatedProperties;
      this.authService$delegate = var3.provideDelegate(this, var6[0]);
      JVMTypeToken var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var6[1]);
      var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.networkMonitor$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, NetworkMonitor.class)), (Object)null).provideDelegate(this, var6[2]);
      var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.happyUserService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, HappyUserService.class)), (Object)null).provideDelegate(this, var6[3]);
      var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.welcomeHomeService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, WelcomeHomeService.class)), (Object)null).provideDelegate(this, var6[4]);
      var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, LocationService.class)), (Object)null).provideDelegate(this, var6[5]);
      this.isLoading = new ObservableBoolean(false);
      Prefs var7 = this.getPrefs();
      Boolean var5 = false;
      this.hasConfirmedDstPromptDialog$delegate = (ReadWriteProperty)(new ObservableProperty(var7, "has_confirmed_dst_prompt_dialog", var5, PreferencesHelper.INSTANCE.get(var7.getBackend(), "has_confirmed_dst_prompt_dialog", var5, Reflection.getOrCreateKotlinClass(Boolean.class))) {
         final Object $initialDefault;
         final String $key;
         final Prefs $prefs;

         public {
            this.$prefs = var1;
            this.$key = var2;
            this.$initialDefault = var3;
         }

         protected void afterChange(KProperty var1, Object var2, Object var3) {
            Intrinsics.checkParameterIsNotNull(var1, "property");
            Intrinsics.checkParameterIsNotNull(var2, "oldValue");
            Intrinsics.checkParameterIsNotNull(var3, "newValue");
            if (!Intrinsics.areEqual(var3, var2)) {
               Prefs var4 = this.$prefs;
               String var5 = this.$key;
               PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var3, Reflection.getOrCreateKotlinClass(Boolean.class));
            }

         }
      });
      this._networkAvailable = new MutableLiveData();
      this.liveDevices = FlowLiveDataConversions.asLiveData$default(this.getDeviceManager().getFlowDevices(), this.getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final IndoorViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               Flow var5 = this.this$0.getNetworkMonitor().getConnectivityStatus();
               FlowCollector var6 = new FlowCollector(this.this$0) {
                  final IndoorViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Object emit(boolean var1, Continuation var2) {
                     this.this$0._networkAvailable.postValue(Boxing.boxBoolean(var1));
                     return Unit.INSTANCE;
                  }
               };
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var5.collect(var6, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      this.isInChina = this.getLocationService().isInChina();
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final HappyUserService getHappyUserService() {
      return (HappyUserService)this.happyUserService$delegate.getValue();
   }

   private final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   private final NetworkMonitor getNetworkMonitor() {
      return (NetworkMonitor)this.networkMonitor$delegate.getValue();
   }

   private final List getObservedLiveDevices() {
      List var1 = (List)this.getLiveDevicesWithLatestDataPoint().getValue();
      if (var1 == null) {
         return CollectionsKt.emptyList();
      } else {
         Iterable var2 = (Iterable)var1;
         Collection var3 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var2, 10)));
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            var3.add((Device)((Pair)var4.next()).getFirst());
         }

         return (List)var3;
      }
   }

   private final Prefs getPrefs() {
      return (Prefs)this.prefs$delegate.getValue();
   }

   private final WelcomeHomeService getWelcomeHomeService() {
      return (WelcomeHomeService)this.welcomeHomeService$delegate.getValue();
   }

   // $FF: synthetic method
   public static void refreshDeviceList$default(IndoorViewModel var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = false;
      }

      var0.refreshDeviceList(var1);
   }

   // $FF: synthetic method
   public static void runWhAndRateUsLogic$default(IndoorViewModel var0, List var1, Function0 var2, Function0 var3, int var4, Object var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = null;
      }

      var0.runWhAndRateUsLogic(var1, var2, var3);
   }

   public final void autoModeChanged(HasFanSpeed var1, AutoMode var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "currentMode");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final AutoMode $currentMode;
         final HasFanSpeed $device;
         int label;
         final IndoorViewModel this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$currentMode = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$currentMode, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var4 = this.this$0.getDeviceManager();
               Device var5 = this.$device;
               AutoMode var7;
               if (this.$currentMode == AutoMode.ON) {
                  var7 = AutoMode.OFF;
               } else {
                  var7 = AutoMode.ON;
               }

               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (DeviceManager.setAutoMode$default(var4, var5, var7, false, var6, 4, (Object)null) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final boolean containsIcpDevice() {
      Iterator var1 = this.getObservedLiveDevices().iterator();

      while(var1.hasNext()) {
         if ((Device)var1.next() instanceof DeviceIcp) {
            return true;
         }
      }

      return false;
   }

   public final void ensureDeviceTimezone(List var1, TimeZone var2, Context var3) {
      Intrinsics.checkNotNullParameter(var1, "nullTimezoneDeviceIdList");
      Intrinsics.checkNotNullParameter(var2, "timezone");
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("set device timezone for ");
      var4.append(var1);
      var5.d(var4.toString(), new Object[0]);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, var3, (Continuation)null) {
         final Context $context;
         final List $nullTimezoneDeviceIdList;
         final TimeZone $timezone;
         int label;
         final IndoorViewModel this$0;

         {
            this.this$0 = var1;
            this.$nullTimezoneDeviceIdList = var2;
            this.$timezone = var3;
            this.$context = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$nullTimezoneDeviceIdList, this.$timezone, this.$context, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var4 = this.this$0.getDeviceManager();
               List var6 = this.$nullTimezoneDeviceIdList;
               TimeZone var8 = this.$timezone;
               Context var7 = this.$context;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var4.setDeviceTimezone(var6, var8, var7, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void g4NightModeChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final Device $device;
         int label;
         final IndoorViewModel this$0;

         {
            this.$device = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               if (this.$device instanceof HasG4NightMode) {
                  DeviceManager var4 = this.this$0.getDeviceManager();
                  var1 = (HasG4NightMode)this.$device;
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (DeviceManager.updateG4NightMode$default(var4, var1, false, var5, 2, (Object)null) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final boolean getHasConfirmedDstPromptDialog() {
      return (Boolean)this.hasConfirmedDstPromptDialog$delegate.getValue(this, $$delegatedProperties[6]);
   }

   public final LiveData getLiveDevices() {
      return this.liveDevices;
   }

   public final LiveData getLiveDevicesWithLatestDataPoint() {
      return FlowLiveDataConversions.asLiveData$default(FlowKt.flowCombine(this.getDeviceManager().getFlowDevices(), this.getDeviceManager().getFlowLatestDevicesDatapoints(), new Function3(this, (Continuation)null) {
         Object L$0;
         Object L$1;
         int label;
         final IndoorViewModel this$0;

         // $FF: synthetic method
         public static boolean $r8$lambda$DorrcN6QaC8s8bC0qx9skpSO_J8/* $FF was: $r8$lambda$DorrcN6QaC8s8bC0qx9skpSO-J8*/(Device var0) {
            return invokeSuspend$lambda$0(var0);
         }

         // $FF: synthetic method
         public static Pair $r8$lambda$Er9Iueb1P748qTv_RGi2YBpIwIQ/* $FF was: $r8$lambda$Er9Iueb1P748qTv-RGi2YBpIwIQ*/(Map var0, Device var1) {
            return invokeSuspend$lambda$2(var0, var1);
         }

         {
            this.this$0 = var1;
         }

         private static final boolean invokeSuspend$lambda$0(Device var0) {
            return var0 instanceof HasBlueProvisionCalls ? ((HasBlueProvisionCalls)var0).getHasFinishedOnboarding() : true;
         }

         private static final Pair invokeSuspend$lambda$2(Map var0, Device var1) {
            IndoorDatapoint var2 = (IndoorDatapoint)var0.get(var1.getUid());
            IndoorDatapoint var3 = null;
            if (var2 != null) {
               var3 = var2;
               if (System.currentTimeMillis() - var2.getTimeInMillis() >= 20000L) {
                  var3 = null;
               }
            }

            return TuplesKt.to(var1, var3);
         }

         public final Object invoke(List var1, Map var2, Continuation var3) {
            Function3 var4 = new <anonymous constructor>(this.this$0, var3);
            var4.L$0 = var1;
            var4.L$1 = var2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            List var3 = (List)this.L$0;
            Map var2 = (Map)this.L$1;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               return (Boolean)this.this$0.getAuthService().isUserLoggedIn().getValue() ? SequencesKt.toList(SequencesKt.map(SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence((Iterable)var3), new IndoorViewModel$liveDevicesWithLatestDataPoint$1$$ExternalSyntheticLambda0()), new Comparator() {
                  public final int compare(Object var1, Object var2) {
                     return ComparisonsKt.compareValues((Comparable)((Device)var1).getName(), (Comparable)((Device)var2).getName());
                  }
               }), new IndoorViewModel$liveDevicesWithLatestDataPoint$1$$ExternalSyntheticLambda1(var2))) : CollectionsKt.emptyList();
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }), this.getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final LiveData getNetworkAvailable() {
      return (LiveData)this._networkAvailable;
   }

   public final MutableLiveData getNullTimezoneDeviceIdList() {
      return this.getDeviceManager().getNullTimezoneDeviceIdList();
   }

   public final boolean isInChina() {
      return this.isInChina;
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.getAuthService().isUserLoggedIn().getValue();
   }

   public final boolean isWelcomeHomeAvailable() {
      return this.getWelcomeHomeService().getCountryAvailable();
   }

   public final void refreshDeviceList(boolean var1) {
      boolean var2;
      label25: {
         Prefs var5 = this.getPrefs();
         long var3 = ((Number)PreferencesHelper.INSTANCE.get(var5.getBackend(), "last_refresh_time", 0L, Reflection.getOrCreateKotlinClass(Long.class))).longValue();
         if (System.currentTimeMillis() - var3 <= 300000L) {
            Collection var7 = (Collection)this.liveDevices.getValue();
            if (var7 != null && !var7.isEmpty()) {
               var2 = false;
               break label25;
            }
         }

         var2 = true;
      }

      Timber.Forest var8 = Timber.Forest;
      StringBuilder var6 = new StringBuilder("refreshDeviceList: shouldRefresh = ");
      var6.append(var2);
      var6.append(", force = ");
      var6.append(var1);
      var8.d(var6.toString(), new Object[0]);
      if ((var2 || var1) && (Boolean)this.getAuthService().isUserLoggedIn().getValue()) {
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            int label;
            final IndoorViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var4;
               label32: {
                  var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        if (var2 != 2) {
                           if (var2 != 3) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           ResultKt.throwOnFailure(var1);
                           return Unit.INSTANCE;
                        }

                        ResultKt.throwOnFailure(var1);
                        break label32;
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     DeviceManager.Companion var3 = DeviceManager.Companion;
                     var1 = this.this$0.getDeviceManager();
                     Continuation var5 = (Continuation)this;
                     this.label = 1;
                     Object var9 = var3.downloadDeviceList(var1, var5);
                     var1 = (DeviceManager)var9;
                     if (var9 == var4) {
                        return var4;
                     }
                  }

                  ApiResult var7 = (ApiResult)var1;
                  Function2 var10 = new Function2(this.this$0, (Continuation)null) {
                     Object L$0;
                     int label;
                     final IndoorViewModel this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                        var3.L$0 = var1;
                        return (Continuation)var3;
                     }

                     public final Object invoke(Throwable var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Throwable var2 = (Throwable)this.L$0;
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           this.this$0.getPrefs().remove("last_refresh_time");
                           Timber.Forest var4 = Timber.Forest;
                           StringBuilder var3 = new StringBuilder("downloadDeviceList: fail = ");
                           var3.append(var2);
                           var4.e(var2, var3.toString(), new Object[0]);
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var13 = (Continuation)this;
                  this.label = 2;
                  Object var11 = ApiResultKt.onFail(var7, var10, var13);
                  var1 = (DeviceManager)var11;
                  if (var11 == var4) {
                     return var4;
                  }
               }

               ApiResult var12 = (ApiResult)var1;
               Function2 var14 = new Function2(this.this$0, (Continuation)null) {
                  int label;
                  final IndoorViewModel this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                  }

                  public final Object invoke(ApiResult var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.isLoading.set(false);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var8 = (Continuation)this;
               this.label = 3;
               if (ApiResultKt.finally(var12, var14, var8) == var4) {
                  return var4;
               } else {
                  return Unit.INSTANCE;
               }
            }
         }, 2, (Object)null);
      }
   }

   public final void runWhAndRateUsLogic(List var1, Function0 var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "devices");
      if (this.getHappyUserService().getShouldShowDev()) {
         this.getHappyUserService().setShouldShowDev(false);
         if (var2 != null) {
            var2.invoke();
            return;
         }
      } else if (!this.getHappyUserService().isRateUsShown()) {
         Boolean var5 = this.getDeviceManager().calculateHappyPoint(var1);
         if (var5 != null) {
            boolean var4 = var5;
            this.getHappyUserService().incrementPoints(var4);
            if (this.getHappyUserService().shouldShowRateUsDialogT1() && var2 != null) {
               var2.invoke();
            }
         }
      }

   }

   public final void setHasConfirmedDstPromptDialog(boolean var1) {
      this.hasConfirmedDstPromptDialog$delegate.setValue(this, $$delegatedProperties[6], var1);
   }

   public final void setMainMode(HasCombo3in1MainMode var1, MainMode var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "mode");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final HasCombo3in1MainMode $device;
         final MainMode $mode;
         int label;
         final IndoorViewModel this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$mode = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$mode, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceManager var4 = this.this$0.getDeviceManager();
               HasMainMode var5 = this.$device;
               var2 = this.$mode.getValue();
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (DeviceManager.setMainMode$default(var4, var5, var2, (String)null, var6, 4, (Object)null) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setToMode(HasMode var1, Mode var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "mode");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, var2, (Continuation)null) {
         final HasMode $device;
         final Mode $mode;
         int label;
         final IndoorViewModel this$0;

         {
            this.this$0 = var1;
            this.$device = var2;
            this.$mode = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$mode, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               var1 = this.this$0.getDeviceManager();
               HasMode var4 = this.$device;
               var2 = this.$mode.getValue();
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (DeviceManager.setMode$default(var1, var4, var2, false, (String)null, var5, 12, (Object)null) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void setWelcomeHomeAsShowed() {
      this.getWelcomeHomeService().setWelcomeHomeAsShowed();
   }

   public final boolean shouldShowInAppReview() {
      return this.getHappyUserService().shouldShowNativeInAppReview();
   }

   public final boolean shouldShowRateUsT2() {
      return this.getHappyUserService().shouldShowRateUsDialogT2();
   }

   public final boolean shouldShowRateUsT3() {
      return this.getHappyUserService().shouldShowRateUsDialogT3();
   }

   public final Object shouldShowWhExplore(Continuation var1) {
      label23: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label23;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final IndoorViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.shouldShowWhExplore((Continuation)this);
            }
         };
      }

      Object var9 = ((<undefinedtype>)var6).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var6).label;
      Object var7;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var9);
         var7 = var9;
      } else {
         ResultKt.throwOnFailure(var9);
         CoroutineContext var5 = (CoroutineContext)Dispatchers.getIO();
         Function2 var10 = new Function2(this, (Continuation)null) {
            int label;
            final IndoorViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               IntrinsicsKt.getCOROUTINE_SUSPENDED();
               if (this.label == 0) {
                  ResultKt.throwOnFailure(var1);
                  return this.this$0.getDeviceManager().getDevices();
               } else {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }
            }
         };
         ((<undefinedtype>)var6).label = 1;
         Object var11 = BuildersKt.withContext(var5, var10, (Continuation)var6);
         var7 = var11;
         if (var11 == var4) {
            return var4;
         }
      }

      List var8 = (List)var7;
      return Boxing.boxBoolean(this.getWelcomeHomeService().shouldShowWHExplore(var8));
   }

   public final void standByChanged(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var1, this, (Continuation)null) {
         final Device $device;
         int label;
         final IndoorViewModel this$0;

         {
            this.$device = var1;
            this.this$0 = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$device, this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               if (this.$device instanceof HasStandBy) {
                  var1 = this.this$0.getDeviceManager();
                  HasStandBy var4 = (HasStandBy)this.$device;
                  Continuation var5 = (Continuation)this;
                  this.label = 1;
                  if (var1.updateStandBy(var4, var5) == var3) {
                     return var3;
                  }
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }
}
