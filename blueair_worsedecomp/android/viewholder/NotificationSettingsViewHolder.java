package com.blueair.android.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.HolderNotificationSettingsBinding;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.NotificationSetting;
import com.blueair.core.model.NotificationType;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/blueair/android/viewholder/NotificationSettingsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/android/databinding/HolderNotificationSettingsBinding;", "<init>", "(Lcom/blueair/android/databinding/HolderNotificationSettingsBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/HolderNotificationSettingsBinding;", "bind", "", "setting", "Lcom/blueair/core/model/NotificationSetting;", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationSettingsViewHolder.kt */
public final class NotificationSettingsViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderNotificationSettingsBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/viewholder/NotificationSettingsViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/viewholder/NotificationSettingsViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationSettingsViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationSettingsViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            HolderNotificationSettingsBinding inflate = HolderNotificationSettingsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new NotificationSettingsViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationSettingsViewHolder(HolderNotificationSettingsBinding holderNotificationSettingsBinding) {
        super(holderNotificationSettingsBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderNotificationSettingsBinding, "binding");
        this.binding = holderNotificationSettingsBinding;
    }

    public final HolderNotificationSettingsBinding getBinding() {
        return this.binding;
    }

    public final void bind(NotificationSetting notificationSetting) {
        int i;
        Intrinsics.checkNotNullParameter(notificationSetting, AnalyticEvent.KEY_SETTING);
        String type = notificationSetting.getType();
        if (Intrinsics.areEqual((Object) type, (Object) NotificationType.FILTER_REPLACEMENT.getValue())) {
            i = R.string.notification_type_filter_replacement;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.QUICK_ALARM_STOP.getValue())) {
            i = R.string.notification_type_quick_alarm_stop;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.FILTER_CLEANING.getValue())) {
            i = R.string.notification_type_filter_cleaning;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.WATER_LEVEL.getValue())) {
            i = R.string.notification_type_water_shortage;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.MARKETING.getValue())) {
            i = R.string.notification_type_marketing;
        } else if (Intrinsics.areEqual((Object) type, (Object) NotificationType.TRANSACTIONAL.getValue())) {
            i = R.string.notification_type_transactional;
        } else {
            return;
        }
        this.binding.typeText.setText(i);
        this.binding.typeSwitch.setCheckedSilence(notificationSetting.isEnabled());
        this.binding.typeSwitch.setContentDescription(this.binding.typeSwitch.getContext().getString(i));
    }
}
