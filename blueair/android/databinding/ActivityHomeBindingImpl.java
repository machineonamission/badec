package com.blueair.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.blueair.android.R;
import com.blueair.android.generated.callback.OnRefreshListener;
import com.blueair.android.viewmodel.HomeViewModel;
import com.blueair.viewcore.view.AbsorbInsetFrameLayout;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;
import com.yuyakaido.android.cardstackview.CardStackView;

public class ActivityHomeBindingImpl extends ActivityHomeBinding implements OnRefreshListener.Listener {
   private static final ViewDataBinding.IncludedLayouts sIncludes;
   private static final SparseIntArray sViewsWithIds;
   private final SwipeRefreshLayout.OnRefreshListener mCallback1;
   private long mDirtyFlags;
   private final AbsorbInsetFrameLayout mboundView0;

   static {
      SparseIntArray var0 = new SparseIntArray();
      sViewsWithIds = var0;
      var0.put(R.id.drawerLayout, 4);
      var0.put(R.id.aqi_animation_background, 5);
      var0.put(R.id.toolbar, 6);
      var0.put(R.id.btn_menu, 7);
      var0.put(R.id.btn_add, 8);
      var0.put(R.id.content_container, 9);
      var0.put(R.id.cl_header, 10);
      var0.put(R.id.tv_indoorLabel, 11);
      var0.put(R.id.cs_notification, 12);
      var0.put(R.id.outdoor_container, 13);
      var0.put(R.id.indoor_container, 14);
      var0.put(R.id.nv_drawer, 15);
      var0.put(R.id.cl_drawer, 16);
      var0.put(R.id.statusBar_drawer, 17);
      var0.put(R.id.drawer_close_view, 18);
      var0.put(R.id.tv_menu, 19);
      var0.put(R.id.ll_drawerHeader, 20);
      var0.put(R.id.iv_leading, 21);
      var0.put(R.id.tv_name, 22);
      var0.put(R.id.rv_drawer, 23);
      var0.put(R.id.drawer_signin, 24);
      var0.put(R.id.build, 25);
   }

   public ActivityHomeBindingImpl(DataBindingComponent var1, View var2) {
      this(var1, var2, mapBindings(var1, var2, 26, sIncludes, sViewsWithIds));
   }

   private ActivityHomeBindingImpl(DataBindingComponent var1, View var2, Object[] var3) {
      super(var1, var2, 3, (ComposeView)var3[5], (AppCompatImageButton)var3[8], (AppCompatImageButton)var3[7], (TextView)var3[25], (ConstraintLayout)var3[16], (ConstraintLayout)var3[10], (LinearLayout)var3[9], (CardStackView)var3[12], (AppCompatImageView)var3[18], (DrawerLayout)var3[4], (MaterialButton)var3[24], (FrameLayout)var3[14], (AppCompatImageView)var3[21], (LinearLayout)var3[20], (NavigationView)var3[15], (FrameLayout)var3[13], (RecyclerView)var3[23], (SimpleStatusBar)var3[17], (SwipeRefreshLayout)var3[1], (ConstraintLayout)var3[6], (TextView)var3[3], (AppCompatTextView)var3[2], (TextView)var3[11], (AppCompatTextView)var3[19], (AppCompatTextView)var3[22]);
      this.mDirtyFlags = -1L;
      AbsorbInsetFrameLayout var4 = (AbsorbInsetFrameLayout)var3[0];
      this.mboundView0 = var4;
      var4.setTag((Object)null);
      this.swipeRefresh.setTag((Object)null);
      this.tvIndoorAirState.setTag((Object)null);
      this.tvIndoorDeviceNum.setTag((Object)null);
      this.setRootTag(var2);
      this.mCallback1 = new OnRefreshListener(this, 1);
      this.invalidateAll();
   }

   private boolean onChangeHomeViewModelDeviceNum(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeHomeViewModelIsLoading(MediatorLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private boolean onChangeHomeViewModelLvAirStateStringRes(MutableLiveData param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public final void _internalCallbackOnRefresh(int var1) {
      HomeViewModel var2 = this.mHomeViewModel;
      if (var2 != null) {
         var2.onSwipeToRefresh();
      }

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
      if (var1 != 0) {
         if (var1 != 1) {
            return var1 != 2 ? false : this.onChangeHomeViewModelIsLoading((MediatorLiveData)var2, var3);
         } else {
            return this.onChangeHomeViewModelLvAirStateStringRes((MutableLiveData)var2, var3);
         }
      } else {
         return this.onChangeHomeViewModelDeviceNum((MutableLiveData)var2, var3);
      }
   }

   public void setHomeViewModel(HomeViewModel param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean setVariable(int var1, Object var2) {
      if (7 == var1) {
         this.setHomeViewModel((HomeViewModel)var2);
         return true;
      } else {
         return false;
      }
   }
}
