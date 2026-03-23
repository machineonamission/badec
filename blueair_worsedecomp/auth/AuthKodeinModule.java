package com.blueair.auth;

import android.content.Context;
import com.blueair.core.service.AnalyticsService;
import com.blueair.core.service.SecurePrefs;
import com.blueair.core.service.UnsecurePrefs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import org.kodein.di.DI;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/auth/AuthKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AuthKodeinModule.kt */
public final class AuthKodeinModule {
    public static final AuthKodeinModule INSTANCE = new AuthKodeinModule();
    public static final String moduleName = "auth";

    private AuthKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(moduleName, false, (String) null, new AuthKodeinModule$$ExternalSyntheticLambda5(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final LocationService getModule$lambda$6$lambda$0(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$0$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new LocationService(context, (UnsecurePrefs) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, UnsecurePrefs.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final GigyaService getModule$lambda$6$lambda$1(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$1$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$1$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$1$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new GigyaService(context, (LocationService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null), (SecurePrefs) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, SecurePrefs.class), (Object) null), (AnalyticsService) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, AnalyticsService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final FacebookService getModule$lambda$6$lambda$2(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        return new FacebookService();
    }

    /* access modifiers changed from: private */
    public static final AuthService getModule$lambda$6$lambda$4(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$4$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$4$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$4$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI4 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$4$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI5 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$4$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        AuthService authService = new AuthService((GigyaService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, GigyaService.class), (Object) null), (SecurePrefs) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, SecurePrefs.class), (Object) null), (UnsecurePrefs) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, UnsecurePrefs.class), (Object) null), (LocationService) directDI4.Instance(new GenericJVMTypeTokenDelegate(typeToken4, LocationService.class), (Object) null), (AnalyticsService) directDI5.Instance(new GenericJVMTypeTokenDelegate(typeToken5, AnalyticsService.class), (Object) null), (Interceptor) null, 32, (DefaultConstructorMarker) null);
        LogOutService.Companion.registerLogOutable(noArgBindingDI, authService);
        return authService;
    }

    /* access modifiers changed from: private */
    public static final LogOutService getModule$lambda$6$lambda$5(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$lambda$5$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new LogOutService((AnalyticsService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$6(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, LocationService.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        AuthKodeinModule$$ExternalSyntheticLambda0 authKodeinModule$$ExternalSyntheticLambda0 = new AuthKodeinModule$$ExternalSyntheticLambda0(context);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, LocationService.class), (RefMaker) null, true, authKodeinModule$$ExternalSyntheticLambda0));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, GigyaService.class), (Object) null, (Boolean) null);
        AuthKodeinModule$$ExternalSyntheticLambda1 authKodeinModule$$ExternalSyntheticLambda1 = new AuthKodeinModule$$ExternalSyntheticLambda1(context);
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken4, GigyaService.class), (RefMaker) null, true, authKodeinModule$$ExternalSyntheticLambda1));
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$bind$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind3 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken5, FacebookService.class), (Object) null, (Boolean) null);
        AuthKodeinModule$$ExternalSyntheticLambda2 authKodeinModule$$ExternalSyntheticLambda2 = new AuthKodeinModule$$ExternalSyntheticLambda2();
        Scope scope3 = withScope.getScope();
        TypeToken contextType3 = withScope.getContextType();
        boolean explicitContext3 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$singleton$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind3.with(new Singleton(scope3, contextType3, explicitContext3, new GenericJVMTypeTokenDelegate(typeToken6, FacebookService.class), (RefMaker) null, true, authKodeinModule$$ExternalSyntheticLambda2));
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$bind$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind4 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken7, AuthService.class), (Object) null, (Boolean) null);
        AuthKodeinModule$$ExternalSyntheticLambda3 authKodeinModule$$ExternalSyntheticLambda3 = new AuthKodeinModule$$ExternalSyntheticLambda3();
        Scope scope4 = withScope.getScope();
        TypeToken contextType4 = withScope.getContextType();
        boolean explicitContext4 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$singleton$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind4.with(new Singleton(scope4, contextType4, explicitContext4, new GenericJVMTypeTokenDelegate(typeToken8, AuthService.class), (RefMaker) null, true, authKodeinModule$$ExternalSyntheticLambda3));
        JVMTypeToken<?> typeToken9 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$bind$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken9, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind5 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken9, LogOutService.class), (Object) null, (Boolean) null);
        AuthKodeinModule$$ExternalSyntheticLambda4 authKodeinModule$$ExternalSyntheticLambda4 = new AuthKodeinModule$$ExternalSyntheticLambda4();
        Scope scope5 = withScope.getScope();
        TypeToken contextType5 = withScope.getContextType();
        boolean explicitContext5 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken10 = TypeTokensJVMKt.typeToken(new AuthKodeinModule$getModule$lambda$6$$inlined$singleton$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken10, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind5.with(new Singleton(scope5, contextType5, explicitContext5, new GenericJVMTypeTokenDelegate(typeToken10, LogOutService.class), (RefMaker) null, true, authKodeinModule$$ExternalSyntheticLambda4));
        return Unit.INSTANCE;
    }
}
