package com.blueair.android.activity;

import android.graphics.Paint;
import com.bin.david.form.annotation.SmartColumn;
import com.bin.david.form.annotation.SmartTable;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@SmartTable
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/blueair/android/activity/InfoItemRecord;", "", "name", "", "scenario", "usage", "count", "content", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getScenario", "getUsage", "getCount", "getContent", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: InfoDetailActivity.kt */
public final class InfoItemRecord {
    public static final int $stable = 0;
    @SmartColumn(align = Paint.Align.LEFT, id = 5, name = "    收集内容", titleAlign = Paint.Align.LEFT, width = 100)
    private final String content;
    @SmartColumn(align = Paint.Align.LEFT, id = 4, name = "    收集情况", titleAlign = Paint.Align.LEFT, width = 150)
    private final String count;
    @SmartColumn(align = Paint.Align.LEFT, id = 1, name = "    信息名称", titleAlign = Paint.Align.LEFT, width = 150)
    private final String name;
    @SmartColumn(align = Paint.Align.LEFT, id = 2, name = "    使用场景", titleAlign = Paint.Align.LEFT, width = 200)
    private final String scenario;
    @SmartColumn(align = Paint.Align.LEFT, id = 3, name = "    使用目的", titleAlign = Paint.Align.LEFT, width = 300)
    private final String usage;

    public static /* synthetic */ InfoItemRecord copy$default(InfoItemRecord infoItemRecord, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = infoItemRecord.name;
        }
        if ((i & 2) != 0) {
            str2 = infoItemRecord.scenario;
        }
        if ((i & 4) != 0) {
            str3 = infoItemRecord.usage;
        }
        if ((i & 8) != 0) {
            str4 = infoItemRecord.count;
        }
        if ((i & 16) != 0) {
            str5 = infoItemRecord.content;
        }
        String str6 = str4;
        String str7 = str5;
        return infoItemRecord.copy(str, str2, str3, str6, str7);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.scenario;
    }

    public final String component3() {
        return this.usage;
    }

    public final String component4() {
        return this.count;
    }

    public final String component5() {
        return this.content;
    }

    public final InfoItemRecord copy(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "scenario");
        Intrinsics.checkNotNullParameter(str3, "usage");
        Intrinsics.checkNotNullParameter(str4, "count");
        Intrinsics.checkNotNullParameter(str5, FirebaseAnalytics.Param.CONTENT);
        return new InfoItemRecord(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InfoItemRecord)) {
            return false;
        }
        InfoItemRecord infoItemRecord = (InfoItemRecord) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) infoItemRecord.name) && Intrinsics.areEqual((Object) this.scenario, (Object) infoItemRecord.scenario) && Intrinsics.areEqual((Object) this.usage, (Object) infoItemRecord.usage) && Intrinsics.areEqual((Object) this.count, (Object) infoItemRecord.count) && Intrinsics.areEqual((Object) this.content, (Object) infoItemRecord.content);
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.scenario.hashCode()) * 31) + this.usage.hashCode()) * 31) + this.count.hashCode()) * 31) + this.content.hashCode();
    }

    public String toString() {
        return "InfoItemRecord(name=" + this.name + ", scenario=" + this.scenario + ", usage=" + this.usage + ", count=" + this.count + ", content=" + this.content + ')';
    }

    public InfoItemRecord(String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "scenario");
        Intrinsics.checkNotNullParameter(str3, "usage");
        Intrinsics.checkNotNullParameter(str4, "count");
        Intrinsics.checkNotNullParameter(str5, FirebaseAnalytics.Param.CONTENT);
        this.name = str;
        this.scenario = str2;
        this.usage = str3;
        this.count = str4;
        this.content = str5;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScenario() {
        return this.scenario;
    }

    public final String getUsage() {
        return this.usage;
    }

    public final String getCount() {
        return this.count;
    }

    public final String getContent() {
        return this.content;
    }
}
