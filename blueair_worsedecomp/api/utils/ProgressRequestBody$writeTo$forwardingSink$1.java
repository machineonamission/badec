package com.blueair.api.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"com/blueair/api/utils/ProgressRequestBody$writeTo$forwardingSink$1", "Lokio/ForwardingSink;", "totalBytesWritten", "", "completed", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "close", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UploadProgress.kt */
public final class ProgressRequestBody$writeTo$forwardingSink$1 extends ForwardingSink {
    private boolean completed;
    final /* synthetic */ ProgressRequestBody this$0;
    private long totalBytesWritten;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProgressRequestBody$writeTo$forwardingSink$1(BufferedSink bufferedSink, ProgressRequestBody progressRequestBody) {
        super(bufferedSink);
        this.this$0 = progressRequestBody;
    }

    public void write(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        super.write(buffer, j);
        this.totalBytesWritten += j;
        this.this$0.progressListener.update(this.totalBytesWritten, this.this$0.contentLength(), this.completed);
    }

    public void close() {
        super.close();
        if (!this.completed) {
            this.completed = true;
            this.this$0.progressListener.update(this.totalBytesWritten, this.this$0.contentLength(), this.completed);
        }
    }
}
