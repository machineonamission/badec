package com.blueair.outdoor;

import android.content.Context;
import android.content.res.Resources;
import com.blueair.api.client.MbGeoClient;
import com.blueair.api.client.OutdoorClient;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.auth.LogOutService;
import com.blueair.core.service.LocationNamePlaceholderProvider;
import com.blueair.database.BlueairDatabase;
import com.blueair.database.repository.TrackedLocationRepository;
import com.blueair.outdoor.service.GeocodeService;
import com.blueair.outdoor.service.OutdoorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import org.kodein.di.DI;
import org.kodein.di.DirectDI;
import org.kodein.di.DirectDIAware;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.Provider;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/outdoor/OutdoorKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "outdoor_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorKodeinModule.kt */
public final class OutdoorKodeinModule {
    public static final OutdoorKodeinModule INSTANCE = new OutdoorKodeinModule();
    public static final String moduleName = "Outdoor";

    private OutdoorKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(moduleName, false, (String) null, new OutdoorKodeinModule$$ExternalSyntheticLambda4(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final TrackedLocationRepository getModule$lambda$5$lambda$0(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$0$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new TrackedLocationRepository((BlueairDatabase) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, BlueairDatabase.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final MbGeoClient getModule$lambda$5$lambda$1(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$provider");
        return new MbGeoClient();
    }

    /* access modifiers changed from: private */
    public static final OutdoorService getModule$lambda$5$lambda$3(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$3$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$3$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$3$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        OutdoorClient outdoorClient = new OutdoorClient((Resources) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, Resources.class), (Object) null), (AuthService) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, AuthService.class), (Object) null), (Interceptor) null, 4, (DefaultConstructorMarker) null);
        DirectDI directDI4 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$3$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI5 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$3$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        GeocodeService geocodeService = (GeocodeService) directDI4.Instance(new GenericJVMTypeTokenDelegate(typeToken4, GeocodeService.class), (Object) null);
        OutdoorService outdoorService = new OutdoorService(context, (TrackedLocationRepository) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, TrackedLocationRepository.class), (Object) null), outdoorClient, geocodeService, (AuthService) directDI5.Instance(new GenericJVMTypeTokenDelegate(typeToken5, AuthService.class), (Object) null));
        LogOutService.Companion.registerLogOutable(noArgBindingDI, outdoorService);
        return outdoorService;
    }

    /* access modifiers changed from: private */
    public static final GeocodeService getModule$lambda$5$lambda$4(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$4$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$4$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$lambda$4$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new GeocodeService(context, (MbGeoClient) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, MbGeoClient.class), (Object) null), (LocationService) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, LocationService.class), (Object) null), (LocationNamePlaceholderProvider) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, LocationNamePlaceholderProvider.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$5(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, TrackedLocationRepository.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        OutdoorKodeinModule$$ExternalSyntheticLambda0 outdoorKodeinModule$$ExternalSyntheticLambda0 = new OutdoorKodeinModule$$ExternalSyntheticLambda0();
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, TrackedLocationRepository.class), (RefMaker) null, true, outdoorKodeinModule$$ExternalSyntheticLambda0));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, MbGeoClient.class), (Object) null, (Boolean) null);
        OutdoorKodeinModule$$ExternalSyntheticLambda1 outdoorKodeinModule$$ExternalSyntheticLambda1 = new OutdoorKodeinModule$$ExternalSyntheticLambda1();
        TypeToken contextType2 = builder.getContextType();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$provider$1().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Provider(contextType2, new GenericJVMTypeTokenDelegate(typeToken4, MbGeoClient.class), outdoorKodeinModule$$ExternalSyntheticLambda1));
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$bind$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind3 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken5, OutdoorService.class), (Object) null, (Boolean) null);
        OutdoorKodeinModule$$ExternalSyntheticLambda2 outdoorKodeinModule$$ExternalSyntheticLambda2 = new OutdoorKodeinModule$$ExternalSyntheticLambda2(context);
        Scope scope2 = withScope.getScope();
        TypeToken contextType3 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind3.with(new Singleton(scope2, contextType3, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken6, OutdoorService.class), (RefMaker) null, true, outdoorKodeinModule$$ExternalSyntheticLambda2));
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$bind$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind4 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken7, GeocodeService.class), (Object) null, (Boolean) null);
        OutdoorKodeinModule$$ExternalSyntheticLambda3 outdoorKodeinModule$$ExternalSyntheticLambda3 = new OutdoorKodeinModule$$ExternalSyntheticLambda3(context);
        Scope scope3 = withScope.getScope();
        TypeToken contextType4 = withScope.getContextType();
        boolean explicitContext3 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new OutdoorKodeinModule$getModule$lambda$5$$inlined$singleton$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind4.with(new Singleton(scope3, contextType4, explicitContext3, new GenericJVMTypeTokenDelegate(typeToken8, GeocodeService.class), (RefMaker) null, true, outdoorKodeinModule$$ExternalSyntheticLambda3));
        return Unit.INSTANCE;
    }
}
