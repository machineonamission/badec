package com.blueair.android.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCaller;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.adapter.DrawerListAdapter;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.adapter.NotificationMsgAdapter;
import com.blueair.android.databinding.ActivityHomeBinding;
import com.blueair.android.dialog.SettingsDialogFragment;
import com.blueair.android.fragment.IndoorFragment;
import com.blueair.android.util.AqiAnimationBackgroundKt;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.android.viewmodel.NotificationsViewModel;
import com.blueair.antifake.dialog.AntiFakeActionDialogFragment;
import com.blueair.core.BuildEnvironment;
import com.blueair.core.BuildVariant;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.ChinaPrivacy;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.SimpleEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.core.util.SkuConfigurationManager;
import com.blueair.login.ProfileActivity;
import com.blueair.push.JPushSdkService;
import com.blueair.push.NotificationPermissionManager;
import com.blueair.push.NotificationService;
import com.blueair.sdk.GooglePlayAppUpdateSdk;
import com.blueair.sdk.KlaviyoSdk;
import com.blueair.viewcore.activity.Actions;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.utils.CustomStackLayoutManager;
import com.google.android.material.R.id;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import com.google.android.material.navigation.NavigationView;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.internal.CardStackSetting;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
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
   d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001MB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0014J\b\u00109\u001a\u000206H\u0002J\b\u0010:\u001a\u000206H\u0002J\u0010\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020!H\u0002J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\b\u0010?\u001a\u000206H\u0014J\b\u0010@\u001a\u000206H\u0014J\b\u0010A\u001a\u000206H\u0003J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\"\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020!2\u0006\u0010H\u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010JH\u0015J\u0010\u0010K\u001a\u0002062\u0006\u0010L\u001a\u00020JH\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R-\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020+0*0)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u000e\u001a\u0004\b2\u00103¨\u0006N"},
   d2 = {"Lcom/blueair/android/activity/HomeActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "notificationService", "Lcom/blueair/push/NotificationService;", "getNotificationService", "()Lcom/blueair/push/NotificationService;", "notificationService$delegate", "Lkotlin/Lazy;", "jpushService", "Lcom/blueair/push/JPushSdkService;", "getJpushService", "()Lcom/blueair/push/JPushSdkService;", "jpushService$delegate", "homeDataBinding", "Lcom/blueair/android/databinding/ActivityHomeBinding;", "viewModel", "Lcom/blueair/android/viewmodel/HomeViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/HomeViewModel;", "viewModel$delegate", "notificationsViewModel", "Lcom/blueair/android/viewmodel/NotificationsViewModel;", "getNotificationsViewModel", "()Lcom/blueair/android/viewmodel/NotificationsViewModel;", "notificationsViewModel$delegate", "versionClickCount", "", "cardAdapter", "Lcom/blueair/android/adapter/NotificationMsgAdapter;", "drawerListAdapter", "Lcom/blueair/android/adapter/DrawerListAdapter;", "appUpdateManager", "Lcom/blueair/sdk/GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager;", "clickNotificationPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "Lcom/blueair/android/adapter/NotificationItem;", "getClickNotificationPublisher", "()Lio/reactivex/subjects/PublishSubject;", "clickNotificationPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "notificationPermissionManager", "Lcom/blueair/push/NotificationPermissionManager;", "getNotificationPermissionManager", "()Lcom/blueair/push/NotificationPermissionManager;", "notificationPermissionManager$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "prepareCardStack", "observeViewModel", "computeAndUpdateCardPadding", "listSize", "showAddMenuDialog", "bindViewModel", "onStart", "onResume", "updateNavigationView", "onNavigationItemSelected", "", "item", "Landroid/view/MenuItem;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onNewIntent", "intent", "Companion", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class HomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeActivity.class, "notificationService", "getNotificationService()Lcom/blueair/push/NotificationService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeActivity.class, "jpushService", "getJpushService()Lcom/blueair/push/JPushSdkService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(HomeActivity.class, "clickNotificationPublisher", "getClickNotificationPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final int $stable = 8;
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int NAV_VIEW_HEADER_INDEX = 0;
   private static final int REQUEST_CODE_UPDATE = 4095;
   private GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager appUpdateManager;
   private NotificationMsgAdapter cardAdapter;
   private final LazyPublishSubject clickNotificationPublisher$delegate;
   private DrawerListAdapter drawerListAdapter;
   private ActivityHomeBinding homeDataBinding;
   private final Lazy jpushService$delegate;
   private final Lazy notificationPermissionManager$delegate;
   private final Lazy notificationService$delegate;
   private final Lazy notificationsViewModel$delegate;
   private final String screenName = "home";
   private int versionClickCount;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$0AzRNcm7s28xVjeVafQ9AHmZhcQ(HomeActivity var0, View var1) {
      updateNavigationView$lambda$20(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$3uJL2TOCmWMs_kz2RCr8XRpX_rs/* $FF was: $r8$lambda$3uJL2TOCmWMs_kz2RCr8XRpX-rs*/(HomeActivity var0, DialogInterface var1, int var2) {
      onActivityResult$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5_XkMet0Xqp_06RqA4YzAW_VsPg/* $FF was: $r8$lambda$5-XkMet0Xqp_06RqA4YzAW-VsPg*/(HomeActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$75iH5oE7J_WmUbTmPBTEmaaKRkI(HomeActivity var0, SimpleEvent var1) {
      return onResume$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$7INWVbS4KUnbgWJPJxExi51wpZM(MutableFloatState var0, Composer var1, int var2) {
      return observeViewModel$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$9FKv8TXLe941iNqcIGAH5twp01s(HomeActivity var0, View var1) {
      updateNavigationView$lambda$16(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$D6iC5lZF2kel6Num77bkPA_VExU(HomeActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MFsD_weNnY_HjznaWaosAmtvJBk/* $FF was: $r8$lambda$MFsD_weNnY-HjznaWaosAmtvJBk*/(HomeActivity var0, List var1) {
      return observeViewModel$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Os7I7Bj_J_wKihUQdQQM1R_Anzs/* $FF was: $r8$lambda$Os7I7Bj-J-wKihUQdQQM1R_Anzs*/(HomeActivity var0, View var1) {
      onCreate$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Rn1o9OBq5co5J8AJEX1Ce_btNM0(HomeActivity var0, String var1, boolean var2, Uri var3, String var4, String var5, String var6, Device var7) {
      return onNewIntent$lambda$28(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Scq0H5uHMkX5N2gePqJC2xYqJPA(LiveData var0, HomeActivity var1, Function1 var2, Device var3) {
      return onNewIntent$withDevice$lambda$24(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$VlycY9NvSvd7uJdwdlFG8sQ0_Qs/* $FF was: $r8$lambda$VlycY9NvSvd7uJdwdlFG8sQ0-Qs*/(HomeActivity var0, List var1) {
      return observeViewModel$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YCEn9Et5BK4oblicXkM4sG2DTGQ(HomeActivity var0, ApiResult var1) {
      return onCreate$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static NotificationPermissionManager $r8$lambda$_hlFlor59lmWhvipdJAQEPa8Wn4(HomeActivity var0) {
      return notificationPermissionManager_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_wjKvwWey0gvfb_ZSpg6GCoc8Ds(HomeActivity var0, boolean var1, Uri var2, String var3, String var4, String var5, Device var6) {
      return onNewIntent$lambda$30(var0, var1, var2, var3, var4, var5, var6);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ddq_54vgmrWWqAVCWR_DHOjbHRQ/* $FF was: $r8$lambda$ddq-54vgmrWWqAVCWR_DHOjbHRQ*/(HomeActivity var0, View var1) {
      updateNavigationView$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$h9tj7MBwbl5ocqKYnUFrtid_Cjw(HomeActivity var0, CustomDialog var1) {
      showAddMenuDialog$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$hpW_abK9_AfG3oXT7ZTzj5WrQdY/* $FF was: $r8$lambda$hpW-abK9_AfG3oXT7ZTzj5WrQdY*/(HomeActivity var0, String var1, boolean var2, Uri var3, String var4, String var5, String var6, Device var7) {
      return onNewIntent$lambda$27(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$qDyVT1BFqQFyFLR5Ye9gd576TLs(HomeActivity var0, String var1, Device var2) {
      return onNewIntent$lambda$26$lambda$25(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$t3wy5QO6Wf_8gzIXmDPgEF9x75k/* $FF was: $r8$lambda$t3wy5QO6Wf-8gzIXmDPgEF9x75k*/(HomeActivity var0) {
      onStart$lambda$14(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$u9Ym2beFKPfHHOMVR9W0gMBoKpA(HomeActivity var0, String var1, Bundle var2) {
      return updateNavigationView$lambda$20$lambda$19(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yLQqrq3jHM9r4peA_qNsZTXkR9o(HomeActivity var0, String var1, boolean var2, Uri var3, String var4, String var5, String var6, Device var7) {
      return onNewIntent$lambda$29(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zmFzUFJ7cosRLogr7sMzr1JysP0(HomeActivity var0, boolean var1) {
      return onCreate$lambda$5$lambda$4(var0, var1);
   }

   public HomeActivity() {
      DIAware var1 = this;
      JVMTypeToken var2 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var3 = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var2, NotificationService.class)), (Object)null);
      KProperty[] var5 = $$delegatedProperties;
      this.notificationService$delegate = var3.provideDelegate(this, var5[0]);
      JVMTypeToken var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.jpushService$delegate = DIAwareKt.Instance(var1, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, JPushSdkService.class)), (Object)null).provideDelegate(this, var5[1]);
      ComponentActivity var4 = (ComponentActivity)this;
      Function0 var6 = new Function0(var4) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new Function0(var4) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var6, new Function0((Function0)null, var4) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      var6 = new Function0(var4) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.notificationsViewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0(var4) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var6, new Function0((Function0)null, var4) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
      this.clickNotificationPublisher$delegate = new LazyPublishSubject();
      this.notificationPermissionManager$delegate = LazyKt.lazy(new HomeActivity$$ExternalSyntheticLambda10(this));
   }

   private final void bindViewModel() {
      ActivityHomeBinding var1 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_home);
      Intrinsics.checkNotNullExpressionValue(var1, "setContentView(...)");
      ActivityHomeBinding var2 = var1;
      this.homeDataBinding = var2;
      var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var1 = null;
      }

      var1.setHomeViewModel(this.getViewModel());
      var1.setLifecycleOwner((LifecycleOwner)this);
   }

   private final void computeAndUpdateCardPadding(int var1) {
      ActivityHomeBinding var9 = this.homeDataBinding;
      Object var8 = null;
      ActivityHomeBinding var7 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var7 = null;
      }

      RecyclerView.LayoutManager var13 = var7.csNotification.getLayoutManager();
      CardStackLayoutManager var14;
      if (var13 instanceof CardStackLayoutManager) {
         var14 = (CardStackLayoutManager)var13;
      } else {
         var14 = null;
      }

      float var2;
      label33: {
         if (var14 != null) {
            CardStackSetting var15 = var14.getCardStackSetting();
            if (var15 != null) {
               var2 = var15.translationInterval;
               break label33;
            }
         }

         var2 = 0.0F;
      }

      byte var6 = 1;
      if (var1 != 1) {
         if (var1 != 2) {
            var6 = 2;
         }
      } else {
         var6 = 0;
      }

      float var3 = (float)var6;
      float var5 = TypedValueCompat.dpToPx(var2, this.getResources().getDisplayMetrics());
      var9 = this.homeDataBinding;
      ActivityHomeBinding var16 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var16 = null;
      }

      float var4 = (float)var16.csNotification.getPaddingBottom();
      var2 = TypedValueCompat.dpToPx(32.0F, this.getResources().getDisplayMetrics());
      var3 = RangesKt.coerceAtLeast(var4 - var3 * var5, 0.0F);
      var16 = this.homeDataBinding;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var16 = (ActivityHomeBinding)var8;
      }

      FrameLayout var18 = var16.outdoorContainer;
      Intrinsics.checkNotNullExpressionValue(var18, "outdoorContainer");
      View var19 = (View)var18;
      var1 = (int)(var2 - var3);
      var19.setPadding(var19.getPaddingLeft(), var1, var19.getPaddingRight(), var19.getPaddingBottom());
   }

   private final PublishSubject getClickNotificationPublisher() {
      return this.clickNotificationPublisher$delegate.getValue(this, $$delegatedProperties[2]);
   }

   private final JPushSdkService getJpushService() {
      return (JPushSdkService)this.jpushService$delegate.getValue();
   }

   private final NotificationPermissionManager getNotificationPermissionManager() {
      return (NotificationPermissionManager)this.notificationPermissionManager$delegate.getValue();
   }

   private final NotificationService getNotificationService() {
      return (NotificationService)this.notificationService$delegate.getValue();
   }

   private final NotificationsViewModel getNotificationsViewModel() {
      return (NotificationsViewModel)this.notificationsViewModel$delegate.getValue();
   }

   private final HomeViewModel getViewModel() {
      return (HomeViewModel)this.viewModel$delegate.getValue();
   }

   private static final NotificationPermissionManager notificationPermissionManager_delegate$lambda$0(HomeActivity var0) {
      return new NotificationPermissionManager((Context)var0, (ActivityResultCaller)var0, false, (Function0)null, 12, (DefaultConstructorMarker)null);
   }

   private final void observeViewModel() {
      LiveData var1 = this.getViewModel().getLiveDevices();
      LifecycleOwner var3 = (LifecycleOwner)this;
      var1.observe(var3, new Observer(new HomeActivity$$ExternalSyntheticLambda12(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      MutableFloatState var4 = PrimitiveSnapshotStateKt.mutableFloatStateOf(50.0F);
      ActivityHomeBinding var2 = this.homeDataBinding;
      ActivityHomeBinding var5 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var5 = null;
      }

      var5.aqiAnimationBackground.setContent((Function2)ComposableLambdaKt.composableLambdaInstance(-1996535943, true, new HomeActivity$$ExternalSyntheticLambda13(var4)));
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var3), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var4, (Continuation)null) {
         final MutableFloatState $aqiLiveValue;
         int label;
         final HomeActivity this$0;

         {
            this.this$0 = var1;
            this.$aqiLiveValue = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$aqiLiveValue, var2));
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
               Flow var5 = this.this$0.getViewModel().getFlowDevicesRating();
               FlowCollector var6 = new FlowCollector(this.$aqiLiveValue, this.this$0) {
                  final MutableFloatState $aqiLiveValue;
                  final HomeActivity this$0;

                  {
                     this.$aqiLiveValue = var1;
                     this.this$0 = var2;
                  }

                  public final Object emit(List var1, Continuation var2) {
                     boolean var9 = var1.isEmpty();
                     float var4 = 50.0F;
                     Pair var12;
                     if (var9) {
                        var12 = new Pair(Boxing.boxInt(-1), Boxing.boxFloat(50.0F));
                     } else {
                        Iterator var11 = ((Iterable)var1).iterator();
                        if (!var11.hasNext()) {
                           throw new NoSuchElementException();
                        }

                        Object var16 = var11.next();
                        Object var13;
                        if (!var11.hasNext()) {
                           var13 = var16;
                        } else {
                           int var6 = ((Number)((Pair)var16).getFirst()).intValue();

                           do {
                              Object var10 = var11.next();
                              int var8 = ((Number)((Pair)var10).getFirst()).intValue();
                              int var7 = var6;
                              var13 = var16;
                              if (var6 < var8) {
                                 var13 = var10;
                                 var7 = var8;
                              }

                              var6 = var7;
                              var16 = var13;
                           } while(var11.hasNext());
                        }

                        var12 = (Pair)var13;
                     }

                     int var20 = ((Number)var12.component1()).intValue();
                     float var3 = ((Number)var12.component2()).floatValue();
                     float var5 = 0.0F;
                     if (var3 < 0.0F) {
                        var3 = 50.0F;
                     } else {
                        var3 = 100.0F - var3;
                     }

                     MutableFloatState var14 = this.$aqiLiveValue;
                     if (var3 < 25.0F) {
                        var3 = var5;
                     } else if (var3 < 50.0F) {
                        var3 = 25.0F;
                     } else {
                        var5 = 75.0F;
                        if (var3 < 75.0F) {
                           var3 = var4;
                        } else if (var3 < 100.0F) {
                           var3 = var5;
                        } else {
                           var3 = 100.0F;
                        }
                     }

                     var14.setFloatValue(var3);
                     if (this.this$0.getViewModel().getLastRatingIndex() != var20) {
                        this.this$0.getViewModel().setLastRatingIndex(var20);
                        MutableLiveData var15 = this.this$0.getViewModel().getLvAirStateStringRes();
                        if (var20 == IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE.getRating()) {
                           var20 = com.blueair.viewcore.R.string.label_excellent_air;
                        } else if (var20 == IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE.getRating()) {
                           var20 = com.blueair.viewcore.R.string.state_good_air;
                        } else if (var20 == IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE.getRating()) {
                           var20 = com.blueair.viewcore.R.string.label_moderate_air;
                        } else if (var20 == IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE.getRating()) {
                           var20 = com.blueair.viewcore.R.string.state_poor_air;
                        } else if (var20 == IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE.getRating()) {
                           var20 = com.blueair.viewcore.R.string.state_verypoor_air;
                        } else {
                           var20 = com.blueair.viewcore.R.string.state_no_readings;
                        }

                        var15.setValue(Boxing.boxInt(var20));
                     }

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
      this.getNotificationsViewModel().getLvNotificationMsgs().observe(var3, new Observer(new HomeActivity$$ExternalSyntheticLambda14(this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
   }

   private static final Unit observeViewModel$lambda$10(MutableFloatState var0, Composer var1, int var2) {
      ComposerKt.sourceInformation(var1, "C252@11037L47:HomeActivity.kt#zdeadj");
      if ((var2 & 3) == 2 && var1.getSkipping()) {
         var1.skipToGroupEnd();
      } else {
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1996535943, var2, -1, "com.blueair.android.activity.HomeActivity.observeViewModel.<anonymous> (HomeActivity.kt:252)");
         }

         AqiAnimationBackgroundKt.AqiAnimationBackground(var0.getFloatValue(), var1, 0);
         if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$11(HomeActivity var0, List var1) {
      NotificationMsgAdapter var6 = var0.cardAdapter;
      Object var5 = null;
      NotificationMsgAdapter var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
         var4 = null;
      }

      Intrinsics.checkNotNull(var1);
      var4.setNewList(var1);
      int var3 = var1.size();
      Integer var7 = (Integer)var0.getViewModel().getDeviceNum().getValue();
      if (var7 == null || var3 != var7) {
         var0.getViewModel().getDeviceNum().setValue(var3);
      }

      ActivityHomeBinding var8 = var0.homeDataBinding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var8 = (ActivityHomeBinding)var5;
      }

      CardStackView var9 = var8.csNotification;
      Intrinsics.checkNotNullExpressionValue(var9, "csNotification");
      View var10 = (View)var9;
      byte var2;
      if (!((Collection)var1).isEmpty()) {
         var2 = 0;
      } else {
         var2 = 8;
      }

      var10.setVisibility(var2);
      var0.computeAndUpdateCardPadding(var3);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$9(HomeActivity var0, List var1) {
      boolean var3;
      label41: {
         label40: {
            Intrinsics.checkNotNull(var1);
            if (!((Collection)var1).isEmpty()) {
               Iterable var9 = (Iterable)var1;
               if (var9 instanceof Collection && ((Collection)var9).isEmpty()) {
                  break label40;
               }

               Iterator var10 = var9.iterator();

               do {
                  if (!var10.hasNext()) {
                     break label40;
                  }
               } while((Device)var10.next() instanceof DeviceMiniRestful);
            }

            var3 = 0;
            break label41;
         }

         var3 = 1;
      }

      ActivityHomeBinding var5 = var0.homeDataBinding;
      Object var4 = null;
      ActivityHomeBinding var11 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var11 = null;
      }

      ConstraintLayout var12 = var11.clHeader;
      Intrinsics.checkNotNullExpressionValue(var12, "clHeader");
      ViewExtensionsKt.show((View)var12, (boolean)(var3 ^ true));
      float var2;
      if (var3) {
         var2 = TypedValueCompat.dpToPx(8.0F, var0.getResources().getDisplayMetrics());
      } else {
         var2 = 0.0F;
      }

      ActivityHomeBinding var6 = var0.homeDataBinding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var6 = (ActivityHomeBinding)var4;
      }

      CardStackView var7 = var6.csNotification;
      Intrinsics.checkNotNullExpressionValue(var7, "csNotification");
      View var8 = (View)var7;
      var3 = MathKt.roundToInt(var2);
      var8.setPadding(var8.getPaddingLeft(), var3, var8.getPaddingRight(), var8.getPaddingBottom());
      return Unit.INSTANCE;
   }

   private static final void onActivityResult$lambda$22(HomeActivity var0, DialogInterface var1, int var2) {
      GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager var4 = var0.appUpdateManager;
      GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager var3 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
         var3 = null;
      }

      var3.checkInAppUpdate(4095);
   }

   private static final void onCreate$lambda$1(HomeActivity var0, View var1) {
      ActivityHomeBinding var3 = var0.homeDataBinding;
      Object var2 = null;
      ActivityHomeBinding var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var5 = null;
      }

      if (var5.drawerLayout.getDrawerLockMode(8388611) != 1) {
         ActivityHomeBinding var4 = var0.homeDataBinding;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            var4 = (ActivityHomeBinding)var2;
         }

         var4.drawerLayout.openDrawer(8388611);
      }

   }

   private static final void onCreate$lambda$2(HomeActivity var0, View var1) {
      int var2 = var0.versionClickCount + 1;
      var0.versionClickCount = var2;
      if (var2 >= 7) {
         var0.versionClickCount = 0;
         var0.startActivity(new Intent((Context)var0, DevSettingsActivity.class));
      }

   }

   private static final void onCreate$lambda$3(HomeActivity var0, View var1) {
      if (var0.getViewModel().isInAntiFakeRegion()) {
         var0.showAddMenuDialog();
      } else {
         Object var2 = var0.getSupportFragmentManager().getFragments().get(1);
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
         ((IndoorFragment)var2).connectDevice();
      }
   }

   private static final Unit onCreate$lambda$5(HomeActivity var0, ApiResult var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().checkChinaPrivacyUpdate(new HomeActivity$$ExternalSyntheticLambda1(var0));
      return Unit.INSTANCE;
   }

   private static final Unit onCreate$lambda$5$lambda$4(HomeActivity var0, boolean var1) {
      if (var1) {
         ChinaPrivacy var2 = SkuConfigurationManager.INSTANCE.getChinaPrivacy();
         var0.startActivity(Actions.INSTANCE.openChinaPrivacyPolicyIntent((Context)var0, var2));
         var0.finish();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onNewIntent$lambda$26$lambda$25(HomeActivity var0, String var1, Device var2) {
      Intrinsics.checkNotNullParameter(var2, "device");
      Object var3 = var0.getSupportFragmentManager().getFragments().get(1);
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
      ((IndoorFragment)var3).openDeviceDetails(var2, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onNewIntent$lambda$27(HomeActivity var0, String var1, boolean var2, Uri var3, String var4, String var5, String var6, Device var7) {
      Intrinsics.checkNotNullParameter(var7, "device");
      onNewIntent$sendAnalyticsEvent(var2, var0, var3, var4, var5, var6, var7);
      Object var8 = var0.getSupportFragmentManager().getFragments().get(1);
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
      ((IndoorFragment)var8).openDeviceDetails(var7, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onNewIntent$lambda$28(HomeActivity var0, String var1, boolean var2, Uri var3, String var4, String var5, String var6, Device var7) {
      Intrinsics.checkNotNullParameter(var7, "device");
      onNewIntent$sendAnalyticsEvent(var2, var0, var3, var4, var5, var6, var7);
      Object var8 = var0.getSupportFragmentManager().getFragments().get(1);
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
      ((IndoorFragment)var8).openDeviceDetails(var7, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onNewIntent$lambda$29(HomeActivity var0, String var1, boolean var2, Uri var3, String var4, String var5, String var6, Device var7) {
      Intrinsics.checkNotNullParameter(var7, "device");
      onNewIntent$sendAnalyticsEvent(var2, var0, var3, var4, var5, var6, var7);
      Object var8 = var0.getSupportFragmentManager().getFragments().get(1);
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
      ((IndoorFragment)var8).openDeviceDetails(var7, var1);
      return Unit.INSTANCE;
   }

   private static final Unit onNewIntent$lambda$30(HomeActivity var0, boolean var1, Uri var2, String var3, String var4, String var5, Device var6) {
      Intrinsics.checkNotNullParameter(var6, "device");
      onNewIntent$sendAnalyticsEvent(var1, var0, var2, var3, var4, var5, var6);
      Object var7 = var0.getSupportFragmentManager().getFragments().get(1);
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
      ((IndoorFragment)var7).openDeviceDetails(var6, "device_details");
      return Unit.INSTANCE;
   }

   private static final void onNewIntent$sendAnalyticsEvent(boolean var0, HomeActivity var1, Uri var2, String var3, String var4, String var5, Device var6) {
      if (var0) {
         AnalyticsService var7 = var1.getAnalytics();
         String var8 = var2.toString();
         Intrinsics.checkNotNullExpressionValue(var8, "toString(...)");
         var7.event(new AnalyticEvent.KlaviyoEvent.Click(var8, var3, var4, var5, var6));
      }
   }

   private static final void onNewIntent$withDevice(HomeActivity var0, String var1, Function1 var2) {
      LiveData var3 = var0.getViewModel().getDevice(var1);
      LiveDataExtensionsKt.observeNonNull(var3, (LifecycleOwner)var0, new HomeActivity$$ExternalSyntheticLambda5(var3, var0, var2));
   }

   private static final Unit onNewIntent$withDevice$lambda$24(LiveData var0, HomeActivity var1, Function1 var2, Device var3) {
      if (var3 != null) {
         var2.invoke(var3);
      }

      var0.removeObservers((LifecycleOwner)var1);
      return Unit.INSTANCE;
   }

   private static final Unit onResume$lambda$15(HomeActivity var0, SimpleEvent var1) {
      NotificationItem var7 = (NotificationItem)var1.getData();
      String var10 = (String)var1.getEventType();
      int var2 = var10.hashCode();
      boolean var3 = false;
      boolean var4 = false;
      Object var6 = null;
      Object var5 = null;
      switch (var2) {
         case 146184104:
            if (var10.equals("event_replace_filter")) {
               var0.getNotificationsViewModel().executeReplaceFilterEvent(var7, (FragmentActivity)var0);
            }
            break;
         case 434821139:
            if (var10.equals("event_close")) {
               NotificationMsgAdapter var16 = var0.cardAdapter;
               NotificationMsgAdapter var13 = var16;
               if (var16 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                  var13 = null;
               }

               var13.remove(var7);
               NotificationsViewModel var14 = var0.getNotificationsViewModel();
               NotificationMsgAdapter var9 = var0.cardAdapter;
               if (var9 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                  var9 = (NotificationMsgAdapter)var6;
               }

               if (var9.getItemCount() > 0) {
                  var3 = true;
               }

               var14.dismissMsg(var7, var3);
            }
            break;
         case 529760468:
            if (var10.equals("event_adjust")) {
               NotificationMsgAdapter var17 = var0.cardAdapter;
               NotificationMsgAdapter var11 = var17;
               if (var17 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                  var11 = null;
               }

               var11.remove(var7);
               NotificationsViewModel var18 = var0.getNotificationsViewModel();
               var11 = var0.cardAdapter;
               if (var11 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                  var11 = (NotificationMsgAdapter)var5;
               }

               var3 = var4;
               if (var11.getItemCount() > 0) {
                  var3 = true;
               }

               var18.dismissMsg(var7, var3);
               Object var8 = var0.getSupportFragmentManager().getFragments().get(1);
               Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
               ((IndoorFragment)var8).openDeviceDetails(var7.getMessage().getDevice(), "device_details");
            }
            break;
         case 1336284116:
            if (var10.equals("event_content")) {
               var0.startActivity(new Intent((Context)var0, NotificationsActivity.class));
            }
            break;
         case 1982146070:
            if (var10.equals("event_buy_filter")) {
               var0.getNotificationsViewModel().executeBuyFilterEvent(var7, (FragmentActivity)var0);
            }
      }

      return Unit.INSTANCE;
   }

   private static final void onStart$lambda$14(HomeActivity var0) {
      var0.getNotificationPermissionManager().checkAndRequest();
   }

   private final void prepareCardStack() {
      ActivityHomeBinding var3 = this.homeDataBinding;
      Object var2 = null;
      ActivityHomeBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var1 = null;
      }

      CardStackView var5 = var1.csNotification;
      Intrinsics.checkNotNullExpressionValue(var5, "csNotification");
      CustomStackLayoutManager var4 = new CustomStackLayoutManager(var5, new CardStackListener(this) {
         final HomeActivity this$0;

         {
            this.this$0 = var1;
         }

         public void onCardAppeared(View var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "view");
            ActivityHomeBinding var4 = this.this$0.homeDataBinding;
            Object var3 = null;
            ActivityHomeBinding var5 = var4;
            if (var4 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
               var5 = null;
            }

            RecyclerView.LayoutManager var7 = var5.csNotification.getLayoutManager();
            CustomStackLayoutManager var6 = (CustomStackLayoutManager)var3;
            if (var7 instanceof CustomStackLayoutManager) {
               var6 = (CustomStackLayoutManager)var7;
            }

            if (var6 != null) {
               var6.setSizeFromTopView();
            }

         }

         public void onCardCanceled() {
         }

         public void onCardDisappeared(View var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "view");
         }

         public void onCardDragging(Direction var1, float var2) {
            Intrinsics.checkNotNullParameter(var1, "direction");
         }

         public void onCardRewound() {
         }

         public void onCardSwiped(Direction var1) {
            Intrinsics.checkNotNullParameter(var1, "direction");
            NotificationMsgAdapter var2 = this.this$0.cardAdapter;
            NotificationMsgAdapter var5 = var2;
            if (var2 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
               var5 = null;
            }

            NotificationItem var3 = var5.getItem(0);
            if (var3 != null) {
               HomeActivity var4 = this.this$0;
               var2 = var4.cardAdapter;
               var5 = var2;
               if (var2 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                  var5 = null;
               }

               var5.removeAt(0);
               NotificationsViewModel.dismissMsg$default(var4.getNotificationsViewModel(), var3, false, 2, (Object)null);
            }

         }
      }, false, 4, (DefaultConstructorMarker)null);
      CardStackSetting var6 = var4.getCardStackSetting();
      var6.canScrollVertical = false;
      var6.stackFrom = StackFrom.Bottom;
      var3 = this.homeDataBinding;
      ActivityHomeBinding var7 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var7 = null;
      }

      var7.csNotification.setLayoutManager((RecyclerView.LayoutManager)var4);
      var3 = this.homeDataBinding;
      var7 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var7 = null;
      }

      CardStackView var12 = var7.csNotification;
      NotificationMsgAdapter var9 = this.cardAdapter;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
         var9 = (NotificationMsgAdapter)var2;
      }

      var12.setAdapter(var9);
   }

   private final void showAddMenuDialog() {
      ActivityHomeBinding var3 = this.homeDataBinding;
      Object var2 = null;
      ActivityHomeBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var1 = null;
      }

      var1.btnAdd.setSelected(true);
      CustomDialog var5 = CustomDialog.show(new OnBindView(this, R.layout.dialog_layout_add_action) {
         final HomeActivity this$0;

         // $FF: synthetic method
         public static void $r8$lambda$nCLX_zgsGo4oHqxzEpQDg4LqE7A/* $FF was: $r8$lambda$nCLX-zgsGo4oHqxzEpQDg4LqE7A*/(CustomDialog var0, HomeActivity var1, View var2) {
            onBind$lambda$2(var0, var1, var2);
         }

         // $FF: synthetic method
         public static void $r8$lambda$sXSRHnxnsKSmHbDPq_9dGrNsvYg(CustomDialog var0, HomeActivity var1, View var2) {
            onBind$lambda$1(var0, var1, var2);
         }

         {
            this.this$0 = var1;
         }

         private static final void onBind$lambda$1(CustomDialog var0, HomeActivity var1, View var2) {
            var0.dismiss();
            FragmentManager var3 = var1.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("AntiFakeActionDialogFragment", "getSimpleName(...)");
            if (!(var3.findFragmentByTag("AntiFakeActionDialogFragment") instanceof AntiFakeActionDialogFragment) && !var3.isStateSaved()) {
               ((DialogFragment)AntiFakeActionDialogFragment.Companion.newInstance()).show(var3, "AntiFakeActionDialogFragment");
            }

         }

         private static final void onBind$lambda$2(CustomDialog var0, HomeActivity var1, View var2) {
            var0.dismiss();
            Object var3 = var1.getSupportFragmentManager().getFragments().get(1);
            Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.android.fragment.IndoorFragment");
            ((IndoorFragment)var3).connectDevice();
         }

         public void onBind(CustomDialog var1, View var2) {
            Intrinsics.checkNotNullParameter(var1, "dialog");
            Intrinsics.checkNotNullParameter(var2, "v");
            View var4 = var2.findViewById(R.id.tv_addProduct);
            var2 = var2.findViewById(R.id.tv_scanFilter);
            Intrinsics.checkNotNull(var2);
            byte var3;
            if (this.this$0.getViewModel().isInAntiFakeRegion()) {
               var3 = 0;
            } else {
               var3 = 8;
            }

            var2.setVisibility(var3);
            var2.setOnClickListener(new HomeActivity$showAddMenuDialog$1$$ExternalSyntheticLambda0(var1, this.this$0));
            var4.setOnClickListener(new HomeActivity$showAddMenuDialog$1$$ExternalSyntheticLambda1(var1, this.this$0));
         }
      }).onDismiss(new HomeActivity$$ExternalSyntheticLambda2(this));
      var1 = this.homeDataBinding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var1 = (ActivityHomeBinding)var2;
      }

      var5.setAlignBaseViewGravity((View)var1.btnAdd, 81);
   }

   private static final void showAddMenuDialog$lambda$12(HomeActivity var0, CustomDialog var1) {
      ActivityHomeBinding var3 = var0.homeDataBinding;
      ActivityHomeBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var2 = null;
      }

      var2.btnAdd.setSelected(false);
   }

   private final void updateNavigationView() {
      Flow var3 = this.getViewModel().getSmartIntegrationsAvailable();
      Object var4 = null;
      FlowKt.launchIn(FlowKt.onEach(var3, new Function2(this, (Continuation)null) {
         boolean Z$0;
         int label;
         final HomeActivity this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.Z$0 = (Boolean)var1;
            return (Continuation)var3;
         }

         public final Object invoke(boolean var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var2 = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               DrawerListAdapter var3 = this.this$0.drawerListAdapter;
               DrawerListAdapter var4 = var3;
               if (var3 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("drawerListAdapter");
                  var4 = null;
               }

               var4.updateMenu(R.id.action_integrations, var2);
               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }), (CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this));
      DrawerListAdapter var5 = this.drawerListAdapter;
      DrawerListAdapter var6 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("drawerListAdapter");
         var6 = null;
      }

      int var1 = R.id.action_dev_settings;
      boolean var2;
      if (BuildEnvironment.INSTANCE.getVariant() == BuildVariant.DEBUG) {
         var2 = true;
      } else {
         var2 = false;
      }

      var6.updateMenu(var1, var2);
      ActivityHomeBinding var10 = this.homeDataBinding;
      ActivityHomeBinding var7 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var7 = null;
      }

      var7.drawerCloseView.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda7(this));
      var10 = this.homeDataBinding;
      var7 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var7 = null;
      }

      var7.llDrawerHeader.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda8(this));
      var7 = this.homeDataBinding;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var7 = (ActivityHomeBinding)var4;
      }

      var7.drawerSignin.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda9(this));
   }

   private static final void updateNavigationView$lambda$16(HomeActivity var0, View var1) {
      ActivityHomeBinding var3 = var0.homeDataBinding;
      ActivityHomeBinding var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var2 = null;
      }

      var2.drawerLayout.closeDrawer(8388611);
   }

   private static final void updateNavigationView$lambda$17(HomeActivity var0, View var1) {
      ActivityHomeBinding var2 = var0.homeDataBinding;
      ActivityHomeBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var3 = null;
      }

      var3.drawerLayout.closeDrawer(8388611);
      var0.startActivity(InfoActivity.Companion.gotoBlueairStore((Activity)var0));
   }

   private static final void updateNavigationView$lambda$20(HomeActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
      DialogFragment var3;
      if (!(var2.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var2.isStateSaved()) {
         var3 = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, com.blueair.viewcore.R.string.action_log_out, com.blueair.viewcore.R.string.logout_message, com.blueair.viewcore.R.string.yes, com.blueair.viewcore.R.string.no, false, false, false, (String[])null, 240, (Object)null);
         ((DialogFragment)var3).show(var2, "ConfirmationDialogCentered");
      } else {
         var3 = null;
      }

      var3 = var3;
      if (var3 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var3, "CONFIRMATION", new HomeActivity$$ExternalSyntheticLambda17(var0));
      }

   }

   private static final Unit updateNavigationView$lambda$20$lambda$19(HomeActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.getViewModel().logout();
         var0.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, (Context)var0, false, 2, (Object)null));
         var0.finish();
      }

      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   @Deprecated(
      message = "Deprecated in Java"
   )
   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if (var1 == 4095 && var2 != -1 && !this.getViewModel().isAppVersionSupported()) {
         (new AlertDialog.Builder((Context)this)).setTitle(com.blueair.viewcore.R.string.update_the_app_title).setMessage(com.blueair.viewcore.R.string.update_the_app_msg).setPositiveButton(17039370, new HomeActivity$$ExternalSyntheticLambda4(this)).setCancelable(false).show();
      }

   }

   protected void onCreate(Bundle var1) {
      SplashScreen.Companion var3 = SplashScreen.Companion;
      Activity var6 = (Activity)this;
      var3.installSplashScreen(var6);
      super.onCreate(var1);
      BaseLokaliseActivity var7 = this;
      Object var22 = null;
      BaseLokaliseActivity.immersiveStatusBar$default(var7, false, 1, (Object)null);
      this.setStatusMode(true);
      this.bindViewModel();
      View var8 = this.findViewById(id.design_navigation_view);
      if (var8 != null) {
         var8.setFocusable(false);
      }

      var8 = this.findViewById(R.id.rv_drawer);
      Intrinsics.checkNotNullExpressionValue(var8, "findViewById(...)");
      RecyclerView var5 = (RecyclerView)var8;
      LifecycleOwner var10 = (LifecycleOwner)this;
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var10), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         int label;
         final HomeActivity this$0;

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
               LifecycleOwner var5 = (LifecycleOwner)this.this$0;
               Lifecycle.State var6 = State.RESUMED;
               Function2 var7 = new Function2(this.this$0, (Continuation)null) {
                  private Object L$0;
                  int label;
                  final HomeActivity this$0;

                  {
                     this.this$0 = var1;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                     var3.L$0 = var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     CoroutineScope var2 = (CoroutineScope)this.L$0;
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label == 0) {
                        ResultKt.throwOnFailure(var1);
                        FlowKt.launchIn(FlowKt.onEach((Flow)this.this$0.getViewModel().isUserSignedIn(), new Function2(this.this$0, (Continuation)null) {
                           int label;
                           final HomeActivity this$0;

                           {
                              this.this$0 = var1;
                           }

                           public final Continuation create(Object var1, Continuation var2) {
                              return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                           }

                           public final Object invoke(boolean var1, Continuation var2) {
                              return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                           }

                           public final Object invokeSuspend(Object var1) {
                              IntrinsicsKt.getCOROUTINE_SUSPENDED();
                              if (this.label == 0) {
                                 ResultKt.throwOnFailure(var1);
                                 this.this$0.updateNavigationView();
                                 return Unit.INSTANCE;
                              } else {
                                 throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                              }
                           }
                        }), var2);
                        return Unit.INSTANCE;
                     } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }
                  }
               };
               Continuation var4 = (Continuation)this;
               this.label = 1;
               if (RepeatOnLifecycleKt.repeatOnLifecycle(var5, var6, var7, var4) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      FlowKt.launchIn(FlowKt.onEach((Flow)this.getViewModel().isUserSignedIn(), new Function2(this, (Continuation)null) {
         boolean Z$0;
         int label;
         final HomeActivity this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.Z$0 = (Boolean)var1;
            return (Continuation)var3;
         }

         public final Object invoke(boolean var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var2 = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               if (!var2) {
                  this.this$0.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, (Context)this.this$0, false, 2, (Object)null));
                  this.this$0.finish();
               }

               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      }), (CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var10));
      ActivityHomeBinding var4 = this.homeDataBinding;
      ActivityHomeBinding var11 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var11 = null;
      }

      var11.btnMenu.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda0(this));
      var4 = this.homeDataBinding;
      var11 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var11 = null;
      }

      TextView var24 = var11.build;
      StringBuilder var13 = new StringBuilder();
      var13.append(this.getString(com.blueair.viewcore.R.string.menu_app_version));
      var13.append(" 4.5.2 (2366)");
      var24.setText((CharSequence)var13.toString());
      ActivityHomeBinding var25 = this.homeDataBinding;
      ActivityHomeBinding var14 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var14 = null;
      }

      var14.build.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda11(this));
      var25 = this.homeDataBinding;
      var14 = var25;
      if (var25 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var14 = null;
      }

      var14.btnAdd.setOnClickListener(new HomeActivity$$ExternalSyntheticLambda15(this));
      this.getJpushService().register(this.getNotificationService().getUseJPush());
      GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager var27 = GooglePlayAppUpdateSdk.INSTANCE.createAppUpdateManager(var6);
      this.appUpdateManager = var27;
      GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager var16 = var27;
      if (var27 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
         var16 = null;
      }

      var16.checkInAppUpdate(4095);
      this.getViewModel().updateTimezoneList();
      this.getViewModel().updateSkuConfiguration(new HomeActivity$$ExternalSyntheticLambda16(this));
      this.getViewModel().checkUserInfoCollections();
      this.cardAdapter = new NotificationMsgAdapter(this.getNotificationsViewModel().getLocationService(), this.getClickNotificationPublisher());
      this.prepareCardStack();
      this.observeViewModel();
      Intent var17 = this.getIntent();
      Intrinsics.checkNotNullExpressionValue(var17, "getIntent(...)");
      this.onNewIntent(var17);
      Context var28 = (Context)this;
      MenuBuilder var29 = new MenuBuilder(var28);
      MenuInflater var18 = this.getMenuInflater();
      int var2 = R.menu.home_drawer;
      Menu var30 = (Menu)var29;
      var18.inflate(var2, var30);
      DrawerListAdapter var19 = new DrawerListAdapter(var30, this);
      this.drawerListAdapter = var19;
      var5.setAdapter(var19);
      MaterialDividerItemDecoration var20 = new MaterialDividerItemDecoration(var28, 1);
      var20.setDividerColorResource(var28, com.blueair.viewcore.R.color.white_10);
      var20.setLastItemDecorated(false);
      var5.addItemDecoration((RecyclerView.ItemDecoration)var20);
      ActivityHomeBinding var21 = this.homeDataBinding;
      if (var21 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var21 = (ActivityHomeBinding)var22;
      }

      var21.drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener(this) {
         private boolean opened;
         final HomeActivity this$0;

         {
            this.this$0 = var1;
         }

         public final boolean getOpened() {
            return this.opened;
         }

         public void onDrawerClosed(View var1) {
            Intrinsics.checkNotNullParameter(var1, "drawerView");
            this.opened = false;
         }

         public void onDrawerOpened(View var1) {
            Intrinsics.checkNotNullParameter(var1, "drawerView");
            this.opened = true;
            this.this$0.getAnalytics().event(new AnalyticEvent.ScreenViewEvent("side_menu", "DrawerLayout"));
         }

         public void onDrawerSlide(View var1, float var2) {
            Intrinsics.checkNotNullParameter(var1, "drawerView");
         }

         public void onDrawerStateChanged(int var1) {
            if (var1 == 2) {
               this.this$0.setStatusMode(this.opened);
            }

         }

         public final void setOpened(boolean var1) {
            this.opened = var1;
         }
      });
      if (this.getIntent().getBooleanExtra("action_register", false)) {
         ConnectDeviceGuideActivity.Companion.launch(var28);
      }

   }

   public boolean onNavigationItemSelected(MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "item");
      int var2 = var1.getItemId();
      if (var2 == R.id.action_signin) {
         if ((Boolean)this.getViewModel().isUserSignedIn().getValue()) {
            this.getViewModel().logout();
         }
      } else if (var2 == R.id.action_profile) {
         this.startActivity(new Intent((Context)this, ProfileActivity.class));
      } else if (var2 == R.id.action_policies) {
         InfoListActivity.Companion.launch((Context)this, InfoListActivity.InfoType.POLICIES);
      } else if (var2 == R.id.action_integrations) {
         InfoActivity.Companion var5 = InfoActivity.Companion;
         Activity var4 = (Activity)this;
         String var3 = this.getString(com.blueair.viewcore.R.string.voice_assistants);
         Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
         this.startActivity(var5.gotoIntegrations(var4, var3));
      } else if (var2 == R.id.action_support) {
         InfoActivity.Companion var9 = InfoActivity.Companion;
         Activity var6 = (Activity)this;
         String var11 = this.getString(com.blueair.viewcore.R.string.action_support);
         Intrinsics.checkNotNullExpressionValue(var11, "getString(...)");
         this.startActivity(var9.gotoSupport(var6, var11));
      } else if (var2 == R.id.action_dev_settings) {
         this.startActivity(new Intent((Context)this, DevSettingsActivity.class));
      } else if (var2 == R.id.action_settings) {
         FragmentManager var7 = this.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var7, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("SettingsDialogFragment", "getSimpleName(...)");
         if (!(var7.findFragmentByTag("SettingsDialogFragment") instanceof SettingsDialogFragment) && !var7.isStateSaved()) {
            ((DialogFragment)SettingsDialogFragment.Companion.newInstance()).show(var7, "SettingsDialogFragment");
         }
      }

      ActivityHomeBinding var10 = this.homeDataBinding;
      ActivityHomeBinding var8 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
         var8 = null;
      }

      var8.drawerLayout.closeDrawer(8388611);
      return true;
   }

   protected void onNewIntent(Intent var1) {
      boolean var2;
      Uri var3;
      String var7;
      String var20;
      String var21;
      label125: {
         label124: {
            label123: {
               Intrinsics.checkNotNullParameter(var1, "intent");
               super.onNewIntent(var1);
               var3 = var1.getData();
               if (var3 == null) {
                  Bundle var18 = var1.getExtras();
                  if (var18 != null) {
                     String var8 = var18.getString("device_id");
                     if (var8 != null) {
                        String var19 = var18.getString("action_type");
                        if (var19 != null) {
                           onNewIntent$withDevice(this, var8, new HomeActivity$$ExternalSyntheticLambda18(this, var19));
                           return;
                        }
                     }
                  }
               } else {
                  Timber.Forest var5 = Timber.Forest;
                  StringBuilder var4 = new StringBuilder("onNewIntent: uri=\"");
                  var4.append(var3);
                  var4.append('"');
                  var5.d(var4.toString(), new Object[0]);
                  if (Intrinsics.areEqual(var3.getScheme(), "blueair")) {
                     if (var3.getQueryParameter("source") == null) {
                        var2 = true;
                     } else {
                        var2 = false;
                     }

                     if (var2) {
                        KlaviyoSdk.INSTANCE.handlePush(var1);
                     }

                     var21 = var3.getHost();
                     if (var21 != null) {
                        var20 = var3.getQueryParameter("type");
                        if (var20 != null) {
                           var6 = var3.getQueryParameter("action");
                           if (var6 != null) {
                              switch (var6) {
                                 case "view_wick_page":
                                    var7 = var3.getQueryParameter("did");
                                    if (var7 != null) {
                                       String var16 = var3.getQueryParameter("target");
                                       if (var16 != null) {
                                          if (Intrinsics.areEqual(var16, "status")) {
                                             var17 = "wick_status";
                                             break label123;
                                          }

                                          if (Intrinsics.areEqual(var16, "purchase")) {
                                             var17 = "wick_purchase";
                                             break label123;
                                          }
                                       }
                                    }
                                    break;
                                 case "stop_alarm":
                                    String var15 = var3.getQueryParameter("did");
                                    if (var15 != null) {
                                       this.startService(Actions.INSTANCE.stopAlarmIntent((Context)this, var15, 0));
                                       return;
                                    }
                                    break;
                                 case "view_device_details":
                                    String var14 = var3.getQueryParameter("did");
                                    if (var14 != null) {
                                       onNewIntent$withDevice(this, var14, new HomeActivity$$ExternalSyntheticLambda22(this, var2, var3, var21, var20, var6));
                                       return;
                                    }
                                    break;
                                 case "view_web":
                                    String var13 = var3.getQueryParameter("url");
                                    if (var13 != null) {
                                       onNewIntent$sendAnalyticsEvent(var2, this, var3, var21, var20, var6, (Device)null);
                                       this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var13)));
                                       return;
                                    }
                                    break;
                                 case "view_home_page":
                                    onNewIntent$sendAnalyticsEvent(var2, this, var3, var21, var20, var6, (Device)null);
                                    return;
                                 case "view_refresher_page":
                                    var7 = var3.getQueryParameter("did");
                                    if (var7 != null) {
                                       String var11 = var3.getQueryParameter("target");
                                       if (var11 != null) {
                                          if (Intrinsics.areEqual(var11, "status")) {
                                             var12 = "refresher_status";
                                             break label124;
                                          }

                                          if (Intrinsics.areEqual(var11, "purchase")) {
                                             var12 = "refresher_purchase";
                                             break label124;
                                          }
                                       }
                                    }
                                    break;
                                 case "view_filter_page":
                                    var7 = var3.getQueryParameter("did");
                                    if (var7 != null) {
                                       String var9 = var3.getQueryParameter("target");
                                       if (var9 != null) {
                                          if (Intrinsics.areEqual(var9, "status")) {
                                             var10 = "filter_status";
                                             break label125;
                                          }

                                          if (Intrinsics.areEqual(var9, "purchase")) {
                                             var10 = "filter_purchase";
                                             break label125;
                                          }
                                       }
                                    }
                              }
                           }
                        }
                     }
                  }
               }

               return;
            }

            onNewIntent$withDevice(this, var7, new HomeActivity$$ExternalSyntheticLambda19(this, var17, var2, var3, var21, var20, var6));
            return;
         }

         onNewIntent$withDevice(this, var7, new HomeActivity$$ExternalSyntheticLambda21(this, var12, var2, var3, var21, var20, var6));
         return;
      }

      onNewIntent$withDevice(this, var7, new HomeActivity$$ExternalSyntheticLambda20(this, var10, var2, var3, var21, var20, var6));
   }

   protected void onResume() {
      super.onResume();
      this.updateNavigationView();
      this.getJpushService().setBadgeNumber(0);
      GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager var2 = this.appUpdateManager;
      GooglePlayAppUpdateSdk.GooglePlayAppUpdateManager var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("appUpdateManager");
         var1 = null;
      }

      var1.resumeInAppUpdate(4095);
      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getClickNotificationPublisher(), new HomeActivity$$ExternalSyntheticLambda6(this)));
   }

   protected void onStart() {
      super.onStart();
      if (this.getNotificationService().getEnabled()) {
         this.getNotificationPermissionManager();
         ActivityHomeBinding var2 = this.homeDataBinding;
         ActivityHomeBinding var1 = var2;
         if (var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("homeDataBinding");
            var1 = null;
         }

         var1.getRoot().postDelayed(new HomeActivity$$ExternalSyntheticLambda3(this), 1L);
      }

   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"},
      d2 = {"Lcom/blueair/android/activity/HomeActivity$Companion;", "", "<init>", "()V", "NAV_VIEW_HEADER_INDEX", "", "REQUEST_CODE_UPDATE", "app_otherRelease"},
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
