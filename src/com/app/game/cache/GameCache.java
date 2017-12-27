package com.app.game.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.app.game.components.pieces.Piece;

public class GameCache<V> {
	
	private Map<String, ArrayList<V>> gameCache = new LinkedHashMap<String, ArrayList<V>>();
	
	public GameCache() {
		
		__init__();
	}
	
	private void __init__(){
		
		System.out.println("Game Cache is initializing\n\n");
		gameCache.put("PlayerHistory", new ArrayList<V>());
		gameCache.put("CapturedWhitePiecesHistory", new ArrayList<V>());
		gameCache.put("CapturedBlackPiecesHistory", new ArrayList<V>());
	}
	
	public void addEntryToCache(String key, ArrayList<V> value){
		
		gameCache.put(key, value);
	}
	
	public void addSingleElementToCacheList(String key, V element){
	
		ArrayList<V> valueList = gameCache.get(key);
		valueList.add(element);
		gameCache.put(key, valueList);
		
	}
	
	public ArrayList<V> getEntryFromCache(String key){
		
		return gameCache.get(key);
	}
	
	public V getSingleLastElementFromCacheList(String key){
		
		V lastElement = gameCache.get(key).get(gameCache.size()-1);
		return lastElement;
	}
	
	public boolean isElementInCache(String key, V element){
		
		ArrayList<V> valueList = gameCache.get(key);
		return valueList.contains(element);
	}
	
	public void clearEntryFromCache(String key){
		
		gameCache.get(key).clear();
	}
	
	public void clearCache(){
		
		gameCache.clear();
	}
}
