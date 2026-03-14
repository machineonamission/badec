package com.blueair.adddevice.fragment;

import com.blueair.adddevice.viewmodel.AddDeviceViewModel;
import com.blueair.viewcore.fragment.BaseFragment;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0002X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"},
   d2 = {"Lcom/blueair/adddevice/fragment/AddDeviceFragment;", "Lcom/blueair/viewcore/fragment/BaseFragment;", "Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "<init>", "()V", "showProgress", "", "shouldShowProgress", "", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "Lkotlin/Lazy;", "viewModel", "getViewModel", "()Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "setViewModel", "(Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;)V", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceFragment extends BaseFragment {
   private final Lazy rxSubs$delegate = LazyKt.lazy(new AddDeviceFragment$$ExternalSyntheticLambda0());
   public AddDeviceViewModel viewModel;

   // $FF: synthetic method
   public static CompositeDisposable $r8$lambda$lH6ALJeVo3UbbR85wD4pyYuB4Ts() {
      return rxSubs_delegate$lambda$0();
   }

   private static final CompositeDisposable rxSubs_delegate$lambda$0() {
      return new CompositeDisposable();
   }

   public CompositeDisposable getRxSubs() {
      return (CompositeDisposable)this.rxSubs$delegate.getValue();
   }

   public AddDeviceViewModel getViewModel() {
      AddDeviceViewModel var1 = this.viewModel;
      if (var1 != null) {
         return var1;
      } else {
         Intrinsics.throwUninitializedPropertyAccessException("viewModel");
         return null;
      }
   }

   public void setViewModel(AddDeviceViewModel var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.viewModel = var1;
   }

   public void showProgress(boolean var1) {
   }
}
