package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceHintBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHintHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceHintBinding;", "binding", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHintBinding;)V", "update", "", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHintHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public DeviceHintHolder(HolderDeviceHintBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   @Metadata(
      d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\u0010\u000f¨\u0006\u0010"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHintHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHintHolder;", "parentView", "Landroid/view/ViewGroup;", "msgRes", "", "expectMarginTopInDp", "", "onClosedListener", "Lkotlin/Function0;", "", "(Landroid/view/ViewGroup;ILjava/lang/Float;Lkotlin/jvm/functions/Function0;)Lcom/blueair/devicedetails/viewholder/DeviceHintHolder;", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      // $FF: synthetic method
      public static void $r8$lambda$MM2kOi1uwIMnboSgnZfnwrrpI_k/* $FF was: $r8$lambda$MM2kOi1uwIMnboSgnZfnwrrpI-k*/(Function0 var0, View var1) {
         newInstance$lambda$1$lambda$0(var0, var1);
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      public static DeviceHintHolder newInstance$default(Companion var0, ViewGroup var1, int var2, Float var3, Function0 var4, int var5, Object var6) {
         if ((var5 & 4) != 0) {
            var3 = null;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      private static final void newInstance$lambda$1$lambda$0(Function0 var0, View var1) {
         var0.invoke();
      }

      public final DeviceHintHolder newInstance(ViewGroup var1, int var2, Float var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onClosedListener");
         HolderDeviceHintBinding var6 = HolderDeviceHintBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         var6.hintText.setText(var2);
         var6.btnCloseHint.setOnClickListener(new DeviceHintHolder$Companion$$ExternalSyntheticLambda0(var4));
         Intrinsics.checkNotNullExpressionValue(var6, "apply(...)");
         if (var3 != null) {
            float var5 = ((Number)var3).floatValue();
            ViewGroup.LayoutParams var7 = var6.getRoot().getLayoutParams();
            ViewGroup.MarginLayoutParams var8;
            if (var7 instanceof ViewGroup.MarginLayoutParams) {
               var8 = (ViewGroup.MarginLayoutParams)var7;
            } else {
               var8 = null;
            }

            if (var8 != null) {
               var8.topMargin = (int)TypedValueCompat.dpToPx(var5, var1.getResources().getDisplayMetrics());
               var6.getRoot().setLayoutParams((ViewGroup.LayoutParams)var8);
            }
         }

         return new DeviceHintHolder(var6);
      }
   }
}
