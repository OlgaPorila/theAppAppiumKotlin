### Automated Mobile App Testing Using Kotlin and Appium

This repository contains automated test scripts for the mobile application "theApp," developed
using Kotlin and the Appium framework. These tests are executed and managed within the IntelliJ
IDEA (or Android Studio) development environment, leveraging Gradle for application build
automation.

### Environment Configuration

Proper setup of your development environment is crucial for executing the automated tests. Follow
these detailed steps to configure your macOS system:

1. **Install Development Tools:**
    - Ensure that IntelliJ IDEA or Android Studio is installed on your system. These IDEs are
      instrumental for developing and testing your application.

2. **Set Up Appium:**
    - Install Appium, which is essential for running automated mobile app tests. Ensure it is
      configured correctly to interact with your development environment.

3. **Configure Java:**
    - Verify that Java is installed and configured properly on your machine. This includes setting
      up environment variables such as `JAVA_HOME`.

4. **Configure ANDROID SDK:**
    - Verify that ANDROID SDK is installed and configured properly on your machine. This includes
      setting up environment variables such as `ANDROID_SDK`.

5. **Prepare the Android Emulator or Device:**
    - Set up an Android emulator or connect a physical device to your system to run the tests.
      Ensure that the device settings are optimized for testing.

By following these steps, you will create a robust environment for running automated tests on macOS,
facilitating efficient development and testing workflows.

### System Requirements and Installation Instructions

1. **Java Installation:**
    - Ensure that [Java](https://www.oracle.com/ca-en/java/technologies/downloads/)  (version 11 ) is installed on your
      system. Verify that the environment variables (such
      as `JAVA_HOME`) are configured correctly to reflect the installation path of Java.

2. **Development Environment:**
    - Install either [IntelliJ IDEA](https://www.jetbrains.com/idea/)
      or [Android Studio 2023](https://developer.android.com/studio). These IDEs are essential for
      code development, testing, and for running your applications on an Android emulator or a
      physical device.

3. **Appium Installation:**
    - Install and configure [Appium](https://appium.io/docs/en/2.2/quickstart/install/) (version 2) for mobile
      application testing. Ensure it is properly set up to interact with your
      development environment.

4. **Appium Inspector:**
    - Install and set up
      the [Appium Inspector](https://appium.github.io/appium-inspector/latest/quickstart/installation/).
      This tool is crucial for examining and locating elements within your mobile applications,
      facilitating easier test script creation.
5. **ANDROID SDK :**
    - Install and set up
      the [Android SDK](https://developer.android.com/about/versions/14/setup-sdk).

### Before executing the Tests

1. **Clone the Repository:**
    - Clone the repository to your local machine to get started with the project.

2. **Open the Project:**
    - Open the cloned project in IntelliJ IDEA to access the source files and project settings.

3. **Install Dependencies:**
    - Install all necessary Gradle dependencies by refreshing the Gradle project or using the
      command `./gradlew build` in the terminal within IntelliJ IDEA.

4. **Start Appium:**
    - Launch Appium to manage the server for your mobile testing. Open your macOS terminal and enter
      the command `appium` to start the Appium server.

5. **Configure Android Device:**
    - Add a new device using the Android Studio Device Manager. It is recommended to use a real
      device for improved performance and more accurate test results.

### Executing the Tests

Make sure Appium is running and your emulator or device is correctly configured before starting the
test execution. Follow these steps to run the tests:

1. **Locate the Test File:**
    - In IntelliJ IDEA, navigate to `LeaguesTest.kt`.

2. **Initiate the Test:**
    - Right-click on the test file and select "Run" to begin the testing process.

3. **View Test Results:**
    - Monitor the test outcomes in the IntelliJ console as the tests are carried out on your
      emulator or device.

4. **Alternative Testing Method:**
    - Alternatively, you can execute the tests by running the command `./gradlew test` directly from
      the terminal within IntelliJ or from your macOS terminal.

### Automated Testing Workflow

Follow these steps to automate navigation and verification tests for a league, team, or player page
within your application:

1. **Open a Page:**
    - Navigate to a specific league, team, or player page. Utilize a data-driven or parameterized
      approach to enhance the test's flexibility and reusability.

2. **Page Verification:**
    - Confirm that the page has opened correctly and that the content displayed matches the expected
      league, team, or player details.

3. **Navigate to a Sub-Tab:**
    - Select a sub-tab of your choice, such as the league table, standings, leaders, or stats tab
      relevant to the selected league, team, or player.

4. **Tab Verification:**
    - Ensure you are on the correct tab and that the data displayed is accurate and corresponds to
      the details from step 1.

5. **Back Navigation Verification:**
    - Verify that the back navigation function works correctly, returning you to the previously
      viewed page without errors.

These steps provide a structured approach to testing user navigation and data integrity within the
app, ensuring a consistent and error-free user experience.

## Setup local ANDROID_SDK or JAVA_HOME path

If you're using macOS and the file `.bashrc` doesn't exist, you might be using a different shell
where the configuration file is different. Many macOS systems now use `zsh` as the default shell
instead of `bash`, so the configuration file would be `.zshrc` instead.

Here's how you can set up your `ANDROID_SDK_ROOT` or `JAVA_HOME` environment variable for `zsh`:

1. **Open Terminal**.

2. **Check if `.zshrc` exists**:
    - You can check by running `ls -a ~` and looking for `.zshrc` in the output.

3. **Create or Edit `.zshrc`**:
    - If `.zshrc` exists, open it with a text editor, for example, you can use `nano`:
      ```bash
      nano ~/.zshrc
      ```
    - If `.zshrc` does not exist, you can create it by typing `touch ~/.zshrc` and then open it
      with `nano ~/.zshrc`.

4. **Add the Environment Variable**:
    - In the `.zshrc` file, add the following line:
      ```bash
      export ANDROID_SDK_ROOT=/path/to/your/android/sdk
      export JAVA_HOME=/path/to/your/java/bin
      ```
      Replace `/path/to/your/android/sdk` with the actual path to your Android SDK.
      Replace `/path/to/your/java/bin` with the actual path to your Java.

5. **Save and Exit**:
    - If using `nano`, press `Ctrl+O` to save and `Ctrl+X` to exit.

6. **Apply the Changes**:
    - Refresh your shell settings by running:
      ```bash
      source ~/.zshrc
      ```

7. **Verify the Setup**:
    - To ensure the environment variable is set correctly, you can check by running:
      ```bash
      echo $ANDROID_SDK_ROOT
      echo $JAVA_HOME
      ```
    - This should output the path you set.

Now that you've set up both `ANDROID_SDK_ROOT` and `JAVA_HOME` environment variable, try running
your Appium tasks
again. This setup should correct the issue you were facing with Appium not being able to locate the
Android SDK.
