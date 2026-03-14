package com.blueair.auth;

import com.facebook.login.LoginManager;
import kotlin.Metadata;

@Metadata(
   d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"},
   d2 = {"Lcom/blueair/auth/FacebookService;", "", "<init>", "()V", "logOut", "", "auth_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class FacebookService {
   public final void logOut() {
      LoginManager.Companion.getInstance().logOut();
   }
}
