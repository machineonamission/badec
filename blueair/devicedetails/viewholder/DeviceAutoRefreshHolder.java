package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.AirRefreshState;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasAirRefresh$_CC;
import com.blueair.core.model.HasMainMode;
import com.blueair.devicedetails.databinding.HolderDeviceAutoRefreshBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0012B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoRefreshHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceAutoRefreshBinding;", "binding", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "onCloseHintListener", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceAutoRefreshBinding;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "autoRefreshHintClosedBefore", "", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "closedBefore", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceAutoRefreshHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private boolean autoRefreshHintClosedBefore;
   private final Function0 onCancelListener;
   private final Function0 onCloseHintListener;
   private final Function0 onOpenInfoListener;

   public DeviceAutoRefreshHolder(HolderDeviceAutoRefreshBinding var1, Function0 var2, Function0 var3, Function0 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var3, "onCancelListener");
      Intrinsics.checkNotNullParameter(var4, "onCloseHintListener");
      super(var1);
      this.onOpenInfoListener = var2;
      this.onCancelListener = var3;
      this.onCloseHintListener = var4;
      var1.infoIcon.setOnClickListener(new DeviceAutoRefreshHolder$$ExternalSyntheticLambda0(this));
      var1.btnCancel.setOnClickListener(new DeviceAutoRefreshHolder$$ExternalSyntheticLambda1(this));
      var1.btnCloseHint.setOnClickListener(new DeviceAutoRefreshHolder$$ExternalSyntheticLambda2(this));
   }

   static final void lambda$3$lambda$0(DeviceAutoRefreshHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   static final void lambda$3$lambda$1(DeviceAutoRefreshHolder var0, View var1) {
      var0.onCancelListener.invoke();
   }

   static final void lambda$3$lambda$2(DeviceAutoRefreshHolder var0, View var1) {
      var0.onCloseHintListener.invoke();
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      boolean var3;
      if (!var2 && var1.isOnline() && !DeviceKt.isStandByOn(var1)) {
         var3 = 0;
      } else {
         var3 = 1;
      }

      HolderDeviceAutoRefreshBinding var6 = (HolderDeviceAutoRefreshBinding)this.getBinding();
      if (var1 instanceof HasMainMode && var1 instanceof HasAirRefresh) {
         if (var3) {
            var6.leadingIcon.setImageResource(R.drawable.ic_auto_refresh_leading_disabled);
            var6.title.setText((CharSequence)this.getString(R.string.auto_refresh));
            var6.title.setTextColor(this.getColor(R.color.surface_dark_55));
            Group var9 = var6.expendedContent;
            Intrinsics.checkNotNullExpressionValue(var9, "expendedContent");
            ViewExtensionsKt.show((View)var9, false);
            ConstraintLayout var10 = var6.hintContainer;
            Intrinsics.checkNotNullExpressionValue(var10, "hintContainer");
            ViewExtensionsKt.show((View)var10, false);
            var6.autoRefreshContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1_disabled_white_bg);
         } else {
            var6.leadingIcon.setImageResource(R.drawable.ic_auto_refresh_leading);
            var6.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            var6.autoRefreshContainer.setBackgroundResource(R.drawable.rounded_rectangle_white_r16_black5_stroke1);
            HasAirRefresh var7 = (HasAirRefresh)var1;
            if (var7.getAirRefreshEnabled()) {
               ApSubMode var11 = ((HasMainMode)var1).apSubMode();
               var3 = DeviceAutoRefreshHolder.WhenMappings.$EnumSwitchMapping$1[var11.ordinal()];
               if (var3 != 1 && var3 != 2) {
                  if (var3 != 3 && var3 != 4) {
                     throw new NoWhenBranchMatchedException();
                  }

                  TextView var20 = var6.title;
                  StringBuilder var31 = new StringBuilder();
                  var31.append(this.getString(R.string.auto_refresh));
                  var31.append(" - ");
                  var31.append(this.getString(R.string.inactive));
                  var20.setText((CharSequence)var31.toString());
                  Group var21 = var6.expendedContent;
                  Intrinsics.checkNotNullExpressionValue(var21, "expendedContent");
                  ViewExtensionsKt.show((View)var21, false);
               } else {
                  AirRefreshState var12 = var7.airRefreshStatus();
                  var3 = DeviceAutoRefreshHolder.WhenMappings.$EnumSwitchMapping$0[var12.ordinal()];
                  if (var3 != 1) {
                     if (var3 != 2 && var3 != 3) {
                        throw new NoWhenBranchMatchedException();
                     }

                     TextView var13 = var6.title;
                     StringBuilder var28 = new StringBuilder();
                     var28.append(this.getString(R.string.auto_refresh));
                     var28.append(" - ");
                     var28.append(this.getString(R.string.active));
                     var13.setText((CharSequence)var28.toString());
                     Group var14 = var6.expendedContent;
                     Intrinsics.checkNotNullExpressionValue(var14, "expendedContent");
                     ViewExtensionsKt.show((View)var14, false);
                  } else {
                     TextView var8 = var6.title;
                     StringBuilder var15 = new StringBuilder();
                     var15.append(this.getString(R.string.auto_refresh));
                     var15.append(" - ");
                     var15.append(this.getString(R.string.air_refreshing));
                     var8.setText((CharSequence)var15.toString());
                     Group var16 = var6.expendedContent;
                     Intrinsics.checkNotNullExpressionValue(var16, "expendedContent");
                     ViewExtensionsKt.show((View)var16, true);
                     var3 = HasAirRefresh$_CC.getAirRefreshLeftSeconds$default(var7, 0L, 1, (Object)null);
                     int var5 = (int)Math.ceil((double)var3 / (double)60.0F);
                     int var4 = (int)Math.ceil((double)var7.getAirRefreshDuration() / (double)60.0F);
                     var6.progressIndicator.setProgress(RangesKt.coerceIn(var3 * 100 / RangesKt.coerceAtLeast(var7.getAirRefreshDuration(), 1), (ClosedRange)(new IntRange(0, 100))));
                     TextView var17 = var6.leftTimeText;
                     if (var5 == 1) {
                        var3 = R.string.disinfection_left_time_1min;
                     } else {
                        var3 = R.string.disinfection_left_time;
                     }

                     String var29 = String.format(this.getString(var3), Arrays.copyOf(new Object[]{var5}, 1));
                     Intrinsics.checkNotNullExpressionValue(var29, "format(...)");
                     var17.setText((CharSequence)var29);
                     TextView var30 = var6.durationText;
                     String var18 = String.format(this.getString(R.string.auto_refresh_duration), Arrays.copyOf(new Object[]{var4}, 1));
                     Intrinsics.checkNotNullExpressionValue(var18, "format(...)");
                     var30.setText((CharSequence)var18);
                  }

                  ConstraintLayout var19 = var6.hintContainer;
                  Intrinsics.checkNotNullExpressionValue(var19, "hintContainer");
                  ViewExtensionsKt.show((View)var19, false);
               }

               ConstraintLayout var22 = var6.hintContainer;
               Intrinsics.checkNotNullExpressionValue(var22, "hintContainer");
               ViewExtensionsKt.show((View)var22, this.autoRefreshHintClosedBefore ^ true);
            } else {
               var6.title.setText(R.string.auto_refresh);
               ConstraintLayout var23 = var6.hintContainer;
               Intrinsics.checkNotNullExpressionValue(var23, "hintContainer");
               ViewExtensionsKt.show((View)var23, false);
            }
         }
      }

      var6.infoIcon.setContentDescription((CharSequence)var6.infoIcon.getContext().getString(R.string.more_info_about, new Object[]{this.getString(R.string.auto_refresh)}));
   }

   public final void update(Device var1, boolean var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.autoRefreshHintClosedBefore = var3;
      this.update(var1, var2);
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J8\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\r"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAutoRefreshHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceAutoRefreshHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onCancelListener", "onClosePromptListener", "devicedetails_otherRelease"},
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

      public final DeviceAutoRefreshHolder newInstance(ViewGroup var1, Function0 var2, Function0 var3, Function0 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var3, "onCancelListener");
         Intrinsics.checkNotNullParameter(var4, "onClosePromptListener");
         HolderDeviceAutoRefreshBinding var5 = HolderDeviceAutoRefreshBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceAutoRefreshHolder(var5, var2, var3, var4);
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
      public static final int[] $EnumSwitchMapping$1;

      static {
         int[] var0 = new int[AirRefreshState.values().length];

         try {
            var0[AirRefreshState.START.ordinal()] = 1;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[AirRefreshState.COMPLETED.ordinal()] = 2;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[AirRefreshState.CANCEL.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.AUTO.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ApSubMode.ECO.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ApSubMode.FAN.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ApSubMode.NIGHT.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$1 = var0;
      }
   }
}
