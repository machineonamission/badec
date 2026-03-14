package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceFilterOrWickStatusBinding;
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
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterOrWickStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterOrWickStatusBinding;", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterOrWickStatusBinding;Lcom/blueair/core/model/DeviceFilterType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterOrWickStatusBinding;", "getType", "()Lcom/blueair/core/model/DeviceFilterType;", "update", "device", "Lcom/blueair/core/model/Device;", "setOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterOrWickStatusHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceFilterOrWickStatusBinding binding;
   private final Function0 onOpenInfoListener;
   private final Function1 onOpenPageListener;
   private final DeviceFilterType type;

   // $FF: synthetic method
   public static void $r8$lambda$2bV8mu9T_KfTXQirouMZnLMK2X8/* $FF was: $r8$lambda$2bV8mu9T-KfTXQirouMZnLMK2X8*/(DeviceFilterOrWickStatusHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$5Mjw3Y3UkSgiujtGk786vnULR1w(DeviceFilterOrWickStatusHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$DT8QptDe4NyDZdmaHaC82zORGL4(DeviceFilterOrWickStatusHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   public DeviceFilterOrWickStatusHolder(HolderDeviceFilterOrWickStatusBinding var1, DeviceFilterType var2, Function0 var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "type");
      Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var4, "onOpenPageListener");
      FrameLayout var6 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      super((View)var6);
      this.binding = var1;
      this.type = var2;
      this.onOpenInfoListener = var3;
      this.onOpenPageListener = var4;
      FrameLayout var7 = var1.getRoot();
      int var5;
      if (DeviceFilterOrWickStatusHolder.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()] == 1) {
         var5 = R.id.holder_device_n_filter_status;
      } else {
         var5 = R.id.holder_device_h_wick_status;
      }

      var7.setId(var5);
      var1.getRoot().setTag(var2.name());
      var1.title.setOnClickListener(new DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda0(this));
      var1.howToReplace.setOnClickListener(new DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda1(this));
      var1.buyNew.setOnClickListener(new DeviceFilterOrWickStatusHolder$$ExternalSyntheticLambda2(this));
   }

   private static final void _init_$lambda$0(DeviceFilterOrWickStatusHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   private static final void _init_$lambda$1(DeviceFilterOrWickStatusHolder var0, View var1) {
      var0.onOpenPageListener.invoke(false);
   }

   private static final void _init_$lambda$2(DeviceFilterOrWickStatusHolder var0, View var1) {
      var0.onOpenPageListener.invoke(true);
   }

   private static final int update$getColor(DeviceFilterOrWickStatusHolder var0, int var1) {
      return var0.itemView.getContext().getColor(var1);
   }

   public final HolderDeviceFilterOrWickStatusBinding getBinding() {
      return this.binding;
   }

   public final DeviceFilterType getType() {
      return this.type;
   }

   public final void setOffline() {
      HolderDeviceFilterOrWickStatusBinding var1 = this.binding;
      var1.lifetime.setText(com.blueair.viewcore.R.string.offline_label);
      var1.lifetimeValue.setText((CharSequence)"");
      var1.progressBar.setProgress(0);
      TextView var2 = var1.expiredText;
      Intrinsics.checkNotNullExpressionValue(var2, "expiredText");
      ViewExtensionsKt.hide((View)var2);
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasSKU) {
         FilterConfig var7 = DeviceConfigProvider.INSTANCE.getFilterConfig(var1, this.type);
         if (var7 != null) {
            DeviceFilterType var8 = this.type;
            int var2 = DeviceFilterOrWickStatusHolder.WhenMappings.$EnumSwitchMapping$0[var8.ordinal()];
            boolean var6 = true;
            int var3;
            int var4;
            if (var2 == 1) {
               var2 = com.blueair.viewcore.R.string.filter_time_left;
               FilterLifeTime var16 = DeviceKt.getFilterLifeTime(var1);
               var4 = var16.getFilterLife();
               var3 = DeviceConfigProvider.INSTANCE.getFilterStatusColor(var16);
               this.binding.iconLeft.setImageResource(com.blueair.viewcore.R.drawable.ic_filter_status);
               this.binding.title.setText(com.blueair.viewcore.R.string.filter_status);
               this.binding.howToReplace.setText(com.blueair.viewcore.R.string.how_to_replace_filter);
               this.binding.buyNew.setText(com.blueair.viewcore.R.string.buy_new_filter);
            } else {
               if (!(var1 instanceof HasWick)) {
                  return;
               }

               var2 = com.blueair.viewcore.R.string.wick_lifetime_left_is;
               var4 = ((HasWick)var1).getWickLifeLeft();
               var3 = DeviceConfigProvider.INSTANCE.getWickStatusColor(var4);
               this.binding.iconLeft.setImageResource(com.blueair.viewcore.R.drawable.ic_humidity_wick);
               this.binding.title.setText(com.blueair.viewcore.R.string.wick_status);
               this.binding.howToReplace.setText(com.blueair.viewcore.R.string.how_to_replace_wick);
               this.binding.buyNew.setText(com.blueair.viewcore.R.string.buy_new_wick);
            }

            MaterialButton var17 = this.binding.howToReplace;
            Intrinsics.checkNotNullExpressionValue(var17, "howToReplace");
            View var18 = (View)var17;
            CharSequence var9 = (CharSequence)DeviceConfigProvider.INSTANCE.getAwsLinkValue(var7.getVideo());
            boolean var5;
            if (var9 != null && var9.length() != 0) {
               var5 = false;
            } else {
               var5 = true;
            }

            ViewExtensionsKt.show(var18, var5 ^ true);
            MaterialButton var19 = this.binding.buyNew;
            Intrinsics.checkNotNullExpressionValue(var19, "buyNew");
            ViewExtensionsKt.show((View)var19, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(var7));
            if (var1.getConnectivityStatus() == ConnectivityStatus.ONLINE) {
               if (var4 > 0) {
                  var6 = false;
               }

               HolderDeviceFilterOrWickStatusBinding var10 = this.binding;
               var10.lifetime.setText(var2);
               TextView var14 = var10.lifetimeValue;
               StringBuilder var20 = new StringBuilder();
               var20.append(var4);
               var20.append('%');
               var14.setText((CharSequence)var20.toString());
               var10.lifetimeValue.setTextColor(var3);
               var10.progressBar.setProgress(var4);
               LinearProgressIndicator var15 = var10.progressBar;
               if (var4 > 10) {
                  var2 = com.blueair.viewcore.R.color.colorPrimary;
               } else {
                  var2 = com.blueair.viewcore.R.color.fill_warning;
               }

               var15.setIndicatorColor(new int[]{update$getColor(this, var2)});
               TextView var11 = var10.expiredText;
               Intrinsics.checkNotNullExpressionValue(var11, "expiredText");
               ViewExtensionsKt.show((View)var11, var6);
               return;
            }

            this.setOffline();
            return;
         }
      }

   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JG\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterOrWickStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterOrWickStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "type", "Lcom/blueair/core/model/DeviceFilterType;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onOpenPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "devicedetails_otherRelease"},
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

      public final DeviceFilterOrWickStatusHolder newInstance(ViewGroup var1, DeviceFilterType var2, Function0 var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "type");
         Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var4, "onOpenPageListener");
         HolderDeviceFilterOrWickStatusBinding var5 = HolderDeviceFilterOrWickStatusBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceFilterOrWickStatusHolder(var5, var2, var3, var4);
      }
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
         int[] var1 = new int[DeviceFilterType.values().length];

         try {
            var1[DeviceFilterType.FILTER.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var1;
      }
   }
}
