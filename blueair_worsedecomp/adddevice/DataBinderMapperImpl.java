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
        SparseIntArray sparseIntArray = new SparseIntArray(10);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_add_device, 1);
        sparseIntArray.put(R.layout.fragment_add_device_success, 2);
        sparseIntArray.put(R.layout.fragment_add_device_wifi, 3);
        sparseIntArray.put(R.layout.fragment_bluetooth_scanning, 4);
        sparseIntArray.put(R.layout.fragment_classic_troubleshooting, 5);
        sparseIntArray.put(R.layout.fragment_enter_device_name, 6);
        sparseIntArray.put(R.layout.fragment_wifi_password, 7);
        sparseIntArray.put(R.layout.holder_ssid_hidden, 8);
        sparseIntArray.put(R.layout.holder_ssid_regular, 9);
        sparseIntArray.put(R.layout.viewcore_appbar, 10);
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
                    if ("layout/activity_add_device_0".equals(tag)) {
                        return new ActivityAddDeviceBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_add_device is invalid. Received: " + tag);
                case 2:
                    if ("layout/fragment_add_device_success_0".equals(tag)) {
                        return new FragmentAddDeviceSuccessBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_add_device_success is invalid. Received: " + tag);
                case 3:
                    if ("layout/fragment_add_device_wifi_0".equals(tag)) {
                        return new FragmentAddDeviceWifiBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_add_device_wifi is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_bluetooth_scanning_0".equals(tag)) {
                        return new FragmentBluetoothScanningBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_bluetooth_scanning is invalid. Received: " + tag);
                case 5:
                    if ("layout/fragment_classic_troubleshooting_0".equals(tag)) {
                        return new FragmentClassicTroubleshootingBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_classic_troubleshooting is invalid. Received: " + tag);
                case 6:
                    if ("layout/fragment_enter_device_name_0".equals(tag)) {
                        return new FragmentEnterDeviceNameBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_enter_device_name is invalid. Received: " + tag);
                case 7:
                    if ("layout/fragment_wifi_password_0".equals(tag)) {
                        return new FragmentWifiPasswordBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_wifi_password is invalid. Received: " + tag);
                case 8:
                    if ("layout/holder_ssid_hidden_0".equals(tag)) {
                        return new HolderSsidHiddenBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_ssid_hidden is invalid. Received: " + tag);
                case 9:
                    if ("layout/holder_ssid_regular_0".equals(tag)) {
                        return new HolderSsidRegularBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_ssid_regular is invalid. Received: " + tag);
                case 10:
                    if ("layout/viewcore_appbar_0".equals(tag)) {
                        return new ViewcoreAppbarBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for viewcore_appbar is invalid. Received: " + tag);
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
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.airboxlab.icp.sdk.DataBinderMapperImpl());
        arrayList.add(new com.blueair.api.DataBinderMapperImpl());
        arrayList.add(new com.blueair.auth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.bluetooth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.core.DataBinderMapperImpl());
        arrayList.add(new com.blueair.devicemanager.DataBinderMapperImpl());
        arrayList.add(new com.blueair.sdk.DataBinderMapperImpl());
        arrayList.add(new com.blueair.viewcore.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(2);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "addDeviceViewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(10);
            sKeys = hashMap;
            hashMap.put("layout/activity_add_device_0", Integer.valueOf(R.layout.activity_add_device));
            hashMap.put("layout/fragment_add_device_success_0", Integer.valueOf(R.layout.fragment_add_device_success));
            hashMap.put("layout/fragment_add_device_wifi_0", Integer.valueOf(R.layout.fragment_add_device_wifi));
            hashMap.put("layout/fragment_bluetooth_scanning_0", Integer.valueOf(R.layout.fragment_bluetooth_scanning));
            hashMap.put("layout/fragment_classic_troubleshooting_0", Integer.valueOf(R.layout.fragment_classic_troubleshooting));
            hashMap.put("layout/fragment_enter_device_name_0", Integer.valueOf(R.layout.fragment_enter_device_name));
            hashMap.put("layout/fragment_wifi_password_0", Integer.valueOf(R.layout.fragment_wifi_password));
            hashMap.put("layout/holder_ssid_hidden_0", Integer.valueOf(R.layout.holder_ssid_hidden));
            hashMap.put("layout/holder_ssid_regular_0", Integer.valueOf(R.layout.holder_ssid_regular));
            hashMap.put("layout/viewcore_appbar_0", Integer.valueOf(R.layout.viewcore_appbar));
        }
    }
}
