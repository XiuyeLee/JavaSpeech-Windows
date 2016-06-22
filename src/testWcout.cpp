#pragma execution_character_set("GBK")
#include<windows.h>
#include<iostream>
using namespace std;

int main(){

	//setlocale(LC_ALL,"zh_CN.UTF-8");//乱码
	wchar_t *s = L"发生";
	cout << "发生" << endl;
	int n = WideCharToMultiByte(CP_UTF8,0,(LPCWSTR)s,-1,NULL,0,NULL,NULL);

	cout << n << endl;
	char *s1 = new char[n];
	memset(s1,0,n+1);
	int size = WideCharToMultiByte(CP_ACP,0,(LPCWSTR)s,-1,s1,n+1,NULL,NULL);
	if(size <=0){
		cout << "failed" << endl;
	}
	else{
		cout << s1 << endl;
		cout << size << endl;
	}


//	wcout.imbue(locale(""));
//	wcout << s << endl;
}
