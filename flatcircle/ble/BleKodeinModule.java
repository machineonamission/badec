package io.flatcircle.ble;

import android.content.Context;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.auth.AuthService;
import com.blueair.core.service.AnalyticsService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;
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

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/flatcircle/ble/BleKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "ble_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BleKodeinModule.kt */
public final class BleKodeinModule {
    public static final BleKodeinModule INSTANCE = new BleKodeinModule();
    public static final String moduleName = "Ble";

    private BleKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(moduleName, false, (String) null, new BleKodeinModule$$ExternalSyntheticLambda2(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final BlueAirManager getModule$lambda$2$lambda$0(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$lambda$0$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new BlueAirManager(context, DfuBaseService.class, (AnalyticsService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, AnalyticsService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final BleIcpController getModule$lambda$2$lambda$1(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$lambda$1$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$lambda$1$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new BleIcpController((BlueAirManager) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, BlueAirManager.class), (Object) null), (AuthService) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$2(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, BlueAirManager.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        BleKodeinModule$$ExternalSyntheticLambda0 bleKodeinModule$$ExternalSyntheticLambda0 = new BleKodeinModule$$ExternalSyntheticLambda0(context);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, BlueAirManager.class), (RefMaker) null, true, bleKodeinModule$$ExternalSyntheticLambda0));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, BleIcpController.class), (Object) null, (Boolean) null);
        BleKodeinModule$$ExternalSyntheticLambda1 bleKodeinModule$$ExternalSyntheticLambda1 = new BleKodeinModule$$ExternalSyntheticLambda1();
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new BleKodeinModule$getModule$lambda$2$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken4, BleIcpController.class), (RefMaker) null, true, bleKodeinModule$$ExternalSyntheticLambda1));
        return Unit.INSTANCE;
    }
}
