package com.blueair.login;

import android.view.View;
import com.blueair.login.databinding.ActivityDisableIotConfirmBinding;
import com.blueair.viewcore.view.ProgressBlockerView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "state", "Lcom/blueair/login/DisableIoTState;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.DisableIoTConfirmActivity$onCreate$1$3", f = "DisableIoTConfirmActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DisableIoTConfirmActivity.kt */
final class DisableIoTConfirmActivity$onCreate$1$3 extends SuspendLambda implements Function2<DisableIoTState, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivityDisableIotConfirmBinding $this_apply;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DisableIoTConfirmActivity this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DisableIoTConfirmActivity.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.blueair.login.DisableIoTState[] r0 = com.blueair.login.DisableIoTState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.login.DisableIoTState r1 = com.blueair.login.DisableIoTState.Disabled     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.login.DisableIoTState r1 = com.blueair.login.DisableIoTState.Failed     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.login.DisableIoTConfirmActivity$onCreate$1$3.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DisableIoTConfirmActivity$onCreate$1$3(ActivityDisableIotConfirmBinding activityDisableIotConfirmBinding, DisableIoTConfirmActivity disableIoTConfirmActivity, Continuation<? super DisableIoTConfirmActivity$onCreate$1$3> continuation) {
        super(2, continuation);
        this.$this_apply = activityDisableIotConfirmBinding;
        this.this$0 = disableIoTConfirmActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DisableIoTConfirmActivity$onCreate$1$3 disableIoTConfirmActivity$onCreate$1$3 = new DisableIoTConfirmActivity$onCreate$1$3(this.$this_apply, this.this$0, continuation);
        disableIoTConfirmActivity$onCreate$1$3.L$0 = obj;
        return disableIoTConfirmActivity$onCreate$1$3;
    }

    public final Object invoke(DisableIoTState disableIoTState, Continuation<? super Unit> continuation) {
        return ((DisableIoTConfirmActivity$onCreate$1$3) create(disableIoTState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        DisableIoTState disableIoTState = (DisableIoTState) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ProgressBlockerView progressBlockerView = this.$this_apply.loading;
            Intrinsics.checkNotNullExpressionValue(progressBlockerView, "loading");
            View view = progressBlockerView;
            int i = 0;
            if (!(disableIoTState == DisableIoTState.Disabling)) {
                i = 8;
            }
            view.setVisibility(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[disableIoTState.ordinal()];
            if (i2 == 1) {
                this.this$0.onIoTDisabled();
            } else if (i2 == 2) {
                this.this$0.onDisablingFailed();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
