package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasChildLock;
import com.blueair.devicedetails.databinding.HolderDeviceHChildLockBinding;
import com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNChildLockHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "device", "Lcom/blueair/core/model/Device;", "onChildLockSetListener", "Lkotlin/Function1;", "", "", "<init>", "(Landroidx/viewbinding/ViewBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "switchBtn", "Lcom/blueair/viewcore/view/SwitchCompat;", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNChildLockHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewBinding binding;
   private final Device device;
   private final Function1 onChildLockSetListener;
   private final SwitchCompat switchBtn;

   // $FF: synthetic method
   public static void $r8$lambda$0T_HDpSb1Hc4kbXN__DrGtr7dEE/* $FF was: $r8$lambda$0T-HDpSb1Hc4kbXN__DrGtr7dEE*/(DeviceNChildLockHolder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   public DeviceNChildLockHolder(ViewBinding var1, Device var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onChildLockSetListener");
      View var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super(var4);
      this.binding = var1;
      this.device = var2;
      this.onChildLockSetListener = var3;
      if (var1 instanceof HolderDeviceHChildLockBinding) {
         SwitchCompat var7 = ((HolderDeviceHChildLockBinding)var1).switchBtn;
         Intrinsics.checkNotNullExpressionValue(var7, "switchBtn");
         this.switchBtn = var7;
         if (var2 instanceof DevicePet20) {
            ((HolderDeviceHChildLockBinding)var1).title.setText(R.string.display_lock_pet20);
         }
      } else {
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceNChildLockBinding");
         HolderDeviceNChildLockBinding var6 = (HolderDeviceNChildLockBinding)var1;
         SwitchCompat var5 = ((HolderDeviceNChildLockBinding)var1).switchBtn;
         Intrinsics.checkNotNullExpressionValue(var5, "switchBtn");
         this.switchBtn = var5;
      }

      this.switchBtn.setOnCheckedChangeListener(new DeviceNChildLockHolder$$ExternalSyntheticLambda0(this));
   }

   private static final void _init_$lambda$0(DeviceNChildLockHolder var0, CompoundButton var1, boolean var2) {
      var0.onChildLockSetListener.invoke(var2);
   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasChildLock) {
         this.switchBtn.setCheckedSilence(((HasChildLock)var1).isChildLockOn());
      }

   }

   @Metadata(
      d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¨\u0006\u000e"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNChildLockHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNChildLockHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onChildLockSetListener", "Lkotlin/Function1;", "", "", "devicedetails_otherRelease"},
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

      public final DeviceNChildLockHolder newInstance(ViewGroup var1, Device var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onChildLockSetListener");
         Function3 var4;
         if (var2 instanceof DeviceNewClassic) {
            var4 = null.INSTANCE;
         } else {
            var4 = null.INSTANCE;
         }

         LayoutInflater var5 = LayoutInflater.from(var1.getContext());
         Intrinsics.checkNotNullExpressionValue(var5, "from(...)");
         return new DeviceNChildLockHolder((ViewBinding)var4.invoke(var5, var1, false), var2, var3);
      }
   }
}
