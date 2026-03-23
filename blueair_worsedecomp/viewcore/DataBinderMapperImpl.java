package com.blueair.viewcore;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.viewcore.databinding.DialogfragmentPopupInfoBindingImpl;
import com.blueair.viewcore.databinding.DialogfragmentSelectDeviceFilterBindingImpl;
import com.blueair.viewcore.databinding.DialogfragmentStepGuideBindingImpl;
import com.blueair.viewcore.databinding.FragmentWebviewBindingImpl;
import com.blueair.viewcore.databinding.HolderDeviceFilterBindingImpl;
import com.blueair.viewcore.databinding.HolderFilterTypeBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_DIALOGFRAGMENTPOPUPINFO = 1;
    private static final int LAYOUT_DIALOGFRAGMENTSELECTDEVICEFILTER = 2;
    private static final int LAYOUT_DIALOGFRAGMENTSTEPGUIDE = 3;
    private static final int LAYOUT_FRAGMENTWEBVIEW = 4;
    private static final int LAYOUT_HOLDERDEVICEFILTER = 5;
    private static final int LAYOUT_HOLDERFILTERTYPE = 6;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(6);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.dialogfragment_popup_info, 1);
        sparseIntArray.put(R.layout.dialogfragment_select_device_filter, 2);
        sparseIntArray.put(R.layout.dialogfragment_step_guide, 3);
        sparseIntArray.put(R.layout.fragment_webview, 4);
        sparseIntArray.put(R.layout.holder_device_filter, 5);
        sparseIntArray.put(R.layout.holder_filter_type, 6);
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
                    if ("layout/dialogfragment_popup_info_0".equals(tag)) {
                        return new DialogfragmentPopupInfoBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_popup_info is invalid. Received: " + tag);
                case 2:
                    if ("layout/dialogfragment_select_device_filter_0".equals(tag)) {
                        return new DialogfragmentSelectDeviceFilterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_select_device_filter is invalid. Received: " + tag);
                case 3:
                    if ("layout/dialogfragment_step_guide_0".equals(tag)) {
                        return new DialogfragmentStepGuideBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for dialogfragment_step_guide is invalid. Received: " + tag);
                case 4:
                    if ("layout/fragment_webview_0".equals(tag)) {
                        return new FragmentWebviewBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_webview is invalid. Received: " + tag);
                case 5:
                    if ("layout/holder_device_filter_0".equals(tag)) {
                        return new HolderDeviceFilterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_device_filter is invalid. Received: " + tag);
                case 6:
                    if ("layout/holder_filter_type_0".equals(tag)) {
                        return new HolderFilterTypeBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for holder_filter_type is invalid. Received: " + tag);
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
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.blueair.auth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.core.DataBinderMapperImpl());
        arrayList.add(new com.blueair.devicemanager.DataBinderMapperImpl());
        arrayList.add(new com.blueair.sdk.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(1);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(6);
            sKeys = hashMap;
            hashMap.put("layout/dialogfragment_popup_info_0", Integer.valueOf(R.layout.dialogfragment_popup_info));
            hashMap.put("layout/dialogfragment_select_device_filter_0", Integer.valueOf(R.layout.dialogfragment_select_device_filter));
            hashMap.put("layout/dialogfragment_step_guide_0", Integer.valueOf(R.layout.dialogfragment_step_guide));
            hashMap.put("layout/fragment_webview_0", Integer.valueOf(R.layout.fragment_webview));
            hashMap.put("layout/holder_device_filter_0", Integer.valueOf(R.layout.holder_device_filter));
            hashMap.put("layout/holder_filter_type_0", Integer.valueOf(R.layout.holder_filter_type));
        }
    }
}
