package com.blueair.viewcore;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/blueair/viewcore/Header;", "", "title", "", "message", "iconDrawableResource", "", "stepOrdinal", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getTitle", "()Ljava/lang/String;", "getMessage", "getIconDrawableResource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStepOrdinal", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/blueair/viewcore/Header;", "equals", "", "other", "hashCode", "toString", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Header.kt */
public final class Header {
    private final Integer iconDrawableResource;
    private final String message;
    private final Integer stepOrdinal;
    private final String title;

    public static /* synthetic */ Header copy$default(Header header, String str, String str2, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = header.title;
        }
        if ((i & 2) != 0) {
            str2 = header.message;
        }
        if ((i & 4) != 0) {
            num = header.iconDrawableResource;
        }
        if ((i & 8) != 0) {
            num2 = header.stepOrdinal;
        }
        return header.copy(str, str2, num, num2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.message;
    }

    public final Integer component3() {
        return this.iconDrawableResource;
    }

    public final Integer component4() {
        return this.stepOrdinal;
    }

    public final Header copy(String str, String str2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        return new Header(str, str2, num, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) header.title) && Intrinsics.areEqual((Object) this.message, (Object) header.message) && Intrinsics.areEqual((Object) this.iconDrawableResource, (Object) header.iconDrawableResource) && Intrinsics.areEqual((Object) this.stepOrdinal, (Object) header.stepOrdinal);
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.message.hashCode()) * 31;
        Integer num = this.iconDrawableResource;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.stepOrdinal;
        if (num2 != null) {
            i = num2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Header(title=" + this.title + ", message=" + this.message + ", iconDrawableResource=" + this.iconDrawableResource + ", stepOrdinal=" + this.stepOrdinal + ')';
    }

    public Header(String str, String str2, Integer num, Integer num2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.title = str;
        this.message = str2;
        this.iconDrawableResource = num;
        this.stepOrdinal = num2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getMessage() {
        return this.message;
    }

    public final Integer getIconDrawableResource() {
        return this.iconDrawableResource;
    }

    public final Integer getStepOrdinal() {
        return this.stepOrdinal;
    }
}
