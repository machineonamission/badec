package com.blueair.api.utils;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

public final class DefaultOnDataMismatchAdapter<T> extends JsonAdapter<T> {
    private final T defaultValue;
    private final JsonAdapter<T> delegate;

    private DefaultOnDataMismatchAdapter(JsonAdapter<T> jsonAdapter, T t) {
        this.delegate = jsonAdapter;
        this.defaultValue = t;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r1 = r2.defaultValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T fromJson(com.squareup.moshi.JsonReader r3) throws java.io.IOException {
        /*
            r2 = this;
            com.squareup.moshi.JsonReader r0 = r3.peekJson()
            com.squareup.moshi.JsonAdapter<T> r1 = r2.delegate     // Catch:{ JsonDataException -> 0x0010 }
            java.lang.Object r1 = r1.fromJson((com.squareup.moshi.JsonReader) r0)     // Catch:{ JsonDataException -> 0x0010 }
        L_0x000a:
            r0.close()
            goto L_0x0013
        L_0x000e:
            r3 = move-exception
            goto L_0x0017
        L_0x0010:
            T r1 = r2.defaultValue     // Catch:{ all -> 0x000e }
            goto L_0x000a
        L_0x0013:
            r3.skipValue()
            return r1
        L_0x0017:
            r0.close()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.utils.DefaultOnDataMismatchAdapter.fromJson(com.squareup.moshi.JsonReader):java.lang.Object");
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        this.delegate.toJson(jsonWriter, t);
    }

    public static <T> JsonAdapter.Factory newFactory(final Class<T> cls, final T t) {
        return new JsonAdapter.Factory() {
            public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
                Class cls = cls;
                if (cls != type) {
                    return null;
                }
                return new DefaultOnDataMismatchAdapter(moshi.nextAdapter(this, cls, set), t);
            }
        };
    }
}
