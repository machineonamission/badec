package com.blueair.core.util;

import java.net.URLEncoder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005J\u001d\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005¨\u0006\u0014"},
   d2 = {"Lcom/blueair/core/util/StringUtils;", "", "<init>", "()V", "urlEncodeStringWithUTF8", "", "value", "normalize", "s", "commaSplit", "", "input", "(Ljava/lang/String;)[Ljava/lang/String;", "nullSafeToLowerCase", "ensureValidHttpHeader", "headerValue", "compareVersion", "", "new", "old", "core_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class StringUtils {
   public static final StringUtils INSTANCE = new StringUtils();

   private StringUtils() {
   }

   public final String[] commaSplit(String var1) {
      if (var1 != null) {
         CharSequence var3 = (CharSequence)var1;
         List var4 = (new Regex(",")).split(var3, 0);
         if (var4 != null) {
            label25: {
               if (!var4.isEmpty()) {
                  ListIterator var2 = var4.listIterator(var4.size());

                  while(var2.hasPrevious()) {
                     if (((CharSequence)((String)var2.previous())).length() != 0) {
                        var4 = CollectionsKt.take((Iterable)var4, var2.nextIndex() + 1);
                        break label25;
                     }
                  }
               }

               var4 = CollectionsKt.emptyList();
            }

            if (var4 != null) {
               return (String[])((Collection)var4).toArray(new String[0]);
            }
         }
      }

      return null;
   }

   public final int compareVersion(String var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "new");
      Intrinsics.checkNotNullParameter(var2, "old");
      List var6 = StringsKt.split$default((CharSequence)var1, new char[]{'.'}, false, 0, 6, (Object)null);
      List var7 = StringsKt.split$default((CharSequence)var2, new char[]{'.'}, false, 0, 6, (Object)null);
      if (var6.size() == var7.size()) {
         Iterator var8 = ((Iterable)var6).iterator();

         for(int var3 = 0; var8.hasNext(); ++var3) {
            Object var9 = var8.next();
            if (var3 < 0) {
               CollectionsKt.throwIndexOverflow();
            }

            Integer var10 = StringsKt.toIntOrNull((String)var9);
            int var4;
            if (var10 != null) {
               var4 = var10;
            } else {
               var4 = 0;
            }

            var10 = StringsKt.toIntOrNull((String)var7.get(var3));
            int var5;
            if (var10 != null) {
               var5 = var10;
            } else {
               var5 = 0;
            }

            if (var4 > var5) {
               return 1;
            }

            if (var5 > var4) {
               return -1;
            }
         }

         return 0;
      } else {
         return var6.size() > var7.size() ? 1 : -1;
      }
   }

   public final String ensureValidHttpHeader(String var1) {
      Intrinsics.checkNotNullParameter(var1, "headerValue");
      CharSequence var6 = (CharSequence)var1;
      Appendable var5 = (Appendable)(new StringBuilder());
      int var4 = var6.length();

      for(int var3 = 0; var3 < var4; ++var3) {
         char var2 = var6.charAt(var3);
         if (var2 == '\t' || ' ' <= var2 && var2 < 127) {
            var5.append(var2);
         }
      }

      return ((StringBuilder)var5).toString();
   }

   public final String normalize(String var1) {
      if (var1 != null) {
         CharSequence var2 = (CharSequence)var1;
         String var3 = (new Regex(" ")).replace(var2, "_");
         if (var3 != null) {
            var3 = var3.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var3, "toLowerCase(...)");
            if (var3 != null) {
               return var3;
            }
         }
      }

      return "";
   }

   public final String nullSafeToLowerCase(String var1) {
      CharSequence var2 = (CharSequence)var1;
      if (var2 != null && var2.length() != 0) {
         var1 = var1.toLowerCase(Locale.ROOT);
         Intrinsics.checkNotNullExpressionValue(var1, "toLowerCase(...)");
         return var1;
      } else {
         return "";
      }
   }

   public final String urlEncodeStringWithUTF8(String var1) {
      Intrinsics.checkNotNullParameter(var1, "value");

      try {
         var1 = URLEncoder.encode(var1, "UTF-8");
         Intrinsics.checkNotNull(var1);
         return var1;
      } catch (Exception var2) {
         return "";
      }
   }
}
