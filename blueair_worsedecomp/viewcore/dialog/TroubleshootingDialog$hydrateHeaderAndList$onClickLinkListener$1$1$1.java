package com.blueair.viewcore.dialog;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.blueair.core.model.Device;
import com.blueair.core.model.UserForm;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.viewcore.dialog.TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1", f = "TroubleshootingDialog.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {326}, m = "invokeSuspend", n = {"account", "userForm", "subject", "body", "uri", "intent", "timestamp"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
/* compiled from: TroubleshootingDialog.kt */
final class TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Device $it;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ TroubleshootingDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1(TroubleshootingDialog troubleshootingDialog, Device device, Continuation<? super TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = troubleshootingDialog;
        this.$it = device;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TroubleshootingDialog$hydrateHeaderAndList$onClickLinkListener$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String username = this.this$0.getAuthService().getUsername();
            long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            String str = Build.VERSION.RELEASE;
            Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
            UserForm userForm = new UserForm(this.$it.getUid(), Build.BRAND + TokenParser.SP + Build.MODEL, str, "4.4.0", currentTimeMillis, UserForm.TYPE_OFFLINE, (String) null, 64, (DefaultConstructorMarker) null);
            String str2 = this.this$0.getString(R.string.label_device_offline) + " - " + username + " - " + currentTimeMillis;
            String string = this.this$0.getString(R.string.troubleshooting_offline_email_content, String.valueOf(currentTimeMillis), username, this.$it.getMac(), userForm.getPhoneModel(), userForm.getSystemVersion(), userForm.getAppVersion());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String str3 = "mailto:info@blueair.com?subject=" + Uri.encode(str2) + "&body=" + Uri.encode(string);
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(str3));
            try {
                this.this$0.startActivity(intent);
            } catch (Throwable unused) {
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(username);
            this.L$1 = SpillingKt.nullOutSpilledVariable(userForm);
            this.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            this.L$3 = SpillingKt.nullOutSpilledVariable(string);
            this.L$4 = SpillingKt.nullOutSpilledVariable(str3);
            this.L$5 = SpillingKt.nullOutSpilledVariable(intent);
            this.J$0 = currentTimeMillis;
            this.label = 1;
            if (this.this$0.getDeviceManager().postUserForm(userForm, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Intent intent2 = (Intent) this.L$5;
            String str4 = (String) this.L$4;
            String str5 = (String) this.L$3;
            String str6 = (String) this.L$2;
            UserForm userForm2 = (UserForm) this.L$1;
            String str7 = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
