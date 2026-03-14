package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.ViewKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasWaterLevel;
import com.blueair.core.model.WaterLevel;
import com.blueair.devicedetails.databinding.HolderDeviceCOnOffButtonBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.ConfirmationDialogLeftAligned;
import com.blueair.viewcore.view.SwitchCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bBE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceCOnOffButtonBinding;", "device", "Lcom/blueair/core/model/Device;", "type", "Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "isInSchedule", "", "onSetListener", "Lkotlin/Function2;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceCOnOffButtonBinding;Lcom/blueair/core/model/Device;Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;ZLkotlin/jvm/functions/Function2;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceCOnOffButtonBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "getType", "()Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "()Z", "titlePrefix", "", "update", "isOn", "Type", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceCOnOffButtonHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceCOnOffButtonBinding binding;
   private final Device device;
   private final boolean isInSchedule;
   private final Function2 onSetListener;
   private final String titlePrefix;
   private final Type type;

   // $FF: synthetic method
   public static void $r8$lambda$RRq5mX_18uj2_3IXYrvjLMJwq9s(DeviceCOnOffButtonHolder var0, View var1) {
      update$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$UNEtyGw3kEzSbbL05WnXG6VMGfw(DeviceCOnOffButtonHolder var0) {
      update$lambda$1(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$pVcfB9_MZPUASFG67IGqiS4U4T8/* $FF was: $r8$lambda$pVcfB9-MZPUASFG67IGqiS4U4T8*/(DeviceCOnOffButtonHolder var0, CompoundButton var1, boolean var2) {
      _init_$lambda$0(var0, var1, var2);
   }

   public DeviceCOnOffButtonHolder(HolderDeviceCOnOffButtonBinding var1, Device var2, Type var3, boolean var4, Function2 var5) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "type");
      Intrinsics.checkNotNullParameter(var5, "onSetListener");
      FrameLayout var7 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var7, "getRoot(...)");
      super((View)var7);
      this.binding = var1;
      this.device = var2;
      this.type = var3;
      this.isInSchedule = var4;
      this.onSetListener = var5;
      var1.switchBtn.setOnCheckedChangeListener(new DeviceCOnOffButtonHolder$$ExternalSyntheticLambda0(this));
      Context var8 = this.itemView.getContext();
      int var6;
      if (var3 == DeviceCOnOffButtonHolder.Type.STANDBY) {
         var6 = R.string.device_status;
      } else {
         var6 = R.string.humidification;
      }

      String var9 = var8.getString(var6);
      Intrinsics.checkNotNullExpressionValue(var9, "getString(...)");
      this.titlePrefix = var9;
      TextView var10 = var1.title;
      if (var3 == DeviceCOnOffButtonHolder.Type.STANDBY) {
         var6 = R.drawable.ic_standby_switch;
      } else {
         var6 = R.drawable.ic_humidification_switch;
      }

      TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(var10, var6, 0, 0, 0);
      if (var4) {
         var1.contentContainer.setBackground(AppCompatResources.getDrawable(this.itemView.getContext(), R.drawable.rounded_square_anti_flash_blue_r8));
      }

   }

   // $FF: synthetic method
   public DeviceCOnOffButtonHolder(HolderDeviceCOnOffButtonBinding var1, Device var2, Type var3, boolean var4, Function2 var5, int var6, DefaultConstructorMarker var7) {
      if ((var6 & 8) != 0) {
         var4 = false;
      }

      this(var1, var2, var3, var4, var5);
   }

   private static final void _init_$lambda$0(DeviceCOnOffButtonHolder var0, CompoundButton var1, boolean var2) {
      var0.onSetListener.invoke(var0.type, var2 ^ true);
   }

   private static final void update$lambda$1(DeviceCOnOffButtonHolder var0) {
      Drawable var1 = var0.binding.title.getCompoundDrawables()[2];
      if (var1 != null) {
         var1.setTint(var0.itemView.getContext().getColor(R.color.peach));
      }

   }

   private static final void update$lambda$3(DeviceCOnOffButtonHolder var0, View var1) {
      View var2 = var0.itemView;
      Intrinsics.checkNotNullExpressionValue(var2, "itemView");
      FragmentManager var3 = ViewKt.findFragment(var2).getChildFragmentManager();
      Intrinsics.checkNotNullExpressionValue(var3, "getChildFragmentManager(...)");
      Intrinsics.checkNotNullExpressionValue("ConfirmationDialogLeftAligned", "getSimpleName(...)");
      if (!(var3.findFragmentByTag("ConfirmationDialogLeftAligned") instanceof ConfirmationDialogLeftAligned) && !var3.isStateSaved()) {
         ((DialogFragment)ConfirmationDialogLeftAligned.Companion.newInstance$default(ConfirmationDialogLeftAligned.Companion, R.string.warning_title_water_shortage, (Integer)null, R.string.warning_msg_water_shortage, R.string.snackbar_ok, (Integer)null, false, false, false, true, (String[])null, (String)null, (Integer)null, (Function1)null, 7904, (Object)null)).show(var3, "ConfirmationDialogLeftAligned");
      }

   }

   public final HolderDeviceCOnOffButtonBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final Type getType() {
      return this.type;
   }

   public final boolean isInSchedule() {
      return this.isInSchedule;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Type var4 = this.type;
      int var2 = DeviceCOnOffButtonHolder.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()];
      boolean var3 = true;
      if (var2 != 1) {
         if (var2 != 2) {
            throw new NoWhenBranchMatchedException();
         }

         if (var1 instanceof HasHumMode) {
            HasHumMode var6 = (HasHumMode)var1;
            this.update(var6.getHumMode());
            SwitchCompat var5 = this.binding.switchBtn;
            if (!(var1 instanceof HasStandBy) || ((HasStandBy)var1).isStandByOn()) {
               var3 = false;
            }

            var5.setEnabled(var3);
            if (var1 instanceof HasWaterLevel && ((HasWaterLevel)var1).isInWaterLevel(WaterLevel.SHORTAGE) && !var6.getHumMode()) {
               this.binding.switchBtn.setEnabled(false);
               TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this.binding.title, R.drawable.ic_humidification_switch, 0, R.drawable.ic_info_h_16, 0);
               this.binding.title.post(new DeviceCOnOffButtonHolder$$ExternalSyntheticLambda1(this));
               this.binding.title.setOnClickListener(new DeviceCOnOffButtonHolder$$ExternalSyntheticLambda2(this));
               return;
            }

            TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(this.binding.title, R.drawable.ic_humidification_switch, 0, 0, 0);
            this.binding.title.setOnClickListener((View.OnClickListener)null);
            return;
         }
      } else if (var1 instanceof HasStandBy) {
         this.update(((HasStandBy)var1).isStandByOn() ^ true);
      }

   }

   public final void update(boolean var1) {
      this.binding.switchBtn.setCheckedSilence(var1);
      Context var3 = this.itemView.getContext();
      int var2;
      if (var1) {
         var2 = R.string.on_camel_case;
      } else {
         var2 = R.string.off_camel_case;
      }

      String var6 = var3.getString(var2);
      Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
      TextView var5 = this.binding.title;
      StringBuilder var4 = new StringBuilder();
      var4.append(this.titlePrefix);
      var4.append(var6);
      var5.setText((CharSequence)var4.toString());
      this.binding.switchBtn.setContentDescription((CharSequence)this.titlePrefix);
   }

   @Metadata(
      d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00100\u000f¨\u0006\u0011"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "type", "Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "isInSchedule", "", "onSetListener", "Lkotlin/Function2;", "", "devicedetails_otherRelease"},
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
      public static DeviceCOnOffButtonHolder newInstance$default(Companion var0, ViewGroup var1, Device var2, Type var3, boolean var4, Function2 var5, int var6, Object var7) {
         if ((var6 & 8) != 0) {
            var4 = false;
         }

         return var0.newInstance(var1, var2, var3, var4, var5);
      }

      public final DeviceCOnOffButtonHolder newInstance(ViewGroup var1, Device var2, Type var3, boolean var4, Function2 var5) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "type");
         Intrinsics.checkNotNullParameter(var5, "onSetListener");
         HolderDeviceCOnOffButtonBinding var6 = HolderDeviceCOnOffButtonBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
         return new DeviceCOnOffButtonHolder(var6, var2, var3, var4, var5);
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceCOnOffButtonHolder$Type;", "", "<init>", "(Ljava/lang/String;I)V", "STANDBY", "HUM", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum Type {
      private static final EnumEntries $ENTRIES;
      private static final Type[] $VALUES;
      HUM,
      STANDBY;

      // $FF: synthetic method
      private static final Type[] $values() {
         return new Type[]{STANDBY, HUM};
      }

      static {
         Type[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
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
         int[] var0 = new int[DeviceCOnOffButtonHolder.Type.values().length];

         try {
            var0[DeviceCOnOffButtonHolder.Type.STANDBY.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceCOnOffButtonHolder.Type.HUM.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
