package com.blueair.devicedetails.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.BR;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.blueair.graph.view.FanHistoryGraphView;
import com.blueair.graph.view.IndoorGraphView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

public class FragmentDeviceSensorsBindingImpl extends FragmentDeviceSensorsBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.sensor_tabs, 1);
      var0.put(R.id.device_graph, 2);
      var0.put(R.id.device_graph_footer, 3);
      var0.put(R.id.fan_value, 4);
      var0.put(R.id.button_collapse, 5);
      var0.put(R.id.fan_graph, 6);
      var0.put(R.id.separator, 7);
   }

   public FragmentDeviceSensorsBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 8, sIncludes, sViewsWithIds));
   }

   private FragmentDeviceSensorsBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (MaterialButton)var3[5], (IndoorGraphView)var3[2], (ConstraintLayout)var3[3], (FanHistoryGraphView)var3[6], (TextView)var3[4], (TabLayout)var3[1], (View)var3[7]);
      this.mDirtyFlags = -1L;
      ConstraintLayout var4 = (ConstraintLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   protected void executeBindings() {
      // $FF: Couldn't be decompiled
   }

   public boolean hasPendingBindings() {
      synchronized(this){}

      Throwable var10000;
      label123: {
         try {
            if (this.mDirtyFlags != 0L) {
               return true;
            }
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var10001 = false;
            break label123;
         }

         label117:
         try {
            return false;
         } catch (Throwable var12) {
            var10000 = var12;
            boolean var14 = false;
            break label117;
         }
      }

      while(true) {
         Throwable var1 = var10000;

         try {
            throw var1;
         } catch (Throwable var11) {
            var10000 = var11;
            boolean var15 = false;
            continue;
         }
      }
   }

   public void invalidateAll() {
      // $FF: Couldn't be decompiled
   }

   protected boolean onFieldChange(int var1, Object var2, int var3) {
      return false;
   }

   public void setDeviceSensorViewModel(DeviceSensorsViewModel var1) {
      this.mDeviceSensorViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.deviceSensorViewModel == var1) {
         this.setDeviceSensorViewModel((DeviceSensorsViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
