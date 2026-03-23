package com.blueair.api.restapi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/restapi/MqttIncludeWrapper;", "", "include", "", "Lcom/blueair/api/restapi/MqttFilterWrapper;", "<init>", "(Ljava/util/List;)V", "getInclude", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UserDevicesBlueRestApi.kt */
public final class MqttIncludeWrapper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<MqttFilterWrapper> include;

    public static /* synthetic */ MqttIncludeWrapper copy$default(MqttIncludeWrapper mqttIncludeWrapper, List<MqttFilterWrapper> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = mqttIncludeWrapper.include;
        }
        return mqttIncludeWrapper.copy(list);
    }

    public final List<MqttFilterWrapper> component1() {
        return this.include;
    }

    public final MqttIncludeWrapper copy(List<MqttFilterWrapper> list) {
        Intrinsics.checkNotNullParameter(list, "include");
        return new MqttIncludeWrapper(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MqttIncludeWrapper) && Intrinsics.areEqual((Object) this.include, (Object) ((MqttIncludeWrapper) obj).include);
    }

    public int hashCode() {
        return this.include.hashCode();
    }

    public String toString() {
        return "MqttIncludeWrapper(include=" + this.include + ')';
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/blueair/api/restapi/MqttIncludeWrapper$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/api/restapi/MqttIncludeWrapper;", "deviceUids", "", "", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UserDevicesBlueRestApi.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MqttIncludeWrapper from(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "deviceUids");
            Iterable<String> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String mqttFilter : iterable) {
                arrayList.add(new MqttFilterWrapper(new MqttFilter(mqttFilter)));
            }
            return new MqttIncludeWrapper((List) arrayList);
        }
    }

    public MqttIncludeWrapper(List<MqttFilterWrapper> list) {
        Intrinsics.checkNotNullParameter(list, "include");
        this.include = list;
    }

    public final List<MqttFilterWrapper> getInclude() {
        return this.include;
    }
}
