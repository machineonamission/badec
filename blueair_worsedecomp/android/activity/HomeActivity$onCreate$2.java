package com.blueair.android.activity;

import com.blueair.viewcore.activity.Actions;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "signedIn", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.activity.HomeActivity$onCreate$2", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeActivity.kt */
final class HomeActivity$onCreate$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$onCreate$2(HomeActivity homeActivity, Continuation<? super HomeActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeActivity$onCreate$2 homeActivity$onCreate$2 = new HomeActivity$onCreate$2(this.this$0, continuation);
        homeActivity$onCreate$2.Z$0 = ((Boolean) obj).booleanValue();
        return homeActivity$onCreate$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((HomeActivity$onCreate$2) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (!z) {
                this.this$0.startActivity(Actions.openWelcomeIntent$default(Actions.INSTANCE, this.this$0, false, 2, (Object) null));
                this.this$0.finish();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
