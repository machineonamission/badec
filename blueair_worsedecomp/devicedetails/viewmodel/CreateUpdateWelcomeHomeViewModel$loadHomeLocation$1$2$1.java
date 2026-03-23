package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.WelcomeHomeLocation;
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
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1", f = "CreateUpdateWelcomeHomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
final class CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WelcomeHomeLocation $it;
    int label;
    final /* synthetic */ CreateUpdateWelcomeHomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, WelcomeHomeLocation welcomeHomeLocation, Continuation<? super CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = createUpdateWelcomeHomeViewModel;
        this.$it = welcomeHomeLocation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setLat(Boxing.boxDouble(this.$it.getLat()));
            this.this$0.setLng(Boxing.boxDouble(this.$it.getLng()));
            this.this$0.setSelectedRadius(WelcomeHomeLocation.WelcomeHomeRadius.Companion.fromValue(Boxing.boxFloat((float) this.$it.getRadius())));
            this.this$0.getAddress().setValue(this.$it.getTextValue());
            this.this$0.getShortAddress().setValue(this.$it.getTextValue());
            this.this$0.getWelcomeHomeExist().postValue(Boxing.boxBoolean(true));
            this.this$0.fetchCity();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
