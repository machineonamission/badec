package com.blueair.android.activity;

import com.blueair.android.R;
import com.blueair.android.adapter.DrawerListAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isAvailable", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.activity.HomeActivity$updateNavigationView$1", f = "HomeActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeActivity.kt */
final class HomeActivity$updateNavigationView$1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ HomeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeActivity$updateNavigationView$1(HomeActivity homeActivity, Continuation<? super HomeActivity$updateNavigationView$1> continuation) {
        super(2, continuation);
        this.this$0 = homeActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeActivity$updateNavigationView$1 homeActivity$updateNavigationView$1 = new HomeActivity$updateNavigationView$1(this.this$0, continuation);
        homeActivity$updateNavigationView$1.Z$0 = ((Boolean) obj).booleanValue();
        return homeActivity$updateNavigationView$1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) (Continuation) obj2);
    }

    public final Object invoke(boolean z, Continuation<? super Unit> continuation) {
        return ((HomeActivity$updateNavigationView$1) create(Boolean.valueOf(z), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z = this.Z$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            DrawerListAdapter access$getDrawerListAdapter$p = this.this$0.drawerListAdapter;
            if (access$getDrawerListAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("drawerListAdapter");
                access$getDrawerListAdapter$p = null;
            }
            access$getDrawerListAdapter$p.updateMenu(R.id.action_integrations, z);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
