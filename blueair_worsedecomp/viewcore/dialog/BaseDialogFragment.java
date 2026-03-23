package com.blueair.viewcore.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.dialog.PopupDialogFragment;
import com.blueair.viewcore.fragment.BaseFragmentInterface;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.blueair.viewcore.viewmodel.BaseViewModelAction;
import com.blueair.viewcore.viewmodel.BaseViewModelEvent;
import com.blueair.viewcore.viewmodel.ConfirmationMessage;
import com.blueair.viewcore.viewmodel.PopupMessage;
import com.blueair.viewcore.viewmodel.SnackbarMessage;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.coroutinehelper.MainCoroutineScope;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.CancellationException;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u00052\u00020\u0006B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\u0018\u001a\u0002H\u0019\"\n\b\u0001\u0010\u0019\u0018\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\b¢\u0006\u0002\u0010\u001cJ\u001a\u0010\u001d\u001a\u0002H\u0019\"\n\b\u0001\u0010\u0019\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u0002H\u0019\"\n\b\u0001\u0010\u0019\u0018\u0001*\u00020\u0002H\b¢\u0006\u0002\u0010\u001eJ\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020/H\u0016R\u001b\u0010\t\u001a\u00020\n8VX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108DX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010 \u001a\u00020!8VX\u0002¢\u0006\f\n\u0004\b$\u0010\u000e\u001a\u0004\b\"\u0010#R\u0016\u0010%\u001a\u0004\u0018\u00010&X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0012\u00102\u001a\u000203X\u0005¢\u0006\u0006\u001a\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/blueair/viewcore/dialog/BaseDialogFragment;", "VM", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "Landroidx/fragment/app/DialogFragment;", "Lcom/blueair/viewcore/fragment/BaseFragmentInterface;", "Lorg/kodein/di/DIAware;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "analytics", "Lcom/blueair/core/service/AnalyticsService;", "getAnalytics", "()Lcom/blueair/core/service/AnalyticsService;", "analytics$delegate", "screenName", "", "getScreenName", "()Ljava/lang/String;", "getViewModel", "T", "owner", "Landroidx/lifecycle/ViewModelStoreOwner;", "(Landroidx/lifecycle/ViewModelStoreOwner;)Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "getSharedViewModel", "()Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "getUniqueViewModel", "rxSubs", "Lio/reactivex/disposables/CompositeDisposable;", "getRxSubs", "()Lio/reactivex/disposables/CompositeDisposable;", "rxSubs$delegate", "snackbarAnchorView", "Landroid/view/View;", "getSnackbarAnchorView", "()Landroid/view/View;", "value", "", "hasBeenPaused", "getHasBeenPaused", "()Z", "onResume", "", "onPause", "onDestroy", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseDialogFragment.kt */
public abstract class BaseDialogFragment<VM extends BaseViewModel> extends DialogFragment implements BaseFragmentInterface<VM>, DIAware, CoroutineScope {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final /* synthetic */ MainCoroutineScope $$delegate_0 = new MainCoroutineScope();
    private final Lazy analytics$delegate;
    private final Lazy di$delegate;
    private boolean hasBeenPaused;
    private final Lazy rxSubs$delegate;
    private final View snackbarAnchorView;

    static {
        Class<BaseDialogFragment> cls = BaseDialogFragment.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "di", "getDi()Lorg/kodein/di/DI;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "analytics", "getAnalytics()Lcom/blueair/core/service/AnalyticsService;", 0))};
    }

    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    /* access modifiers changed from: protected */
    public abstract String getScreenName();

    public BaseDialogFragment() {
        DIPropertyDelegateProvider<Object> closestDI = ClosestKt.closestDI((Fragment) this);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.di$delegate = closestDI.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BaseDialogFragment$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.analytics$delegate = DIAwareKt.Instance(this, new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        this.rxSubs$delegate = LazyKt.lazy(new BaseDialogFragment$$ExternalSyntheticLambda0());
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

    /* access modifiers changed from: protected */
    public View getSnackbarAnchorView() {
        return this.snackbarAnchorView;
    }

    public final boolean getHasBeenPaused() {
        return this.hasBeenPaused;
    }

    public void onResume() {
        super.onResume();
        String screenName = getScreenName();
        if (screenName != null) {
            AnalyticsService analytics = getAnalytics();
            String simpleName = getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            analytics.event(new AnalyticEvent.ScreenViewEvent(screenName, simpleName));
        }
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getViewModel().getBaseActionPublisher(), new BaseDialogFragment$$ExternalSyntheticLambda1(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$5(BaseDialogFragment baseDialogFragment, BaseViewModelEvent baseViewModelEvent) {
        BaseViewModelAction action = baseViewModelEvent.getAction();
        if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.PressBack.INSTANCE)) {
            FragmentActivity activity = baseDialogFragment.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.FinishActivity.INSTANCE)) {
            FragmentActivity activity2 = baseDialogFragment.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowProgress.INSTANCE)) {
            Object variable = baseViewModelEvent.getVariable();
            Intrinsics.checkNotNull(variable, "null cannot be cast to non-null type kotlin.Boolean");
            baseDialogFragment.showProgress(((Boolean) variable).booleanValue());
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowSnackbar.INSTANCE)) {
            FragmentActivity activity3 = baseDialogFragment.getActivity();
            if (activity3 != null) {
                Object variable2 = baseViewModelEvent.getVariable();
                Intrinsics.checkNotNull(variable2, "null cannot be cast to non-null type com.blueair.viewcore.viewmodel.SnackbarMessage");
                SnackbarMessage snackbarMessage = (SnackbarMessage) variable2;
                if (baseDialogFragment.getSnackbarAnchorView() == null) {
                    ViewUtils.INSTANCE.showSnackbar((Activity) activity3, snackbarMessage.getMessageResId(), snackbarMessage.getType());
                } else {
                    ViewUtils viewUtils = ViewUtils.INSTANCE;
                    View snackbarAnchorView2 = baseDialogFragment.getSnackbarAnchorView();
                    Intrinsics.checkNotNull(snackbarAnchorView2);
                    viewUtils.showSnackbar(snackbarAnchorView2, snackbarMessage.getMessageResId(), snackbarMessage.getType());
                }
            }
        } else if (Intrinsics.areEqual((Object) action, (Object) BaseViewModelAction.ShowPopup.INSTANCE)) {
            FragmentActivity activity4 = baseDialogFragment.getActivity();
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
            FragmentActivity activity5 = baseDialogFragment.getActivity();
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

    public void onDestroy() {
        super.onDestroy();
        JobKt__JobKt.cancelChildren$default(getCoroutineContext(), (CancellationException) null, 1, (Object) null);
    }
}
