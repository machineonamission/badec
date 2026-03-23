package com.blueair.login;

import com.blueair.auth.GigyaService;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aB\u001f\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/blueair/login/LoginFailure;", "", "code", "", "textResourceId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getCode", "()Ljava/lang/String;", "getTextResourceId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "INVALID_EMAIL_OR_PASSWORD", "INTERNET_CONNECTION", "NO_USER_WITH_THAT_EMAIL", "LOGIN_IDENTIFIER_EXIST", "GET_EMAIL_ERROR", "MISSING_EMAIL_ERROR", "INVALID_PARAM_VALUE", "INVALID_PASSWORD", "EMAIL_ALREADY_EXIST", "RESET_NO_USER_WITH_THAT_EMAIL", "LOGIN_PENDING_PASSWORD_CHANGE", "CANCELED", "SERVER_ERROR", "Companion", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: LoginFailure.kt */
public enum LoginFailure {
    INVALID_EMAIL_OR_PASSWORD("403042", Integer.valueOf(R.string.invalid_credentials)),
    INTERNET_CONNECTION("400106", Integer.valueOf(R.string.login_error_internet_connection)),
    NO_USER_WITH_THAT_EMAIL("403047", Integer.valueOf(R.string.invalid_credentials)),
    LOGIN_IDENTIFIER_EXIST("403043", Integer.valueOf(R.string.login_error_user_exist)),
    GET_EMAIL_ERROR("400025", Integer.valueOf(R.string.login_get_email_error)),
    MISSING_EMAIL_ERROR("400027", Integer.valueOf(R.string.login_get_email_error)),
    INVALID_PARAM_VALUE("400006", Integer.valueOf(R.string.login_get_email_error)),
    INVALID_PASSWORD("400009", Integer.valueOf(R.string.register_invalid_input)),
    EMAIL_ALREADY_EXIST("400009_1", Integer.valueOf(R.string.msg_account_exist)),
    RESET_NO_USER_WITH_THAT_EMAIL("403047", Integer.valueOf(R.string.password_reset_error_not_found_email)),
    LOGIN_PENDING_PASSWORD_CHANGE("403100", Integer.valueOf(R.string.login_error_pending_password_change)),
    CANCELED((String) null, (int) null),
    SERVER_ERROR((String) null, Integer.valueOf(R.string.login_error_server));
    
    public static final Companion Companion = null;
    private final String code;
    private final Integer textResourceId;

    public static EnumEntries<LoginFailure> getEntries() {
        return $ENTRIES;
    }

    private LoginFailure(String str, Integer num) {
        this.code = str;
        this.textResourceId = num;
    }

    public final String getCode() {
        return this.code;
    }

    public final Integer getTextResourceId() {
        return this.textResourceId;
    }

    static {
        LoginFailure[] $values;
        $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/blueair/login/LoginFailure$Companion;", "", "<init>", "()V", "fromCode", "Lcom/blueair/login/LoginFailure;", "e", "", "isReset", "", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: LoginFailure.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ LoginFailure fromCode$default(Companion companion, Throwable th, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.fromCode(th, z);
        }

        public final LoginFailure fromCode(Throwable th, boolean z) {
            String str;
            if (th instanceof GigyaService.GigyaException) {
                str = String.valueOf(((GigyaService.GigyaException) th).getError().getErrorCode());
            } else {
                str = th != null ? th.getMessage() : null;
            }
            if (str != null) {
                switch (str.hashCode()) {
                    case 1502342377:
                        if (str.equals("400009-1")) {
                            return LoginFailure.EMAIL_ALREADY_EXIST;
                        }
                        break;
                    case 1534522498:
                        if (str.equals("400006")) {
                            return LoginFailure.INVALID_PARAM_VALUE;
                        }
                        break;
                    case 1534522501:
                        if (str.equals("400009")) {
                            return LoginFailure.INVALID_PASSWORD;
                        }
                        break;
                    case 1534522559:
                        if (str.equals("400025")) {
                            return LoginFailure.GET_EMAIL_ERROR;
                        }
                        break;
                    case 1534522561:
                        if (str.equals("400027")) {
                            return LoginFailure.MISSING_EMAIL_ERROR;
                        }
                        break;
                    case 1534523459:
                        if (str.equals("400106")) {
                            return LoginFailure.INTERNET_CONNECTION;
                        }
                        break;
                    case 1534611991:
                        if (str.equals("403042")) {
                            return LoginFailure.INVALID_EMAIL_OR_PASSWORD;
                        }
                        break;
                    case 1534611992:
                        if (str.equals("403043")) {
                            return LoginFailure.LOGIN_IDENTIFIER_EXIST;
                        }
                        break;
                    case 1534611996:
                        if (str.equals("403047")) {
                            if (z) {
                                return LoginFailure.RESET_NO_USER_WITH_THAT_EMAIL;
                            }
                            return LoginFailure.NO_USER_WITH_THAT_EMAIL;
                        }
                        break;
                    case 1534612826:
                        if (str.equals("403100")) {
                            return LoginFailure.LOGIN_PENDING_PASSWORD_CHANGE;
                        }
                        break;
                }
            }
            return LoginFailure.SERVER_ERROR;
        }
    }
}
