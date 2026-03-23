package com.blueair.livestream;

import android.content.Context;
import com.airboxlab.icp.sdk.BlueAirManager;
import com.blueair.auth.AuthService;
import com.blueair.core.util.NetworkMonitor;
import io.flatcircle.ble.BleIcpController;
import io.flatcircle.ble.BleService;
import io.flatcircle.mqtt.MqttService;
import io.flatcircle.stomp.StompService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/livestream/LiveStreamKodeinModule;", "", "<init>", "()V", "MODULE_NAME", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "livestream_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LiveStreamKodeinModule.kt */
public final class LiveStreamKodeinModule {
    public static final LiveStreamKodeinModule INSTANCE = new LiveStreamKodeinModule();
    private static final String MODULE_NAME = "LiveStream";

    private LiveStreamKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(MODULE_NAME, false, (String) null, new LiveStreamKodeinModule$$ExternalSyntheticLambda0(), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final StreamService getModule$lambda$4$lambda$0(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$0$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$0$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI3 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$0$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI4 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$0$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new StreamService((MqttService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, MqttService.class), (Object) null), (StompService) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, StompService.class), (Object) null), (BleService) directDI3.Instance(new GenericJVMTypeTokenDelegate(typeToken3, BleService.class), (Object) null), (NetworkMonitor) directDI4.Instance(new GenericJVMTypeTokenDelegate(typeToken4, NetworkMonitor.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final MqttService getModule$lambda$4$lambda$1(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$1$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new MqttService((AuthService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final StompService getModule$lambda$4$lambda$2(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDI directDI = noArgBindingDI.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$2$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new StompService((AuthService) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final BleService getModule$lambda$4$lambda$3(NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$3$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$lambda$3$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new BleService(new BleIcpController((BlueAirManager) directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, BlueAirManager.class), (Object) null), (AuthService) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null)));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$4(DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, StreamService.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        LiveStreamKodeinModule$$ExternalSyntheticLambda1 liveStreamKodeinModule$$ExternalSyntheticLambda1 = new LiveStreamKodeinModule$$ExternalSyntheticLambda1();
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, StreamService.class), (RefMaker) null, true, liveStreamKodeinModule$$ExternalSyntheticLambda1));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, MqttService.class), (Object) null, (Boolean) null);
        LiveStreamKodeinModule$$ExternalSyntheticLambda2 liveStreamKodeinModule$$ExternalSyntheticLambda2 = new LiveStreamKodeinModule$$ExternalSyntheticLambda2();
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken4, MqttService.class), (RefMaker) null, true, liveStreamKodeinModule$$ExternalSyntheticLambda2));
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$bind$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind3 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken5, StompService.class), (Object) null, (Boolean) null);
        LiveStreamKodeinModule$$ExternalSyntheticLambda3 liveStreamKodeinModule$$ExternalSyntheticLambda3 = new LiveStreamKodeinModule$$ExternalSyntheticLambda3();
        Scope scope3 = withScope.getScope();
        TypeToken contextType3 = withScope.getContextType();
        boolean explicitContext3 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken6 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$singleton$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken6, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind3.with(new Singleton(scope3, contextType3, explicitContext3, new GenericJVMTypeTokenDelegate(typeToken6, StompService.class), (RefMaker) null, true, liveStreamKodeinModule$$ExternalSyntheticLambda3));
        JVMTypeToken<?> typeToken7 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$bind$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken7, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind4 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken7, BleService.class), (Object) null, (Boolean) null);
        LiveStreamKodeinModule$$ExternalSyntheticLambda4 liveStreamKodeinModule$$ExternalSyntheticLambda4 = new LiveStreamKodeinModule$$ExternalSyntheticLambda4();
        Scope scope4 = withScope.getScope();
        TypeToken contextType4 = withScope.getContextType();
        boolean explicitContext4 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken8 = TypeTokensJVMKt.typeToken(new LiveStreamKodeinModule$getModule$lambda$4$$inlined$singleton$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind4.with(new Singleton(scope4, contextType4, explicitContext4, new GenericJVMTypeTokenDelegate(typeToken8, BleService.class), (RefMaker) null, true, liveStreamKodeinModule$$ExternalSyntheticLambda4));
        return Unit.INSTANCE;
    }
}
