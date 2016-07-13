# Gtemplate

Dagger + mvp + rxjava template for new things

injector + base activity + base presenter

  # Libraries 

   // Dagger
    apt 'com.google.dagger:dagger-compiler:2.0.2'
    compile 'com.google.dagger:dagger:2.0.2'
    provided 'org.glassfish:javax.annotation:10.0-b28'

    // Lombok
    provided 'org.projectlombok:lombok:1.12.6'
    apt "org.projectlombok:lombok:1.12.6"

    // view binding
    apt 'com.jakewharton:butterknife-compiler:8.1.0'

    //android
    compile 'com.android.support:appcompat-v7:24.0.0'
    compile 'com.android.support:design:24.0.0'
    compile 'com.android.support:support-v4:24.0.0'
    compile 'com.android.support:support-annotations:24.0.0'
    compile 'com.android.support:recyclerview-v7:24.0.0'
    compile 'com.android.support:cardview-v7:24.0.0'
    compile 'com.android.support:design:24.0.0'

    //retrofit
    compile 'com.squareup.retrofit2:retrofit:2.0.2'
    compile 'com.squareup.retrofit2:converter-gson:2.0.2'
    compile 'com.squareup.retrofit2:adapter-rxjava:2.0.2'

    //glide
    compile 'com.github.bumptech.glide:glide:3.6.1'

    //logging
    compile 'org.slf4j:slf4j-android:1.7.7'
    compile 'com.squareup.okhttp3:okhttp:3.3.1'
    compile 'com.squareup.okhttp3:logging-interceptor:3.3.1'

    //rx
    compile 'io.reactivex:rxandroid:1.1.0'

    //material component
    compile 'com.afollestad.material-dialogs:core:0.8.6.0'

    //test
    testApt 'com.google.dagger:dagger-compiler:2.0.2'
    testCompile 'junit:junit:4.12'
    testCompile 'org.mockito:mockito-core:1.10.19'
    testCompile 'org.hamcrest:hamcrest-library:1.3'
    testCompile 'org.robolectric:robolectric:3.0-rc3'
    testCompile 'org.robolectric:shadows-support-v4:3.0'
    testCompile 'org.robolectric:shadows-multidex:3.0'
    testCompile 'com.squareup.assertj:assertj-android:1.1.1'
    testCompile 'com.annimon:stream:1.1.0'
    testCompile 'junit:junit:4.12'