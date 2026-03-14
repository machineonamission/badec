package com.blueair.outdoor.ui.dialog;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.outdoor.ui.viewmodels.MapsViewModel;
import com.blueair.viewcore.R;
import com.blueair.viewcore.dialog.BaseDialogFragment;
import com.blueair.viewcore.dialog.BaseEditTextDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006!"},
   d2 = {"Lcom/blueair/outdoor/ui/dialog/LocationEditNameDialogFragment;", "Lcom/blueair/viewcore/dialog/BaseEditTextDialogFragment;", "Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "viewModel", "getViewModel", "()Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;", "setViewModel", "(Lcom/blueair/outdoor/ui/viewmodels/MapsViewModel;)V", "onSaveListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "text", "", "getOnSaveListener", "()Lkotlin/jvm/functions/Function1;", "setOnSaveListener", "(Lkotlin/jvm/functions/Function1;)V", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "validateText", "", "onSaveBtnClicked", "Companion", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class LocationEditNameDialogFragment extends BaseEditTextDialogFragment {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_NAME = "EXTRA_NAME";
   private Function1 onSaveListener;
   private final String screenName;
   public MapsViewModel viewModel;

   public final Function1 getOnSaveListener() {
      return this.onSaveListener;
   }

   protected String getScreenName() {
      return this.screenName;
   }

   public MapsViewModel getViewModel() {
      MapsViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   protected void onSaveBtnClicked(String var1) {
      Intrinsics.checkNotNullParameter(var1, "text");
      Function1 var2 = this.onSaveListener;
      if (var2 != null) {
         var2.invoke(var1);
      }

      super.onSaveBtnClicked(var1);
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      FragmentActivity var3 = ((BaseDialogFragment)this).requireActivity();
      Intrinsics.checkNotNullExpressionValue(var3, "requireActivity(...)");
      this.setViewModel((MapsViewModel)((BaseViewModel)(new ViewModelProvider((ViewModelStoreOwner)var3)).get(MapsViewModel.class)));
      TextView var4 = this.getDialogTitle();
      if (var4 != null) {
         var4.setText(R.string.outdoor_edit_location_name);
      }

      var4 = this.getDialogMsg();
      if (var4 != null) {
         ViewExtensionsKt.hide((View)var4);
      }

      EditText var6 = this.getEditText();
      if (var6 != null) {
         var6.setFilters((InputFilter[])(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(100)}));
      }

      var6 = this.getEditText();
      if (var6 != null) {
         ((TextView)var6).addTextChangedListener(new TextWatcher(this) {
            final LocationEditNameDialogFragment this$0;

            public {
               this.this$0 = var1;
            }

            public void afterTextChanged(Editable var1) {
            }

            public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
            }

            public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
               Button var5 = this.this$0.getSaveBtn();
               if (var5 != null) {
                  var5.setEnabled(this.this$0.validateText());
               }

            }
         });
      }

      var6 = this.getEditText();
      if (var6 != null) {
         var6.setText((CharSequence)this.requireArguments().getString("EXTRA_NAME"));
      }

   }

   public final void setOnSaveListener(Function1 var1) {
      this.onSaveListener = var1;
   }

   public void setViewModel(MapsViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   protected boolean validateText() {
      String var4;
      label22: {
         EditText var2 = this.getEditText();
         if (var2 != null) {
            Editable var3 = var2.getText();
            if (var3 != null) {
               var4 = var3.toString();
               break label22;
            }
         }

         var4 = null;
      }

      CharSequence var5 = (CharSequence)var4;
      boolean var1;
      if (var5 != null && !StringsKt.isBlank(var5)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1 ^ true;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"},
      d2 = {"Lcom/blueair/outdoor/ui/dialog/LocationEditNameDialogFragment$Companion;", "", "<init>", "()V", "EXTRA_NAME", "", "newInstance", "Lcom/blueair/outdoor/ui/dialog/LocationEditNameDialogFragment;", "name", "outdoor_otherRelease"},
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

      public final LocationEditNameDialogFragment newInstance(String var1) {
         Intrinsics.checkNotNullParameter(var1, "name");
         LocationEditNameDialogFragment var2 = new LocationEditNameDialogFragment();
         var2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to("EXTRA_NAME", var1)}));
         return var2;
      }
   }
}
