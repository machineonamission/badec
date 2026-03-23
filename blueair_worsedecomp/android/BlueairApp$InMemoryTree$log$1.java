package com.blueair.android;

import com.blueair.android.BlueairApp;
import com.blueair.core.PrefKeys;
import com.blueair.core.service.UnsecurePrefs;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import org.kodein.di.DIAwareKt;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.BlueairApp$InMemoryTree$log$1", f = "BlueairApp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BlueairApp.kt */
final class BlueairApp$InMemoryTree$log$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(BlueairApp.InMemoryTree.class, "prefs", "<v#0>", 0))};
    int label;
    final /* synthetic */ BlueairApp this$0;
    final /* synthetic */ BlueairApp.InMemoryTree this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlueairApp$InMemoryTree$log$1(BlueairApp blueairApp, BlueairApp.InMemoryTree inMemoryTree, Continuation<? super BlueairApp$InMemoryTree$log$1> continuation) {
        super(2, continuation);
        this.this$0 = blueairApp;
        this.this$1 = inMemoryTree;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BlueairApp$InMemoryTree$log$1(this.this$0, this.this$1, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BlueairApp$InMemoryTree$log$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new BlueairApp$InMemoryTree$log$1$invokeSuspend$$inlined$instance$default$1().getSuperType());
            Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
            this.this$1.checkFileSizeLimit(((Number) PreferencesHelper.INSTANCE.get(invokeSuspend$lambda$0(DIAwareKt.Instance(this.this$0, new GenericJVMTypeTokenDelegate(typeToken, UnsecurePrefs.class), (Object) null).provideDelegate((Object) null, $$delegatedProperties[0])).getBackend(), PrefKeys.KEY_MAX_LOG_FILE_SIZE, Boxing.boxInt(100), Reflection.getOrCreateKotlinClass(Integer.class))).intValue());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    private static final UnsecurePrefs invokeSuspend$lambda$0(Lazy<UnsecurePrefs> lazy) {
        return lazy.getValue();
    }
}
