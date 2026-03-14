package com.blueair.api.utils;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"},
   d2 = {"Lcom/blueair/api/utils/RandomString;", "", "length", "", "random", "Ljava/security/SecureRandom;", "symbols", "", "<init>", "(ILjava/security/SecureRandom;Ljava/lang/String;)V", "", "buf", "nextString", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RandomString {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String alphanum;
   private static final String digits;
   private static final String lower;
   private static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   private final char[] buf;
   private final SecureRandom random;
   private final char[] symbols;

   static {
      Locale var0 = Locale.ROOT;
      Intrinsics.checkNotNullExpressionValue(var0, "ROOT");
      String var2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(var0);
      Intrinsics.checkNotNullExpressionValue(var2, "toLowerCase(...)");
      lower = var2;
      digits = "0123456789";
      StringBuilder var1 = new StringBuilder();
      var1.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
      var1.append(var2);
      var1.append("0123456789");
      alphanum = var1.toString();
   }

   public RandomString() {
      this(0, (SecureRandom)null, (String)null, 7, (DefaultConstructorMarker)null);
   }

   public RandomString(int var1) {
      this(var1, (SecureRandom)null, (String)null, 6, (DefaultConstructorMarker)null);
   }

   public RandomString(int var1, SecureRandom var2) {
      Intrinsics.checkNotNullParameter(var2, "random");
      this(var1, var2, (String)null, 4, (DefaultConstructorMarker)null);
   }

   public RandomString(int var1, SecureRandom var2, String var3) {
      Intrinsics.checkNotNullParameter(var2, "random");
      Intrinsics.checkNotNullParameter(var3, "symbols");
      super();
      if (var1 >= 1) {
         if (var3.length() >= 2) {
            Object var4 = Objects.requireNonNull(var2);
            Intrinsics.checkNotNullExpressionValue(var4, "requireNonNull(...)");
            this.random = (SecureRandom)var4;
            char[] var5 = var3.toCharArray();
            Intrinsics.checkNotNullExpressionValue(var5, "toCharArray(...)");
            this.symbols = var5;
            this.buf = new char[var1];
         } else {
            throw new IllegalArgumentException();
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   // $FF: synthetic method
   public RandomString(int var1, SecureRandom var2, String var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 1) != 0) {
         var1 = 256;
      }

      if ((var4 & 2) != 0) {
         var2 = new SecureRandom();
      }

      if ((var4 & 4) != 0) {
         var3 = alphanum;
      }

      this(var1, var2, var3);
   }

   public final String nextString() {
      int var2 = this.buf.length;

      for(int var1 = 0; var1 < var2; ++var1) {
         char[] var4 = this.buf;
         char[] var3 = this.symbols;
         var4[var1] = var3[this.random.nextInt(var3.length)];
      }

      return new String(this.buf);
   }

   @Metadata(
      d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007¨\u0006\u000e"},
      d2 = {"Lcom/blueair/api/utils/RandomString$Companion;", "", "<init>", "()V", "upper", "", "getUpper", "()Ljava/lang/String;", "lower", "getLower", "digits", "getDigits", "alphanum", "getAlphanum", "api_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final String getAlphanum() {
         return RandomString.alphanum;
      }

      public final String getDigits() {
         return RandomString.digits;
      }

      public final String getLower() {
         return RandomString.lower;
      }

      public final String getUpper() {
         return RandomString.upper;
      }
   }
}
