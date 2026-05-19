class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length == 0) return new int[]{1};
        int carry = 1;

        for(int i = digits.length - 1; i >= 0 && carry > 0; i--) {
            int digit = digits[i];
            int sum = digit + carry;

            digits[i] = sum % 10;
            carry = sum / 10;
        }

        int[] result = digits;
        if(carry == 1) {
            result = new int[digits.length + 1];
            result[0] = 1;
            for(int i = 0; i < digits.length; i++) {
                result[i+1] = digits[i];
            }
        }

        return result;
    }
}
