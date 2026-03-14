package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.HasBody;
import com.blueair.core.model.HasChildLock;
import com.blueair.devicedetails.databinding.HolderDeviceSchedulesBinding;
import com.blueair.viewcore.R;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSchedulesHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceSchedulesBinding;", "binding", "onChildLockClickedListener", "Lkotlin/Function0;", "", "onOpenSchedulesListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceSchedulesBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "schedules", "", "Lcom/blueair/core/model/DeviceScheduleMerged;", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSchedulesHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Function0 onChildLockClickedListener;
   private final Function0 onOpenSchedulesListener;

   // $FF: synthetic method
   public static void $r8$lambda$uhXC7iQqW5RoMoAO_91JngF_BUA/* $FF was: $r8$lambda$uhXC7iQqW5RoMoAO_91JngF-BUA*/(DeviceSchedulesHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$w7xD_LPJ7usAuoKGg_8UPhUFkPs/* $FF was: $r8$lambda$w7xD-LPJ7usAuoKGg_8UPhUFkPs*/(DeviceSchedulesHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   public DeviceSchedulesHolder(HolderDeviceSchedulesBinding var1, Function0 var2, Function0 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onChildLockClickedListener");
      Intrinsics.checkNotNullParameter(var3, "onOpenSchedulesListener");
      super(var1);
      this.onChildLockClickedListener = var2;
      this.onOpenSchedulesListener = var3;
      var1.childLockContainer.setOnClickListener(new DeviceSchedulesHolder$$ExternalSyntheticLambda0(this));
      var1.schedulesContainer.setOnClickListener(new DeviceSchedulesHolder$$ExternalSyntheticLambda1(this));
   }

   private static final void _init_$lambda$0(DeviceSchedulesHolder var0, View var1) {
      var0.onChildLockClickedListener.invoke();
   }

   private static final void _init_$lambda$1(DeviceSchedulesHolder var0, View var1) {
      var0.onOpenSchedulesListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var5 = var1 instanceof HasChildLock;
      Object var7 = null;
      HasChildLock var6;
      if (var5) {
         var6 = (HasChildLock)var1;
      } else {
         var6 = null;
      }

      if (var6 != null) {
         boolean var3;
         HolderDeviceSchedulesBinding var8;
         label55: {
            var8 = (HolderDeviceSchedulesBinding)this.getBinding();
            if (!var2 && var1.isOnline() && !DeviceKt.isStandByOn(var1)) {
               HasBody var14 = (HasBody)var7;
               if (var1 instanceof HasBody) {
                  var14 = (HasBody)var1;
               }

               if (var14 == null || var14.getBodyMounted()) {
                  var3 = 0;
                  break label55;
               }
            }

            var3 = 1;
         }

         var8.childLockContainer.setEnabled((boolean)(var3 ^ true));
         ConstraintLayout var15 = var8.childLockContainer;
         int var4;
         if (var3) {
            var4 = R.drawable.rounded_rectangle_white_r1000_black5_stroke1_disabled_white_bg;
         } else {
            var4 = R.drawable.rounded_rectangle_white_r1000_black5_stroke1;
         }

         var15.setBackgroundResource(var4);
         TextView var16 = var8.childLockText;
         if (var3) {
            var4 = R.color.surface_dark_55;
         } else {
            var4 = R.color.colorPrimaryText;
         }

         var16.setTextColor(this.getColor(var4));
         if (((HasChildLock)var1).isChildLockOn()) {
            ImageView var10 = var8.childLockIcon;
            if (var3) {
               var3 = R.drawable.ic_child_lock_on_disabled;
            } else {
               var3 = R.drawable.ic_child_lock_on;
            }

            var10.setImageResource(var3);
            var8.childLockValue.setText(R.string.on);
            return;
         }

         ImageView var9 = var8.childLockIcon;
         if (var3) {
            var3 = R.drawable.ic_child_lock_off_disabled;
         } else {
            var3 = R.drawable.ic_child_lock_off;
         }

         var9.setImageResource(var3);
         var8.childLockValue.setText(R.string.off);
      }

   }

   public final void update(Device var1, boolean var2, List var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var3, "schedules");
      this.update(var1, var2);
      Iterable var6 = (Iterable)var3;
      int var5;
      if (var6 instanceof Collection && ((Collection)var6).isEmpty()) {
         var5 = 0;
      } else {
         Iterator var7 = var6.iterator();
         int var4 = 0;

         while(true) {
            var5 = var4;
            if (!var7.hasNext()) {
               break;
            }

            if (!((DeviceScheduleMerged)var7.next()).getPaused()) {
               var5 = var4 + 1;
               var4 = var5;
               if (var5 < 0) {
                  CollectionsKt.throwCountOverflow();
                  var4 = var5;
               }
            }
         }
      }

      TextView var10 = ((HolderDeviceSchedulesBinding)this.getBinding()).schedulesValue;
      String var8 = String.format(this.getString(R.string.schedule_active), Arrays.copyOf(new Object[]{var5}, 1));
      Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
      var10.setText((CharSequence)var8);
      ImageView var9 = ((HolderDeviceSchedulesBinding)this.getBinding()).schedulesIcon;
      int var11;
      if (var5 > 0) {
         var11 = R.drawable.ic_schedules_active;
      } else {
         var11 = R.drawable.ic_schedules_off;
      }

      var9.setImageResource(var11);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceSchedulesHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceSchedulesHolder;", "parentView", "Landroid/view/ViewGroup;", "onChildLockClickedListener", "Lkotlin/Function0;", "", "onOpenSchedulesListener", "devicedetails_otherRelease"},
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

      public final DeviceSchedulesHolder newInstance(ViewGroup var1, Function0 var2, Function0 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onChildLockClickedListener");
         Intrinsics.checkNotNullParameter(var3, "onOpenSchedulesListener");
         HolderDeviceSchedulesBinding var4 = HolderDeviceSchedulesBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceSchedulesHolder(var4, var2, var3);
      }
   }
}
