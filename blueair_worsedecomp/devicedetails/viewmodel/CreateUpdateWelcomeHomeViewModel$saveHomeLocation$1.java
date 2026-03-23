package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.devicemanager.DeviceManager;
import io.flatcircle.coroutinehelper.ApiResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1", f = "CreateUpdateWelcomeHomeViewModel.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
final class CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreateUpdateWelcomeHomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, Continuation<? super CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1> continuation) {
        super(2, continuation);
        this.this$0 = createUpdateWelcomeHomeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUpdateWelcomeHomeViewModel$saveHomeLocation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            DeviceManager access$getDeviceManager = this.this$0.getDeviceManager();
            Device device = this.this$0.getDevice();
            Double lat = this.this$0.getLat();
            Intrinsics.checkNotNull(lat);
            double doubleValue = lat.doubleValue();
            Double lng = this.this$0.getLng();
            Intrinsics.checkNotNull(lng);
            double doubleValue2 = lng.doubleValue();
            WelcomeHomeLocation.WelcomeHomeRadius selectedRadius = this.this$0.getSelectedRadius();
            Intrinsics.checkNotNull(selectedRadius);
            int value = (int) selectedRadius.getValue();
            String value2 = (this.this$0.getUseShortAddress() ? this.this$0.getShortAddress() : this.this$0.getAddress()).getValue();
            Intrinsics.checkNotNull(value2);
            this.label = 1;
            obj = access$getDeviceManager.addWelcomeHomeLocation(device, new WelcomeHomeLocation(doubleValue, doubleValue2, value, value2, true), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel = this.this$0;
        createUpdateWelcomeHomeViewModel._loading.setValue(Boxing.boxBoolean(false));
        if (((ApiResult) obj).isSuccess()) {
            createUpdateWelcomeHomeViewModel._success.setValue(Unit.INSTANCE);
        } else {
            createUpdateWelcomeHomeViewModel._failure.setValue(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }
}
