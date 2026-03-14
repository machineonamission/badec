package com.blueair.core.util;

public interface JsonSerializer {
   Object fromJson(String var1) throws Exception;

   String toJson(Object var1);
}
