package com.blueair.adddevice.fragment.legacy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.R;
import com.blueair.adddevice.service.AddDeviceService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigProgressFragment;", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceProgressFragment;", "<init>", "()V", "rootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRootView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceAutoConfigProgressFragment extends AddDeviceProgressFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private ConstraintLayout rootView;

   public ConstraintLayout getRootView() {
      ConstraintLayout var2 = this.rootView;
      ConstraintLayout var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rootView");
         var1 = null;
      }

      return var1;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      int var4;
      if (this.getDeviceModelType() == 3) {
         var4 = R.layout.fragment_add_device_auto_config_progress_classic;
      } else {
         var4 = R.layout.fragment_add_device_auto_config_progress;
      }

      View var5 = var1.inflate(var4, var2, false);
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
      ConstraintLayout var12 = (ConstraintLayout)var5;
      this.rootView = var12;
      Object var11 = null;
      ConstraintLayout var6 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rootView");
         var6 = null;
      }

      TextView var7 = (TextView)var6.findViewById(R.id.textAddDeviceSubtitle);
      if (var7 != null) {
         var7.setText(com.blueair.viewcore.R.string.add_device_progress);
      }

      Context var8 = this.getContext();
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      ActionBar var9 = ((AppCompatActivity)var8).getSupportActionBar();
      if (var9 != null) {
         var9.setDisplayHomeAsUpEnabled(false);
      }

      ConstraintLayout var10 = this.rootView;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("rootView");
         var10 = (ConstraintLayout)var11;
      }

      return (View)var10;
   }

   public void onResume() {
      super.onResume();
      AddDeviceService.autoPairDevice$default(this.getAddService(), (String)null, (String)null, 3, (Object)null);
      if (this.getDeviceModelType() == 3) {
         FragmentActivity var1 = this.getActivity();
         Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
         ActionBar var2 = ((AppCompatActivity)var1).getSupportActionBar();
         if (var2 != null) {
            var2.setTitle((CharSequence)this.getString(com.blueair.viewcore.R.string.connect));
         }

         this.hideLoading();
      }

   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigProgressFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigProgressFragment;", "deviceModelType", "", "adddevice_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final AddDeviceAutoConfigProgressFragment newInstance(int var1) {
         AddDeviceAutoConfigProgressFragment var3 = new AddDeviceAutoConfigProgressFragment();
         Bundle var2 = new Bundle();
         var2.putInt("deviceModelType", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
