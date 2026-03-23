package com.blueair.adddevice.fragment.legacy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.blueair.adddevice.DeviceInformationLegacy;
import com.blueair.adddevice.DeviceUtilsLegacy;
import com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.concurrent.TimeoutException;
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
import kotlinx.coroutines.TimeoutCancellationException;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.adddevice.fragment.legacy.AddDeviceProgressFragment$addDeviceOnBackend$1", f = "AddDeviceProgressFragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AddDeviceProgressFragment.kt */
final class AddDeviceProgressFragment$addDeviceOnBackend$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DeviceInformationLegacy $deviceInfo;
    int label;
    final /* synthetic */ AddDeviceProgressFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddDeviceProgressFragment$addDeviceOnBackend$1(AddDeviceProgressFragment addDeviceProgressFragment, DeviceInformationLegacy deviceInformationLegacy, Continuation<? super AddDeviceProgressFragment$addDeviceOnBackend$1> continuation) {
        super(2, continuation);
        this.this$0 = addDeviceProgressFragment;
        this.$deviceInfo = deviceInformationLegacy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddDeviceProgressFragment$addDeviceOnBackend$1(this.this$0, this.$deviceInfo, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AddDeviceProgressFragment$addDeviceOnBackend$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ApiResult apiResult;
        String str;
        FragmentActivity activity;
        Resources resources;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        Handler handler = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AddDeviceProgressFragment.Companion companion = AddDeviceProgressFragment.Companion;
            AddDeviceProgressFragment.backendAddingDeviceBusy = true;
            this.label = 1;
            obj2 = AddDeviceProgressFragment.retryWithBackoff$default(this.this$0, 0, 0, 0, 0.0d, new AddDeviceProgressFragment$addDeviceOnBackend$1$addDeviceResult$1(this.this$0, this.$deviceInfo, (Continuation<? super AddDeviceProgressFragment$addDeviceOnBackend$1$addDeviceResult$1>) null), this, 15, (Object) null);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
            } catch (TimeoutCancellationException unused) {
                apiResult = ApiResult.Companion.fail(new TimeoutException("more than 2 minutes have passed "));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        apiResult = (ApiResult) obj2;
        if (apiResult.isSuccess()) {
            Timber.Forest.d("addDevice success", new Object[0]);
            this.this$0.getAddService().addOnbackendSuccess();
            Handler access$getHandler$p = this.this$0.handler;
            if (access$getHandler$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("handler");
            } else {
                handler = access$getHandler$p;
            }
            handler.post(this.this$0.otaCheckInitTask);
            AddDeviceProgressFragment.Companion companion2 = AddDeviceProgressFragment.Companion;
            AddDeviceProgressFragment.backendAddingDeviceBusy = false;
        } else {
            Throwable exceptionOrNull = apiResult.exceptionOrNull();
            if (exceptionOrNull == null) {
                return Unit.INSTANCE;
            }
            Timber.Forest.e(exceptionOrNull);
            Context context = this.this$0.getContext();
            if (context == null || (resources = context.getResources()) == null || (str = resources.getString(R.string.add_device_information_failure)) == null) {
                str = "Failed to add device information.";
            }
            if (exceptionOrNull instanceof DeviceUtilsLegacy.AddDeviceBackendException) {
                DeviceUtilsLegacy.AddDeviceBackendException addDeviceBackendException = (DeviceUtilsLegacy.AddDeviceBackendException) exceptionOrNull;
                if (addDeviceBackendException.getUiMessage().length() > 0) {
                    str = addDeviceBackendException.getUiMessage();
                }
            }
            View view = this.this$0.getView();
            if (!(!this.this$0.isAdded() || view == null || (activity = this.this$0.getActivity()) == null)) {
                ViewUtils.INSTANCE.showError((Activity) activity, str);
            }
            this.this$0.getAddService().addOnBackendFail();
            AddDeviceProgressFragment.Companion companion3 = AddDeviceProgressFragment.Companion;
            AddDeviceProgressFragment.backendAddingDeviceBusy = false;
        }
        return Unit.INSTANCE;
    }
}
