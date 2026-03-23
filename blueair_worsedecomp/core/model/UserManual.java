package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\tHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/blueair/core/model/UserManual;", "", "link", "", "<init>", "(Ljava/lang/String;)V", "getLink", "()Ljava/lang/String;", "startIndex", "", "getStartIndex", "()I", "filterIndex", "getFilterIndex", "wickIndex", "getWickIndex", "refresherIndex", "getRefresherIndex", "component1", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SkuConfiguration.kt */
public final class UserManual {
    private final int filterIndex;
    private final String link;
    private final int refresherIndex;
    private final int startIndex;
    private final int wickIndex;

    public static /* synthetic */ UserManual copy$default(UserManual userManual, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userManual.link;
        }
        return userManual.copy(str);
    }

    public final String component1() {
        return this.link;
    }

    public final UserManual copy(String str) {
        Intrinsics.checkNotNullParameter(str, "link");
        return new UserManual(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserManual) && Intrinsics.areEqual((Object) this.link, (Object) ((UserManual) obj).link);
    }

    public int hashCode() {
        return this.link.hashCode();
    }

    public String toString() {
        return "UserManual(link=" + this.link + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x001c, code lost:
        r0 = kotlin.text.StringsKt.toIntOrNull(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UserManual(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "link"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            r2.link = r3
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "parse(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            java.lang.String r0 = "start_index"
            java.lang.String r0 = r3.getQueryParameter(r0)
            r1 = 1
            if (r0 == 0) goto L_0x0027
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x0027
            int r0 = r0.intValue()
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            r2.startIndex = r0
            java.lang.String r0 = "filter_index"
            java.lang.String r0 = r3.getQueryParameter(r0)
            if (r0 == 0) goto L_0x003d
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x003d
            int r0 = r0.intValue()
            goto L_0x003e
        L_0x003d:
            r0 = r1
        L_0x003e:
            r2.filterIndex = r0
            java.lang.String r0 = "wick_index"
            java.lang.String r0 = r3.getQueryParameter(r0)
            if (r0 == 0) goto L_0x0053
            java.lang.Integer r0 = kotlin.text.StringsKt.toIntOrNull(r0)
            if (r0 == 0) goto L_0x0053
            int r0 = r0.intValue()
            goto L_0x0054
        L_0x0053:
            r0 = r1
        L_0x0054:
            r2.wickIndex = r0
            java.lang.String r0 = "refresher_index"
            java.lang.String r3 = r3.getQueryParameter(r0)
            if (r3 == 0) goto L_0x0068
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)
            if (r3 == 0) goto L_0x0068
            int r1 = r3.intValue()
        L_0x0068:
            r2.refresherIndex = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.UserManual.<init>(java.lang.String):void");
    }

    public final String getLink() {
        return this.link;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getFilterIndex() {
        return this.filterIndex;
    }

    public final int getWickIndex() {
        return this.wickIndex;
    }

    public final int getRefresherIndex() {
        return this.refresherIndex;
    }
}
