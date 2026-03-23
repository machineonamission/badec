package com.blueair.core.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/blueair/core/model/SimpleResourceBundle;", "", "iconRes", "", "titleRes", "contentRes", "linkStr", "", "linkToken", "<init>", "(IIILjava/lang/String;Ljava/lang/String;)V", "getIconRes", "()I", "getTitleRes", "getContentRes", "getLinkStr", "()Ljava/lang/String;", "getLinkToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleResourceBundle.kt */
public final class SimpleResourceBundle {
    private final int contentRes;
    private final int iconRes;
    private final String linkStr;
    private final String linkToken;
    private final int titleRes;

    public static /* synthetic */ SimpleResourceBundle copy$default(SimpleResourceBundle simpleResourceBundle, int i, int i2, int i3, String str, String str2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = simpleResourceBundle.iconRes;
        }
        if ((i4 & 2) != 0) {
            i2 = simpleResourceBundle.titleRes;
        }
        if ((i4 & 4) != 0) {
            i3 = simpleResourceBundle.contentRes;
        }
        if ((i4 & 8) != 0) {
            str = simpleResourceBundle.linkStr;
        }
        if ((i4 & 16) != 0) {
            str2 = simpleResourceBundle.linkToken;
        }
        String str3 = str;
        String str4 = str2;
        return simpleResourceBundle.copy(i, i2, i3, str3, str4);
    }

    public final int component1() {
        return this.iconRes;
    }

    public final int component2() {
        return this.titleRes;
    }

    public final int component3() {
        return this.contentRes;
    }

    public final String component4() {
        return this.linkStr;
    }

    public final String component5() {
        return this.linkToken;
    }

    public final SimpleResourceBundle copy(int i, int i2, int i3, String str, String str2) {
        return new SimpleResourceBundle(i, i2, i3, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SimpleResourceBundle)) {
            return false;
        }
        SimpleResourceBundle simpleResourceBundle = (SimpleResourceBundle) obj;
        return this.iconRes == simpleResourceBundle.iconRes && this.titleRes == simpleResourceBundle.titleRes && this.contentRes == simpleResourceBundle.contentRes && Intrinsics.areEqual((Object) this.linkStr, (Object) simpleResourceBundle.linkStr) && Intrinsics.areEqual((Object) this.linkToken, (Object) simpleResourceBundle.linkToken);
    }

    public int hashCode() {
        int i = ((((this.iconRes * 31) + this.titleRes) * 31) + this.contentRes) * 31;
        String str = this.linkStr;
        int i2 = 0;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.linkToken;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "SimpleResourceBundle(iconRes=" + this.iconRes + ", titleRes=" + this.titleRes + ", contentRes=" + this.contentRes + ", linkStr=" + this.linkStr + ", linkToken=" + this.linkToken + ')';
    }

    public SimpleResourceBundle(int i, int i2, int i3, String str, String str2) {
        this.iconRes = i;
        this.titleRes = i2;
        this.contentRes = i3;
        this.linkStr = str;
        this.linkToken = str2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SimpleResourceBundle(int r2, int r3, int r4, java.lang.String r5, java.lang.String r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L_0x0006
            r5 = r0
        L_0x0006:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x000c
            r7 = r0
            goto L_0x000d
        L_0x000c:
            r7 = r6
        L_0x000d:
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.core.model.SimpleResourceBundle.<init>(int, int, int, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final int getContentRes() {
        return this.contentRes;
    }

    public final String getLinkStr() {
        return this.linkStr;
    }

    public final String getLinkToken() {
        return this.linkToken;
    }
}
