package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.util.SimpleScrollingPagerIndicator;
import com.blueair.android.viewmodel.OutdoorViewModel;

public class FragmentOutdoorBindingImpl extends FragmentOutdoorBinding {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private long mDirtyFlags;
   private final ConstraintLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.outdoor_title, 1);
      var0.put(R.id.rv_location, 2);
      var0.put(R.id.page_dots, 3);
   }

   public FragmentOutdoorBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 4, sIncludes, sViewsWithIds));
   }

   private FragmentOutdoorBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 0, (TextView)var3[1], (SimpleScrollingPagerIndicator)var3[3], (RecyclerView)var3[2]);
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

   public void setOutdoorViewModel(OutdoorViewModel var1) {
      this.mOutdoorViewModel = var1;
   }

   public boolean setVariable(int var1, Object var2) {
      if (9 == var1) {
         this.setOutdoorViewModel((OutdoorViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
