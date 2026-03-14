package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentWhExploreBinding implements ViewBinding {
   public final MaterialButton buttonNeverShow;
   public final MaterialButton buttonProceed;
   public final MaterialButton buttonTryLater;
   public final ImageView imClose;
   public final ImageView imWelcomeHome;
   private final LinearLayout rootView;

   private DialogfragmentWhExploreBinding(LinearLayout var1, MaterialButton var2, MaterialButton var3, MaterialButton var4, ImageView var5, ImageView var6) {
      this.rootView = var1;
      this.buttonNeverShow = var2;
      this.buttonProceed = var3;
      this.buttonTryLater = var4;
      this.imClose = var5;
      this.imWelcomeHome = var6;
   }

   public static DialogfragmentWhExploreBinding bind(View var0) {
      int var1 = R.id.buttonNeverShow;
      MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
      if (var6 != null) {
         var1 = R.id.buttonProceed;
         MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.buttonTryLater;
            MaterialButton var3 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var3 != null) {
               var1 = R.id.imClose;
               ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
               if (var2 != null) {
                  var1 = R.id.imWelcomeHome;
                  ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                  if (var5 != null) {
                     return new DialogfragmentWhExploreBinding((LinearLayout)var0, var6, var4, var3, var2, var5);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentWhExploreBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentWhExploreBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_wh_explore, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
