package com.blueair.adddevice.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.blueair.adddevice.BR;
import com.blueair.adddevice.R;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;

public class ActivityAddDeviceBindingImpl extends ActivityAddDeviceBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;

   static {
      ViewDataBinding.IncludedLayouts var1 = new ViewDataBinding.IncludedLayouts(5);
      sIncludes = var1;
      int var0 = R.layout.viewcore_appbar;
      var1.setIncludes(0, new String[]{"viewcore_appbar"}, new int[]{1}, new int[]{var0});
      SparseIntArray var2 = new SparseIntArray();
      sViewsWithIds = var2;
      var2.put(R.id.bottomButtonsBarrier, 2);
      var2.put(R.id.content_fragment, 3);
      var2.put(R.id.help_button, 4);
   }

   public ActivityAddDeviceBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 5, sIncludes, sViewsWithIds));
   }

   private ActivityAddDeviceBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 1, (Barrier)var3[2], (FrameLayout)var3[3], (AppCompatTextView)var3[4], (ViewcoreAppbarBinding)var3[1]);
      this.mDirtyFlags = -1L;
      ConstraintLayout var4 = (ConstraintLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.setContainedBinding(this.viewcoreAppbar);
      this.setRootTag(var2);
      this.invalidateAll();
   }

   private boolean onChangeViewcoreAppbar(ViewcoreAppbarBinding param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   protected void executeBindings() {
      // $FF: Couldn't be decompiled
   }

   public boolean hasPendingBindings() {
      synchronized(this){}

      Throwable var10000;
      label153: {
         try {
            if (this.mDirtyFlags != 0L) {
               return true;
            }
         } catch (Throwable var13) {
            var10000 = var13;
            boolean var10001 = false;
            break label153;
         }

         try {
            ;
         } catch (Throwable var12) {
            var10000 = var12;
            boolean var14 = false;
            break label153;
         }

         if (this.viewcoreAppbar.hasPendingBindings()) {
            return true;
         }

         return false;
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
      return var1 != 0 ? false : this.onChangeViewcoreAppbar((ViewcoreAppbarBinding)var2, var3);
   }

   public void setAddDeviceViewModel(AddDeviceViewModel var1) {
      this.mAddDeviceViewModel = var1;
   }

   public void setLifecycleOwner(LifecycleOwner var1) {
      super.setLifecycleOwner(var1);
      this.viewcoreAppbar.setLifecycleOwner(var1);
   }

   public boolean setVariable(int var1, Object var2) {
      if (BR.addDeviceViewModel == var1) {
         this.setAddDeviceViewModel((AddDeviceViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
