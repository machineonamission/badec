package com.blueair.database;

import com.blueair.database.entity.DeviceScheduleInstructionEntity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DeviceScheduleInstructionsConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleInstructionsConverter.kt */
public final class DeviceScheduleInstructionsConverter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final List<DeviceScheduleInstructionEntity> jsonToList(String str) {
        return Companion.jsonToList(str);
    }

    @JvmStatic
    public static final String listToJson(List<DeviceScheduleInstructionEntity> list) {
        return Companion.listToJson(list);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007R\u001d\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/blueair/database/DeviceScheduleInstructionsConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "Lcom/blueair/database/entity/DeviceScheduleInstructionEntity;", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "jsonToList", "value", "", "listToJson", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleInstructionsConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JsonAdapter<List<DeviceScheduleInstructionEntity>> getJsonAdapter() {
            JsonAdapter<List<DeviceScheduleInstructionEntity>> adapter = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter((Type) Types.newParameterizedType(List.class, DeviceScheduleInstructionEntity.class));
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter(...)");
            return adapter;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0018, code lost:
            r2 = kotlin.collections.CollectionsKt.toList(r2);
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.blueair.database.entity.DeviceScheduleInstructionEntity> jsonToList(java.lang.String r2) {
            /*
                r1 = this;
                r0 = r2
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L_0x0027
                int r0 = r0.length()
                if (r0 != 0) goto L_0x000c
                goto L_0x0027
            L_0x000c:
                com.squareup.moshi.JsonAdapter r0 = r1.getJsonAdapter()
                java.lang.Object r2 = r0.fromJson((java.lang.String) r2)
                java.util.List r2 = (java.util.List) r2
                if (r2 == 0) goto L_0x0022
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.List r2 = kotlin.collections.CollectionsKt.toList(r2)
                if (r2 != 0) goto L_0x0021
                goto L_0x0022
            L_0x0021:
                return r2
            L_0x0022:
                java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
                return r2
            L_0x0027:
                java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.DeviceScheduleInstructionsConverter.Companion.jsonToList(java.lang.String):java.util.List");
        }

        @JvmStatic
        public final String listToJson(List<DeviceScheduleInstructionEntity> list) {
            if ((list == null ? CollectionsKt.emptyList() : list).isEmpty()) {
                return "";
            }
            String json = getJsonAdapter().toJson(list);
            Intrinsics.checkNotNull(json);
            return json;
        }
    }
}
