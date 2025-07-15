package org.example;

import java.util.HashMap;
import java.util.Map;

public class myHashMap<K,T> extends HashMap <K,T> {
    @Override
    public String toString() {
        String ans ="";
        for (Map.Entry<K,T>entry: entrySet())
        {
            ans += entry.getKey() + ": " + entry.getValue().toString();
        }
        return ans;
    }
}
