package com.blueair.devicedetails.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.viewmodel.UserManualViewModel;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.barteksc.pdfviewer.PDFView;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.ApiResultKt;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0003J\b\u0010\u001f\u001a\u00020\u001bH\u0014R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"},
   d2 = {"Lcom/blueair/devicedetails/activity/UserManualActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "pdfView", "Lcom/github/barteksc/pdfviewer/PDFView;", "tvSubtitle", "Landroid/widget/TextView;", "progressView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "url", "defPageNum", "", "viewModel", "Lcom/blueair/devicedetails/viewmodel/UserManualViewModel;", "getViewModel", "()Lcom/blueair/devicedetails/viewmodel/UserManualViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "cacheFile", "Ljava/io/File;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "downloadFromUri", "onDestroy", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class UserManualActivity extends BaseActivity {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private static final String EXTRA_PAGE_NUMBER = "EXTRA_PAGE_NUMBER";
   private static final String EXTRA_URL = "EXTRA_URL";
   private String _screenName;
   private File cacheFile;
   private int defPageNum = 1;
   private PDFView pdfView;
   private ProgressBlockerView progressView;
   private TextView tvSubtitle;
   private String url;
   private final Lazy viewModel$delegate;

   // $FF: synthetic method
   public static void $r8$lambda$GL1nEQmvhoA6ZnDrvmVLw0x31tM(UserManualActivity var0, View var1) {
      onCreate$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static void $r8$lambda$d73h5B0QnPjKoT7wFGrrCfysyJw(UserManualActivity var0, View var1) {
      onCreate$lambda$2(var0, var1);
   }

   public UserManualActivity() {
      ComponentActivity var1 = (ComponentActivity)this;
      Function0 var2 = new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelProvider.Factory invoke() {
            return this.$this_viewModels.getDefaultViewModelProviderFactory();
         }
      };
      this.viewModel$delegate = (Lazy)(new ViewModelLazy(Reflection.getOrCreateKotlinClass(UserManualViewModel.class), new Function0(var1) {
         final ComponentActivity $this_viewModels;

         public {
            this.$this_viewModels = var1;
         }

         public final ViewModelStore invoke() {
            return this.$this_viewModels.getViewModelStore();
         }
      }, var2, new Function0((Function0)null, var1) {
         final Function0 $extrasProducer;
         final ComponentActivity $this_viewModels;

         public {
            this.$extrasProducer = var1;
            this.$this_viewModels = var2;
         }

         public final CreationExtras invoke() {
            Function0 var1 = this.$extrasProducer;
            if (var1 != null) {
               CreationExtras var2 = (CreationExtras)var1.invoke();
               if (var2 != null) {
                  return var2;
               }
            }

            return this.$this_viewModels.getDefaultViewModelCreationExtras();
         }
      }));
   }

   private final void downloadFromUri(String var1) {
      BuildersKt.launch$default((CoroutineScope)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final String $url;
         int label;
         final UserManualActivity this$0;

         {
            this.this$0 = var1;
            this.$url = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$url, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4;
            label32: {
               var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        if (var2 != 3) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ResultKt.throwOnFailure(var1);
                        return Unit.INSTANCE;
                     }

                     ResultKt.throwOnFailure(var1);
                     break label32;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  UserManualViewModel var5 = this.this$0.getViewModel();
                  String var3 = this.$url;
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  Object var9 = var5.downloadFile(var3, var6);
                  var1 = var9;
                  if (var9 == var4) {
                     return var4;
                  }
               }

               ApiResult var10 = (ApiResult)var1;
               Function2 var13 = new Function2(this.this$0, this.$url, (Continuation)null) {
                  final String $url;
                  Object L$0;
                  int label;
                  final UserManualActivity this$0;

                  {
                     this.this$0 = var1;
                     this.$url = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     Function2 var3 = new <anonymous constructor>(this.this$0, this.$url, var2);
                     var3.L$0 = var1;
                     return (Continuation)var3;
                  }

                  public final Object invoke(InputStream var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     InputStream var5 = (InputStream)this.L$0;
                     Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     Object var3 = null;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        ResultKt.throwOnFailure(var1);
                     } else {
                        ResultKt.throwOnFailure(var1);
                        if (var5 != null) {
                           CoroutineContext var7 = (CoroutineContext)Dispatchers.getIO();
                           Function2 var8 = new Function2(this.$url, this.this$0, var5, (Continuation)null) {
                              final InputStream $it;
                              final String $url;
                              int label;
                              final UserManualActivity this$0;

                              // $FF: synthetic method
                              public static void $r8$lambda$V2_38MIM6apKVlZigFbwfjIdaKk(UserManualActivity var0, int var1, int var2) {
                                 invokeSuspend$lambda$3(var0, var1, var2);
                              }

                              // $FF: synthetic method
                              public static void $r8$lambda$XUmyvmWnojZfUNYah_Xdx5jRfDg/* $FF was: $r8$lambda$XUmyvmWnojZfUNYah-Xdx5jRfDg*/(UserManualActivity var0, int var1) {
                                 invokeSuspend$lambda$2(var0, var1);
                              }

                              {
                                 this.$url = var1;
                                 this.this$0 = var2;
                                 this.$it = var3;
                              }

                              private static final void invokeSuspend$lambda$2(UserManualActivity var0, int var1) {
                                 TextView var3 = var0.tvSubtitle;
                                 Object var4 = null;
                                 TextView var2 = var3;
                                 if (var3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
                                    var2 = null;
                                 }

                                 StringBuilder var6 = new StringBuilder("Page ");
                                 PDFView var5 = var0.pdfView;
                                 PDFView var8 = var5;
                                 if (var5 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("pdfView");
                                    var8 = null;
                                 }

                                 var6.append(var8.getCurrentPage() + 1);
                                 var6.append('/');
                                 PDFView var7 = var0.pdfView;
                                 if (var7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("pdfView");
                                    var7 = (PDFView)var4;
                                 }

                                 var6.append(var7.getPageCount());
                                 var2.setText((CharSequence)var6.toString());
                              }

                              private static final void invokeSuspend$lambda$3(UserManualActivity var0, int var1, int var2) {
                                 TextView var3 = var0.tvSubtitle;
                                 TextView var4 = var3;
                                 if (var3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("tvSubtitle");
                                    var4 = null;
                                 }

                                 StringBuilder var5 = new StringBuilder("Page ");
                                 var5.append(var1 + 1);
                                 var5.append('/');
                                 var5.append(var2);
                                 var4.setText((CharSequence)var5.toString());
                              }

                              public final Continuation create(Object var1, Continuation var2) {
                                 return (Continuation)(new <anonymous constructor>(this.$url, this.this$0, this.$it, var2));
                              }

                              public final Object invoke(CoroutineScope var1, Continuation var2) {
                                 return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 if (this.label == 0) {
                                    ResultKt.throwOnFailure(var1);
                                    StringBuilder var62 = new StringBuilder();
                                    var62.append(this.$url.hashCode());
                                    var62.append('_');
                                    var62.append(System.currentTimeMillis());
                                    String var63 = var62.toString();
                                    File var3 = new File(this.this$0.getCacheDir(), var63);
                                    Closeable var2 = (Closeable)Okio.buffer(Okio.source(this.$it));

                                    label463: {
                                       Throwable var10000;
                                       label464: {
                                          BufferedSource var5;
                                          try {
                                             var5 = (BufferedSource)var2;
                                          } catch (Throwable var61) {
                                             var10000 = var61;
                                             boolean var10001 = false;
                                             break label464;
                                          }

                                          var64 = null;

                                          Closeable var4;
                                          try {
                                             var4 = (Closeable)Okio.buffer(Okio.sink$default(var3, false, 1, (Object)null));
                                          } catch (Throwable var60) {
                                             var10000 = var60;
                                             boolean var68 = false;
                                             break label464;
                                          }

                                          try {
                                             ((BufferedSink)var4).writeAll((Source)var5);
                                          } catch (Throwable var59) {
                                             Throwable var65 = var59;

                                             try {
                                                throw var65;
                                             } finally {
                                                try {
                                                   CloseableKt.closeFinally(var4, var65);
                                                } catch (Throwable var56) {
                                                   var10000 = var56;
                                                   boolean var69 = false;
                                                   break label464;
                                                }
                                             }
                                          }

                                          label446:
                                          try {
                                             CloseableKt.closeFinally(var4, (Throwable)null);
                                             break label463;
                                          } catch (Throwable var58) {
                                             var10000 = var58;
                                             boolean var70 = false;
                                             break label446;
                                          }
                                       }

                                       Throwable var66 = var10000;

                                       try {
                                          throw var66;
                                       } finally {
                                          CloseableKt.closeFinally(var2, var66);
                                       }
                                    }

                                    CloseableKt.closeFinally(var2, (Throwable)null);
                                    PDFView var67 = this.this$0.pdfView;
                                    if (var67 == null) {
                                       Intrinsics.throwUninitializedPropertyAccessException("pdfView");
                                    } else {
                                       var64 = var67;
                                    }

                                    var64.fromFile(var3).onLoad(new UserManualActivity$downloadFromUri$1$1$1$$ExternalSyntheticLambda0(this.this$0)).onPageChange(new UserManualActivity$downloadFromUri$1$1$1$$ExternalSyntheticLambda1(this.this$0)).spacing(16).defaultPage(this.this$0.defPageNum).load();
                                    this.this$0.cacheFile = var3;
                                    return Unit.INSTANCE;
                                 } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }
                              }
                           };
                           Continuation var6 = (Continuation)this;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                           this.label = 1;
                           if (BuildersKt.withContext(var7, var8, var6) == var4) {
                              return var4;
                           }
                        }
                     }

                     ProgressBlockerView var9 = this.this$0.progressView;
                     if (var9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("progressView");
                        var9 = (ProgressBlockerView)var3;
                     }

                     ViewExtensionsKt.hide((View)var9);
                     return Unit.INSTANCE;
                  }
               };
               Continuation var7 = (Continuation)this;
               this.label = 2;
               Object var11 = ApiResultKt.onSuccess(var10, var13, var7);
               var1 = var11;
               if (var11 == var4) {
                  return var4;
               }
            }

            ApiResult var14 = (ApiResult)var1;
            Function2 var8 = new Function2(this.this$0, (Continuation)null) {
               Object L$0;
               int label;
               final UserManualActivity this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  Function2 var3 = new <anonymous constructor>(this.this$0, var2);
                  var3.L$0 = var1;
                  return (Continuation)var3;
               }

               public final Object invoke(Throwable var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Throwable var2 = (Throwable)this.L$0;
                  IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  if (this.label == 0) {
                     ResultKt.throwOnFailure(var1);
                     ViewUtils var3 = ViewUtils.INSTANCE;
                     Activity var4 = (Activity)this.this$0;
                     String var6 = var2.getMessage();
                     String var5 = var6;
                     if (var6 == null) {
                        var5 = "";
                     }

                     var3.showSnackbar(var4, var5, ViewUtils.MessageType.ERROR.INSTANCE);
                     return Unit.INSTANCE;
                  } else {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }
               }
            };
            Continuation var12 = (Continuation)this;
            this.label = 3;
            if (ApiResultKt.onFail(var14, var8, var12) == var4) {
               return var4;
            } else {
               return Unit.INSTANCE;
            }
         }
      }, 3, (Object)null);
   }

   private final UserManualViewModel getViewModel() {
      return (UserManualViewModel)this.viewModel$delegate.getValue();
   }

   private static final void onCreate$lambda$1(UserManualActivity var0, View var1) {
      var0.finish();
   }

   private static final void onCreate$lambda$2(UserManualActivity var0, View var1) {
      var0.finish();
   }

   protected String getScreenName() {
      return this._screenName;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(R.layout.activity_user_manual);
      View var4 = this.findViewById(R.id.pdf_view);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.pdfView = (PDFView)var4;
      var4 = this.findViewById(R.id.progressView);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.progressView = (ProgressBlockerView)var4;
      Intent var2 = this.getIntent();
      if (var2 != null) {
         this._screenName = var2.getStringExtra("screen_name");
         String var6 = var2.getStringExtra("EXTRA_URL");
         if (var6 == null) {
            throw new IllegalStateException("Required value was null.".toString());
         }

         this.url = var6;
         this.defPageNum = RangesKt.coerceAtLeast(var2.getIntExtra("EXTRA_PAGE_NUMBER", this.defPageNum) - 1, 0);
      }

      var4 = this.findViewById(R.id.tv_subtitle);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.tvSubtitle = (TextView)var4;
      View var11 = this.findViewById(R.id.close_btn);
      var4 = this.findViewById(R.id.btnBack);
      var11.setOnClickListener(new UserManualActivity$$ExternalSyntheticLambda0(this));
      var4.setOnClickListener(new UserManualActivity$$ExternalSyntheticLambda1(this));
      String var12 = this.url;
      String var9 = var12;
      if (var12 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("url");
         var9 = null;
      }

      this.downloadFromUri(var9);
      String var3 = Locale.getDefault().toLanguageTag();
      Timber.Forest var13 = Timber.Forest;
      StringBuilder var10 = new StringBuilder("LanguageCode: ");
      var10.append(var3);
      var13.d(var10.toString(), new Object[0]);
   }

   protected void onDestroy() {
      super.onDestroy();

      Throwable var10000;
      label247: {
         PDFView var3;
         try {
            Result.Companion var1 = Result.Companion;
            var3 = this.pdfView;
         } catch (Throwable var33) {
            var10000 = var33;
            boolean var10001 = false;
            break label247;
         }

         Object var2 = null;
         PDFView var34 = var3;
         if (var3 == null) {
            try {
               Intrinsics.throwUninitializedPropertyAccessException("pdfView");
            } catch (Throwable var32) {
               var10000 = var32;
               boolean var39 = false;
               break label247;
            }

            var34 = null;
         }

         try {
            var34.recycle();
            var38 = this.cacheFile;
         } catch (Throwable var31) {
            var10000 = var31;
            boolean var40 = false;
            break label247;
         }

         Boolean var35 = (Boolean)var2;
         if (var38 != null) {
            try {
               var35 = var38.delete();
            } catch (Throwable var30) {
               var10000 = var30;
               boolean var41 = false;
               break label247;
            }
         }

         label228:
         try {
            Result.constructor-impl(var35);
            return;
         } catch (Throwable var29) {
            var10000 = var29;
            boolean var42 = false;
            break label228;
         }
      }

      Throwable var36 = var10000;
      Result.Companion var37 = Result.Companion;
      Result.constructor-impl(ResultKt.createFailure(var36));
   }

   @Metadata(
      d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"},
      d2 = {"Lcom/blueair/devicedetails/activity/UserManualActivity$Companion;", "", "<init>", "()V", "EXTRA_URL", "", "EXTRA_PAGE_NUMBER", "launch", "", "context", "Landroid/content/Context;", "screenName", "url", "pageNum", "", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      // $FF: synthetic method
      public static void launch$default(Companion var0, Context var1, String var2, String var3, int var4, int var5, Object var6) {
         if ((var5 & 8) != 0) {
            var4 = 1;
         }

         var0.launch(var1, var2, var3, var4);
      }

      public final void launch(Context var1, String var2, String var3, int var4) {
         Intrinsics.checkNotNullParameter(var1, "context");
         Intrinsics.checkNotNullParameter(var3, "url");
         Intent var5 = new Intent(var1, UserManualActivity.class);
         var5.putExtra("screen_name", var2);
         var5.putExtra("EXTRA_URL", var3);
         var5.putExtra("EXTRA_PAGE_NUMBER", var4);
         var1.startActivity(var5);
      }
   }
}
