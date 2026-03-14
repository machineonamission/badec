package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.Device;
import com.blueair.core.model.Device$_CC;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.adapter.DeviceNScheduleModeAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNCreateEditScheduleBinding;
import com.blueair.devicedetails.databinding.DialogfragmentDevicePCreateEditScheduleBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.ConfirmationDialogCentered;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.extensions.FragmentExtensionsKt;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.fragment.BaseFragmentInterface$_CC;
import com.blueair.viewcore.fragment.ProgressFragment;
import com.blueair.viewcore.fragment.ProgressFragment$_CC;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 d2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001dB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J)\u0010\u0012\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0002\u0010\u001bJ$\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u0001072\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\u001a\u0010W\u001a\u00020\u00132\u0006\u0010X\u001a\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010Y\u001a\u00020\u0013H\u0002J\b\u0010Z\u001a\u00020\u0013H\u0002J\u0010\u0010[\u001a\u00020\u001a2\u0006\u0010\\\u001a\u00020]H\u0002J\u0010\u0010^\u001a\u00020\u001a2\u0006\u0010_\u001a\u00020`H\u0002J\b\u0010a\u001a\u00020\u0013H\u0002J\b\u0010b\u001a\u00020\u0013H\u0016J\b\u0010c\u001a\u00020\u0013H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR+\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u0013\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020?X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006e"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "Lcom/blueair/viewcore/fragment/ProgressFragment;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "showProgress", "", "shouldShowProgress", "", "context", "Landroid/content/Context;", "shouldShow", "forcedColor", "", "(Landroid/content/Context;ZLjava/lang/Integer;)V", "onScheduleChanged", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isDelete", "device", "Lcom/blueair/core/model/Device;", "contentContainerActive", "contentContainer", "title", "Landroid/widget/TextView;", "backBtn", "Landroid/widget/ImageButton;", "saveBtn", "Lcom/google/android/material/button/MaterialButton;", "scheduleName", "Landroid/widget/EditText;", "timezoneValue", "startTimeValue", "endTimeValue", "scheduleRepeat", "startMainModeIcon", "Landroid/widget/ImageView;", "startIcon", "endMainModeIcon", "endIcon", "settingsStart", "Landroid/view/ViewGroup;", "settingsEnd", "rvStartMode", "Landroidx/recyclerview/widget/RecyclerView;", "rvEndMode", "deleteBtn", "progressView", "cbMon", "Landroid/widget/CheckBox;", "cbTue", "cbWed", "cbThu", "cbFri", "cbSat", "cbSun", "scheduleSwitchBtn", "Lcom/blueair/viewcore/view/SwitchCompat;", "startModeAdapter", "Lcom/blueair/devicedetails/adapter/DeviceNScheduleModeAdapter;", "endModeAdapter", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "updateTimeViews", "updateRepeatDaysText", "getPurifyModeIcon", "mode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "getMainModeIcon", "mainMode", "Lcom/blueair/core/model/MainMode;", "saveStartEndModeToViewModel", "onStart", "onDestroy", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNCreateEditScheduleDialogFragment extends BaseDialogFragment implements ProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ImageButton backBtn;
   private CheckBox cbFri;
   private CheckBox cbMon;
   private CheckBox cbSat;
   private CheckBox cbSun;
   private CheckBox cbThu;
   private CheckBox cbTue;
   private CheckBox cbWed;
   private ConstraintLayout contentContainer;
   private ConstraintLayout contentContainerActive;
   private MaterialButton deleteBtn;
   private Device device;
   private ImageView endIcon;
   private ImageView endMainModeIcon;
   private DeviceNScheduleModeAdapter endModeAdapter;
   private TextView endTimeValue;
   private Function1 onScheduleChanged;
   private ProgressBlockerView progressBlockerView;
   private ProgressBlockerView progressView;
   private RecyclerView rvEndMode;
   private RecyclerView rvStartMode;
   private MaterialButton saveBtn;
   private EditText scheduleName;
   private TextView scheduleRepeat;
   private SwitchCompat scheduleSwitchBtn;
   private final String screenName = "device_details_schedule_details";
   private ViewGroup settingsEnd;
   private ViewGroup settingsStart;
   private ImageView startIcon;
   private ImageView startMainModeIcon;
   private DeviceNScheduleModeAdapter startModeAdapter;
   private TextView startTimeValue;
   private TextView timezoneValue;
   private TextView title;
   public DeviceCreateEditScheduleViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$0FyjsgkK1NiF8L2xfxDLzov_6CA/* $FF was: $r8$lambda$0FyjsgkK1NiF8L2xfxDLzov-6CA*/(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$20$lambda$19(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$0I8rfARSgQO4EaayWnqbfrt5XzA(DeviceNCreateEditScheduleDialogFragment var0, boolean var1, boolean var2) {
      return onViewCreated$lambda$7$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$14jUTUnyNAfcwULYuwtli_rrVDw/* $FF was: $r8$lambda$14jUTUnyNAfcwULYuwtli-rrVDw*/(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$29(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$50tesFRdLzWRmUilxZnjb7YIOk0(DeviceNCreateEditScheduleDialogFragment var0, MainMode var1) {
      return onViewCreated$lambda$22(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$A9jFs1YA2lvFaRReNX5AyIizuA0(DeviceNCreateEditScheduleDialogFragment var0, Calendar var1) {
      return onViewCreated$lambda$17$lambda$16$lambda$15(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$H4jH0EsEXQ3I_mQZSftc3rVGAfw(DeviceNCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      return onViewCreated$lambda$23(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$QoXkoAgWfuIsz9N6Q2Fbojkty9s(DeviceNCreateEditScheduleDialogFragment var0, Boolean var1) {
      return onViewCreated$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$RIgDe0suHTnrLddhR1Jo9CNWkQI(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UpZfur1t1ZAA3ZhYB6_smjk7Cr8(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$V3kx3SsupUqy_7_JfJq9CSRyX3E/* $FF was: $r8$lambda$V3kx3SsupUqy-7-JfJq9CSRyX3E*/(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$33(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$_togjUkQjaUgddF_tbw_a1OTgto/* $FF was: $r8$lambda$_togjUkQjaUgddF-tbw_a1OTgto*/(DeviceNCreateEditScheduleDialogFragment var0, MainMode var1) {
      return onViewCreated$lambda$25(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$d9IDQ0jL9O1P4_1KiZ4Nqrhnh9g(DeviceNCreateEditScheduleDialogFragment var0, boolean var1) {
      return onViewCreated$lambda$33$lambda$32$lambda$31(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$jTgl5kInh96MOi_qVFa9CNGlAkw/* $FF was: $r8$lambda$jTgl5kInh96MOi-qVFa9CNGlAkw*/(DeviceNCreateEditScheduleDialogFragment var0, String var1) {
      return onViewCreated$lambda$24(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$mF__kEMIEZOtvwWAOL5cui5iM2o/* $FF was: $r8$lambda$mF--kEMIEZOtvwWAOL5cui5iM2o*/(DeviceNCreateEditScheduleDialogFragment var0, String var1, Bundle var2) {
      return onViewCreated$lambda$33$lambda$32(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nIDAIN2QKBLZqN8XHCmAuVolYEs(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$17(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$nv73wof6xeN_aY_gzZRhN1qJoZg/* $FF was: $r8$lambda$nv73wof6xeN-aY_gzZRhN1qJoZg*/(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$27(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$pLdl_gF2KfS2BJ2Y5Q6VU3Hy3gc(DeviceNCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      return onViewCreated$lambda$21(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$qU_1UroC8seDRHrg0kldwQmnuds/* $FF was: $r8$lambda$qU-1UroC8seDRHrg0kldwQmnuds*/(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      onViewCreated$lambda$14(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$syWZU_9zGE1W6j0KfKhqTEhOalg(DeviceNCreateEditScheduleDialogFragment var0, Calendar var1) {
      return onViewCreated$lambda$14$lambda$13$lambda$12(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ujL4MHHYz5sW1pOOwSaehfAF1Ss(DeviceNCreateEditScheduleDialogFragment var0, CompoundButton var1, boolean var2) {
      onViewCreated$lambda$9(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$vG_KfibdbIscLYshl7DYIty7gjE(DeviceNCreateEditScheduleDialogFragment var0) {
      onViewCreated$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$zSHoEJ_hOn9zyBKCsGpcGLYT6CM(DeviceNCreateEditScheduleDialogFragment var0, Boolean var1) {
      return onViewCreated$lambda$8(var0, var1);
   }

   private final int getMainModeIcon(MainMode var1) {
      int var2 = DeviceNCreateEditScheduleDialogFragment.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
      if (var2 != 1) {
         if (var2 != 2) {
            return var2 != 3 ? 0 : ModeIcon.COOL.getOnIcon();
         } else {
            return ModeIcon.HEAT.getOnIcon();
         }
      } else {
         return ModeIcon.AIR_PURIFY.getOnIcon();
      }
   }

   private final int getPurifyModeIcon(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      Device var3 = this.device;
      Device var2 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var2 = null;
      }

      return var1.toModeIcon(var2).getOnIcon();
   }

   private static final Unit onViewCreated$lambda$11(DeviceNCreateEditScheduleDialogFragment var0, Boolean var1) {
      int var2;
      if (var1) {
         var2 = R.color.error_red;
      } else {
         var2 = R.color.colorPrimaryText;
      }

      var2 = ContextCompat.getColor(var0.requireContext(), var2);
      TextView var4 = var0.startTimeValue;
      Object var3 = null;
      TextView var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("startTimeValue");
         var6 = null;
      }

      var6.setTextColor(var2);
      TextView var5 = var0.endTimeValue;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("endTimeValue");
         var5 = (TextView)var3;
      }

      var5.setTextColor(var2);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$14(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)(new TimePickerDialogFragment(var0.getViewModel().getStartTime(), new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda0(var0)))).show(var2, "TimePickerDialogFragment");
      }

   }

   private static final Unit onViewCreated$lambda$14$lambda$13$lambda$12(DeviceNCreateEditScheduleDialogFragment var0, Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setStartTime(var1);
      var0.updateTimeViews();
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$17(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("TimePickerDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("TimePickerDialogFragment") instanceof TimePickerDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)(new TimePickerDialogFragment(var0.getViewModel().getEndTime(), new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda13(var0)))).show(var2, "TimePickerDialogFragment");
      }

   }

   private static final Unit onViewCreated$lambda$17$lambda$16$lambda$15(DeviceNCreateEditScheduleDialogFragment var0, Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.getViewModel().setEndTime(var1);
      var0.updateTimeViews();
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$2(DeviceNCreateEditScheduleDialogFragment var0) {
      ConstraintLayout var6 = var0.contentContainer;
      Object var5 = null;
      Object var4 = null;
      ConstraintLayout var3 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
         var3 = null;
      }

      boolean var1;
      if (ViewCompat.getLayoutDirection((View)var3) == 0) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      TextView var24 = var0.title;
      TextView var14 = var24;
      if (var24 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("title");
         var14 = null;
      }

      View var25 = (View)var14;
      ViewGroup.LayoutParams var15 = var25.getLayoutParams();
      if (var15 != null) {
         ViewGroup.LayoutParams var8 = (ViewGroup.LayoutParams)((ViewGroup.MarginLayoutParams)var15);
         ViewGroup.MarginLayoutParams var7 = (ViewGroup.MarginLayoutParams)var8;
         if (var1) {
            ConstraintLayout var22 = var0.contentContainer;
            ConstraintLayout var16 = var22;
            if (var22 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
               var16 = null;
            }

            var1 = var16.getWidth();
            TextView var23 = var0.title;
            TextView var17 = var23;
            if (var23 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("title");
               var17 = null;
            }

            int var2 = var17.getRight();
            TextView var9 = var0.title;
            if (var9 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("title");
               var9 = (TextView)var4;
            }

            var7.leftMargin = var1 - var2 - var9.getLeft();
         } else {
            TextView var20 = var0.title;
            TextView var18 = var20;
            if (var20 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("title");
               var18 = null;
            }

            int var13 = var18.getLeft();
            ConstraintLayout var21 = var0.contentContainer;
            ConstraintLayout var19 = var21;
            if (var21 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
               var19 = null;
            }

            var1 = var19.getWidth();
            TextView var10 = var0.title;
            if (var10 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("title");
               var10 = (TextView)var5;
            }

            var7.rightMargin = var13 - (var1 - var10.getRight());
         }

         var25.setLayoutParams(var8);
      } else {
         throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      }
   }

   private static final void onViewCreated$lambda$20$lambda$19(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      Set var4 = (Set)(new LinkedHashSet());
      CheckBox var3 = var0.cbMon;
      Object var2 = null;
      CheckBox var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbMon");
         var5 = null;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.MON);
      }

      var3 = var0.cbTue;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbTue");
         var5 = null;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.TUE);
      }

      var3 = var0.cbWed;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbWed");
         var5 = null;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.WED);
      }

      var3 = var0.cbThu;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbThu");
         var5 = null;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.THU);
      }

      var3 = var0.cbFri;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbFri");
         var5 = null;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.FRI);
      }

      var3 = var0.cbSat;
      var5 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbSat");
         var5 = null;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.SAT);
      }

      var5 = var0.cbSun;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbSun");
         var5 = (CheckBox)var2;
      }

      if (var5.isChecked()) {
         var4.add(DayOfWeek.SUN);
      }

      var0.getViewModel().setRepeat(var4);
      var0.updateRepeatDaysText();
   }

   private static final Unit onViewCreated$lambda$21(DeviceNCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      ImageView var3 = var0.startIcon;
      if (var3 != null) {
         Intrinsics.checkNotNull(var1);
         var3.setImageResource(var0.getPurifyModeIcon(var1));
      }

      var3 = var0.startMainModeIcon;
      if (var3 != null) {
         View var4 = (View)var3;
         Device var7 = var0.device;
         Device var5 = var7;
         if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var5 = null;
         }

         boolean var2;
         if (var5 instanceof HasCombo3in1MainMode && var1 != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            var2 = true;
         } else {
            var2 = false;
         }

         ViewExtensionsKt.show(var4, var2);
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$22(DeviceNCreateEditScheduleDialogFragment var0, MainMode var1) {
      ImageView var2 = var0.startMainModeIcon;
      if (var2 != null) {
         Intrinsics.checkNotNull(var1);
         var2.setImageResource(var0.getMainModeIcon(var1));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$23(DeviceNCreateEditScheduleDialogFragment var0, DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      onViewCreated$updateEndIcon(var0);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$24(DeviceNCreateEditScheduleDialogFragment var0, String var1) {
      onViewCreated$updateEndIcon(var0);
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$25(DeviceNCreateEditScheduleDialogFragment var0, MainMode var1) {
      ImageView var2 = var0.endMainModeIcon;
      if (var2 != null) {
         Intrinsics.checkNotNull(var1);
         var2.setImageResource(var0.getMainModeIcon(var1));
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$27(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceNSetScheduleModeDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceNSetScheduleModeDialogFragment") instanceof DeviceNSetScheduleModeDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)DeviceNSetScheduleModeDialogFragment.Companion.newInstance(true)).show(var2, "DeviceNSetScheduleModeDialogFragment");
      }

   }

   private static final void onViewCreated$lambda$29(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("DeviceNSetScheduleModeDialogFragment", "getSimpleName(...)");
      if (!(var2.findFragmentByTag("DeviceNSetScheduleModeDialogFragment") instanceof DeviceNSetScheduleModeDialogFragment) && !var2.isStateSaved()) {
         ((DialogFragment)DeviceNSetScheduleModeDialogFragment.Companion.newInstance(false)).show(var2, "DeviceNSetScheduleModeDialogFragment");
      }

   }

   private static final void onViewCreated$lambda$3(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      var0.dismiss();
   }

   private static final void onViewCreated$lambda$33(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      FragmentManager var2 = var0.getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var2, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
      DialogFragment var3;
      if (!(var2.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var2.isStateSaved()) {
         var3 = ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.delete_schedule_title, R.string.delete_schedule_content, R.string.delete_schedule_confirm, R.string.btn_cancel, true, false, false, (String[])null, 224, (Object)null);
         ((DialogFragment)var3).show(var2, "ConfirmationDialogCentered");
      } else {
         var3 = null;
      }

      var3 = var3;
      if (var3 != null) {
         FragmentExtensionsKt.setFragmentResultListenerWithClear((Fragment)var3, "CONFIRMATION", new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda14(var0));
      }

   }

   private static final Unit onViewCreated$lambda$33$lambda$32(DeviceNCreateEditScheduleDialogFragment var0, String var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "<unused var>");
      Intrinsics.checkNotNullParameter(var2, "result");
      if (var2.getBoolean("IS_CONFIRMED")) {
         var0.getViewModel().delete(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda15(var0));
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$33$lambda$32$lambda$31(DeviceNCreateEditScheduleDialogFragment var0, boolean var1) {
      if (var1) {
         Function1 var2 = var0.onScheduleChanged;
         if (var2 != null) {
            var2.invoke(true);
         }

         var0.dismiss();
      }

      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$7(DeviceNCreateEditScheduleDialogFragment var0, View var1) {
      BaseFragmentInterface var2 = var0;
      EditText var4 = null;
      BaseFragmentInterface$_CC.showProgress$default(var2, false, 1, (Object)null);
      DeviceCreateEditScheduleViewModel var3 = var0.getViewModel();
      EditText var5 = var0.scheduleName;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
      } else {
         var4 = var5;
      }

      var3.setLabel(var4.getText().toString());
      var0.saveStartEndModeToViewModel();
      var0.getViewModel().onComplete(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda11(var0));
   }

   private static final Unit onViewCreated$lambda$7$lambda$6(DeviceNCreateEditScheduleDialogFragment var0, boolean var1, boolean var2) {
      Context var3 = var0.getContext();
      if (var3 != null) {
         var0.hideProgress(var3);
      }

      if (var1) {
         FragmentManager var4 = var0.getChildFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("ConfirmationDialogCentered", "getSimpleName(...)");
         if (!(var4.findFragmentByTag("ConfirmationDialogCentered") instanceof ConfirmationDialogCentered) && !var4.isStateSaved()) {
            ((DialogFragment)ConfirmationDialogCentered.Companion.newInstance$default(ConfirmationDialogCentered.Companion, R.string.overlap_title, R.string.overlap_content, R.string.btn_cancel, (Integer)null, false, false, false, (String[])null, 240, (Object)null)).show(var4, "ConfirmationDialogCentered");
         }
      } else if (var2) {
         Function1 var5 = var0.onScheduleChanged;
         if (var5 != null) {
            var5.invoke(false);
         }

         var0.dismissAllowingStateLoss();
      }

      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$8(DeviceNCreateEditScheduleDialogFragment var0, Boolean var1) {
      MaterialButton var2 = var0.saveBtn;
      MaterialButton var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("saveBtn");
         var3 = null;
      }

      Intrinsics.checkNotNull(var1);
      var3.setEnabled(var1);
      return Unit.INSTANCE;
   }

   private static final void onViewCreated$lambda$9(DeviceNCreateEditScheduleDialogFragment var0, CompoundButton var1, boolean var2) {
      var0.getViewModel().setPaused(var2 ^ true);
   }

   private static final void onViewCreated$updateEndIcon(DeviceNCreateEditScheduleDialogFragment var0) {
      ImageView var3 = var0.endMainModeIcon;
      if (var3 != null) {
         View var5 = (View)var3;
         Device var4 = var0.device;
         Device var7 = var4;
         if (var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var7 = null;
         }

         boolean var2;
         if (var7 instanceof HasCombo3in1MainMode && Intrinsics.areEqual(var0.getViewModel().getScheduleEndType().getValue(), "custom") && var0.getViewModel().getScheduleEndCustomMode() != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            var2 = true;
         } else {
            var2 = false;
         }

         ViewExtensionsKt.show(var5, var2);
      }

      int var1;
      if (Intrinsics.areEqual(var0.getViewModel().getScheduleEndType().getValue(), "custom")) {
         var1 = var0.getPurifyModeIcon(var0.getViewModel().getScheduleEndCustomMode());
      } else {
         var1 = ModeIcon.PREVIOUS.getOnIcon();
      }

      ImageView var6 = var0.endIcon;
      if (var6 != null) {
         var6.setImageResource(var1);
      }

   }

   private final void saveStartEndModeToViewModel() {
      DeviceNScheduleModeAdapter var1 = this.startModeAdapter;
      if (var1 != null) {
         this.getViewModel().setPurifierMode(var1.getMode());
         this.getViewModel().setStartFanSpeed(var1.getFanSpeed());
         this.getViewModel().setStartBrightness(var1.getBrightness());
         this.getViewModel().setStartAutoRh(var1.getAutoRh());
         this.getViewModel().setStartMainMode(var1.getMainMode());
         this.getViewModel().setStartApSubMode(var1.getApSubMode());
         this.getViewModel().setStartSmartSubMode(var1.getSmartSubMode());
         this.getViewModel().setStartHeatAutoTemp(var1.getHeatAutoTemp());
         this.getViewModel().setStartHeatEcoTemp(var1.getHeatEcoTmp());
         this.getViewModel().setStartOscillationEnabled(var1.getOscillationEnabled());
         this.getViewModel().setStartHumMode(var1.getHumMode());
      }

      var1 = this.endModeAdapter;
      if (var1 != null) {
         this.getViewModel().getScheduleEndType().setValue(var1.getCustomType());
         this.getViewModel().setScheduleEndCustomMode(var1.getMode());
         this.getViewModel().setScheduleEndCustomFanSpeed(var1.getFanSpeed());
         this.getViewModel().setScheduleEndCustomBrightness(var1.getBrightness());
         this.getViewModel().setScheduleEndCustomAutoRh(var1.getAutoRh());
         this.getViewModel().setScheduleEndCustomMainMode(var1.getMainMode());
         this.getViewModel().setScheduleEndCustomApSubMode(var1.getApSubMode());
         this.getViewModel().setScheduleEndCustomSmartSubMode(var1.getSmartSubMode());
         this.getViewModel().setScheduleEndCustomHeatAutoTemp(var1.getHeatAutoTemp());
         this.getViewModel().setScheduleEndCustomHeatEcoTemp(var1.getHeatEcoTmp());
         this.getViewModel().setScheduleEndCustomOscillationEnabled(var1.getOscillationEnabled());
         this.getViewModel().setScheduleEndCustomHumMode(var1.getHumMode());
      }

   }

   private final void updateRepeatDaysText() {
      TextView var2 = this.scheduleRepeat;
      TextView var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleRepeat");
         var1 = null;
      }

      Set var4 = this.getViewModel().getRepeat();
      Context var3 = this.requireContext();
      Intrinsics.checkNotNullExpressionValue(var3, "requireContext(...)");
      var1.setText((CharSequence)DayOfWeekExtensionKt.toString(var4, var3));
   }

   private final void updateTimeViews() {
      TextView var3 = this.startTimeValue;
      Object var2 = null;
      TextView var1 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("startTimeValue");
         var1 = null;
      }

      var1.setText((CharSequence)this.getViewModel().getDisplayStartTime());
      var1 = this.endTimeValue;
      if (var1 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("endTimeValue");
         var1 = (TextView)var2;
      }

      var1.setText((CharSequence)this.getViewModel().getDisplayEndTime());
   }

   public void clearProgressFragment() {
      ProgressFragment$_CC.$default$clearProgressFragment(this);
   }

   public ProgressBlockerView getProgressBlockerView() {
      return this.progressBlockerView;
   }

   public ConstraintLayout getRootView() {
      ConstraintLayout var2 = this.contentContainer;
      ConstraintLayout var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
         var1 = null;
      }

      return var1;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceCreateEditScheduleViewModel getViewModel() {
      DeviceCreateEditScheduleViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void hideProgress(Context var1) {
      ProgressFragment$_CC.$default$hideProgress(this, var1);
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var40 = this.getDialog();
      if (var40 != null) {
         Window var41 = var40.getWindow();
         if (var41 != null) {
            var41.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var41.setWindowAnimations(R.style.dialog_animation);
            var41.setGravity(80);
         }
      }

      this.setViewModel((DeviceCreateEditScheduleViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(DeviceCreateEditScheduleViewModel.class)));
      DeviceCreateEditScheduleViewModel var4 = this.getViewModel();
      Context var42 = this.requireContext();
      Intrinsics.checkNotNullExpressionValue(var42, "requireContext(...)");
      var4.initTimeFormat(var42);
      Bundle var43 = this.getArguments();
      Device var44;
      if (var43 != null) {
         var44 = (Device)var43.getParcelable("device");
      } else {
         var44 = null;
      }

      if (var44 != null) {
         this.device = var44;
         DeviceCreateEditScheduleViewModel var5 = this.getViewModel();
         Device var92 = this.device;
         var44 = var92;
         if (var92 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var44 = null;
         }

         var5.setDevice(var44);
         DeviceCreateEditScheduleViewModel var93 = this.getViewModel();
         Bundle var46 = this.getArguments();
         DeviceScheduleMerged var47;
         if (var46 != null) {
            var47 = (DeviceScheduleMerged)var46.getParcelable("schedule_merged");
         } else {
            var47 = null;
         }

         var93.setEditingSchedule(var47);
         Device var94 = this.device;
         Device var48 = var94;
         if (var94 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("device");
            var48 = null;
         }

         ViewBinding var27;
         if (var48 instanceof DeviceNewClassic) {
            var27 = DialogfragmentDeviceNCreateEditScheduleBinding.inflate(var1, var2, false);
            Intrinsics.checkNotNullExpressionValue(var27, "inflate(...)");
            ViewBinding var35 = var27;
            DialogfragmentDeviceNCreateEditScheduleBinding var95 = (DialogfragmentDeviceNCreateEditScheduleBinding)var35;
            ConstraintLayout var49 = var95.contentContainerActive;
            Intrinsics.checkNotNullExpressionValue(var49, "contentContainerActive");
            this.contentContainerActive = var49;
            ConstraintLayout var7 = var49;
            if (var49 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("contentContainerActive");
               var7 = null;
            }

            ViewExtensionsKt.hide((View)var7);
            var7 = var95.contentContainer;
            Intrinsics.checkNotNullExpressionValue(var7, "contentContainer");
            this.contentContainer = var7;
            TextView var9 = var95.title;
            Intrinsics.checkNotNullExpressionValue(var9, "title");
            this.title = var9;
            ImageButton var10 = var95.backBtn;
            Intrinsics.checkNotNullExpressionValue(var10, "backBtn");
            this.backBtn = var10;
            MaterialButton var11 = var95.saveBtn;
            Intrinsics.checkNotNullExpressionValue(var11, "saveBtn");
            this.saveBtn = var11;
            EditText var12 = var95.scheduleName;
            Intrinsics.checkNotNullExpressionValue(var12, "scheduleName");
            this.scheduleName = var12;
            TextView var13 = var95.timezoneValue;
            Intrinsics.checkNotNullExpressionValue(var13, "timezoneValue");
            this.timezoneValue = var13;
            var13 = var95.startTimeValue;
            Intrinsics.checkNotNullExpressionValue(var13, "startTimeValue");
            this.startTimeValue = var13;
            var13 = var95.endTimeValue;
            Intrinsics.checkNotNullExpressionValue(var13, "endTimeValue");
            this.endTimeValue = var13;
            TextView var50 = var95.scheduleRepeat;
            Intrinsics.checkNotNullExpressionValue(var50, "scheduleRepeat");
            this.scheduleRepeat = var50;
            var13 = var50;
            if (var50 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("scheduleRepeat");
               var13 = null;
            }

            ViewExtensionsKt.hide((View)var13);
            this.startIcon = var95.startIcon;
            this.endIcon = var95.endIcon;
            this.settingsStart = (ViewGroup)var95.settingsStart;
            this.settingsEnd = (ViewGroup)var95.settingsEnd;
            MaterialButton var17 = var95.deleteBtn;
            Intrinsics.checkNotNullExpressionValue(var17, "deleteBtn");
            this.deleteBtn = var17;
            ProgressBlockerView var18 = var95.progressView;
            Intrinsics.checkNotNullExpressionValue(var18, "progressView");
            this.progressView = var18;
            CheckBox var19 = var95.cbMon;
            Intrinsics.checkNotNullExpressionValue(var19, "cbMon");
            this.cbMon = var19;
            var19 = var95.cbTue;
            Intrinsics.checkNotNullExpressionValue(var19, "cbTue");
            this.cbTue = var19;
            var19 = var95.cbWed;
            Intrinsics.checkNotNullExpressionValue(var19, "cbWed");
            this.cbWed = var19;
            var19 = var95.cbThu;
            Intrinsics.checkNotNullExpressionValue(var19, "cbThu");
            this.cbThu = var19;
            var19 = var95.cbFri;
            Intrinsics.checkNotNullExpressionValue(var19, "cbFri");
            this.cbFri = var19;
            var19 = var95.cbSat;
            Intrinsics.checkNotNullExpressionValue(var19, "cbSat");
            this.cbSat = var19;
            var19 = var95.cbSun;
            Intrinsics.checkNotNullExpressionValue(var19, "cbSun");
            this.cbSun = var19;
            SwitchCompat var26 = var95.scheduleSwitchBtn;
            Intrinsics.checkNotNullExpressionValue(var26, "scheduleSwitchBtn");
            this.scheduleSwitchBtn = var26;
            var27 = var35;
         } else {
            var94 = this.device;
            var48 = var94;
            if (var94 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("device");
               var48 = null;
            }

            if (var48 instanceof DevicePet20) {
               DialogfragmentDevicePCreateEditScheduleBinding var28 = DialogfragmentDevicePCreateEditScheduleBinding.inflate(var1, var2, false);
               Intrinsics.checkNotNullExpressionValue(var28, "inflate(...)");
               var27 = var28;
               DialogfragmentDevicePCreateEditScheduleBinding var36 = (DialogfragmentDevicePCreateEditScheduleBinding)var27;
               ConstraintLayout var52 = var36.contentContainerActive;
               Intrinsics.checkNotNullExpressionValue(var52, "contentContainerActive");
               this.contentContainerActive = var52;
               var52 = var36.contentContainer;
               Intrinsics.checkNotNullExpressionValue(var52, "contentContainer");
               this.contentContainer = var52;
               TextView var54 = var36.title;
               Intrinsics.checkNotNullExpressionValue(var54, "title");
               this.title = var54;
               ImageButton var55 = var36.backBtn;
               Intrinsics.checkNotNullExpressionValue(var55, "backBtn");
               this.backBtn = var55;
               MaterialButton var56 = var36.saveBtn;
               Intrinsics.checkNotNullExpressionValue(var56, "saveBtn");
               this.saveBtn = var56;
               EditText var57 = var36.scheduleName;
               Intrinsics.checkNotNullExpressionValue(var57, "scheduleName");
               this.scheduleName = var57;
               TextView var58 = var36.timezoneValue;
               Intrinsics.checkNotNullExpressionValue(var58, "timezoneValue");
               this.timezoneValue = var58;
               var58 = var36.startTimeValue;
               Intrinsics.checkNotNullExpressionValue(var58, "startTimeValue");
               this.startTimeValue = var58;
               var58 = var36.endTimeValue;
               Intrinsics.checkNotNullExpressionValue(var58, "endTimeValue");
               this.endTimeValue = var58;
               var58 = var36.scheduleRepeat;
               Intrinsics.checkNotNullExpressionValue(var58, "scheduleRepeat");
               this.scheduleRepeat = var58;
               this.rvStartMode = var36.rvStartMode;
               this.rvEndMode = var36.rvEndMode;
               MaterialButton var62 = var36.deleteBtn;
               Intrinsics.checkNotNullExpressionValue(var62, "deleteBtn");
               this.deleteBtn = var62;
               ProgressBlockerView var63 = var36.progressView;
               Intrinsics.checkNotNullExpressionValue(var63, "progressView");
               this.progressView = var63;
               CheckBox var64 = var36.cbMon;
               Intrinsics.checkNotNullExpressionValue(var64, "cbMon");
               this.cbMon = var64;
               var64 = var36.cbTue;
               Intrinsics.checkNotNullExpressionValue(var64, "cbTue");
               this.cbTue = var64;
               var64 = var36.cbWed;
               Intrinsics.checkNotNullExpressionValue(var64, "cbWed");
               this.cbWed = var64;
               var64 = var36.cbThu;
               Intrinsics.checkNotNullExpressionValue(var64, "cbThu");
               this.cbThu = var64;
               var64 = var36.cbFri;
               Intrinsics.checkNotNullExpressionValue(var64, "cbFri");
               this.cbFri = var64;
               var64 = var36.cbSat;
               Intrinsics.checkNotNullExpressionValue(var64, "cbSat");
               this.cbSat = var64;
               var64 = var36.cbSun;
               Intrinsics.checkNotNullExpressionValue(var64, "cbSun");
               this.cbSun = var64;
               SwitchCompat var37 = var36.scheduleSwitchBtn;
               Intrinsics.checkNotNullExpressionValue(var37, "scheduleSwitchBtn");
               this.scheduleSwitchBtn = var37;
            } else {
               var27 = DialogfragmentDeviceHCreateEditScheduleBinding.inflate(var1, var2, false);
               Intrinsics.checkNotNullExpressionValue(var27, "inflate(...)");
               ViewBinding var38 = var27;
               var27 = (DialogfragmentDeviceHCreateEditScheduleBinding)var38;
               ConstraintLayout var71 = var27.contentContainerActive;
               Intrinsics.checkNotNullExpressionValue(var71, "contentContainerActive");
               this.contentContainerActive = var71;
               var71 = var27.contentContainer;
               Intrinsics.checkNotNullExpressionValue(var71, "contentContainer");
               this.contentContainer = var71;
               TextView var73 = var27.title;
               Intrinsics.checkNotNullExpressionValue(var73, "title");
               this.title = var73;
               ImageButton var74 = var27.backBtn;
               Intrinsics.checkNotNullExpressionValue(var74, "backBtn");
               this.backBtn = var74;
               MaterialButton var75 = var27.saveBtn;
               Intrinsics.checkNotNullExpressionValue(var75, "saveBtn");
               this.saveBtn = var75;
               EditText var76 = var27.scheduleName;
               Intrinsics.checkNotNullExpressionValue(var76, "scheduleName");
               this.scheduleName = var76;
               TextView var77 = var27.timezoneValue;
               Intrinsics.checkNotNullExpressionValue(var77, "timezoneValue");
               this.timezoneValue = var77;
               var77 = var27.startTimeValue;
               Intrinsics.checkNotNullExpressionValue(var77, "startTimeValue");
               this.startTimeValue = var77;
               var77 = var27.endTimeValue;
               Intrinsics.checkNotNullExpressionValue(var77, "endTimeValue");
               this.endTimeValue = var77;
               var77 = var27.scheduleRepeat;
               Intrinsics.checkNotNullExpressionValue(var77, "scheduleRepeat");
               this.scheduleRepeat = var77;
               this.startMainModeIcon = var27.startMainModeIcon;
               this.startIcon = var27.startIcon;
               this.endMainModeIcon = var27.endMainModeIcon;
               this.endIcon = var27.endIcon;
               this.settingsStart = (ViewGroup)var27.settingsStart;
               this.settingsEnd = (ViewGroup)var27.settingsEnd;
               MaterialButton var81 = var27.deleteBtn;
               Intrinsics.checkNotNullExpressionValue(var81, "deleteBtn");
               this.deleteBtn = var81;
               ProgressBlockerView var82 = var27.progressView;
               Intrinsics.checkNotNullExpressionValue(var82, "progressView");
               this.progressView = var82;
               CheckBox var83 = var27.cbMon;
               Intrinsics.checkNotNullExpressionValue(var83, "cbMon");
               this.cbMon = var83;
               var83 = var27.cbTue;
               Intrinsics.checkNotNullExpressionValue(var83, "cbTue");
               this.cbTue = var83;
               var83 = var27.cbWed;
               Intrinsics.checkNotNullExpressionValue(var83, "cbWed");
               this.cbWed = var83;
               var83 = var27.cbThu;
               Intrinsics.checkNotNullExpressionValue(var83, "cbThu");
               this.cbThu = var83;
               var83 = var27.cbFri;
               Intrinsics.checkNotNullExpressionValue(var83, "cbFri");
               this.cbFri = var83;
               var83 = var27.cbSat;
               Intrinsics.checkNotNullExpressionValue(var83, "cbSat");
               this.cbSat = var83;
               var83 = var27.cbSun;
               Intrinsics.checkNotNullExpressionValue(var83, "cbSun");
               this.cbSun = var83;
               SwitchCompat var31 = var27.scheduleSwitchBtn;
               Intrinsics.checkNotNullExpressionValue(var31, "scheduleSwitchBtn");
               this.scheduleSwitchBtn = var31;
               Device var32 = this.device;
               Device var90 = var32;
               if (var32 == null) {
                  Intrinsics.throwUninitializedPropertyAccessException("device");
                  var90 = null;
               }

               var27 = var38;
               if (var90 instanceof HasCombo3in1MainMode) {
                  ImageView var33 = this.startMainModeIcon;
                  if (var33 != null) {
                     ViewExtensionsKt.show$default((View)var33, false, 1, (Object)null);
                  }

                  ImageView var91 = this.endMainModeIcon;
                  var27 = var38;
                  if (var91 != null) {
                     ViewExtensionsKt.show$default((View)var91, false, 1, (Object)null);
                     var27 = var38;
                  }
               }
            }
         }

         ProgressBlockerView var39 = this.progressView;
         if (var39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            var39 = null;
         }

         this.setProgressBlockerView(var39);
         View var34 = var27.getRoot();
         Intrinsics.checkNotNullExpressionValue(var34, "getRoot(...)");
         return var34;
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public void onDestroy() {
      super.onDestroy();
      this.clearProgressFragment();
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -1);
         }
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      ConstraintLayout var35 = this.contentContainer;
      Object var8 = null;
      Object var9 = null;
      ConstraintLayout var11 = var35;
      if (var35 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
         var11 = null;
      }

      var11.setOutlineProvider(new ViewOutlineProvider(this) {
         final DeviceNCreateEditScheduleDialogFragment this$0;

         {
            this.this$0 = var1;
         }

         public void getOutline(View var1, Outline var2) {
            Intrinsics.checkNotNullParameter(var1, "view");
            Intrinsics.checkNotNullParameter(var2, "outline");
            int var3 = (int)TypedValue.applyDimension(1, 25.0F, this.this$0.getResources().getDisplayMetrics());
            var2.setRoundRect(0, 0, var1.getWidth(), var1.getHeight() + var3, (float)var3);
         }
      });
      var35 = this.contentContainer;
      var11 = var35;
      if (var35 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
         var11 = null;
      }

      var11.setClipToOutline(true);
      TextView var37 = this.title;
      TextView var13 = var37;
      if (var37 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("title");
         var13 = null;
      }

      var13.setText((CharSequence)this.getViewModel().getTitle());
      var37 = this.title;
      var13 = var37;
      if (var37 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("title");
         var13 = null;
      }

      var13.post(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda16(this));
      ImageButton var39 = this.backBtn;
      ImageButton var15 = var39;
      if (var39 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("backBtn");
         var15 = null;
      }

      var15.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda3(this));
      MaterialButton var40 = this.saveBtn;
      MaterialButton var16 = var40;
      if (var40 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("saveBtn");
         var16 = null;
      }

      var16.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda4(this));
      this.getViewModel().getSaveBtnEnabled().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda5(this)) {
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
      SwitchCompat var41 = this.scheduleSwitchBtn;
      SwitchCompat var17 = var41;
      if (var41 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleSwitchBtn");
         var17 = null;
      }

      var17.setOnCheckedChangeListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda6(this));
      EditText var42 = this.scheduleName;
      EditText var18 = var42;
      if (var42 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("scheduleName");
         var18 = null;
      }

      var18.setText((CharSequence)this.getViewModel().getDisplayLabel());
      TextView var43 = this.timezoneValue;
      TextView var19 = var43;
      if (var43 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("timezoneValue");
         var19 = null;
      }

      TimezoneUtils var4 = TimezoneUtils.INSTANCE;
      Context var5 = this.requireContext();
      Intrinsics.checkNotNullExpressionValue(var5, "requireContext(...)");
      Device var3 = this.device;
      Device var44 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         var44 = null;
      }

      var19.setText((CharSequence)var4.getDisplayName(var5, Device$_CC.getTimezone$default(var44, (Context)null, 1, (Object)null)));
      this.updateTimeViews();
      this.getViewModel().isStartTimeSameAsEndTime().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda7(this)) {
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
      TextView var45 = this.startTimeValue;
      var19 = var45;
      if (var45 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("startTimeValue");
         var19 = null;
      }

      ViewCompat.setAccessibilityDelegate((View)var19, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_start_time_content_description));
      var45 = this.startTimeValue;
      var19 = var45;
      if (var45 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("startTimeValue");
         var19 = null;
      }

      var19.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda8(this));
      var45 = this.endTimeValue;
      var19 = var45;
      if (var45 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("endTimeValue");
         var19 = null;
      }

      ViewCompat.setAccessibilityDelegate((View)var19, ViewUtils.INSTANCE.createTimePickerShowAccessibilityDelegate(R.string.schedule_end_time_content_description));
      var45 = this.endTimeValue;
      var19 = var45;
      if (var45 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("endTimeValue");
         var19 = null;
      }

      var19.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda9(this));

      for(DayOfWeek var24 : (Iterable)this.getViewModel().getRepeat()) {
         label179: {
            switch (DeviceNCreateEditScheduleDialogFragment.WhenMappings.$EnumSwitchMapping$0[var24.ordinal()]) {
               case 1:
                  CheckBox var55 = this.cbMon;
                  var25 = var55;
                  if (var55 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbMon");
                  break;
               case 2:
                  CheckBox var54 = this.cbTue;
                  var25 = var54;
                  if (var54 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbTue");
                  break;
               case 3:
                  CheckBox var53 = this.cbWed;
                  var25 = var53;
                  if (var53 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbWed");
                  break;
               case 4:
                  CheckBox var52 = this.cbThu;
                  var25 = var52;
                  if (var52 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbThu");
                  break;
               case 5:
                  CheckBox var51 = this.cbFri;
                  var25 = var51;
                  if (var51 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbFri");
                  break;
               case 6:
                  CheckBox var50 = this.cbSat;
                  var25 = var50;
                  if (var50 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbSat");
                  break;
               case 7:
                  CheckBox var49 = this.cbSun;
                  var25 = var49;
                  if (var49 != null) {
                     break label179;
                  }

                  Intrinsics.throwUninitializedPropertyAccessException("cbSun");
                  break;
               default:
                  throw new NoWhenBranchMatchedException();
            }

            var25 = null;
         }

         var25.setChecked(true);
      }

      this.updateRepeatDaysText();
      CheckBox var56 = this.cbMon;
      CheckBox var26 = var56;
      if (var56 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbMon");
         var26 = null;
      }

      CheckBox var64 = this.cbTue;
      var56 = var64;
      if (var64 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbTue");
         var56 = null;
      }

      CheckBox var68 = this.cbWed;
      var64 = var68;
      if (var68 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbWed");
         var64 = null;
      }

      CheckBox var70 = this.cbThu;
      var68 = var70;
      if (var70 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbThu");
         var68 = null;
      }

      CheckBox var6 = this.cbFri;
      var70 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbFri");
         var70 = null;
      }

      CheckBox var7 = this.cbSat;
      var6 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbSat");
         var6 = null;
      }

      CheckBox var10 = this.cbSun;
      var7 = var10;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("cbSun");
         var7 = null;
      }

      Iterator var27 = ((Iterable)CollectionsKt.listOf(new CheckBox[]{var26, var56, var64, var68, var70, var6, var7})).iterator();

      while(var27.hasNext()) {
         ((CheckBox)var27.next()).setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda10(this));
      }

      this.getViewModel().getLivePurifierMode().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda12(this)) {
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
      this.getViewModel().getLiveMainMode().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda17(this)) {
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
      this.getViewModel().getLiveScheduleEndCustomMode().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda18(this)) {
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
      this.getViewModel().getScheduleEndType().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda19(this)) {
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
      this.getViewModel().getLiveScheduleEndCustomMainMode().observe(this.getViewLifecycleOwner(), new Observer(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda20(this)) {
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
      ViewGroup var28 = this.settingsStart;
      if (var28 != null) {
         var28.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda21(this));
      }

      var28 = this.settingsEnd;
      if (var28 != null) {
         var28.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda1(this));
      }

      if (this.getViewModel().getState() == DeviceCreateEditScheduleViewModel.State.MODIFY) {
         MaterialButton var58 = this.deleteBtn;
         MaterialButton var30 = var58;
         if (var58 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
            var30 = null;
         }

         var30.setOnClickListener(new DeviceNCreateEditScheduleDialogFragment$$ExternalSyntheticLambda2(this));
         SwitchCompat var31 = this.scheduleSwitchBtn;
         if (var31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scheduleSwitchBtn");
            var31 = (SwitchCompat)var9;
         }

         var31.setCheckedSilence(this.getViewModel().getPaused() ^ true);
      } else {
         MaterialButton var59 = this.deleteBtn;
         MaterialButton var32 = var59;
         if (var59 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteBtn");
            var32 = null;
         }

         ViewExtensionsKt.hide((View)var32);
         ConstraintLayout var33 = this.contentContainerActive;
         if (var33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainerActive");
            var33 = (ConstraintLayout)var8;
         }

         ViewExtensionsKt.hide((View)var33);
      }

      String var60 = (String)this.getViewModel().getScheduleEndType().getValue();
      String var34 = var60;
      if (var60 == null) {
         var34 = "previous";
      }

      RecyclerView var61 = this.rvStartMode;
      if (var61 != null) {
         Device var66 = this.getViewModel().getDevice();
         Intrinsics.checkNotNull(var66);
         this.startModeAdapter = new DeviceNScheduleModeAdapter(var66, true, var34, this.getViewModel().getPurifierMode(), this.getViewModel().getStartFanSpeed(), this.getViewModel().getStartBrightness(), this.getViewModel().getStartAutoRh(), this.getViewModel().getStartMainMode(), this.getViewModel().getStartApSubMode(), this.getViewModel().getStartSmartSubMode(), this.getViewModel().getStartHeatAutoTemp(), this.getViewModel().getStartHeatEcoTemp(), this.getViewModel().getStartOscillationEnabled(), this.getViewModel().getStartHumMode());
         var61.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
         var61.setAdapter(this.startModeAdapter);
      }

      var61 = this.rvEndMode;
      if (var61 != null) {
         Device var67 = this.getViewModel().getDevice();
         Intrinsics.checkNotNull(var67);
         this.endModeAdapter = new DeviceNScheduleModeAdapter(var67, false, var34, this.getViewModel().getScheduleEndCustomMode(), this.getViewModel().getScheduleEndCustomFanSpeed(), this.getViewModel().getScheduleEndCustomBrightness(), this.getViewModel().getScheduleEndCustomAutoRh(), this.getViewModel().getScheduleEndCustomMainMode(), this.getViewModel().getScheduleEndCustomApSubMode(), this.getViewModel().getScheduleEndCustomSmartSubMode(), this.getViewModel().getScheduleEndCustomHeatAutoTemp(), this.getViewModel().getScheduleEndCustomHeatEcoTemp(), this.getViewModel().getScheduleEndCustomOscillationEnabled(), this.getViewModel().getScheduleEndCustomHumMode());
         var61.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(this.requireContext())));
         var61.setAdapter(this.endModeAdapter);
      }

   }

   public void setProgressBlockerView(ProgressBlockerView var1) {
      this.progressBlockerView = var1;
   }

   public void setViewModel(DeviceCreateEditScheduleViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(Context var1, boolean var2, Integer var3) {
      ProgressFragment$_CC.$default$showProgress(this, var1, var2, var3);
      this.setCancelable(var2 ^ true);
   }

   public void showProgress(boolean var1) {
      ProgressFragment$_CC.showProgress$default(this, this.getContext(), var1, (Integer)null, 4, (Object)null);
   }

   @Metadata(
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceNCreateEditScheduleDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "mergedSchedule", "Lcom/blueair/core/model/DeviceScheduleMerged;", "onScheduleChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isDelete", "", "devicedetails_otherRelease"},
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
      public static DeviceNCreateEditScheduleDialogFragment newInstance$default(Companion var0, Device var1, DeviceScheduleMerged var2, Function1 var3, int var4, Object var5) {
         if ((var4 & 2) != 0) {
            var2 = null;
         }

         return var0.newInstance(var1, var2, var3);
      }

      public final DeviceNCreateEditScheduleDialogFragment newInstance(Device var1, DeviceScheduleMerged var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "device");
         Intrinsics.checkNotNullParameter(var3, "onScheduleChanged");
         DeviceNCreateEditScheduleDialogFragment var4 = new DeviceNCreateEditScheduleDialogFragment();
         var4.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("device", var1), TuplesKt.to("schedule_merged", var2)}));
         var4.onScheduleChanged = var3;
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
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[DayOfWeek.TUE.ordinal()] = 2;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DayOfWeek.WED.ordinal()] = 3;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DayOfWeek.THU.ordinal()] = 4;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DayOfWeek.FRI.ordinal()] = 5;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DayOfWeek.SAT.ordinal()] = 6;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DayOfWeek.SUN.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.AirPurify.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
