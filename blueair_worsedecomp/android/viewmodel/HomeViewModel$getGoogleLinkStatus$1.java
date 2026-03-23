package com.blueair.android.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.LocationService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$getGoogleLinkStatus$1", f = "HomeViewModel.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$getGoogleLinkStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$getGoogleLinkStatus$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$getGoogleLinkStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getGoogleLinkStatus$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$getGoogleLinkStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData<Boolean> mutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MutableLiveData<Boolean> googleLinked = this.this$0.getGoogleLinked();
            this.L$0 = googleLinked;
            this.label = 1;
            Object googleLinkStatus = this.this$0.getDeviceManager().getGoogleLinkStatus(LocationService.getGoogleClientId$default(this.this$0.getLocationService(), false, 1, (Object) null), this);
            if (googleLinkStatus == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutableLiveData = googleLinked;
            obj = googleLinkStatus;
        } else if (i == 1) {
            mutableLiveData = (MutableLiveData) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.this$0.fetchingGoogleLinked.postValue(Boxing.boxBoolean(false));
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        mutableLiveData.postValue(obj);
        this.this$0.fetchingGoogleLinked.postValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
