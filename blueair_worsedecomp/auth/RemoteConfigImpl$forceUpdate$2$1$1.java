package com.blueair.auth;

import com.blueair.core.util.LinkUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* compiled from: RemoteConfigImpl.kt */
final class RemoteConfigImpl$forceUpdate$2$1$1<TResult> implements OnCompleteListener {
    final /* synthetic */ Continuation<Boolean> $cont;
    final /* synthetic */ FirebaseRemoteConfig $this_with;
    final /* synthetic */ RemoteConfigImpl this$0;

    RemoteConfigImpl$forceUpdate$2$1$1(FirebaseRemoteConfig firebaseRemoteConfig, Continuation<? super Boolean> continuation, RemoteConfigImpl remoteConfigImpl) {
        this.$this_with = firebaseRemoteConfig;
        this.$cont = continuation;
        this.this$0 = remoteConfigImpl;
    }

    public final void onComplete(Task<Void> task) {
        Intrinsics.checkNotNullParameter(task, "fetchTask");
        if (task.isSuccessful()) {
            Task<Boolean> activate = this.$this_with.activate();
            final RemoteConfigImpl remoteConfigImpl = this.this$0;
            final Continuation<Boolean> continuation = this.$cont;
            activate.addOnCompleteListener(new OnCompleteListener() {
                public final void onComplete(Task<Boolean> task) {
                    Intrinsics.checkNotNullParameter(task, "activateTask");
                    if (task.isSuccessful()) {
                        LinkUtils.INSTANCE.init(remoteConfigImpl.getWebLinks());
                        Continuation<Boolean> continuation = continuation;
                        Result.Companion companion = Result.Companion;
                        continuation.resumeWith(Result.m9366constructorimpl(true));
                        return;
                    }
                    Continuation<Boolean> continuation2 = continuation;
                    Result.Companion companion2 = Result.Companion;
                    continuation2.resumeWith(Result.m9366constructorimpl(false));
                }
            });
            return;
        }
        Continuation<Boolean> continuation2 = this.$cont;
        Result.Companion companion = Result.Companion;
        continuation2.resumeWith(Result.m9366constructorimpl(false));
    }
}
