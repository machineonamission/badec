package com.blueair.core.util;

import com.blueair.core.model.ChinaPrivacy;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.IpConfig;
import com.blueair.core.model.McuFirmwareVersions;
import com.blueair.core.model.SkuConfiguration;
import com.blueair.core.model.SkuConfigurationData;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0012\u0010 \u001a\u0004\u0018\u00010\u00062\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0016\u0010%\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/blueair/core/util/SkuConfigurationManager;", "", "<init>", "()V", "serializer", "Lcom/blueair/core/util/MoshiSerializer;", "Lcom/blueair/core/model/SkuConfigurationData;", "value", "", "version", "getVersion", "()I", "series", "getSeries", "Lcom/blueair/core/model/ChinaPrivacy;", "chinaPrivacy", "getChinaPrivacy", "()Lcom/blueair/core/model/ChinaPrivacy;", "Lcom/blueair/core/model/McuFirmwareVersions;", "mcuFirmwareVersions", "getMcuFirmwareVersions", "()Lcom/blueair/core/model/McuFirmwareVersions;", "Lcom/blueair/core/model/SkuConfiguration;", "config", "getConfig", "()Lcom/blueair/core/model/SkuConfiguration;", "update", "", "data", "loadFromFile", "context", "Landroid/content/Context;", "loadFromJson", "json", "", "shouldUpdate", "", "updateSkuConfiguration", "skuConfigData", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfigurationManager.kt */
public final class SkuConfigurationManager {
    public static final SkuConfigurationManager INSTANCE = new SkuConfigurationManager();
    private static ChinaPrivacy chinaPrivacy = new ChinaPrivacy(0, new I18nConfig("", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null), new I18nConfig("", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null), new I18nConfig("", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2046, (DefaultConstructorMarker) null));
    private static SkuConfiguration config = new SkuConfiguration(0, 0, MapsKt.emptyMap());
    private static McuFirmwareVersions mcuFirmwareVersions = new McuFirmwareVersions((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    private static final MoshiSerializer<SkuConfigurationData> serializer = new MoshiSerializer<>(SkuConfigurationData.class, I18nConfig.Adapter.INSTANCE, IpConfig.Adapter.INSTANCE);
    private static int series;
    private static int version;

    private SkuConfigurationManager() {
    }

    public final int getVersion() {
        return version;
    }

    public final int getSeries() {
        return series;
    }

    public final ChinaPrivacy getChinaPrivacy() {
        return chinaPrivacy;
    }

    public final McuFirmwareVersions getMcuFirmwareVersions() {
        return mcuFirmwareVersions;
    }

    public final SkuConfiguration getConfig() {
        return config;
    }

    private final void update(SkuConfigurationData skuConfigurationData) {
        version = skuConfigurationData.getVersion();
        series = skuConfigurationData.getSeries();
        chinaPrivacy = skuConfigurationData.getChinaPrivacy();
        mcuFirmwareVersions = skuConfigurationData.getMcuFirmwareVersions();
        config = skuConfigurationData.getSkuConfiguration();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0093, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0097, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        throw r0;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void loadFromFile(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x009f }
            r0 = r4
            com.blueair.core.util.SkuConfigurationManager r0 = (com.blueair.core.util.SkuConfigurationManager) r0     // Catch:{ all -> 0x009f }
            android.content.res.Resources r0 = r5.getResources()     // Catch:{ all -> 0x009f }
            int r1 = com.blueair.core.R.raw.sku_configurations     // Catch:{ all -> 0x009f }
            java.io.InputStream r0 = r0.openRawResource(r1)     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "openRawResource(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x009f }
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x009f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x009f }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x009f }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x009f }
            boolean r0 = r2 instanceof java.io.BufferedReader     // Catch:{ all -> 0x009f }
            r1 = 8192(0x2000, float:1.14794E-41)
            if (r0 == 0) goto L_0x002b
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x009f }
            goto L_0x0031
        L_0x002b:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ all -> 0x009f }
            r0.<init>(r2, r1)     // Catch:{ all -> 0x009f }
            r2 = r0
        L_0x0031:
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x009f }
            r0 = r2
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x0098 }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = kotlin.io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x0098 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x009f }
            com.blueair.core.model.SkuConfigurationData r0 = r4.loadFromJson(r0)     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x0047
            goto L_0x0081
        L_0x0047:
            r4.update(r0)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = "sku_configuration.json"
            java.io.FileInputStream r5 = r5.openFileInput(r0)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = "openFileInput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)     // Catch:{ all -> 0x009f }
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ all -> 0x009f }
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x009f }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x009f }
            r2.<init>(r5, r0)     // Catch:{ all -> 0x009f }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x009f }
            boolean r5 = r2 instanceof java.io.BufferedReader     // Catch:{ all -> 0x009f }
            if (r5 == 0) goto L_0x0067
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ all -> 0x009f }
            goto L_0x006d
        L_0x0067:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x009f }
            r5.<init>(r2, r1)     // Catch:{ all -> 0x009f }
            r2 = r5
        L_0x006d:
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x009f }
            r5 = r2
            java.io.BufferedReader r5 = (java.io.BufferedReader) r5     // Catch:{ all -> 0x0091 }
            java.io.Reader r5 = (java.io.Reader) r5     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = kotlin.io.TextStreamsKt.readText(r5)     // Catch:{ all -> 0x0091 }
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x009f }
            com.blueair.core.model.SkuConfigurationData r5 = r4.loadFromJson(r5)     // Catch:{ all -> 0x009f }
            if (r5 != 0) goto L_0x0082
        L_0x0081:
            return
        L_0x0082:
            boolean r0 = r4.shouldUpdate(r5)     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x008b
            r4.update(r5)     // Catch:{ all -> 0x009f }
        L_0x008b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009f }
            kotlin.Result.m9366constructorimpl(r5)     // Catch:{ all -> 0x009f }
            return
        L_0x0091:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r5)     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ all -> 0x009f }
        L_0x0098:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r5)     // Catch:{ all -> 0x009f }
            throw r0     // Catch:{ all -> 0x009f }
        L_0x009f:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            kotlin.Result.m9366constructorimpl(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.SkuConfigurationManager.loadFromFile(android.content.Context):void");
    }

    private final SkuConfigurationData loadFromJson(String str) {
        return serializer.fromJson(str);
    }

    private final boolean shouldUpdate(SkuConfigurationData skuConfigurationData) {
        if (series == 0) {
            return true;
        }
        if (skuConfigurationData.getSeries() != series || skuConfigurationData.getVersion() <= version) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateSkuConfiguration(android.content.Context r3, com.blueair.core.model.SkuConfigurationData r4) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "skuConfigData"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r2.shouldUpdate(r4)
            if (r0 == 0) goto L_0x0069
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005f }
            r0 = r2
            com.blueair.core.util.SkuConfigurationManager r0 = (com.blueair.core.util.SkuConfigurationManager) r0     // Catch:{ all -> 0x005f }
            r2.update(r4)     // Catch:{ all -> 0x005f }
            com.blueair.core.util.MoshiSerializer<com.blueair.core.model.SkuConfigurationData> r0 = serializer     // Catch:{ all -> 0x005f }
            java.lang.String r4 = r0.toJson(r4)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "sku_configuration.json"
            r1 = 0
            java.io.FileOutputStream r3 = r3.openFileOutput(r0, r1)     // Catch:{ all -> 0x005f }
            java.lang.String r0 = "openFileOutput(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch:{ all -> 0x005f }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x005f }
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x005f }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x005f }
            r1.<init>(r3, r0)     // Catch:{ all -> 0x005f }
            java.io.Writer r1 = (java.io.Writer) r1     // Catch:{ all -> 0x005f }
            boolean r3 = r1 instanceof java.io.BufferedWriter     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x003c
            java.io.BufferedWriter r1 = (java.io.BufferedWriter) r1     // Catch:{ all -> 0x005f }
            goto L_0x0044
        L_0x003c:
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x005f }
            r0 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r1, r0)     // Catch:{ all -> 0x005f }
            r1 = r3
        L_0x0044:
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x005f }
            r3 = r1
            java.io.BufferedWriter r3 = (java.io.BufferedWriter) r3     // Catch:{ all -> 0x0058 }
            r3.write(r4)     // Catch:{ all -> 0x0058 }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0058 }
            r3 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x005f }
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005f }
            kotlin.Result.m9366constructorimpl(r3)     // Catch:{ all -> 0x005f }
            return
        L_0x0058:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x005a }
        L_0x005a:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r3)     // Catch:{ all -> 0x005f }
            throw r4     // Catch:{ all -> 0x005f }
        L_0x005f:
            r3 = move-exception
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r3 = kotlin.ResultKt.createFailure(r3)
            kotlin.Result.m9366constructorimpl(r3)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.util.SkuConfigurationManager.updateSkuConfiguration(android.content.Context, com.blueair.core.model.SkuConfigurationData):void");
    }
}
