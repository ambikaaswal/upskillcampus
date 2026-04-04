Multi-Client Service Marketplace Platform
Project Overview

This project is a Multi-Client Service Marketplace Platform developed as part of an industrial internship. The platform allows users to browse and book services, while service providers can manage and offer their services.

The application is built using Java (Servlets & JSP), JDBC, and MySQL, following the MVC (Model-View-Controller) architecture.

Features
👤 User Registration & Login
🔐 Authentication & Session Management
📋 View Available Services
📅 Book Services
🛠️ Service Management (Provider Side)
💾 Database Integration using JDBC


Tech Stack
Backend: Java Servlets
Frontend: JSP
Database: MySQL
Server: Apache Tomcat
Architecture: MVC
📂 Project Structure
upskillcampus/
│
├── src/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   └── util/
│
├── webapp/
│   ├── views/
│   └── WEB-INF/
│
├── lib/                  # Required JAR files
├── README.md
└── MuliclientServiceMarketplacePlatform_AmbikaAswal_USC_UCT.pdf

For admin: password: Market@Place and name shall be admin

⚙️ Setup Instructions
1️⃣ Clone Repository
git clone https://github.com/ambikaaswal/upskillcampus.git

2️⃣ Import Project
Open in VS Code / Eclipse
Configure Apache Tomcat Server

3️⃣ Database Setup
Open MySQL / phpMyAdmin
Create database:
CREATE DATABASE marketplace;
Create required tables (users, services, bookings)
4️⃣ Configure Database Connection

Go to:

src/util/DBConnection.java

Update:

String url = "jdbc:mysql://localhost:3306/marketplace";
String user = "root";
String password = "";

Note: 
     The database password is set to "". 
     Please update it according to your local MySQL configuration before running the project.

5️⃣ Run Project
Deploy on Apache Tomcat

To compile code on local system vscode:
go to src
javac -cp ".;..\lib\*;C:\tomcat\apache-tomcat-10.1.52\lib\*" -d ..\webapp\WEB-INF\classes controller\*.java dao\*.java model\*.java util\*.java

Open browser:
http://localhost:8080/your-project-name

📊 System Architecture

The application follows MVC Architecture:

Model: DAO + Database
View: JSP Pages
Controller: Servlets

Flow:

User → JSP → Servlet → DAO → Database
📄 Report

📥 View Project Report

📌 Notes
Compiled .class files are excluded using .gitignore
Database runs on localhost
JAR files are included in /lib for easy setup
🔮 Future Enhancements
💳 Payment Gateway Integration
🔔 Real-time Notifications
📱 Mobile Application
🤖 AI-based Recommendations
🎨 Improved UI (React)

Acknowledgment
This project was developed as part of an internship under Upskill Campus and UniConverge Technologies (UCT). I would like to thank my mentors and peers for their guidance and support.

Author

Ambika Aswal
Industrial Internship Project