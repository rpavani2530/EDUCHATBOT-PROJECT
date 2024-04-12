MainActivity. java
package com.educhat.kommu;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.content.Context;
import com.applozic.mobicommons.commons.core.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import io.kommunicate.KmChatBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;
public class MainActivity extends AppCompatActivity {
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 Kommunicate.init(this,"2e72222be2482309322b1906917ab6c57");
 List<String> botList = new ArrayList(); botList.add("educhat-qogkn"); //enter
your integrated bot Ids
 new KmChatBuilder(this).setChatName("EduChat")
 .setBotIds(botList)
 .launchChat(new KmCallback() {
 @Override
public void onSuccess(Object message) {
 Utils.printLog(MainActivity.this, "ChatTest", "Success : " +
message);
 }
 12
 @Override
public void onFailure(Object error) {
 Utils.printLog(MainActivity.this, "ChatTest", "Failure : " +
error);
 }
 });
 }
 @Override
 protected void onStop() {
 super.onStop();
 setContentView(R.layout.activity_main);
 }
}
build.gradle file
apply plugin: 'com.android.application'
android {
 compileSdkVersion 28
 buildToolsVersion "29.0.2"
 defaultConfig {
 applicationId "com.educhat.kommu"
 minSdkVersion 19
 targetSdkVersion 28
 versionCode 1
 versionName "1.0"
 testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
 }
 buildTypes {
 release {
 minifyEnabled false
 proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'),
'proguard-rules.pro'
 }
 }
}
dependencies {
 implementation fileTree(dir: 'libs', include: ['*.jar'])
 implementation 'androidx.appcompat:appcompat:1.1.0'
 implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
 testImplementation 'junit:junit:4.12'
 androidTestImplementation 'androidx.test.ext:junit:1.1.1'
 androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
 implementation 'io.kommunicate:kommunicate:1.8.4'
}
 13
A few raw responses:
{
 "responseId": "1863490d-8467-4191-96ac-7e2bed170bab-9cc28bb4",
 "queryResult": {
 "queryText": "hi",
 "action": "input.welcome",
 "parameters": {},
 "allRequiredParamsPresent": true,
 "fulfillmentText": "Hi! This is your EduGuru speaking.I am here to help you out with your
difficulties in selecting a stream after your 10th or Inter.",
 "fulfillmentMessages": [
 {
 "text": {
 "text": [
 "Hi! This is your EduGuru speaking.I am here to help you out with your difficulties in
selecting a stream after your 10th or Inter."
 ]
 }
 },
 {
 "text": {
 "text": [
 "tell me your interests or favorite subjects so that I can suggest you a stream or ask me
about any career you want to know about."
 ]
 }
 },
 {
 "text": {
 "text": [
 "no worries EduGuru is here."
 ]
 }
 }
-----------------
{
 "responseId": "97c4251c-390c-4479-9f3c-ebdc63610b5b-9cc28bb4",
 "queryResult": {
 "queryText": "tell me about hotel management",
 "parameters": {},
 "allRequiredParamsPresent": true,
 "fulfillmentText": "Hotel management is also a job oriented course. It can easily land you a job
if you complete this course successfully.Usually duration of the course is just 3 years after 10+2
 14
in arts and you can find a job in hospitality sector like Hotels and restaurants. You will be recruited
by small or big hotels according to your skills.",
 "fulfillmentMessages": [
 {
 "text": {
 "text": [
 "Hotel management is also a job oriented course. It can easily land you a job if you
complete this course successfully.Usually duration of the course is just 3 years after 10+2 in arts
and you can find a job in hospitality sector like Hotels and restaurants. You will be recruited by
small or big hotels according to your skills."
 ]
 }
 }
 ],
-------------
{
 "responseId": "fdc61595-9aff-4416-8cc3-9f4b6f394a49-9cc28bb4",
 "queryResult": {
 "queryText": "i don't like maths",
 "parameters": {
 "ScienceM_subjects_interestes": "mathematics"
 },
 "allRequiredParamsPresent": true,
 "fulfillmentText": "after 12th you can go for: Fashion Designing,Animation,Hotel
Management etc if you don't like maths. You can opt for arts in Inter.",
 "fulfillmentMessages": [
 {
 "text": {
 "text": [
 "after 12th you can go for: Fashion Designing,Animation,Hotel Management etc if you
don't like maths. You can opt for arts in Inter."
 ]
 }
 }
 ],
 "intent": {
 "name": "projects/eduguru-qmefub/agent/intents/ff1e1836-6faa-479d-a230-fd9d723e8ef1",
 "displayName": "dont_not_like_maths"
 },
 "intentDetectionConfidence": 0.5359055,
 "languageCode": "en"
 },
 "alternativeQueryResults": [
 {
 "queryText": "i dont like maths",
 "languageCode": "en"
 15
 }
 ]
} 