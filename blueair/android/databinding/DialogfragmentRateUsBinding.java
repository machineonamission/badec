package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentRateUsBinding implements ViewBinding {
   public final MaterialButton buttonImproveNegative;
   public final MaterialButton buttonImprovePositive;
   public final MaterialButton buttonRateCancel;
   public final MaterialButton buttonRateRedirect;
   public final ImageView imClose;
   public final ImageView imRateUs;
   private final ScrollView rootView;
   public final ScrollView scrollable;
   public final TextView textDescription;
   public final LinearLayout viewHelpUsImprove;
   public final LinearLayout viewRateUs;

   private DialogfragmentRateUsBinding(ScrollView var1, MaterialButton var2, MaterialButton var3, MaterialButton var4, MaterialButton var5, ImageView var6, ImageView var7, ScrollView var8, TextView var9, LinearLayout var10, LinearLayout var11) {
      this.rootView = var1;
      this.buttonImproveNegative = var2;
      this.buttonImprovePositive = var3;
      this.buttonRateCancel = var4;
      this.buttonRateRedirect = var5;
      this.imClose = var6;
      this.imRateUs = var7;
      this.scrollable = var8;
      this.textDescription = var9;
      this.viewHelpUsImprove = var10;
      this.viewRateUs = var11;
   }

   public static DialogfragmentRateUsBinding bind(View var0) {
      int var1 = R.id.buttonImproveNegative;
      MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.buttonImprovePositive;
         MaterialButton var11 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var11 != null) {
            var1 = R.id.buttonRateCancel;
            MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.buttonRateRedirect;
               MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  var1 = R.id.imClose;
                  ImageView var7 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.imRateUs;
                     ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                     if (var2 != null) {
                        ScrollView var9 = (ScrollView)var0;
                        var1 = R.id.textDescription;
                        TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var5 != null) {
                           var1 = R.id.viewHelpUsImprove;
                           LinearLayout var10 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                           if (var10 != null) {
                              var1 = R.id.viewRateUs;
                              LinearLayout var4 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 return new DialogfragmentRateUsBinding(var9, var3, var11, var6, var8, var7, var2, var9, var5, var10, var4);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentRateUsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentRateUsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_rate_us, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ScrollView getRoot() {
      return this.rootView;
   }
}
