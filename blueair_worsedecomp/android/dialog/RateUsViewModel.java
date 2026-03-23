package com.blueair.android.dialog;

import android.app.Application;
import com.blueair.auth.LocationService;
import com.blueair.core.model.AmplitudeEvent;
import com.blueair.core.model.UserRateNoEvent;
import com.blueair.core.model.UserRateSkipEvent;
import com.blueair.core.model.UserRateYesEvent;
import com.blueair.core.service.HappyUserService;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001c\u001a\u00020\u0018H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/blueair/android/dialog/RateUsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "Lkotlin/Lazy;", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "marketLink", "", "getMarketLink", "()Ljava/lang/String;", "feedbackLink", "getFeedbackLink", "onSkip", "", "trigger", "onImprovePositive", "onImproveNegative", "setRateUsAsShown", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RateUsViewModel.kt */
public final class RateUsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public static final int $stable = 8;
    private final Lazy happyUserService$delegate;
    private final Lazy locationService$delegate;

    static {
        Class<RateUsViewModel> cls = RateUsViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RateUsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new RateUsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.locationService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new RateUsViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.happyUserService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, HappyUserService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    private final HappyUserService getHappyUserService() {
        return (HappyUserService) this.happyUserService$delegate.getValue();
    }

    public final String getMarketLink() {
        return getLocationService().getMarketLink();
    }

    public final String getFeedbackLink() {
        boolean isInChina = getLocationService().isInChina();
        if (isInChina) {
            return "https://www.wjx.cn/vj/Yh98xwA.aspx";
        }
        if (!isInChina) {
            return "https://docs.google.com/forms/d/e/1FAIpQLSe67KIedm4zO_LP44cjgjtJ-tuQQU6HwNwsLRT4el43bKtJJg/viewform";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void onSkip(String str) {
        Intrinsics.checkNotNullParameter(str, "trigger");
        getAnalyticsService().amplitudeLog((AmplitudeEvent) new UserRateSkipEvent(str));
    }

    public final void onImprovePositive(String str) {
        Intrinsics.checkNotNullParameter(str, "trigger");
        setRateUsAsShown();
        getAnalyticsService().amplitudeLog((AmplitudeEvent) new UserRateYesEvent(str));
    }

    public final void onImproveNegative(String str) {
        Intrinsics.checkNotNullParameter(str, "trigger");
        setRateUsAsShown();
        getAnalyticsService().amplitudeLog((AmplitudeEvent) new UserRateNoEvent(str));
    }

    private final void setRateUsAsShown() {
        getHappyUserService().setRateUsShown(true);
    }
}
