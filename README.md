# 🚀 MVI Login Screen with Retrofit and Jetpack Compose

This project demonstrates a simple **Login Screen** built using the **Model-View-Intent (MVI)** architecture in **Jetpack Compose**, integrated with a REST API using **Retrofit**.

## 📱 Features

- Jetpack Compose UI
- MVI Architecture:
  - `Intent` for user actions
  - `State` for screen state
  - `ViewModel` as state processor
- Retrofit API integration for login
- Displays success/error messages based on API response
- Custom `TextField` styling with no underline and custom background

---

## 🧱 Project Structure

├── model
│ ├── LoginIntent.kt # Defines user actions (Intents)
│ ├── LoginState.kt # Represents screen state
│ ├── LoginRequest.kt # API request data class
├── retrofitApi
│ ├── AuthApi.kt # Retrofit interface
│ ├── RetrofitInstance.kt # Retrofit singleton
├── view
│ ├── LoginScreen.kt # Jetpack Compose UI
├── viewmodel
│ ├── LoginViewModel.kt # Handles business logic and emits state

## 🧪 API Format

### Request JSON

{"expiresInMins":30,"username":"emilys","password":"emilyspass"}

### Add Dependencies

// Compose

implementation "androidx.compose.ui:ui:<latest>"

implementation "androidx.lifecycle:lifecycle-viewmodel-compose:<latest>"

// Retrofit

implementation "com.squareup.retrofit2:retrofit:2.9.0"

implementation "com.squareup.retrofit2:converter-gson:2.9.0"

implementation "com.squareup.okhttp3:logging-interceptor:4.9.3"

💡 Usage

Enter your email and password in the respective fields.

Press the Login button.

If credentials are valid:

✅ "Login Successful" is shown.

If invalid:

❌ Error message is displayed.

🎨 Custom TextField Styling

Rounded corners

No underline

Optional gradient or shadow background using Box wrapper

🔒 Notes

This example assumes a test login API. You should handle real tokens securely (e.g., via DataStore).

To extend this, add proper navigation after login and store tokens securely.

🙋 Need Help?

Open an issue or contact the author.
