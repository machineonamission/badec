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
      SparseIntArray var0 = new SparseIntArray(6);
      INTERNAL_LAYOUT_ID_LOOKUP = var0;
      var0.put(R.layout.dialogfragment_popup_info, 1);
      var0.put(R.layout.dialogfragment_select_device_filter, 2);
      var0.put(R.layout.dialogfragment_step_guide, 3);
      var0.put(R.layout.fragment_webview, 4);
      var0.put(R.layout.holder_device_filter, 5);
      var0.put(R.layout.holder_filter_type, 6);
   }

   public List collectDependencies() {
      ArrayList var1 = new ArrayList(5);
      var1.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
      var1.add(new com.blueair.auth.DataBinderMapperImpl());
      var1.add(new com.blueair.core.DataBinderMapperImpl());
      var1.add(new com.blueair.devicemanager.DataBinderMapperImpl());
      var1.add(new com.blueair.sdk.DataBinderMapperImpl());
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
               if ("layout/dialogfragment_popup_info_0".equals(var4)) {
                  return new DialogfragmentPopupInfoBindingImpl(var1, var2);
               }

               StringBuilder var10 = new StringBuilder("The tag for dialogfragment_popup_info is invalid. Received: ");
               var10.append(var4);
               throw new IllegalArgumentException(var10.toString());
            case 2:
               if ("layout/dialogfragment_select_device_filter_0".equals(var4)) {
                  return new DialogfragmentSelectDeviceFilterBindingImpl(var1, var2);
               }

               StringBuilder var9 = new StringBuilder("The tag for dialogfragment_select_device_filter is invalid. Received: ");
               var9.append(var4);
               throw new IllegalArgumentException(var9.toString());
            case 3:
               if ("layout/dialogfragment_step_guide_0".equals(var4)) {
                  return new DialogfragmentStepGuideBindingImpl(var1, var2);
               }

               StringBuilder var8 = new StringBuilder("The tag for dialogfragment_step_guide is invalid. Received: ");
               var8.append(var4);
               throw new IllegalArgumentException(var8.toString());
            case 4:
               if ("layout/fragment_webview_0".equals(var4)) {
                  return new FragmentWebviewBindingImpl(var1, var2);
               }

               StringBuilder var7 = new StringBuilder("The tag for fragment_webview is invalid. Received: ");
               var7.append(var4);
               throw new IllegalArgumentException(var7.toString());
            case 5:
               if ("layout/holder_device_filter_0".equals(var4)) {
                  return new HolderDeviceFilterBindingImpl(var1, var2);
               }

               StringBuilder var6 = new StringBuilder("The tag for holder_device_filter is invalid. Received: ");
               var6.append(var4);
               throw new IllegalArgumentException(var6.toString());
            case 6:
               if ("layout/holder_filter_type_0".equals(var4)) {
                  return new HolderFilterTypeBindingImpl(var1, var2);
               }

               StringBuilder var5 = new StringBuilder("The tag for holder_filter_type is invalid. Received: ");
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
         SparseArray var0 = new SparseArray(1);
         sKeys = var0;
         var0.put(0, "_all");
      }
   }

   private static class InnerLayoutIdLookup {
      static final HashMap sKeys;

      static {
         HashMap var0 = new HashMap(6);
         sKeys = var0;
         var0.put("layout/dialogfragment_popup_info_0", R.layout.dialogfragment_popup_info);
         var0.put("layout/dialogfragment_select_device_filter_0", R.layout.dialogfragment_select_device_filter);
         var0.put("layout/dialogfragment_step_guide_0", R.layout.dialogfragment_step_guide);
         var0.put("layout/fragment_webview_0", R.layout.fragment_webview);
         var0.put("layout/holder_device_filter_0", R.layout.holder_device_filter);
         var0.put("layout/holder_filter_type_0", R.layout.holder_filter_type);
      }
   }
}
