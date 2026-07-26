class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks.length == 0) return 0;

        int[] count = new int[26];

        for(char task : tasks){
            count[task - 'A']++;
        }

        int max = 0;
        for(char c = 'A'; c <= 'Z'; c++){
            max = Math.max(count[c - 'A'] , max);
        }

        int duplicate = 0;
        for(int num : count){
            if(num == max){
                duplicate++;
            }
        }

        return Math.max((max - 1) * (n + 1) + duplicate , tasks.length);
    }
}
