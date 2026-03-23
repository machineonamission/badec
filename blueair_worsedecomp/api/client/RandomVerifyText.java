package com.blueair.api.client;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/blueair/api/client/RandomVerifyText;", "", "rand", "", "text", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getRand", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceClient.kt */
public final class RandomVerifyText {
    private final String rand;
    private final String text;

    public static /* synthetic */ RandomVerifyText copy$default(RandomVerifyText randomVerifyText, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = randomVerifyText.rand;
        }
        if ((i & 2) != 0) {
            str2 = randomVerifyText.text;
        }
        return randomVerifyText.copy(str, str2);
    }

    public final String component1() {
        return this.rand;
    }

    public final String component2() {
        return this.text;
    }

    public final RandomVerifyText copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "rand");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new RandomVerifyText(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RandomVerifyText)) {
            return false;
        }
        RandomVerifyText randomVerifyText = (RandomVerifyText) obj;
        return Intrinsics.areEqual((Object) this.rand, (Object) randomVerifyText.rand) && Intrinsics.areEqual((Object) this.text, (Object) randomVerifyText.text);
    }

    public int hashCode() {
        return (this.rand.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "RandomVerifyText(rand=" + this.rand + ", text=" + this.text + ')';
    }

    public RandomVerifyText(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "rand");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.rand = str;
        this.text = str2;
    }

    public final String getRand() {
        return this.rand;
    }

    public final String getText() {
        return this.text;
    }
}
