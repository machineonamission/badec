package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceFilterV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016BZ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "hasBuyLink", "", "onInfoClick", "Lkotlin/Function0;", "", "openPageAct", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlyBuy", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterV2Binding;Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceFilterType;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "update", "forceOffline", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFilterV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Device device;
   private final DeviceFilterType filterType;
   private final boolean hasBuyLink;
   private final Function0 onInfoClick;
   private final Function1 openPageAct;

   // $FF: synthetic method
   public static Unit $r8$lambda$i24618_5q4vPA8NOENf3s0r7JtI/* $FF was: $r8$lambda$i24618-5q4vPA8NOENf3s0r7JtI*/(DeviceFilterV2Holder var0) {
      return update$lambda$7(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xK5_Wmf49BK7ujAA_CTDR228jFc/* $FF was: $r8$lambda$xK5-Wmf49BK7ujAA-CTDR228jFc*/(DeviceFilterV2Holder var0, View var1) {
      update$lambda$5(var0, var1);
   }

   public DeviceFilterV2Holder(HolderDeviceFilterV2Binding var1, Device var2, DeviceFilterType var3, boolean var4, Function0 var5, Function1 var6) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "filterType");
      Intrinsics.checkNotNullParameter(var5, "onInfoClick");
      Intrinsics.checkNotNullParameter(var6, "openPageAct");
      super(var1);
      this.device = var2;
      this.filterType = var3;
      this.hasBuyLink = var4;
      this.onInfoClick = var5;
      this.openPageAct = var6;
      int var8 = DeviceFilterV2Holder.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()];
      byte var7 = 0;
      boolean var9 = true;
      if (var8 != 1) {
         if (var8 != 2) {
            if (var8 != 3) {
               throw new NoWhenBranchMatchedException();
            }

            var1.leadingIcon.setImageResource(R.drawable.ic_water_refresher);
            var1.title.setText(R.string.label_water_refresher);
            var1.btnBuy.setText(R.string.action_buy_refresher);
            var1.ivInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{this.getString(R.string.label_water_refresher)}));
            ImageView var12 = var1.ivInfo;
            Intrinsics.checkNotNullExpressionValue(var12, "ivInfo");
            ViewExtensionsKt.show$default((View)var12, false, 1, (Object)null);
         } else {
            var1.leadingIcon.setImageResource(R.drawable.ic_humidity_wick);
            var1.title.setText(R.string.label_wick_filter);
            var1.btnBuy.setText(R.string.action_buy_wick_filter);
            var1.ivInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{this.getString(R.string.label_wick_filter)}));
            ImageView var13 = var1.ivInfo;
            Intrinsics.checkNotNullExpressionValue(var13, "ivInfo");
            ViewExtensionsKt.hide((View)var13);
         }
      } else {
         var1.leadingIcon.setImageResource(R.drawable.ic_filter_status);
         var1.title.setText(R.string.label_air_filter);
         var1.btnBuy.setText(R.string.action_buy_filter);
         var1.ivInfo.setContentDescription((CharSequence)var1.getRoot().getContext().getString(R.string.more_info_about, new Object[]{this.getString(R.string.label_air_filter)}));
         ImageView var14 = var1.ivInfo;
         Intrinsics.checkNotNullExpressionValue(var14, "ivInfo");
         View var15 = (View)var14;
         if (var2 == null || !DeviceKt.supportRealTrack(var2)) {
            var9 = false;
         }

         ViewExtensionsKt.show(var15, var9);
      }

      var1.contentContainer.setTag(var3.name());
      if (var2 != null && DeviceKt.shouldMergeFilter(var2)) {
         var1.btnBuy.setText(R.string.btn_buy);
      }

      var1.btnBuy.setOnClickListener(new DeviceFilterV2Holder$$ExternalSyntheticLambda0(this));
      var1.btnReplace.setOnClickListener(new DeviceFilterV2Holder$$ExternalSyntheticLambda1(this));
      var1.ivInfo.setOnClickListener(new DeviceFilterV2Holder$$ExternalSyntheticLambda2(this));
      MaterialButton var10 = var1.btnBuy;
      Intrinsics.checkNotNullExpressionValue(var10, "btnBuy");
      View var11 = (View)var10;
      if (!var4) {
         var7 = 8;
      }

      var11.setVisibility(var7);
   }

   static final void lambda$4$lambda$1(DeviceFilterV2Holder var0, View var1) {
      var0.openPageAct.invoke(true);
   }

   static final void lambda$4$lambda$2(DeviceFilterV2Holder var0, View var1) {
      var0.openPageAct.invoke(false);
   }

   static final void lambda$4$lambda$3(DeviceFilterV2Holder var0, View var1) {
      var0.onInfoClick.invoke();
   }

   private static final void update$lambda$5(DeviceFilterV2Holder var0, View var1) {
      var0.openPageAct.invoke(false);
   }

   private static final Unit update$lambda$7(DeviceFilterV2Holder var0) {
      Group var1 = ((HolderDeviceFilterV2Binding)var0.getBinding()).groupProgress;
      Intrinsics.checkNotNullExpressionValue(var1, "groupProgress");
      ViewExtensionsKt.hide((View)var1);
      return Unit.INSTANCE;
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      DeviceFilterType var4 = this.filterType;
      int var3 = DeviceFilterV2Holder.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
      Integer var13;
      if (var3 != 1) {
         label61: {
            if (var3 != 2) {
               if (var3 != 3) {
                  throw new NoWhenBranchMatchedException();
               }

               HasRemoveYellowWater var14;
               if (var1 instanceof HasRemoveYellowWater) {
                  var14 = (HasRemoveYellowWater)var1;
               } else {
                  var14 = null;
               }

               if (var14 != null) {
                  var13 = var14.getRefresherLifeLeft();
                  break label61;
               }
            } else {
               HasWick var15;
               if (var1 instanceof HasWick) {
                  var15 = (HasWick)var1;
               } else {
                  var15 = null;
               }

               if (var15 != null) {
                  var13 = var15.getWickLifeLeft();
                  break label61;
               }
            }

            var13 = null;
         }
      } else {
         var13 = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(var1);
      }

      Context var5 = ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.getContext();
      if (var1 instanceof HasRemoveYellowWater && Intrinsics.areEqual(((HasRemoveYellowWater)var1).getYwrmEnabled(), false) && this.filterType == DeviceFilterType.REFRESHER) {
         ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
         ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.setText((CharSequence)this.getString(R.string.inactive));
         Group var9 = ((HolderDeviceFilterV2Binding)this.getBinding()).groupLife;
         Intrinsics.checkNotNullExpressionValue(var9, "groupLife");
         ViewExtensionsKt.hide((View)var9);
         MaterialButton var10 = ((HolderDeviceFilterV2Binding)this.getBinding()).btnBuy;
         Intrinsics.checkNotNullExpressionValue(var10, "btnBuy");
         ViewExtensionsKt.hide((View)var10);
         ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.setOnClickListener((View.OnClickListener)null);
      } else {
         ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.setOnClickListener(new DeviceFilterV2Holder$$ExternalSyntheticLambda3(this));
         ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_right_v2, 0);
         Group var6 = ((HolderDeviceFilterV2Binding)this.getBinding()).groupLife;
         Intrinsics.checkNotNullExpressionValue(var6, "groupLife");
         ViewExtensionsKt.show$default((View)var6, false, 1, (Object)null);
         MaterialButton var18 = ((HolderDeviceFilterV2Binding)this.getBinding()).btnBuy;
         Intrinsics.checkNotNullExpressionValue(var18, "btnBuy");
         View var19 = (View)var18;
         if (this.hasBuyLink) {
            var3 = 0;
         } else {
            var3 = 8;
         }

         var19.setVisibility(var3);
         if (!var2 && var1.isOnline()) {
            if (var13 != null) {
               var3 = ((Number)var13).intValue();
               AppCompatTextView var7 = ((HolderDeviceFilterV2Binding)this.getBinding()).progressText;
               StringCompanionObject var16 = StringCompanionObject.INSTANCE;
               String var17 = String.format(this.getString(R.string.percentage_left), Arrays.copyOf(new Object[]{var3}, 1));
               Intrinsics.checkNotNullExpressionValue(var17, "format(...)");
               var7.setText((CharSequence)var17);
               ((HolderDeviceFilterV2Binding)this.getBinding()).progressIndicator.setProgress(var3);
               if (var3 > 10) {
                  ((HolderDeviceFilterV2Binding)this.getBinding()).progressIndicator.setIndicatorColor(new int[]{ContextCompat.getColor(var5, R.color.colorPrimary)});
               } else {
                  ((HolderDeviceFilterV2Binding)this.getBinding()).progressIndicator.setIndicatorColor(new int[]{ContextCompat.getColor(var5, R.color.fill_warning)});
               }

               Group var8 = ((HolderDeviceFilterV2Binding)this.getBinding()).groupProgress;
               Intrinsics.checkNotNullExpressionValue(var8, "groupProgress");
               ViewExtensionsKt.show$default((View)var8, false, 1, (Object)null);
            } else {
               new DeviceFilterV2Holder$$ExternalSyntheticLambda4(this);
            }
         } else {
            ((HolderDeviceFilterV2Binding)this.getBinding()).progressText.setText((CharSequence)this.getString(R.string.offline_label));
            ((HolderDeviceFilterV2Binding)this.getBinding()).progressIndicator.setProgress(0);
         }
      }
   }

   @Metadata(
      d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012¨\u0006\u0016"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "hasBuyLink", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onOpenPageListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlyBuy", "devicedetails_otherRelease"},
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

      public final DeviceFilterV2Holder newInstance(ViewGroup var1, Device var2, DeviceFilterType var3, boolean var4, Function0 var5, Function1 var6) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "filterType");
         Intrinsics.checkNotNullParameter(var5, "onInfoClickListener");
         Intrinsics.checkNotNullParameter(var6, "onOpenPageListener");
         HolderDeviceFilterV2Binding var7 = HolderDeviceFilterV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var7, "inflate(...)");
         return new DeviceFilterV2Holder(var7, var2, var3, var4, var5, var6);
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
         int[] var0 = new int[DeviceFilterType.values().length];

         try {
            var0[DeviceFilterType.FILTER.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceFilterType.WICK.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceFilterType.REFRESHER.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
