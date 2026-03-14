package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.adapter.AlarmCardAdapter;
import com.blueair.devicedetails.databinding.ActivityAlarmListBinding;
import com.blueair.devicedetails.dialog.DeleteAlarmDialogFragment;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.kongzue.dialogx.dialogs.CustomDialog;
import com.kongzue.dialogx.interfaces.OnBindView;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/activity/AlarmListActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityAlarmListBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "adapter", "Lcom/blueair/devicedetails/adapter/AlarmCardAdapter;", "device", "Lcom/blueair/core/model/HasAlarm;", "getDevice", "()Lcom/blueair/core/model/HasAlarm;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "createNewAlarm", "showMenuDialog", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AlarmListActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private AlarmCardAdapter adapter;
   private ActivityAlarmListBinding binding;
   private final String screenName = "device_details_alarm_list";
   private final DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$1F1SQP_K2fQDSlZFfQoV6ohDafc/* $FF was: $r8$lambda$1F1SQP-K2fQDSlZFfQoV6ohDafc*/(AlarmListActivity var0, View var1) {
      configure$lambda$11$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5NkPMZtVL7OFkgj_i_HTnov9TuM/* $FF was: $r8$lambda$5NkPMZtVL7OFkgj-i_HTnov9TuM*/(AlarmListActivity var0, View var1) {
      configure$lambda$11$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$OrQ5QWzpDodZlfpaQxKu4bOp1pA(AlarmListActivity var0, View var1) {
      configure$lambda$11$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$OyeYNvIydbzSv3LGBpYLm8tjNIw(AlarmListActivity var0, DeviceAlarm var1) {
      return configure$lambda$11$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$eKUSG4NbAFZqFNTQTy2kBKAsOnA(AlarmListActivity var0, View var1) {
      configure$lambda$11$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$l5vVOYBVb1SF2TAUH_cdjRXLiL8/* $FF was: $r8$lambda$l5vVOYBVb1SF2TAUH-cdjRXLiL8*/(AlarmListActivity var0, ActivityAlarmListBinding var1, Device var2) {
      return configure$lambda$11$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$s9jrTjLLBonEkgTn0pUoVhg8L10(AlarmListActivity var0, View var1) {
      configure$lambda$11$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vpgJj5anyVkzRXFZQfTOmArgz0s(AlarmListActivity var0, View var1) {
      configure$lambda$11$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$yawhM7AniuLL_4UCsksrtbMhNEE/* $FF was: $r8$lambda$yawhM7AniuLL-4UCsksrtbMhNEE*/(AlarmListActivity var0, DeviceAlarm var1, boolean var2) {
      return configure$lambda$11$lambda$6(var0, var1, var2);
   }

   public AlarmListActivity() {
      BaseActivity var1 = this;
      this.viewModel = (DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class));
   }

   private final void configure() {
      ActivityAlarmListBinding var2 = this.binding;
      Object var3 = null;
      ActivityAlarmListBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      AppCompatTextView var4 = var1.tvSubtitle;
      Device var5 = this.viewModel.getDevice();
      String var6;
      if (var5 != null) {
         var6 = var5.getName();
      } else {
         var6 = null;
      }

      var4.setText((CharSequence)var6);
      var1.epBtnBack.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda0(this));
      var1.epBtnClose.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda1(this));
      var1.epBtnCreate.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda2(this));
      var1.btnBack.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda3(this));
      var1.btnMore.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda4(this));
      var1.btnCreate.setOnClickListener(new AlarmListActivity$$ExternalSyntheticLambda5(this));
      this.adapter = new AlarmCardAdapter(this.getColor(R.color.colorPrimaryText), new AlarmListActivity$$ExternalSyntheticLambda6(this), new AlarmListActivity$$ExternalSyntheticLambda7(this));
      RecyclerView var8 = var1.rvList;
      AlarmCardAdapter var7 = this.adapter;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("adapter");
         var7 = (AlarmCardAdapter)var3;
      }

      var8.setAdapter(var7);
      this.viewModel.getLiveDevice().observe((LifecycleOwner)this, new Observer(new AlarmListActivity$$ExternalSyntheticLambda8(this, var1)) {
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
      var1.rvList.addOnScrollListener(new RecyclerView.OnScrollListener(var1) {
         final ActivityAlarmListBinding $this_apply;

         {
            this.$this_apply = var1;
         }

         public void onScrollStateChanged(RecyclerView var1, int var2) {
            Intrinsics.checkNotNullParameter(var1, "recyclerView");
            super.onScrollStateChanged(var1, var2);
            if (var2 != 0) {
               this.$this_apply.bottomBar.setBackgroundColor(-1);
               View var4 = this.$this_apply.separator;
               Intrinsics.checkNotNullExpressionValue(var4, "separator");
               ViewExtensionsKt.show$default(var4, false, 1, (Object)null);
            } else {
               this.$this_apply.bottomBar.setBackgroundColor(0);
               View var3 = this.$this_apply.separator;
               Intrinsics.checkNotNullExpressionValue(var3, "separator");
               ViewExtensionsKt.hide(var3);
            }
         }
      });
   }

   private static final void configure$lambda$11$lambda$0(AlarmListActivity var0, View var1) {
      var0.finish();
   }

   private static final void configure$lambda$11$lambda$1(AlarmListActivity var0, View var1) {
      var0.finish();
   }

   private static final Unit configure$lambda$11$lambda$10(AlarmListActivity var0, ActivityAlarmListBinding var1, Device var2) {
      var0.viewModel.setDevice(var2);
      AlarmCardAdapter var5 = var0.adapter;
      AlarmCardAdapter var7 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("adapter");
         var7 = null;
      }

      boolean var3;
      label32: {
         List var10 = CollectionsKt.sortedWith((Iterable)CollectionsKt.filterNotNull((Iterable)var0.getDevice().getAlarms()), new Comparator() {
            public final int compare(Object var1, Object var2) {
               return ComparisonsKt.compareValues((Comparable)((DeviceAlarm)var1).getSecondsInDay(), (Comparable)((DeviceAlarm)var2).getSecondsInDay());
            }
         });
         boolean var4 = false;
         var7.setData(var10, false);
         Iterable var8 = (Iterable)var0.getDevice().getAlarms();
         if (!(var8 instanceof Collection) || !((Collection)var8).isEmpty()) {
            Iterator var9 = var8.iterator();

            while(var9.hasNext()) {
               var3 = var4;
               if ((DeviceAlarm)var9.next() != null) {
                  break label32;
               }
            }
         }

         var3 = true;
      }

      ConstraintLayout var6 = var1.emptyContainer;
      Intrinsics.checkNotNullExpressionValue(var6, "emptyContainer");
      ViewExtensionsKt.show((View)var6, var3);
      var0.setStatusMode(var3 ^ true);
      return Unit.INSTANCE;
   }

   private static final void configure$lambda$11$lambda$2(AlarmListActivity var0, View var1) {
      var0.createNewAlarm();
   }

   private static final void configure$lambda$11$lambda$3(AlarmListActivity var0, View var1) {
      var0.finish();
   }

   private static final void configure$lambda$11$lambda$4(AlarmListActivity var0, View var1) {
      var0.showMenuDialog();
   }

   private static final void configure$lambda$11$lambda$5(AlarmListActivity var0, View var1) {
      var0.createNewAlarm();
   }

   private static final Unit configure$lambda$11$lambda$6(AlarmListActivity var0, DeviceAlarm var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "alarm");
      int var3 = var0.getDevice().getAlarms().indexOf(var1);
      if (var3 < 0) {
         return Unit.INSTANCE;
      } else {
         DeviceDetailsViewModel.setAlarm$default(var0.viewModel, var0.getDevice(), var3 + 1, DeviceAlarm.copy$default(var1, (String)null, var2, 0, false, 0, 0, 0, 0, 253, (Object)null), (Function2)null, 8, (Object)null);
         return Unit.INSTANCE;
      }
   }

   private static final Unit configure$lambda$11$lambda$7(AlarmListActivity var0, DeviceAlarm var1) {
      Intrinsics.checkNotNullParameter(var1, "alarm");
      int var2 = var0.getDevice().getAlarms().indexOf(var1);
      if (var2 < 0) {
         return Unit.INSTANCE;
      } else {
         AlarmEditActivity.Companion.launch((Context)var0, var0.getDevice(), var2);
         return Unit.INSTANCE;
      }
   }

   private final void createNewAlarm() {
      Iterable var4 = (Iterable)this.getDevice().getAlarms();
      boolean var3 = var4 instanceof Collection;
      int var1 = 0;
      if (!var3 || !((Collection)var4).isEmpty()) {
         Iterator var7 = var4.iterator();
         var1 = 0;

         while(var7.hasNext()) {
            boolean var2;
            if ((DeviceAlarm)var7.next() != null) {
               var2 = 1;
            } else {
               var2 = 0;
            }

            if (var2) {
               var2 = var1 + 1;
               var1 = var2;
               if (var2 < 0) {
                  CollectionsKt.throwCountOverflow();
                  var1 = var2;
               }
            }
         }
      }

      if (var1 >= 5) {
         FragmentManager var8 = this.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var8, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
         if (!(var8.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var8.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.alarm_full_title, (Integer)null, R.string.alarm_full_desc, R.string.button_got_it, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null)).show(var8, "ConfirmationDialogLeftAligned");
            return;
         }
      } else {
         var1 = this.getDevice().getAlarms().indexOf((Object)null);
         if (var1 >= 0) {
            AlarmEditActivity.Companion.launch((Context)this, this.getDevice(), var1);
            return;
         }
      }

   }

   private final HasAlarm getDevice() {
      Device var1 = this.viewModel.getDevice();
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasAlarm");
      return (HasAlarm)var1;
   }

   private final void showMenuDialog() {
      CustomDialog var3 = CustomDialog.show(new OnBindView(this, com.blueair.devicedetails.R.layout.dialog_alarm_more_action) {
         final AlarmListActivity this$0;

         // $FF: synthetic method
         public static void $r8$lambda$HAaBFYSxy_wEWIXuTSIeQTSdnS0(CustomDialog var0, AlarmListActivity var1, View var2) {
            onBind$lambda$0(var0, var1, var2);
         }

         // $FF: synthetic method
         public static void $r8$lambda$fGKyBY6wA_lDLo9ix8ba5mmHsPg(CustomDialog var0, AlarmListActivity var1, View var2) {
            onBind$lambda$2(var0, var1, var2);
         }

         {
            this.this$0 = var1;
         }

         private static final void onBind$lambda$0(CustomDialog var0, AlarmListActivity var1, View var2) {
            var0.dismiss();
            var1.createNewAlarm();
         }

         private static final void onBind$lambda$2(CustomDialog var0, AlarmListActivity var1, View var2) {
            var0.dismiss();
            FragmentManager var3 = var1.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("DeleteAlarmDialogFragment", "getSimpleName(...)");
            if (!(var3.findFragmentByTag("DeleteAlarmDialogFragment") instanceof DeleteAlarmDialogFragment) && !var3.isStateSaved()) {
               ((DialogFragment)DeleteAlarmDialogFragment.Companion.newInstance$default(DeleteAlarmDialogFragment.Companion, var1.getDevice(), true, (View)null, 4, (Object)null)).show(var3, "DeleteAlarmDialogFragment");
            }

         }

         public void onBind(CustomDialog var1, View var2) {
            Intrinsics.checkNotNullParameter(var1, "dialog");
            Intrinsics.checkNotNullParameter(var2, "v");
            View var3 = var2.findViewById(com.blueair.devicedetails.R.id.tv_add);
            var2 = var2.findViewById(com.blueair.devicedetails.R.id.tv_delete);
            var3.setOnClickListener(new AlarmListActivity$showMenuDialog$1$$ExternalSyntheticLambda0(var1, this.this$0));
            var2.setOnClickListener(new AlarmListActivity$showMenuDialog$1$$ExternalSyntheticLambda1(var1, this.this$0));
         }
      });
      ActivityAlarmListBinding var2 = this.binding;
      ActivityAlarmListBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var3.setAlignBaseViewGravity((View)var1.btnMore, 17);
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      BaseLokaliseActivity var2 = this;
      ActivityAlarmListBinding var3 = null;
      BaseLokaliseActivity.immersiveStatusBar$default(var2, false, 1, (Object)null);
      ActivityAlarmListBinding var4 = ActivityAlarmListBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      this.binding = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
      } else {
         var3 = var4;
      }

      this.setContentView((View)var3.getRoot());
      this.configure();
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/activity/AlarmListActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "devicedetails_otherRelease"},
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

      public final void launch(Context var1) {
         Intrinsics.checkNotNullParameter(var1, "context");
         var1.startActivity(new Intent(var1, AlarmListActivity.class));
      }
   }
}
