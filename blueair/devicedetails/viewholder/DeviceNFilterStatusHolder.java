package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.HolderDeviceNFilterStatusBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFilterStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceNFilterStatusBinding;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceNFilterStatusBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceNFilterStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "setOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceNFilterStatusHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceNFilterStatusBinding binding;
   private final Function1 onOpenFilterPageListener;
   private final Function0 onOpenInfoListener;

   // $FF: synthetic method
   public static void $r8$lambda$35V4IVlLCe5vn47uwt5sdYXWjNo(DeviceNFilterStatusHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$4F2DJ1QT1m3CbhL_atZQfWF0vnY/* $FF was: $r8$lambda$4F2DJ1QT1m3CbhL-atZQfWF0vnY*/(DeviceNFilterStatusHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$DgnNqe_cDccMLyJi0teDecWka_Y/* $FF was: $r8$lambda$DgnNqe-cDccMLyJi0teDecWka-Y*/(DeviceNFilterStatusHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   public DeviceNFilterStatusHolder(HolderDeviceNFilterStatusBinding var1, Function0 var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var3, "onOpenFilterPageListener");
      View var4 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var4, "getRoot(...)");
      super(var4);
      this.binding = var1;
      this.onOpenInfoListener = var2;
      this.onOpenFilterPageListener = var3;
      var1.title.setOnClickListener(new DeviceNFilterStatusHolder$$ExternalSyntheticLambda0(this));
      var1.howToReplace.setOnClickListener(new DeviceNFilterStatusHolder$$ExternalSyntheticLambda1(this));
      var1.buyNew.setOnClickListener(new DeviceNFilterStatusHolder$$ExternalSyntheticLambda2(this));
   }

   private static final void _init_$lambda$0(DeviceNFilterStatusHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   private static final void _init_$lambda$1(DeviceNFilterStatusHolder var0, View var1) {
      var0.onOpenFilterPageListener.invoke(false);
   }

   private static final void _init_$lambda$2(DeviceNFilterStatusHolder var0, View var1) {
      var0.onOpenFilterPageListener.invoke(true);
   }

   private static final int update$getColor(DeviceNFilterStatusHolder var0, int var1) {
      return var0.itemView.getContext().getColor(var1);
   }

   public final HolderDeviceNFilterStatusBinding getBinding() {
      return this.binding;
   }

   public final void setOffline() {
      HolderDeviceNFilterStatusBinding var2 = this.binding;
      var2.progressText.setText((CharSequence)"");
      var2.progressBar.setProgress(0);
      TextView var1 = var2.hintText;
      Intrinsics.checkNotNullExpressionValue(var1, "hintText");
      ViewExtensionsKt.show$default((View)var1, false, 1, (Object)null);
      var2.hintText.setText(R.string.offline_label);
      var1 = var2.expiredText;
      Intrinsics.checkNotNullExpressionValue(var1, "expiredText");
      ViewExtensionsKt.hide((View)var1);
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasSKU && var1 instanceof HasFanSpeed) {
         FilterConfig var6 = DeviceConfigProvider.INSTANCE.getFilterConfig(var1, DeviceFilterType.FILTER);
         MaterialButton var5 = this.binding.howToReplace;
         Intrinsics.checkNotNullExpressionValue(var5, "howToReplace");
         View var7 = (View)var5;
         DeviceConfigProvider var8 = DeviceConfigProvider.INSTANCE;
         AwsLinkConfig var16;
         if (var6 != null) {
            var16 = var6.getVideo();
         } else {
            var16 = null;
         }

         CharSequence var17 = (CharSequence)var8.getAwsLinkValue(var16);
         boolean var4 = false;
         boolean var2;
         if (var17 != null && var17.length() != 0) {
            var2 = 0;
         } else {
            var2 = 1;
         }

         ViewExtensionsKt.show(var7, (boolean)(var2 ^ true));
         MaterialButton var18 = this.binding.buyNew;
         Intrinsics.checkNotNullExpressionValue(var18, "buyNew");
         ViewExtensionsKt.show((View)var18, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(var6));
         if (var1.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
            FilterLifeTime var9 = DeviceKt.getFilterLifeTime(var1);
            int var3 = var9.getFilterLife();
            HolderDeviceNFilterStatusBinding var19 = this.binding;
            var19.progressBar.setProgress(var3);
            if (var9.getFilterLife() <= 0) {
               var4 = true;
            }

            LinearProgressIndicator var10 = var19.progressBar;
            if (var3 > 10) {
               var2 = R.color.colorPrimary;
            } else {
               var2 = R.color.fill_warning;
            }

            var10.setIndicatorColor(new int[]{update$getColor(this, var2)});
            TextView var20 = var19.progressText;
            String var11;
            if (var4) {
               var11 = this.itemView.getContext().getString(R.string.filter_has_expired);
            } else {
               StringBuilder var12 = new StringBuilder();
               var12.append(var3);
               var12.append('%');
               var11 = var12.toString();
            }

            var20.setText((CharSequence)var11);
            TextView var13 = var19.expiredText;
            Intrinsics.checkNotNullExpressionValue(var13, "expiredText");
            ViewExtensionsKt.show((View)var13, var4);
            var13 = var19.hintText;
            Intrinsics.checkNotNullExpressionValue(var13, "hintText");
            ViewExtensionsKt.hide((View)var13);
            return;
         }

         this.setOffline();
      }

   }

   @Metadata(
      d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J?\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\f¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceNFilterStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceNFilterStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "devicedetails_otherRelease"},
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

      public final DeviceNFilterStatusHolder newInstance(ViewGroup var1, Function0 var2, Function1 var3) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var3, "onOpenFilterPageListener");
         HolderDeviceNFilterStatusBinding var4 = HolderDeviceNFilterStatusBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
         return new DeviceNFilterStatusHolder(var4, var2, var3);
      }
   }
}
