package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.TypedValueCompat;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.databinding.HolderDeviceMsgBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\r"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceMsgBinding;", "binding", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMsgBinding;)V", "update", "", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceMsgHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   public DeviceMsgHolder(HolderDeviceMsgBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1);
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
   }

   @Metadata(
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011¨\u0006\u0012"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder;", "parentView", "Landroid/view/ViewGroup;", "titleRes", "", "msgRes", "expectMarginTopInDp", "", "expectIconRes", "onClosedListener", "Lkotlin/Function0;", "", "(Landroid/view/ViewGroup;IILjava/lang/Float;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Lcom/blueair/devicedetails/viewholder/DeviceMsgHolder;", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      // $FF: synthetic method
      public static void $r8$lambda$nRGCzVCqJ5xtzmdOhdC8vsASrxI(Function0 var0, View var1) {
         newInstance$lambda$1$lambda$0(var0, var1);
      }

      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      public static DeviceMsgHolder newInstance$default(Companion var0, ViewGroup var1, int var2, int var3, Float var4, Integer var5, Function0 var6, int var7, Object var8) {
         if ((var7 & 8) != 0) {
            var4 = null;
         }

         if ((var7 & 16) != 0) {
            var5 = null;
         }

         return var0.newInstance(var1, var2, var3, var4, var5, var6);
      }

      private static final void newInstance$lambda$1$lambda$0(Function0 var0, View var1) {
         var0.invoke();
      }

      public final DeviceMsgHolder newInstance(ViewGroup var1, int var2, int var3, Float var4, Integer var5, Function0 var6) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var6, "onClosedListener");
         HolderDeviceMsgBinding var8 = HolderDeviceMsgBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         var8.title.setText(var2);
         var8.message.setText(var3);
         var8.closeBtn.setOnClickListener(new DeviceMsgHolder$Companion$$ExternalSyntheticLambda0(var6));
         Intrinsics.checkNotNullExpressionValue(var8, "apply(...)");
         if (var4 != null) {
            float var7 = ((Number)var4).floatValue();
            ViewGroup.LayoutParams var10 = var8.getRoot().getLayoutParams();
            ViewGroup.MarginLayoutParams var11;
            if (var10 instanceof ViewGroup.MarginLayoutParams) {
               var11 = (ViewGroup.MarginLayoutParams)var10;
            } else {
               var11 = null;
            }

            if (var11 != null) {
               var11.topMargin = (int)TypedValueCompat.dpToPx(var7, var1.getResources().getDisplayMetrics());
               var8.getRoot().setLayoutParams((ViewGroup.LayoutParams)var11);
            }
         }

         if (var5 != null) {
            var2 = ((Number)var5).intValue();
            var8.leadingIcon.setImageResource(var2);
         }

         return new DeviceMsgHolder(var8);
      }
   }
}
