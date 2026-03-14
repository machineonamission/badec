package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blueair.core.model.AlarmSound;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.HasAlarm;
import com.blueair.devicedetails.databinding.ActivityAlarmEditBinding;
import com.blueair.devicedetails.dialog.DeviceAlarmSoundPickerDialogFragment;
import com.blueair.devicedetails.dialog.TimePickerV2DialogFragment;
import com.blueair.devicedetails.viewholder.DeviceOfflineV2Holder;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.dialog.TroubleshootingDialog;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.utils.ByteLengthFilter;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import com.google.android.material.textfield.TextInputEditText;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020#H\u0014J\b\u0010'\u001a\u00020\u001eH\u0002J\b\u0010(\u001a\u00020#H\u0002J\b\u0010)\u001a\u00020#H\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u001e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010!¨\u0006+"},
   d2 = {"Lcom/blueair/devicedetails/activity/AlarmEditActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/ActivityAlarmEditBinding;", "viewModel", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "device", "Lcom/blueair/core/model/HasAlarm;", "alarmIndex", "", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "alarmTime", "Ljava/util/Calendar;", "value", "Lcom/blueair/core/model/AlarmSound;", "alarmSound", "setAlarmSound", "(Lcom/blueair/core/model/AlarmSound;)V", "", "Lcom/blueair/core/model/DayOfWeek;", "repeatDays", "setRepeatDays", "(Ljava/util/Set;)V", "", "offlineClosed", "setOfflineClosed", "(Z)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "checkAlarmMutualExclusive", "showProgress", "hideProgress", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AlarmEditActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_ALARM_INDEX = "EXTRA_ALARM_INDEX";
   private DeviceAlarm alarm;
   private int alarmIndex;
   private AlarmSound alarmSound;
   private Calendar alarmTime;
   private ActivityAlarmEditBinding binding;
   private HasAlarm device;
   private boolean offlineClosed;
   private Set repeatDays;
   private final String screenName = "device_details_alarm_details";
   private final DeviceDetailsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$5X6OyvskfzDBg9fZw0la10pw7kE(AlarmEditActivity var0, ActivityAlarmEditBinding var1, CompoundButton var2, boolean var3) {
      onCreate$lambda$30$lambda$11(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$7JkGQnjrF0vKVWUQGGPrJ_ax_gg(AlarmEditActivity var0, ActivityAlarmEditBinding var1, String var2, Bundle var3) {
      return onCreate$lambda$30$lambda$10$lambda$9(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$8sHK7aJ8FgiV54EHQjwZDoRYQqg(AlarmEditActivity var0, String var1, Bundle var2) {
      return onCreate$lambda$30$lambda$15$lambda$14(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$9G8fuikKJ6VIMtLFh0vT_GLoUcI(ActivityAlarmEditBinding var0, AlarmEditActivity var1, View var2) {
      onCreate$lambda$30$lambda$20$lambda$19(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$BmtYzqxdZ4XPAn3CdWSjbsVS_H8(AlarmEditActivity var0, View var1) {
      onCreate$lambda$30$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Dkl_nKdmePRcev7vDZjG6QHE2AU(AlarmEditActivity var0, List var1, ActivityAlarmEditBinding var2, View var3) {
      onCreate$lambda$30$lambda$26(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$K9rHDn1SPhIpnjdl9g3mKa_vdC4/* $FF was: $r8$lambda$K9rHDn1SPhIpnjdl9g3mKa-vdC4*/(AlarmEditActivity var0, List var1, View var2) {
      onCreate$lambda$30$lambda$22(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$PurrXashedu9Enu_MnGktEc87_M/* $FF was: $r8$lambda$PurrXashedu9Enu-MnGktEc87-M*/(AlarmEditActivity var0, List var1, ActivityAlarmEditBinding var2, View var3) {
      onCreate$lambda$30$lambda$24(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$QiW5O1nT8Eh5_mm2fiDs3Gq_Hs4/* $FF was: $r8$lambda$QiW5O1nT8Eh5-mm2fiDs3Gq_Hs4*/(AlarmEditActivity var0, ActivityAlarmEditBinding var1, View var2) {
      onCreate$lambda$30$lambda$17(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$WWVZ3A_FeE9IpnUNN7VDgP_BhVw(AlarmEditActivity var0, ActivityAlarmEditBinding var1, CompoundButton var2, boolean var3) {
      onCreate$lambda$30$lambda$16(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$eWzuFgW7Gwo301OsNAAVI_tkH7Q/* $FF was: $r8$lambda$eWzuFgW7Gwo301OsNAAVI-tkH7Q*/(AlarmEditActivity var0) {
      return onCreate$lambda$30$lambda$6(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$i1VSE8DjMXFUDq5TLnw7PG57d9A(AlarmEditActivity var0, View var1) {
      onCreate$lambda$30$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$iExXvp3OiPRqwgFZG2YWJ95UlYA(AlarmEditActivity var0) {
      return onCreate$lambda$30$lambda$4(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$jUtlI_oMhOef_S9kUUgyA6uoheI/* $FF was: $r8$lambda$jUtlI-oMhOef-S9kUUgyA6uoheI*/(AlarmEditActivity var0, ActivityAlarmEditBinding var1, View var2) {
      onCreate$lambda$30$lambda$15(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kwQGfi8oCZeWklDFPTM4sOk_M68(AlarmEditActivity var0, ActivityAlarmEditBinding var1, View var2) {
      onCreate$lambda$30$lambda$10(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mGYhlFOv_WPpiJRncoX6PSI2in8(ActivityAlarmEditBinding var0, AlarmEditActivity var1, Boolean var2) {
      return onCreate$lambda$30$lambda$7(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pH5P_pFvYRholby_9vVCYNwrDYY/* $FF was: $r8$lambda$pH5P-pFvYRholby_9vVCYNwrDYY*/(AlarmEditActivity var0, ActivityAlarmEditBinding var1, DeviceAlarm var2, View var3) {
      onCreate$lambda$30$lambda$29(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xqJTq_S_mNK6budPmeBPF8RxvPg/* $FF was: $r8$lambda$xqJTq-S-mNK6budPmeBPF8RxvPg*/(ActivityAlarmEditBinding var0, AlarmEditActivity var1, View var2) {
      onCreate$lambda$30$lambda$12(var0, var1, var2);
   }

   public AlarmEditActivity() {
      BaseActivity var1 = this;
      this.viewModel = (DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceDetailsViewModel.class));
      Calendar var2 = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(var2, "getInstance(...)");
      this.alarmTime = var2;
      this.alarmSound = AlarmSound.Birds;
      this.repeatDays = SetsKt.emptySet();
   }

   private final boolean checkAlarmMutualExclusive() {
      ActivityAlarmEditBinding var3 = this.binding;
      Object var2 = null;
      ActivityAlarmEditBinding var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      if (!var1.ringtoneSwitch.isChecked()) {
         var1 = this.binding;
         if (var1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var1 = (ActivityAlarmEditBinding)var2;
         }

         if (!var1.sunriseSwitch.isChecked()) {
            FragmentManager var5 = this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var5, "getSupportFragmentManager(...)");
            Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
            if (!(var5.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var5.isStateSaved()) {
               ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.alarm_mutual_exclusive_title, (Integer)null, R.string.alarm_mutual_exclusive_msg, R.string.button_got_it, (Integer)null, false, false, false, false, (String[])null, (String)null, (Integer)null, (Function1)null, 8160, (Object)null)).show(var5, "ConfirmationDialogLeftAligned");
            }

            return true;
         }
      }

      return false;
   }

   private final void hideProgress() {
      ActivityAlarmEditBinding var2 = this.binding;
      ActivityAlarmEditBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ProgressBlockerView var3 = var1.progressView;
      Intrinsics.checkNotNullExpressionValue(var3, "progressView");
      ViewExtensionsKt.hide((View)var3);
   }

   private static final void onCreate$lambda$30$lambda$10(AlarmEditActivity var0, ActivityAlarmEditBinding var1, View var2) {
      FragmentManager var3 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerV2DialogFragment", "getSimpleName(...)");
      DialogFragment var5;
      if (!(var3.findFragmentByTag("TimePickerV2DialogFragment") instanceof TimePickerV2DialogFragment) && !var3.isStateSaved()) {
         TimePickerV2DialogFragment.Companion var4 = TimePickerV2DialogFragment.Companion;
         String var6 = var0.getString(R.string.alarm_time_picker_title);
         Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
         var5 = TimePickerV2DialogFragment.Companion.newInstance$default(var4, var6, var0.alarmTime, false, 4, (Object)null);
         ((DialogFragment)var5).show(var3, "TimePickerV2DialogFragment");
      } else {
         var5 = null;
      }

      var5 = var5;
      if (var5 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var5, "TimePickerV2DialogFragment", new AlarmEditActivity$$ExternalSyntheticLambda8(var0, var1));
      }

   }

   private static final Unit onCreate$lambda$30$lambda$10$lambda$9(AlarmEditActivity var0, ActivityAlarmEditBinding var1, String var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var2, "<unused var>");
      Intrinsics.checkNotNullParameter(var3, "result");
      int var5 = var3.getInt("ARG_HOUR_OF_DAY", -1);
      int var4 = var3.getInt("ARG_MINUTE", -1);
      if (var5 != -1 && var4 != -1) {
         var0.alarmTime.set(11, var5);
         var0.alarmTime.set(12, var4);
         var1.timeValue.setText((CharSequence)var0.viewModel.getCurrentTimeFormatter().format(var0.alarmTime.getTime()));
      }

      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$30$lambda$11(AlarmEditActivity var0, ActivityAlarmEditBinding var1, CompoundButton var2, boolean var3) {
      if (!var3 && var0.checkAlarmMutualExclusive()) {
         var1.ringtoneSwitch.setChecked(true);
      } else {
         Group var4 = var1.ringtoneContent;
         Intrinsics.checkNotNullExpressionValue(var4, "ringtoneContent");
         ViewExtensionsKt.show((View)var4, var3);
      }
   }

   private static final void onCreate$lambda$30$lambda$12(ActivityAlarmEditBinding var0, AlarmEditActivity var1, View var2) {
      if (!var0.ringtoneSwitch.isChecked()) {
         DeviceDetailsViewModel var5 = var1.viewModel;
         HasAlarm var4 = var1.device;
         HasAlarm var3 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var3 = null;
         }

         var5.stopAlarm(var3);
      }

   }

   private static final void onCreate$lambda$30$lambda$15(AlarmEditActivity var0, ActivityAlarmEditBinding var1, View var2) {
      FragmentManager var5 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var5, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceAlarmSoundPickerDialogFragment", "getSimpleName(...)");
      DialogFragment var3;
      if (!(var5.findFragmentByTag("DeviceAlarmSoundPickerDialogFragment") instanceof DeviceAlarmSoundPickerDialogFragment) && !var5.isStateSaved()) {
         var3 = DeviceAlarmSoundPickerDialogFragment.Companion.newInstance(var0.alarmSound.getValue(), var1.seekbarVolume.getProgress());
         ((DialogFragment)var3).show(var5, "DeviceAlarmSoundPickerDialogFragment");
      } else {
         var3 = null;
      }

      var3 = var3;
      if (var3 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var3, "DeviceAlarmSoundPickerDialogFragment", new AlarmEditActivity$$ExternalSyntheticLambda0(var0));
      }

   }

   private static final Unit onCreate$lambda$30$lambda$15$lambda$14(AlarmEditActivity var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      int var3 = var2.getInt("ARG_SOUND", AlarmSound.Birds.getValue());
      var0.setAlarmSound(AlarmSound.Companion.fromValue(var3));
      return Unit.INSTANCE;
   }

   private static final void onCreate$lambda$30$lambda$16(AlarmEditActivity var0, ActivityAlarmEditBinding var1, CompoundButton var2, boolean var3) {
      if (!var3 && var0.checkAlarmMutualExclusive()) {
         var1.sunriseSwitch.setChecked(true);
      } else {
         Group var4 = var1.sunriseContent;
         Intrinsics.checkNotNullExpressionValue(var4, "sunriseContent");
         ViewExtensionsKt.show((View)var4, var3);
      }
   }

   private static final void onCreate$lambda$30$lambda$17(AlarmEditActivity var0, ActivityAlarmEditBinding var1, View var2) {
      var0.viewModel.setSunRiseLightHintClosedBefore(true);
      ConstraintLayout var3 = var1.hintContainer;
      Intrinsics.checkNotNullExpressionValue(var3, "hintContainer");
      ViewExtensionsKt.hide((View)var3);
   }

   private static final void onCreate$lambda$30$lambda$2(AlarmEditActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$30$lambda$20$lambda$19(ActivityAlarmEditBinding var0, AlarmEditActivity var1, View var2) {
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

      var1.setRepeatDays(var3);
   }

   private static final void onCreate$lambda$30$lambda$22(AlarmEditActivity var0, List var1, View var2) {
      var0.setRepeatDays(DayOfWeekExtensionKt.getEverydaySet(DayOfWeek.Companion));
      Iterator var3 = ((Iterable)var1).iterator();

      while(var3.hasNext()) {
         ((CheckBox)var3.next()).setChecked(true);
      }

   }

   private static final void onCreate$lambda$30$lambda$24(AlarmEditActivity var0, List var1, ActivityAlarmEditBinding var2, View var3) {
      var0.setRepeatDays(DayOfWeekExtensionKt.getWeekdaySet(DayOfWeek.Companion));

      for(CheckBox var5 : (Iterable)var1) {
         var5.setChecked(true ^ ArraysKt.contains(new CheckBox[]{var2.cbSat, var2.cbSun}, var5));
      }

   }

   private static final void onCreate$lambda$30$lambda$26(AlarmEditActivity var0, List var1, ActivityAlarmEditBinding var2, View var3) {
      var0.setRepeatDays(DayOfWeekExtensionKt.getWeekendSet(DayOfWeek.Companion));

      for(CheckBox var5 : (Iterable)var1) {
         var5.setChecked(ArraysKt.contains(new CheckBox[]{var2.cbSat, var2.cbSun}, var5));
      }

   }

   private static final void onCreate$lambda$30$lambda$29(AlarmEditActivity var0, ActivityAlarmEditBinding var1, DeviceAlarm var2, View var3) {
      Iterator var16 = ((Iterable)var0.repeatDays).iterator();
      int var6 = 0;

      int var4;
      for(var4 = 0; var16.hasNext(); var4 |= 1 << ((DayOfWeek)var16.next()).getMonFirstOrder()) {
      }

      int var5 = var4;
      if (var4 == 0) {
         var5 = 128;
      }

      var0.showProgress();
      DeviceDetailsViewModel var13 = var0.viewModel;
      HasAlarm var12 = var0.device;
      HasAlarm var17 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var17 = null;
      }

      Device var14 = var17;
      int var7 = var0.alarmIndex;
      CharSequence var22 = (CharSequence)String.valueOf(var1.alarmName.getText());
      var17 = var22;
      if (var22.length() == 0) {
         var17 = var0.getString(R.string.alarm_default_name);
         Intrinsics.checkNotNullExpressionValue(var17, "getString(...)");
      }

      String var19 = (String)var17;
      var4 = var6;
      if (var2 != null) {
         var4 = var6;
         if (!var2.getEnabled()) {
            var4 = 1;
         }
      }

      int var9 = var0.alarmTime.get(11);
      int var8 = var0.alarmTime.get(12);
      boolean var11 = var1.sunriseSwitch.isChecked();
      int var10 = var1.seekbarDuration.getProgress();
      if (var1.ringtoneSwitch.isChecked()) {
         AlarmSound var15;
         if (var0.alarmSound == AlarmSound.Mute) {
            var15 = AlarmSound.Birds;
         } else {
            var15 = var0.alarmSound;
         }

         var6 = var15.getValue();
      } else {
         var6 = AlarmSound.Mute.getValue();
      }

      var13.setAlarm(var14, var7 + 1, new DeviceAlarm(var19, (boolean)(var4 ^ true), var9 * 3600 + var8 * 60, var11, var10, var6, var1.seekbarVolume.getProgress(), var5), new Function2(var0, (Continuation)null) {
         Object L$0;
         int label;
         final AlarmEditActivity this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            Function2 var3 = new <anonymous constructor>(this.this$0, var2);
            var3.L$0 = var1;
            return (Continuation)var3;
         }

         public final Object invoke(ApiResult var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            ApiResult var2 = (ApiResult)this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
               ResultKt.throwOnFailure(var1);
               this.this$0.hideProgress();
               if (var2.isSuccess()) {
                  this.this$0.finish();
               }

               return Unit.INSTANCE;
            } else {
               throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
         }
      });
   }

   private static final void onCreate$lambda$30$lambda$3(AlarmEditActivity var0, View var1) {
      var0.finish();
   }

   private static final Unit onCreate$lambda$30$lambda$4(AlarmEditActivity var0) {
      var0.setOfflineClosed(true);
      return Unit.INSTANCE;
   }

   private static final Unit onCreate$lambda$30$lambda$6(AlarmEditActivity var0) {
      FragmentManager var3 = var0.getSupportFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getSupportFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TroubleshootingDialog", "getSimpleName(...)");
      if (!(var3.findFragmentByTag("TroubleshootingDialog") instanceof TroubleshootingDialog) && !var3.isStateSaved()) {
         TroubleshootingDialog.Companion var2 = TroubleshootingDialog.Companion;
         HasAlarm var1 = var0.device;
         HasAlarm var4 = var1;
         if (var1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var4 = null;
         }

         ((DialogFragment)var2.newInstance("action_type_device_offline", var4)).show(var3, "TroubleshootingDialog");
         var3.executePendingTransactions();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onCreate$lambda$30$lambda$7(ActivityAlarmEditBinding var0, AlarmEditActivity var1, Boolean var2) {
      FrameLayout var4 = var0.offlineContainer;
      Intrinsics.checkNotNullExpressionValue(var4, "offlineContainer");
      View var5 = (View)var4;
      boolean var3;
      if (var2 && !var1.offlineClosed) {
         var3 = true;
      } else {
         var3 = false;
      }

      ViewExtensionsKt.show(var5, var3);
      var0.btnSaveChange.setEnabled(var2 ^ true);
      return Unit.INSTANCE;
   }

   private final void setAlarmSound(AlarmSound var1) {
      this.alarmSound = var1;
      ActivityAlarmEditBinding var4 = this.binding;
      Object var3 = null;
      ActivityAlarmEditBinding var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var2 = null;
      }

      TextView var6 = var2.tvSoundValue;
      HasAlarm var5 = this.device;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var5 = (HasAlarm)var3;
      }

      var6.setText(var1.getName(var5.getMcuFirmware()));
   }

   private final void setOfflineClosed(boolean var1) {
      if (this.offlineClosed != var1) {
         this.offlineClosed = var1;
         ActivityAlarmEditBinding var4 = this.binding;
         ActivityAlarmEditBinding var3 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var3 = null;
         }

         FrameLayout var6 = var3.offlineContainer;
         Intrinsics.checkNotNullExpressionValue(var6, "offlineContainer");
         View var8 = (View)var6;
         Object var7 = this.viewModel.getDeviceOffline().getValue();
         boolean var2 = true;
         if (Intrinsics.areEqual(var7, true) && !var1) {
            var1 = var2;
         } else {
            var1 = false;
         }

         ViewExtensionsKt.show(var8, var1);
      }

   }

   private final void setRepeatDays(Set var1) {
      this.repeatDays = var1;
      byte var2;
      if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, var1)) {
         var2 = 0;
      } else if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, var1)) {
         var2 = 1;
      } else if (DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, var1)) {
         var2 = 2;
      } else {
         var2 = -1;
      }

      ActivityAlarmEditBinding var6 = this.binding;
      Object var5 = null;
      ActivityAlarmEditBinding var8 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      CheckBox var7 = var8.cbEveryday;
      var6 = this.binding;
      var8 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = null;
      }

      CheckBox var15 = var8.cbWeekdays;
      var8 = this.binding;
      if (var8 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var8 = (ActivityAlarmEditBinding)var5;
      }

      Iterator var11 = ((Iterable)CollectionsKt.listOf(new CheckBox[]{var7, var15, var8.cbWeekends})).iterator();

      for(int var3 = 0; var11.hasNext(); ++var3) {
         var5 = var11.next();
         if (var3 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         CheckBox var13 = (CheckBox)var5;
         boolean var4;
         if (var3 == var2) {
            var4 = true;
         } else {
            var4 = false;
         }

         var13.setChecked(var4);
      }

   }

   private final void showProgress() {
      ActivityAlarmEditBinding var2 = this.binding;
      ActivityAlarmEditBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var1 = null;
      }

      ProgressBlockerView var3 = var1.progressView;
      Intrinsics.checkNotNullExpressionValue(var3, "progressView");
      ViewExtensionsKt.show$default((View)var3, false, 1, (Object)null);
   }

   protected String getScreenName() {
      return this.screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      ActivityAlarmEditBinding var8 = ActivityAlarmEditBinding.inflate(this.getLayoutInflater());
      Intrinsics.checkNotNullExpressionValue(var8, "inflate(...)");
      this.binding = var8;
      Intent var9 = this.getIntent();
      ActivityAlarmEditBinding var4 = null;
      HasAlarm var10;
      if (var9 != null) {
         var10 = (HasAlarm)var9.getParcelableExtra("device");
      } else {
         var10 = null;
      }

      if (var10 != null) {
         this.device = var10;
         Intent var11 = this.getIntent();
         int var2;
         if (var11 != null) {
            var2 = var11.getIntExtra("EXTRA_ALARM_INDEX", 0);
         } else {
            var2 = 0;
         }

         this.alarmIndex = var2;
         HasAlarm var5 = this.device;
         HasAlarm var12 = var5;
         if (var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var12 = null;
         }

         this.alarm = (DeviceAlarm)CollectionsKt.getOrNull(var12.getAlarms(), this.alarmIndex);
         AlarmSound.Companion var13 = AlarmSound.Companion;
         DeviceAlarm var36 = this.alarm;
         if (var36 != null) {
            var2 = var36.getSound();
         } else {
            var2 = AlarmSound.Birds.getValue();
         }

         this.setAlarmSound(var13.fromValue(var2));
         DeviceAlarm var14 = this.alarm;
         if (var14 != null) {
            int var3 = var14.getSecondsInDay();
            var2 = var3 / 3600;
            this.alarmTime.set(11, var2);
            this.alarmTime.set(12, (var3 - var2 * 3600) / 60);
            this.setRepeatDays(var14.getDaysOfWeek());
         }

         ActivityAlarmEditBinding var37 = this.binding;
         ActivityAlarmEditBinding var15 = var37;
         if (var37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            var15 = null;
         }

         this.setContentView((View)var15.getRoot());
         var15 = this.binding;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
         } else {
            var4 = var15;
         }

         DeviceAlarm var6;
         label111: {
            var6 = this.alarm;
            var4.btnBack.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda9(this));
            var4.btnCancel.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda16(this));
            var4.scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(var4) {
               final ActivityAlarmEditBinding $this_apply;
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
                     final ActivityAlarmEditBinding $this_apply$inlined;
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
            var38 = var4.title;
            if (var6 != null) {
               var17 = var6.getName();
               if (var17 != null) {
                  break label111;
               }
            }

            var17 = this.getString(R.string.create_sunrise_alarm);
            Intrinsics.checkNotNullExpressionValue(var17, "getString(...)");
         }

         var38.setText((CharSequence)var17);
         if (var6 == null) {
            var4.btnSaveChange.setText(R.string.create_alarm);
         }

         TextInputEditText var7;
         label105: {
            DeviceOfflineV2Holder.Companion var18 = DeviceOfflineV2Holder.Companion;
            FrameLayout var39 = var4.offlineContainer;
            Intrinsics.checkNotNullExpressionValue(var39, "offlineContainer");
            DeviceOfflineV2Holder var19 = var18.newInstance((ViewGroup)var39, new AlarmEditActivity$$ExternalSyntheticLambda17(this), new AlarmEditActivity$$ExternalSyntheticLambda1(this));
            var4.offlineContainer.addView(var19.itemView);
            this.viewModel.getDeviceOffline().observe((LifecycleOwner)this, new Observer(new AlarmEditActivity$$ExternalSyntheticLambda2(var4, this)) {
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
            var7 = var4.alarmName;
            if (var6 != null) {
               String var40 = var6.getName();
               var20 = var40;
               if (var40 != null) {
                  break label105;
               }
            }

            var20 = this.getString(R.string.alarm_default_name);
            Intrinsics.checkNotNullExpressionValue(var20, "getString(...)");
         }

         var7.setText((CharSequence)var20);
         var4.alarmName.setFilters(new ByteLengthFilter[]{new ByteLengthFilter(21, Charsets.UTF_8)});
         var4.timeValue.setText((CharSequence)this.viewModel.getCurrentTimeFormatter().format(this.alarmTime.getTime()));
         ViewCompat.setAccessibilityDelegate((View)var4.timeValue, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.alarm_time_content_description));
         var4.setTimeGroup.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda3(this, var4));
         var4.ringtoneSwitch.setOnCheckedChangeListener(new AlarmEditActivity$$ExternalSyntheticLambda4(this, var4));
         var4.ringtoneSwitch.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda5(var4, this));
         SwitchCompat var21 = var4.ringtoneSwitch;
         if (var6 != null && var6.getSound() == AlarmSound.Mute.getValue()) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         var21.setChecked((boolean)(var2 ^ true));
         var4.clickViewSound.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda6(this, var4));
         AccessibleSeekBar var22 = var4.seekbarVolume;
         if (var6 != null) {
            var2 = var6.getVolume();
         } else {
            var2 = 50;
         }

         var22.setProgress(var2);
         var4.tvVolumeValue.setText((CharSequence)String.valueOf(var4.seekbarVolume.getProgress()));
         var4.seekbarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(var4, this) {
            final ActivityAlarmEditBinding $this_apply;
            final AlarmEditActivity this$0;

            {
               this.$this_apply = var1;
               this.this$0 = var2;
            }

            public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
               this.$this_apply.tvVolumeValue.setText((CharSequence)String.valueOf(var2));
            }

            public void onStartTrackingTouch(SeekBar var1) {
            }

            public void onStopTrackingTouch(SeekBar var1) {
               DeviceDetailsViewModel var3 = this.this$0.viewModel;
               HasAlarm var2 = this.this$0.device;
               HasAlarm var4 = var2;
               if (var2 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("device");
                  var4 = null;
               }

               var3.playAlarm(var4, this.this$0.alarmSound.getValue(), this.$this_apply.seekbarVolume.getProgress());
            }
         });
         var4.sunriseSwitch.setOnCheckedChangeListener(new AlarmEditActivity$$ExternalSyntheticLambda7(this, var4));
         SwitchCompat var23 = var4.sunriseSwitch;
         if (var6 != null && !var6.getLightEnabled()) {
            var2 = 1;
         } else {
            var2 = 0;
         }

         var23.setChecked((boolean)(var2 ^ true));
         if (var6 != null) {
            var2 = var6.getLightDuration();
         } else {
            var2 = 15;
         }

         if (var2 == 15) {
            var4.seekbarDuration.setProgress(30);
         }

         var4.seekbarDuration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this, var4) {
            final ActivityAlarmEditBinding $this_apply;
            final AlarmEditActivity this$0;
            private final int tintColor;
            private final int unTintSeparatorColor;
            private final int unTintTextColor;

            {
               this.this$0 = var1;
               this.$this_apply = var2;
               this.tintColor = var1.getColor(R.color.colorPrimary);
               this.unTintTextColor = var1.getColor(R.color.surface_dark_55);
               this.unTintSeparatorColor = var1.getColor(R.color.surface_dark_45);
            }

            public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
               TextView var4 = this.$this_apply.tvDurationValue;
               StringBuilder var5 = new StringBuilder();
               var5.append(var2);
               var5.append(' ');
               var5.append(this.this$0.getString(R.string.eta_minutes));
               var4.setText((CharSequence)var5.toString());
               if (var2 != 15) {
                  if (var2 != 30) {
                     this.$this_apply.tvProgress0.setTextColor(this.unTintTextColor);
                     this.$this_apply.separatorStart.setBackgroundColor(this.unTintSeparatorColor);
                     this.$this_apply.tvProgress100.setTextColor(this.unTintTextColor);
                     this.$this_apply.separatorEnd.setBackgroundColor(this.unTintSeparatorColor);
                  } else {
                     this.$this_apply.tvProgress0.setTextColor(this.unTintTextColor);
                     this.$this_apply.separatorStart.setBackgroundColor(this.unTintSeparatorColor);
                     this.$this_apply.tvProgress100.setTextColor(this.tintColor);
                     this.$this_apply.separatorEnd.setBackgroundColor(this.tintColor);
                  }
               } else {
                  this.$this_apply.tvProgress0.setTextColor(this.tintColor);
                  this.$this_apply.separatorStart.setBackgroundColor(this.tintColor);
                  this.$this_apply.tvProgress100.setTextColor(this.unTintTextColor);
                  this.$this_apply.separatorEnd.setBackgroundColor(this.unTintSeparatorColor);
               }
            }

            public void onStartTrackingTouch(SeekBar var1) {
            }

            public void onStopTrackingTouch(SeekBar var1) {
            }
         });
         var4.seekbarDuration.setProgress(var2);
         TextView var24 = var4.tvProgress0;
         StringBuilder var41 = new StringBuilder("15 ");
         var41.append(this.getString(R.string.eta_minutes));
         var24.setText((CharSequence)var41.toString());
         TextView var42 = var4.tvProgress100;
         StringBuilder var25 = new StringBuilder("30 ");
         var25.append(this.getString(R.string.eta_minutes));
         var42.setText((CharSequence)var25.toString());
         ConstraintLayout var26 = var4.hintContainer;
         Intrinsics.checkNotNullExpressionValue(var26, "hintContainer");
         ViewExtensionsKt.show((View)var26, this.viewModel.getSunRiseLightHintClosedBefore() ^ true);
         var4.btnCloseHint.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda10(this, var4));

         for(DayOfWeek var27 : (Iterable)this.repeatDays) {
            CheckBox var28;
            switch (AlarmEditActivity.WhenMappings.$EnumSwitchMapping$0[var27.ordinal()]) {
               case 1:
                  var28 = var4.cbMon;
                  break;
               case 2:
                  var28 = var4.cbTue;
                  break;
               case 3:
                  var28 = var4.cbWed;
                  break;
               case 4:
                  var28 = var4.cbThu;
                  break;
               case 5:
                  var28 = var4.cbFri;
                  break;
               case 6:
                  var28 = var4.cbSat;
                  break;
               case 7:
                  var28 = var4.cbSun;
                  break;
               default:
                  throw new NoWhenBranchMatchedException();
            }

            Intrinsics.checkNotNull(var28);
            var28.setChecked(true);
         }

         List var44 = CollectionsKt.listOf(new CheckBox[]{var4.cbMon, var4.cbTue, var4.cbWed, var4.cbThu, var4.cbFri, var4.cbSat, var4.cbSun});
         Iterator var29 = ((Iterable)var44).iterator();

         while(var29.hasNext()) {
            ((CheckBox)var29.next()).setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda11(var4, this));
         }

         var4.cbEveryday.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda12(this, var44));
         var4.cbWeekdays.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda13(this, var44, var4));
         var4.cbWeekends.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda14(this, var44, var4));
         var4.btnSaveChange.setOnClickListener(new AlarmEditActivity$$ExternalSyntheticLambda15(this, var4, var6));
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   protected void onDestroy() {
      super.onDestroy();
      DeviceDetailsViewModel var3 = this.viewModel;
      HasAlarm var2 = this.device;
      HasAlarm var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var1 = null;
      }

      var3.stopAlarm(var1);
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/activity/AlarmEditActivity$Companion;", "", "<init>", "()V", "EXTRA_ALARM_INDEX", "", "launch", "", "context", "Landroid/content/Context;", "device", "Lcom/blueair/core/model/Device;", "alarmIndex", "", "devicedetails_otherRelease"},
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

      public final void launch(Context var1, Device var2, int var3) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var2, "device");
         Intent var4 = new Intent(var1, AlarmEditActivity.class);
         var4.putExtra("device", var2);
         var4.putExtra("EXTRA_ALARM_INDEX", var3);
         var1.startActivity(var4);
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

      static {
         int[] var0 = new int[DayOfWeek.values().length];

         try {
            var0[DayOfWeek.MON.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DayOfWeek.TUE.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DayOfWeek.WED.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DayOfWeek.THU.ordinal()] = 4;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DayOfWeek.FRI.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DayOfWeek.SAT.ordinal()] = 6;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DayOfWeek.SUN.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
