package com.blueair.viewcore.fragment;

import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00028\u0000X¦\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011À\u0006\u0003"},
   d2 = {"Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "", "showProgress", "", "shouldShowProgress", "", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "viewModel", "getViewModel", "()Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "setViewModel", "(Lcom/blueair/viewcore/viewmodel/BaseViewModel;)V", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public interface BaseFragmentInterface {
   CompositeDisposable getRxSubs();

   BaseViewModel getViewModel();

   void setViewModel(BaseViewModel var1);

   void showProgress(boolean var1);

   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class DefaultImpls {
      // $FF: synthetic method
      public static void showProgress$default(BaseFragmentInterface var0, boolean var1, int var2, Object var3) {
         BaseFragmentInterface$_CC.showProgress$default(var0, var1, var2, var3);
      }
   }
}
