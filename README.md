# 📚 Attendance Tracker

A simple Android application built with **Kotlin** and **Jetpack Compose** that helps college students manage their weekly class schedule and mark attendance. The app provides an intuitive interface for viewing daily classes and editing the weekly timetable.

---

## ✨ Features

- 📅 View today's scheduled classes
- ✅ Mark each class as Present or Absent
- 📝 Weekly schedule editor
- ➕ Add new subjects to any day
- 🗑️ Delete subjects from the timetable
- 🎨 Modern UI built using Jetpack Compose
- ⚡ Lightweight and easy to customize

---

## 📱 Screens

### Today's Classes
- Displays all classes scheduled for the current day.
- Mark attendance using a single button.
- Attendance status changes instantly.

### Edit Schedule
- View the timetable for every weekday.
- Add new subjects.
- Delete existing subjects.
- Changes are reflected immediately in the app.

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose
- **Architecture:** Single Activity Architecture
- **Design:** Material 3
- **Build System:** Gradle (Kotlin DSL)
- **IDE:** Android Studio

---

## 📂 Project Structure

```
AttendanceTracker/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/attendancetracker/
│   │   │   │       ├── MainActivity.kt
│   │   │   │       └── ui/theme/
│   │   │   ├── AndroidManifest.xml
│   │   │   └── res/
│   └── build.gradle.kts
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or newer
- JDK 17+
- Android SDK

---

### Installation

Clone the repository

```bash
git clone https://github.com/your-username/AttendanceTracker.git
```

Navigate to the project

```bash
cd AttendanceTracker
```

Open the project in **Android Studio**.

Allow Gradle to sync.

Run the application on an emulator or physical Android device.

---

## 📖 Usage

1. Launch the application.
2. Open the **Today's Classes** tab.
3. Mark each class as **Present** or **Absent**.
4. Switch to **Edit Schedule**.
5. Add or remove subjects for any weekday.
6. Return to Today's Classes to view the updated schedule.

---

## 🎯 Current Features

- Weekly timetable
- Attendance marking
- Add new subjects
- Delete subjects
- Compose UI
- Material Design 3

---

## 🚧 Future Improvements

- Room Database integration for persistent storage
- Automatic day detection using device calendar
- Attendance percentage calculation
- Monthly attendance reports
- Subject-wise statistics
- Notifications for upcoming classes
- Dark mode support
- Backup & Restore
- Export attendance to PDF/Excel
- Cloud synchronization

---

## 📸 Screenshots

Add screenshots here after running the application.

```
screenshots/
├── home.png
├── attendance.png
└── schedule_editor.png
```

---

## 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a feature branch.

```bash
git checkout -b feature-name
```

3. Commit your changes.

```bash
git commit -m "Added new feature"
```

4. Push the branch.

```bash
git push origin feature-name
```

5. Open a Pull Request.

---

## 💡 Learning Objectives

This project demonstrates:

- Kotlin programming
- Jetpack Compose UI development
- State management using `remember`
- Mutable state lists
- Material 3 components
- LazyColumn
- Composable functions
- Android project structure

---

## 📌 Known Limitations

- Attendance is not saved after closing the app.
- Current day is hardcoded.
- No database integration.
- No authentication.
- No attendance analytics.

---

## 📄 License

This project is licensed under the MIT License.

---

## 👨‍💻 Author

**Ashutosh Kumar**

GitHub: https://github.com/your-github-username

---

### ⭐ If you found this project useful, consider giving it a Star on GitHub!