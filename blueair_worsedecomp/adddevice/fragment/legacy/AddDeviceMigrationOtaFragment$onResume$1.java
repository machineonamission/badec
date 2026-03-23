package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blueair.viewcore.ViewUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceMigrationOtaFragment$onResume$1", f = "AddDeviceMigrationOtaFragment.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceMigrationOtaFragment.kt */
final class AddDeviceMigrationOtaFragment$onResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AddDeviceMigrationOtaFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceMigrationOtaFragment$onResume$1(AddDeviceMigrationOtaFragment addDeviceMigrationOtaFragment, Continuation<? super AddDeviceMigrationOtaFragment$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceMigrationOtaFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceMigrationOtaFragment$onResume$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceMigrationOtaFragment$onResume$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getAddService().migrationOtaCheck((Function1<? super String, Unit>) new AddDeviceMigrationOtaFragment$onResume$1$$ExternalSyntheticLambda0(this.this$0), (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(AddDeviceMigrationOtaFragment addDeviceMigrationOtaFragment, String str) {
        FragmentActivity activity;
        View view = addDeviceMigrationOtaFragment.getView();
        if (!(!addDeviceMigrationOtaFragment.isAdded() || view == null || (activity = addDeviceMigrationOtaFragment.getActivity()) == null)) {
            ViewUtils.INSTANCE.showInfo((Activity) activity, str);
        }
        return Unit.INSTANCE;
    }
}
