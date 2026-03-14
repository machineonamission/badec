package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.R;
import io.flatcircle.viewhelper.ViewHelperUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J$\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020+H\u0014J\b\u0010,\u001a\u00020'H\u0014J\b\u0010-\u001a\u00020.H$J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020.H\u0016R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001a\u0010\u0017¨\u00061"},
   d2 = {"Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "<init>", "()V", "dialogTitle", "Landroid/widget/TextView;", "getDialogTitle", "()Landroid/widget/TextView;", "dialogTitle$delegate", "Lkotlin/Lazy;", "dialogMsg", "getDialogMsg", "dialogMsg$delegate", "editText", "Landroid/widget/EditText;", "getEditText", "()Landroid/widget/EditText;", "editText$delegate", "saveBtn", "Landroid/widget/Button;", "getSaveBtn", "()Landroid/widget/Button;", "saveBtn$delegate", "cancelBtn", "getCancelBtn", "cancelBtn$delegate", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "", "view", "onSaveBtnClicked", "text", "", "onCancelBtnClicked", "validateText", "", "showProgress", "shouldShowProgress", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseEditTextDialogFragment extends BaseDialogFragment {
   private final Lazy cancelBtn$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda4(this));
   private final Lazy dialogMsg$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda1(this));
   private final Lazy dialogTitle$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda0(this));
   private final Lazy editText$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda2(this));
   private final Lazy saveBtn$delegate = LazyKt.lazy(new BaseEditTextDialogFragment$$ExternalSyntheticLambda3(this));

   // $FF: synthetic method
   public static void $r8$lambda$4y4R_cPFLSiqKe360LsqrWgcTNQ(BaseEditTextDialogFragment var0, View var1) {
      onViewCreated$lambda$7(var0, var1);
   }

   // $FF: synthetic method
   public static EditText $r8$lambda$8_n3QA0xNm_uT_YUa8i3vYurP3k/* $FF was: $r8$lambda$8-n3QA0xNm_uT-YUa8i3vYurP3k*/(BaseEditTextDialogFragment var0) {
      return editText_delegate$lambda$2(var0);
   }

   // $FF: synthetic method
   public static Button $r8$lambda$AkZ_KKhSmt1XgL5OST_oPEZIiDE(BaseEditTextDialogFragment var0) {
      return cancelBtn_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static TextView $r8$lambda$HAjm1OcVab3kBoIsvNelVebmZgo(BaseEditTextDialogFragment var0) {
      return dialogTitle_delegate$lambda$0(var0);
   }

   // $FF: synthetic method
   public static TextView $r8$lambda$TBbxYUKtMG788u77oBYDEmUXmaU(BaseEditTextDialogFragment var0) {
      return dialogMsg_delegate$lambda$1(var0);
   }

   // $FF: synthetic method
   public static Button $r8$lambda$Tm1Ek1aijdPhR1VkUt2R6Ctp6jw(BaseEditTextDialogFragment var0) {
      return saveBtn_delegate$lambda$3(var0);
   }

   // $FF: synthetic method
   public static void $r8$lambda$kvg9G3vFHfxWUjEW6vcpH_WBnKA/* $FF was: $r8$lambda$kvg9G3vFHfxWUjEW6vcpH-WBnKA*/(BaseEditTextDialogFragment var0, View var1) {
      onViewCreated$lambda$6(var0, var1);
   }

   private static final Button cancelBtn_delegate$lambda$4(BaseEditTextDialogFragment var0) {
      View var1 = var0.getView();
      return var1 != null ? (Button)var1.findViewById(R.id.cancel_view) : null;
   }

   private static final TextView dialogMsg_delegate$lambda$1(BaseEditTextDialogFragment var0) {
      View var1 = var0.getView();
      return var1 != null ? (TextView)var1.findViewById(R.id.dialog_msg) : null;
   }

   private static final TextView dialogTitle_delegate$lambda$0(BaseEditTextDialogFragment var0) {
      View var1 = var0.getView();
      return var1 != null ? (TextView)var1.findViewById(R.id.dialog_title) : null;
   }

   private static final EditText editText_delegate$lambda$2(BaseEditTextDialogFragment var0) {
      View var1 = var0.getView();
      return var1 != null ? (EditText)var1.findViewById(R.id.editText) : null;
   }

   private static final void onViewCreated$lambda$6(BaseEditTextDialogFragment var0, View var1) {
      if (var0.validateText()) {
         label15: {
            EditText var3 = var0.getEditText();
            if (var3 != null) {
               Editable var4 = var3.getText();
               if (var4 != null) {
                  String var2 = var4.toString();
                  var5 = var2;
                  if (var2 != null) {
                     break label15;
                  }
               }
            }

            var5 = "";
         }

         var0.onSaveBtnClicked(var5);
      }

   }

   private static final void onViewCreated$lambda$7(BaseEditTextDialogFragment var0, View var1) {
      var0.onCancelBtnClicked();
   }

   private static final Button saveBtn_delegate$lambda$3(BaseEditTextDialogFragment var0) {
      View var1 = var0.getView();
      return var1 != null ? (Button)var1.findViewById(R.id.ok_view) : null;
   }

   protected final Button getCancelBtn() {
      return (Button)this.cancelBtn$delegate.getValue();
   }

   protected final TextView getDialogMsg() {
      return (TextView)this.dialogMsg$delegate.getValue();
   }

   protected final TextView getDialogTitle() {
      return (TextView)this.dialogTitle$delegate.getValue();
   }

   protected final EditText getEditText() {
      return (EditText)this.editText$delegate.getValue();
   }

   protected final Button getSaveBtn() {
      return (Button)this.saveBtn$delegate.getValue();
   }

   protected void onCancelBtnClicked() {
      this.dismiss();
   }

   public Dialog onCreateDialog(Bundle var1) {
      Dialog var4 = new Dialog(this.requireContext());
      FragmentActivity var3 = this.getActivity();
      if (var3 != null) {
         Window var2 = var4.getWindow();
         if (var2 != null) {
            var2.setBackgroundDrawable(ContextCompat.getDrawable((Context)var3, R.drawable.rounded_rectangle_white));
         }
      }

      return var4;
   }

   public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      View var4 = var1.inflate(R.layout.dialog_enter_device_name, var2, false);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      return var4;
   }

   protected void onSaveBtnClicked(String var1) {
      Intrinsics.checkNotNullParameter(var1, "text");
      ViewHelperUtil.INSTANCE.hideSoftKeyboard(this.getView());
      this.dismiss();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      Button var3 = this.getSaveBtn();
      if (var3 != null) {
         var3.setOnClickListener(new BaseEditTextDialogFragment$$ExternalSyntheticLambda5(this));
      }

      var3 = this.getCancelBtn();
      if (var3 != null) {
         var3.setOnClickListener(new BaseEditTextDialogFragment$$ExternalSyntheticLambda6(this));
      }

   }

   public void showProgress(boolean var1) {
   }

   protected abstract boolean validateText();
}
