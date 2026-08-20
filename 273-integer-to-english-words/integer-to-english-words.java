    class Solution {
        String[] ones = {
            "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen",
            "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        private String helper(int num){
            if(num < 20){
                return ones[num];
            }
            if(num < 100){
                return tens[num / 10] + (num % 10 == 0 ? "" : " " + helper(num % 10));
            }
            return ones[num / 100] + " Hundred" +
                (num % 100 == 0 ? "" : " " + helper(num % 100));
        }
        public String numberToWords(int num) {
            if(num == 0){
                return "Zero";
            }
            StringBuilder ans = new StringBuilder();
            if(num >= 1000_000_000){
                ans.append(helper(num/1000_000_000));
                ans.append(" Billion");
                num %= 1_000_000_000;
            }

            if(num >= 1000_000){
                if(ans.length() > 0){
                    ans.append(" ");
                }
                ans.append(helper(num / 1000_000));
                ans.append(" Million");
                num %= 1000_000;
            }

            if(num >= 1000){
                if(ans.length() > 0){
                    ans.append(" ");
                }
                ans.append(helper(num / 1000));
                ans.append(" Thousand");
                num %= 1000;
            }

            if(num > 0){
                if(ans.length() > 0){
                    ans.append(" ");
                }
                ans.append(helper(num));
            }

            return ans.toString();
        }
    }