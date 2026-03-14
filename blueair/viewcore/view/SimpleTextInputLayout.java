package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blueair.viewcore.R;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001f"},
   d2 = {"Lcom/blueair/viewcore/view/SimpleTextInputLayout;", "Lcom/google/android/material/textfield/TextInputLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "required", "", "triggerTimeMillis", "", "blockPeriod", "value", "", "errorText", "getErrorText", "()Ljava/lang/CharSequence;", "setErrorText", "(Ljava/lang/CharSequence;)V", "initAttr", "", "setTextInputAccessibilityDelegate", "delegate", "Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;", "shouldAnnounceErrorForAccessibility", "TextInputAccessibilityDelegate", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SimpleTextInputLayout extends TextInputLayout {
   private final long blockPeriod;
   private CharSequence errorText;
   private boolean required;
   private long triggerTimeMillis;

   public SimpleTextInputLayout(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null);
   }

   public SimpleTextInputLayout(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2);
      this.blockPeriod = 2000L;
      this.errorText = (CharSequence)"";
      this.initAttr(var2, 0);
   }

   public SimpleTextInputLayout(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.blockPeriod = 2000L;
      this.errorText = (CharSequence)"";
      this.initAttr(var2, var3);
   }

   private final void initAttr(AttributeSet var1, int var2) {
      Context var4 = this.getContext();
      Intrinsics.checkNotNullExpressionValue(var4, "getContext(...)");
      int[] var3 = R.styleable.SimpleTextInputLayout;
      Intrinsics.checkNotNullExpressionValue(var3, "SimpleTextInputLayout");
      TypedArray var5 = var4.obtainStyledAttributes(var1, var3, var2, 0);
      this.required = var5.getBoolean(R.styleable.SimpleTextInputLayout_required, false);
      var5.recycle();
   }

   public final CharSequence getErrorText() {
      return this.errorText;
   }

   public final void setErrorText(CharSequence var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.errorText = var1;
      if (var1.length() > 0) {
         this.triggerTimeMillis = System.currentTimeMillis();
      }

   }

   public void setTextInputAccessibilityDelegate(TextInputLayout.AccessibilityDelegate var1) {
      EditText var2 = this.getEditText();
      if (var2 != null) {
         ViewCompat.setAccessibilityDelegate((View)var2, new TextInputAccessibilityDelegate(this));
      }

   }

   public final boolean shouldAnnounceErrorForAccessibility() {
      long var1 = System.currentTimeMillis();
      return this.errorText.length() > 0 && var1 - this.triggerTimeMillis < this.blockPeriod;
   }

   @Metadata(
      d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"},
      d2 = {"Lcom/blueair/viewcore/view/SimpleTextInputLayout$TextInputAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "layout", "Lcom/blueair/viewcore/view/SimpleTextInputLayout;", "<init>", "(Lcom/blueair/viewcore/view/SimpleTextInputLayout;)V", "getLayout", "()Lcom/blueair/viewcore/view/SimpleTextInputLayout;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
      private final SimpleTextInputLayout layout;

      public TextInputAccessibilityDelegate(SimpleTextInputLayout var1) {
         Intrinsics.checkNotNullParameter(var1, "layout");
         super();
         this.layout = var1;
      }

      public final SimpleTextInputLayout getLayout() {
         return this.layout;
      }

      public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfoCompat var2) {
         Intrinsics.checkNotNullParameter(var1, "host");
         Intrinsics.checkNotNullParameter(var2, "info");
         super.onInitializeAccessibilityNodeInfo(var1, var2);
         EditText var5 = this.layout.getEditText();
         Editable var11;
         if (var5 != null) {
            var11 = var5.getText();
         } else {
            var11 = null;
         }

         CharSequence var6 = (CharSequence)var11;
         CharSequence var12 = this.layout.getHint();
         CharSequence var7 = this.layout.getPlaceholderText();
         int var3 = this.layout.getCounterMaxLength();
         boolean var4 = TextUtils.isEmpty(var6);
         String var13;
         if (!TextUtils.isEmpty(var12)) {
            var13 = String.valueOf(var12);
         } else {
            var13 = "";
         }

         String var10;
         if (this.layout.required) {
            StringBuilder var8 = new StringBuilder(", ");
            var8.append(var1.getContext().getString(R.string.required));
            var10 = var8.toString();
            if (StringsKt.contains$default((CharSequence)var13, (CharSequence)"*", false, 2, (Object)null)) {
               var10 = StringsKt.replace$default(var13, "*", var10, false, 4, (Object)null);
            } else {
               var8 = new StringBuilder();
               var8.append(var13);
               var8.append(var10);
               var10 = var8.toString();
            }
         } else {
            var10 = var13;
         }

         if (!var4) {
            var2.setText(var6);
         } else {
            CharSequence var14 = (CharSequence)var10;
            if (!TextUtils.isEmpty(var14)) {
               var2.setText(var14);
            } else if (var7 != null) {
               var2.setText(var7);
            }
         }

         CharSequence var15 = (CharSequence)var10;
         if (!TextUtils.isEmpty(var15)) {
            if (VERSION.SDK_INT >= 26) {
               var2.setHintText(var15);
            } else {
               String var16 = var10;
               if (!var4) {
                  StringBuilder var17 = new StringBuilder();
                  var17.append(var6);
                  var17.append(", ");
                  var17.append(var10);
                  var16 = var17.toString();
               }

               var2.setText((CharSequence)var16);
            }

            var2.setShowingHintText(var4);
         }

         if (var6 == null || var6.length() != var3) {
            var3 = -1;
         }

         var2.setMaxTextLength(var3);
         var2.setSelected(false);
         if (this.layout.shouldAnnounceErrorForAccessibility()) {
            var2.setText(this.layout.getErrorText());
            var2.setStateDescription((CharSequence)null);
            var2.setContentDescription((CharSequence)null);
            var2.setHintText((CharSequence)null);
            var2.setClassName((CharSequence)"");
         }

      }
   }
}
