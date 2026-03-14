package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class QualityStatusViewBinding implements ViewBinding {
   public final ImageView qualityStatusImage;
   public final TextView qualityTitle;
   public final TextView qualityValue;
   private final LinearLayout rootView;

   private QualityStatusViewBinding(LinearLayout var1, ImageView var2, TextView var3, TextView var4) {
      this.rootView = var1;
      this.qualityStatusImage = var2;
      this.qualityTitle = var3;
      this.qualityValue = var4;
   }

   public static QualityStatusViewBinding bind(View var0) {
      int var1 = R.id.quality_status_image;
      ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.quality_title;
         TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.quality_value;
            TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               return new QualityStatusViewBinding((LinearLayout)var0, var3, var2, var4);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static QualityStatusViewBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static QualityStatusViewBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.quality_status_view, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
