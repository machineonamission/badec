package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.adapter.DeviceInfoAdapter;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceSettingInfoBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.EmptyViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DIAware;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 12\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00011B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0012\u0010#\u001a\u00020$2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010-\u001a\u00020\u001eH\u0016J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u00062"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSettingInfoDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "Lorg/kodein/di/DIAware;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/EmptyViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/EmptyViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceSettingInfoBinding;", "adapter", "Lcom/blueair/devicedetails/adapter/DeviceInfoAdapter;", "getAdapter", "()Lcom/blueair/devicedetails/adapter/DeviceInfoAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "showProgress", "shouldShowProgress", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceSettingInfoDialogFragment extends BaseDialogFragment implements DIAware {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final Lazy adapter$delegate = LazyKt.lazy(new DeviceSettingInfoDialogFragment$$ExternalSyntheticLambda1());
   public Device device;
   private final String screenName = "device_settings_info";
   private DialogfragmentDeviceSettingInfoBinding viewDataBinding;
   public EmptyViewModel viewModel;

   // $FF: synthetic method
   public static boolean $r8$lambda$Fl_Ly7AVLcXQOTNcAL3GvOIKE_w/* $FF was: $r8$lambda$Fl-Ly7AVLcXQOTNcAL3GvOIKE_w*/(DeviceSettingInfoDialogFragment var0, MenuItem var1) {
      return onCreateView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static DeviceInfoAdapter $r8$lambda$ps8KPuNLyObWv6l0x3Xv8mLEzME() {
      return adapter_delegate$lambda$0();
   }

   private static final DeviceInfoAdapter adapter_delegate$lambda$0() {
      return new DeviceInfoAdapter();
   }

   private final DeviceInfoAdapter getAdapter() {
      return (DeviceInfoAdapter)this.adapter$delegate.getValue();
   }

   private static final boolean onCreateView$lambda$3(DeviceSettingInfoDialogFragment var0, MenuItem var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      var0.dismiss();
      return true;
   }

   public final Device getDevice() {
      Device var1 = this.device;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("device");
         return null;
      }
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public EmptyViewModel getViewModel() {
      EmptyViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setStyle(0, R.style.DialogTheme);
   }

   public Dialog onCreateDialog(Bundle var1) {
      Timber.Forest.d("DialogFragment: onCreateDialog", new Object[0]);
      Dialog var4 = new Dialog(this.requireContext());
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("onCreateDialog: dialog = ");
      var2.append(var4);
      var3.d(var2.toString(), new Object[0]);
      FragmentActivity var5 = this.getActivity();
      if (var5 != null) {
         Window var6 = var4.getWindow();
         if (var6 != null) {
            var6.setBackgroundDrawable(ContextCompat.getDrawable((Context)var5, R.drawable.top_rounded_rectangle_white));
         }
      }

      return var4;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      this.setViewModel((EmptyViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)(this))).get(EmptyViewModel.class)));
      DialogfragmentDeviceSettingInfoBinding var14 = DialogfragmentDeviceSettingInfoBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      this.viewDataBinding = var14;
      Object var13 = null;
      DialogfragmentDeviceSettingInfoBinding var6 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new DeviceSettingInfoDialogFragment$$ExternalSyntheticLambda0(this));
      DividerItemDecoration var5 = new DividerItemDecoration(this.getContext(), 1);
      Resources var15 = this.getResources();
      int var4 = com.blueair.devicedetails.R.drawable.item_decoration;
      FragmentActivity var7 = this.getActivity();
      Resources.Theme var8;
      if (var7 != null) {
         var8 = var7.getTheme();
      } else {
         var8 = null;
      }

      Drawable var9 = ResourcesCompat.getDrawable(var15, var4, var8);
      if (var9 != null) {
         var5.setDrawable(var9);
      }

      DialogfragmentDeviceSettingInfoBinding var16 = this.viewDataBinding;
      DialogfragmentDeviceSettingInfoBinding var10 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var10 = null;
      }

      var10.recyclerViewDeviceInfo.addItemDecoration((RecyclerView.ItemDecoration)var5);
      var10 = this.viewDataBinding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var10 = (DialogfragmentDeviceSettingInfoBinding)var13;
      }

      View var12 = var10.getRoot();
      Intrinsics.checkNotNullExpressionValue(var12, "getRoot(...)");
      return var12;
   }

   public void onResume() {
      super.onResume();
      DialogfragmentDeviceSettingInfoBinding var2 = this.viewDataBinding;
      DialogfragmentDeviceSettingInfoBinding var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var1 = null;
      }

      var1.recyclerViewDeviceInfo.setAdapter(this.getAdapter());
      this.getAdapter().setDevice(this.getDevice());
   }

   public void onStart() {
      super.onStart();
      Dialog var2 = this.getDialog();
      if (var2 != null) {
         Window var1 = var2.getWindow();
         if (var1 != null) {
            var1.setLayout(-1, -2);
         }

         var1 = var2.getWindow();
         if (var1 != null) {
            var1.setGravity(80);
         }
      }

   }

   public void onStop() {
      Dialog var1 = this.getDialog();
      if (var1 != null) {
         Window var2 = var1.getWindow();
         if (var2 != null) {
            WindowManager.LayoutParams var3 = var2.getAttributes();
            if (var3 != null) {
               var3.windowAnimations = R.style.dialog_animation_exit_only;
            }
         }
      }

      super.onStop();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Dialog var3 = this.getDialog();
      if (var3 != null) {
         Window var4 = var3.getWindow();
         if (var4 != null) {
            WindowManager.LayoutParams var5 = var4.getAttributes();
            if (var5 != null) {
               var5.windowAnimations = R.style.dialog_animation;
            }
         }
      }

      Bundle var6 = this.getArguments();
      Device var7;
      if (var6 != null) {
         var7 = (Device)var6.getParcelable("device");
      } else {
         var7 = null;
      }

      if (var7 != null) {
         this.setDevice(var7);
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setViewModel(EmptyViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceSettingInfoDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceSettingInfoDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceSettingInfoDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceSettingInfoDialogFragment var3 = new DeviceSettingInfoDialogFragment();
         Bundle var2 = new Bundle();
         var2.putParcelable("device", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
