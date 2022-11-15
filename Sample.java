// Time Complexity : O(n)
// Space Complexity :O(mn)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//1 Paint house 
class Solution {
    public int minCost(int[][] costs) {
    
    int n = costs.length;
    int[][] dp = new int[n][3];

    for(int i=0; i<3; i++){

        dp[n-1][i] = costs[n-1][i];
    }

    for(int i = n-2; i >= 0 ; i--){ 
        dp[i][0] = costs[i][0] + Math.min(dp[i+1][1], dp[i+1][2]);
        dp[i][1] = costs[i][1] + Math.min(dp[i+1][0],dp[i+1][2]);
        dp[i][2] = costs[i][2] + Math.min(dp[i+1][0], dp[i+1][1]);

    }
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < 3 ; i++){

        min = Math.min(dp[0][i], min);
    }

    return min;
    }
}
    





    




//2 coing change 2
// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    public int change(int amount, int[] coins) {
        
        if (coins == null || coins.length == 0) { return -1;}
        int n = coins.length;
        int[][] dp = new int[n+1][amount +1 ];

        for(int i = 0; i< n+1 ; i++) {
            dp[i][0] =1;
        }

        for (int i = 1; i< n+1 ; i++){

            for ( int j =1 ; j < amount +1 ; j++){
                    if (j < coins[i-1]){
                        dp[i][j] = dp[i-1][j];
                    }
                        else{
                            dp[i][j] = dp[i-1][j] + dp[i][j- coins[i-1]];


                        }
            }
        }

    return dp[n][amount];   
    }
}
