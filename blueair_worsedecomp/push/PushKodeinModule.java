package com.blueair.push;

import android.content.Context;
import com.blueair.auth.AuthService;
import com.blueair.devicemanager.DeviceManager;
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

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/push/PushKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "push_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PushKodeinModule.kt */
public final class PushKodeinModule {
    public static final PushKodeinModule INSTANCE = new PushKodeinModule();
    public static final String moduleName = "Push";

    private PushKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(moduleName, false, (String) null, new PushKodeinModule$$ExternalSyntheticLambda0(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final NotificationService getModule$lambda$1$lambda$0(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        DirectDIAware directDIAware = noArgBindingDI;
        DirectDI directDI = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new PushKodeinModule$getModule$lambda$1$lambda$0$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        directDI.Instance(new GenericJVMTypeTokenDelegate(typeToken, DeviceManager.class), (Object) null);
        DirectDI directDI2 = directDIAware.getDirectDI();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new PushKodeinModule$getModule$lambda$1$lambda$0$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        return new NotificationService(context, (AuthService) directDI2.Instance(new GenericJVMTypeTokenDelegate(typeToken2, AuthService.class), (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$1(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new PushKodeinModule$getModule$lambda$1$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, NotificationService.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        PushKodeinModule$$ExternalSyntheticLambda1 pushKodeinModule$$ExternalSyntheticLambda1 = new PushKodeinModule$$ExternalSyntheticLambda1(context);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new PushKodeinModule$getModule$lambda$1$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, NotificationService.class), (RefMaker) null, true, pushKodeinModule$$ExternalSyntheticLambda1));
        return Unit.INSTANCE;
    }
}
