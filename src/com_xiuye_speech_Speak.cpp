#define _USING_V110_SDK71_
#include "com_xiuye_speech_Speak.h"
#include<sphelper.h>
#include<iostream>
using namespace std;
ISpVoice *pSpVoice = NULL;
jint currentVoice = 1;

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    coInitialize
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_coInitialize
(JNIEnv *, jobject) {

	if(FAILED(CoInitialize(NULL))) {
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

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    setSpeed
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_setSpeed
(JNIEnv *env, jobject, jint speed) {

	if(pSpVoice == NULL)
	return;
	if(speed >= -10 && speed <=10)
	{
		pSpVoice->SetRate(speed);
	}
	else if(speed < -10) {
		pSpVoice->SetRate(-10);
	}
	else {
		pSpVoice->SetRate(10);
	}

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    getSpeed
 * Signature: ()V
 */
JNIEXPORT jint JNICALL Java_com_xiuye_speech_Speak_getSpeed(JNIEnv *, jobject) {

	if (pSpVoice == NULL)
		return -11;

	jint speed = 0;
	if (FAILED(pSpVoice->GetRate(&speed))) {
		return -11;
	}
	return speed;

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    pause
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_pause
(JNIEnv *, jobject) {
	pSpVoice->Pause();
}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    resume
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_resume
(JNIEnv *, jobject) {

	pSpVoice->Resume();

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    kindsOfVoice
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_xiuye_speech_Speak_kindsOfVoice(JNIEnv *,
		jobject) {

	CComPtr < IEnumSpObjectTokens > cpEnum;
	HRESULT hr = S_OK;
	hr = SpEnumTokens(SPCAT_VOICES, NULL, NULL, &cpEnum);
	if (FAILED(hr)) {
		return -1;
	}

	jint kindsOfVoice;
	hr = cpEnum->GetCount((ULONG*) &kindsOfVoice);
	if (FAILED(hr)) {
		return -2;
	}
	return kindsOfVoice;
}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    setVoice
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_setVoice
(JNIEnv *env, jobject obj, jint indexOfVoice) {

	CComPtr < ISpObjectToken > cpVoiceToken;
	CComPtr < IEnumSpObjectTokens > cpEnum;
	HRESULT hr = S_OK;
	hr = SpEnumTokens(SPCAT_VOICES, NULL, NULL, &cpEnum);
	if (FAILED(hr)) {
		return;
	}
	jint kindsOfVoice = Java_com_xiuye_speech_Speak_kindsOfVoice(env,obj);
	if(indexOfVoice > kindsOfVoice || kindsOfVoice <= 0) {
		indexOfVoice = 1;
	}
	for(int i = 0;i<indexOfVoice;i++) {
		cpVoiceToken.Release();
		hr = cpEnum->Next(1,&cpVoiceToken, NULL);
	}
	if (FAILED(hr)) {
		return;
	}
	pSpVoice->SetVoice(cpVoiceToken);
	currentVoice = indexOfVoice;

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    getVoice
 * Signature: ()V
 */
JNIEXPORT jint JNICALL Java_com_xiuye_speech_Speak_getVoice(JNIEnv *, jobject) {

	return currentVoice;

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    setVolume
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_xiuye_speech_Speak_setVolume
(JNIEnv *, jobject, jint size) {

	if(size < 0) {
		size = 0;
	}
	else if(size > 100) {
		size = 100;
	}
	pSpVoice->SetVolume(size);

}

/*
 * Class:     com_xiuye_speech_Speak
 * Method:    getVolume
 * Signature: ()V
 */
JNIEXPORT jint JNICALL Java_com_xiuye_speech_Speak_getVolume(JNIEnv *,
		jobject) {
	jint volume = 0;

	pSpVoice->GetVolume((USHORT*) &volume);

	return volume;
}

