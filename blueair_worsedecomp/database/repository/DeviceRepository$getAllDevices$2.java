package com.blueair.database.repository;

import com.blueair.core.model.Device;
import com.blueair.database.entity.DeviceEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/blueair/core/model/Device;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.database.repository.DeviceRepository$getAllDevices$2", f = "DeviceRepository.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceRepository.kt */
final class DeviceRepository$getAllDevices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Device>>, Object> {
    int label;
    final /* synthetic */ DeviceRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceRepository$getAllDevices$2(DeviceRepository deviceRepository, Continuation<? super DeviceRepository$getAllDevices$2> continuation) {
        super(2, continuation);
        this.this$0 = deviceRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeviceRepository$getAllDevices$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Device>> continuation) {
        return ((DeviceRepository$getAllDevices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.blueairDb.deviceDao().getDevices(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable<DeviceEntity> iterable = (Iterable) obj;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (DeviceEntity device : iterable) {
            arrayList.add(device.toDevice());
        }
        return (List) arrayList;
    }
}
