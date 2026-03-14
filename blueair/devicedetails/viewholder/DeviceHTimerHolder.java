package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceCombo2in1;
import com.blueair.core.model.DeviceCombo3in1;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasTimer;
import com.blueair.core.model.HasTimer$_CC;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.TimerState;
import com.blueair.devicedetails.databinding.HolderDeviceHTimerBinding;
import com.blueair.devicedetails.dialog.DeviceTimerPickerDialogFragment;
import com.blueair.viewcore.R;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHTimerHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceHTimerBinding;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "onDurationSetListener", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceHTimerBinding;Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceHTimerBinding;", "getDevice", "()Lcom/blueair/core/model/Device;", "liveDevice", "enableView", "enable", "", "timerState", "update", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceHTimerHolder extends DeviceAttributeHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderDeviceHTimerBinding binding;
   private final Device device;
   private Device liveDevice;
   private final Function1 onDurationSetListener;
   private final Function0 onOpenInfoListener;
   private final Function1 onStateSetListener;

   // $FF: synthetic method
   public static void $r8$lambda$C5vRFMAjjZHmj4Z37k10RYNk1K0(DeviceHTimerHolder var0, View var1) {
      _init_$lambda$6(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$CeNxMATpyoo8zbdpcmA1i4dQjCk(DeviceHTimerHolder var0, View var1) {
      _init_$lambda$10(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$S6CY7BthyI2rhRexcoPAL2k4KfE(DeviceHTimerHolder var0, View var1) {
      _init_$lambda$0(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$xY_yzzvmvZjE3Gx1_m_PgdXXJVo(DeviceHTimerHolder var0, View var1) {
      _init_$lambda$8(var0, var1);
   }

   public DeviceHTimerHolder(HolderDeviceHTimerBinding var1, Device var2, Function0 var3, Function1 var4, Function1 var5) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
      Intrinsics.checkNotNullParameter(var4, "onStateSetListener");
      Intrinsics.checkNotNullParameter(var5, "onDurationSetListener");
      FrameLayout var6 = var1.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      super((View)var6);
      this.binding = var1;
      this.device = var2;
      this.onOpenInfoListener = var3;
      this.onStateSetListener = var4;
      this.onDurationSetListener = var5;
      this.liveDevice = var2;
      var1.timerTitle.setOnClickListener(new DeviceHTimerHolder$$ExternalSyntheticLambda0(this));
      var1.timerSelect.setOnClickListener(new DeviceHTimerHolder$$ExternalSyntheticLambda1(this));
      var1.timerControlIcon.setOnClickListener(new DeviceHTimerHolder$$ExternalSyntheticLambda2(this));
      var1.contentProgress.setOnClickListener(new DeviceHTimerHolder$$ExternalSyntheticLambda3(this));
   }

   private static final void _init_$lambda$0(DeviceHTimerHolder var0, View var1) {
      var0.onOpenInfoListener.invoke();
   }

   private static final void _init_$lambda$10(DeviceHTimerHolder var0, View var1) {
      HasTimer var3 = var0.liveDevice;
      if (var3 instanceof HasTimer) {
         var3 = var3;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         TimerState var5 = var3.timerStatus();
         int var2 = DeviceHTimerHolder.WhenMappings.$EnumSwitchMapping$0[var5.ordinal()];
         if (var2 != 2 && var2 != 3) {
            if (var2 == 4) {
               var0.onStateSetListener.invoke(TimerState.RESUME);
               return;
            }
         } else {
            var0.onStateSetListener.invoke(TimerState.STOP);
         }
      }

   }

   private static final void _init_$lambda$6(DeviceHTimerHolder var0, View var1) {
      Device var3 = var0.liveDevice;
      HasTimer var13;
      if (var3 instanceof HasTimer) {
         var13 = (HasTimer)var3;
      } else {
         var13 = null;
      }

      if (var13 != null) {
         Context var4 = var1.getContext();
         Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
         FragmentManager var14 = ((FragmentActivity)var4).getSupportFragmentManager();
         Intrinsics.checkNotNullExpressionValue(var14, "getSupportFragmentManager(...)");
         Intrinsics.checkNotNullExpressionValue("DeviceTimerPickerDialogFragment", "getSimpleName(...)");
         if (!(var14.findFragmentByTag("DeviceTimerPickerDialogFragment") instanceof DeviceTimerPickerDialogFragment) && !var14.isStateSaved()) {
            String var10 = var1.getContext().getString(R.string.timer);
            Intrinsics.checkNotNullExpressionValue(var10, "getString(...)");
            String var6 = var0.binding.getRoot().getContext().getString(R.string.timer_duration);
            Intrinsics.checkNotNullExpressionValue(var6, "getString(...)");
            Device var5 = var0.device;
            byte var2;
            if (!(var5 instanceof DevicePet20) && !(var5 instanceof DeviceCombo2in1) && !(var5 instanceof DeviceCombo3in1)) {
               var2 = 12;
            } else {
               var2 = 24;
            }

            List var15 = CollectionsKt.toList((Iterable)(new IntRange(1, var2)));
            Iterable var8 = (Iterable)var15;
            Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var8, 10)));
            Iterator var17 = var8.iterator();

            while(var17.hasNext()) {
               String var9 = String.format(var6, Arrays.copyOf(new Object[]{((Number)var17.next()).intValue()}, 1));
               Intrinsics.checkNotNullExpressionValue(var9, "format(...)");
               var7.add(var9);
            }

            List var16 = (List)var7;
            var2 = RangesKt.coerceAtLeast(var15.indexOf(var13.getTimerDuration() / 3600), 0);
            DeviceTimerPickerDialogFragment var11 = DeviceTimerPickerDialogFragment.Companion.newInstance(var10, var16, var2, true);
            var11.setOnPickResult(new DeviceHTimerHolder$$ExternalSyntheticLambda4(var0, var15));
            ((DialogFragment)var11).show(var14, "DeviceTimerPickerDialogFragment");
         }
      }

   }

   private static final void _init_$lambda$8(DeviceHTimerHolder var0, View var1) {
      HasTimer var2 = var0.liveDevice;
      if (var2 instanceof HasTimer) {
         var2 = var2;
      } else {
         var2 = null;
      }

      if (var2 != null) {
         TimerState var4 = var2.timerStatus();
         if (DeviceHTimerHolder.WhenMappings.$EnumSwitchMapping$0[var4.ordinal()] == 1) {
            var0.onStateSetListener.invoke(TimerState.START);
            return;
         }

         var0.onStateSetListener.invoke(TimerState.COMPLETED);
      }

   }

   private final void enableView(boolean var1, TimerState var2) {
      this.binding.timerSelect.setEnabled(var1);
      this.binding.timerControlIcon.setEnabled(var1);
      this.binding.contentProgress.setEnabled(var1);
      this.binding.timerProgressBar.setEnabled(var1);
      this.binding.timerProgressStatusIcon.setEnabled(var1);
      Context var4 = this.itemView.getContext();
      int var3 = DeviceHTimerHolder.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var3 != 1) {
         if (var3 != 4) {
            if (var1) {
               var3 = R.color.colorPrimary;
            } else {
               var3 = R.color.greyblue;
            }
         } else if (var1) {
            var3 = R.color.colorPrimary;
         } else {
            var3 = R.color.greyblue;
         }
      } else {
         var3 = R.color.greyblue;
      }

      var3 = var4.getColor(var3);
      this.binding.timerProgressBar.setIndicatorColor(new int[]{var3});
      CircularProgressIndicator var11 = this.binding.timerProgressBar;
      Context var5 = this.itemView.getContext();
      if (var1) {
         var3 = R.color.timberwolf;
      } else {
         var3 = R.color.anti_flash_blue;
      }

      var11.setTrackColor(var5.getColor(var3));
      TextView var6 = this.binding.timerSelect;
      Context var12 = this.itemView.getContext();
      if (var1) {
         var3 = R.color.colorPrimaryText;
      } else {
         var3 = R.color.greyblue;
      }

      var6.setTextColor(var12.getColor(var3));
   }

   static final Unit lambda$6$lambda$5$lambda$4$lambda$3$lambda$2(DeviceHTimerHolder var0, List var1, int var2) {
      var0.onDurationSetListener.invoke(((Number)var1.get(var2)).intValue() * 3600);
      return Unit.INSTANCE;
   }

   public final HolderDeviceHTimerBinding getBinding() {
      return this.binding;
   }

   public final Device getDevice() {
      return this.device;
   }

   public void update(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      if (var1 instanceof HasTimer) {
         this.liveDevice = var1;
         HasTimer var6 = (HasTimer)var1;
         TimerState var7 = var6.timerStatus();
         int var2 = DeviceHTimerHolder.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
         boolean var3 = false;
         if (var2 == 1) {
            TextView var15 = this.binding.timerSelect;
            Intrinsics.checkNotNullExpressionValue(var15, "timerSelect");
            ViewExtensionsKt.show$default((View)var15, false, 1, (Object)null);
            var15 = this.binding.timerSelect;
            String var8 = this.itemView.getContext().getString(R.string.timer_duration);
            Intrinsics.checkNotNullExpressionValue(var8, "getString(...)");
            var8 = String.format(var8, Arrays.copyOf(new Object[]{var6.getTimerDuration() / 3600}, 1));
            Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
            var15.setText((CharSequence)var8);
            this.binding.timerControlIcon.setImageResource(R.drawable.selector_timer_start);
            LinearLayout var17 = this.binding.contentCountdown;
            Intrinsics.checkNotNullExpressionValue(var17, "contentCountdown");
            ViewExtensionsKt.hide((View)var17);
         } else {
            TextView var21 = this.binding.timerSelect;
            Intrinsics.checkNotNullExpressionValue(var21, "timerSelect");
            ViewExtensionsKt.hide((View)var21);
            this.binding.timerControlIcon.setImageResource(R.drawable.selector_timer_stop);
            LinearLayout var22 = this.binding.contentCountdown;
            Intrinsics.checkNotNullExpressionValue(var22, "contentCountdown");
            ViewExtensionsKt.show$default((View)var22, false, 1, (Object)null);
            if (var7 == TimerState.STOP) {
               this.binding.countdownNumber.setTextColor(this.itemView.getContext().getColor(R.color.lightbluegrey));
               this.binding.timerProgressBar.setIndicatorColor(new int[]{this.itemView.getContext().getColor(R.color.colorPrimary)});
               this.binding.timerProgressStatusIcon.setImageResource(R.drawable.selector_timer_progress_start);
            } else {
               this.binding.countdownNumber.setTextColor(this.itemView.getContext().getColor(R.color.colorPrimary));
               this.binding.timerProgressBar.setIndicatorColor(new int[]{this.itemView.getContext().getColor(R.color.colorPrimary)});
               this.binding.timerProgressStatusIcon.setImageResource(R.drawable.selector_timer_progress_pause);
            }

            var2 = var6.getTimerLeftTime();
            int var4 = RangesKt.coerceAtLeast(var6.getTimerDuration(), 1);
            int var5 = DeviceHTimerHolder.WhenMappings.$EnumSwitchMapping$0[var7.ordinal()];
            if (var5 != 2 && var5 != 3) {
               if (var5 != 4) {
                  var2 = 0;
               } else {
                  var2 = RangesKt.coerceIn(var2, 0, var4);
               }
            } else {
               var2 = HasTimer$_CC.getRealTimerLeftTime$default(var6, 0L, 1, (Object)null);
            }

            Timber.Forest var18 = Timber.Forest;
            StringBuilder var23 = new StringBuilder();
            var23.append(HasTimer$_CC.getRealTimerLeftTime$default(var6, 0L, 1, (Object)null));
            var23.append(" _ ");
            var23.append(var6.getTimerLeftTimeUpdateTime());
            var18.d(var23.toString(), new Object[0]);
            this.binding.timerProgressBar.setProgress(var2 * 100 / var4);
            var4 = var2 / 3600;
            var2 -= var4 * 3600;
            var5 = var2 / 60;
            TextView var19 = this.binding.countdownNumber;
            String var24 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{var4, var5, var2 - var5 * 60}, 3));
            Intrinsics.checkNotNullExpressionValue(var24, "format(...)");
            var19.setText((CharSequence)var24);
         }

         var2 = var3;
         if (var1 instanceof HasCombo3in1MainMode) {
            var2 = var3;
            if (((HasMainMode)var1).isInMainMode(MainMode.HEAT)) {
               var2 = var3;
               if (var1.isUsDevice()) {
                  var2 = 1;
               }
            }
         }

         this.enableView((boolean)(var2 ^ true), var6.timerStatus());
      }
   }

   @Metadata(
      d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JN\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\f0\u000e¨\u0006\u0012"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceHTimerHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceHTimerHolder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "onOpenInfoListener", "Lkotlin/Function0;", "", "onStateSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/TimerState;", "onDurationSetListener", "", "devicedetails_otherRelease"},
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

      public final DeviceHTimerHolder newInstance(ViewGroup var1, Device var2, Function0 var3, Function1 var4, Function1 var5) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var3, "onOpenInfoListener");
         Intrinsics.checkNotNullParameter(var4, "onStateSetListener");
         Intrinsics.checkNotNullParameter(var5, "onDurationSetListener");
         HolderDeviceHTimerBinding var6 = HolderDeviceHTimerBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
         return new DeviceHTimerHolder(var6, var2, var3, var4, var5);
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
         int[] var0 = new int[TimerState.values().length];

         try {
            var0[TimerState.COMPLETED.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[TimerState.START.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[TimerState.RESUME.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[TimerState.STOP.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
