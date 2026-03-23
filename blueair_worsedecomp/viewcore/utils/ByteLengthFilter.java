package com.blueair.viewcore.utils;

import android.text.InputFilter;
import android.text.Spanned;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/blueair/viewcore/utils/ByteLengthFilter;", "Landroid/text/InputFilter;", "maxLength", "", "charset", "Ljava/nio/charset/Charset;", "<init>", "(ILjava/nio/charset/Charset;)V", "getMaxLength", "()I", "getCharset", "()Ljava/nio/charset/Charset;", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ByteLengthFilter.kt */
public final class ByteLengthFilter implements InputFilter {
    private final Charset charset;
    private final int maxLength;

    public ByteLengthFilter(int i, Charset charset2) {
        Intrinsics.checkNotNullParameter(charset2, "charset");
        this.maxLength = i;
        this.charset = charset2;
    }

    public final Charset getCharset() {
        return this.charset;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        Intrinsics.checkNotNullParameter(charSequence, "source");
        Intrinsics.checkNotNullParameter(spanned, "dest");
        if (charSequence.length() == 0) {
            return null;
        }
        byte[] bytes = StringsKt.removeRange((CharSequence) spanned, i3, i4).toString().getBytes(this.charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        int length = this.maxLength - bytes.length;
        byte[] bytes2 = String.valueOf(charSequence.charAt(i)).getBytes(this.charset);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        if (length < bytes2.length) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (length > 0 && i < i2) {
            char charAt = charSequence.charAt(i);
            byte[] bytes3 = String.valueOf(charAt).getBytes(this.charset);
            Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
            length -= bytes3.length;
            sb.append(charAt);
            i++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        byte[] bytes4 = sb2.getBytes(this.charset);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        if (bytes4.length <= this.maxLength) {
            return sb2;
        }
        return new String(ArraysKt.copyOfRange(bytes4, 0, this.maxLength), this.charset);
    }
}
