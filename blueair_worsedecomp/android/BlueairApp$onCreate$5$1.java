package com.blueair.android;

import com.blueair.core.PrefKeys;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicemanager.DeviceManager;
import kotlin.Lazy;
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
@DebugMetadata(c = "com.blueair.android.BlueairApp$onCreate$5$1", f = "BlueairApp.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BlueairApp.kt */
final class BlueairApp$onCreate$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lazy<DeviceManager> $deviceManager$delegate;
    final /* synthetic */ String $it;
    final /* synthetic */ Lazy<UnsecurePrefs> $prefs$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BlueairApp$onCreate$5$1(String str, Lazy<DeviceManager> lazy, Lazy<UnsecurePrefs> lazy2, Continuation<? super BlueairApp$onCreate$5$1> continuation) {
        super(2, continuation);
        this.$it = str;
        this.$deviceManager$delegate = lazy;
        this.$prefs$delegate = lazy2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BlueairApp$onCreate$5$1(this.$it, this.$deviceManager$delegate, this.$prefs$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BlueairApp$onCreate$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (BlueairApp.onCreate$lambda$16(this.$deviceManager$delegate).removeAblDeviceRemote(this.$it, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        BlueairApp.onCreate$lambda$13(this.$prefs$delegate).remove(PrefKeys.KEY_LEGACY_DEVICE_TO_DELETE);
        return Unit.INSTANCE;
    }
}
