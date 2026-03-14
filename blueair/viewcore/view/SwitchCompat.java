package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"},
   d2 = {"Lcom/blueair/viewcore/view/SwitchCompat;", "Landroidx/appcompat/widget/SwitchCompat;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shouldIgnoreCheckedChange", "", "setOnCheckedChangeListener", "", "listener", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "setCheckedSilence", "checked", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class SwitchCompat extends androidx.appcompat.widget.SwitchCompat {
   private boolean shouldIgnoreCheckedChange;

   // $FF: synthetic method
   public static void $r8$lambda$_k1iHofZHFCzoCOmY1yVKIeVKzk(SwitchCompat var0, CompoundButton.OnCheckedChangeListener var1, CompoundButton var2, boolean var3) {
      setOnCheckedChangeListener$lambda$0(var0, var1, var2, var3);
   }

   public SwitchCompat(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      boolean var2;
      if (this.getSwitchMinWidth() <= 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setEnforceSwitchWidth(var2);
   }

   public SwitchCompat(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      boolean var3;
      if (this.getSwitchMinWidth() <= 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.setEnforceSwitchWidth(var3);
   }

   public SwitchCompat(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      boolean var4;
      if (this.getSwitchMinWidth() <= 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.setEnforceSwitchWidth(var4);
   }

   private static final void setOnCheckedChangeListener$lambda$0(SwitchCompat var0, CompoundButton.OnCheckedChangeListener var1, CompoundButton var2, boolean var3) {
      if (!var0.shouldIgnoreCheckedChange && var1 != null) {
         var1.onCheckedChanged(var2, var3);
      }

   }

   public final void setCheckedSilence(boolean var1) {
      this.shouldIgnoreCheckedChange = true;
      super.setChecked(var1);
      this.shouldIgnoreCheckedChange = false;
   }

   public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener var1) {
      super.setOnCheckedChangeListener(new SwitchCompat$$ExternalSyntheticLambda0(this, var1));
   }
}
