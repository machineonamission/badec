package com.blueair.login;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.BindingAdapter;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\b0\u0005H\u0007\u001a\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\r"},
   d2 = {"afterTextChange", "Landroid/text/TextWatcher;", "et", "Landroidx/appcompat/widget/AppCompatEditText;", "bloc", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "errorText", "Lcom/google/android/material/textfield/TextInputLayout;", "text", "", "login_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class BindingAdapterKt {
   @BindingAdapter({"afterTextChange"})
   public static final TextWatcher afterTextChange(AppCompatEditText var0, Function1 var1) {
      Intrinsics.checkNotNullParameter(var0, "et");
      Intrinsics.checkNotNullParameter(var1, "bloc");
      TextView var2 = (TextView)var0;
      TextWatcher var3 = new TextWatcher(var1, var0) {
         final Function1 $bloc$inlined;
         final AppCompatEditText $et$inlined;

         public {
            this.$bloc$inlined = var1;
            this.$et$inlined = var2;
         }

         public void afterTextChanged(Editable var1) {
            this.$bloc$inlined.invoke(this.$et$inlined);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      };
      var2.addTextChangedListener(var3);
      return var3;
   }

   @BindingAdapter({"errorText"})
   public static final void errorText(TextInputLayout var0, String var1) {
      Intrinsics.checkNotNullParameter(var0, "et");
      var0.setError((CharSequence)var1);
   }
}
