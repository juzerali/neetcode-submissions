class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for(int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) fives++;
            else if(bills[i] == 10) {
                fives--;
                tens++;
            }
            else if (bills[i] == 20) {
                if(tens > 0) {
                    tens--;
                    fives--;
                } else {
                    fives -= 3;
                }
            }

            if(fives < 0 || tens < 0) return false;
        }

        return fives >= 0 && tens >= 0;
    }
}