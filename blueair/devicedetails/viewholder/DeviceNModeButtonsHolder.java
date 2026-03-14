package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceHumidifier;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasStandBy;
import com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter;
import com.blueair.devicedetails.databinding.HolderDeviceHModeButtonsBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(
   d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceNModeButtonsAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "standbyHintText", "Landroid/widget/TextView;", "standbyModeRoot", "Lcom/blueair/devicedetails/databinding/HolderDeviceNModeButtonBinding;", "separator", "Landroid/view/View;", "update", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNModeButtonsHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final DeviceNModeButtonsAdapter adapter;
   private final ViewBinding binding;
   private final Device device;
   private final boolean isInSchedule;
   private final Function1 onModeSelectedListener;
   private final RecyclerView recyclerView;
   private final View separator;
   private final TextView standbyHintText;
   private final HolderDeviceNModeButtonBinding standbyModeRoot;

   // $FF: synthetic method
   public static void $r8$lambda$nirjqPodaIs71OlVTKD1_5_bJ7Q/* $FF was: $r8$lambda$nirjqPodaIs71OlVTKD1-5-bJ7Q*/(DeviceNModeButtonsHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceNModeButtonsHolder(ViewBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onModeSelectedListener");
      View var7 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      super(var7);
      this.binding = var1;
      this.device = var2;
      this.isInSchedule = var3;
      this.onModeSelectedListener = var4;
      DeviceNModeButtonsAdapter var16 = new DeviceNModeButtonsAdapter(var3, var4, false, 4, (DefaultConstructorMarker)null);
      this.adapter = var16;
      if (var1 instanceof HolderDeviceHModeButtonsBinding) {
         RecyclerView var17 = ((HolderDeviceHModeButtonsBinding)var1).modeButtons;
         Intrinsics.checkNotNullExpressionValue(var17, "modeButtons");
         this.recyclerView = var17;
         TextView var8 = ((HolderDeviceHModeButtonsBinding)var1).standbyHint;
         this.standbyHintText = var8;
         HolderDeviceNModeButtonBinding var18 = ((HolderDeviceHModeButtonsBinding)var1).standbyModeRoot;
         this.standbyModeRoot = var18;
         View var10 = ((HolderDeviceHModeButtonsBinding)var1).separator;
         this.separator = var10;
         if (var3) {
            ViewExtensionsKt.hide((View)var8);
            View var19 = var18.getRoot();
            Intrinsics.checkNotNullExpressionValue(var19, "getRoot(...)");
            ViewExtensionsKt.hide(var19);
            ViewExtensionsKt.hide(var10);
         } else {
            var3 = var2 instanceof DeviceNewClassic;
            View var9 = var18.getRoot();
            Intrinsics.checkNotNullExpressionValue(var9, "getRoot(...)");
            ViewExtensionsKt.show(var9, var3);
            ViewExtensionsKt.show(var10, var3);
            if (var3) {
               var8.setText(R.string.air_purifier_off_msg);
               var18.modeRoot.setOnClickListener(new DeviceNModeButtonsHolder$$ExternalSyntheticLambda0(this));
            }

            ViewUtils var11 = ViewUtils.INSTANCE;
            View var20 = var18.getRoot();
            Intrinsics.checkNotNullExpressionValue(var20, "getRoot(...)");
            ViewUtils.setAccessibilityDelegate$default(var11, var20, Reflection.getOrCreateKotlinClass(RadioButton.class), (String)null, (Function2)null, 12, (Object)null);
         }
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNModeButtonsBinding");
         HolderDeviceNModeButtonsBinding var21 = (HolderDeviceNModeButtonsBinding)var1;
         RecyclerView var12 = ((HolderDeviceNModeButtonsBinding)var1).modeButtons;
         Intrinsics.checkNotNullExpressionValue(var12, "modeButtons");
         this.recyclerView = var12;
         this.standbyHintText = null;
         this.standbyModeRoot = null;
         this.separator = null;
      }

      var16.setDevice(var2);
      RecyclerView var14 = this.recyclerView;
      Context var13 = this.itemView.getContext();
      int var6 = var16.getItemCount();
      int var5 = 4;
      if (var6 < 4) {
         var5 = var16.getItemCount();
      }

      var14.setLayoutManager((RecyclerView.LayoutManager)(new GridLayoutManager(var13, var5)));
      this.recyclerView.setAdapter(var16);
   }

   private static final void _init_$lambda$0(DeviceNModeButtonsHolder var0, View var1) {
      var0.onModeSelectedListener.invoke(ModeIcon.STANDBY);
   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.adapter.setDevice(var1);
      TextView var3 = this.standbyHintText;
      if (var3 != null) {
         View var5 = (View)var3;
         boolean var2;
         if ((var1 instanceof DeviceHumidifier || var1 instanceof DeviceNewClassic) && ((HasStandBy)var1).isStandByOn()) {
            var2 = true;
         } else {
            var2 = false;
         }

         ViewExtensionsKt.show(var5, var2);
      }

      HolderDeviceNModeButtonBinding var6 = this.standbyModeRoot;
      if (var6 != null) {
         View var7 = var6.getRoot();
         if (var7 != null && var7.getVisibility() == 0 && var1 instanceof HasStandBy) {
            HolderDeviceNModeButtonBinding var8 = this.standbyModeRoot;
            var1 = var1;
            if (var1.isStandByOn()) {
               var8.modeIcon.setImageResource(ModeIcon.STANDBY.getOnIcon());
               var8.modeText.setText(R.string.turn_on);
            } else {
               var8.modeIcon.setImageResource(ModeIcon.STANDBY.getOffIcon());
               var8.modeText.setText(R.string.on);
            }

            this.standbyModeRoot.getRoot().setSelected(var1.isStandByOn() ^ true);
         }
      }

   }

   public final void update(Device var1, DeviceCreateEditScheduleViewModel.PurifierMode var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "mode");
      this.adapter.setPurifierMode(var2);
      this.adapter.setDevice(var1);
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNModeButtonsHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"},
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

      public final DeviceNModeButtonsHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onModeSelectedListener");
         ViewBinding var6;
         if (var2 instanceof DeviceCombo2in1 || var2 instanceof DevicePet20 || var2 instanceof DeviceHumidifier && !var3 || var2 instanceof DeviceNewClassic && !var3) {
            HolderDeviceHModeButtonsBinding var7 = HolderDeviceHModeButtonsBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
            var6 = var7;
         } else {
            HolderDeviceNModeButtonsBinding var5 = HolderDeviceNModeButtonsBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
            var6 = var5;
         }

         return new DeviceNModeButtonsHolder(var6, var2, var3, var4);
      }
   }
}
