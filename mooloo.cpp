#include <bits/stdc++.h>
//#include <bits/bedugging.h>
using namespace std;
typedef long long ll;
typedef pair<int,int> pii;
void solve() {
    ll n,k; cin >> n >> k;
    vector<ll> stor(n);
    for (int i = 0; i < n; i++) cin >> stor[i];
    vector<ll> dp(n); dp[0] = k+1;
    for (int i = 1; i < n; i++) {
        dp[i] = dp[i-1] + min(stor[i]-stor[i-1], k+1);
    }
    //cout << dp << '\n';
    cout << dp[n-1] << '\n';
}
int main() {
    ios_base::sync_with_stdio(0); cin.tie(0);
    //int t; cin >> t;
    int t = 1;
    while (t--) {
        solve();
    }
}