#pragma region
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define int ll
using pii = pair<int,int>;
#define vt vector
#ifndef LOCAL
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")
#define debug(...)
#endif
#define fi first
#define se second
#define pb push_back 
#define lb lower_bound
#define ub upper_bound
#define sz(x) (int)(x).size()
#define all(v) v.begin(), v.end()
#define rall(v) v.rbegin(), v.rend()
#define YES cout << "YES" << '\n'
#define NO cout << "NO" << '\n'
#define IMP cout << "IMPOSSIBLE" << '\n'
#define FOR(i,s,e) for (int i = (s); i < (e); ++i) 
#define F0R(i,e) FOR(i,0,e) 
#define ROF(i,s,e) for (int i = (e)-1; i >= (s); --i) 
#define R0F(i,e) ROF(i,0,e) 
#define printv(v,s,e) FOR(i,s,e+1) cout << v[i] << ' '; cout << '\n'
#define re(...) int __VA_ARGS__; read(__VA_ARGS__);
template<class T> using min_priority_queue = priority_queue<T, vector<T>, greater<T>>;
template<class T, class H> istream& operator>>(istream& in, pair<H, T>& a) {in >> a.fi >> a.se; return in;};
template<typename T> istream& operator>>(istream& in, vector<T>& a) {for(auto &x: a) in >> x; return in;};
template<class T> void read(T &x) {cin >> x;}
template<class H, class... T> void read(H &h, T &...t) { read(h); read(t...); }
#pragma endregion

int sgn(int n) {
    if (n>0) return 1;
    if (n<0) return -1;
    return 0;
}
void solve() {
    re(n);
    vector<int> stor(n);
    read(stor);
    F0R(i,n) {
        re(x);
        stor[i] -= x;
    }

    int cur = 0;
    vector<pii> ranges;
    F0R(i,n-1) {
        if (sgn(stor[i]) != sgn(stor[i+1])) {
            ranges.pb({cur,i+1});
            cur = i+1;
        }
    }
    ranges.pb({cur,n});

    int ans = 0;
    for (auto [l,r]: ranges) {
        int sign = sgn(stor[l]);
        FOR(i,l,r) stor[i] *= sign;

        int add = stor[l], mn = stor[l];
        FOR(i,l+1,r) {
            if (stor[i-1] < stor[i]) {
                add += stor[i] - stor[i-1];
            }
            mn = min(mn, stor[i]);
        }
        ans += add;
    }
    cout << ans << '\n';
}
signed main() {
    #ifdef LOCAL
    freopen("txt.in","r",stdin);
    freopen("txt.out","w",stdout);
    #else
    ios_base::sync_with_stdio(0); cin.tie(0);
    #endif
    int t = 1;
    //cin >> t;
    while (t--) {
        solve();
    }
}