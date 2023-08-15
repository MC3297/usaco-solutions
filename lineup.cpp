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

//less bruteforce implementation
void solve() {
    map<string,int> id = {{"Beatrice",0}, {"Belinda",1}, {"Bella",2}, {"Bessie",3}, {"Betsy",4}, {"Blue",5}, {"Buttercup",6}, {"Sue",7}};
    vector<string> name = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
    
    vector<int> adj[8];
    int n; cin >> n;
    F0R(i,n) {
        int a,b;
        F0R(j,6) {
            string s; cin >> s;
            if (j == 0) a = id[s];
            if (j == 5) b = id[s];
        }
        adj[a].pb(b);
        adj[b].pb(a);
    }
    vector<int> ans;
    bool vis[8]{};
    F0R(i,8) {
        if (vis[i]) continue;
        if (sz(adj[i]) == 0) {
            vis[i] = 1;
            ans.pb(i);
            continue;
        }
        else if (sz(adj[i]) == 1) {
            vis[i] = 1;
            int cur = adj[i][0];
            ans.pb(i);
            while (sz(adj[cur]) > 1) {//sz is <= 2
                vis[cur] = 1;
                for (int j: adj[cur]) if (!vis[j]) {
                    vis[j] = 1;
                    ans.pb(cur);
                    cur = j;
                    break;
                }
            }
            ans.pb(cur);
            vis[cur] = 1;
        }
    }
    for (int i: ans) cout << name[i] << '\n';
}
signed main() {
    freopen("lineup.in","r",stdin);
    freopen("lineup.out","w",stdout);
    #ifdef LOCAL
    freopen("in.txt","r",stdin);
    freopen("out.txt","w",stdout);
    #else
    ios_base::sync_with_stdio(0); cin.tie(0);
    #endif
    int t = 1;
    //cin >> t;
    while (t--) {
        solve();
    }
}