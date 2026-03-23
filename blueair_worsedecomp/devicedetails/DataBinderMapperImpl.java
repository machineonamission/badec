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
        SparseIntArray sparseIntArray = new SparseIntArray(47);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_custom_input, 1);
        sparseIntArray.put(R.layout.activity_device_details, 2);
        sparseIntArray.put(R.layout.activity_device_filter_detail, 3);
        sparseIntArray.put(R.layout.activity_device_replace_filter, 4);
        sparseIntArray.put(R.layout.activity_devices_alarm_list, 5);
        sparseIntArray.put(R.layout.activity_schedule_list, 6);
        sparseIntArray.put(R.layout.activity_welcome_home_config, 7);
        sparseIntArray.put(R.layout.dialogfragment_buy_filter_v2, 8);
        sparseIntArray.put(R.layout.dialogfragment_device_alarm_sound_picker, 9);
        sparseIntArray.put(R.layout.dialogfragment_device_create_edit_schedule, 10);
        sparseIntArray.put(R.layout.dialogfragment_device_details, 11);
        sparseIntArray.put(R.layout.dialogfragment_device_error_report, 12);
        sparseIntArray.put(R.layout.dialogfragment_device_filter_page, 13);
        sparseIntArray.put(R.layout.dialogfragment_device_filter_selection, 14);
        sparseIntArray.put(R.layout.dialogfragment_device_h_humidity_levels_info, 15);
        sparseIntArray.put(R.layout.dialogfragment_device_h_timer_picker, 16);
        sparseIntArray.put(R.layout.dialogfragment_device_link, 17);
        sparseIntArray.put(R.layout.dialogfragment_device_n_filter, 18);
        sparseIntArray.put(R.layout.dialogfragment_device_n_product_settings, 19);
        sparseIntArray.put(R.layout.dialogfragment_device_n_set_schedule_mode, 20);
        sparseIntArray.put(R.layout.dialogfragment_device_set_timezone, 21);
        sparseIntArray.put(R.layout.dialogfragment_device_setting_info, 22);
        sparseIntArray.put(R.layout.dialogfragment_device_timer_picker_v2, 23);
        sparseIntArray.put(R.layout.dialogfragment_time_picker_v2, 24);
        sparseIntArray.put(R.layout.fragment_device_h_welcome_home, 25);
        sparseIntArray.put(R.layout.fragment_device_n_welcome_home, 26);
        sparseIntArray.put(R.layout.fragment_device_schedules, 27);
        sparseIntArray.put(R.layout.fragment_device_sensors, 28);
        sparseIntArray.put(R.layout.fragment_device_welcome_home, 29);
        sparseIntArray.put(R.layout.fragment_filter, 30);
        sparseIntArray.put(R.layout.holder_device_h_attribute_fan_speed, 31);
        sparseIntArray.put(R.layout.holder_device_h_brightness, 32);
        sparseIntArray.put(R.layout.holder_device_h_fan_speed, 33);
        sparseIntArray.put(R.layout.holder_device_h_settings_delete, 34);
        sparseIntArray.put(R.layout.holder_device_n_brightness, 35);
        sparseIntArray.put(R.layout.holder_device_n_clean_air_eta, 36);
        sparseIntArray.put(R.layout.holder_device_n_fan_speed, 37);
        sparseIntArray.put(R.layout.holder_device_n_filter_status, 38);
        sparseIntArray.put(R.layout.holder_device_n_mode_button, 39);
        sparseIntArray.put(R.layout.holder_device_n_on_off_button, 40);
        sparseIntArray.put(R.layout.holder_device_n_settings, 41);
        sparseIntArray.put(R.layout.holder_device_n_settings_delete, 42);
        sparseIntArray.put(R.layout.holder_device_n_settings_hins, 43);
        sparseIntArray.put(R.layout.holder_device_n_settings_mode, 44);
        sparseIntArray.put(R.layout.holder_device_n_settings_trigger, 45);
        sparseIntArray.put(R.layout.holder_device_setting_info, 46);
        sparseIntArray.put(R.layout.holder_device_setting_info_error_report, 47);
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = INTERNAL_LAYOUT_ID_LOOKUP.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag != null) {
            switch (i2) {
                case 1:
                    if ("layout/activity_custom_input_0".equals(tag)) {
                        return new ActivityCustomInputBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_custom_input is invalid. Received: " + tag);
                case 2:
                    if ("layout/activity_device_details_0".equals(tag)) {
                        return new ActivityDeviceDetailsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_device_details is invalid. Received: " + tag);
                case 3:
                    if ("layout/activity_device_filter_detail_0".equals(tag)) {
                        return new ActivityDeviceFilterDetailBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_device_filter_detail is invalid. Received: " + tag);
                case 4:
                    if ("layout/activity_device_replace_filter_0".equals(tag)) {
                        return new ActivityDeviceReplaceFilterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_device_replace_filter is invalid. Received: " + tag);
                case 5:
                    if ("layout/activity_devices_alarm_list_0".equals(tag)) {
                        return new ActivityDevicesAlarmListBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_devices_alarm_list is invalid. Received: " + tag);
                case 6:
                    if ("layout/activity_schedule_list_0".equals(tag)) {
                        return new ActivityScheduleListBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_schedule_list is invalid. Received: " + tag);
                case 7:
                    if ("layout/activity_welcome_home_config_0".equals(tag)) {
                        return new ActivityWelcomeHomeConfigBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_welcome_home_config is invalid. Received: " + tag);
                case 8:
                    if ("layout/dialogfragment_buy_filter_v2_0".equals(tag)) {
                        return new DialogfragmentBuyFilterV2BindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_buy_filter_v2 is invalid. Received: " + tag);
                case 9:
                    if ("layout/dialogfragment_device_alarm_sound_picker_0".equals(tag)) {
                        return new DialogfragmentDeviceAlarmSoundPickerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_alarm_sound_picker is invalid. Received: " + tag);
                case 10:
                    if ("layout/dialogfragment_device_create_edit_schedule_0".equals(tag)) {
                        return new DialogfragmentDeviceCreateEditScheduleBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_create_edit_schedule is invalid. Received: " + tag);
                case 11:
                    if ("layout/dialogfragment_device_details_0".equals(tag)) {
                        return new DialogfragmentDeviceDetailsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_details is invalid. Received: " + tag);
                case 12:
                    if ("layout/dialogfragment_device_error_report_0".equals(tag)) {
                        return new DialogfragmentDeviceErrorReportBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_error_report is invalid. Received: " + tag);
                case 13:
                    if ("layout/dialogfragment_device_filter_page_0".equals(tag)) {
                        return new DialogfragmentDeviceFilterPageBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_filter_page is invalid. Received: " + tag);
                case 14:
                    if ("layout/dialogfragment_device_filter_selection_0".equals(tag)) {
                        return new DialogfragmentDeviceFilterSelectionBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_filter_selection is invalid. Received: " + tag);
                case 15:
                    if ("layout/dialogfragment_device_h_humidity_levels_info_0".equals(tag)) {
                        return new DialogfragmentDeviceHHumidityLevelsInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_h_humidity_levels_info is invalid. Received: " + tag);
                case 16:
                    if ("layout/dialogfragment_device_h_timer_picker_0".equals(tag)) {
                        return new DialogfragmentDeviceHTimerPickerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_h_timer_picker is invalid. Received: " + tag);
                case 17:
                    if ("layout/dialogfragment_device_link_0".equals(tag)) {
                        return new DialogfragmentDeviceLinkBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_link is invalid. Received: " + tag);
                case 18:
                    if ("layout/dialogfragment_device_n_filter_0".equals(tag)) {
                        return new DialogfragmentDeviceNFilterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_n_filter is invalid. Received: " + tag);
                case 19:
                    if ("layout/dialogfragment_device_n_product_settings_0".equals(tag)) {
                        return new DialogfragmentDeviceNProductSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_n_product_settings is invalid. Received: " + tag);
                case 20:
                    if ("layout/dialogfragment_device_n_set_schedule_mode_0".equals(tag)) {
                        return new DialogfragmentDeviceNSetScheduleModeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_n_set_schedule_mode is invalid. Received: " + tag);
                case 21:
                    if ("layout/dialogfragment_device_set_timezone_0".equals(tag)) {
                        return new DialogfragmentDeviceSetTimezoneBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_set_timezone is invalid. Received: " + tag);
                case 22:
                    if ("layout/dialogfragment_device_setting_info_0".equals(tag)) {
                        return new DialogfragmentDeviceSettingInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_setting_info is invalid. Received: " + tag);
                case 23:
                    if ("layout/dialogfragment_device_timer_picker_v2_0".equals(tag)) {
                        return new DialogfragmentDeviceTimerPickerV2BindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_device_timer_picker_v2 is invalid. Received: " + tag);
                case 24:
                    if ("layout/dialogfragment_time_picker_v2_0".equals(tag)) {
                        return new DialogfragmentTimePickerV2BindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_time_picker_v2 is invalid. Received: " + tag);
                case 25:
                    if ("layout/fragment_device_h_welcome_home_0".equals(tag)) {
                        return new FragmentDeviceHWelcomeHomeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_device_h_welcome_home is invalid. Received: " + tag);
                case 26:
                    if ("layout/fragment_device_n_welcome_home_0".equals(tag)) {
                        return new FragmentDeviceNWelcomeHomeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_device_n_welcome_home is invalid. Received: " + tag);
                case 27:
                    if ("layout/fragment_device_schedules_0".equals(tag)) {
                        return new FragmentDeviceSchedulesBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_device_schedules is invalid. Received: " + tag);
                case 28:
                    if ("layout/fragment_device_sensors_0".equals(tag)) {
                        return new FragmentDeviceSensorsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_device_sensors is invalid. Received: " + tag);
                case 29:
                    if ("layout/fragment_device_welcome_home_0".equals(tag)) {
                        return new FragmentDeviceWelcomeHomeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_device_welcome_home is invalid. Received: " + tag);
                case 30:
                    if ("layout/fragment_filter_0".equals(tag)) {
                        return new FragmentFilterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_filter is invalid. Received: " + tag);
                case 31:
                    if ("layout/holder_device_h_attribute_fan_speed_0".equals(tag)) {
                        return new HolderDeviceHAttributeFanSpeedBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_h_attribute_fan_speed is invalid. Received: " + tag);
                case 32:
                    if ("layout/holder_device_h_brightness_0".equals(tag)) {
                        return new HolderDeviceHBrightnessBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_h_brightness is invalid. Received: " + tag);
                case 33:
                    if ("layout/holder_device_h_fan_speed_0".equals(tag)) {
                        return new HolderDeviceHFanSpeedBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_h_fan_speed is invalid. Received: " + tag);
                case 34:
                    if ("layout/holder_device_h_settings_delete_0".equals(tag)) {
                        return new HolderDeviceHSettingsDeleteBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_h_settings_delete is invalid. Received: " + tag);
                case 35:
                    if ("layout/holder_device_n_brightness_0".equals(tag)) {
                        return new HolderDeviceNBrightnessBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_brightness is invalid. Received: " + tag);
                case 36:
                    if ("layout/holder_device_n_clean_air_eta_0".equals(tag)) {
                        return new HolderDeviceNCleanAirEtaBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_clean_air_eta is invalid. Received: " + tag);
                case 37:
                    if ("layout/holder_device_n_fan_speed_0".equals(tag)) {
                        return new HolderDeviceNFanSpeedBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_fan_speed is invalid. Received: " + tag);
                case 38:
                    if ("layout/holder_device_n_filter_status_0".equals(tag)) {
                        return new HolderDeviceNFilterStatusBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_filter_status is invalid. Received: " + tag);
                case 39:
                    if ("layout/holder_device_n_mode_button_0".equals(tag)) {
                        return new HolderDeviceNModeButtonBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_mode_button is invalid. Received: " + tag);
                case 40:
                    if ("layout/holder_device_n_on_off_button_0".equals(tag)) {
                        return new HolderDeviceNOnOffButtonBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_on_off_button is invalid. Received: " + tag);
                case 41:
                    if ("layout/holder_device_n_settings_0".equals(tag)) {
                        return new HolderDeviceNSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_settings is invalid. Received: " + tag);
                case 42:
                    if ("layout/holder_device_n_settings_delete_0".equals(tag)) {
                        return new HolderDeviceNSettingsDeleteBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_settings_delete is invalid. Received: " + tag);
                case 43:
                    if ("layout/holder_device_n_settings_hins_0".equals(tag)) {
                        return new HolderDeviceNSettingsHinsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_settings_hins is invalid. Received: " + tag);
                case 44:
                    if ("layout/holder_device_n_settings_mode_0".equals(tag)) {
                        return new HolderDeviceNSettingsModeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_settings_mode is invalid. Received: " + tag);
                case 45:
                    if ("layout/holder_device_n_settings_trigger_0".equals(tag)) {
                        return new HolderDeviceNSettingsTriggerBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_n_settings_trigger is invalid. Received: " + tag);
                case 46:
                    if ("layout/holder_device_setting_info_0".equals(tag)) {
                        return new HolderDeviceSettingInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_setting_info is invalid. Received: " + tag);
                case 47:
                    if ("layout/holder_device_setting_info_error_report_0".equals(tag)) {
                        return new HolderDeviceSettingInfoErrorReportBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_setting_info_error_report is invalid. Received: " + tag);
                default:
                    return null;
            }
        } else {
            throw new RuntimeException("view must have a tag");
        }
    }

    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = InnerLayoutIdLookup.sKeys.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i) {
        return InnerBrLookup.sKeys.get(i);
    }

    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.blueair.api.DataBinderMapperImpl());
        arrayList.add(new com.blueair.auth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.core.DataBinderMapperImpl());
        arrayList.add(new com.blueair.devicemanager.DataBinderMapperImpl());
        arrayList.add(new com.blueair.graph.DataBinderMapperImpl());
        arrayList.add(new com.blueair.outdoor.DataBinderMapperImpl());
        arrayList.add(new com.blueair.push.DataBinderMapperImpl());
        arrayList.add(new com.blueair.viewcore.DataBinderMapperImpl());
        arrayList.add(new com.github.mikephil.charting.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(7);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "deviceCreateEditScheduleViewModel");
            sparseArray.put(2, "deviceDetailViewModel");
            sparseArray.put(3, "deviceDetailsViewModel");
            sparseArray.put(4, "deviceSchedulesViewModel");
            sparseArray.put(5, "deviceSensorViewModel");
            sparseArray.put(6, "vm");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(47);
            sKeys = hashMap;
            hashMap.put("layout/activity_custom_input_0", Integer.valueOf(R.layout.activity_custom_input));
            hashMap.put("layout/activity_device_details_0", Integer.valueOf(R.layout.activity_device_details));
            hashMap.put("layout/activity_device_filter_detail_0", Integer.valueOf(R.layout.activity_device_filter_detail));
            hashMap.put("layout/activity_device_replace_filter_0", Integer.valueOf(R.layout.activity_device_replace_filter));
            hashMap.put("layout/activity_devices_alarm_list_0", Integer.valueOf(R.layout.activity_devices_alarm_list));
            hashMap.put("layout/activity_schedule_list_0", Integer.valueOf(R.layout.activity_schedule_list));
            hashMap.put("layout/activity_welcome_home_config_0", Integer.valueOf(R.layout.activity_welcome_home_config));
            hashMap.put("layout/dialogfragment_buy_filter_v2_0", Integer.valueOf(R.layout.dialogfragment_buy_filter_v2));
            hashMap.put("layout/dialogfragment_device_alarm_sound_picker_0", Integer.valueOf(R.layout.dialogfragment_device_alarm_sound_picker));
            hashMap.put("layout/dialogfragment_device_create_edit_schedule_0", Integer.valueOf(R.layout.dialogfragment_device_create_edit_schedule));
            hashMap.put("layout/dialogfragment_device_details_0", Integer.valueOf(R.layout.dialogfragment_device_details));
            hashMap.put("layout/dialogfragment_device_error_report_0", Integer.valueOf(R.layout.dialogfragment_device_error_report));
            hashMap.put("layout/dialogfragment_device_filter_page_0", Integer.valueOf(R.layout.dialogfragment_device_filter_page));
            hashMap.put("layout/dialogfragment_device_filter_selection_0", Integer.valueOf(R.layout.dialogfragment_device_filter_selection));
            hashMap.put("layout/dialogfragment_device_h_humidity_levels_info_0", Integer.valueOf(R.layout.dialogfragment_device_h_humidity_levels_info));
            hashMap.put("layout/dialogfragment_device_h_timer_picker_0", Integer.valueOf(R.layout.dialogfragment_device_h_timer_picker));
            hashMap.put("layout/dialogfragment_device_link_0", Integer.valueOf(R.layout.dialogfragment_device_link));
            hashMap.put("layout/dialogfragment_device_n_filter_0", Integer.valueOf(R.layout.dialogfragment_device_n_filter));
            hashMap.put("layout/dialogfragment_device_n_product_settings_0", Integer.valueOf(R.layout.dialogfragment_device_n_product_settings));
            hashMap.put("layout/dialogfragment_device_n_set_schedule_mode_0", Integer.valueOf(R.layout.dialogfragment_device_n_set_schedule_mode));
            hashMap.put("layout/dialogfragment_device_set_timezone_0", Integer.valueOf(R.layout.dialogfragment_device_set_timezone));
            hashMap.put("layout/dialogfragment_device_setting_info_0", Integer.valueOf(R.layout.dialogfragment_device_setting_info));
            hashMap.put("layout/dialogfragment_device_timer_picker_v2_0", Integer.valueOf(R.layout.dialogfragment_device_timer_picker_v2));
            hashMap.put("layout/dialogfragment_time_picker_v2_0", Integer.valueOf(R.layout.dialogfragment_time_picker_v2));
            hashMap.put("layout/fragment_device_h_welcome_home_0", Integer.valueOf(R.layout.fragment_device_h_welcome_home));
            hashMap.put("layout/fragment_device_n_welcome_home_0", Integer.valueOf(R.layout.fragment_device_n_welcome_home));
            hashMap.put("layout/fragment_device_schedules_0", Integer.valueOf(R.layout.fragment_device_schedules));
            hashMap.put("layout/fragment_device_sensors_0", Integer.valueOf(R.layout.fragment_device_sensors));
            hashMap.put("layout/fragment_device_welcome_home_0", Integer.valueOf(R.layout.fragment_device_welcome_home));
            hashMap.put("layout/fragment_filter_0", Integer.valueOf(R.layout.fragment_filter));
            hashMap.put("layout/holder_device_h_attribute_fan_speed_0", Integer.valueOf(R.layout.holder_device_h_attribute_fan_speed));
            hashMap.put("layout/holder_device_h_brightness_0", Integer.valueOf(R.layout.holder_device_h_brightness));
            hashMap.put("layout/holder_device_h_fan_speed_0", Integer.valueOf(R.layout.holder_device_h_fan_speed));
            hashMap.put("layout/holder_device_h_settings_delete_0", Integer.valueOf(R.layout.holder_device_h_settings_delete));
            hashMap.put("layout/holder_device_n_brightness_0", Integer.valueOf(R.layout.holder_device_n_brightness));
            hashMap.put("layout/holder_device_n_clean_air_eta_0", Integer.valueOf(R.layout.holder_device_n_clean_air_eta));
            hashMap.put("layout/holder_device_n_fan_speed_0", Integer.valueOf(R.layout.holder_device_n_fan_speed));
            hashMap.put("layout/holder_device_n_filter_status_0", Integer.valueOf(R.layout.holder_device_n_filter_status));
            hashMap.put("layout/holder_device_n_mode_button_0", Integer.valueOf(R.layout.holder_device_n_mode_button));
            hashMap.put("layout/holder_device_n_on_off_button_0", Integer.valueOf(R.layout.holder_device_n_on_off_button));
            hashMap.put("layout/holder_device_n_settings_0", Integer.valueOf(R.layout.holder_device_n_settings));
            hashMap.put("layout/holder_device_n_settings_delete_0", Integer.valueOf(R.layout.holder_device_n_settings_delete));
            hashMap.put("layout/holder_device_n_settings_hins_0", Integer.valueOf(R.layout.holder_device_n_settings_hins));
            hashMap.put("layout/holder_device_n_settings_mode_0", Integer.valueOf(R.layout.holder_device_n_settings_mode));
            hashMap.put("layout/holder_device_n_settings_trigger_0", Integer.valueOf(R.layout.holder_device_n_settings_trigger));
            hashMap.put("layout/holder_device_setting_info_0", Integer.valueOf(R.layout.holder_device_setting_info));
            hashMap.put("layout/holder_device_setting_info_error_report_0", Integer.valueOf(R.layout.holder_device_setting_info_error_report));
        }
    }
}
