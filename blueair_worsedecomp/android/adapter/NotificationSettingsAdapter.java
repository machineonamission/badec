package com.blueair.android.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.viewholder.NotificationSettingsViewHolder;
import com.blueair.core.model.NotificationSetting;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020#H\u0016R0\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR7\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016RL\u0010\u0017\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006("}, d2 = {"Lcom/blueair/android/adapter/NotificationSettingsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/android/viewholder/NotificationSettingsViewHolder;", "<init>", "()V", "value", "", "Lcom/blueair/core/model/NotificationSetting;", "settings", "getSettings", "()Ljava/util/List;", "setSettings", "(Ljava/util/List;)V", "onShowInfoListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "setting", "", "getOnShowInfoListener", "()Lkotlin/jvm/functions/Function1;", "setOnShowInfoListener", "(Lkotlin/jvm/functions/Function1;)V", "onSettingChangedListener", "Lkotlin/Function2;", "old", "new", "getOnSettingChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnSettingChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "holder", "position", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationSettingsAdapter.kt */
public final class NotificationSettingsAdapter extends RecyclerView.Adapter<NotificationSettingsViewHolder> {
    public static final int $stable = 8;
    private Function2<? super NotificationSetting, ? super NotificationSetting, Unit> onSettingChangedListener;
    private Function1<? super NotificationSetting, Unit> onShowInfoListener;
    private List<NotificationSetting> settings = CollectionsKt.emptyList();

    public final List<NotificationSetting> getSettings() {
        return this.settings;
    }

    public final void setSettings(List<NotificationSetting> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        this.settings = list;
        notifyDataSetChanged();
    }

    public final Function1<NotificationSetting, Unit> getOnShowInfoListener() {
        return this.onShowInfoListener;
    }

    public final void setOnShowInfoListener(Function1<? super NotificationSetting, Unit> function1) {
        this.onShowInfoListener = function1;
    }

    public final Function2<NotificationSetting, NotificationSetting, Unit> getOnSettingChangedListener() {
        return this.onSettingChangedListener;
    }

    public final void setOnSettingChangedListener(Function2<? super NotificationSetting, ? super NotificationSetting, Unit> function2) {
        this.onSettingChangedListener = function2;
    }

    public NotificationSettingsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return NotificationSettingsViewHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.settings.size();
    }

    public void onBindViewHolder(NotificationSettingsViewHolder notificationSettingsViewHolder, int i) {
        Intrinsics.checkNotNullParameter(notificationSettingsViewHolder, "holder");
        NotificationSetting notificationSetting = this.settings.get(i);
        notificationSettingsViewHolder.bind(notificationSetting);
        notificationSettingsViewHolder.getBinding().typeText.setOnClickListener(new NotificationSettingsAdapter$$ExternalSyntheticLambda0(this, notificationSetting));
        notificationSettingsViewHolder.getBinding().typeSwitch.setOnCheckedChangeListener(new NotificationSettingsAdapter$$ExternalSyntheticLambda1(this, notificationSetting));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$0(NotificationSettingsAdapter notificationSettingsAdapter, NotificationSetting notificationSetting, View view) {
        Function1<? super NotificationSetting, Unit> function1 = notificationSettingsAdapter.onShowInfoListener;
        if (function1 != null) {
            function1.invoke(notificationSetting);
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1(NotificationSettingsAdapter notificationSettingsAdapter, NotificationSetting notificationSetting, CompoundButton compoundButton, boolean z) {
        Function2<? super NotificationSetting, ? super NotificationSetting, Unit> function2 = notificationSettingsAdapter.onSettingChangedListener;
        if (function2 != null) {
            NotificationSetting notificationSetting2 = notificationSetting;
            function2.invoke(notificationSetting2, NotificationSetting.copy$default(notificationSetting2, (String) null, z ? 1 : 0, (Integer) null, 5, (Object) null));
        }
    }
}
