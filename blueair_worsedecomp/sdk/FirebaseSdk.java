package com.blueair.sdk;

import com.google.android.gms.tasks.Task;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.FirebaseMessaging;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0002J \u0010\f\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00050\nJ \u0010\r\u001a\u00020\u00052\u0018\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000b\u0012\u0004\u0012\u00020\u00050\n¨\u0006\u000e"}, d2 = {"Lcom/blueair/sdk/FirebaseSdk;", "", "<init>", "()V", "handleTask", "", "task", "Lcom/google/android/gms/tasks/Task;", "", "onComplete", "Lkotlin/Function1;", "Lkotlin/Result;", "getMessagingToken", "getInstallationsId", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: FirebaseSdk.kt */
public final class FirebaseSdk {
    public static final FirebaseSdk INSTANCE = new FirebaseSdk();

    private FirebaseSdk() {
    }

    private final void handleTask(Task<String> task, Function1<? super Result<String>, Unit> function1) {
        if (task.isSuccessful()) {
            Result.Companion companion = Result.Companion;
            function1.invoke(Result.m9365boximpl(Result.m9366constructorimpl(task.getResult())));
            return;
        }
        Result.Companion companion2 = Result.Companion;
        Exception exception = task.getException();
        if (exception == null) {
            exception = new Exception("unknown");
        }
        function1.invoke(Result.m9365boximpl(Result.m9366constructorimpl(ResultKt.createFailure(exception))));
    }

    /* access modifiers changed from: private */
    public static final void getMessagingToken$lambda$0(Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        INSTANCE.handleTask(task, function1);
    }

    public final void getMessagingToken(Function1<? super Result<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new FirebaseSdk$$ExternalSyntheticLambda0(function1));
    }

    /* access modifiers changed from: private */
    public static final void getInstallationsId$lambda$1(Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "it");
        INSTANCE.handleTask(task, function1);
    }

    public final void getInstallationsId(Function1<? super Result<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onComplete");
        FirebaseInstallations.getInstance().getId().addOnCompleteListener(new FirebaseSdk$$ExternalSyntheticLambda1(function1));
    }
}
