package io.flatcircle.mqtt;

import androidx.exifinterface.media.ExifInterface;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b\u001a\"\u0010\u0006\u001a\u0002H\u0002\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\b¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"serializeListFromString", "", "T", "", "input", "", "serializeFromString", "(Ljava/lang/String;)Ljava/lang/Object;", "mqtt_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: MqttService.kt */
public final class MqttServiceKt {
    public static final /* synthetic */ <T> List<T> serializeListFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        if (str.length() == 0) {
            return CollectionsKt.emptyList();
        }
        Moshi build = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        JsonAdapter lenient = build.adapter((Type) Types.newParameterizedType(List.class, Object.class)).lenient();
        Intrinsics.checkNotNullExpressionValue(lenient, "lenient(...)");
        JsonAdapter jsonAdapter = lenient;
        List<T> list = (List) lenient.fromJson(str);
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        List list2 = list;
        return list;
    }

    public static final /* synthetic */ <T> T serializeFromString(String str) {
        Intrinsics.checkNotNullParameter(str, "input");
        if (str.length() == 0) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            T objectInstance = Reflection.getOrCreateKotlinClass(Object.class).getObjectInstance();
            Intrinsics.checkNotNull(objectInstance);
            return objectInstance;
        }
        Moshi build = new Moshi.Builder().add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        JsonAdapter<Object> lenient = build.adapter(cls).lenient();
        Intrinsics.checkNotNullExpressionValue(lenient, "lenient(...)");
        JsonAdapter jsonAdapter = lenient;
        T fromJson = lenient.fromJson(str);
        if (fromJson != null) {
            return fromJson;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        T objectInstance2 = Reflection.getOrCreateKotlinClass(Object.class).getObjectInstance();
        Intrinsics.checkNotNull(objectInstance2);
        return objectInstance2;
    }
}
