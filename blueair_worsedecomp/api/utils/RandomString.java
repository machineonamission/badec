package com.blueair.api.utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/blueair/api/utils/RandomString;", "", "length", "", "random", "Ljava/security/SecureRandom;", "symbols", "", "<init>", "(ILjava/security/SecureRandom;Ljava/lang/String;)V", "", "buf", "nextString", "Companion", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RandomString.kt */
public final class RandomString {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String alphanum;
    /* access modifiers changed from: private */
    public static final String digits = "0123456789";
    /* access modifiers changed from: private */
    public static final String lower;
    /* access modifiers changed from: private */
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final char[] buf;
    private final SecureRandom random;
    private final char[] symbols;

    public RandomString() {
        this(0, (SecureRandom) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public RandomString(int i) {
        this(i, (SecureRandom) null, (String) null, 6, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RandomString(int i, SecureRandom secureRandom) {
        this(i, secureRandom, (String) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(secureRandom, "random");
    }

    public RandomString(int i, SecureRandom secureRandom, String str) {
        Intrinsics.checkNotNullParameter(secureRandom, "random");
        Intrinsics.checkNotNullParameter(str, "symbols");
        if (i < 1) {
            throw new IllegalArgumentException();
        } else if (str.length() >= 2) {
            Object requireNonNull = Objects.requireNonNull(secureRandom);
            Intrinsics.checkNotNullExpressionValue(requireNonNull, "requireNonNull(...)");
            this.random = (SecureRandom) requireNonNull;
            char[] charArray = str.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            this.symbols = charArray;
            this.buf = new char[i];
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RandomString(int i, SecureRandom secureRandom, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 256 : i, (i2 & 2) != 0 ? new SecureRandom() : secureRandom, (i2 & 4) != 0 ? alphanum : str);
    }

    public final String nextString() {
        int length = this.buf.length;
        for (int i = 0; i < length; i++) {
            char[] cArr = this.buf;
            char[] cArr2 = this.symbols;
            cArr[i] = cArr2[this.random.nextInt(cArr2.length)];
        }
        return new String(this.buf);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/blueair/api/utils/RandomString$Companion;", "", "<init>", "()V", "upper", "", "getUpper", "()Ljava/lang/String;", "lower", "getLower", "digits", "getDigits", "alphanum", "getAlphanum", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: RandomString.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getUpper() {
            return RandomString.upper;
        }

        public final String getLower() {
            return RandomString.lower;
        }

        public final String getDigits() {
            return RandomString.digits;
        }

        public final String getAlphanum() {
            return RandomString.alphanum;
        }
    }

    static {
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        String lowerCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        lower = lowerCase;
        alphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + lowerCase + "0123456789";
    }
}
