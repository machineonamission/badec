package com.blueair.api.client;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000bH\u0016¨\u0006\f"}, d2 = {"com/blueair/api/client/DownloadNetworkClient$downloadFromUrl$1", "Lokhttp3/Callback;", "onResponse", "", "call", "Lokhttp3/Call;", "response", "Lokhttp3/Response;", "onFailure", "e", "Ljava/io/IOException;", "Lokio/IOException;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DownloadNetworkClient.kt */
public final class DownloadNetworkClient$downloadFromUrl$1 implements Callback {
    final /* synthetic */ Function1<InputStream, Unit> $callback;

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, "e");
    }

    DownloadNetworkClient$downloadFromUrl$1(Function1<? super InputStream, Unit> function1) {
        this.$callback = function1;
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        ResponseBody body = response.body();
        this.$callback.invoke(body != null ? body.byteStream() : null);
    }
}
