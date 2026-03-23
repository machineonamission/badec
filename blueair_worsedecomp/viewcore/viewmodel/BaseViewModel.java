package com.blueair.viewcore.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.viewmodel.BaseViewModelAction;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import io.reactivex.subjects.PublishSubject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.LazyContextDIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020$J\u0010\u0010(\u001a\u00020$2\b\b\u0002\u0010)\u001a\u00020*Jd\u0010+\u001a\u00020$2\b\b\u0003\u0010,\u001a\u00020-2\b\b\u0003\u0010.\u001a\u00020-2\b\b\u0003\u0010/\u001a\u00020-2\n\b\u0003\u00100\u001a\u0004\u0018\u00010-2\n\b\u0003\u00101\u001a\u0004\u0018\u00010-2!\u00102\u001a\u001d\u0012\u0013\u0012\u00110*¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020$03¢\u0006\u0002\u00107J+\u00108\u001a\u00020$2\b\b\u0001\u0010,\u001a\u00020-2\n\b\u0001\u00109\u001a\u0004\u0018\u00010-2\b\b\u0001\u0010.\u001a\u00020-¢\u0006\u0002\u0010:J\u001a\u0010;\u001a\u00020$2\b\b\u0001\u0010.\u001a\u00020-2\b\b\u0002\u0010<\u001a\u00020=J\u0006\u0010>\u001a\u00020$J\u0006\u0010?\u001a\u00020$J\u001c\u0010@\u001a\u00020$\"\u0004\b\u0000\u0010A2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002HA0\nH\u0002R%\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\t8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0015\u001a\u00020\u00168DX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8DX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006B"}, d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "baseActionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelEvent;", "getBaseActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "baseActionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "deviceManager", "Lcom/blueair/devicemanager/DeviceManager;", "getDeviceManager", "()Lcom/blueair/devicemanager/DeviceManager;", "deviceManager$delegate", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "getAnalyticsService", "()Lcom/blueair/core/service/AnalyticsService;", "analyticsService$delegate", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "postAnalyticsEvent", "", "event", "Lcom/blueair/core/model/AnalyticEvent;", "hideProgress", "showProgress", "shouldShowProgress", "", "showConfirmation", "titleResId", "", "messageResId", "positiveResId", "negativeResId", "topImageResId", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "confirmed", "(IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "showPopup", "subtitleResId", "(ILjava/lang/Integer;I)V", "showMessage", "messageType", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "pressBack", "finishActivity", "publishEvent", "T", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseViewModel.kt */
public abstract class BaseViewModel extends AndroidViewModel implements DIAware, CoroutineScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final Lazy analyticsService$delegate;
    private final LazyPublishSubject baseActionPublisher$delegate = new LazyPublishSubject();
    private final Lazy deviceManager$delegate;
    private final Lazy di$delegate;

    static {
        Class<BaseViewModel> cls = BaseViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "baseActionPublisher", "getBaseActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "deviceManager", "getDeviceManager()Lcom/blueair/devicemanager/DeviceManager;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "analyticsService", "getAnalyticsService()Lcom/blueair/core/service/AnalyticsService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        LazyContextDIPropertyDelegateProvider closestDI = ClosestKt.closestDI((AndroidViewModel) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[1]);
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BaseViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.deviceManager$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, DeviceManager.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BaseViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analyticsService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, AnalyticsService.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public final PublishSubject<BaseViewModelEvent<?>> getBaseActionPublisher() {
        return this.baseActionPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final DeviceManager getDeviceManager() {
        return (DeviceManager) this.deviceManager$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final AnalyticsService getAnalyticsService() {
        return (AnalyticsService) this.analyticsService$delegate.getValue();
    }

    public CoroutineContext getCoroutineContext() {
        return ViewModelKt.getViewModelScope(this).getCoroutineContext();
    }

    public final void postAnalyticsEvent(AnalyticEvent analyticEvent) {
        Intrinsics.checkNotNullParameter(analyticEvent, "event");
        getAnalyticsService().event(analyticEvent);
    }

    public final void hideProgress() {
        showProgress(false);
    }

    public static /* synthetic */ void showProgress$default(BaseViewModel baseViewModel, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = true;
            }
            baseViewModel.showProgress(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
    }

    public final void showProgress(boolean z) {
        publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowProgress.INSTANCE, Boolean.valueOf(z)));
    }

    public static /* synthetic */ void showConfirmation$default(BaseViewModel baseViewModel, int i, int i2, int i3, Integer num, Integer num2, Function1 function1, int i4, Object obj) {
        Function1 function12;
        Integer num3;
        Integer num4;
        int i5;
        int i6;
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i = R.string.confirmation_title_default;
            }
            if ((i4 & 2) != 0) {
                i2 = R.string.confirmation_message_default;
            }
            if ((i4 & 4) != 0) {
                i3 = R.string.confirmation_positive_default;
            }
            if ((i4 & 8) != 0) {
                num = null;
            }
            if ((i4 & 16) != 0) {
                num3 = null;
                i5 = i3;
                function12 = function1;
                i6 = i;
                num4 = num;
            } else {
                num3 = num2;
                function12 = function1;
                i5 = i3;
                num4 = num;
                i6 = i;
            }
            baseViewModel.showConfirmation(i6, i2, i5, num4, num3, function12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showConfirmation");
    }

    public final void showConfirmation(int i, int i2, int i3, Integer num, Integer num2, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowConfirmation.INSTANCE, new ConfirmationMessage(i, i2, i3, num, num2, function1)));
    }

    public final void showPopup(int i, Integer num, int i2) {
        publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowPopup.INSTANCE, new PopupMessage(i, num, i2)));
    }

    public static /* synthetic */ void showMessage$default(BaseViewModel baseViewModel, int i, ViewUtils.MessageType messageType, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                messageType = ViewUtils.MessageType.INFO.INSTANCE;
            }
            baseViewModel.showMessage(i, messageType);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showMessage");
    }

    public final void showMessage(int i, ViewUtils.MessageType messageType) {
        Intrinsics.checkNotNullParameter(messageType, "messageType");
        publishEvent(new BaseViewModelEvent(BaseViewModelAction.ShowSnackbar.INSTANCE, new SnackbarMessage(i, messageType)));
    }

    public final void pressBack() {
        publishEvent(new BaseViewModelEvent(BaseViewModelAction.PressBack.INSTANCE, Unit.INSTANCE));
    }

    public final void finishActivity() {
        publishEvent(new BaseViewModelEvent(BaseViewModelAction.FinishActivity.INSTANCE, Unit.INSTANCE));
        onCleared();
    }

    private final <T> void publishEvent(BaseViewModelEvent<T> baseViewModelEvent) {
        if (!getBaseActionPublisher().hasObservers()) {
            Timber.Forest.w("No fragments/activities/views are subscribed for message", new Object[0]);
        }
        getBaseActionPublisher().onNext(baseViewModelEvent);
    }
}
