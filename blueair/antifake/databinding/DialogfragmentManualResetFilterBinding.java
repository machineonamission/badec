package com.blueair.antifake.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.blueair.antifake.R;
import com.google.android.material.button.MaterialButton;
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public final class DialogfragmentManualResetFilterBinding implements ViewBinding {
   public final ImageButton btnBack;
   public final MaterialButton btnConfirm;
   public final TextView contentTitle;
   public final TextView customerSupportText;
   public final ScrollingPagerIndicator pageDots;
   public final ViewPager2 pager;
   private final LinearLayout rootView;
   public final TextView title;

   private DialogfragmentManualResetFilterBinding(LinearLayout var1, ImageButton var2, MaterialButton var3, TextView var4, TextView var5, ScrollingPagerIndicator var6, ViewPager2 var7, TextView var8) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnConfirm = var3;
      this.contentTitle = var4;
      this.customerSupportText = var5;
      this.pageDots = var6;
      this.pager = var7;
      this.title = var8;
   }

   public static DialogfragmentManualResetFilterBinding bind(View var0) {
      int var1 = R.id.btn_back;
      ImageButton var2 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var2 != null) {
         var1 = R.id.btn_confirm;
         MaterialButton var5 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var5 != null) {
            var1 = R.id.content_title;
            TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var8 != null) {
               var1 = R.id.customer_support_text;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.page_dots;
                  ScrollingPagerIndicator var7 = (ScrollingPagerIndicator)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.pager;
                     ViewPager2 var3 = (ViewPager2)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        var1 = R.id.title;
                        TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var4 != null) {
                           return new DialogfragmentManualResetFilterBinding((LinearLayout)var0, var2, var5, var8, var6, var7, var3, var4);
                        }
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentManualResetFilterBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentManualResetFilterBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_manual_reset_filter, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
