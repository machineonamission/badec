package com.blueair.viewcore.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000eÀ\u0006\u0003"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/MvvmCustomViewNonNullState;", "S", "Landroid/os/Parcelable;", "VM", "Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModelNonNullState;", "", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/MvvmCustomViewModelNonNullState;", "attachLifeCycle", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onLifecycleOwnerAttached", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface MvvmCustomViewNonNullState {
   void attachLifeCycle(LifecycleOwner var1);

   MvvmCustomViewModelNonNullState getViewModel();

   void onLifecycleOwnerAttached(LifecycleOwner var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      @Deprecated
      public static void attachLifeCycle(MvvmCustomViewNonNullState var0, LifecycleOwner var1) {
         Intrinsics.checkNotNullParameter(var1, "lifecycleOwner");
         MvvmCustomViewNonNullState$_CC.access$attachLifeCycle$jd(var0, var1);
      }
   }
}
