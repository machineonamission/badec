package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.adapter.DeviceModeButtonsV2Adapter;
import com.blueair.devicedetails.databinding.HolderDeviceModeButtonsV2Binding;
import com.blueair.viewcore.utils.ModeIcon;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J4\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001fJ\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonsV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "forMainMode", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceModeButtonsV2Binding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getForMainMode", "()Z", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceModeButtonsV2Adapter;", "refreshLayout", "setRecyclerViewMarginH", "dp", "", "update", "forceOffline", "mainMode", "Lcom/blueair/core/model/MainMode;", "modeValue", "stayOffModeValues", "", "disableModeValues", "registerModeIconForHide", "modeIcon", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceModeButtonsV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final DeviceModeButtonsV2Adapter adapter;
   private final boolean forMainMode;

   public DeviceModeButtonsV2Holder(HolderDeviceModeButtonsV2Binding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onModeSelectedListener");
      super(var1);
      this.forMainMode = var3;
      DeviceModeButtonsV2Adapter var5 = new DeviceModeButtonsV2Adapter(var3, var4);
      this.adapter = var5;
      var5.setDevice(var2);
      this.refreshLayout();
   }

   private final void refreshLayout() {
      RecyclerView var3 = ((HolderDeviceModeButtonsV2Binding)this.getBinding()).modeButtons;
      int var2 = RangesKt.coerceIn(this.adapter.getItemCount(), 1, 4);
      if (var2 != 2) {
         if (var2 == 3) {
            this.setRecyclerViewMarginH(35.0F);
         }
      } else {
         float var1;
         if (this.adapter.getDevice() instanceof DeviceMiniRestful) {
            var1 = 0.0F;
         } else {
            var1 = 80.0F;
         }

         this.setRecyclerViewMarginH(var1);
      }

      var3.setLayoutManager((RecyclerView.LayoutManager)(new GridLayoutManager(this.itemView.getContext(), var2)));
      var3.setAdapter(this.adapter);
   }

   private final void setRecyclerViewMarginH(float var1) {
      int var2 = (int)TypedValueCompat.dpToPx(var1, ((HolderDeviceModeButtonsV2Binding)this.getBinding()).modeButtons.getContext().getResources().getDisplayMetrics());
      ViewGroup.LayoutParams var3 = ((HolderDeviceModeButtonsV2Binding)this.getBinding()).modeButtons.getLayoutParams();
      ViewGroup.MarginLayoutParams var4;
      if (var3 instanceof ViewGroup.MarginLayoutParams) {
         var4 = (ViewGroup.MarginLayoutParams)var3;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         var4.setMarginStart(var2);
         var4.setMarginEnd(var2);
         ((HolderDeviceModeButtonsV2Binding)this.getBinding()).modeButtons.setLayoutParams((ViewGroup.LayoutParams)var4);
      }

   }

   // $FF: synthetic method
   public static void update$default(DeviceModeButtonsV2Holder var0, MainMode var1, ModeIcon var2, Set var3, Set var4, int var5, Object var6) {
      if ((var5 & 4) != 0) {
         var3 = SetsKt.emptySet();
      }

      var0.update(var1, var2, var3, var4);
   }

   public final boolean getForMainMode() {
      return this.forMainMode;
   }

   public final void registerModeIconForHide(ModeIcon var1) {
      Intrinsics.checkNotNullParameter(var1, "modeIcon");
      this.adapter.registerModeIconForHide(var1);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      int var3 = this.adapter.getItemCount();
      this.adapter.setDevice(var1);
      if (this.adapter.getItemCount() != var3) {
         this.refreshLayout();
      }

      this.adapter.setForceOffline(var2);
   }

   public final void update(MainMode var1, ModeIcon var2, Set var3, Set var4) {
      Intrinsics.checkNotNullParameter(var1, "mainMode");
      Intrinsics.checkNotNullParameter(var2, "modeValue");
      Intrinsics.checkNotNullParameter(var3, "stayOffModeValues");
      Intrinsics.checkNotNullParameter(var4, "disableModeValues");
      int var5 = this.adapter.getItemCount();
      this.adapter.setMainMode(var1);
      if (this.adapter.getItemCount() != var5) {
         this.refreshLayout();
      }

      this.adapter.setModeValue(var2);
      this.adapter.setStayOffModeValues(var3);
      this.adapter.setDisableModeValues(var4);
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "forMainMode", "", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"},
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
      public static DeviceModeButtonsV2Holder newInstance$default(Companion var0, ViewGroup var1, Device var2, boolean var3, Function1 var4, int var5, Object var6) {
         if ((var5 & 4) != 0) {
            var3 = false;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceModeButtonsV2Holder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onModeSelectedListener");
         HolderDeviceModeButtonsV2Binding var5 = HolderDeviceModeButtonsV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         var5.getRoot().setItemAnimator((RecyclerView.ItemAnimator)null);
         return new DeviceModeButtonsV2Holder(var5, var2, var3, var4);
      }
   }
}
