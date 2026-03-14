package com.blueair.devicedetails.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.Device$_CC;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasWick;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.util.DeviceNSettings;
import com.blueair.devicedetails.viewholder.DeviceNSettingDeleteHolder;
import com.blueair.devicedetails.viewholder.DeviceNSettingHolder;
import com.blueair.devicedetails.viewholder.DeviceNSettingTriggerHolder;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0016Ra\u0010\u0005\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"},
   d2 = {"Lcom/blueair/devicedetails/adapter/DeviceNSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "<init>", "()V", "onSettingActionListener", "Lkotlin/Function3;", "Lcom/blueair/devicedetails/util/DeviceNSettings;", "Lkotlin/ParameterName;", "name", "type", "Lcom/blueair/core/model/Device;", "device", "", "data", "", "getOnSettingActionListener", "()Lkotlin/jvm/functions/Function3;", "setOnSettingActionListener", "(Lkotlin/jvm/functions/Function3;)V", "settings", "", "value", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "getItemCount", "", "getItemViewType", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSettingsAdapter extends RecyclerView.Adapter {
   private Device device;
   private Function3 onSettingActionListener;
   private List settings = CollectionsKt.emptyList();

   // $FF: synthetic method
   public static Unit $r8$lambda$BfIZnTRI1preDrWA9SGQ_nxuxnM/* $FF was: $r8$lambda$BfIZnTRI1preDrWA9SGQ-nxuxnM*/(Device var0, DeviceNSettingsAdapter var1, DeviceNSettings var2, FilterTrigger var3) {
      return onBindViewHolder$lambda$2(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$L3YmgqBy_uesEtJqplx9cMWOtrg(DeviceNSettingsAdapter var0, DeviceNSettings var1, Device var2, View var3) {
      onBindViewHolder$lambda$0(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$rJXbumhHQudKU6IzK2MjaMxwu3s(Device var0, DeviceNSettingsAdapter var1, DeviceNSettings var2, FilterTrigger var3) {
      return onBindViewHolder$lambda$1(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$roHN7l_AA1Pj4dEqYimGy82JBVI(DeviceNSettingsAdapter var0, DeviceNSettings var1, Device var2, View var3) {
      onBindViewHolder$lambda$3(var0, var1, var2, var3);
   }

   private static final void onBindViewHolder$lambda$0(DeviceNSettingsAdapter var0, DeviceNSettings var1, Device var2, View var3) {
      Function3 var4 = var0.onSettingActionListener;
      if (var4 != null) {
         var4.invoke(var1, var2, Unit.INSTANCE);
      }

   }

   private static final Unit onBindViewHolder$lambda$1(Device var0, DeviceNSettingsAdapter var1, DeviceNSettings var2, FilterTrigger var3) {
      Intrinsics.checkNotNullParameter(var3, "newTrigger");
      if (!Intrinsics.areEqual(var3, ((DeviceNewClassic)var0).getTrigger())) {
         Function3 var4 = var1.onSettingActionListener;
         if (var4 != null) {
            var4.invoke(var2, var0, var3);
         }
      }

      return Unit.INSTANCE;
   }

   private static final Unit onBindViewHolder$lambda$2(Device var0, DeviceNSettingsAdapter var1, DeviceNSettings var2, FilterTrigger var3) {
      Intrinsics.checkNotNullParameter(var3, "newTrigger");
      if (!Intrinsics.areEqual(var3, ((DeviceNewClassic)var0).getG4NightModeTrigger())) {
         Function3 var4 = var1.onSettingActionListener;
         if (var4 != null) {
            var4.invoke(var2, var0, var3);
         }
      }

      return Unit.INSTANCE;
   }

   private static final void onBindViewHolder$lambda$3(DeviceNSettingsAdapter var0, DeviceNSettings var1, Device var2, View var3) {
      Function3 var4 = var0.onSettingActionListener;
      if (var4 != null) {
         var4.invoke(var1, var2, Unit.INSTANCE);
      }

   }

   public final Device getDevice() {
      return this.device;
   }

   public int getItemCount() {
      return this.settings.size();
   }

   public int getItemViewType(int var1) {
      return ((DeviceNSettings)this.settings.get(var1)).ordinal();
   }

   public final Function3 getOnSettingActionListener() {
      return this.onSettingActionListener;
   }

   public void onBindViewHolder(RecyclerView.ViewHolder var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "holder");
      Device var7 = this.device;
      if (var7 != null) {
         DeviceNSettings var6 = (DeviceNSettings)this.settings.get(var2);
         if (var1 instanceof DeviceNSettingHolder) {
            var2 = DeviceNSettingsAdapter.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
            HasWick var18 = null;
            switch (var2) {
               case 1:
                  ((DeviceNSettingHolder)var1).update(R.string.custom_name, var7.getName());
                  break;
               case 2:
                  DeviceNSettingHolder var9 = (DeviceNSettingHolder)var1;
                  var2 = R.string.timezone;
                  TimezoneUtils var23 = TimezoneUtils.INSTANCE;
                  Context var21 = var1.itemView.getContext();
                  Intrinsics.checkNotNullExpressionValue(var21, "getContext(...)");
                  var9.update(var2, var23.getDisplayName(var21, Device$_CC.getTimezone$default(var7, (Context)null, 1, (Object)null)));
                  break;
               case 3:
                  ((DeviceNSettingHolder)var1).update(R.string.product_info, "");
                  break;
               case 4:
                  if (DeviceKt.isCelsiusUnit(var7)) {
                     var2 = R.string.temperature_celsius;
                  } else {
                     var2 = R.string.temperature_fahrenheit;
                  }

                  DeviceNSettingHolder var20 = (DeviceNSettingHolder)var1;
                  int var17 = R.string.temp_expanded;
                  String var22 = var1.itemView.getContext().getString(var2);
                  Intrinsics.checkNotNullExpressionValue(var22, "getString(...)");
                  var20.update(var17, var22);
                  break;
               case 5:
                  if (var7 instanceof HasWick) {
                     var18 = (HasWick)var7;
                  }

                  boolean var4;
                  if (var18 != null) {
                     var4 = var18.getWickdryEnabled();
                  } else {
                     var4 = false;
                  }

                  if (var4) {
                     var2 = R.string.on;
                  } else {
                     var2 = R.string.off;
                  }

                  DeviceNSettingHolder var19 = (DeviceNSettingHolder)var1;
                  int var3 = R.string.dry_mode;
                  String var8 = var1.itemView.getContext().getString(var2);
                  Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
                  var19.update(var3, var8);
                  break;
               case 6:
                  ((DeviceNSettingHolder)var1).update(R.string.error_report, "");
            }

            ((DeviceNSettingHolder)var1).getBinding().getRoot().setOnClickListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda0(this, var6, var7));
            return;
         }

         if (var1 instanceof DeviceNSettingTriggerHolder) {
            DeviceNewClassic var5 = (DeviceNewClassic)var7;
            var2 = DeviceNSettingsAdapter.WhenMappings.$EnumSwitchMapping$0[var6.ordinal()];
            if (var2 == 7) {
               var1 = var1;
               var1.update(R.string.triggers_for_auto_mode_n, var5.getTrigger(), var5.isStandByOn());
               var1.setOnTriggerSelectedListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda1(var7, this, var6));
               return;
            }

            if (var2 == 8) {
               var1 = var1;
               var1.update(R.string.triggers_for_night_mode_n, var5.getG4NightModeTrigger(), var5.isStandByOn());
               var1.setOnTriggerSelectedListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda2(var7, this, var6));
               return;
            }
         } else if (var1 instanceof DeviceNSettingDeleteHolder) {
            ((DeviceNSettingDeleteHolder)var1).getDeleteButton().setOnClickListener(new DeviceNSettingsAdapter$$ExternalSyntheticLambda3(this, var6, var7));
         }
      }

   }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup var1, int var2) {
      Intrinsics.checkNotNullParameter(var1, "parent");
      DeviceNSettings var3 = (DeviceNSettings)DeviceNSettings.getEntries().get(var2);
      switch (DeviceNSettingsAdapter.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()]) {
         case 1:
         case 2:
         case 3:
         case 4:
         case 5:
         case 6:
            return DeviceNSettingHolder.Companion.newInstance(var1);
         case 7:
         case 8:
            return DeviceNSettingTriggerHolder.Companion.newInstance(var1);
         case 9:
            return DeviceNSettingDeleteHolder.Companion.newInstance(var1, this.device);
         default:
            throw new NoWhenBranchMatchedException();
      }
   }

   public final void setDevice(Device var1) {
      if (!Intrinsics.areEqual(this.device, var1)) {
         this.device = var1;
         this.settings = DeviceNSettings.Companion.getSupportedSettings(this.device);
         this.notifyDataSetChanged();
      }

   }

   public final void setOnSettingActionListener(Function3 var1) {
      this.onSettingActionListener = var1;
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
         int[] var0 = new int[DeviceNSettings.values().length];

         try {
            var0[DeviceNSettings.CUSTOM_NAME.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceNSettings.TIME_ZONE.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceNSettings.PRODUCT_INFO.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceNSettings.TEMPERATURE.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceNSettings.DRY_MODE.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceNSettings.SYSTEM_INFO.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceNSettings.TRIGGER_AUTO.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceNSettings.TRIGGER_NIGHT.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceNSettings.DELETE.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
