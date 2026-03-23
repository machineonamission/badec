package com.blueair.login;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.blueair.login.databinding.FragmentForgotPasswordBinding;
import com.blueair.viewcore.ViewUtilsKt;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.blueair.login.ForgotPasswordFragment$onViewCreated$1$3", f = "ForgotPasswordFragment.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ForgotPasswordFragment.kt */
final class ForgotPasswordFragment$onViewCreated$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentForgotPasswordBinding $this_with;
    int label;
    final /* synthetic */ ForgotPasswordFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ForgotPasswordFragment$onViewCreated$1$3(ForgotPasswordFragment forgotPasswordFragment, FragmentForgotPasswordBinding fragmentForgotPasswordBinding, Continuation<? super ForgotPasswordFragment$onViewCreated$1$3> continuation) {
        super(2, continuation);
        this.this$0 = forgotPasswordFragment;
        this.$this_with = fragmentForgotPasswordBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForgotPasswordFragment$onViewCreated$1$3(this.this$0, this.$this_with, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ForgotPasswordFragment$onViewCreated$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.login.ForgotPasswordFragment$onViewCreated$1$3$1", f = "ForgotPasswordFragment.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.login.ForgotPasswordFragment$onViewCreated$1$3$1  reason: invalid class name */
    /* compiled from: ForgotPasswordFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(fragmentForgotPasswordBinding, forgotPasswordFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            StateFlow<LoginFailure> forgotPasswordFailure;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ForgotPasswordViewModel viewModel = fragmentForgotPasswordBinding.getViewModel();
                if (!(viewModel == null || (forgotPasswordFailure = viewModel.getForgotPasswordFailure()) == null)) {
                    final FragmentForgotPasswordBinding fragmentForgotPasswordBinding = fragmentForgotPasswordBinding;
                    final ForgotPasswordFragment forgotPasswordFragment = forgotPasswordFragment;
                    this.label = 1;
                    if (new ForgotPasswordFragment$onViewCreated$1$3$1$invokeSuspend$$inlined$map$1(forgotPasswordFailure).collect(new FlowCollector() {
                        public final Object emit(Integer num, Continuation<? super Unit> continuation) {
                            if (num == null) {
                                fragmentForgotPasswordBinding.txtEmailError.setVisibility(8);
                                TextInputLayout textInputLayout = fragmentForgotPasswordBinding.txtEmail;
                                Intrinsics.checkNotNullExpressionValue(textInputLayout, "txtEmail");
                                ViewUtilsKt.bindSelected(textInputLayout, false);
                            } else {
                                fragmentForgotPasswordBinding.txtEmailError.setText(forgotPasswordFragment.getString(num.intValue()));
                                fragmentForgotPasswordBinding.txtEmailError.setVisibility(0);
                                TextInputLayout textInputLayout2 = fragmentForgotPasswordBinding.txtEmail;
                                Intrinsics.checkNotNullExpressionValue(textInputLayout2, "txtEmail");
                                ViewUtilsKt.bindSelected(textInputLayout2, true);
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleOwner viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            Lifecycle.State state = Lifecycle.State.STARTED;
            final FragmentForgotPasswordBinding fragmentForgotPasswordBinding = this.$this_with;
            final ForgotPasswordFragment forgotPasswordFragment = this.this$0;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(viewLifecycleOwner, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
