class Solution {
    public int[] twoSum(int[] nums, int target) {
         
         int index1=-1;
         int index2=-1;
         List<Integer> set = new ArrayList<>();
         for(int i=0; i<nums.length; i++){
            int compliment = target-nums[i];
            if(set.contains(compliment)){
                index1=set.indexOf(compliment);
                index2=i;
                break;
            }
            else
                set.add(nums[i]);
         }
         if(index1 != -1 || index2 != -1)
             return new int[] {index1, index2};
        return new int [] {};
    }
}
