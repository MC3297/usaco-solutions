#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define int ll
using pii = pair<int,int>;
#ifndef LOCAL
#define debug(...)
#endif
#define fi first
#define se second
#define pb push_back 
#define lb lower_bound
#define ub upper_bound
#define sz(x) (int)(x).size()
#define all(v) v.begin(), v.end()
#define YES cout << "YES" << '\n'
#define NO cout << "NO" << '\n'
#define IMP cout << "IMPOSSIBLE" << '\n'
#define FOR(i,s,e) for (int i = (s); i < (e); ++i) 
#define F0R(i,e) FOR(i,0,e) 
#define ROF(i,s,e) for (int i = (e)-1; i >= (s); --i) 
#define R0F(i,e) ROF(i,0,e) 
#define printv(v,s,e) FOR(i,s,e+1) cout << v[i] << ' '; cout << '\n'
template<class T> using min_priority_queue = priority_queue<T, vector<T>, greater<T>>;
template<typename T> istream& operator>>(istream& in, vector<T>& a) {for(auto &x: a) in >> x; return in;};
template<class T, class H> istream& operator>>(istream& in, pair<H, T>& a) {in >> a.fi >> a.se; return in;};
template<class T> void read(T &x) {cin >> x;}
template<class H, class... T> void read(H &h, T &...t) { read(h); read(t...); }
//photo bronze but O(n)
void solve() {
    int n; cin >> n;
    vector<int> stor(n-1), diff(n), pref(n);
    for (int i = 0; i < n-1; i++) cin >> stor[i];
    
    //rewrite the answer array in terms of first two elements
    for (int i = 1; i < n-1; i++) {
        diff[i+1] = stor[i]-stor[i-1];
        pref[i+1] = diff[i+1] + pref[i-1];
    }
    
    vector<int> even(n), odd(n);
    //assume 1 is at even index
    int mn = 0;
    for (int i = 0; i < n-1; i += 2) 
        mn = min(mn, pref[i]);

    even[0] = 1-mn; even[1] = stor[0]-even[0];
    for (int i = 2; i < n; i++) 
        even[i] = even[i-2] + diff[i];

    //assume 1 is at odd index
    mn = 0;
    for (int i = 1; i < n-1; i += 2) 
        mn = min(mn, pref[i]);
    
    odd[1] = 1-mn; odd[0] = stor[0]-odd[1];
    for (int i = 2; i < n; i++) 
        odd[i] = odd[i-2] + diff[i];
    //check if valid and find lexicographically smallest
    vector<vector<int>> temp = {odd,even};
    sort(all(temp));

    vector<int> copy = temp[0];
    sort(all(copy));
    copy.erase(unique(all(copy)), copy.end());
    for (int i = 0; i < n-1; i++) {
        if (copy.size() == n) cout << temp[0][i] << ' ';
        else cout << temp[1][i] << ' ';
    }
    if (copy.size() == n) cout << temp[0].back();
    else cout << temp[1].back();
}
signed main() {
    #ifdef LOCAL
    freopen("in.txt","r",stdin);
    freopen("out.txt","w",stdout);
    #else
    ios_base::sync_with_stdio(0); cin.tie(0);
    freopen("photo.in","r",stdin);
    freopen("photo.out","w",stdout);
    #endif
    int t = 1;
    //cin >> t;
    while (t--) {
        solve();
    }
}
