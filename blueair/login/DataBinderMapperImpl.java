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
      SparseIntArray var0 = new SparseIntArray(9);
      INTERNAL_LAYOUT_ID_LOOKUP = var0;
      var0.put(R.layout.activity_delete_account_confirm, 1);
      var0.put(R.layout.activity_disable_iot_confirm, 2);
      var0.put(R.layout.activity_manage_my_account, 3);
      var0.put(R.layout.activity_post_delete_account, 4);
      var0.put(R.layout.activity_post_disable_iot, 5);
      var0.put(R.layout.activity_profile, 6);
      var0.put(R.layout.fragment_forgot_password, 7);
      var0.put(R.layout.fragment_register, 8);
      var0.put(R.layout.fragment_sign_in, 9);
   }

   public List collectDependencies() {
      ArrayList var1 = new ArrayList(7);
      var1.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
      var1.add(new com.blueair.auth.DataBinderMapperImpl());
      var1.add(new com.blueair.core.DataBinderMapperImpl());
      var1.add(new com.blueair.devicemanager.DataBinderMapperImpl());
      var1.add(new com.blueair.outdoor.DataBinderMapperImpl());
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
               if ("layout/activity_delete_account_confirm_0".equals(var4)) {
                  return new ActivityDeleteAccountConfirmBindingImpl(var1, var2);
               }

               StringBuilder var13 = new StringBuilder("The tag for activity_delete_account_confirm is invalid. Received: ");
               var13.append(var4);
               throw new IllegalArgumentException(var13.toString());
            case 2:
               if ("layout/activity_disable_iot_confirm_0".equals(var4)) {
                  return new ActivityDisableIotConfirmBindingImpl(var1, var2);
               }

               StringBuilder var12 = new StringBuilder("The tag for activity_disable_iot_confirm is invalid. Received: ");
               var12.append(var4);
               throw new IllegalArgumentException(var12.toString());
            case 3:
               if ("layout/activity_manage_my_account_0".equals(var4)) {
                  return new ActivityManageMyAccountBindingImpl(var1, var2);
               }

               StringBuilder var11 = new StringBuilder("The tag for activity_manage_my_account is invalid. Received: ");
               var11.append(var4);
               throw new IllegalArgumentException(var11.toString());
            case 4:
               if ("layout/activity_post_delete_account_0".equals(var4)) {
                  return new ActivityPostDeleteAccountBindingImpl(var1, var2);
               }

               StringBuilder var10 = new StringBuilder("The tag for activity_post_delete_account is invalid. Received: ");
               var10.append(var4);
               throw new IllegalArgumentException(var10.toString());
            case 5:
               if ("layout/activity_post_disable_iot_0".equals(var4)) {
                  return new ActivityPostDisableIotBindingImpl(var1, var2);
               }

               StringBuilder var9 = new StringBuilder("The tag for activity_post_disable_iot is invalid. Received: ");
               var9.append(var4);
               throw new IllegalArgumentException(var9.toString());
            case 6:
               if ("layout/activity_profile_0".equals(var4)) {
                  return new ActivityProfileBindingImpl(var1, var2);
               }

               StringBuilder var8 = new StringBuilder("The tag for activity_profile is invalid. Received: ");
               var8.append(var4);
               throw new IllegalArgumentException(var8.toString());
            case 7:
               if ("layout/fragment_forgot_password_0".equals(var4)) {
                  return new FragmentForgotPasswordBindingImpl(var1, var2);
               }

               StringBuilder var7 = new StringBuilder("The tag for fragment_forgot_password is invalid. Received: ");
               var7.append(var4);
               throw new IllegalArgumentException(var7.toString());
            case 8:
               if ("layout/fragment_register_0".equals(var4)) {
                  return new FragmentRegisterBindingImpl(var1, var2);
               }

               StringBuilder var6 = new StringBuilder("The tag for fragment_register is invalid. Received: ");
               var6.append(var4);
               throw new IllegalArgumentException(var6.toString());
            case 9:
               if ("layout/fragment_sign_in_0".equals(var4)) {
                  return new FragmentSignInBindingImpl(var1, var2);
               }

               StringBuilder var5 = new StringBuilder("The tag for fragment_sign_in is invalid. Received: ");
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
         var0.put(1, "viewModel");
      }
   }

   private static class InnerLayoutIdLookup {
      static final HashMap sKeys;

      static {
         HashMap var0 = new HashMap(9);
         sKeys = var0;
         var0.put("layout/activity_delete_account_confirm_0", R.layout.activity_delete_account_confirm);
         var0.put("layout/activity_disable_iot_confirm_0", R.layout.activity_disable_iot_confirm);
         var0.put("layout/activity_manage_my_account_0", R.layout.activity_manage_my_account);
         var0.put("layout/activity_post_delete_account_0", R.layout.activity_post_delete_account);
         var0.put("layout/activity_post_disable_iot_0", R.layout.activity_post_disable_iot);
         var0.put("layout/activity_profile_0", R.layout.activity_profile);
         var0.put("layout/fragment_forgot_password_0", R.layout.fragment_forgot_password);
         var0.put("layout/fragment_register_0", R.layout.fragment_register);
         var0.put("layout/fragment_sign_in_0", R.layout.fragment_sign_in);
      }
   }
}
