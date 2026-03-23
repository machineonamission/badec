package com.blueair.database.repository;

import com.blueair.core.model.DataTrend;
import com.blueair.core.model.DeviceData;
import com.blueair.database.entity.DeviceDataEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.DeviceRepository$insertAndReplaceDeviceData$2", f = "DeviceRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceRepository.kt */
final class DeviceRepository$insertAndReplaceDeviceData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DataTrend $dataTrend;
    final /* synthetic */ DeviceData $deviceData;
    int label;
    final /* synthetic */ DeviceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceRepository$insertAndReplaceDeviceData$2(DeviceRepository deviceRepository, DeviceData deviceData, DataTrend dataTrend, Continuation<? super DeviceRepository$insertAndReplaceDeviceData$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceRepository;
        this.$deviceData = deviceData;
        this.$dataTrend = dataTrend;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceRepository$insertAndReplaceDeviceData$2(this.this$0, this.$deviceData, this.$dataTrend, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeviceRepository$insertAndReplaceDeviceData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.blueairDb.deviceDao().device(this.$deviceData.getDeviceId()) != null) {
                try {
                    this.this$0.blueairDb.deviceDataDao().insertAllAndReplace(this.$deviceData.getDeviceId(), DeviceDataEntity.Companion.fromDeviceData(this.$deviceData, this.$dataTrend));
                } catch (Throwable th) {
                    Timber.Forest forest = Timber.Forest;
                    forest.e(th, "insertAndReplaceDeviceData: runtime exception: " + th.getMessage(), new Object[0]);
                }
            } else {
                Timber.Forest forest2 = Timber.Forest;
                forest2.w("insertAndReplaceDeviceData: IGNORED since device " + this.$deviceData.getDeviceId() + " does not exist", new Object[0]);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
