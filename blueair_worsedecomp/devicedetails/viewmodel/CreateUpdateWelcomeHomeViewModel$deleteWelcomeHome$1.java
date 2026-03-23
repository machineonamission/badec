package com.blueair.devicedetails.viewmodel;

import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1", f = "CreateUpdateWelcomeHomeViewModel.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
final class CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreateUpdateWelcomeHomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, Continuation<? super CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1> continuation) {
        super(2, continuation);
        this.this$0 = createUpdateWelcomeHomeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUpdateWelcomeHomeViewModel$deleteWelcomeHome$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getDeviceManager().deleteWelcomeHome(this.this$0.getDevice().getUid(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel = this.this$0;
        createUpdateWelcomeHomeViewModel._loading.setValue(Boxing.boxBoolean(false));
        if (((ApiResult) obj).isSuccess()) {
            createUpdateWelcomeHomeViewModel._success.setValue(Unit.INSTANCE);
        } else {
            createUpdateWelcomeHomeViewModel._failure.setValue(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
