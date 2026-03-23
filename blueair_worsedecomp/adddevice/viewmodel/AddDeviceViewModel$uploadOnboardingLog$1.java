package com.blueair.adddevice.viewmodel;

import com.blueair.api.utils.ProgressListener;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.viewmodel.AddDeviceViewModel$uploadOnboardingLog$1", f = "AddDeviceViewModel.kt", i = {}, l = {229}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceViewModel.kt */
final class AddDeviceViewModel$uploadOnboardingLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $message;
    int label;
    final /* synthetic */ AddDeviceViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceViewModel$uploadOnboardingLog$1(AddDeviceViewModel addDeviceViewModel, String str, Continuation<? super AddDeviceViewModel$uploadOnboardingLog$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceViewModel;
        this.$message = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceViewModel$uploadOnboardingLog$1(this.this$0, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceViewModel$uploadOnboardingLog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.getDeviceManager().uploadLog(this.this$0.getApplication(), IssueType.ONBOARDING, LogLength.M10, this.$message, new ProgressListener() {
                public void update(long j, long j2, boolean z) {
                    Timber.Forest forest = Timber.Forest;
                    forest.d("upload onboarding log: " + ((int) ((((long) 100) * j) / j2)) + "% done", new Object[0]);
                }

                public void onFailure(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "t");
                    Timber.Forest forest = Timber.Forest;
                    forest.e(th, "upload onboarding log failed: " + th.getMessage(), new Object[0]);
                }
            }, this) == coroutine_suspended) {
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
