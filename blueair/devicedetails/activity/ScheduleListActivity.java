package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.adapter.ScheduleCardAdapter;
import com.blueair.devicedetails.databinding.ActivityScheduleListBinding;
import com.blueair.devicedetails.dialog.DeleteScheduleDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceSchedulesViewModel;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
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
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u0016\u0010\u001a\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\u0014\u0010 \u001a\u00020\u00162\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001dH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/activity/ScheduleListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "schedulesBinding", "Lcom/blueair/devicedetails/databinding/ActivityScheduleListBinding;", "scheduleAdapter", "Lcom/blueair/devicedetails/adapter/ScheduleCardAdapter;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSchedulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "overviewLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "hydrateSchedules", "it", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "showMenuDialog", "showDeleteDialog", "gotoScheduleOverview", "mergedSchedule", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScheduleListActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityResultLauncher overviewLauncher;
   private ScheduleCardAdapter scheduleAdapter;
   private ActivityScheduleListBinding schedulesBinding;
   private final String screenName = "device_details_schedule_list";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$59kkU22tv2syvMqKurBDEDpuaK0(ScheduleListActivity var0, List var1) {
      return configure$lambda$8(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$BjedVyAqIBNS5wwZFhY_aZ0MQ_M/* $FF was: $r8$lambda$BjedVyAqIBNS5wwZFhY_aZ0MQ-M*/(ScheduleListActivity var0, DeviceScheduleMerged var1, boolean var2) {
      return configure$lambda$5(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UOVd8NONW0PHhbTOxj_lEaHTObs(ScheduleListActivity var0, View var1) {
      configure$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$d_Qnd7DmYAiFLqvoDrVFj0U0h_0/* $FF was: $r8$lambda$d-Qnd7DmYAiFLqvoDrVFj0U0h-0*/(ScheduleListActivity var0, ActivityResult var1) {
      onCreate$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jo2Kp3reLcbfEnc3ahUvGM1UY30(ScheduleListActivity var0, View var1) {
      configure$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$nkvJS9YJirP_aExQlALNjSsyOZY(ScheduleListActivity var0, DeviceScheduleMerged var1) {
      return configure$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$sKt745XdQcnFWDUBUp3SkRnZn0s(ScheduleListActivity var0, View var1) {
      configure$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ziSovlKaTROBrLKV43PX7qjF1SA(ScheduleListActivity var0) {
      return configure$lambda$4(var0);
   }

   public ScheduleListActivity() {
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
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceSchedulesViewModel.class), new Function0(var2) {
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
      ViewDataBinding var1 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_schedule_list);
      Intrinsics.checkNotNullExpressionValue(var1, "setContentView(...)");
      ActivityScheduleListBinding var3 = (ActivityScheduleListBinding)var1;
      this.schedulesBinding = var3;
      Object var2 = null;
      ActivityScheduleListBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var4 = null;
      }

      var4.btnMore.setEnabled(false);
      var3 = this.schedulesBinding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var4 = null;
      }

      var4.btnBack.setOnClickListener(new ScheduleListActivity$$ExternalSyntheticLambda1(this));
      var3 = this.schedulesBinding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var4 = null;
      }

      var4.btnMore.setOnClickListener(new ScheduleListActivity$$ExternalSyntheticLambda2(this));
      var3 = this.schedulesBinding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var4 = null;
      }

      var4.btnCreate.setOnClickListener(new ScheduleListActivity$$ExternalSyntheticLambda3(this));
      this.scheduleAdapter = new ScheduleCardAdapter(this.getViewModel().getDevice() instanceof HasBlueCloudFunctions, DateFormat.is24HourFormat((Context)this), this.getViewModel().getDevice(), new ScheduleListActivity$$ExternalSyntheticLambda4(this), new ScheduleListActivity$$ExternalSyntheticLambda5(this), new ScheduleListActivity$$ExternalSyntheticLambda6(this));
      var3 = this.schedulesBinding;
      var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var4 = null;
      }

      RecyclerView var14 = var4.rvList;
      ScheduleCardAdapter var9 = this.scheduleAdapter;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
         var9 = (ScheduleCardAdapter)var2;
      }

      var14.setAdapter(var9);
      var14.addItemDecoration(new SimpleSpacingDecoration(0, (int)TypedValueCompat.dpToPx(-2.0F, this.getResources().getDisplayMetrics()), false, 4, (DefaultConstructorMarker)null));
      var14.addOnScrollListener(new RecyclerView.OnScrollListener(this) {
         final ScheduleListActivity this$0;

         {
            this.this$0 = var1;
         }

         public void onScrollStateChanged(RecyclerView var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "recyclerView");
            super.onScrollStateChanged(var1, var2);
            ActivityScheduleListBinding var3 = this.this$0.schedulesBinding;
            ActivityScheduleListBinding var4 = var3;
            if (var3 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
               var4 = null;
            }

            if (var2 != 0) {
               var4.bottomBar.setBackgroundColor(-1);
               View var6 = var4.separator;
               Intrinsics.checkNotNullExpressionValue(var6, "separator");
               ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
            } else {
               var4.bottomBar.setBackgroundColor(0);
               View var5 = var4.separator;
               Intrinsics.checkNotNullExpressionValue(var5, "separator");
               ViewExtensionsKt.hide(var5);
            }
         }
      });
      this.getViewModel().getSchedules().observe((LifecycleOwner)this, new Observer(new ScheduleListActivity$$ExternalSyntheticLambda7(this)) {
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
      this.getViewModel().refreshDeviceSchedule(true);
   }

   private static final void configure$lambda$1(ScheduleListActivity var0, View var1) {
      var0.finish();
   }

   private static final void configure$lambda$2(ScheduleListActivity var0, View var1) {
      var0.showMenuDialog();
   }

   private static final void configure$lambda$3(ScheduleListActivity var0, View var1) {
      gotoScheduleOverview$default(var0, (DeviceScheduleMerged)null, 1, (Object)null);
   }

   private static final Unit configure$lambda$4(ScheduleListActivity var0) {
      gotoScheduleOverview$default(var0, (DeviceScheduleMerged)null, 1, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$5(ScheduleListActivity var0, DeviceScheduleMerged var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "tappedSchedule");
      BuildersKt.launch$default(var0, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(var0, var1, var2, (Continuation)null) {
         final boolean $checked;
         final DeviceScheduleMerged $tappedSchedule;
         int label;
         final ScheduleListActivity this$0;

         {
            this.this$0 = var1;
            this.$tappedSchedule = var2;
            this.$checked = var3;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$tappedSchedule, this.$checked, var2));
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
               DeviceSchedulesViewModel var5 = this.this$0.getViewModel();
               var1 = this.$tappedSchedule;
               boolean var3 = this.$checked;
               Continuation var6 = (Continuation)this;
               this.label = 1;
               if (var5.updateScheduleSwitch(var1, var3 ^ true, var6) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$6(ScheduleListActivity var0, DeviceScheduleMerged var1) {
      Intrinsics.checkNotNullParameter(var1, "tappedSchedule");
      var0.gotoScheduleOverview(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configure$lambda$8(ScheduleListActivity var0, List var1) {
      Intrinsics.checkNotNull(var1);
      var0.hydrateSchedules(var1);
      return Unit.INSTANCE;
   }

   private final DeviceSchedulesViewModel getViewModel() {
      return (DeviceSchedulesViewModel)this.viewModel$delegate.getValue();
   }

   private final void gotoScheduleOverview(DeviceScheduleMerged var1) {
      ActivityResultLauncher var3 = this.overviewLauncher;
      ActivityResultLauncher var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("overviewLauncher");
         var2 = null;
      }

      var2.launch(ScheduleOverviewActivity.Companion.getLaunchIntent((Context)this, this.getViewModel().getDevice(), var1));
   }

   // $FF: synthetic method
   static void gotoScheduleOverview$default(ScheduleListActivity var0, DeviceScheduleMerged var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = null;
      }

      var0.gotoScheduleOverview(var1);
   }

   private final void hydrateSchedules(List var1) {
      ScheduleCardAdapter var5 = this.scheduleAdapter;
      Object var4 = null;
      ScheduleCardAdapter var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleAdapter");
         var3 = null;
      }

      var3.setItems(var1);
      ActivityScheduleListBinding var14 = this.schedulesBinding;
      ActivityScheduleListBinding var9 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var9 = null;
      }

      RecyclerView var10 = var9.rvList;
      Intrinsics.checkNotNullExpressionValue(var10, "rvList");
      View var11 = (View)var10;
      byte var2 = 0;
      ViewExtensionsKt.show$default(var11, false, 1, (Object)null);
      var14 = this.schedulesBinding;
      ActivityScheduleListBinding var12 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var12 = null;
      }

      AppCompatImageButton var16 = var12.btnMore;
      Collection var13 = (Collection)var1;
      var16.setEnabled(true ^ var13.isEmpty());
      ActivityScheduleListBinding var6 = this.schedulesBinding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var6 = (ActivityScheduleListBinding)var4;
      }

      LinearLayout var7 = var6.bottomBar;
      Intrinsics.checkNotNullExpressionValue(var7, "bottomBar");
      View var8 = (View)var7;
      if (var13.isEmpty()) {
         var2 = 8;
      }

      var8.setVisibility(var2);
   }

   private static final void onCreate$lambda$0(ScheduleListActivity var0, ActivityResult var1) {
      if (var1.getResultCode() == -1) {
         var0.getViewModel().refreshDeviceSchedule(false);
      }

   }

   private final void showDeleteDialog() {
      FragmentManager var1 = this.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var1, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeleteScheduleDialogFragment", "getSimpleName(...)");
      if (!(var1.findFragmentByTag("DeleteScheduleDialogFragment") instanceof DeleteScheduleDialogFragment) && !var1.isStateSaved()) {
         ((DialogFragment)DeleteScheduleDialogFragment.Companion.newInstance()).show(var1, "DeleteScheduleDialogFragment");
      }

   }

   private final void showMenuDialog() {
      CustomDialog var3 = CustomDialog.show(new OnBindView(this, R.layout.dialog_schedule_more_action) {
         final ScheduleListActivity this$0;

         // $FF: synthetic method
         public static void $r8$lambda$Iv5hnx_lWPuqYDg4qn0uhj41sgs/* $FF was: $r8$lambda$Iv5hnx-lWPuqYDg4qn0uhj41sgs*/(CustomDialog var0, ScheduleListActivity var1, View var2) {
            onBind$lambda$0(var0, var1, var2);
         }

         // $FF: synthetic method
         public static void $r8$lambda$K4SsT7XGRN7o1n7g2iVRflzpYH4(CustomDialog var0, ScheduleListActivity var1, View var2) {
            onBind$lambda$1(var0, var1, var2);
         }

         {
            this.this$0 = var1;
         }

         private static final void onBind$lambda$0(CustomDialog var0, ScheduleListActivity var1, View var2) {
            var0.dismiss();
            ScheduleListActivity.gotoScheduleOverview$default(var1, (DeviceScheduleMerged)null, 1, (Object)null);
         }

         private static final void onBind$lambda$1(CustomDialog var0, ScheduleListActivity var1, View var2) {
            var0.dismiss();
            var1.showDeleteDialog();
         }

         public void onBind(CustomDialog var1, View var2) {
            Intrinsics.checkNotNullParameter(var1, "dialog");
            Intrinsics.checkNotNullParameter(var2, "v");
            View var3 = var2.findViewById(R.id.tv_addSchedule);
            var2 = var2.findViewById(R.id.tv_deleteSchedule);
            var3.setOnClickListener(new ScheduleListActivity$showMenuDialog$1$$ExternalSyntheticLambda0(var1, this.this$0));
            var2.setOnClickListener(new ScheduleListActivity$showMenuDialog$1$$ExternalSyntheticLambda1(var1, this.this$0));
         }
      });
      ActivityScheduleListBinding var2 = this.schedulesBinding;
      ActivityScheduleListBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         var1 = null;
      }

      var3.setAlignBaseViewGravity((View)var1.btnMore, 17);
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Intent var4 = this.getIntent();
      ActivityScheduleListBinding var2 = null;
      Device var5;
      if (var4 != null) {
         var5 = (Device)var4.getParcelableExtra("device");
      } else {
         var5 = null;
      }

      if (!(var5 instanceof Device)) {
         var5 = null;
      }

      if (var5 != null) {
         this.getViewModel().setDevice(var5);
         this.configure();
         ActivityScheduleListBinding var3 = this.schedulesBinding;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulesBinding");
         } else {
            var2 = var3;
         }

         var2.tvSubtitle.setText((CharSequence)var5.getName());
         this.getViewModel().refreshDeviceSchedule(false);
         ActivityResultLauncher var6 = this.registerForActivityResult((ActivityResultContract)(new ActivityResultContracts.StartActivityForResult()), new ScheduleListActivity$$ExternalSyntheticLambda0(this));
         Intrinsics.checkNotNullExpressionValue(var6, "registerForActivityResult(...)");
         this.overviewLauncher = var6;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/devicedetails/activity/ScheduleListActivity$Companion;", "", "<init>", "()V", "intent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final Intent intent(Context var1, Device var2) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intent var3 = new Intent(var1, ScheduleListActivity.class);
         var3.putExtra("device", var2);
         return var3;
      }
   }
}
