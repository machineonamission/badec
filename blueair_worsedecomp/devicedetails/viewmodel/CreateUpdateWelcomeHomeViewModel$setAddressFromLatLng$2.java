package com.blueair.devicedetails.viewmodel;

import android.location.Address;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.devicedetails.viewmodel.CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2", f = "CreateUpdateWelcomeHomeViewModel.kt", i = {0, 0}, l = {174}, m = "invokeSuspend", n = {"it", "$i$a$-let-CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1"}, s = {"L$0", "I$0"})
/* compiled from: CreateUpdateWelcomeHomeViewModel.kt */
final class CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ double $lat;
    final /* synthetic */ double $lng;
    final /* synthetic */ Function0<Unit> $onAddressFetch;
    int I$0;
    Object L$0;
    int label;
    final /* synthetic */ CreateUpdateWelcomeHomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2(CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel, double d, double d2, Function0<Unit> function0, Continuation<? super CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2> continuation) {
        super(2, continuation);
        this.this$0 = createUpdateWelcomeHomeViewModel;
        this.$lat = d;
        this.$lng = d2;
        this.$onAddressFetch = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2(this.this$0, this.$lat, this.$lng, this.$onAddressFetch, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Address address;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List<Address> fromLocation = this.this$0.geocoder.getFromLocation(this.$lat, this.$lng, 1);
            if (!(fromLocation == null || (address = (Address) CollectionsKt.firstOrNull(fromLocation)) == null)) {
                CreateUpdateWelcomeHomeViewModel createUpdateWelcomeHomeViewModel = this.this$0;
                double d = this.$lat;
                double d2 = this.$lng;
                Function0<Unit> function0 = this.$onAddressFetch;
                createUpdateWelcomeHomeViewModel.setLat(Boxing.boxDouble(d));
                createUpdateWelcomeHomeViewModel.setLng(Boxing.boxDouble(d2));
                createUpdateWelcomeHomeViewModel.fetchAddress(address);
                this.L$0 = SpillingKt.nullOutSpilledVariable(address);
                this.I$0 = 0;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1(function0, (Continuation<? super CreateUpdateWelcomeHomeViewModel$setAddressFromLatLng$2$1$1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            Address address2 = (Address) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
