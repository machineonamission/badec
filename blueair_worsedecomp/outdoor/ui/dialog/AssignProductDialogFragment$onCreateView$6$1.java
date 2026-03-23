package com.blueair.outdoor.ui.dialog;

import com.blueair.core.model.HasLocation;
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
@DebugMetadata(c = "com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$6$1", f = "AssignProductDialogFragment.kt", i = {1, 1}, l = {101, 107}, m = "invokeSuspend", n = {"result", "assignedDeviceIdList"}, s = {"L$0", "L$1"})
/* compiled from: AssignProductDialogFragment.kt */
final class AssignProductDialogFragment$onCreateView$6$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<HasLocation[]> $assignedDevices;
    final /* synthetic */ List<HasLocation> $hasLocations;
    final /* synthetic */ Ref.ObjectRef<TrackedLocation> $location;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AssignProductDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssignProductDialogFragment$onCreateView$6$1(AssignProductDialogFragment assignProductDialogFragment, Ref.ObjectRef<TrackedLocation> objectRef, Ref.ObjectRef<HasLocation[]> objectRef2, List<? extends HasLocation> list, Continuation<? super AssignProductDialogFragment$onCreateView$6$1> continuation) {
        super(2, continuation);
        this.this$0 = assignProductDialogFragment;
        this.$location = objectRef;
        this.$assignedDevices = objectRef2;
        this.$hasLocations = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssignProductDialogFragment$onCreateView$6$1(this.this$0, this.$location, this.$assignedDevices, this.$hasLocations, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AssignProductDialogFragment$onCreateView$6$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a5, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$6$1.AnonymousClass1((kotlin.coroutines.Continuation<? super com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$6$1.AnonymousClass1>) null), r8) == r0) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a7, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0043, code lost:
        if (r9 == r0) goto L_0x00a7;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0027
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r0 = r8.L$1
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r8.L$0
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a8
        L_0x001b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0046
        L_0x0027:
            kotlin.ResultKt.throwOnFailure(r9)
            com.blueair.outdoor.ui.dialog.AssignProductDialogFragment r9 = r8.this$0
            com.blueair.outdoor.ui.viewmodels.MapsViewModel r9 = r9.getViewModel()
            kotlin.jvm.internal.Ref$ObjectRef<com.blueair.core.model.TrackedLocation> r1 = r8.$location
            T r1 = r1.element
            com.blueair.core.model.TrackedLocation r1 = (com.blueair.core.model.TrackedLocation) r1
            java.lang.String r1 = r1.getId()
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r8.label = r3
            java.lang.Object r9 = r9.queryLocationDevices(r1, r4)
            if (r9 != r0) goto L_0x0046
            goto L_0x00a7
        L_0x0046:
            io.flatcircle.coroutinehelper.ApiResult r9 = (io.flatcircle.coroutinehelper.ApiResult) r9
            boolean r1 = r9.isSuccess()
            if (r1 == 0) goto L_0x005b
            java.lang.Object r1 = r9.getOrNull()
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L_0x007e
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x007e
        L_0x005b:
            kotlin.jvm.internal.Ref$ObjectRef<com.blueair.core.model.HasLocation[]> r1 = r8.$assignedDevices
            T r1 = r1.element
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r1.length
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            int r4 = r1.length
            r5 = 0
        L_0x006b:
            if (r5 >= r4) goto L_0x007b
            r6 = r1[r5]
            com.blueair.core.model.HasLocation r6 = (com.blueair.core.model.HasLocation) r6
            java.lang.String r6 = r6.getUid()
            r3.add(r6)
            int r5 = r5 + 1
            goto L_0x006b
        L_0x007b:
            r1 = r3
            java.util.List r1 = (java.util.List) r1
        L_0x007e:
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$6$1$1 r4 = new com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$6$1$1
            com.blueair.outdoor.ui.dialog.AssignProductDialogFragment r5 = r8.this$0
            java.util.List<com.blueair.core.model.HasLocation> r6 = r8.$hasLocations
            r7 = 0
            r4.<init>(r5, r6, r1, r7)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r8.L$0 = r9
            java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r8.L$1 = r9
            r8.label = r2
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r5)
            if (r9 != r0) goto L_0x00a8
        L_0x00a7:
            return r0
        L_0x00a8:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.outdoor.ui.dialog.AssignProductDialogFragment$onCreateView$6$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
