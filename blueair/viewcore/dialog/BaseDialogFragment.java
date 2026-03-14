package com.blueair.viewcore.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.BaseViewModelAction;
import com.blueair.viewcore.viewmodel.BaseViewModelEvent;
import com.blueair.viewcore.viewmodel.ConfirmationMessage;
import com.blueair.viewcore.viewmodel.PopupMessage;
import com.blueair.viewcore.viewmodel.SnackbarMessage;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.coroutinehelper.MainCoroutineScope;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u0018\u001a\u0002H\u0019\"\n\b\u0001\u0010\u0019\u0018\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u0002H\u0019\"\n\b\u0001\u0010\u0019\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0002H\u0019\"\n\b\u0001\u0010\u0019\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u001eJ\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020/H\u0016R\u001b\u0010\t\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010 \u001a\u00020!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0012\u00102\u001a\u000203X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"},
   d2 = {"Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Landroidx/fragment/app/DialogFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "analytics", "Lcom/blueair/core/service/AnalyticsService;", "getAnalytics", "()Lcom/blueair/core/service/AnalyticsService;", "analytics$delegate", "screenName", "", "getScreenName", "()Ljava/lang/String;", "getViewModel", "T", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "getSharedViewModel", "()Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "getUniqueViewModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "snackbarAnchorView", "Landroid/view/View;", "getSnackbarAnchorView", "()Landroid/view/View;", "value", "", "hasBeenPaused", "getHasBeenPaused", "()Z", "onResume", "", "onPause", "onDestroy", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseDialogFragment extends DialogFragment implements BaseFragmentInterface, DIAware, CoroutineScope {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseDialogFragment.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseDialogFragment.class, "analytics", "getAnalytics()Lcom/blueair/core/service/AnalyticsService;", 0)))};
   private final MainCoroutineScope $$delegate_0 = new MainCoroutineScope();
   private final Lazy analytics$delegate;
   private final Lazy di$delegate;
   private boolean hasBeenPaused;
   private final Lazy rxSubs$delegate;
   private final View snackbarAnchorView;

   // $FF: synthetic method
   public static CompositeDisposable $r8$lambda$ILdlWtq49wU665bogvqLRcZDcZo() {
      return rxSubs_delegate$lambda$0();
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$oXeCHC1h_QrfL7Uu89Bj0YCoZi8(BaseDialogFragment var0, BaseViewModelEvent var1) {
      return onResume$lambda$5(var0, var1);
   }

   public BaseDialogFragment() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI((Fragment)this);
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var3 = this;
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analytics$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var4, AnalyticsService.class)), (Object)null).provideDelegate(this, var1[1]);
      this.rxSubs$delegate = LazyKt.lazy(new BaseDialogFragment$$ExternalSyntheticLambda0());
   }

   private static final Unit onResume$lambda$5(BaseDialogFragment var0, BaseViewModelEvent var1) {
      BaseViewModelAction var2 = var1.getAction();
      if (Intrinsics.areEqual(var2, BaseViewModelAction.PressBack.INSTANCE)) {
         FragmentActivity var3 = var0.getActivity();
         if (var3 != null) {
            var3.onBackPressed();
         }
      } else if (Intrinsics.areEqual(var2, BaseViewModelAction.FinishActivity.INSTANCE)) {
         FragmentActivity var4 = var0.getActivity();
         if (var4 != null) {
            var4.finish();
         }
      } else if (Intrinsics.areEqual(var2, BaseViewModelAction.ShowProgress.INSTANCE)) {
         Object var9 = var1.getVariable();
         Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type kotlin.Boolean");
         var0.showProgress((Boolean)var9);
      } else if (Intrinsics.areEqual(var2, BaseViewModelAction.ShowSnackbar.INSTANCE)) {
         FragmentActivity var15 = var0.getActivity();
         if (var15 != null) {
            Object var10 = var1.getVariable();
            Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.SnackbarMessage");
            SnackbarMessage var11 = (SnackbarMessage)var10;
            if (var0.getSnackbarAnchorView() == null) {
               ViewUtils.INSTANCE.showSnackbar((Activity)var15, var11.getMessageResId(), var11.getType());
            } else {
               ViewUtils var16 = ViewUtils.INSTANCE;
               View var5 = var0.getSnackbarAnchorView();
               Intrinsics.checkNotNull(var5);
               var16.showSnackbar(var5, var11.getMessageResId(), var11.getType());
            }
         }
      } else if (Intrinsics.areEqual(var2, BaseViewModelAction.ShowPopup.INSTANCE)) {
         FragmentActivity var6 = var0.getActivity();
         if (var6 != null) {
            FragmentManager var7 = var6.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(var7, "getSupportFragmentManager(...)");
            Fragment var17 = var7.findFragmentByTag(PopupDialogFragment.Companion.getTAG());
            if (var17 != null) {
               var7.beginTransaction().remove(var17).commit();
            }

            PopupDialogFragment.Companion var18 = PopupDialogFragment.Companion;
            Object var12 = var1.getVariable();
            Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.PopupMessage");
            var18.newInstance((PopupMessage)var12).show(var7, PopupDialogFragment.Companion.getTAG());
         }
      } else {
         if (!Intrinsics.areEqual(var2, BaseViewModelAction.ShowConfirmation.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
         }

         FragmentActivity var8 = var0.getActivity();
         if (var8 != null) {
            Object var13 = var1.getVariable();
            Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.ConfirmationMessage");
            ConfirmationMessage var14 = (ConfirmationMessage)var13;
            ViewUtils.INSTANCE.showConfirmation((Context)var8, var14.getTitleResId(), var14.getMessageResId(), var14.getPositiveResId(), var14.getNegativeResId(), var14.getTopImageResId(), var14.getAction());
         }
      }

      return Unit.INSTANCE;
   }

   private static final CompositeDisposable rxSubs_delegate$lambda$0() {
      return new CompositeDisposable();
   }

   protected final AnalyticsService getAnalytics() {
      return (AnalyticsService)this.analytics$delegate.getValue();
   }

   public CoroutineContext getCoroutineContext() {
      return this.$$delegate_0.getCoroutineContext();
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return org.kodein.di.DIAware.DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return org.kodein.di.DIAware.DefaultImpls.getDiTrigger(this);
   }

   public final boolean getHasBeenPaused() {
      return this.hasBeenPaused;
   }

   public CompositeDisposable getRxSubs() {
      return (CompositeDisposable)this.rxSubs$delegate.getValue();
   }

   protected abstract String getScreenName();

   // $FF: synthetic method
   public final BaseViewModel getSharedViewModel() {
      FragmentActivity var1 = this.requireActivity();
      Intrinsics.checkNotNullExpressionValue(var1, "requireActivity(...)");
      ViewModelProvider var3 = new ViewModelProvider((ViewModelStoreOwner)var1);
      Intrinsics.reifiedOperationMarker(4, "T");
      Class var2 = BaseViewModel.class;
      return (BaseViewModel)var3.get(BaseViewModel.class);
   }

   protected View getSnackbarAnchorView() {
      return this.snackbarAnchorView;
   }

   // $FF: synthetic method
   public final BaseViewModel getUniqueViewModel() {
      ViewModelProvider var1 = new ViewModelProvider((ViewModelStoreOwner)this);
      Intrinsics.reifiedOperationMarker(4, "T");
      Class var2 = BaseViewModel.class;
      return (BaseViewModel)var1.get(BaseViewModel.class);
   }

   // $FF: synthetic method
   public final BaseViewModel getViewModel(ViewModelStoreOwner var1) {
      Intrinsics.checkNotNullParameter(var1, "owner");
      ViewModelProvider var3 = new ViewModelProvider(var1);
      Intrinsics.reifiedOperationMarker(4, "T");
      Class var2 = BaseViewModel.class;
      return (BaseViewModel)var3.get(BaseViewModel.class);
   }

   public void onDestroy() {
      super.onDestroy();
      JobKt.cancelChildren$default(this.getCoroutineContext(), (CancellationException)null, 1, (Object)null);
   }

   public void onPause() {
      this.getRxSubs().clear();
      this.hasBeenPaused = true;
      super.onPause();
   }

   public void onResume() {
      super.onResume();
      String var2 = this.getScreenName();
      if (var2 != null) {
         AnalyticsService var1 = this.getAnalytics();
         String var3 = this.getClass().getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var3, "getSimpleName(...)");
         var1.event(new AnalyticEvent.ScreenViewEvent(var2, var3));
      }

      this.getRxSubs().add(RxExtensionsKt.subscribeAndLogE((Observable)this.getViewModel().getBaseActionPublisher(), new BaseDialogFragment$$ExternalSyntheticLambda1(this)));
   }
}
