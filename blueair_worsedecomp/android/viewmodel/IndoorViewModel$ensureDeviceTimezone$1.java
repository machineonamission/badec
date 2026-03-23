package com.blueair.android.viewmodel;

import android.content.Context;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.IndoorViewModel$ensureDeviceTimezone$1", f = "IndoorViewModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: IndoorViewModel.kt */
final class IndoorViewModel$ensureDeviceTimezone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ List<String> $nullTimezoneDeviceIdList;
    final /* synthetic */ TimeZone $timezone;
    int label;
    final /* synthetic */ IndoorViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IndoorViewModel$ensureDeviceTimezone$1(IndoorViewModel indoorViewModel, List<String> list, TimeZone timeZone, Context context, Continuation<? super IndoorViewModel$ensureDeviceTimezone$1> continuation) {
        super(2, continuation);
        this.this$0 = indoorViewModel;
        this.$nullTimezoneDeviceIdList = list;
        this.$timezone = timeZone;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IndoorViewModel$ensureDeviceTimezone$1(this.this$0, this.$nullTimezoneDeviceIdList, this.$timezone, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((IndoorViewModel$ensureDeviceTimezone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getDeviceManager().setDeviceTimezone(this.$nullTimezoneDeviceIdList, this.$timezone, this.$context, (Continuation<? super ApiResult<ResponseBody>>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
