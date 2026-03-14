package com.blueair.api.utils;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

@Metadata(
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"},
   d2 = {"Lcom/blueair/api/utils/ProgressRequestBody;", "Lokhttp3/RequestBody;", "delegate", "progressListener", "Lcom/blueair/api/utils/ProgressListener;", "<init>", "(Lokhttp3/RequestBody;Lcom/blueair/api/utils/ProgressListener;)V", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "writeTo", "", "sink", "Lokio/BufferedSink;", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ProgressRequestBody extends RequestBody {
   private final RequestBody delegate;
   private final ProgressListener progressListener;

   public ProgressRequestBody(RequestBody var1, ProgressListener var2) {
      Intrinsics.checkNotNullParameter(var1, "delegate");
      Intrinsics.checkNotNullParameter(var2, "progressListener");
      super();
      this.delegate = var1;
      this.progressListener = var2;
   }

   public long contentLength() throws IOException {
      return this.delegate.contentLength();
   }

   public MediaType contentType() {
      return this.delegate.contentType();
   }

   public void writeTo(BufferedSink var1) throws IOException {
      Intrinsics.checkNotNullParameter(var1, "sink");
      var1 = Okio.buffer((Sink)(new ForwardingSink(var1, this) {
         private boolean completed;
         final ProgressRequestBody this$0;
         private long totalBytesWritten;

         {
            this.this$0 = var2;
         }

         public void close() {
            super.close();
            if (!this.completed) {
               this.completed = true;
               this.this$0.progressListener.update(this.totalBytesWritten, this.this$0.contentLength(), this.completed);
            }

         }

         public void write(Buffer var1, long var2) {
            Intrinsics.checkNotNullParameter(var1, "source");
            super.write(var1, var2);
            this.totalBytesWritten += var2;
            this.this$0.progressListener.update(this.totalBytesWritten, this.this$0.contentLength(), this.completed);
         }
      }));
      this.delegate.writeTo(var1);
      var1.flush();
   }
}
