package com.blueair.outdoor.ui.viewmodels;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.blueair.core.model.MbLocationFeatures;
import com.blueair.core.model.TrackedLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u000bH\u0016J&\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\n0\u0010H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/blueair/outdoor/ui/viewmodels/MapboxPlacesSearchViewModel;", "Lcom/blueair/outdoor/ui/viewmodels/SearchViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "searchResults", "", "Lcom/blueair/core/model/MbLocationFeatures;", "query", "", "", "onItemSelected", "position", "", "completion", "Lkotlin/Function1;", "Lcom/blueair/outdoor/ui/viewmodels/CustomPlace;", "outdoor_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public class MapboxPlacesSearchViewModel extends SearchViewModel {
   private List searchResults;

   public MapboxPlacesSearchViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      this.searchResults = CollectionsKt.emptyList();
   }

   public void onItemSelected(int var1, Function1 var2) {
      Intrinsics.checkNotNullParameter(var2, "completion");
      if (var1 < ((Collection)this.searchResults).size()) {
         MbLocationFeatures var3 = (MbLocationFeatures)this.searchResults.get(var1);
         if (((Collection)var3.getCenter()).size() == 2) {
            var2.invoke(new CustomPlace(((Number)var3.getCenter().get(1)).doubleValue(), ((Number)var3.getCenter().get(0)).doubleValue(), var3.getText(), var3.getPlace_name()));
         } else {
            var2.invoke((Object)null);
         }
      } else {
         var2.invoke((Object)null);
      }
   }

   public void query(String var1) {
      Intrinsics.checkNotNullParameter(var1, "query");
      BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
         final String $query;
         Object L$0;
         Object L$1;
         Object L$2;
         int label;
         final MapboxPlacesSearchViewModel this$0;

         {
            this.this$0 = var1;
            this.$query = var2;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, this.$query, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int var2 = this.label;
            if (var2 != 0) {
               if (var2 != 1) {
                  throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
               }

               List var3 = (List)this.L$2;
               String var11 = (String)this.L$1;
               TrackedLocation var12 = (TrackedLocation)this.L$0;
               ResultKt.throwOnFailure(var1);
            } else {
               TrackedLocation var5;
               label22: {
                  ResultKt.throwOnFailure(var1);
                  var5 = (TrackedLocation)this.this$0.getCurrentLocation().getValue();
                  if (var5 != null) {
                     Pair var9 = var5.getLatLngInWGS();
                     if (var9 != null) {
                        StringBuilder var13 = new StringBuilder();
                        var13.append(((Number)var9.getSecond()).doubleValue());
                        var13.append(',');
                        var13.append(((Number)var9.getFirst()).doubleValue());
                        String var14 = var13.toString();
                        var10 = var14;
                        if (var14 != null) {
                           break label22;
                        }
                     }
                  }

                  var10 = "";
               }

               List var8 = this.this$0.getGeocodeService().mapboxSearch(this.$query, var10, "", 10);
               CoroutineContext var15 = (CoroutineContext)Dispatchers.getMain();
               Function2 var6 = new Function2(this.this$0, var8, (Continuation)null) {
                  final List $results;
                  int label;
                  final MapboxPlacesSearchViewModel this$0;

                  {
                     this.this$0 = var1;
                     this.$results = var2;
                  }

                  public final Continuation create(Object var1, Continuation var2) {
                     return (Continuation)(new <anonymous constructor>(this.this$0, this.$results, var2));
                  }

                  public final Object invoke(CoroutineScope var1, Continuation var2) {
                     return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                  }

                  public final Object invokeSuspend(Object var1) {
                     IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     } else {
                        ResultKt.throwOnFailure(var1);
                        this.this$0.searchResults = this.$results;
                        MutableLiveData var2 = this.this$0.getSearchItems();
                        Iterable var3 = (Iterable)this.$results;
                        Collection var7 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var3, 10)));

                        for(MbLocationFeatures var5 : var3) {
                           String var8 = var5.getText();
                           String var6 = var5.getPlace_name();
                           String var9 = UUID.randomUUID().toString();
                           Intrinsics.checkNotNullExpressionValue(var9, "toString(...)");
                           var7.add(new SearchItemContainer(var8, var6, var9));
                        }

                        var2.setValue((List)var7);
                        return Unit.INSTANCE;
                     }
                  }
               };
               Continuation var7 = (Continuation)this;
               this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
               this.L$1 = SpillingKt.nullOutSpilledVariable(var10);
               this.L$2 = SpillingKt.nullOutSpilledVariable(var8);
               this.label = 1;
               if (BuildersKt.withContext(var15, var6, var7) == var4) {
                  return var4;
               }
            }

            return Unit.INSTANCE;
         }
      }, 2, (Object)null);
   }
}
