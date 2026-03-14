package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class HolderSearchPlaceBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final TextView description;
   public final ImageButton imageButton;
   public final ImageView locationIcon;
   private final ConstraintLayout rootView;
   public final TextView title;
   public final Guideline topGuideline;

   private HolderSearchPlaceBinding(ConstraintLayout var1, Guideline var2, TextView var3, ImageButton var4, ImageView var5, TextView var6, Guideline var7) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.description = var3;
      this.imageButton = var4;
      this.locationIcon = var5;
      this.title = var6;
      this.topGuideline = var7;
   }

   public static HolderSearchPlaceBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.description;
         TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var6 != null) {
            var1 = R.id.imageButton;
            ImageButton var2 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               var1 = R.id.location_icon;
               ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  var1 = R.id.title;
                  TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var4 != null) {
                     var1 = R.id.top_guideline;
                     Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        return new HolderSearchPlaceBinding((ConstraintLayout)var0, var7, var6, var2, var3, var4, var5);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderSearchPlaceBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderSearchPlaceBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_search_place, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
