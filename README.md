# 221501058MOBILE APPLICATION DEVELOPMENT-LAB

Android Installation and Setup:

Step 1: Install Android Studio

Download Android Studio from the official website: Android Studio Download.
Follow the installation instructions for your operating system (Windows, macOS, or Linux).
Once installed, open Android Studio and configure the SDK (Software Development Kit) based on your development preferences.
Ensure you have the necessary Android Virtual Device (AVD) or connect a physical Android device for testing.

Step 2: Create a New Android Project

Open Android Studio and select "New Project".
Choose "Empty View Activity" and click Next.
Enter your Application Name (e.g., "LoginApp") and ensure the language is set to Java.
Check the SDK version to ensure it is compatible with your development environment.
Click Finish to create the project.

Step 3: Access Project Files

Once the project is created, Android Studio will open the project structure.
Navigate to the following files:
activity_main.xml: Located in the res/layout folder, this file defines the UI layout for the login screen.
MainActivity.java: Located in the java folder, this file handles the logic for the login process.
Modify these files as needed to implement the login system.

Experiment 1:Login App
This experiment focuses on creating a login app with the following key features:

Key Features:
Credential Validation:
Ensures the correct username and password are entered.
Passwords are masked and validated (e.g., required minimum length, special characters).

Error Handling:
Provides clear feedback for incorrect login attempts (e.g., "Invalid Username or Password").
Limits the number of failed attempts and locks the account temporarily after several invalid attempts.

Session Management:
Manages user sessions with secure tokens, allowing persistent login until the session expires or the user logs out.

Password Security:
Passwords are hashed before storage to ensure security.

Account Lockout:
Temporarily locks the account after multiple failed login attempts.

Password Recovery:
A "Forgot Password" option allows users to reset their password via email.

How It Works:
Users log in with a username and password.
If credentials are correct, the user is redirected to the main app screen.
If incorrect, an error message is displayed, and after multiple failed attempts, the account is temporarily locked.
Users can recover their account by resetting their password through the Forgot Password feature.

Installation Clone this repository:

https://github.com/KavithaPooja/221501058MAD.git

bash Copy code git clone Navigate to the project directory:

bash Copy code cd mobile-app-experiments-lab Install dependencies:

bash Copy code npm install Run the application:

bash Copy code npm start Usage Once the application is running, you can explore the different experiments by navigating through the menu. Each feature is designed to be intuitive, with user guides available in the help section of the application.

Contributing Contributions are welcome! Please read the CONTRIBUTING.md file for more information on how to get involved.

License This project is licensed under the MIT License - see the LICENSE file for details.

Feel free to modify this template according to your specific project requirements. If you need additional sections or details, let me know!
