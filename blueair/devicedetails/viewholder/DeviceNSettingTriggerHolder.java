package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.FilterTrigger;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsTriggerBinding;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R7\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingTriggerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsTriggerBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsTriggerBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNSettingsTriggerBinding;", "onTriggerSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FilterTrigger;", "Lkotlin/ParameterName;", "name", "trigger", "", "getOnTriggerSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnTriggerSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "update", "title", "", "value", "disabled", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNSettingTriggerHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNSettingsTriggerBinding binding;
   private Function1 onTriggerSelectedListener;

   public DeviceNSettingTriggerHolder(HolderDeviceNSettingsTriggerBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
      RadioGroup var2 = var1.radioGroupTrigger;
      Intrinsics.checkNotNullExpressionValue(var2, "radioGroupTrigger");
      Iterator var3 = ViewGroupKt.getChildren((ViewGroup)var2).iterator();

      while(var3.hasNext()) {
         ((View)var3.next()).setOnClickListener(new DeviceNSettingTriggerHolder$$ExternalSyntheticLambda0(this));
      }

   }

   static final void lambda$2$lambda$1(DeviceNSettingTriggerHolder var0, View var1) {
      int var2 = var1.getId();
      FilterTrigger var4;
      if (var2 == R.id.radio_button_pm) {
         var4 = FilterTrigger.Particles.INSTANCE;
      } else if (var2 == R.id.radio_button_pm_tvoc) {
         var4 = FilterTrigger.ParticlesAndGases.INSTANCE;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         Function1 var3 = var0.onTriggerSelectedListener;
         if (var3 != null) {
            var3.invoke(var4);
         }
      }

   }

   public final HolderDeviceNSettingsTriggerBinding getBinding() {
      return this.binding;
   }

   public final Function1 getOnTriggerSelectedListener() {
      return this.onTriggerSelectedListener;
   }

   public final void setOnTriggerSelectedListener(Function1 var1) {
      this.onTriggerSelectedListener = var1;
   }

   public final void update(int var1, FilterTrigger var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var2, "value");
      this.binding.title.setText(var1);
      if (var2 instanceof FilterTrigger.Particles) {
         var1 = R.id.radio_button_pm;
      } else if (var2 instanceof FilterTrigger.ParticlesAndGases) {
         var1 = R.id.radio_button_pm_tvoc;
      } else {
         var1 = R.id.radio_button_pm;
      }

      this.binding.radioGroupTrigger.check(var1);
      TextView var7 = this.binding.title;
      Context var4 = this.itemView.getContext();
      if (var3) {
         var1 = com.blueair.viewcore.R.color.marineblue_20;
      } else {
         var1 = com.blueair.viewcore.R.color.colorPrimaryText;
      }

      var7.setTextColor(ContextCompat.getColor(var4, var1));
      RadioGroup var8 = this.binding.radioGroupTrigger;
      Intrinsics.checkNotNullExpressionValue(var8, "radioGroupTrigger");
      Iterator var9 = ViewGroupKt.getChildren((ViewGroup)var8).iterator();

      while(var9.hasNext()) {
         ((View)var9.next()).setEnabled(var3 ^ true);
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNSettingTriggerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNSettingTriggerHolder;", "parentView", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceNSettingTriggerHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderDeviceNSettingsTriggerBinding var2 = HolderDeviceNSettingsTriggerBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceNSettingTriggerHolder(var2);
      }
   }
}
