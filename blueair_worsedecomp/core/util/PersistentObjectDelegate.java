package com.blueair.core.util;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b\"\u00020\t¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0012\u001a\u00028\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0002¢\u0006\u0002\u0010\u0016J,\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00028\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/blueair/core/util/PersistentObjectDelegate;", "T", "", "context", "Landroid/content/Context;", "fileName", "", "default", "objectType", "Ljava/lang/reflect/Type;", "typeArguments", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;[Ljava/lang/reflect/Type;)V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "field", "Ljava/lang/Object;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: PersistentObjectDelegate.kt */
public final class PersistentObjectDelegate<T> {
    private final Context context;
    private T field;
    private final String fileName;
    private final MoshiSerializer<T> serializer;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0076, code lost:
        throw r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PersistentObjectDelegate(android.content.Context r3, java.lang.String r4, T r5, java.lang.reflect.Type r6, java.lang.reflect.Type... r7) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "fileName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "objectType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "typeArguments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r2.<init>()
            r2.context = r3
            r2.fileName = r4
            com.blueair.core.util.MoshiSerializer r0 = new com.blueair.core.util.MoshiSerializer
            int r1 = r7.length
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r1)
            java.lang.reflect.Type[] r7 = (java.lang.reflect.Type[]) r7
            java.lang.reflect.ParameterizedType r6 = com.squareup.moshi.Types.newParameterizedType(r6, r7)
            java.lang.String r7 = "newParameterizedType(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.reflect.Type r6 = (java.lang.reflect.Type) r6
            r7 = 0
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r0.<init>(r6, r7)
            r2.serializer = r0
            java.io.FileInputStream r3 = r3.openFileInput(r4)     // Catch:{ all -> 0x0077 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0077 }
            r4 = r3
            java.io.FileInputStream r4 = (java.io.FileInputStream) r4     // Catch:{ all -> 0x0070 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch:{ all -> 0x0070 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0070 }
            java.nio.charset.Charset r6 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0070 }
            java.io.InputStreamReader r7 = new java.io.InputStreamReader     // Catch:{ all -> 0x0070 }
            r7.<init>(r4, r6)     // Catch:{ all -> 0x0070 }
            java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ all -> 0x0070 }
            boolean r4 = r7 instanceof java.io.BufferedReader     // Catch:{ all -> 0x0070 }
            if (r4 == 0) goto L_0x0055
            java.io.BufferedReader r7 = (java.io.BufferedReader) r7     // Catch:{ all -> 0x0070 }
            goto L_0x005d
        L_0x0055:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ all -> 0x0070 }
            r6 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r7, r6)     // Catch:{ all -> 0x0070 }
            r7 = r4
        L_0x005d:
            java.io.Reader r7 = (java.io.Reader) r7     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = kotlin.io.TextStreamsKt.readText(r7)     // Catch:{ all -> 0x0070 }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r6)     // Catch:{ all -> 0x0077 }
            java.lang.Object r3 = r0.fromJson(r4)     // Catch:{ all -> 0x0077 }
            if (r3 != 0) goto L_0x006e
            goto L_0x0077
        L_0x006e:
            r5 = r3
            goto L_0x0077
        L_0x0070:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0072 }
        L_0x0072:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x0077 }
            throw r6     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r2.field = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.PersistentObjectDelegate.<init>(android.content.Context, java.lang.String, java.lang.Object, java.lang.reflect.Type, java.lang.reflect.Type[]):void");
    }

    public final T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.field;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setValue(java.lang.Object r3, kotlin.reflect.KProperty<?> r4, T r5) {
        /*
            r2 = this;
            java.lang.String r3 = "property"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            T r3 = r2.field
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x000e
            return
        L_0x000e:
            r2.field = r5
            r3 = 0
            android.content.Context r4 = r2.context     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = r2.fileName     // Catch:{ all -> 0x0054 }
            java.io.FileOutputStream r4 = r4.openFileOutput(r0, r3)     // Catch:{ all -> 0x0054 }
            java.lang.String r0 = "openFileOutput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)     // Catch:{ all -> 0x0054 }
            java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ all -> 0x0054 }
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0054 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0054 }
            r1.<init>(r4, r0)     // Catch:{ all -> 0x0054 }
            java.io.Writer r1 = (java.io.Writer) r1     // Catch:{ all -> 0x0054 }
            boolean r4 = r1 instanceof java.io.BufferedWriter     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0030
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1     // Catch:{ all -> 0x0054 }
            goto L_0x0038
        L_0x0030:
            java.io.BufferedWriter r4 = new java.io.BufferedWriter     // Catch:{ all -> 0x0054 }
            r0 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r1, r0)     // Catch:{ all -> 0x0054 }
            r1 = r4
        L_0x0038:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x0054 }
            r4 = r1
            java.io.BufferedWriter r4 = (java.io.BufferedWriter) r4     // Catch:{ all -> 0x004d }
            com.blueair.core.util.MoshiSerializer<T> r0 = r2.serializer     // Catch:{ all -> 0x004d }
            java.lang.String r5 = r0.toJson(r5)     // Catch:{ all -> 0x004d }
            r4.write(r5)     // Catch:{ all -> 0x004d }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x004d }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x0054 }
            return
        L_0x004d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004f }
        L_0x004f:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x0054 }
            throw r5     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r4 = move-exception
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "failed to write "
            r0.<init>(r1)
            java.lang.String r1 = r2.fileName
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r5.e(r4, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.PersistentObjectDelegate.setValue(java.lang.Object, kotlin.reflect.KProperty, java.lang.Object):void");
    }
}
