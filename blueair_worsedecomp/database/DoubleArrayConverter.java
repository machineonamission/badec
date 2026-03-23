package com.blueair.database;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/DoubleArrayConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DoubleArrayConverter.kt */
public final class DoubleArrayConverter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final String fromDoubleArray(double[] dArr) {
        return Companion.fromDoubleArray(dArr);
    }

    @JvmStatic
    public static final double[] fromString(String str) {
        return Companion.fromString(str);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007R \u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/blueair/database/DoubleArrayConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "fromString", "", "value", "", "fromDoubleArray", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DoubleArrayConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final JsonAdapter<List<Double>> getJsonAdapter() {
            JsonAdapter<List<Double>> adapter = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter((Type) Types.newParameterizedType(List.class, Double.class));
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter(...)");
            return adapter;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            r3 = kotlin.collections.CollectionsKt.toDoubleArray(r3);
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final double[] fromString(java.lang.String r3) {
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
                com.squareup.moshi.JsonAdapter r0 = r2.getJsonAdapter()
                java.lang.Object r3 = r0.fromJson((java.lang.String) r3)
                java.util.List r3 = (java.util.List) r3
                if (r3 == 0) goto L_0x0023
                java.util.Collection r3 = (java.util.Collection) r3
                double[] r3 = kotlin.collections.CollectionsKt.toDoubleArray(r3)
                if (r3 != 0) goto L_0x0022
                goto L_0x0023
            L_0x0022:
                return r3
            L_0x0023:
                double[] r3 = new double[r1]
                return r3
            L_0x0026:
                double[] r3 = new double[r1]
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.database.DoubleArrayConverter.Companion.fromString(java.lang.String):double[]");
        }

        @JvmStatic
        public final String fromDoubleArray(double[] dArr) {
            List<Double> list;
            if (dArr == null || (list = ArraysKt.toList(dArr)) == null) {
                list = CollectionsKt.emptyList();
            }
            if (list.isEmpty()) {
                return "";
            }
            String json = getJsonAdapter().toJson(list);
            Intrinsics.checkNotNull(json);
            return json;
        }
    }
}
