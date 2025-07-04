# OpenCV Android Kotlin C++ App

This project demonstrates how to integrate **OpenCV** into an **Android app** using **Kotlin** and **native C++ (NDK)** code. It's designed for developers seeking to combine computer vision capabilities with Android native performance.

---

## Features

- Uses **OpenCV 4.11.0** via Gradle dependency
- Kotlin-based Android application
- Native C++ integration with the Android NDK
- ViewBinding-enabled UI
- CMake-based build configuration

---

## Project Structure

- `java/com.example.andsdk/`: Kotlin source files
- `cpp/`: C++ native code for performance-critical operations
- `jniLibs/`: (Optional) Custom native `.so` libraries, if not using Maven OpenCV
- `CMakeLists.txt`: CMake build configuration for native code
- `res/`: Layouts and UI resources
- `build.gradle.kts`: App module Gradle configuration

---

## Getting Started

### Prerequisites

- Android Studio (Giraffe or newer recommended)
- Android NDK (r25+)
- OpenCV 4.11.0 or higher
- Gradle 8+

### Setup Instructions

1. Clone this repository
2. Open in Android Studio
3. Let Gradle sync dependencies
4. Build and run on an Android device or emulator (API 24+)

---

## OpenCV Initialization

Make sure to initialize OpenCV before using any OpenCV APIs. This is typically done using `OpenCVLoader.initDebug()` in the main activity.

---

## Native C++ Integration

The native C++ code is compiled with CMake. The Kotlin code calls native functions declared using the `external` keyword. The native library is loaded using `System.loadLibrary()`.

---

## ViewBinding Support

ViewBinding is enabled to simplify UI interactions. All layout files are automatically bound to their corresponding Kotlin classes.

---

## Proguard Rules (Optional)

To avoid issues when minifying your app in release builds, consider adding the following Proguard rules:

```
-keep class org.opencv.** { *; }
-dontwarn org.opencv.**
```

---

## Testing

Unit and instrumentation test templates are included. Run tests with:

- `./gradlew test`
- `./gradlew connectedAndroidTest`

---

## License

This project is licensed under the MIT License.

---

## Notes

- Ensure OpenCV dependencies are fully resolved before building.
- Native `.so` libraries are automatically packaged by the OpenCV Gradle dependency.
- Avoid mixing OpenCV Gradle and manual `.so` inclusion unless necessary.

---

For contributions, bug reports, or feature requests, feel free to open an issue or submit a pull request.

