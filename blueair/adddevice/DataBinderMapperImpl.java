package com.blueair.adddevice;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.adddevice.databinding.ActivityAddDeviceBindingImpl;
import com.blueair.adddevice.databinding.FragmentAddDeviceSuccessBindingImpl;
import com.blueair.adddevice.databinding.FragmentAddDeviceWifiBindingImpl;
import com.blueair.adddevice.databinding.FragmentBluetoothScanningBindingImpl;
import com.blueair.adddevice.databinding.FragmentClassicTroubleshootingBindingImpl;
import com.blueair.adddevice.databinding.FragmentEnterDeviceNameBindingImpl;
import com.blueair.adddevice.databinding.FragmentWifiPasswordBindingImpl;
import com.blueair.adddevice.databinding.HolderSsidHiddenBindingImpl;
import com.blueair.adddevice.databinding.HolderSsidRegularBindingImpl;
import com.blueair.adddevice.databinding.ViewcoreAppbarBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
   private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
   private static final int LAYOUT_ACTIVITYADDDEVICE = 1;
   private static final int LAYOUT_FRAGMENTADDDEVICESUCCESS = 2;
   private static final int LAYOUT_FRAGMENTADDDEVICEWIFI = 3;
   private static final int LAYOUT_FRAGMENTBLUETOOTHSCANNING = 4;
   private static final int LAYOUT_FRAGMENTCLASSICTROUBLESHOOTING = 5;
   private static final int LAYOUT_FRAGMENTENTERDEVICENAME = 6;
   private static final int LAYOUT_FRAGMENTWIFIPASSWORD = 7;
   private static final int LAYOUT_HOLDERSSIDHIDDEN = 8;
   private static final int LAYOUT_HOLDERSSIDREGULAR = 9;
   private static final int LAYOUT_VIEWCOREAPPBAR = 10;

   static {
      SparseIntArray var0 = new SparseIntArray(10);
      INTERNAL_LAYOUT_ID_LOOKUP = var0;
      var0.put(R.layout.activity_add_device, 1);
      var0.put(R.layout.fragment_add_device_success, 2);
      var0.put(R.layout.fragment_add_device_wifi, 3);
      var0.put(R.layout.fragment_bluetooth_scanning, 4);
      var0.put(R.layout.fragment_classic_troubleshooting, 5);
      var0.put(R.layout.fragment_enter_device_name, 6);
      var0.put(R.layout.fragment_wifi_password, 7);
      var0.put(R.layout.holder_ssid_hidden, 8);
      var0.put(R.layout.holder_ssid_regular, 9);
      var0.put(R.layout.viewcore_appbar, 10);
   }

   public List collectDependencies() {
      ArrayList var1 = new ArrayList(9);
      var1.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
      var1.add(new com.airboxlab.icp.sdk.DataBinderMapperImpl());
      var1.add(new com.blueair.api.DataBinderMapperImpl());
      var1.add(new com.blueair.auth.DataBinderMapperImpl());
      var1.add(new com.blueair.bluetooth.DataBinderMapperImpl());
      var1.add(new com.blueair.core.DataBinderMapperImpl());
      var1.add(new com.blueair.devicemanager.DataBinderMapperImpl());
      var1.add(new com.blueair.sdk.DataBinderMapperImpl());
      var1.add(new com.blueair.viewcore.DataBinderMapperImpl());
      return var1;
   }

   public String convertBrIdToString(int var1) {
      return (String)DataBinderMapperImpl.InnerBrLookup.sKeys.get(var1);
   }

   public ViewDataBinding getDataBinder(DataBindingComponent var1, View var2, int var3) {
      var3 = INTERNAL_LAYOUT_ID_LOOKUP.get(var3);
      if (var3 > 0) {
         Object var4 = var2.getTag();
         if (var4 == null) {
            throw new RuntimeException("view must have a tag");
         }

         switch (var3) {
            case 1:
               if ("layout/activity_add_device_0".equals(var4)) {
                  return new ActivityAddDeviceBindingImpl(var1, var2);
               }

               StringBuilder var14 = new StringBuilder("The tag for activity_add_device is invalid. Received: ");
               var14.append(var4);
               throw new IllegalArgumentException(var14.toString());
            case 2:
               if ("layout/fragment_add_device_success_0".equals(var4)) {
                  return new FragmentAddDeviceSuccessBindingImpl(var1, var2);
               }

               StringBuilder var13 = new StringBuilder("The tag for fragment_add_device_success is invalid. Received: ");
               var13.append(var4);
               throw new IllegalArgumentException(var13.toString());
            case 3:
               if ("layout/fragment_add_device_wifi_0".equals(var4)) {
                  return new FragmentAddDeviceWifiBindingImpl(var1, var2);
               }

               StringBuilder var12 = new StringBuilder("The tag for fragment_add_device_wifi is invalid. Received: ");
               var12.append(var4);
               throw new IllegalArgumentException(var12.toString());
            case 4:
               if ("layout/fragment_bluetooth_scanning_0".equals(var4)) {
                  return new FragmentBluetoothScanningBindingImpl(var1, var2);
               }

               StringBuilder var11 = new StringBuilder("The tag for fragment_bluetooth_scanning is invalid. Received: ");
               var11.append(var4);
               throw new IllegalArgumentException(var11.toString());
            case 5:
               if ("layout/fragment_classic_troubleshooting_0".equals(var4)) {
                  return new FragmentClassicTroubleshootingBindingImpl(var1, var2);
               }

               StringBuilder var10 = new StringBuilder("The tag for fragment_classic_troubleshooting is invalid. Received: ");
               var10.append(var4);
               throw new IllegalArgumentException(var10.toString());
            case 6:
               if ("layout/fragment_enter_device_name_0".equals(var4)) {
                  return new FragmentEnterDeviceNameBindingImpl(var1, var2);
               }

               StringBuilder var9 = new StringBuilder("The tag for fragment_enter_device_name is invalid. Received: ");
               var9.append(var4);
               throw new IllegalArgumentException(var9.toString());
            case 7:
               if ("layout/fragment_wifi_password_0".equals(var4)) {
                  return new FragmentWifiPasswordBindingImpl(var1, var2);
               }

               StringBuilder var8 = new StringBuilder("The tag for fragment_wifi_password is invalid. Received: ");
               var8.append(var4);
               throw new IllegalArgumentException(var8.toString());
            case 8:
               if ("layout/holder_ssid_hidden_0".equals(var4)) {
                  return new HolderSsidHiddenBindingImpl(var1, var2);
               }

               StringBuilder var7 = new StringBuilder("The tag for holder_ssid_hidden is invalid. Received: ");
               var7.append(var4);
               throw new IllegalArgumentException(var7.toString());
            case 9:
               if ("layout/holder_ssid_regular_0".equals(var4)) {
                  return new HolderSsidRegularBindingImpl(var1, var2);
               }

               StringBuilder var6 = new StringBuilder("The tag for holder_ssid_regular is invalid. Received: ");
               var6.append(var4);
               throw new IllegalArgumentException(var6.toString());
            case 10:
               if ("layout/viewcore_appbar_0".equals(var4)) {
                  return new ViewcoreAppbarBindingImpl(var1, var2);
               }

               StringBuilder var5 = new StringBuilder("The tag for viewcore_appbar is invalid. Received: ");
               var5.append(var4);
               throw new IllegalArgumentException(var5.toString());
         }
      }

      return null;
   }

   public ViewDataBinding getDataBinder(DataBindingComponent var1, View[] var2, int var3) {
      if (var2 != null && var2.length != 0 && INTERNAL_LAYOUT_ID_LOOKUP.get(var3) > 0 && var2[0].getTag() == null) {
         throw new RuntimeException("view must have a tag");
      } else {
         return null;
      }
   }

   public int getLayoutId(String var1) {
      if (var1 == null) {
         return 0;
      } else {
         Integer var2 = (Integer)DataBinderMapperImpl.InnerLayoutIdLookup.sKeys.get(var1);
         return var2 == null ? 0 : var2;
      }
   }

   private static class InnerBrLookup {
      static final SparseArray sKeys;

      static {
         SparseArray var0 = new SparseArray(2);
         sKeys = var0;
         var0.put(0, "_all");
         var0.put(1, "addDeviceViewModel");
      }
   }

   private static class InnerLayoutIdLookup {
      static final HashMap sKeys;

      static {
         HashMap var0 = new HashMap(10);
         sKeys = var0;
         var0.put("layout/activity_add_device_0", R.layout.activity_add_device);
         var0.put("layout/fragment_add_device_success_0", R.layout.fragment_add_device_success);
         var0.put("layout/fragment_add_device_wifi_0", R.layout.fragment_add_device_wifi);
         var0.put("layout/fragment_bluetooth_scanning_0", R.layout.fragment_bluetooth_scanning);
         var0.put("layout/fragment_classic_troubleshooting_0", R.layout.fragment_classic_troubleshooting);
         var0.put("layout/fragment_enter_device_name_0", R.layout.fragment_enter_device_name);
         var0.put("layout/fragment_wifi_password_0", R.layout.fragment_wifi_password);
         var0.put("layout/holder_ssid_hidden_0", R.layout.holder_ssid_hidden);
         var0.put("layout/holder_ssid_regular_0", R.layout.holder_ssid_regular);
         var0.put("layout/viewcore_appbar_0", R.layout.viewcore_appbar);
      }
   }
}
