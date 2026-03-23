package com.blueair.android.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.blueair.core.PrefKeys;
import com.blueair.viewcore.TemperatureUtils;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
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
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$getTemperatureSettings$1", f = "HomeViewModel.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$getTemperatureSettings$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$getTemperatureSettings$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$getTemperatureSettings$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getTemperatureSettings$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$getTemperatureSettings$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getSettingsLoading().setValue(Boxing.boxBoolean(true));
            this.label = 1;
            obj = this.this$0.getDeviceManager().getTemperatureSettings(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String str = (String) obj;
        if (str != null) {
            PreferencesHelper.INSTANCE.set(this.this$0.getPrefs().getBackend(), PrefKeys.TempIsCelsius, Boxing.boxBoolean(Intrinsics.areEqual((Object) str, (Object) TemperatureUtils.CELSIUS)), Reflection.getOrCreateKotlinClass(Boolean.class));
        }
        MutableLiveData<Boolean> isTempCelsius = this.this$0.isTempCelsius();
        if (str != null && !Intrinsics.areEqual((Object) str, (Object) TemperatureUtils.CELSIUS)) {
            z = false;
        }
        isTempCelsius.setValue(Boxing.boxBoolean(z));
        this.this$0.getSettingsLoading().setValue(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    }
}
