package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.core.view.ViewGroupKt;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.HolderDeviceMainModeDehumBinding;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B2\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0011¨\u0006\u0015"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeDehumHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeDehumBinding;", "binding", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceMainModeDehumBinding;Lkotlin/jvm/functions/Function1;)V", "update", "device", "Lcom/blueair/core/model/Device;", "forceOffline", "", "mainMode", "isEnabled", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceMainModeDehumHolder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);

   // $FF: synthetic method
   public static void $r8$lambda$V92onH37cQf3lkV_ibjjx6iJao8/* $FF was: $r8$lambda$V92onH37cQf3lkV-ibjjx6iJao8*/(Function1 var0, RadioGroup var1, int var2) {
      _init_$lambda$1(var0, var1, var2);
   }

   public DeviceMainModeDehumHolder(HolderDeviceMainModeDehumBinding var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "onModeSelectedListener");
      super(var1);
      var1.radioGroup.setOnCheckedChangeListener(new DeviceMainModeDehumHolder$$ExternalSyntheticLambda0(var2));
   }

   private static final void _init_$lambda$1(Function1 var0, RadioGroup var1, int var2) {
      MainMode var3;
      if (var2 == R.id.rb_purify) {
         var3 = MainMode.AirPurify;
      } else if (var2 == R.id.rb_dehum) {
         var3 = MainMode.Dehumidification;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         var0.invoke(var3);
      }

   }

   public void update(Device var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      HasMainMode var3;
      if (var1 instanceof HasMainMode) {
         var3 = (HasMainMode)var1;
      } else {
         var3 = null;
      }

      if (var3 != null) {
         MainMode var5 = var3.mainMode();
         if (var5 != null) {
            if (!DeviceKt.isStandByOn(var1) && var1.isOnline() && !var2) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.update(var5, var2);
         }
      }

   }

   public final void update(MainMode var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "mainMode");
      com.blueair.viewcore.view.RadioGroup var4 = ((HolderDeviceMainModeDehumBinding)this.getBinding()).radioGroup;
      Intrinsics.checkNotNullExpressionValue(var4, "radioGroup");
      Iterator var5 = ViewGroupKt.getChildren((ViewGroup)var4).iterator();

      while(var5.hasNext()) {
         ((View)var5.next()).setEnabled(var2);
      }

      com.blueair.viewcore.view.RadioGroup var6 = ((HolderDeviceMainModeDehumBinding)this.getBinding()).radioGroup;
      int var3;
      if (var1 == MainMode.AirPurify) {
         var3 = R.id.rb_purify;
      } else {
         var3 = R.id.rb_dehum;
      }

      var6.checkSilence(var3);
   }

   @Metadata(
      d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceMainModeDehumHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceMainModeDehumHolder;", "parentView", "Landroid/view/ViewGroup;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/MainMode;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"},
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

      public final DeviceMainModeDehumHolder newInstance(ViewGroup var1, Function1 var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "onModeSelectedListener");
         HolderDeviceMainModeDehumBinding var3 = HolderDeviceMainModeDehumBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
         return new DeviceMainModeDehumHolder(var3, var2);
      }
   }
}
