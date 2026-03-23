package com.blueair.android.dialog;

import com.blueair.core.model.NotificationSetting;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.dialog.NotificationCenterViewModel$updateNotificationSetting$1", f = "NotificationCenterViewModel.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationCenterViewModel.kt */
final class NotificationCenterViewModel$updateNotificationSetting$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ NotificationSetting $newSetting;
    final /* synthetic */ NotificationSetting $oldSetting;
    int label;
    final /* synthetic */ NotificationCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationCenterViewModel$updateNotificationSetting$1(NotificationCenterViewModel notificationCenterViewModel, NotificationSetting notificationSetting, NotificationSetting notificationSetting2, Continuation<? super NotificationCenterViewModel$updateNotificationSetting$1> continuation) {
        super(1, continuation);
        this.this$0 = notificationCenterViewModel;
        this.$newSetting = notificationSetting;
        this.$oldSetting = notificationSetting2;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationCenterViewModel$updateNotificationSetting$1(this.this$0, this.$newSetting, this.$oldSetting, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationCenterViewModel$updateNotificationSetting$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getDeviceManager().updateNotificationSetting(this.$newSetting, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((ApiResult) obj).isSuccess()) {
            this.this$0.postNotificationSetting(this.$newSetting);
        } else {
            this.this$0.postNotificationSetting(this.$oldSetting);
            this.this$0.showMessage(R.string.request_failed, ViewUtils.MessageType.ERROR.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
