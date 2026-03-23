package com.blueair.android.dialog;

import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import io.flatcircle.coroutinehelper.ApiResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.dialog.NotificationCenterViewModel$fetchNotificationSettings$1", f = "NotificationCenterViewModel.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NotificationCenterViewModel.kt */
final class NotificationCenterViewModel$fetchNotificationSettings$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ NotificationCenterViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationCenterViewModel$fetchNotificationSettings$1(NotificationCenterViewModel notificationCenterViewModel, Continuation<? super NotificationCenterViewModel$fetchNotificationSettings$1> continuation) {
        super(1, continuation);
        this.this$0 = notificationCenterViewModel;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new NotificationCenterViewModel$fetchNotificationSettings$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((NotificationCenterViewModel$fetchNotificationSettings$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getDeviceManager().getNotificationSettings(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult.isSuccess()) {
            this.this$0._fetchFailed.postValue(Boxing.boxBoolean(false));
            List list2 = (List) apiResult.getOrNull();
            if (list2 == null || (list = CollectionsKt.toMutableList(list2)) == null) {
                list = new ArrayList();
            }
            List arrayList = new ArrayList();
            NotificationCenterViewModel notificationCenterViewModel = this.this$0;
            for (NotificationType notificationType : NotificationType.getEntries()) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual((Object) ((NotificationSetting) obj2).getType(), (Object) notificationType.getValue())) {
                        break;
                    }
                }
                NotificationSetting notificationSetting = (NotificationSetting) obj2;
                if (notificationSetting == null) {
                    notificationSetting = new NotificationSetting(notificationType.getValue(), 1, (Integer) null, 4, (DefaultConstructorMarker) null);
                }
                String type = notificationSetting.getType();
                if (Intrinsics.areEqual((Object) type, (Object) NotificationType.ALL.getValue())) {
                    notificationCenterViewModel._notificationAllSettings.postValue(notificationSetting);
                } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.LEGACY_PRODUCT_ALERT.getValue())) {
                    notificationCenterViewModel._notificationProductAlertSettings.postValue(notificationSetting);
                } else {
                    Boxing.boxBoolean(arrayList.add(notificationSetting));
                }
            }
            this.this$0._notificationSettings.postValue(arrayList);
        } else {
            this.this$0._fetchFailed.postValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }
}
