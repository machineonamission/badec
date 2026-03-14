package com.blueair.devicedetails.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.viewholder.DeviceNModeButtonHolder;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.PopupInfoDialogFragment;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.utils.ModeIconKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B@\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012%\b\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010'\u001a\u00020(H\u0016J\u0018\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020(H\u0016J\u0018\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020(H\u0016J\"\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u000105H\u0002J \u00106\u001a\u00020\u000b2\u0006\u00101\u001a\u0002022\u0006\u00107\u001a\u00020(2\u0006\u00108\u001a\u00020(H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000fR.\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000fR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00069"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNModeButtonsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonHolder;", "isInSchedule", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "isMainMode", "<init>", "(ZLkotlin/jvm/functions/Function1;Z)V", "()Z", "getOnModeSelectedListener", "()Lkotlin/jvm/functions/Function1;", "modes", "", "purifierMode", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "getPurifierMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "setPurifierMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "purifierMainMode", "Lcom/blueair/core/model/MainMode;", "getPurifierMainMode", "()Lcom/blueair/core/model/MainMode;", "setPurifierMainMode", "(Lcom/blueair/core/model/MainMode;)V", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "handleClickInfo", "view", "Landroid/view/View;", "mainMode", "subMode", "Lcom/blueair/core/model/ApSubMode;", "showInfoDialog", "title", "content", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNModeButtonsAdapter extends RecyclerView.Adapter {
   private Device device;
   private final boolean isInSchedule;
   private final boolean isMainMode;
   private List modes;
   private final Function1 onModeSelectedListener;
   private MainMode purifierMainMode;
   private DeviceCreateEditScheduleViewModel.PurifierMode purifierMode;

   // $FF: synthetic method
   public static void $r8$lambda$2h7TnmkrhY_VUK93qLRQRZ1VG4Q/* $FF was: $r8$lambda$2h7TnmkrhY-VUK93qLRQRZ1VG4Q*/(DeviceNModeButtonsAdapter var0, ModeIcon var1, View var2) {
      onBindViewHolder$lambda$0(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4zfcqZOXTBW1TB6tzMJg_uDpY8s(DeviceNModeButtonsAdapter var0, ModeIcon var1, View var2) {
      onBindViewHolder$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$ZLrocktn5FQQ0cp5uYusvU0hxcc(ModeIcon var0, DeviceNModeButtonsAdapter var1, View var2) {
      onBindViewHolder$lambda$2(var0, var1, var2);
   }

   public DeviceNModeButtonsAdapter(boolean var1, Function1 var2, boolean var3) {
      this.isInSchedule = var1;
      this.onModeSelectedListener = var2;
      this.isMainMode = var3;
      this.modes = CollectionsKt.emptyList();
   }

   // $FF: synthetic method
   public DeviceNModeButtonsAdapter(boolean var1, Function1 var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 2) != 0) {
         var2 = null;
      }

      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   private final void handleClickInfo(View var1, MainMode var2, ApSubMode var3) {
      if (var3 == null && var2 == MainMode.HEAT) {
         this.showInfoDialog(var1, R.string.main_mode_heat, R.string.mode_disable_hint_heat);
      }

   }

   private static final void onBindViewHolder$lambda$0(DeviceNModeButtonsAdapter var0, ModeIcon var1, View var2) {
      Function1 var3 = var0.onModeSelectedListener;
      if (var3 != null) {
         var3.invoke(var1);
      }

   }

   private static final void onBindViewHolder$lambda$2(ModeIcon var0, DeviceNModeButtonsAdapter var1, View var2) {
      MainMode var3 = var0.toMainMode();
      if (var3 != null) {
         Intrinsics.checkNotNull(var2);
         var1.handleClickInfo(var2, var3, (ApSubMode)null);
      }

   }

   private static final void onBindViewHolder$lambda$4(DeviceNModeButtonsAdapter var0, ModeIcon var1, View var2) {
      MainMode var3 = var0.purifierMainMode;
      MainMode var4 = var3;
      if (var3 == null) {
         HasCombo3in1MainMode var6 = var0.device;
         if (var6 instanceof HasCombo3in1MainMode) {
            var6 = var6;
         } else {
            var6 = null;
         }

         MainMode var8;
         if (var6 != null) {
            var8 = var6.mainMode();
         } else {
            var8 = null;
         }

         var4 = var8;
         if (var8 == null) {
            return;
         }
      }

      ApSubMode var5 = var1.toApSubMode();
      if (var5 != null) {
         Intrinsics.checkNotNull(var2);
         var0.handleClickInfo(var2, var4, var5);
      }

   }

   private final void showInfoDialog(View var1, int var2, int var3) {
      FragmentManager var4 = ViewKt.findFragment(var1).getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var4, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("PopupInfoDialogFragment", "getSimpleName(...)");
      if (!(var4.findFragmentByTag("PopupInfoDialogFragment") instanceof PopupInfoDialogFragment) && !var4.isStateSaved()) {
         ((DialogFragment)PopupInfoDialogFragment.Companion.newInstance(var2, (Integer)null, var3)).show(var4, "PopupInfoDialogFragment");
      }

   }

   public final Device getDevice() {
      return this.device;
   }

   public int getItemCount() {
      return this.modes.size();
   }

   public final Function1 getOnModeSelectedListener() {
      return this.onModeSelectedListener;
   }

   public final MainMode getPurifierMainMode() {
      return this.purifierMainMode;
   }

   public final DeviceCreateEditScheduleViewModel.PurifierMode getPurifierMode() {
      return this.purifierMode;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final boolean isMainMode() {
      return this.isMainMode;
   }

   public void onBindViewHolder(DeviceNModeButtonHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      ModeIcon var3 = (ModeIcon)this.modes.get(var2);
      var1.getBinding().modeRoot.setOnClickListener(new DeviceNModeButtonsAdapter$$ExternalSyntheticLambda0(this, var3));
      if (this.isMainMode) {
         var1.updateMainMode(var3, this.device, this.purifierMainMode, this.purifierMode);
         var1.getBinding().infoView.setOnClickListener(new DeviceNModeButtonsAdapter$$ExternalSyntheticLambda1(var3, this));
      } else {
         var1.updateMode(var3, this.device, this.purifierMainMode, this.purifierMode);
         var1.getBinding().infoView.setOnClickListener(new DeviceNModeButtonsAdapter$$ExternalSyntheticLambda2(this, var3));
      }
   }

   public DeviceNModeButtonHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      return DeviceNModeButtonHolder.Companion.newInstance(var1);
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1) || this.purifierMode != null || this.purifierMainMode != null) {
         this.device = var1;
         this.modes = ModeIconKt.getSupportedModes$default(var1, this.isInSchedule, this.isMainMode, (MainMode)null, 4, (Object)null);
         this.notifyDataSetChanged();
      }
   }

   public final void setPurifierMainMode(MainMode var1) {
      this.purifierMainMode = var1;
   }

   public final void setPurifierMode(DeviceCreateEditScheduleViewModel.PurifierMode var1) {
      this.purifierMode = var1;
   }
}
