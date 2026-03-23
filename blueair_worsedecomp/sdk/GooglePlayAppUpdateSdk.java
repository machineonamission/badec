package com.blueair.sdk;

import android.app.Activity;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/sdk/GooglePlayAppUpdateSdk;", "", "<init>", "()V", "createAppUpdateManager", "Lcom/blueair/sdk/GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager;", "activity", "Landroid/app/Activity;", "GooglePlayAppUpdateManager", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GooglePlayAppUpdateSdk.kt */
public final class GooglePlayAppUpdateSdk {
    public static final GooglePlayAppUpdateSdk INSTANCE = new GooglePlayAppUpdateSdk();

    private GooglePlayAppUpdateSdk() {
    }

    public final GooglePlayAppUpdateManager createAppUpdateManager(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new GooglePlayAppUpdateManager(activity);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/sdk/GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "appUpdateManager", "Lcom/google/android/play/core/appupdate/AppUpdateManager;", "checkInAppUpdate", "", "requestCode", "", "resumeInAppUpdate", "sdk_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: GooglePlayAppUpdateSdk.kt */
    public static final class GooglePlayAppUpdateManager {
        private final Activity activity;
        private final AppUpdateManager appUpdateManager;

        public GooglePlayAppUpdateManager(Activity activity2) {
            Intrinsics.checkNotNullParameter(activity2, "activity");
            this.activity = activity2;
            AppUpdateManager create = AppUpdateManagerFactory.create(activity2);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            this.appUpdateManager = create;
        }

        /* access modifiers changed from: private */
        public static final void checkInAppUpdate$lambda$1(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        public final void checkInAppUpdate(int i) {
            this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda1(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda0(this, i)));
        }

        /* access modifiers changed from: private */
        public static final Unit checkInAppUpdate$lambda$0(GooglePlayAppUpdateManager googlePlayAppUpdateManager, int i, AppUpdateInfo appUpdateInfo) {
            if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(1)) {
                googlePlayAppUpdateManager.appUpdateManager.startUpdateFlowForResult(appUpdateInfo, 1, googlePlayAppUpdateManager.activity, i);
            }
            return Unit.INSTANCE;
        }

        /* access modifiers changed from: private */
        public static final void resumeInAppUpdate$lambda$3(Function1 function1, Object obj) {
            function1.invoke(obj);
        }

        public final void resumeInAppUpdate(int i) {
            this.appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda3(new GooglePlayAppUpdateSdk$GooglePlayAppUpdateManager$$ExternalSyntheticLambda2(this, i)));
        }

        /* access modifiers changed from: private */
        public static final Unit resumeInAppUpdate$lambda$2(GooglePlayAppUpdateManager googlePlayAppUpdateManager, int i, AppUpdateInfo appUpdateInfo) {
            if (appUpdateInfo.updateAvailability() == 3) {
                googlePlayAppUpdateManager.appUpdateManager.startUpdateFlowForResult(appUpdateInfo, 1, googlePlayAppUpdateManager.activity, i);
            }
            return Unit.INSTANCE;
        }
    }
}
