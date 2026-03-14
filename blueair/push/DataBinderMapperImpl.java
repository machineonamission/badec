package com.blueair.push;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
   private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(0);

   public List collectDependencies() {
      ArrayList var1 = new ArrayList(7);
      var1.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
      var1.add(new com.blueair.api.DataBinderMapperImpl());
      var1.add(new com.blueair.auth.DataBinderMapperImpl());
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
      if (INTERNAL_LAYOUT_ID_LOOKUP.get(var3) > 0 && var2.getTag() == null) {
         throw new RuntimeException("view must have a tag");
      } else {
         return null;
      }
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
      static final HashMap sKeys = new HashMap(0);
   }
}
