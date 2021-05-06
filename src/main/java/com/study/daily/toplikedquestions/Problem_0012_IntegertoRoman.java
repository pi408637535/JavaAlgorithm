package com.study.daily.toplikedquestions;

public class Problem_0012_IntegertoRoman {
    public String intToRoman(int num) {
        String[][] c = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"},
        {"", "X","XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
                {"", "M", "MM", "MMM"}};

        return c[3][num / 1000] + c[2][num / 100 % 10] + c[1][num / 10 % 10] + c[0][num % 10];

    }
}
