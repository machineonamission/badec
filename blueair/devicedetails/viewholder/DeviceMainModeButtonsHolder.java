package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.adapter.DeviceNModeButtonsAdapter;
import com.blueair.devicedetails.databinding.HolderDeviceMainModeButtonsBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeButtonsBinding;", "device", "Lcom/blueair/core/model/Device;", "onMainModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "onSubModeSelectedListener", "Lcom/blueair/core/model/ApSubMode;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeButtonsBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeButtonsBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "mainModeAdapter", "Lcom/blueair/devicedetails/adapter/DeviceNModeButtonsAdapter;", "subModeAdapter", "update", "mainMode", "subMode", "isStandbyOn", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceMainModeButtonsHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceMainModeButtonsBinding binding;
   private final Device device;
   private final DeviceNModeButtonsAdapter mainModeAdapter;
   private final Function1 onMainModeSelectedListener;
   private final Function1 onSubModeSelectedListener;
   private final DeviceNModeButtonsAdapter subModeAdapter;

   // $FF: synthetic method
   public static Unit $r8$lambda$2eo2gueCmNPEp0QQIb5gEzwLRUo(DeviceMainModeButtonsHolder var0, ModeIcon var1) {
      return mainModeAdapter$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Pw9YrFNw5mtEqlW2eQ5m2pFOoEM(DeviceMainModeButtonsHolder var0, ModeIcon var1) {
      return subModeAdapter$lambda$1(var0, var1);
   }

   public DeviceMainModeButtonsHolder(HolderDeviceMainModeButtonsBinding var1, Device var2, Function1 var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onMainModeSelectedListener");
      Intrinsics.checkNotNullParameter(var4, "onSubModeSelectedListener");
      LinearLayout var5 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      super((View)var5);
      this.binding = var1;
      this.device = var2;
      this.onMainModeSelectedListener = var3;
      this.onSubModeSelectedListener = var4;
      DeviceNModeButtonsAdapter var8 = new DeviceNModeButtonsAdapter(false, new DeviceMainModeButtonsHolder$$ExternalSyntheticLambda0(this), true);
      this.mainModeAdapter = var8;
      DeviceNModeButtonsAdapter var9 = new DeviceNModeButtonsAdapter(false, new DeviceMainModeButtonsHolder$$ExternalSyntheticLambda1(this), false, 4, (DefaultConstructorMarker)null);
      this.subModeAdapter = var9;
      RecyclerView var6 = var1.mainModeButtons;
      GridLayoutManager var7 = new GridLayoutManager(this.itemView.getContext(), 4);
      var7.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
         public int getSpanSize(int var1) {
            return var1 % 3 == 1 ? 2 : 1;
         }
      });
      var6.setLayoutManager((RecyclerView.LayoutManager)var7);
      var1.mainModeButtons.setAdapter(var8);
      var1.subModeButtons.setLayoutManager((RecyclerView.LayoutManager)(new GridLayoutManager(this.itemView.getContext(), 4)));
      var1.subModeButtons.setAdapter(var9);
   }

   private static final Unit mainModeAdapter$lambda$0(DeviceMainModeButtonsHolder var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      MainMode var2 = var1.toMainMode();
      if (var2 != null) {
         var0.onMainModeSelectedListener.invoke(var2);
      }

      return Unit.INSTANCE;
   }

   private static final Unit subModeAdapter$lambda$1(DeviceMainModeButtonsHolder var0, ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      ApSubMode var2 = var1.toApSubMode();
      if (var2 != null) {
         var0.onSubModeSelectedListener.invoke(var2);
      }

      return Unit.INSTANCE;
   }

   public final HolderDeviceMainModeButtonsBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.mainModeAdapter.setDevice(var1);
      this.subModeAdapter.setDevice(var1);
      TextView var4 = this.binding.heatHint;
      Intrinsics.checkNotNullExpressionValue(var4, "heatHint");
      View var6 = (View)var4;
      boolean var2 = var1 instanceof HasCombo3in1MainMode;
      Object var5 = null;
      HasCombo3in1MainMode var8;
      if (var2) {
         var8 = (HasCombo3in1MainMode)var1;
      } else {
         var8 = null;
      }

      label24: {
         if (var8 != null) {
            boolean var3 = var8.isInMainMode(MainMode.HEAT);
            var2 = true;
            if (var3) {
               HasStandBy var9 = (HasStandBy)var5;
               if (var1 instanceof HasStandBy) {
                  var9 = (HasStandBy)var1;
               }

               if (var9 != null && !var9.isStandByOn()) {
                  break label24;
               }
            }
         }

         var2 = false;
      }

      ViewExtensionsKt.show(var6, var2);
   }

   public final void update(Device var1, MainMode var2, ApSubMode var3, boolean var4) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "mainMode");
      Intrinsics.checkNotNullParameter(var3, "subMode");
      this.mainModeAdapter.setPurifierMainMode(var2);
      this.subModeAdapter.setPurifierMainMode(var2);
      DeviceCreateEditScheduleViewModel.PurifierMode var6;
      if (var4) {
         var6 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
      } else {
         var6 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromSubMode(var3);
      }

      this.mainModeAdapter.setPurifierMode(var6);
      this.subModeAdapter.setPurifierMode(var6);
      this.subModeAdapter.setDevice(var1);
      this.mainModeAdapter.setDevice(var1);
      TextView var5 = this.binding.heatHint;
      Intrinsics.checkNotNullExpressionValue(var5, "heatHint");
      ViewExtensionsKt.hide((View)var5);
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J^\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMainModeButtonsHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onMainModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "onSubModeSelectedListener", "Lcom/blueair/core/model/ApSubMode;", "devicedetails_otherRelease"},
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

      public final DeviceMainModeButtonsHolder newInstance(ViewGroup var1, Device var2, Function1 var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onMainModeSelectedListener");
         Intrinsics.checkNotNullParameter(var4, "onSubModeSelectedListener");
         HolderDeviceMainModeButtonsBinding var5 = HolderDeviceMainModeButtonsBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceMainModeButtonsHolder(var5, var2, var3, var4);
      }
   }
}
