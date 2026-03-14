package com.blueair.viewcore.utils;

import android.text.InputFilter;
import android.text.Spanned;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J:\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"},
   d2 = {"Lcom/blueair/viewcore/utils/ByteLengthFilter;", "Landroid/text/InputFilter;", "maxLength", "", "charset", "Ljava/nio/charset/Charset;", "<init>", "(ILjava/nio/charset/Charset;)V", "getMaxLength", "()I", "getCharset", "()Ljava/nio/charset/Charset;", "filter", "", "source", "start", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ByteLengthFilter implements InputFilter {
   private final Charset charset;
   private final int maxLength;

   public ByteLengthFilter(int var1, Charset var2) {
      Intrinsics.checkNotNullParameter(var2, "charset");
      super();
      this.maxLength = var1;
      this.charset = var2;
   }

   public CharSequence filter(CharSequence var1, int var2, int var3, Spanned var4, int var5, int var6) {
      Intrinsics.checkNotNullParameter(var1, "source");
      Intrinsics.checkNotNullParameter(var4, "dest");
      if (var1.length() == 0) {
         return null;
      } else {
         byte[] var10 = StringsKt.removeRange((CharSequence)var4, var5, var6).toString().getBytes(this.charset);
         Intrinsics.checkNotNullExpressionValue(var10, "getBytes(...)");
         var5 = var10.length;
         var5 = this.maxLength - var5;
         var10 = String.valueOf(var1.charAt(var2)).getBytes(this.charset);
         Intrinsics.checkNotNullExpressionValue(var10, "getBytes(...)");
         if (var5 < var10.length) {
            return (CharSequence)"";
         } else {
            for(var12 = new StringBuilder(); var5 > 0 && var2 < var3; ++var2) {
               char var7 = var1.charAt(var2);
               byte[] var8 = String.valueOf(var7).getBytes(this.charset);
               Intrinsics.checkNotNullExpressionValue(var8, "getBytes(...)");
               var5 -= var8.length;
               var12.append(var7);
            }

            String var9 = var12.toString();
            Intrinsics.checkNotNullExpressionValue(var9, "toString(...)");
            var10 = var9.getBytes(this.charset);
            Intrinsics.checkNotNullExpressionValue(var10, "getBytes(...)");
            return var10.length <= this.maxLength ? (CharSequence)var9 : (CharSequence)(new String(ArraysKt.copyOfRange(var10, 0, this.maxLength), this.charset));
         }
      }
   }

   public final Charset getCharset() {
      return this.charset;
   }

   public final int getMaxLength() {
      return this.maxLength;
   }
}
