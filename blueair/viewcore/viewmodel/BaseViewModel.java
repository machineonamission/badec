package com.blueair.viewcore.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.DIAware.DefaultImpls;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020$J\u0010\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*Jd\u0010+\u001a\u00020$2\b\b\u0003\u0010,\u001a\u00020-2\b\b\u0003\u0010.\u001a\u00020-2\b\b\u0003\u0010/\u001a\u00020-2\n\b\u0003\u00100\u001a\u0004\u0018\u00010-2\n\b\u0003\u00101\u001a\u0004\u0018\u00010-2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020$03¢\u0006\u0002\u00107J+\u00108\u001a\u00020$2\b\b\u0001\u0010,\u001a\u00020-2\n\b\u0001\u00109\u001a\u0004\u0018\u00010-2\b\b\u0001\u0010.\u001a\u00020-¢\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020$2\b\b\u0001\u0010.\u001a\u00020-2\b\b\u0002\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020$J\u0006\u0010?\u001a\u00020$J\u001c\u0010@\u001a\u00020$\"\u0004\b\u0000\u0010A2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002HA0\nH\u0002R%\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006B"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "baseActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelEvent;", "getBaseActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "baseActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "postAnalyticsEvent", "", "event", "Lcom/blueair/core/model/AnalyticEvent;", "hideProgress", "showProgress", "shouldShowProgress", "", "showConfirmation", "titleResId", "", "messageResId", "positiveResId", "negativeResId", "topImageResId", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "confirmed", "(IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "showPopup", "subtitleResId", "(ILjava/lang/Integer;I)V", "showMessage", "messageType", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "pressBack", "finishActivity", "publishEvent", "T", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseViewModel extends AndroidViewModel implements DIAware, CoroutineScope {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseViewModel.class, "baseActionPublisher", "getBaseActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseViewModel.class, "di", "getDi()Lorg/kodein/di/DI;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseViewModel.class, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(BaseViewModel.class, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0)))};
   private final Lazy analyticsService$delegate;
   private final LazyPublishSubject baseActionPublisher$delegate;
   private final Lazy deviceManager$delegate;
   private final Lazy di$delegate;

   public BaseViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.baseActionPublisher$delegate = new LazyPublishSubject();
      LazyContextDIPropertyDelegateProvider var2 = ClosestKt.closestDI(this);
      KProperty[] var4 = $$delegatedProperties;
      this.di$delegate = var2.provideDelegate(this, var4[1]);
      DIAware var5 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.deviceManager$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, DeviceManager.class)), (Object)null).provideDelegate(this, var4[2]);
      var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.analyticsService$delegate = DIAwareKt.Instance(var5, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AnalyticsService.class)), (Object)null).provideDelegate(this, var4[3]);
   }

   private final void publishEvent(BaseViewModelEvent var1) {
      if (!this.getBaseActionPublisher().hasObservers()) {
         Timber.Forest.w("No fragments/activities/views are subscribed for message", new Object[0]);
      }

      this.getBaseActionPublisher().onNext(var1);
   }

   // $FF: synthetic method
   public static void showConfirmation$default(BaseViewModel var0, int var1, int var2, int var3, Integer var4, Integer var5, Function1 var6, int var7, Object var8) {
      if (var8 == null) {
         if ((var7 & 1) != 0) {
            var1 = R.string.confirmation_title_default;
         }

         if ((var7 & 2) != 0) {
            var2 = R.string.confirmation_message_default;
         }

         if ((var7 & 4) != 0) {
            var3 = R.string.confirmation_positive_default;
         }

         if ((var7 & 8) != 0) {
            var4 = null;
         }

         if ((var7 & 16) != 0) {
            var5 = null;
         }

         var0.showConfirmation(var1, var2, var3, var4, var5, var6);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showConfirmation");
      }
   }

   // $FF: synthetic method
   public static void showMessage$default(BaseViewModel var0, int var1, ViewUtils.MessageType var2, int var3, Object var4) {
      if (var4 == null) {
         if ((var3 & 2) != 0) {
            var2 = ViewUtils.MessageType.INFO.INSTANCE;
         }

         var0.showMessage(var1, var2);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMessage");
      }
   }

   // $FF: synthetic method
   public static void showProgress$default(BaseViewModel var0, boolean var1, int var2, Object var3) {
      if (var3 == null) {
         if ((var2 & 1) != 0) {
            var1 = true;
         }

         var0.showProgress(var1);
      } else {
         throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
      }
   }

   public final void finishActivity() {
      this.publishEvent(new BaseViewModelEvent(BaseViewModelAction.FinishActivity.INSTANCE, Unit.INSTANCE));
      this.onCleared();
   }

   protected final AnalyticsService getAnalyticsService() {
      return (AnalyticsService)this.analyticsService$delegate.getValue();
   }

   public final PublishSubject getBaseActionPublisher() {
      return this.baseActionPublisher$delegate.getValue(this, $$delegatedProperties[0]);
   }

   public CoroutineContext getCoroutineContext() {
      return ViewModelKt.getViewModelScope((ViewModel)this).getCoroutineContext();
   }

   protected final DeviceManager getDeviceManager() {
      return (DeviceManager)this.deviceManager$delegate.getValue();
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

   public final void hideProgress() {
      this.showProgress(false);
   }

   public final void postAnalyticsEvent(AnalyticEvent var1) {
      Intrinsics.checkNotNullParameter(var1, "event");
      this.getAnalyticsService().event(var1);
   }

   public final void pressBack() {
      this.publishEvent(new BaseViewModelEvent(BaseViewModelAction.PressBack.INSTANCE, Unit.INSTANCE));
   }

   public final void showConfirmation(int var1, int var2, int var3, Integer var4, Integer var5, Function1 var6) {
      Intrinsics.checkNotNullParameter(var6, "action");
      this.publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowConfirmation.INSTANCE, new ConfirmationMessage(var1, var2, var3, var4, var5, var6)));
   }

   public final void showMessage(int var1, ViewUtils.MessageType var2) {
      Intrinsics.checkNotNullParameter(var2, "messageType");
      this.publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowSnackbar.INSTANCE, new SnackbarMessage(var1, var2)));
   }

   public final void showPopup(int var1, Integer var2, int var3) {
      this.publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowPopup.INSTANCE, new PopupMessage(var1, var2, var3)));
   }

   public final void showProgress(boolean var1) {
      this.publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowProgress.INSTANCE, var1));
   }
}
