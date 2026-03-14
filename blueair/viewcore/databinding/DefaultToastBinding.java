package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.viewcore.R;

public final class DefaultToastBinding implements ViewBinding {
   private final TextView rootView;

   private DefaultToastBinding(TextView var1) {
      this.rootView = var1;
   }

   public static DefaultToastBinding bind(View var0) {
      if (var0 != null) {
         return new DefaultToastBinding((TextView)var0);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static DefaultToastBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DefaultToastBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.default_toast, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public TextView getRoot() {
      return this.rootView;
   }
}
