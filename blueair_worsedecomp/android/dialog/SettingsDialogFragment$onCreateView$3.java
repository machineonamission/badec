package com.blueair.android.dialog;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.dialog.SettingsDialogFragment$onCreateView$3", f = "SettingsDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SettingsDialogFragment.kt */
final class SettingsDialogFragment$onCreateView$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SettingsDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsDialogFragment$onCreateView$3(SettingsDialogFragment settingsDialogFragment, Continuation<? super SettingsDialogFragment$onCreateView$3> continuation) {
        super(2, continuation);
        this.this$0 = settingsDialogFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SettingsDialogFragment$onCreateView$3 settingsDialogFragment$onCreateView$3 = new SettingsDialogFragment$onCreateView$3(this.this$0, continuation);
        settingsDialogFragment$onCreateView$3.L$0 = obj;
        return settingsDialogFragment$onCreateView$3;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingsDialogFragment$onCreateView$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.android.dialog.SettingsDialogFragment$onCreateView$3$1", f = "SettingsDialogFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.android.dialog.SettingsDialogFragment$onCreateView$3$1  reason: invalid class name */
    /* compiled from: SettingsDialogFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(settingsDialogFragment, continuation);
            r0.Z$0 = ((Boolean) obj).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
        }

        public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            boolean z = this.Z$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                SettingsDialogFragment.onCreateView$setNotificationCenterVisibility(settingsDialogFragment, z);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final SettingsDialogFragment settingsDialogFragment = this.this$0;
            FlowKt.launchIn(FlowKt.onEach(this.this$0.getViewModel().isUserSignedIn(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null)), coroutineScope);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
