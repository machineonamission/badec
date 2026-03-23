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
        SparseIntArray sparseIntArray = new SparseIntArray(17);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_dev_settings, 1);
        sparseIntArray.put(R.layout.activity_google_app_flip, 2);
        sparseIntArray.put(R.layout.activity_home, 3);
        sparseIntArray.put(R.layout.activity_info, 4);
        sparseIntArray.put(R.layout.activity_info_detail, 5);
        sparseIntArray.put(R.layout.activity_info_list, 6);
        sparseIntArray.put(R.layout.activity_notifications, 7);
        sparseIntArray.put(R.layout.dialog_aqi_index_info, 8);
        sparseIntArray.put(R.layout.dialog_notification_center, 9);
        sparseIntArray.put(R.layout.dialogfragment_notification_edit_number, 10);
        sparseIntArray.put(R.layout.dialogfragment_settings, 11);
        sparseIntArray.put(R.layout.dialogfragment_smart_integrations, 12);
        sparseIntArray.put(R.layout.fragment_indoor, 13);
        sparseIntArray.put(R.layout.fragment_outdoor, 14);
        sparseIntArray.put(R.layout.fragment_policies, 15);
        sparseIntArray.put(R.layout.fragment_smart_integrations, 16);
        sparseIntArray.put(R.layout.integration_item, 17);
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
                    if ("layout/activity_dev_settings_0".equals(tag)) {
                        return new ActivityDevSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_dev_settings is invalid. Received: " + tag);
                case 2:
                    if ("layout/activity_google_app_flip_0".equals(tag)) {
                        return new ActivityGoogleAppFlipBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_google_app_flip is invalid. Received: " + tag);
                case 3:
                    if ("layout/activity_home_0".equals(tag)) {
                        return new ActivityHomeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
                case 4:
                    if ("layout/activity_info_0".equals(tag)) {
                        return new ActivityInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_info is invalid. Received: " + tag);
                case 5:
                    if ("layout/activity_info_detail_0".equals(tag)) {
                        return new ActivityInfoDetailBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_info_detail is invalid. Received: " + tag);
                case 6:
                    if ("layout/activity_info_list_0".equals(tag)) {
                        return new ActivityInfoListBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_info_list is invalid. Received: " + tag);
                case 7:
                    if ("layout/activity_notifications_0".equals(tag)) {
                        return new ActivityNotificationsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_notifications is invalid. Received: " + tag);
                case 8:
                    if ("layout/dialog_aqi_index_info_0".equals(tag)) {
                        return new DialogAqiIndexInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_aqi_index_info is invalid. Received: " + tag);
                case 9:
                    if ("layout/dialog_notification_center_0".equals(tag)) {
                        return new DialogNotificationCenterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialog_notification_center is invalid. Received: " + tag);
                case 10:
                    if ("layout/dialogfragment_notification_edit_number_0".equals(tag)) {
                        return new DialogfragmentNotificationEditNumberBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_notification_edit_number is invalid. Received: " + tag);
                case 11:
                    if ("layout/dialogfragment_settings_0".equals(tag)) {
                        return new DialogfragmentSettingsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_settings is invalid. Received: " + tag);
                case 12:
                    if ("layout/dialogfragment_smart_integrations_0".equals(tag)) {
                        return new DialogfragmentSmartIntegrationsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_smart_integrations is invalid. Received: " + tag);
                case 13:
                    if ("layout/fragment_indoor_0".equals(tag)) {
                        return new FragmentIndoorBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_indoor is invalid. Received: " + tag);
                case 14:
                    if ("layout/fragment_outdoor_0".equals(tag)) {
                        return new FragmentOutdoorBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_outdoor is invalid. Received: " + tag);
                case 15:
                    if ("layout/fragment_policies_0".equals(tag)) {
                        return new FragmentPoliciesBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_policies is invalid. Received: " + tag);
                case 16:
                    if ("layout/fragment_smart_integrations_0".equals(tag)) {
                        return new FragmentSmartIntegrationsBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_smart_integrations is invalid. Received: " + tag);
                case 17:
                    if ("layout/integration_item_0".equals(tag)) {
                        return new IntegrationItemBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for integration_item is invalid. Received: " + tag);
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
        ArrayList arrayList = new ArrayList(17);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.airboxlab.icp.sdk.DataBinderMapperImpl());
        arrayList.add(new com.blueair.adddevice.DataBinderMapperImpl());
        arrayList.add(new com.blueair.antifake.DataBinderMapperImpl());
        arrayList.add(new com.blueair.api.DataBinderMapperImpl());
        arrayList.add(new com.blueair.auth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.bluetooth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.core.DataBinderMapperImpl());
        arrayList.add(new com.blueair.devicedetails.DataBinderMapperImpl());
        arrayList.add(new com.blueair.devicemanager.DataBinderMapperImpl());
        arrayList.add(new com.blueair.graph.DataBinderMapperImpl());
        arrayList.add(new com.blueair.login.DataBinderMapperImpl());
        arrayList.add(new com.blueair.outdoor.DataBinderMapperImpl());
        arrayList.add(new com.blueair.push.DataBinderMapperImpl());
        arrayList.add(new com.blueair.sdk.DataBinderMapperImpl());
        arrayList.add(new com.blueair.viewcore.DataBinderMapperImpl());
        arrayList.add(new com.github.mikephil.charting.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(12);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "addDeviceViewModel");
            sparseArray.put(2, "deviceCreateEditScheduleViewModel");
            sparseArray.put(3, "deviceDetailViewModel");
            sparseArray.put(4, "deviceDetailsViewModel");
            sparseArray.put(5, "deviceSchedulesViewModel");
            sparseArray.put(6, "deviceSensorViewModel");
            sparseArray.put(7, "homeViewModel");
            sparseArray.put(8, "indoorViewModel");
            sparseArray.put(9, "outdoorViewModel");
            sparseArray.put(10, "viewModel");
            sparseArray.put(11, "vm");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(17);
            sKeys = hashMap;
            hashMap.put("layout/activity_dev_settings_0", Integer.valueOf(R.layout.activity_dev_settings));
            hashMap.put("layout/activity_google_app_flip_0", Integer.valueOf(R.layout.activity_google_app_flip));
            hashMap.put("layout/activity_home_0", Integer.valueOf(R.layout.activity_home));
            hashMap.put("layout/activity_info_0", Integer.valueOf(R.layout.activity_info));
            hashMap.put("layout/activity_info_detail_0", Integer.valueOf(R.layout.activity_info_detail));
            hashMap.put("layout/activity_info_list_0", Integer.valueOf(R.layout.activity_info_list));
            hashMap.put("layout/activity_notifications_0", Integer.valueOf(R.layout.activity_notifications));
            hashMap.put("layout/dialog_aqi_index_info_0", Integer.valueOf(R.layout.dialog_aqi_index_info));
            hashMap.put("layout/dialog_notification_center_0", Integer.valueOf(R.layout.dialog_notification_center));
            hashMap.put("layout/dialogfragment_notification_edit_number_0", Integer.valueOf(R.layout.dialogfragment_notification_edit_number));
            hashMap.put("layout/dialogfragment_settings_0", Integer.valueOf(R.layout.dialogfragment_settings));
            hashMap.put("layout/dialogfragment_smart_integrations_0", Integer.valueOf(R.layout.dialogfragment_smart_integrations));
            hashMap.put("layout/fragment_indoor_0", Integer.valueOf(R.layout.fragment_indoor));
            hashMap.put("layout/fragment_outdoor_0", Integer.valueOf(R.layout.fragment_outdoor));
            hashMap.put("layout/fragment_policies_0", Integer.valueOf(R.layout.fragment_policies));
            hashMap.put("layout/fragment_smart_integrations_0", Integer.valueOf(R.layout.fragment_smart_integrations));
            hashMap.put("layout/integration_item_0", Integer.valueOf(R.layout.integration_item));
        }
    }
}
