package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/UserManualViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "downloadFile", "Lio/flatcircle/coroutinehelper/ApiResult;", "Ljava/io/InputStream;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserManualViewModel.kt */
public final class UserManualViewModel extends BaseViewModel {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserManualViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final Object downloadFile(String str, Continuation<? super ApiResult<InputStream>> continuation) {
        return getDeviceManager().downloadFile(str, continuation);
    }
}
