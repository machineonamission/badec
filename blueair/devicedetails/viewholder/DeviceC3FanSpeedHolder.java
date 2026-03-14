package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceC3FanSpeedBinding;
import com.blueair.devicedetails.util.EtaUtils;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*BD\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001f\u001a\u00020\u000eH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0007H\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nJ\b\u0010)\u001a\u00020\u000eH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceC3FanSpeedHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceC3FanSpeedBinding;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "fanSpeedEnum", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceC3FanSpeedBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceC3FanSpeedBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "()Z", "tvs", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "seekBarEnabledMarginTop", "", "Ljava/lang/Integer;", "seekBarEnabledPadding", "Landroid/graphics/Rect;", "postFanSpeed", "setSeekbarEnabled", "enabled", "updateProgressLabels", "context", "Landroid/content/Context;", "progress", "update", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "updateUpDownButtonState", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceC3FanSpeedHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceC3FanSpeedBinding binding;
   private final Device device;
   private final boolean isInSchedule;
   private final Function1 onFanSpeedSetListener;
   private Integer seekBarEnabledMarginTop;
   private Rect seekBarEnabledPadding;
   private ArrayList tvs;

   // $FF: synthetic method
   public static void $r8$lambda$1LEPmWj6Pw2uFfxrlWyEkl5txTw(DeviceC3FanSpeedHolder var0, View var1) {
      _init_$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$zSeCyh9GFwHej0hC1dvzS2CkzKs(DeviceC3FanSpeedHolder var0, View var1) {
      _init_$lambda$2(var0, var1);
   }

   public DeviceC3FanSpeedHolder(HolderDeviceC3FanSpeedBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onFanSpeedSetListener");
      FrameLayout var6 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      super((View)var6);
      this.binding = var1;
      this.device = var2;
      this.isInSchedule = var3;
      this.onFanSpeedSetListener = var4;
      TextView var8 = var1.fanSpeedLevel0;
      Intrinsics.checkNotNullExpressionValue(var8, "fanSpeedLevel0");
      TextView var7 = var1.fanSpeedLevel1;
      Intrinsics.checkNotNullExpressionValue(var7, "fanSpeedLevel1");
      TextView var12 = var1.fanSpeedLevel2;
      Intrinsics.checkNotNullExpressionValue(var12, "fanSpeedLevel2");
      TextView var13 = var1.fanSpeedLevel3;
      Intrinsics.checkNotNullExpressionValue(var13, "fanSpeedLevel3");
      TextView var10 = var1.fanSpeedLevel4;
      Intrinsics.checkNotNullExpressionValue(var10, "fanSpeedLevel4");
      this.tvs = CollectionsKt.arrayListOf(new TextView[]{var8, var7, var12, var13, var10});
      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceC3FanSpeedHolder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            DeviceC3FanSpeedHolder var4 = this.this$0;
            Context var5 = var1.getContext();
            Intrinsics.checkNotNullExpressionValue(var5, "getContext(...)");
            var4.updateProgressLabels(var5, var2);
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.postFanSpeed();
         }
      });
      var1.upIcon.setOnClickListener(new DeviceC3FanSpeedHolder$$ExternalSyntheticLambda0(this));
      var1.downIcon.setOnClickListener(new DeviceC3FanSpeedHolder$$ExternalSyntheticLambda1(this));
      if (var3) {
         var1.contentContainer.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
         int var5 = this.itemView.getContext().getResources().getDimensionPixelSize(R.dimen.device_details_humidifier_margin_horizontal);
         ConstraintLayout var11 = var1.contentContainer;
         Intrinsics.checkNotNullExpressionValue(var11, "contentContainer");
         ((View)var11).setPadding(var5, var5, var5, var5);
         TextView var9 = var1.cleanAirEta;
         Intrinsics.checkNotNullExpressionValue(var9, "cleanAirEta");
         ViewExtensionsKt.hide((View)var9);
      }

   }

   private static final void _init_$lambda$2(DeviceC3FanSpeedHolder var0, View var1) {
      AccessibleSeekBar var5 = var0.binding.seekbar;
      int var3 = var5.getProgress();
      Iterator var4 = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().iterator();
      int var2 = 0;

      while(true) {
         if (!var4.hasNext()) {
            var2 = -1;
            break;
         }

         if (((Number)var4.next()).intValue() > var3) {
            break;
         }

         ++var2;
      }

      if (var2 >= 0) {
         var5.setProgress(((Number)FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(var2)).intValue());
      }

      var0.postFanSpeed();
   }

   private static final void _init_$lambda$5(DeviceC3FanSpeedHolder var0, View var1) {
      AccessibleSeekBar var4 = var0.binding.seekbar;
      int var2 = var4.getProgress();
      List var3 = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP();
      ListIterator var6 = var3.listIterator(var3.size());

      while(true) {
         if (var6.hasPrevious()) {
            if (((Number)var6.previous()).intValue() >= var2) {
               continue;
            }

            var2 = var6.nextIndex();
            break;
         }

         var2 = -1;
         break;
      }

      if (var2 >= 0) {
         var4.setProgress(((Number)FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(var2)).intValue());
      }

      var0.postFanSpeed();
   }

   private final void postFanSpeed() {
      this.updateUpDownButtonState();
      FanSpeedEnum var1 = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(this.binding.seekbar.getProgress()));
      this.update(var1);
      this.onFanSpeedSetListener.invoke(var1);
   }

   private final void setSeekbarEnabled(boolean var1) {
      AppCompatImageView var3 = this.binding.downIcon;
      Intrinsics.checkNotNullExpressionValue(var3, "downIcon");
      ViewExtensionsKt.show((View)var3, var1);
      var3 = this.binding.upIcon;
      Intrinsics.checkNotNullExpressionValue(var3, "upIcon");
      ViewExtensionsKt.show((View)var3, var1);
      AccessibleSeekBar var4 = this.binding.seekbar;
      var4.setEnabled(var1);
      Drawable var8;
      if (var1) {
         var8 = AppCompatResources.getDrawable(var4.getContext(), R.drawable.thumb_shadowed);
      } else {
         var8 = null;
      }

      var4.setThumb(var8);
      Context var9 = var4.getContext();
      int var2;
      if (var1) {
         var2 = R.drawable.progressbar_slim;
      } else {
         var2 = R.drawable.progressbar_slim_gray;
      }

      var4.setProgressDrawable(AppCompatResources.getDrawable(var9, var2));
      ViewGroup.LayoutParams var10 = var4.getLayoutParams();
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
      ConstraintLayout.LayoutParams var11 = (ConstraintLayout.LayoutParams)var10;
      if (this.seekBarEnabledMarginTop == null) {
         this.seekBarEnabledMarginTop = var11.topMargin;
         this.seekBarEnabledPadding = new Rect(var4.getPaddingLeft(), var4.getPaddingTop(), var4.getPaddingRight(), var4.getPaddingBottom());
      }

      if (var1) {
         Integer var5 = this.seekBarEnabledMarginTop;
         if (var5 != null) {
            var2 = var5;
         } else {
            var2 = -15;
         }
      } else {
         var2 = 30;
      }

      var11.topMargin = var2;
      if (var1) {
         Rect var12 = this.seekBarEnabledPadding;
         if (var12 != null) {
            var4.setPadding(var12.left, var12.top, var12.right, var12.bottom);
         }

      } else {
         Intrinsics.checkNotNull(var4);
         ((View)var4).setPadding(0, 0, 0, 0);
      }
   }

   private final void updateProgressLabels(Context var1, int var2) {
      int var3;
      label56: {
         var3 = 0;
         if (var2 < 0 || var2 >= 25) {
            if (25 <= var2 && var2 < 50) {
               var2 = 1;
               break label56;
            }

            if (50 <= var2 && var2 < 75) {
               var2 = 2;
               break label56;
            }

            if (75 <= var2 && var2 < 100) {
               var2 = 3;
               break label56;
            }

            if (var2 == 100) {
               var2 = 4;
               break label56;
            }
         }

         var2 = 0;
      }

      for(Object var6 : (Iterable)this.tvs) {
         if (var3 < 0) {
            CollectionsKt.throwIndexOverflow();
         }

         TextView var8 = (TextView)var6;
         int var4;
         if (var3 <= var2) {
            var4 = R.color.colorPrimaryText;
         } else {
            var4 = R.color.light_gray;
         }

         var8.setTextColor(var1.getColor(var4));
         ++var3;
      }

   }

   private final void updateUpDownButtonState() {
      int var1 = this.binding.seekbar.getProgress();
      AppCompatImageView var4 = this.binding.upIcon;
      boolean var3 = true;
      boolean var2;
      if (var1 < 100) {
         var2 = true;
      } else {
         var2 = false;
      }

      var4.setEnabled(var2);
      var4 = this.binding.downIcon;
      if (var1 > 0) {
         var2 = var3;
      } else {
         var2 = false;
      }

      var4.setEnabled(var2);
   }

   public final HolderDeviceC3FanSpeedBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (!(var1 instanceof HasCombo3in1MainMode)) {
         if (var1 instanceof HasFanSpeed) {
            this.update(((HasFanSpeed)var1).getFanSpeedEnum());
         }

      } else {
         HasCombo3in1MainMode var3 = (HasCombo3in1MainMode)var1;
         this.update(var3.currentFanSpeedEnum());
         boolean var2;
         if (var3.isInMainMode(MainMode.HEAT) && var1.isUsDevice()) {
            var2 = false;
         } else {
            var2 = true;
         }

         this.setSeekbarEnabled(var2);
      }
   }

   public final void update(Device var1, IndoorDatapoint var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasFanSpeed) {
         Object var5 = null;
         IndoorDatapoint var10;
         if (var2 == null) {
            HasSensorData var4;
            if (var1 instanceof HasSensorData) {
               var4 = (HasSensorData)var1;
            } else {
               var4 = null;
            }

            if (var4 != null) {
               var10 = var4.getLatestSensorDatapoint();
            } else {
               var10 = null;
            }
         } else {
            var10 = var2;
         }

         Float var11;
         if (var10 != null) {
            var11 = var10.getPm25();
         } else {
            var11 = null;
         }

         if (var11 != null && !this.isInSchedule && (!(var1 instanceof HasWick) || !((HasWick)var1).getWickdryOn())) {
            TextView var6 = this.binding.cleanAirEta;
            EtaUtils var12 = EtaUtils.INSTANCE;
            Context var7 = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(var7, "getContext(...)");
            int var3 = DeviceKt.fanSpeedValue(var1);
            Float var9 = (Float)var5;
            if (var2 != null) {
               var9 = var2.getPm25();
            }

            var6.setText(var12.etaString(var7, var3, var9));
            return;
         }

         TextView var8 = this.binding.cleanAirEta;
         Intrinsics.checkNotNullExpressionValue(var8, "cleanAirEta");
         ViewExtensionsKt.show((View)var8, false);
      }

   }

   public final void update(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeedEnum");
      int var2 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(var1);
      this.binding.seekbar.setProgress(var2);
      this.updateUpDownButtonState();
   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JE\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceC3FanSpeedHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceC3FanSpeedHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "fanSpeedEnum", "", "devicedetails_otherRelease"},
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
      public static DeviceC3FanSpeedHolder newInstance$default(Companion var0, ViewGroup var1, Device var2, boolean var3, Function1 var4, int var5, Object var6) {
         if ((var5 & 4) != 0) {
            var3 = false;
         }

         return var0.newInstance(var1, var2, var3, var4);
      }

      public final DeviceC3FanSpeedHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onFanSpeedSetListener");
         HolderDeviceC3FanSpeedBinding var5 = HolderDeviceC3FanSpeedBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         DeviceC3FanSpeedHolder var7 = new DeviceC3FanSpeedHolder(var5, var2, var3, var4);
         Context var6 = var1.getContext();
         Intrinsics.checkNotNullExpressionValue(var6, "getContext(...)");
         var7.updateProgressLabels(var6, var5.seekbar.getProgress());
         return var7;
      }
   }
}
