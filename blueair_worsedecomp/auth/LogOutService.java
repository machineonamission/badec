package com.blueair.auth;

import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.service.AnalyticsService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DirectDI;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/auth/LogOutService;", "", "analyticsService", "Lcom/blueair/core/service/AnalyticsService;", "<init>", "(Lcom/blueair/core/service/AnalyticsService;)V", "logOutableList", "", "Lcom/blueair/auth/LogOutable;", "registerLogOutable", "", "logOutable", "logOutRegistered", "reason", "Lcom/blueair/auth/LogoutReason;", "Companion", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LogOutService.kt */
public final class LogOutService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AnalyticsService analyticsService;
    private final List<LogOutable> logOutableList = new ArrayList();

    public LogOutService(AnalyticsService analyticsService2) {
        Intrinsics.checkNotNullParameter(analyticsService2, "analyticsService");
        this.analyticsService = analyticsService2;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/auth/LogOutService$Companion;", "", "<init>", "()V", "registerLogOutable", "", "diBinding", "Lorg/kodein/di/bindings/NoArgBindingDI;", "logOutable", "Lcom/blueair/auth/LogOutable;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LogOutService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void registerLogOutable(NoArgBindingDI<? extends Object> noArgBindingDI, LogOutable logOutable) {
            Intrinsics.checkNotNullParameter(noArgBindingDI, "diBinding");
            Intrinsics.checkNotNullParameter(logOutable, "logOutable");
            DirectDI directDI = noArgBindingDI.getDirectDI();
            JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LogOutService$Companion$registerLogOutable$$inlined$instance$default$1().getSuperType());
            Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            ((LogOutService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, LogOutService.class), (Object) null)).registerLogOutable(logOutable);
        }
    }

    public final void registerLogOutable(LogOutable logOutable) {
        Intrinsics.checkNotNullParameter(logOutable, "logOutable");
        this.logOutableList.add(logOutable);
    }

    public final void logOutRegistered(LogoutReason logoutReason) {
        Intrinsics.checkNotNullParameter(logoutReason, "reason");
        Timber.Forest.d("logOutRegistered: size = " + this.logOutableList.size(), new Object[0]);
        this.analyticsService.event(new AnalyticEvent.LogoutEvent(logoutReason.getValue()));
        for (LogOutable logOutable : this.logOutableList) {
            try {
                Timber.Forest.d("logOut " + logOutable, new Object[0]);
                logOutable.logOut();
            } catch (Exception e) {
                String str = logOutable + ", message: " + e.getLocalizedMessage();
                Timber.Forest.e(e, str, new Object[0]);
                this.analyticsService.event(new AnalyticEvent.BugEvent.LogoutFail(str));
            }
        }
    }
}
