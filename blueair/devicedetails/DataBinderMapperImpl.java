package com.blueair.devicedetails;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.databinding.ActivityCustomInputBindingImpl;
import com.blueair.devicedetails.databinding.ActivityDeviceDetailsBindingImpl;
import com.blueair.devicedetails.databinding.ActivityDeviceFilterDetailBindingImpl;
import com.blueair.devicedetails.databinding.ActivityDeviceReplaceFilterBindingImpl;
import com.blueair.devicedetails.databinding.ActivityDevicesAlarmListBindingImpl;
import com.blueair.devicedetails.databinding.ActivityScheduleListBindingImpl;
import com.blueair.devicedetails.databinding.ActivityWelcomeHomeConfigBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentBuyFilterV2BindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceAlarmSoundPickerBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceCreateEditScheduleBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceErrorReportBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterPageBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceFilterSelectionBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceHHumidityLevelsInfoBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceHTimerPickerBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceLinkBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNFilterBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNProductSettingsBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceNSetScheduleModeBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSetTimezoneBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSettingInfoBindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceTimerPickerV2BindingImpl;
import com.blueair.devicedetails.databinding.DialogfragmentTimePickerV2BindingImpl;
import com.blueair.devicedetails.databinding.FragmentDeviceHWelcomeHomeBindingImpl;
import com.blueair.devicedetails.databinding.FragmentDeviceNWelcomeHomeBindingImpl;
import com.blueair.devicedetails.databinding.FragmentDeviceSchedulesBindingImpl;
import com.blueair.devicedetails.databinding.FragmentDeviceSensorsBindingImpl;
import com.blueair.devicedetails.databinding.FragmentDeviceWelcomeHomeBindingImpl;
import com.blueair.devicedetails.databinding.FragmentFilterBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceHAttributeFanSpeedBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceHBrightnessBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceHFanSpeedBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceHSettingsDeleteBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNBrightnessBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNCleanAirEtaBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNFanSpeedBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNFilterStatusBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNModeButtonBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNOnOffButtonBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsDeleteBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsHinsBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsModeBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceNSettingsTriggerBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceSettingInfoBindingImpl;
import com.blueair.devicedetails.databinding.HolderDeviceSettingInfoErrorReportBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
   private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
   private static final int LAYOUT_ACTIVITYCUSTOMINPUT = 1;
   private static final int LAYOUT_ACTIVITYDEVICEDETAILS = 2;
   private static final int LAYOUT_ACTIVITYDEVICEFILTERDETAIL = 3;
   private static final int LAYOUT_ACTIVITYDEVICEREPLACEFILTER = 4;
   private static final int LAYOUT_ACTIVITYDEVICESALARMLIST = 5;
   private static final int LAYOUT_ACTIVITYSCHEDULELIST = 6;
   private static final int LAYOUT_ACTIVITYWELCOMEHOMECONFIG = 7;
   private static final int LAYOUT_DIALOGFRAGMENTBUYFILTERV2 = 8;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEALARMSOUNDPICKER = 9;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICECREATEEDITSCHEDULE = 10;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEDETAILS = 11;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEERRORREPORT = 12;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEFILTERPAGE = 13;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEFILTERSELECTION = 14;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEHHUMIDITYLEVELSINFO = 15;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICEHTIMERPICKER = 16;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICELINK = 17;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICENFILTER = 18;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICENPRODUCTSETTINGS = 19;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICENSETSCHEDULEMODE = 20;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICESETTIMEZONE = 21;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICESETTINGINFO = 22;
   private static final int LAYOUT_DIALOGFRAGMENTDEVICETIMERPICKERV2 = 23;
   private static final int LAYOUT_DIALOGFRAGMENTTIMEPICKERV2 = 24;
   private static final int LAYOUT_FRAGMENTDEVICEHWELCOMEHOME = 25;
   private static final int LAYOUT_FRAGMENTDEVICENWELCOMEHOME = 26;
   private static final int LAYOUT_FRAGMENTDEVICESCHEDULES = 27;
   private static final int LAYOUT_FRAGMENTDEVICESENSORS = 28;
   private static final int LAYOUT_FRAGMENTDEVICEWELCOMEHOME = 29;
   private static final int LAYOUT_FRAGMENTFILTER = 30;
   private static final int LAYOUT_HOLDERDEVICEHATTRIBUTEFANSPEED = 31;
   private static final int LAYOUT_HOLDERDEVICEHBRIGHTNESS = 32;
   private static final int LAYOUT_HOLDERDEVICEHFANSPEED = 33;
   private static final int LAYOUT_HOLDERDEVICEHSETTINGSDELETE = 34;
   private static final int LAYOUT_HOLDERDEVICENBRIGHTNESS = 35;
   private static final int LAYOUT_HOLDERDEVICENCLEANAIRETA = 36;
   private static final int LAYOUT_HOLDERDEVICENFANSPEED = 37;
   private static final int LAYOUT_HOLDERDEVICENFILTERSTATUS = 38;
   private static final int LAYOUT_HOLDERDEVICENMODEBUTTON = 39;
   private static final int LAYOUT_HOLDERDEVICENONOFFBUTTON = 40;
   private static final int LAYOUT_HOLDERDEVICENSETTINGS = 41;
   private static final int LAYOUT_HOLDERDEVICENSETTINGSDELETE = 42;
   private static final int LAYOUT_HOLDERDEVICENSETTINGSHINS = 43;
   private static final int LAYOUT_HOLDERDEVICENSETTINGSMODE = 44;
   private static final int LAYOUT_HOLDERDEVICENSETTINGSTRIGGER = 45;
   private static final int LAYOUT_HOLDERDEVICESETTINGINFO = 46;
   private static final int LAYOUT_HOLDERDEVICESETTINGINFOERRORREPORT = 47;

   static {
      SparseIntArray var0 = new SparseIntArray(47);
      INTERNAL_LAYOUT_ID_LOOKUP = var0;
      var0.put(R.layout.activity_custom_input, 1);
      var0.put(R.layout.activity_device_details, 2);
      var0.put(R.layout.activity_device_filter_detail, 3);
      var0.put(R.layout.activity_device_replace_filter, 4);
      var0.put(R.layout.activity_devices_alarm_list, 5);
      var0.put(R.layout.activity_schedule_list, 6);
      var0.put(R.layout.activity_welcome_home_config, 7);
      var0.put(R.layout.dialogfragment_buy_filter_v2, 8);
      var0.put(R.layout.dialogfragment_device_alarm_sound_picker, 9);
      var0.put(R.layout.dialogfragment_device_create_edit_schedule, 10);
      var0.put(R.layout.dialogfragment_device_details, 11);
      var0.put(R.layout.dialogfragment_device_error_report, 12);
      var0.put(R.layout.dialogfragment_device_filter_page, 13);
      var0.put(R.layout.dialogfragment_device_filter_selection, 14);
      var0.put(R.layout.dialogfragment_device_h_humidity_levels_info, 15);
      var0.put(R.layout.dialogfragment_device_h_timer_picker, 16);
      var0.put(R.layout.dialogfragment_device_link, 17);
      var0.put(R.layout.dialogfragment_device_n_filter, 18);
      var0.put(R.layout.dialogfragment_device_n_product_settings, 19);
      var0.put(R.layout.dialogfragment_device_n_set_schedule_mode, 20);
      var0.put(R.layout.dialogfragment_device_set_timezone, 21);
      var0.put(R.layout.dialogfragment_device_setting_info, 22);
      var0.put(R.layout.dialogfragment_device_timer_picker_v2, 23);
      var0.put(R.layout.dialogfragment_time_picker_v2, 24);
      var0.put(R.layout.fragment_device_h_welcome_home, 25);
      var0.put(R.layout.fragment_device_n_welcome_home, 26);
      var0.put(R.layout.fragment_device_schedules, 27);
      var0.put(R.layout.fragment_device_sensors, 28);
      var0.put(R.layout.fragment_device_welcome_home, 29);
      var0.put(R.layout.fragment_filter, 30);
      var0.put(R.layout.holder_device_h_attribute_fan_speed, 31);
      var0.put(R.layout.holder_device_h_brightness, 32);
      var0.put(R.layout.holder_device_h_fan_speed, 33);
      var0.put(R.layout.holder_device_h_settings_delete, 34);
      var0.put(R.layout.holder_device_n_brightness, 35);
      var0.put(R.layout.holder_device_n_clean_air_eta, 36);
      var0.put(R.layout.holder_device_n_fan_speed, 37);
      var0.put(R.layout.holder_device_n_filter_status, 38);
      var0.put(R.layout.holder_device_n_mode_button, 39);
      var0.put(R.layout.holder_device_n_on_off_button, 40);
      var0.put(R.layout.holder_device_n_settings, 41);
      var0.put(R.layout.holder_device_n_settings_delete, 42);
      var0.put(R.layout.holder_device_n_settings_hins, 43);
      var0.put(R.layout.holder_device_n_settings_mode, 44);
      var0.put(R.layout.holder_device_n_settings_trigger, 45);
      var0.put(R.layout.holder_device_setting_info, 46);
      var0.put(R.layout.holder_device_setting_info_error_report, 47);
   }

   public List collectDependencies() {
      ArrayList var1 = new ArrayList(10);
      var1.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
      var1.add(new com.blueair.api.DataBinderMapperImpl());
      var1.add(new com.blueair.auth.DataBinderMapperImpl());
      var1.add(new com.blueair.core.DataBinderMapperImpl());
      var1.add(new com.blueair.devicemanager.DataBinderMapperImpl());
      var1.add(new com.blueair.graph.DataBinderMapperImpl());
      var1.add(new com.blueair.outdoor.DataBinderMapperImpl());
      var1.add(new com.blueair.push.DataBinderMapperImpl());
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
               if ("layout/activity_custom_input_0".equals(var4)) {
                  return new ActivityCustomInputBindingImpl(var1, var2);
               }

               StringBuilder var51 = new StringBuilder("The tag for activity_custom_input is invalid. Received: ");
               var51.append(var4);
               throw new IllegalArgumentException(var51.toString());
            case 2:
               if ("layout/activity_device_details_0".equals(var4)) {
                  return new ActivityDeviceDetailsBindingImpl(var1, var2);
               }

               StringBuilder var50 = new StringBuilder("The tag for activity_device_details is invalid. Received: ");
               var50.append(var4);
               throw new IllegalArgumentException(var50.toString());
            case 3:
               if ("layout/activity_device_filter_detail_0".equals(var4)) {
                  return new ActivityDeviceFilterDetailBindingImpl(var1, var2);
               }

               StringBuilder var49 = new StringBuilder("The tag for activity_device_filter_detail is invalid. Received: ");
               var49.append(var4);
               throw new IllegalArgumentException(var49.toString());
            case 4:
               if ("layout/activity_device_replace_filter_0".equals(var4)) {
                  return new ActivityDeviceReplaceFilterBindingImpl(var1, var2);
               }

               StringBuilder var48 = new StringBuilder("The tag for activity_device_replace_filter is invalid. Received: ");
               var48.append(var4);
               throw new IllegalArgumentException(var48.toString());
            case 5:
               if ("layout/activity_devices_alarm_list_0".equals(var4)) {
                  return new ActivityDevicesAlarmListBindingImpl(var1, var2);
               }

               StringBuilder var47 = new StringBuilder("The tag for activity_devices_alarm_list is invalid. Received: ");
               var47.append(var4);
               throw new IllegalArgumentException(var47.toString());
            case 6:
               if ("layout/activity_schedule_list_0".equals(var4)) {
                  return new ActivityScheduleListBindingImpl(var1, var2);
               }

               StringBuilder var46 = new StringBuilder("The tag for activity_schedule_list is invalid. Received: ");
               var46.append(var4);
               throw new IllegalArgumentException(var46.toString());
            case 7:
               if ("layout/activity_welcome_home_config_0".equals(var4)) {
                  return new ActivityWelcomeHomeConfigBindingImpl(var1, var2);
               }

               StringBuilder var45 = new StringBuilder("The tag for activity_welcome_home_config is invalid. Received: ");
               var45.append(var4);
               throw new IllegalArgumentException(var45.toString());
            case 8:
               if ("layout/dialogfragment_buy_filter_v2_0".equals(var4)) {
                  return new DialogfragmentBuyFilterV2BindingImpl(var1, var2);
               }

               StringBuilder var44 = new StringBuilder("The tag for dialogfragment_buy_filter_v2 is invalid. Received: ");
               var44.append(var4);
               throw new IllegalArgumentException(var44.toString());
            case 9:
               if ("layout/dialogfragment_device_alarm_sound_picker_0".equals(var4)) {
                  return new DialogfragmentDeviceAlarmSoundPickerBindingImpl(var1, var2);
               }

               StringBuilder var43 = new StringBuilder("The tag for dialogfragment_device_alarm_sound_picker is invalid. Received: ");
               var43.append(var4);
               throw new IllegalArgumentException(var43.toString());
            case 10:
               if ("layout/dialogfragment_device_create_edit_schedule_0".equals(var4)) {
                  return new DialogfragmentDeviceCreateEditScheduleBindingImpl(var1, var2);
               }

               StringBuilder var42 = new StringBuilder("The tag for dialogfragment_device_create_edit_schedule is invalid. Received: ");
               var42.append(var4);
               throw new IllegalArgumentException(var42.toString());
            case 11:
               if ("layout/dialogfragment_device_details_0".equals(var4)) {
                  return new DialogfragmentDeviceDetailsBindingImpl(var1, var2);
               }

               StringBuilder var41 = new StringBuilder("The tag for dialogfragment_device_details is invalid. Received: ");
               var41.append(var4);
               throw new IllegalArgumentException(var41.toString());
            case 12:
               if ("layout/dialogfragment_device_error_report_0".equals(var4)) {
                  return new DialogfragmentDeviceErrorReportBindingImpl(var1, var2);
               }

               StringBuilder var40 = new StringBuilder("The tag for dialogfragment_device_error_report is invalid. Received: ");
               var40.append(var4);
               throw new IllegalArgumentException(var40.toString());
            case 13:
               if ("layout/dialogfragment_device_filter_page_0".equals(var4)) {
                  return new DialogfragmentDeviceFilterPageBindingImpl(var1, var2);
               }

               StringBuilder var39 = new StringBuilder("The tag for dialogfragment_device_filter_page is invalid. Received: ");
               var39.append(var4);
               throw new IllegalArgumentException(var39.toString());
            case 14:
               if ("layout/dialogfragment_device_filter_selection_0".equals(var4)) {
                  return new DialogfragmentDeviceFilterSelectionBindingImpl(var1, var2);
               }

               StringBuilder var38 = new StringBuilder("The tag for dialogfragment_device_filter_selection is invalid. Received: ");
               var38.append(var4);
               throw new IllegalArgumentException(var38.toString());
            case 15:
               if ("layout/dialogfragment_device_h_humidity_levels_info_0".equals(var4)) {
                  return new DialogfragmentDeviceHHumidityLevelsInfoBindingImpl(var1, var2);
               }

               StringBuilder var37 = new StringBuilder("The tag for dialogfragment_device_h_humidity_levels_info is invalid. Received: ");
               var37.append(var4);
               throw new IllegalArgumentException(var37.toString());
            case 16:
               if ("layout/dialogfragment_device_h_timer_picker_0".equals(var4)) {
                  return new DialogfragmentDeviceHTimerPickerBindingImpl(var1, var2);
               }

               StringBuilder var36 = new StringBuilder("The tag for dialogfragment_device_h_timer_picker is invalid. Received: ");
               var36.append(var4);
               throw new IllegalArgumentException(var36.toString());
            case 17:
               if ("layout/dialogfragment_device_link_0".equals(var4)) {
                  return new DialogfragmentDeviceLinkBindingImpl(var1, var2);
               }

               StringBuilder var35 = new StringBuilder("The tag for dialogfragment_device_link is invalid. Received: ");
               var35.append(var4);
               throw new IllegalArgumentException(var35.toString());
            case 18:
               if ("layout/dialogfragment_device_n_filter_0".equals(var4)) {
                  return new DialogfragmentDeviceNFilterBindingImpl(var1, var2);
               }

               StringBuilder var34 = new StringBuilder("The tag for dialogfragment_device_n_filter is invalid. Received: ");
               var34.append(var4);
               throw new IllegalArgumentException(var34.toString());
            case 19:
               if ("layout/dialogfragment_device_n_product_settings_0".equals(var4)) {
                  return new DialogfragmentDeviceNProductSettingsBindingImpl(var1, var2);
               }

               StringBuilder var33 = new StringBuilder("The tag for dialogfragment_device_n_product_settings is invalid. Received: ");
               var33.append(var4);
               throw new IllegalArgumentException(var33.toString());
            case 20:
               if ("layout/dialogfragment_device_n_set_schedule_mode_0".equals(var4)) {
                  return new DialogfragmentDeviceNSetScheduleModeBindingImpl(var1, var2);
               }

               StringBuilder var32 = new StringBuilder("The tag for dialogfragment_device_n_set_schedule_mode is invalid. Received: ");
               var32.append(var4);
               throw new IllegalArgumentException(var32.toString());
            case 21:
               if ("layout/dialogfragment_device_set_timezone_0".equals(var4)) {
                  return new DialogfragmentDeviceSetTimezoneBindingImpl(var1, var2);
               }

               StringBuilder var31 = new StringBuilder("The tag for dialogfragment_device_set_timezone is invalid. Received: ");
               var31.append(var4);
               throw new IllegalArgumentException(var31.toString());
            case 22:
               if ("layout/dialogfragment_device_setting_info_0".equals(var4)) {
                  return new DialogfragmentDeviceSettingInfoBindingImpl(var1, var2);
               }

               StringBuilder var30 = new StringBuilder("The tag for dialogfragment_device_setting_info is invalid. Received: ");
               var30.append(var4);
               throw new IllegalArgumentException(var30.toString());
            case 23:
               if ("layout/dialogfragment_device_timer_picker_v2_0".equals(var4)) {
                  return new DialogfragmentDeviceTimerPickerV2BindingImpl(var1, var2);
               }

               StringBuilder var29 = new StringBuilder("The tag for dialogfragment_device_timer_picker_v2 is invalid. Received: ");
               var29.append(var4);
               throw new IllegalArgumentException(var29.toString());
            case 24:
               if ("layout/dialogfragment_time_picker_v2_0".equals(var4)) {
                  return new DialogfragmentTimePickerV2BindingImpl(var1, var2);
               }

               StringBuilder var28 = new StringBuilder("The tag for dialogfragment_time_picker_v2 is invalid. Received: ");
               var28.append(var4);
               throw new IllegalArgumentException(var28.toString());
            case 25:
               if ("layout/fragment_device_h_welcome_home_0".equals(var4)) {
                  return new FragmentDeviceHWelcomeHomeBindingImpl(var1, var2);
               }

               StringBuilder var27 = new StringBuilder("The tag for fragment_device_h_welcome_home is invalid. Received: ");
               var27.append(var4);
               throw new IllegalArgumentException(var27.toString());
            case 26:
               if ("layout/fragment_device_n_welcome_home_0".equals(var4)) {
                  return new FragmentDeviceNWelcomeHomeBindingImpl(var1, var2);
               }

               StringBuilder var26 = new StringBuilder("The tag for fragment_device_n_welcome_home is invalid. Received: ");
               var26.append(var4);
               throw new IllegalArgumentException(var26.toString());
            case 27:
               if ("layout/fragment_device_schedules_0".equals(var4)) {
                  return new FragmentDeviceSchedulesBindingImpl(var1, var2);
               }

               StringBuilder var25 = new StringBuilder("The tag for fragment_device_schedules is invalid. Received: ");
               var25.append(var4);
               throw new IllegalArgumentException(var25.toString());
            case 28:
               if ("layout/fragment_device_sensors_0".equals(var4)) {
                  return new FragmentDeviceSensorsBindingImpl(var1, var2);
               }

               StringBuilder var24 = new StringBuilder("The tag for fragment_device_sensors is invalid. Received: ");
               var24.append(var4);
               throw new IllegalArgumentException(var24.toString());
            case 29:
               if ("layout/fragment_device_welcome_home_0".equals(var4)) {
                  return new FragmentDeviceWelcomeHomeBindingImpl(var1, var2);
               }

               StringBuilder var23 = new StringBuilder("The tag for fragment_device_welcome_home is invalid. Received: ");
               var23.append(var4);
               throw new IllegalArgumentException(var23.toString());
            case 30:
               if ("layout/fragment_filter_0".equals(var4)) {
                  return new FragmentFilterBindingImpl(var1, var2);
               }

               StringBuilder var22 = new StringBuilder("The tag for fragment_filter is invalid. Received: ");
               var22.append(var4);
               throw new IllegalArgumentException(var22.toString());
            case 31:
               if ("layout/holder_device_h_attribute_fan_speed_0".equals(var4)) {
                  return new HolderDeviceHAttributeFanSpeedBindingImpl(var1, var2);
               }

               StringBuilder var21 = new StringBuilder("The tag for holder_device_h_attribute_fan_speed is invalid. Received: ");
               var21.append(var4);
               throw new IllegalArgumentException(var21.toString());
            case 32:
               if ("layout/holder_device_h_brightness_0".equals(var4)) {
                  return new HolderDeviceHBrightnessBindingImpl(var1, var2);
               }

               StringBuilder var20 = new StringBuilder("The tag for holder_device_h_brightness is invalid. Received: ");
               var20.append(var4);
               throw new IllegalArgumentException(var20.toString());
            case 33:
               if ("layout/holder_device_h_fan_speed_0".equals(var4)) {
                  return new HolderDeviceHFanSpeedBindingImpl(var1, var2);
               }

               StringBuilder var19 = new StringBuilder("The tag for holder_device_h_fan_speed is invalid. Received: ");
               var19.append(var4);
               throw new IllegalArgumentException(var19.toString());
            case 34:
               if ("layout/holder_device_h_settings_delete_0".equals(var4)) {
                  return new HolderDeviceHSettingsDeleteBindingImpl(var1, var2);
               }

               StringBuilder var18 = new StringBuilder("The tag for holder_device_h_settings_delete is invalid. Received: ");
               var18.append(var4);
               throw new IllegalArgumentException(var18.toString());
            case 35:
               if ("layout/holder_device_n_brightness_0".equals(var4)) {
                  return new HolderDeviceNBrightnessBindingImpl(var1, var2);
               }

               StringBuilder var17 = new StringBuilder("The tag for holder_device_n_brightness is invalid. Received: ");
               var17.append(var4);
               throw new IllegalArgumentException(var17.toString());
            case 36:
               if ("layout/holder_device_n_clean_air_eta_0".equals(var4)) {
                  return new HolderDeviceNCleanAirEtaBindingImpl(var1, var2);
               }

               StringBuilder var16 = new StringBuilder("The tag for holder_device_n_clean_air_eta is invalid. Received: ");
               var16.append(var4);
               throw new IllegalArgumentException(var16.toString());
            case 37:
               if ("layout/holder_device_n_fan_speed_0".equals(var4)) {
                  return new HolderDeviceNFanSpeedBindingImpl(var1, var2);
               }

               StringBuilder var15 = new StringBuilder("The tag for holder_device_n_fan_speed is invalid. Received: ");
               var15.append(var4);
               throw new IllegalArgumentException(var15.toString());
            case 38:
               if ("layout/holder_device_n_filter_status_0".equals(var4)) {
                  return new HolderDeviceNFilterStatusBindingImpl(var1, var2);
               }

               StringBuilder var14 = new StringBuilder("The tag for holder_device_n_filter_status is invalid. Received: ");
               var14.append(var4);
               throw new IllegalArgumentException(var14.toString());
            case 39:
               if ("layout/holder_device_n_mode_button_0".equals(var4)) {
                  return new HolderDeviceNModeButtonBindingImpl(var1, var2);
               }

               StringBuilder var13 = new StringBuilder("The tag for holder_device_n_mode_button is invalid. Received: ");
               var13.append(var4);
               throw new IllegalArgumentException(var13.toString());
            case 40:
               if ("layout/holder_device_n_on_off_button_0".equals(var4)) {
                  return new HolderDeviceNOnOffButtonBindingImpl(var1, var2);
               }

               StringBuilder var12 = new StringBuilder("The tag for holder_device_n_on_off_button is invalid. Received: ");
               var12.append(var4);
               throw new IllegalArgumentException(var12.toString());
            case 41:
               if ("layout/holder_device_n_settings_0".equals(var4)) {
                  return new HolderDeviceNSettingsBindingImpl(var1, var2);
               }

               StringBuilder var11 = new StringBuilder("The tag for holder_device_n_settings is invalid. Received: ");
               var11.append(var4);
               throw new IllegalArgumentException(var11.toString());
            case 42:
               if ("layout/holder_device_n_settings_delete_0".equals(var4)) {
                  return new HolderDeviceNSettingsDeleteBindingImpl(var1, var2);
               }

               StringBuilder var10 = new StringBuilder("The tag for holder_device_n_settings_delete is invalid. Received: ");
               var10.append(var4);
               throw new IllegalArgumentException(var10.toString());
            case 43:
               if ("layout/holder_device_n_settings_hins_0".equals(var4)) {
                  return new HolderDeviceNSettingsHinsBindingImpl(var1, var2);
               }

               StringBuilder var9 = new StringBuilder("The tag for holder_device_n_settings_hins is invalid. Received: ");
               var9.append(var4);
               throw new IllegalArgumentException(var9.toString());
            case 44:
               if ("layout/holder_device_n_settings_mode_0".equals(var4)) {
                  return new HolderDeviceNSettingsModeBindingImpl(var1, var2);
               }

               StringBuilder var8 = new StringBuilder("The tag for holder_device_n_settings_mode is invalid. Received: ");
               var8.append(var4);
               throw new IllegalArgumentException(var8.toString());
            case 45:
               if ("layout/holder_device_n_settings_trigger_0".equals(var4)) {
                  return new HolderDeviceNSettingsTriggerBindingImpl(var1, var2);
               }

               StringBuilder var7 = new StringBuilder("The tag for holder_device_n_settings_trigger is invalid. Received: ");
               var7.append(var4);
               throw new IllegalArgumentException(var7.toString());
            case 46:
               if ("layout/holder_device_setting_info_0".equals(var4)) {
                  return new HolderDeviceSettingInfoBindingImpl(var1, var2);
               }

               StringBuilder var6 = new StringBuilder("The tag for holder_device_setting_info is invalid. Received: ");
               var6.append(var4);
               throw new IllegalArgumentException(var6.toString());
            case 47:
               if ("layout/holder_device_setting_info_error_report_0".equals(var4)) {
                  return new HolderDeviceSettingInfoErrorReportBindingImpl(var1, var2);
               }

               StringBuilder var5 = new StringBuilder("The tag for holder_device_setting_info_error_report is invalid. Received: ");
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
         SparseArray var0 = new SparseArray(7);
         sKeys = var0;
         var0.put(0, "_all");
         var0.put(1, "deviceCreateEditScheduleViewModel");
         var0.put(2, "deviceDetailViewModel");
         var0.put(3, "deviceDetailsViewModel");
         var0.put(4, "deviceSchedulesViewModel");
         var0.put(5, "deviceSensorViewModel");
         var0.put(6, "vm");
      }
   }

   private static class InnerLayoutIdLookup {
      static final HashMap sKeys;

      static {
         HashMap var0 = new HashMap(47);
         sKeys = var0;
         var0.put("layout/activity_custom_input_0", R.layout.activity_custom_input);
         var0.put("layout/activity_device_details_0", R.layout.activity_device_details);
         var0.put("layout/activity_device_filter_detail_0", R.layout.activity_device_filter_detail);
         var0.put("layout/activity_device_replace_filter_0", R.layout.activity_device_replace_filter);
         var0.put("layout/activity_devices_alarm_list_0", R.layout.activity_devices_alarm_list);
         var0.put("layout/activity_schedule_list_0", R.layout.activity_schedule_list);
         var0.put("layout/activity_welcome_home_config_0", R.layout.activity_welcome_home_config);
         var0.put("layout/dialogfragment_buy_filter_v2_0", R.layout.dialogfragment_buy_filter_v2);
         var0.put("layout/dialogfragment_device_alarm_sound_picker_0", R.layout.dialogfragment_device_alarm_sound_picker);
         var0.put("layout/dialogfragment_device_create_edit_schedule_0", R.layout.dialogfragment_device_create_edit_schedule);
         var0.put("layout/dialogfragment_device_details_0", R.layout.dialogfragment_device_details);
         var0.put("layout/dialogfragment_device_error_report_0", R.layout.dialogfragment_device_error_report);
         var0.put("layout/dialogfragment_device_filter_page_0", R.layout.dialogfragment_device_filter_page);
         var0.put("layout/dialogfragment_device_filter_selection_0", R.layout.dialogfragment_device_filter_selection);
         var0.put("layout/dialogfragment_device_h_humidity_levels_info_0", R.layout.dialogfragment_device_h_humidity_levels_info);
         var0.put("layout/dialogfragment_device_h_timer_picker_0", R.layout.dialogfragment_device_h_timer_picker);
         var0.put("layout/dialogfragment_device_link_0", R.layout.dialogfragment_device_link);
         var0.put("layout/dialogfragment_device_n_filter_0", R.layout.dialogfragment_device_n_filter);
         var0.put("layout/dialogfragment_device_n_product_settings_0", R.layout.dialogfragment_device_n_product_settings);
         var0.put("layout/dialogfragment_device_n_set_schedule_mode_0", R.layout.dialogfragment_device_n_set_schedule_mode);
         var0.put("layout/dialogfragment_device_set_timezone_0", R.layout.dialogfragment_device_set_timezone);
         var0.put("layout/dialogfragment_device_setting_info_0", R.layout.dialogfragment_device_setting_info);
         var0.put("layout/dialogfragment_device_timer_picker_v2_0", R.layout.dialogfragment_device_timer_picker_v2);
         var0.put("layout/dialogfragment_time_picker_v2_0", R.layout.dialogfragment_time_picker_v2);
         var0.put("layout/fragment_device_h_welcome_home_0", R.layout.fragment_device_h_welcome_home);
         var0.put("layout/fragment_device_n_welcome_home_0", R.layout.fragment_device_n_welcome_home);
         var0.put("layout/fragment_device_schedules_0", R.layout.fragment_device_schedules);
         var0.put("layout/fragment_device_sensors_0", R.layout.fragment_device_sensors);
         var0.put("layout/fragment_device_welcome_home_0", R.layout.fragment_device_welcome_home);
         var0.put("layout/fragment_filter_0", R.layout.fragment_filter);
         var0.put("layout/holder_device_h_attribute_fan_speed_0", R.layout.holder_device_h_attribute_fan_speed);
         var0.put("layout/holder_device_h_brightness_0", R.layout.holder_device_h_brightness);
         var0.put("layout/holder_device_h_fan_speed_0", R.layout.holder_device_h_fan_speed);
         var0.put("layout/holder_device_h_settings_delete_0", R.layout.holder_device_h_settings_delete);
         var0.put("layout/holder_device_n_brightness_0", R.layout.holder_device_n_brightness);
         var0.put("layout/holder_device_n_clean_air_eta_0", R.layout.holder_device_n_clean_air_eta);
         var0.put("layout/holder_device_n_fan_speed_0", R.layout.holder_device_n_fan_speed);
         var0.put("layout/holder_device_n_filter_status_0", R.layout.holder_device_n_filter_status);
         var0.put("layout/holder_device_n_mode_button_0", R.layout.holder_device_n_mode_button);
         var0.put("layout/holder_device_n_on_off_button_0", R.layout.holder_device_n_on_off_button);
         var0.put("layout/holder_device_n_settings_0", R.layout.holder_device_n_settings);
         var0.put("layout/holder_device_n_settings_delete_0", R.layout.holder_device_n_settings_delete);
         var0.put("layout/holder_device_n_settings_hins_0", R.layout.holder_device_n_settings_hins);
         var0.put("layout/holder_device_n_settings_mode_0", R.layout.holder_device_n_settings_mode);
         var0.put("layout/holder_device_n_settings_trigger_0", R.layout.holder_device_n_settings_trigger);
         var0.put("layout/holder_device_setting_info_0", R.layout.holder_device_setting_info);
         var0.put("layout/holder_device_setting_info_error_report_0", R.layout.holder_device_setting_info_error_report);
      }
   }
}
