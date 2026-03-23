package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.HasWelcomeHome;
import com.blueair.core.model.WelcomeHomeLocation;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1", f = "CreateUpdateWelcomeHomeViewModel.kt", i = {0, 0}, l = {100}, m = "invokeSuspend", n = {"it", "$i$a$-let-CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2"}, s = {"L$0", "I$0"})
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
final class CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ CreateUpdateWelcomeHomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, Continuation<? super CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1> continuation) {
        super(2, continuation);
        this.this$0 = createUpdateWelcomeHomeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        WelcomeHomeLocation welcomeHome;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel = this.this$0;
            Iterator it = this.this$0.getDeviceManager().getDevices().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual((Object) ((Device) obj2).getUid(), (Object) createUpdateWelcomeHomeViewModel.getDevice().getUid())) {
                    break;
                }
            }
            HasWelcomeHome hasWelcomeHome = obj2 instanceof HasWelcomeHome ? (HasWelcomeHome) obj2 : null;
            if (!(hasWelcomeHome == null || (welcomeHome = hasWelcomeHome.getWelcomeHome()) == null)) {
                CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel2 = this.this$0;
                this.L$0 = SpillingKt.nullOutSpilledVariable(welcomeHome);
                this.I$0 = 0;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1(createUpdateWelcomeHomeViewModel2, welcomeHome, (Continuation<? super CreateUpdateWelcomeHomeViewModel$loadHomeLocation$1$2$1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            WelcomeHomeLocation welcomeHomeLocation = (WelcomeHomeLocation) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
