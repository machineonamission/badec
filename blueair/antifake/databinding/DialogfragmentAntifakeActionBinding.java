package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.antifake.R;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentAntifakeActionBinding implements ViewBinding {
   public final ImageButton backBtn;
   public final LinearLayout contentContainer;
   private final FrameLayout rootView;
   public final MaterialButton scanBtn;
   public final TextView title;
   public final FrameLayout titleBar;

   private DialogfragmentAntifakeActionBinding(FrameLayout var1, ImageButton var2, LinearLayout var3, MaterialButton var4, TextView var5, FrameLayout var6) {
      this.rootView = var1;
      this.backBtn = var2;
      this.contentContainer = var3;
      this.scanBtn = var4;
      this.title = var5;
      this.titleBar = var6;
   }

   public static DialogfragmentAntifakeActionBinding bind(View var0) {
      int var1 = R.id.back_btn;
      ImageButton var3 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.content_container;
         LinearLayout var5 = (LinearLayout)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.scan_btn;
            MaterialButton var6 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.title;
               TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.title_bar;
                  FrameLayout var2 = (FrameLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var2 != null) {
                     return new DialogfragmentAntifakeActionBinding((FrameLayout)var0, var3, var5, var6, var4, var2);
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentAntifakeActionBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentAntifakeActionBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_antifake_action, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
