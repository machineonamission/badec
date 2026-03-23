package com.blueair.android.activity;

import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.R;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.adapter.NotificationMsgAdapter;
import com.blueair.android.databinding.ActivityNotificationsBinding;
import com.blueair.android.viewholder.NotificationMsgHolder;
import com.blueair.android.viewmodel.NotificationsViewModel;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Device;
import com.blueair.core.model.SimpleEvent;
import com.blueair.devicedetails.dialog.DeviceDetailsV2DialogFragment;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.utils.SimpleSpacingDecoration;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0014J\b\u0010 \u001a\u00020\u001bH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R-\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\f0\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017¨\u0006!"}, d2 = {"Lcom/blueair/android/activity/NotificationsActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityNotificationsBinding;", "clickNotificationPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "Lcom/blueair/android/adapter/NotificationItem;", "getClickNotificationPublisher", "()Lio/reactivex/subjects/PublishSubject;", "clickNotificationPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "notificationMsgAdapter", "Lcom/blueair/android/adapter/NotificationMsgAdapter;", "notificationsViewModel", "Lcom/blueair/android/viewmodel/NotificationsViewModel;", "getNotificationsViewModel", "()Lcom/blueair/android/viewmodel/NotificationsViewModel;", "notificationsViewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "observeViewModel", "onResume", "bindViewModel", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationsActivity.kt */
public final class NotificationsActivity extends BaseActivity {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(NotificationsActivity.class, "clickNotificationPublisher", "getClickNotificationPublisher()Lio/reactivex/subjects/PublishSubject;", 0))};
    public static final int $stable = 8;
    private ActivityNotificationsBinding binding;
    private final LazyPublishSubject clickNotificationPublisher$delegate = new LazyPublishSubject();
    private NotificationMsgAdapter notificationMsgAdapter;
    private final Lazy notificationsViewModel$delegate;
    private final String screenName = AnalyticEvent.ScreenViewEvent.NOTIFICATIONS;

    public NotificationsActivity() {
        ComponentActivity componentActivity = this;
        this.notificationsViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(NotificationsViewModel.class), new NotificationsActivity$special$$inlined$viewModels$default$2(componentActivity), new NotificationsActivity$special$$inlined$viewModels$default$1(componentActivity), new NotificationsActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    private final PublishSubject<SimpleEvent<String, NotificationItem>> getClickNotificationPublisher() {
        return this.clickNotificationPublisher$delegate.getValue((Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    private final NotificationsViewModel getNotificationsViewModel() {
        return (NotificationsViewModel) this.notificationsViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bindViewModel();
        ActivityNotificationsBinding activityNotificationsBinding = null;
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        setStatusMode(true);
        this.notificationMsgAdapter = new NotificationMsgAdapter(getNotificationsViewModel().getLocationService(), getClickNotificationPublisher());
        ActivityNotificationsBinding activityNotificationsBinding2 = this.binding;
        if (activityNotificationsBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationsBinding2 = null;
        }
        RecyclerView recyclerView = activityNotificationsBinding2.rvList;
        NotificationMsgAdapter notificationMsgAdapter2 = this.notificationMsgAdapter;
        if (notificationMsgAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
            notificationMsgAdapter2 = null;
        }
        recyclerView.setAdapter(notificationMsgAdapter2);
        ActivityNotificationsBinding activityNotificationsBinding3 = this.binding;
        if (activityNotificationsBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationsBinding3 = null;
        }
        activityNotificationsBinding3.btnBack.setOnClickListener(new NotificationsActivity$$ExternalSyntheticLambda0(this));
        ActivityNotificationsBinding activityNotificationsBinding4 = this.binding;
        if (activityNotificationsBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationsBinding4 = null;
        }
        activityNotificationsBinding4.tvDismissAll.setOnClickListener(new NotificationsActivity$$ExternalSyntheticLambda1(this));
        float dpToPx = TypedValueCompat.dpToPx(8.0f, getResources().getDisplayMetrics());
        ActivityNotificationsBinding activityNotificationsBinding5 = this.binding;
        if (activityNotificationsBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityNotificationsBinding = activityNotificationsBinding5;
        }
        activityNotificationsBinding.rvList.addItemDecoration(new SimpleSpacingDecoration(0, (int) dpToPx, false, 4, (DefaultConstructorMarker) null));
        observeViewModel();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(NotificationsActivity notificationsActivity, View view) {
        notificationsActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(NotificationsActivity notificationsActivity, View view) {
        NotificationMsgAdapter notificationMsgAdapter2 = notificationsActivity.notificationMsgAdapter;
        if (notificationMsgAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
            notificationMsgAdapter2 = null;
        }
        notificationMsgAdapter2.setNewList(CollectionsKt.emptyList());
        notificationsActivity.getNotificationsViewModel().dismissAll();
    }

    private final void observeViewModel() {
        getNotificationsViewModel().getLvNotificationMsgs().observe(this, new NotificationsActivity$sam$androidx_lifecycle_Observer$0(new NotificationsActivity$$ExternalSyntheticLambda3(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit observeViewModel$lambda$2(NotificationsActivity notificationsActivity, List list) {
        NotificationMsgAdapter notificationMsgAdapter2 = notificationsActivity.notificationMsgAdapter;
        if (notificationMsgAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
            notificationMsgAdapter2 = null;
        }
        Intrinsics.checkNotNull(list);
        notificationMsgAdapter2.setNewList(list);
        notificationsActivity.getNotificationsViewModel().getNotificationsNum().setValue(Integer.valueOf(list.size()));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getRxSubs().add(RxExtensionsKt.subscribeAndLogE(getClickNotificationPublisher(), new NotificationsActivity$$ExternalSyntheticLambda2(this)));
    }

    /* access modifiers changed from: private */
    public static final Unit onResume$lambda$4(NotificationsActivity notificationsActivity, SimpleEvent simpleEvent) {
        NotificationItem notificationItem = (NotificationItem) simpleEvent.getData();
        String str = (String) simpleEvent.getEventType();
        switch (str.hashCode()) {
            case 146184104:
                if (str.equals(NotificationMsgHolder.EVENT_REPLACE_FILTER)) {
                    notificationsActivity.getNotificationsViewModel().executeReplaceFilterEvent(notificationItem, notificationsActivity);
                    break;
                }
                break;
            case 434821139:
                if (str.equals(NotificationMsgHolder.EVENT_CLOSE)) {
                    NotificationMsgAdapter notificationMsgAdapter2 = notificationsActivity.notificationMsgAdapter;
                    if (notificationMsgAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationMsgAdapter");
                        notificationMsgAdapter2 = null;
                    }
                    notificationMsgAdapter2.remove(notificationItem);
                    NotificationsViewModel.dismissMsg$default(notificationsActivity.getNotificationsViewModel(), notificationItem, false, 2, (Object) null);
                    break;
                }
                break;
            case 529760468:
                if (str.equals(NotificationMsgHolder.EVENT_ADJUST)) {
                    NotificationsViewModel.dismissMsg$default(notificationsActivity.getNotificationsViewModel(), notificationItem, false, 2, (Object) null);
                    Device device = notificationItem.getMessage().getDevice();
                    FragmentManager supportFragmentManager = notificationsActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    String uid = device.getUid();
                    if (!(supportFragmentManager.findFragmentByTag(uid) instanceof DeviceDetailsV2DialogFragment) && !supportFragmentManager.isStateSaved()) {
                        DeviceDetailsV2DialogFragment.Companion.newInstance(device, "device_details").show(supportFragmentManager, uid);
                        break;
                    }
                }
                break;
            case 1982146070:
                if (str.equals(NotificationMsgHolder.EVENT_BUY_FILTER)) {
                    notificationsActivity.getNotificationsViewModel().executeBuyFilterEvent(notificationItem, notificationsActivity);
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }

    private final void bindViewModel() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_notifications);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        ActivityNotificationsBinding activityNotificationsBinding = (ActivityNotificationsBinding) contentView;
        this.binding = activityNotificationsBinding;
        if (activityNotificationsBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityNotificationsBinding = null;
        }
        activityNotificationsBinding.setViewModel(getNotificationsViewModel());
        activityNotificationsBinding.setLifecycleOwner(this);
    }
}
