// IMyAidlInterface.aidl
package com.whc.myapplication;
parcelable User;
// Declare any non-default types here with import statements

interface IMyAidlInterface {
   void sayHello(String t,int i,in User user);
   int getUserAge(in User user);
   void download(String url);
}