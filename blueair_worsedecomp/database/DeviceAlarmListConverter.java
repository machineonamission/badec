package com.blueair.database;

import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.util.MoshiSerializer;
import com.squareup.moshi.Types;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceAlarmListConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAlarmListConverter.kt */
public final class DeviceAlarmListConverter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MoshiSerializer<List<DeviceAlarm>> serializer;

    @JvmStatic
    public static final String fromDeviceAlarmList(List<DeviceAlarm> list) {
        return Companion.fromDeviceAlarmList(list);
    }

    @JvmStatic
    public static final List<DeviceAlarm> fromString(String str) {
        return Companion.fromString(str);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\n2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0007R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/blueair/database/DeviceAlarmListConverter$Companion;", "", "<init>", "()V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "", "Lcom/blueair/core/model/DeviceAlarm;", "fromString", "value", "", "fromDeviceAlarmList", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceAlarmListConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<DeviceAlarm> fromString(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            List<DeviceAlarm> list = StringsKt.trim(str, '[', ']').length() == 0 ? null : (List) DeviceAlarmListConverter.serializer.fromJson(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(6);
            for (int i = 0; i < 6; i++) {
                arrayList.add((Object) null);
            }
            return arrayList;
        }

        @JvmStatic
        public final String fromDeviceAlarmList(List<DeviceAlarm> list) {
            Intrinsics.checkNotNullParameter(list, "value");
            return DeviceAlarmListConverter.serializer.toJson(list);
        }
    }

    static {
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, DeviceAlarm.class);
        Intrinsics.checkNotNullExpressionValue(newParameterizedType, "newParameterizedType(...)");
        serializer = new MoshiSerializer<>(newParameterizedType, new Object[0]);
    }
}
