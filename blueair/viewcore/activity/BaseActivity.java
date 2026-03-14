package com.blueair.viewcore.activity;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.ClosestKt;
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(
   d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010'\u001a\u0002H(\"\n\b\u0000\u0010(\u0018\u0001*\u00020)2\u0006\u0010*\u001a\u00020+H\u0086\b¢\u0006\u0002\u0010,J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020.H\u0014J\b\u00100\u001a\u00020.H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u0004\u0018\u00010\"X¤\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u00061"},
   d2 = {"Lcom/blueair/viewcore/activity/BaseActivity;", "Lcom/blueair/viewcore/activity/BaseLokaliseActivity;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "job", "Lkotlinx/coroutines/CompletableJob;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "Lkotlin/Lazy;", "value", "", "hasBeenPaused", "getHasBeenPaused", "()Z", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "analytics", "Lcom/blueair/core/service/AnalyticsService;", "getAnalytics", "()Lcom/blueair/core/service/AnalyticsService;", "analytics$delegate", "screenName", "", "getScreenName", "()Ljava/lang/String;", "firstForeground", "getFirstForeground", "getViewModel", "T", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "onResume", "", "onPause", "onDestroy", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseActivity extends BaseLokaliseActivity implements DIAware, CoroutineScope {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseActivity.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseActivity.class, "analytics", "getAnalytics()Lcom/blueair/core/service/AnalyticsService;", 0)))};
   private final Lazy analytics$delegate;
   private final Lazy di$delegate;
   private boolean firstForeground;
   private boolean hasBeenPaused;
   private final CompletableJob job = SupervisorKt.SupervisorJob$default((Job)null, 1, (Object)null);
   private final Lazy rxSubs$delegate = LazyKt.lazy(new BaseActivity$$ExternalSyntheticLambda0());

   // $FF: synthetic method
   public static CompositeDisposable $r8$lambda$en5EgkiNxrlxtcQV71BVJHJdJxU() {
      return rxSubs_delegate$lambda$0();
   }

   public BaseActivity() {
      DIPropertyDelegateProvider var2 = ClosestKt.closestDI();
      KProperty[] var1 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var1[0]);
      DIAware var3 = this;
      JVMTypeToken var4 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analytics$delegate = DIAwareKt.Instance(var3, (TypeToken)(new GenericJVMTypeTokenDelegate(var4, AnalyticsService.class)), (Object)null).provideDelegate(this, var1[1]);
      this.firstForeground = true;
   }

   private static final CompositeDisposable rxSubs_delegate$lambda$0() {
      return new CompositeDisposable();
   }

   protected final AnalyticsService getAnalytics() {
      return (AnalyticsService)this.analytics$delegate.getValue();
   }

   public CoroutineContext getCoroutineContext() {
      return Dispatchers.getMain().plus((CoroutineContext)this.job);
   }

   public DI getDi() {
      return (DI)this.di$delegate.getValue();
   }

   public DIContext getDiContext() {
      return DefaultImpls.getDiContext(this);
   }

   public DITrigger getDiTrigger() {
      return DefaultImpls.getDiTrigger(this);
   }

   protected final boolean getFirstForeground() {
      return this.firstForeground;
   }

   public final boolean getHasBeenPaused() {
      return this.hasBeenPaused;
   }

   protected final CompositeDisposable getRxSubs() {
      return (CompositeDisposable)this.rxSubs$delegate.getValue();
   }

   protected abstract String getScreenName();

   // $FF: synthetic method
   public final BaseViewModel getViewModel(ViewModelStoreOwner var1) {
      Intrinsics.checkNotNullParameter(var1, "owner");
      ViewModelProvider var3 = new ViewModelProvider(var1);
      Intrinsics.reifiedOperationMarker(4, "T");
      Class var2 = BaseViewModel.class;
      return (BaseViewModel)var3.get(BaseViewModel.class);
   }

   protected void onDestroy() {
      super.onDestroy();
      JobKt.cancelChildren$default(this.getCoroutineContext(), (CancellationException)null, 1, (Object)null);
   }

   protected void onPause() {
      this.hasBeenPaused = true;
      this.getRxSubs().clear();
      this.firstForeground = false;
      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      String var1 = this.getScreenName();
      if (var1 != null) {
         AnalyticsService var2 = this.getAnalytics();
         String var3 = this.getClass().getSimpleName();
         Intrinsics.checkNotNullExpressionValue(var3, "getSimpleName(...)");
         var2.event(new AnalyticEvent.ScreenViewEvent(var1, var3));
      }

   }
}
