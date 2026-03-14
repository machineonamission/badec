package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.adapter.DevicesAlarmAdapter;
import com.blueair.devicedetails.databinding.ActivityDevicesAlarmListBinding;
import com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceAlarmsViewModel;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"},
   d2 = {"Lcom/blueair/devicedetails/activity/DevicesAlarmListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDevicesAlarmListBinding;", "devicesAlarmAdapter", "Lcom/blueair/devicedetails/adapter/DevicesAlarmAdapter;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceAlarmsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "observeViewModel", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DevicesAlarmListActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityDevicesAlarmListBinding binding;
   private DevicesAlarmAdapter devicesAlarmAdapter;
   private final String screenName;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$1t1migYWd0805dAm3LN0yUxffus(DevicesAlarmListActivity var0, HasAlarm var1, View var2) {
      return configure$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Elg6x1_rJ4iLsRQketCfm1Dchps/* $FF was: $r8$lambda$Elg6x1-rJ4iLsRQketCfm1Dchps*/(DevicesAlarmListActivity var0, boolean var1) {
      return observeViewModel$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$YbMv0mt7jpPGtmWcQj3xR_E2JwI(DevicesAlarmListActivity var0, HasAlarm var1, DeviceAlarm var2, boolean var3) {
      return configure$lambda$1(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_8FCQz_wj1piQV4btRW6drbHD_Y(DevicesAlarmListActivity var0, HasAlarm var1) {
      return configure$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$c5_l_eOqxzFCw6_s4BxAt__8lmM/* $FF was: $r8$lambda$c5-l_eOqxzFCw6_s4BxAt_-8lmM*/(DevicesAlarmListActivity var0, View var1) {
      configure$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$n4WzURWXix1eNHH1drG7b6OE4RU(DevicesAlarmListActivity var0, List var1) {
      return observeViewModel$lambda$7(var0, var1);
   }

   public DevicesAlarmListActivity() {
      ComponentActivity var2 = (ComponentActivity)this;
      Function0 var1 = new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceAlarmsViewModel.class), new Function0(var2) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var1, new Function0((Function0)null, var2) {
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

   private final void configure() {
      ActivityDevicesAlarmListBinding var2 = ActivityDevicesAlarmListBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
      this.binding = var2;
      ActivityDevicesAlarmListBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      this.setContentView(var1.getRoot());
      var2 = this.binding;
      var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.btnBack.setOnClickListener(new DevicesAlarmListActivity$$ExternalSyntheticLambda0(this));
      this.devicesAlarmAdapter = new DevicesAlarmAdapter(new DevicesAlarmListActivity$$ExternalSyntheticLambda1(this), new DevicesAlarmListActivity$$ExternalSyntheticLambda2(this), new DevicesAlarmListActivity$$ExternalSyntheticLambda3(this));
      var2 = this.binding;
      var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      RecyclerView var3 = var1.rvList;
      DevicesAlarmAdapter var9 = this.devicesAlarmAdapter;
      DevicesAlarmAdapter var6 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("devicesAlarmAdapter");
         var6 = null;
      }

      var3.setAdapter(var6);
      var3.addItemDecoration(new SimpleSpacingDecoration(0, (int)TypedValueCompat.dpToPx(28.0F, this.getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker)null));
      var3.setItemAnimator((RecyclerView.ItemAnimator)null);
      this.getViewModel().refreshDeviceAlarms();
   }

   private static final void configure$lambda$0(DevicesAlarmListActivity var0, View var1) {
      var0.finish();
   }

   private static final Unit configure$lambda$1(DevicesAlarmListActivity var0, HasAlarm var1, DeviceAlarm var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "hasAlarm");
      Intrinsics.checkNotNullParameter(var2, "deviceAlarm");
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)var0), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, var2, var3, (Continuation)null) {
         final boolean $checked;
         final DeviceAlarm $deviceAlarm;
         final HasAlarm $hasAlarm;
         int label;
         final DevicesAlarmListActivity this$0;

         {
            this.this$0 = var1;
            this.$hasAlarm = var2;
            this.$deviceAlarm = var3;
            this.$checked = var4;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$hasAlarm, this.$deviceAlarm, this.$checked, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               DeviceAlarmsViewModel var8 = this.this$0.getViewModel();
               HasAlarm var7 = this.$hasAlarm;
               DeviceAlarm var6 = this.$deviceAlarm;
               boolean var3 = this.$checked;
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (var8.updateAlarmSwitch(var7, var6, var3, var5) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$3(DevicesAlarmListActivity var0, HasAlarm var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var2.isStateSaved()) {
         ((DialogFragment)TroubleshootingDialog.Companion.newInstance("action_type_device_offline", var1)).show(var2, "TroubleshootingDialog");
         var2.executePendingTransactions();
      }

      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$5(DevicesAlarmListActivity var0, HasAlarm var1, View var2) {
      Intrinsics.checkNotNullParameter(var1, "hasAlarm");
      Intrinsics.checkNotNullParameter(var2, "anchorView");
      FragmentManager var3 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeleteAlarmDialogFragment", "getSimpleName(...)");
      if (!(var3.findFragmentByTag("DeleteAlarmDialogFragment") instanceof DeleteAlarmDialogFragment) && !var3.isStateSaved()) {
         ((DialogFragment)DeleteAlarmDialogFragment.Companion.newInstance(var1, false, var2)).show(var3, "DeleteAlarmDialogFragment");
      }

      return Unit.INSTANCE;
   }

   private final DeviceAlarmsViewModel getViewModel() {
      return (DeviceAlarmsViewModel)this.viewModel$delegate.getValue();
   }

   private final void observeViewModel() {
      MutableLiveData var2 = this.getViewModel().getLvDeviceAlarms();
      LifecycleOwner var1 = (LifecycleOwner)this;
      var2.observe(var1, new Observer(new DevicesAlarmListActivity$$ExternalSyntheticLambda4(this)) {
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
      LiveDataExtensionsKt.observeNonNull(this.getViewModel().getNetworkAvailable(), var1, new DevicesAlarmListActivity$$ExternalSyntheticLambda5(this));
   }

   private static final Unit observeViewModel$lambda$7(DevicesAlarmListActivity var0, List var1) {
      DevicesAlarmAdapter var2 = var0.devicesAlarmAdapter;
      DevicesAlarmAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("devicesAlarmAdapter");
         var3 = null;
      }

      Intrinsics.checkNotNull(var1);
      var3.setItems(var1);
      return Unit.INSTANCE;
   }

   private static final Unit observeViewModel$lambda$8(DevicesAlarmListActivity var0, boolean var1) {
      DevicesAlarmAdapter var2 = var0.devicesAlarmAdapter;
      DevicesAlarmAdapter var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("devicesAlarmAdapter");
         var3 = null;
      }

      var3.setForceOffline(var1 ^ true);
      return Unit.INSTANCE;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.configure();
      this.observeViewModel();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/activity/DevicesAlarmListActivity$Companion;", "", "<init>", "()V", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "devicedetails_otherRelease"},
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

      public final Intent intent(Context var1) {
         Intrinsics.checkNotNullParameter(var1, "context");
         return new Intent(var1, DevicesAlarmListActivity.class);
      }
   }
}
