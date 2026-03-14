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
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.FilterLifeLevel;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.NotificationMessage;
import com.blueair.core.model.NotificationMsgType;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicedetails.activity.DeviceFilterDetailActivity;
import com.blueair.devicedetails.databinding.BottomSheetFilterOrderBinding;
import com.blueair.devicedetails.dialog.BuyFilterV2DialogFragment;
import com.blueair.devicedetails.dialog.DeviceFilterPageDialogFragment;
import com.blueair.devicedetails.dialog.DeviceNFilterDialogFragment;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import io.flatcircle.preferenceshelper2.PrefsBackend;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002J\u0006\u00100\u001a\u000201J\u0016\u00102\u001a\u0002012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J \u00107\u001a\u0002012\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:H\u0002J(\u0010;\u001a\u0002012\u0006\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020:2\u0006\u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020>H\u0002J(\u0010?\u001a\u0002012\u0006\u00108\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00132\u0006\u0010<\u001a\u00020,H\u0002J\u0016\u0010C\u001a\u0002012\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0018\u0010D\u001a\u0002012\u0006\u00103\u001a\u0002042\b\b\u0002\u0010E\u001a\u00020,R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fRI\u0010\u0011\u001a:\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u00140\u0012j\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0014`\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0&8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006F"},
   d2 = {"Lcom/blueair/android/viewmodel/NotificationsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "app", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "aqiHumLevelMap", "Ljava/util/HashMap;", "", "Lkotlin/Pair;", "Lcom/blueair/core/model/AqiHumLevel;", "", "Lkotlin/collections/HashMap;", "getAqiHumLevelMap", "()Ljava/util/HashMap;", "notificationsNum", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getNotificationsNum", "()Landroidx/lifecycle/MutableLiveData;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "lvNotificationMsgs", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/NotificationMessage;", "getLvNotificationMsgs", "()Landroidx/lifecycle/LiveData;", "shouldReplace", "", "lastDevice", "Lcom/blueair/core/model/Device;", "newDevice", "dismissAll", "", "executeBuyFilterEvent", "item", "Lcom/blueair/android/adapter/NotificationItem;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "showFilterPurchaseOptionDialog", "device", "deviceFilter", "Lcom/blueair/core/model/FilterInfo;", "toPurchaseOrSubscribe", "purchase", "activityContext", "Landroid/content/Context;", "analyticsLogFilterClickEvent", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "filterName", "executeReplaceFilterEvent", "dismissMsg", "withDelay", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationsViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationsViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationsViewModel.class, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationsViewModel.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)))};
   public static final int $stable = 8;
   private final HashMap aqiHumLevelMap;
   private final Lazy authService$delegate;
   private final Lazy locationService$delegate;
   private final MutableLiveData notificationsNum;
   private final Lazy prefs$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$_jep_xMwsWsObdVb4T8KtXBuJUg/* $FF was: $r8$lambda$-jep-xMwsWsObdVb4T8KtXBuJUg*/(NotificationsViewModel var0, Device var1, FilterInfo var2, BottomSheetDialog var3, View var4) {
      showFilterPurchaseOptionDialog$lambda$3(var0, var1, var2, var3, var4);
   }

   // $FF: synthetic method
   public static void $r8$lambda$XsWe0JZ8Ny5FrckVv_bK4TTRK3U(BottomSheetDialog var0, View var1) {
      showFilterPurchaseOptionDialog$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$n4Zns03mz2JSDNN7ZWmdfadLV58(NotificationsViewModel var0, Device var1, FilterInfo var2, BottomSheetDialog var3, View var4) {
      showFilterPurchaseOptionDialog$lambda$2(var0, var1, var2, var3, var4);
   }

   public NotificationsViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "app");
      super(var1);
      DIAware var4 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, AuthService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.authService$delegate = var3.provideDelegate(this, var5[0]);
      JVMTypeToken var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.locationService$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, LocationService.class)), (Object)null).provideDelegate(this, var5[1]);
      this.aqiHumLevelMap = new HashMap();
      this.notificationsNum = new MutableLiveData(0);
      var6 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var4, (TypeToken)(new GenericJVMTypeTokenDelegate(var6, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var5[2]);
   }

   private final void analyticsLogFilterClickEvent(Device var1, DeviceFilterType var2, String var3, boolean var4) {
      AnalyticEvent.FilterClickEvent var5;
      if (var4) {
         var5 = new AnalyticEvent.FilterClickEvent.HomepageFilterClickPurchase(System.currentTimeMillis(), var2, var3, var1, this.getAuthService().getUserIdForBlueCloud(), this.getAuthService().getCloudUserRegion());
      } else {
         var5 = new AnalyticEvent.FilterClickEvent.HomepageFilterClickSubscribe(System.currentTimeMillis(), var2, var3, var1, this.getAuthService().getUserIdForBlueCloud(), this.getAuthService().getCloudUserRegion());
      }

      this.getAnalyticsService().event(var5);
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var5, (Continuation)null) {
         final AnalyticEvent.FilterClickEvent $event;
         int label;
         final NotificationsViewModel this$0;

         {
            this.this$0 = var1;
            this.$event = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$event, var2));
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
               var1 = this.$event;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var4.analyticsLogFilterClickEvent(var1, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   // $FF: synthetic method
   public static void dismissMsg$default(NotificationsViewModel var0, NotificationItem var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.dismissMsg(var1, var2);
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final UnsecurePrefs getPrefs() {
      return (UnsecurePrefs)this.prefs$delegate.getValue();
   }

   private final boolean shouldReplace(Device var1, Device var2) {
      if (!Intrinsics.areEqual(var1.getName(), var2.getName())) {
         return true;
      } else if (!Intrinsics.areEqual(DeviceKt.getSkuCompat(var1), DeviceKt.getSkuCompat(var2))) {
         return true;
      } else {
         return var1 instanceof HasRemoveYellowWater && var2 instanceof HasRemoveYellowWater && !Intrinsics.areEqual(((HasRemoveYellowWater)var1).getYwrmEnabled(), ((HasRemoveYellowWater)var2).getYwrmEnabled());
      }
   }

   private final void showFilterPurchaseOptionDialog(FragmentActivity var1, Device var2, FilterInfo var3) {
      BottomSheetDialog var4 = new BottomSheetDialog((Context)var1, R.style.BottomSheetDialog);
      BottomSheetFilterOrderBinding var5 = BottomSheetFilterOrderBinding.inflate(var1.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
      var5.buttonFilterOneTimePurchase.setOnClickListener(new NotificationsViewModel$$ExternalSyntheticLambda0(this, var2, var3, var4));
      var5.buttonFilterSubscription.setOnClickListener(new NotificationsViewModel$$ExternalSyntheticLambda1(this, var2, var3, var4));
      var5.btnCancel.setOnClickListener(new NotificationsViewModel$$ExternalSyntheticLambda2(var4));
      var4.setContentView((View)var5.getRoot());
      var4.show();
   }

   private static final void showFilterPurchaseOptionDialog$lambda$2(NotificationsViewModel var0, Device var1, FilterInfo var2, BottomSheetDialog var3, View var4) {
      Context var5 = var4.getContext();
      Intrinsics.checkNotNullExpressionValue(var5, "getContext(...)");
      var0.toPurchaseOrSubscribe(var1, var2, true, var5);
      var3.dismiss();
   }

   private static final void showFilterPurchaseOptionDialog$lambda$3(NotificationsViewModel var0, Device var1, FilterInfo var2, BottomSheetDialog var3, View var4) {
      Context var5 = var4.getContext();
      Intrinsics.checkNotNullExpressionValue(var5, "getContext(...)");
      var0.toPurchaseOrSubscribe(var1, var2, false, var5);
      var3.dismiss();
   }

   private static final void showFilterPurchaseOptionDialog$lambda$4(BottomSheetDialog var0, View var1) {
      var0.dismiss();
   }

   private final void toPurchaseOrSubscribe(Device var1, FilterInfo var2, boolean var3, Context var4) {
      int var5;
      if (var2.getType() == DeviceFilterType.FILTER) {
         var5 = R.string.order_filter;
      } else {
         var5 = R.string.order_wick;
      }

      String var8 = var4.getString(var5);
      Intrinsics.checkNotNull(var8);
      DeviceFilterType var9 = var2.getType();
      String var7 = var2.getName().getValue();
      String var6 = var7;
      if (var7 == null) {
         var6 = "";
      }

      this.analyticsLogFilterClickEvent(var1, var9, var6, var3);
      String var10;
      if (var3) {
         var10 = DeviceConfigProvider.INSTANCE.getIpConfigValue(var2.getLinkPurchase());
      } else {
         var10 = DeviceConfigProvider.INSTANCE.getIpConfigValue(var2.getLinkSubscribe());
      }

      if (var10 != null) {
         DeviceConfigProvider.INSTANCE.openFilterUrl(var4, var10, var8);
      }

   }

   public final void dismissAll() {
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final NotificationsViewModel this$0;

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
               var1 = this.this$0.getDeviceManager();
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (var1.dismissAll(var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }

   public final void dismissMsg(NotificationItem var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "item");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var2, this, var1, (Continuation)null) {
         final NotificationItem $item;
         final boolean $withDelay;
         int label;
         final NotificationsViewModel this$0;

         {
            this.$withDelay = var1;
            this.this$0 = var2;
            this.$item = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.$withDelay, this.this$0, this.$item, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
                  return Unit.INSTANCE;
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               if (this.$withDelay) {
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (DelayKt.delay(300L, var6) == var3) {
                     return var3;
                  }
               }
            }

            DeviceManager var5 = this.this$0.getDeviceManager();
            NotificationMessage var4 = this.$item.getMessage();
            Continuation var7 = (Continuation)this;
            this.label = 2;
            if (var5.dismissNotificationMsg(var4, var7) == var3) {
               return var3;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 2, (Object)null);
   }

   public final void executeBuyFilterEvent(NotificationItem var1, FragmentActivity var2) {
      Intrinsics.checkNotNullParameter(var1, "item");
      Intrinsics.checkNotNullParameter(var2, "fragmentActivity");
      List var6 = var1.getDeviceFilters();
      Device var5 = var1.getMessage().getDevice();
      Collection var7 = (Collection)var6;
      if (var7 != null && !var7.isEmpty()) {
         DeviceFilterType var8 = DeviceFilterType.valueOf(var1.getMessage().getSubType());
         if (DeviceKt.useV2UI(var5)) {
            FragmentManager var10 = var2.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var10, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("BuyFilterV2DialogFragment", "getSimpleName(...)");
            if (!(var10.findFragmentByTag("BuyFilterV2DialogFragment") instanceof BuyFilterV2DialogFragment) && !var10.isStateSaved()) {
               ((DialogFragment)BuyFilterV2DialogFragment.Companion.newInstance$default(BuyFilterV2DialogFragment.Companion, var5, (String)null, var8, true, (String)null, 16, (Object)null)).show(var10, "BuyFilterV2DialogFragment");
               return;
            }
         } else if (DeviceKt.useNewFilterConfig(var5)) {
            FragmentManager var11 = var2.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var11, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
            if (!(var11.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment) && !var11.isStateSaved()) {
               ((DialogFragment)DeviceNFilterDialogFragment.Companion.newInstance(var5, (String)null, var8, true, true)).show(var11, "DeviceNFilterDialogFragment");
               return;
            }
         } else {
            FilterInfo var9 = (FilterInfo)CollectionsKt.first(var6);
            CharSequence var12 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var9.getLinkPurchase());
            boolean var3;
            if (var12 != null && var12.length() != 0) {
               var3 = false;
            } else {
               var3 = true;
            }

            var12 = (CharSequence)DeviceConfigProvider.INSTANCE.getIpConfigValue(var9.getLinkSubscribe());
            boolean var4;
            if (var12 != null && var12.length() != 0) {
               var4 = false;
            } else {
               var4 = true;
            }

            if (!var3 && !var4) {
               this.showFilterPurchaseOptionDialog(var2, var5, var9);
               return;
            }

            if (!var3 && var4) {
               this.toPurchaseOrSubscribe(var5, var9, true, (Context)var2);
               return;
            }

            if (var3 && !var4) {
               this.toPurchaseOrSubscribe(var5, var9, false, (Context)var2);
            }
         }
      }

   }

   public final void executeReplaceFilterEvent(NotificationItem var1, FragmentActivity var2) {
      Intrinsics.checkNotNullParameter(var1, "item");
      Intrinsics.checkNotNullParameter(var2, "fragmentActivity");
      Device var6 = var1.getMessage().getDevice();
      DeviceFilterType var7 = DeviceFilterType.valueOf(var1.getMessage().getSubType());
      if (DeviceKt.useV2UI(var6)) {
         DeviceFilterDetailActivity.Companion.launch((Context)var2, var6, (String)null, var7, true);
      } else {
         boolean var3 = DeviceKt.useNewFilterConfig(var6);
         Object var5 = null;
         Object var4 = null;
         if (var3) {
            FragmentManager var13 = var2.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var13, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceNFilterDialogFragment", "getSimpleName(...)");
            BaseDialogFragment var10 = (BaseDialogFragment)var4;
            if (!(var13.findFragmentByTag("DeviceNFilterDialogFragment") instanceof DeviceNFilterDialogFragment)) {
               var10 = (BaseDialogFragment)var4;
               if (!var13.isStateSaved()) {
                  var10 = DeviceNFilterDialogFragment.Companion.newInstance(var6, (String)null, var7, false, true);
                  ((DialogFragment)var10).show(var13, "DeviceNFilterDialogFragment");
               }
            }

            var10 = var10;
         } else {
            FragmentManager var12 = var2.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var12, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeviceFilterPageDialogFragment", "getSimpleName(...)");
            BaseDialogFragment var8 = (BaseDialogFragment)var5;
            if (!(var12.findFragmentByTag("DeviceFilterPageDialogFragment") instanceof DeviceFilterPageDialogFragment)) {
               var8 = (BaseDialogFragment)var5;
               if (!var12.isStateSaved()) {
                  var8 = DeviceFilterPageDialogFragment.Companion.newInstance(var6, true);
                  ((DialogFragment)var8).show(var12, "DeviceFilterPageDialogFragment");
               }
            }

            var8 = var8;
         }
      }
   }

   public final HashMap getAqiHumLevelMap() {
      return this.aqiHumLevelMap;
   }

   public final LocationService getLocationService() {
      return (LocationService)this.locationService$delegate.getValue();
   }

   public final LiveData getLvNotificationMsgs() {
      return FlowLiveDataConversions.asLiveData$default(FlowKt.distinctUntilChanged(FlowKt.flowCombine(this.getDeviceManager().getFlowNotifications(), this.getDeviceManager().getFlowDevices(), new Function3(this, (Continuation)null) {
         int I$0;
         int I$1;
         int I$2;
         int I$3;
         long J$0;
         long J$1;
         Object L$0;
         Object L$1;
         Object L$2;
         Object L$3;
         Object L$4;
         Object L$5;
         Object L$6;
         Object L$7;
         Object L$8;
         Object L$9;
         int label;
         final NotificationsViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Object invoke(List var1, List var2, Continuation var3) {
            Function3 var4 = new <anonymous constructor>(this.this$0, var3);
            var4.L$0 = var1;
            var4.L$1 = var2;
            return ((<undefinedtype>)var4).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            List var13 = (List)this.L$0;
            List var25 = (List)this.L$1;
            Object var24 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            int var5;
            Iterator var15;
            Sequence var17;
            NotificationsViewModel var19;
            byte var58;
            if (var2 != 0) {
               if (var2 != 1) {
                  if (var2 != 2) {
                     if (var2 != 3) {
                        if (var2 != 4) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var58 = this.I$0;
                        Pair var14 = (Pair)this.L$9;
                        AqiHumLevel var82 = (AqiHumLevel)this.L$8;
                        Float var83 = (Float)this.L$7;
                        Device var84 = (Device)this.L$6;
                        var15 = (Iterator)this.L$4;
                        NotificationsViewModel var16 = (NotificationsViewModel)this.L$3;
                        Sequence var85 = (Sequence)this.L$2;
                        ResultKt.throwOnFailure(var1);
                        var2 = 10;
                        var17 = var85;
                        var19 = var16;
                        var13 = var13;
                        var5 = var58;
                        var58 = var2;
                     } else {
                        var5 = this.I$1;
                        var58 = this.I$0;
                        Device var125 = (Device)this.L$6;
                        Object var18 = this.L$5;
                        var15 = (Iterator)this.L$4;
                        var2 = 10;
                        NotificationsViewModel var86 = (NotificationsViewModel)this.L$3;
                        Sequence var106 = (Sequence)this.L$2;
                        ResultKt.throwOnFailure(var1);
                        Sequence var29 = var106;
                        if (var125 instanceof DeviceHumidifier) {
                           DeviceHumidifier var20 = (DeviceHumidifier)var125;
                           IndoorDatapoint var107 = var20.getLatestSensorDatapoint();
                           Float var138;
                           if (var107 != null) {
                              var138 = var107.getHum();
                           } else {
                              var138 = null;
                           }

                           AqiHumLevel var108;
                           if (var138 != null) {
                              var108 = AqiHumLevel.Companion.fromHumValue(var138);
                           } else {
                              var108 = null;
                           }

                           Pair var21 = (Pair)var86.getAqiHumLevelMap().get(var20.getUid());
                           long var11 = System.currentTimeMillis();
                           if (var21 != null) {
                              if (var21.getFirst() == var108) {
                                 Prefs var26 = var86.getPrefs();
                                 Integer var22 = Boxing.boxInt(var2);
                                 PreferencesHelper var23 = PreferencesHelper.INSTANCE;
                                 PrefsBackend var185 = var26.getBackend();
                                 long var9 = ((Number)var23.get(var185, "KEY_NOTIFICATION_AQI_INTERMITTENT", var22, Reflection.getOrCreateKotlinClass(Integer.class))).longValue() * 1000L;
                                 List var30;
                                 if (var11 - ((Number)var21.getSecond()).longValue() > var9) {
                                    DeviceManager var165 = var86.getDeviceManager();
                                    String var175 = var20.getUid();
                                    AqiHumLevel var147;
                                    if (var108 == null) {
                                       var147 = AqiHumLevel.IDEAL;
                                    } else {
                                       var147 = var108;
                                    }

                                    this.L$0 = var13;
                                    this.L$1 = var25;
                                    this.L$2 = SpillingKt.nullOutSpilledVariable(var29);
                                    this.L$3 = var86;
                                    this.L$4 = var15;
                                    this.L$5 = SpillingKt.nullOutSpilledVariable(var18);
                                    this.L$6 = SpillingKt.nullOutSpilledVariable(var125);
                                    this.L$7 = SpillingKt.nullOutSpilledVariable(var138);
                                    this.L$8 = SpillingKt.nullOutSpilledVariable(var108);
                                    this.L$9 = SpillingKt.nullOutSpilledVariable(var21);
                                    this.I$0 = var58;
                                    this.I$1 = var5;
                                    this.J$0 = var11;
                                    this.J$1 = var9;
                                    this.label = 4;
                                    if (var165.executeHumForNotification(var175, var147, this) == var24) {
                                       return var24;
                                    }

                                    NotificationsViewModel var109 = var86;
                                    Sequence var87 = var29;
                                    var30 = var13;
                                    var17 = var87;
                                    var19 = var109;
                                 } else {
                                    var19 = var86;
                                    var17 = var29;
                                    var30 = var13;
                                 }

                                 var13 = var30;
                                 var5 = var58;
                                 var58 = var2;
                              } else {
                                 ((Map)var86.getAqiHumLevelMap()).put(var20.getUid(), new Pair(var108, Boxing.boxLong(var11)));
                                 var19 = var86;
                                 var17 = var29;
                                 var13 = var13;
                                 var5 = var58;
                                 var58 = var2;
                              }
                           } else {
                              ((Map)var86.getAqiHumLevelMap()).put(var20.getUid(), new Pair(var108, Boxing.boxLong(var11)));
                              var19 = var86;
                              var17 = var29;
                              var13 = var13;
                              var5 = var58;
                              var58 = var2;
                           }
                        } else {
                           var19 = var86;
                           var17 = var106;
                           var13 = var13;
                           var5 = var58;
                           var58 = var2;
                        }
                     }
                  } else {
                     byte var3 = 10;
                     var2 = this.I$1;
                     int var7 = this.I$0;
                     Device var102 = (Device)this.L$6;
                     Object var159 = this.L$5;
                     Iterator var88 = (Iterator)this.L$4;
                     NotificationsViewModel var176 = (NotificationsViewModel)this.L$3;
                     Sequence var166 = (Sequence)this.L$2;
                     ResultKt.throwOnFailure(var1);
                     Object var131 = var159;
                     Device var126 = var102;
                     Sequence var31 = var166;
                     var15 = var88;
                     NotificationsViewModel var90;
                     if (var126 instanceof HasRemoveYellowWater) {
                        HasRemoveYellowWater var89 = (HasRemoveYellowWater)var126;
                        if (Intrinsics.areEqual(var89.getYwrmEnabled(), Boxing.boxBoolean(true))) {
                           DeviceManager var139 = var176.getDeviceManager();
                           String var110 = var126.getUid();
                           DeviceFilterType var148 = DeviceFilterType.REFRESHER;
                           int var6 = var89.getRefresherLifeLeft();
                           this.L$0 = var13;
                           this.L$1 = var25;
                           this.L$2 = SpillingKt.nullOutSpilledVariable(var166);
                           this.L$3 = var176;
                           this.L$4 = var15;
                           this.L$5 = SpillingKt.nullOutSpilledVariable(var159);
                           this.L$6 = var126;
                           this.L$7 = null;
                           this.L$8 = null;
                           this.L$9 = null;
                           this.I$0 = var7;
                           this.I$1 = var2;
                           this.label = 3;
                           var5 = var2;
                           var90 = var176;
                           var2 = var3;
                           if (var139.executeFilterLifeForNotification(var110, var148, var6, this) == var24) {
                              return var24;
                           }
                        } else {
                           var5 = var2;
                           var90 = var176;
                           var2 = var3;
                        }
                     } else {
                        var5 = var2;
                        var90 = var176;
                        var2 = var3;
                     }

                     if (var126 instanceof DeviceHumidifier) {
                        DeviceHumidifier var149 = (DeviceHumidifier)var126;
                        IndoorDatapoint var111 = var149.getLatestSensorDatapoint();
                        Float var140;
                        if (var111 != null) {
                           var140 = var111.getHum();
                        } else {
                           var140 = null;
                        }

                        AqiHumLevel var112;
                        if (var140 != null) {
                           var112 = AqiHumLevel.Companion.fromHumValue(var140);
                        } else {
                           var112 = null;
                        }

                        Pair var160 = (Pair)var90.getAqiHumLevelMap().get(var149.getUid());
                        long var76 = System.currentTimeMillis();
                        if (var160 != null) {
                           if (var160.getFirst() == var112) {
                              Prefs var186 = var90.getPrefs();
                              Integer var167 = Boxing.boxInt(var2);
                              PreferencesHelper var177 = PreferencesHelper.INSTANCE;
                              PrefsBackend var187 = var186.getBackend();
                              long var73 = ((Number)var177.get(var187, "KEY_NOTIFICATION_AQI_INTERMITTENT", var167, Reflection.getOrCreateKotlinClass(Integer.class))).longValue() * 1000L;
                              List var32;
                              if (var76 - ((Number)var160.getSecond()).longValue() > var73) {
                                 DeviceManager var168 = var90.getDeviceManager();
                                 String var178 = var149.getUid();
                                 AqiHumLevel var150;
                                 if (var112 == null) {
                                    var150 = AqiHumLevel.IDEAL;
                                 } else {
                                    var150 = var112;
                                 }

                                 this.L$0 = var13;
                                 this.L$1 = var25;
                                 this.L$2 = SpillingKt.nullOutSpilledVariable(var31);
                                 this.L$3 = var90;
                                 this.L$4 = var15;
                                 this.L$5 = SpillingKt.nullOutSpilledVariable(var131);
                                 this.L$6 = SpillingKt.nullOutSpilledVariable(var126);
                                 this.L$7 = SpillingKt.nullOutSpilledVariable(var140);
                                 this.L$8 = SpillingKt.nullOutSpilledVariable(var112);
                                 this.L$9 = SpillingKt.nullOutSpilledVariable(var160);
                                 this.I$0 = var7;
                                 this.I$1 = var5;
                                 this.J$0 = var76;
                                 this.J$1 = var73;
                                 this.label = 4;
                                 if (var168.executeHumForNotification(var178, var150, this) == var24) {
                                    return var24;
                                 }

                                 NotificationsViewModel var113 = var90;
                                 Sequence var91 = var31;
                                 var32 = var13;
                                 var17 = var91;
                                 var19 = var113;
                              } else {
                                 var19 = var90;
                                 var17 = var31;
                                 var32 = var13;
                              }

                              var13 = var32;
                              var5 = var7;
                              var58 = var2;
                           } else {
                              ((Map)var90.getAqiHumLevelMap()).put(var149.getUid(), new Pair(var112, Boxing.boxLong(var76)));
                              var19 = var90;
                              var17 = var166;
                              var13 = var13;
                              var5 = var7;
                              var58 = var2;
                           }
                        } else {
                           ((Map)var90.getAqiHumLevelMap()).put(var149.getUid(), new Pair(var112, Boxing.boxLong(var76)));
                           var19 = var90;
                           var17 = var166;
                           var13 = var13;
                           var5 = var7;
                           var58 = var2;
                        }
                     } else {
                        var19 = var90;
                        var17 = var166;
                        var13 = var13;
                        var5 = var7;
                        var58 = var2;
                     }
                  }
               } else {
                  var58 = 10;
                  int var66 = this.I$1;
                  var5 = this.I$0;
                  DeviceHumidifier var151 = (Device)this.L$6;
                  IndoorDatapoint var114 = (IndoorDatapoint)this.L$5;
                  var15 = (Iterator)this.L$4;
                  var19 = (NotificationsViewModel)this.L$3;
                  var17 = (Sequence)this.L$2;
                  ResultKt.throwOnFailure(var1);
                  List var132 = var13;
                  var13 = var13;
                  var2 = var66;
                  int var70 = var5;
                  var1 = var151;
                  Object var161 = var114;
                  Iterator var92 = var15;
                  NotificationsViewModel var179 = var19;
                  Sequence var169 = var17;
                  byte var56 = (byte)var58;
                  if (var151 instanceof HasWick) {
                     DeviceManager var28 = var19.getDeviceManager();
                     String var27 = var151.getUid();
                     DeviceFilterType var188 = DeviceFilterType.WICK;
                     int var8 = ((HasWick)var151).getWickLifeLeft();
                     this.L$0 = var132;
                     this.L$1 = var25;
                     this.L$2 = SpillingKt.nullOutSpilledVariable(var17);
                     this.L$3 = var19;
                     this.L$4 = var15;
                     this.L$5 = SpillingKt.nullOutSpilledVariable(var114);
                     this.L$6 = var151;
                     this.L$7 = null;
                     this.L$8 = null;
                     this.L$9 = null;
                     this.I$0 = var5;
                     this.I$1 = var66;
                     this.label = 2;
                     var13 = var132;
                     var2 = var66;
                     var70 = var5;
                     var1 = var151;
                     var161 = var114;
                     var92 = var15;
                     var179 = var19;
                     var169 = var17;
                     var56 = (byte)var58;
                     if (var28.executeFilterLifeForNotification(var27, var188, var8, this) == var24) {
                        return var24;
                     }
                  }

                  Object var133 = var161;
                  Device var128 = var1;
                  Sequence var34 = var169;
                  var15 = var92;
                  NotificationsViewModel var94;
                  if (var128 instanceof HasRemoveYellowWater) {
                     HasRemoveYellowWater var93 = (HasRemoveYellowWater)var128;
                     if (Intrinsics.areEqual(var93.getYwrmEnabled(), Boxing.boxBoolean(true))) {
                        DeviceManager var142 = var179.getDeviceManager();
                        String var115 = var128.getUid();
                        DeviceFilterType var152 = DeviceFilterType.REFRESHER;
                        var66 = var93.getRefresherLifeLeft();
                        this.L$0 = var13;
                        this.L$1 = var25;
                        this.L$2 = SpillingKt.nullOutSpilledVariable(var169);
                        this.L$3 = var179;
                        this.L$4 = var15;
                        this.L$5 = SpillingKt.nullOutSpilledVariable(var161);
                        this.L$6 = var128;
                        this.L$7 = null;
                        this.L$8 = null;
                        this.L$9 = null;
                        this.I$0 = var70;
                        this.I$1 = var2;
                        this.label = 3;
                        var5 = var2;
                        var94 = var179;
                        var2 = var56;
                        if (var142.executeFilterLifeForNotification(var115, var152, var66, this) == var24) {
                           return var24;
                        }
                     } else {
                        var5 = var2;
                        var94 = var179;
                        var2 = var56;
                     }
                  } else {
                     var5 = var2;
                     var94 = var179;
                     var2 = var56;
                  }

                  if (var128 instanceof DeviceHumidifier) {
                     var151 = (DeviceHumidifier)var128;
                     var114 = var151.getLatestSensorDatapoint();
                     Float var143;
                     if (var114 != null) {
                        var143 = var114.getHum();
                     } else {
                        var143 = null;
                     }

                     AqiHumLevel var117;
                     if (var143 != null) {
                        var117 = AqiHumLevel.Companion.fromHumValue(var143);
                     } else {
                        var117 = null;
                     }

                     Pair var162 = (Pair)var94.getAqiHumLevelMap().get(var151.getUid());
                     long var77 = System.currentTimeMillis();
                     if (var162 != null) {
                        if (var162.getFirst() == var117) {
                           Prefs var189 = var94.getPrefs();
                           Integer var170 = Boxing.boxInt(var2);
                           PreferencesHelper var180 = PreferencesHelper.INSTANCE;
                           PrefsBackend var190 = var189.getBackend();
                           long var74 = ((Number)var180.get(var190, "KEY_NOTIFICATION_AQI_INTERMITTENT", var170, Reflection.getOrCreateKotlinClass(Integer.class))).longValue() * 1000L;
                           List var35;
                           if (var77 - ((Number)var162.getSecond()).longValue() > var74) {
                              DeviceManager var171 = var94.getDeviceManager();
                              String var181 = var151.getUid();
                              AqiHumLevel var154;
                              if (var117 == null) {
                                 var154 = AqiHumLevel.IDEAL;
                              } else {
                                 var154 = var117;
                              }

                              this.L$0 = var13;
                              this.L$1 = var25;
                              this.L$2 = SpillingKt.nullOutSpilledVariable(var34);
                              this.L$3 = var94;
                              this.L$4 = var15;
                              this.L$5 = SpillingKt.nullOutSpilledVariable(var133);
                              this.L$6 = SpillingKt.nullOutSpilledVariable(var128);
                              this.L$7 = SpillingKt.nullOutSpilledVariable(var143);
                              this.L$8 = SpillingKt.nullOutSpilledVariable(var117);
                              this.L$9 = SpillingKt.nullOutSpilledVariable(var162);
                              this.I$0 = var70;
                              this.I$1 = var5;
                              this.J$0 = var77;
                              this.J$1 = var74;
                              this.label = 4;
                              if (var171.executeHumForNotification(var181, var154, this) == var24) {
                                 return var24;
                              }

                              NotificationsViewModel var118 = var94;
                              Sequence var95 = var34;
                              var35 = var13;
                              var17 = var95;
                              var19 = var118;
                           } else {
                              var19 = var94;
                              var17 = var34;
                              var35 = var13;
                           }

                           var13 = var35;
                           var5 = var70;
                           var58 = var2;
                        } else {
                           ((Map)var94.getAqiHumLevelMap()).put(var151.getUid(), new Pair(var117, Boxing.boxLong(var77)));
                           var19 = var94;
                           var17 = var169;
                           var13 = var13;
                           var5 = var70;
                           var58 = var2;
                        }
                     } else {
                        ((Map)var94.getAqiHumLevelMap()).put(var151.getUid(), new Pair(var117, Boxing.boxLong(var77)));
                        var19 = var94;
                        var17 = var169;
                        var13 = var13;
                        var5 = var70;
                        var58 = var2;
                     }
                  } else {
                     var19 = var94;
                     var17 = var169;
                     var13 = var13;
                     var5 = var70;
                     var58 = var2;
                  }
               }
            } else {
               var58 = 10;
               ResultKt.throwOnFailure(var1);
               var17 = CollectionsKt.asSequence((Iterable)var25);
               var19 = this.this$0;
               var15 = var17.iterator();
               var5 = 0;
            }

            while(true) {
               if (!var15.hasNext()) {
                  Iterable var41 = (Iterable)var25;
                  Map var101 = (Map)(new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(var41, var58)), 16)));

                  for(Object var104 : var41) {
                     var101.put(((Device)var104).getUid(), var104);
                  }

                  var41 = (Iterable)var13;
                  NotificationsViewModel var124 = this.this$0;
                  Collection var105 = (Collection)(new ArrayList());

                  for(NotificationMessage var81 : var41) {
                     label104: {
                        label103: {
                           Device var137 = var81.getDevice();
                           Device var146 = (Device)var101.get(var137.getUid());
                           NotificationMsgType var44 = var81.getType();
                           var2 = null.WhenMappings.$EnumSwitchMapping$0[var44.ordinal()];
                           if (var2 != 1) {
                              if (var2 != 2) {
                                 throw new NoWhenBranchMatchedException();
                              }

                              if (var146 == null || var146.getConnectivityStatus() != ConnectivityStatus.ONLINE || DeviceKt.isStandByOn(var146)) {
                                 break label103;
                              }
                           } else {
                              if (FilterLifeLevel.Companion.fromLevel(var81.getSubLevel()) == FilterLifeLevel.NORMAL) {
                                 break label103;
                              }

                              if (var146 instanceof HasRemoveYellowWater && !Intrinsics.areEqual(((HasRemoveYellowWater)var146).getYwrmEnabled(), Boxing.boxBoolean(true)) && Intrinsics.areEqual(var81.getSubType(), "REFRESHER")) {
                                 var45 = null;
                                 break label104;
                              }
                           }

                           var45 = var81;
                           if (var146 != null) {
                              var45 = var81;
                              if (var124.shouldReplace(var146, var137)) {
                                 var45 = new NotificationMessage(var146, var81.getType(), var81.getSubType(), var81.getSubLevel());
                              }
                           }
                           break label104;
                        }

                        var45 = null;
                     }

                     if (var45 != null) {
                        var105.add(var45);
                     }
                  }

                  return (List)var105;
               }

               IndoorDatapoint var119 = (IndoorDatapoint)var15.next();
               DeviceHumidifier var155 = (Device)var119;
               if (var155 instanceof HasFanSpeed && DeviceKt.hasAirFilter(var155)) {
                  Integer var36 = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(var155);
                  if (var36 != null) {
                     var2 = ((Number)var36).intValue();
                     DeviceManager var134 = var19.getDeviceManager();
                     String var96 = var155.getUid();
                     DeviceFilterType var37 = DeviceFilterType.FILTER;
                     this.L$0 = var13;
                     this.L$1 = var25;
                     this.L$2 = SpillingKt.nullOutSpilledVariable(var17);
                     this.L$3 = var19;
                     this.L$4 = var15;
                     this.L$5 = SpillingKt.nullOutSpilledVariable(var119);
                     this.L$6 = var155;
                     this.L$7 = null;
                     this.L$8 = null;
                     this.L$9 = null;
                     this.I$0 = var5;
                     this.I$1 = 0;
                     this.I$2 = var2;
                     this.I$3 = 0;
                     this.label = 1;
                     if (var134.executeFilterLifeForNotification(var96, var37, var2, this) == var24) {
                        break;
                     }
                  }
               }

               int var68 = 0;
               List var135 = var13;
               var13 = var13;
               var2 = var68;
               int var71 = var5;
               var1 = var155;
               Object var163 = var119;
               Iterator var97 = var15;
               NotificationsViewModel var182 = var19;
               Sequence var172 = var17;
               byte var57 = (byte)var58;
               if (var155 instanceof HasWick) {
                  DeviceManager var195 = var19.getDeviceManager();
                  String var194 = var155.getUid();
                  DeviceFilterType var191 = DeviceFilterType.WICK;
                  int var72 = ((HasWick)var155).getWickLifeLeft();
                  this.L$0 = var135;
                  this.L$1 = var25;
                  this.L$2 = SpillingKt.nullOutSpilledVariable(var17);
                  this.L$3 = var19;
                  this.L$4 = var15;
                  this.L$5 = SpillingKt.nullOutSpilledVariable(var119);
                  this.L$6 = var155;
                  this.L$7 = null;
                  this.L$8 = null;
                  this.L$9 = null;
                  this.I$0 = var5;
                  this.I$1 = var68;
                  this.label = 2;
                  var13 = var135;
                  var2 = var68;
                  var71 = var5;
                  var1 = var155;
                  var163 = var119;
                  var97 = var15;
                  var182 = var19;
                  var172 = var17;
                  var57 = (byte)var58;
                  if (var195.executeFilterLifeForNotification(var194, var191, var72, this) == var24) {
                     break;
                  }
               }

               Object var136 = var163;
               Device var129 = var1;
               Sequence var39 = var172;
               var15 = var97;
               NotificationsViewModel var99;
               if (var129 instanceof HasRemoveYellowWater) {
                  HasRemoveYellowWater var98 = (HasRemoveYellowWater)var129;
                  if (Intrinsics.areEqual(var98.getYwrmEnabled(), Boxing.boxBoolean(true))) {
                     DeviceManager var144 = var182.getDeviceManager();
                     String var120 = var129.getUid();
                     DeviceFilterType var156 = DeviceFilterType.REFRESHER;
                     var68 = var98.getRefresherLifeLeft();
                     this.L$0 = var13;
                     this.L$1 = var25;
                     this.L$2 = SpillingKt.nullOutSpilledVariable(var172);
                     this.L$3 = var182;
                     this.L$4 = var15;
                     this.L$5 = SpillingKt.nullOutSpilledVariable(var163);
                     this.L$6 = var129;
                     this.L$7 = null;
                     this.L$8 = null;
                     this.L$9 = null;
                     this.I$0 = var71;
                     this.I$1 = var2;
                     this.label = 3;
                     var5 = var2;
                     var99 = var182;
                     var2 = var57;
                     if (var144.executeFilterLifeForNotification(var120, var156, var68, this) == var24) {
                        break;
                     }
                  } else {
                     var5 = var2;
                     var99 = var182;
                     var2 = var57;
                  }
               } else {
                  var5 = var2;
                  var99 = var182;
                  var2 = var57;
               }

               if (var129 instanceof DeviceHumidifier) {
                  var155 = (DeviceHumidifier)var129;
                  var119 = var155.getLatestSensorDatapoint();
                  Float var145;
                  if (var119 != null) {
                     var145 = var119.getHum();
                  } else {
                     var145 = null;
                  }

                  AqiHumLevel var122;
                  if (var145 != null) {
                     var122 = AqiHumLevel.Companion.fromHumValue(var145);
                  } else {
                     var122 = null;
                  }

                  Pair var164 = (Pair)var99.getAqiHumLevelMap().get(var155.getUid());
                  long var78 = System.currentTimeMillis();
                  if (var164 != null) {
                     if (var164.getFirst() == var122) {
                        Prefs var192 = var99.getPrefs();
                        Integer var173 = Boxing.boxInt(var2);
                        PreferencesHelper var183 = PreferencesHelper.INSTANCE;
                        PrefsBackend var193 = var192.getBackend();
                        long var75 = ((Number)var183.get(var193, "KEY_NOTIFICATION_AQI_INTERMITTENT", var173, Reflection.getOrCreateKotlinClass(Integer.class))).longValue() * 1000L;
                        List var40;
                        if (var78 - ((Number)var164.getSecond()).longValue() > var75) {
                           DeviceManager var174 = var99.getDeviceManager();
                           String var184 = var155.getUid();
                           AqiHumLevel var158;
                           if (var122 == null) {
                              var158 = AqiHumLevel.IDEAL;
                           } else {
                              var158 = var122;
                           }

                           this.L$0 = var13;
                           this.L$1 = var25;
                           this.L$2 = SpillingKt.nullOutSpilledVariable(var39);
                           this.L$3 = var99;
                           this.L$4 = var15;
                           this.L$5 = SpillingKt.nullOutSpilledVariable(var136);
                           this.L$6 = SpillingKt.nullOutSpilledVariable(var129);
                           this.L$7 = SpillingKt.nullOutSpilledVariable(var145);
                           this.L$8 = SpillingKt.nullOutSpilledVariable(var122);
                           this.L$9 = SpillingKt.nullOutSpilledVariable(var164);
                           this.I$0 = var71;
                           this.I$1 = var5;
                           this.J$0 = var78;
                           this.J$1 = var75;
                           this.label = 4;
                           if (var174.executeHumForNotification(var184, var158, this) == var24) {
                              break;
                           }

                           NotificationsViewModel var123 = var99;
                           Sequence var100 = var39;
                           var40 = var13;
                           var17 = var100;
                           var19 = var123;
                        } else {
                           var19 = var99;
                           var17 = var39;
                           var40 = var13;
                        }

                        var13 = var40;
                        var5 = var71;
                        var58 = var2;
                     } else {
                        ((Map)var99.getAqiHumLevelMap()).put(var155.getUid(), new Pair(var122, Boxing.boxLong(var78)));
                        var19 = var99;
                        var17 = var172;
                        var13 = var13;
                        var5 = var71;
                        var58 = var2;
                     }
                  } else {
                     ((Map)var99.getAqiHumLevelMap()).put(var155.getUid(), new Pair(var122, Boxing.boxLong(var78)));
                     var19 = var99;
                     var17 = var172;
                     var13 = var13;
                     var5 = var71;
                     var58 = var2;
                  }
               } else {
                  var19 = var99;
                  var17 = var172;
                  var13 = var13;
                  var5 = var71;
                  var58 = var2;
               }
            }

            return var24;
         }

         // $FF: synthetic class
         @Metadata(
            k = 3,
            mv = {2, 2, 0},
            xi = 48
         )
         public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;

            static {
               int[] var0 = new int[NotificationMsgType.values().length];

               try {
                  var0[NotificationMsgType.FILTER_LIFE.ordinal()] = 1;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[NotificationMsgType.AQI.ordinal()] = 2;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var0;
            }
         }
      })), this.getCoroutineContext().plus((CoroutineContext)Dispatchers.getIO()), 0L, 2, (Object)null);
   }

   public final MutableLiveData getNotificationsNum() {
      return this.notificationsNum;
   }
}
