package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding;
import com.blueair.devicedetails.dialog.DeviceSetScheduleModeV2DialogFragment;
import com.blueair.devicedetails.dialog.TimePickerV2DialogFragment;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(
   d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u001bH\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\u0019H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.¢\u0006\u0004\n\u0002\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u00061"},
   d2 = {"Lcom/blueair/devicedetails/activity/ScheduleOverviewActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "device", "Lcom/blueair/core/model/Device;", "repeatCheckBoxes", "", "Landroid/widget/CheckBox;", "[Landroid/widget/CheckBox;", "dayOfWeekCheckBoxList", "", "binding", "Lcom/blueair/devicedetails/databinding/ActivityDeviceScheduleOverviewBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "configureView", "shouldShowMainMode", "", "parseTimePickerResult", "Ljava/util/Calendar;", "result", "updateTimeViews", "updateRepeatDaysText", "getPurifyModeIcon", "", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "getMainModeIcon", "mainMode", "Lcom/blueair/core/model/MainMode;", "humMode", "showProgress", "hideProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScheduleOverviewActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ActivityDeviceScheduleOverviewBinding binding;
   private List dayOfWeekCheckBoxList;
   private Device device;
   private CheckBox[] repeatCheckBoxes;
   private final String screenName = "device_details_schedule_details";
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static Unit $r8$lambda$3OUdlnDlPAgdEiUH3iybz2LoNnA(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, MainMode var2) {
      return configureView$lambda$39$lambda$27(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$4pM0SptB9WeeYrFZ4zUH_6jKaDc/* $FF was: $r8$lambda$4pM0SptB9WeeYrFZ4zUH-6jKaDc*/(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, MainMode var2) {
      return configureView$lambda$39$lambda$23(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4xrE486LXA18vSvaq38kzHu3WHM(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5oGe03f3MVOByhdqS3ylV9bXb1U(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, View var2) {
      configureView$lambda$39$lambda$20(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$5qCUmrydBO4xiKd9Cv0RtZpG_XM(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, String var2) {
      return configureView$lambda$39$lambda$26(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Bk96WFOmTh7SjMQk7lixXUBrzc8(ScheduleOverviewActivity var0, Boolean var1) {
      return configureView$lambda$39$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$H0DA0hynxAmdo1COHba_lAIi_FY/* $FF was: $r8$lambda$H0DA0hynxAmdo1COHba_lAIi-FY*/(ActivityDeviceScheduleOverviewBinding var0, View var1, AccessibilityNodeInfoCompat var2) {
      return configureView$lambda$39$lambda$36(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$J_Kz2MIEijVMJK_SImaSKuGRs8k/* $FF was: $r8$lambda$J-Kz2MIEijVMJK_SImaSKuGRs8k*/(ActivityDeviceScheduleOverviewBinding var0, View var1, AccessibilityNodeInfoCompat var2) {
      return configureView$lambda$39$lambda$35(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$KgbwpPB1dLu0Ln5YAnULfr2tXLo(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$34(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$TUxPBqX71x4b6qf7_RuCSS9itf0/* $FF was: $r8$lambda$TUxPBqX71x4b6qf7-RuCSS9itf0*/(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$UaZBOvs0f4i5kaSiEYm8svN2Egc(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      return configureView$lambda$39$lambda$28(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$VefgcW6S1MHAlkGjgmkdPpFGOcE(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, View var2) {
      configureView$lambda$39$lambda$3(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WOI_RGuj2pSLbxomUVeSO_Ia_q8/* $FF was: $r8$lambda$WOI-RGuj2pSLbxomUVeSO_Ia_q8*/(ScheduleOverviewActivity var0, String var1, Bundle var2) {
      return configureView$lambda$39$lambda$9$lambda$8(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Wqr_jNtrQGp96TGYQ9q2AEh9KIA/* $FF was: $r8$lambda$Wqr-jNtrQGp96TGYQ9q2AEh9KIA*/(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$WsEACLfel1UBjtWwkrQWvq9Z2ws(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$18(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$ZYKu9RD3Dl76Ee2Zzx4ya3zCEAI(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, FanSpeedEnum var2) {
      return configureView$lambda$39$lambda$29(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_isxRs0LZq5Z_2kuwAEwwLwShso/* $FF was: $r8$lambda$_isxRs0LZq5Z-2kuwAEwwLwShso*/(ActivityDeviceScheduleOverviewBinding var0, View var1, AccessibilityNodeInfoCompat var2) {
      return configureView$lambda$39$lambda$37(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$e9hdvV9i_CIkio0ADHx37jRWz4E/* $FF was: $r8$lambda$e9hdvV9i-CIkio0ADHx37jRWz4E*/(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      return configureView$lambda$39$lambda$24(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$fv4F4SlvpmikXjTb_M_2qRpXt5g/* $FF was: $r8$lambda$fv4F4SlvpmikXjTb-M_2qRpXt5g*/(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, View var2) {
      configureView$lambda$39$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$gjYO_N0rZ0J5XKTaTXO3BH3a05I/* $FF was: $r8$lambda$gjYO-N0rZ0J5XKTaTXO3BH3a05I*/(ScheduleOverviewActivity var0, String var1, Bundle var2) {
      return configureView$lambda$39$lambda$13$lambda$12(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$gx5yNgpCTnV_yroaM9N1hweEQtg(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$9(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iuq3JfyTXI2peX3hkm_Wdsgy_7w(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, FanSpeedEnum var2) {
      return configureView$lambda$39$lambda$25(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mWBHsP_kUzkRviZlSySA2Be23nU(ActivityDeviceScheduleOverviewBinding var0, Boolean var1) {
      return configureView$lambda$39$lambda$4(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$n57fPvyaH_PW_cUiiC_zA16LaBo/* $FF was: $r8$lambda$n57fPvyaH-PW_cUiiC-zA16LaBo*/(ScheduleOverviewActivity var0, boolean var1, boolean var2) {
      return configureView$lambda$39$lambda$3$lambda$2(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nlbzp5elPhHnpE0uIPD06lajQHM(ScheduleOverviewActivity var0, View var1) {
      configureView$lambda$39$lambda$13(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$q9byRsXIYG4JJP_yswo4km7xN4k(ActivityDeviceScheduleOverviewBinding var0, ScheduleOverviewActivity var1, View var2) {
      configureView$lambda$39$lambda$16$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vl7dunNP2TaltZcrsOpWg8fcTsI(View var0, boolean var1) {
      configureView$lambda$39$lambda$38(var0, var1);
   }

   public ScheduleOverviewActivity() {
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
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(DeviceCreateEditScheduleViewModel.class), new Function0(var2) {
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

   private final void configureView() {
      ActivityDeviceScheduleOverviewBinding var1 = this.binding;
      Object var3 = null;
      ActivityDeviceScheduleOverviewBinding var2 = var1;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      var2.backBtn.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda0(this));
      var2.btnSaveChange.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda2(this, var2));
      MediatorLiveData var11 = this.getViewModel().getSaveBtnEnabled();
      LifecycleOwner var5 = (LifecycleOwner)this;
      var11.observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda7(var2)) {
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
      var2.scheduleName.setText((CharSequence)this.getViewModel().getDisplayLabel());
      this.updateTimeViews();
      this.getViewModel().isStartTimeSameAsEndTime().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda8(this)) {
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
      ViewCompat.setAccessibilityDelegate((View)var2.startTimeValue, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_start_time_content_description));
      var2.startTimeGroup.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda9(this));
      ViewCompat.setAccessibilityDelegate((View)var2.endTimeValue, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_end_time_content_description));
      var2.endTimeGroup.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda10(this));

      for(DayOfWeek var12 : (Iterable)this.getViewModel().getRepeat()) {
         CheckBox var13;
         switch (ScheduleOverviewActivity.WhenMappings.$EnumSwitchMapping$0[var12.ordinal()]) {
            case 1:
               var13 = var2.cbMon;
               break;
            case 2:
               var13 = var2.cbTue;
               break;
            case 3:
               var13 = var2.cbWed;
               break;
            case 4:
               var13 = var2.cbThu;
               break;
            case 5:
               var13 = var2.cbFri;
               break;
            case 6:
               var13 = var2.cbSat;
               break;
            case 7:
               var13 = var2.cbSun;
               break;
            default:
               throw new NoWhenBranchMatchedException();
         }

         Intrinsics.checkNotNull(var13);
         var13.setChecked(true);
      }

      this.updateRepeatDaysText();
      CheckBox var14 = var2.cbMon;
      Intrinsics.checkNotNullExpressionValue(var14, "cbMon");
      CheckBox var9 = var2.cbTue;
      Intrinsics.checkNotNullExpressionValue(var9, "cbTue");
      CheckBox var7 = var2.cbWed;
      Intrinsics.checkNotNullExpressionValue(var7, "cbWed");
      CheckBox var10 = var2.cbThu;
      Intrinsics.checkNotNullExpressionValue(var10, "cbThu");
      CheckBox var8 = var2.cbFri;
      Intrinsics.checkNotNullExpressionValue(var8, "cbFri");
      CheckBox var27 = var2.cbSat;
      Intrinsics.checkNotNullExpressionValue(var27, "cbSat");
      CheckBox var6 = var2.cbSun;
      Intrinsics.checkNotNullExpressionValue(var6, "cbSun");
      List var28 = CollectionsKt.listOf(new CheckBox[]{var14, var9, var7, var10, var8, var27, var6});
      this.dayOfWeekCheckBoxList = var28;
      List var15 = var28;
      if (var28 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
         var15 = null;
      }

      Iterator var16 = ((Iterable)var15).iterator();

      while(var16.hasNext()) {
         ((CheckBox)var16.next()).setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda12(var2, this));
      }

      ActivityDeviceScheduleOverviewBinding var29 = this.binding;
      ActivityDeviceScheduleOverviewBinding var17 = var29;
      if (var29 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var17 = null;
      }

      var17.cbEveryday.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda13(this));
      var29 = this.binding;
      var17 = var29;
      if (var29 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var17 = null;
      }

      var17.cbWeekdays.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda14(this, var2));
      var29 = this.binding;
      var17 = var29;
      if (var29 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var17 = null;
      }

      var17.cbWeekends.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda15(this, var2));
      this.getViewModel().getLiveMainMode().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda11(this, var2)) {
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
      this.getViewModel().getLivePurifierMode().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda19(this, var2)) {
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
      this.getViewModel().getLiveStartFanSpeed().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda20(this, var2)) {
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
      this.getViewModel().getScheduleEndType().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda21(this, var2)) {
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
      this.getViewModel().getLiveScheduleEndCustomMainMode().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda22(this, var2)) {
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
      this.getViewModel().getLiveScheduleEndCustomMode().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda23(this, var2)) {
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
      this.getViewModel().getLiveScheduleEndCustomFanSpeed().observe(var5, new Observer(new ScheduleOverviewActivity$$ExternalSyntheticLambda24(this, var2)) {
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
      var2.settingsStart.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda25(this));
      var2.settingsEnd.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda26(this));
      var2.btnCancel.setOnClickListener(new ScheduleOverviewActivity$$ExternalSyntheticLambda1(this));
      if (this.getViewModel().getState() == DeviceCreateEditScheduleViewModel.State.NEW) {
         var17 = this.binding;
         if (var17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var17 = (ActivityDeviceScheduleOverviewBinding)var3;
         }

         var17.title.setText((CharSequence)this.getString(R.string.create_schedule));
      }

      var2.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(var2) {
         final ActivityDeviceScheduleOverviewBinding $this_apply;
         private long lastScrollTime;

         {
            this.$this_apply = var1;
         }

         public final long getLastScrollTime() {
            return this.lastScrollTime;
         }

         public void onScrollChange(NestedScrollView var1, int var2, int var3, int var4, int var5) {
            Intrinsics.checkNotNullParameter(var1, "v");
            this.lastScrollTime = System.currentTimeMillis();
            this.$this_apply.bottomBar.setBackgroundColor(-1);
            View var6 = this.$this_apply.separator;
            Intrinsics.checkNotNullExpressionValue(var6, "separator");
            ViewExtensionsKt.show$default(var6, false, 1, (Object)null);
            ((View)var1).postDelayed(new Runnable(this, this.$this_apply) {
               final ActivityDeviceScheduleOverviewBinding $this_apply$inlined;
               final <undefinedtype> this$0;

               public {
                  this.this$0 = var1;
                  this.$this_apply$inlined = var2;
               }

               public final void run() {
                  if (System.currentTimeMillis() - this.this$0.getLastScrollTime() > 250L) {
                     this.$this_apply$inlined.bottomBar.setBackgroundColor(0);
                     View var1 = this.$this_apply$inlined.separator;
                     Intrinsics.checkNotNullExpressionValue(var1, "separator");
                     ViewExtensionsKt.hide(var1);
                  }

               }
            }, 300L);
         }

         public final void setLastScrollTime(long var1) {
            this.lastScrollTime = var1;
         }
      });
      String var21 = this.getString(R.string.button_role);
      Intrinsics.checkNotNullExpressionValue(var21, "getString(...)");
      ViewUtils var23 = ViewUtils.INSTANCE;
      ShadowLayout var32 = var2.startTimeGroup;
      Intrinsics.checkNotNullExpressionValue(var32, "startTimeGroup");
      ViewUtils.setAccessibilityDelegate$default(var23, (View)var32, (KClass)null, var21, new ScheduleOverviewActivity$$ExternalSyntheticLambda3(var2), 2, (Object)null);
      var23 = ViewUtils.INSTANCE;
      var32 = var2.endTimeGroup;
      Intrinsics.checkNotNullExpressionValue(var32, "endTimeGroup");
      ViewUtils.setAccessibilityDelegate$default(var23, (View)var32, (KClass)null, var21, new ScheduleOverviewActivity$$ExternalSyntheticLambda4(var2), 2, (Object)null);
      var23 = ViewUtils.INSTANCE;
      var32 = var2.settingsStart;
      Intrinsics.checkNotNullExpressionValue(var32, "settingsStart");
      ViewUtils.setAccessibilityDelegate$default(var23, (View)var32, (KClass)null, var21, (Function2)null, 10, (Object)null);
      var23 = ViewUtils.INSTANCE;
      var32 = var2.settingsEnd;
      Intrinsics.checkNotNullExpressionValue(var32, "settingsEnd");
      ViewUtils.setAccessibilityDelegate$default(var23, (View)var32, (KClass)null, var21, new ScheduleOverviewActivity$$ExternalSyntheticLambda5(var2), 2, (Object)null);
      ScheduleOverviewActivity$$ExternalSyntheticLambda6 var22 = new ScheduleOverviewActivity$$ExternalSyntheticLambda6();
      var2.startTimeGroup.setOnFocusChangeListener(var22);
      var2.endTimeGroup.setOnFocusChangeListener(var22);
      var2.settingsStart.setOnFocusChangeListener(var22);
      var2.settingsEnd.setOnFocusChangeListener(var22);
   }

   private static final void configureView$lambda$39$lambda$0(ScheduleOverviewActivity var0, View var1) {
      var0.finish();
   }

   private static final void configureView$lambda$39$lambda$13(ScheduleOverviewActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerV2DialogFragment", "getSimpleName(...)");
      DialogFragment var4;
      if (!(var2.findFragmentByTag("TimePickerV2DialogFragment") instanceof TimePickerV2DialogFragment) && !var2.isStateSaved()) {
         TimePickerV2DialogFragment.Companion var3 = TimePickerV2DialogFragment.Companion;
         String var5 = var0.getString(R.string.schedule_end_time);
         Intrinsics.checkNotNullExpressionValue(var5, "getString(...)");
         var4 = TimePickerV2DialogFragment.Companion.newInstance$default(var3, var5, var0.getViewModel().getEndTime(), false, 4, (Object)null);
         ((DialogFragment)var4).show(var2, "TimePickerV2DialogFragment");
      } else {
         var4 = null;
      }

      var4 = var4;
      if (var4 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var4, "TimePickerV2DialogFragment", new ScheduleOverviewActivity$$ExternalSyntheticLambda16(var0));
      }

   }

   private static final Unit configureView$lambda$39$lambda$13$lambda$12(ScheduleOverviewActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      Calendar var3 = var0.parseTimePickerResult(var2);
      if (var3 != null) {
         var0.getViewModel().setEndTime(var3);
         var0.updateTimeViews();
      }

      return Unit.INSTANCE;
   }

   private static final void configureView$lambda$39$lambda$16$lambda$15(ActivityDeviceScheduleOverviewBinding var0, ScheduleOverviewActivity var1, View var2) {
      Set var3 = (Set)(new LinkedHashSet());
      if (var0.cbMon.isChecked()) {
         var3.add(DayOfWeek.MON);
      }

      if (var0.cbTue.isChecked()) {
         var3.add(DayOfWeek.TUE);
      }

      if (var0.cbWed.isChecked()) {
         var3.add(DayOfWeek.WED);
      }

      if (var0.cbThu.isChecked()) {
         var3.add(DayOfWeek.THU);
      }

      if (var0.cbFri.isChecked()) {
         var3.add(DayOfWeek.FRI);
      }

      if (var0.cbSat.isChecked()) {
         var3.add(DayOfWeek.SAT);
      }

      if (var0.cbSun.isChecked()) {
         var3.add(DayOfWeek.SUN);
      }

      var1.getViewModel().setRepeat(var3);
      var1.updateRepeatDaysText();
   }

   private static final void configureView$lambda$39$lambda$18(ScheduleOverviewActivity var0, View var1) {
      var0.getViewModel().setRepeat(DayOfWeekExtensionKt.getEverydaySet(DayOfWeek.Companion));
      List var2 = var0.dayOfWeekCheckBoxList;
      List var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
         var3 = null;
      }

      Iterator var4 = ((Iterable)var3).iterator();

      while(var4.hasNext()) {
         ((CheckBox)var4.next()).setChecked(true);
      }

      var0.updateRepeatDaysText();
   }

   private static final void configureView$lambda$39$lambda$20(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, View var2) {
      var0.getViewModel().setRepeat(DayOfWeekExtensionKt.getWeekdaySet(DayOfWeek.Companion));
      List var3 = var0.dayOfWeekCheckBoxList;
      List var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
         var4 = null;
      }

      for(CheckBox var6 : (Iterable)var4) {
         var6.setChecked(true ^ ArraysKt.contains(new CheckBox[]{var1.cbSat, var1.cbSun}, var6));
      }

      var0.updateRepeatDaysText();
   }

   private static final void configureView$lambda$39$lambda$22(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, View var2) {
      var0.getViewModel().setRepeat(DayOfWeekExtensionKt.getWeekendSet(DayOfWeek.Companion));
      List var3 = var0.dayOfWeekCheckBoxList;
      List var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("dayOfWeekCheckBoxList");
         var4 = null;
      }

      for(CheckBox var5 : (Iterable)var4) {
         var5.setChecked(ArraysKt.contains(new CheckBox[]{var1.cbSat, var1.cbSun}, var5));
      }

      var0.updateRepeatDaysText();
   }

   private static final Unit configureView$lambda$39$lambda$23(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, MainMode var2) {
      configureView$lambda$39$updateStartMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$24(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      configureView$lambda$39$updateStartMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$25(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, FanSpeedEnum var2) {
      configureView$lambda$39$updateStartMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$26(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, String var2) {
      configureView$lambda$39$updateEndMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$27(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, MainMode var2) {
      configureView$lambda$39$updateEndMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$28(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      configureView$lambda$39$updateEndMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$29(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, FanSpeedEnum var2) {
      configureView$lambda$39$updateEndMode(var0, var1);
      return Unit.INSTANCE;
   }

   private static final void configureView$lambda$39$lambda$3(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1, View var2) {
      var0.showProgress();
      var0.getViewModel().setLabel(String.valueOf(var1.scheduleName.getText()));
      var0.getViewModel().onComplete(new ScheduleOverviewActivity$$ExternalSyntheticLambda17(var0));
   }

   private static final Unit configureView$lambda$39$lambda$3$lambda$2(ScheduleOverviewActivity var0, boolean var1, boolean var2) {
      var0.hideProgress();
      if (var1) {
         FragmentManager var3 = var0.getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
         if (!(var3.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var3.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.overlap_title, R.string.overlap_content, R.string.btn_cancel, (Integer)null, false, false, false, (String[])null, 240, (Object)null)).show(var3, "ConfirmationDialogCentered");
         }
      } else if (var2) {
         var0.setResult(-1);
         var0.finish();
      }

      return Unit.INSTANCE;
   }

   private static final void configureView$lambda$39$lambda$31(ScheduleOverviewActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceSetScheduleModeV2DialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceSetScheduleModeV2DialogFragment") instanceof DeviceSetScheduleModeV2DialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)DeviceSetScheduleModeV2DialogFragment.Companion.newInstance(true)).show(var2, "DeviceSetScheduleModeV2DialogFragment");
      }

   }

   private static final void configureView$lambda$39$lambda$33(ScheduleOverviewActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceSetScheduleModeV2DialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceSetScheduleModeV2DialogFragment") instanceof DeviceSetScheduleModeV2DialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)DeviceSetScheduleModeV2DialogFragment.Companion.newInstance(false)).show(var2, "DeviceSetScheduleModeV2DialogFragment");
      }

   }

   private static final void configureView$lambda$39$lambda$34(ScheduleOverviewActivity var0, View var1) {
      var0.finish();
   }

   private static final Unit configureView$lambda$39$lambda$35(ActivityDeviceScheduleOverviewBinding var0, View var1, AccessibilityNodeInfoCompat var2) {
      Intrinsics.checkNotNullParameter(var1, "v");
      Intrinsics.checkNotNullParameter(var2, "info");
      StringBuilder var3 = new StringBuilder();
      var3.append(var0.startTimeLabel.getText());
      var3.append(", ");
      var3.append(var0.startTimeValue.getText());
      var2.setContentDescription((CharSequence)var3.toString());
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$36(ActivityDeviceScheduleOverviewBinding var0, View var1, AccessibilityNodeInfoCompat var2) {
      Intrinsics.checkNotNullParameter(var1, "v");
      Intrinsics.checkNotNullParameter(var2, "info");
      StringBuilder var3 = new StringBuilder();
      var3.append(var0.endTimeLabel.getText());
      var3.append(", ");
      var3.append(var0.endTimeValue.getText());
      var2.setContentDescription((CharSequence)var3.toString());
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$37(ActivityDeviceScheduleOverviewBinding var0, View var1, AccessibilityNodeInfoCompat var2) {
      Intrinsics.checkNotNullParameter(var1, "v");
      Intrinsics.checkNotNullParameter(var2, "info");
      MaterialButton var3 = var0.btnLastUsed;
      Intrinsics.checkNotNullExpressionValue(var3, "btnLastUsed");
      if (((View)var3).getVisibility() == 0) {
         StringBuilder var4 = new StringBuilder();
         var4.append(var2.getContentDescription());
         var4.append(", ");
         var4.append(var0.btnLastUsed.getText());
         var2.setContentDescription((CharSequence)var4.toString());
      }

      return Unit.INSTANCE;
   }

   private static final void configureView$lambda$39$lambda$38(View var0, boolean var1) {
      if (var0 instanceof ViewGroup) {
         ViewGroup var3 = (ViewGroup)var0;
         var0 = var3.getChildAt(0);
         int var2;
         if (var1) {
            var2 = R.drawable.rounded_rectangle_white_r16_focused_stroke2;
         } else if (var0.isSelected()) {
            var2 = R.drawable.rounded_rectangle_white_r16_warning_stroke1;
         } else {
            var2 = R.drawable.rounded_rectangle_white_r16_black5_stroke1;
         }

         var0 = var3.getChildAt(0);
         if (var0 != null) {
            var0.setBackgroundResource(var2);
         }
      }

   }

   private static final Unit configureView$lambda$39$lambda$4(ActivityDeviceScheduleOverviewBinding var0, Boolean var1) {
      MaterialButton var2 = var0.btnSaveChange;
      Intrinsics.checkNotNull(var1);
      var2.setEnabled(var1);
      return Unit.INSTANCE;
   }

   private static final Unit configureView$lambda$39$lambda$5(ScheduleOverviewActivity var0, Boolean var1) {
      int var2;
      if (var1) {
         var2 = R.drawable.rounded_rectangle_white_r16_warning_stroke1;
      } else {
         var2 = R.drawable.rounded_rectangle_white_r16_black5_stroke1;
      }

      ActivityDeviceScheduleOverviewBinding var5 = var0.binding;
      Object var4 = null;
      ActivityDeviceScheduleOverviewBinding var3 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var3 = null;
      }

      FrameLayout var8 = var3.flStartTime;
      Intrinsics.checkNotNull(var1);
      var8.setSelected(var1);
      var5 = var0.binding;
      ActivityDeviceScheduleOverviewBinding var9 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      var9.flEndTime.setSelected(var1);
      var9 = var0.binding;
      ActivityDeviceScheduleOverviewBinding var7 = var9;
      if (var9 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var7 = null;
      }

      var7.flStartTime.setBackgroundResource(var2);
      ActivityDeviceScheduleOverviewBinding var6 = var0.binding;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = (ActivityDeviceScheduleOverviewBinding)var4;
      }

      var6.flEndTime.setBackgroundResource(var2);
      return Unit.INSTANCE;
   }

   private static final void configureView$lambda$39$lambda$9(ScheduleOverviewActivity var0, View var1) {
      FragmentManager var2 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerV2DialogFragment", "getSimpleName(...)");
      DialogFragment var4;
      if (!(var2.findFragmentByTag("TimePickerV2DialogFragment") instanceof TimePickerV2DialogFragment) && !var2.isStateSaved()) {
         TimePickerV2DialogFragment.Companion var5 = TimePickerV2DialogFragment.Companion;
         String var3 = var0.getString(R.string.schedule_start_time_label);
         Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
         var4 = TimePickerV2DialogFragment.Companion.newInstance$default(var5, var3, var0.getViewModel().getStartTime(), false, 4, (Object)null);
         ((DialogFragment)var4).show(var2, "TimePickerV2DialogFragment");
      } else {
         var4 = null;
      }

      var4 = var4;
      if (var4 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var4, "TimePickerV2DialogFragment", new ScheduleOverviewActivity$$ExternalSyntheticLambda18(var0));
      }

   }

   private static final Unit configureView$lambda$39$lambda$9$lambda$8(ScheduleOverviewActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      Calendar var3 = var0.parseTimePickerResult(var2);
      if (var3 != null) {
         var0.getViewModel().setStartTime(var3);
         var0.updateTimeViews();
      }

      return Unit.INSTANCE;
   }

   private static final void configureView$lambda$39$updateEndMode(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1) {
      if (!Intrinsics.areEqual(var0.getViewModel().getScheduleEndType().getValue(), "custom")) {
         MaterialButton var7 = var1.btnLastUsed;
         Intrinsics.checkNotNullExpressionValue(var7, "btnLastUsed");
         ViewExtensionsKt.show$default((View)var7, false, 1, (Object)null);
         ImageView var8 = var1.ivEndMainMode;
         Intrinsics.checkNotNullExpressionValue(var8, "ivEndMainMode");
         ViewExtensionsKt.hide((View)var8);
         SimpleIconTextView var9 = var1.ictvEndMode;
         Intrinsics.checkNotNullExpressionValue(var9, "ictvEndMode");
         ViewExtensionsKt.hide((View)var9);
      } else {
         MaterialButton var3 = var1.btnLastUsed;
         Intrinsics.checkNotNullExpressionValue(var3, "btnLastUsed");
         ViewExtensionsKt.hide((View)var3);
         if (var0.getViewModel().getScheduleEndCustomMode() != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY && var0.shouldShowMainMode()) {
            int var2 = var0.getMainModeIcon(var0.getViewModel().getScheduleEndCustomMainMode(), var0.getViewModel().getScheduleEndCustomHumMode());
            if (var2 == 0) {
               ImageView var13 = var1.ivEndMainMode;
               Intrinsics.checkNotNullExpressionValue(var13, "ivEndMainMode");
               ViewExtensionsKt.hide((View)var13);
            } else {
               ImageView var14 = var1.ivEndMainMode;
               Intrinsics.checkNotNullExpressionValue(var14, "ivEndMainMode");
               ViewExtensionsKt.show$default((View)var14, false, 1, (Object)null);
               var1.ivEndMainMode.setImageResource(var2);
            }
         } else {
            ImageView var12 = var1.ivEndMainMode;
            Intrinsics.checkNotNullExpressionValue(var12, "ivEndMainMode");
            ViewExtensionsKt.hide((View)var12);
         }

         int var10 = var0.getPurifyModeIcon(var0.getViewModel().getScheduleEndCustomMode());
         var1.ictvEndMode.setIconResource(var10);
         if (var0.getViewModel().getScheduleEndCustomMode() == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
            FanSpeedUtils var5 = FanSpeedUtils.INSTANCE;
            Device var4 = var0.device;
            Device var15 = var4;
            if (var4 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var15 = null;
            }

            var10 = var5.getFanSpeedLevel(var15, var0.getViewModel().getScheduleEndCustomFanSpeed());
            var1.ictvEndMode.setText(String.valueOf(var10));
         } else {
            var1.ictvEndMode.hideText();
         }

         SimpleIconTextView var6 = var1.ictvEndMode;
         Intrinsics.checkNotNullExpressionValue(var6, "ictvEndMode");
         ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
      }
   }

   private static final void configureView$lambda$39$updateStartMode(ScheduleOverviewActivity var0, ActivityDeviceScheduleOverviewBinding var1) {
      DeviceCreateEditScheduleViewModel.PurifierMode var4 = var0.getViewModel().getPurifierMode();
      DeviceCreateEditScheduleViewModel.PurifierMode var5 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
      Device var3 = null;
      if (var4 != var5 && var0.shouldShowMainMode()) {
         int var2 = var0.getMainModeIcon(var0.getViewModel().getStartMainMode(), var0.getViewModel().getStartHumMode());
         if (var2 == 0) {
            ImageView var8 = var1.ivStartMainMode;
            Intrinsics.checkNotNullExpressionValue(var8, "ivStartMainMode");
            ViewExtensionsKt.hide((View)var8);
         } else {
            ImageView var9 = var1.ivStartMainMode;
            Intrinsics.checkNotNullExpressionValue(var9, "ivStartMainMode");
            ViewExtensionsKt.show$default((View)var9, false, 1, (Object)null);
            var1.ivStartMainMode.setImageResource(var2);
         }
      } else {
         ImageView var7 = var1.ivStartMainMode;
         Intrinsics.checkNotNullExpressionValue(var7, "ivStartMainMode");
         ViewExtensionsKt.hide((View)var7);
      }

      var1.ictvStartMode.setIconResource(var0.getPurifyModeIcon(var0.getViewModel().getPurifierMode()));
      if (var0.getViewModel().getPurifierMode() == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
         FanSpeedUtils var11 = FanSpeedUtils.INSTANCE;
         Device var10 = var0.device;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
         } else {
            var3 = var10;
         }

         int var6 = var11.getFanSpeedLevel(var3, var0.getViewModel().getStartFanSpeed());
         var1.ictvStartMode.setText(String.valueOf(var6));
      } else {
         var1.ictvStartMode.hideText();
      }
   }

   private final int getMainModeIcon(MainMode var1, boolean var2) {
      Device var5 = this.device;
      Device var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var4 = null;
      }

      if (var4 instanceof HasHumMode) {
         return var2 ? ModeIcon.HUM.getFlatIcon() : ModeIcon.AIR_PURIFY.getFlatIcon();
      } else {
         int var3 = ScheduleOverviewActivity.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
         if (var3 != 1) {
            if (var3 != 2) {
               if (var3 != 3) {
                  if (var3 != 4) {
                     return var3 != 5 ? 0 : ModeIcon.HUM.getFlatIcon();
                  } else {
                     return R.drawable.mode_icon_dehum_flat;
                  }
               } else {
                  return ModeIcon.COOL.getFlatIcon();
               }
            } else {
               return ModeIcon.HEAT.getFlatIcon();
            }
         } else {
            return ModeIcon.AIR_PURIFY.getFlatIcon();
         }
      }
   }

   private final int getPurifyModeIcon(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Device var3 = this.device;
      Device var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var2 = null;
      }

      return var1.toModeIcon(var2).getFlatIcon();
   }

   private final DeviceCreateEditScheduleViewModel getViewModel() {
      return (DeviceCreateEditScheduleViewModel)this.viewModel$delegate.getValue();
   }

   private final void hideProgress() {
      ActivityDeviceScheduleOverviewBinding var2 = this.binding;
      ActivityDeviceScheduleOverviewBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ProgressBlockerView var3 = var1.progressView;
      Intrinsics.checkNotNullExpressionValue(var3, "progressView");
      ViewExtensionsKt.hide((View)var3);
   }

   private final Calendar parseTimePickerResult(Bundle var1) {
      int var3 = var1.getInt("ARG_HOUR_OF_DAY", -1);
      int var2 = var1.getInt("ARG_MINUTE", -1);
      if (var3 != -1 && var2 != -1) {
         Calendar var4 = Calendar.getInstance();
         var4.set(11, var3);
         var4.set(12, var2);
         return var4;
      } else {
         return null;
      }
   }

   private final boolean shouldShowMainMode() {
      Device var3 = this.device;
      Object var2 = null;
      Device var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var1 = null;
      }

      if (!(var1 instanceof HasCombo3in1MainMode)) {
         var3 = this.device;
         var1 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var1 = null;
         }

         if (!(var1 instanceof HasDehumidifierMainMode)) {
            var3 = this.device;
            var1 = var3;
            if (var3 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var1 = null;
            }

            if (!(var1 instanceof HasHumMainMode)) {
               var1 = this.device;
               if (var1 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("device");
                  var1 = (Device)var2;
               }

               if (!(var1 instanceof HasHumMode)) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private final void showProgress() {
      ActivityDeviceScheduleOverviewBinding var2 = this.binding;
      ActivityDeviceScheduleOverviewBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ProgressBlockerView var3 = var1.progressView;
      Intrinsics.checkNotNullExpressionValue(var3, "progressView");
      ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
   }

   private final void updateRepeatDaysText() {
      Set var6 = this.getViewModel().getRepeat();
      byte var1;
      if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, var6)) {
         var1 = 0;
      } else if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, var6)) {
         var1 = 1;
      } else if (DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, var6)) {
         var1 = 2;
      } else {
         var1 = -1;
      }

      CheckBox var7 = this.repeatCheckBoxes;
      CheckBox[] var8 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("repeatCheckBoxes");
         var8 = null;
      }

      int var4 = var8.length;
      int var3 = 0;

      for(int var2 = 0; var3 < var4; ++var2) {
         var7 = var8[var3];
         boolean var5;
         if (var2 == var1) {
            var5 = true;
         } else {
            var5 = false;
         }

         var7.setChecked(var5);
         ++var3;
      }

   }

   private final void updateTimeViews() {
      ActivityDeviceScheduleOverviewBinding var3 = this.binding;
      Object var2 = null;
      ActivityDeviceScheduleOverviewBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      var1.startTimeValue.setText((CharSequence)this.getViewModel().getDisplayStartTime());
      var1 = this.binding;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = (ActivityDeviceScheduleOverviewBinding)var2;
      }

      var1.endTimeValue.setText((CharSequence)this.getViewModel().getDisplayEndTime());
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(this.onCreateView());
      this.configureView();
   }

   public final View onCreateView() {
      this.getViewModel().initTimeFormat((Context)this);
      Intent var1 = this.getIntent();
      Object var2 = null;
      Device var6;
      if (var1 != null) {
         var6 = (Device)var1.getParcelableExtra("device");
      } else {
         var6 = null;
      }

      if (var6 != null) {
         this.device = var6;
         DeviceCreateEditScheduleViewModel var4 = this.getViewModel();
         Device var3 = this.device;
         var6 = var3;
         if (var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var6 = null;
         }

         var4.setDevice(var6);
         DeviceCreateEditScheduleViewModel var17 = this.getViewModel();
         Intent var8 = this.getIntent();
         DeviceScheduleMerged var9;
         if (var8 != null) {
            var9 = (DeviceScheduleMerged)var8.getParcelableExtra("schedule_merged");
         } else {
            var9 = null;
         }

         var17.setEditingSchedule(var9);
         ActivityDeviceScheduleOverviewBinding var18 = ActivityDeviceScheduleOverviewBinding.inflate(this.getLayoutInflater());
         Intrinsics.checkNotNullExpressionValue(var18, "inflate(...)");
         this.binding = var18;
         ActivityDeviceScheduleOverviewBinding var10 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = null;
         }

         this.setContentView((View)var10.getRoot());
         var18 = this.binding;
         var10 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = null;
         }

         CheckBox var22 = var10.cbEveryday;
         Intrinsics.checkNotNullExpressionValue(var22, "cbEveryday");
         var18 = this.binding;
         var10 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = null;
         }

         CheckBox var5 = var10.cbWeekdays;
         Intrinsics.checkNotNullExpressionValue(var5, "cbWeekdays");
         var18 = this.binding;
         var10 = var18;
         if (var18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var10 = null;
         }

         CheckBox var14 = var10.cbWeekends;
         Intrinsics.checkNotNullExpressionValue(var14, "cbWeekends");
         this.repeatCheckBoxes = new CheckBox[]{var22, var5, var14};
         ActivityDeviceScheduleOverviewBinding var15 = this.binding;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var15 = (ActivityDeviceScheduleOverviewBinding)var2;
         }

         ConstraintLayout var16 = var15.getRoot();
         Intrinsics.checkNotNullExpressionValue(var16, "getRoot(...)");
         return (View)var16;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/activity/ScheduleOverviewActivity$Companion;", "", "<init>", "()V", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "mergedSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "devicedetails_otherRelease"},
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

      // $FF: synthetic method
      public static Intent getLaunchIntent$default(Companion var0, Context var1, Device var2, DeviceScheduleMerged var3, int var4, Object var5) {
         if ((var4 & 4) != 0) {
            var3 = null;
         }

         return var0.getLaunchIntent(var1, var2, var3);
      }

      public final Intent getLaunchIntent(Context var1, Device var2, DeviceScheduleMerged var3) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intent var4 = new Intent(var1, ScheduleOverviewActivity.class);
         var4.putExtra("device", var2);
         var4.putExtra("schedule_merged", var3);
         return var4;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[DayOfWeek.values().length];

         try {
            var0[DayOfWeek.MON.ordinal()] = 1;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[DayOfWeek.TUE.ordinal()] = 2;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[DayOfWeek.WED.ordinal()] = 3;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DayOfWeek.THU.ordinal()] = 4;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DayOfWeek.FRI.ordinal()] = 5;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DayOfWeek.SAT.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DayOfWeek.SUN.ordinal()] = 7;
         } catch (NoSuchFieldError var7) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.AirPurify.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MainMode.Dehumidification.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MainMode.Humidification.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
