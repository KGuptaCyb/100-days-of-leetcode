class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0;
        int j = n - 1;
       
        while(i < j){
            
            int sum = numbers[i] + numbers[j];
            
            if(sum == target){
                int[] res = {i + 1, j + 1};
                return res;
            }
            if(sum > target){
                j--;
            }
            else{
                i++;
            }
 
        }
        return new int[0];
    }
}
