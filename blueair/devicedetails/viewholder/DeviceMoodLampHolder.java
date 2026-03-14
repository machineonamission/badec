package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasMoodLamp;
import com.blueair.core.model.MoodLampEnum;
import com.blueair.devicedetails.databinding.HolderDeviceMoodLampBinding;
import com.blueair.devicedetails.util.NightLampUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0007H\u0016J\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMoodLampHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceMoodLampBinding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onLampGearSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MoodLampEnum;", "Lkotlin/ParameterName;", "name", "gear", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMoodLampBinding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "tvList", "", "Landroid/widget/TextView;", "separatorList", "Landroid/view/View;", "maxGearPosition", "", "inTouch", "lastProgress", "update", "forceOffline", "moodLampEnum", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceMoodLampHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Device device;
   private boolean inTouch;
   private final boolean isInSchedule;
   private int lastProgress;
   private final int maxGearPosition;
   private final Function1 onLampGearSelectedListener;
   private final List separatorList;
   private final List tvList;

   public DeviceMoodLampHolder(HolderDeviceMoodLampBinding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onLampGearSelectedListener");
      super(var1);
      this.device = var2;
      this.isInSchedule = var3;
      this.onLampGearSelectedListener = var4;
      this.maxGearPosition = 3;
      TextView var6 = var1.tvProgress0;
      Intrinsics.checkNotNullExpressionValue(var6, "tvProgress0");
      TextView var7 = var1.tvProgress1;
      Intrinsics.checkNotNullExpressionValue(var7, "tvProgress1");
      TextView var9 = var1.tvProgress2;
      Intrinsics.checkNotNullExpressionValue(var9, "tvProgress2");
      TextView var5 = var1.tvProgress3;
      Intrinsics.checkNotNullExpressionValue(var5, "tvProgress3");
      this.tvList = CollectionsKt.listOf(new TextView[]{var6, var7, var9, var5});
      View var10 = var1.separator0;
      Intrinsics.checkNotNullExpressionValue(var10, "separator0");
      View var11 = var1.separator1;
      Intrinsics.checkNotNullExpressionValue(var11, "separator1");
      View var12 = var1.separator2;
      Intrinsics.checkNotNullExpressionValue(var12, "separator2");
      View var8 = var1.separator3;
      Intrinsics.checkNotNullExpressionValue(var8, "separator3");
      this.separatorList = CollectionsKt.listOf(new View[]{var10, var11, var12, var8});
      var1.clickView.setOnClickListener(new DeviceMoodLampHolder$$ExternalSyntheticLambda0(var1));
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceMoodLampHolder$$ExternalSyntheticLambda1(var1, this));
      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceMoodLampHolder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.update(MoodLampEnum.Companion.fromStep(var2));
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = true;
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = false;
            this.this$0.onLampGearSelectedListener.invoke(MoodLampEnum.Companion.fromStep(var1.getProgress()));
         }
      });
      var1.expendSwitch.setChecked(false);
   }

   static final void lambda$3$lambda$0(HolderDeviceMoodLampBinding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   static final void lambda$3$lambda$2(HolderDeviceMoodLampBinding var0, DeviceMoodLampHolder var1, CompoundButton var2, boolean var3) {
      Group var4 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var4, "expendedContent");
      ViewExtensionsKt.show((View)var4, var3 ^ true);
      if (!var1.isInSchedule && !var3) {
         Device var5 = var1.device;
         if (var5 != null) {
            var1.update(var5, false);
         }
      }

   }

   public final Device getDevice() {
      return this.device;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public final void setDevice(Device var1) {
      this.device = var1;
   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (!this.inTouch) {
         this.device = var1;
         if (var1 instanceof HasMoodLamp) {
            this.update(MoodLampEnum.Companion.fromServerValue((HasMoodLamp)var1));
         }

         if (!var2 && var1.isOnline()) {
            HolderDeviceMoodLampBinding var5 = (HolderDeviceMoodLampBinding)this.getBinding();
            var5.clickView.setEnabled(true);
            var5.expendSwitch.setEnabled(true);
            var5.contentContainer.setEnabled(true);
            var5.leadingIcon.setImageTintList((ColorStateList)null);
            var5.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            var5.expendSwitch.setBackgroundTintList((ColorStateList)null);
            SwitchCompat var6 = var5.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var6, "expendSwitch");
            ViewExtensionsKt.show((View)var6, true);
         } else {
            HolderDeviceMoodLampBinding var4 = (HolderDeviceMoodLampBinding)this.getBinding();
            var4.clickView.setEnabled(false);
            var4.expendSwitch.setEnabled(false);
            var4.expendSwitch.setChecked(true);
            Group var3 = var4.expendedContent;
            Intrinsics.checkNotNullExpressionValue(var3, "expendedContent");
            ViewExtensionsKt.show((View)var3, false);
            var4.expendSwitch.setChecked(true);
            SwitchCompat var7 = var4.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var7, "expendSwitch");
            ViewExtensionsKt.show((View)var7, true);
            var4.contentContainer.setEnabled(false);
            var4.expendSwitch.setBackgroundTintList(ColorStateList.valueOf(this.getColor(R.color.fill_grey)));
            var4.leadingIcon.setImageTintList(ColorStateList.valueOf(this.getColor(R.color.surface_dark_45)));
            var4.title.setTextColor(this.getColor(R.color.surface_dark_55));
            var4.progressText.setText((CharSequence)"");
         }
      }
   }

   public final void update(MoodLampEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "moodLampEnum");
      ((HolderDeviceMoodLampBinding)this.getBinding()).seekbar.setProgress(var1.toStep());
      this.lastProgress = ((HolderDeviceMoodLampBinding)this.getBinding()).seekbar.getProgress();
      ((HolderDeviceMoodLampBinding)this.getBinding()).progressText.setText(NightLampUtils.INSTANCE.getTitleRes(var1));
      int var4 = this.getColor(R.color.colorPrimary);
      int var3 = this.getColor(R.color.surface_dark_55);
      int var5 = this.getColor(R.color.surface_dark_45);
      int var6 = this.maxGearPosition;
      if (var6 >= 0) {
         int var2 = 0;

         while(true) {
            if (var2 <= this.lastProgress) {
               ((TextView)this.tvList.get(var2)).setTextColor(var4);
               ((View)this.separatorList.get(var2)).setBackground((Drawable)(new ColorDrawable(var4)));
            } else {
               ((TextView)this.tvList.get(var2)).setTextColor(var3);
               ((View)this.separatorList.get(var2)).setBackground((Drawable)(new ColorDrawable(var5)));
            }

            if (var2 == var6) {
               break;
            }

            ++var2;
         }
      }

   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMoodLampHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMoodLampHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onGearSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MoodLampEnum;", "Lkotlin/ParameterName;", "name", "gear", "", "devicedetails_otherRelease"},
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

      public final DeviceMoodLampHolder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onGearSelectedListener");
         HolderDeviceMoodLampBinding var5 = HolderDeviceMoodLampBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceMoodLampHolder(var5, var2, var3, var4);
      }
   }
}
