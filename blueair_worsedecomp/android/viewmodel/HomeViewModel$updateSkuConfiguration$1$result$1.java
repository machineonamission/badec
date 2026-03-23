package com.blueair.android.viewmodel;

import com.blueair.core.model.SkuConfigurationData;
import com.blueair.core.util.SkuConfigurationManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "skuConfigData", "Lcom/blueair/core/model/SkuConfigurationData;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.android.viewmodel.HomeViewModel$updateSkuConfiguration$1$result$1", f = "HomeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HomeViewModel.kt */
final class HomeViewModel$updateSkuConfiguration$1$result$1 extends SuspendLambda implements Function2<SkuConfigurationData, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HomeViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeViewModel$updateSkuConfiguration$1$result$1(HomeViewModel homeViewModel, Continuation<? super HomeViewModel$updateSkuConfiguration$1$result$1> continuation) {
        super(2, continuation);
        this.this$0 = homeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HomeViewModel$updateSkuConfiguration$1$result$1 homeViewModel$updateSkuConfiguration$1$result$1 = new HomeViewModel$updateSkuConfiguration$1$result$1(this.this$0, continuation);
        homeViewModel$updateSkuConfiguration$1$result$1.L$0 = obj;
        return homeViewModel$updateSkuConfiguration$1$result$1;
    }

    public final Object invoke(SkuConfigurationData skuConfigurationData, Continuation<? super Unit> continuation) {
        return ((HomeViewModel$updateSkuConfiguration$1$result$1) create(skuConfigurationData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SkuConfigurationData skuConfigurationData = (SkuConfigurationData) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SkuConfigurationManager.INSTANCE.updateSkuConfiguration(this.this$0.getApplication(), skuConfigurationData);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
