package com.blueair.adddevice.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.adddevice.R;
import com.google.android.material.button.MaterialButton;

public final class FragmentAddDeviceManualUserValidateClassicBinding implements ViewBinding {
   public final ImageView bgCountdown;
   public final MaterialButton buttonNo;
   public final MaterialButton buttonYes;
   public final Group groupButtons;
   public final ConstraintLayout rootLayout;
   private final ScrollView rootView;
   public final ScrollView scrollable;
   public final TextView textAddDeviceSubtitle;
   public final TextView textAddDeviceSubtitleThree;
   public final TextView textAddDeviceSubtitleTwo;
   public final TextView textAddDeviceTitle;
   public final TextView txtCountdown;

   private FragmentAddDeviceManualUserValidateClassicBinding(ScrollView var1, ImageView var2, MaterialButton var3, MaterialButton var4, Group var5, ConstraintLayout var6, ScrollView var7, TextView var8, TextView var9, TextView var10, TextView var11, TextView var12) {
      this.rootView = var1;
      this.bgCountdown = var2;
      this.buttonNo = var3;
      this.buttonYes = var4;
      this.groupButtons = var5;
      this.rootLayout = var6;
      this.scrollable = var7;
      this.textAddDeviceSubtitle = var8;
      this.textAddDeviceSubtitleThree = var9;
      this.textAddDeviceSubtitleTwo = var10;
      this.textAddDeviceTitle = var11;
      this.txtCountdown = var12;
   }

   public static FragmentAddDeviceManualUserValidateClassicBinding bind(View var0) {
      int var1 = R.id.bgCountdown;
      ImageView var5 = (ImageView)ViewBindings.findChildViewById(var0, var1);
      if (var5 != null) {
         var1 = R.id.buttonNo;
         MaterialButton var10 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var10 != null) {
            var1 = R.id.buttonYes;
            MaterialButton var12 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var12 != null) {
               var1 = R.id.group_buttons;
               Group var8 = (Group)ViewBindings.findChildViewById(var0, var1);
               if (var8 != null) {
                  var1 = R.id.rootLayout;
                  ConstraintLayout var6 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     ScrollView var2 = (ScrollView)var0;
                     var1 = R.id.textAddDeviceSubtitle;
                     TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var3 != null) {
                        var1 = R.id.textAddDeviceSubtitleThree;
                        TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var7 != null) {
                           var1 = R.id.textAddDeviceSubtitleTwo;
                           TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var9 != null) {
                              var1 = R.id.textAddDeviceTitle;
                              TextView var4 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var4 != null) {
                                 var1 = R.id.txtCountdown;
                                 TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var11 != null) {
                                    return new FragmentAddDeviceManualUserValidateClassicBinding(var2, var5, var10, var12, var8, var6, var2, var3, var7, var9, var4, var11);
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

   public static FragmentAddDeviceManualUserValidateClassicBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentAddDeviceManualUserValidateClassicBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_add_device_manual_user_validate_classic, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ScrollView getRoot() {
      return this.rootView;
   }
}
