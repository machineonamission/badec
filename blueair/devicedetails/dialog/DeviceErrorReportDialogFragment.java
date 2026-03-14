package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import com.blueair.core.model.HasCompatibility;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.DialogfragmentDeviceErrorReportBinding;
import com.blueair.devicedetails.viewholder.DeviceInfoItem;
import com.blueair.viewcore.R;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import io.flatcircle.connectivityhelper.NetUtil;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceErrorReportDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "viewDataBinding", "Lcom/blueair/devicedetails/databinding/DialogfragmentDeviceErrorReportBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceErrorReportDialogFragment extends DialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public Device device;
   private DialogfragmentDeviceErrorReportBinding viewDataBinding;

   // $FF: synthetic method
   public static boolean $r8$lambda$LWfknXtE2MMDBQW24bRkAjMoBzg(DeviceErrorReportDialogFragment var0, MenuItem var1) {
      return onCreateView$lambda$2(var0, var1);
   }

   private static final boolean onCreateView$lambda$2(DeviceErrorReportDialogFragment var0, MenuItem var1) {
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
      FragmentActivity var6 = this.getActivity();
      if (var6 != null) {
         Window var5 = var4.getWindow();
         if (var5 != null) {
            var5.setBackgroundDrawable(ContextCompat.getDrawable((Context)var6, R.drawable.top_rounded_rectangle_white));
         }
      }

      return var4;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      DialogfragmentDeviceErrorReportBinding var14 = DialogfragmentDeviceErrorReportBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var14, "inflate(...)");
      this.viewDataBinding = var14;
      Object var13 = null;
      DialogfragmentDeviceErrorReportBinding var6 = var14;
      if (var14 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var6 = null;
      }

      var6.toolbar.getMenu().findItem(com.blueair.devicedetails.R.id.action_close).setOnMenuItemClickListener(new DeviceErrorReportDialogFragment$$ExternalSyntheticLambda0(this));
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

      DialogfragmentDeviceErrorReportBinding var16 = this.viewDataBinding;
      DialogfragmentDeviceErrorReportBinding var10 = var16;
      if (var16 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var10 = null;
      }

      var10.recyclerViewDeviceInfo.addItemDecoration((RecyclerView.ItemDecoration)var5);
      var10 = this.viewDataBinding;
      if (var10 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
         var10 = (DialogfragmentDeviceErrorReportBinding)var13;
      }

      View var12 = var10.getRoot();
      Intrinsics.checkNotNullExpressionValue(var12, "getRoot(...)");
      return var12;
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
      Dialog var6 = this.getDialog();
      if (var6 != null) {
         Window var7 = var6.getWindow();
         if (var7 != null) {
            WindowManager.LayoutParams var8 = var7.getAttributes();
            if (var8 != null) {
               var8.windowAnimations = R.style.dialog_animation;
            }
         }
      }

      Bundle var9 = this.getArguments();
      Object var16 = null;
      Device var10;
      if (var9 != null) {
         var10 = (Device)var9.getParcelable("device");
      } else {
         var10 = null;
      }

      if (var10 != null) {
         this.setDevice(var10);
         var10 = this.getDevice();
         String var13;
         if (var10 instanceof HasSKU) {
            Device var12 = this.getDevice();
            Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type com.blueair.core.model.HasSKU");
            var13 = ((HasSKU)var12).getSku();
         } else if (var10 instanceof HasCompatibility) {
            Device var14 = this.getDevice();
            Intrinsics.checkNotNull(var14, "null cannot be cast to non-null type com.blueair.core.model.HasCompatibility");
            var13 = ((HasCompatibility)var14).getCompatibility();
         } else {
            var13 = this.getDevice().getModelName();
         }

         ItemAdapter var5 = new ItemAdapter();
         DeviceInfoItem var3 = new DeviceInfoItem(TuplesKt.to("App version", "v 4.5.2 (2366)"));
         StringBuilder var4 = new StringBuilder();
         var4.append(Build.DEVICE);
         var4.append(' ');
         var4.append(Build.MODEL);
         var5.add(new DeviceInfoItem[]{var3, new DeviceInfoItem(TuplesKt.to("Phone model", var4.toString())), new DeviceInfoItem(TuplesKt.to("Phone OS version", String.valueOf(VERSION.SDK_INT))), new DeviceInfoItem(TuplesKt.to("Device UUID", String.valueOf(this.getDevice().getUid()))), new DeviceInfoItem(TuplesKt.to("Device SKU", String.valueOf(var13))), new DeviceInfoItem(TuplesKt.to("Device MAC", String.valueOf(this.getDevice().getMac()))), new DeviceInfoItem(TuplesKt.to("Wifi info", String.valueOf(NetUtil.INSTANCE.getActiveWifiInfo(this.getContext()))))});
         FastAdapter var17 = FastAdapter.Companion.with((IAdapter)var5);
         DialogfragmentDeviceErrorReportBinding var15 = this.viewDataBinding;
         if (var15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewDataBinding");
            var15 = (DialogfragmentDeviceErrorReportBinding)var16;
         }

         var15.recyclerViewDeviceInfo.swapAdapter((RecyclerView.Adapter)var17, false);
      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceErrorReportDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceErrorReportDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceErrorReportDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceErrorReportDialogFragment var3 = new DeviceErrorReportDialogFragment();
         Bundle var2 = new Bundle();
         var2.putParcelable("device", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
