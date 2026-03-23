package com.blueair.android.viewmodel;

import android.app.Application;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.DevSettingsViewModel$uploadLog$1", f = "DevSettingsViewModel.kt", i = {0}, l = {356}, m = "invokeSuspend", n = {"app"}, s = {"L$0"})
/* compiled from: DevSettingsViewModel.kt */
final class DevSettingsViewModel$uploadLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $description;
    final /* synthetic */ LogLength $length;
    final /* synthetic */ IssueType $type;
    Object L$0;
    int label;
    final /* synthetic */ DevSettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DevSettingsViewModel$uploadLog$1(DevSettingsViewModel devSettingsViewModel, IssueType issueType, LogLength logLength, String str, Continuation<? super DevSettingsViewModel$uploadLog$1> continuation) {
        super(2, continuation);
        this.this$0 = devSettingsViewModel;
        this.$type = issueType;
        this.$length = logLength;
        this.$description = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevSettingsViewModel$uploadLog$1(this.this$0, this.$type, this.$length, this.$description, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevSettingsViewModel$uploadLog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Application application = this.this$0.getApplication();
            this.L$0 = SpillingKt.nullOutSpilledVariable(application);
            this.label = 1;
            obj = this.this$0.getDeviceManager().uploadLog(application, this.$type, this.$length, this.$description, new DevSettingsViewModel$uploadLog$1$uuid$1(this.this$0), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Application application2 = (Application) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Timber.Forest forest = Timber.Forest;
        forest.d("UploadLog uuid: " + ((String) obj), new Object[0]);
        return Unit.INSTANCE;
    }
}
