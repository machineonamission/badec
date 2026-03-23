package com.blueair.android.viewmodel;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.DevSettingsViewModel$forceUpdateRemoteConfig$1", f = "DevSettingsViewModel.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DevSettingsViewModel.kt */
final class DevSettingsViewModel$forceUpdateRemoteConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DevSettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DevSettingsViewModel$forceUpdateRemoteConfig$1(DevSettingsViewModel devSettingsViewModel, Continuation<? super DevSettingsViewModel$forceUpdateRemoteConfig$1> continuation) {
        super(2, continuation);
        this.this$0 = devSettingsViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DevSettingsViewModel$forceUpdateRemoteConfig$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DevSettingsViewModel$forceUpdateRemoteConfig$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData<Boolean> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Boolean> remoteConfigUpdated = this.this$0.getRemoteConfigUpdated();
            this.L$0 = remoteConfigUpdated;
            this.label = 1;
            Object forceUpdate = this.this$0.remoteConfig.forceUpdate(this);
            if (forceUpdate == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = remoteConfigUpdated;
            obj = forceUpdate;
        } else if (i == 1) {
            mutableLiveData = (MutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(obj);
        return Unit.INSTANCE;
    }
}
