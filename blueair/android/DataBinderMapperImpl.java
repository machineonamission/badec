package com.blueair.android;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.databinding.ActivityDevSettingsBindingImpl;
import com.blueair.android.databinding.ActivityGoogleAppFlipBindingImpl;
import com.blueair.android.databinding.ActivityHomeBindingImpl;
import com.blueair.android.databinding.ActivityInfoBindingImpl;
import com.blueair.android.databinding.ActivityInfoDetailBindingImpl;
import com.blueair.android.databinding.ActivityInfoListBindingImpl;
import com.blueair.android.databinding.ActivityNotificationsBindingImpl;
import com.blueair.android.databinding.DialogAqiIndexInfoBindingImpl;
import com.blueair.android.databinding.DialogNotificationCenterBindingImpl;
import com.blueair.android.databinding.DialogfragmentNotificationEditNumberBindingImpl;
import com.blueair.android.databinding.DialogfragmentSettingsBindingImpl;
import com.blueair.android.databinding.DialogfragmentSmartIntegrationsBindingImpl;
import com.blueair.android.databinding.FragmentIndoorBindingImpl;
import com.blueair.android.databinding.FragmentOutdoorBindingImpl;
import com.blueair.android.databinding.FragmentPoliciesBindingImpl;
import com.blueair.android.databinding.FragmentSmartIntegrationsBindingImpl;
import com.blueair.android.databinding.IntegrationItemBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
   private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
   private static final int LAYOUT_ACTIVITYDEVSETTINGS = 1;
   private static final int LAYOUT_ACTIVITYGOOGLEAPPFLIP = 2;
   private static final int LAYOUT_ACTIVITYHOME = 3;
   private static final int LAYOUT_ACTIVITYINFO = 4;
   private static final int LAYOUT_ACTIVITYINFODETAIL = 5;
   private static final int LAYOUT_ACTIVITYINFOLIST = 6;
   private static final int LAYOUT_ACTIVITYNOTIFICATIONS = 7;
   private static final int LAYOUT_DIALOGAQIINDEXINFO = 8;
   private static final int LAYOUT_DIALOGFRAGMENTNOTIFICATIONEDITNUMBER = 10;
   private static final int LAYOUT_DIALOGFRAGMENTSETTINGS = 11;
   private static final int LAYOUT_DIALOGFRAGMENTSMARTINTEGRATIONS = 12;
   private static final int LAYOUT_DIALOGNOTIFICATIONCENTER = 9;
   private static final int LAYOUT_FRAGMENTINDOOR = 13;
   private static final int LAYOUT_FRAGMENTOUTDOOR = 14;
   private static final int LAYOUT_FRAGMENTPOLICIES = 15;
   private static final int LAYOUT_FRAGMENTSMARTINTEGRATIONS = 16;
   private static final int LAYOUT_INTEGRATIONITEM = 17;

   static {
      SparseIntArray var0 = new SparseIntArray(17);
      INTERNAL_LAYOUT_ID_LOOKUP = var0;
      var0.put(R.layout.activity_dev_settings, 1);
      var0.put(R.layout.activity_google_app_flip, 2);
      var0.put(R.layout.activity_home, 3);
      var0.put(R.layout.activity_info, 4);
      var0.put(R.layout.activity_info_detail, 5);
      var0.put(R.layout.activity_info_list, 6);
      var0.put(R.layout.activity_notifications, 7);
      var0.put(R.layout.dialog_aqi_index_info, 8);
      var0.put(R.layout.dialog_notification_center, 9);
      var0.put(R.layout.dialogfragment_notification_edit_number, 10);
      var0.put(R.layout.dialogfragment_settings, 11);
      var0.put(R.layout.dialogfragment_smart_integrations, 12);
      var0.put(R.layout.fragment_indoor, 13);
      var0.put(R.layout.fragment_outdoor, 14);
      var0.put(R.layout.fragment_policies, 15);
      var0.put(R.layout.fragment_smart_integrations, 16);
      var0.put(R.layout.integration_item, 17);
   }

   public List collectDependencies() {
      ArrayList var1 = new ArrayList(17);
      var1.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
      var1.add(new com.airboxlab.icp.sdk.DataBinderMapperImpl());
      var1.add(new com.blueair.adddevice.DataBinderMapperImpl());
      var1.add(new com.blueair.antifake.DataBinderMapperImpl());
      var1.add(new com.blueair.api.DataBinderMapperImpl());
      var1.add(new com.blueair.auth.DataBinderMapperImpl());
      var1.add(new com.blueair.bluetooth.DataBinderMapperImpl());
      var1.add(new com.blueair.core.DataBinderMapperImpl());
      var1.add(new com.blueair.devicedetails.DataBinderMapperImpl());
      var1.add(new com.blueair.devicemanager.DataBinderMapperImpl());
      var1.add(new com.blueair.graph.DataBinderMapperImpl());
      var1.add(new com.blueair.login.DataBinderMapperImpl());
      var1.add(new com.blueair.outdoor.DataBinderMapperImpl());
      var1.add(new com.blueair.push.DataBinderMapperImpl());
      var1.add(new com.blueair.sdk.DataBinderMapperImpl());
      var1.add(new com.blueair.viewcore.DataBinderMapperImpl());
      var1.add(new com.github.mikephil.charting.DataBinderMapperImpl());
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
               if ("layout/activity_dev_settings_0".equals(var4)) {
                  return new ActivityDevSettingsBindingImpl(var1, var2);
               }

               StringBuilder var21 = new StringBuilder("The tag for activity_dev_settings is invalid. Received: ");
               var21.append(var4);
               throw new IllegalArgumentException(var21.toString());
            case 2:
               if ("layout/activity_google_app_flip_0".equals(var4)) {
                  return new ActivityGoogleAppFlipBindingImpl(var1, var2);
               }

               StringBuilder var20 = new StringBuilder("The tag for activity_google_app_flip is invalid. Received: ");
               var20.append(var4);
               throw new IllegalArgumentException(var20.toString());
            case 3:
               if ("layout/activity_home_0".equals(var4)) {
                  return new ActivityHomeBindingImpl(var1, var2);
               }

               StringBuilder var19 = new StringBuilder("The tag for activity_home is invalid. Received: ");
               var19.append(var4);
               throw new IllegalArgumentException(var19.toString());
            case 4:
               if ("layout/activity_info_0".equals(var4)) {
                  return new ActivityInfoBindingImpl(var1, var2);
               }

               StringBuilder var18 = new StringBuilder("The tag for activity_info is invalid. Received: ");
               var18.append(var4);
               throw new IllegalArgumentException(var18.toString());
            case 5:
               if ("layout/activity_info_detail_0".equals(var4)) {
                  return new ActivityInfoDetailBindingImpl(var1, var2);
               }

               StringBuilder var17 = new StringBuilder("The tag for activity_info_detail is invalid. Received: ");
               var17.append(var4);
               throw new IllegalArgumentException(var17.toString());
            case 6:
               if ("layout/activity_info_list_0".equals(var4)) {
                  return new ActivityInfoListBindingImpl(var1, var2);
               }

               StringBuilder var16 = new StringBuilder("The tag for activity_info_list is invalid. Received: ");
               var16.append(var4);
               throw new IllegalArgumentException(var16.toString());
            case 7:
               if ("layout/activity_notifications_0".equals(var4)) {
                  return new ActivityNotificationsBindingImpl(var1, var2);
               }

               StringBuilder var15 = new StringBuilder("The tag for activity_notifications is invalid. Received: ");
               var15.append(var4);
               throw new IllegalArgumentException(var15.toString());
            case 8:
               if ("layout/dialog_aqi_index_info_0".equals(var4)) {
                  return new DialogAqiIndexInfoBindingImpl(var1, var2);
               }

               StringBuilder var14 = new StringBuilder("The tag for dialog_aqi_index_info is invalid. Received: ");
               var14.append(var4);
               throw new IllegalArgumentException(var14.toString());
            case 9:
               if ("layout/dialog_notification_center_0".equals(var4)) {
                  return new DialogNotificationCenterBindingImpl(var1, var2);
               }

               StringBuilder var13 = new StringBuilder("The tag for dialog_notification_center is invalid. Received: ");
               var13.append(var4);
               throw new IllegalArgumentException(var13.toString());
            case 10:
               if ("layout/dialogfragment_notification_edit_number_0".equals(var4)) {
                  return new DialogfragmentNotificationEditNumberBindingImpl(var1, var2);
               }

               StringBuilder var12 = new StringBuilder("The tag for dialogfragment_notification_edit_number is invalid. Received: ");
               var12.append(var4);
               throw new IllegalArgumentException(var12.toString());
            case 11:
               if ("layout/dialogfragment_settings_0".equals(var4)) {
                  return new DialogfragmentSettingsBindingImpl(var1, var2);
               }

               StringBuilder var11 = new StringBuilder("The tag for dialogfragment_settings is invalid. Received: ");
               var11.append(var4);
               throw new IllegalArgumentException(var11.toString());
            case 12:
               if ("layout/dialogfragment_smart_integrations_0".equals(var4)) {
                  return new DialogfragmentSmartIntegrationsBindingImpl(var1, var2);
               }

               StringBuilder var10 = new StringBuilder("The tag for dialogfragment_smart_integrations is invalid. Received: ");
               var10.append(var4);
               throw new IllegalArgumentException(var10.toString());
            case 13:
               if ("layout/fragment_indoor_0".equals(var4)) {
                  return new FragmentIndoorBindingImpl(var1, var2);
               }

               StringBuilder var9 = new StringBuilder("The tag for fragment_indoor is invalid. Received: ");
               var9.append(var4);
               throw new IllegalArgumentException(var9.toString());
            case 14:
               if ("layout/fragment_outdoor_0".equals(var4)) {
                  return new FragmentOutdoorBindingImpl(var1, var2);
               }

               StringBuilder var8 = new StringBuilder("The tag for fragment_outdoor is invalid. Received: ");
               var8.append(var4);
               throw new IllegalArgumentException(var8.toString());
            case 15:
               if ("layout/fragment_policies_0".equals(var4)) {
                  return new FragmentPoliciesBindingImpl(var1, var2);
               }

               StringBuilder var7 = new StringBuilder("The tag for fragment_policies is invalid. Received: ");
               var7.append(var4);
               throw new IllegalArgumentException(var7.toString());
            case 16:
               if ("layout/fragment_smart_integrations_0".equals(var4)) {
                  return new FragmentSmartIntegrationsBindingImpl(var1, var2);
               }

               StringBuilder var6 = new StringBuilder("The tag for fragment_smart_integrations is invalid. Received: ");
               var6.append(var4);
               throw new IllegalArgumentException(var6.toString());
            case 17:
               if ("layout/integration_item_0".equals(var4)) {
                  return new IntegrationItemBindingImpl(var1, var2);
               }

               StringBuilder var5 = new StringBuilder("The tag for integration_item is invalid. Received: ");
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
         SparseArray var0 = new SparseArray(12);
         sKeys = var0;
         var0.put(0, "_all");
         var0.put(1, "addDeviceViewModel");
         var0.put(2, "deviceCreateEditScheduleViewModel");
         var0.put(3, "deviceDetailViewModel");
         var0.put(4, "deviceDetailsViewModel");
         var0.put(5, "deviceSchedulesViewModel");
         var0.put(6, "deviceSensorViewModel");
         var0.put(7, "homeViewModel");
         var0.put(8, "indoorViewModel");
         var0.put(9, "outdoorViewModel");
         var0.put(10, "viewModel");
         var0.put(11, "vm");
      }
   }

   private static class InnerLayoutIdLookup {
      static final HashMap sKeys;

      static {
         HashMap var0 = new HashMap(17);
         sKeys = var0;
         var0.put("layout/activity_dev_settings_0", R.layout.activity_dev_settings);
         var0.put("layout/activity_google_app_flip_0", R.layout.activity_google_app_flip);
         var0.put("layout/activity_home_0", R.layout.activity_home);
         var0.put("layout/activity_info_0", R.layout.activity_info);
         var0.put("layout/activity_info_detail_0", R.layout.activity_info_detail);
         var0.put("layout/activity_info_list_0", R.layout.activity_info_list);
         var0.put("layout/activity_notifications_0", R.layout.activity_notifications);
         var0.put("layout/dialog_aqi_index_info_0", R.layout.dialog_aqi_index_info);
         var0.put("layout/dialog_notification_center_0", R.layout.dialog_notification_center);
         var0.put("layout/dialogfragment_notification_edit_number_0", R.layout.dialogfragment_notification_edit_number);
         var0.put("layout/dialogfragment_settings_0", R.layout.dialogfragment_settings);
         var0.put("layout/dialogfragment_smart_integrations_0", R.layout.dialogfragment_smart_integrations);
         var0.put("layout/fragment_indoor_0", R.layout.fragment_indoor);
         var0.put("layout/fragment_outdoor_0", R.layout.fragment_outdoor);
         var0.put("layout/fragment_policies_0", R.layout.fragment_policies);
         var0.put("layout/fragment_smart_integrations_0", R.layout.fragment_smart_integrations);
         var0.put("layout/integration_item_0", R.layout.integration_item);
      }
   }
}
