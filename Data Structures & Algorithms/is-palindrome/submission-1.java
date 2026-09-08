class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(left <= right){

            if(!Character.isLetterOrDigit(arr[left])){
                left++;
            }else if(!Character.isLetterOrDigit(arr[right])){
                right--;
            }else if(arr[left] == arr[right]){
                left++;
                right--;
            }else{
                return false;
            }
            
        }

        return true;
    }
}
