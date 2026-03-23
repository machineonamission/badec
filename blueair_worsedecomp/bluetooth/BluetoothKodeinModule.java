package com.blueair.bluetooth;

import android.content.Context;
import com.blueair.bluetooth.service.BleScanningService;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kodein.di.DI;
import org.kodein.di.bindings.NoArgBindingDI;
import org.kodein.di.bindings.RefMaker;
import org.kodein.di.bindings.Scope;
import org.kodein.di.bindings.Singleton;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/blueair/bluetooth/BluetoothKodeinModule;", "", "<init>", "()V", "moduleName", "", "getModule", "Lorg/kodein/di/DI$Module;", "applicationContext", "Landroid/content/Context;", "bluetooth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: BluetoothKodeinModule.kt */
public final class BluetoothKodeinModule {
    public static final BluetoothKodeinModule INSTANCE = new BluetoothKodeinModule();
    public static final String moduleName = "Bluetooth";

    private BluetoothKodeinModule() {
    }

    public final DI.Module getModule(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        return new DI.Module(moduleName, false, (String) null, new BluetoothKodeinModule$$ExternalSyntheticLambda0(context), 6, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final BleScanningService getModule$lambda$2$lambda$0(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        return new BleScanningService(context);
    }

    /* access modifiers changed from: private */
    public static final BluetoothConnectivityService getModule$lambda$2$lambda$1(Context context, NoArgBindingDI noArgBindingDI) {
        Intrinsics.checkNotNullParameter(noArgBindingDI, "$this$singleton");
        return new BluetoothConnectivityService(context);
    }

    /* access modifiers changed from: private */
    public static final Unit getModule$lambda$2(Context context, DI.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$Module");
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BluetoothKodeinModule$getModule$lambda$2$$inlined$bind$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken, BleScanningService.class), (Object) null, (Boolean) null);
        DI.BindBuilder.WithScope withScope = builder;
        BluetoothKodeinModule$$ExternalSyntheticLambda1 bluetoothKodeinModule$$ExternalSyntheticLambda1 = new BluetoothKodeinModule$$ExternalSyntheticLambda1(context);
        Scope scope = withScope.getScope();
        TypeToken contextType = withScope.getContextType();
        boolean explicitContext = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new BluetoothKodeinModule$getModule$lambda$2$$inlined$singleton$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind.with(new Singleton(scope, contextType, explicitContext, new GenericJVMTypeTokenDelegate(typeToken2, BleScanningService.class), (RefMaker) null, true, bluetoothKodeinModule$$ExternalSyntheticLambda1));
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new BluetoothKodeinModule$getModule$lambda$2$$inlined$bind$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        DI.Builder.TypeBinder Bind2 = builder.Bind(new GenericJVMTypeTokenDelegate(typeToken3, BluetoothConnectivityService.class), (Object) null, (Boolean) null);
        BluetoothKodeinModule$$ExternalSyntheticLambda2 bluetoothKodeinModule$$ExternalSyntheticLambda2 = new BluetoothKodeinModule$$ExternalSyntheticLambda2(context);
        Scope scope2 = withScope.getScope();
        TypeToken contextType2 = withScope.getContextType();
        boolean explicitContext2 = withScope.getExplicitContext();
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new BluetoothKodeinModule$getModule$lambda$2$$inlined$singleton$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        Bind2.with(new Singleton(scope2, contextType2, explicitContext2, new GenericJVMTypeTokenDelegate(typeToken4, BluetoothConnectivityService.class), (RefMaker) null, true, bluetoothKodeinModule$$ExternalSyntheticLambda2));
        return Unit.INSTANCE;
    }
}
