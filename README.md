# Run-and-Track
This application is a running tracking application based on modern Android tech-stacks and MVVM architecture.  
It allows users to track their running activities, displaying real-time routes on an interactive map while storing essential statistics using Room database.

__[APK Link](https://github.com/riteshpandey5102/Run-and-Track/blob/main/app-debug.apk)__

## Tech stack & Open-source libraries
- Kotlin based, Coroutines + Flow for asynchronous.
- Dagger Hilt for dependency injection.
- Jetpack
  - Lifecycle - dispose of observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Room Persistence - construct the database using the abstract layer.
- Architecture
  - MVVM Architecture
  - Repository pattern
- Glide - loading images.
- Timber - A logger with a small, extensible API.
- Material-Components - Material design components for building ripple animation, and CardView.
- Google Maps SDK - Track location and show current location user.
- EasyPermissions is a wrapper library to simplify basic system permissions logic when targeting Android M or higher.

#### Add google map api key to Android Manifest file in defined metadata field to integrate Google maps SDK
