package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.ActivityCustomInputBinding;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"},
   d2 = {"Lcom/blueair/devicedetails/activity/CustomInputActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "inputBinding", "Lcom/blueair/devicedetails/databinding/ActivityCustomInputBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "bindView", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CustomInputActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final String EXTRA_HINT = "extra_hint";
   public static final String EXTRA_INITIAL_VALUE = "extra_initial_value";
   public static final String EXTRA_INPUT = "extra_input";
   public static final String EXTRA_MAX_LENGTH = "extra_max_length";
   public static final String EXTRA_TITLE = "extra_title";
   private String _screenName;
   private ActivityCustomInputBinding inputBinding;

   // $FF: synthetic method
   public static void $r8$lambda$9byY783zXvSPxo_LWQ8f_qkFb58/* $FF was: $r8$lambda$9byY783zXvSPxo-LWQ8f-qkFb58*/(CustomInputActivity var0, View var1) {
      bindView$lambda$3(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$VorbpzxzsDZIDKPihgZbbSVZVRE(CustomInputActivity var0, View var1) {
      bindView$lambda$1(var0, var1);
   }

   private final void bindView() {
      ViewDataBinding var2 = DataBindingUtil.setContentView((Activity)this, R.layout.activity_custom_input);
      Intrinsics.checkNotNullExpressionValue(var2, "setContentView(...)");
      ActivityCustomInputBinding var4 = (ActivityCustomInputBinding)var2;
      this.inputBinding = var4;
      Object var3 = null;
      ActivityCustomInputBinding var5 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var5 = null;
      }

      this.setContentView(var5.getRoot());
      this._screenName = this.getIntent().getStringExtra("screen_name");
      var4 = this.inputBinding;
      var5 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var5 = null;
      }

      var5.editTextLayout.setHint((CharSequence)this.getIntent().getStringExtra("extra_hint"));
      var4 = this.inputBinding;
      var5 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var5 = null;
      }

      var5.tvTitle.setText((CharSequence)this.getIntent().getStringExtra("extra_title"));
      var4 = this.inputBinding;
      var5 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var5 = null;
      }

      TextInputEditText var9 = var5.editText;
      Intrinsics.checkNotNullExpressionValue(var9, "editText");
      ((TextView)var9).addTextChangedListener(new TextWatcher(this) {
         final CustomInputActivity this$0;

         public {
            this.this$0 = var1;
         }

         public void afterTextChanged(Editable var1) {
            ActivityCustomInputBinding var5 = this.this$0.inputBinding;
            Object var4 = null;
            ActivityCustomInputBinding var3 = var5;
            if (var5 == null) {
               Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
               var3 = null;
            }

            MaterialButton var7 = var3.btnSave;
            CharSequence var6 = (CharSequence)var4;
            if (var1 != null) {
               var6 = StringsKt.trim((CharSequence)var1);
            }

            boolean var2;
            if (var6 != null && var6.length() != 0) {
               var2 = false;
            } else {
               var2 = true;
            }

            var7.setEnabled(true ^ var2);
         }

         public void beforeTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }

         public void onTextChanged(CharSequence var1, int var2, int var3, int var4) {
         }
      });
      var4 = this.inputBinding;
      ActivityCustomInputBinding var10 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var10 = null;
      }

      var10.editText.setText((CharSequence)this.getIntent().getStringExtra("extra_initial_value"));
      var4 = this.inputBinding;
      var10 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var10 = null;
      }

      var10.btnBack.setOnClickListener(new CustomInputActivity$$ExternalSyntheticLambda0(this));
      var4 = this.inputBinding;
      var10 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var10 = null;
      }

      var10.btnSave.setOnClickListener(new CustomInputActivity$$ExternalSyntheticLambda1(this));
      var4 = this.inputBinding;
      var10 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var10 = null;
      }

      var10.editText.requestFocus();
      int var1 = this.getIntent().getIntExtra("extra_max_length", 0);
      if (var1 > 0) {
         var10 = this.inputBinding;
         if (var10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            var10 = (ActivityCustomInputBinding)var3;
         }

         TextInputEditText var16 = var10.editText;
         InputFilter[] var15 = var16.getFilters();
         Intrinsics.checkNotNullExpressionValue(var15, "getFilters(...)");
         var16.setFilters((InputFilter[])ArraysKt.plus((Object[])var15, new InputFilter.LengthFilter(var1)));
      }

   }

   private static final void bindView$lambda$1(CustomInputActivity var0, View var1) {
      var0.finish();
   }

   private static final void bindView$lambda$3(CustomInputActivity var0, View var1) {
      ActivityCustomInputBinding var2 = var0.inputBinding;
      ActivityCustomInputBinding var3 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
         var3 = null;
      }

      String var5 = String.valueOf(var3.editText.getText());
      Intent var4 = new Intent();
      var4.putExtra("extra_input", var5);
      Unit var6 = Unit.INSTANCE;
      var0.setResult(-1, var4);
      var0.finish();
   }

   protected String getScreenName() {
      return this._screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object)null);
      this.setStatusMode(true);
      this.bindView();
   }

   @Metadata(
      d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0015"},
      d2 = {"Lcom/blueair/devicedetails/activity/CustomInputActivity$Companion;", "", "<init>", "()V", "EXTRA_HINT", "", "EXTRA_TITLE", "EXTRA_INITIAL_VALUE", "EXTRA_INPUT", "EXTRA_MAX_LENGTH", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "screenName", "title", "hint", "initialValue", "maxLength", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/Intent;", "devicedetails_otherRelease"},
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
      public static Intent getLaunchIntent$default(Companion var0, Context var1, String var2, String var3, String var4, String var5, Integer var6, int var7, Object var8) {
         if ((var7 & 32) != 0) {
            var6 = null;
         }

         return var0.getLaunchIntent(var1, var2, var3, var4, var5, var6);
      }

      public final Intent getLaunchIntent(Context var1, String var2, String var3, String var4, String var5, Integer var6) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var3, "title");
         Intrinsics.checkNotNullParameter(var4, "hint");
         Intrinsics.checkNotNullParameter(var5, "initialValue");
         Intent var7 = new Intent(var1, CustomInputActivity.class);
         var7.putExtra("screen_name", var2);
         var7.putExtra("extra_hint", var4);
         var7.putExtra("extra_title", var3);
         var7.putExtra("extra_initial_value", var5);
         var7.putExtra("extra_max_length", (Serializable)var6);
         return var7;
      }
   }
}
