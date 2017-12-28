package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_721 {
	
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts==null || accounts.size()<1){
            return new ArrayList<>();
        }
        int[] parent = new int[accounts.size()];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> eleStrs = accounts.get(i);
            for(int j=1;j<eleStrs.size();j++){
                String email = eleStrs.get(j);
                if(map.containsKey(email)){
                    int pre_id = map.get(email);
                    int cur_id = i;
                    int parent_pre_id = findParent(parent,pre_id);
                    int parent_cur_id = findParent(parent,cur_id);
                    if(parent_pre_id!=parent_cur_id){
                        parent[parent_cur_id] = parent_pre_id;
                    }
                }else{
                    map.put(email,i);
                }
            }
        }
        
        Map<Integer,Set<String>> hm = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            int index = findParent(parent,i);
            if(!hm.containsKey(index)){
                hm.put(index,new HashSet<>());
            }
            
            Set<String> temp = new HashSet<>();
            for(int j=1;j<accounts.get(i).size();j++){
                temp.add(accounts.get(i).get(j));
            }
            hm.get(index).addAll(temp);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(Integer id : hm.keySet()){
            ans.add(new ArrayList<>());
            ans.get(ans.size()-1).add(accounts.get(id).get(0));
            
            List<String> addemails = new ArrayList<>(hm.get(id));
            Collections.sort(addemails);
            ans.get(ans.size()-1).addAll(addemails);
        }
        
        return ans;
        
    }
    
    public int findParent(int[] parent,int index){
             while(index!=parent[index]){
                 parent[index] = parent[parent[index]];
                 index = parent[index];
             }
        
             return index;
    }
}
