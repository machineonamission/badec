package com.blueair.viewcore.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014¨\u0006\u000e"},
   d2 = {"Lcom/blueair/viewcore/dialog/BaseEditDeviceNameDialogFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "<init>", "()V", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "validateText", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseEditDeviceNameDialogFragment extends BaseEditTextDialogFragment {
   // $FF: synthetic method
   public static void $r8$lambda$oIGUQRLy_t0aSjAYNM6s5T6cFyA/* $FF was: $r8$lambda$oIGUQRLy-t0aSjAYNM6s5T6cFyA*/(EditText var0) {
      onViewCreated$lambda$1$lambda$0(var0);
   }

   private static final void onViewCreated$lambda$1$lambda$0(EditText var0) {
      var0.requestFocus();
      Object var1 = var0.getContext().getSystemService("input_method");
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
      ((InputMethodManager)var1).showSoftInput((View)var0, 1);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      EditText var3 = this.getEditText();
      if (var3 != null) {
         var3.setFilters((InputFilter[])(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(25)}));
         var3.post(new BaseEditDeviceNameDialogFragment$$ExternalSyntheticLambda0(var3));
      }

   }

   protected boolean validateText() {
      EditText var1 = this.getEditText();
      Editable var3;
      if (var1 != null) {
         var3 = var1.getText();
      } else {
         var3 = null;
      }

      if (((CharSequence)String.valueOf(var3)).length() == 0) {
         ViewUtils var2 = ViewUtils.INSTANCE;
         FragmentActivity var4 = this.requireActivity();
         Intrinsics.checkNotNullExpressionValue(var4, "requireActivity(...)");
         var2.showSnackbar((Activity)var4, R.string.device_name_invalid_name, ViewUtils.MessageType.WARNING.INSTANCE);
         return false;
      } else {
         return true;
      }
   }
}
