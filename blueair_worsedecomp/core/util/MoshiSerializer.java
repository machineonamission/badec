package com.blueair.core.util;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cJ\u0017\u0010\u001d\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0004\u0018\u00018\u00002\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR-\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00120\u00118BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00118BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u0018\u0010\u0015¨\u0006#"}, d2 = {"Lcom/blueair/core/util/MoshiSerializer;", "T", "Lcom/blueair/core/util/JsonSerializer;", "type", "Ljava/lang/reflect/Type;", "extraAdapters", "", "", "<init>", "(Ljava/lang/reflect/Type;[Ljava/lang/Object;)V", "moshi", "Lcom/squareup/moshi/Moshi;", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "moshi$delegate", "Lkotlin/Lazy;", "mapAdapter", "Lcom/squareup/moshi/JsonAdapter;", "", "", "getMapAdapter", "()Lcom/squareup/moshi/JsonAdapter;", "mapAdapter$delegate", "jsonAdapter", "getJsonAdapter", "jsonAdapter$delegate", "toJson", "t", "(Ljava/lang/Object;)Ljava/lang/String;", "fromJson", "serialized", "(Ljava/lang/String;)Ljava/lang/Object;", "fromMap", "map", "(Ljava/util/Map;)Ljava/lang/Object;", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: MoshiSerializer.kt */
public final class MoshiSerializer<T> implements JsonSerializer<T> {
    private final Lazy jsonAdapter$delegate = LazyKt.lazy(new MoshiSerializer$$ExternalSyntheticLambda2(this));
    private final Lazy mapAdapter$delegate = LazyKt.lazy(new MoshiSerializer$$ExternalSyntheticLambda1(this));
    private final Lazy moshi$delegate;
    private final Type type;

    public MoshiSerializer(Type type2, Object... objArr) {
        Intrinsics.checkNotNullParameter(type2, "type");
        Intrinsics.checkNotNullParameter(objArr, "extraAdapters");
        this.type = type2;
        this.moshi$delegate = LazyKt.lazy(new MoshiSerializer$$ExternalSyntheticLambda0(objArr));
    }

    private final Moshi getMoshi() {
        Object value = this.moshi$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Moshi) value;
    }

    /* access modifiers changed from: private */
    public static final Moshi moshi_delegate$lambda$1(Object[] objArr) {
        Moshi.Builder builder = new Moshi.Builder();
        for (Object add : objArr) {
            builder.add(add);
        }
        builder.add((JsonAdapter.Factory) new KotlinJsonAdapterFactory());
        return builder.build();
    }

    private final JsonAdapter<Map<String, Object>> getMapAdapter() {
        Object value = this.mapAdapter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* access modifiers changed from: private */
    public static final JsonAdapter mapAdapter_delegate$lambda$2(MoshiSerializer moshiSerializer) {
        return moshiSerializer.getMoshi().adapter((Type) Types.newParameterizedType(Map.class, String.class, Object.class));
    }

    private final JsonAdapter<T> getJsonAdapter() {
        Object value = this.jsonAdapter$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (JsonAdapter) value;
    }

    /* access modifiers changed from: private */
    public static final JsonAdapter jsonAdapter_delegate$lambda$3(MoshiSerializer moshiSerializer) {
        return moshiSerializer.getMoshi().adapter(moshiSerializer.type);
    }

    public String toJson(T t) {
        String json = getJsonAdapter().toJson(t);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return json;
    }

    public T fromJson(String str) {
        Intrinsics.checkNotNullParameter(str, "serialized");
        if (str.length() > 0) {
            return getJsonAdapter().fromJson(str);
        }
        return null;
    }

    public final T fromMap(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        String json = getMapAdapter().toJson(map);
        Intrinsics.checkNotNull(json);
        return fromJson(json);
    }
}
