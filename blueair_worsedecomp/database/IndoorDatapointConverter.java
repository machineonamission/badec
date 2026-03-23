package com.blueair.database;

import com.blueair.core.model.IndoorDatapoint;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/blueair/database/IndoorDatapointConverter;", "", "<init>", "()V", "Companion", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorDatapointConverter.kt */
public final class IndoorDatapointConverter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final String fromArrayList(ArrayList<IndoorDatapoint> arrayList) {
        return Companion.fromArrayList(arrayList);
    }

    @JvmStatic
    public static final ArrayList<IndoorDatapoint> fromString(String str) {
        return Companion.fromString(str);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J$\u0010\u000e\u001a\u00020\r2\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bH\u0007R'\u0010\u0004\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/blueair/database/IndoorDatapointConverter$Companion;", "", "<init>", "()V", "jsonAdapter", "Lcom/squareup/moshi/JsonAdapter;", "Ljava/util/ArrayList;", "Lcom/blueair/core/model/IndoorDatapoint;", "Lkotlin/collections/ArrayList;", "getJsonAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "fromString", "value", "", "fromArrayList", "database_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorDatapointConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JsonAdapter<ArrayList<IndoorDatapoint>> getJsonAdapter() {
            JsonAdapter<ArrayList<IndoorDatapoint>> adapter = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter((Type) Types.newParameterizedType(List.class, IndoorDatapoint.class));
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter(...)");
            return adapter;
        }

        @JvmStatic
        public final ArrayList<IndoorDatapoint> fromString(String str) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                return new ArrayList<>();
            }
            ArrayList<IndoorDatapoint> fromJson = getJsonAdapter().fromJson(str);
            return fromJson == null ? new ArrayList<>() : fromJson;
        }

        @JvmStatic
        public final String fromArrayList(ArrayList<IndoorDatapoint> arrayList) {
            Collection collection = arrayList;
            if (collection == null || collection.isEmpty()) {
                return "";
            }
            String json = getJsonAdapter().toJson(arrayList);
            Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
            return json;
        }
    }
}
