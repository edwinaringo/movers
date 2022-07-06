# 🚚 MOVERS

[![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](#)
[![GitHub Forks](https://img.shields.io/github/forks/edwinaringo/movers.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/edwinaringo/movers/fork)
[![GitHub Issues](https://img.shields.io/github/issues/edwinaringo/movers.svg?style=flat&label=Issues&maxAge=2592000)](https://github.com/edwinaringo/movers/issues)
[![contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg?style=flat&label=Contributions&colorA=red&colorB=black	)](#)

## Project Description
Movers is an android  moving app help app lets you compare local moving companies to find the best fit for you.

It is designed to help on scheduling and booking household moving and delivery. Users can get help with furniture delivery, large item moving, labor needs, and more from vetted, independent pickup truck owners.

The notable thing about Movers is that the quotes are guarantees; no estimates, just accurate quotes of the exact figure you can expect to pay your moving company.If you’ve been burned by an inaccurate moving quote in the past, this guarantee should put your mind at ease for a less-stressful move.

---
## 👨🏼‍💻 Contributors
It was really fun to work with these awesome geeks to get the job done:

* [Sheila Sharon](https://github.com/DevSheila)
* [Edwin Aringo](https://github.com/edwinaringo)
* [Habib Abdul](https://github.com/Habib001-coder)
* [Jeremiah Ogutu](https://github.com/Jeremiah-ogutu)
* [Dian](https://github.com/diana3664)
* [Collins Boit](https://github.com/l00pinfinity)


---
## User Classes and Characteristics
There are **two** types of users for our system.

### 1. Customer Class
Customers interact with our system directly in order to place moving request, modify request, get bill and give feedback.
Customers enters their details and requirements.They choose their current location and final destination from map.Customer gets matched with helper.Alternatively they can select their own helpers.Full price is quoted to customer.Booking is the next step.If successful, customer and helpers/movers and talk and track goods in real time.Once all this steps are done,the customer can pay, tip and review
### 2. Movers  Class
Movers interact with our system directly in order to set up their account details, their services rates,terms and conditions.

On setting up this information movers/helpers can view requests made to them by customers and also approve or decline requests.


## Demo


https://user-images.githubusercontent.com/70254321/177591169-23432faf-fae2-4168-8e04-8a730b2acf4c.mp4


Watch full demo:(https://github.com/edwinaringo/movers/blob/development/Demo/movers-demo.mp4
## Figma
https://www.figma.com/file/mPpxZKJavqf6yGPPPlNGx3/Untitled?node-id=0%3A1

## Technologies
1. Android
1. Java
1. Junit
1. Gradle
1. xml
1. Google maps API
1. Firebase

Libraries used include:
```

    implementation 'androidx.appcompat:appcompat:1.3.1'
    implementation 'com.google.android.material:material:1.4.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    implementation 'com.google.android.libraries.places:places:2.4.0'
    implementation 'com.google.android.gms:play-services-maps:17.0.1'

    implementation 'androidx.legacy:legacy-support-v4:1.0.0'

    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation platform('com.google.firebase:firebase-bom:28.3.0')
    implementation 'com.google.firebase:firebase-analytics'
    implementation 'com.google.firebase:firebase-database'
    implementation 'com.google.firebase:firebase-auth:21.0.1'
    //piccaso
    implementation 'com.squareup.picasso:picasso:2.71828'
    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.5.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
    //okhttp
    implementation 'com.squareup.okhttp3:logging-interceptor:3.6.0'
    implementation 'com.squareup.okhttp3:okhttp:3.6.0'
    // Parceler
    implementation 'org.parceler:parceler-api:1.1.12'
    annotationProcessor 'org.parceler:parceler:1.1.12'

    //for butterknife
    implementation 'com.jakewharton:butterknife:10.2.0'
    annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.0'
    implementation 'pl.droidsonroids.gif:android-gif-drawable:1.2.19'
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
    //yoyo library
    implementation 'com.daimajia.androidanimations:library:2.4@aar'

    //card view
    implementation 'androidx.cardview:cardview:1.0.0'

    //navigation
    implementation "androidx.constraintlayout:constraintlayout:2.1.0"
    implementation 'com.etebarian:meow-bottom-navigation:1.0.4'
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.61"
```

For testing, the following libraries were used:

```
androidTestImplementation 'androidx.test.ext:junit:1.1.1'
androidTestImplementation 'androidx.test:rules:1.2.0'
androidTestImplementation 'androidx.test🏃1.2.0'
androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
testImplementation 'org.robolectric:robolectric:4.3.1'

```


## Setup
### Prerequisites
You will need to have
1. JRE & JDK
1. SDK
1. Gradle
1. Junit
1. Spark
1. Android Studio
1. PostreSQL


## How to Run

In order to have a look at the code files and understand the working, simply download this repository and open Android Studio and browse to the downloaded project and open it. It will load the project files and the code will be ready to run.

Before running application,got to  [Movers API repository](https://github.com/DevSheila/MoversAPI) repository,download it to your local directory or clone it.Follow API's instructions as  as indicated in the repository.Once done, use [ngrok application](https://ngrok.com/download) to run the API locally.Replace constant MOVERS_API_BASE_URL  in [constant class](https://github.com/edwinaringo/movers/blob/development/app/src/main/java/com/example/movers_app/Constants.java) with the acquired link from running ngrok application.You will now have a working API for the app.Login to Android Studio and can  the project.


## Contributions Welcome
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](#)

If you find any bug in the code or have any improvements in mind then feel free to generate a pull request.

## Issues
[![GitHub Issues](https://img.shields.io/github/issues/edwinaringo/movers.svg?style=flat&label=Issues&maxAge=2592000)](https://www.github.com/harismuneer/Restaurant-Management-System/issues)

If you face any issue, you can create a new issue in the Issues Tab and we  will be glad to help you out.
## License
[![MIT](https://img.shields.io/cocoapods/l/AFNetworking.svg?style=style&label=License&maxAge=2592000)](../master/LICENSE)




