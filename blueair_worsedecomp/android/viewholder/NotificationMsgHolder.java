package com.blueair.android.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.adapter.NotificationItem;
import com.blueair.android.databinding.CardItemNotificationBinding;
import com.blueair.core.model.AqiHumLevel;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterInfo;
import com.blueair.core.model.FilterLifeLevel;
import com.blueair.core.model.NotificationAqiSubType;
import com.blueair.core.model.NotificationMessage;
import com.blueair.core.model.SimpleEvent;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rJ.\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rH\u0002J.\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u001c\b\u0002\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rH\u0002J,\u0010\u0012\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J(\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u00132\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006&"}, d2 = {"Lcom/blueair/android/viewholder/NotificationMsgHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/android/databinding/CardItemNotificationBinding;", "<init>", "(Lcom/blueair/android/databinding/CardItemNotificationBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/CardItemNotificationBinding;", "hydrate", "", "item", "Lcom/blueair/android/adapter/NotificationItem;", "clickPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/core/model/SimpleEvent;", "", "hydrateAqi", "hydrateFilterLife", "fetchPurchaseLinkAndVideoRes", "Lkotlin/Pair;", "", "Lcom/blueair/core/model/FilterInfo;", "device", "Lcom/blueair/core/model/Device;", "deviceFilterType", "Lcom/blueair/core/model/DeviceFilterType;", "hydrateFilterInfo", "filterType", "filterLifeLevel", "Lcom/blueair/core/model/FilterLifeLevel;", "convertAqiLevelToStatusLabel", "", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "subType", "Lcom/blueair/core/model/NotificationAqiSubType;", "subLevel", "Companion", "StringSet", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: NotificationMsgHolder.kt */
public final class NotificationMsgHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_ADJUST = "event_adjust";
    public static final String EVENT_BUY_FILTER = "event_buy_filter";
    public static final String EVENT_CLOSE = "event_close";
    public static final String EVENT_CONTENT = "event_content";
    public static final String EVENT_REPLACE_FILTER = "event_replace_filter";
    private final CardItemNotificationBinding binding;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationMsgHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|(2:15|16)|17|19|20|21|22|23|24|25|26|27|28|29|31) */
        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|(2:15|16)|17|19|20|21|22|23|24|25|26|27|28|29|31) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0065 */
        static {
            /*
                com.blueair.core.model.NotificationMsgType[] r0 = com.blueair.core.model.NotificationMsgType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.NotificationMsgType r2 = com.blueair.core.model.NotificationMsgType.FILTER_LIFE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.NotificationMsgType r3 = com.blueair.core.model.NotificationMsgType.AQI     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DeviceFilterType r3 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.blueair.core.model.DeviceFilterType r3 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                r3 = 3
                com.blueair.core.model.DeviceFilterType r4 = com.blueair.core.model.DeviceFilterType.REFRESHER     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                $EnumSwitchMapping$1 = r0
                com.blueair.core.model.AqiHumLevel[] r0 = com.blueair.core.model.AqiHumLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.AqiHumLevel r4 = com.blueair.core.model.AqiHumLevel.DRY     // Catch:{ NoSuchFieldError -> 0x004c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.blueair.core.model.AqiHumLevel r1 = com.blueair.core.model.AqiHumLevel.VERY_DRY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.blueair.core.model.AqiHumLevel r1 = com.blueair.core.model.AqiHumLevel.MOSIT     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                com.blueair.core.model.AqiHumLevel r1 = com.blueair.core.model.AqiHumLevel.VERY_MOSIT     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                com.blueair.core.model.AqiHumLevel r1 = com.blueair.core.model.AqiHumLevel.IDEAL     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewholder.NotificationMsgHolder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationMsgHolder(CardItemNotificationBinding cardItemNotificationBinding) {
        super(cardItemNotificationBinding.getRoot());
        Intrinsics.checkNotNullParameter(cardItemNotificationBinding, "binding");
        this.binding = cardItemNotificationBinding;
    }

    public final CardItemNotificationBinding getBinding() {
        return this.binding;
    }

    public static /* synthetic */ void hydrate$default(NotificationMsgHolder notificationMsgHolder, NotificationItem notificationItem, PublishSubject publishSubject, int i, Object obj) {
        if ((i & 2) != 0) {
            publishSubject = null;
        }
        notificationMsgHolder.hydrate(notificationItem, publishSubject);
    }

    public final void hydrate(NotificationItem notificationItem, PublishSubject<SimpleEvent<String, NotificationItem>> publishSubject) {
        if (notificationItem != null) {
            NotificationMessage message = notificationItem.getMessage();
            AppCompatImageView appCompatImageView = this.binding.ivDevice;
            DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(message.getDevice());
            appCompatImageView.setImageResource(deviceImage != null ? deviceImage.getDevice() : 0);
            this.binding.tvDeviceName.setText(message.getDevice().getName());
            this.binding.ivClose.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda3(publishSubject, notificationItem));
            this.binding.getRoot().setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda4(publishSubject, notificationItem));
            MaterialButton materialButton = this.binding.btnBuyFilter;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnBuyFilter");
            ViewExtensionsKt.hide(materialButton);
            MaterialButton materialButton2 = this.binding.btnReplaceFilter;
            Intrinsics.checkNotNullExpressionValue(materialButton2, "btnReplaceFilter");
            ViewExtensionsKt.hide(materialButton2);
            MaterialButton materialButton3 = this.binding.btnAdjust;
            Intrinsics.checkNotNullExpressionValue(materialButton3, "btnAdjust");
            ViewExtensionsKt.hide(materialButton3);
            View view = this.binding.ivIndicator;
            Intrinsics.checkNotNullExpressionValue(view, "ivIndicator");
            ViewExtensionsKt.hide(view);
            int i = WhenMappings.$EnumSwitchMapping$0[message.getType().ordinal()];
            if (i == 1) {
                hydrateFilterLife(notificationItem, publishSubject);
            } else if (i == 2) {
                hydrateAqi(notificationItem, publishSubject);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void hydrate$lambda$2$lambda$0(PublishSubject publishSubject, NotificationItem notificationItem, View view) {
        if (publishSubject != null) {
            publishSubject.onNext(new SimpleEvent(EVENT_CLOSE, notificationItem));
        }
    }

    /* access modifiers changed from: private */
    public static final void hydrate$lambda$2$lambda$1(PublishSubject publishSubject, NotificationItem notificationItem, View view) {
        if (publishSubject != null) {
            publishSubject.onNext(new SimpleEvent(EVENT_CONTENT, notificationItem));
        }
    }

    static /* synthetic */ void hydrateAqi$default(NotificationMsgHolder notificationMsgHolder, NotificationItem notificationItem, PublishSubject publishSubject, int i, Object obj) {
        if ((i & 2) != 0) {
            publishSubject = null;
        }
        notificationMsgHolder.hydrateAqi(notificationItem, publishSubject);
    }

    private final void hydrateAqi(NotificationItem notificationItem, PublishSubject<SimpleEvent<String, NotificationItem>> publishSubject) {
        NotificationMessage message = notificationItem.getMessage();
        Pair<Integer, IndoorAirStatusLabel> convertAqiLevelToStatusLabel = convertAqiLevelToStatusLabel(NotificationAqiSubType.valueOf(message.getSubType()), message.getSubLevel());
        int intValue = convertAqiLevelToStatusLabel.getFirst().intValue();
        IndoorAirStatusLabel second = convertAqiLevelToStatusLabel.getSecond();
        CardItemNotificationBinding cardItemNotificationBinding = this.binding;
        if (intValue == 0) {
            cardItemNotificationBinding.tvMessage.setText("");
        } else {
            cardItemNotificationBinding.tvMessage.setText(intValue);
        }
        if (second == null) {
            cardItemNotificationBinding.tvState.setText("");
        } else {
            cardItemNotificationBinding.tvState.setText(second.getTextResId());
            cardItemNotificationBinding.ivIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(cardItemNotificationBinding.ivIndicator.getContext(), second.getColorRes()));
            View view = cardItemNotificationBinding.ivIndicator;
            Intrinsics.checkNotNullExpressionValue(view, "ivIndicator");
            ViewExtensionsKt.show$default(view, false, 1, (Object) null);
        }
        cardItemNotificationBinding.tvState.setBackground((Drawable) null);
        MaterialButton materialButton = cardItemNotificationBinding.btnAdjust;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnAdjust");
        ViewExtensionsKt.show$default(materialButton, false, 1, (Object) null);
        cardItemNotificationBinding.btnAdjust.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda2(publishSubject, notificationItem));
    }

    /* access modifiers changed from: private */
    public static final void hydrateAqi$lambda$4$lambda$3(PublishSubject publishSubject, NotificationItem notificationItem, View view) {
        if (publishSubject != null) {
            publishSubject.onNext(new SimpleEvent(EVENT_ADJUST, notificationItem));
        }
    }

    static /* synthetic */ void hydrateFilterLife$default(NotificationMsgHolder notificationMsgHolder, NotificationItem notificationItem, PublishSubject publishSubject, int i, Object obj) {
        if ((i & 2) != 0) {
            publishSubject = null;
        }
        notificationMsgHolder.hydrateFilterLife(notificationItem, publishSubject);
    }

    private final void hydrateFilterLife(NotificationItem notificationItem, PublishSubject<SimpleEvent<String, NotificationItem>> publishSubject) {
        this.binding.btnBuyFilter.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda0(publishSubject, notificationItem));
        this.binding.btnReplaceFilter.setOnClickListener(new NotificationMsgHolder$$ExternalSyntheticLambda1(publishSubject, notificationItem));
        NotificationMessage message = notificationItem.getMessage();
        DeviceFilterType valueOf = DeviceFilterType.valueOf(message.getSubType());
        hydrateFilterInfo(this.binding, message.getDevice(), valueOf, FilterLifeLevel.Companion.fromLevel(message.getSubLevel()));
        int i = 0;
        if (notificationItem.getDeviceFilters() == null) {
            Pair<List<FilterInfo>, String> fetchPurchaseLinkAndVideoRes = fetchPurchaseLinkAndVideoRes(message.getDevice(), valueOf);
            notificationItem.setDeviceFilters(fetchPurchaseLinkAndVideoRes.getFirst());
            notificationItem.setHasVideo(fetchPurchaseLinkAndVideoRes.getSecond() != null);
        }
        MaterialButton materialButton = this.binding.btnBuyFilter;
        Intrinsics.checkNotNullExpressionValue(materialButton, "btnBuyFilter");
        materialButton.setVisibility(notificationItem.canBuy() ? 0 : 8);
        MaterialButton materialButton2 = this.binding.btnReplaceFilter;
        Intrinsics.checkNotNullExpressionValue(materialButton2, "btnReplaceFilter");
        View view = materialButton2;
        if (!notificationItem.getHasVideo()) {
            i = 8;
        }
        view.setVisibility(i);
        this.binding.tvState.setBackgroundResource(R.drawable.notification_state_warning_bg);
    }

    /* access modifiers changed from: private */
    public static final void hydrateFilterLife$lambda$5(PublishSubject publishSubject, NotificationItem notificationItem, View view) {
        if (publishSubject != null) {
            publishSubject.onNext(new SimpleEvent(EVENT_BUY_FILTER, notificationItem));
        }
    }

    /* access modifiers changed from: private */
    public static final void hydrateFilterLife$lambda$6(PublishSubject publishSubject, NotificationItem notificationItem, View view) {
        if (publishSubject != null) {
            publishSubject.onNext(new SimpleEvent(EVENT_REPLACE_FILTER, notificationItem));
        }
    }

    private final Pair<List<FilterInfo>, String> fetchPurchaseLinkAndVideoRes(Device device, DeviceFilterType deviceFilterType) {
        List list;
        List<FilterInfo> filters;
        CharSequence ipConfigValue;
        FilterConfig filterConfig = DeviceConfigProvider.INSTANCE.getFilterConfig(device, deviceFilterType);
        if (filterConfig == null || (filters = filterConfig.getFilters()) == null) {
            list = CollectionsKt.emptyList();
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : filters) {
                FilterInfo filterInfo = (FilterInfo) next;
                CharSequence ipConfigValue2 = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkPurchase());
                if (!((ipConfigValue2 == null || ipConfigValue2.length() == 0) && ((ipConfigValue = DeviceConfigProvider.INSTANCE.getIpConfigValue(filterInfo.getLinkSubscribe())) == null || ipConfigValue.length() == 0))) {
                    arrayList.add(next);
                }
            }
            list = (List) arrayList;
        }
        String awsLinkValue = DeviceConfigProvider.INSTANCE.getAwsLinkValue(filterConfig != null ? filterConfig.getVideo() : null);
        if (DeviceKt.useV2UI(device) || !DeviceKt.useNewFilterConfig(device)) {
            awsLinkValue = "";
        }
        return new Pair<>(list, awsLinkValue);
    }

    private final void hydrateFilterInfo(CardItemNotificationBinding cardItemNotificationBinding, Device device, DeviceFilterType deviceFilterType, FilterLifeLevel filterLifeLevel) {
        StringSet stringSet;
        Context context = cardItemNotificationBinding.getRoot().getContext();
        String name = device.getName();
        boolean shouldMergeFilter = DeviceKt.shouldMergeFilter(device);
        int i = WhenMappings.$EnumSwitchMapping$1[deviceFilterType.ordinal()];
        if (i == 1) {
            stringSet = new StringSet(R.string.notification_template_title_filter_usage_prompt, shouldMergeFilter ? R.string.btn_buy : R.string.action_buy_filter, shouldMergeFilter ? R.string.action_replace : R.string.replace_filter, R.string.notification_template_content_filter_usage_warning, R.string.notification_template_content_filter_usage_prompt);
        } else if (i == 2) {
            stringSet = new StringSet(R.string.wick_filter_usage_state, shouldMergeFilter ? R.string.btn_buy : R.string.action_buy_wick_filter, shouldMergeFilter ? R.string.action_replace : R.string.replace_wick_filter, R.string.notification_template_content_wick_usage_warning, R.string.notification_template_content_wick_usage_prompt);
        } else if (i == 3) {
            stringSet = new StringSet(R.string.refresher_usage_state, shouldMergeFilter ? R.string.btn_buy : R.string.action_buy_refresher, shouldMergeFilter ? R.string.action_replace : R.string.replace_water_refresher, R.string.notification_template_content_refresher_usage_warning, R.string.notification_template_content_refresher_usage_prompt);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        int component1 = stringSet.component1();
        int component2 = stringSet.component2();
        int component3 = stringSet.component3();
        int component4 = stringSet.component4();
        int component5 = stringSet.component5();
        cardItemNotificationBinding.tvState.setText(context.getString(component1, new Object[]{Integer.valueOf(filterLifeLevel.getMaxValue())}));
        cardItemNotificationBinding.btnBuyFilter.setText(context.getString(component2));
        cardItemNotificationBinding.btnReplaceFilter.setText(context.getString(component3));
        AppCompatTextView appCompatTextView = cardItemNotificationBinding.tvMessage;
        if (filterLifeLevel != FilterLifeLevel.URGENT) {
            component4 = component5;
        }
        appCompatTextView.setText(context.getString(component4, new Object[]{name}));
    }

    public final Pair<Integer, IndoorAirStatusLabel> convertAqiLevelToStatusLabel(NotificationAqiSubType notificationAqiSubType, int i) {
        IndoorAirStatusLabel indoorAirStatusLabel;
        int i2;
        Intrinsics.checkNotNullParameter(notificationAqiSubType, "subType");
        if (notificationAqiSubType == NotificationAqiSubType.HUM) {
            int i3 = WhenMappings.$EnumSwitchMapping$2[AqiHumLevel.Companion.fromLevel(i).ordinal()];
            if (i3 == 1 || i3 == 2) {
                i2 = R.string.notification_content_dry_air;
                indoorAirStatusLabel = IndoorAirStatusLabel.Dry.INSTANCE;
                return new Pair<>(Integer.valueOf(i2), indoorAirStatusLabel);
            } else if (i3 == 3 || i3 == 4) {
                i2 = R.string.notification_content_moist_air;
                indoorAirStatusLabel = IndoorAirStatusLabel.Moist.INSTANCE;
                return new Pair<>(Integer.valueOf(i2), indoorAirStatusLabel);
            } else if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
        }
        i2 = 0;
        indoorAirStatusLabel = null;
        return new Pair<>(Integer.valueOf(i2), indoorAirStatusLabel);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/android/viewholder/NotificationMsgHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/viewholder/NotificationMsgHolder;", "parent", "Landroid/view/ViewGroup;", "EVENT_BUY_FILTER", "", "EVENT_REPLACE_FILTER", "EVENT_CLOSE", "EVENT_CONTENT", "EVENT_ADJUST", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationMsgHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NotificationMsgHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            CardItemNotificationBinding inflate = CardItemNotificationBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new NotificationMsgHolder(inflate);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/android/viewholder/NotificationMsgHolder$StringSet;", "", "state", "", "buy", "replace", "urgentMsg", "normalMsg", "<init>", "(IIIII)V", "getState", "()I", "getBuy", "getReplace", "getUrgentMsg", "getNormalMsg", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: NotificationMsgHolder.kt */
    private static final class StringSet {
        private final int buy;
        private final int normalMsg;
        private final int replace;
        private final int state;
        private final int urgentMsg;

        public static /* synthetic */ StringSet copy$default(StringSet stringSet, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = stringSet.state;
            }
            if ((i6 & 2) != 0) {
                i2 = stringSet.buy;
            }
            if ((i6 & 4) != 0) {
                i3 = stringSet.replace;
            }
            if ((i6 & 8) != 0) {
                i4 = stringSet.urgentMsg;
            }
            if ((i6 & 16) != 0) {
                i5 = stringSet.normalMsg;
            }
            int i7 = i4;
            int i8 = i5;
            return stringSet.copy(i, i2, i3, i7, i8);
        }

        public final int component1() {
            return this.state;
        }

        public final int component2() {
            return this.buy;
        }

        public final int component3() {
            return this.replace;
        }

        public final int component4() {
            return this.urgentMsg;
        }

        public final int component5() {
            return this.normalMsg;
        }

        public final StringSet copy(int i, int i2, int i3, int i4, int i5) {
            return new StringSet(i, i2, i3, i4, i5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StringSet)) {
                return false;
            }
            StringSet stringSet = (StringSet) obj;
            return this.state == stringSet.state && this.buy == stringSet.buy && this.replace == stringSet.replace && this.urgentMsg == stringSet.urgentMsg && this.normalMsg == stringSet.normalMsg;
        }

        public int hashCode() {
            return (((((((this.state * 31) + this.buy) * 31) + this.replace) * 31) + this.urgentMsg) * 31) + this.normalMsg;
        }

        public String toString() {
            return "StringSet(state=" + this.state + ", buy=" + this.buy + ", replace=" + this.replace + ", urgentMsg=" + this.urgentMsg + ", normalMsg=" + this.normalMsg + ')';
        }

        public StringSet(int i, int i2, int i3, int i4, int i5) {
            this.state = i;
            this.buy = i2;
            this.replace = i3;
            this.urgentMsg = i4;
            this.normalMsg = i5;
        }

        public final int getState() {
            return this.state;
        }

        public final int getBuy() {
            return this.buy;
        }

        public final int getReplace() {
            return this.replace;
        }

        public final int getUrgentMsg() {
            return this.urgentMsg;
        }

        public final int getNormalMsg() {
            return this.normalMsg;
        }
    }
}
