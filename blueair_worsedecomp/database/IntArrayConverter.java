package com.blueair.database;

import com.blueair.core.util.MoshiSerializer;
import com.squareup.moshi.Types;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/IntArrayConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IntArrayConverter.kt */
public final class IntArrayConverter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MoshiSerializer<List<Integer>> serializer;

    @JvmStatic
    public static final String fromIntArray(int[] iArr) {
        return Companion.fromIntArray(iArr);
    }

    @JvmStatic
    public static final int[] fromString(String str) {
        return Companion.fromString(str);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/blueair/database/IntArrayConverter$Companion;", "", "<init>", "()V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "", "", "fromString", "", "value", "", "fromIntArray", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IntArrayConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            r3 = kotlin.collections.CollectionsKt.toIntArray(r3);
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int[] fromString(java.lang.String r3) {
            /*
                r2 = this;
                r0 = r3
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1 = 0
                if (r0 == 0) goto L_0x0026
                int r0 = r0.length()
                if (r0 != 0) goto L_0x000d
                goto L_0x0026
            L_0x000d:
                com.blueair.core.util.MoshiSerializer r0 = com.blueair.database.IntArrayConverter.serializer
                java.lang.Object r3 = r0.fromJson(r3)
                java.util.List r3 = (java.util.List) r3
                if (r3 == 0) goto L_0x0023
                java.util.Collection r3 = (java.util.Collection) r3
                int[] r3 = kotlin.collections.CollectionsKt.toIntArray(r3)
                if (r3 != 0) goto L_0x0022
                goto L_0x0023
            L_0x0022:
                return r3
            L_0x0023:
                int[] r3 = new int[r1]
                return r3
            L_0x0026:
                int[] r3 = new int[r1]
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.IntArrayConverter.Companion.fromString(java.lang.String):int[]");
        }

        @JvmStatic
        public final String fromIntArray(int[] iArr) {
            List<Integer> list;
            if (iArr == null || (list = ArraysKt.toList(iArr)) == null) {
                list = CollectionsKt.emptyList();
            }
            if (list.isEmpty()) {
                return "";
            }
            return IntArrayConverter.serializer.toJson(list);
        }
    }

    static {
        ParameterizedType newParameterizedType = Types.newParameterizedType(List.class, Integer.class);
        Intrinsics.checkNotNullExpressionValue(newParameterizedType, "newParameterizedType(...)");
        serializer = new MoshiSerializer<>(newParameterizedType, new Object[0]);
    }
}
