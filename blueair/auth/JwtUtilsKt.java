package com.blueair.auth;

import com.auth0.android.jwt.JWT;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"},
   d2 = {"isExpReached", "", "Lcom/auth0/android/jwt/JWT;", "auth_otherRelease"},
   k = 2,
   mv = {2, 2, 0},
   xi = 48
)
public final class JwtUtilsKt {
   public static final boolean isExpReached(JWT var0) {
      Intrinsics.checkNotNullParameter(var0, "<this>");
      Date var1 = new Date();
      Date var2 = var0.getExpiresAt();
      return var2 == null ? true : var1.after(var2);
   }
}
