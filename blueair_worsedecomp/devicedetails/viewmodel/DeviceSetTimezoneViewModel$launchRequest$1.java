package com.blueair.devicedetails.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceSetTimezoneViewModel$launchRequest$1", f = "DeviceSetTimezoneViewModel.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceSetTimezoneViewModel.kt */
final class DeviceSetTimezoneViewModel$launchRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
    int label;
    final /* synthetic */ DeviceSetTimezoneViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceSetTimezoneViewModel$launchRequest$1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, DeviceSetTimezoneViewModel deviceSetTimezoneViewModel, Continuation<? super DeviceSetTimezoneViewModel$launchRequest$1> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.this$0 = deviceSetTimezoneViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceSetTimezoneViewModel$launchRequest$1(this.$action, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceSetTimezoneViewModel$launchRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Unit>, Object> function1 = this.$action;
            this.label = 1;
            if (function1.invoke(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.this$0._requesting.postValue(Boxing.boxBoolean(false));
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0._requesting.postValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
