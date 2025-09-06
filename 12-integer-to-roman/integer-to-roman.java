class Solution {
    public String intToRoman(int num) {
        int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] sym = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < val.length; i++) {
            if (num == 0) {
                break;
            }
            int times = num / val[i];
            while (times-- > 0) {
                result.append(sym[i]);
            }
            num = num % val[i];  // reduce the number
        }

        return result.toString();
    }
}
