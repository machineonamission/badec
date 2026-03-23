package com.blueair.android.dialog;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.NotificationSetting;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001eH\u0002¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u001cJ\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u0011H\u0002J\u0016\u0010%\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\fR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00180\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\f¨\u0006("}, d2 = {"Lcom/blueair/android/dialog/NotificationCenterViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "_requesting", "Landroidx/lifecycle/MutableLiveData;", "", "requesting", "Landroidx/lifecycle/LiveData;", "getRequesting", "()Landroidx/lifecycle/LiveData;", "_fetchFailed", "fetchFailed", "getFetchFailed", "_notificationAllSettings", "Lcom/blueair/core/model/NotificationSetting;", "notificationAllSettings", "getNotificationAllSettings", "_notificationProductAlertSettings", "notificationProductAlertSettings", "getNotificationProductAlertSettings", "_notificationSettings", "", "notificationSettings", "getNotificationSettings", "launchRequest", "", "action", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "fetchNotificationSettings", "postNotificationSetting", "setting", "updateNotificationSetting", "oldSetting", "newSetting", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationCenterViewModel.kt */
public final class NotificationCenterViewModel extends BaseViewModel {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _fetchFailed;
    /* access modifiers changed from: private */
    public final MutableLiveData<NotificationSetting> _notificationAllSettings;
    /* access modifiers changed from: private */
    public final MutableLiveData<NotificationSetting> _notificationProductAlertSettings;
    /* access modifiers changed from: private */
    public final MutableLiveData<List<NotificationSetting>> _notificationSettings;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _requesting;
    private final LiveData<Boolean> fetchFailed;
    private final LiveData<NotificationSetting> notificationAllSettings;
    private final LiveData<NotificationSetting> notificationProductAlertSettings;
    private final LiveData<List<NotificationSetting>> notificationSettings;
    private final LiveData<Boolean> requesting;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationCenterViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(false);
        this._requesting = mutableLiveData;
        this.requesting = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(false);
        this._fetchFailed = mutableLiveData2;
        this.fetchFailed = mutableLiveData2;
        MutableLiveData<NotificationSetting> mutableLiveData3 = new MutableLiveData<>();
        this._notificationAllSettings = mutableLiveData3;
        this.notificationAllSettings = mutableLiveData3;
        MutableLiveData<NotificationSetting> mutableLiveData4 = new MutableLiveData<>();
        this._notificationProductAlertSettings = mutableLiveData4;
        this.notificationProductAlertSettings = mutableLiveData4;
        MutableLiveData<List<NotificationSetting>> mutableLiveData5 = new MutableLiveData<>();
        this._notificationSettings = mutableLiveData5;
        this.notificationSettings = mutableLiveData5;
        fetchNotificationSettings();
    }

    public final LiveData<Boolean> getRequesting() {
        return this.requesting;
    }

    public final LiveData<Boolean> getFetchFailed() {
        return this.fetchFailed;
    }

    public final LiveData<NotificationSetting> getNotificationAllSettings() {
        return this.notificationAllSettings;
    }

    public final LiveData<NotificationSetting> getNotificationProductAlertSettings() {
        return this.notificationProductAlertSettings;
    }

    public final LiveData<List<NotificationSetting>> getNotificationSettings() {
        return this.notificationSettings;
    }

    private final void launchRequest(Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        if (!Intrinsics.areEqual((Object) this.requesting.getValue(), (Object) true)) {
            this._requesting.setValue(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new NotificationCenterViewModel$launchRequest$1(function1, this, (Continuation<? super NotificationCenterViewModel$launchRequest$1>) null), 3, (Object) null);
        }
    }

    public final void fetchNotificationSettings() {
        launchRequest(new NotificationCenterViewModel$fetchNotificationSettings$1(this, (Continuation<? super NotificationCenterViewModel$fetchNotificationSettings$1>) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void postNotificationSetting(com.blueair.core.model.NotificationSetting r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getType()
            com.blueair.core.model.NotificationType r1 = com.blueair.core.model.NotificationType.ALL
            java.lang.String r1 = r1.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x0016
            androidx.lifecycle.MutableLiveData<com.blueair.core.model.NotificationSetting> r0 = r9._notificationAllSettings
            r0.postValue(r10)
            return
        L_0x0016:
            com.blueair.core.model.NotificationType r1 = com.blueair.core.model.NotificationType.LEGACY_PRODUCT_ALERT
            java.lang.String r1 = r1.getValue()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x0028
            androidx.lifecycle.MutableLiveData<com.blueair.core.model.NotificationSetting> r0 = r9._notificationProductAlertSettings
            r0.postValue(r10)
            return
        L_0x0028:
            androidx.lifecycle.MutableLiveData<java.util.List<com.blueair.core.model.NotificationSetting>> r0 = r9._notificationSettings
            java.lang.Object r0 = r0.getValue()
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto L_0x0069
            kotlin.enums.EnumEntries r0 = com.blueair.core.model.NotificationType.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0049:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0066
            java.lang.Object r2 = r0.next()
            com.blueair.core.model.NotificationType r2 = (com.blueair.core.model.NotificationType) r2
            com.blueair.core.model.NotificationSetting r3 = new com.blueair.core.model.NotificationSetting
            java.lang.String r4 = r2.getValue()
            r7 = 4
            r8 = 0
            r5 = 1
            r6 = 0
            r3.<init>(r4, r5, r6, r7, r8)
            r1.add(r3)
            goto L_0x0049
        L_0x0066:
            r0 = r1
            java.util.List r0 = (java.util.List) r0
        L_0x0069:
            java.util.Iterator r1 = r0.iterator()
            r2 = 0
        L_0x006e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x008c
            java.lang.Object r3 = r1.next()
            com.blueair.core.model.NotificationSetting r3 = (com.blueair.core.model.NotificationSetting) r3
            java.lang.String r3 = r3.getType()
            java.lang.String r4 = r10.getType()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0089
            goto L_0x008d
        L_0x0089:
            int r2 = r2 + 1
            goto L_0x006e
        L_0x008c:
            r2 = -1
        L_0x008d:
            if (r2 < 0) goto L_0x009d
            androidx.lifecycle.MutableLiveData<java.util.List<com.blueair.core.model.NotificationSetting>> r1 = r9._notificationSettings
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toMutableList(r0)
            r0.set(r2, r10)
            r1.postValue(r0)
        L_0x009d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.dialog.NotificationCenterViewModel.postNotificationSetting(com.blueair.core.model.NotificationSetting):void");
    }

    public final void updateNotificationSetting(NotificationSetting notificationSetting, NotificationSetting notificationSetting2) {
        Intrinsics.checkNotNullParameter(notificationSetting, "oldSetting");
        Intrinsics.checkNotNullParameter(notificationSetting2, "newSetting");
        launchRequest(new NotificationCenterViewModel$updateNotificationSetting$1(this, notificationSetting2, notificationSetting, (Continuation<? super NotificationCenterViewModel$updateNotificationSetting$1>) null));
    }
}
