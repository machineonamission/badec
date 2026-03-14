package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.HolderDeviceFilterStatusBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterStatusBinding;", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterStatusBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "fromFilterPage", "setOnlineView", "Lcom/blueair/core/model/HasFanSpeed;", "setOfflineView", "updateFilterTimeView", "filterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "updateProgressBar", "", "updateFilterStatusView", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterStatusHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceFilterStatusBinding binding;
   private final Function1 onOpenFilterPageListener;

   // $FF: synthetic method
   public static void $r8$lambda$E3Ki4YjKSIa6oNW0NEiwhCoyIdc(DeviceFilterStatusHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$Tv5LoVL_zyYCEQtoq8ER_PEOd30/* $FF was: $r8$lambda$Tv5LoVL_zyYCEQtoq8ER-PEOd30*/(DeviceFilterStatusHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UVNFfe6EnQXZDcuCCTHjwIN3SW4(DeviceFilterStatusHolder var0, View var1) {
      _init_$lambda$1(var0, var1);
   }

   public DeviceFilterStatusHolder(HolderDeviceFilterStatusBinding var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onOpenFilterPageListener");
      ConstraintLayout var3 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var3, "getRoot(...)");
      super((View)var3);
      this.binding = var1;
      this.onOpenFilterPageListener = var2;
      var1.getRoot().setTag("FILTER");
      var1.howToReplace.setOnClickListener(new DeviceFilterStatusHolder$$ExternalSyntheticLambda0(this));
      var1.buyNew.setOnClickListener(new DeviceFilterStatusHolder$$ExternalSyntheticLambda1(this));
      var1.filterReplacement.setOnClickListener(new DeviceFilterStatusHolder$$ExternalSyntheticLambda2(this));
   }

   private static final void _init_$lambda$0(DeviceFilterStatusHolder var0, View var1) {
      var0.onOpenFilterPageListener.invoke(false);
   }

   private static final void _init_$lambda$1(DeviceFilterStatusHolder var0, View var1) {
      var0.onOpenFilterPageListener.invoke(true);
   }

   private static final void _init_$lambda$2(DeviceFilterStatusHolder var0, View var1) {
      var0.onOpenFilterPageListener.invoke(false);
   }

   private final void setOfflineView() {
      this.binding.filterTimeLeftView.setText(this.itemView.getContext().getText(R.string.offline_label));
      TextView var1 = this.binding.filterTimePercentView;
      Intrinsics.checkNotNullExpressionValue(var1, "filterTimePercentView");
      ViewExtensionsKt.show((View)var1, false);
   }

   private final void setOnlineView(HasFanSpeed var1) {
      FilterLifeTime var2 = DeviceKt.getFilterLifeTime(var1);
      this.updateFilterTimeView(var2);
      this.updateFilterStatusView(var2);
   }

   private final void updateFilterStatusView(FilterLifeTime var1) {
      boolean var2;
      if (var1.getFilterLife() <= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2) {
         this.binding.filterTimeLeftView.setText(this.itemView.getContext().getText(R.string.filter_has_expired));
      }

      TextView var3 = this.binding.filterTimePercentView;
      Intrinsics.checkNotNullExpressionValue(var3, "filterTimePercentView");
      ViewExtensionsKt.show((View)var3, var2 ^ true);
      var3 = this.binding.filterChangeView;
      Intrinsics.checkNotNullExpressionValue(var3, "filterChangeView");
      ViewExtensionsKt.show((View)var3, var2);
      this.binding.filterTimePercentView.setTextColor(DeviceConfigProvider.INSTANCE.getFilterStatusColor(var1));
   }

   private final void updateFilterTimeView(FilterLifeTime var1) {
      if (var1 instanceof FilterLifeTime.FilterDaysLeft) {
         TextView var3 = this.binding.filterTimeLeftView;
         StringCompanionObject var4 = StringCompanionObject.INSTANCE;
         String var11 = this.itemView.getContext().getString(R.string.filter_usage);
         Intrinsics.checkNotNullExpressionValue(var11, "getString(...)");
         var1 = var1;
         var11 = String.format(var11, Arrays.copyOf(new Object[]{var1.getFilterLife()}, 1));
         Intrinsics.checkNotNullExpressionValue(var11, "format(...)");
         var3.setText((CharSequence)var11);
         var3 = this.binding.filterTimePercentView;
         Intrinsics.checkNotNullExpressionValue(var3, "filterTimePercentView");
         ViewExtensionsKt.show((View)var3, false);
         Integer var6 = var1.getFilterLifePercentage();
         if (var6 != null) {
            int var2 = ((Number)var6).intValue();
            this.binding.progress.setProgress(var2);
            this.updateProgressBar(var2);
            return;
         }
      } else {
         if (var1 instanceof FilterLifeTime.FilterPercentageLeft) {
            this.binding.filterTimeLeftView.setText((CharSequence)this.itemView.getContext().getString(R.string.filter_time_left));
            TextView var9 = this.binding.filterTimePercentView;
            Intrinsics.checkNotNullExpressionValue(var9, "filterTimePercentView");
            ViewExtensionsKt.show((View)var9, true);
            var9 = this.binding.filterTimePercentView;
            StringCompanionObject var13 = StringCompanionObject.INSTANCE;
            FilterLifeTime.FilterPercentageLeft var14 = (FilterLifeTime.FilterPercentageLeft)var1;
            String var7 = String.format("%d%s", Arrays.copyOf(new Object[]{var14.getFilterLife(), "%"}, 2));
            Intrinsics.checkNotNullExpressionValue(var7, "format(...)");
            var9.setText((CharSequence)var7);
            this.binding.progress.setProgress(var14.getFilterLife());
            this.updateProgressBar(var14.getFilterLife());
            return;
         }

         if (!(var1 instanceof FilterLifeTime.NoFilterInfo)) {
            throw new NoWhenBranchMatchedException();
         }
      }

   }

   private final void updateProgressBar(int var1) {
      if (var1 > 10) {
         this.binding.progress.setIndicatorColor(new int[]{ContextCompat.getColor(this.binding.progress.getContext(), R.color.colorPrimary)});
      } else {
         this.binding.progress.setIndicatorColor(new int[]{ContextCompat.getColor(this.binding.progress.getContext(), R.color.fill_warning)});
      }
   }

   public final HolderDeviceFilterStatusBinding getBinding() {
      return this.binding;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var3 = var1 instanceof HasFanSpeed;
      Object var5 = null;
      HasFanSpeed var4;
      if (var3) {
         var4 = (HasFanSpeed)var1;
      } else {
         var4 = null;
      }

      if (var4 != null) {
         Timber.Forest var7 = Timber.Forest;
         StringBuilder var8 = new StringBuilder("device:  filter life =  ");
         HasFanSpeed var6 = (HasFanSpeed)var1;
         var8.append(var6.getFilterLife());
         var8.append(", filter lifetime =  ");
         var8.append(DeviceKt.getFilterLifeTime(var1));
         var8.append("  & filter trigger = ");
         var8.append(var6.getFilterTrigger());
         String var18 = var8.toString();
         boolean var2 = false;
         var7.d(var18, new Object[0]);
         ConnectivityStatus var9 = var1.getConnectivityStatus();
         if (DeviceFilterStatusHolder.WhenMappings.$EnumSwitchMapping$0[var9.ordinal()] == 1) {
            this.setOnlineView(var6);
         } else {
            this.setOfflineView();
         }

         if (StringsKt.contains$default((CharSequence)var4.getModelName(), (CharSequence)"511i", false, 2, (Object)null) && var4 instanceof HasSKU) {
            MaterialButton var10 = this.binding.filterReplacement;
            Intrinsics.checkNotNullExpressionValue(var10, "filterReplacement");
            ViewExtensionsKt.hide((View)var10);
            FilterConfig var15 = DeviceConfigProvider.getFilterConfig$default(DeviceConfigProvider.INSTANCE, (Device)(var4), (DeviceFilterType)null, 2, (Object)null);
            var10 = this.binding.howToReplace;
            Intrinsics.checkNotNullExpressionValue(var10, "howToReplace");
            View var16 = (View)var10;
            DeviceConfigProvider var17 = DeviceConfigProvider.INSTANCE;
            AwsLinkConfig var12 = (AwsLinkConfig)var5;
            if (var15 != null) {
               var12 = var15.getVideo();
            }

            CharSequence var13 = (CharSequence)var17.getAwsLinkValue(var12);
            if (var13 == null || var13.length() == 0) {
               var2 = true;
            }

            ViewExtensionsKt.show(var16, var2 ^ true);
            MaterialButton var14 = this.binding.buyNew;
            Intrinsics.checkNotNullExpressionValue(var14, "buyNew");
            ViewExtensionsKt.show((View)var14, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(var15));
         }
      }

   }

   public final void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.update(var1);
      MaterialButton var3 = this.binding.filterReplacement;
      Intrinsics.checkNotNullExpressionValue(var3, "filterReplacement");
      ViewExtensionsKt.show((View)var3, var2 ^ true);
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "", "devicedetails_otherRelease"},
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

      public final DeviceFilterStatusHolder newInstance(ViewGroup var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onOpenFilterPageListener");
         HolderDeviceFilterStatusBinding var3 = HolderDeviceFilterStatusBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceFilterStatusHolder(var3, var2);
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
         int[] var0 = new int[ConnectivityStatus.values().length];

         try {
            var0[ConnectivityStatus.ONLINE.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
