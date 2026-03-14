package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;
import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.databinding.DialogfragmentAboutAirQualityBinding;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.CustomViewModelStoreOwner;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0003J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"},
   d2 = {"Lcom/blueair/devicedetails/dialog/AboutAirQualityDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentAboutAirQualityBinding;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceSensorsViewModel;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "configureView", "", "onStart", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AboutAirQualityDialogFragment extends BaseDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private DialogfragmentAboutAirQualityBinding binding;
   private final String screenName = "device_details_about_aqi";
   public DeviceSensorsViewModel viewModel;

   // $FF: synthetic method
   public static void $r8$lambda$lljQHagTvxjnY_Xy_Au5Ql6W5xk/* $FF was: $r8$lambda$lljQHagTvxjnY-Xy_Au5Ql6W5xk*/(AboutAirQualityDialogFragment var0, DialogfragmentAboutAirQualityBinding var1) {
      configureView$lambda$8$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$quPK6g0TpWkhqe1Bqpxdc_8H_NA/* $FF was: $r8$lambda$quPK6g0TpWkhqe1Bqpxdc-8H-NA*/(AboutAirQualityDialogFragment var0, View var1) {
      onCreateView$lambda$2$lambda$1(var0, var1);
   }

   private final void configureView() {
      DialogfragmentAboutAirQualityBinding var5 = this.binding;
      DialogfragmentAboutAirQualityBinding var4 = var5;
      if (var5 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      boolean var3;
      label48: {
         ConstraintLayout var11 = var4.contentPm1;
         Intrinsics.checkNotNullExpressionValue(var11, "contentPm1");
         ViewExtensionsKt.show((View)var11, this.getViewModel().getSupportedSensors().contains(SensorType.PM1));
         var11 = var4.contentPm10;
         Intrinsics.checkNotNullExpressionValue(var11, "contentPm10");
         ViewExtensionsKt.show((View)var11, this.getViewModel().getSupportedSensors().contains(SensorType.PM10));
         var11 = var4.contentPm25;
         Intrinsics.checkNotNullExpressionValue(var11, "contentPm25");
         ViewExtensionsKt.show((View)var11, this.getViewModel().getSupportedSensors().contains(SensorType.PM25));
         Group var14 = var4.groupHum;
         Intrinsics.checkNotNullExpressionValue(var14, "groupHum");
         ViewExtensionsKt.show((View)var14, this.getViewModel().getSupportedSensors().contains(SensorType.HUM));
         ConstraintLayout var15 = var4.contentTvoc;
         Intrinsics.checkNotNullExpressionValue(var15, "contentTvoc");
         ViewExtensionsKt.show((View)var15, this.getViewModel().getSupportedSensors().contains(SensorType.VOC));
         var15 = var4.contentHcho;
         Intrinsics.checkNotNullExpressionValue(var15, "contentHcho");
         ViewExtensionsKt.show((View)var15, this.getViewModel().getSupportedSensors().contains(SensorType.HCHO));
         Group var17 = var4.groupGases;
         Intrinsics.checkNotNullExpressionValue(var17, "groupGases");
         var18 = (View)var17;
         ConstraintLayout var6 = var4.contentTvoc;
         Intrinsics.checkNotNullExpressionValue(var6, "contentTvoc");
         if (((View)var6).getVisibility() != 0) {
            var6 = var4.contentHcho;
            Intrinsics.checkNotNullExpressionValue(var6, "contentHcho");
            if (((View)var6).getVisibility() != 0) {
               var3 = false;
               break label48;
            }
         }

         var3 = true;
      }

      ViewExtensionsKt.show(var18, var3);
      ConstraintLayout var7 = var4.contentPm1;
      ConstraintLayout var27 = var4.contentPm10;
      ConstraintLayout var8 = var4.contentPm25;
      int var1 = 0;

      while(true) {
         if (var1 >= 3) {
            Group var20 = var4.groupParticleHeader;
            Intrinsics.checkNotNullExpressionValue(var20, "groupParticleHeader");
            ViewExtensionsKt.hide((View)var20);
            var20 = var4.groupIndoorAir;
            Intrinsics.checkNotNullExpressionValue(var20, "groupIndoorAir");
            ViewExtensionsKt.hide((View)var20);
            TextView var22 = var4.contentTitleHum;
            Intrinsics.checkNotNullExpressionValue(var22, "contentTitleHum");
            View var23 = (View)var22;
            ViewGroup.LayoutParams var28 = var23.getLayoutParams();
            if (var28 == null) {
               throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }

            var28 = (ViewGroup.LayoutParams)((ViewGroup.MarginLayoutParams)var28);
            ((ViewGroup.MarginLayoutParams)var28).topMargin = 0;
            var23.setLayoutParams(var28);
            break;
         }

         ConstraintLayout var19 = (new ConstraintLayout[]{var7, var27, var8})[var1];
         Intrinsics.checkNotNull(var19);
         boolean var2;
         if (((View)var19).getVisibility() == 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         if (var2) {
            break;
         }

         ++var1;
      }

      double[] var24 = this.getViewModel().getIndoorAirRatings().getPm25Ranges();
      Collection var30 = (Collection)(new ArrayList(var24.length));
      int var10 = var24.length;

      for(int var9 = 0; var9 < var10; ++var9) {
         var30.add((int)var24[var9]);
      }

      List var25 = (List)var30;
      TextView var31 = var4.rangeExcellent;
      StringBuilder var36 = new StringBuilder("0-");
      var36.append(((Number)var25.get(0)).intValue());
      var31.setText((CharSequence)var36.toString());
      var31 = var4.rangeGood;
      var36 = new StringBuilder();
      var36.append(((Number)var25.get(0)).intValue() + 1);
      var36.append('-');
      var36.append(((Number)var25.get(1)).intValue());
      var31.setText((CharSequence)var36.toString());
      var31 = var4.rangeModerate;
      var36 = new StringBuilder();
      var36.append(((Number)var25.get(1)).intValue() + 1);
      var36.append('-');
      var36.append(((Number)var25.get(2)).intValue());
      var31.setText((CharSequence)var36.toString());
      TextView var39 = var4.rangePolluted;
      StringBuilder var34 = new StringBuilder();
      var34.append(((Number)var25.get(2)).intValue() + 1);
      var34.append('-');
      var34.append(((Number)var25.get(3)).intValue());
      var39.setText((CharSequence)var34.toString());
      TextView var35 = var4.rangeVpolluted;
      StringBuilder var40 = new StringBuilder();
      var40.append(((Number)var25.get(3)).intValue() + 1);
      var40.append('-');
      var40.append(((Number)var25.get(4)).intValue());
      var35.setText((CharSequence)var40.toString());
      var4.scrollView.post(new AboutAirQualityDialogFragment$$ExternalSyntheticLambda0(this, var4));
   }

   private static final void configureView$lambda$8$lambda$7(AboutAirQualityDialogFragment var0, DialogfragmentAboutAirQualityBinding var1) {
      SensorType var2 = var0.getViewModel().getSelectedSensor();
      View var3;
      switch (AboutAirQualityDialogFragment.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()]) {
         case 1:
            var3 = (View)var1.contentPm1;
            break;
         case 2:
            var3 = (View)var1.contentPm10;
            break;
         case 3:
            var3 = (View)var1.contentPm25;
            break;
         case 4:
            var3 = (View)var1.contentTitleHum;
            break;
         case 5:
            var3 = (View)var1.contentTvoc;
            break;
         case 6:
            var3 = (View)var1.contentHcho;
            break;
         default:
            var3 = null;
      }

      if (var3 != null) {
         var1.scrollView.scrollTo(0, var3.getTop());
      }

   }

   private static final void onCreateView$lambda$2$lambda$1(AboutAirQualityDialogFragment var0, View var1) {
      var0.dismiss();
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public DeviceSensorsViewModel getViewModel() {
      DeviceSensorsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setStyle(0, R.style.DialogTheme);
      Dialog var8 = this.getDialog();
      if (var8 != null) {
         Window var9 = var8.getWindow();
         if (var9 != null) {
            var9.setBackgroundDrawable((Drawable)(new ColorDrawable(0)));
            var9.setWindowAnimations(R.style.dialog_animation);
            var9.setGravity(80);
         }
      }

      BaseDialogFragment var10 = this;
      this.setViewModel((DeviceSensorsViewModel)((BaseViewModel)(new ViewModelProvider(CustomViewModelStoreOwner.Companion.getDEVICE_DETAILS())).get(DeviceSensorsViewModel.class)));
      DialogfragmentAboutAirQualityBinding var4 = DialogfragmentAboutAirQualityBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      var4.btnClose.setOnClickListener(new AboutAirQualityDialogFragment$$ExternalSyntheticLambda1(this));
      this.binding = var4;
      this.configureView();
      DialogfragmentAboutAirQualityBinding var7 = this.binding;
      var4 = var7;
      if (var7 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      FrameLayout var6 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var6, "getRoot(...)");
      return (View)var6;
   }

   public void onStart() {
      super.onStart();
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            var2.setLayout(-1, -1);
         }
      }

   }

   public void setViewModel(DeviceSensorsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/dialog/AboutAirQualityDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/AboutAirQualityDialogFragment;", "devicedetails_otherRelease"},
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

      public final AboutAirQualityDialogFragment newInstance() {
         return new AboutAirQualityDialogFragment();
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
         int[] var0 = new int[SensorType.values().length];

         try {
            var0[SensorType.PM1.ordinal()] = 1;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[SensorType.PM10.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[SensorType.PM25.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[SensorType.HUM.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SensorType.VOC.ordinal()] = 5;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SensorType.HCHO.ordinal()] = 6;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$0 = var0;
      }
   }
}
