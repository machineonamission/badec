package com.blueair.adddevice.activity;

import com.blueair.core.PrefKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.activity.AddDeviceActivityLegacy$onCloseClick$2$1", f = "AddDeviceActivityLegacy.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceActivityLegacy.kt */
final class AddDeviceActivityLegacy$onCloseClick$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ AddDeviceActivityLegacy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceActivityLegacy$onCloseClick$2$1(AddDeviceActivityLegacy addDeviceActivityLegacy, String str, Continuation<? super AddDeviceActivityLegacy$onCloseClick$2$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceActivityLegacy;
        this.$it = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceActivityLegacy$onCloseClick$2$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceActivityLegacy$onCloseClick$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getDeviceManager().removeAblDeviceRemote(this.$it, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getPrefs().remove(PrefKeys.KEY_LEGACY_DEVICE_TO_DELETE);
        return Unit.INSTANCE;
    }
}
