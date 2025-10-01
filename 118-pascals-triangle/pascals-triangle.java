class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        for(int i=1;i<numRows;i++){
            List<Integer> an=new ArrayList<>();
            an.add(1);
            for(int j=1;j<i;j++){
                int val=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                an.add(val);
            }
            
            an.add(1);
            ans.add(an);
        }
        return ans;
    }
}