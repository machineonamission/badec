package com.blueair.devicedetails.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.Device;
import com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.BaseEditDeviceNameDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0006H\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001d"},
   d2 = {"Lcom/blueair/devicedetails/dialog/DeviceEditNameDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditDeviceNameDialogFragment;", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "setViewModel", "(Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;)V", "device", "Lcom/blueair/core/model/Device;", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onSaveBtnClicked", "text", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceEditNameDialogFragment extends BaseEditDeviceNameDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public Device device;
   private final String screenName;
   public DeviceDetailsViewModel viewModel;

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

   public DeviceDetailsViewModel getViewModel() {
      DeviceDetailsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   protected void onSaveBtnClicked(String var1) {
      Intrinsics.checkNotNullParameter(var1, "text");
      this.getViewModel().setDeviceName(this.getDevice(), var1);
      super.onSaveBtnClicked(var1);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      TextView var4 = this.getDialogTitle();
      Object var15 = null;
      if (var4 != null) {
         Context var5 = this.getContext();
         CharSequence var6;
         if (var5 != null) {
            var6 = var5.getText(R.string.edit_purifier_name_title);
         } else {
            var6 = null;
         }

         var4.setText(var6);
      }

      var4 = this.getDialogMsg();
      if (var4 != null) {
         Context var7 = this.getContext();
         CharSequence var8;
         if (var7 != null) {
            var8 = var7.getText(R.string.edit_purifier_name_msg);
         } else {
            var8 = null;
         }

         var4.setText(var8);
      }

      Bundle var17 = this.getArguments();
      Device var9 = (Device)var15;
      if (var17 != null) {
         var9 = (Device)var17.getParcelable("device");
      }

      if (var9 != null) {
         this.setDevice(var9);
         FragmentActivity var10 = ((BaseDialogFragment)this).requireActivity();
         Intrinsics.checkNotNullExpressionValue(var10, "requireActivity(...)");
         this.setViewModel((DeviceDetailsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var10)).get(DeviceDetailsViewModel.class)));
         EditText var11 = this.getEditText();
         if (var11 != null) {
            var11.setText((CharSequence)this.getDevice().getName());
         }

         var11 = this.getEditText();
         if (var11 != null) {
            Editable var13 = var11.getText();
            if (var13 != null) {
               int var3 = var13.length();
               EditText var14 = this.getEditText();
               if (var14 != null) {
                  var14.setSelection(var3);
               }
            }
         }

      } else {
         throw new IllegalStateException("Required value was null.".toString());
      }
   }

   public final void setDevice(Device var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.device = var1;
   }

   public void setViewModel(DeviceDetailsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/dialog/DeviceEditNameDialogFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/dialog/DeviceEditNameDialogFragment;", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"},
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

      public final DeviceEditNameDialogFragment newInstance(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         DeviceEditNameDialogFragment var3 = new DeviceEditNameDialogFragment();
         Bundle var2 = new Bundle();
         var2.putParcelable("device", var1);
         var3.setArguments(var2);
         return var3;
      }
   }
}
