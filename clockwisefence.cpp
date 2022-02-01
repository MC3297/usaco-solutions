
#include <iostream>
using namespace std;
#include <bits/stdc++.h>
int turns(char a, char b) {
	if (a == 'N' && b == 'W') {return 0;} //turn left
	if (a == 'N' && b == 'E') {return 1;} //turn right
	if (a == 'S' && b == 'E') {return 0;} //turn left
	if (a == 'S' && b == 'W') {return 1;} //turn right
	if (a == 'E' && b == 'N') {return 0;} //turn left
	if (a == 'E' && b == 'S') {return 1;} //turn right
	if (a == 'W' && b == 'S') {return 0;} //turn left
	if (a == 'W' && b == 'N') {return 1;} //turn right
	return -1;
}
main() {
	ios_base::sync_with_stdio(0); cin.tie(0);
	int a;

	cin >> a;
	for (int i = 0; i < a; i++) {
		string s;
		cin >> s;
		int lefts = 0;
		int rights = 0;
		for (int j = 1; j < s.length(); j++) {
			if (turns(s.at(j-1), s.at(j)) == 1) {
				rights++;
			}
			else if (turns(s.at(j-1), s.at(j)) == 0) {
				lefts++;
			}
		}
		//cout << lefts << "\n";
		//cout << rights << "\n";
		if (lefts > rights) {
			cout << "CCW" << "\n";
		}
		else if (rights > lefts) {
			cout << "CW" << "\n";
		}
	}
}

