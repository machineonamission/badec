package com.blueair.adddevice.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.BaseEditDeviceNameDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0006H\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"},
   d2 = {"Lcom/blueair/adddevice/dialog/EnterDeviceNameDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditDeviceNameDialogFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Landroid/view/View;", "onSaveBtnClicked", "text", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class EnterDeviceNameDialogFragment extends BaseEditDeviceNameDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String DEVICE_NAME = "device_name";
   public static final String SET_NAME_REQUEST_KEY = "set_name";
   private final String screenName;
   public AddDeviceViewModel viewModel;

   protected String getScreenName() {
      return this.screenName;
   }

   public AddDeviceViewModel getViewModel() {
      AddDeviceViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public Dialog onCreateDialog(Bundle var1) {
      FragmentActivity var2 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var2, "requireActivity(...)");
      this.setViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var2)).get(AddDeviceViewModel.class)));
      return super.onCreateDialog(var1);
   }

   protected void onSaveBtnClicked(String var1) {
      Intrinsics.checkNotNullParameter(var1, "text");
      FragmentKt.setFragmentResult((Fragment)this, "set_name", BundleKt.bundleOf(new Pair[]{TuplesKt.to("device_name", var1)}));
      super.onSaveBtnClicked(var1);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentActivity var4 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
      this.setViewModel((AddDeviceViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var4)).get(AddDeviceViewModel.class)));
      TextView var3 = this.getDialogTitle();
      Object var12 = null;
      if (var3 != null) {
         Context var5 = this.getContext();
         CharSequence var6;
         if (var5 != null) {
            var6 = var5.getText(R.string.custome_purifier_name);
         } else {
            var6 = null;
         }

         var3.setText(var6);
      }

      var3 = this.getDialogMsg();
      if (var3 != null) {
         Context var7 = this.getContext();
         CharSequence var8;
         if (var7 != null) {
            var8 = var7.getText(R.string.name_purifier);
         } else {
            var8 = null;
         }

         var3.setText(var8);
      }

      Bundle var15 = this.getArguments();
      String var9 = (String)var12;
      if (var15 != null) {
         var9 = var15.getString("device_name");
      }

      EditText var13 = this.getEditText();
      if (var13 != null) {
         CharSequence var10 = (CharSequence)var9;
         if (var10 != null && var10.length() != 0) {
            var13.setText(var10);
            Editable var11 = var13.getText();
            if (var11 != null) {
               var13.setSelection(var11.length());
            }
         }
      }

   }

   public void setViewModel(AddDeviceViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"},
      d2 = {"Lcom/blueair/adddevice/dialog/EnterDeviceNameDialogFragment$Companion;", "", "<init>", "()V", "SET_NAME_REQUEST_KEY", "", "DEVICE_NAME", "newInstance", "Lcom/blueair/adddevice/dialog/EnterDeviceNameDialogFragment;", "prePopName", "adddevice_otherRelease"},
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

      // $FF: synthetic method
      public static EnterDeviceNameDialogFragment newInstance$default(Companion var0, String var1, int var2, Object var3) {
         if ((var2 & 1) != 0) {
            var1 = null;
         }

         return var0.newInstance(var1);
      }

      public final EnterDeviceNameDialogFragment newInstance(String var1) {
         EnterDeviceNameDialogFragment var3 = new EnterDeviceNameDialogFragment();
         Bundle var2 = new Bundle();
         CharSequence var4 = (CharSequence)var1;
         if (var4 != null && var4.length() != 0) {
            var2.putString("device_name", var1);
         }

         var3.setArguments(var2);
         return var3;
      }
   }
}
