package com.blueair.devicedetails.util;

import com.blueair.core.model.Device;
import com.blueair.push.NotificationService;
import com.blueair.viewcore.activity.Actions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0006\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "FilterType", "FilterReset", "FilterStatus", "FilterPurchase", "FilterImportanceVideo", "FilterTutorialVideo", "Companion", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterImportanceVideo;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterPurchase;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterReset;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterStatus;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterTutorialVideo;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterType;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterPageWidget.kt */
public abstract class DeviceFilterPageWidget {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<DeviceFilterPageWidget> WIDGETS = CollectionsKt.listOf(FilterType.INSTANCE, FilterReset.INSTANCE, FilterStatus.INSTANCE, FilterPurchase.INSTANCE, FilterImportanceVideo.INSTANCE, FilterTutorialVideo.INSTANCE);
    /* access modifiers changed from: private */
    public static final Lazy<Map<DeviceFilterPageWidget, Integer>> widgetsToViewType$delegate = LazyKt.lazy(new DeviceFilterPageWidget$$ExternalSyntheticLambda0());
    private final String name;

    public /* synthetic */ DeviceFilterPageWidget(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterType;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class FilterType extends DeviceFilterPageWidget {
        public static final FilterType INSTANCE = new FilterType();

        private FilterType() {
            super(Actions.EXTRA_FILTER_TYPE, (DefaultConstructorMarker) null);
        }
    }

    private DeviceFilterPageWidget(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterReset;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class FilterReset extends DeviceFilterPageWidget {
        public static final FilterReset INSTANCE = new FilterReset();

        private FilterReset() {
            super("filter_reset", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterStatus;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class FilterStatus extends DeviceFilterPageWidget {
        public static final FilterStatus INSTANCE = new FilterStatus();

        private FilterStatus() {
            super(NotificationService.ACTION_TYPE_FILTER_STATUS, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterPurchase;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class FilterPurchase extends DeviceFilterPageWidget {
        public static final FilterPurchase INSTANCE = new FilterPurchase();

        private FilterPurchase() {
            super(NotificationService.ACTION_TYPE_FILTER_PURCHASE, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterImportanceVideo;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class FilterImportanceVideo extends DeviceFilterPageWidget {
        public static final FilterImportanceVideo INSTANCE = new FilterImportanceVideo();

        private FilterImportanceVideo() {
            super("filter_importance_video", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$FilterTutorialVideo;", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "<init>", "()V", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class FilterTutorialVideo extends DeviceFilterPageWidget {
        public static final FilterTutorialVideo INSTANCE = new FilterTutorialVideo();

        private FilterTutorialVideo() {
            super("filter_tutorial_video", (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR'\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000b0\n8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/util/DeviceFilterPageWidget$Companion;", "", "<init>", "()V", "WIDGETS", "", "Lcom/blueair/devicedetails/util/DeviceFilterPageWidget;", "getWIDGETS", "()Ljava/util/List;", "widgetsToViewType", "", "", "getWidgetsToViewType", "()Ljava/util/Map;", "widgetsToViewType$delegate", "Lkotlin/Lazy;", "getSupportedWidgets", "device", "Lcom/blueair/core/model/Device;", "filterPurchase", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterPageWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<DeviceFilterPageWidget> getWIDGETS() {
            return DeviceFilterPageWidget.WIDGETS;
        }

        public final Map<DeviceFilterPageWidget, Integer> getWidgetsToViewType() {
            return (Map) DeviceFilterPageWidget.widgetsToViewType$delegate.getValue();
        }

        public final List<DeviceFilterPageWidget> getSupportedWidgets(Device device, boolean z) {
            boolean z2;
            Collection arrayList = new ArrayList();
            for (Object next : getWIDGETS()) {
                DeviceFilterPageWidget deviceFilterPageWidget = (DeviceFilterPageWidget) next;
                if (device != null) {
                    z2 = DeviceFilterPageWidgetKt.supportFilterWidget(device, deviceFilterPageWidget, z);
                } else {
                    z2 = false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        }
    }

    /* access modifiers changed from: private */
    public static final Map widgetsToViewType_delegate$lambda$1() {
        Iterable iterable = WIDGETS;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        int i = 0;
        for (Object next : iterable) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to((DeviceFilterPageWidget) next, Integer.valueOf(i)));
            i = i2;
        }
        return MapsKt.toMap((List) arrayList);
    }
}
