package io.flatcircle.preferenceshelper2;

import androidx.exifinterface.media.ExifInterface;
import com.foobot.liblabclient.domain.Attribute;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonEncodingException;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0007\u001a\u00020\b\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u0001H\bJ(\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0001J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J6\u0010\u0013\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u0001H\tH\b¢\u0006\u0002\u0010\u0015J?\u0010\u0013\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u0001H\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0001¢\u0006\u0002\u0010\u0016J%\u0010\u0017\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0019J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ%\u0010 \u001a\u00020!2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020!H\u0000¢\u0006\u0002\b\"J4\u0010#\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u0001H\tH\b¢\u0006\u0002\u0010\u0015J%\u0010$\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\u0000¢\u0006\u0002\b%J\u0016\u0010&\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012J*\u0010'\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010(\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u0002H\tH\b¢\u0006\u0002\u0010)J5\u0010'\u001a\u0002H\t\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010(\u001a\u00020\u00122\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u00062\u0006\u0010\u0014\u001a\u0002H\tH\u0001¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\u0012\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010(\u001a\u0002H\tH\b¢\u0006\u0002\u0010,J-\u0010+\u001a\u00020\u0012\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010(\u001a\u0002H\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0001¢\u0006\u0002\u0010-J2\u0010.\u001a\u00020\b\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u0002H\tH\b¢\u0006\u0002\u00100J=\u0010.\u001a\u00020\b\"\b\b\u0000\u0010\t*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u0002H\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0006H\u0001¢\u0006\u0002\u00101J%\u00102\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0010H\u0000¢\u0006\u0002\b3J%\u00104\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u001bH\u0000¢\u0006\u0002\b5J%\u00106\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u001eH\u0000¢\u0006\u0002\b7J%\u00108\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u00020!H\u0000¢\u0006\u0002\b9J%\u0010:\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\u0012H\u0000¢\u0006\u0002\b;R(\u0010\u0003\u001a\u001c\u0012\u0018\u0012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lio/flatcircle/preferenceshelper2/PreferencesHelper;", "", "()V", "customAdapters", "", "Lkotlin/Pair;", "Lkotlin/reflect/KClass;", "addCustomAdapter", "", "T", "adapter", "clazz", "clear", "prefsBackend", "Lio/flatcircle/preferenceshelper2/PrefsBackend;", "contains", "", "key", "", "get", "default", "(Lio/flatcircle/preferenceshelper2/PrefsBackend;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "(Lio/flatcircle/preferenceshelper2/PrefsBackend;Ljava/lang/String;Ljava/lang/Object;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getBoolean", "fallbackVal", "getBoolean$preferenceshelper2_release", "getFloat", "", "getFloat$preferenceshelper2_release", "getInt", "", "getInt$preferenceshelper2_release", "getLong", "", "getLong$preferenceshelper2_release", "getSafely", "getString", "getString$preferenceshelper2_release", "remove", "serializeFromString", "input", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "serializeIntoString", "(Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/Object;Lkotlin/reflect/KClass;)Ljava/lang/String;", "set", "value", "(Lio/flatcircle/preferenceshelper2/PrefsBackend;Ljava/lang/String;Ljava/lang/Object;)V", "(Lio/flatcircle/preferenceshelper2/PrefsBackend;Ljava/lang/String;Ljava/lang/Object;Lkotlin/reflect/KClass;)V", "setBoolean", "setBoolean$preferenceshelper2_release", "setFloat", "setFloat$preferenceshelper2_release", "setInt", "setInt$preferenceshelper2_release", "setLong", "setLong$preferenceshelper2_release", "setString", "setString$preferenceshelper2_release", "preferenceshelper2_release"}, k = 1, mv = {1, 1, 15})
/* compiled from: PreferencesHelper.kt */
public final class PreferencesHelper {
    public static final PreferencesHelper INSTANCE = new PreferencesHelper();
    private static final List<Pair<KClass<? extends Object>, Object>> customAdapters = new ArrayList();

    private PreferencesHelper() {
    }

    private final <T> void addCustomAdapter(Object obj) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        addCustomAdapter(obj, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> void addCustomAdapter(Object obj, KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(obj, "adapter");
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        Pair pair = new Pair(kClass, obj);
        Iterator<Pair<KClass<? extends Object>, Object>> it = customAdapters.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) (KClass) it.next().getFirst(), (Object) kClass)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            customAdapters.add(pair);
        } else {
            customAdapters.set(i, pair);
        }
    }

    private final <T> T get(PrefsBackend prefsBackend, String str, T t) throws IllegalArgumentException {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return get(prefsBackend, str, t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    private final <T> T getSafely(PrefsBackend prefsBackend, String str, T t) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return get(prefsBackend, str, t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T get(io.flatcircle.preferenceshelper2.PrefsBackend r4, java.lang.String r5, T r6, kotlin.reflect.KClass<T> r7) {
        /*
            r3 = this;
            java.lang.String r0 = "prefsBackend"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            java.lang.String r0 = "clazz"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            java.lang.Class r0 = java.lang.Long.TYPE
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0031
            java.lang.Long r6 = (java.lang.Long) r6
            if (r6 == 0) goto L_0x0024
            long r6 = r6.longValue()
            goto L_0x0026
        L_0x0024:
            r6 = 0
        L_0x0026:
            long r4 = r3.getLong$preferenceshelper2_release(r4, r5, r6)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        L_0x0031:
            java.lang.Class r0 = java.lang.Integer.TYPE
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0051
            java.lang.Integer r6 = (java.lang.Integer) r6
            if (r6 == 0) goto L_0x0046
            int r1 = r6.intValue()
        L_0x0046:
            int r4 = r3.getInt$preferenceshelper2_release(r4, r5, r1)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        L_0x0051:
            java.lang.Class r0 = java.lang.Float.TYPE
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x0072
            java.lang.Float r6 = (java.lang.Float) r6
            if (r6 == 0) goto L_0x0066
            float r6 = r6.floatValue()
            goto L_0x0067
        L_0x0066:
            r6 = 0
        L_0x0067:
            float r4 = r3.getFloat$preferenceshelper2_release(r4, r5, r6)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        L_0x0072:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            java.lang.String r2 = ""
            if (r0 == 0) goto L_0x0096
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0085
            r2 = r6
        L_0x0085:
            java.lang.String r4 = r3.getString$preferenceshelper2_release(r4, r5, r2)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        L_0x008e:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException
            java.lang.String r5 = "null cannot be cast to non-null type T"
            r4.<init>(r5)
            throw r4
        L_0x0096:
            java.lang.Class r0 = java.lang.Boolean.TYPE
            kotlin.reflect.KClass r0 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r0)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 == 0) goto L_0x00ba
            boolean r7 = r6 instanceof java.lang.Boolean
            if (r7 != 0) goto L_0x00a7
            r6 = 0
        L_0x00a7:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            if (r6 == 0) goto L_0x00af
            boolean r1 = r6.booleanValue()
        L_0x00af:
            boolean r4 = r3.getBoolean$preferenceshelper2_release(r4, r5, r1)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Object r4 = (java.lang.Object) r4
            return r4
        L_0x00ba:
            if (r6 == 0) goto L_0x00c5
            java.lang.String r4 = r3.getString$preferenceshelper2_release(r4, r5, r2)
            java.lang.Object r4 = r3.serializeFromString(r4, r7, r6)
            return r4
        L_0x00c5:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Custom objects require a default parameter to be passed"
            r4.<init>(r5)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flatcircle.preferenceshelper2.PreferencesHelper.get(io.flatcircle.preferenceshelper2.PrefsBackend, java.lang.String, java.lang.Object, kotlin.reflect.KClass):java.lang.Object");
    }

    private final <T> void set(PrefsBackend prefsBackend, String str, T t) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        set(prefsBackend, str, t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> void set(PrefsBackend prefsBackend, String str, T t, KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(t, "value");
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            setLong$preferenceshelper2_release(prefsBackend, str, ((Long) t).longValue());
        } else if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            setInt$preferenceshelper2_release(prefsBackend, str, ((Integer) t).intValue());
        } else if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            setFloat$preferenceshelper2_release(prefsBackend, str, ((Float) t).floatValue());
        } else if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(String.class))) {
            setString$preferenceshelper2_release(prefsBackend, str, (String) t);
        } else if (Intrinsics.areEqual((Object) kClass, (Object) Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
            setBoolean$preferenceshelper2_release(prefsBackend, str, ((Boolean) t).booleanValue());
        } else {
            setString$preferenceshelper2_release(prefsBackend, str, serializeIntoString(t, kClass));
        }
    }

    private final <T> String serializeIntoString(T t) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return serializeIntoString(t, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> String serializeIntoString(T t, KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(t, "input");
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        Moshi.Builder builder = new Moshi.Builder();
        Iterator<Pair<KClass<? extends Object>, Object>> it = customAdapters.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) (KClass) it.next().getFirst(), (Object) kClass)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            builder.add(customAdapters.get(i).getSecond());
        }
        JsonAdapter<T> adapter = builder.add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(clazz.java)");
        String json = adapter.toJson(t);
        Intrinsics.checkExpressionValueIsNotNull(json, "jsonAdapter.toJson(input)");
        return json;
    }

    private final <T> T serializeFromString(String str, T t) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return serializeFromString(str, Reflection.getOrCreateKotlinClass(Object.class), t);
    }

    public final <T> T serializeFromString(String str, KClass<T> kClass, T t) throws IllegalArgumentException {
        Intrinsics.checkParameterIsNotNull(str, "input");
        Intrinsics.checkParameterIsNotNull(kClass, "clazz");
        Intrinsics.checkParameterIsNotNull(t, Attribute.DEF_VAL_TYPE);
        if (str.length() == 0) {
            return t;
        }
        Moshi.Builder builder = new Moshi.Builder();
        Iterator<Pair<KClass<? extends Object>, Object>> it = customAdapters.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual((Object) (KClass) it.next().getFirst(), (Object) kClass)) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            builder.add(customAdapters.get(i).getSecond());
        }
        JsonAdapter<T> adapter = builder.add((JsonAdapter.Factory) new KotlinJsonAdapterFactory()).build().adapter(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkExpressionValueIsNotNull(adapter, "moshi.adapter(clazz.java)");
        try {
            T fromJson = adapter.fromJson(str);
            return fromJson != null ? fromJson : t;
        } catch (JsonEncodingException e) {
            throw new IllegalArgumentException("Unable to serialize " + str + " into " + kClass + " due to... " + e.getLocalizedMessage());
        }
    }

    public final boolean contains(PrefsBackend prefsBackend, String str) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return prefsBackend.contains(str);
    }

    public final void setLong$preferenceshelper2_release(PrefsBackend prefsBackend, String str, long j) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        prefsBackend.setLong(str, j);
    }

    public final long getLong$preferenceshelper2_release(PrefsBackend prefsBackend, String str, long j) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return prefsBackend.getLong(str, j);
    }

    public final void setInt$preferenceshelper2_release(PrefsBackend prefsBackend, String str, int i) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        prefsBackend.setInt(str, i);
    }

    public final int getInt$preferenceshelper2_release(PrefsBackend prefsBackend, String str, int i) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return prefsBackend.getInt(str, i);
    }

    public final void setFloat$preferenceshelper2_release(PrefsBackend prefsBackend, String str, float f) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        prefsBackend.setFloat(str, f);
    }

    public final float getFloat$preferenceshelper2_release(PrefsBackend prefsBackend, String str, float f) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return prefsBackend.getFloat(str, f);
    }

    public final void setString$preferenceshelper2_release(PrefsBackend prefsBackend, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "value");
        prefsBackend.setString(str, str2);
    }

    public final String getString$preferenceshelper2_release(PrefsBackend prefsBackend, String str, String str2) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "fallbackVal");
        return prefsBackend.getString(str, str2);
    }

    public final void setBoolean$preferenceshelper2_release(PrefsBackend prefsBackend, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        prefsBackend.setBoolean(str, z);
    }

    public final boolean getBoolean$preferenceshelper2_release(PrefsBackend prefsBackend, String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        return prefsBackend.getBoolean(str, z);
    }

    public final void remove(PrefsBackend prefsBackend, String str) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        Intrinsics.checkParameterIsNotNull(str, "key");
        prefsBackend.remove(str);
    }

    public final void clear(PrefsBackend prefsBackend) {
        Intrinsics.checkParameterIsNotNull(prefsBackend, "prefsBackend");
        prefsBackend.clear();
    }

    static /* synthetic */ Object get$default(PreferencesHelper preferencesHelper, PrefsBackend prefsBackend, String str, Object obj, int i, Object obj2) throws IllegalArgumentException {
        if ((i & 4) != 0) {
            obj = null;
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return preferencesHelper.get(prefsBackend, str, obj, Reflection.getOrCreateKotlinClass(Object.class));
    }
}
