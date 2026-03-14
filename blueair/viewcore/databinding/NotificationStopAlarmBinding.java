package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;

public final class NotificationStopAlarmBinding implements ViewBinding {
   public final TextView body;
   public final Button btnStop;
   private final LinearLayout rootView;
   public final TextView title;

   private NotificationStopAlarmBinding(LinearLayout var1, TextView var2, Button var3, TextView var4) {
      this.rootView = var1;
      this.body = var2;
      this.btnStop = var3;
      this.title = var4;
   }

   public static NotificationStopAlarmBinding bind(View var0) {
      int var1 = R.id.body;
      TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.btn_stop;
         Button var4 = (Button)ViewBindings.findChildViewById(var0, var1);
         if (var4 != null) {
            var1 = R.id.title;
            TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var2 != null) {
               return new NotificationStopAlarmBinding((LinearLayout)var0, var3, var4, var2);
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static NotificationStopAlarmBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static NotificationStopAlarmBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.notification_stop_alarm, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public LinearLayout getRoot() {
      return this.rootView;
   }
}
