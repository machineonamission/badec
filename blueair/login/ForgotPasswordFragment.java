package com.blueair.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.CreationExtras.Empty;
import com.blueair.login.databinding.FragmentForgotPasswordBinding;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.ViewUtilsKt;
import com.google.android.material.textfield.TextInputLayout;
import io.flatcircle.viewhelper.ViewHelperUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058TX\u0094\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"},
   d2 = {"Lcom/blueair/login/ForgotPasswordFragment;", "Lcom/blueair/login/BaseLoginFragment;", "<init>", "()V", "viewModel", "Lcom/blueair/login/ForgotPasswordViewModel;", "getViewModel", "()Lcom/blueair/login/ForgotPasswordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "login_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ForgotPasswordFragment extends BaseLoginFragment {
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$3yLyUQGW6KsBfTwQ5Agw3zSRJTI(ForgotPasswordFragment var0, View var1) {
      onViewCreated$lambda$3$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$Q8WCLyaJtPGJUAF5ccEg3pwEIWU(ForgotPasswordViewModel var0, String var1) {
      return onViewCreated$lambda$6$lambda$5(var0, var1);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$eN1rXTEMXI2N0zmy3d70DLoaiME(View var0, ForgotPasswordFragment var1, Unit var2) {
      return onViewCreated$lambda$6$lambda$4(var0, var1, var2);
   }

   // $FF: synthetic method
   public static void $r8$lambda$uC4xoXV96NcaTa7GlomFOnQxhn8(ForgotPasswordFragment var0, View var1) {
      onViewCreated$lambda$3$lambda$0(var0, var1);
   }

   public ForgotPasswordFragment() {
      super(R.layout.fragment_forgot_password);
      Fragment var1 = this;
      Function0 var2 = new Function0(var1) {
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final Fragment invoke() {
            return this.$this_viewModels;
         }
      };
      Lazy var3 = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0(var2) {
         final Function0 $ownerProducer;

         public {
            this.$ownerProducer = var1;
         }

         public final ViewModelStoreOwner invoke() {
            return (ViewModelStoreOwner)this.$ownerProducer.invoke();
         }
      });
      this.viewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(var1, Reflection.getOrCreateKotlinClass(ForgotPasswordViewModel.class), new Function0(var3) {
         final Lazy $owner$delegate;

         public {
            this.$owner$delegate = var1;
         }

         public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate).getViewModelStore();
         }
      }, new Function0((Function0)null, var3) {
         final Function0 $extrasProducer;
         final Lazy $owner$delegate;

         public {
            this.$extrasProducer = var1;
            this.$owner$delegate = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            ViewModelStoreOwner var3 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var4;
            if (var3 instanceof HasDefaultViewModelProviderFactory) {
               var4 = (HasDefaultViewModelProviderFactory)var3;
            } else {
               var4 = null;
            }

            return var4 != null ? var4.getDefaultViewModelCreationExtras() : (CreationExtras)Empty.INSTANCE;
         }
      }, new Function0(var1, var3) {
         final Lazy $owner$delegate;
         final Fragment $this_viewModels;

         public {
            this.$this_viewModels = var1;
            this.$owner$delegate = var2;
         }

         public final ViewModelProvider.Factory invoke() {
            ViewModelStoreOwner var1 = FragmentViewModelLazyKt.access$viewModels$lambda-1(this.$owner$delegate);
            HasDefaultViewModelProviderFactory var2;
            if (var1 instanceof HasDefaultViewModelProviderFactory) {
               var2 = (HasDefaultViewModelProviderFactory)var1;
            } else {
               var2 = null;
            }

            if (var2 != null) {
               ViewModelProvider.Factory var3 = var2.getDefaultViewModelProviderFactory();
               if (var3 != null) {
                  return var3;
               }
            }

            ViewModelProvider.Factory var4 = this.$this_viewModels.getDefaultViewModelProviderFactory();
            Intrinsics.checkNotNullExpressionValue(var4, "defaultViewModelProviderFactory");
            return var4;
         }
      });
   }

   private static final void onViewCreated$lambda$3$lambda$0(ForgotPasswordFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var2.onBackPressed();
      }

   }

   private static final void onViewCreated$lambda$3$lambda$1(ForgotPasswordFragment var0, View var1) {
      FragmentActivity var2 = var0.getActivity();
      if (var2 != null) {
         var2.finish();
      }

   }

   private static final Unit onViewCreated$lambda$6$lambda$4(View var0, ForgotPasswordFragment var1, Unit var2) {
      ViewHelperUtil.INSTANCE.hideSoftKeyboard(var0);
      ViewUtils var4 = ViewUtils.INSTANCE;
      FragmentActivity var3 = var1.requireActivity();
      Intrinsics.checkNotNullExpressionValue(var3, "requireActivity(...)");
      var4.showSnackbar((Activity)var3, com.blueair.viewcore.R.string.msg_reset_password_success, ViewUtils.MessageType.SUCCESS.INSTANCE);
      var1.requireActivity().getSupportFragmentManager().popBackStack();
      return Unit.INSTANCE;
   }

   private static final Unit onViewCreated$lambda$6$lambda$5(ForgotPasswordViewModel var0, String var1) {
      var0.checkEmailInput();
      return Unit.INSTANCE;
   }

   protected ForgotPasswordViewModel getViewModel() {
      return (ForgotPasswordViewModel)this.viewModel$delegate.getValue();
   }

   public void onViewCreated(View var1, Bundle var2) {
      Intrinsics.checkNotNullParameter(var1, "view");
      super.onViewCreated(var1, var2);
      ViewDataBinding var5 = this.getBinding();
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type com.blueair.login.databinding.FragmentForgotPasswordBinding");
      FragmentForgotPasswordBinding var3 = (FragmentForgotPasswordBinding)var5;
      var3.btnBack.setOnClickListener(new ForgotPasswordFragment$$ExternalSyntheticLambda0(this));
      var3.btnClose.setOnClickListener(new ForgotPasswordFragment$$ExternalSyntheticLambda1(this));
      LifecycleOwner var6 = this.getViewLifecycleOwner();
      Intrinsics.checkNotNullExpressionValue(var6, "getViewLifecycleOwner(...)");
      CoroutineScope var4 = (CoroutineScope)LifecycleOwnerKt.getLifecycleScope(var6);
      LoginActivity var7 = null;
      BuildersKt.launch$default(var4, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var3, (Continuation)null) {
         final FragmentForgotPasswordBinding $this_with;
         int label;
         final ForgotPasswordFragment this$0;

         {
            this.this$0 = var1;
            this.$this_with = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$this_with, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               ResultKt.throwOnFailure(var1);
            } else {
               ResultKt.throwOnFailure(var1);
               LifecycleOwner var7 = this.this$0.getViewLifecycleOwner();
               Intrinsics.checkNotNullExpressionValue(var7, "getViewLifecycleOwner(...)");
               Lifecycle.State var6 = State.STARTED;
               Function2 var4 = new Function2(this.$this_with, this.this$0, (Continuation)null) {
                  final FragmentForgotPasswordBinding $this_with;
                  int label;
                  final ForgotPasswordFragment this$0;

                  {
                     this.$this_with = var1;
                     this.this$0 = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.$this_with, this.this$0, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        ForgotPasswordViewModel var6 = this.$this_with.getViewModel();
                        if (var6 != null) {
                           StateFlow var7 = var6.getForgotPasswordFailure();
                           if (var7 != null) {
                              Flow var5 = new Flow((Flow)var7) {
                                 final Flow $this_unsafeTransform$inlined;

                                 public {
                                    this.$this_unsafeTransform$inlined = var1;
                                 }

                                 public Object collect(FlowCollector var1, Continuation var2) {
                                    Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1) {
                                       final FlowCollector $this_unsafeFlow;

                                       public {
                                          this.$this_unsafeFlow = var1;
                                       }

                                       public final Object emit(Object var1, Continuation var2) {
                                          label28: {
                                             if (var2 instanceof <undefinedtype>) {
                                                <undefinedtype> var4 = (<undefinedtype>)var2;
                                                if ((var4.label & Integer.MIN_VALUE) != 0) {
                                                   var4.label += Integer.MIN_VALUE;
                                                   var11 = var4;
                                                   break label28;
                                                }
                                             }

                                             var11 = new ContinuationImpl(this, var2) {
                                                int I$0;
                                                Object L$0;
                                                Object L$1;
                                                Object L$2;
                                                Object L$3;
                                                int label;
                                                Object result;
                                                final <undefinedtype> this$0;

                                                public {
                                                   this.this$0 = var1;
                                                }

                                                public final Object invokeSuspend(Object var1) {
                                                   this.result = var1;
                                                   this.label |= Integer.MIN_VALUE;
                                                   return this.this$0.emit((Object)null, (Continuation)this);
                                                }
                                             };
                                          }

                                          Object var13 = ((<undefinedtype>)var11).result;
                                          Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                          int var3 = ((<undefinedtype>)var11).label;
                                          if (var3 != 0) {
                                             if (var3 != 1) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                             }

                                             var3 = ((<undefinedtype>)var11).I$0;
                                             FlowCollector var7 = (FlowCollector)((<undefinedtype>)var11).L$3;
                                             Object var8 = ((<undefinedtype>)var11).L$2;
                                             <undefinedtype> var9 = (<undefinedtype>)((<undefinedtype>)var11).L$1;
                                             Object var10 = ((<undefinedtype>)var11).L$0;
                                             ResultKt.throwOnFailure(var13);
                                          } else {
                                             ResultKt.throwOnFailure(var13);
                                             FlowCollector var6 = this.$this_unsafeFlow;
                                             Continuation var14 = (Continuation)var11;
                                             LoginFailure var15 = (LoginFailure)var1;
                                             Integer var16;
                                             if (var15 != null) {
                                                var16 = var15.getTextResId();
                                             } else {
                                                var16 = null;
                                             }

                                             ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
                                             ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var11);
                                             ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var1);
                                             ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var6);
                                             ((<undefinedtype>)var11).I$0 = 0;
                                             ((<undefinedtype>)var11).label = 1;
                                             if (var6.emit(var16, (Continuation)var11) == var5) {
                                                return var5;
                                             }
                                          }

                                          return Unit.INSTANCE;
                                       }
                                    }, var2);
                                    return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
                                 }
                              };
                              FlowCollector var8 = new FlowCollector(this.$this_with, this.this$0) {
                                 final FragmentForgotPasswordBinding $this_with;
                                 final ForgotPasswordFragment this$0;

                                 {
                                    this.$this_with = var1;
                                    this.this$0 = var2;
                                 }

                                 public final Object emit(Integer var1, Continuation var2) {
                                    if (var1 == null) {
                                       this.$this_with.txtEmailError.setVisibility(8);
                                       TextInputLayout var3 = this.$this_with.txtEmail;
                                       Intrinsics.checkNotNullExpressionValue(var3, "txtEmail");
                                       ViewUtilsKt.bindSelected(var3, false);
                                    } else {
                                       this.$this_with.txtEmailError.setText((CharSequence)this.this$0.getString(((Number)var1).intValue()));
                                       this.$this_with.txtEmailError.setVisibility(0);
                                       TextInputLayout var4 = this.$this_with.txtEmail;
                                       Intrinsics.checkNotNullExpressionValue(var4, "txtEmail");
                                       ViewUtilsKt.bindSelected(var4, true);
                                    }

                                    return Unit.INSTANCE;
                                 }
                              };
                              Continuation var4 = (Continuation)this;
                              this.label = 1;
                              if (var5.collect(var8, var4) == var3) {
                                 return var3;
                              }
                           }
                        }
                     }

                     return Unit.INSTANCE;
                  }
               };
               Continuation var5 = (Continuation)this;
               this.label = 1;
               if (RepeatOnLifecycleKt.repeatOnLifecycle(var7, var6, var4, var5) == var3) {
                  return var3;
               }
            }

            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
      FragmentActivity var10 = this.getActivity();
      if (var10 instanceof LoginActivity) {
         var7 = (LoginActivity)var10;
      }

      if (var7 != null) {
         var7.setStatusMode(true);
         ViewGroup.LayoutParams var11 = var3.toolbar.getLayoutParams();
         if (var11 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)var11).topMargin = var7.getStatusBarHeight();
            var3.toolbar.setLayoutParams(var11);
         }
      }

      ForgotPasswordViewModel var8 = this.getViewModel();
      LifecycleOwner var9 = (LifecycleOwner)this;
      BaseLoginViewModelKt.observe(var9, var8.getForgotFinished(), new ForgotPasswordFragment$$ExternalSyntheticLambda2(var1, this));
      BaseLoginViewModelKt.observe(var9, (LiveData)var8.getEmail(), new ForgotPasswordFragment$$ExternalSyntheticLambda3(var8));
   }
}
