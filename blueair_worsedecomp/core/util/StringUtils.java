package com.blueair.core.util;

import java.net.URLEncoder;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005¨\u0006\u0014"}, d2 = {"Lcom/blueair/core/util/StringUtils;", "", "<init>", "()V", "urlEncodeStringWithUTF8", "", "value", "normalize", "s", "commaSplit", "", "input", "(Ljava/lang/String;)[Ljava/lang/String;", "nullSafeToLowerCase", "ensureValidHttpHeader", "headerValue", "compareVersion", "", "new", "old", "core_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StringUtils.kt */
public final class StringUtils {
    public static final StringUtils INSTANCE = new StringUtils();

    private StringUtils() {
    }

    public final String urlEncodeStringWithUTF8(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            Intrinsics.checkNotNull(encode);
            return encode;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String normalize(String str) {
        String replace;
        if (str == null || (replace = new Regex(" ").replace((CharSequence) str, "_")) == null) {
            return "";
        }
        String lowerCase = replace.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase == null ? "" : lowerCase;
    }

    public final String[] commaSplit(String str) {
        List<String> split;
        List list;
        if (str == null || (split = new Regex(",").split(str, 0)) == null) {
            return null;
        }
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        list = CollectionsKt.emptyList();
        if (list != null) {
            return (String[]) list.toArray(new String[0]);
        }
        return null;
    }

    public final String nullSafeToLowerCase(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final int compareVersion(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "new");
        Intrinsics.checkNotNullParameter(str4, "old");
        List split$default = StringsKt.split$default((CharSequence) str3, new char[]{'.'}, false, 0, 6, (Object) null);
        List split$default2 = StringsKt.split$default((CharSequence) str4, new char[]{'.'}, false, 0, 6, (Object) null);
        if (split$default.size() == split$default2.size()) {
            int i = 0;
            for (Object next : split$default) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Integer intOrNull = StringsKt.toIntOrNull((String) next);
                int intValue = intOrNull != null ? intOrNull.intValue() : 0;
                Integer intOrNull2 = StringsKt.toIntOrNull((String) split$default2.get(i));
                int intValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
                if (intValue > intValue2) {
                    return 1;
                }
                if (intValue2 > intValue) {
                    return -1;
                }
                i = i2;
            }
            return 0;
        } else if (split$default.size() > split$default2.size()) {
            return 1;
        } else {
            return -1;
        }
    }

    public final String ensureValidHttpHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "headerValue");
        CharSequence charSequence = str;
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (charAt == 9 || (' ' <= charAt && charAt < 127)) {
                sb.append(charAt);
            }
        }
        return ((StringBuilder) sb).toString();
    }
}
