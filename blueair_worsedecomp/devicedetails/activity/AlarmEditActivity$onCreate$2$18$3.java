package com.blueair.devicedetails.activity;

import com.blueair.api.restapi.SimpleResponse;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.activity.AlarmEditActivity$onCreate$2$18$3", f = "AlarmEditActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AlarmEditActivity.kt */
final class AlarmEditActivity$onCreate$2$18$3 extends SuspendLambda implements Function2<ApiResult<SimpleResponse>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AlarmEditActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlarmEditActivity$onCreate$2$18$3(AlarmEditActivity alarmEditActivity, Continuation<? super AlarmEditActivity$onCreate$2$18$3> continuation) {
        super(2, continuation);
        this.this$0 = alarmEditActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AlarmEditActivity$onCreate$2$18$3 alarmEditActivity$onCreate$2$18$3 = new AlarmEditActivity$onCreate$2$18$3(this.this$0, continuation);
        alarmEditActivity$onCreate$2$18$3.L$0 = obj;
        return alarmEditActivity$onCreate$2$18$3;
    }

    public final Object invoke(ApiResult<SimpleResponse> apiResult, Continuation<? super Unit> continuation) {
        return ((AlarmEditActivity$onCreate$2$18$3) create(apiResult, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ApiResult apiResult = (ApiResult) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.hideProgress();
            if (apiResult.isSuccess()) {
                this.this$0.finish();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
