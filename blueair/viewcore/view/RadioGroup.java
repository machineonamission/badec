package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/blueair/viewcore/view/RadioGroup;", "Landroid/widget/RadioGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "shouldIgnoreCheckedChange", "", "setOnCheckedChangeListener", "", "listener", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "checkSilence", "id", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RadioGroup extends android.widget.RadioGroup {
   private boolean shouldIgnoreCheckedChange;

   // $FF: synthetic method
   public static void $r8$lambda$wi0sQX3_a8YxmM7H_ESg9lEcdM8/* $FF was: $r8$lambda$wi0sQX3-a8YxmM7H-ESg9lEcdM8*/(RadioGroup var0, android.widget.RadioGroup.OnCheckedChangeListener var1, android.widget.RadioGroup var2, int var3) {
      setOnCheckedChangeListener$lambda$0(var0, var1, var2, var3);
   }

   public RadioGroup(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
   }

   public RadioGroup(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
   }

   private static final void setOnCheckedChangeListener$lambda$0(RadioGroup var0, android.widget.RadioGroup.OnCheckedChangeListener var1, android.widget.RadioGroup var2, int var3) {
      if (!var0.shouldIgnoreCheckedChange && var1 != null) {
         var1.onCheckedChanged(var2, var3);
      }

   }

   public final void checkSilence(int var1) {
      this.shouldIgnoreCheckedChange = true;
      super.check(var1);
      this.shouldIgnoreCheckedChange = false;
   }

   public void setOnCheckedChangeListener(android.widget.RadioGroup.OnCheckedChangeListener var1) {
      super.setOnCheckedChangeListener(new RadioGroup$$ExternalSyntheticLambda0(this, var1));
   }
}
