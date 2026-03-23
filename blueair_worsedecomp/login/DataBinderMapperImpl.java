package com.blueair.login;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.login.databinding.ActivityDeleteAccountConfirmBindingImpl;
import com.blueair.login.databinding.ActivityDisableIotConfirmBindingImpl;
import com.blueair.login.databinding.ActivityManageMyAccountBindingImpl;
import com.blueair.login.databinding.ActivityPostDeleteAccountBindingImpl;
import com.blueair.login.databinding.ActivityPostDisableIotBindingImpl;
import com.blueair.login.databinding.ActivityProfileBindingImpl;
import com.blueair.login.databinding.FragmentForgotPasswordBindingImpl;
import com.blueair.login.databinding.FragmentRegisterBindingImpl;
import com.blueair.login.databinding.FragmentSignInBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACTIVITYDELETEACCOUNTCONFIRM = 1;
    private static final int LAYOUT_ACTIVITYDISABLEIOTCONFIRM = 2;
    private static final int LAYOUT_ACTIVITYMANAGEMYACCOUNT = 3;
    private static final int LAYOUT_ACTIVITYPOSTDELETEACCOUNT = 4;
    private static final int LAYOUT_ACTIVITYPOSTDISABLEIOT = 5;
    private static final int LAYOUT_ACTIVITYPROFILE = 6;
    private static final int LAYOUT_FRAGMENTFORGOTPASSWORD = 7;
    private static final int LAYOUT_FRAGMENTREGISTER = 8;
    private static final int LAYOUT_FRAGMENTSIGNIN = 9;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(9);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.activity_delete_account_confirm, 1);
        sparseIntArray.put(R.layout.activity_disable_iot_confirm, 2);
        sparseIntArray.put(R.layout.activity_manage_my_account, 3);
        sparseIntArray.put(R.layout.activity_post_delete_account, 4);
        sparseIntArray.put(R.layout.activity_post_disable_iot, 5);
        sparseIntArray.put(R.layout.activity_profile, 6);
        sparseIntArray.put(R.layout.fragment_forgot_password, 7);
        sparseIntArray.put(R.layout.fragment_register, 8);
        sparseIntArray.put(R.layout.fragment_sign_in, 9);
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
                    if ("layout/activity_delete_account_confirm_0".equals(tag)) {
                        return new ActivityDeleteAccountConfirmBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_delete_account_confirm is invalid. Received: " + tag);
                case 2:
                    if ("layout/activity_disable_iot_confirm_0".equals(tag)) {
                        return new ActivityDisableIotConfirmBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_disable_iot_confirm is invalid. Received: " + tag);
                case 3:
                    if ("layout/activity_manage_my_account_0".equals(tag)) {
                        return new ActivityManageMyAccountBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_manage_my_account is invalid. Received: " + tag);
                case 4:
                    if ("layout/activity_post_delete_account_0".equals(tag)) {
                        return new ActivityPostDeleteAccountBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_post_delete_account is invalid. Received: " + tag);
                case 5:
                    if ("layout/activity_post_disable_iot_0".equals(tag)) {
                        return new ActivityPostDisableIotBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_post_disable_iot is invalid. Received: " + tag);
                case 6:
                    if ("layout/activity_profile_0".equals(tag)) {
                        return new ActivityProfileBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for activity_profile is invalid. Received: " + tag);
                case 7:
                    if ("layout/fragment_forgot_password_0".equals(tag)) {
                        return new FragmentForgotPasswordBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_forgot_password is invalid. Received: " + tag);
                case 8:
                    if ("layout/fragment_register_0".equals(tag)) {
                        return new FragmentRegisterBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_register is invalid. Received: " + tag);
                case 9:
                    if ("layout/fragment_sign_in_0".equals(tag)) {
                        return new FragmentSignInBindingImpl(dataBindingComponent, view);
                    }
                    throw new IllegalArgumentException("The tag for fragment_sign_in is invalid. Received: " + tag);
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
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.blueair.auth.DataBinderMapperImpl());
        arrayList.add(new com.blueair.core.DataBinderMapperImpl());
        arrayList.add(new com.blueair.devicemanager.DataBinderMapperImpl());
        arrayList.add(new com.blueair.outdoor.DataBinderMapperImpl());
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
            sparseArray.put(1, "viewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(9);
            sKeys = hashMap;
            hashMap.put("layout/activity_delete_account_confirm_0", Integer.valueOf(R.layout.activity_delete_account_confirm));
            hashMap.put("layout/activity_disable_iot_confirm_0", Integer.valueOf(R.layout.activity_disable_iot_confirm));
            hashMap.put("layout/activity_manage_my_account_0", Integer.valueOf(R.layout.activity_manage_my_account));
            hashMap.put("layout/activity_post_delete_account_0", Integer.valueOf(R.layout.activity_post_delete_account));
            hashMap.put("layout/activity_post_disable_iot_0", Integer.valueOf(R.layout.activity_post_disable_iot));
            hashMap.put("layout/activity_profile_0", Integer.valueOf(R.layout.activity_profile));
            hashMap.put("layout/fragment_forgot_password_0", Integer.valueOf(R.layout.fragment_forgot_password));
            hashMap.put("layout/fragment_register_0", Integer.valueOf(R.layout.fragment_register));
            hashMap.put("layout/fragment_sign_in_0", Integer.valueOf(R.layout.fragment_sign_in));
        }
    }
}
