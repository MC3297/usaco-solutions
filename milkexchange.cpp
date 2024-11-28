#pragma region
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
#define int ll
using pii = pair<int,int>;
#ifndef LOCAL
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target("avx2,bmi,bmi2,lzcnt,popcnt")
#define debug(...)
#endif
#define vt vector
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
#define printv(v,s,e) FOR(z,s,e+1) cout << v[z] << ' '; cout << '\n'
#define ir(...) int __VA_ARGS__; re(__VA_ARGS__);
#define cmp(x,y) [&](auto&aa,auto&bb){return x aa y<x bb y;}
template<class T> using min_priority_queue = priority_queue<T, vector<T>, greater<T>>;
template<class T, class H> istream& operator>>(istream& in, pair<H, T>& a) {in >> a.fi >> a.se; return in;};
template<typename T> istream& operator>>(istream& in, vector<T>& a) {for(auto &x: a) in >> x; return in;};
template<class T> void re(T &x) {cin >> x;}
template<class H, class... T> void re(H &h, T &...t) { re(h); re(t...); }
template<class T> void pr(T &x) {cout << (x) << '\n';}
template<class H, class... T> void pr(H &h, T &...t) { cout << (h) << ' '; pr(t...); }
#pragma endregion

int parse(vt<int>& v, string& sub, int m) {
    int tmp = m;
    F0R(i,sz(v)-1) {
        if (sub[i+1] == 'L') {
            break;
        }
        int mn = min(m, v[i]);
        v[i] -= mn;
        m -= mn;
    }
    
    m = tmp;
    ROF(i,1,sz(v)) {
        if (sub[i-1] == 'R') break;
        int mn = min(m, v[i]);
        v[i] -= mn;
        m -= mn;
    }
    
    int sum = 0;
    for (int i: v) sum += i;
    return sum;
}
void solve() {
    ir(n,m);
    string tmps; re(tmps);
    vt<int> tmpa(n); re(tmpa);
    
    string s = "";
    vt<int> a(n);
    int ind = -1;
    F0R(i,n) {
        if (tmps[i] == 'L' && tmps[(i+1)%n] == 'R') {
            ind = i+1;
            break;
        }
    }
    if (ind == -1) {
        cout << accumulate(all(tmpa), 0) << '\n';
        return;
    }
    F0R(i,n) {
        a[i] = tmpa[(i+ind)%n];
        s += tmps[(i+ind)%n];
    }
    debug(a);
    debug(s);
    
    vt<int> v;
    string sub = "";
    int ans = 0;
    F0R(i,n) {
        v.pb(a[i]);
        sub += s[i];
        if (s[i] == 'L' && i+1 < n && s[i+1] == 'R') {
            ans += parse(v, sub, m);
            v.clear();
            sub = "";
        }
    }
    ans += parse(v, sub, m);
    pr(ans);
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