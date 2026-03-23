package com.blueair.outdoor.ui.dialog;

import com.blueair.core.model.TrackedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$5$2", f = "AssignProductDialogFragment.kt", i = {1}, l = {85, 86}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
/* compiled from: AssignProductDialogFragment.kt */
final class AssignProductDialogFragment$onCreateView$5$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<TrackedLocation> $location;
    final /* synthetic */ List<String> $resetIdList;
    final /* synthetic */ List<String> $setIdList;
    Object L$0;
    int label;
    final /* synthetic */ AssignProductDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssignProductDialogFragment$onCreateView$5$2(AssignProductDialogFragment assignProductDialogFragment, Ref.ObjectRef<TrackedLocation> objectRef, List<String> list, List<String> list2, Continuation<? super AssignProductDialogFragment$onCreateView$5$2> continuation) {
        super(2, continuation);
        this.this$0 = assignProductDialogFragment;
        this.$location = objectRef;
        this.$setIdList = list;
        this.$resetIdList = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssignProductDialogFragment$onCreateView$5$2(this.this$0, this.$location, this.$setIdList, this.$resetIdList, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssignProductDialogFragment$onCreateView$5$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0066, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$5$2.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$5$2.AnonymousClass1>) null), r7) == r0) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0068, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        if (r8 == r0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r7.L$0
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0069
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0045
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            com.blueair.outdoor.ui.dialog.AssignProductDialogFragment r8 = r7.this$0
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r8 = r8.getViewModel()
            kotlin.jvm.internal.Ref$ObjectRef<com.blueair.core.model.TrackedLocation> r1 = r7.$location
            T r1 = r1.element
            com.blueair.core.model.TrackedLocation r1 = (com.blueair.core.model.TrackedLocation) r1
            java.lang.String r1 = r1.getId()
            java.util.List<java.lang.String> r4 = r7.$setIdList
            java.util.List<java.lang.String> r5 = r7.$resetIdList
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r3
            java.lang.Object r8 = r8.setLocationDevices(r1, r4, r5, r6)
            if (r8 != r0) goto L_0x0045
            goto L_0x0068
        L_0x0045:
            io.flatcircle.coroutinehelper.ApiResult r8 = (io.flatcircle.coroutinehelper.ApiResult) r8
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$5$2$1 r3 = new com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$5$2$1
            com.blueair.outdoor.ui.dialog.AssignProductDialogFragment r4 = r7.this$0
            r5 = 0
            r3.<init>(r8, r4, r5)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r8 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r7.L$0 = r8
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4)
            if (r8 != r0) goto L_0x0069
        L_0x0068:
            return r0
        L_0x0069:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$5$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
