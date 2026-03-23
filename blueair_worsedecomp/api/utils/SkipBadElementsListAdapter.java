package com.blueair.api.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001:\u0001\u000fB\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/api/utils/SkipBadElementsListAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "", "", "elementAdapter", "<init>", "(Lcom/squareup/moshi/JsonAdapter;)V", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value", "Factory", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkipBadElementsListAdapter.kt */
public final class SkipBadElementsListAdapter extends JsonAdapter<List<? extends Object>> {
    private final JsonAdapter<Object> elementAdapter;

    public SkipBadElementsListAdapter(JsonAdapter<Object> jsonAdapter) {
        Intrinsics.checkNotNullParameter(jsonAdapter, "elementAdapter");
        this.elementAdapter = jsonAdapter;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/blueair/api/utils/SkipBadElementsListAdapter$Factory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "<init>", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", "", "", "moshi", "Lcom/squareup/moshi/Moshi;", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SkipBadElementsListAdapter.kt */
    public static final class Factory implements JsonAdapter.Factory {
        public static final Factory INSTANCE = new Factory();

        private Factory() {
        }

        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(set, "annotations");
            Intrinsics.checkNotNullParameter(moshi, "moshi");
            Class<List> cls = List.class;
            if (!Intrinsics.areEqual((Object) Types.getRawType(type), (Object) cls) || Intrinsics.areEqual((Object) type, (Object) cls)) {
                return null;
            }
            JsonAdapter adapter = moshi.adapter(Types.collectionElementType(type, cls));
            Intrinsics.checkNotNull(adapter);
            return new SkipBadElementsListAdapter(adapter).nullSafe();
        }
    }

    public List<Object> fromJson(JsonReader jsonReader) {
        Intrinsics.checkNotNullParameter(jsonReader, "reader");
        List<Object> arrayList = new ArrayList<>();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            try {
                arrayList.add(this.elementAdapter.fromJson(jsonReader.peekJson()));
            } catch (JsonDataException e) {
                Timber.Forest.e(e, "JsonArray element parsing exception, will skip this element", new Object[0]);
            }
            jsonReader.skipValue();
        }
        jsonReader.endArray();
        return arrayList;
    }

    public void toJson(JsonWriter jsonWriter, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (list != null) {
            jsonWriter.beginArray();
            for (Object json : list) {
                this.elementAdapter.toJson(jsonWriter, json);
            }
            jsonWriter.endArray();
            return;
        }
        throw new NullPointerException("value was null! Wrap in .nullSafe() to write nullable values.");
    }
}
