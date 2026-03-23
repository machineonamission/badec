package com.blueair.android.viewmodel;

import com.blueair.api.utils.ProgressListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"com/blueair/android/viewmodel/DevSettingsViewModel$uploadLog$1$uuid$1", "Lcom/blueair/api/utils/ProgressListener;", "update", "", "bytesWritten", "", "contentLength", "done", "", "onFailure", "t", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevSettingsViewModel.kt */
public final class DevSettingsViewModel$uploadLog$1$uuid$1 implements ProgressListener {
    final /* synthetic */ DevSettingsViewModel this$0;

    DevSettingsViewModel$uploadLog$1$uuid$1(DevSettingsViewModel devSettingsViewModel) {
        this.this$0 = devSettingsViewModel;
    }

    public void update(long j, long j2, boolean z) {
        int i = (int) ((((long) 100) * j) / j2);
        this.this$0._liveLogUploadProgress.postValue(Integer.valueOf(i));
        Timber.Forest forest = Timber.Forest;
        forest.d("UploadLog: " + i + "% done", new Object[0]);
    }

    public void onFailure(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "t");
        this.this$0._liveLogUploadError.postValue(th.getLocalizedMessage());
        Timber.Forest forest = Timber.Forest;
        forest.e(th, "UploadLog failed: " + th.getMessage(), new Object[0]);
    }
}
