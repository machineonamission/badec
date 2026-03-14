package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.blueair.devicedetails.view.ButtonTileConstraintLayout;

public final class HolderSimpleInfoBinding implements ViewBinding {
   public final Guideline leftGuideline;
   public final ButtonTileConstraintLayout regularSettingLayout;
   public final Guideline rightGuideline;
   private final ButtonTileConstraintLayout rootView;
   public final AppCompatImageView settingArrow;
   public final TextView tvTitle;

   private HolderSimpleInfoBinding(ButtonTileConstraintLayout var1, Guideline var2, ButtonTileConstraintLayout var3, Guideline var4, AppCompatImageView var5, TextView var6) {
      this.rootView = var1;
      this.leftGuideline = var2;
      this.regularSettingLayout = var3;
      this.rightGuideline = var4;
      this.settingArrow = var5;
      this.tvTitle = var6;
   }

   public static HolderSimpleInfoBinding bind(View var0) {
      int var1 = R.id.left_guideline;
      Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         ButtonTileConstraintLayout var6 = (ButtonTileConstraintLayout)var0;
         var1 = R.id.right_guideline;
         Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.setting_arrow;
            AppCompatImageView var4 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.tv_title;
               TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  return new HolderSimpleInfoBinding(var6, var3, var6, var5, var4, var2);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderSimpleInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderSimpleInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_simple_info, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ButtonTileConstraintLayout getRoot() {
      return this.rootView;
   }
}
