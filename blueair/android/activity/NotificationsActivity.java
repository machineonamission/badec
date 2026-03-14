package com.blueair.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.adapter.NotificationMsgAdapter;
import com.blueair.android.databinding.ActivityNotificationsBinding;
import com.blueair.android.viewmodel.NotificationsViewModel;
import com.blueair.core.model.Device;
import com.blueair.core.model.SimpleEvent;
import com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R-\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"},
   d2 = {"Lcom/blueair/android/activity/NotificationsActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityNotificationsBinding;", "clickNotificationPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "Lcom/blueair/android/adapter/NotificationItem;", "getClickNotificationPublisher", "()Lio/reactivex/subjects/PublishSubject;", "clickNotificationPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "notificationMsgAdapter", "Lcom/blueair/android/adapter/NotificationMsgAdapter;", "notificationsViewModel", "Lcom/blueair/android/viewmodel/NotificationsViewModel;", "getNotificationsViewModel", "()Lcom/blueair/android/viewmodel/NotificationsViewModel;", "notificationsViewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "observeViewModel", "onResume", "bindViewModel", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class NotificationsActivity extends BaseActivity {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(NotificationsActivity.class, "clickNotificationPublisher", "getClickNotificationPublisher()Lio/reactivex/subjects/PublishSubject;", 0)))};
   public static final int $stable = 8;
   private ActivityNotificationsBinding binding;
   private final LazyPublishSubject clickNotificationPublisher$delegate = new LazyPublishSubject();
   private NotificationMsgAdapter notificationMsgAdapter;
   private final Lazy notificationsViewModel$delegate;
   private final String screenName = "notifications";

   // $FF: synthetic method
   public static Unit $r8$lambda$9KF0IF1B95cIRbiPun9KhMxRku8(NotificationsActivity var0, SimpleEvent var1) {
      return onResume$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$LZfPMQ3_luXwYG6g7Wh79m0DgJs(NotificationsActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Q_GMLKN7ZLA7mmhFK62JcYNn8ZU/* $FF was: $r8$lambda$Q-GMLKN7ZLA7mmhFK62JcYNn8ZU*/(NotificationsActivity var0, List var1) {
      return observeViewModel$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$dEUtRhURFkRDp5i67p4d1B5e6Gk(NotificationsActivity var0, View var1) {
      onCreate$lambda$0(var0, var1);
   }

   public NotificationsActivity() {
      ComponentActivity var1 = (ComponentActivity)this;
      Function0 var2 = new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.notificationsViewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var2, new Function0((Function0)null, var1) {
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
   }

   private final void bindViewModel() {
      ActivityNotificationsBinding var1 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_notifications);
      Intrinsics.checkNotNullExpressionValue(var1, "setContentView(...)");
      ActivityNotificationsBinding var2 = var1;
      this.binding = var2;
      var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.setViewModel(this.getNotificationsViewModel());
      var1.setLifecycleOwner((LifecycleOwner)this);
   }

   private final PublishSubject getClickNotificationPublisher() {
      return this.clickNotificationPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   private final NotificationsViewModel getNotificationsViewModel() {
      return (NotificationsViewModel)this.notificationsViewModel$delegate.getValue();
   }

   private final void observeViewModel() {
      this.getNotificationsViewModel().getLvNotificationMsgs().observe((LifecycleOwner)this, new Observer(new NotificationsActivity$$ExternalSyntheticLambda3(this)) {
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

   private static final Unit observeViewModel$lambda$2(NotificationsActivity var0, List var1) {
      NotificationMsgAdapter var3 = var0.notificationMsgAdapter;
      NotificationMsgAdapter var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
         var2 = null;
      }

      Intrinsics.checkNotNull(var1);
      var2.setNewList(var1);
      var0.getNotificationsViewModel().getNotificationsNum().setValue(var1.size());
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$0(NotificationsActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$1(NotificationsActivity var0, View var1) {
      NotificationMsgAdapter var2 = var0.notificationMsgAdapter;
      NotificationMsgAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
         var3 = null;
      }

      var3.setNewList(CollectionsKt.emptyList());
      var0.getNotificationsViewModel().dismissAll();
   }

   private static final Unit onResume$lambda$4(NotificationsActivity var0, SimpleEvent var1) {
      NotificationItem var3 = (NotificationItem)var1.getData();
      switch (var5) {
         case "event_replace_filter":
            var0.getNotificationsViewModel().executeReplaceFilterEvent(var3, (FragmentActivity)var0);
            break;
         case "event_close":
            NotificationMsgAdapter var8 = var0.notificationMsgAdapter;
            NotificationMsgAdapter var7 = var8;
            if (var8 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
               var7 = null;
            }

            var7.remove(var3);
            NotificationsViewModel.dismissMsg$default(var0.getNotificationsViewModel(), var3, false, 2, (Object)null);
            break;
         case "event_adjust":
            NotificationsViewModel.dismissMsg$default(var0.getNotificationsViewModel(), var3, false, 2, (Object)null);
            Device var6 = var3.getMessage().getDevice();
            FragmentManager var4 = var0.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var4, "getSupportFragmentManager(...)");
            String var2 = var6.getUid();
            if (!(var4.findFragmentByTag(var2) instanceof DeviceDetailsV2DialogFragment) && !var4.isStateSaved()) {
               ((DialogFragment)DeviceDetailsV2DialogFragment.Companion.newInstance(var6, "device_details")).show(var4, var2);
            }
            break;
         case "event_buy_filter":
            var0.getNotificationsViewModel().executeBuyFilterEvent(var3, (FragmentActivity)var0);
      }

      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.bindViewModel();
      BaseLokaliseActivity var6 = this;
      Object var3 = null;
      BaseLokaliseActivity.immersiveStatusBar$default(var6, false, 1, (Object)null);
      this.setStatusMode(true);
      this.notificationMsgAdapter = new NotificationMsgAdapter(this.getNotificationsViewModel().getLocationService(), this.getClickNotificationPublisher());
      ActivityNotificationsBinding var4 = this.binding;
      ActivityNotificationsBinding var7 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      RecyclerView var5 = var7.rvList;
      NotificationMsgAdapter var12 = this.notificationMsgAdapter;
      NotificationMsgAdapter var8 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
         var8 = null;
      }

      var5.setAdapter(var8);
      ActivityNotificationsBinding var13 = this.binding;
      ActivityNotificationsBinding var9 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      var9.btnBack.setOnClickListener(new NotificationsActivity$$ExternalSyntheticLambda0(this));
      var13 = this.binding;
      var9 = var13;
      if (var13 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      var9.tvDismissAll.setOnClickListener(new NotificationsActivity$$ExternalSyntheticLambda1(this));
      float var2 = TypedValueCompat.dpToPx(8.0F, this.getResources().getDisplayMetrics());
      var9 = this.binding;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = (ActivityNotificationsBinding)var3;
      }

      var9.rvList.addItemDecoration(new SimpleSpacingDecoration(0, (int)var2, false, 4, (DefaultConstructorMarker)null));
      this.observeViewModel();
   }

   protected void onResume() {
      super.onResume();
      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getClickNotificationPublisher(), new NotificationsActivity$$ExternalSyntheticLambda2(this)));
   }
}
