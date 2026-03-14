package com.blueair.viewcore.viewmodel;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import io.flatcircle.livedatahelper.LiveDataExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rB#\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0015\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u001a¨\u0006\u001b"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/CustomConstraintLayout;", "S", "Landroid/os/Parcelable;", "VM", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/blueair/viewcore/viewmodel/MvvmCustomView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onSaveInstanceState", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewStateWrapper;", "onRestoreInstanceState", "", "state", "onLifecycleOwnerAttached", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onStateUpdate", "(Landroid/os/Parcelable;)V", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class CustomConstraintLayout extends ConstraintLayout implements MvvmCustomView {
   // $FF: synthetic method
   public static Unit $r8$lambda$qqKFotUtdIFuBIyUpTZAOGU328E(CustomConstraintLayout var0, Parcelable var1) {
      return onLifecycleOwnerAttached$lambda$0(var0, var1);
   }

   public CustomConstraintLayout(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
   }

   public CustomConstraintLayout(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrSet");
      super(var1, var2);
   }

   public CustomConstraintLayout(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
   }

   private static final Unit onLifecycleOwnerAttached$lambda$0(CustomConstraintLayout var0, Parcelable var1) {
      Intrinsics.checkNotNull(var1);
      var0.onStateUpdate(var1);
      return Unit.INSTANCE;
   }

   public void attachLifeCycle(Context var1) {
      MvvmCustomView$_CC.$default$attachLifeCycle(this, var1);
   }

   public void onLifecycleOwnerAttached(LifecycleOwner var1) {
      Intrinsics.checkNotNullParameter(var1, "lifecycleOwner");
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("onLifecycleOwnerAttached for ");
      var2.append(var1);
      var3.d(var2.toString(), new Object[0]);
      LiveDataExtensionsKt.observeNonNull((LiveData)this.getViewModel().getLiveData(), var1, new CustomConstraintLayout$$ExternalSyntheticLambda0(this));
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (var1 instanceof MvvmCustomViewStateWrapper) {
         MvvmCustomViewModel var2 = this.getViewModel();
         MvvmCustomViewStateWrapper var3 = (MvvmCustomViewStateWrapper)var1;
         var1 = var3.getState();
         if (!(var1 instanceof Parcelable)) {
            var1 = null;
         }

         var2.setState(var1);
         super.onRestoreInstanceState(var3.getSuperState());
      }

   }

   protected MvvmCustomViewStateWrapper onSaveInstanceState() {
      return new MvvmCustomViewStateWrapper(super.onSaveInstanceState(), this.getViewModel().getState());
   }

   public abstract void onStateUpdate(Parcelable var1);
}
