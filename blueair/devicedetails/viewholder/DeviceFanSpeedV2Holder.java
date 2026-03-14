package com.blueair.devicedetails.viewholder;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFanTable;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasCleanAirEta;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.MainMode;
import com.blueair.devicedetails.databinding.HolderDeviceFanspeedV2Binding;
import com.blueair.devicedetails.util.DeviceControlUtils;
import com.blueair.devicedetails.util.EtaUtils;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(
   d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/BD\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003J\b\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0018\u0010(\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020)2\u0006\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u001eH\u0002J\u001f\u0010\"\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\n2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0015R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceFanspeedV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFanspeedV2Binding;Lcom/blueair/core/model/Device;ZLkotlin/jvm/functions/Function1;)V", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "()Z", "tvList", "", "Landroid/widget/TextView;", "separatorList", "Landroid/view/View;", "previousIsFanMode", "supportStepless", "maxGearPosition", "", "minGearPosition", "inTouch", "lastProgress", "update", "forceOffline", "hydrateEta", "handleGearProgress", "calcFanSpeedByProgress", "progress", "getProgressAfterSnap", "Lcom/blueair/core/model/HasFanSpeed;", "isSlidingRight", "fanSpeedEnum", "preferSpeedLevel", "(Lcom/blueair/core/model/FanSpeedEnum;Ljava/lang/Integer;)V", "applyContentDesp", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceFanSpeedV2Holder extends DeviceControlHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private Device device;
   private boolean inTouch;
   private final boolean isInSchedule;
   private int lastProgress;
   private int maxGearPosition;
   private int minGearPosition;
   private final Function1 onFanSpeedSelectedListener;
   private boolean previousIsFanMode;
   private final List separatorList;
   private boolean supportStepless;
   private final List tvList;

   public DeviceFanSpeedV2Holder(HolderDeviceFanspeedV2Binding var1, Device var2, boolean var3, Function1 var4) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var4, "onFanSpeedSelectedListener");
      super(var1);
      this.device = var2;
      this.isInSchedule = var3;
      this.onFanSpeedSelectedListener = var4;
      this.maxGearPosition = 4;
      TextView var5 = var1.tvProgress0;
      Intrinsics.checkNotNullExpressionValue(var5, "tvProgress0");
      TextView var8 = var1.tvProgress1;
      Intrinsics.checkNotNullExpressionValue(var8, "tvProgress1");
      TextView var10 = var1.tvProgress2;
      Intrinsics.checkNotNullExpressionValue(var10, "tvProgress2");
      TextView var15 = var1.tvProgress3;
      Intrinsics.checkNotNullExpressionValue(var15, "tvProgress3");
      TextView var6 = var1.tvProgress4;
      Intrinsics.checkNotNullExpressionValue(var6, "tvProgress4");
      TextView var9 = var1.tvProgress5;
      Intrinsics.checkNotNullExpressionValue(var9, "tvProgress5");
      TextView var7 = var1.tvProgress6;
      Intrinsics.checkNotNullExpressionValue(var7, "tvProgress6");
      this.tvList = CollectionsKt.listOf(new TextView[]{var5, var8, var10, var15, var6, var9, var7});
      View var17 = var1.separator0;
      Intrinsics.checkNotNullExpressionValue(var17, "separator0");
      View var16 = var1.separator1;
      Intrinsics.checkNotNullExpressionValue(var16, "separator1");
      View var20 = var1.separator2;
      Intrinsics.checkNotNullExpressionValue(var20, "separator2");
      View var18 = var1.separator3;
      Intrinsics.checkNotNullExpressionValue(var18, "separator3");
      View var11 = var1.separator4;
      Intrinsics.checkNotNullExpressionValue(var11, "separator4");
      View var21 = var1.separator5;
      Intrinsics.checkNotNullExpressionValue(var21, "separator5");
      View var19 = var1.separator6;
      Intrinsics.checkNotNullExpressionValue(var19, "separator6");
      this.separatorList = CollectionsKt.listOf(new View[]{var17, var16, var20, var18, var11, var21, var19});
      this.handleGearProgress();
      var1.clickView.setOnClickListener(new DeviceFanSpeedV2Holder$$ExternalSyntheticLambda0(var1));
      var1.expendSwitch.setOnCheckedChangeListener(new DeviceFanSpeedV2Holder$$ExternalSyntheticLambda1(var1, this));
      var1.seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(this) {
         final DeviceFanSpeedV2Holder this$0;

         {
            this.this$0 = var1;
         }

         public void onProgressChanged(SeekBar var1, int var2, boolean var3) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            DeviceFanSpeedV2Holder var4 = this.this$0;
            DeviceFanSpeedV2Holder.update$default(var4, var4.calcFanSpeedByProgress(var2), (Integer)null, 2, (Object)null);
         }

         public void onStartTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = true;
         }

         public void onStopTrackingTouch(SeekBar var1) {
            Intrinsics.checkNotNullParameter(var1, "seekBar");
            this.this$0.inTouch = false;
            FanSpeedEnum var3 = this.this$0.calcFanSpeedByProgress(var1.getProgress());
            if (null.WhenMappings.$EnumSwitchMapping$0[var3.ordinal()] == 1) {
               Device var5 = this.this$0.getDevice();
               HasFanSpeed var6;
               if (var5 instanceof HasFanSpeed) {
                  var6 = (HasFanSpeed)var5;
               } else {
                  var6 = null;
               }

               if (var6 != null) {
                  DeviceFanSpeedV2Holder var4 = this.this$0;
                  int var2 = var4.getProgressAfterSnap(var6, var1.getProgress());
                  var1.setProgress(var2);
                  var4.onFanSpeedSelectedListener.invoke(var4.calcFanSpeedByProgress(var2));
               }

            } else {
               this.this$0.onFanSpeedSelectedListener.invoke(var3);
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
               int[] var1 = new int[FanSpeedEnum.values().length];

               try {
                  var1[FanSpeedEnum.SNAP_STEP.ordinal()] = 1;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$0 = var1;
            }
         }
      });
      if (var3) {
         var1.expendSwitch.setChecked(false);
      }

      Device var12 = this.device;
      if (var12 instanceof HasFanSpeed && var12 != null && !DeviceKt.isAfterG4(var12)) {
         this.supportStepless = true;
         var12 = this.device;
         if (!(var12 instanceof DeviceIcp)) {
            HasFanSpeed var14;
            if (var12 instanceof HasFanSpeed) {
               var14 = (HasFanSpeed)var12;
            } else {
               var14 = null;
            }

            if (var14 == null || !var14.getHasGear4()) {
               var1.seekbar.setMax(99);
               return;
            }
         }

         var1.seekbar.setMax(100);
      } else {
         this.supportStepless = false;
         var1.seekbar.setMax(this.maxGearPosition - this.minGearPosition);
      }
   }

   private final FanSpeedEnum calcFanSpeedByProgress(int var1) {
      if (this.supportStepless) {
         Device var2 = this.device;
         HasFanSpeed var3;
         if (var2 instanceof HasFanSpeed) {
            var3 = (HasFanSpeed)var2;
         } else {
            var3 = null;
         }

         if (var3 != null && var3.getHasGear4()) {
            return FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(var1));
         } else {
            var3 = this.device;
            if (var3 != null && DeviceKt.isG4orB4orNB(var3)) {
               return FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(var1));
            } else {
               return this.device instanceof DeviceIcp ? FanSpeedEnum.Companion.fanSpeedEnumFromProgressIcp(FanSpeedUtils.INSTANCE.getIcpSpeedFromSeekBarProgress(var1)) : FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(var1));
            }
         }
      } else {
         return FanSpeedEnum.Companion.fromStep(var1 + this.minGearPosition, this.device);
      }
   }

   private final int getProgressAfterSnap(HasFanSpeed var1, int var2) {
      if (var1.getHasGear4()) {
         return this.isSlidingRight(var2) ? 25 : 0;
      } else if (DeviceKt.isG4orB4orNB(var1)) {
         return this.isSlidingRight(var2) ? 33 : 0;
      } else if (var1 instanceof DeviceIcp) {
         if (76 <= var2 && var2 < 101) {
            return 100;
         } else {
            return 26 <= var2 && var2 < 76 ? 50 : 0;
         }
      } else if (1 <= var2 && var2 < 33) {
         return this.isSlidingRight(var2) ? 33 : 0;
      } else if (34 <= var2 && var2 < 66) {
         return this.isSlidingRight(var2) ? 66 : 33;
      } else if (67 <= var2 && var2 < 99) {
         return this.isSlidingRight(var2) ? 99 : 66;
      } else {
         return 0;
      }
   }

   private final void handleGearProgress() {
      Device var5 = this.device;
      boolean var4 = var5 instanceof DeviceFanTable;
      Object var6 = null;
      byte var1;
      if (var4) {
         var1 = 6;
      } else {
         HasFanSpeed var11;
         if (var5 instanceof HasFanSpeed) {
            var11 = (HasFanSpeed)var5;
         } else {
            var11 = null;
         }

         if (var11 != null && var11.getHasGear4()) {
            var1 = 4;
         } else {
            var1 = 3;
         }
      }

      this.maxGearPosition = var1;
      Device var7 = this.device;
      HasFanSpeed var12 = (HasFanSpeed)var6;
      if (var7 instanceof HasFanSpeed) {
         var12 = (HasFanSpeed)var7;
      }

      int var2 = 0;
      if (var12 != null && var12.getHasGear0()) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      this.minGearPosition = var1 ^ 1;
      int var3 = ((Collection)this.tvList).size();

      for(int var9 = var2; var9 < var3; ++var9) {
         var2 = this.minGearPosition;
         if (var9 > this.maxGearPosition || var2 > var9) {
            var12 = (HasFanSpeed)this.tvList.get(var9);
            Intrinsics.checkNotNullExpressionValue(var12, "get(...)");
            ViewExtensionsKt.hide((View)var12);
            ViewExtensionsKt.hide((View)this.separatorList.get(var9));
         }
      }

   }

   private final void hydrateEta(Device var1) {
      HolderDeviceFanspeedV2Binding var4 = (HolderDeviceFanspeedV2Binding)this.getBinding();
      SwitchCompat var3 = var4.expendSwitch;
      Intrinsics.checkNotNullExpressionValue(var3, "expendSwitch");
      ViewExtensionsKt.show((View)var3, true);
      if (var1 instanceof HasFanSpeed && var1 instanceof HasSensorData) {
         Integer var7;
         if (var1 instanceof HasCleanAirEta) {
            var7 = ((HasCleanAirEta)var1).getCleanAirEta() / 60;
         } else {
            label39: {
               IndoorDatapoint var12 = ((HasSensorData)var1).getLatestSensorDatapoint();
               if (var12 != null) {
                  Float var13 = var12.getPm25();
                  if (var13 != null) {
                     int var2 = (int)var13;
                     var7 = EtaUtils.INSTANCE.eta(DeviceKt.fanSpeedValue(var1), var2);
                     break label39;
                  }
               }

               var7 = null;
            }
         }

         if (var7 == null) {
            LinearLayout var9 = var4.etaContainer;
            Intrinsics.checkNotNullExpressionValue(var9, "etaContainer");
            ViewExtensionsKt.show((View)var9, false);
         } else {
            int var10 = var7;
            String var14 = "";
            if (var10 == 0) {
               LinearLayout var8 = var4.etaContainer;
               Intrinsics.checkNotNullExpressionValue(var8, "etaContainer");
               ViewExtensionsKt.show((View)var8, var4.expendSwitch.isChecked() ^ true);
               var4.etaIcon.setImageResource(R.drawable.ic_eta_done);
               var4.etaText.setText(R.string.cleaning_complete);
               var4.etaValue.setText((CharSequence)"");
            } else {
               LinearLayout var5 = var4.etaContainer;
               Intrinsics.checkNotNullExpressionValue(var5, "etaContainer");
               ViewExtensionsKt.show((View)var5, var4.expendSwitch.isChecked() ^ true);
               var4.etaIcon.setImageResource(R.drawable.ic_eta);
               var4.etaText.setText(R.string.clear_air_in);
               TextView var16 = var4.etaValue;
               StringBuilder var15 = new StringBuilder();
               if (var7 > 60) {
                  var14 = "> ";
               }

               var15.append(var14);
               var15.append(Math.min(var7, 60));
               var15.append(' ');
               if (var7 != null && var7 == 1) {
                  var10 = R.string.eta_minute;
               } else {
                  var10 = R.string.eta_minutes;
               }

               var15.append(this.getString(var10));
               var16.setText((CharSequence)var15.toString());
            }
         }
      } else {
         LinearLayout var6 = var4.etaContainer;
         Intrinsics.checkNotNullExpressionValue(var6, "etaContainer");
         ViewExtensionsKt.show((View)var6, false);
      }
   }

   private final boolean isSlidingRight(int var1) {
      return this.lastProgress < var1;
   }

   static final void lambda$3$lambda$0(HolderDeviceFanspeedV2Binding var0, View var1) {
      var0.expendSwitch.setChecked(var0.expendSwitch.isChecked() ^ true);
   }

   static final void lambda$3$lambda$2(HolderDeviceFanspeedV2Binding var0, DeviceFanSpeedV2Holder var1, CompoundButton var2, boolean var3) {
      Group var6 = var0.expendedContent;
      Intrinsics.checkNotNullExpressionValue(var6, "expendedContent");
      ViewExtensionsKt.show((View)var6, var3 ^ true);
      if (!var1.isInSchedule) {
         if (var3) {
            LinearLayout var5 = var0.etaContainer;
            Intrinsics.checkNotNullExpressionValue(var5, "etaContainer");
            ViewExtensionsKt.hide((View)var5);
            return;
         }

         Device var4 = var1.device;
         if (var4 != null) {
            var1.update(var4, false);
         }
      }

   }

   // $FF: synthetic method
   public static void update$default(DeviceFanSpeedV2Holder var0, FanSpeedEnum var1, Integer var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      var0.update(var1, var2);
   }

   public final void applyContentDesp() {
      HolderDeviceFanspeedV2Binding var1 = (HolderDeviceFanspeedV2Binding)this.getBinding();
      View var3 = var1.clickView;
      StringBuilder var2 = new StringBuilder();
      var2.append(var1.title.getText());
      var2.append(", ");
      var2.append(var1.progressText.getText());
      var3.setContentDescription((CharSequence)var2.toString());
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
         boolean var3;
         if (var1 instanceof HasCombo3in1MainMode && var1.isUsDevice() && ((HasCombo3in1MainMode)var1).isInMainMode(MainMode.HEAT)) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.update(FanSpeedEnum.Companion.fromServerValue(var1, DeviceKt.fanSpeedValue(var1)), FanSpeedUtils.INSTANCE.getFanSpeedLevel(var1));
         if (DeviceControlUtils.INSTANCE.isFanMode(var1) && !var3) {
            if (!this.previousIsFanMode) {
               ((HolderDeviceFanspeedV2Binding)this.getBinding()).expendSwitch.setChecked(false);
            }

            this.previousIsFanMode = true;
         } else {
            this.previousIsFanMode = false;
         }

         boolean var4;
         if (!var2 && var1.isOnline() && !DeviceKt.isStandByOn(var1)) {
            var4 = false;
         } else {
            var4 = true;
         }

         HolderDeviceFanspeedV2Binding var5 = null;
         if (!var4 && !var3) {
            var5 = (HolderDeviceFanspeedV2Binding)this.getBinding();
            var5.clickView.setEnabled(true);
            var5.expendSwitch.setEnabled(true);
            var5.getRoot().setBackgroundTintList((ColorStateList)null);
            var5.leadingIcon.setImageResource(R.drawable.ic_fanspeed);
            var5.title.setTextColor(this.getColor(R.color.colorPrimaryText));
            if (var1 instanceof HasMainMode && !(var1 instanceof HasHumMainMode)) {
               ApSubMode var15 = ((HasMainMode)var1).apSubMode();
               var3 = DeviceFanSpeedV2Holder.WhenMappings.$EnumSwitchMapping$0[var15.ordinal()];
               if (var3 != 1) {
                  if (var3 != 2) {
                     if (var3 != 3) {
                        if (var3 != 4) {
                           throw new NoWhenBranchMatchedException();
                        }

                        this.hydrateEta(var1);
                     } else {
                        var5.clickView.setEnabled(false);
                        SwitchCompat var10 = var5.expendSwitch;
                        Intrinsics.checkNotNullExpressionValue(var10, "expendSwitch");
                        ViewExtensionsKt.show((View)var10, false);
                        var5.expendSwitch.setChecked(true);
                        var5.progressText.setText(R.string.night);
                     }
                  } else {
                     var5.clickView.setEnabled(false);
                     SwitchCompat var11 = var5.expendSwitch;
                     Intrinsics.checkNotNullExpressionValue(var11, "expendSwitch");
                     ViewExtensionsKt.show((View)var11, false);
                     var5.expendSwitch.setChecked(true);
                     var5.progressText.setText(R.string.eco);
                  }
               } else {
                  var5.clickView.setEnabled(false);
                  SwitchCompat var12 = var5.expendSwitch;
                  Intrinsics.checkNotNullExpressionValue(var12, "expendSwitch");
                  ViewExtensionsKt.show((View)var12, false);
                  var5.expendSwitch.setChecked(true);
                  var5.progressText.setText(R.string.auto);
               }
            } else {
               this.hydrateEta(var1);
            }
         } else {
            HolderDeviceFanspeedV2Binding var6 = (HolderDeviceFanspeedV2Binding)this.getBinding();
            var6.clickView.setEnabled(false);
            var6.expendSwitch.setChecked(true);
            var6.expendSwitch.setEnabled(false);
            SwitchCompat var8 = var6.expendSwitch;
            Intrinsics.checkNotNullExpressionValue(var8, "expendSwitch");
            ViewExtensionsKt.show((View)var8, false);
            ConstraintLayout var7 = var6.getRoot();
            ColorStateList var9 = var5;
            if (var4) {
               var9 = ColorStateList.valueOf(this.getColor(R.color.surface_dark_5));
            }

            var7.setBackgroundTintList(var9);
            var6.leadingIcon.setImageResource(R.drawable.ic_fanspeed_disabled);
            var6.title.setTextColor(this.getColor(R.color.surface_dark_55));
            if (var4) {
               var6.progressText.setText((CharSequence)"");
            }
         }

         this.applyContentDesp();
      }
   }

   public final void update(FanSpeedEnum var1, Integer var2) {
      Intrinsics.checkNotNullParameter(var1, "fanSpeedEnum");
      if (var1 != FanSpeedEnum.SNAP_STEP) {
         int var3;
         if (var2 != null) {
            var3 = var2;
         } else {
            var3 = FanSpeedUtils.INSTANCE.getFanSpeedLevel(this.device, var1);
         }

         int var4 = RangesKt.coerceIn(var3, this.minGearPosition, this.maxGearPosition);
         AccessibleSeekBar var9 = ((HolderDeviceFanspeedV2Binding)this.getBinding()).seekbar;
         if (this.supportStepless) {
            Device var10 = this.device;
            HasFanSpeed var11;
            if (var10 instanceof HasFanSpeed) {
               var11 = (HasFanSpeed)var10;
            } else {
               var11 = null;
            }

            if (var11 != null && var11.getHasGear4()) {
               var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(var1);
            } else {
               var11 = this.device;
               Intrinsics.checkNotNull(var11);
               if (DeviceKt.isG4orB4orNB(var11)) {
                  var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedG4(var1);
               } else if (this.device instanceof DeviceIcp) {
                  var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedIcp(var1);
               } else {
                  var3 = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedLegacy(var1);
               }
            }
         } else {
            var3 = var4 - this.minGearPosition;
         }

         var9.setProgress(var3);
         this.lastProgress = ((HolderDeviceFanspeedV2Binding)this.getBinding()).seekbar.getProgress();
         ((HolderDeviceFanspeedV2Binding)this.getBinding()).progressText.setText((CharSequence)String.valueOf(var4));
         int var6 = this.getColor(R.color.colorPrimary);
         int var7 = this.getColor(R.color.surface_dark_55);
         int var5 = this.getColor(R.color.surface_dark_45);
         var3 = this.minGearPosition;
         int var8 = this.maxGearPosition;
         if (var3 <= var8) {
            while(true) {
               if (var3 <= var4) {
                  ((TextView)this.tvList.get(var3)).setTextColor(var6);
                  ((View)this.separatorList.get(var3)).setBackground((Drawable)(new ColorDrawable(var6)));
               } else {
                  ((TextView)this.tvList.get(var3)).setTextColor(var7);
                  ((View)this.separatorList.get(var3)).setBackground((Drawable)(new ColorDrawable(var5)));
               }

               if (var3 == var8) {
                  break;
               }

               ++var3;
            }
         }

         if (this.isInSchedule) {
            this.applyContentDesp();
         }
      }

   }

   @Metadata(
      d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFanSpeedV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "isInSchedule", "", "onFanSpeedSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "Lkotlin/ParameterName;", "name", "speed", "", "devicedetails_otherRelease"},
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

      public final DeviceFanSpeedV2Holder newInstance(ViewGroup var1, Device var2, boolean var3, Function1 var4) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var4, "onFanSpeedSelectedListener");
         HolderDeviceFanspeedV2Binding var5 = HolderDeviceFanspeedV2Binding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var5, "inflate(...)");
         return new DeviceFanSpeedV2Holder(var5, var2, var3, var4);
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
         int[] var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.AUTO.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ApSubMode.ECO.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ApSubMode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ApSubMode.FAN.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
