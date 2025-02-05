#include <iostream>
using namespace std;

int gcd(int a, int b) {
	int c = a % b;
	while (c != 0) {
		a = b;
		b = c;
		c = a % b;
	}
	return b;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int num1, num2;

	cin >> num1 >> num2;
	cout << gcd(num1, num2) << "\n" << num1 * num2 / gcd(num1, num2);

}