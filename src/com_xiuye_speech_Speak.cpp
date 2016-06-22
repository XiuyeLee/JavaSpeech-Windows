#define _USING_V110_SDK71_
#include "com_xiuye_speech_Speak.h"
#include<sphelper.h>
#include<iostream>
using namespace std;
ISpVoice *pSpVoice = NULL;
/*
 * Class:     com_xiuye_speech_Speak
 * Method:    coInitialize
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_coInitialize
(JNIEnv *, jobject) {

	if(FAILED(CoInitialize(NULL))){
		cout << "Failed to initialize COM!" << endl;
		return;
	}

	if(FAILED(CoCreateInstance(CLSID_SpVoice,NULL,CLSCTX_ALL/*CLSCTX_INPROC_SERVER*/,IID_ISpVoice,(void**)&pSpVoice))) {
		cout << "Failed to create instance of ISpVoice!" << endl;
		return;
	}

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    speak
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_speak
(JNIEnv *env, jobject, jstring jstr) {

//	const char * words1 = env->GetStringUTFChars(jstr,0);
//	cout << words1 << endl;
//	env->ReleaseStringUTFChars(jstr,words1);
	const jchar * words = env->GetStringChars(jstr,0);

//	cout << CLSID_SpVoice << endl;
//	cout << CLSCTX_INPROC_SERVER << endl;
//	cout << IID_ISpVoice << endl;

	pSpVoice->Speak((LPCWSTR)words,SPF_DEFAULT,NULL);//即使字符编码也不同，但是说的字（或者单词）的字音是正确的。



	env->ReleaseStringChars(jstr,words);

	//wcout.imbue(locale(""));//直接就可以了不要使用wcout

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    unCoinitialize
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_coUninitialize
(JNIEnv *, jobject) {

	pSpVoice->Release();
	CoUninitialize();
}

