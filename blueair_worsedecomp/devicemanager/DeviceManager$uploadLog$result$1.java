package com.blueair.devicemanager;

import android.content.Context;
import com.blueair.api.restapi.UploadLogRsp;
import com.blueair.api.utils.ProgressListener;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "rsp", "Lcom/blueair/api/restapi/UploadLogRsp;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicemanager.DeviceManager$uploadLog$result$1", f = "DeviceManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DeviceManager.kt */
final class DeviceManager$uploadLog$result$1 extends SuspendLambda implements Function2<UploadLogRsp, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $description;
    final /* synthetic */ LogLength $length;
    final /* synthetic */ ProgressListener $listener;
    final /* synthetic */ IssueType $type;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceManager$uploadLog$result$1(DeviceManager deviceManager, Context context, IssueType issueType, LogLength logLength, String str, ProgressListener progressListener, Continuation<? super DeviceManager$uploadLog$result$1> continuation) {
        super(2, continuation);
        this.this$0 = deviceManager;
        this.$context = context;
        this.$type = issueType;
        this.$length = logLength;
        this.$description = str;
        this.$listener = progressListener;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DeviceManager$uploadLog$result$1 deviceManager$uploadLog$result$1 = new DeviceManager$uploadLog$result$1(this.this$0, this.$context, this.$type, this.$length, this.$description, this.$listener, continuation);
        deviceManager$uploadLog$result$1.L$0 = obj;
        return deviceManager$uploadLog$result$1;
    }

    public final Object invoke(UploadLogRsp uploadLogRsp, Continuation<? super Unit> continuation) {
        return ((DeviceManager$uploadLog$result$1) create(uploadLogRsp, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Throwable th;
        UploadLogRsp uploadLogRsp = (UploadLogRsp) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                File access$createUploadLogFile = this.this$0.createUploadLogFile(this.$context, uploadLogRsp.getLogUuid(), this.$type, this.$length, this.$description);
                Closeable presignUploadFile = this.this$0.getUserBlueClient().presignUploadFile(uploadLogRsp, access$createUploadLogFile, this.$listener);
                ProgressListener progressListener = this.$listener;
                try {
                    Response response = (Response) presignUploadFile;
                    if (!response.isSuccessful()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(response.message());
                        sb.append(": ");
                        ResponseBody body = response.body();
                        sb.append(body != null ? body.string() : null);
                        progressListener.onFailure(new Exception(sb.toString()));
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(presignUploadFile, (Throwable) null);
                    access$createUploadLogFile.delete();
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(presignUploadFile, th);
                    throw th2;
                }
            } catch (Throwable th3) {
                this.$listener.onFailure(th3);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
