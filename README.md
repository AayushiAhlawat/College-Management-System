# 🎓 College Management System (CMS) 🏫

## Overview ℹ️
The College Management System (CMS) is a Java-based desktop application designed to streamline administrative tasks and manage various activities within a college or university. It provides functionalities for maintaining student information, faculty details, course offerings, attendance records, examination marks, and more.

## Features 🚀
- **Login System**: Allows users with different roles (admin, faculty, student) to log in and access their respective functionalities.
- **Student Management**: Enables administrators to manage student records, including admission details, personal information, and academic performance.
- **Faculty Management**: Facilitates the management of faculty members, their profiles, courses taught, and other relevant information.
- **Attendance Management**: Allows for the tracking of student attendance in various courses and generates reports for monitoring.
- **Examination Management**: Manages examination schedules, marks entry, grade calculation, and result generation.
- **Library Management**: Provides functionalities for managing library resources, book borrowing, and returning.
- **Accounting**: Tracks financial transactions, fee payments, and generates financial reports.
- **User-friendly Interface**: Utilizes Java Swing for developing a user-friendly and intuitive graphical user interface (GUI).

## Prerequisites 🛠️
- JDK and JRE 8 or higher installed on the system.
- MySQL database server installed and configured.
- Required JAR files added to the project classpath:
  - AbsoluteLayout-RELEASE120.jar
  - jcalendar-1.4.jar
  - mysql-connector-java-5.1.15-bin.jar
  - rs2xml.jar

## Installation and Setup 🛠️
1. Clone or download the project repository from [GitHub link] (<https://github.com/AayushiAhlawat/College-Management-System.git>).
2. Install JDK and JRE 8 on your system.
3. Install and configure MySQL database server.
4. Import the project into your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
5. Add the required JAR files to the project classpath.
6. Configure the database connection settings in `Util/Util.java`.
7. Execute the `Util/Database.java` file to create necessary tables in the database.
8. Update college settings, user accounts, and permissions as required.
9. Run the project using the `Login.java` file to start the application.

## Usage 📘
- Upon launching the application, users can log in with their credentials.
- Admins can manage student and faculty records, conduct examinations, manage library resources, and handle financial transactions.
- Faculty members can view student details, mark attendance, enter examination marks, and perform other academic tasks.
- Students can access their personal information, view course schedules, check examination results, and utilize library services.

## Contribution 🤝
Contributions are welcome! If you'd like to contribute to the development of the College Management System, feel free to fork the repository, make your changes, and submit a pull request. You can contribute by adding new features, fixing bugs, improving documentation, or suggesting enhancements. Together, we can make the CMS even better for educational institutions!
