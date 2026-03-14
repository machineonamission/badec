package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.RadioGroup;

public final class HolderDeviceMainModeDehumBinding implements ViewBinding {
   public final RadioGroup radioGroup;
   public final RadioButton rbDehum;
   public final RadioButton rbPurify;
   private final RadioGroup rootView;

   private HolderDeviceMainModeDehumBinding(RadioGroup var1, RadioGroup var2, RadioButton var3, RadioButton var4) {
      this.rootView = var1;
      this.radioGroup = var2;
      this.rbDehum = var3;
      this.rbPurify = var4;
   }

   public static HolderDeviceMainModeDehumBinding bind(View var0) {
      RadioGroup var3 = (RadioGroup)var0;
      int var1 = R.id.rb_dehum;
      RadioButton var4 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.rb_purify;
         RadioButton var2 = (RadioButton)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            return new HolderDeviceMainModeDehumBinding(var3, var3, var4, var2);
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static HolderDeviceMainModeDehumBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static HolderDeviceMainModeDehumBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.holder_device_main_mode_dehum, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public RadioGroup getRoot() {
      return this.rootView;
   }
}
