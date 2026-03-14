package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.databinding.FragmentClassicTroubleshootingBinding;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0017"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/ClassicTroubleShootingFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceBaseFragment;", "<init>", "()V", "binding", "Lcom/blueair/adddevice/databinding/FragmentClassicTroubleshootingBinding;", "radioButtons", "", "Landroid/widget/CompoundButton;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ClassicTroubleShootingFragment extends AddDeviceBaseFragment {
   private FragmentClassicTroubleshootingBinding binding;
   private Set radioButtons;

   // $FF: synthetic method
   public static void $r8$lambda$BHsmF35UrUUNDAGVxib1tHeS3Co(ClassicTroubleShootingFragment var0, FragmentClassicTroubleshootingBinding var1, CompoundButton var2, boolean var3) {
      onViewCreated$lambda$7$onCheckedChange(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   public static void $r8$lambda$SP08p3tybw_V98DOHeMiO5tLqR4(ClassicTroubleShootingFragment var0, FragmentClassicTroubleshootingBinding var1, View var2) {
      onViewCreated$lambda$7$lambda$6(var0, var1, var2);
   }

   private static final void onViewCreated$lambda$7$lambda$6(ClassicTroubleShootingFragment var0, FragmentClassicTroubleshootingBinding var1, View var2) {
      Set var4 = var0.radioButtons;
      Set var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("radioButtons");
         var6 = null;
      }

      Iterator var13 = ((Iterable)var6).iterator();

      do {
         if (!var13.hasNext()) {
            var7 = null;
            break;
         }

         var7 = var13.next();
      } while(!((CompoundButton)var7).isChecked());

      CompoundButton var8 = (CompoundButton)var7;
      Integer var9;
      if (var8 != null) {
         var9 = var8.getId();
      } else {
         var9 = null;
      }

      int var3 = var1.radioBtnWifiBlinking.getId();
      if (var9 != null && var9 == var3) {
         var0.getAddService().startManualConfigClassic();
      } else {
         var3 = var1.radioBtnWifiFading.getId();
         if (var9 != null && var9 == var3) {
            var0.getAddService().startManualConfigStep2Classic();
         } else {
            var3 = var1.radioBtnWifiFadingFast.getId();
            if (var9 != null && var9 == var3) {
               var0.getAddService().startAutoOrManualClassic();
            } else {
               var3 = var1.radioBtnWifiSolid.getId();
               if (var9 != null && var9 == var3) {
                  var0.getAddService().startActivateDeviceWifiClassic();
               } else {
                  TextView var5 = var1.txtError;
                  Intrinsics.checkNotNullExpressionValue(var5, "txtError");
                  ViewExtensionsKt.show$default((View)var5, false, 1, (Object)null);
               }
            }
         }
      }
   }

   private static final void onViewCreated$lambda$7$onCheckedChange(ClassicTroubleShootingFragment var0, FragmentClassicTroubleshootingBinding var1, CompoundButton var2, boolean var3) {
      Set var4 = var0.radioButtons;
      Set var6 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("radioButtons");
         var6 = null;
      }

      Iterable var11 = (Iterable)var6;
      Collection var7 = (Collection)(new ArrayList());

      for(Object var12 : var11) {
         if (((CompoundButton)var12).getId() != var2.getId() && var3) {
            var7.add(var12);
         }
      }

      Iterator var8 = ((Iterable)((List)var7)).iterator();

      while(var8.hasNext()) {
         ((CompoundButton)var8.next()).setChecked(false);
      }

      Unit var9 = Unit.INSTANCE;
      TextView var10 = var1.txtError;
      Intrinsics.checkNotNullExpressionValue(var10, "txtError");
      ViewExtensionsKt.hide((View)var10);
   }

   public ConstraintLayout getRootView() {
      return null;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      FragmentClassicTroubleshootingBinding var6 = FragmentClassicTroubleshootingBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
      this.binding = var6;
      FragmentClassicTroubleshootingBinding var4 = var6;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      View var5 = var4.getRoot();
      Intrinsics.checkNotNullExpressionValue(var5, "getRoot(...)");
      return var5;
   }

   public void onResume() {
      super.onResume();
      FragmentActivity var1 = this.getActivity();
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      ActionBar var3 = ((AppCompatActivity)var1).getSupportActionBar();
      if (var3 != null) {
         var3.setTitle((CharSequence)this.getString(R.string.troubleshooting));
      }

      Set var2 = this.radioButtons;
      Set var4 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("radioButtons");
         var4 = null;
      }

      Iterator var5 = ((Iterable)var4).iterator();

      while(var5.hasNext()) {
         ((CompoundButton)var5.next()).setChecked(false);
      }

   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      FragmentClassicTroubleshootingBinding var3 = this.binding;
      Object var13 = null;
      FragmentClassicTroubleshootingBinding var4 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var4 = null;
      }

      Drawable var5 = var4.imgWifiBlinking.getDrawable();
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      ((AnimationDrawable)var5).start();
      var3 = this.binding;
      FragmentClassicTroubleshootingBinding var6 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var6 = null;
      }

      Drawable var7 = var6.imgWifiFading.getDrawable();
      Intrinsics.checkNotNull(var7, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AnimationDrawable var8 = (AnimationDrawable)var7;
      var8.setEnterFadeDuration(2000);
      var8.setExitFadeDuration(2000);
      var8.start();
      var3 = this.binding;
      FragmentClassicTroubleshootingBinding var9 = var3;
      if (var3 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var9 = null;
      }

      Drawable var10 = var9.imgWifiFadingFast.getDrawable();
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
      AnimationDrawable var11 = (AnimationDrawable)var10;
      var11.setEnterFadeDuration(2000);
      var11.setExitFadeDuration(2000);
      var11.start();
      FragmentClassicTroubleshootingBinding var12 = this.binding;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("binding");
         var12 = (FragmentClassicTroubleshootingBinding)var13;
      }

      this.radioButtons = SetsKt.setOf(new RadioButton[]{var12.radioBtnWifiBlinking, var12.radioBtnWifiFading, var12.radioBtnWifiFadingFast, var12.radioBtnWifiSolid});
      var12.radioBtnWifiBlinking.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, var12));
      var12.radioBtnWifiFading.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, var12));
      var12.radioBtnWifiFadingFast.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, var12));
      var12.radioBtnWifiSolid.setOnCheckedChangeListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda0(this, var12));
      var12.btnNext.setOnClickListener(new ClassicTroubleShootingFragment$$ExternalSyntheticLambda1(this, var12));
   }
}
