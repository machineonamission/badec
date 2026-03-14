package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;

public final class SimpleTextWithFamilyWeight500Binding implements ViewBinding {
   private final AppCompatTextView rootView;
   public final AppCompatTextView tvText;

   private SimpleTextWithFamilyWeight500Binding(AppCompatTextView var1, AppCompatTextView var2) {
      this.rootView = var1;
      this.tvText = var2;
   }

   public static SimpleTextWithFamilyWeight500Binding bind(View var0) {
      if (var0 != null) {
         AppCompatTextView var1 = (AppCompatTextView)var0;
         return new SimpleTextWithFamilyWeight500Binding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static SimpleTextWithFamilyWeight500Binding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static SimpleTextWithFamilyWeight500Binding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.simple_text_with_family_weight500, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public AppCompatTextView getRoot() {
      return this.rootView;
   }
}
