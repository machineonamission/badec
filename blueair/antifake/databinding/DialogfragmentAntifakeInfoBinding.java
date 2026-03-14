package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;

public final class DialogfragmentAntifakeInfoBinding implements ViewBinding {
   public final ImageButton closeBtn;
   private final LinearLayout rootView;
   public final NestedScrollView scrollable;
   public final TextView title;
   public final ConstraintLayout titleBar;

   private DialogfragmentAntifakeInfoBinding(LinearLayout var1, ImageButton var2, NestedScrollView var3, TextView var4, ConstraintLayout var5) {
      this.rootView = var1;
      this.closeBtn = var2;
      this.scrollable = var3;
      this.title = var4;
      this.titleBar = var5;
   }

   public static DialogfragmentAntifakeInfoBinding bind(View var0) {
      int var1 = R.id.close_btn;
      ImageButton var4 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.scrollable;
         NestedScrollView var2 = (NestedScrollView)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.title;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.title_bar;
               ConstraintLayout var3 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
               if (var3 != null) {
                  return new DialogfragmentAntifakeInfoBinding((LinearLayout)var0, var4, var2, var5, var3);
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentAntifakeInfoBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentAntifakeInfoBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_antifake_info, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
