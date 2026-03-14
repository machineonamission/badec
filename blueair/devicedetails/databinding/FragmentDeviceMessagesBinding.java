package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;

public final class FragmentDeviceMessagesBinding implements ViewBinding {
   public final RecyclerView messageList;
   private final RecyclerView rootView;

   private FragmentDeviceMessagesBinding(RecyclerView var1, RecyclerView var2) {
      this.rootView = var1;
      this.messageList = var2;
   }

   public static FragmentDeviceMessagesBinding bind(View var0) {
      if (var0 != null) {
         RecyclerView var1 = (RecyclerView)var0;
         return new FragmentDeviceMessagesBinding(var1, var1);
      } else {
         throw new NullPointerException("rootView");
      }
   }

   public static FragmentDeviceMessagesBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentDeviceMessagesBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_device_messages, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public RecyclerView getRoot() {
      return this.rootView;
   }
}
