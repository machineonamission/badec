package com.blueair.android.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel", f = "HomeViewModel.kt", i = {1}, l = {197, 201}, m = "fetchAblGranularRegion", n = {"region"}, s = {"L$0"})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$fetchAblGranularRegion$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$fetchAblGranularRegion$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$fetchAblGranularRegion$1> continuation) {
        super(continuation);
        this.this$0 = homeViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.fetchAblGranularRegion(this);
    }
}
