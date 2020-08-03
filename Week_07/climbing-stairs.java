class Solution {

    Map<Integer,Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        if(map.get(n)!=null){
            return map.get(n);
        }else{
            int res = climbStairs(n-1)+climbStairs(n-2);
            map.put(n,res);
            return res;
        }
    }

}