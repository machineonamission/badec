package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class DialogConnectionTipsBinding implements ViewBinding {
   public final Guideline bottomGuideline;
   public final MaterialButton confirmButton;
   public final TextView contentText1;
   public final TextView contentText2;
   public final TextView contentText3;
   public final TextView contentText4;
   public final TextView contentText5;
   public final ImageView dot1;
   public final ImageView dot2;
   public final ImageView dot3;
   public final ImageView dot4;
   public final ImageView dot5;
   public final Guideline endGuideline;
   private final ConstraintLayout rootView;
   public final Guideline startGuideline;
   public final TextView title;
   public final Guideline topGuideline;

   private DialogConnectionTipsBinding(ConstraintLayout var1, Guideline var2, MaterialButton var3, TextView var4, TextView var5, TextView var6, TextView var7, TextView var8, ImageView var9, ImageView var10, ImageView var11, ImageView var12, ImageView var13, Guideline var14, Guideline var15, TextView var16, Guideline var17) {
      this.rootView = var1;
      this.bottomGuideline = var2;
      this.confirmButton = var3;
      this.contentText1 = var4;
      this.contentText2 = var5;
      this.contentText3 = var6;
      this.contentText4 = var7;
      this.contentText5 = var8;
      this.dot1 = var9;
      this.dot2 = var10;
      this.dot3 = var11;
      this.dot4 = var12;
      this.dot5 = var13;
      this.endGuideline = var14;
      this.startGuideline = var15;
      this.title = var16;
      this.topGuideline = var17;
   }

   public static DialogConnectionTipsBinding bind(View var0) {
      int var1 = R.id.bottom_guideline;
      Guideline var2 = (Guideline)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.confirm_button;
         MaterialButton var9 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var9 != null) {
            var1 = R.id.content_text1;
            TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var8 != null) {
               var1 = R.id.content_text2;
               TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var14 != null) {
                  var1 = R.id.content_text3;
                  TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var13 != null) {
                     var1 = R.id.content_text4;
                     TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var16 != null) {
                        var1 = R.id.content_text5;
                        TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var15 != null) {
                           var1 = R.id.dot_1;
                           ImageView var17 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                           if (var17 != null) {
                              var1 = R.id.dot_2;
                              ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                              if (var10 != null) {
                                 var1 = R.id.dot_3;
                                 ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                 if (var4 != null) {
                                    var1 = R.id.dot_4;
                                    ImageView var12 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                    if (var12 != null) {
                                       var1 = R.id.dot_5;
                                       ImageView var3 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                       if (var3 != null) {
                                          var1 = R.id.end_guideline;
                                          Guideline var11 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                          if (var11 != null) {
                                             var1 = R.id.start_guideline;
                                             Guideline var5 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                             if (var5 != null) {
                                                var1 = R.id.title;
                                                TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var7 != null) {
                                                   var1 = R.id.top_guideline;
                                                   Guideline var6 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                                                   if (var6 != null) {
                                                      return new DialogConnectionTipsBinding((ConstraintLayout)var0, var2, var9, var8, var14, var13, var16, var15, var17, var10, var4, var12, var3, var11, var5, var7, var6);
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
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

   public static DialogConnectionTipsBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogConnectionTipsBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialog_connection_tips, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
