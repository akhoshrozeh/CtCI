#include <iostream>

using namespace std;

void m_reverse(char* str);

int main(int argc, char* argv[]) {

	if(argc <= 1) return 0;
	char* str = argv[1];
	cout << "You entered: " << str << endl;
	m_reverse(str);
	cout << "After m_reverse(): " << str << endl;
	return 0;
}

void m_reverse(char* str) {
	if(!str) return;
	char* end = str;
	

	// find the end of the str then go back since it points to terminating char
	while(*end) {
		end++;
	}
	end--;

	char temp;
	while(end != str && end > str) {
		temp = *str;
		*str = *end;
		*end = temp;
		str++;
		end--;
	}
	


}