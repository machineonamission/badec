package com.blueair.viewcore.fragment;

import android.app.Activity;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.PopupDialogFragment;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.BaseViewModelAction;
import com.blueair.viewcore.viewmodel.BaseViewModelEvent;
import com.blueair.viewcore.viewmodel.ConfirmationMessage;
import com.blueair.viewcore.viewmodel.PopupMessage;
import com.blueair.viewcore.viewmodel.SnackbarMessage;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import org.kodein.di.android.DIPropertyDelegateProvider;
import org.kodein.di.android.x.ClosestKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u0014\u001a\u0002H\u0015\"\n\b\u0001\u0010\u0015\u0018\u0001*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\b¢\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u0002H\u0015\"\n\b\u0001\u0010\u0015\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0002H\u0015\"\n\b\u0001\u0010\u0015\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u001aJ\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016R\u001b\u0010\t\u001a\u00020\n8VX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108DX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u001c\u001a\u00020\u001d8VX\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\"@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010&\u001a\u0004\u0018\u00010'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8VX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/blueair/viewcore/fragment/BaseFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "analytics", "Lcom/blueair/core/service/AnalyticsService;", "getAnalytics", "()Lcom/blueair/core/service/AnalyticsService;", "analytics$delegate", "getViewModel", "T", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "getSharedViewModel", "()Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "getUniqueViewModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "value", "", "hasBeenPaused", "getHasBeenPaused", "()Z", "screenName", "", "getScreenName", "()Ljava/lang/String;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "onResume", "", "onPause", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment<VM extends BaseViewModel> extends Fragment implements BaseFragmentInterface<VM>, DIAware, CoroutineScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final Lazy analytics$delegate;
    private final Lazy di$delegate;
    private boolean hasBeenPaused;
    private final Lazy rxSubs$delegate = LazyKt.lazy(new BaseFragment$$ExternalSyntheticLambda0());
    private final String screenName;

    static {
        Class<BaseFragment> cls = BaseFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "analytics", "getAnalytics()Lcom/blueair/core/service/AnalyticsService;", 0))};
    }

    public BaseFragment() {
        DIPropertyDelegateProvider<Object> closestDI = ClosestKt.closestDI((Fragment) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BaseFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analytics$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final AnalyticsService getAnalytics() {
        return (AnalyticsService) this.analytics$delegate.getValue();
    }

    public final /* synthetic */ <T extends BaseViewModel> T getViewModel(ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "owner");
        ViewModelProvider viewModelProvider = new ViewModelProvider(viewModelStoreOwner);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class cls = BaseViewModel.class;
        Class cls2 = cls;
        return (BaseViewModel) viewModelProvider.get(cls);
    }

    public final /* synthetic */ <T extends BaseViewModel> T getSharedViewModel() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) requireActivity);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class cls = BaseViewModel.class;
        Class cls2 = cls;
        return (BaseViewModel) viewModelProvider.get(cls);
    }

    public final /* synthetic */ <T extends BaseViewModel> T getUniqueViewModel() {
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) this);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class cls = BaseViewModel.class;
        Class cls2 = cls;
        return (BaseViewModel) viewModelProvider.get(cls);
    }

    /* access modifiers changed from: private */
    public static final CompositeDisposable rxSubs_delegate$lambda$0() {
        return new CompositeDisposable();
    }

    public CompositeDisposable getRxSubs() {
        return (CompositeDisposable) this.rxSubs$delegate.getValue();
    }

    public final boolean getHasBeenPaused() {
        return this.hasBeenPaused;
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    public CoroutineContext getCoroutineContext() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        return LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner).getCoroutineContext();
    }

    public void onResume() {
        super.onResume();
        String screenName2 = getScreenName();
        if (screenName2 != null) {
            AnalyticsService analytics = getAnalytics();
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            analytics.event(new AnalyticEvent.ScreenViewEvent(screenName2, simpleName));
        }
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getViewModel().getBaseActionPublisher(), new BaseFragment$$ExternalSyntheticLambda1(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(BaseFragment baseFragment, BaseViewModelEvent baseViewModelEvent) {
        BaseViewModelAction action = baseViewModelEvent.getAction();
        if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.PressBack.INSTANCE)) {
            FragmentActivity activity = baseFragment.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.FinishActivity.INSTANCE)) {
            FragmentActivity activity2 = baseFragment.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowProgress.INSTANCE)) {
            Object variable = baseViewModelEvent.getVariable();
            Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type kotlin.Boolean");
            baseFragment.showProgress(((Boolean) variable).booleanValue());
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowSnackbar.INSTANCE)) {
            FragmentActivity activity3 = baseFragment.getActivity();
            if (activity3 != null) {
                Object variable2 = baseViewModelEvent.getVariable();
                Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.SnackbarMessage");
                SnackbarMessage snackbarMessage = (SnackbarMessage) variable2;
                ViewUtils.INSTANCE.showSnackbar((Activity) activity3, snackbarMessage.getMessageResId(), snackbarMessage.getType());
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowPopup.INSTANCE)) {
            FragmentActivity activity4 = baseFragment.getActivity();
            if (activity4 != null) {
                FragmentManager supportFragmentManager = activity4.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(PopupDialogFragment.Companion.getTAG());
                if (findFragmentByTag != null) {
                    supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
                }
                PopupDialogFragment.Companion companion = PopupDialogFragment.Companion;
                Object variable3 = baseViewModelEvent.getVariable();
                Intrinsics.checkNotNull(variable3, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.PopupMessage");
                companion.newInstance((PopupMessage) variable3).show(supportFragmentManager, PopupDialogFragment.Companion.getTAG());
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowConfirmation.INSTANCE)) {
            FragmentActivity activity5 = baseFragment.getActivity();
            if (activity5 != null) {
                Object variable4 = baseViewModelEvent.getVariable();
                Intrinsics.checkNotNull(variable4, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.ConfirmationMessage");
                ConfirmationMessage confirmationMessage = (ConfirmationMessage) variable4;
                ViewUtils.INSTANCE.showConfirmation((Context) activity5, confirmationMessage.getTitleResId(), confirmationMessage.getMessageResId(), confirmationMessage.getPositiveResId(), confirmationMessage.getNegativeResId(), confirmationMessage.getTopImageResId(), (Function1<? super Boolean, Unit>) confirmationMessage.getAction());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    public void onPause() {
        getRxSubs().clear();
        this.hasBeenPaused = true;
        super.onPause();
    }
}
