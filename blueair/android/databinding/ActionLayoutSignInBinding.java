package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.viewbinding.ViewBinding;
import com.blueair.android.R;

public final class ActionLayoutSignInBinding implements ViewBinding {
   private final Button rootView;

   private ActionLayoutSignInBinding(Button var1) {
      this.rootView = var1;
   }

   public static ActionLayoutSignInBinding bind(View var0) {
      if (var0 != null) {
         return new ActionLayoutSignInBinding((Button)var0);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static ActionLayoutSignInBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActionLayoutSignInBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.action_layout_sign_in, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public Button getRoot() {
      return this.rootView;
   }
}
