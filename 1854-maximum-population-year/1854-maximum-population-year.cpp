class Solution {
public:
    int maximumPopulation(vector<vector<int>>& logs) {
        vector<int> pop(101, 0);

        for (auto i : logs) {
            pop[i[0] - 1950]++;
            pop[i[1] - 1950]--;
        }

        int ans = 1950, maxi = pop[0];

        for (int i = 1; i < 101; i++) {
            pop[i] += pop[i - 1];

            if (pop[i] > maxi) {
                maxi = pop[i];
                ans = i + 1950;
            }
        }

        return ans;
    }
};