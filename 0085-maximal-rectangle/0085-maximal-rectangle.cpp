class Solution {
public:
    int histogram(vector<int> row){

        int maxi = 0;
        int n = row.size();
        int nse = 0;
        int pse = 0;
        stack<int> st;

        for(int i = 0; i < n; i++){

            while(!st.empty() && row[st.top()]>row[i]){
                int element = row[st.top()];
                st.pop();
                nse = i;
                if(st.empty()) pse = -1;
                else pse = st.top();

                int area = element*(nse-pse-1);
                maxi = max(maxi,area);
            }

            st.push(i);
        }

        while(!st.empty()){
            nse = n;
            int element = row[st.top()];
            st.pop();

            if(st.empty()) pse = -1;
            else pse = st.top();

            int area = element*(nse-pse-1);
            maxi = max(maxi,area);
        }

        return maxi;
    }
    int maximalRectangle(vector<vector<char>>& matrix) {
        
        int rows = matrix.size();
        int columns = matrix[0].size();

        vector<vector<int>> presum(rows,vector<int>(columns,0));

        for(int i = 0; i < columns; i++){   //converting each row into histogram heights

            int sum = 0;
            for(int j = 0; j < rows; j++){

                if(matrix[j][i]=='1') sum++;
                else sum = 0;

                presum[j][i] = sum;
            }
        }

        int maxi = 0;

        for(int i = 0; i < rows; i++){     //run the histogram algo for each row
            maxi = max(maxi,histogram(presum[i]));
        }

        return maxi;
    }
};